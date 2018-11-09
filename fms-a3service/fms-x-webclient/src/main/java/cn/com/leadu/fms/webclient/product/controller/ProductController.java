package cn.com.leadu.fms.webclient.product.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import cn.com.leadu.fms.webclient.product.rpc.ProductRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: ProductController
 * @Description: 产品方案管理controller
 * @date 2018-03-23
 */
@RestController
@RequestMapping("product")
public class ProductController {

    /**
     * @Fields  : 产品方案管理rpc
     */
    @Autowired
    private ProductRpc productRpc;

    /**
     * @Title:
     * @Description: 分页查询产品方案管理信息
     * @param productVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "findProductsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductsByPage(ProductVo productVo){
        Map productVoMap = productVo == null?null:(Map) JSON.toJSON(productVo);
        return productRpc.findProductsByPage(productVoMap);
    }

    /**
     * @Title:
     * @Description: 保存产品方案管理
     * @param productVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "saveProduct",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveProduct(@RequestBody ProductVo productVo){
        return productRpc.saveProduct(productVo);
    }

    /**
     * @Title:
     * @Description:  修改产品方案管理
     * @param productVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "modifyProduct",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyProduct(@RequestBody ProductVo productVo){
        return productRpc.modifyProduct(productVo);
    }

    /**
     * @Title:
     * @Description:   根据productId集合删除产品方案管理
     * @param productIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "deleteProductsByProductIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProductsByProductIds(@RequestBody ProductVo productVo){
        return productRpc.deleteProductsByProductIds(productVo);
    }

    /**
     * @Title:
     * @Description:  根据productId获取产品方案管理
     * @param productId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "findProductByProductId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductByProductId(String productId){
        return productRpc.findProductByProductId(productId);
    }


    /**
     * @Title:
     * @Description:  根据productId获取产品方案管理
     * @param productId
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "findProductVoByProductId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductVoByProductId(String productId){
        return productRpc.findProductVoByProductId(productId);
    }
    /**
     * @Title:
     * @Description:  根据机构代码等条件获取用户组及下层分组中的全部产品方案
     * @param productVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    @RequestMapping(value = "findProductVoListByGroupCodes", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductVoListByGroupCodes(ProductVo productVo){
        Map<String, Object> productVoMap = productVo == null? null:(Map<String, Object>) JSON.toJSON(productVo);
        return productRpc.findProductVoListByGroupCodes(productVoMap);
    }

    /**
     * @Title:
     * @Description:  根据产品方案代码，获取产品方案信息
     * @param product
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    @RequestMapping(value = "findProductVoByProduct", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductVoByProduct(String product){
        return productRpc.findProductVoByProduct(product);
    }

}
