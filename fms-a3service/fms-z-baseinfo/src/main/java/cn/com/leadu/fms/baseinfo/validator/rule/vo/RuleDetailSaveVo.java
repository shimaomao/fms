package cn.com.leadu.fms.baseinfo.validator.rule.vo;

import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionSaveVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceSaveVo;
import lombok.Data;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleDetailSaveVo
 * @Description:
 * @date 2018/5/21
 */
@Data
public class RuleDetailSaveVo {

    private static final long serialVersionUID = 1L;

    private Integer index;

    private String ruleConditionTableName;

    private List<RuleConditionSaveVo> ruleConditionTableData;

    private String ruleConsequenceTableName;

    private List<RuleConsequenceSaveVo> ruleConsequenceTableData;

    private Integer priority;

}
