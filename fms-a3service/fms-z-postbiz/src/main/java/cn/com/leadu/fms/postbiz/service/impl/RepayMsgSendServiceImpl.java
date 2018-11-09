package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonMessageService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.CompanyType;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.IntegerUtils;
import cn.com.leadu.fms.common.util.PatternMatcherUtils;
import cn.com.leadu.fms.data.baseinfo.repository.BasMsgRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedGetPhoneNumVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.postbiz.rpc.finance.ContRepaySkedRpc;
import cn.com.leadu.fms.postbiz.rpc.prebiz.ContInsuranceRpc;
import cn.com.leadu.fms.postbiz.rpc.prebiz.ContractRpc;
import cn.com.leadu.fms.postbiz.rpc.prebiz.CstmCompanyRpc;
import cn.com.leadu.fms.postbiz.rpc.prebiz.CstmPersonRpc;
import cn.com.leadu.fms.postbiz.rpc.system.SysParamRpc;
import cn.com.leadu.fms.postbiz.rpc.system.SysTplTypeRpc;
import cn.com.leadu.fms.postbiz.rpc.thirdinterface.MessageSendRpc;
import cn.com.leadu.fms.postbiz.service.RepayMsgSendService;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @description: 还款计划短信发送service
 * @author:ningyangyang
 * @since:2018/5/9
 */
@Service
@Slf4j
public class RepayMsgSendServiceImpl implements RepayMsgSendService {

    /**
     * @Fields  : 系统常量rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 合同信息rpc
     */
    @Autowired
    private ContractRpc contractRpc;

    /**
     * @Fields  : 合同融资还款计划rpc
     */
    @Autowired
    private ContRepaySkedRpc contRepaySkedRpc;

    /**
     * @Fields  : 合同融资还款计划Repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;


    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Fields  : 短信发送service
     */
    @Autowired
    private CommonMessageService  CommonMessageService;

    /**
     * @Fields  : 企业客户信息rpc
     */
    @Autowired
    private CstmCompanyRpc cstmCompanyRpc;

    /**
     * @Fields  : 个人客户信息rpc
     */
    @Autowired
    private CstmPersonRpc cstmPersonRpc;

    /**
     * @Fields  : 短信发送管理repository
     */
    @Autowired
    private BasMsgRepository basMsgRepository;

    /**
     * @Fields  : 短信模板
     */
    @Autowired
    private SysTplTypeRpc sysTplTypeRpc;

    /**
     * @Fields  : 车辆保险rpc
     */
    @Autowired
    private ContInsuranceRpc contInsuranceRpc;

    /**
     * @Fields  : 短信发送rpc
     */
    @Autowired
    private MessageSendRpc messageSendRpc;
    /**
     * @Title:
     * @Description: 定时分类发送短信
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-9 11:52:38
     */
    @Override
    @Transactional
    public void messageSend() {
        //2018.10.24增加需求
        //短信发送管理增加条件
        //租金类型是租金

        //还款短信提醒
        contRepaySkedMessageSend();

        //还款日当天短信发送
        contDueDateSkedMessageSend();

        //逾期后每天短信发送
//        contOverdueSkedMessageSend();

    }

    //还款短信提醒
    public void contRepaySkedMessageSend(){
        String messageRemindingDays;   //短信提醒天数
        try {
            messageRemindingDays = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.MESSAGE_REMINDING_DAYS));   //短信还款提醒天数
            //overdueRemindingFrequency  =  ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.OVERDUE_REMINDING_FREQUENCY));  //还款提醒频率
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw  new FmsServiceException("获取常量失败");
        }
        ContRepaySkedVo contRepaySked = new ContRepaySkedVo();
        //
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, IntegerUtils.getIntValue(messageRemindingDays));
        String jugDate = DateUtils.dateToStr(calendar.getTime(),DateUtils.formatStr_yyyyMMdd);

        contRepaySked.setJugDate(jugDate);
        // 租金类型是租金 0-租金 1-首付 2-尾付 3-提前还款 4-转固定资产
        contRepaySked.setRepayType(RepayTypeEnums.RENT.getType());
        contRepaySked.setApplyType(ApplyTypeEnums.PERSON.getType());
