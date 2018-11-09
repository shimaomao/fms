package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskSearchVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.LawsuitTaskService;
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
 * @ClassName: LawsuitTaskController
 * @Description: 诉讼任务信息相关接口
 */
@RestController
@RequestMapping("lawsuit_task")
public class LawsuitTaskController {

    /**
     * @Fields  : 诉讼任务信息service
     */
    @Autowired
    private LawsuitTaskService lawsuitTaskService;

    /**
     * @Title:
     * @Description: 分页查询诉讼任务信息信息
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "findLawsuitTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitTasksByPage(LawsuitTaskSearchVo lawsuitTaskSearchVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(lawsuitTaskService.findLawsuitTasksByPage(lawsuitTaskSearchVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据lawsuitTaskNo获取诉讼任务信息
     * @param lawsuitTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "findLawsuitTasksByTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitTasksByTaskNo(String lawsuitTaskNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(lawsuitTaskService.findLawsuitTasksByTaskNo(lawsuitTaskNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据lawsuitTaskNo获取诉讼登记信息
     * @param lawsuitTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "findLawsuitRegistersByTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitRegistersByTaskNo(String lawsuitTaskNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(lawsuitTaskService.findLawsuitRegistersByTaskNo(lawsuitTaskNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据overdueContId获取诉讼基本信息
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "findLawsuitTasksByOverdueContId" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitTasksByOverdueContId(String overdueContId){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(lawsuitTaskService.findLawsuitTasksByOverdueContId(overdueContId)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据overdueContId获取逾期客户Id
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "findOverdueCstmIdByOverdueContId" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmIdByOverdueContId(String overdueContId){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(lawsuitTaskService.findOverdueCstmIdByOverdueContId(overdueContId)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 诉讼任务申请发起
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "saveLawsuitTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveLawsuitTask(@Valid @RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo, @AuthUserInfo SysUser sysUser){
        lawsuitTaskService.saveLawsuitTask(lawsuitTaskSearchVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 校验合同是否存在未结束的任务
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "isLawsuitTaskExit",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> isLawsuitTaskExit(String overdueContId){
        lawsuitTaskService.isLawsuitTaskExit(overdueContId);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 风控经理审核通过
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "lawsuitApproval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawsuitApproval(@Valid @RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo, @AuthUserInfo SysUser sysUser){
        lawsuitTaskService.lawsuitApproval(lawsuitTaskSearchVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 退回
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "lawsuitBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawsuitBack(@Valid @RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo, @AuthUserInfo SysUser sysUser){
        lawsuitTaskService.lawsuitBack(lawsuitTaskSearchVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 拒绝
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "lawsuitRefuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawsuitRefuse(@Valid @RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo, @AuthUserInfo SysUser sysUser){
        lawsuitTaskService.lawsuitRefuse(lawsuitTaskSearchVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 诉讼任务登记暂存
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "registerTemporary",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> registerTemporary(@Valid @RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo){
        lawsuitTaskService.registerTemporary(lawsuitTaskSearchVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 诉讼任务登记暂存
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @RequestMapping(value = "registerSave",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> registerSave(@Valid @RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo, @AuthUserInfo SysUser sysUser){
        lawsuitTaskService.registerSave(lawsuitTaskSearchVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }


}
