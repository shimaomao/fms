package cn.com.leadu.fms.webclient.prebiz.controller;/**
 * Created by yyq on 2018/6/30.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applymanageapprove.ApplyManageApproveVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ApplyManageApproveRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 总经理审核
 * @author: yangyiquan
 * @create: 2018-06-30 16:34
 **/
@RestController
@RequestMapping("apply_manage_approve")
public class ApplyManageApproveController {
    /**
     * @Fields  : 订单风控审批rpc
     */
    @Autowired
    private ApplyManageApproveRpc applyManageApproveRpc;

    /** 
    * @Description: 总经理审核通过 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 16:37
    */ 
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody ApplyManageApproveVo applyManageApproveVo){
        return applyManageApproveRpc.approval(applyManageApproveVo);
    }

    /** 
    * @Description: 总经理审核退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 16:40
    */ 
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ApplyManageApproveVo applyManageApproveVo){
        return applyManageApproveRpc.sendBack(applyManageApproveVo);
    }

    /**
    * @Description: 退回风控经理
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/27 12:04
    */
    @RequestMapping(value = "backToDiragree",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backToDiragree(@RequestBody ApplyManageApproveVo applyManageApproveVo){
        return applyManageApproveRpc.backToDiragree(applyManageApproveVo);
    }
}