//        contRepaySked.setOverdueStatus(OverDueStatusEnums.NOT_OVERDUE.getType());
        contRepaySked.setCompanyType(CompanyType.sale.getType());
        contRepaySked.setRepayStatus(RepayStatusEnums.PREPAYMENT.getType());
        Map<String,Object> contRepaySkedVoMap = contRepaySked == null?null:(Map) JSON.toJSON(contRepaySked);
        List<ContRepaySkedVo> contRepaySkedVoList = null;     //即将到还款日期提前短信提醒
        try {
            contRepaySkedVoList = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findOnceOverdueSked(contRepaySkedVoMap));   //查找快要到期短信
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw  new FmsServiceException("获取还款计划表失败");
        }
        sendMessage(contRepaySkedVoList,TplTypeKeyEnums.DXMB_REPAY.getType());
    }

    /**
     * @Title:
     * @Description: 还款日当天早上10点短信发送
     * @param
     * @return void
     *
     * @throws
     * @author qinmuqiao
     * @date 2018-5-9 11:52:38
     */
    public  void  contDueDateSkedMessageSend(){
        ContRepaySkedVo contRepaySked = new ContRepaySkedVo();

        String jugDate = DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMdd);
        contRepaySked.setJugDate(jugDate);
        contRepaySked.setCompanyType(CompanyType.sale.getType());
        contRepaySked.setRepayType(RepayTypeEnums.RENT.getType());
        List<ContRepaySkedVo> contRepaySkedVoList = null;     //即将到还款日期提前短信提醒
        contRepaySkedVoList = contRepaySkedRepository.selecContDueDateSkedMessageSend(contRepaySked);//查找快要到期短信
        sendMessage(contRepaySkedVoList,TplTypeKeyEnums.DUEDATE_SEND_MESSAGE.getType());
    }

    /**
     * @Title:
     * @Description: 逾期后每天早上10点短信发送
     * @param
     * @return void
     *
     * @throws
     * @author qinmuqiao
     * @date 2018-5-9 11:52:38
     */
    public void contOverdueSkedMessageSend(){

        ContRepaySkedVo contRepaySked = new ContRepaySkedVo();
        contRepaySked.setCompanyType(CompanyType.sale.getType());
        contRepaySked.setRepayType(RepayTypeEnums.RENT.getType());
        List<ContRepaySkedVo> contRepaySkedVoList = null;
        Integer overDueDateMax =  Integer.parseInt(commonConstantService.findSysParamValue(CommonParamConstants.CONT_REPAY_MAXDAYS));
        Integer overDueDateMin =  Integer.parseInt(commonConstantService.findSysParamValue(CommonParamConstants.CONT_REPAY_MINDAYS));

        contRepaySkedVoList = contRepaySkedRepository.selecContOverdueSkedMessageSend(contRepaySked,overDueDateMax,overDueDateMin);   //查找快要到期短信
        //发送短信
        sendMessage(contRepaySkedVoList,TplTypeKeyEnums.OVERDUEDATE_SEND_MESSAGE.getType());
    }

    /**
     * @Title:
     * @Description: 发送短信
     * @param
     * @return void
     *
     * @throws
     * @author qinmuqiao
     * @date 2018-5-9 11:52:38
     */
    public  void sendMessage(List<ContRepaySkedVo> contRepaySkedVoList , String msgType){
        String sysTplType;
        try {

            sysTplType  =  ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(msgType)).getTplContent();
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw  new FmsServiceException("获取短信模板失败");
        }
        //声明获取apply_no的list  获取电话号码
        List<String> applyNos = new ArrayList();
        if(ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedVoList)){
            String message = "";
            Map<String,List<String>> phoneNumMap ;
            for(ContRepaySkedVo contRepay:contRepaySkedVoList){
                applyNos.add(contRepay.getApplyNo());
            }
            phoneNumMap = getTelephoneNum(applyNos);

            for(ContRepaySkedVo contRepay:contRepaySkedVoList){
                if (TplTypeKeyEnums.DXMB_REPAY.getType().equals(msgType)){
                    String repayDate = DateUtils.dateToStr(contRepay.getRepayDate(),DateUtils.formatStr_yyyyMMdd);
                    Map<String,String> map = new HashMap<>();
                    map.put("repayDate",repayDate);
                    message = PatternMatcherUtils.replaceTemplateVariables(sysTplType,map);
                }else if (TplTypeKeyEnums.DUEDATE_SEND_MESSAGE.getType().equals(msgType)){
                    message =  sysTplType;
                }else if(TplTypeKeyEnums.OVERDUEDATE_SEND_MESSAGE.getType().equals(msgType)){
                    //获取还款日期
                    String repayDate = DateUtils.dateToStr(contRepay.getRepayDate(),DateUtils.formatStr_yyyyMMddChinese);
                    Map<String,String> map = new HashMap<>();
                    map.put("repayDate",repayDate);

                    //获取应付租金
                    String rent = (contRepay.getRentActual() == null ? "0" :contRepay.getRentActual()).toString();
                    map.put("borrowMoney",rent);

                    //计算俩个日期相差
                    String overdueDay = String.valueOf(DateUtils.getDay(contRepay.getRepayDate(),DateUtils.getNowDate()));
                    map.put("overDueDays",overdueDay);

                    //获取罚息金额
                    String overDueAmount = BigDecimalUtils.adds(contRepay.getRentActual(), contRepay.getOverdueAmount()).toString();
                    map.put("overDueAmount",overDueAmount);

                    message = PatternMatcherUtils.replaceTemplateVariables(sysTplType,map);
                }
                System.out.println( "========" + contRepay.getMobileNo()+ "===" + message + "===" + TplTypeKeyEnums.DXMB_REPAY.getType());
                if (ArrayUtils.isNotNullAndLengthNotZero(phoneNumMap.get(contRepay.getApplyNo()))){
                    for (String mobileNo : phoneNumMap.get(contRepay.getApplyNo())){
                        try {
                            ResponseEntityUtils.getRestResponseData(messageSendRpc.sendMessage(mobileNo,message,"合同号："+contRepay.getContNo(), msgType));
                        } catch (FmsRpcException ex) {
                            ex.printStackTrace();
                            log.error(ex.getMessage());
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

}
