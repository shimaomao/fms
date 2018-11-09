package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.RuleConsequenceService;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceModifyVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceSaveVo;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleItemTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.RuleConsequenceRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleConsequence;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConsequenceService
 * @Description: 规则引擎结果业务实现层
 * @date 2018-05-17
 */
@Service
public class RuleConsequenceServiceImpl implements RuleConsequenceService {

    /**
     * @Fields  : 规则引擎结果repository
     */
    @Autowired
    private RuleConsequenceRepository ruleConsequenceRepository;

    /**
     * @Title:
     * @Description: 分页查询规则引擎结果
     * @param ruleConsequenceVo
     * @return PageInfoExtend<RuleConsequence>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    public PageInfoExtend<RuleConsequence> findRuleConsequencesByPage(RuleConsequenceVo ruleConsequenceVo){
        Example example = SqlUtil.newExample(RuleConsequence.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RuleConsequence> pageInfo = ruleConsequenceRepository.selectListByExamplePage(example,ruleConsequenceVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存规则引擎结果
     * @param ruleConsequenceSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    public void saveRuleConsequence(RuleConsequenceSaveVo ruleConsequenceSaveVo){
        ruleConsequenceRepository.insertData(ruleConsequenceSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改规则引擎结果
     * @param ruleConsequenceModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    public void modifyRuleConsequence(RuleConsequenceModifyVo ruleConsequenceModifyVo){
        ruleConsequenceRepository.updateByPrimaryKeySelectiveData(ruleConsequenceModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleConseqId删除规则引擎结果
     * @param ruleConsequenceDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    public void deleteRuleConsequence(RuleConsequenceDeleteVo ruleConsequenceDeleteVo){
        ruleConsequenceRepository.deleteData(ruleConsequenceDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleConseqId集合删除规则引擎结果
     * @param ruleConsequenceDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    public void deleteRuleConsequencesByRuleConseqIds(RuleConsequenceDeleteListVo ruleConsequenceDeleteListVo){
        ruleConsequenceRepository.deleteDataList(ruleConsequenceDeleteListVo.getRuleConseqIds(),ruleConsequenceDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据ruleConseqId获取规则引擎结果
     * @param ruleConseqId
     * @return RuleConsequence
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    public RuleConsequence findRuleConsequenceByRuleConseqId(String ruleConseqId){
        return ruleConsequenceRepository.selectByPrimaryKey(ruleConseqId);
    }

    /**
     * @Title:
     * @Description:   批量保存结果
     * @param ruleConsequences
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/18 05:32:16
     */
    public void saveRuleConsequences(List<RuleConsequence> ruleConsequences){
        ruleConsequenceRepository.insertDataList(ruleConsequences);
    }

    /**
     * @Title:
     * @Description:   根据规则id查找结果，并根据规则顺序和结果排序进行顺序排列
     * @param ruleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 10:48:33
     */
    public List<RuleConsequenceVo> findRuleConsequenceVosByRuleId(String ruleId){
        if(StringUtils.isNotTrimBlank(ruleId)) {
            RuleConsequenceVo ruleConsequenceVo = new RuleConsequenceVo();
            ruleConsequenceVo.setRuleId(ruleId);
            ruleConsequenceVo.setRuleItemType(RuleItemTypeEnums.CONSEQUENCE.getType());
            ruleConsequenceVo.setConseqLogicTypeKey(CommonCodeTypeConstants.LOGIC_TYPE);
            return ruleConsequenceRepository.selectRuleConsequenceVosByRuleId(ruleConsequenceVo);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   查找结果，并根据规则顺序和结果排序进行顺序排列
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 10:48:33
     */
    public List<RuleConsequenceVo> findRuleConsequenceVos(){
        RuleConsequenceVo ruleConsequenceVo = new RuleConsequenceVo();
        ruleConsequenceVo.setRuleItemType(RuleItemTypeEnums.CONSEQUENCE.getType());
        ruleConsequenceVo.setConseqLogicTypeKey(CommonCodeTypeConstants.LOGIC_TYPE);
        return ruleConsequenceRepository.selectRuleConsequenceVos(ruleConsequenceVo);
    }

    /**
     * @Title:
     * @Description:   查找结果，并根据规则顺序和结果排序进行顺序排列
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 10:48:33
     */
    public List<RuleConsequenceVo> findRuleConsequenceVos(String ruleId){
        RuleConsequenceVo ruleConsequenceVo = new RuleConsequenceVo();
        ruleConsequenceVo.setRuleItemType(RuleItemTypeEnums.CONSEQUENCE.getType());
        ruleConsequenceVo.setConseqLogicTypeKey(CommonCodeTypeConstants.LOGIC_TYPE);
        ruleConsequenceVo.setRuleId(ruleId);
        return ruleConsequenceRepository.selectRuleConsequenceVos(ruleConsequenceVo);
    }

    /**
     * @Title:
     * @Description:   批量更新结果
     * @param ruleConsequences
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 04:59:23
     */
    public void modifyRuleConsequences(List<RuleConsequence> ruleConsequences){
        ruleConsequenceRepository.updateByPrimaryKeySelectiveDataList(ruleConsequences);
    }

    /**
     * @Title:
     * @Description:   根据规则id和已知的结果id，删除该规则id下不在已经结果id中的数据
     * @param ruleId
     * @param ruleConseqIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 05:06:00
     */
    public void deleteRuleConsequences(String ruleId,List<String> ruleConseqIds){
        Example example = SqlUtil.newExample(RuleConsequence.class);
        example.createCriteria().andEqualTo("ruleId",ruleId)
                .andNotIn("ruleConseqId",ruleConseqIds);
        ruleConsequenceRepository.deleteExampleData(example,new RuleConsequence());
    }

    /**
     * @Title:
     * @Description:   根据规则id删除对应的结果
     * @param ruleIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 06:29:29
     */
    public void deleteRuleConsequences(List<String> ruleIds){
        Example example = SqlUtil.newExample(RuleConsequence.class);
        example.createCriteria().andIn("ruleId",ruleIds);
        ruleConsequenceRepository.deleteExampleData(example,new RuleConsequence());
    }

}
