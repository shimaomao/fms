package cn.com.leadu.fms.business.service.impl;/**
 * Created by ningyangyang on 2018/6/14.
 */

import cn.com.leadu.fms.business.common.util.activiti.ActUtils;
import cn.com.leadu.fms.business.rpc.system.SysTplTypeRpc;
import cn.com.leadu.fms.business.service.CommonSysUserInfoService;
import cn.com.leadu.fms.common.constant.enums.CommonInfoLevel;
import cn.com.leadu.fms.common.constant.enums.CommonInfoType;
import cn.com.leadu.fms.common.constant.enums.CommonUserInfoReadStatusEnums;
import cn.com.leadu.fms.common.constant.enums.CommonUserUnitsEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.PatternMatcherUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.system.repository.SysInfoRepository;
import cn.com.leadu.fms.data.system.repository.SysUserInfoRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.system.entity.SysInfo;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Title: fms
 * @Description: 消息提示共通
 * @author: ningyangyang
 * @date 2018/6/14 17:37
 */
@Service
@Slf4j
public class CommonSysUserInfoServiceImpl implements CommonSysUserInfoService{

    /**
     *  短信模板rpc
     */
    @Autowired
    private  SysTplTypeRpc sysTplTypeRpc;

    /**
     *  消息Repository
     */
    @Autowired
    private  SysInfoRepository SysInfoRepository;

   /**
     *  用户消息Repository
     */
    @Autowired
    private  SysUserInfoRepository sysUserInfoRepository;
    /**
     * @Title:
     * @Description:   产生消息提示信息
     * @return
     * @param userType 接收人类型(用户，角色，组织机构)
     * @param userCode 接收人代码
     * @param infoType 短信模板代码
     * @param variables 要替换的值
     * @param infoCodeType 消息业务类型
     * @param defaultTpl 默认模板
     * @throws
     * @author ningyangyang
     * @date 2018/06/14 02:29:41
     */
    public  void infoPoint(String userType, String userCode, String infoType, Map<String,String> variables, String infoCodeType,String defaultTpl){
        List<String> approvalUsers = getNextUser(userCode,userType);
        //获取短信模板
        SysTplType  sysTplType = null;
        try {
            sysTplType  =  ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(infoType));

        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw  new FmsServiceException("未取得消息模板");
        }
        String info = "";
        if(sysTplType != null){
            info = sysTplType.getTplContent();
        }else{
            info = defaultTpl;
        }
        if(StringUtils.isTrimBlank(info)){
            throw new FmsServiceException("未获取到消息模板");
        }
        String message =  PatternMatcherUtils.replaceTemplateVariables(info,variables);  //替换模板中的变量
        SysInfo sysInfo = new SysInfo();
        sysInfo.setInfoContent(message);
        sysInfo.setInfoType(CommonInfoType.TASK.getType());
        sysInfo.setInfoLevel(CommonInfoLevel.SIMPLE.getLevel());
        SysInfoRepository.insertData(sysInfo);
        List<SysUserInfo> sysUserInfoList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(approvalUsers)){
            for(String user:approvalUsers){
                SysUserInfo sysUserInfo = new SysUserInfo();
                sysUserInfo.setInfoId(sysInfo.getInfoId());
                sysUserInfo.setUser(user);
                sysUserInfo.setReadStatus(CommonUserInfoReadStatusEnums.UNREAD.getStatus());
                sysUserInfo.setInfoCodeType(infoCodeType);
                sysUserInfoList.add(sysUserInfo);
            }
        }
        sysUserInfoRepository.insertDataList(sysUserInfoList);

    }

    /**
     * @Title:
     * @Description: 根据code和type获取具体下一步代理人
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  21:07
     */
    public  List<String> getNextUser(String code,String userType){
        List<String> approvalUsers = new ArrayList<>();

        if(CommonUserUnitsEnums.USER.getUnit().equals(userType)){
            //个人
            approvalUsers.add(code);
        }else if(CommonUserUnitsEnums.ROLE.getUnit().equals(userType)){
            //角色
            approvalUsers = ActUtils.findSysUserLoginNamesByRole(code);
        }else if(CommonUserUnitsEnums.GROUP.getUnit().equals(userType)){
            //组织机构
            approvalUsers = ActUtils.findSysUserLoginNamesByGroupCode(code);
        }
        return approvalUsers;
    }
}
