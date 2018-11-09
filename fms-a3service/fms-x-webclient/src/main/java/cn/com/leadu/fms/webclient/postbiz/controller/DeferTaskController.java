package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.DeferTaskRpc;
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
 * @ClassName: DeferTaskController
 * @Description: 合同展期controller
 */
@RestController
@RequestMapping("defer_task")
public class DeferTaskController {

    /**
     * @Fields  : 合同展期rpc
     */
    @Autowired
    private DeferTaskRpc deferTaskRpc;


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
    public ResponseEntity<RestResponse> findDeferTaskVoByContNo(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.findDeferTaskVoByContNo(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  提交合同展期申请
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "submitDeferTaskApply",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> submitDeferTaskApply(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.submitDeferTaskApply(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  合同展期审批
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "submitDeferTaskApprove",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> submitDeferTaskApprove(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.submitDeferTaskApprove(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  展期合同生成
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "generateDeferContract",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> generateDeferContract(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.generateDeferContract(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  展期合同打印
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @RequestMapping(value = "printDeferContract",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> printDeferContract(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.printDeferContract(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  展期合同审核
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @RequestMapping(value = "approveDeferContract",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approveDeferContract(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.approveDeferContract(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  展期合同财务审核
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @RequestMapping(value = "submitFinanceApprove",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> submitFinanceApprove(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.submitFinanceApprove(deferTaskVo);
    }
    /**
     * @Title:
     * @Description:  展期合同总经理审核
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @RequestMapping(value = "submitManagerApprove",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> submitManagerApprove(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.submitManagerApprove(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  合同展期审批退回上一级
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.sendBack(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  打印付款单
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @RequestMapping(value = "printPaymentOrder",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPaymentOrder(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.printPaymentOrder(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取展期合同展期前合同信息
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-17 14:35:16
     */
    @RequestMapping(value = "findOldDeferTaskVoByContNo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findOldDeferTaskVoByContNo(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.findOldDeferTaskVoByContNo(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取展期任务表信息
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @RequestMapping(value = "findDeferTaskByTaskNo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findDeferTaskByTaskNo(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.findDeferTaskByTaskNo(deferTaskVo);
    }

    /**
     * @Title:
     * @Description:  合同展期审批拒绝
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-9 14:35:16
     */
    @RequestMapping(value = "goRefuse",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> goRefuse(@RequestBody DeferTaskVo deferTaskVo){
        return deferTaskRpc.goRefuse(deferTaskVo);
    }
}
