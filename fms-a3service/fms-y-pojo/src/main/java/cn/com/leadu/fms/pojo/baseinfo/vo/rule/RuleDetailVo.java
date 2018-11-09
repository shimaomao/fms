package cn.com.leadu.fms.pojo.baseinfo.vo.rule;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import lombok.Data;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleDetailVo
 * @Description:
 * @date 2018/5/18
 */
@Data
public class RuleDetailVo extends PageQuery<Rule> {


    private static final long serialVersionUID = 1L;

    private Integer index;

    private String ruleConditionTableName;

    private List<RuleConditionVo> ruleConditionTableData;

    private String ruleConsequenceTableName;

    private List<RuleConsequenceVo> ruleConsequenceTableData;

    private Integer priority;

}
