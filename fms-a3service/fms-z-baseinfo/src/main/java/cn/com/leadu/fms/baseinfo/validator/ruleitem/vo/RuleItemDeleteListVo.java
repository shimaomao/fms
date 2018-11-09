package cn.com.leadu.fms.baseinfo.validator.ruleitem.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleItem;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemVo
 * @Description: 规则引擎项目管理删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class RuleItemDeleteListVo extends BaseVo<RuleItem> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 规则项目ID
     * @author qiaomengnan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> ruleItemIds;

}