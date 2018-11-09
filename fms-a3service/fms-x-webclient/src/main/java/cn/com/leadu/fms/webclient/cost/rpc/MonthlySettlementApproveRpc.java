package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementApproveRpc
 * @Description: gps月结任务审批rpc
 * @date 2018-05-28
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface MonthlySettlementApproveRpc {

    /** 
    * @Description: 月结审批操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/30 16:13
    */ 
    @RequestMapping(value = "api/cost/monthly_settlement_approve/approval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> approval(@RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo);
}
