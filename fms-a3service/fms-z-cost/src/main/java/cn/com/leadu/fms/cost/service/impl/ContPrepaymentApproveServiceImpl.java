package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContPrepaymentEnums;
import cn.com.leadu.fms.business.common.util.activiti.ActContPrepaymentUtils;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonFinBackfillService;
import cn.com.leadu.fms.business.service.CommonSysUserInfoService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.CommonUserUnitsEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PrepaymDetailItemEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PrepaymentTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ChargeStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ExamTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.InputModeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.LicenseAttrEnums;
import cn.com.leadu.fms.common.constant.enums.finance.OverDueStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ReceiptBizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ReceiptExamStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayTypeEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.InfoCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.cost.rpc.finance.ContChargeRpc;
import cn.com.leadu.fms.cost.rpc.finance.ContRepaySkedRpc;
import cn.com.leadu.fms.cost.service.ContPrepayDetailService;
import cn.com.leadu.fms.cost.service.ContPrepaymentApproveService;
import cn.com.leadu.fms.cost.service.ContPrepaymentService;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentModifyVo;
import cn.com.leadu.fms.data.asset.repository.EquMorDetailRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContOverdueRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @program: fms
 * @description: 提前还款审批service实现层
 * @author: yangyiquan
 * @create: 2018-05-16 15:03
 **/
@Slf4j
@Service
public class ContPrepaymentApproveServiceImpl implements ContPrepaymentApproveService{

    /**
     * @Fields  : 提前还款service
     */
    @Autowired
    private ContPrepaymentService contPrepaymentService;

    /**
     * @Fields  : 提前还款明细seervice
     */
    @Autowired
    private ContPrepayDetailService contPrepayDetailService;

    /**
     * @Fields  : 审批日志录入service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  :  财务收款repository
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;
    /**
     * @Fields  : 财务勾稽repository
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Fields  : 财务待收款repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;
    /**
     * @Fields  : 财务待收款rpc
     */
    @Autowired
    private ContChargeRpc contChargeRpc;

    /**
     * 还款计划表
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 消息提示共通repository
     */
    @Autowired
    private CommonSysUserInfoService commonSysUserInfoService;

    /**
     * @Fields  : 资方抵押明细repository
     */
    @Autowired
    private EquMorDetailRepository equMorDetailRepository;

    /**
     * @Fields  : 合同信息Repository层
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  : 财务付款Repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 开票信息Repository层
     */
    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     * CommonConstantService
     */
    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Fields  : 融资合同还款计划rpc
     */
    @Autowired
    private ContRepaySkedRpc contRepaySkedRpc;

    /**
     * @Fields  : 合同融资信息repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    /**
     * @Fields  : 逾期罚息repository
     */
    @Autowired
    private ContOverdueRepository contOverdueRepository;
    @Autowired
    private CommonFinBackfillService commonFinBackfillService;

