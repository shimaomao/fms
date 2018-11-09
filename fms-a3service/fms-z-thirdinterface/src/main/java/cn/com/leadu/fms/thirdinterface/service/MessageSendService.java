package cn.com.leadu.fms.thirdinterface.service;/**
 * Created by ningyangyang on 2018/6/15.
 */

/**
 * @Title: fms
 * @Description: 发送短信
 * @author: ningyangyang
 * @date 2018/6/15 17:51
 */
public interface MessageSendService {

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
    void sendMessage(String to,String cont,String memo,String type);

}
