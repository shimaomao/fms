package cn.com.leadu.fms.finance.rpc.cost;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:  gps月结付款rpc
 * @author:yangyiquan
 * @since:2018/6/02
 */
@FeignClient("${fms.feigns.serverNames.fmsCost}")
public interface MonthlySettlementRpc {

    /** 
    * @Description: 根据monthlySettlementNo获取gps月结任务表
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/2 14:29
    */ 
    @RequestMapping(value = "monthly_settlement/findMonthlySettlementBySettlementNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<MonthlySettlement>> findMonthlySettlementBySettlementNo(@RequestParam("monthlySettlementNo") String monthlySettlementNo);
}
