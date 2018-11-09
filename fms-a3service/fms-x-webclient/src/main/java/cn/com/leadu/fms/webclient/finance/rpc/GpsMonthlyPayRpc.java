package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangyiquan
 * @ClassName: GpsMonthlyPayRpc
 * @Description: gps月结付款Rpc
 * @date 2018-06-02
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface GpsMonthlyPayRpc {
    
    /** 
    * @Description: Gps月结财务制单
    * @param:
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/2 12:05
    */ 
    @RequestMapping(value = "api/finance/gps_monthly_pay/makeVoucher",method = RequestMethod.POST)
    ResponseEntity<RestResponse> makeVoucher(MonthlySettlementApproveVo monthlySettlementApproveVo);

    /** 
    * @Description: Gps月结财务付款
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 11:56
    */ 
    @RequestMapping(value = "api/finance/gps_monthly_pay/payment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> payment(MonthlySettlementApproveVo monthlySettlementApproveVo);

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/finance/gps_monthly_pay/printGpsMonthly",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printGpsMonthly(MonthlySettlementApproveVo monthlySettlementApproveVo);
}
