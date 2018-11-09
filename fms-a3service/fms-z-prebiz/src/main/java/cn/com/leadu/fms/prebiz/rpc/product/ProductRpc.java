package cn.com.leadu.fms.prebiz.rpc.product;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: ProductController
 * @Description: 产品方案管理rpc
 * @date 2018-03-23
 */
@FeignClient("${fms.feigns.serverNames.fmsProduct}")
public interface ProductRpc {

    /**
     * @Title:
     * @Description:  根据产品方案代码，获取产品方案信息
     * @param product
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    @RequestMapping(value = "product/findProductVoByProduct", method = RequestMethod.GET)
    ResponseEntity<RestResponse<Map<String, Object>>> findProductVoByProduct(@RequestParam("product") String product);
}
