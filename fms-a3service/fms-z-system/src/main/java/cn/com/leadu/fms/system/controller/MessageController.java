package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.business.service.CommonMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 短信发送接口
 * @author:ningyangyang
 * @since:2018/5/11
 */
@RestController
@RequestMapping("message")
public class MessageController {

    /**
     * @Fields  : 短信发送service
     */
    @Autowired
    private CommonMessageService commonMessageService;

    /**
     * @Title:
     * @Description: 短信发送
     * @param phoneNum 手机号码
     * @param content 短信内容
     * @param projectName 工程名称
     * @param serviceName 服务名称
     * @param classFunctionName 方法路径
     * @return
     * @throws
     * @author nignyangyang
     * @date 2018-5-11 11:47:36
     */
    public void sendMessage(String phoneNum, String content, String projectName, String serviceName, String classFunctionName){
        commonMessageService.sendMessage(phoneNum, content, projectName, serviceName,  classFunctionName);
    }
}
