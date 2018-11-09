package cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasRepayRule;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleVo
 * @Description: 还款日规则删除时载体及验证
 * @date 2018-03-16
 */
@Data
public class BasRepayRuleDeleteListVo extends BaseVo<BasRepayRule> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> ruleIds;

}