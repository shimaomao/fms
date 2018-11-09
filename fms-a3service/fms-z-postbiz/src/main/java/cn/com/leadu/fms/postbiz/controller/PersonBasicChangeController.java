package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangePostVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.PersonBasicChangeService;
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
 * @ClassName: PersonBasicChangeController
 * @Description: 个人基本信息变更表相关接口
 * @date 2018-08-31
 */
@RestController
@RequestMapping("person_basic_change")
public class PersonBasicChangeController {

    /**
     * @Fields  : 个人基本信息变更表service
     */
    @Autowired
    private PersonBasicChangeService personBasicChangeService;

    /**
     * @Title:
     * @Description: 分页查询个人基本信息变更表信息
     * @param personBasicChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
//    @RequestMapping(value = "findPersonBasicChangesByPage" ,method = RequestMethod.GET)
//    public ResponseEntity<RestResponse> findPersonBasicChangesByPage(PersonBasicChangeVo personBasicChangeVo){
//        return new ResponseEntity<RestResponse>(
//                RestResponseGenerator.genSuccessResponse(personBasicChangeService.findPersonBasicChangesByPage(personBasicChangeVo)),
//                HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description: 保存个人基本信息变更表
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "savePersonBasicChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> savePersonBasicChange(@Valid @RequestBody PersonBasicChangePostVo personBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        personBasicChangeService.savePersonBasicChange(personBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改个人基本信息变更表
     * @param personBasicChangeModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
//    @RequestMapping(value = "modifyPersonBasicChange",method = RequestMethod.PUT)
//    public ResponseEntity<RestResponse> modifyPersonBasicChange(@Valid @RequestBody PersonBasicChangeModifyVo personBasicChangeModifyVo){
//        personBasicChangeService.modifyPersonBasicChange(personBasicChangeModifyVo);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  删除个人基本信息变更表
     * @param personBasicChangeDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
//    @RequestMapping(value = "deletePersonBasicChange",method = RequestMethod.DELETE)
//    public ResponseEntity<RestResponse> deletePersonBasicChange(@Valid @RequestBody PersonBasicChangeDeleteVo personBasicChangeDeleteVo){
//        personBasicChangeService.deletePersonBasicChange(personBasicChangeDeleteVo);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:   根据personChangeId集合删除个人基本信息变更表
     * @param personBasicChangeDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
//    @RequestMapping(value = "deletePersonBasicChangesByPersonChangeIds" , method = RequestMethod.DELETE)
//    public ResponseEntity<RestResponse> deletePersonBasicChangesByPersonChangeIds(@Valid @RequestBody PersonBasicChangeDeleteListVo personBasicChangeDeleteListVo){
//        personBasicChangeService.deletePersonBasicChangesByPersonChangeIds(personBasicChangeDeleteListVo);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  根据personChangeId获取个人基本信息变更表
     * @param personChangeId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
//    @RequestMapping(value = "findPersonBasicChangeByPersonChangeId", method = RequestMethod.GET)
//    public ResponseEntity<RestResponse> findPersonBasicChangeByPersonChangeId(String personChangeId){
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(personBasicChangeService.findPersonBasicChangeByPersonChangeId(personChangeId)), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  根据personTaskNo获取个人基本信息变更表
     * @param personTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "findCstmPersonByTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersonByTaskNo(String personTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(personBasicChangeService.findCstmPersonByTaskNo(personTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据personTaskNo获取个人基本信息
     * @param applyNo
     * @param personTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "findApplyCstmPersonByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(String applyNo, String personTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(personBasicChangeService.findApplyCstmPersonByApplyNo(applyNo, personTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管审核通过
     * @param personBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "personBasicChangeApproval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> personBasicChangeApproval(@Valid @RequestBody PersonBasicChangePostVo personBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        personBasicChangeService.personBasicChangeApproval(personBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管审核退回
     * @param personBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "personBasicChangeBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> personBasicChangeBack(@Valid @RequestBody PersonBasicChangePostVo personBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        personBasicChangeService.personBasicChangeBack(personBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管复核通过
     * @param personBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "personBasicChangeReview",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> personBasicChangeReview(@Valid @RequestBody PersonBasicChangePostVo personBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        personBasicChangeService.personBasicChangeReview(personBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管审核退回
     * @param personBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "personBasicChangeReviewBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> personBasicChangeReviewBack(@Valid @RequestBody PersonBasicChangePostVo personBasicChangePostVo, @AuthUserInfo SysUser sysUser){
        personBasicChangeService.personBasicChangeReviewBack(personBasicChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
