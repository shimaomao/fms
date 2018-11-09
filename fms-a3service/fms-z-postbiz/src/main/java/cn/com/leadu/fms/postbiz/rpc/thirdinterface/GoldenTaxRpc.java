package cn.com.leadu.fms.postbiz.rpc.thirdinterface;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxRpc
 * @Description: 金税rpc
 * @date 2018/9/12 0012
 */
@FeignClient("${fms.feigns.serverNames.fmsThirdInterface}")
public interface GoldenTaxRpc {

    @RequestMapping(value = "golden_tax/invoice", method = RequestMethod.POST)
    ResponseEntity<RestResponse<GoldenTaxInvoiceResultVo>> invoice(@RequestBody GoldenTaxInvoiceSendVo goldenTaxInvoiceSendVo);

    @RequestMapping(value = "golden_tax/printinv", method = RequestMethod.POST)
    ResponseEntity<RestResponse<GoldenTaxInvoiceResultVo>> printinv(@RequestBody GoldenTaxPrintinvVo goldenTaxPrintinvVo);

}
