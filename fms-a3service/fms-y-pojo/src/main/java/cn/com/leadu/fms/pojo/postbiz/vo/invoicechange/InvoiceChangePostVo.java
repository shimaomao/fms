package cn.com.leadu.fms.pojo.postbiz.vo.invoicechange;

import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;

import java.util.List;

/**
 * Created by root on 2018/8/29.
 */
@Data
public class InvoiceChangePostVo {

    /**
     * 变更前实体
     */
    private InvoiceChangeVo oldInvoiceChangeVo;

    /**
     * 变更后实体
     */
    private InvoiceChangeVo newInvoiceChangeVo;

    /**
     * @Fields  : 附件信息
     * @author lijunjun
     */
    private List<BizFiles> bizFilesList;

    /**
     * @Fields  : 任务Id
     * @author lijunjun
     */
    private String taskId;

    /**
     * @Fields  : 变更任务号
     * @author lijunjun
     */
    private String invoiceTaskNo;

    /**
     * @Fields  : 备注
     * @author lijunjun
     */
    private String remark;
}
