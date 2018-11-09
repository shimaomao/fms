package cn.com.leadu.fms.thirdinterface.rpc.goldentax;

import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxPrintinvRpc
 * @Description:  金税发票打印rpc
 * @date 2018/9/12 0012
 */
@FeignClient(name = "goldenTaxPrintinv",url = "${fms.goldenTax.printinvUrl}")
public interface GoldenTaxPrintinvRpc {

    @RequestMapping(method = RequestMethod.POST)
    Response printinv(@RequestBody Map<String,Object> params);

}
