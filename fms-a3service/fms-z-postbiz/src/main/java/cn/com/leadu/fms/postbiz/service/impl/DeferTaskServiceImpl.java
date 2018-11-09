package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActDeferTaskUtils;
import cn.com.leadu.fms.business.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonFinBackfillService;
import cn.com.leadu.fms.business.service.CommonGetRepayInfoService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.postbiz.ContCostTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.CostItemEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DeferTaskStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ChargePayModeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.DepositRtnModeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.RentPayModeEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.Financials;
import cn.com.leadu.fms.common.util.IntegerUtils;
import cn.com.leadu.fms.common.util.JsonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.ContCostRepository;
import cn.com.leadu.fms.data.postbiz.repository.DeferTaskRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedAlreadyPayInfoVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ContCost;
import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.rpc.prebiz.ContractRpc;
import cn.com.leadu.fms.postbiz.service.DeferTaskService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author ningyangyang
 * @ClassName: DeferTaskService
 * @Description: 合同展期业务实现层
 */
@Slf4j
@Service
public class DeferTaskServiceImpl implements DeferTaskService {

    /**
     * @Fields  : 合同展期repository
     */
    @Autowired
    private DeferTaskRepository deferTaskRepository;

    /**
     * @Fields  : 合同展期repository
     */
    @Autowired
    private CommonGetRepayInfoService commonGetRepayInfoService;

    /**
     * @Fields  : 合同展期任务号获取service
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 审批日志保存service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 附件信息保存service
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields  : 合同融资repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    /**
     * @Fields  : pdf模板打印service
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  : 合同还款计划repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 财务付款repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 合同费用Repository
     */
    @Autowired
    private ContCostRepository contCostRepository;
    /**
     * @Fields  : 合同费用Repository
     */
    @Autowired
    private BasFileTypeRpc basFileTypeRpc;
    /**
     * @Fields  : 合同信息rpc
     */
    @Autowired
    private ContractRpc contractRpc;
    @Autowired
    private CommonFinBackfillService commonFinBackfillService;

