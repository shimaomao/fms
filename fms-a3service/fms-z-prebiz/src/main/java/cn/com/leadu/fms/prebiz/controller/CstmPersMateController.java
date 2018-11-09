package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate.CstmPersMateVo;
import cn.com.leadu.fms.prebiz.service.CstmPersMateService;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateController
 * @Description: 客户个人配偶信息相关接口
 * @date 2018-03-26
 */
@RestController
@RequestMapping("cstm_pers_mate")
public class CstmPersMateController {

    /**
     * @Fields  : 客户个人配偶信息service
     */
    @Autowired
    private CstmPersMateService cstmPersMateService;

    /**
     * @Title:
     * @Description: 分页查询客户个人配偶信息信息
     * @param cstmPersMateVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "findCstmPersMatesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersMatesByPage(CstmPersMateVo cstmPersMateVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(cstmPersMateService.findCstmPersMatesByPage(cstmPersMateVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存客户个人配偶信息
     * @param cstmPersMateSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
//    @RequestMapping(value = "saveCstmPersMate",method = RequestMethod.POST)
//    public ResponseEntity<RestResponse> saveCstmPersMate(@Valid @RequestBody CstmPersMateSaveVo cstmPersMateSaveVo){
//        cstmPersMateService.saveCstmPersMate(cstmPersMateSaveVo);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  修改客户个人配偶信息
     * @param cstmPersMateModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "modifyCstmPersMate",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmPersMate(@Valid @RequestBody CstmPersMateModifyVo cstmPersMateModifyVo){
        cstmPersMateService.modifyCstmPersMate(cstmPersMateModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除客户个人配偶信息
     * @param cstmPersMateDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "deleteCstmPersMate",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersMate(@Valid @RequestBody CstmPersMateDeleteVo cstmPersMateDeleteVo){
        cstmPersMateService.deleteCstmPersMate(cstmPersMateDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据persMateId集合删除客户个人配偶信息
     * @param cstmPersMateDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "deleteCstmPersMatesByPersMateIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersMatesByPersMateIds(@Valid @RequestBody CstmPersMateDeleteListVo cstmPersMateDeleteListVo){
        cstmPersMateService.deleteCstmPersMatesByPersMateIds(cstmPersMateDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据persMateId获取客户个人配偶信息
     * @param persMateId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "findCstmPersMateByPersMateId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersMateByPersMateId(String persMateId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(cstmPersMateService.findCstmPersMateByPersMateId(persMateId)), HttpStatus.OK);
    }

}
