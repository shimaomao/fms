package cn.com.leadu.fms.webclient.finance.controller;/**
 * Created by yyq on 2018/6/4.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;
import cn.com.leadu.fms.webclient.finance.rpc.PilferMonthlyPayRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 盗抢险月结付款Controller
 * @author: yangyiquan
 * @create: 2018-06-04 18:08
 **/
@RestController
@RequestMapping("pilfer_monthly_pay")
public class PilferMonthlyPayController {

    /**
     * @Fields  : 盗抢险月结付款Rpc
     */
    @Autowired
    private PilferMonthlyPayRpc pilferMonthlyPayRpc;

    /** 
    * @Description: 盗抢险月结财务制单 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 18:10
    */ 
    @RequestMapping(value = "makeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> makeVoucher(@RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo){
        return pilferMonthlyPayRpc.makeVoucher(pilferInsuranceApproveVo);
    }

    /** 
    * @Description:  盗抢险月结财务付款
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 18:10
    */ 
    @RequestMapping(value = "payment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> payment(@RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo){
        return pilferMonthlyPayRpc.payment(pilferInsuranceApproveVo);
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
    @RequestMapping(value = "printPilferMonthly",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPilferMonthly(@RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo){
        return pilferMonthlyPayRpc.printPilferMonthly(pilferInsuranceApproveVo);
    }
}
