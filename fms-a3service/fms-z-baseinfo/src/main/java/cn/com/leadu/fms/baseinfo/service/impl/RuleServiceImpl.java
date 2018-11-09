package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.common.constant.BaseInfoRabbitMqQueues;
import cn.com.leadu.fms.baseinfo.service.RuleConditionService;
import cn.com.leadu.fms.baseinfo.service.RuleConsequenceService;
import cn.com.leadu.fms.baseinfo.service.RuleService;
import cn.com.leadu.fms.baseinfo.validator.rule.vo.*;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionModifyVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionSaveVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceModifyVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceSaveVo;
import cn.com.leadu.fms.business.service.RabbitService;
import cn.com.leadu.fms.business.service.RedisService;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.enums.CommonRuleDatasRedisKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.RuleRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleConsequence;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleCondConseqVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleDetailVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qiaomengnan
 * @ClassName: RuleService
 * @Description: 规则引擎业务实现层
 * @date 2018-05-17
 */
@Service
public class RuleServiceImpl implements RuleService {

    /**
     * @Fields  : 规则引擎repository
     */
    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private RuleConditionService ruleConditionService;

    @Autowired
    private RuleConsequenceService ruleConsequenceService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RabbitService rabbitService;

    private static final String RULE_CONDITION_TABLE_NAME = "ruleCondition_";

    private static final String RULE_CONSEQUENCE_TABLE_NAME = "ruleConsequence_";

