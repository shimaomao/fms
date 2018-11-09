package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import cn.com.leadu.fms.postbiz.service.LicenseIdxService;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author license_idx
 * @ClassName: LicenseIdxController
 * @Description: 指标管理表相关接口
 */
@RestController
@RequestMapping("license_idx")
public class LicenseIdxController {

    /**
     * @Fields  : 指标管理表service
     */
    @Autowired
    private LicenseIdxService licenseIdxService;

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
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(licenseIdxService.findLicenseIdxVosByPage(licenseIdxVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存指标管理表
     * @param licenseIdxSaveVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "saveLicenseIdx",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveLicenseIdx(@Valid @RequestBody LicenseIdxSaveVo licenseIdxSaveVo){
        licenseIdxService.saveLicenseIdx(licenseIdxSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改指标管理表
     * @param licenseIdxModifyVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "modifyLicenseIdx",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyLicenseIdx(@Valid @RequestBody LicenseIdxModifyVo licenseIdxModifyVo){
        licenseIdxService.modifyLicenseIdx(licenseIdxModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除指标管理表
     * @param licenseIdxDeleteVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "deleteLicenseIdx",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteLicenseIdx(@Valid @RequestBody LicenseIdxDeleteVo licenseIdxDeleteVo){
        licenseIdxService.deleteLicenseIdx(licenseIdxDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据licenseIdxId集合删除指标管理表
     * @param licenseIdxDeleteListVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @RequestMapping(value = "deleteLicenseIdxsByLicenseIdxIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteLicenseIdxsByLicenseIdxIds(@Valid @RequestBody LicenseIdxDeleteListVo licenseIdxDeleteListVo){
        licenseIdxService.deleteLicenseIdxsByLicenseIdxIds(licenseIdxDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(licenseIdxService.findLicenseIdxByLicenseIdxId(licenseIdxId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据licenseIdxId获取指标管理表
     * @param licenseIdxId
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-12 11:38:16
     */
    @RequestMapping(value = "findLicenseIdxVoByLicenseIdxId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLicenseIdxVoByLicenseIdxId(String licenseIdxId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(licenseIdxService.findLicenseIdxVoByLicenseIdxId(licenseIdxId)), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(licenseIdxService.checkLicenseIdxVoBylicenseIdxNo(licenseIdxNo)), HttpStatus.OK);
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
        licenseIdxService.modifyLicenseIdxVoBylicenseIdx(licenseIdxId,licenseIdxzt);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据用户代码查询未使用指标信息
     * @throws
     * @author license_idx
     * @date 2018-9-20 11:38:16
     */
    @RequestMapping(value = "findLicenseIdxVoBylicenseIdxlist", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLicenseIdxVoBylicenseIdxlist(LicenseIdxVo licenseIdxVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(licenseIdxService.findLicenseIdxVoBylicenseIdxlist(licenseIdxVo)), HttpStatus.OK);
    }

}
