package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author wangxue
 * @ClassName: MessageSendService
 * @Description: 短信发送接口service
 * @date 2018/3/16
 */
@Service
public interface CommonMessageService {

    /**
     * @Title:
     * @Description: 根据手机号和短信内容发送短信
     * @param phoneNum 手机号
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-16 16:44:23
     */
    void sendMessage(String phoneNum, String content,String projectName, String serviceName, String classFunctionName);
}
