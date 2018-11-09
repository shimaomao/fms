package cn.com.leadu.fms.pojo.original.vo.origfiledetail;

import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import lombok.Data;

import java.util.List;

/**
 * Created by lijunjun on 2018/5/30.
 */
@Data
public class OrigFileBorrowFinanceVo {

    /**
     * 财务收款信息List
     */
    private List<ContReceiptVo> contReceiptVoList;

    /**
     * 借阅任务号
     */
    private String borrowTaskNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 任务ID
     */
    private String taskId;
}
