package cn.com.leadu.fms.webclient.finance.controller;/**
 * Created by yyq on 2018/6/2.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
import cn.com.leadu.fms.webclient.finance.rpc.GpsMonthlyPayRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: gps月结付款Controller
 * @author: yangyiquan
 * @create: 2018-06-02 11:49
 **/
@RestController
@RequestMapping("gps_monthly_pay")
public class GpsMonthlyPayController {

    /**
     * @Fields  : gps月结付款Rpc
     */
    @Autowired
    private GpsMonthlyPayRpc gpsMonthlyPayRpc;

    /** 
    * @Description: Gps月结制单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/2 11:55
    */ 
    @RequestMapping(value = "makeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> makeVoucher(@RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo){
        return gpsMonthlyPayRpc.makeVoucher(monthlySettlementApproveVo);
    }

    /** 
    * @Description: Gps月结财务付款
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 11:57
    */ 
    @RequestMapping(value = "payment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> payment(@RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo){
        return gpsMonthlyPayRpc.payment(monthlySettlementApproveVo);
    }

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "printGpsMonthly",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printGpsMonthly(@RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo){
        return gpsMonthlyPayRpc.printGpsMonthly(monthlySettlementApproveVo);
    }
}
