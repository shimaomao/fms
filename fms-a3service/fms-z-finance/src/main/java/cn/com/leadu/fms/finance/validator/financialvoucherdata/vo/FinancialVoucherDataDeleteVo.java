package cn.com.leadu.fms.finance.validator.financialvoucherdata.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataVo
 * @Description: 财务凭证数据删除时载体及验证
 * @date 2018-06-25
 */
@Data
public class FinancialVoucherDataDeleteVo extends BaseVo<FinancialVoucherData> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 财务凭证id
     * @author qiaomengnan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String voucherDataId;

}