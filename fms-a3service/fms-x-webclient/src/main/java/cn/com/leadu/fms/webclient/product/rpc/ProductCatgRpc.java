package cn.com.leadu.fms.webclient.product.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.productcatg.ProductCatgVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: ProductCatgController
 * @Description: 产品大类管理rpc
 * @date 2018-03-21
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ProductCatgRpc {

    /**
     * @Title:
     * @Description: 分页查询产品大类管理信息
     * @param productCatgVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "api/product/product_catg/findProductCatgsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProductCatgsByPage(@RequestParam Map<String, Object> productCatgVoMap);

    /**
     * @Title:
     * @Description: 保存产品大类管理
     * @param productCatgVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "api/product/product_catg/saveProductCatg",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveProductCatg(@RequestBody ProductCatgVo productCatgVo);

    /**
     * @Title:
     * @Description:  修改产品大类管理
     * @param productCatgVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "api/product/product_catg/modifyProductCatg",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyProductCatg(@RequestBody ProductCatgVo productCatgVo);

    /**
     * @Title:
     * @Description:   根据productCatgId集合删除产品大类管理
     * @param productCatgVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "api/product/product_catg/deleteProductCatgsByProductCatgIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteProductCatgsByProductCatgIds(@RequestBody ProductCatgVo productCatgVo);

    /**
     * @Title:
     * @Description:  根据productCatgId获取产品大类管理
     * @param productCatgId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "api/product/product_catg/findProductCatgByProductCatgId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProductCatgByProductCatgId(@RequestParam("productCatgId") String productCatgId);

    /**
     * @Title:
     * @Description:  取得全部产品大类信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-21 19:43:48
     */
    @RequestMapping(value = "api/product/product_catg/findProductCatgListByAll", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProductCatgListByAll();

}
