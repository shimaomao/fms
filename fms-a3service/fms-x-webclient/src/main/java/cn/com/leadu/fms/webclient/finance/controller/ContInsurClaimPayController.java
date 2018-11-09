package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.webclient.finance.rpc.ContInsurClaimPayRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanfengbo
 * @ClassName:
 * @Description: 保险理赔制单付款Controller
 * @date
 */
@RestController
@RequestMapping("cont_insur_claim_pay")
public class ContInsurClaimPayController {
    /**
     * @Fields  : 保险理赔制单付款Rpc
     */
    @Autowired
    private ContInsurClaimPayRpc contInsurClaimPayRpc;

    /**
     * @Description: 保险理赔制单
     * @param:
     * @return:
     * @Author: yanfengbo
     * @Date:
     */
    @RequestMapping(value = "makeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> makeVoucher(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return contInsurClaimPayRpc.makeVoucher(contInsurClaimVo);
    }

    /**
     * @Description: 保险理赔制单付款
     * @param:
     * @return:
     * @Author: yanfengbo
     * @Date:
     */
    @RequestMapping(value = "payment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> payment(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return contInsurClaimPayRpc.payment(contInsurClaimVo);
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
    @RequestMapping(value = "printContInsurClaim",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printContInsurClaim(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return contInsurClaimPayRpc.printContInsurClaim(contInsurClaimVo);
    }
}
