package cn.com.leadu.fms.schedule.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qiaomengnan
 * @ClassName: ContRepaySkedRpc
 * @Description: 黑名单相关接口
 * @date 2018/5/8
 */
@FeignClient("${fms.feigns.serverNames.fmsFinance}")
public interface ContRepaySkedRpc {

    /**
     * @Title:
     * @Description: 检查是否有合同还款逾期
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/08 03:47:10
     */
    @RequestMapping(value = "cont_repay_sked/checkContRepaySked" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> checkContRepaySked();

}
