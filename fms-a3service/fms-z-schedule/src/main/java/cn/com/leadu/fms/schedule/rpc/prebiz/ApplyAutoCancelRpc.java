package cn.com.leadu.fms.schedule.rpc.prebiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qiaomengnan
 * @ClassName: ApplyAutoCancelRpc
 * @Description: 申请订单自动取消
 * @date 2018/5/11
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface ApplyAutoCancelRpc {

    /**
     * @Title:
     * @Description:  申请订单自动取消
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 10:13:58
     */
    @RequestMapping(value = "apply_auto_cancel/applyAutoCancel",method = RequestMethod.GET)
    ResponseEntity<RestResponse> applyAutoCancel();

}
