package cn.com.leadu.fms.pojo.baseinfo.vo.rule;

import lombok.Data;

/**
 * @author liujinge
 * @ClassName: RuleInsuranceVo
 * @Description: 规则引擎 险种类型入力vo
 * @date 2018/6/15
 */
@Data
public class RuleOverdueAssignmentVo {

    /**
     * @Fields : 风控初审人员
     */
    private String riskApproveUser;

    /**
     * @Fields : 催收类别
     */
    private String collectionType;
}
