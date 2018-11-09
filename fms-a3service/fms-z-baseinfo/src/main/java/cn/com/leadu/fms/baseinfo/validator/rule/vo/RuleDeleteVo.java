package cn.com.leadu.fms.baseinfo.validator.rule.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: RuleVo
 * @Description: 规则引擎删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class RuleDeleteVo extends BaseVo<Rule> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 规则ID
     * @author qiaomengnan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String ruleId;

}