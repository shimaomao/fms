package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.contactschange.ContactsChangeVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.ContactsChangeRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ContactsChangeController
 * @Description: 联系人信息变更controller
 * @date 2018-09-01
 */
@RestController
@RequestMapping("contacts_change")
public class ContactsChangeController {

    /**
     * @Fields  : 联系人信息变更rpc
     */
    @Autowired
    private ContactsChangeRpc contactsChangeRpc;

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
        Map contactsChangeVoMap = contactsChangeVo == null?null:(Map) JSON.toJSON(contactsChangeVo);
        return contactsChangeRpc.findContactsChangesByPage(contactsChangeVoMap);
    }

    /**
     * @Title:
     * @Description: 保存联系人信息变更
     * @param contactsChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "saveContactsChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContactsChange(@RequestBody ContactsChangeVo contactsChangeVo){
        return contactsChangeRpc.saveContactsChange(contactsChangeVo);
    }

    /**
     * @Title:
     * @Description:  修改联系人信息变更
     * @param contactsChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "modifyContactsChange",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContactsChange(@RequestBody ContactsChangeVo contactsChangeVo){
        return contactsChangeRpc.modifyContactsChange(contactsChangeVo);
    }

    /**
     * @Title:
     * @Description:   根据contactsChangeId集合删除联系人信息变更
     * @param contactsChangeIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "deleteContactsChangesByContactsChangeIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContactsChangesByContactsChangeIds(@RequestBody List<String> contactsChangeIds){
        ContactsChangeVo contactsChangeVo = new ContactsChangeVo();
        contactsChangeVo.setContactsChangeIds(contactsChangeIds);
        return contactsChangeRpc.deleteContactsChangesByContactsChangeIds(contactsChangeVo);
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
        return contactsChangeRpc.findContactsChangeByContactsChangeId(contactsChangeId);
    }

}
