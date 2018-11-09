package cn.com.leadu.fms.pojo.postbiz.vo.invoice;

import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: InvoicePrintinvResultVo
 * @Description: 打印结果result
 * @date 2018/9/18 0018
 */
@Data
public class InvoicePrintinvResultVo {

    /**
     * @Fields  : 打印成功的发票信息
     * @author qiaomengnan
     */
    private List<InvoiceAuto> successInvoiceAutos = new ArrayList<>();

    /**
     * @Fields  : 打印失败的发票信息
     * @author qiaomengnan
     */
    private List<InvoiceAuto> errorInvoiceAutos = new ArrayList<>();

    /**
     * @Fields  : 因为失败没有继续发送的信息
     * @author qiaomengnan
     */
    private List<InvoiceAuto> notSendInvoiceAutos = new ArrayList<>();

    /**
     * @Fields  : 失败原因
     * @author qiaomengnan
     */
    private String errorMsg;

    /**
     * @Fields  : 失败code
     * @author qiaomengnan
     */
    private String errorCode;

}
