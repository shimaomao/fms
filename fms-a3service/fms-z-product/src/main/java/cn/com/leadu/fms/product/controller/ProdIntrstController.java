package cn.com.leadu.fms.product.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.product.vo.prodintrst.ProdIntrstVo;
import cn.com.leadu.fms.product.service.ProdIntrstService;
import cn.com.leadu.fms.product.validator.prodintrst.vo.*;
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
 * @ClassName: ProdIntrstController
 * @Description: 产品利率相关接口
 * @date 2018-03-27
 */
@RestController
@RequestMapping("prod_intrst")
public class ProdIntrstController {

    /**
     * @Fields  : 产品利率service
     */
    @Autowired
    private ProdIntrstService prodIntrstService;

    /**
     * @Title:
     * @Description: 分页查询产品利率信息
     * @param prodIntrstVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "findProdIntrstsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProdIntrstsByPage(ProdIntrstVo prodIntrstVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(prodIntrstService.findProdIntrstsByPage(prodIntrstVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存产品利率
     * @param prodIntrstSaveVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "saveProdIntrst",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveProdIntrst(@Valid @RequestBody ProdIntrstSaveVo prodIntrstSaveVo){
        prodIntrstService.saveProdIntrst(prodIntrstSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改产品利率
     * @param prodIntrstModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "modifyProdIntrst",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyProdIntrst(@Valid @RequestBody ProdIntrstModifyVo prodIntrstModifyVo){
        prodIntrstService.modifyProdIntrst(prodIntrstModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除产品利率
     * @param prodIntrstDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "deleteProdIntrst",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProdIntrst(@Valid @RequestBody ProdIntrstDeleteVo prodIntrstDeleteVo){
        prodIntrstService.deleteProdIntrst(prodIntrstDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据prodIntrstId集合删除产品利率
     * @param prodIntrstDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "deleteProdIntrstsByProdIntrstIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProdIntrstsByProdIntrstIds(@Valid @RequestBody ProdIntrstDeleteListVo prodIntrstDeleteListVo){
        prodIntrstService.deleteProdIntrstsByProdIntrstIds(prodIntrstDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据prodIntrstId获取产品利率
     * @param prodIntrstId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "findProdIntrstByProdIntrstId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProdIntrstByProdIntrstId(String prodIntrstId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(prodIntrstService.findProdIntrstByProdIntrstId(prodIntrstId)), HttpStatus.OK);
    }

}
