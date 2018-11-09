package cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleConsequence;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConsequenceVo
 * @Description: 规则引擎结果删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class RuleConsequenceDeleteListVo extends BaseVo<RuleConsequence> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 规则结果ID
     * @author qiaomengnan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> ruleConseqIds;

}