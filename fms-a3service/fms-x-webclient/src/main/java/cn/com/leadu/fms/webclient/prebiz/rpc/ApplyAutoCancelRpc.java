package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yanfengbo
 * @ClassName: ApplyAutoCancelRpc
 * @Description: 申请订单自动取消
 * @date
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ApplyAutoCancelRpc {
    @RequestMapping(value = "api/prebiz/apply_auto_cancel/applyAutoCancel" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> applyAutoCancel();
}
