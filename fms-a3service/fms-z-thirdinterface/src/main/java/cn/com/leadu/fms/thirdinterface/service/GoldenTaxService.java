package cn.com.leadu.fms.thirdinterface.service;

import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.*;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxService
 * @Description: 金税service
 * @date 2018/9/12 0012
 */
public interface GoldenTaxService  {

    /**
     * @Title:
     * @Description:   开票
     * @param goldenTaxInvoiceSendVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 06:48:25
     */
    GoldenTaxInvoiceResultVo invoice(GoldenTaxInvoiceSendVo goldenTaxInvoiceSendVo);

    /**
     * @Title:
     * @Description:   打印
     * @param goldenTaxPrintinvVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 07:02:14
     */
    GoldenTaxInvoiceResultVo printinv(GoldenTaxPrintinvVo goldenTaxPrintinvVo);

}
