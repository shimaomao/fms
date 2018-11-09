package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.webclient.postbiz.rpc.AutomaticSettleRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 自动结清
 * @author:ningyangyang
 * @since:2018/5/15
 */
@RestController
@RequestMapping("automatic_settle")
public class AutomaticSettleController {


    @Autowired
    private AutomaticSettleRpc automaticSettleRpc;
    /**
     * @Title:
     * @Description: 自动结清
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "automaticSettle",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> automaticSettle(){
        return automaticSettleRpc.automaticSettle();
    }
}
