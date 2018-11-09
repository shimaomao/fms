package cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailVo
 * @Description: 凭证类型明细管理删除时载体及验证
 * @date 2018-06-20
 */
@Data
public class FinancialVoucherDetailDeleteVo extends BaseVo<FinancialVoucherDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 凭证明细id
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String voucherDetailId;

}