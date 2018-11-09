package cn.com.leadu.fms.finance.controller;/**
 * Created by yyq on 2018/6/2.
 */

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.GpsMonthlyPayService;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: fms
 * @description: gps月结付款Controller
 * @author: yangyiquan
 * @create: 2018-06-02 13:55
 **/
@RestController
@RequestMapping("gps_monthly_pay")
public class GpsMonthlyPayController {
    /**
     * @Fields  : gps月结付款service
     */
    @Autowired
    private GpsMonthlyPayService gpsMonthlyPayService;

    /** 
    * @Description: Gps月结制单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/2 14:00
    */ 
    @RequestMapping(value = "makeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> makeVoucher(@Valid @RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo, @AuthUserInfo SysUser sysUser){
        monthlySettlementApproveVo.setUser(sysUser.getUser());
        gpsMonthlyPayService.makeVoucher(monthlySettlementApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: Gps月结财务付款
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 13:48
    */ 
    @RequestMapping(value = "payment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> payment(@Valid @RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo, @AuthUserInfo SysUser sysUser){
        monthlySettlementApproveVo.setUser(sysUser.getUser());
        gpsMonthlyPayService.payment(monthlySettlementApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> printGpsMonthly(@Valid @RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(gpsMonthlyPayService.printGpsMonthly(monthlySettlementApproveVo)), HttpStatus.OK);
    }
}
