package cn.com.leadu.fms.insurance.rpc.thirdinterface;/**
 * Created by ningyangyang on 2018/6/15.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/6/15 18:05
 */
@FeignClient("${fms.feigns.serverNames.fmsThirdInterface}")
public interface MessageSendRpc {

    /**
     * @Title:
     * @Description:   短信发送
     * @param to       接收人
     * @param cont     内容
     * @param type     短信类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/24 05:06:12
     */
    @RequestMapping(value = "message_send/sendMessage", method = RequestMethod.GET)
    ResponseEntity<RestResponse<String>> sendMessage(@RequestParam("to") String to,@RequestParam("cont") String cont,@RequestParam("memo") String memo, @RequestParam("type") String type);

}
