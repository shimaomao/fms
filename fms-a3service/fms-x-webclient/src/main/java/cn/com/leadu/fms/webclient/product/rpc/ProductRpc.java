package cn.com.leadu.fms.webclient.product.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ProductRpc {

    /**
     * @Title:
     * @Description: 分页查询产品方案管理信息
     * @param productVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "api/product/product/findProductsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProductsByPage(@RequestParam Map<String, Object> productVoMap);

    /**
     * @Title:
     * @Description: 保存产品方案管理
     * @param productVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "api/product/product/saveProduct",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveProduct(@RequestBody ProductVo productVo);

    /**
     * @Title:
     * @Description:  修改产品方案管理
     * @param productVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "api/product/product/modifyProduct",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyProduct(@RequestBody ProductVo productVo);

    /**
     * @Title:
     * @Description:   根据productId集合删除产品方案管理
     * @param productIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "api/product/product/deleteProductsByProductIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteProductsByProductIds(@RequestBody ProductVo productVo);

    /**
     * @Title:
     * @Description:  根据productId获取产品方案管理
     * @param productId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "api/product/product/findProductByProductId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProductByProductId(@RequestParam("productId") String productId);

    /**
     * @Title:
     * @Description:  根据productId获取产品方案信息
     * @param productId
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "api/product/product/findProductVoByProductId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProductVoByProductId(@RequestParam("productId") String productId);

    /**
     * @Title:
     * @Description:  根据机构代码等条件获取用户组及下层分组中的全部产品方案
     * @param productVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    @RequestMapping(value = "api/product/product/findProductVoListByGroupCodes", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProductVoListByGroupCodes(@RequestParam Map<String, Object> productVoMap);

    /**
     * @Title:
     * @Description:  根据产品方案代码，获取产品方案信息
     * @param product
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    @RequestMapping(value = "api/product/product/findProductVoByProduct", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProductVoByProduct(@RequestParam("product") String product);


}
