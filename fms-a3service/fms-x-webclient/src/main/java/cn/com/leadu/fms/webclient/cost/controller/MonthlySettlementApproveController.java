package cn.com.leadu.fms.webclient.cost.controller;/**
 * Created by yyq on 2018/5/30.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
import cn.com.leadu.fms.webclient.cost.rpc.MonthlySettlementApproveRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: gps月结申请审批
 * @author: yangyiquan
 * @create: 2018-05-30 16:15
 **/
@RestController
@RequestMapping("monthly_settlement_approve")
public class MonthlySettlementApproveController {

    /**
     * @Field: gps月结任务审批rpc
     */
    @Autowired
    private MonthlySettlementApproveRpc monthlySettlementApproveRpc;

    /** 
    * @Description: 月结审批操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/30 16:17
    */ 
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo){
        return monthlySettlementApproveRpc.approval(monthlySettlementApproveVo);
    }
}
