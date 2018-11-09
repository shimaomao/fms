package cn.com.leadu.fms.finance.rpc.baseinfo;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangxue
 * @ClassName: BasPartnerRpc
 * @Description: 经销商信息维护rpc
 * @date 2018-03-17
 */
@FeignClient("${fms.feigns.serverNames.fmsBaseInfo}")
public interface BasRepayRuleRpc {

    /**
     * @Title:
     * @Description:根据当前日期取得还款日
     * @return
     * @throws
     * @author liujinge
     * @date 2018-4-12 13:35:32
     */
    @RequestMapping(value = "bas_repay_rule/findRepayDay", method = RequestMethod.GET)
    ResponseEntity<RestResponse<String>> findRepayDay();

}
