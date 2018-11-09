package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr.CstmPersAddrVo;
import cn.com.leadu.fms.prebiz.service.CstmPersAddrService;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.*;
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
 * @ClassName: CstmPersAddrController
 * @Description: 客户个人地址信息相关接口
 * @date 2018-03-26
 */
@RestController
@RequestMapping("cstm_pers_addr")
public class CstmPersAddrController {

    /**
     * @Fields  : 客户个人地址信息service
     */
    @Autowired
    private CstmPersAddrService cstmPersAddrService;

    /**
     * @Title:
     * @Description: 分页查询客户个人地址信息信息
     * @param cstmPersAddrVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "findCstmPersAddrsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersAddrsByPage(CstmPersAddrVo cstmPersAddrVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(cstmPersAddrService.findCstmPersAddrsByPage(cstmPersAddrVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存客户个人地址信息
     * @param cstmPersAddrSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
//    @RequestMapping(value = "saveCstmPersAddr",method = RequestMethod.POST)
//    public ResponseEntity<RestResponse> saveCstmPersAddr(@Valid @RequestBody CstmPersAddrSaveVo cstmPersAddrSaveVo){
//        cstmPersAddrService.saveCstmPersAddr(cstmPersAddrSaveVo);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  修改客户个人地址信息
     * @param cstmPersAddrModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "modifyCstmPersAddr",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmPersAddr(@Valid @RequestBody CstmPersAddrModifyVo cstmPersAddrModifyVo){
        cstmPersAddrService.modifyCstmPersAddr(cstmPersAddrModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除客户个人地址信息
     * @param cstmPersAddrDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "deleteCstmPersAddr",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersAddr(@Valid @RequestBody CstmPersAddrDeleteVo cstmPersAddrDeleteVo){
        cstmPersAddrService.deleteCstmPersAddr(cstmPersAddrDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据persAddrId集合删除客户个人地址信息
     * @param cstmPersAddrDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "deleteCstmPersAddrsByPersAddrIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersAddrsByPersAddrIds(@Valid @RequestBody CstmPersAddrDeleteListVo cstmPersAddrDeleteListVo){
        cstmPersAddrService.deleteCstmPersAddrsByPersAddrIds(cstmPersAddrDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据persAddrId获取客户个人地址信息
     * @param persAddrId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "findCstmPersAddrByPersAddrId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersAddrByPersAddrId(String persAddrId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(cstmPersAddrService.findCstmPersAddrByPersAddrId(persAddrId)), HttpStatus.OK);
    }

}
