package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.crmcompany.CrmCompanyVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.CrmCompanyRpc;
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
 * @author ningyangyang
 * @ClassName: CrmCompanyController
 * @Description: CRM企业信息controller
 * @date 2018-05-23
 */
@RestController
@RequestMapping("crm_company")
public class CrmCompanyController {

    /**
     * @Fields  : CRM企业信息rpc
     */
    @Autowired
    private CrmCompanyRpc crmCompanyRpc;

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
        Map crmCompanyVoMap = crmCompanyVo == null?null:(Map) JSON.toJSON(crmCompanyVo);
        return crmCompanyRpc.findCrmCompanysByPage(crmCompanyVoMap);
    }

    /**
     * @Title:
     * @Description: 保存CRM企业信息
     * @param crmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "saveCrmCompany",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCrmCompany(@RequestBody CrmCompanyVo crmCompanyVo){
        return crmCompanyRpc.saveCrmCompany(crmCompanyVo);
    }

    /**
     * @Title:
     * @Description:  修改CRM企业信息
     * @param crmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "modifyCrmCompany",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCrmCompany(@RequestBody CrmCompanyVo crmCompanyVo){
        return crmCompanyRpc.modifyCrmCompany(crmCompanyVo);
    }

    /**
     * @Title:
     * @Description:   根据companyId集合删除CRM企业信息
     * @param companyIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "deleteCrmCompanysByCompanyIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCrmCompanysByCompanyIds(@RequestBody List<String> companyIds){
        CrmCompanyVo crmCompanyVo = new CrmCompanyVo();
        crmCompanyVo.setCompanyIds(companyIds);
        return crmCompanyRpc.deleteCrmCompanysByCompanyIds(crmCompanyVo);
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
        return crmCompanyRpc.findCrmCompanyByCompanyId(companyId);
    }

    /**
     * @Title:
     * @Description:  根据companyId获取CRM企业信息
     * @param certifNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @RequestMapping(value = "findCrmCompanyByCertifNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmCompanyByCertifNo(String certifNo){
        return crmCompanyRpc.findCrmCompanyByCertifNo(certifNo);
    }

}
