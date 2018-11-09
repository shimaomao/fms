package cn.com.leadu.fms.finance.validator.contcharge.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: ContChargeVo
 * @Description: 财务待收款删除时载体及验证
 * @date 2018-06-01
 */
@Data
public class ContChargeDeleteVo extends BaseVo<ContCharge> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 财务待收款id
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String contChargeId;

}