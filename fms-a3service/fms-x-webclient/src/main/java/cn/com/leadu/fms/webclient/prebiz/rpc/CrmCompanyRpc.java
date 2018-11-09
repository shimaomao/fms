package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.crmcompany.CrmCompanyVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyController
 * @Description: CRM企业信息rpc
 * @date 2018-05-23
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CrmCompanyRpc {

    /**
     * @Title:
     * @Description: 分页查询CRM企业信息信息
     * @param crmCompanyVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "api/prebiz/crm_company/findCrmCompanysByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCrmCompanysByPage(@RequestParam Map<String, Object> crmCompanyVoMap);

    /**
     * @Title:
     * @Description: 保存CRM企业信息
     * @param crmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "api/prebiz/crm_company/saveCrmCompany",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCrmCompany(@RequestBody CrmCompanyVo crmCompanyVo);

    /**
     * @Title:
     * @Description:  修改CRM企业信息
     * @param crmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "api/prebiz/crm_company/modifyCrmCompany",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCrmCompany(@RequestBody CrmCompanyVo crmCompanyVo);

    /**
     * @Title:
     * @Description:   根据companyId集合删除CRM企业信息
     * @param crmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "api/prebiz/crm_company/deleteCrmCompanysByCompanyIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCrmCompanysByCompanyIds(@RequestBody CrmCompanyVo crmCompanyVo);

    /**
     * @Title:
     * @Description:  根据companyId获取CRM企业信息
     * @param companyId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "api/prebiz/crm_company/findCrmCompanyByCompanyId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCrmCompanyByCompanyId(@RequestParam("companyId") String companyId);

    /**
     * @Title:
     * @Description:  根据companyId获取CRM企业信息
     * @param certifNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "api/prebiz/crm_company/findCrmCompanyByCertifNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCrmCompanyByCertifNo(@RequestParam("certifNo") String certifNo);

}
