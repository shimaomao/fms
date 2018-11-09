package cn.com.leadu.fms.business.service;/**
 * Created by ningyangyang on 2018/6/14.
 */

import java.util.Date;
import java.util.Map;

/**
 * @Title: fms
 * @Description:  消息提示共通
 * @author: ningyangyang
 * @date 2018/6/14 20:50
 */
public interface CommonSysUserInfoService {

    /**
     * @Title:
     * @Description:   产生消息提示信息
     * @return
     * @param userType 接收人类型(用户，角色，组织机构)
     * @param userCode 接收人代码
     * @param infoType 短信模板代码
     * @param variables 替换参数
     * @param infoCodeType 消息业务类型
     * @throws
     * @author ningyangyang
     * @date 2018/06/14 02:29:41
     */
    void infoPoint(String userType, String userCode, String infoType, Map<String,String> variables, String infoCodeType,String defaultTpl);
}
