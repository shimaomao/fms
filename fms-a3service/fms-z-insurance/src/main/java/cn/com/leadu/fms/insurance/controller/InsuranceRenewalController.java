package cn.com.leadu.fms.insurance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.insurance.service.InsuranceRenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:  保险续保
 * @author:ningyangyang
 * @since:2018/5/17
 */
@RestController
@RequestMapping("insurance_renewal")
public class InsuranceRenewalController {


    /**
     * @Fields  : 续保任务service
     */
    @Autowired
    private InsuranceRenewalService insuranceRenewalService;

    /**
     * @Title:
     * @Description: 续保任务生成
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 11:52:38
     */
    @RequestMapping(value = "insuranceRenewalTask" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> insuranceRenewalTask(){
        insuranceRenewalService.insuranceRenewalTask();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
