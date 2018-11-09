package cn.com.leadu.fms.prebiz.controller;/**
 * Created by ningyangyang on 2018/9/11.
 */

import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ChangeLesseeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/9/11 18:49
 */
@RestController
@RequestMapping("change_lessee_task")
public class ChangeLesseeTaskController {

    /**
     * @Fields  : 变更承租人service
     */
    @Autowired
    private ChangeLesseeTaskService changeLesseeTaskService;

    /**
     * @Title:
     * @Description: 暂存变更承租人信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-11 14:55:49
     */
    @RequestMapping(value = "saveApplyInputVo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyInputVo(@RequestBody ApplyInputVo applyInputVo,@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(changeLesseeTaskService.saveApplyInputVo(applyInputVo,sysUser)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 提交变更承租人信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-11 14:55:49
     */
    @RequestMapping(value = "submitApplyInputVo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitApplyInputVo(@RequestBody ApplyInputVo applyInputVo, @AuthUserInfo SysUser sysUser){
        changeLesseeTaskService.submitApplyInputVo(applyInputVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取客户的所有基本信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-11 14:55:49
     */
    @RequestMapping(value = "findApplyInputVoByApplyNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInputVoByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(changeLesseeTaskService.findApplyInputVoByApplyNo(applyNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取风控审批用申请录入信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 14:55:49
     */
    @RequestMapping(value = "findApplyInputRiskByTaskNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInputRiskByTaskNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(changeLesseeTaskService.findApplyInputRiskByTaskNo(applyNo)), HttpStatus.OK);
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

}
