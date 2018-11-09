package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.ChangeLesseeService;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeTaskController
 * @Description: 承租人变更相关接口
 */
@RestController
@RequestMapping("change_lessee_task")
public class ChangeLesseeTaskController {

    /**
     * @Fields  : 承租人变更service
     */
    @Autowired
    private ChangeLesseeService changeLesseeTaskService;


    /**
     * @Title:
     * @Description:  根据contNo获取承租人变更
     * @param contNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-17 15:14:53
     */
    @RequestMapping(value = "findChangeLesseeTaskByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findChangeLesseeTaskByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(changeLesseeTaskService.findChangeLesseeTaskByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 承租人变更风控复审
     * @param applyRiskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:53
     */
    @RequestMapping(value = "submitRiskApprove",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitRiskApprove(@Valid @RequestBody ApplyRiskVo applyRiskVo, @AuthUserInfo SysUser sysUser){
        changeLesseeTaskService.submitRiskApprove(applyRiskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 承租人变更合同生成
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:53
     */
    @RequestMapping(value = "changeContGenerate",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> changeContGenerate(@Valid @RequestBody ChangeLesseeTaskVo changeLesseeTaskVo, @AuthUserInfo SysUser sysUser){
        changeLesseeTaskService.changeContGenerate(changeLesseeTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 承租人变更合同打印
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:53
     */
    @RequestMapping(value = "changeContPrint",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> changeContPrint(@Valid @RequestBody ChangeLesseeTaskVo changeLesseeTaskVo, @AuthUserInfo SysUser sysUser){
        changeLesseeTaskService.changeContPrint(changeLesseeTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 承租人变更合同审核
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:53
     */
    @RequestMapping(value = "changeContApprove",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> changeContApprove(@Valid @RequestBody ChangeLesseeTaskVo changeLesseeTaskVo, @AuthUserInfo SysUser sysUser){
        changeLesseeTaskService.changeContApprove(changeLesseeTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 承租人变更退回上一级
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-15 15:14:53
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ChangeLesseeTaskVo changeLesseeTaskVo, @AuthUserInfo SysUser sysUser){
        changeLesseeTaskService.sendBack(changeLesseeTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 承租人变更拒绝
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-9 15:14:53
     */
    @RequestMapping(value = "goRefuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> goRefuse(@Valid @RequestBody ChangeLesseeTaskVo changeLesseeTaskVo, @AuthUserInfo SysUser sysUser){
        changeLesseeTaskService.goRefuse(changeLesseeTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
