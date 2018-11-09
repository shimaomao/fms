package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentAutoJobRpc
 * @Description: 提前还款自动作业Rpc
 * @date 2018-10-26
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContPrepaymentAutoJobRpc {

    /**
    * @Description: 提前还款自动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/26 10:52
    */
    @RequestMapping(value = "api/cost/prepayment_auto_job/autoCancelPrepayment",method = RequestMethod.GET)
    ResponseEntity<RestResponse> autoCancelPrepayment();

    /**
    * @Description: 提前还款手动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/30 17:54
    */
    @RequestMapping(value = "api/cost/prepayment_auto_job/manualCancelPrepayment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> manualCancelPrepayment(@RequestBody ContPrepaymentVo contPrepaymentVo);
}