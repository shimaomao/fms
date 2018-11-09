package cn.com.leadu.fms.webclient.insurance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ningyangyang on 2018/5/21.
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface InsurClaimCheckRpc {

    /**
     * @Description: 保险理赔审核通过
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/16 15:09
     */
    @RequestMapping(value = "api/insurance/insur_claim_check/approval" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approval(@RequestBody ContInsurClaimVo contInsurClaimVo);

    /**
     * @Description: 保险理赔审核返回上一级
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/16 15:09
     */
    @RequestMapping(value = "api/insurance/insur_claim_check/sendBack" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> sendBack(@RequestBody ContInsurClaimVo contInsurClaimVo);

    /**
     * @Description: 测试接口
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/16 15:09
     */
    @RequestMapping(value = "api/insurance/insurance_message_send/insuranceMessageSend" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> insuranceMessageSend();

    /**
     * @Description: 保险理赔财务收款完成
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/19 17:23
     */
    @RequestMapping(value = "api/insurance/insur_claim_check/Receivables" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> Receivables(@RequestBody ContInsurClaimVo contInsurClaimVo);

    /**
     * @Description: 保险理赔财务收款返回上一级
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/22 17:23
     */
    @RequestMapping(value = "api/insurance/insur_claim_check/refunds" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> refunds(@RequestBody ContInsurClaimVo contInsurClaimVo);
}
