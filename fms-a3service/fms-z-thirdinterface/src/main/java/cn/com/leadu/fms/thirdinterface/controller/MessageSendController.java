package cn.com.leadu.fms.thirdinterface.controller;/**
 * Created by ningyangyang on 2018/6/15.
 */

import cn.com.leadu.fms.common.constant.enums.thirdinterface.MessageTypeEnums;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.thirdinterface.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: fms
 * @Description: 短信发送接口
 * @author: ningyangyang
 * @date 2018/6/15 17:57
 */
@RestController
@RequestMapping("message_send")
public class MessageSendController {

    /**
     * @Fields  : 短信发送service
     * @author qiaomengnan
     */
    @Autowired
    private MessageSendService messageSendService;

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
    @RequestMapping(value = "sendMessage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> sendMessage(String to,String cont,String memo,String type){
        messageSendService.sendMessage(to,cont,memo,type);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
