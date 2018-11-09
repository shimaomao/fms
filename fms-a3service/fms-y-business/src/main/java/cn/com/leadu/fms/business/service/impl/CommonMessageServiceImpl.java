package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.config.EtonenetParam;
import cn.com.leadu.fms.business.service.CommonMessageService;
import cn.com.leadu.fms.data.system.repository.MessageLogRepository;
import cn.com.leadu.fms.pojo.system.entity.MessageLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: MessageSendService
 * @Description: 短信发送接口service实现类
 * @date 2018/3/16
 */
@Service
public class CommonMessageServiceImpl implements CommonMessageService {

    private static final Logger logger = LoggerFactory.getLogger(CommonMessageServiceImpl.class);

    @Autowired
    private MessageLogRepository messageLogRepository;

    @Autowired
    private EtonenetParam etonenetParam;

    /**
     * Hex编码字符组
     */
    private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * @Title:
     * @Description: 根据手机号和短信内容发送短信
     * @param phoneNum 手机号
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-16 16:44:23
     */
    @Override
    public void sendMessage(String phoneNum, String content, String projectName, String serviceName, String classFunctionName) {
        // 保存日志
        saveMessageLog(phoneNum, content, projectName, serviceName, classFunctionName);
        // 发送短信
        String resultStr = doGetRequest(setSmsParam(phoneNum, content));
    }

    /**
     * @Title:
     * @Description: 设置发送参数
     * @param phoneNum 手机号
     * @param content 短信内容
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-16 16:44:23
     */
    private String setSmsParam(String phoneNum, String content){
        //目标号码，必填参数
        String da = "86"+phoneNum;
        //下行内容以及编码格式，必填参数
        int dc = 15;
        String sm = encodeHexStr(dc, content);//下行内容进行Hex编码，此处dc设为15，即使用GBK编码格式
        //组成url字符串
        String smsUrl = etonenetParam.getMtUrl() + "?command=" + etonenetParam.getCommand() + "&spid=" + etonenetParam.getSpid()
                + "&sppassword=" + etonenetParam.getSppassword() + "&spsc=" + etonenetParam.getSpsc() + "&sa=" + etonenetParam.getSa()
                + "&da=" + da + "&sm=" + sm + "&dc=" + dc;
        return smsUrl;
    }

    /**
     * @Title:
     * @Description: 短信内容编码
     * @param dataCoding 编码格式
     * @param realStr url
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-16 16:44:23
     */
    //
    private String encodeHexStr(int dataCoding, String realStr) {
        String hexStr = null;
        if (realStr != null) {
            byte[] data = null;
            try {
                if (dataCoding == 15) {
                    data = realStr.getBytes("GBK");
                } else if ((dataCoding & 0x0C) == 0x08) {
                    data = realStr.getBytes("UnicodeBigUnmarked");
                } else {
                    data = realStr.getBytes("ISO8859-1");
                }
            } catch (UnsupportedEncodingException e) {
                logger.error("短信内容编码error",e);
                e.printStackTrace();
            }

            if (data != null) {
                int len = data.length;
                char[] out = new char[len << 1];
                // two characters form the hex value.
                for (int i = 0, j = 0; i < len; i++) {
                    out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
                    out[j++] = DIGITS[0x0F & data[i]];
                }
                hexStr = new String(out);
            }
        }
        return hexStr;
    }

    /**
     * 发送http GET请求，并返回http响应字符串
     *
     * @param urlstr 完整的请求url字符串
     * @return
     */
    public static String doGetRequest(String urlstr) {
        String res = null;
        try {
            URL url = new URL(urlstr);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-Type", "text/html; charset=GB2312");
            System.setProperty("sun.net.client.defaultConnectTimeout", "5000");//jdk1.4换成这个,连接超时
            System.setProperty("sun.net.client.defaultReadTimeout", "10000"); //jdk1.4换成这个,读操作超时
            //httpConn.setConnectTimeout(5000);//jdk 1.5换成这个,连接超时
            //httpConn.setReadTimeout(10000);//jdk 1.5换成这个,读操作超时
            httpConn.setDoInput(true);
            int rescode = httpConn.getResponseCode();
            if (rescode == 200) {
                BufferedReader bfw = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                res = bfw.readLine();
            } else {
                res = "Http request error code :" + rescode;
            }
        } catch (Exception e) {
            logger.error("送http GET请求error",e);
            e.printStackTrace();
        }
        System.out.println(res);
        return res;
    }

    /**
     * 保存发送短信log
     *
     * @param phoneNum 手机号码
     * @param content 短信内容
     * @param projectName 工程名称
     * @param serviceName 服务名称
     * @param classFunctionName 方法路径
     */
    private void saveMessageLog(String phoneNum,String content,String projectName,String serviceName,String classFunctionName){
        Date nowDate = new Date();
        MessageLog messageLog = new MessageLog();
        messageLog.setPhone(phoneNum);
        messageLog.setContent(content);
        messageLog.setProjectName(projectName);
        messageLog.setServiceName(serviceName);
        messageLog.setClassFunctionName(classFunctionName);
        messageLog.setSendTime(nowDate);
        messageLog.setCreateTime(nowDate);
        messageLog.setUpdateTime(nowDate);
        messageLogRepository.insertData(messageLog);
    }

}
