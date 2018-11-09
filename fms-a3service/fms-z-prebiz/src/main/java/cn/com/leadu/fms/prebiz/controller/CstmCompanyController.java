package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.prebiz.service.CstmCompanyService;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.*;
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
 * @ClassName: CstmCompanyController
 * @Description: 客户企业基本信息相关接口
 * @date 2018-03-27
 */
@RestController
@RequestMapping("cstm_company")
public class CstmCompanyController {

    /**
     * @Fields  : 客户企业基本信息service
     */
    @Autowired
    private CstmCompanyService cstmCompanyService;

    /**
     * @Title:
     * @Description: 分页查询客户企业基本信息信息
     * @param cstmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "findCstmCompanysByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmCompanysByPage(CstmCompanyVo cstmCompanyVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(cstmCompanyService.findCstmCompanysByPage(cstmCompanyVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存客户企业基本信息
     * @param cstmCompanySaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
//    @RequestMapping(value = "saveCstmCompany",method = RequestMethod.POST)
//    public ResponseEntity<RestResponse> saveCstmCompany(@Valid @RequestBody CstmCompanySaveVo cstmCompanySaveVo){
//        cstmCompanyService.saveCstmCompany(cstmCompanySaveVo);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  修改客户企业基本信息
     * @param cstmCompanyModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "modifyCstmCompany",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmCompany(@Valid @RequestBody CstmCompanyModifyVo cstmCompanyModifyVo){
        cstmCompanyService.modifyCstmCompany(cstmCompanyModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除客户企业基本信息
     * @param cstmCompanyDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "deleteCstmCompany",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmCompany(@Valid @RequestBody CstmCompanyDeleteVo cstmCompanyDeleteVo){
        cstmCompanyService.deleteCstmCompany(cstmCompanyDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据cstmCompanyId集合删除客户企业基本信息
     * @param cstmCompanyDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "deleteCstmCompanysByCstmCompanyIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmCompanysByCstmCompanyIds(@Valid @RequestBody CstmCompanyDeleteListVo cstmCompanyDeleteListVo){
        cstmCompanyService.deleteCstmCompanysByCstmCompanyIds(cstmCompanyDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据cstmCompanyId获取客户企业基本信息
     * @param cstmCompanyId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "findCstmCompanyByCstmCompanyId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmCompanyByCstmCompanyId(String cstmCompanyId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(cstmCompanyService.findCstmCompanyByCstmCompanyId(cstmCompanyId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取客户企业基本信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-14 11:11:47
     */
    @RequestMapping(value = "findCstmCompanyByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmCompanyByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(cstmCompanyService.findCstmCompanyByApplyNo(applyNo)), HttpStatus.OK);
    }
}
