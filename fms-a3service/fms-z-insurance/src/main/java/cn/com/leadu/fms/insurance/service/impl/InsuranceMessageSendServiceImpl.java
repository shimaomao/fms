package cn.com.leadu.fms.insurance.service.impl;/**
 * Created by ningyangyang on 2018/6/15.
 */

import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.MsgStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.CompanyType;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.constant.enums.thirdinterface.MessageTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.baseinfo.repository.BasMsgRepository;
import cn.com.leadu.fms.data.insurance.repository.RenewalRegisterRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.insurance.rpc.finance.ContRepaySkedRpc;
import cn.com.leadu.fms.insurance.rpc.original.OrigFileRpc;
import cn.com.leadu.fms.insurance.rpc.system.SysParamRpc;
import cn.com.leadu.fms.insurance.rpc.system.SysTplTypeRpc;
import cn.com.leadu.fms.insurance.rpc.thirdinterface.MessageSendRpc;
import cn.com.leadu.fms.insurance.service.InsuranceMessageSendService;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedGetPhoneNumVo;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/6/15 14:18
 */
@Service
@Slf4j
public class InsuranceMessageSendServiceImpl implements InsuranceMessageSendService {

    @Autowired
    private OrigFileRpc origFileRpc;

    @Autowired
    private SysTplTypeRpc sysTplTypeRpc;

    @Autowired
    private MessageSendRpc messageSendRpc;

    @Autowired
    private RenewalRegisterRepository renewalRegisterRepository;

    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 合同融资还款计划Repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;


    /**
     * @Title:
     * @Description: 保险信息发送
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-6-15 11:52:38
     */
    @Override
    @Transactional
    public void insuranceMessageSend() {
//        renewalRegisterNotice();
        renewalPriorNotice();
//        insuranceExpire();
        //contRepaySkedMessageSend();
        //messageSendRpc.sendMessage("15605538283","尊敬的客户！您的爱车闽H203219于2018年车险已续保，强制保险标志于今日顺丰寄出，单号顺丰233123131233，注意查收！【万量融资租赁】",MessageEnums.OTHER);
    }

