package cn.com.leadu.fms.finance.validator.financialvoucher.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucher;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherVo
 * @Description: 凭证类型管理删除时载体及验证
 * @date 2018-06-20
 */
@Data
public class FinancialVoucherDeleteListVo extends BaseVo<FinancialVoucher> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 凭证类型id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> voucherIds;

}