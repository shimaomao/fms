package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContractAutoCancelRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanfengbo
 * @ClassName: ContractAutoCancelController
 * @Description: 未生效合同自动取消
 * @date
 */
@RestController
@RequestMapping("contract_auto_cancel")
public class ContractAutoCancelController {
    @Autowired
    private ContractAutoCancelRpc contractAutoCancelRpc;
    @RequestMapping(value = "contractAutoCancel" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> contractAutoCancel(){
        return contractAutoCancelRpc.contractAutoCancel();
    }
}
