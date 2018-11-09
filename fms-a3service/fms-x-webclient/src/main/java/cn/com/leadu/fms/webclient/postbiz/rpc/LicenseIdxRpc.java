package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author license_idx
 * @ClassName: LicenseIdxController
 * @Description: 指标管理表rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface LicenseIdxRpc {

    /**
     * @Title:
     * @Description: 分页查询指标管理表信息
     * @param licenseIdxVoMap
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/findLicenseIdxsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLicenseIdxsByPage(@RequestParam Map<String, Object> licenseIdxVoMap);

    /**
     * @Title:
     * @Description: 保存指标管理表
     * @param licenseIdxVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/saveLicenseIdx",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveLicenseIdx(@RequestBody LicenseIdxVo licenseIdxVo);

    /**
     * @Title:
     * @Description:  修改指标管理表
     * @param licenseIdxVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/modifyLicenseIdx",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyLicenseIdx(@RequestBody LicenseIdxVo licenseIdxVo);

    /**
     * @Title:
     * @Description:   根据licenseIdxId集合删除指标管理表
     * @param licenseIdxVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/deleteLicenseIdxsByLicenseIdxIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteLicenseIdxsByLicenseIdxIds(@RequestBody LicenseIdxVo licenseIdxVo);

    /**
     * @Title:
     * @Description:  根据licenseIdxId获取指标管理表
     * @param licenseIdxId
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/findLicenseIdxByLicenseIdxId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLicenseIdxByLicenseIdxId(@RequestParam("licenseIdxId") String licenseIdxId);


    /**
     * @Title:
     * @Description:  根据licenseIdxId获取指标管理表
     * @param licenseIdxId
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-12 13:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/findLicenseIdxVoByLicenseIdxId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLicenseIdxVoByLicenseIdxId(@RequestParam("licenseIdxId") String licenseIdxId);

    /**
     * @Title:
     * @Description:  根据licenseIdxNo获取指标管理表是否存在
     * @param licenseIdxNo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-13 11:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/checkLicenseIdxVoBylicenseIdxNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> checkLicenseIdxVoBylicenseIdxNo(@RequestParam("licenseIdxNo") String licenseIdxNo);

    /**
     * @Title:
     * @Description:  修改指标管理表
     * @param licenseIdxId
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-13 11:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/modifyLicenseIdxVoBylicenseIdx",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyLicenseIdxVoBylicenseIdx(@RequestParam("licenseIdxId") String licenseIdxId, @RequestParam("licenseIdxzt") String licenseIdxzt);

    /**
     * @Title:
     * @Description: 分页查询指标管理表信息
     * @param licenseIdxVoMap
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "api/postbiz/license_idx/findLicenseIdxVoBylicenseIdxlist" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLicenseIdxVoBylicenseIdxlist(@RequestParam Map<String, Object> licenseIdxVoMap);
}
