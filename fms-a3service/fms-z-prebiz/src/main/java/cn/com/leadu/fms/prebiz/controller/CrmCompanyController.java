package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.crmcompany.CrmCompanyVo;
import cn.com.leadu.fms.prebiz.service.CrmCompanyService;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.*;
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
 * @ClassName: CrmCompanyController
 * @Description: CRM企业信息相关接口
 * @date 2018-05-23
 */
@RestController
@RequestMapping("crm_company")
public class CrmCompanyController {

    /**
     * @Fields  : CRM企业信息service
     */
    @Autowired
    private CrmCompanyService crmCompanyService;

    /**
     * @Title:
     * @Description: 分页查询CRM企业信息信息
     * @param crmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "findCrmCompanysByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmCompanysByPage(CrmCompanyVo crmCompanyVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(crmCompanyService.findCrmCompanysByPage(crmCompanyVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存CRM企业信息
     * @param crmCompanySaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "saveCrmCompany",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCrmCompany(@Valid @RequestBody CrmCompanySaveVo crmCompanySaveVo){
        crmCompanyService.saveCrmCompany(crmCompanySaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改CRM企业信息
     * @param crmCompanyModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "modifyCrmCompany",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCrmCompany(@Valid @RequestBody CrmCompanyModifyVo crmCompanyModifyVo){
        crmCompanyService.modifyCrmCompany(crmCompanyModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除CRM企业信息
     * @param crmCompanyDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "deleteCrmCompany",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCrmCompany(@Valid @RequestBody CrmCompanyDeleteVo crmCompanyDeleteVo){
        crmCompanyService.deleteCrmCompany(crmCompanyDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据companyId集合删除CRM企业信息
     * @param crmCompanyDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "deleteCrmCompanysByCompanyIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCrmCompanysByCompanyIds(@Valid @RequestBody CrmCompanyDeleteListVo crmCompanyDeleteListVo){
        crmCompanyService.deleteCrmCompanysByCompanyIds(crmCompanyDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据companyId获取CRM企业信息
     * @param companyId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "findCrmCompanyByCompanyId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmCompanyByCompanyId(String companyId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(crmCompanyService.findCrmCompanyByCompanyId(companyId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据certifNo获取CRM企业信息
     * @param certifNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "findCrmCompanyByCertifNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmCompanyByCertifNo(String certifNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(crmCompanyService.findCrmCompanyByCertifNo(certifNo)), HttpStatus.OK);
    }

}
