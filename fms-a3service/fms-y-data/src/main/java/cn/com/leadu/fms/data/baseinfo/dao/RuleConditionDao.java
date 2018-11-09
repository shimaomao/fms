package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionDao
 * @Description: 规则引擎条件dao层
 * @date 2018-05-17
 */
public interface RuleConditionDao extends BaseDao<RuleCondition> {

    /**
     * @Title:
     * @Description:   根据规则id查询规则条件列表
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 12:41:42
     */
    List<RuleConditionVo> selectRuleConditionVosByRuleId(@Param("ruleConditionVo") RuleConditionVo ruleConditionVo);


    /**
     * @Title:
     * @Description:   查询规则条件列表
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 12:41:42
     */
    List<RuleConditionVo> selectRuleConditionVos(@Param("ruleConditionVo") RuleConditionVo ruleConditionVo);

}