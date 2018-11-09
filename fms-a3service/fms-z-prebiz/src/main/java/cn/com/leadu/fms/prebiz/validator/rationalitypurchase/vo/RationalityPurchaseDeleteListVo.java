package cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.RationalityPurchase;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RationalityPurchaseVo
 * @Description: 购买合理性删除时载体及验证
 * @date 2018-05-29
 */
@Data
public class RationalityPurchaseDeleteListVo extends BaseVo<RationalityPurchase> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 购车原因id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> buyCarIds;

}