    /**
     * @Title:
     * @Description:  根据contNo获取展期合同的当前合同信息
     * @param deferTaskVo
     * @return DeferTaskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    @Transactional
    public DeferTaskVo findDeferTaskVoByContNo(DeferTaskVo deferTaskVo) {
        DeferTask deferTask1 = null;
        if(StringUtils.isNotTrimBlank(deferTaskVo.getDeferTaskNo())){
            //获取任务信息
            Example example = SqlUtil.newExample(DeferTask.class);
            example.createCriteria().andEqualTo("deferTaskNo",deferTaskVo.getDeferTaskNo());
            deferTask1 = deferTaskRepository.selectOneByExample(example);
        }
        //合同号不能未空
        if(StringUtils.isTrimBlank(deferTaskVo.getContNo())){
            if(StringUtils.isTrimBlank(deferTaskVo.getDeferTaskNo())){
                throw new FmsServiceException("获取合同信息失败");
            }else{
                if(deferTask1 != null){
                    deferTaskVo.setContNo(deferTask1.getContNo());
                }else{
                    throw new FmsServiceException("获取合同信息失败");
                }
            }
        }
        //当前合同信息
        DeferTaskVo deferTask = deferTaskRepository.selectDeferTaskVoByContNo(deferTaskVo);
        if(deferTask != null){
            //已还款信息
            ContRepaySkedAlreadyPayInfoVo contRepaySkedAlreadyPayInfoVo =   commonGetRepayInfoService.commonGetRepayInfo(deferTask.getContNo());
            if(contRepaySkedAlreadyPayInfoVo != null){
                deferTask.setAlreadyPayAmount(contRepaySkedAlreadyPayInfoVo.getAlreadyRepayAmount());
                deferTask.setAlreadyPayPeriod(contRepaySkedAlreadyPayInfoVo.getAlreadyRepayNper());
            }
        }
        //如果taskId存在，查找展期附件和展期任务信息
        //if(StringUtils.isNotTrimBlank(deferTaskVo.getTaskId())){
            if(StringUtils.isNotTrimBlank(deferTaskVo.getDeferTaskNo())){
                deferTask.setInterestRate(deferTask1.getInterestRate()); //利率
                deferTask.setDeferMaturity(deferTask1.getDeferMaturity()); //展期期限
                deferTask.setRent(deferTask1.getRent()); //月供
                deferTask.setIrr(deferTask1.getIrr()); //irr
                deferTask.setDeferDeposit(deferTask1.getDeferDeposit());//展期保证金
                deferTask.setBackDeposit(deferTask1.getBackDeposit()); //退还保证金
                deferTask.setBizFilesList(bizFilesService.findBizFilesList(deferTaskVo.getDeferTaskNo(), BizCodeTypeEnums.DEFER_CONTRACT_FILE.getCodeType())); //申请附件信息
                deferTask.setContractGenerateFileList(bizFilesService.findBizFilesList(deferTaskVo.getDeferTaskNo(), BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE.getCodeType())); //生成合同附件
                deferTask.setContractPrintFileList(bizFilesService.findBizFilesList(deferTaskVo.getDeferTaskNo(), BizCodeTypeEnums.DEFER_CONTRACT_PRINT_FILE.getCodeType())); //合同打印附件信息
                //收付款信息
                this.setContPayInfo(deferTask,deferTaskVo.getDeferTaskNo());
            }
        //}
        return deferTask;
    }
    /**
     * @Title:
     * @Description:  获取付款信息
     * @param deferTaskVo
     * @return DeferTaskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-8 14:35:16
     */
    private void setContPayInfo(DeferTaskVo deferTaskVo,String taskNo){
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",taskNo).andEqualTo("paymentType",BizTypeEnums.DEFER_CONTRACT.getType());
        ContPay contPay = contPayRepository.selectOneByExample(example);
        if(contPay != null){
            deferTaskVo.setPayAccBranch(contPay.getPayAccBranch());
            deferTaskVo.setPayAccBank(contPay.getPayAccBank());
            deferTaskVo.setPayAccountName(contPay.getPayAccountName());
            deferTaskVo.setPayAccountNo(contPay.getPayAccountNo());
            deferTaskVo.setRecAccBank(contPay.getRecAccBank());
            deferTaskVo.setRecAccountName(contPay.getRecAccountName());
            deferTaskVo.setRecAccountNo(contPay.getRecAccountNo());
        }
    }
    /**
     * @Title:
     * @Description: 提交合同展期申请
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Transactional
    public void submitDeferTaskApply(DeferTaskVo deferTaskVo,SysUser sysUser){
        //展期任务载体
        ActRuTaskVo actRuTaskVo = null;
        if(StringUtils.isTrimBlank(deferTaskVo.getTaskId())){  //根据taskId判断是否开启任务
            DeferTask defer =  findDeferTaskByTaskNo(deferTaskVo);
            if(defer != null){
                throw new FmsServiceException("该合同已经进行过展期!");
            }
            //获取任务号
            String deferTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.DEFER_CONTRACT_NUM_TYPE.getType());
            deferTaskVo.setDeferTaskNo(deferTaskNo);
            //开启工作流
            actRuTaskVo = ActDeferTaskUtils.startDeferTask(deferTaskNo,deferTaskVo.getLessee());

        }else{
            //继续提交任务
             actRuTaskVo = ActDeferTaskUtils.approvalAgree(deferTaskVo.getTaskId());
        }
        //更新任务表字段
        deferTaskVo.setPresentUser(actRuTaskVo.getNextAssignee()); //下一节点用户
        deferTaskVo.setDeferTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        deferTaskVo.setDeferSubmitUser(sysUser.getUser()); //提交人
        deferTaskVo.setDeferSubmitDate(Calendar.getInstance().getTime());//提交时间
        //根据合同号去展期任务表查找，如果有则进行更新，否则插入一条新数据
//        if(StringUtils.isNotTrimBlank(deferTaskVo.getContNo())&&StringUtils.isNotTrimBlank(deferTaskVo.getDeferTaskNo())){
            Example example = SqlUtil.newExample(DeferTask.class);
            example.createCriteria().andEqualTo("deferTaskNo",deferTaskVo.getDeferTaskNo());
            DeferTask deferTask = deferTaskRepository.selectOneByExample(example);
            if(deferTask != null){
                deferTaskRepository.updateByExampleSelectiveData(deferTaskVo.getEntity(),example);
            }else{
                deferTaskRepository.insertData(deferTaskVo.getEntity());
            }
//        }else{
//            throw new FmsServiceException("获取合同信息失败");
//        }
        //保存附件信息
        bizFilesService.modifyBizFilesList(deferTaskVo.getBizFilesList(),deferTaskVo.getDeferTaskNo(), BizCodeTypeEnums.DEFER_CONTRACT_FILE.getCodeType());
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新展期任务表
        if(StringUtils.isNotTrimBlank(deferTaskVo.getTaskId())){
            updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
        }
        updateDeferTaskInfo(deferTaskVo, actRuTaskVo);
        //保存收付款信息
        Example example1 = SqlUtil.newExample(ContPay.class);
        example1.createCriteria().andEqualTo("bizCode",deferTaskVo.getDeferTaskNo()).andEqualTo("paymentType",BizTypeEnums.DEFER_CONTRACT.getType());
        contPayRepository.deleteExampleData(example1,new ContPay());
        if(deferTaskVo.getBackDeposit().compareTo(BigDecimal.ZERO)>0){  //退还保证金大于0
            ContPay contPay = new ContPay();
            contPay.setBizCode(deferTaskVo.getDeferTaskNo());
            contPay.setPaymentType(BizTypeEnums.DEFER_CONTRACT.getType());
            contPay.setRecAccBank(deferTaskVo.getRecAccBank());
            contPay.setRecAccountNo(deferTaskVo.getRecAccountNo());
            contPay.setRecAccountName(deferTaskVo.getRecAccountName());
            contPay.setPayAmount(deferTaskVo.getBackDeposit());
            contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
            contPay.setPayFund(PayFundNameEnums.BACK_DEPOSIT.getType());
            contPayRepository.insertData(contPay);
        }

    }

    /**
     *  根据合同号查找是否有任务存在
     * @param deferTaskVo
     * @return
     */
    public DeferTask findDeferTaskByTaskNo(DeferTaskVo deferTaskVo){
        Example example = SqlUtil.newExample(DeferTask.class);
        example.createCriteria().andEqualTo("contNo",deferTaskVo.getContNo()).andNotEqualTo("deferTaskStatus",DeferTaskStatusEnums.REFUSE.getType()).andNotEqualTo("deferTaskStatus",DeferTaskStatusEnums.CANCEL.getType());
        DeferTask deferTask = deferTaskRepository.selectOneByExample(example);
        Contract contract = null;
        try {
            contract =  ResponseEntityUtils.getRestResponseData(contractRpc.findContractByContractNo(deferTaskVo.getContNo())) ;
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw  new FmsServiceException("未获取到合同信息");
        }
        //得到当前日期
        Long now = new Date().getTime();
        //得到合同租赁日期
        Long end = contract.getLeaseTermEndDate().getTime();
        //日期之间相隔天数
        Long dayCount = (end - now)/(24*3600*1000);
        //如果大于60天，则不允许发起展期任务
        if(dayCount > 60){
            throw new FmsServiceException("租赁期届满时才可发起展期申请");
        }
        return deferTask;
    }

