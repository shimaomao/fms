package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmperson.CstmPersonVo;
import cn.com.leadu.fms.prebiz.service.CstmPersonService;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.*;
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
 * @ClassName: CstmPersonController
 * @Description: 客户个人基本信息相关接口
 * @date 2018-03-26
 */
@RestController
@RequestMapping("cstm_person")
public class CstmPersonController {

    /**
     * @Fields  : 客户个人基本信息service
     */
    @Autowired
    private CstmPersonService cstmPersonService;

    /**
     * @Title:
     * @Description: 分页查询客户个人基本信息信息
     * @param cstmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "findCstmPersonsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersonsByPage(CstmPersonVo cstmPersonVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(cstmPersonService.findCstmPersonsByPage(cstmPersonVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存客户个人基本信息
     * @param cstmPersonSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
//    @RequestMapping(value = "saveCstmPerson",method = RequestMethod.POST)
//    public ResponseEntity<RestResponse> saveCstmPerson(@Valid @RequestBody CstmPersonSaveVo cstmPersonSaveVo){
//        cstmPersonService.saveCstmPerson(cstmPersonSaveVo);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  修改客户个人基本信息
     * @param cstmPersonModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "modifyCstmPerson",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmPerson(@Valid @RequestBody CstmPersonModifyVo cstmPersonModifyVo){
        cstmPersonService.modifyCstmPerson(cstmPersonModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除客户个人基本信息
     * @param cstmPersonDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "deleteCstmPerson",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPerson(@Valid @RequestBody CstmPersonDeleteVo cstmPersonDeleteVo){
        cstmPersonService.deleteCstmPerson(cstmPersonDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据cstmPersonId集合删除客户个人基本信息
     * @param cstmPersonDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "deleteCstmPersonsByCstmPersonIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersonsByCstmPersonIds(@Valid @RequestBody CstmPersonDeleteListVo cstmPersonDeleteListVo){
        cstmPersonService.deleteCstmPersonsByCstmPersonIds(cstmPersonDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据cstmPersonId获取客户个人基本信息
     * @param cstmPersonId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "findCstmPersonByCstmPersonId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersonByCstmPersonId(String cstmPersonId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(cstmPersonService.findCstmPersonByCstmPersonId(cstmPersonId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取客户个人基本信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-14 11:27:21
     */
    @RequestMapping(value = "findCstmPersonByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersonByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(cstmPersonService.findCstmPersonByApplyNo(applyNo)), HttpStatus.OK);
    }


}
