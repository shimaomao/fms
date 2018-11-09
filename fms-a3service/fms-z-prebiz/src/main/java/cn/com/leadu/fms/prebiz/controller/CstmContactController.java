package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcontact.CstmContactVo;
import cn.com.leadu.fms.prebiz.service.CstmContactService;
import cn.com.leadu.fms.prebiz.validator.cstmcontact.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmContactController
 * @Description: 客户联系人信息相关接口
 * @date 2018-03-27
 */
@RestController
@RequestMapping("cstm_contact")
public class CstmContactController {

    /**
     * @Fields  : 客户联系人信息service
     */
    @Autowired
    private CstmContactService cstmContactService;

    /**
     * @Title:
     * @Description: 分页查询客户联系人信息信息
     * @param cstmContactVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "findCstmContactsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmContactsByPage(CstmContactVo cstmContactVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(cstmContactService.findCstmContactsByPage(cstmContactVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存客户联系人信息
     * @param cstmContactList
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
//    @RequestMapping(value = "saveCstmContact",method = RequestMethod.POST)
//    public ResponseEntity<RestResponse> saveCstmContact(@Valid @RequestBody List<CstmContact> cstmContactList){
//        cstmContactService.saveCstmContact(cstmContactList);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  修改客户联系人信息
     * @param cstmContactModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "modifyCstmContact",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmContact(@Valid @RequestBody CstmContactModifyVo cstmContactModifyVo){
        cstmContactService.modifyCstmContact(cstmContactModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除客户联系人信息
     * @param cstmContactDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "deleteCstmContact",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmContact(@Valid @RequestBody CstmContactDeleteVo cstmContactDeleteVo){
        cstmContactService.deleteCstmContact(cstmContactDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据contactId集合删除客户联系人信息
     * @param cstmContactDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "deleteCstmContactsByContactIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmContactsByContactIds(@Valid @RequestBody CstmContactDeleteListVo cstmContactDeleteListVo){
        cstmContactService.deleteCstmContactsByContactIds(cstmContactDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contactId获取客户联系人信息
     * @param contactId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "findCstmContactByContactId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmContactByContactId(String contactId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(cstmContactService.findCstmContactByContactId(contactId)), HttpStatus.OK);
    }

}
