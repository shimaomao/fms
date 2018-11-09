package cn.com.leadu.fms.postbiz.validator.invoicechangetask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChangeTask;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskVo
 * @Description: 开票变更任务删除时载体及验证
 * @date 2018-08-29
 */
@Data
public class InvoiceChangeTaskDeleteVo extends BaseVo<InvoiceChangeTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 变更任务id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String invoiceChangeTaskId;

}