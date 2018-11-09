package cn.com.leadu.fms.pojo.baseinfo.vo.rule;

import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: RuleCondConseqVo
 * @Description: 条件结果 组合vo
 * @date 2018/5/23
 */
@Data
public class RuleCondConseqVo {

    private RuleConditionVo ruleConditionVo;

    private RuleConsequenceVo ruleConsequenceVo;

    /**
     * @Fields  : 优先级
     * @author qiaomengnan
     */
    private Integer priority;

}
