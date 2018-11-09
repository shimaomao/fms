package cn.com.leadu.fms.insurance.service.impl;

import cn.com.leadu.fms.business.service.CommonSysUserInfoService;
import cn.com.leadu.fms.business.service.impl.CommonSysUserInfoServiceImpl;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.CommonUserUnitsEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.FinFlagEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.InfoCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.CompanyType;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.IntegerUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.insurance.repository.RenewalRegisterRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContInsuranceRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.common.constant.enums.insurance.InsuranceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.RenewalStatusEnums;
import cn.com.leadu.fms.insurance.rpc.prebiz.ContInsuranceRpc;
import cn.com.leadu.fms.insurance.rpc.system.SysParamRpc;
import cn.com.leadu.fms.insurance.service.InsuranceRenewalService;
import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

/**
 * @description:  续保任务
 * @author:ningyangyang
 * @since:2018/5/17
 */
@Slf4j
@Service
public class InsuranceRenewalServiceImpl implements InsuranceRenewalService {

    /**
     * @Fields  : 系统常量rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 车辆保险rpc
     */
    @Autowired
    private ContInsuranceRpc contInsuranceRpc;

    /**
     * @Fields  : 车辆保险repository
     */
    @Autowired
    private ContInsuranceRepository contInsuranceRepository;

    /**
     * @Fields  : 续保任务登记repository
     */
    @Autowired
    private RenewalRegisterRepository renewalRegisterRepository;


    /**
     * @Fields  : 消息提示共通repository
     */
    @Autowired
    private CommonSysUserInfoService commonSysUserInfoService;

    /**
     * @Title:
     * @Description: 续保任务生成
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 11:52:38
     */
    @Override
    @Transactional
    public void insuranceRenewalTask() {

        Date nowDate = new Date();//获取当前时间
        String insuranceRemindingDays = null;
        try {
            insuranceRemindingDays = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.INSURANCE_REMINDING_DAYS));   //保险到期提醒天数
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("请求失败");
        }
        Long times = Long.valueOf(insuranceRemindingDays)*24*3600*1000;
        Date jugDay = new Date(nowDate.getTime() + times);    //时间
        String endDay =  DateUtils.dateToStr(jugDay,DateUtils.formatStr_yyyyMMdd);
        ContInsuranceVo cont =  new ContInsuranceVo();
        cont.setInValidTime(endDay);
        cont.setInsuranceStatus(InsuranceStatusEnums.INSURANCE_VALID.getType());
        Map<String,Object> contInsuranceMap = cont==null?null:(Map) JSON.toJSON(cont);
        List<ContInsuranceVo> contInsuranceList = null;
        try {
            contInsuranceList = ResponseEntityUtils.getRestResponseData(contInsuranceRpc.findContInsuranceByStatus(contInsuranceMap));
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("请求失败");
        }
        // String insuranceRemindingFrequency  =  ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(INSURANCE_REMINDING_FREQUENCY.getType()));  //保险失效提醒频率
        List<RenewalRegister> renewalRegisterList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(contInsuranceList)){
            for(ContInsuranceVo contInsurance: contInsuranceList){
                //(保险失效日+30天 < 租赁期限结束日) || 业务类型是经销商
                if((DateUtils.getAddDay(contInsurance.getValidEndDay(),30).getTime()<contInsurance.getLeaseTermEndDate().getTime())
                        || CompanyType.sale.getType().equals(contInsurance.getCompanyType1()) ){

                    RenewalRegister renewalRegister = new RenewalRegister();
                    renewalRegister.setContNo(contInsurance.getContNo());
                    renewalRegister.setRenewalDeadlineDate(contInsurance.getValidEndDay());
                    if(contInsurance.getFinAmount().compareTo(new BigDecimal(0))==1){
                        renewalRegister.setFinFlag(FinFlagEnums.FIN_INSUR.getType());
                    }else {
                        renewalRegister.setFinFlag(FinFlagEnums.NOT_FIN_INSUR.getType());
                    }
                    renewalRegister.setFinAmount(contInsurance.getFinAmount());
                    renewalRegister.setRenewalStatus(RenewalStatusEnums.TO_BE_SUBMITTED.getType());
                    renewalRegister.setCurrentInsuranceId(contInsurance.getContVehinsId());
                    renewalRegisterList.add(renewalRegister);
                }
                //saveRenewalRegister(renewalRegister,contInsurance.getContNo(),contInsurance.getValidEndDay());
            }

            if(ArrayUtils.isNotNullAndLengthNotZero(renewalRegisterList)){
                renewalRegisterRepository.insertDataList(renewalRegisterList);
                Map<String,String> map = new HashMap<>();
                Calendar calendar = Calendar.getInstance();
                map.put("date",DateUtils.dateToStr(calendar.getTime(),DateUtils.formatStr_yyyyMMdd));
                map.put("count",String.valueOf(renewalRegisterList.size()));
                String defaultTpl = "${date}:生成${count}条新的续保任务!";
                commonSysUserInfoService.infoPoint(CommonUserUnitsEnums.ROLE.getUnit(),"ZG103", TplTypeKeyEnums.RENEWAL_REGISTER.getType(),map, InfoCodeTypeEnums.INSUR_RENEWAL.getType(),defaultTpl);
            }
        }
    }

    /**
     * @Title:
     * @Description: 续保任务登记
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 11:52:38
     */
