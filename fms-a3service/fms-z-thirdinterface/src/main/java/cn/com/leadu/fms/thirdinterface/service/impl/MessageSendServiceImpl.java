package cn.com.leadu.fms.thirdinterface.service.impl;/**
 * Created by ningyangyang on 2018/6/15.
 */

import cn.com.leadu.fms.common.constant.enums.insurance.MsgStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.constant.enums.thirdinterface.MessageTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.baseinfo.repository.BasMsgRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import cn.com.leadu.fms.thirdinterface.common.port.message.MessageUtil;
import cn.com.leadu.fms.thirdinterface.config.WebMessageProperties;
import cn.com.leadu.fms.thirdinterface.service.MessageSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: fms
 * @Description: 发送短信
 * @author: ningyangyang
 * @date 2018/6/15 17:54
 */
@Slf4j
@Service
public class MessageSendServiceImpl implements MessageSendService {

    /**
     * @Fields  : 短信配置
     * @author qiaomengnan
     */
    @Autowired
    private WebMessageProperties webMessageProperties;
    @Autowired
    private BasMsgRepository basMsgRepository;

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
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendMessage(String to,String cont,String memo,String type) {
        String interfaceType = null;
        //还款短信
        if(TplTypeKeyEnums.DXMB_REPAY.getType().equals(type) ||
                TplTypeKeyEnums.DUEDATE_SEND_MESSAGE.getType().equals(type) ||
                TplTypeKeyEnums.OVERDUEDATE_SEND_MESSAGE.getType().equals(type)){
            interfaceType= MessageTypeEnums.REPAY.getType();
        }else{
            interfaceType= MessageTypeEnums.OTHER.getType();
        }
        if(webMessageProperties.getTest())
            to = webMessageProperties.getTestMobNo();

        String messageSendStatus = messageInterfaceInvoke(to,cont,interfaceType);

        BasMsg basMsg  = new BasMsg();
        basMsg.setMsgText(cont);
        basMsg.setTelNo(to);
        basMsg.setMemo(memo);
        basMsg.setMsgTypeKey(type);
        basMsg.setMsgStatus(messageSendStatus);  //短信发送状态

        basMsgRepository.insertData(basMsg);
    }

    /**
     * @Title:
     * @Description:   短信发送
     * @param to       接收人
     * @param cont     内容
     * @param type     短信类型
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/08/9 05:06:12
     */
    public String messageInterfaceInvoke(String to,String cont,String type){
        String msg = null;
        try {
            if(StringUtils.isNotTrimBlank(to,cont,type)){
                if(MessageTypeEnums.REPAY.getType().equals(type)){
                    //还款短信
                    msg  =   MessageUtil.messageSend(to,cont,webMessageProperties.getUrl(),webMessageProperties.getRepayId(),webMessageProperties.getRepayPwd());
                }else if(MessageTypeEnums.OTHER.getType().equals(type)){
                    //其他短信
                    msg =  MessageUtil.messageSend(to,cont,webMessageProperties.getUrl(),webMessageProperties.getOtherId(),webMessageProperties.getOtherPwd());
                }else
                    throw new FmsServiceException("短信类型不存在");
            }

        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            return MsgStatusEnums.SEND_FAILURE.getStatus();
        }
        String [] msgArry = null;
        if(StringUtils.isNotTrimBlank(msg)){
             msgArry = msg.split("/");
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(msgArry))
            return msgArry[0];
        else
            return MsgStatusEnums.SEND_FAILURE.getStatus();
    }

}
