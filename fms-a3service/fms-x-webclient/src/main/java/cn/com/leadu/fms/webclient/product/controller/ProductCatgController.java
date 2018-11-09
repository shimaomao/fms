package cn.com.leadu.fms.webclient.product.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.productcatg.ProductCatgVo;
import cn.com.leadu.fms.webclient.product.rpc.ProductCatgRpc;
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
 * @ClassName: ProductCatgController
 * @Description: 产品大类管理controller
 * @date 2018-03-21
 */
@RestController
@RequestMapping("product_catg")
public class ProductCatgController {

    /**
     * @Fields  : 产品大类管理rpc
     */
    @Autowired
    private ProductCatgRpc productCatgRpc;

    /**
     * @Title:
     * @Description: 分页查询产品大类管理信息
     * @param productCatgVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "findProductCatgsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductCatgsByPage(ProductCatgVo productCatgVo){
        Map productCatgVoMap = productCatgVo == null?null:(Map) JSON.toJSON(productCatgVo);
        return productCatgRpc.findProductCatgsByPage(productCatgVoMap);
    }

    /**
     * @Title:
     * @Description: 保存产品大类管理
     * @param productCatgVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "saveProductCatg",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveProductCatg(@RequestBody ProductCatgVo productCatgVo){
        return productCatgRpc.saveProductCatg(productCatgVo);
    }

    /**
     * @Title:
     * @Description:  修改产品大类管理
     * @param productCatgVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "modifyProductCatg",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyProductCatg(@RequestBody ProductCatgVo productCatgVo){
        return productCatgRpc.modifyProductCatg(productCatgVo);
    }

    /**
     * @Title:
     * @Description:   根据productCatgId集合删除产品大类管理
     * @param productCatgIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "deleteProductCatgsByProductCatgIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProductCatgsByProductCatgIds(@RequestBody List<String> productCatgIds){
        ProductCatgVo productCatgVo = new ProductCatgVo();
        productCatgVo.setProductCatgIds(productCatgIds);
        return productCatgRpc.deleteProductCatgsByProductCatgIds(productCatgVo);
    }

    /**
     * @Title:
     * @Description:  根据productCatgId获取产品大类管理
     * @param productCatgId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "findProductCatgByProductCatgId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductCatgByProductCatgId(String productCatgId){
        return productCatgRpc.findProductCatgByProductCatgId(productCatgId);
    }

    /**
     * @Title:
     * @Description:  取得全部产品大类信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-21 19:43:48
     */
    @RequestMapping(value = "findProductCatgListByAll", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductCatgListByAll(){
        return productCatgRpc.findProductCatgListByAll();
    }

}
