package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskController
 * @Description: 收车任务rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface RetrieveCarsTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询收车任务信息
     * @param retrieveCarsTaskVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/findRetrieveCarsTasksByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRetrieveCarsTasksByPage(@RequestParam Map<String, Object> retrieveCarsTaskVoMap);

    /**
     * @Title:
     * @Description: 分页查询收车任务信息
     * @param retrieveCarsTaskVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/findRetrieveCarsTaskVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRetrieveCarsTaskVosByPage(@RequestParam Map<String, Object> retrieveCarsTaskVoMap);

    /**
     * @Title:
     * @Description: 保存收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/saveRetrieveCarsTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveRetrieveCarsTask(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 委托书下载
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/downLoadLetter",method = RequestMethod.POST)
    ResponseEntity<RestResponse> downLoadLetter(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:  修改收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/modifyRetrieveCarsTask",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyRetrieveCarsTask(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:   根据retrieveCarId集合删除收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/deleteRetrieveCarsTasksByRetrieveCarIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteRetrieveCarsTasksByRetrieveCarIds(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:  根据retrieveCarId获取收车任务
     * @param retrieveCarId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/findRetrieveCarsTaskByRetrieveCarId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRetrieveCarsTaskByRetrieveCarId(@RequestParam("retrieveCarId") String retrieveCarId);

    /**
     * @Title:
     * @Description:   发起收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskLaunch", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskLaunch(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:   收车任务风控派单
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskRisk", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskRisk(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:   收车任务审批
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskApprove", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskApprove(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:   收车任务详情查询
     * @param retrieveCarId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/findRetrieveCarsTaskVoById", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRetrieveCarsTaskVoById(@RequestParam("retrieveCarId") String retrieveCarId);

    /**
     * @Title:
     * @Description:   根据收车任务号获取收车任务
     * @param retrieveCarTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/findRetrieveCarsTaskVoByTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRetrieveCarsTaskVoByTaskNo(@RequestParam("retrieveCarTaskNo") String retrieveCarTaskNo);

    /**
     * @Title:
     * @Description: 收车任务委派与登记
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskRegister", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskRegister(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 收车任务车辆入库
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskStorage", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskStorage(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 收车任务确认交接
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskHandover", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskHandover(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 收车任务财务审核
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskFinancial", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskFinancial(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 收车任务总经理审核
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskAudit", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskAudit(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 收车任务拒绝
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskRefuse", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskRefuse(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 收车任务退回
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskSendBack", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 收车任务退回(总经理退回)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskAuditSendBack", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskAuditSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description: 收车任务退回(财务审核退回)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/retrieveCarsTaskFinanceSendBack", method = RequestMethod.POST)
    ResponseEntity<RestResponse> retrieveCarsTaskFinanceSendBack(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:  检查是否有正在进行的任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/25 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/checkRetrieveCarsTask", method = RequestMethod.POST)
    ResponseEntity<RestResponse> checkRetrieveCarsTask(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:  收车任务打印付款单
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/10/13 10:34:41
     */
    @RequestMapping(value = "api/postbiz/retrieve_cars_task/printPaymentOrder", method = RequestMethod.POST)
    ResponseEntity<RestResponse> printPaymentOrder(@RequestBody RetrieveCarsTaskVo retrieveCarsTaskVo);

}
