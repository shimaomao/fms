package cn.com.leadu.fms.postbiz.validator.invoicechange.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChange;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeVo
 * @Description: 开票信息变更删除时载体及验证
 * @date 2018-08-29
 */
@Data
public class InvoiceChangeDeleteVo extends BaseVo<InvoiceChange> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 开票信息变更id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String invoiceChangeId;

}