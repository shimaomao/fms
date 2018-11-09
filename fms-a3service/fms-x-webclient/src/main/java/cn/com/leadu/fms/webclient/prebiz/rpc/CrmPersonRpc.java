package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.crmperson.CrmPersonVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: CrmPersonController
 * @Description: CRM个人信息rpc
 * @date 2018-05-23
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CrmPersonRpc {

    /**
     * @Title:
     * @Description: 分页查询CRM个人信息信息
     * @param crmPersonVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "api/prebiz/crm_person/findCrmPersonsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCrmPersonsByPage(@RequestParam Map<String, Object> crmPersonVoMap);

    /**
     * @Title:
     * @Description: 保存CRM个人信息
     * @param crmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "api/prebiz/crm_person/saveCrmPerson",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCrmPerson(@RequestBody CrmPersonVo crmPersonVo);

    /**
     * @Title:
     * @Description:  修改CRM个人信息
     * @param crmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "api/prebiz/crm_person/modifyCrmPerson",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCrmPerson(@RequestBody CrmPersonVo crmPersonVo);

    /**
     * @Title:
     * @Description:   根据personId集合删除CRM个人信息
     * @param crmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "api/prebiz/crm_person/deleteCrmPersonsByPersonIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCrmPersonsByPersonIds(@RequestBody CrmPersonVo crmPersonVo);

    /**
     * @Title:
     * @Description:  根据personId获取CRM个人信息
     * @param personId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "api/prebiz/crm_person/findCrmPersonByPersonId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCrmPersonByPersonId(@RequestParam("personId") String personId);

    /**
     * @Title:
     * @Description:  根据证件号码获取CRM个人信息
     * @param certifNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "api/prebiz/crm_person/findCrmPersonByCertifNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCrmPersonByCertifNo(@RequestParam("certifNo") String certifNo);

}
