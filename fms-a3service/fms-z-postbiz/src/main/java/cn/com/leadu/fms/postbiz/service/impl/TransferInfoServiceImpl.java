package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActTransferTaskEnums;
import cn.com.leadu.fms.business.common.util.activiti.ActSurrenderChargeUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActTransferTaskUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileDetailStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.CostItemEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InsurancDealTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InsuranceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.TransferStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.baseinfo.repository.BasFileTypeRepository;
import cn.com.leadu.fms.data.cost.repository.ContPrepaymentRepository;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.postbiz.repository.ContCostRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContInsuranceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.*;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.TransferInfoService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.TransferInfoRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.common.vo.FileVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: TransferInfoService
 * @Description: 过户流程业务实现层
 * @date 2018-08-29
 */
@Service
public class TransferInfoServiceImpl implements TransferInfoService {

    /**
     * @Fields  : 过户流程repository
     */
    @Autowired
    private TransferInfoRepository transferInfoRepository;

    /**
     * @Fields  : 业务编号管理repository
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 审批日志录入service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 合同车辆保险信息repository
     */
    @Autowired
    private ContInsuranceRepository contInsuranceRepository;

    /**
     * @Fields  : 销售还款计划表repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 销售还款计划表repository
     */
    @Autowired
    private BasFileTypeRepository basFileTypeRepository;

    /**
     * @Fields  : 原件归档明细repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;

    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  : 财务付款信息repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 财务待收款信息repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;

    /**
     * @Fields  : 财务收款信息repository
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    /**
     * @Fields  : 财务勾稽表信息repository
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Fields  : 附件处理service
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields  : 通用pdfservice
     * @author qiaomengnan
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * @Fields  : 提前还款信息repository
     */
    @Autowired
    private ContPrepaymentRepository contPrepaymentRepository;

    /**
     * @Fields  : 客户费用信息repository
     */
    @Autowired
    private ContCostRepository contCostRepository;

