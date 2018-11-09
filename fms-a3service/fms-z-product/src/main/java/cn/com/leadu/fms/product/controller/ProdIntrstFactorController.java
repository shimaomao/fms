package cn.com.leadu.fms.product.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import cn.com.leadu.fms.product.service.ProdIntrstFactorService;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.*;
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
 * @ClassName: ProdIntrstFactorController
 * @Description: 产品利率相关接口
 * @date 2018-03-27
 */
@RestController
@RequestMapping("prod_intrst_factor")
public class ProdIntrstFactorController {

    /**
     * @Fields  : 产品利率service
     */
    @Autowired
    private ProdIntrstFactorService prodIntrstFactorService;

    /**
     * @Title:
     * @Description: 分页查询产品利率信息
     * @param prodIntrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "findProdIntrstFactorsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProdIntrstFactorsByPage(ProdIntrstFactorVo prodIntrstFactorVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(prodIntrstFactorService.findProdIntrstFactorsByPage(prodIntrstFactorVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存产品利率
     * @param prodIntrstFactorSaveVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "saveProdIntrstFactor",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveProdIntrstFactor(@Valid @RequestBody ProdIntrstFactorSaveVo prodIntrstFactorSaveVo){
        prodIntrstFactorService.saveProdIntrstFactor(prodIntrstFactorSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改产品利率
     * @param prodIntrstFactorModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "modifyProdIntrstFactor",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyProdIntrstFactor(@Valid @RequestBody ProdIntrstFactorModifyVo prodIntrstFactorModifyVo){
        prodIntrstFactorService.modifyProdIntrstFactor(prodIntrstFactorModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除产品利率
     * @param prodIntrstFactorDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "deleteProdIntrstFactor",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProdIntrstFactor(@Valid @RequestBody ProdIntrstFactorDeleteVo prodIntrstFactorDeleteVo){
        prodIntrstFactorService.deleteProdIntrstFactor(prodIntrstFactorDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据prodIntrstFactorId集合删除产品利率
     * @param prodIntrstFactorDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "deleteProdIntrstFactorsByProdIntrstFactorIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProdIntrstFactorsByProdIntrstFactorIds(@Valid @RequestBody ProdIntrstFactorDeleteListVo prodIntrstFactorDeleteListVo){
        prodIntrstFactorService.deleteProdIntrstFactorsByProdIntrstFactorIds(prodIntrstFactorDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据prodIntrstFactorId获取产品利率
     * @param prodIntrstFactorId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "findProdIntrstFactorByProdIntrstFactorId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProdIntrstFactorByProdIntrstFactorId(String prodIntrstFactorId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(prodIntrstFactorService.findProdIntrstFactorByProdIntrstFactorId(prodIntrstFactorId)), HttpStatus.OK);
    }

}
