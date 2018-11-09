package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.RetrieveCarsTaskRpc;
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
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskController
 * @Description: 收车任务controller
 */
@RestController
@RequestMapping("retrieve_cars_task")
public class RetrieveCarsTaskController {

    /**
     * @Fields  : 收车任务rpc
     */
    @Autowired
    private RetrieveCarsTaskRpc retrieveCarsTaskRpc;

    /**
     * @Title:
     * @Description: 分页查询收车任务信息
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "findRetrieveCarsTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRetrieveCarsTasksByPage(RetrieveCarsTaskVo retrieveCarsTaskVo){
        Map retrieveCarsTaskVoMap = retrieveCarsTaskVo == null?null:(Map) JSON.toJSON(retrieveCarsTaskVo);
        return retrieveCarsTaskRpc.findRetrieveCarsTasksByPage(retrieveCarsTaskVoMap);
    }

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
        Map retrieveCarsTaskVoMap = retrieveCarsTaskVo == null?null:(Map) JSON.toJSON(retrieveCarsTaskVo);
        return retrieveCarsTaskRpc.findRetrieveCarsTaskVosByPage(retrieveCarsTaskVoMap);
    }

    /**
     * @Title:
     * @Description: 保存收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "saveRetrieveCarsTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRetrieveCarsTask(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo){
        return retrieveCarsTaskRpc.saveRetrieveCarsTask(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description: 委托书下载
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "downLoadLetter",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> downLoadLetter(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo){
        return retrieveCarsTaskRpc.downLoadLetter(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  修改收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "modifyRetrieveCarsTask",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRetrieveCarsTask(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo){
        return retrieveCarsTaskRpc.modifyRetrieveCarsTask(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:   根据retrieveCarId集合删除收车任务
     * @param retrieveCarIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "deleteRetrieveCarsTasksByRetrieveCarIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRetrieveCarsTasksByRetrieveCarIds(@RequestBody List<String> retrieveCarIds){
        RetrieveCarsTaskVo retrieveCarsTaskVo = new RetrieveCarsTaskVo();
        retrieveCarsTaskVo.setRetrieveCarIds(retrieveCarIds);
        return retrieveCarsTaskRpc.deleteRetrieveCarsTasksByRetrieveCarIds(retrieveCarsTaskVo);
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
        return retrieveCarsTaskRpc.findRetrieveCarsTaskByRetrieveCarId(retrieveCarId);
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
    public ResponseEntity<RestResponse> retrieveCarsTaskLaunch(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo){
        return retrieveCarsTaskRpc.retrieveCarsTaskLaunch(retrieveCarsTaskVo);
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
    public ResponseEntity<RestResponse> retrieveCarsTaskRisk(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskRisk(retrieveCarsTaskVo);
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
    public ResponseEntity<RestResponse> retrieveCarsTaskApprove(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskApprove(retrieveCarsTaskVo);
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
    public ResponseEntity<RestResponse> findRetrieveCarsTaskVoById(String retrieveCarId){
        return retrieveCarsTaskRpc.findRetrieveCarsTaskVoById(retrieveCarId);
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
    public ResponseEntity<RestResponse> findRetrieveCarsTaskVoByTaskNo(String retrieveCarTaskNo){
        return retrieveCarsTaskRpc.findRetrieveCarsTaskVoByTaskNo(retrieveCarTaskNo);
    }

    /**
     * @Title:
     * @Description:   收车任务委派与登记
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskRegister", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskRegister(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskRegister(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务入库
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskStorage", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskStorage(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskStorage(retrieveCarsTaskVo);
    }
    /**
     * @Title:
     * @Description:  确认交接
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskHandover", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskHandover(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskHandover(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  财务审核
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskFinancial", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskFinancial(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskFinancial(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务总经理审核
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskAudit", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskAudit(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskAudit(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务拒绝
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskRefuse", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskRefuse(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskRefuse(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务退回(一般)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskSendBack(retrieveCarsTaskVo);
    }
    /**
     * @Title:
     * @Description:  收车任务退回(总经理退回)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskAuditSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskAuditSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskAuditSendBack(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务退回(财务审核退回)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @RequestMapping(value = "retrieveCarsTaskFinanceSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> retrieveCarsTaskFinanceSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.retrieveCarsTaskFinanceSendBack(retrieveCarsTaskVo);
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
    public ResponseEntity<RestResponse> checkRetrieveCarsTask(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.checkRetrieveCarsTask(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务打印付款单
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/10/13 10:34:41
     */
    @RequestMapping(value = "printPaymentOrder", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPaymentOrder(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo) {
        return retrieveCarsTaskRpc.printPaymentOrder(retrieveCarsTaskVo);
    }

}
