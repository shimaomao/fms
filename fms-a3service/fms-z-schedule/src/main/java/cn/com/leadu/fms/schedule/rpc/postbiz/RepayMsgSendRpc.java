package cn.com.leadu.fms.schedule.rpc.postbiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:   定时分类发送短信
 * @author:ningyangyang
 * @since:2018/5/14
 */
@FeignClient("${fms.feigns.serverNames.fmsPostBiz}")
public interface RepayMsgSendRpc {
    /**
     * @Title:
     * @Description: 定时分类发送短信
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "repay_msg_send/messageSend" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> messageSend();
}