    /**
     * @Title:
     * @Description: 已续保短信通知
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-6-15 11:52:38
     */
    public void renewalRegisterNotice(){

        String template1 = null;
        String template2 = null;
        List<OrigFileVo> origFileVoList = null;
        try {
            //已续保通知
             template1 =   ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(TplTypeKeyEnums.ALREADY_RENEWAL.getType())).getTplContent();
            //保险卡寄出通知
             template2 =   ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(TplTypeKeyEnums.FILE_SEND.getType())).getTplContent();
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("取得短信模板失败");
        }
        try {
            origFileVoList =   ResponseEntityUtils.getRestResponseData(origFileRpc.findOrigFileVos());
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("获取续保信息失败");
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(origFileVoList)){
            List<BasMsg> basMsgList = new ArrayList<>();
            for(OrigFileVo origFileVo:origFileVoList){
               // BasMsg BasMsg = new BasMsg();
                String valiDate = DateUtils.dateToStr(origFileVo.getValidStartDay(),DateUtils.formatStr_yyyyMMdd);
                String inValidDate = DateUtils.dateToStr(origFileVo.getValidEndDay(),DateUtils.formatStr_yyyyMMdd);
                Map<String,String> map1 = new HashMap<>();
                map1.put("licenseNo",origFileVo.getVehicleLicenseNo());
                map1.put("validDate",valiDate);
                map1.put("inValidDate",inValidDate);
                String message1 = PatternMatcherUtils.replaceTemplateVariables(template1,map1);
                //template1.replace("${licenseNo}",origFileVo.getVehicleLicenseNo()).replace("${validDate}",valiDate).replace("${inValidDate}",inValidDate);
                origFileVo.setMobileNo(getMobileNo(origFileVo.getMobileNo()));
                try {
                    ResponseEntityUtils.getRestResponseData(messageSendRpc.sendMessage(origFileVo.getMobileNo(),message1,"", TplTypeKeyEnums.RENEWAL_COST_NOTICE.getType()));
                } catch (FmsRpcException ex) {
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                }

               // BasMsg BasMsg2 = new BasMsg();
                String year = DateUtils.dateToStr(origFileVo.getValidStartDay(),DateUtils.formatStr_yyyy);
                Map<String,String> map2 = new HashMap<>();
                map2.put("licenseNo",origFileVo.getVehicleLicenseNo());
                map2.put("year",year);
                map2.put("postNo",origFileVo.getPostNo());
                String message2 = PatternMatcherUtils.replaceTemplateVariables(template2,map2);
                //template2.replace("${licenseNo}",origFileVo.getVehicleLicenseNo()).replace("${year}",year).replace("${postNo}",origFileVo.getPostNo());
                try {
                    ResponseEntityUtils.getRestResponseData(messageSendRpc.sendMessage(origFileVo.getMobileNo(),message2,"", TplTypeKeyEnums.FILE_SEND.getType()));
                } catch (FmsRpcException ex) {
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                }
           }
        }
    }

    /**
     * @Title:
     * @Description: 未融资客户到期日前1个月短信通知续保
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-6-15 11:52:38
     */
    public void renewalPriorNotice(){
        RenewalRegisterVo renewalRegisterVo = new RenewalRegisterVo();
        Calendar calendar = Calendar.getInstance();
        String noticeRenewalDays;
        try {
            noticeRenewalDays = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.NOTICE_RENEWAL_DAYS));   //获取提前天数
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw  new FmsServiceException("获取常量失败");
        }
        calendar.add(Calendar.DATE, IntegerUtils.getIntValue(noticeRenewalDays));
        Date jugDay = calendar.getTime();
        String endDay =  DateUtils.dateToStr(jugDay,DateUtils.formatStr_yyyyMMdd);
        renewalRegisterVo.setJugTime(endDay);
        renewalRegisterVo.setApplyType(ApplyTypeEnums.PERSON.getType());
        renewalRegisterVo.setFinItem(FinItemEnums.INSURANCE.getCode());
        renewalRegisterVo.setCompanyType(CompanyType.sale.getType());
        List<ContInsuranceVo> contInsuranceVos = renewalRegisterRepository.selectContInsuranPerMonth(renewalRegisterVo);
        String template1 = null;
        try {
            template1 =   ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(TplTypeKeyEnums.ADVANCE_NOTICE.getType())).getTplContent();
        } catch (FmsRpcException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new FmsServiceException("取得短信模板失败");
        }
        //取得发送短信号码
        if(ArrayUtils.isNotNullAndLengthNotZero(contInsuranceVos)){
            List applyNos = contInsuranceVos.stream().map(ContInsuranceVo::getApplyNo).collect(Collectors.toList());
            //取得电话号码
            Map<String,List<String>> phoneNumMap = getTelephoneNum(applyNos);
            for(ContInsuranceVo contInsuranceVo:contInsuranceVos){
                // 融资期限未到期且 经销商以外的 做提醒
                if((DateUtils.getAddDay(contInsuranceVo.getValidEndDay(),30).getTime()<contInsuranceVo.getLeaseTermEndDate().getTime())
                        && !CompanyType.sale.getType().equals(contInsuranceVo.getCompanyType1())) {
                    String inValidDate = DateUtils.dateToStr(contInsuranceVo.getValidEndDay(), DateUtils.formatStr_yyyyMMdd);
                    Map<String, String> map1 = new HashMap<>();
                    map1.put("licenseNo", contInsuranceVo.getVehicleLicenseNo());
                    map1.put("inValidDate", inValidDate);
                    String message1 = PatternMatcherUtils.replaceTemplateVariables(template1, map1);
                    String memo = "合同号："+contInsuranceVo.getContNo();
                    //template1.replace("${licenseNo}",renewalRegister.getVehicleLicenseNo()).replace("${inValidDate}",inValidDate);
                    if (ArrayUtils.isNotNullAndLengthNotZero(phoneNumMap.get(contInsuranceVo.getApplyNo()))){
                        for (String mobileNo : phoneNumMap.get(contInsuranceVo.getApplyNo())){
                            try {
                                ResponseEntityUtils.getRestResponseData(messageSendRpc.sendMessage(mobileNo, message1, memo, TplTypeKeyEnums.ALREADY_RENEWAL.getType()));
                            } catch (FmsRpcException ex) {
                                ex.printStackTrace();
                                log.error(ex.getMessage());
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * @Title:获取手机号
     * @Description: 用申请号的list去获取手机号
     * @param
     * @return void
     *
     * @throws
     * @author qinmuqiao
     * @date 2018-5-9 11:52:38
     */
    public Map<String, List<String>> getTelephoneNum(List<String> applyNos){
        // 获取所有需要发送短信的联系信息
        List<ContRepaySkedGetPhoneNumVo> contactNoList = contRepaySkedRepository.getAllContactNosByApplyNo(applyNos);

        Map<String,List<String>> phoneNums = new HashMap<>();

        String mobileNo;
        if (ArrayUtils.isNotNullAndLengthNotZero(contactNoList)){
            for (ContRepaySkedGetPhoneNumVo phoneNumVo :contactNoList ) {
                // 如果手机号List不为空
                if(ArrayUtils.isNotNullAndLengthNotZero(phoneNumVo.getMobileNoList())){
                    // 对手机号进行循环
                    for (int x=0; x < phoneNumVo.getMobileNoList().size(); x++){
                        for(int i = 0; i<phoneNumVo.getMobileNoList().get(x).toCharArray().length;i++){
                            // 校验手机号并进行截取
                            if(Character.isDigit(phoneNumVo.getMobileNoList().get(x).toCharArray()[i])){
                                // 截取手机号
                                mobileNo = phoneNumVo.getMobileNoList().get(x).substring(i,i+11);
                                // 替换到指定位置
                                phoneNumVo.getMobileNoList().set(x, mobileNo);
                                break;
                            }
                        }
                    }
                }
                phoneNums.put(phoneNumVo.getApplyNo(),phoneNumVo.getMobileNoList());
            }
        }
        return  phoneNums;
    }

    /**
     * @Title:
     * @Description: 未融资客户到期前3日未能取得客户合规的续保保单
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-6-15 11:52:38
     */
    public void insuranceOrigNotice(){
        //到期前3日未能取得客户合规的续保保单
        Calendar calendar1 = Calendar.getInstance();
        String noticeVoucherDays;
        try {
            noticeVoucherDays = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.NOTICE_VOUCHER_DAYS));   //获取提前天数
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw  new FmsServiceException("获取常量失败");
        }
        calendar1.add(Calendar.DATE,IntegerUtils.getIntValue(noticeVoucherDays));
        Date jugDays = calendar1.getTime();   //时间
        String endDays =  DateUtils.dateToStr(jugDays,DateUtils.formatStr_yyyyMMdd);
        RenewalRegisterVo renewalRegisterVo = new RenewalRegisterVo();
        renewalRegisterVo.setJugTime(endDays);
        renewalRegisterVo.setMsgType("msg");
        renewalRegisterVo.setCompanyType(CompanyType.sale.getType());
        List<RenewalRegisterVo> RenewalRegisterVoList = renewalRegisterRepository.selectRenewalRegistersPriorMonth(renewalRegisterVo);
        String template2 = null;
        try {
            template2 =   ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(TplTypeKeyEnums.RENEWAL_COST_NOTICE.getType())).getTplContent();
        } catch (FmsRpcException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new FmsServiceException("取得短信模板失败");
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(RenewalRegisterVoList)){
            List<BasMsg> basMsgList = new ArrayList<>();
            for(RenewalRegisterVo renewalRegister:RenewalRegisterVoList){
                //BasMsg BasMsg = new BasMsg();
                String inValidDate = DateUtils.dateToStr(renewalRegister.getValidEndDay(),DateUtils.formatStr_yyyyMMdd);
                Map<String,String> map2 = new HashMap<>();
                map2.put("licenseNo",renewalRegister.getVehicleLicenseNo());
                map2.put("inValidDate",inValidDate);
                map2.put("finAmount",String.valueOf(renewalRegister.getFinAmount()));
                String message2 = PatternMatcherUtils.replaceTemplateVariables(template2,map2);
                //template2.replace("${licenseNo}",renewalRegister.getVehicleLicenseNo()).replace("${inValidDate}",inValidDate).replace("${finAmount}",String.valueOf(renewalRegister.getFinAmount()));
                renewalRegister.setMobileNo(getMobileNo(renewalRegister.getMobileNo()));
                try {
                    ResponseEntityUtils.getRestResponseData(messageSendRpc.sendMessage(renewalRegister.getMobileNo(),message2,"", TplTypeKeyEnums.RENEWAL_COST_NOTICE.getType()));
                } catch (FmsRpcException ex) {
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                }
            }
        }
    }
    /**
     * @Title:
     * @Description: 保险到期，租赁期满由客户自行续保
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-6-15 11:52:38
     */
    public void insuranceExpire(){
        RenewalRegisterVo renewalRegisterVo = new RenewalRegisterVo();
        String template = null;
        String noticeDay = null;
        try {
            noticeDay = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.INSURANCE_REMINDING_DAYS));
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("取得系统常量失败");
        }
        try {
            template = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(TplTypeKeyEnums.RENEWAL_BY_CUSTOMER.getType())).getTplContent();
        } catch (FmsRpcException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new FmsServiceException("取得短信模板失败");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,Integer.valueOf(noticeDay));
        //Long times = new Date(IntegerUtils.getValue(noticeDay)*24*3600*1000).getTime();
        Date jugDays =  calendar.getTime();   //时间
        String endDays =  DateUtils.dateToStr(jugDays,DateUtils.formatStr_yyyyMMdd);
        renewalRegisterVo.setJugTime(endDays);
        renewalRegisterVo.setCompanyType(CompanyType.sale.getType());
        List<RenewalRegisterVo> renewalRegisterVosList = renewalRegisterRepository.selectContInsurance(renewalRegisterVo);
        if(ArrayUtils.isNotNullAndLengthNotZero(renewalRegisterVosList)){
            List<BasMsg> basMsgList = new ArrayList<>();
            for(RenewalRegisterVo renewalRegister:renewalRegisterVosList){
                //BasMsg BasMsg = new BasMsg();
                String inValidDate = DateUtils.dateToStr(renewalRegister.getValidEndDay(),DateUtils.formatStr_yyyyMMdd);
                Map<String,String> map = new HashMap<>();
                map.put("licenseNo",renewalRegister.getVehicleLicenseNo());
                map.put("inValidDate",inValidDate);
                String message = PatternMatcherUtils.replaceTemplateVariables(template,map);
                //template.replace("${licenseNo}",renewalRegister.getVehicleLicenseNo()).replace("${inValidDate}",inValidDate);
                renewalRegister.setMobileNo(getMobileNo(renewalRegister.getMobileNo()));
                try {
                    ResponseEntityUtils.getRestResponseData(messageSendRpc.sendMessage(renewalRegister.getMobileNo(),message,"", TplTypeKeyEnums.RENEWAL_BY_CUSTOMER.getType()));
                } catch (FmsRpcException ex) {
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                }
//                saveSendMessage(renewalRegister.getMobileNo(),message,TplTypeKeyEnums.RENEWAL_BY_CUSTOMER.getType(),flag);
//                BasMsg.setTelNo(renewalRegister.getMobileNo());
//                BasMsg.setMsgText(message);
//                BasMsg.setMsgTypeKey(TplTypeKeyEnums.RENEWAL_BY_CUSTOMER.getType());
//                if(YesNoFlagEnums.YES.getType().equals(flag)){
//                    BasMsg.setMsgStatus(MsgStatusEnums.SEND_SUCCESS.getStatus());
//                }else{
//                    BasMsg.setMsgStatus(MsgStatusEnums.SEND_FAILURE.getStatus());
//                }
            }
        }
    }

        //手机号码转换
     public String getMobileNo(String mobileNo){
         String  telNo = null;
         if(StringUtils.isNotTrimBlank(mobileNo)){
             for(int i = 0; i<mobileNo.toCharArray().length;i++){
                 if(Character.isDigit(mobileNo.toCharArray()[i])){
                     telNo =  mobileNo.substring(i,i+11);
                     break;
                 }
             }
         }
         return telNo;
     }
}
