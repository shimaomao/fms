package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangyiquan
 * @ClassName: PilferMonthlyPayRpc
 * @Description: 盗抢险月结付款Rpc
 * @date 2018-06-04
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface PilferMonthlyPayRpc {

    /** 
    * @Description:  盗抢险月结财务制单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 17:54
    */ 
    @RequestMapping(value = "api/finance/pilfer_monthly_pay/makeVoucher",method = RequestMethod.POST)
    ResponseEntity<RestResponse> makeVoucher(PilferInsuranceApproveVo pilferInsuranceApproveVo);

    /** 
    * @Description: 盗抢险月结财务付款
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 17:54
    */ 
    @RequestMapping(value = "api/finance/pilfer_monthly_pay/payment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> payment(PilferInsuranceApproveVo pilferInsuranceApproveVo);

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/finance/pilfer_monthly_pay/printPilferMonthly",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printPilferMonthly(PilferInsuranceApproveVo pilferInsuranceApproveVo);
}
