package cn.com.leadu.fms.postbiz.validator.invoice.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yangyiquan
 * @ClassName: InvoiceVo
 * @Description: 开票信息删除时载体及验证
 */
@Data
public class InvoiceDeleteVo extends BaseVo<Invoice> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 开票信息ID
     * @author yangyiquan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String invoiceId;

}