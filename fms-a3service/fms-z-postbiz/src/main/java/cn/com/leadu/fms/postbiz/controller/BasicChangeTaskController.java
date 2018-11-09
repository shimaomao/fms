package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.*;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.postbiz.service.BasicChangeTaskService;
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
 * @ClassName: BasicChangeTaskController
 * @Description: 基本信息变更任务相关接口
 * @date 2018-08-31
 */
@RestController
@RequestMapping("basic_change_task")
public class BasicChangeTaskController {

    /**
     * @Fields  : 基本信息变更任务service
     */
    @Autowired
    private BasicChangeTaskService basicChangeTaskService;

    /**
     * @Description: 分页查询合同信息一览
     * @param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/28 11:31
     */
    @RequestMapping(value="findContractListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractListByPage(ValidContractChangeVo validContractChangeVo, @AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basicChangeTaskService.findContractListByPage(validContractChangeVo,sysUser)), HttpStatus.OK);
    }

    /**
     * @Description: 生效合同变更查询
     * @param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/28 11:31
     */
    @RequestMapping(value="findBasicChangeTaskListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasicChangeTaskListByPage(BasicChangeTaskVo basicChangeTaskVo, @AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basicChangeTaskService.findBasicChangeTaskListByPage(basicChangeTaskVo,sysUser)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: check该客户是否存在未结束的基本信息变更任务
     * @param basicChangeTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:10:59
     */
    @RequestMapping(value = "checkBasicChangeTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> checkBasicChangeTask(@Valid @RequestBody BasicChangeTaskVo basicChangeTaskVo){
        basicChangeTaskService.checkBasicChangeTask(basicChangeTaskVo.getApplyNo());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: check该任务是否能被取消
     * @param basicChangeTaskCancelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:10:59
     */
    @RequestMapping(value = "isTaskCanBeCancel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> isTaskCanBeCancel(@Valid @RequestBody BasicChangeTaskCancelVo basicChangeTaskCancelVo, @AuthUserInfo SysUserVo sysUser){
        basicChangeTaskService.isTaskCanBeCancel(basicChangeTaskCancelVo.getBasicTaskNo(), sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 基本信息变更取消
     * @param basicChangeTaskCancelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:10:59
     */
    @RequestMapping(value = "basicChangeTaskCancel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> basicChangeTaskCancel(@Valid @RequestBody BasicChangeTaskCancelVo basicChangeTaskCancelVo, @AuthUserInfo SysUserVo sysUser){
        basicChangeTaskService.basicChangeTaskCancel(basicChangeTaskCancelVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询指定申请编号的企业基本信息变更历史任务
     * @param vo 参数
     * @return PageInfoExtend<BasicChangeCompHistoryVo>
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "findBasicCompChangeHistory",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasicCompChangeHistory(BasicChangeCompHistoryVo vo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basicChangeTaskService.findBasicCompChangeHistory(vo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询指定申请编号的个人基本信息变更历史任务
     * @param vo 参数
     * @return PageInfoExtend<BasicChangePersHistoryVo>
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "findBasicPersChangeHistory",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasicPersChangeHistory(BasicChangePersHistoryVo vo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basicChangeTaskService.findBasicPersChangeHistory(vo)), HttpStatus.OK);
    }

    /**
     * 获取展期、增加保证金、变更承租人变更任务号
     * @param contNo 合同号
     * @return
     */
    @RequestMapping(value = "findChangeInfo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findChangeInfo(String contNo) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basicChangeTaskService.findChangeInfo(contNo)), HttpStatus.OK);
    }

    /**
     * 获取基本信息变更取消内容
     * @param basicTaskNo 变更任务号
     * @return
     */
    @RequestMapping(value = "findBasicChangeCancelVo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasicChangeCancelVo(String basicTaskNo, @AuthUserInfo SysUserVo sysUser) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basicChangeTaskService.findBasicChangeCancelVo(basicTaskNo, sysUser)), HttpStatus.OK);
    }

}
