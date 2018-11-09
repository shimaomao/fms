package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActInsurClaimCheckUtils;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehMaintainEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.JsonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.insurance.repository.ContInsurClaimRepository;
import cn.com.leadu.fms.data.postbiz.repository.VehMaintainRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.finance.service.ContInsurClaimPayService;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName:
 * @Description: 保险理赔制单付款Service
 * @date
 */
@Service
public class ContInsurClaimPayServiceImpl implements ContInsurClaimPayService {
    /**
     * @Fields  : 保险理赔repository
     */
    @Autowired
    private ContInsurClaimRepository contInsurClaimRepository;

    /**
     * * @Fields  : 财务付款表Repository层
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 审批日志录入service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 通用pdfservice
     * @author yanfengbo
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * @Fields : 车辆维修记录Repository
     */
    @Autowired
    private VehMaintainRepository vehMaintainRepository;

    /**
     * @param contInsurClaimVo
     * @Description: 保险理赔制单
     * @param:
     * @return:
     * @Author:
     */
    @Override
    @Transactional
    public void makeVoucher(ContInsurClaimVo contInsurClaimVo) {
        ActRuTaskVo actRuTaskVo = null;
        String act = "";
        //流程引擎
        if("0".equals(contInsurClaimVo.getActType())){//通过
            act = ActTypeEnums.APPROVAL.getType();
            actRuTaskVo = ActInsurClaimCheckUtils.approvalAgree(contInsurClaimVo.getTaskId());
            //更新财务付款表
            ContPay contPay = new ContPay();
            contPay.setContPayId(contInsurClaimVo.getContPayId());
            contPay.setPayAccBank(contInsurClaimVo.getPayAccBank());
            contPay.setPayAccountName(contInsurClaimVo.getPayAccountName());
            contPay.setPayAccountNo(contInsurClaimVo.getPayAccountNo());
            contPay.setPayAccBranch(contInsurClaimVo.getPayAccBranch());
            contPayRepository.updateByPrimaryKeySelectiveData(contPay);
            //审批通过操作
            this.approveCommon(contInsurClaimVo,act,actRuTaskVo);
        }else{//退回
            act = ActTypeEnums.SENDBACK.getType();
            actRuTaskVo = ActInsurClaimCheckUtils.approvalReturnSuperior(contInsurClaimVo.getTaskId());
            //审批退回操作
            this.approveReturnCommon(contInsurClaimVo,act,actRuTaskVo);
        }
    }

    /**
     * @param contInsurClaimVo
     * @Description: 保险理赔财务付款
     * @param:
     * @return:
     * @Author:
     */
    @Override
    @Transactional
    public void payment(ContInsurClaimVo contInsurClaimVo) {
        ActRuTaskVo actRuTaskVo = null;
        String act = "";
        //流程引擎
        if("0".equals(contInsurClaimVo.getActType())){//通过
            act = ActTypeEnums.SUBMIT.getType();
            actRuTaskVo = ActInsurClaimCheckUtils.approvalAgree(contInsurClaimVo.getTaskId());
            //更新财务付款表
            ContPay contPay = new ContPay();
            contPay.setContPayId(contInsurClaimVo.getContPayId());
            contPay.setPayStatus(PayStatusEnums.REQUEST.getType());
            contPayRepository.updateByPrimaryKeySelectiveData(contPay);
            //录入车辆维修记录
            saveVehMaintainFromInsurClaim(contInsurClaimVo,contInsurClaimVo.getContInsurClaimNo());
            //审批操作
            this.approveCommon(contInsurClaimVo,act,actRuTaskVo);
        }else{//退回
            act = ActTypeEnums.SENDBACK.getType();
            actRuTaskVo = ActInsurClaimCheckUtils.approvalReturnSuperior(contInsurClaimVo.getTaskId());
            //审批退回操作
            this.approveReturnCommon(contInsurClaimVo,act,actRuTaskVo);
        }
    }

