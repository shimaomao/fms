package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.webclient.prebiz.rpc.ApplyAutoCancelRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanfengbo
 * @ClassName: ApplyAutoCancelService
 * @Description: 申请订单自动取消
 * @date
 */
@RestController
@RequestMapping("apply_auto_cancel")
public class applyAutoCancelController {
    @Autowired
    private ApplyAutoCancelRpc applyAutoCancelRpc;

    @RequestMapping(value = "applyAutoCancel" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> applyAutoCancel(){
        return applyAutoCancelRpc.applyAutoCancel();
    }
}
