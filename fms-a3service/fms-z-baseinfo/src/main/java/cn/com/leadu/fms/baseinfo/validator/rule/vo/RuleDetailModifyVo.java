package cn.com.leadu.fms.baseinfo.validator.rule.vo;

import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionModifyVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceModifyVo;
import lombok.Data;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleDetailSaveVo
 * @Description:
 * @date 2018/5/21
 */
@Data
public class RuleDetailModifyVo {

    private static final long serialVersionUID = 1L;

    private Integer index;

    private String ruleConditionTableName;

    private List<RuleConditionModifyVo> ruleConditionTableData;

    private String ruleConsequenceTableName;

    private List<RuleConsequenceModifyVo> ruleConsequenceTableData;

    private Integer priority;

}
