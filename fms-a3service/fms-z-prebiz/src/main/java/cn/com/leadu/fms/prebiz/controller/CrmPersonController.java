package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.crmperson.CrmPersonVo;
import cn.com.leadu.fms.prebiz.service.CrmPersonService;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.*;
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
 * @ClassName: CrmPersonController
 * @Description: CRM个人信息相关接口
 * @date 2018-05-23
 */
@RestController
@RequestMapping("crm_person")
public class CrmPersonController {

    /**
     * @Fields  : CRM个人信息service
     */
    @Autowired
    private CrmPersonService crmPersonService;

    /**
     * @Title:
     * @Description: 分页查询CRM个人信息信息
     * @param crmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:07
     */
    @RequestMapping(value = "findCrmPersonsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmPersonsByPage(CrmPersonVo crmPersonVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(crmPersonService.findCrmPersonsByPage(crmPersonVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存CRM个人信息
     * @param crmPersonSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:07
     */
    @RequestMapping(value = "saveCrmPerson",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCrmPerson(@Valid @RequestBody CrmPersonSaveVo crmPersonSaveVo){
        crmPersonService.saveCrmPerson(crmPersonSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改CRM个人信息
     * @param crmPersonModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:07
     */
    @RequestMapping(value = "modifyCrmPerson",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCrmPerson(@Valid @RequestBody CrmPersonModifyVo crmPersonModifyVo){
        crmPersonService.modifyCrmPerson(crmPersonModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除CRM个人信息
     * @param crmPersonDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:07
     */
    @RequestMapping(value = "deleteCrmPerson",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCrmPerson(@Valid @RequestBody CrmPersonDeleteVo crmPersonDeleteVo){
        crmPersonService.deleteCrmPerson(crmPersonDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据personId集合删除CRM个人信息
     * @param crmPersonDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:07
     */
    @RequestMapping(value = "deleteCrmPersonsByPersonIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCrmPersonsByPersonIds(@Valid @RequestBody CrmPersonDeleteListVo crmPersonDeleteListVo){
        crmPersonService.deleteCrmPersonsByPersonIds(crmPersonDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据personId获取CRM个人信息
     * @param personId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:07
     */
    @RequestMapping(value = "findCrmPersonByPersonId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmPersonByPersonId(String personId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(crmPersonService.findCrmPersonByPersonId(personId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据证件号码取CRM个人信息
     * @param certifNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 17:28:07
     */
    @RequestMapping(value = "findCrmPersonByCertifNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmPersonByCertifNo(String certifNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(crmPersonService.findCrmPersonByCertifNo(certifNo)), HttpStatus.OK);
    }
}
