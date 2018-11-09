package cn.com.leadu.fms.baseinfo.validator.rulecondition.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionVo
 * @Description: 规则引擎条件删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class RuleConditionDeleteListVo extends BaseVo<RuleCondition> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 规则条件ID
     * @author qiaomengnan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> ruleCondIds;

}