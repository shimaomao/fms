package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.contactschange.ContactsChangeVo;
import cn.com.leadu.fms.postbiz.service.ContactsChangeService;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: ContactsChangeController
 * @Description: 联系人信息变更相关接口
 * @date 2018-09-01
 */
@RestController
@RequestMapping("contacts_change")
public class ContactsChangeController {

    /**
     * @Fields  : 联系人信息变更service
     */
    @Autowired
    private ContactsChangeService contactsChangeService;

    /**
     * @Title:
     * @Description: 分页查询联系人信息变更信息
     * @param contactsChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "findContactsChangesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContactsChangesByPage(ContactsChangeVo contactsChangeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contactsChangeService.findContactsChangesByPage(contactsChangeVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存联系人信息变更
     * @param contactsChangeSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "saveContactsChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContactsChange(@Valid @RequestBody ContactsChangeSaveVo contactsChangeSaveVo){
        contactsChangeService.saveContactsChange(contactsChangeSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改联系人信息变更
     * @param contactsChangeModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "modifyContactsChange",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContactsChange(@Valid @RequestBody ContactsChangeModifyVo contactsChangeModifyVo){
        contactsChangeService.modifyContactsChange(contactsChangeModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除联系人信息变更
     * @param contactsChangeDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "deleteContactsChange",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContactsChange(@Valid @RequestBody ContactsChangeDeleteVo contactsChangeDeleteVo){
        contactsChangeService.deleteContactsChange(contactsChangeDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据contactsChangeId集合删除联系人信息变更
     * @param contactsChangeDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "deleteContactsChangesByContactsChangeIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContactsChangesByContactsChangeIds(@Valid @RequestBody ContactsChangeDeleteListVo contactsChangeDeleteListVo){
        contactsChangeService.deleteContactsChangesByContactsChangeIds(contactsChangeDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contactsChangeId获取联系人信息变更
     * @param contactsChangeId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "findContactsChangeByContactsChangeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContactsChangeByContactsChangeId(String contactsChangeId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contactsChangeService.findContactsChangeByContactsChangeId(contactsChangeId)), HttpStatus.OK);
    }

}