    /**
     * @Title:
     * @Description: 合同展期申请审批拒绝
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-9 14:35:16
     */
    @Override
    @Transactional
    public void goRefuse(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.approvalToRefuse(deferTaskVo.getTaskId());
        actRuTaskVo.setTaskCode(DeferTaskStatusEnums.REFUSE.getType());
        actRuTaskVo.setNextAssignee("");
        //保存日志信息
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.REFUSE.getType(),sysUser);
        //更新任务表
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 合同展期申请审批取消
     * @param deferTaskNo 展期任务号
     * @param memo 备注
     * @param sysUser 当前节点用户
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-11 14:35:16
     */
    @Override
    public void applyCancel(String deferTaskNo, String memo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.applyCancel(deferTaskNo);
        actRuTaskVo.setTaskCode(DeferTaskStatusEnums.CANCEL.getType());
        actRuTaskVo.setNextAssignee("");
        DeferTaskVo deferTaskVo = new DeferTaskVo();
        deferTaskVo.setDeferTaskNo(deferTaskNo);
        deferTaskVo.setMemo(memo);
        //保存日志信息
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.CANCEL.getType(),sysUser);
        //更新任务表
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);

    }

    /**
     * @Title:
     * @Description: 合同展期申请审批
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Override
    @Transactional
    public void submitDeferTaskApprove(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.approvalAgree(deferTaskVo.getTaskId());
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新展期任务信息
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 展期合同生成
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Override
    @Transactional
    public void generateDeferContract(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.approvalAgree(deferTaskVo.getTaskId());
        //保存生成的合同
        saveDeferBcxy(deferTaskVo);
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新展期任务信息
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
    }


    /**
     * @Title:
     * @Description: 展期合同打印
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:16
     */
    @Override
    @Transactional
    public void printDeferContract(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.approvalAgree(deferTaskVo.getTaskId());
        //保存上传的签字合同
        bizFilesService.modifyBizFilesList(deferTaskVo.getContractPrintFileList(),deferTaskVo.getDeferTaskNo(), BizCodeTypeEnums.DEFER_CONTRACT_PRINT_FILE.getCodeType());
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新展期任务信息
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description:  展期合同审核
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-4 14:35:15
     */
    @Override
    @Transactional
    public void approveDeferContract(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = null;
        if(deferTaskVo.getBackDeposit().compareTo(BigDecimal.ZERO)>0){
            actRuTaskVo = ActDeferTaskUtils.approvalAgreeToFinance(deferTaskVo.getTaskId());
        }else{
            actRuTaskVo  = ActDeferTaskUtils.approvalAgreeToEnd(deferTaskVo.getTaskId());
            //生成还款计划表
            List<ContRepaySked> contRepaySkedList = this.getContrepaySkedList(deferTaskVo);
            contRepaySkedRepository.insertDataList(contRepaySkedList);
            // 回填处理
            commonFinBackfillService.finBackfillByContNo(deferTaskVo.getContNo());
            //修改合同信息的租赁日期
            modifyContractLeaseTerm(deferTaskVo,contRepaySkedList);
        }
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新展期任务信息
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 展期财务审核
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Override
    @Transactional
    public void submitFinanceApprove(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.approvalAgree(deferTaskVo.getTaskId());
        //更新收付款信息
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",deferTaskVo.getDeferTaskNo()).andEqualTo("paymentType",BizTypeEnums.DEFER_CONTRACT.getType());
        ContPay contPay = new ContPay();
        contPay.setPayAccBank(deferTaskVo.getPayAccBank());
        contPay.setPayAccountName(deferTaskVo.getPayAccountName());
        contPay.setPayAccountNo(deferTaskVo.getPayAccountNo());
        contPay.setPayAccBranch(deferTaskVo.getPayAccBranch());
        contPayRepository.updateByExampleSelectiveData(contPay,example);
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新展期任务信息
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 展期总经理审核
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Override
    @Transactional
    public void submitManagerApprove(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.approvalAgree(deferTaskVo.getTaskId());
        //生成还款计划表
        List<ContRepaySked> contRepaySkedList = this.getContrepaySkedList(deferTaskVo);
        contRepaySkedRepository.insertDataList(contRepaySkedList);
        // 回填处理
        commonFinBackfillService.finBackfillByContNo(deferTaskVo.getContNo());
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新展期任务信息
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
        // 保存客户费用信息
        ContCost contCost = new ContCost();
        // 合同编号
        contCost.setContNo(deferTaskVo.getContNo());
        //contCost.setContReceiptId(contReceipt.getContReceiptId());
        // 保证金
        contCost.setCostAmount(deferTaskVo.getBackDeposit().negate());
        // 款项：保证金
        contCost.setCostItem(CostItemEnums.DEPOSIT.getType());
        // 类型：收取
        contCost.setCostType(ContCostTypeEnums.RETURN.getType());
        contCostRepository.insertData(contCost);
        //修改合同信息的租赁日期
        modifyContractLeaseTerm(deferTaskVo,contRepaySkedList);
    }

    /**
     * @Title:
     * @Description: 修改合同信息租赁期限
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-17 14:35:16
     */
    @Transactional
    private void modifyContractLeaseTerm(DeferTaskVo deferTaskVo,List<ContRepaySked> contRepaySkedList){
        //合同信息实体
        Contract contract = new Contract();
        Example example = SqlUtil.newExample(ContractFinance.class);
        example.createCriteria().andEqualTo("contNo",deferTaskVo.getContNo());
        ContractFinance contractFinance = contractFinanceRepository.selectOneByExample(example);  //查询合同融资信息
        //融资期限
        Integer periodType = IntegerUtils.getValue(contractFinance.getFinPeriodType());
        //展期期限
        Integer deferPeriodType = IntegerUtils.getIntValue(deferTaskVo.getDeferMaturity());
        //最后一期还款的期数
        Integer lastPeriodType = periodType+deferPeriodType;
        //最后一期还款时间
        Date lastRepayDate = new Date();
        //找到最后一期还款的日期
        for(ContRepaySked contRepaySked:contRepaySkedList){
            if(contRepaySked.getPeriod().equals(lastPeriodType)){
                lastRepayDate = contRepaySked.getRepayDate();
                break;
            }
        }
        /*//租赁日期
        Date leaseTerm;*/
        contract.setLeaseTermEndDate(lastRepayDate);
        /*//期初支付
        if(StringUtils.equals(contractFinance.getRentPayMode(), RentPayModeEnums.BEGIN_PAY.getType())){
            leaseTerm = DateUtils.getAddMonth(lastRepayDate,1);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(leaseTerm);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
            contract.setLeaseTermEndDate(calendar.getTime());
        }else if(StringUtils.equals(contractFinance.getRentPayMode(), RentPayModeEnums.END_PAY.getType())){  //期末支付
            contract.setLeaseTermEndDate(lastRepayDate);
        }*/
        Example example1 = SqlUtil.newExample(Contract.class);
        example1.createCriteria().andEqualTo("contNo",deferTaskVo.getContNo());
        contractRepository.updateByExampleSelectiveData(contract,example1);
    }

    /**
     * @Title:
     * @Description: 合同展期申请审批退回上一级
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Override
    @Transactional
    public void sendBack(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.approvalReturnSuperior(deferTaskVo.getTaskId());
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.SENDBACK.getType(),sysUser);
        //更新展期任务信息
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 打印付款单
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Override
    @Transactional
    public String printPaymentOrder(DeferTaskVo deferTaskVo) {
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(deferTaskVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        //付款金额合计
        if(deferTaskVo.getBackDeposit()!=null){
            pdfVariables.put("totalShouldPay", StringUtils.defaultString(StringUtils.getValue(Math.abs(deferTaskVo.getBackDeposit().floatValue()))));
        }

        pdfVariables.put("payAccountName", deferTaskVo.getPayAccountName()); //付款户名
        pdfVariables.put("payAccountNo", deferTaskVo.getPayAccountNo()); //付款账号
        pdfVariables.put("payAccBranch", deferTaskVo.getPayAccBranch()); //付款银行
        pdfVariables.put("recAccBranch", deferTaskVo.getRecAccBank()); //收款银行
        pdfVariables.put("recAccountName", deferTaskVo.getRecAccountName()); //收款户名
        pdfVariables.put("recAccountNo", deferTaskVo.getRecAccountNo()); //收款账号
        pdfVariables.put("lessor", deferTaskVo.getLessor()); //出租人
        pdfVariables.put("name", deferTaskVo.getLessee());//承租人
        pdfVariables.put("vinNo", deferTaskVo.getVinNo());//车架号

        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_DEFER_TASK.getType());
        return filePath;
    }

    /**
     * @Title:
     * @Description:  根据contNo获取展期合同的展期前合同信息
     * @param deferTaskVo
     * @return DeferTaskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public DeferTaskVo findOldDeferTaskVoByContNo(DeferTaskVo deferTaskVo) {
        DeferTaskVo deferTask = null;
        if(StringUtils.isNotTrimBlank(deferTaskVo.getContNo())){
            //当前合同信息
             deferTask = deferTaskRepository.selectDeferTaskVoByContNo(deferTaskVo);
            if(deferTask != null){
                //已还款信息
                ContRepaySkedAlreadyPayInfoVo contRepaySkedAlreadyPayInfoVo =   commonGetRepayInfoService.commonGetRepayInfo(deferTask.getContNo());
                if(contRepaySkedAlreadyPayInfoVo != null){
                    deferTask.setAlreadyPayPeriod(contRepaySkedAlreadyPayInfoVo.getAlreadyRepayNper());
                    deferTask.setAlreadyPayAmount(contRepaySkedAlreadyPayInfoVo.getAlreadyRepayAmount());
                }
            }
        }
        return deferTask;
    }


    /**
     * @Title:
     * @Description: 审批日志保存
     * @param
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Transactional
    private void saveWorkFlowLog(DeferTaskVo deferTaskVo, ActRuTaskVo actRuTaskVo, String actType, SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(deferTaskVo.getDeferTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.DEFER_CONTRACT.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(deferTaskVo.getMemo());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 更新展期任务表信息
     * @param
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-17 14:35:16
     */
    @Transactional
    private void updateDeferTaskInfo(DeferTaskVo deferTaskVo, ActRuTaskVo actRuTaskVo) {
        //更新任务表
        deferTaskVo.setDeferTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        deferTaskVo.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点人
        Example example = SqlUtil.newExample(DeferTask.class);
        example.createCriteria().andEqualTo("deferTaskNo",deferTaskVo.getDeferTaskNo());
        deferTaskRepository.updateByExampleSelectiveData(deferTaskVo.getEntity(),example);
    }

    /**
     * @Title:
     * @Description: 获取还款计划表
     * @param deferTaskVo
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    private List<ContRepaySked> getContrepaySkedList(DeferTaskVo deferTaskVo){
        //取得合同融资信息，生成还款计划表
        ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(deferTaskVo.getContNo());
        //还款日取得
        String repayDay = contractFinanceVo.getRepayDay();
        if(StringUtils.isTrimBlank(repayDay)){
            throw new FmsServiceException("还款日不能为空");
        }
        //获取合同信息
        Example example  = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo",deferTaskVo.getContNo());
        Contract contract = contractRepository.selectOneByExample(example);
        //删除原来的尾付
        Example example1 = SqlUtil.newExample(ContRepaySked.class);
        example1.createCriteria().andEqualTo("contNo",deferTaskVo.getContNo()).andEqualTo("repayType", RepayTypeEnums.FINAL_AMOUNT.getType());
        //尾付的日期
        Date validateTime = contRepaySkedRepository.selectOneByExample(example1).getRepayDate();
        contRepaySkedRepository.deleteExampleData(example1,new ContRepaySked());
        String[][] contRepaySkedArray = Financials.findmyrepaymentplan(deferTaskVo.getDeferAmount(), BigDecimal.ZERO,
                deferTaskVo.getDeferMaturity(), contractFinanceVo.getRepayRate(), BigDecimalUtils.dividePercent(deferTaskVo.getInterestRate()), contractFinanceVo.getRepayMode(), repayDay, contractFinanceVo.getRentPayMode());
        List<ContRepaySked> contRepaySkedList = new ArrayList<>();
        //期数
        int period  = Integer.valueOf(deferTaskVo.getDeferMaturity())/Integer.valueOf(contractFinanceVo.getRepayRate());
        //每期手续费
        BigDecimal charge = null;
        if(ChargePayModeEnums.INSTALMENT_CHARGE.getType().equals(contractFinanceVo.getChargePayMode())){
            charge = contractFinanceVo.getCharge().divide(new BigDecimal(period), 0, BigDecimal.ROUND_HALF_UP);
        }
        //每期返还保证金
        BigDecimal deposit = null;
        if(DepositRtnModeEnums.INSTALMENT_DEPOSIT.getType().equals(contractFinanceVo.getDepositRtnMode())){
            deposit = contractFinanceVo.getDeposit().divide(new BigDecimal(period), 0, BigDecimal.ROUND_HALF_UP);
        }

        //手续费合计
        BigDecimal chargeSum = new BigDecimal(0);
        //保证金合计
        BigDecimal depositSum = new BigDecimal(0);
        //实际租金
        BigDecimal rentActual = null;
        //原来还款的期数
        int finPeriodType = Integer.valueOf(contractFinanceVo.getFinPeriodType());
        //生成还款计划表
        for(int i=1; i< contRepaySkedArray.length; i++){
            if(!StringUtils.isTrimBlank(contRepaySkedArray[i][0])){
                ContRepaySked contRepaySked = new ContRepaySked();

                contRepaySked.setContNo(deferTaskVo.getContNo());
                contRepaySked.setPeriod(i+finPeriodType);//期数
                contRepaySkedArray[i][0] = DateUtils.getRepayDate(validateTime, repayDay, i, contractFinanceVo.getRentPayMode());
                contRepaySked.setRepayDate(DateUtils.strToDate(contRepaySkedArray[i][0], DateUtils.formatStr_yyyyMMd_NO));//还款日期


                //实际客户租金
                rentActual = new BigDecimal(contRepaySkedArray[i][1]);
//                if(ChargePayModeEnums.INSTALMENT_CHARGE.getType().equals(contractFinanceVo.getChargePayMode())){
//                    //最后一期
//                    if(i == period){
//                        charge = contractFinanceVo.getCharge().subtract(chargeSum);
//                    }
//                    contRepaySked.setCharge(charge);
//                    rentActual = rentActual.add(charge);
//                    chargeSum = chargeSum.add(charge);
//                }
//                if(DepositRtnModeEnums.INSTALMENT_DEPOSIT.getType().equals(contractFinanceVo.getDepositRtnMode())){
//                    //最后一期
//                    if(i == period){
//                        deposit = contractFinanceVo.getDeposit().subtract(depositSum);
//                    }
//                    contRepaySked.setDeposit(deposit);
//                    rentActual = rentActual.subtract(deposit);
//                    depositSum = depositSum.add(deposit);
//                }

                //成交日期
                contRepaySked.setDealDate(DateUtils.getNowDate());
                contRepaySked.setRent(new BigDecimal(contRepaySkedArray[i][1]));//每期客户租金
                contRepaySked.setPrincipal(new BigDecimal(contRepaySkedArray[i][2]));//当期本金
                contRepaySked.setInterest(new BigDecimal(contRepaySkedArray[i][3]));//当期利息
                contRepaySked.setRestPrincipal(new BigDecimal(contRepaySkedArray[i][4]));//当期剩余本金;
                contRepaySked.setIntrstMonthRate(new BigDecimal(contRepaySkedArray[i][5]));//当期月利率;
                //每月牌照使用费
                if(contractFinanceVo.getLicenseFee() != null){
                    rentActual = rentActual.add(contractFinanceVo.getLicenseFee());
                }
                contRepaySked.setRentActual(rentActual);
                setContRepaySked(contRepaySked, contractFinanceVo.getContNo());
                contRepaySkedList.add(contRepaySked);
            }
        }
        return contRepaySkedList;
    }

    /**
     * @Description: 还款计划表初始值
     * @param contRepaySked
     */
    private void setContRepaySked(ContRepaySked contRepaySked, String contNo) {
        //扣款状态-待扣款
        contRepaySked.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
        //逾期状态-正常
        contRepaySked.setOverdueStatus(OverDueStatusEnums.NOT_OVERDUE.getType());
    }

    /**
     * @Description: 保存展期生成合同-补充协议
     * @param deferTaskVo
     */
    private void saveDeferBcxy(DeferTaskVo deferTaskVo){
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(deferTaskVo);
        //赋值
        pdfVariables.put("groupName",deferTaskVo.getLessor()); //甲方
        pdfVariables.put("name",deferTaskVo.getLessee());// 乙方
        pdfVariables.put("contNo",deferTaskVo.getContNo());//合同号
        pdfVariables.put("date",DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));//当前时间
        pdfVariables.put("phase",String.valueOf(deferTaskVo.getAlreadyPayPeriod())); //已还期数
        pdfVariables.put("TailMoney",String.valueOf(deferTaskVo.getBalancePayment())); //尾款
        pdfVariables.put("TailMoney1",String.valueOf(deferTaskVo.getBalancePayment())); //尾款
        pdfVariables.put("contNo2",(deferTaskVo.getContNo()+"-ZQ"));
        //pdf路径
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.BCXY_WKZQ.getType());
        //根据文件类型取得 合同附件类型
        List<BasFileType> basFileTypeList = new ArrayList<>();
        try {
            basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE.getCodeType()));
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("合同附件类型取得失败");
        }
        List<BizFiles> bizFilesList = new ArrayList<>();
        for(BasFileType basFileType:basFileTypeList){
            if(basFileType.getFileType().equals(BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE_1.getCodeType())){
                BizFiles bizFiles = new BizFiles();
                bizFiles.setBizCode(deferTaskVo.getDeferTaskNo());
                bizFiles.setBizCodeType(BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE.getCodeType());
                bizFiles.setFileType(basFileType.getFileType());
                bizFiles.setFileName(basFileType.getFileTypeName()+deferTaskVo.getContNo()+".pdf");
                bizFiles.setFilePath(filePath);
                bizFilesList.add(bizFiles);
            }
        }
        bizFilesService.modifyBizFilesList(bizFilesList,deferTaskVo.getDeferTaskNo(),BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE.getCodeType());
    }

}
