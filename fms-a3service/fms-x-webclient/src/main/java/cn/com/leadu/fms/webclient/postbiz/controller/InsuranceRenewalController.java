package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.webclient.postbiz.rpc.InsuranceRenewalRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:   续保任务
 * @author:ningyangyang
 * @since:2018/5/17
 */
@RestController
@RequestMapping("insurance_renewal")
public class InsuranceRenewalController {

    @Autowired
    private InsuranceRenewalRpc insuranceRenewalRpc;

    @RequestMapping(value = "insuranceRenewalTask" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> insuranceRenewalTask(){
        return  insuranceRenewalRpc.insuranceRenewalTask();
    }
}
