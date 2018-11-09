package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.companybasicchange.CompanyBasicChangePostVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.CompanyBasicChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeController
 * @Description: 企业基本信息变更相关接口
 * @date 2018-09-01
 */
@RestController
@RequestMapping("company_basic_change")
public class CompanyBasicChangeController {

    /**
     * @Fields  : 企业基本信息变更service
     */
    @Autowired
    private CompanyBasicChangeService companyBasicChangeService;

    /**
     * @Title:
     * @Description: 保存企业基本信息变更
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:35
     */
    @RequestMapping(value = "saveCompanyBasicChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCompanyBasicChange(@Valid @RequestBody CompanyBasicChangePostVo companyBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        companyBasicChangeService.saveCompanyBasicChange(companyBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据companyTaskNo获取企业基本信息变更
     * @param companyTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:35
     */
    @RequestMapping(value = "findCstmCompanyByTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmCompanyByTaskNo(String companyTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(companyBasicChangeService.findCstmCompanyByTaskNo(companyTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据companyTaskNo获取企业基本信息变更
     * @param applyNo
     * @param companyTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:35
     */
    @RequestMapping(value = "findApplyCstmPersonByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(String applyNo, String companyTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(companyBasicChangeService.findApplyCstmPersonByApplyNo(applyNo, companyTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管审核通过
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "companyBasicChangeApproval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> companyBasicChangeApproval(@Valid @RequestBody CompanyBasicChangePostVo companyBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        companyBasicChangeService.companyBasicChangeApproval(companyBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管审核退回
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "companyBasicChangeBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> companyBasicChangeBack(@Valid @RequestBody CompanyBasicChangePostVo companyBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        companyBasicChangeService.companyBasicChangeBack(companyBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管复核通过
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "companyBasicChangeReview",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> companyBasicChangeReview(@Valid @RequestBody CompanyBasicChangePostVo companyBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        companyBasicChangeService.companyBasicChangeReview(companyBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管复核退回
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "companyBasicChangeReviewBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> companyBasicChangeReviewBack(@Valid @RequestBody CompanyBasicChangePostVo companyBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        companyBasicChangeService.companyBasicChangeReviewBack(companyBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
