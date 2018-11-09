package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.RetrieveCarsTaskService;
import cn.com.leadu.fms.postbiz.validator.retrievecarstask.vo.*;
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
 * @ClassName: RetrieveCarsTaskController
 * @Description: 收车任务相关接口
 */
@RestController
@RequestMapping("retrieve_cars_task")
public class RetrieveCarsTaskController {

    /**
     * @Fields  : 收车任务service
     */
    @Autowired
    private RetrieveCarsTaskService retrieveCarsTaskService;

    /**
     * @Title:
     * @Description: 分页查询收车任务信息
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "findRetrieveCarsTaskVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRetrieveCarsTaskVosByPage(RetrieveCarsTaskVo retrieveCarsTaskVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(retrieveCarsTaskService.findRetrieveCarsTaskVosByPage(retrieveCarsTaskVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据retrieveCarId获取收车任务
     * @param retrieveCarId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "findRetrieveCarsTaskByRetrieveCarId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRetrieveCarsTaskByRetrieveCarId(String retrieveCarId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(retrieveCarsTaskService.findRetrieveCarsTaskByRetrieveCarId(retrieveCarId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   发起收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskLaunch", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskLaunch(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskLaunch(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务风控派单
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskRisk", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskRisk(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo,@AuthUserInfo SysUser sysUser) {
        retrieveCarsTaskService.retrieveCarsTaskRisk(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务审批
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskApprove", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskApprove(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo,@AuthUserInfo SysUser sysUser) {
        retrieveCarsTaskService.retrieveCarsTaskApprove(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务详情查询
     * @param retrieveCarId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "findRetrieveCarsTaskVoById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRetrieveCarsTaskVoById(String retrieveCarId) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(retrieveCarsTaskService.findRetrieveCarsTaskVoById(retrieveCarId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据收车任务号获取收车任务
     * @param retrieveCarTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "findRetrieveCarsTaskVoByTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRetrieveCarsTaskVoByTaskNo(String retrieveCarTaskNo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(retrieveCarsTaskService.findRetrieveCarsTaskVoByTaskNo(retrieveCarTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务委派和登记
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskRegister", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskRegister(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskRegister(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务车辆入库
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskStorage", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskStorage(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskStorage(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务确认交接
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskHandover", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskHandover(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskHandover(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务财务审核
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskFinancial", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskFinancial(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskFinancial(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务总经理审核
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskAudit", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskAudit(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskAudit(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务拒绝
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskRefuse", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskRefuse(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskRefuse(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务退回
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskSendBack(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务退回(总经理退回)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskAuditSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskAuditSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskAuditSendBack(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收车任务退回(财务审核退回)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskFinanceSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskFinanceSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo, @AuthUserInfo SysUser sysUser){
        retrieveCarsTaskService.retrieveCarsTaskFinanceSendBack(retrieveCarsTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:  检查是否有正在进行的任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/25 10:34:41
     */
    @RequestMapping(value = "checkRetrieveCarsTask", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> checkRetrieveCarsTask(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(retrieveCarsTaskService.checkRetrieveCarsTask(retrieveCarsTaskVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 委托书下载
     * @param retrieveCarsTaskSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "downLoadLetter",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> downLoadLetter(@Valid @RequestBody RetrieveCarsTaskSaveVo retrieveCarsTaskSaveVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(retrieveCarsTaskService.downLoadLetter(retrieveCarsTaskSaveVo.getRetrieveCarTaskNo())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  收车任务打印付款单
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/25 10:34:41
     */
    @RequestMapping(value = "printPaymentOrder", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPaymentOrder(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(retrieveCarsTaskService.printPaymentOrder(retrieveCarsTaskVo)), HttpStatus.OK);
    }
}
