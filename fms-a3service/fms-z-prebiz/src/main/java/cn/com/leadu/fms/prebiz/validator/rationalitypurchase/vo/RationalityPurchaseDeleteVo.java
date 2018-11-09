package cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.RationalityPurchase;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: RationalityPurchaseVo
 * @Description: 购买合理性删除时载体及验证
 * @date 2018-05-29
 */
@Data
public class RationalityPurchaseDeleteVo extends BaseVo<RationalityPurchase> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 购车原因id
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String buyCarId;

}