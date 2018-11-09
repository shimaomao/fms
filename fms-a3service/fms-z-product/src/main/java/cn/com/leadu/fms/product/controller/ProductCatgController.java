package cn.com.leadu.fms.product.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.product.vo.productcatg.ProductCatgVo;
import cn.com.leadu.fms.product.service.ProductCatgService;
import cn.com.leadu.fms.product.validator.productcatg.vo.*;
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
 * @ClassName: ProductCatgController
 * @Description: 产品大类管理相关接口
 * @date 2018-03-21
 */
@RestController
@RequestMapping("product_catg")
public class ProductCatgController {

    /**
     * @Fields  : 产品大类管理service
     */
    @Autowired
    private ProductCatgService productCatgService;

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
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(productCatgService.findProductCatgsByPage(productCatgVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存产品大类管理
     * @param productCatgSaveVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "saveProductCatg",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveProductCatg(@Valid @RequestBody ProductCatgSaveVo productCatgSaveVo){
        productCatgService.saveProductCatg(productCatgSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改产品大类管理
     * @param productCatgModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "modifyProductCatg",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyProductCatg(@Valid @RequestBody ProductCatgModifyVo productCatgModifyVo){
        productCatgService.modifyProductCatg(productCatgModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除产品大类管理
     * @param productCatgDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "deleteProductCatg",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProductCatg(@Valid @RequestBody ProductCatgDeleteVo productCatgDeleteVo){
        productCatgService.deleteProductCatg(productCatgDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据productCatgId集合删除产品大类管理
     * @param productCatgDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @RequestMapping(value = "deleteProductCatgsByProductCatgIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProductCatgsByProductCatgIds(@Valid @RequestBody ProductCatgDeleteListVo productCatgDeleteListVo){
        productCatgService.deleteProductCatgsByProductCatgIds(productCatgDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(productCatgService.findProductCatgByProductCatgId(productCatgId)), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> findProductCatgListByAll() {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(productCatgService.findProductCatgListByAll()), HttpStatus.OK);
    }

}
