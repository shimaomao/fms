package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yanfengbo
 * @ClassName:
 * @Description: 保险理赔制单付款Rpc
 * @date
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContInsurClaimPayRpc {
    /**
     * @Description: 保险理赔制单
     * @param:
     * @return:
     * @Author: yanfengbo
     */
    @RequestMapping(value = "api/finance/cont_insur_claim_pay/makeVoucher",method = RequestMethod.POST)
    ResponseEntity<RestResponse> makeVoucher(ContInsurClaimVo contInsurClaimVo);

    /**
     * @Description: 保险理赔制单付款
     * @param:
     * @return:
     * @Author: yanfengbo
     */
    @RequestMapping(value = "api/finance/cont_insur_claim_pay/payment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> payment(ContInsurClaimVo contInsurClaimVo);

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/finance/cont_insur_claim_pay/printContInsurClaim",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printContInsurClaim(ContInsurClaimVo contInsurClaimVo);
}