    /**
     * @param contPrepaymentApproveVo
     * @Description: 提前还款审批通过
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/16 15:17
     */
    @Override
    @Transactional
    public void approval(ContPrepaymentApproveVo contPrepaymentApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        //根据业务编号取得提前还款信息
        ContPrepayment contPrepayment = contPrepaymentService.findContPrepaymentByContPrepaymentNo(contPrepaymentApproveVo.getContPrepaymentNo());
        // 合同编号
        contPrepaymentApproveVo.setContNo(contPrepayment.getContNo());
        if(ActContPrepaymentEnums.CONT_PREPAYMENT_APPROVAL.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())
                && contPrepayment.getPrepayTrialAmount().compareTo(contPrepayment.getPrepayActualAmount()) == 0 && contPrepayment.getPrepayActualAmount().compareTo(BigDecimal.ZERO)>=0){
            //初审时，试算金额和实际金额一致时
            //流程引擎跳过下一级
            actRuTaskVo = ActContPrepaymentUtils.skipAgreeConfirm(contPrepaymentApproveVo.getTaskId());
            //审批日志，提前还款状态
            contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);
        } else if(ActContPrepaymentEnums.CONT_PREPAYMENT_APPROVAL.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())
                && contPrepayment.getPrepayTrialAmount().compareTo(contPrepayment.getPrepayActualAmount()) != 0){
            //流程引擎提交下一级
            actRuTaskVo = ActContPrepaymentUtils.approvalAgree(contPrepaymentApproveVo.getTaskId());
            //审批日志，提前还款状态
            contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);
        }
        else if(ActContPrepaymentEnums.CONT_PREPAYMENT_APPROVAL.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())
                && contPrepayment.getPrepayTrialAmount().compareTo(contPrepayment.getPrepayActualAmount()) == 0 && contPrepayment.getPrepayActualAmount().compareTo(BigDecimal.ZERO)<0){
            //到财务经理审核节点
            actRuTaskVo = ActContPrepaymentUtils.AgreePayment(contPrepaymentApproveVo.getTaskId());
            //合同信息结清状态修改为已结清
            updateContractPrepaymentSts(contPrepaymentApproveVo);
            //审批日志，提前还款状态
            contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);
        }else if(ActContPrepaymentEnums.CONT_PREPAYMENT_REVIEW.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())
                && contPrepayment.getPrepayTrialAmount().compareTo(contPrepayment.getPrepayActualAmount()) != 0 && contPrepayment.getPrepayActualAmount().compareTo(BigDecimal.ZERO)<0){
            //复审通过到财务审核节点
            actRuTaskVo = ActContPrepaymentUtils.AgreePayment(contPrepaymentApproveVo.getTaskId());
            // 合同信息结清状态修改为已结清
            updateContractPrepaymentSts(contPrepaymentApproveVo);
            //审批日志，提前还款状态
            contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.APPROVAL.getType(), actRuTaskVo);
        }else if(ActContPrepaymentEnums.CONT_PREPAYMENT_REVIEW.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())
                && contPrepayment.getPrepayTrialAmount().compareTo(contPrepayment.getPrepayActualAmount()) != 0 && contPrepayment.getPrepayActualAmount().compareTo(BigDecimal.ZERO)>=0){
            //复审通过到财务确认收款
            actRuTaskVo = ActContPrepaymentUtils.approvalAgree(contPrepaymentApproveVo.getTaskId());
            //审批日志，提前还款状态
            contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.APPROVAL.getType(), actRuTaskVo);
        }else if(ActContPrepaymentEnums.CONT_PREPAYMENT_PAYMENT.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())){
            // 根据合同号，获取车辆处理任务
            TransferInfo transferInfo = contPrepaymentService.findTransferInfoByContNo(contPrepaymentApproveVo.getContNo());
            Example example = SqlUtil.newExample(ContractFinance.class);
            example.createCriteria().andEqualTo("contNo", contPrepaymentApproveVo.getContNo());
            // 获取合同融资信息
            ContractFinance contractFinance = contractFinanceRepository.selectOneByExample(example);
            boolean transferDepositFlag = false;
            // 获取提前还款明细List
            List<ContPrepayDetail> contPrepayDetailList = contPrepayDetailService.findContPrepayDetailVoByContPrepaymentNo(contPrepaymentApproveVo.getContPrepaymentNo());
            if (ArrayUtils.isNotNullAndLengthNotZero(contPrepayDetailList)){
                for (ContPrepayDetail contPrepayDetail : contPrepayDetailList){
                    if (StringUtils.equals(PrepaymDetailItemEnums.TRANSFER_DEPOSIT.getType(), contPrepayDetail.getPrepaymDetailItem())
                            && BigDecimalUtils.getNotNullBigDecimal(contPrepayDetailList.get(0).getPrepayActualAmount()).compareTo(BigDecimal.ZERO) > 0){
                        // 如果实际过户保证金大于0
                        transferDepositFlag = true;
                        break;
                    }
                }
            }
            if ((transferInfo != null && BizStatusEnums.TRANSFER_END.getType().equals(transferInfo.getTransferHandleSts()))
                    || transferDepositFlag
                    || (contractFinance != null && StringUtils.equals(contractFinance.getLicenseAttr(), LicenseAttrEnums.LEASE_BACK.getType()))) {
                // 回租赁或者是已过户的或者是实际过户保证金>0
                if(StringUtils.isNotTrimBlank(contPrepaymentApproveVo.getPayAccBranch())){
                    //财务复审通过到总经理审核
                    actRuTaskVo = ActContPrepaymentUtils.AgreeCheck(contPrepaymentApproveVo.getTaskId());
                    //更新财务付款表
                    example = SqlUtil.newExample(ContPay.class);
                    example.createCriteria().andEqualTo("bizCode",contPrepaymentApproveVo.getContPrepaymentNo()).andEqualTo("paymentType",BizTypeEnums.PREPAYMENT.getType());
                    ContPay contPay = contPayRepository.selectOneByExample(example);
                    if(contPay != null){
                        contPay.setPayAmount(contPrepaymentApproveVo.getPayActualAmount());// 付款金额
                        contPay.setPayAccBank(contPrepaymentApproveVo.getPayAccBank());// 付款银行
                        contPay.setPayAccBranch(contPrepaymentApproveVo.getPayAccBranch());
                        contPay.setPayAccountName(contPrepaymentApproveVo.getPayAccountName());
                        contPay.setPayAccountNo(contPrepaymentApproveVo.getPayAccountNo());
                        contPayRepository.updateByExampleSelectiveData(contPay,example);
                    }else{
                        contPay = new ContPay();
                        contPay.setBizCode(contPrepaymentApproveVo.getContPrepaymentNo());
                        contPay.setPaymentType(BizTypeEnums.PREPAYMENT.getType());
                        contPay.setPayAmount(contPrepaymentApproveVo.getPayActualAmount());// 付款金额
                        contPay.setPayAccBank(contPrepaymentApproveVo.getPayAccBank());// 付款银行
                        contPay.setPayAccBranch(contPrepaymentApproveVo.getPayAccBranch());
                        contPay.setPayAccountName(contPrepaymentApproveVo.getPayAccountName());
                        contPay.setPayAccountNo(contPrepaymentApproveVo.getPayAccountNo());
                        contPayRepository.insertData(contPay);
                    }
                    if (transferInfo != null && BizStatusEnums.TRANSFER_END.getType().equals(transferInfo.getTransferHandleSts())){
                        // 删除过户付款信息
                        deleteTransferContPay(transferInfo.getTransferNo());
                    }
                }else{
                    throw new FmsServiceException("请选择付款银行");
                }
                //审批日志，提前还款状态
                contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.APPROVAL.getType(), actRuTaskVo);
            } else {
                throw new FmsServiceException("已过户才可以操作");
            }
        }else if(ActContPrepaymentEnums.CONT_PREPAYMENT_CHECK.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())){
            // 根据合同编号，获取车辆处置信息
            VehicleDisposal vehicleDisposal = contPrepaymentService.findVehicleDisposalByContNo(contPrepaymentApproveVo.getContNo());
            if (vehicleDisposal != null) {
                // 车辆处置信息有数据时，需要进行车辆出库处理
                actRuTaskVo = ActContPrepaymentUtils.approveAgreeExport(contPrepaymentApproveVo.getTaskId());
            } else {
                // 没有车辆处置信息时，直接结束
                actRuTaskVo = ActContPrepaymentUtils.approvalAgree(contPrepaymentApproveVo.getTaskId());
            }
            // 获取提前还款付款信息
            ContPay contPay = findContPayByBizCode(contPrepaymentApproveVo.getContPrepaymentNo(), BizTypeEnums.PREPAYMENT.getType());
            if (contPay != null) {
                // 总经理审核，付款状态修改为已付款
                contPay.setPayStatus(PayStatusEnums.WITHDRAWING.getType());
                // 付款日期
                contPay.setPayDate(new Date());
                contPayRepository.updateByPrimaryKeySelectiveData(contPay);
            }
            //提前还款相应处理
            //根据业务编号取得提前还款信息
            ContPrepayment contPrepayMent = contPrepaymentService.findContPrepaymentByContPrepaymentNo(contPrepaymentApproveVo.getContPrepaymentNo());
            //获取提前还款实际租金
            BigDecimal actualReceiptAmount = getActualReceiptAmount(contPrepaymentApproveVo.getContPrepaymentNo());
            List<ContRepaySked> contRepaySkedList;
            try {
                //查询当前还款计划表
                contRepaySkedList = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findAllContRepaySkedByContNo(contPrepayMent.getContNo()));
            } catch (FmsRpcException e) {
                log.error(e.getMessage());
                throw new FmsServiceException("获取融资合同还款计划信息失败");
            }
            if(contRepaySkedList == null || contRepaySkedList.size()==0){
                throw new FmsServiceException("获取融资合同还款计划信息失败");
            }
            //插入一条数据到还款计划表
            ContRepaySked contRepaySked = saveToContRepaySked(contRepaySkedList,contPrepayMent,contPrepaymentApproveVo,actualReceiptAmount);
            //更新还款计划表状态
            updateContRepaySked(contPrepaymentApproveVo);
            // 回填处理
            commonFinBackfillService.finBackfillByContNo(contPrepayMent.getContNo());

            //更新合同还款状态
            updateContractPrepaymentSts(contPrepaymentApproveVo);

            //提前还款结束后，如果客户在抵押状态，通知资管解押
            this.noticeEquMor(contPrepaymentApproveVo.getContNo());
            //保存开票信息
            saveInvoice(contRepaySked,contPrepayMent,contPrepaymentApproveVo,actualReceiptAmount);
            //更新逾期罚息表状态
            updateOverdueContSts(contPrepaymentApproveVo);

            //审批日志，提前还款状态
            contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.APPROVAL.getType(), actRuTaskVo);
        }
    }

    /**
     * @Description: 根据过户业务号，删除过户处理保存的付款信息
     * @param: transferNo 过户任务号
     * @return:
     * @Author: wangxue
     * @Date: 2018/5/16 15:17
     */
    private void deleteTransferContPay(String transferNo) {
        ContPay contPay = findContPayByBizCode(transferNo, BizTypeEnums.TRANSFER.getType());
        if (contPay != null) {
            // 删除过户付款信息
            contPayRepository.deleteData(contPay);
        }
    }

    /**
     * @Description: 根据业务code和业务类型 获取财务付款信息
     * @param: bizCode
     * @param: paymentType
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/16 15:17
     */
    public ContPay findContPayByBizCode(String bizCode, String paymentType) {
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",bizCode).andEqualTo("paymentType",paymentType);
        return contPayRepository.selectOneByExample(example);
    }

    /**
     * @param contPrepaymentApproveVo
     * @Description: 提前还款审批退回
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/16 15:17
     */
    @Override
    @Transactional
    public void sendBack(ContPrepaymentApproveVo contPrepaymentApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        //根据业务编号取得提前还款信息
        ContPrepayment contPrepayment = contPrepaymentService.findContPrepaymentByContPrepaymentNo(contPrepaymentApproveVo.getContPrepaymentNo());
         if(ActContPrepaymentEnums.CONT_PREPAYMENT_PAYMENT.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())
                 && contPrepayment.getPrepayTrialAmount().compareTo(contPrepayment.getPrepayActualAmount()) != 0 && contPrepayment.getPrepayActualAmount().compareTo(BigDecimal.ZERO)<0 ){
             //退回到复审节点
             actRuTaskVo =  ActContPrepaymentUtils.approvalBackReview(contPrepaymentApproveVo.getTaskId());
         }else if(ActContPrepaymentEnums.CONT_PREPAYMENT_PAYMENT.getFlag().equals(contPrepaymentApproveVo.getTaskDefinitionKey())
                 && contPrepayment.getPrepayTrialAmount().compareTo(contPrepayment.getPrepayActualAmount()) == 0 && contPrepayment.getPrepayActualAmount().compareTo(BigDecimal.ZERO)<0 ){
             //退回到初审节点
             actRuTaskVo = ActContPrepaymentUtils.approvalBackApproval(contPrepaymentApproveVo.getTaskId());
         }else{
             //流程引擎
             actRuTaskVo = ActContPrepaymentUtils.approvalReturnSuperior(contPrepaymentApproveVo.getTaskId());
         }
        //退回
        contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.SENDBACK.getType(), actRuTaskVo);
    }

    /**
    * @Description: 审批共通操作 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/16 16:15
    */ 
    @Transactional
    @Override
    public void contPrepaymentApproveCommon(ContPrepaymentApproveVo contPrepaymentApproveVo, String act, ActRuTaskVo actRuTaskVo) {
        //根据业务编号取得提前还款信息
        ContPrepayment contPrepayment = contPrepaymentService.findContPrepaymentByContPrepaymentNo(contPrepaymentApproveVo.getContPrepaymentNo());
        if(contPrepayment == null){
            throw new FmsServiceException( "提前还款申请信息不存在");
        }
        //更新提前还款状态
        String contractBizStatusUpd = actRuTaskVo.getTaskCode();
        ContPrepaymentModifyVo contPrepaymentModifyVo = new ContPrepaymentModifyVo();
        contPrepaymentModifyVo.setPrepaymentSts(contractBizStatusUpd);
        contPrepaymentModifyVo.setContPrepaymentId(contPrepayment.getContPrepaymentId());
        //当前节点用户
        contPrepaymentModifyVo.setPresentUser(actRuTaskVo.getNextAssignee());
        contPrepaymentService.modifyContPrepayment(contPrepaymentModifyVo);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contPrepaymentApproveVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contPrepaymentApproveVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.PREPAYMENT.getType());
        workflowLog.setWfLogNo(contPrepaymentApproveVo.getContPrepaymentNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @param contPrepaymentApproveVo
     * @Description: 财务确认
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/20 15:01
     */
    @Transactional
    @Override
    public void receiptConfirm(ContPrepaymentApproveVo contPrepaymentApproveVo) {
        //根据业务编号取得提前还款信息
        ContPrepayment contPrepayment = contPrepaymentService.findContPrepaymentByContPrepaymentNo(contPrepaymentApproveVo.getContPrepaymentNo());
        ContCharge contCharge = null;
        //查询待收款数据
        try {
            List<ContCharge> contChargeList  = ResponseEntityUtils.getRestResponseData(contChargeRpc.fingContChargeListByBizIdAndBizType(contPrepaymentApproveVo.getContPrepaymentNo(),BizTypeEnums.PREPAYMENT.getType()));
            if(ArrayUtils.isNotNullAndLengthNotZero(contChargeList)){
                contCharge = (contChargeList.get(0));
            }
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            throw new FmsServiceException("获取财务待收款数据失败");
        }
        if(contCharge == null){
            throw new FmsServiceException("获取财务待收款数据失败");
        }
        contCharge.setChargeStatus(ChargeStatusEnums.COLLECTION.getType());
        contChargeRepository.updateByPrimaryKeySelectiveData(contCharge);
        //保存财务收款数据
        for(ContReceipt contReceipt : contPrepaymentApproveVo.getContReceiptList()){
            contReceipt.setInputMode(InputModeEnums.INPUT.getType());
            contReceiptRepository.insertData(contReceipt);
            //保存勾稽数据
            ContReceiptExam contReceiptExam = new ContReceiptExam();
            contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType());
            contReceiptExam.setReceiptBizId(contCharge.getContChargeId());
            contReceiptExam.setContReceiptId(contReceipt.getContReceiptId());
            contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());
            contReceiptExam.setReceiptExamAmount(contReceipt.getReceiptAmount());
            contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());
            contReceiptExamRepository.insertData(contReceiptExam);
        }

        //获取提前还款实际租金
        BigDecimal actualReceiptAmount = getActualReceiptAmount(contPrepaymentApproveVo.getContPrepaymentNo());
        List<ContRepaySked> contRepaySkedList;
        try {
            //查询当前还款计划表
            contRepaySkedList = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findAllContRepaySkedByContNo(contPrepayment.getContNo()));
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            throw new FmsServiceException("获取融资合同还款计划信息失败");
        }
        if(contRepaySkedList == null || contRepaySkedList.size()==0){
            throw new FmsServiceException("获取融资合同还款计划信息失败");
        }
        //插入一条数据到还款计划表
        ContRepaySked contRepaySked = saveToContRepaySked(contRepaySkedList,contPrepayment,contPrepaymentApproveVo,actualReceiptAmount);
        //更新还款计划表状态
        updateContRepaySked(contPrepaymentApproveVo);
        // 回填处理
        commonFinBackfillService.finBackfillByContNo(contPrepayment.getContNo());

        //更新合同还款状态
        updateContractPrepaymentSts(contPrepaymentApproveVo);

        //提前还款结束后，如果客户在抵押状态，通知资管解押
        this.noticeEquMor(contPrepaymentApproveVo.getContNo());
        //保存开票信息
        saveInvoice(contRepaySked,contPrepayment,contPrepaymentApproveVo,actualReceiptAmount);

        //更新逾期罚息表状态
        updateOverdueContSts(contPrepaymentApproveVo);
        // 流程引擎
        ActRuTaskVo actRuTaskVo;
        // 根据合同编号，获取车辆处置信息
        VehicleDisposal vehicleDisposal = contPrepaymentService.findVehicleDisposalByContNo(contPrepaymentApproveVo.getContNo());
        if (vehicleDisposal != null) {
            // 车辆处置信息有数据时，需要进行车辆出库处理
            actRuTaskVo = ActContPrepaymentUtils.approveAgreeExport(contPrepaymentApproveVo.getTaskId());
        } else {
            // 没有车辆处置信息时，直接结束
            actRuTaskVo = ActContPrepaymentUtils.approvalAgree(contPrepaymentApproveVo.getTaskId());
        }
        //流程引擎