    /**
     * @Title:
     * @Description: 分页查询过户信息一览数据
     * @param transferInfoVo
     * @return PageInfoExtend<TransferInfo>
     * @throws
     * @author wangxue
     * @date 2018-8-29 19:00:22
     */
    public PageInfoExtend<TransferInfo> findTransferInfosByPage(TransferInfoVo transferInfoVo){
        // 承租人
        if (StringUtils.isNotTrimBlank(transferInfoVo.getCstmName())){
            transferInfoVo.setCstmName(SqlUtil.likePattern(transferInfoVo.getCstmName()));
        }else{
            transferInfoVo.setCstmName(null);
        }
        // 出租人
        if (StringUtils.isNotTrimBlank(transferInfoVo.getBelongGroup())){
            transferInfoVo.setBelongGroup(SqlUtil.likePattern(transferInfoVo.getBelongGroup()));
        }else{
            transferInfoVo.setBelongGroup(null);
        }
        // 车架号
        if (StringUtils.isNotTrimBlank(transferInfoVo.getVinNo())){
            transferInfoVo.setVinNo(SqlUtil.likePattern(transferInfoVo.getVinNo()));
        }else{
            transferInfoVo.setVinNo(null);
        }
        // 合同编号
        if (StringUtils.isNotTrimBlank(transferInfoVo.getContNo())){
            transferInfoVo.setContNo(SqlUtil.likePattern(transferInfoVo.getContNo()));
        }else{
            transferInfoVo.setContNo(null);
        }
        // 过户状态
        if (StringUtils.isTrimBlank(transferInfoVo.getTransferSts())){
            transferInfoVo.setTransferSts(null);
        }
        // 抵押状态
        if (StringUtils.isTrimBlank(transferInfoVo.getMortgageStatus())){
            transferInfoVo.setMortgageStatus(null);
        }
        // 文件类型（车辆登记证）
        transferInfoVo.setFileTypes(getRegistrationFileType());
        PageInfoExtend<TransferInfo> pageInfo = transferInfoRepository.selectListVoByPage("selectTransferInfosByPage", transferInfoVo, transferInfoVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 获取过户流程的页面显示的信息
     * @param contNo 合同编号
     * @return TransferInfoVo
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:00
     */
    @Override
    public TransferInfoVo findTransferDetailByContNo(String contNo) {
        String cancelMortgageStatus = MortgageStatusEnums.CANCEL.getStatus();
        String invalidMortgageStatus = MortgageStatusEnums.INVALID.getStatus();
        // 获取过户明细信息
        TransferInfoVo transferInfoVo = transferInfoRepository.selectTransferDetailByContNo(contNo,cancelMortgageStatus,invalidMortgageStatus);        selectInsuranceAndRepayAmount(transferInfoVo);
        // 取得提前还款状态
        ContPrepayment contPrepayment = findContPrepaymentByContNo(contNo);
        if (contPrepayment != null) {
            transferInfoVo.setPrepaymentSts(contPrepayment.getPrepaymentSts());
        }
        return transferInfoVo;
    }

    /**
     * @Title:
     * @Description: 根据过户任务号 获取过户任务信息
     * @param transferNo 过户任务号
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-1 15:15:00
     */
    @Override
    public TransferInfoVo findTransferDetailByTransferNo(String transferNo) {
        String cancelMortgageStatus = MortgageStatusEnums.CANCEL.getStatus();
        String invalidMortgageStatus = MortgageStatusEnums.INVALID.getStatus();
        // 获取过户明细信息
        TransferInfoVo transferInfoVo = transferInfoRepository.selectTransferInfoVoByTransferNo(transferNo,cancelMortgageStatus,invalidMortgageStatus);
        selectInsuranceAndRepayAmount(transferInfoVo);
        // 取得提前还款状态
        ContPrepayment contPrepayment = findContPrepaymentByContNo(transferInfoVo.getContNo());
        if (contPrepayment != null) {
            transferInfoVo.setPrepaymentSts(contPrepayment.getPrepaymentSts());
        }
        // 获取费用信息
        transferInfoVo.setDeposit(transferInfoVo.getDeposit() == null ? BigDecimal.ZERO : transferInfoVo.getDeposit());// 保证金
        transferInfoVo.setTransferDeposit(transferInfoVo.getTransferDeposit() == null ? BigDecimal.ZERO : transferInfoVo.getTransferDeposit());// 过户保证金
        if (PaymentStsEnums.AUTOMATIC_CLEARING.getType().equals(transferInfoVo.getPaymentSts())) {
            // 自动结清的场合
            transferInfoVo.setTransferDeposit(BigDecimal.ZERO);
            // 获取合同保证金
            BigDecimal deposit = contCostRepository.selectSumCostAmountByContNo(transferInfoVo.getContNo(), CostItemEnums.DEPOSIT.getType());
            deposit = deposit == null ? BigDecimal.ZERO : deposit;
            transferInfoVo.setDeposit(deposit);
        } else if (PaymentStsEnums.NORMAL_EARLY_CLEARANCE.getType().equals(transferInfoVo.getPaymentSts())
                || PaymentStsEnums.FORCIBLY_EARLY_CLEARANCE.getType().equals(transferInfoVo.getPaymentSts()) ) {
            // 提前结清的场合
            transferInfoVo.setDeposit(BigDecimal.ZERO);
        }
        // 费用总额
        if (transferInfoVo.getTotalCost() == null) {
            BigDecimal totalCost = BigDecimalUtils.adds(transferInfoVo.getRetreatsAmount(),transferInfoVo.getDeposit(),transferInfoVo.getTransferDeposit(),(BigDecimal.ZERO.subtract(transferInfoVo.getTransferCost())));
            transferInfoVo.setTotalCost(totalCost);
        }
        // 获取财务付款信息
        ContPay contPay = findContPayByTransferNo(transferNo);
        if (contPay != null) {
            transferInfoVo = EntityUtils.getEntity(contPay, transferInfoVo);
        }
        // 获取上传的附件数据
        transferInfoVo.setBizFilesList(bizFilesService.findBizFilesList(transferNo, BizCodeTypeEnums.TRANSFER_FILE.getCodeType())); //过户附件信息
        // 获取上传的申请附件信息
        transferInfoVo.setApplyBizFilesList(bizFilesService.findBizFilesList(transferNo, BizCodeTypeEnums.TRANSFER_APPLY_FILE.getCodeType()));
        return transferInfoVo;
    }

    /**
     * @Title:
     * @Description: 获取保险信息，已还金额，车辆登记证文件状态
     * @param transferInfoVo 过户任务信息任务号
     * @author wangxue
     * @date 2018-9-1 15:15:00
     */
    private void selectInsuranceAndRepayAmount(TransferInfoVo transferInfoVo){
        String contNo = transferInfoVo.getContNo();
        // 获取保险失效日
        Example example = SqlUtil.newExample(ContInsurance.class);
        example.createCriteria().andEqualTo("contNo",contNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        ContInsurance contInsurance = contInsuranceRepository.selectOneByExample(example);
        if (contInsurance != null) {
            transferInfoVo.setValidEndDay(contInsurance.getValidEndDay());
            transferInfoVo.setInsuranceStatus(contInsurance.getInsuranceStatus());
        } else {
            // 保险状态设置为“失效”
            transferInfoVo.setInsuranceStatus(InsuranceStatusEnums.INSURANCE_INVALID.getType());
        }
        // 获取已还金额
        Example example_repay = SqlUtil.newExample(ContRepaySked.class);
        example_repay.createCriteria().andEqualTo("contNo",contNo);
        SqlUtil.setOrderByColumnAsc(example_repay,"period");
        List<ContRepaySked> contRepaySkedList = contRepaySkedRepository.selectListByExample(example_repay);
        BigDecimal paidAmount = BigDecimal.ZERO;
        if (ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedList)) {
            for (ContRepaySked contRepaySked : contRepaySkedList) {
                // 排除首付那期数据
//                if (contRepaySked.getPeriod() != null && contRepaySked.getPeriod() != 0) {
                if (!RepayTypeEnums.INIT_AMOUNT.getType().equals(contRepaySked.getRepayType())) {
                    // 扣款状态:2(成功)
                    if (RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())) {
                        // 到账金额
                        paidAmount = BigDecimalUtils.adds(paidAmount, contRepaySked.getReceiptAmount());
                    }
                }
            }
        }
        transferInfoVo.setPaidAmount(paidAmount);
        // 登记证文件状态
        // 文件状态 3：已归档
        transferInfoVo.setOrigFileDetailStatus(findOrigFileDetailStatusByContNo(contNo, transferInfoVo.getBizCodeType()));
    }

    /**
     * @Title:
     * @Description: 获取合同的车辆登记证状态
     * @param contNo 合同编号
     * @param bizCodeType 类型
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    public String findOrigFileDetailStatusByContNo(String contNo, String bizCodeType) {
        if (StringUtils.isNotTrimBlank(bizCodeType)) {
            Example example_file = new Example(OrigFileDetail.class);
            example_file.createCriteria().andEqualTo("bizCode", contNo).andIn("fileType",getRegistrationFileType())
                    .andEqualTo("bizCodeType", bizCodeType);
            SqlUtil.setOrderByUpdateTimeDesc(example_file);
            OrigFileDetail origFileDetail = origFileDetailRepository.selectOneByExample(example_file);
            if (origFileDetail != null) {
               return origFileDetail.getOrigFileDetailStatus();
            }
        }
        return OrigFileDetailStatusEnums.BE_SORTED.getType();
    }

    /***
     * 获取车辆登记证的文件类型
     * @return
     */
    private List<String> getRegistrationFileType() {
        String fileTypeName = "车辆登记证";
        Example example = new Example(BasFileType.class);
        example.createCriteria().andLike("fileTypeName", fileTypeName);
        List<BasFileType> basFileTypeList = basFileTypeRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(basFileTypeList)) {
            List<String> fileTypeList = new ArrayList<>();
            for (BasFileType basFileType : basFileTypeList) {
                fileTypeList.add(basFileType.getFileType());
            }
            return fileTypeList;
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 融资申请暂存处理
     * @param transferInfoVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    @Override
    @Transactional
    public TransferInfoVo saveTransferApply(TransferInfoVo transferInfoVo) {
        Contract contract = getContractByContNo(transferInfoVo.getContNo());
        if (contract == null) {
            throw new FmsServiceException("合同数据不存在");
        }
        // 获取过户任务信息，判断是否存在有效的过户任务
        TransferInfo transferInfo = findTransferInfoByContNo(transferInfoVo.getContNo());
        if (transferInfo != null && !BizStatusEnums.TRANSFER_SAVE.getType().equals(transferInfo.getTransferHandleSts())
                && !BizStatusEnums.TRANSFER_APPLY.getType().equals(transferInfo.getTransferHandleSts())) {
            throw new FmsServiceException("过户申请已经提交，不可再次申请");
        }
        // 获取过户任务号
        String transferNo = transferInfoVo.getTransferNo();
        if (StringUtils.isTrimBlank(transferInfoVo.getTransferNo())) {
            transferNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.TRANSFER_NUM_TYPE.getType());
        }
        // 保存过户任务信息
        saveOrUpdateTransferInfo(transferInfoVo, ActTypeEnums.SAVEINFO.getType(), transferNo);
        //保存过户申请附件信息
        bizFilesService.modifyBizFilesList(transferInfoVo.getApplyBizFilesList(), transferNo, BizCodeTypeEnums.TRANSFER_APPLY_FILE.getCodeType());
        // 返回的数据
        TransferInfoVo transferVo = new TransferInfoVo();
        // 合同编号
        transferVo.setContNo(transferInfoVo.getContNo());
        // 过户任务号
        transferVo.setTransferNo(transferNo);
        return transferVo;
    }

    /**
     * @Title:
     * @Description: 过户申请提交处理
     * @param transferInfoVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    @Override
    @Transactional
    public void submitTransferApply(TransferInfoVo transferInfoVo) {
        String cancelMortgageStatus = MortgageStatusEnums.CANCEL.getStatus();
        String invalidMortgageStatus = MortgageStatusEnums.INVALID.getStatus();
        // 获取当前合同数据
        TransferInfoVo transferCheckVo = transferInfoRepository.selectTransferDetailByContNo(transferInfoVo.getContNo(),cancelMortgageStatus,invalidMortgageStatus);
        if (transferCheckVo == null) {
            throw new FmsServiceException("合同数据不存在");
        }
        // 获取过户任务信息，判断是否存在有效的过户任务
        TransferInfo transferInfo = findTransferInfoByContNo(transferInfoVo.getContNo());
        if (transferInfo != null && !BizStatusEnums.TRANSFER_SAVE.getType().equals(transferInfo.getTransferHandleSts())
                && !BizStatusEnums.TRANSFER_APPLY.getType().equals(transferInfo.getTransferHandleSts())) {
            throw new FmsServiceException("过户申请已经提交，不可再次申请");
        }
        // 判断车辆是否在抵押中
        if (!MortgageStatusEnums.NOT_MOR.getStatus().equals(transferCheckVo.getMortgageStatus())
                && !MortgageStatusEnums.EQU_REL.getStatus().equals(transferCheckVo.getMortgageStatus())) {
            throw new FmsServiceException("车辆抵押中，请先和资方解除抵押");
        }
        // 获取车辆登记证状态
        String origFileDetailStatus = findOrigFileDetailStatusByContNo(transferCheckVo.getContNo(), transferCheckVo.getBizCodeType());
        if (!OrigFileDetailStatusEnums.BE_BORROWED.getType().equals(origFileDetailStatus)) {
            throw new FmsServiceException("请先申请借阅车辆登记证文件");
        }
        // 获取过户任务号
        String transferNo = transferInfoVo.getTransferNo();
        if (StringUtils.isTrimBlank(transferInfoVo.getTransferNo())) {
            transferNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.TRANSFER_NUM_TYPE.getType());
        }
        //工作流引擎
        ActRuTaskVo actRuTaskVo = null;
        if (StringUtils.isTrimBlank(transferInfoVo.getTaskId())) {
            // 任务ID为空，开启新流程
            actRuTaskVo = ActTransferTaskUtils.startTransferAndSubmit(transferNo, transferInfoVo.getContNo());
        } else { //任务id不为空，继续工作流
            actRuTaskVo = ActTransferTaskUtils.approvalAgree(transferInfoVo.getTaskId());
        }
        // 过户处理状态
        String transferHandlerStsUp = actRuTaskVo.getTaskCode();
        transferInfoVo.setTransferHandleSts(transferHandlerStsUp);
        // 当前节点用户
        transferInfoVo.setPresentUser(actRuTaskVo.getNextAssignee());
        // 保存过户任务信息
        saveOrUpdateTransferInfo(transferInfoVo, ActTypeEnums.SUBMIT.getType(), transferNo);
        //保存过户申请附件信息
        bizFilesService.modifyBizFilesList(transferInfoVo.getApplyBizFilesList(), transferNo, BizCodeTypeEnums.TRANSFER_APPLY_FILE.getCodeType());
        // 保存流程日志
        saveWorkflowLog(transferInfoVo.getUser(), transferInfoVo.getRemark(),transferNo, transferHandlerStsUp, ActTypeEnums.SUBMIT.getType());
    }

    /**
     * @Description: 保存或更新过户信息表
     * @param transferInfoVo 需要保存的数据
     * @return String 过户任务号
     * @author wangxue
     * @date 2018-9-1 10:15:00
     */
    public void saveOrUpdateTransferInfo(TransferInfoVo transferInfoVo, String type, String transferNo) {
        TransferInfo transferInfo = new TransferInfo();
        // 所有权转移人
        transferInfo.setOwnershipPerson(transferInfoVo.getOwnershipPerson());
        // 证件号码
        transferInfo.setCertifNo(transferInfoVo.getCertifNo());
        // 过户申请日期
        transferInfo.setTransferApplyDate(transferInfoVo.getTransferApplyDate());
        // 保险处置方式
        transferInfo.setInsurancDealType(transferInfoVo.getInsurancDealType());
        // 联系电话
        transferInfo.setContactMobile(transferInfoVo.getContactMobile());
        // 联系地址
        transferInfo.setContactAddr(transferInfoVo.getContactAddr());
        if (ActTypeEnums.SAVEINFO.getType().equals(type)) {
            // 暂存的场合
            transferInfo.setTransferHandleSts(BizStatusEnums.TRANSFER_SAVE.getType());
        }
        if (ActTypeEnums.SUBMIT.getType().equals(type)) {
            // 提交的场合
            // 流程处理状态
            transferInfo.setTransferHandleSts(transferInfoVo.getTransferHandleSts());
            // 当前节点用户
            transferInfo.setPresentUser(transferInfoVo.getPresentUser());
        }
        if (StringUtils.isTrimBlank(transferInfoVo.getTransferNo())) {
            // 初次保存的场合，新增数据
            // 生成过户任务号
            transferInfo.setTransferNo(transferNo);
            // 过户状态
            transferInfo.setTransferSts(TransferStatusEnums.NOT_TRANSFER.getType());
            // 合同编号
            transferInfo.setContNo(transferInfoVo.getContNo());
            // 车架号
            transferInfo.setVinNo(transferInfoVo.getVinNo());
            transferInfoRepository.insertData(transferInfo);
        } else {
            transferNo = transferInfoVo.getTransferNo();
            Example example = new Example(TransferInfo.class);
            example.createCriteria().andEqualTo("transferNo", transferNo);
            transferInfoRepository.updateByExampleSelectiveData(transferInfo, example);
        }
    }

    /**
     * @Description: 根据合同编号 获取合同信息
     * @param contNo 合同编号
     * @return Contract
     * @author wangxue
     * @date 2018-9-1 10:15:00
     */
    private Contract getContractByContNo(String contNo) {
        Example example = new Example(Contract.class);
        example.createCriteria().andEqualTo("contNo", contNo);
        return contractRepository.selectOneByExample(example);
    }

    /**
     * @Description: 登录流程日志
     * @param user 用户
     * @param remark 备注
     * @param wfLogNo 任务号
     * @param status 状态
     * @param actType 操作类型
     * @author wangxue
     * @date 2018-9-1 10:15:00
     */
    private void saveWorkflowLog(String user, String remark, String wfLogNo, String status, String actType) {
        // 登录工作流日志
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(user);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(remark);
        workflowLog.setWfLogType(BizTypeEnums.TRANSFER.getType());
        workflowLog.setWfLogNo(wfLogNo);
        workflowLog.setStatus(status);
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }


    /**
     * @Title:
     * @Description: 过户流程审批通过
     * @param transferApproveVo 审批信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-5 17:15:00
     */
    @Override
    @Transactional
    public void transferApproval(TransferApproveVo transferApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        // 根据过户任务号，获取过户任务信息
        TransferInfo transferInfo = findTransferInfoByTransferNo(transferApproveVo.getTransferNo());
        if (transferInfo == null) {
            throw new FmsServiceException("过户任务不存在");
        }
        if (ActTransferTaskEnums.TRANSFER_TASK_REVIEW.getFlag().equals(transferApproveVo.getTaskDefinitionKey())) {
            // 资管复核提交后
            if (checkContPrepaymentApproveByContNo(transferInfo.getContNo())) {
                // 退保以外的场合，当前合同的提前还款处于财务审核节点，流程结束
                actRuTaskVo = ActTransferTaskUtils.agreeDirectEnd(transferApproveVo.getTaskId());
            } else {
                // 退保以外的场合，且合同提前还款已结束，进入财务审核节点
                actRuTaskVo = ActTransferTaskUtils.approvalAgree(transferApproveVo.getTaskId());
            }
        } else if (ActTransferTaskEnums.TRANSFER_TASK_TOUCHING.getFlag().equals(transferApproveVo.getTaskDefinitionKey())) {
            // 财务审核的场合
            if(StringUtils.isNotTrimBlank(transferApproveVo.getPayAccBranch())){
                ContPay contPay = findContPayByTransferNo(transferApproveVo.getTransferNo());
                if (contPay != null) {
                    // 付款银行
                    contPay.setPayAccBank(transferApproveVo.getPayAccBank());
                    // 付款银行分行
                    contPay.setPayAccBranch(transferApproveVo.getPayAccBranch());
                    // 付款卡号
                    contPay.setPayAccountNo(transferApproveVo.getPayAccountNo());
                    // 付款账户名
                    contPay.setPayAccountName(transferApproveVo.getPayAccountName());
                    // 付款银联号
                    contPay.setPayEleBankNo(transferApproveVo.getPayEleBankNo());
                    contPayRepository.updateByPrimaryKeySelectiveData(contPay);
                    actRuTaskVo = ActTransferTaskUtils.approvalAgree(transferApproveVo.getTaskId());
                } else {
                    throw new FmsServiceException("未找到付款信息");
                }
            } else {
                throw new FmsServiceException("请选择付款银行");
            }
        } else if (ActTransferTaskEnums.TRANSFER_TASK_LOAN.getFlag().equals(transferApproveVo.getTaskDefinitionKey())) {
            // 财务确认付款的场合
            ContPay contPay = findContPayByTransferNo(transferApproveVo.getTransferNo());
            if (contPay != null) {
                // 付款状态
                contPay.setPayStatus(PayStatusEnums.WITHDRAWING.getType());
                // 付款日期
                contPay.setPayDate(new Date());
                contPayRepository.updateByPrimaryKeySelectiveData(contPay);
                actRuTaskVo = ActTransferTaskUtils.approvalAgree(transferApproveVo.getTaskId());
            } else {
                throw new FmsServiceException("未找到付款信息");
            }
        } else {
            actRuTaskVo = ActTransferTaskUtils.approvalAgree(transferApproveVo.getTaskId());
        }
        // 过户处理状态
        String transferHandlerStsUp = actRuTaskVo.getTaskCode();
        TransferInfo modifyTransferInfo = new TransferInfo();
        modifyTransferInfo.setTransferHandleSts(transferHandlerStsUp);
        // 当前节点用户
        modifyTransferInfo.setPresentUser(actRuTaskVo.getNextAssignee());
        modifyTransferInfo.setTransferId(transferInfo.getTransferId());
        transferInfoRepository.updateByPrimaryKeySelectiveData(modifyTransferInfo);
        // 保存流程日志
        saveWorkflowLog(transferApproveVo.getUser(), transferApproveVo.getRemark(),transferApproveVo.getTransferNo(), transferHandlerStsUp, ActTypeEnums.APPROVAL.getType());
    }

    /**
     * @Title:
     * @Description: 过户流程审批退回
     * @param transferApproveVo 审批信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-5 17:15:00
     */
    @Override
    public void transferSendBack(TransferApproveVo transferApproveVo) {
        // 根据过户任务号，获取过户任务信息
        TransferInfo transferInfo = findTransferInfoByTransferNo(transferApproveVo.getTransferNo());
        if (transferInfo == null) {
            throw new FmsServiceException("过户任务不存在");
        }
        // 流程任务
        ActRuTaskVo actRuTaskVo = null;
        if (ActTransferTaskEnums.TRANSFER_TASK_LOAN.getFlag().equals(transferApproveVo.getTaskDefinitionKey())) {
            // 财务确认付款节点，退回到财务财务审核节点
            actRuTaskVo = ActTransferTaskUtils.approvalBackTouching(transferApproveVo.getTaskId());
        } else {
            actRuTaskVo = ActTransferTaskUtils.approvalReturnSuperior(transferApproveVo.getTaskId());
        }
        // 过户处理状态
        String transferHandlerStsUp = actRuTaskVo.getTaskCode();
        TransferInfo modifyTransferInfo = new TransferInfo();
        modifyTransferInfo.setTransferHandleSts(transferHandlerStsUp);
        // 当前节点用户
        modifyTransferInfo.setPresentUser(actRuTaskVo.getNextAssignee());
        modifyTransferInfo.setTransferId(transferInfo.getTransferId());
        transferInfoRepository.updateByPrimaryKeySelectiveData(modifyTransferInfo);
        // 保存流程日志
        saveWorkflowLog(transferApproveVo.getUser(), transferApproveVo.getRemark(),transferApproveVo.getTransferNo(), transferHandlerStsUp, ActTypeEnums.SENDBACK.getType());
    }

    /**
     * @Title:
     * @Description: 过户费用结算暂存
     * @param transferInfoVo 过户费用信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @Override
    @Transactional
    public TransferInfoVo saveTransferSettlement(TransferInfoVo transferInfoVo) {
        // 根据过户任务或获取过户任务信息
        TransferInfo transferInfo = findTransferInfoByTransferNo(transferInfoVo.getTransferNo());
        if (transferInfo == null) {
            throw  new FmsServiceException("未找到过户任务");
        }
        // 过户费用结算保存DB
        transferSettlementHandler(transferInfoVo, transferInfo, ActTypeEnums.SAVEINFO.getType());
        //保存附件信息
        bizFilesService.modifyBizFilesList(transferInfoVo.getBizFilesList(), transferInfoVo.getTransferNo(), BizCodeTypeEnums.TRANSFER_FILE.getCodeType());
        return transferInfoVo;
    }

    /**
     * @Title:
     * @Description: 过户费用结算提交
     * @param transferInfoVo 过户费用信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @Override
    @Transactional
    public void submitTransferSettlement(TransferInfoVo transferInfoVo) {
        // 根据过户任务或获取过户任务信息
        TransferInfo transferInfo = findTransferInfoByTransferNo(transferInfoVo.getTransferNo());
        if (transferInfo == null) {
            throw new FmsServiceException("未找到过户任务");
        }
        // 计算过户费用总额
        BigDecimal totalCost = BigDecimalUtils.adds(transferInfoVo.getRetreatsAmount(),transferInfoVo.getDeposit(),transferInfoVo.getTransferDeposit(),(BigDecimal.ZERO.subtract(transferInfoVo.getTransferCost())));
        if (totalCost.compareTo(transferInfoVo.getTotalCost()) != 0) {
            throw new FmsServiceException("过户费用总额计算不正确");
        }
        // 设置流程
        ActRuTaskVo actRuTaskVo = ActTransferTaskUtils.approvalAgree(transferInfoVo.getTaskId());
        // 过户处理状态
        String transferHandlerStsUp = actRuTaskVo.getTaskCode();
        transferInfoVo.setTransferHandleSts(transferHandlerStsUp);
        // 当前节点用户
        transferInfoVo.setPresentUser(actRuTaskVo.getNextAssignee());
        transferInfoVo.setTransferId(transferInfo.getTransferId());
        // 将数据保存到DB中
        transferSettlementHandler(transferInfoVo, transferInfo, ActTypeEnums.SUBMIT.getType());
        //保存附件信息
        bizFilesService.modifyBizFilesList(transferInfoVo.getBizFilesList(), transferInfoVo.getTransferNo(), BizCodeTypeEnums.TRANSFER_FILE.getCodeType());
        // 保存流程日志
        saveWorkflowLog(transferInfoVo.getUser(), transferInfoVo.getRemark(),transferInfoVo.getTransferNo(), transferHandlerStsUp, ActTypeEnums.SUBMIT.getType());
    }

    /**
     * @Title:
     * @Description: 费用结算DB更新
     * @param transferInfoVo 过户费用信息
     * @param transferInfo 过户任务信息
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    private void transferSettlementHandler(TransferInfoVo transferInfoVo, TransferInfo transferInfo, String type) {
        // 更新过户任务信息
        if (ActTypeEnums.SUBMIT.getType().equals(type)) {
            // 提交的场合
            transferInfo.setTransferSts(TransferStatusEnums.TRANSFERRED.getType());
            // 流程处理状态
            transferInfo.setTransferHandleSts(transferInfoVo.getTransferHandleSts());
            // 当前节点用户
            transferInfo.setPresentUser(transferInfoVo.getPresentUser());

        }
        // 退保金额
        transferInfo.setRetreatsAmount(transferInfoVo.getRetreatsAmount());
        // 过户手续费
        transferInfo.setTransferCost(transferInfoVo.getTransferCost());
        // 保证金
        transferInfo.setDeposit(transferInfoVo.getDeposit());
        // 过户保证金
        transferInfo.setTransferDeposit(transferInfoVo.getTransferDeposit());
        // 费用总额
        transferInfo.setTotalCost(transferInfoVo.getTotalCost());
        transferInfoRepository.updateByPrimaryKeyData(transferInfo);
        // 根据过户任务号和业务类型获取付款任务信息
        ContPay contPay = findContPayByTransferNo(transferInfoVo.getTransferNo());
        boolean addFlag = false;
        if (contPay == null) {
            // 新增
            addFlag = true;
            contPay = new ContPay();
            // 业务关联号 合同号
            contPay.setBizCode(transferInfo.getTransferNo());
            // 业务类型
            contPay.setPaymentType(BizTypeEnums.TRANSFER.getType());
            // 付款状态
            contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
            // 付款款项
            contPay.setPayFund(PayFundNameEnums.TOTAL.getType());
        }
        // 费用总额 金额,费用总额小于0 的场合付款金额设置为0
        BigDecimal payAmount = BigDecimalUtils.getNotNullBigDecimal(transferInfoVo.getTotalCost()).compareTo(BigDecimal.ZERO) <= 0
                ? BigDecimal.ZERO : transferInfoVo.getTotalCost();
        contPay.setPayAmount(payAmount);
        // 收款银行
        contPay.setRecAccBank(transferInfoVo.getRecAccBank());
        // 收款银行分行
        contPay.setRecAccBranch(transferInfoVo.getRecAccBranch());
        // 收款账号
        contPay.setRecAccountNo(transferInfoVo.getRecAccountNo());
        // 收款账户名
        contPay.setRecAccountName(transferInfoVo.getRecAccountName());
        // 收款联行号
        contPay.setRecEleBankNo(transferInfoVo.getRecEleBankNo());
        // 保存数据
        if (addFlag) {
            contPayRepository.insertData(contPay);
        } else {
            contPayRepository.updateByPrimaryKeyData(contPay);
        }
        // 保险处置方式为“退保的场合”，追加财务待收款信息
        if (InsurancDealTypeEnums.RETREATS.getType().equals(transferInfo.getInsurancDealType())) {
            ContCharge contCharge = findContChargeByTaskNo(transferInfo.getTransferNo());
            if (contCharge == null) {
                contCharge = new ContCharge();
                // 业务类型
                contCharge.setChargeBizType(BizTypeEnums.TRANSFER.getType());
                // 业务号
                contCharge.setChargeBizId(transferInfo.getTransferNo());
                // 款项名称:退保金额
                contCharge.setChargeFund(PayFundNameEnums.RETREATS_AMOUNT.getType());
                // 应收金额
                contCharge.setChargeAmount(transferInfoVo.getRetreatsAmount());
                // 收款状态
                contCharge.setChargeStatus(ChargeStatusEnums.TO_BE_COLLECTION.getType());
                // 明细区分
                contCharge.setChargeDetailFlag(ChargeDetailFlagEnums.TOTAL.getType());
                contChargeRepository.insertData(contCharge);
            } else {
                // 应收金额
                contCharge.setChargeAmount(transferInfoVo.getRetreatsAmount());
                // 收款状态
                contCharge.setChargeStatus(ChargeStatusEnums.TO_BE_COLLECTION.getType());
                contChargeRepository.updateByPrimaryKeySelectiveData(contCharge);
            }
        }
    }

    /**
     * @Title:
     * @Description: 根据过户任务号，获取财务待收款信息
     * @param transferNo 过户任务号
     * @return ContCharge
     * @throws
     * @author wangxue
     * @date 2018-9-5 17:15:00
     */
    private ContCharge findContChargeByTaskNo(String transferNo) {
        Example example = SqlUtil.newExample(ContCharge.class);
        example.createCriteria().andEqualTo("chargeBizId", transferNo).andEqualTo("chargeBizType",BizTypeEnums.TRANSFER.getType());
        return contChargeRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 根据过户任务号，获取还款信息
     * @param transferNo 过户任务号
     * @return ContPay
     * @throws
     * @author wangxue
     * @date 2018-9-5 17:15:00
     */
    private ContPay findContPayByTransferNo(String transferNo) {
        Example example = new Example(ContPay.class);
        example.createCriteria().andEqualTo("bizCode", transferNo).andEqualTo("paymentType", BizTypeEnums.TRANSFER.getType());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return contPayRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 根据过户任务号，获取过户任务信息.
     * @param transferNo 过户任务号
     * @return TransferInfo
     * @throws
     * @author wangxue
     * @date 2018-9-6 19:00:22
     */
    @Override
    public TransferInfo findTransferInfoByTransferNo(String transferNo) {
        Example example = new Example(TransferInfo.class);
        example.createCriteria().andEqualTo("transferNo", transferNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return transferInfoRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 过户财务确认收款
     * @param transferApproveVo 确认收款信息
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @Override
    @Transactional
    public void transferReceipt(TransferApproveVo transferApproveVo) {
        // 获取财务待收款信息
        ContCharge contCharge = findContChargeByTaskNo(transferApproveVo.getTransferNo());
        if (contCharge == null) {
            throw new FmsServiceException("收款信息不存在");
        }
        // 根据过户任务号获取过户任务信息
        TransferInfo transferInfo = findTransferInfoByTransferNo(transferApproveVo.getTransferNo());
        // 更新收款信息
        contCharge.setChargeActualAmount(transferApproveVo.getReceiptActualAmount());
        contCharge.setChargeStatus(ChargeStatusEnums.COLLECTION.getType());
        contChargeRepository.updateByPrimaryKeySelectiveData(contCharge);
        // 登录财务收款信息
        if (ArrayUtils.isNotNullAndLengthNotZero(transferApproveVo.getReceiptVoList())) {
            List<ContReceipt> contReceiptList = new ArrayList<>();
            List<ContReceiptExam> contReceiptExamList = new ArrayList<>();
            for (TransferReceiptVo receiptVo : transferApproveVo.getReceiptVoList()) {
                //插入财务收款表
                ContReceipt contReceipt = new ContReceipt();
                contReceipt.setContReceiptId(UUIDUtils.getUUID()); //主键
                contReceipt.setInputMode(InputModeEnums.INPUT.getType()); //数据来源
                contReceipt.setReceiptAmount(receiptVo.getReceiptAmount()); //到账金额
                contReceipt.setRecAccBank(receiptVo.getRecAccBank()); //收款银行
                contReceipt.setRecAccountName(receiptVo.getRecAccountName()); //收款户名
                contReceipt.setRecAccBranch(receiptVo.getRecAccBranch()); //收款银行分行
                contReceipt.setRecAccountNo(receiptVo.getRecAccountNo()); //收款账号
                contReceipt.setRecEleBankNo(receiptVo.getRecEleBankNo()); //收款联行号
                contReceipt.setRestAmount(BigDecimal.ZERO); //剩余金额
                contReceipt.setReceiptDate(receiptVo.getReceiptDate()); //到账日期
                contReceipt.setMemo(receiptVo.getMemo()); //备注
                contReceiptList.add(contReceipt);
                //插入财务勾稽表
                ContReceiptExam contReceiptExam = new ContReceiptExam();
                contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType()); //收款业务类型
                contReceiptExam.setReceiptBizId(contCharge.getContChargeId()); // 款项业务id
                contReceiptExam.setContReceiptId(contReceipt.getContReceiptId()); // 财务收款ID
                contReceiptExam.setReceiptExamAmount(transferApproveVo.getReceiptActualAmount()); // 勾稽金额
                contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());   //勾稽类型
                contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());
                contReceiptExamList.add(contReceiptExam);
            }
            contReceiptRepository.insertDataList(contReceiptList); //批量插入财务收款表
            contReceiptExamRepository.insertDataList(contReceiptExamList); //批量插入财务勾稽表
        }
        // 设置流程
        ActRuTaskVo actRuTaskVo;
        // 根据合同号获取当前合同的提前还款信息
        if (checkContPrepaymentApproveByContNo(transferInfo.getContNo())) {
            // 当前合同的提前还款处于财务审核节点，流程结束
            actRuTaskVo = ActTransferTaskUtils.agreeDirectEnd(transferApproveVo.getTaskId());
        } else {
            // 进入下一节点（财务审核节点）
            actRuTaskVo = ActTransferTaskUtils.approvalAgree(transferApproveVo.getTaskId());
        }
        // 过户处理状态
        String transferHandlerStsUp = actRuTaskVo.getTaskCode();
        TransferInfo modifytransferInfo = new TransferInfo();
        modifytransferInfo.setTransferHandleSts(transferHandlerStsUp);
        // 当前节点用户
        modifytransferInfo.setPresentUser(actRuTaskVo.getNextAssignee());
        // 过户任务ID
        modifytransferInfo.setTransferId(transferInfo.getTransferId());
        transferInfoRepository.updateByPrimaryKeySelectiveData(modifytransferInfo);
        // 保存流程日志
        saveWorkflowLog(transferApproveVo.getUser(), transferApproveVo.getRemark(),transferApproveVo.getTransferNo(), transferHandlerStsUp, ActTypeEnums.APPROVAL.getType());
    }

    /**
     * @Title:
     * @Description: 过户任务，打印付款单
     * @param transferApproveVo 确认收款信息
     * @return String
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @Override
    public String printPaymentForm(TransferApproveVo transferApproveVo) {
        // 获取付款信息
        ContPay contPay = findContPayByTransferNo(transferApproveVo.getTransferNo());
        // 获得过户任务信息
        TransferInfo transferInfo = findTransferInfoByTransferNo(transferApproveVo.getTransferNo());
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(transferApproveVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        //付款金额合计
        if(contPay.getPayAmount()!=null){
            pdfVariables.put("totalAmount", StringUtils.defaultString(StringUtils.getValue(Math.abs(contPay.getPayAmount().floatValue()))));
        }
        // 过户手续费
        pdfVariables.put("transferCost", StringUtils.defaultString(StringUtils.getValue(Math.abs(0.0 - transferInfo.getTransferCost().floatValue()))));
        // 保证金
        pdfVariables.put("deposit", StringUtils.defaultString(StringUtils.getValue(Math.abs(transferInfo.getDeposit().floatValue()))));
        // 过户保证金
        pdfVariables.put("transferDeposit", StringUtils.defaultString(StringUtils.getValue(Math.abs(transferInfo.getTransferDeposit().floatValue()))));
        // 退保金额
        pdfVariables.put("retreatsAmount", StringUtils.defaultString(StringUtils.getValue(Math.abs(transferInfo.getRetreatsAmount().floatValue()))));
        pdfVariables.put("payAccountName", transferApproveVo.getPayAccountName());
        pdfVariables.put("payAccountNo", transferApproveVo.getPayAccountNo());
        pdfVariables.put("payAccBranch", transferApproveVo.getPayAccBranch());
        pdfVariables.put("recAccBranch", contPay.getRecAccBranch());
        pdfVariables.put("recAccountName", contPay.getRecAccountName());
        pdfVariables.put("recAccountNo", contPay.getRecAccountNo());
        pdfVariables.put("lessor", transferApproveVo.getBelongGroup()); // 出租人
        pdfVariables.put("name", transferApproveVo.getCstmName());//承租人
        pdfVariables.put("vinNo", transferInfo.getVinNo());//车架号
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_TRANSFER.getType());
        return filePath;
    }

    /**
     * @Title:
     * @Description: 根据合同编号，获取过户任务信息
     * @param contNo 合同编号
     * @return TransferInfo
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @Override
    public TransferInfo findTransferInfoByContNo(String contNo) {
        Example example = new Example(TransferInfo.class);
        example.createCriteria().andEqualTo("contNo", contNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return transferInfoRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 根据合同编号，判断当前合同的提前还款是否处于财务审核节点
     * @param contNo 合同编号
     * @return boolean true：是，false：否
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    private boolean checkContPrepaymentApproveByContNo(String contNo) {
        // 根据合同号，获取最新的提前还款任务信息
        ContPrepayment contPrepayment = findContPrepaymentByContNo(contNo);
        if (contPrepayment != null && (BizStatusEnums.PREPAYMENT_PAYMENT_ONE.getType().equals(contPrepayment.getPrepaymentSts())
                || BizStatusEnums.PREPAYMENT_PAYMENT_TWO.getType().equals(contPrepayment.getPrepaymentSts())
                || BizStatusEnums.PREPAYMENT_PAYMENT_BACK.getType().equals(contPrepayment.getPrepaymentSts()))) {
            return true;
        }
        return false;
    }

    /**
     * @Title:
     * @Description: 根据合同编号，获取提前还款信息（合同的最新一条提前还款任务）
     * @param contNo 合同编号
     * @return ContPrepayment
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    private ContPrepayment findContPrepaymentByContNo(String contNo) {
        Example example = new Example(ContPrepayment.class);
        example.createCriteria().andEqualTo("contNo", contNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return contPrepaymentRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 确认书下载
     * @param contNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @Override
    public FileVo downLoadLetter(String contNo) {
        if (StringUtils.isTrimBlank(contNo)){
            throw new FmsServiceException("参数不正确");
        }
        // 获取生成确认书需要的数据
        TransferInfoLetterVo transferInfoLetterVo = transferInfoRepository.selectTransferInfoLetterVo(contNo);
        if (transferInfoLetterVo == null){
            throw new FmsServiceException("当前没有可以下载的车辆过户确认书");
        }

        transferInfoLetterVo.setBrandModel(transferInfoLetterVo.getVehBrandCodeName()==null ? "":
                transferInfoLetterVo.getVehBrandCodeName() +"  "+ transferInfoLetterVo.getVehicleCodeName()== null ? "":transferInfoLetterVo.getVehicleCodeName());//品牌+车型
        transferInfoLetterVo.setLicenseVinNo(transferInfoLetterVo.getVehicleLicenseNo()==null ? "":
                transferInfoLetterVo.getVehicleLicenseNo() + "/" + transferInfoLetterVo.getVinNo()==null ? "": transferInfoLetterVo.getVinNo());//车牌号+车架号

        Map<String,String> pdfVariables = JsonUtils.objectToMap(transferInfoLetterVo);
        FileVo fileResult = new FileVo();
        String filePath;
        filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.TRANS_INFO.getType());
        fileResult.setFilePath(filePath);
        fileResult.setFileName("车辆过户确认书"+"（"+transferInfoLetterVo.getContNo()+"）.pdf");
        return fileResult;
    }

    /**
     * @Title:
     * @Description: 分页查询过户退保一览
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public PageInfoExtend<TransferInfoRetreatsVo> findTransferInfoRetreatsVosByPage(TransferInfoRetreatsVo transferInfoRetreatsVo){
        // 承租人
        if (StringUtils.isNotTrimBlank(transferInfoRetreatsVo.getCstmName())){
            transferInfoRetreatsVo.setCstmName(SqlUtil.likePattern(transferInfoRetreatsVo.getCstmName()));
        }else{
            transferInfoRetreatsVo.setCstmName(null);
        }
        // 出租人
        if (StringUtils.isNotTrimBlank(transferInfoRetreatsVo.getBelongGroup())){
            transferInfoRetreatsVo.setBelongGroup(SqlUtil.likePattern(transferInfoRetreatsVo.getBelongGroup()));
        }else{
            transferInfoRetreatsVo.setBelongGroup(null);
        }
        // 车架号
        if (StringUtils.isNotTrimBlank(transferInfoRetreatsVo.getVinNo())){
            transferInfoRetreatsVo.setVinNo(SqlUtil.likePattern(transferInfoRetreatsVo.getVinNo()));
        }else{
            transferInfoRetreatsVo.setVinNo(null);
        }
        // 合同编号
        if (StringUtils.isNotTrimBlank(transferInfoRetreatsVo.getContNo())){
            transferInfoRetreatsVo.setContNo(SqlUtil.likePattern(transferInfoRetreatsVo.getContNo()));
        }else{
            transferInfoRetreatsVo.setContNo(null);
        }
        //已过户
        transferInfoRetreatsVo.setTransferSts(TransferStatusEnums.TRANSFERRED.getType());
        //保险处置方式为退保
        transferInfoRetreatsVo.setInsurancDealType(InsurancDealTypeEnums.RETREATS.getType());
        PageInfoExtend<TransferInfoRetreatsVo> pageInfo = transferInfoRepository.selectListVoByPage("selectTransferInfoRetreatsVosByPage", transferInfoRetreatsVo, transferInfoRetreatsVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 根据合同号获取过户退保详情
     * @param
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018-10-29 17:15:00
     */
    @Override
    @Transactional
    public TransferInfoRetreatsVo findTransferInfoRetreatsByVo(String contNo) {
        /*TransferInfoRetreatsVo transferInfoRetreatsVo = new TransferInfoRetreatsVo();
        // 合同编号
        transferInfoRetreatsVo.setContNo(contNo);
        List<TransferInfoRetreatsVo> transferInfoRetreatsVoList = transferInfoRepository.findTransferInfoRetreatsByVo(transferInfoRetreatsVo);
        return transferInfoRetreatsVoList.get(0);*/
        return transferInfoRepository.selectTransferInfoRetreatVoByContNo(contNo);
    }

    /**
     * @Title:
     * @Description: 过户退保申请提交处理
     * @param transferInfoRetreatsVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author fangshaofeng
     * @date 2018-10-30 10:15:00
     */
    @Override
    @Transactional
    public void submitTransferInfoRetreatsApply(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser) {
        //获取过户信息
        TransferInfo transferInfo = this.findTransferInfoByContNo(transferInfoRetreatsVo.getContNo());
        if(transferInfo == null){
            throw new FmsServiceException( "过户信息不存在");
        }
        // 获取过户退保任务号
        String RetreatsNo = transferInfoRetreatsVo.getRetreatsNo();
        if (StringUtils.isTrimBlank(transferInfoRetreatsVo.getRetreatsNo())) {
            RetreatsNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.SURRENDER_CHARGE.getType());
        }
        //工作流引擎
        ActRuTaskVo actRuTaskVo = null;
        if (StringUtils.isTrimBlank(transferInfoRetreatsVo.getTaskId())) {
            // 任务ID为空，开启新流程
            actRuTaskVo = ActSurrenderChargeUtils.startTransferAndSubmit(RetreatsNo, transferInfoRetreatsVo.getContNo());

            //录入财务付款表(录入收款银行相关信息)
            ContPay contPay = new ContPay();
            //业务类型--->退保任务
            contPay.setPaymentType(BizTypeEnums.SURRENDER_CHARGE.getType());
            //业务关联号--->退保任务号
            contPay.setBizCode(RetreatsNo);
            //付款状态
            contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
            //款项名称--->"退保金额金额"名称
            contPay.setPayFund(PayFundNameEnums.RETREATS_AMOUNT.getType());
            //付款金额--->退保金额
            contPay.setPayAmount(transferInfoRetreatsVo.getRetreatsAmount());
            //收款银行
            contPay.setRecAccBank(transferInfoRetreatsVo.getRetreatsRecAccBank());
            //收款银行分行
            contPay.setRecAccBranch(transferInfoRetreatsVo.getRetreatsRecAccBranch());
            //收款账号
            contPay.setRecAccountNo(transferInfoRetreatsVo.getRetreatsRecAccountNo());
            //收款户名
            contPay.setRecAccountName(transferInfoRetreatsVo.getRetreatsRecAccountName());
            contPayRepository.insertData(contPay);
        } else { //任务id不为空，继续工作流
            actRuTaskVo = ActSurrenderChargeUtils.approvalAgree(transferInfoRetreatsVo.getTaskId());

            //根据退保任务号和业务类型查询财务付款表(为了取到付款表id从而更新付款表)
            ContPay contPayOne = transferInfoRepository.selectContPayByRetreatsNo(transferInfoRetreatsVo.getRetreatsNo(), BizTypeEnums.SURRENDER_CHARGE.getType());
            if(contPayOne==null){
                throw new FmsServiceException("无法取得财务付款相关信息");
            }
            //更新财务付款表(更新收款银行相关信息)
            ContPay contPay = new ContPay();
            //取需要更新的数据id
            contPay.setContPayId(contPayOne.getContPayId());
            //付款金额--->退保金额
            contPay.setPayAmount(transferInfoRetreatsVo.getRetreatsAmount());
            //收款银行
            contPay.setRecAccBank(transferInfoRetreatsVo.getRetreatsRecAccBank());
            //收款银行分行
            contPay.setRecAccBranch(transferInfoRetreatsVo.getRetreatsRecAccBranch());
            //收款账号
            contPay.setRecAccountNo(transferInfoRetreatsVo.getRetreatsRecAccountNo());
            //收款户名
            contPay.setRecAccountName(transferInfoRetreatsVo.getRetreatsRecAccountName());
            contPayRepository.updateByPrimaryKeySelectiveData(contPay);
        }
        // 过户退保处理状态
        String retreatsHandleSts = actRuTaskVo.getTaskCode();
        transferInfo.setRetreatsHandleSts(retreatsHandleSts);
        // 当前节点用户
        transferInfo.setRetreatsPresentUser(actRuTaskVo.getNextAssignee());
        // 生成过户退保任务号
        transferInfo.setRetreatsNo(RetreatsNo);
        //退保金额
        transferInfo.setRetreatsAmount(transferInfoRetreatsVo.getRetreatsAmount());
        // 更新过户退保任务信息
        transferInfoRepository.updateByPrimaryKeyData(transferInfo);
        // 保存流程日志
        saveWorkflowLog(sysUser.getUser(), transferInfoRetreatsVo.getRemark(),RetreatsNo, retreatsHandleSts, ActTypeEnums.SUBMIT.getType());
    }

    /**
     * @Title:
     * @Description: 根据退保任务号查询过户退保信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public TransferInfoRetreatsVo findTransferInfoRetreatVoByRetreatsNo(String retreatsNo){
        //获取过户退保信息
        TransferInfoRetreatsVo transferInfoRetreatsVo = transferInfoRepository.selectTransferInfoRetreatVoByRetreatsNo(retreatsNo);
        if(transferInfoRetreatsVo == null){
            throw new FmsServiceException( "过户信息不存在");
        }
        //获取收付款银行信息
        ContPay contPay = transferInfoRepository.selectContPayByRetreatsNo(retreatsNo, BizTypeEnums.SURRENDER_CHARGE.getType());
        if(contPay == null){
            throw new FmsServiceException("无法取得财务付款相关信息");
        }
        transferInfoRetreatsVo.setContPayId(contPay.getContPayId());
        transferInfoRetreatsVo.setRetreatsRecAccBank(contPay.getRecAccBank());
        transferInfoRetreatsVo.setRetreatsRecAccBranch(contPay.getRecAccBranch());
        transferInfoRetreatsVo.setRetreatsRecAccountName(contPay.getRecAccountName());
        transferInfoRetreatsVo.setRetreatsRecAccountNo(contPay.getRecAccountNo());
        transferInfoRetreatsVo.setPayAccBank(contPay.getPayAccBank());
        transferInfoRetreatsVo.setPayAccountName(contPay.getPayAccountName());
        transferInfoRetreatsVo.setPayAccountNo(contPay.getPayAccountNo());
        transferInfoRetreatsVo.setPayAccBranch(contPay.getPayAccBranch());
        return transferInfoRetreatsVo;
    }

    /**
     * @Title:
     * @Description: 过户退保资管复核操作更新退保处理状态和退保当前节点共通处理
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    private void updateTransferInfoForRetreats(TransferInfoRetreatsVo transferInfoRetreatsVo,ActRuTaskVo actRuTaskVo){
        //更新退保处理状态和退保当前节点
        if(StringUtils.isTrimBlank(transferInfoRetreatsVo.getContNo()))
            throw new FmsServiceException("合同号不存在");
        TransferInfo transferInfo = this.findTransferInfoByContNo(transferInfoRetreatsVo.getContNo());
        if(transferInfo == null){
            throw new FmsServiceException( "过户信息不存在");
        }
        Example example  = SqlUtil.newExample(TransferInfo.class);
        example.createCriteria().andEqualTo("transferId",transferInfo.getTransferId());
        TransferInfo transferInfo2 = new TransferInfo();
        transferInfo2.setRetreatsHandleSts(actRuTaskVo.getTaskCode());
        transferInfo2.setRetreatsPresentUser(actRuTaskVo.getNextAssignee());
        transferInfoRepository.updateByExampleSelectiveData(transferInfo2,example);
    }

    /**
     * @Title:
     * @Description: 过户退保流程资管复核审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    @Transactional
    public void approval(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser) {
        //继续走流程,更新退保处理状态和退保当前节点,保存日志
        passAgree(transferInfoRetreatsVo,sysUser,ActTypeEnums.APPROVAL.getType());
    }

    /**
     * @Title:
     * @Description: 过户退保流程财务确认收款同意
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    @Transactional
    public void Receivables(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser){
        //插入财务应收金额数据
        ContCharge contCharge = new ContCharge();
        contCharge.setChargeBizType(BizTypeEnums.SURRENDER_CHARGE.getType());//业务类型为"过户退保任务"
        contCharge.setChargeBizId(transferInfoRetreatsVo.getRetreatsNo());//业务号为退保任务号
        contCharge.setChargeFund(PayFundNameEnums.RETREATS_AMOUNT.getType());//款项名称为"退保金额"
        contCharge.setChargeAmount(transferInfoRetreatsVo.getRetreatsAmount());//应收款金额为退保金额
        contCharge.setChargeActualAmount(transferInfoRetreatsVo.getReceiptsAmount()); //实收款金额为前台页面计算的金额
        contCharge.setChargeStatus(ChargeStatusEnums.COLLECTION.getType());//收款状态为"已收款"
        contCharge.setChargeDetailFlag(ChargeDetailFlagEnums.TOTAL.getType());//明细区分为"合计"
        contChargeRepository.insertData(contCharge);
        //保存财务收款数据
        for(ContReceipt contReceipt : transferInfoRetreatsVo.getContReceiptList()){
            contReceipt.setInputMode(InputModeEnums.INPUT.getType());//数据来源
            contReceiptRepository.insertData(contReceipt);
            //保存勾稽数据
            ContReceiptExam contReceiptExam = new ContReceiptExam();
            contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType());//收款业务类型为"财务代收款"
            contReceiptExam.setReceiptBizId(contCharge.getContChargeId());//收款业务ID
            contReceiptExam.setContReceiptId(contReceipt.getContReceiptId());//财务收款ID
            contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());//勾稽状态为"财务待收款款项自动勾稽"
            contReceiptExam.setReceiptExamAmount(contReceipt.getReceiptAmount());//勾稽金额
            contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());//勾稽状态为"已勾稽"
            contReceiptExamRepository.insertData(contReceiptExam);
        }
        //继续走流程,更新退保处理状态和退保当前节点,保存日志
        passAgree(transferInfoRetreatsVo,sysUser,ActTypeEnums.APPROVAL.getType());
    }

    /**
     * @Title:
     * @Description: 过户退保流程财务制单(无退回)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    @Transactional
    public void makeVoucher(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser) {
        //获取收付款银行信息
        ContPay contPayOne = transferInfoRepository.selectContPayByRetreatsNo(transferInfoRetreatsVo.getRetreatsNo(), BizTypeEnums.SURRENDER_CHARGE.getType());
        if(contPayOne == null){
            throw new FmsServiceException("无法取得财务付款相关信息");
        }
        //更新财务付款表(插入付款银行相关信息)
        ContPay contPay = new ContPay();
        contPay.setContPayId(contPayOne.getContPayId());
        contPay.setPayAccBank(transferInfoRetreatsVo.getPayAccBank());
        contPay.setPayAccountName(transferInfoRetreatsVo.getPayAccountName());
        contPay.setPayAccountNo(transferInfoRetreatsVo.getPayAccountNo());
        contPay.setPayAccBranch(transferInfoRetreatsVo.getPayAccBranch());
        contPayRepository.updateByPrimaryKeySelectiveData(contPay);
        //继续走流程,更新退保处理状态和退保当前节点,保存日志
        passAgree(transferInfoRetreatsVo,sysUser,ActTypeEnums.APPROVAL.getType());
    }

    /**
     * @Title:
     * @Description: 过户退保流程财务付款
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    @Transactional
    public void payment(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser) {

        if("0".equals(transferInfoRetreatsVo.getActType())){//通过
            //获取收付款银行信息
            ContPay contPayOne = transferInfoRepository.selectContPayByRetreatsNo(transferInfoRetreatsVo.getRetreatsNo(), BizTypeEnums.SURRENDER_CHARGE.getType());
            if(contPayOne == null){
                throw new FmsServiceException("无法取得财务付款相关信息");
            }
            //更新财务付款表(更新付款状态)
            ContPay contPay = new ContPay();
            contPay.setContPayId(contPayOne.getContPayId());
            contPay.setPayStatus(PayStatusEnums.REQUEST.getType());
            contPayRepository.updateByPrimaryKeySelectiveData(contPay);
            //继续走流程,更新退保处理状态和退保当前节点,保存日志
            passAgree(transferInfoRetreatsVo,sysUser,ActTypeEnums.SUBMIT.getType());
        }else {//退回
            sendBack(transferInfoRetreatsVo,sysUser);
        }
    }

    /**
     * @Title:
     * @Description: 过户退保流程退回共通处理(资管复核审核退回上一级和财务确认收款退回上一级和财务付款退回上一级)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    @Transactional
    public void sendBack(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActSurrenderChargeUtils.approvalReturnSuperior(transferInfoRetreatsVo.getTaskId());
        //更新退保处理状态和退保当前节点
        updateTransferInfoForRetreats(transferInfoRetreatsVo,actRuTaskVo);
        // 保存流程日志
        saveWorkflowLog(sysUser.getUser(), transferInfoRetreatsVo.getRemark(),transferInfoRetreatsVo.getRetreatsNo(), actRuTaskVo.getTaskCode(), ActTypeEnums.SENDBACK.getType());
    }

    /**
     * @Title:
     * @Description: 过户退保流程审核通过共通处理
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void passAgree(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser,String act){
        ActRuTaskVo actRuTaskVo = ActSurrenderChargeUtils.approvalAgree(transferInfoRetreatsVo.getTaskId());
        //更新退保处理状态和退保当前节点
        updateTransferInfoForRetreats(transferInfoRetreatsVo,actRuTaskVo);
        // 保存流程日志
        saveWorkflowLog(sysUser.getUser(), transferInfoRetreatsVo.getRemark(),transferInfoRetreatsVo.getRetreatsNo(), actRuTaskVo.getTaskCode(), act);
    }
}
