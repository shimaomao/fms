package cn.com.leadu.fms.postbiz.validator.invoiceauto.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoVo
 * @Description: 自动开票信息删除时载体及验证
 */
@Data
public class InvoiceAutoDeleteVo extends BaseVo<InvoiceAuto> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 自动开票id
     * @author yangyiquan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String invoiceAutoId;

}