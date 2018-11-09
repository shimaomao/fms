package cn.com.leadu.fms.pojo.postbiz.vo.transferinfo;

import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: TransferReceiptVo
 * @Description: 过户任务确认收款载体
 */
@Data
public class TransferReceiptVo {

    private static final long serialVersionUID = 1L;


    /**
     * @Fields : 收款银行
     * @author huzongcheng
     */
    private String recAccBank;

    /**
     * @Fields : 收款银行分行
     * @author huzongcheng
     */
    private String recAccBranch;
    /**
     * @Fields : 收款账号
     * @author huzongcheng
     */
    private String recAccountNo;

    /**
     * @Fields : 收款户名
     * @author huzongcheng
     */
    private String recAccountName;

    /**
     * @Fields : 收款联行号
     * @author huzongcheng
     */
    private String recEleBankNo;

    /**
     * @Fields : 实收金额
     * @author huzongcheng
     */
    private BigDecimal receiptAmount;

    /**
     * @Fields : 备注
     * @author huzongcheng
     */
    private String memo;

    /**
     * @Fields : 到账日期
     * @author huzongcheng
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date receiptDate;
}
