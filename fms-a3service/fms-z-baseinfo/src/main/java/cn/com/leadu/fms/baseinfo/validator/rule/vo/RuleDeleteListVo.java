package cn.com.leadu.fms.baseinfo.validator.rule.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleVo
 * @Description: 规则引擎删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class RuleDeleteListVo extends BaseVo<Rule> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 规则ID
     * @author qiaomengnan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> ruleIds;

}