//        ActRuTaskVo actRuTaskVo = ActContPrepaymentUtils.approvalAgree(contPrepaymentApproveVo.getTaskId());
        //审批日志，提前还款状态
        contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.APPROVAL.getType(), actRuTaskVo);
    }

    /**
    * @Description: 插入一条数据到还款计划表
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/12 10:58
    */
    private ContRepaySked saveToContRepaySked(List<ContRepaySked> contRepaySkedList, ContPrepayment contPrepayment, ContPrepaymentApproveVo contPrepaymentApproveVo, BigDecimal actualReceiptAmount) {
        BigDecimal residueAmount = BigDecimal.ZERO;//剩余未还本金
        for(ContRepaySked contRepaySked : contRepaySkedList){
            if(!RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())){
                residueAmount = residueAmount.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getPrincipal()));
            }
        }
        //构造一条期数是99的数据
        ContRepaySked contRepaySked = new ContRepaySked();
        contRepaySked.setContNo(contPrepayment.getContNo());
        contRepaySked.setPeriod(99);//期数
        contRepaySked.setRepayDate(contPrepayment.getValidityDate());//还款日期=有效期
        contRepaySked.setDealDate(new Date());//成交日期
        contRepaySked.setRent(actualReceiptAmount);//每期客户租金=收款合计（不包括保证金，续保押金退还部分和过户保证金）
        contRepaySked.setRentActual(actualReceiptAmount);//实际租金=收款合计（不包括保证金，续保押金退还部分和过户保证金）
        contRepaySked.setPrincipal(residueAmount);//当期本金=所有未还款本金
        contRepaySked.setInterest(actualReceiptAmount.subtract(residueAmount));//当期利息=租金-本金
        contRepaySked.setRestPrincipal(BigDecimal.ZERO);//当期剩余本金=0
        contRepaySked.setOverdueStatus(OverDueStatusEnums.NOT_OVERDUE.getType());//逾期状态-正常
        contRepaySked.setRepayType(RepayTypeEnums.PREPAYMENT.getType());//类别=提前还款
        contRepaySked.setReceiptDate(new Date());//到账日期
        contRepaySked.setReceiptAmount(actualReceiptAmount);//已收金额=实收金额
        contRepaySked.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());//扣款状态-成功
        contRepaySkedRepository.insertData(contRepaySked);
        return contRepaySked;
    }

    /**
    * @Description: 获取提前还款实际收到的金额
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/11 20:19
    */
    private BigDecimal getActualReceiptAmount(String contPrepaymentNo) {
        //提前还款的明细信息
        List<ContPrepayDetail> ContPrepayDetails  = contPrepayDetailService.findContPrepayDetailVoByContPrepaymentNo(contPrepaymentNo);
        BigDecimal actualReceiptAmount = BigDecimal.ZERO;
        //需要相减的数据
        String[] subtractList = {PrepaymDetailItemEnums.OTHER_SUBTRACT.getType()};
        //需要忽视的数据
        String[] ignoreList = {PrepaymDetailItemEnums.DEPOSIT.getType(),PrepaymDetailItemEnums.RENEWAL_DEPOSIT.getType(),
                PrepaymDetailItemEnums.TRANSFER_DEPOSIT.getType()};
        for (ContPrepayDetail contPrepayDetail:ContPrepayDetails){
            if (ArrayUtils.equalsContains(ignoreList, contPrepayDetail.getPrepaymDetailItem())) {
                continue;
            }
            if(ArrayUtils.equalsContains(subtractList,contPrepayDetail.getPrepaymDetailItem())){
                //相减
                actualReceiptAmount = actualReceiptAmount.subtract(contPrepayDetail.getPrepayActualAmount());
            }else{
                //相加
                actualReceiptAmount = actualReceiptAmount.add(contPrepayDetail.getPrepayActualAmount());
            }
        }
        return actualReceiptAmount;
    }

    /**
     * @Description: 保存开票信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/21 12:03
     */
    private void saveInvoice(ContRepaySked contRepaySked, ContPrepayment contPrepayment, ContPrepaymentApproveVo contPrepaymentApproveVo, BigDecimal actualReceiptAmount) {
        BigDecimal invoiceTax6;
        BigDecimal invoiceTax16;
        //获取税率
        try {
            //税率16
            invoiceTax16 = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.INVOICE_TAX_16));
            //税率6
            invoiceTax6 = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.INVOICE_TAX_6));
        } catch (Exception e) {
            throw new FmsServiceException("获取开票税率失败");
        }
        //获取租赁方式
        ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(contPrepayment.getContNo());

        //构造开票信息
        Invoice invoice = new Invoice();
        invoice.setInvoiceDataType(InvoiceTypeEnums.PREPAYMENT.getType());
        invoice.setContNo(contPrepayment.getContNo());
        invoice.setReceiveDate(new Date());
        invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());//未开票
        invoice.setInvoiceVoucherStatus(YesNoFlagEnums.NO.getType());//未生成凭证
        invoice.setDetailNo(contRepaySked.getPeriod()+"");
        //如果是回租赁
        if(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())){
            invoice.setReceiveAccount(contPrepayment.getPrepayActualAmount());//应收金额=提前还款实际总金额
            invoice.setReceiveActualAccount(contRepaySked.getRentActual());//实收金额=实际租金
            invoice.setInvoiceAmount(contRepaySked.getInterest());//开票金额=当期利息
            invoice.setInvoiceTax(invoiceTax6);
        }else{
            invoice.setReceiveAccount(contPrepayment.getPrepayActualAmount());//应收金额=提前还款实际总金额
            invoice.setReceiveActualAccount(contRepaySked.getRentActual());//实收金额=实际租金
            invoice.setInvoiceAmount(contRepaySked.getRentActual());//开票金额=实际租金
            invoice.setInvoiceTax(invoiceTax16);
        }
        //开票金额大于0，保存
        if(BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).compareTo(BigDecimal.ZERO)>0){
            invoiceRepository.insertData(invoice);
        }
    }

    /**
    * @Description: 更新还款计划表状态
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/10 14:12
    */
    private void updateContRepaySked(ContPrepaymentApproveVo contPrepaymentApproveVo) {
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("repayStatus", RepayStatusEnums.TO_BE_WITHHELD.getType());
        criteria.andEqualTo("contNo",contPrepaymentApproveVo.getContNo());
        ContRepaySked contRepaySked = new ContRepaySked();
        contRepaySked.setRepayStatus(RepayStatusEnums.PREPAYMENT.getType());
        contRepaySkedRepository.updateByExampleSelectiveData(contRepaySked, example);
    }

    /**
    * @Description: 更新合同还款状态
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/10 14:11
    */
    private void updateContractPrepaymentSts(ContPrepaymentApproveVo contPrepaymentApproveVo) {
        Contract contract = new Contract();
        Example example = SqlUtil.newExample(Contract.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contPrepaymentApproveVo.getContNo());
        ContPrepayment contPrepayment = contPrepaymentService.findContPrepaymentByContPrepaymentNo(contPrepaymentApproveVo.getContPrepaymentNo());
        if(PrepaymentTypeEnums.NORMAL_PREPAYMENT.getType().equals(contPrepayment.getPrepaymentType())){//正常提前还款
            contract.setPaymentSts(PaymentStsEnums.NORMAL_EARLY_CLEARANCE.getType());//正常提前结清
        }else {//强制提前还款
            contract.setPaymentSts(PaymentStsEnums.FORCIBLY_EARLY_CLEARANCE.getType());//强制提前结清
        }
        contractRepository.updateByExampleSelectiveData(contract, example);
    }

    /**
     * @Description: 提前还款结束后，如果客户在抵押状态，通知资管解押
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/19 16:23
     */
    private void noticeEquMor(String contNo){
        Example example = SqlUtil.newExample(EquMorDetail.class);
        example.createCriteria().andEqualTo("mainContNo", contNo);
        EquMorDetail equMorDetail = equMorDetailRepository.selectOneByExample(example);
        if(equMorDetail !=null && MortgageStatusEnums.EQU_MOR_SUCCESS.getStatus().equals(equMorDetail.getMortgageStatus())){//如果客户在抵押状态
            ContPrepaymentVo contPrepaymentVo = contPrepaymentService.findContPrepaymentVoByContNo(contNo);
            Map<String,String> map = new HashMap<>();
//            map.put("contNo", contNo);
            map.put("personName", contPrepaymentVo.getName());
            String defaultTpl = "您好，有一条合同承租人为：${personName}，已完成提前还款，请及时解押";
            commonSysUserInfoService.infoPoint(CommonUserUnitsEnums.USER.getUnit(),"os_xm01", TplTypeKeyEnums.NOTICE_EQU_MOR.getType(),map, InfoCodeTypeEnums.EQU_MOR_DETAIL_LIST.getType(),defaultTpl);
        }
    }

    /**
     * @Description: 更新逾期逾期罚息表还款状态
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/10/16 16:23
     */
    private void updateOverdueContSts(ContPrepaymentApproveVo contPrepaymentApproveVo){
        Example example = SqlUtil.newExample(ContOverdue.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo",contPrepaymentApproveVo.getContNo());
        criteria.andEqualTo("repayStatus", RepayStatusEnums.TO_BE_WITHHELD.getType());
        ContOverdue contOverdue = new ContOverdue();
        contOverdue.setRepayStatus(RepayStatusEnums.PREPAYMENT.getType());
        contOverdueRepository.updateByExampleSelectiveData(contOverdue,example);
    }

}
