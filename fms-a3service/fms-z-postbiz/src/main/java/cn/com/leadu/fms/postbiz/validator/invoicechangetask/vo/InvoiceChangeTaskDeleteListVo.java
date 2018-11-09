package cn.com.leadu.fms.postbiz.validator.invoicechangetask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChangeTask;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskVo
 * @Description: 开票变更任务删除时载体及验证
 * @date 2018-08-29
 */
@Data
public class InvoiceChangeTaskDeleteListVo extends BaseVo<InvoiceChangeTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 变更任务id
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> invoiceChangeTaskIds;

}