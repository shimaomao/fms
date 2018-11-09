package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcontact.CstmContactVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: CstmContactController
 * @Description: 客户联系人信息rpc
 * @date 2018-03-27
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CstmContactRpc {

    /**
     * @Title:
     * @Description: 分页查询客户联系人信息信息
     * @param cstmContactVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    @RequestMapping(value = "api/prebiz/cstm_contact/findCstmContactsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmContactsByPage(@RequestParam Map<String, Object> cstmContactVoMap);

    /**
     * @Title:
     * @Description: 保存客户联系人信息
     * @param cstmContactVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    @RequestMapping(value = "api/prebiz/cstm_contact/saveCstmContact",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCstmContact(@RequestBody CstmContactVo cstmContactVo);

    /**
     * @Title:
     * @Description:  修改客户联系人信息
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    @RequestMapping(value = "api/prebiz/cstm_contact/modifyCstmContact",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCstmContact(@RequestBody CstmContactVo cstmContactVo);

    /**
     * @Title:
     * @Description:   根据contactId集合删除客户联系人信息
     * @param contactIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    @RequestMapping(value = "api/system/cstm_contact/deleteCstmContactsByContactIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCstmContactsByContactIds(@RequestBody CstmContactVo cstmContactVo);

    /**
     * @Title:
     * @Description:  根据contactId获取客户联系人信息
     * @param contactId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    @RequestMapping(value = "api/prebiz/cstm_contact/findCstmContactByContactId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmContactByContactId(@RequestParam("contactId") String contactId);

}
