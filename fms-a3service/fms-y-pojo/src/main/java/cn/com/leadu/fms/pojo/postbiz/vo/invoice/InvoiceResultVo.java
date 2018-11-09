package cn.com.leadu.fms.pojo.postbiz.vo.invoice;

import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: InvoiceResultVo
 * @Description: 发票打印结果返回vo
 * @date 2018/9/18 0018
 */
@Data
public class InvoiceResultVo {

    /**
     * @Fields  : 成功发送的开票信息
     * @author qiaomengnan
     */
    private List<InvoiceVo> successInvoiceVos = new ArrayList<>();

    /**
     * @Fields  : 发送失败的开票信息
     * @author qiaomengnan
     */
    private List<InvoiceVo> errorInvoiceVos = new ArrayList<>();

    /**
     * @Fields  : 因为失败而没有继续发送的数据
     * @author qiaomengnan
     */
    private List<InvoiceVo> notSendInvoiceVos = new ArrayList<>();

    /**
     * @Fields  : 发送成功返回的发票信息
     * @author qiaomengnan
     */
    private List<InvoiceAuto> invoiceAutos = new ArrayList<>();

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
