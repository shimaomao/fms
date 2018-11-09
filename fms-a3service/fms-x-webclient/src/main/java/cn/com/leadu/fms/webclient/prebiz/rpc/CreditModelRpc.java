package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qiaomengnan
 * @ClassName: CreditModelRpc
 * @Description: 贷前模型rpc
 * @date 2018/5/15
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CreditModelRpc {

    /**
     * @Title:
     * @Description:   生成贷前模型
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/14 04:32:36
     */
    @RequestMapping(value = "api/prebiz/credit_model/generatePreBizCreditModel" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> generatePreBizCreditModel(@RequestParam("applyNo") String applyNo);

    /**
     * @Title:
     * @Description:   获取用户报告基础信息
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/15 11:05:56
     */
    @RequestMapping(value = "api/prebiz/credit_model/findCustomerByApplyNo" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> findCustomerByApplyNo(@RequestParam("applyNo") String applyNo);

}
