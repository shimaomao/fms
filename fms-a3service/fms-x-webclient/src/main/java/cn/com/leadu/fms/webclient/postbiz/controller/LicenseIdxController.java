package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.LicenseIdxRpc;
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
 * @author license_idx
 * @ClassName: LicenseIdxController
 * @Description: 指标管理表controller
 */
@RestController
@RequestMapping("license_idx")
public class LicenseIdxController {

    /**
     * @Fields  : 指标管理表rpc
     */
    @Autowired
    private LicenseIdxRpc licenseIdxRpc;

    /**
     * @Title:
     * @Description: 分页查询指标管理表信息
     * @param licenseIdxVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "findLicenseIdxsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLicenseIdxsByPage(LicenseIdxVo licenseIdxVo){
        Map licenseIdxVoMap = licenseIdxVo == null?null:(Map) JSON.toJSON(licenseIdxVo);
        return licenseIdxRpc.findLicenseIdxsByPage(licenseIdxVoMap);
    }

    /**
     * @Title:
     * @Description: 保存指标管理表
     * @param licenseIdxVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "saveLicenseIdx",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveLicenseIdx(@RequestBody LicenseIdxVo licenseIdxVo){
        return licenseIdxRpc.saveLicenseIdx(licenseIdxVo);
    }

    /**
     * @Title:
     * @Description:  修改指标管理表
     * @param licenseIdxVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "modifyLicenseIdx",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyLicenseIdx(@RequestBody LicenseIdxVo licenseIdxVo){
        return licenseIdxRpc.modifyLicenseIdx(licenseIdxVo);
    }

    /**
     * @Title:
     * @Description:   根据licenseIdxId集合删除指标管理表
     * @param licenseIdxIds
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "deleteLicenseIdxsByLicenseIdxIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteLicenseIdxsByLicenseIdxIds(@RequestBody List<String> licenseIdxIds){
        LicenseIdxVo licenseIdxVo = new LicenseIdxVo();
        licenseIdxVo.setLicenseIdxIds(licenseIdxIds);
        return licenseIdxRpc.deleteLicenseIdxsByLicenseIdxIds(licenseIdxVo);
    }

    /**
     * @Title:
     * @Description:  根据licenseIdxId获取指标管理表
     * @param licenseIdxId
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "findLicenseIdxByLicenseIdxId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLicenseIdxByLicenseIdxId(String licenseIdxId){
        return licenseIdxRpc.findLicenseIdxByLicenseIdxId(licenseIdxId);
    }

    /**
     * @Title:
     * @Description:  根据licenseIdxId获取指标管理表
     * @param licenseIdxId
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-12 13:38:16
     */
    @RequestMapping(value = "findLicenseIdxVoByLicenseIdxId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLicenseIdxVoByLicenseIdxId(String licenseIdxId){
        return licenseIdxRpc.findLicenseIdxVoByLicenseIdxId(licenseIdxId);
    }

    /**
     * @Title:
     * @Description:  根据licenseIdxNo获取指标管理表是否存在
     * @param licenseIdxNo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-13 11:38:16
     */
    @RequestMapping(value = "checkLicenseIdxVoBylicenseIdxNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> checkLicenseIdxVoBylicenseIdxNo(String licenseIdxNo){
        return licenseIdxRpc.checkLicenseIdxVoBylicenseIdxNo(licenseIdxNo);
    }

    /**
     * @Title:
     * @Description:  修改指标管理表
     * @param licenseIdxId
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-13 11:38:16
     */
    @RequestMapping(value = "modifyLicenseIdxVoBylicenseIdx",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyLicenseIdxVoBylicenseIdx(String licenseIdxId,String licenseIdxzt){
        return licenseIdxRpc.modifyLicenseIdxVoBylicenseIdx(licenseIdxId,licenseIdxzt);
    }

    /**
     * @Title:
     * @Description: 分页查询指标管理表信息
     * @param licenseIdxVo
     * @throws
     * @author license_idx
     * @date 2018-9-20 11:38:16
     */
    @RequestMapping(value = "findLicenseIdxVoBylicenseIdxlist" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLicenseIdxVoBylicenseIdxlist(LicenseIdxVo licenseIdxVo){
        Map licenseIdxVoMap = licenseIdxVo == null?null:(Map) JSON.toJSON(licenseIdxVo);
        return licenseIdxRpc.findLicenseIdxVoBylicenseIdxlist(licenseIdxVoMap);
    }

}
