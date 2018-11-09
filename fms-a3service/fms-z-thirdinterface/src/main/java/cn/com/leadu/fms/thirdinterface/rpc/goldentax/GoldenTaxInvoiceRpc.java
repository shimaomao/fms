package cn.com.leadu.fms.thirdinterface.rpc.goldentax;

import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.GoldenTaxInvoiceSendVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxInvoiceRpc
 * @Description: 金税开票rpc
 * @date 2018/9/12 0012
 */
@FeignClient(name = "goldenTaxInvoice",url = "${fms.goldenTax.invoiceUrl}")
public interface GoldenTaxInvoiceRpc {

    @RequestMapping(method = RequestMethod.POST)
    Response invoice(@RequestBody GoldenTaxInvoiceSendVo goldenTaxInvoiceSendVo);

}
