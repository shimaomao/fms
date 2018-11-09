package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: DeferTaskController
 * @Description: 合同展期rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface DeferTaskRpc {

    /**
     * @Title:
     * @Description:  提交合同展期申请
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/submitDeferTaskApply",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> submitDeferTaskApply(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  合同展期审批
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/submitDeferTaskApprove",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> submitDeferTaskApprove(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  展期合同生成
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "api/prebiz/defer_cont_create/generateDeferContract",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> generateDeferContract(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  展期合同打印
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/printDeferContract",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> printDeferContract(@RequestBody DeferTaskVo deferTaskVo);


    /**
     * @Title:
     * @Description:  展期合同审核
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/approveDeferContract",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approveDeferContract(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  展期合同财务审核
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/submitFinanceApprove",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> submitFinanceApprove(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  展期合同总经理审核
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/submitManagerApprove",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> submitManagerApprove(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  合同展期审批退回上一级
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/sendBack",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> sendBack(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  打印付款单
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/printPaymentOrder",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printPaymentOrder(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  根据contNo获取展期合同的当前合同信息
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @RequestMapping(value = "api/prebiz/defer_cont_create/findDeferTaskVoByContNo", method = RequestMethod.POST)
    ResponseEntity<RestResponse> findDeferTaskVoByContNo(@RequestBody DeferTaskVo deferTaskVo);


    /**
     * @Title:
     * @Description:  根据contNo获取展期合同展期前的信息
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/findOldDeferTaskVoByContNo", method = RequestMethod.POST)
    ResponseEntity<RestResponse> findOldDeferTaskVoByContNo(@RequestBody DeferTaskVo deferTaskVo);


    /**
     * @Title:
     * @Description:  根据contNo获取展期任务表信息
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/findDeferTaskByTaskNo", method = RequestMethod.POST)
    ResponseEntity<RestResponse> findDeferTaskByTaskNo(@RequestBody DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description:  合同展期审批拒绝
     * @param deferTaskVo 展期任务Vo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-9 14:35:16
     */
    @RequestMapping(value = "api/postbiz/defer_task/goRefuse",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> goRefuse(@RequestBody DeferTaskVo deferTaskVo);

}
