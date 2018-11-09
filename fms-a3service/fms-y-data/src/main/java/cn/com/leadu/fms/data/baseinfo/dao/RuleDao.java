package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleDao
 * @Description: 规则引擎dao层
 * @date 2018-05-17
 */
public interface RuleDao extends BaseDao<Rule> {

    /**
     * @Title:
     * @Description:   查询ruleVo，并根据时间倒序
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/23 12:28:09
     */
    List<RuleVo> selectRuleVos(@Param("ruleVo") RuleVo ruleVo);

    /**
     * @Title:
     * @Description:   根据条件单个查询ruleVo
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/23 12:28:09
     */
    RuleVo selectRuleVo(@Param("ruleVo") RuleVo ruleVo);


}