    /**
     * @param contInsurClaimVo
     * @param act
     * @param actRuTaskVo
     * @Description: 审批通过操作
     * @param:
     * @return:
     * @Author:
     */
    @Transactional
    public void approveCommon(ContInsurClaimVo contInsurClaimVo, String act, ActRuTaskVo actRuTaskVo) {
//        String claimStatus = contInsurClaimVo.getInsurClaimStatus();
//        if (claimStatus.equals(InsurClaimStatusEnums.TO_BE_REVIEW.getType())||claimStatus.equals(InsurClaimStatusEnums.RETURN_LOAN.getType())){
//            claimStatus = InsurClaimStatusEnums.AUDIT_PASS.getType();
//        }else if (claimStatus.equals(InsurClaimStatusEnums.AUDIT_PASS.getType())){
//            claimStatus = InsurClaimStatusEnums.WAIT_LOAN.getType();
//        }

        //更新状态
        ContInsurClaim contInsurClaim = new ContInsurClaim();
        contInsurClaim.setInsurClaimStatus(actRuTaskVo.getTaskCode());
        Example example = SqlUtil.newExample(ContInsurClaim.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contInsurClaimNo",contInsurClaimVo.getServiceId());
        //当前节点用户
        contInsurClaim.setPresentUser(actRuTaskVo.getNextAssignee());
        contInsurClaimRepository.updateByExampleSelectiveData(contInsurClaim,example);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contInsurClaimVo.getUser());
        workflowLog.setWfLogNo(contInsurClaimVo.getContInsurClaimNo());
        workflowLog.setWfLogType(BizTypeEnums.CONT_INSUR_CLAIM.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contInsurClaimVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }


    /**
     * @param contInsurClaimVo
     * @param act
     * @param actRuTaskVo
     * @Description: 审批退回操作
     * @param:
     * @return:
     * @Author:
     */
    @Transactional
    public void approveReturnCommon(ContInsurClaimVo contInsurClaimVo, String act, ActRuTaskVo actRuTaskVo) {
//        String claimStatus = contInsurClaimVo.getInsurClaimStatus();
//        if (claimStatus.equals(InsurClaimStatusEnums.TO_BE_REVIEW.getType())||claimStatus.equals(InsurClaimStatusEnums.RETURN_LOAN.getType())){
//            claimStatus = InsurClaimStatusEnums.SEND_BACK_REVIEW.getType();
//        }else if (claimStatus.equals(InsurClaimStatusEnums.AUDIT_PASS.getType())){
//            claimStatus = InsurClaimStatusEnums.RETURN_LOAN.getType();
//        }
        //更新状态
        ContInsurClaim contInsurClaim = new ContInsurClaim();
        contInsurClaim.setInsurClaimStatus(actRuTaskVo.getTaskCode());
        Example example = SqlUtil.newExample(ContInsurClaim.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contInsurClaimNo",contInsurClaimVo.getServiceId());
        //当前节点用户
        contInsurClaim.setPresentUser(actRuTaskVo.getNextAssignee());
        contInsurClaimRepository.updateByExampleSelectiveData(contInsurClaim,example);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contInsurClaimVo.getUser());
        workflowLog.setWfLogNo(contInsurClaimVo.getContInsurClaimNo());
        workflowLog.setWfLogType(BizTypeEnums.CONT_INSUR_CLAIM.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contInsurClaimVo.getRemark1());

        //workflowLog.setWfLogSubNo("");
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 流程结束后录入一条车辆维修记录
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public void saveVehMaintainFromInsurClaim(ContInsurClaimVo contInsurClaimVo,String contInsurClaimNo){
        //录入车辆维修记录
        VehMaintain vehMaintain = new VehMaintain();
        //来源
        vehMaintain.setMaintainFlag(VehMaintainEnums.MAINTAINCLAIM.getType());
        //理赔号
        vehMaintain.setContInsurClaimNo(contInsurClaimNo);
        //车架号
        vehMaintain.setVinNo(contInsurClaimVo.getVinNo());
        //发动机号
        vehMaintain.setEngineNo(contInsurClaimVo.getEngineNo());
        //车牌号
        vehMaintain.setVehicleLicenseNo(contInsurClaimVo.getVehicleLicenseNo());
        //维修日期--->事故日期
        vehMaintain.setMaintainDate(contInsurClaimVo.getAccidentTime());
        //维修金额--->理赔金额
        vehMaintain.setMaintainAmount(contInsurClaimVo.getClaimAmount());
        //维修备注--->情况说明
        vehMaintain.setMaintainMemo(contInsurClaimVo.getDescription());
        vehMaintainRepository.insertData(vehMaintain);
    }

    /**
     * @Title:
     * @Description: 保险理赔付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public String printContInsurClaim(ContInsurClaimVo contInsurClaimVo){
        if(contInsurClaimVo == null){
            throw new FmsServiceException("未找到相关数据");
        }
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(contInsurClaimVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        if(contInsurClaimVo.getClaimAmount()!=null){
            pdfVariables.put("claimAmount", StringUtils.defaultString(contInsurClaimVo.getClaimAmount().toString()));
        }
        pdfVariables.put("accountName", StringUtils.defaultString(contInsurClaimVo.getAccountName()));
        pdfVariables.put("recAccBranch",StringUtils.defaultString(contInsurClaimVo.getAccBank()+" "+contInsurClaimVo.getRecAccBranch()));
        pdfVariables.put("accountNo", contInsurClaimVo.getAccountNo());
        pdfVariables.put("payAccountName", contInsurClaimVo.getPayAccountName());
        if(contInsurClaimVo.getPayAccBank() != null && contInsurClaimVo.getPayAccBranch() != null){
            pdfVariables.put("payAccBranch",StringUtils.defaultString(contInsurClaimVo.getPayAccBank()+" "+contInsurClaimVo.getPayAccBranch()));
        }
        pdfVariables.put("payAccountNo", contInsurClaimVo.getPayAccountNo());
        pdfVariables.put("groupName", contInsurClaimVo.getGroupName());
        pdfVariables.put("name", contInsurClaimVo.getName());
        pdfVariables.put("vinNo", contInsurClaimVo.getVinNo());
        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_CONT_INSUR_CLAIM.getType());
        return filePath;
    }
}
