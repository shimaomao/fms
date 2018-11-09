package cn.com.leadu.fms.product.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.product.service.ProductService;
import cn.com.leadu.fms.product.validator.product.vo.ProductDeleteListVo;
import cn.com.leadu.fms.product.validator.product.vo.ProductDeleteVo;
import cn.com.leadu.fms.product.validator.product.vo.ProductModifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author niehaibing
 * @ClassName: ProductController
 * @Description: 产品方案管理相关接口
 * @date 2018-03-23
 */
@RestController
@RequestMapping("product")
public class ProductController {

    /**
     * @Fields  : 产品方案管理service
     */
    @Autowired
    private ProductService productService;

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
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(productService.findProductsByPage(productVo)),
                HttpStatus.OK);
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
    public ResponseEntity<RestResponse> saveProduct(@Valid @RequestBody ProductVo productVo){
        productService.saveProduct(productVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改产品方案管理
     * @param productModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "modifyProduct",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyProduct(@Valid @RequestBody ProductModifyVo productModifyVo){
        productService.modifyProduct(productModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除产品方案管理
     * @param productDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "deleteProduct",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProduct(@Valid @RequestBody ProductDeleteVo productDeleteVo){
        productService.deleteProduct(productDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据productId集合删除产品方案管理
     * @param productDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "deleteProductsByProductIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProductsByProductIds(@Valid @RequestBody ProductDeleteListVo productDeleteListVo){
        productService.deleteProductsByProductIds(productDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(productService.findProductByProductId(productId)), HttpStatus.OK);
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
    @RequestMapping(value = "findProductVoByProductId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProductVoByProductId(String productId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(productService.findProductVoByProductId(productId)), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> findProductVoListByGroupCodes(ProductVo productVo, @AuthUserInfo SysUser sysUser){
        productVo.setGroupCode(sysUser.getGroupCode());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(productService.findProductVoListByGroupCodes(productVo)), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(productService.findProductVoByProduct(product)), HttpStatus.OK);
    }

}
