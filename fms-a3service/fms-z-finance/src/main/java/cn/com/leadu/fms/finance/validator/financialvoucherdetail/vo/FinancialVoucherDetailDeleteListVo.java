package cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailVo
 * @Description: 凭证类型明细管理删除时载体及验证
 * @date 2018-06-20
 */
@Data
public class FinancialVoucherDetailDeleteListVo extends BaseVo<FinancialVoucherDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 凭证明细id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> voucherDetailIds;

}