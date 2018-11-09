package cn.com.leadu.fms.webclient.insurance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.webclient.insurance.rpc.InsurClaimCheckRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ningyangyang on 2018/5/21.
 */
@RestController
@RequestMapping("insur_claim_check")
public class InsurClaimCheckController {

    @Autowired
     private InsurClaimCheckRpc InsurClaimCheckRpc;

    /**
     * @Description: 保险理赔审核通过
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/16 15:09
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return InsurClaimCheckRpc.approval(contInsurClaimVo);
    }

    /**
     * @Description: 保险理赔审核返回上一级
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/16 15:09
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return InsurClaimCheckRpc.sendBack(contInsurClaimVo);
    }

    /**
     * @Description: 测试接口
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/16 15:09
     */
    @RequestMapping(value = "insuranceMessageSend",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> insuranceMessageSend(){
        return InsurClaimCheckRpc.insuranceMessageSend();
    }

    /**
     * @Description: 保险理赔财务收款完成
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/19 17:23
     */
    @RequestMapping(value = "Receivables",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> Receivables(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return InsurClaimCheckRpc.Receivables(contInsurClaimVo);
    }

    /**
     * @Description: 保险理赔财务收款返回上一级
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/22 17:23
     */
    @RequestMapping(value = "refunds",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> refunds(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return InsurClaimCheckRpc.refunds(contInsurClaimVo);
    }

}
