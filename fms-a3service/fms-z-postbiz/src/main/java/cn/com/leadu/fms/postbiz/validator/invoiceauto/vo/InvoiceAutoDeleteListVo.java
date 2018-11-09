package cn.com.leadu.fms.postbiz.validator.invoiceauto.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoVo
 * @Description: 自动开票信息删除时载体及验证
 */
@Data
public class InvoiceAutoDeleteListVo extends BaseVo<InvoiceAuto> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 自动开票id
     * @author yangyiquan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> invoiceAutoIds;

}