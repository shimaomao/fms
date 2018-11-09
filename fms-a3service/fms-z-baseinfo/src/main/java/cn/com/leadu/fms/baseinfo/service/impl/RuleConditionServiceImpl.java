package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.RuleConditionService;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleItemTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.baseinfo.repository.RuleConditionRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionSaveVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionModifyVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionService
 * @Description: 规则引擎条件业务实现层
 * @date 2018-05-17
 */
@Service
public class RuleConditionServiceImpl implements RuleConditionService {

    /**
     * @Fields  : 规则引擎条件repository
     */
    @Autowired
    private RuleConditionRepository ruleConditionRepository;

    /**
     * @Title:
     * @Description: 分页查询规则引擎条件
     * @param ruleConditionVo
     * @return PageInfoExtend<RuleCondition>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:15
     */
    public PageInfoExtend<RuleCondition> findRuleConditionsByPage(RuleConditionVo ruleConditionVo){
        Example example = SqlUtil.newExample(RuleCondition.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RuleCondition> pageInfo = ruleConditionRepository.selectListByExamplePage(example,ruleConditionVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存规则引擎条件
     * @param ruleConditionSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:15
     */
    public void saveRuleCondition(RuleConditionSaveVo ruleConditionSaveVo){
        ruleConditionRepository.insertData(ruleConditionSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改规则引擎条件
     * @param ruleConditionModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:15
     */
    public void modifyRuleCondition(RuleConditionModifyVo ruleConditionModifyVo){
        ruleConditionRepository.updateByPrimaryKeySelectiveData(ruleConditionModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleCondId删除规则引擎条件
     * @param ruleConditionDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:15
     */
    public void deleteRuleCondition(RuleConditionDeleteVo ruleConditionDeleteVo){
        ruleConditionRepository.deleteData(ruleConditionDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleCondId集合删除规则引擎条件
     * @param ruleConditionDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:15
     */
    public void deleteRuleConditionsByRuleCondIds(RuleConditionDeleteListVo ruleConditionDeleteListVo){
        ruleConditionRepository.deleteDataList(ruleConditionDeleteListVo.getRuleCondIds(),ruleConditionDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据ruleCondId获取规则引擎条件
     * @param ruleCondId
     * @return RuleCondition
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:15
     */
    public RuleCondition findRuleConditionByRuleCondId(String ruleCondId){
        return ruleConditionRepository.selectByPrimaryKey(ruleCondId);
    }

    /**
     * @Title:
     * @Description:   批量保存条件
     * @param ruleConditions
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/18 05:30:21
     */
    public void saveRuleConditions(List<RuleCondition> ruleConditions){
        ruleConditionRepository.insertDataList(ruleConditions);
    }

    /**
     * @Title:
     * @Description:   根据规则id查找条件，并根据规则顺序和条件顺序进行排序
     * @param ruleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 10:35:29
     */
    public List<RuleConditionVo> findRuleConditionVosByRuleId(String ruleId){
        if(StringUtils.isNotTrimBlank(ruleId)) {
            RuleConditionVo ruleConditionVo = new RuleConditionVo();
            ruleConditionVo.setRuleId(ruleId);
            ruleConditionVo.setRuleItemType(RuleItemTypeEnums.CONDITION.getType());
            ruleConditionVo.setCondLogicTypeKey(CommonCodeTypeConstants.LOGIC_TYPE);
            return ruleConditionRepository.selectRuleConditionVosByRuleId(ruleConditionVo);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   查找条件，并根据规则顺序和条件顺序进行排序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 10:35:29
     */
    public List<RuleConditionVo> findRuleConditionVos(){
        RuleConditionVo ruleConditionVo = new RuleConditionVo();
        ruleConditionVo.setRuleItemType(RuleItemTypeEnums.CONDITION.getType());
        ruleConditionVo.setCondLogicTypeKey(CommonCodeTypeConstants.LOGIC_TYPE);
        return ruleConditionRepository.selectRuleConditionVos(ruleConditionVo);
    }

    /**
     * @Title:
     * @Description:   根据ruleId查找条件，并根据规则顺序和条件顺序进行排序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 10:35:29
     */
    public List<RuleConditionVo> findRuleConditionVos(String ruleId){
        RuleConditionVo ruleConditionVo = new RuleConditionVo();
        ruleConditionVo.setRuleItemType(RuleItemTypeEnums.CONDITION.getType());
        ruleConditionVo.setCondLogicTypeKey(CommonCodeTypeConstants.LOGIC_TYPE);
        ruleConditionVo.setRuleId(ruleId);
        return ruleConditionRepository.selectRuleConditionVos(ruleConditionVo);
    }

    /**
     * @Title:
     * @Description: 批量更新条件
     * @param ruleConditions
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 04:58:23
     */
    public void modifyRuleConditions(List<RuleCondition> ruleConditions){
        ruleConditionRepository.updateByPrimaryKeySelectiveDataList(ruleConditions);
    }

    /**
     * @Title:
     * @Description:   根据规则id和已知的条件id，删除该规则id下不在已经条件id中的数据
     * @param ruleId
     * @param ruleCondIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 05:06:00
     */
    public void deleteRuleConditions(String ruleId,List<String> ruleCondIds){
        Example example = SqlUtil.newExample(RuleCondition.class);
        example.createCriteria().andEqualTo("ruleId",ruleId)
                .andNotIn("ruleCondId",ruleCondIds);
        ruleConditionRepository.deleteExampleData(example,new RuleCondition());
    }

    /**
     * @Title:
     * @Description:   根据规则id删除下面的条件
     * @param ruleIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 06:28:28
     */
    public void deleteRuleConditions(List<String> ruleIds){
        Example example = SqlUtil.newExample(RuleCondition.class);
        example.createCriteria().andIn("ruleId",ruleIds);
        ruleConditionRepository.deleteExampleData(example,new RuleCondition());
    }

}
