package cn.com.leadu.fms.finance.validator.financialvoucher.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucher;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherVo
 * @Description: 凭证类型管理删除时载体及验证
 * @date 2018-06-20
 */
@Data
public class FinancialVoucherDeleteVo extends BaseVo<FinancialVoucher> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 凭证类型id
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String voucherId;

}