package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: CstmCompanyController
 * @Description: 客户企业基本信息rpc
 * @date 2018-03-27
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CstmCompanyRpc {

    /**
     * @Title:
     * @Description: 分页查询客户企业基本信息信息
     * @param cstmCompanyVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "api/prebiz/cstm_company/findCstmCompanysByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmCompanysByPage(@RequestParam Map<String, Object> cstmCompanyVoMap);

    /**
     * @Title:
     * @Description: 保存客户企业基本信息
     * @param cstmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "api/prebiz/cstm_company/saveCstmCompany",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCstmCompany(@RequestBody CstmCompanyVo cstmCompanyVo);

    /**
     * @Title:
     * @Description:  修改客户企业基本信息
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "api/prebiz/cstm_company/modifyCstmCompany",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCstmCompany(@RequestBody CstmCompanyVo cstmCompanyVo);

    /**
     * @Title:
     * @Description:   根据cstmCompanyId集合删除客户企业基本信息
     * @param cstmCompanyIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "api/system/cstm_company/deleteCstmCompanysByCstmCompanyIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCstmCompanysByCstmCompanyIds(@RequestBody CstmCompanyVo cstmCompanyVo);

    /**
     * @Title:
     * @Description:  根据cstmCompanyId获取客户企业基本信息
     * @param cstmCompanyId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "api/prebiz/cstm_company/findCstmCompanyByCstmCompanyId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmCompanyByCstmCompanyId(@RequestParam("cstmCompanyId") String cstmCompanyId);

}
