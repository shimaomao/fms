package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.contactschange.ContactsChangeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ContactsChangeController
 * @Description: 联系人信息变更rpc
 * @date 2018-09-01
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContactsChangeRpc {

    /**
     * @Title:
     * @Description: 分页查询联系人信息变更信息
     * @param contactsChangeVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "api/postbiz/contacts_change/findContactsChangesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContactsChangesByPage(@RequestParam Map<String, Object> contactsChangeVoMap);

    /**
     * @Title:
     * @Description: 保存联系人信息变更
     * @param contactsChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "api/postbiz/contacts_change/saveContactsChange",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContactsChange(@RequestBody ContactsChangeVo contactsChangeVo);

    /**
     * @Title:
     * @Description:  修改联系人信息变更
     * @param contactsChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "api/postbiz/contacts_change/modifyContactsChange",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContactsChange(@RequestBody ContactsChangeVo contactsChangeVo);

    /**
     * @Title:
     * @Description:   根据contactsChangeId集合删除联系人信息变更
     * @param contactsChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "api/postbiz/contacts_change/deleteContactsChangesByContactsChangeIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContactsChangesByContactsChangeIds(@RequestBody ContactsChangeVo contactsChangeVo);

    /**
     * @Title:
     * @Description:  根据contactsChangeId获取联系人信息变更
     * @param contactsChangeId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @RequestMapping(value = "api/postbiz/contacts_change/findContactsChangeByContactsChangeId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContactsChangeByContactsChangeId(@RequestParam("contactsChangeId") String contactsChangeId);

}