//    void saveRenewalRegister(RenewalRegister renewalRegister,String contNo,Date date){
//        renewalRegister.setContNo(contNo);
//        renewalRegister.setRenewalDeadlineDate(date);
//        //renewalRegister.setFinAmount();
//        renewalRegister.setRenewalStatus(RenewalStatusEnums.TO_BE_SUBMITTED.getType());
//        renewalRegisterRepository.insertData(renewalRegister);
//    }
    /**
     * @Title:
     * @Description: 更新车辆保险信息
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 11:52:38
     */
//    void updateContInsurance(String contNo){
//        Date nowDate = new Date();      //获取当前时间
//        ContInsurance contInsurance =  new ContInsurance();
//        contInsurance.setContNo(contNo);
//        contInsurance.setInsuranceStatus(InsuranceStatusEnums.INSURANCE_VALID.getType());
//        Map<String,Object> contInsuranceMap = contInsurance==null?null:(Map) JSON.toJSON(contInsurance);
//        try {
//            List<ContInsurance> contInsuranceList =   ResponseEntityUtils.getRestResponseData(contInsuranceRpc.findContInsurance(contInsuranceMap));
//            List<ContInsurance> validContInsuranceList = new ArrayList<>();
//            if(ArrayUtils.isNotNullAndLengthNotZero(contInsuranceList)){
//                if(contInsuranceList.size() > 1){
//                    ContInsurance max = contInsuranceList.get(0);
//                    for(int i = 1;i< contInsuranceList.size();i++){
//                        if(contInsuranceList.get(i).getValidEndDay().getTime()>max.getValidEndDay().getTime()){
//                            if(max.getValidEndDay().getTime()<nowDate.getTime()){
//                                max.setInsuranceStatus(MsgTplKeyEnums.INSURANCE_INVALID.getType());
//                                validContInsuranceList.add(max);
//                            }
//                            max = contInsuranceList.get(i);
//                        }else if(contInsuranceList.get(i).getValidEndDay().getTime()<nowDate.getTime()){
//                            contInsuranceList.get(i).setInsuranceStatus(MsgTplKeyEnums.INSURANCE_INVALID.getType());
//                            validContInsuranceList.add(contInsuranceList.get(i));
//                        }
//                    }
//                    if(ArrayUtils.isNotNullAndLengthNotZero(validContInsuranceList)){
//                        contInsuranceRepository.updateByPrimaryKeySelectiveDataList(validContInsuranceList);
//                    }
//                }
//            }
//        } catch (FmsRpcException e) {
//            e.printStackTrace();
//            throw new FmsServiceException("获取车辆保险信息失败");
//        }
//    }

}
