package cn.com.leadu.fms.insurance.controller;/**
 * Created by ningyangyang on 2018/6/19.
 */

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.insurance.service.InsuranceMessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: fms
 * @Description: 短信发送
 * @author: ningyangyang
 * @date 2018/6/19 18:01
 */
@RestController
@RequestMapping("insurance_message_send")
public class InsuranceMessageSendController {

    @Autowired
    private InsuranceMessageSendService insuranceMessageSendService;

    /**
     * @Title:
     * @Description: 保险信息发送
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-6-15 11:52:38
     */
    @RequestMapping(value = "insuranceMessageSend" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> insuranceMessageSend(){
        insuranceMessageSendService.insuranceMessageSend();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
