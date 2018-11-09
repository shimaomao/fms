package cn.com.leadu.fms.finance.validator.assisaccounttype.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeVo
 * @Description: 辅助核算类型管理删除时载体及验证
 * @date 2018-06-23
 */
@Data
public class AssisAccountTypeDeleteVo extends BaseVo<AssisAccountType> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 辅助核算类型id
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String assisAccountTypeId;

}