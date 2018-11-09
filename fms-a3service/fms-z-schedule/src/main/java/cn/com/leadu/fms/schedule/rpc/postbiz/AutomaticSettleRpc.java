package cn.com.leadu.fms.schedule.rpc.postbiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: 自动结清
 * @author:ningyangyang
 * @since:2018/5/15
 */
@FeignClient("${fms.feigns.serverNames.fmsPostBiz}")
public interface AutomaticSettleRpc {

    /**
     * @Title:
     * @Description: 自动结清
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "automatic_settle/automaticSettle" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> automaticSettle();
}
