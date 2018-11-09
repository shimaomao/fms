package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.DeferTaskService;
import cn.com.leadu.fms.postbiz.validator.defertask.vo.*;
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
 * @ClassName: DeferTaskController
 * @Description: 合同展期相关接口
 */
@RestController
@RequestMapping("defer_task")
public class DeferTaskController {

    /**
     * @Fields  : 合同展期service
     */
    @Autowired
    private DeferTaskService deferTaskService;

    /**
     * @Title:
     * @Description:  根据contNo获取展期合同的当前合同信息
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @RequestMapping(value = "findDeferTaskVoByContNo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findDeferTaskVoByContNo(@Valid @RequestBody DeferTaskVo deferTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(deferTaskService.findDeferTaskVoByContNo(deferTaskVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  提交合同展期申请
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:15
     */
    @RequestMapping(value = "submitDeferTaskApply",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> submitDeferTaskApply(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.submitDeferTaskApply(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  合同展期审批
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:15
     */
    @RequestMapping(value = "submitDeferTaskApprove",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> submitDeferTaskApprove(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.submitDeferTaskApprove(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  展期合同生成
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:15
     */
    @RequestMapping(value = "generateDeferContract",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> generateDeferContract(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.generateDeferContract(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  展期合同打印
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:15
     */
    @RequestMapping(value = "printDeferContract",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> printDeferContract(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.printDeferContract(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  展期合同审核
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:15
     */
    @RequestMapping(value = "approveDeferContract",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approveDeferContract(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.approveDeferContract(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description:  展期财务审核
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:15
     */
    @RequestMapping(value = "submitFinanceApprove",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> submitFinanceApprove(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.submitFinanceApprove(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description:  展期总经理审核
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:15
     */
    @RequestMapping(value = "submitManagerApprove",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> submitManagerApprove(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.submitManagerApprove(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description:  合同展期审批退回上一级
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:15
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.sendBack(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  打印付款单
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:15
     */
    @RequestMapping(value = "printPaymentOrder",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPaymentOrder(@Valid @RequestBody DeferTaskVo deferTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(deferTaskService.printPaymentOrder(deferTaskVo)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:  根据contNo获取展期合同任务表的合同
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @RequestMapping(value = "findOldDeferTaskVoByContNo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findOldDeferTaskVoByContNo(@Valid @RequestBody DeferTaskVo deferTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(deferTaskService.findOldDeferTaskVoByContNo(deferTaskVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取展期任务表的信息
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @RequestMapping(value = "findDeferTaskByTaskNo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findDeferTaskByTaskNo(@Valid @RequestBody DeferTaskVo deferTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(deferTaskService.findDeferTaskByTaskNo(deferTaskVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  合同展期审批拒绝
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-9 14:35:15
     */
    @RequestMapping(value = "goRefuse",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> goRefuse(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferTaskService.goRefuse(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
