package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.rpc.baseinfo.RuleRpc;
import cn.com.leadu.fms.business.service.CommonRuleService;
import cn.com.leadu.fms.business.service.RabbitService;
import cn.com.leadu.fms.business.service.RedisService;
import cn.com.leadu.fms.common.constant.enums.CommonRuleDatasRedisKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.LogicTypeUtils;
import cn.com.leadu.fms.common.util.ReflectUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleCondConseqVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleDetailVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CommonRuleServiceImpl
 * @Description: 通用规则引擎service层类
 * @date 2018/5/21
 */
@Service
public class CommonRuleServiceImpl implements CommonRuleService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RuleRpc ruleRpc;

    public <T> T get(T data,String ruleType,String ruleKey){
        //先从redis中取，如果redis中没有,远程rpc去取
        Object result = redisService.get(CommonRuleDatasRedisKeyEnums.FMS_COMMON_RULE_DATAS_TREE.getPrefix() + ruleType + StringUtils.LINE + ruleKey);
        RuleVo ruleVo = null;
        if(result != null){
            ruleVo = (RuleVo)result;
        }

        if(ruleVo == null){
            //远程取出规则数据
            try {
                ruleVo = ResponseEntityUtils.getRestResponseData(ruleRpc.findRuleVo(ruleType,ruleKey));
                if(ruleVo == null)
                    throw new FmsServiceException("规则数据不存在");
                else{
                    //
                }
            } catch (FmsRpcException e) {
                e.printStackTrace();
                throw new FmsServiceException("获取规则数据失败");
            }
        }

        //排列优先级
        List<RuleDetailVo> ruleDetailVos = ruleVo.getRuleDetailVos();
        if(ArrayUtils.isNotNullAndLengthNotZero(ruleDetailVos)){
            Collections.sort(ruleDetailVos, new Comparator<RuleDetailVo>() {
                @Override
                public int compare(RuleDetailVo o1, RuleDetailVo o2) {
                    if(o1.getPriority() > o2.getPriority())
                        return 1;
                    else
                        return -1;
                }
            });

            Class clazz = data.getClass();
            Object fieldValue = null;
            //默认结果
            List<RuleConsequenceVo> defaultRuleConsequenceVos = null;
            for(RuleDetailVo ruleDetailVo : ruleDetailVos){
                //一个 RuleDetailVo 则是一个条件和对应的结果, 条件是and关系
                List<RuleConditionVo> ruleConditionVos =  ruleDetailVo.getRuleConditionTableData();
                if(ArrayUtils.isNullOrLengthZero(ruleConditionVos)){
                    defaultRuleConsequenceVos = ruleDetailVo.getRuleConsequenceTableData();
                    continue;
                }
                boolean res = true;
                String condLogicTypeName = null;
                for(RuleConditionVo ruleConditionVo : ruleConditionVos){
                    //入参字段
                    String condItemKey = ruleConditionVo.getCondItemKey();
                    Field field = null;
                    try {
                        field = ReflectUtils.getField(condItemKey,clazz);
                        Method method = ReflectUtils.getMethodGet(field,clazz);
                        fieldValue = method.invoke(data);
                        if(StringUtils.isTrimBlank(fieldValue)){ //为空直接退出本次对比
                            res = false;
                            break;
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                        throw new FmsServiceException(condItemKey + ",入参属性不存在");
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                        throw new FmsServiceException(field.getName() + ",get方法不存在");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new FmsServiceException(field.getName() + ",方法执行失败");
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        throw new FmsServiceException(field.getName() + ",方法执行失败");
                    }
                    //逻辑运算符
                    condLogicTypeName = ruleConditionVo.getCondLogicTypeName();
                    //对比值
                    String condLogicValue1 = ruleConditionVo.getCondLogicValue1();
                    res = getResult(fieldValue,condLogicTypeName,condLogicValue1);
                    //有一个结果为false 则可以退出
                    if(!res)
                        break;;
                }
                if(res) {
                    //如果成功,则判定以此为结果,否则继续处理
                    setResult(ruleDetailVo.getRuleConsequenceTableData(),clazz,fieldValue,data);
                    return data;
                }
            }
            //走到此步骤,说明需要默认结果
            if(ArrayUtils.isNotNullAndLengthNotZero(defaultRuleConsequenceVos)){
                setResult(defaultRuleConsequenceVos,clazz,null,data);
                return data;
            }
        }
        throw new FmsServiceException("未计算出结果");
    }

    private void setResult(List<RuleConsequenceVo> ruleConsequenceVos,Class clazz,Object fieldValue,Object data){
        //如果成功,则判定以此为结果,否则继续处理
        for(RuleConsequenceVo ruleConsequenceVo : ruleConsequenceVos) {
            //if(ruleConsequenceVo.getConseqLogicTypeName().equals(condLogicTypeName)){
            Field field = null;
            try {
                field = ReflectUtils.getField(ruleConsequenceVo.getConseqItemKey(), clazz);
                try {
                    Method method = ReflectUtils.getMethodSet(field, clazz);
                    //判断是否有形参需要替换
                    if (ruleConsequenceVo.getConseqLogicValue1().startsWith("$") && fieldValue != null) {
                        ruleConsequenceVo.setConseqLogicValue1(
                                fieldValue +
                                        ruleConsequenceVo.getConseqLogicValue1().substring(ruleConsequenceVo.getConseqLogicValue1().lastIndexOf("}") + 1)
                        );
                    }
                    method.invoke(data, getValue(field, ruleConsequenceVo.getConseqLogicValue1()));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new FmsServiceException(field.getName() + ",set方法不存在");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new FmsServiceException(field.getName() + ",set赋值失败");
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    throw new FmsServiceException(field.getName() + ",set赋值失败");
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                throw new FmsServiceException(ruleConsequenceVo.getConseqItemKey() + ",入参属性不存在");
            }
        }
            //}
    }

    private boolean getResult(Object fieldValue,String condLogicTypeName,String condLogicValue1){
        if(StringUtils.isTrimBlank(fieldValue))
            throw new FmsServiceException("对比值不能为空");
        if(StringUtils.isTrimBlank(condLogicValue1))
            throw new FmsServiceException("运算对比值不能为空");
        //可用于 > 、 < 、 >= 、 <= 、 = 对比的类型  Integer Double Float BigDecimal
        //String 用于 =
        if(LogicTypeUtils.GREATER_THAN.equals(condLogicTypeName)){ //大于
            return getGreaterThanResult(fieldValue, condLogicValue1);
        } else if(LogicTypeUtils.LESS_THAN.equals(condLogicTypeName)){
            return getLessThanResult(fieldValue,condLogicValue1);
        } else if(LogicTypeUtils.EQUAL.equals(condLogicTypeName)){
            return getEqualResult(fieldValue,condLogicValue1);
        } else if(LogicTypeUtils.GREATER_THAN_EQUAL.equals(condLogicTypeName)){
            return getGreaterThanEqual(fieldValue, condLogicValue1);
        } else if(LogicTypeUtils.LESS_THAN_EQUAL.equals(condLogicTypeName)){
            return getLessThanEqual(fieldValue, condLogicValue1);
        } else if(LogicTypeUtils.IN_EQUAL.equals(condLogicTypeName))
            return getInEqual(fieldValue, condLogicValue1);
        else {
            throw new FmsServiceException(condLogicTypeName + ",逻辑运算符不存在");
        }
    }

    private boolean getGreaterThanResult(Object fieldValue,String condLogicValue1){
        if(fieldValue instanceof Integer){
            if((Integer)fieldValue > Integer.parseInt(condLogicValue1))
                return true;
        } else if(fieldValue instanceof  Double){
            if((Double)fieldValue > Double.parseDouble(condLogicValue1))
                return true;
        } else if(fieldValue instanceof Float){
            if((Float)fieldValue > Float.parseFloat(condLogicValue1))
                return true;
        } else if(fieldValue instanceof BigDecimal){
            if(((BigDecimal) fieldValue).compareTo(new BigDecimal(condLogicValue1)) == 1)
                return true;
        } else {
            throw new FmsServiceException(fieldValue.getClass() + "不适用于" + LogicTypeUtils.GREATER_THAN + "比对");
        }
        return false;
    }

    private boolean getLessThanResult(Object fieldValue,String condLogicValue1){
        if(fieldValue instanceof Integer){
            if((Integer)fieldValue < Integer.parseInt(condLogicValue1))
                return true;
        } else if(fieldValue instanceof  Double){
            if((Double)fieldValue < Double.parseDouble(condLogicValue1))
                return true;
        } else if(fieldValue instanceof Float){
            if((Float)fieldValue < Float.parseFloat(condLogicValue1))
                return true;
        } else if(fieldValue instanceof BigDecimal){
            if(((BigDecimal) fieldValue).compareTo(new BigDecimal(condLogicValue1)) == -1)
                return true;
        } else {
            throw new FmsServiceException(fieldValue.getClass() + "不适用于" + LogicTypeUtils.LESS_THAN + "比对");
        }
        return false;
    }

    private boolean getEqualResult(Object fieldValue,String condLogicValue1){
        if(fieldValue instanceof Integer){
            if(((Integer)fieldValue).equals(Integer.parseInt(condLogicValue1)) )
                return true;
        } else if(fieldValue instanceof  Double){
            if(((Double)fieldValue).equals(Double.parseDouble(condLogicValue1)))
                return true;
        } else if(fieldValue instanceof Float){
            if(((Float)fieldValue).equals(Float.parseFloat(condLogicValue1)))
                return true;
        } else if(fieldValue instanceof BigDecimal){
            if(((BigDecimal) fieldValue).compareTo(new BigDecimal(condLogicValue1)) == 0)
                return true;
        } else if(fieldValue instanceof String){
            if(fieldValue.toString().equals(condLogicValue1))
                return true;
        } else {
            throw new FmsServiceException(fieldValue.getClass() + "不适用于" + LogicTypeUtils.EQUAL + "比对");
        }
        return false;
    }

    private boolean getGreaterThanEqual(Object fieldValue,String condLogicValue1){
        if(fieldValue instanceof Integer){
            if((Integer)fieldValue >= Integer.parseInt(condLogicValue1))
                return true;
        } else if(fieldValue instanceof  Double){
            if((Double)fieldValue >= Double.parseDouble(condLogicValue1))
                return true;
        } else if(fieldValue instanceof Float){
            if((Float)fieldValue >= Float.parseFloat(condLogicValue1))
                return true;
        } else if(fieldValue instanceof BigDecimal){
            BigDecimal value = (BigDecimal) fieldValue;
            BigDecimal value2 = new BigDecimal(condLogicValue1);
            if(value.compareTo(value2) == 1 || value.compareTo(value2) == 0)
                return true;
        } else {
            throw new FmsServiceException(fieldValue.getClass() + "不适用于" + LogicTypeUtils.GREATER_THAN_EQUAL + "比对");
        }
        return false;
    }

    private boolean getLessThanEqual(Object fieldValue,String condLogicValue1){
        if(fieldValue instanceof Integer){
            if((Integer)fieldValue <= Integer.parseInt(condLogicValue1))
                return true;
        } else if(fieldValue instanceof  Double){
            if((Double)fieldValue <= Double.parseDouble(condLogicValue1))
                return true;
        } else if(fieldValue instanceof Float){
            if((Float)fieldValue <= Float.parseFloat(condLogicValue1))
                return true;
        } else if(fieldValue instanceof BigDecimal){
            BigDecimal value = (BigDecimal) fieldValue;
            BigDecimal value2 = new BigDecimal(condLogicValue1);
            if(value.compareTo(value2) == -1 || value.compareTo(value2) == 0)
                return true;
        } else {
            throw new FmsServiceException(fieldValue.getClass() + "不适用于" + LogicTypeUtils.LESS_THAN_EQUAL + "比对");
        }
        return false;
    }

    private boolean getInEqual(Object fieldValue,String condLogicValue1){
        //存值约定,以,分割
        String [] values = condLogicValue1.split(StringUtils.COMMA);
        return ArrayUtils.equalsContains(values,fieldValue.toString());
    }


    private Object getValue(Field field,String value){
        if(value == null)
            throw new FmsServiceException("值为null,不可进行类型转换");
        if(field.getType() == Integer.class){
            return Integer.valueOf(value);
        } else if(field.getType() == Double.class){
            return Double.valueOf(value);
        } else if(field.getType() == Float.class){
            return Float.valueOf(value);
        } else if(field.getType() == BigDecimal.class){
            return new BigDecimal(value);
        } else if(field.getType() == String.class){
            return value;
        } else {
            throw new FmsServiceException(field.getType() + ",类型暂不支持转换");
        }
    }

}