    /**
     * @Title:
     * @Description: 分页查询规则引擎
     * @param ruleVo
     * @return PageInfoExtend<Rule>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:27
     */
    public PageInfoExtend<Rule> findRulesByPage(RuleVo ruleVo){
        Example example = SqlUtil.newExample(Rule.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<Rule> pageInfo = ruleRepository.selectListByExamplePage(example,ruleVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存规则引擎
     * @param ruleSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:27
     */
    @Transactional
    public void saveRule(RuleSaveVo ruleSaveVo){
        Rule rule = ruleSaveVo.getEntity();
        rule.setRuleId(UUIDUtils.getUUID());
        List<RuleDetailSaveVo> ruleDetailVoList = ruleSaveVo.getRuleDetailVos();
        //用于最终要保存的条件
        List<RuleCondition> ruleConditions = new ArrayList<>();
        //用于最终要保存的结果
        List<RuleConsequence> ruleConsequences = new ArrayList<>();
        //赋值
        for(int k = 0; k< ruleDetailVoList.size() ; k ++ ){
            RuleDetailSaveVo ruleDetailVo = ruleDetailVoList.get(k);
            //将条件赋值
            for(int i = 0 ;i < ruleDetailVo.getRuleConditionTableData().size() ; i ++ ){
                RuleConditionSaveVo ruleConditionVo = ruleDetailVo.getRuleConditionTableData().get(i);
                ruleConditionVo.setRuleId(rule.getRuleId());
                ruleConditionVo.setOrderNo(i);
                ruleConditionVo.setRuleNo(k);
                ruleConditions.add(ruleConditionVo.getEntity());
            }
            //将结果赋值
            for(int i =0 ;i < ruleDetailVo.getRuleConsequenceTableData().size() ; i++){
                RuleConsequenceSaveVo ruleConsequenceVo = ruleDetailVo.getRuleConsequenceTableData().get(i);
                ruleConsequenceVo.setRuleId(rule.getRuleId());
                ruleConsequenceVo.setOrderNo(i);
                ruleConsequenceVo.setRuleNo(k);
                ruleConsequenceVo.setPriority(ruleDetailVo.getPriority());
                ruleConsequences.add(ruleConsequenceVo.getEntity());
            }
        }
        ruleRepository.insertData(rule);
        ruleConditionService.saveRuleConditions(ruleConditions);
        ruleConsequenceService.saveRuleConsequences(ruleConsequences);
        rabbitService.convertAndSend(BaseInfoRabbitMqQueues.BASE_INFO_RULE_SAVE_REDIS,null);
    }

    /**
     * @Title:
     * @Description: 修改规则引擎
     * @param ruleModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:27
     */
    @Transactional
    public void modifyRule(RuleModifyVo ruleModifyVo){
        Rule rule = ruleModifyVo.getEntity();
        List<RuleDetailModifyVo> ruleDetailVoList = ruleModifyVo.getRuleDetailVos();
        //用于最终要更新的条件
        List<RuleCondition> modifyRuleConditions = new ArrayList<>();
        //用于最终要更新的结果
        List<RuleConsequence> modifyRuleConsequences = new ArrayList<>();
        //用于最终要保存的条件
        List<RuleCondition> saveRuleConditions = new ArrayList<>();
        //用于最终要保存的结果
        List<RuleConsequence> saveRuleConsequences = new ArrayList<>();
        //赋值
        for(int k = 0; k< ruleDetailVoList.size() ; k ++ ){
            RuleDetailModifyVo ruleDetailVo = ruleDetailVoList.get(k);
            //将条件赋值
            for(int i = 0 ;i < ruleDetailVo.getRuleConditionTableData().size() ; i ++ ){
                RuleConditionModifyVo ruleConditionVo = ruleDetailVo.getRuleConditionTableData().get(i);
                ruleConditionVo.setRuleId(rule.getRuleId());
                ruleConditionVo.setOrderNo(i);
                ruleConditionVo.setRuleNo(k);
                if(StringUtils.isNotTrimBlank(ruleConditionVo.getRuleCondId()) && ruleConditionVo.getRuleCondId().length() >= 32)
                    modifyRuleConditions.add(ruleConditionVo.getEntity());
                else {
                    ruleConditionVo.setRuleCondId(null);
                    saveRuleConditions.add(ruleConditionVo.getEntity());
                }
            }
            //将结果赋值
            for(int i =0 ;i < ruleDetailVo.getRuleConsequenceTableData().size() ; i++){
                RuleConsequenceModifyVo ruleConsequenceVo = ruleDetailVo.getRuleConsequenceTableData().get(i);
                ruleConsequenceVo.setRuleId(rule.getRuleId());
                ruleConsequenceVo.setOrderNo(i);
                ruleConsequenceVo.setRuleNo(k);
                ruleConsequenceVo.setPriority(ruleDetailVo.getPriority());
                if(StringUtils.isNotTrimBlank(ruleConsequenceVo.getRuleConseqId()) && ruleConsequenceVo.getRuleConseqId().length() >= 32)
                    modifyRuleConsequences.add(ruleConsequenceVo.getEntity());
                else {
                    ruleConsequenceVo.setRuleConseqId(null);
                    saveRuleConsequences.add(ruleConsequenceVo.getEntity());
                }
            }
        }
        //先删除已经被踢出的条件和结果，再进行更新和添加
        List<String> delRuleConditionIds = modifyRuleConditions.stream().map(RuleCondition::getRuleCondId).collect(Collectors.toList());
        ruleConditionService.deleteRuleConditions(rule.getRuleId(),delRuleConditionIds);
        List<String> delRuleConsequenceIds = modifyRuleConsequences.stream().map(RuleConsequence::getRuleConseqId).collect(Collectors.toList());
        ruleConsequenceService.deleteRuleConsequences(rule.getRuleId(),delRuleConsequenceIds);
        ruleConditionService.modifyRuleConditions(modifyRuleConditions);
        ruleConditionService.saveRuleConditions(saveRuleConditions);
        ruleConsequenceService.modifyRuleConsequences(modifyRuleConsequences);
        ruleConsequenceService.saveRuleConsequences(saveRuleConsequences);
        ruleRepository.updateByPrimaryKeySelectiveData(rule);
        rabbitService.convertAndSend(BaseInfoRabbitMqQueues.BASE_INFO_RULE_SAVE_REDIS,null);
    }

    /**
     * @Title:
     * @Description:  通过ruleId删除规则引擎
     * @param ruleDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:27
     */
    public void deleteRule(RuleDeleteVo ruleDeleteVo){
        ruleRepository.deleteData(ruleDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleId集合删除规则引擎
     * @param ruleDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:27
     */
    @Transactional
    public void deleteRulesByRuleIds(RuleDeleteListVo ruleDeleteListVo){
        ruleRepository.deleteDataList(ruleDeleteListVo.getRuleIds(),ruleDeleteListVo.getEntity());
        ruleConditionService.deleteRuleConditions(ruleDeleteListVo.getRuleIds());
        ruleConsequenceService.deleteRuleConsequences(ruleDeleteListVo.getRuleIds());
        rabbitService.convertAndSend(BaseInfoRabbitMqQueues.BASE_INFO_RULE_SAVE_REDIS,null);
    }

    /**
     * @Title:
     * @Description:  根据ruleId获取规则引擎
     * @param ruleId
     * @return Rule
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:27
     */
    public Rule findRuleByRuleId(String ruleId){
        return ruleRepository.selectByPrimaryKey(ruleId);
    }


    /**
     * @Title:
     * @Description:   查询规则引擎详情
     * @param ruleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 11:26:36
     */
    public RuleVo findRuleVoByRuleId(String ruleId){
        Rule rule = ruleRepository.selectByPrimaryKey(ruleId);
        if(rule != null){
            RuleVo ruleVo = EntityUtils.getEntity(rule,new RuleVo());
            //查询条件
            List<RuleConditionVo> ruleConditionVos = ruleConditionService.findRuleConditionVosByRuleId(ruleId);
            //查询结果
            List<RuleConsequenceVo> ruleConsequenceVos = ruleConsequenceService.findRuleConsequenceVosByRuleId(ruleId);
            //组装数据
            Map<Integer,RuleDetailVo> ruleDetailVoMap = new LinkedHashMap<>();

            if(ruleConditionVos.size() >= ruleConsequenceVos.size()){
                for(RuleConditionVo ruleConditionVo : ruleConditionVos){
                    RuleDetailVo ruleDetailVo =  getRuleDetailVo(ruleDetailVoMap,ruleConditionVo.getRuleNo());
                    ruleDetailVo.getRuleConditionTableData().add(ruleConditionVo);
                }

                for(RuleConsequenceVo ruleConsequenceVo : ruleConsequenceVos){
                    RuleDetailVo ruleDetailVo = getRuleDetailVo(ruleDetailVoMap,ruleConsequenceVo.getRuleNo());
                    if(ruleDetailVo.getPriority() == null)
                        ruleDetailVo.setPriority(ruleConsequenceVo.getPriority());
                    ruleDetailVo.getRuleConsequenceTableData().add(ruleConsequenceVo);
                }

            }else if(ruleConditionVos.size() < ruleConsequenceVos.size()){

                for(RuleConsequenceVo ruleConsequenceVo : ruleConsequenceVos){
                    RuleDetailVo ruleDetailVo = getRuleDetailVo(ruleDetailVoMap,ruleConsequenceVo.getRuleNo());
                    if(ruleDetailVo.getPriority() == null)
                        ruleDetailVo.setPriority(ruleConsequenceVo.getPriority());
                    ruleDetailVo.getRuleConsequenceTableData().add(ruleConsequenceVo);
                }

                for(RuleConditionVo ruleConditionVo : ruleConditionVos){
                    RuleDetailVo ruleDetailVo =  getRuleDetailVo(ruleDetailVoMap,ruleConditionVo.getRuleNo());
                    ruleDetailVo.getRuleConditionTableData().add(ruleConditionVo);
                }

            }else{
                throw new FmsServiceException("查询规则数据失败");
            }
            ruleVo.setRuleDetailVos(new ArrayList<RuleDetailVo>(ruleDetailVoMap.values()));
            return ruleVo;
        }
        return null;
    }



    private RuleDetailVo getRuleDetailVo(Map<Integer,RuleDetailVo> ruleDetailVoMap,Integer ruleNo){
        RuleDetailVo ruleDetailVo = ruleDetailVoMap.get(ruleNo);
        if(ruleDetailVo == null){
            ruleDetailVo = new RuleDetailVo();
            ruleDetailVo.setIndex(ruleDetailVoMap.size());
            ruleDetailVo.setRuleConditionTableData(new ArrayList<>());
            ruleDetailVo.setRuleConsequenceTableData(new ArrayList<>());
            ruleDetailVo.setRuleConditionTableName(RULE_CONDITION_TABLE_NAME + ruleDetailVo.getIndex());
            ruleDetailVo.setRuleConsequenceTableName(RULE_CONSEQUENCE_TABLE_NAME + ruleDetailVo.getIndex());
            ruleDetailVoMap.put(ruleNo,ruleDetailVo);
        }
        return ruleDetailVo;
    }


    private List<RuleConsequenceVo> getRuleConsequenceVos(String ruleNo,List<RuleConsequenceVo> ruleConsequenceVos){
        List<RuleConsequenceVo> ruleNoDatas = new ArrayList<>();
        for(RuleConsequenceVo ruleConsequenceVo : ruleConsequenceVos){
            if(ruleNo.equals(ruleConsequenceVo.getRuleNo())){
                ruleNoDatas.add(ruleConsequenceVo);
            }
        }
        return ruleNoDatas;
    }

    /**
     * @Title:
     * @Description:   初始化规则引擎到redis中
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/22 11:29:42
     */
    public void initRule(){
        //查出所有规则
        RuleVo ruleVo = new RuleVo();
        ruleVo.setRuleCodeType(CommonCodeTypeConstants.RULE_TYPE);
        List<RuleVo> ruleVos = ruleRepository.selectRuleVos(ruleVo);

        //查出所有规则条件
        List<RuleConditionVo> ruleConditionVos = ruleConditionService.findRuleConditionVos();
        //将规则条件转成Map, String -> List形式
        Map<String,List<RuleConditionVo>> ruleConditionVosMap = new HashMap<>();
        for(RuleConditionVo ruleConditionVo : ruleConditionVos){
            List<RuleConditionVo> tmps = ruleConditionVosMap.get(ruleConditionVo.getRuleId());
            if(tmps == null){
                tmps = new ArrayList<>();
                ruleConditionVosMap.put(ruleConditionVo.getRuleId(),tmps);
            }
            tmps.add(ruleConditionVo);
        }

        //查出所有规则结果
        List<RuleConsequenceVo> ruleConsequenceVos = ruleConsequenceService.findRuleConsequenceVos();
        //将规则结果转换成Map,String -> List形式
        Map<String,List<RuleConsequenceVo>> ruleConsequenceVosMap = new LinkedHashMap<>();
        for(RuleConsequenceVo ruleConsequenceVo : ruleConsequenceVos){
            List<RuleConsequenceVo> tmps = ruleConsequenceVosMap.get(ruleConsequenceVo.getRuleId());
            if(tmps == null){
                tmps = new ArrayList<>();
                ruleConsequenceVosMap.put(ruleConsequenceVo.getRuleId(),tmps);
            }
            tmps.add(ruleConsequenceVo);
        }

        Map<String,RuleVo> ruleVoMap = new HashMap<>();

        //拿到各自规则下方的条件和结果,并进行组装
        for(RuleVo ruleVoTmp : ruleVos){
            List<RuleConditionVo> ruleConditionVos1 = ruleConditionVosMap.get(ruleVoTmp.getRuleId());
            List<RuleConsequenceVo> ruleConsequenceVos1 = ruleConsequenceVosMap.get(ruleVoTmp.getRuleId());
            setRuleDetailVos(ruleVoTmp,ruleConditionVos1,ruleConsequenceVos1);
            String key = ruleVoTmp.getRuleType() + StringUtils.LINE + ruleVoTmp.getRuleKey();
            ruleVoMap.put(key,ruleVoTmp);
            redisService.save(CommonRuleDatasRedisKeyEnums.FMS_COMMON_RULE_DATAS_TREE.getPrefix() + key,ruleVoTmp);
        }
        redisService.save(CommonRuleDatasRedisKeyEnums.FMS_COMMON_RULE_DATAS_MAP.getPrefix(),ruleVoMap);
    }


    private void setRuleDetailVos(RuleVo ruleVoTmp,List<RuleConditionVo> ruleConditionVos1,List<RuleConsequenceVo> ruleConsequenceVos1){
        //通过ruleNo组装
        Map<Integer,RuleDetailVo> ruleDetailVoMap = new HashMap<>();

        //组装各自规则下方的条件和结果
        if(ruleConditionVos1.size() >=  ruleConsequenceVos1.size() ){

            for(RuleConditionVo ruleConditionVo : ruleConditionVos1){
                RuleDetailVo ruleDetailVo = getRuleDetailVo(ruleDetailVoMap,ruleConditionVo);
                ruleDetailVo.getRuleConditionTableData().add(ruleConditionVo);

            }

            for(RuleConsequenceVo ruleConsequenceVo : ruleConsequenceVos1){
                RuleDetailVo ruleDetailVo = getRuleDetailVo(ruleDetailVoMap,ruleConsequenceVo);
                if(ruleDetailVo.getPriority() == null) {
                    ruleDetailVo.setPriority(ruleConsequenceVo.getPriority());
                }
                ruleDetailVo.getRuleConsequenceTableData().add(ruleConsequenceVo);
            }

        }else if(ruleConditionVos1.size() < ruleConsequenceVos1.size()){

            for(RuleConsequenceVo ruleConsequenceVo : ruleConsequenceVos1){
                RuleDetailVo ruleDetailVo = getRuleDetailVo(ruleDetailVoMap,ruleConsequenceVo);
                if(ruleDetailVo.getPriority() == null) {
                    ruleDetailVo.setPriority(ruleConsequenceVo.getPriority());
                }
                ruleDetailVo.getRuleConsequenceTableData().add(ruleConsequenceVo);
            }

            for(RuleConditionVo ruleConditionVo : ruleConditionVos1){
                RuleDetailVo ruleDetailVo = getRuleDetailVo(ruleDetailVoMap,ruleConditionVo);
                ruleDetailVo.getRuleConditionTableData().add(ruleConditionVo);
            }

        }
        ruleVoTmp.setRuleDetailVos(new ArrayList<>(ruleDetailVoMap.values()));
    }

    /**
     * @Title:
     * @Description: 根据ruleType ruleKey查询一条完整的规则数据
     * @param ruleType
     * @param ruleKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/24 11:12:31
     */
    public RuleVo findRuleVo(String ruleType,String ruleKey){
        Object result = redisService.get(CommonRuleDatasRedisKeyEnums.FMS_COMMON_RULE_DATAS_TREE + ruleType + StringUtils.LINE + ruleKey);
        if(result == null) {
            RuleVo ruleVo = new RuleVo();
            ruleVo.setRuleType(ruleType);
            ruleVo.setRuleKey(ruleKey);
            ruleVo = ruleRepository.selectRuleVo(ruleVo);
            if (ruleVo != null) {
                List<RuleConditionVo> ruleConditionVos = ruleConditionService.findRuleConditionVos(ruleVo.getRuleId());
                List<RuleConsequenceVo> ruleConsequenceVos = ruleConsequenceService.findRuleConsequenceVos(ruleVo.getRuleId());
                setRuleDetailVos(ruleVo, ruleConditionVos, ruleConsequenceVos);
                String key = ruleVo.getRuleType() + StringUtils.LINE + ruleVo.getRuleKey();
                redisService.save(CommonRuleDatasRedisKeyEnums.FMS_COMMON_RULE_DATAS_TREE.getPrefix() + key, ruleVo);
            }
            //redis中没有,重新刷新缓存
            rabbitService.convertAndSend(BaseInfoRabbitMqQueues.BASE_INFO_RULE_SAVE_REDIS,null);
            return ruleVo;
        }else{
            return (RuleVo)result;
        }
    }

    private RuleDetailVo getRuleDetailVo(Map<Integer,RuleDetailVo> ruleDetailVoMap,RuleConditionVo ruleConditionVo){
        RuleDetailVo ruleDetailVo = ruleDetailVoMap.get(ruleConditionVo.getRuleNo());
        if(ruleDetailVo == null) {
            ruleDetailVo = new RuleDetailVo();
            ruleDetailVo.setRuleConsequenceTableData(new ArrayList<>());
            ruleDetailVo.setRuleConditionTableData(new ArrayList<>());
            ruleDetailVo.setIndex(ruleConditionVo.getRuleNo());
            ruleDetailVoMap.put(ruleConditionVo.getRuleNo(),ruleDetailVo);
        }
        return ruleDetailVo;
    }

    private RuleDetailVo getRuleDetailVo(Map<Integer,RuleDetailVo> ruleDetailVoMap,RuleConsequenceVo ruleConsequenceVo){
        RuleDetailVo ruleDetailVo = ruleDetailVoMap.get(ruleConsequenceVo.getRuleNo());
        if(ruleDetailVo == null) {
            ruleDetailVo = new RuleDetailVo();
            ruleDetailVo.setRuleConsequenceTableData(new ArrayList<>());
            ruleDetailVo.setRuleConditionTableData(new ArrayList<>());
            ruleDetailVo.setIndex(ruleConsequenceVo.getRuleNo());
            ruleDetailVo.setPriority(ruleConsequenceVo.getPriority());
            ruleDetailVoMap.put(ruleConsequenceVo.getRuleNo(),ruleDetailVo);
        }
        return ruleDetailVo;
    }

}
