package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleConsequence;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConsequenceDao
 * @Description: 规则引擎结果dao层
 * @date 2018-05-17
 */
public interface RuleConsequenceDao extends BaseDao<RuleConsequence> {


    /**
     * @Title:
     * @Description:   根据规则id查询规则结果列表
     * @param ruleConsequenceVo
     * @return List<RuleConsequenceVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 12:49:37
     */
    List<RuleConsequenceVo> selectRuleConsequenceVosByRuleId(@Param("ruleConsequenceVo") RuleConsequenceVo ruleConsequenceVo);

    /**
     * @Title:
     * @Description:   查询规则结果列表
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 12:41:42
     */
    List<RuleConsequenceVo> selectRuleConsequenceVos(@Param("ruleConsequenceVo") RuleConsequenceVo ruleConsequenceVo);


}