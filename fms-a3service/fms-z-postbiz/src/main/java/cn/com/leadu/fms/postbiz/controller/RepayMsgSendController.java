package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.postbiz.service.RepayMsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:  短信发送定时任务
 * @author:ningyangyang
 * @since:2018/5/9
 */
@RestController
@RequestMapping("repay_msg_send")
public class RepayMsgSendController {

    /**
     * @Fields  :messageSendservice
     */
    @Autowired
    private RepayMsgSendService repayMsgSendService;

    /**
     * @Title:
     * @Description: 定时分类发送短信
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "messageSend" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse>  messageSend(){
        repayMsgSendService.messageSend();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
