package cn.com.leadu.fms.insurance.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActRenewalRegisterUtils;
import cn.com.leadu.fms.business.service.*;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.insurance.ChargeStatusEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.FinFlagEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.InsurPurTypeEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.ServiceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileBizCodeTypeEnum;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileDetailStatusEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.insurance.repository.RenewalRegisterRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContInsuranceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.insurance.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.insurance.rpc.original.OrigFileRpc;
import cn.com.leadu.fms.insurance.rpc.prebiz.BizFilesRpc;
import cn.com.leadu.fms.insurance.rpc.prebiz.ContFinDetailRpc;
import cn.com.leadu.fms.insurance.rpc.prebiz.ContInsuranceRpc;
import cn.com.leadu.fms.insurance.rpc.prebiz.GuaranteeInfoRpc;
import cn.com.leadu.fms.insurance.rpc.system.SysParamRpc;
import cn.com.leadu.fms.insurance.service.RenewalRegisterService;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterDeleteListVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterDeleteVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterModifyVo;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contpayment.ContPaymentVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author yanfengbo
 * @ClassName: RenewalRegisterService
 * @Description: 续保任务一览业务实现层
 * @date 2018-05-17
 */
@Service
@Slf4j
public class RenewalRegisterServiceImpl implements RenewalRegisterService {

    /**
     * @Fields  : 续保任务一览repository
     */
    @Autowired
    private RenewalRegisterRepository renewalRegisterRepository;

    /**
     * @Fields  : 车辆保险Rpc
     */
    @Autowired
    private ContInsuranceRpc contInsuranceRpc;

    /**
     * @Fields  : 车辆保险Repository
     */
    @Autowired
    private ContInsuranceRepository contInsuranceRepository;

    @Autowired
    private BizFilesService bizFilesService;

    @Autowired
    private BizFilesRpc bizFilesRpc;

    /**
     * @Fields  : 财务付款Repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 财务待收款Repository
     */
    @Autowired
    ContChargeRepository contChargeRepository;

    /**
     * @Fields  : 担保信息rpc
     */
    @Autowired
    private GuaranteeInfoRpc guaranteeInfoRpc;

    /**
     * @Fields  : 合同融资信息明细rpc
     */
    @Autowired
    private ContFinDetailRpc contFinDetailRpc;

    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 财务收款Repository
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    /**
     * @Fields  : 财务勾稽Repository
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Fields  : 审批日志Service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 合同信息Repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  : 系统常量rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  :资料邮寄附件Repository
     */
    @Autowired
    private OrigFileRepository origFileRepository;

    /**
     * @Fields  :资料邮寄附件明细Repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;

    @Autowired
    private OrigFileRpc origFileRpc;

    /**
     * @Fields  :附件rpc
     */
    @Autowired
    private BasFileTypeRpc basFileTypeRpc;

    /**
     * @Fields  : 通用pdfservice
     * @author yanfengbo
     */
    @Autowired
    private CommonPdfService commonPdfService;

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
     * @Title:
     * @Description: 分页查询续保任务一览
     * @param renewalRegisterVo
     * @return PageInfoExtend<RenewalRegister>
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 15:28:42
     */
    public PageInfoExtend<RenewalRegisterVo> findRenewalRegistersByPage(RenewalRegisterVo renewalRegisterVo){
        if(StringUtils.isNotTrimBlank(renewalRegisterVo.getRenewalRegisterId()))
            renewalRegisterVo.setRenewalRegisterId(renewalRegisterVo.getRenewalRegisterId());
        else
            renewalRegisterVo.setRenewalRegisterId(null);
        if (StringUtils.isTrimBlank(renewalRegisterVo.getContNo()))
            renewalRegisterVo.setContNo(null);
        else
            renewalRegisterVo.setContNo(SqlUtil.likePattern(renewalRegisterVo.getContNo()));

        if(StringUtils.isTrimBlank(renewalRegisterVo.getName()))
            renewalRegisterVo.setName(null);
        else
            renewalRegisterVo.setName(SqlUtil.likePattern(renewalRegisterVo.getName()));
        if(StringUtils.isNotTrimBlank(renewalRegisterVo.getVinNo()))
            renewalRegisterVo.setVinNo(SqlUtil.likePattern(renewalRegisterVo.getVinNo()));
        else
            renewalRegisterVo.setVinNo(null);
        if(StringUtils.isNotTrimBlank(renewalRegisterVo.getVehicleLicenseNo()))
            renewalRegisterVo.setVehicleLicenseNo(SqlUtil.likePattern(renewalRegisterVo.getVehicleLicenseNo()));
        else
            renewalRegisterVo.setVehicleLicenseNo(null);
        if(StringUtils.isNotTrimBlank(renewalRegisterVo.getServiceType()))
            renewalRegisterVo.setServiceType(renewalRegisterVo.getServiceType());
        else
            renewalRegisterVo.setServiceType(null);
        if(StringUtils.isNotTrimBlank(renewalRegisterVo.getRenewalTaskNo()))
            renewalRegisterVo.setRenewalTaskNo(renewalRegisterVo.getRenewalTaskNo());
        else
            renewalRegisterVo.setRenewalTaskNo(null);
        //保险失效日区间(起始)
        if(StringUtils.isTrimBlank(renewalRegisterVo.getValidStartTime()))
            renewalRegisterVo.setValidStartTime(null);
        else
            renewalRegisterVo.setValidStartTime(renewalRegisterVo.getValidStartTime());
        //保险失效日区间(结束)
        if(StringUtils.isTrimBlank(renewalRegisterVo.getValidEndTime()))
            renewalRegisterVo.setValidEndTime(null);
        else
            renewalRegisterVo.setValidEndTime(renewalRegisterVo.getValidEndTime());
        PageInfoExtend<RenewalRegisterVo>  renewalRegisterVos = renewalRegisterRepository.selectListVoByPage("selectRenewalRegistersByPage", renewalRegisterVo, renewalRegisterVo.getPageQuery());
        List<RenewalRegisterVo> renewalRegisterList = renewalRegisterVos.getData();
        List<GuaranteePers> guaranteePersList = new ArrayList<>();
        List<GuaranteeComp> guaranteeCompList = new ArrayList<>();
        for(RenewalRegisterVo renewalRegister:renewalRegisterList){
            try {
                 guaranteePersList =  ResponseEntityUtils.getRestResponseData(guaranteeInfoRpc.findGuaranteePersByApplyNo(renewalRegister.getApplyNo()));
                 guaranteeCompList = ResponseEntityUtils.getRestResponseData(guaranteeInfoRpc.findGuaranteeCompByApplyNo(renewalRegister.getApplyNo()));
            } catch (FmsRpcException ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
                throw new FmsServiceException("请求失败");
            }
            if(ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList)){
                for(GuaranteeComp guaranteeComp:guaranteeCompList){
                    GuaranteePers guaranteePers = new GuaranteePers();
                    guaranteePers.setName(guaranteeComp.getCompLegalRep());
                    guaranteePers.setMobileNo(guaranteeComp.getMobileNo());
                    guaranteePersList.add(guaranteePers);
                }
            }
            renewalRegister.setGuaranteePersList(guaranteePersList);
            List<ContFinDetail> contFinDetailList = null;
            try {
                contFinDetailList = ResponseEntityUtils.getRestResponseData(contFinDetailRpc.findContFinDetailsByContNo(renewalRegister.getContNo()));
            } catch (FmsRpcException ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
                throw new FmsServiceException("请求失败");
            }
            //排序
            Comparator<ContFinDetail> comparator = new Comparator<ContFinDetail>() {
                public int compare(ContFinDetail s1, ContFinDetail s2) {
                    return s1.getFinItemYear() - s2.getFinItemYear();
                }
            };
            if(ArrayUtils.isNotNullAndLengthNotZero(contFinDetailList)){
                Collections.sort(contFinDetailList,comparator);
            }
            renewalRegister.setContFinDetailList(contFinDetailList);
        }
        renewalRegisterVos.setData(renewalRegisterList);

        return renewalRegisterVos;
    }

    /**
     * @Title:
     * @Description: 排序方法
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-14 15:28:42
     */



    /**
     * @Title:
     * @Description: 根据taskNo获取一条续保任务明细
     * @param renewalRegisterVo
     * @return RenewalRegisterVo
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 15:28:42
     */
    @Override
    @Transactional
    public RenewalRegisterVo findRenewalRegistersByTaskNo(RenewalRegisterVo renewalRegisterVo) {
        if(StringUtils.isNotTrimBlank(renewalRegisterVo.getRenewalTaskNo()))
            renewalRegisterVo.setRenewalTaskNo(renewalRegisterVo.getRenewalTaskNo());
        else
            return new RenewalRegisterVo();
        PageInfoExtend<RenewalRegisterVo>  renewalRegisterVos = renewalRegisterRepository.selectListVoByPage("selectRenewalRegistersByTaskNo", renewalRegisterVo, renewalRegisterVo.getPageQuery());
        RenewalRegisterVo renewalRegister = renewalRegisterVos.getData().get(0);
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",renewalRegisterVo.getRenewalTaskNo()).andEqualTo("paymentType",BizTypeEnums.RENEWAL.getType());
        ContPay contPay =  contPayRepository.selectOneByExample(example);
        if(contPay!=null){
            renewalRegister.setRecAccBank(contPay.getRecAccBank());
            renewalRegister.setRecAccountName(contPay.getRecAccountName());
            renewalRegister.setRecAccountNo(contPay.getRecAccountNo());
            renewalRegister.setRecEleBankNo(contPay.getRecEleBankNo());
            renewalRegister.setRecAccBranch(contPay.getRecAccBranch());
            renewalRegister.setRequesAmount(contPay.getPayAmount());
            renewalRegister.setPayAccBank(contPay.getPayAccBank());
            renewalRegister.setPayAccountName(contPay.getPayAccountName());
            renewalRegister.setPayAccountNo(contPay.getPayAccountNo());
            renewalRegister.setPayEleBankNo(contPay.getPayEleBankNo());
            renewalRegister.setPayAccBranch(contPay.getPayAccBranch());
        }
        return renewalRegister;
    }


    /**
     * @Title:
     * @Description: 续保财务确认收款
     * @param renewalRegisterVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 15:28:42
     */
    @Transactional
    public void renewalRegisterReceipt(RenewalRegisterVo renewalRegisterVo,SysUser sysUser){
        ActRuTaskVo task =  ActRenewalRegisterUtils.approvalAgree(renewalRegisterVo.getTaskId());
        //登入审批日志
        saveWorkFlowLog(renewalRegisterVo,task, ActTypeEnums.APPROVAL.getType(),sysUser);
        //收款总金额
        BigDecimal totalReceiveAmount = BigDecimal.ZERO;

        if(ArrayUtils.isNotNullAndLengthNotZero(renewalRegisterVo.getRenewalRegisterVoList())){
            List<ContReceipt> contReceiptList = new ArrayList<>();
            List<ContReceiptExam> contReceiptExamList = new ArrayList<>();
            for(RenewalRegisterVo renewalRegister:renewalRegisterVo.getRenewalRegisterVoList()){
                totalReceiveAmount = totalReceiveAmount.add(BigDecimalUtils.getNotNullBigDecimal(renewalRegister.getReceiptAmount()));
                //插入财务收款表
                ContReceipt contReceipt = new ContReceipt();
                contReceipt.setContReceiptId(UUIDUtils.getUUID());
                contReceipt.setInputMode(InputModeEnums.INPUT.getType());
                contReceipt.setReceiptAmount(renewalRegister.getReceiptAmount());
                contReceipt.setRecAccBank(renewalRegister.getRecAccBank());
                contReceipt.setRecAccountName(renewalRegister.getRecAccountName());
                contReceipt.setRecAccBranch(renewalRegister.getRecAccBranch());//收款银行
                contReceipt.setRecAccountNo(renewalRegister.getRecAccountNo());
                contReceipt.setRecEleBankNo(renewalRegister.getRecEleBankNo());
                contReceipt.setRestAmount(new BigDecimal(0));
                contReceipt.setReceiptDate(renewalRegister.getReceiptDate());
                contReceipt.setMemo(renewalRegister.getMemo());
                contReceiptList.add(contReceipt);
                //contReceiptRepository.insertData(contReceipt);
                //插入财务勾稽表
                ContReceiptExam contReceiptExam  =  new ContReceiptExam();
                contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType());
                Example example = SqlUtil.newExample(ContCharge.class);
                example.createCriteria().andEqualTo("chargeBizId",renewalRegisterVo.getRenewalTaskNo()).andEqualTo("chargeBizType",BizTypeEnums.RENEWAL.getType());
                ContCharge contCharge = contChargeRepository.selectOneByExample(example);
                contReceiptExam.setReceiptBizId(contCharge.getContChargeId());      //款项业务id
                contReceiptExam.setContReceiptId(contReceipt.getContReceiptId());
                contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());   //勾稽类型
                contReceiptExam.setReceiptExamAmount(renewalRegister.getReceiptAmount());
                contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());
                contReceiptExamList.add(contReceiptExam);
                //contReceiptExamRepository.insertData(contReceiptExam);
            }
            contReceiptRepository.insertDataList(contReceiptList);
            contReceiptExamRepository.insertDataList(contReceiptExamList);
        }
        //保存开票信息
        saveInvoice(renewalRegisterVo, totalReceiveAmount);
        //更新续保任务表
        Example example1 = SqlUtil.newExample(RenewalRegister.class);
        example1.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
        RenewalRegister renewalRegister = renewalRegisterRepository.selectOneByExample(example1);
        renewalRegister.setRenewalStatus(task.getTaskCode());
        renewalRegister.setPresentUser(task.getNextAssignee());
        renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example1);

    }


    /**
     * @Description: 保存开票信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/21 14:27
     */
    private void saveInvoice(RenewalRegisterVo renewalRegisterVo, BigDecimal totalReceiveAmount) {
        //构造开票信息
        Invoice invoice = new Invoice();
        invoice.setInvoiceDataType(InvoiceTypeEnums.INSURANCE_COST.getType());
        invoice.setContNo(renewalRegisterVo.getContNo());
        invoice.setReceiveDate(new Date());
        invoice.setReceiveAccount(renewalRegisterVo.getCustomPaymentAmount());//应收金额=客户打款金额
        invoice.setReceiveActualAccount(totalReceiveAmount);//实收金额=到账金额
        invoice.setInvoiceAmount(totalReceiveAmount);//开票金额=到账金额
        invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());//未开票
        invoice.setInvoiceVoucherStatus(YesNoFlagEnums.NO.getType());//未生成凭证
        invoice.setDetailNo(renewalRegisterVo.getRenewalTaskNo());
        BigDecimal invoiceTax;
        //获取税率
        try {
            //税率6
            invoiceTax = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.INVOICE_TAX_6));
        } catch (Exception e) {
            throw new FmsServiceException("获取开票税率失败");
        }
        invoice.setInvoiceTax(invoiceTax);
        //开票金额大于0，保存
        if(BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).compareTo(BigDecimal.ZERO)>0){
            invoiceRepository.insertData(invoice);
        }
    }

    /**
     * @Title:
     * @Description: 续保请款
     * @param renewalRegisterVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @Override
    @Transactional
    public void renewalRegisterWithdraw(RenewalRegisterVo renewalRegisterVo,SysUser sysUser) {
        ActRuTaskVo actRuTaskVo =  ActRenewalRegisterUtils.approvalAgree(renewalRegisterVo.getTaskId());
        saveWorkFlowLog(renewalRegisterVo,actRuTaskVo,ActTypeEnums.APPROVAL.getType(),sysUser);
        //生成一条合同车辆保险
        ContInsurance contInsurance = new ContInsurance();
        contInsurance.setContNo(renewalRegisterVo.getContNo());
        contInsurance.setInsCompName(renewalRegisterVo.getInsCompName());
        contInsurance.setInsuranceType(renewalRegisterVo.getInsuranceType());
        contInsuranceRepository.insertData(contInsurance);
        //更新续保任务表
        Example example1 = SqlUtil.newExample(RenewalRegister.class);
        example1.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
        RenewalRegister renewalRegister = renewalRegisterRepository.selectOneByExample(example1);
        renewalRegister.setRenewalStatus(actRuTaskVo.getTaskCode());
        renewalRegister.setPresentUser(actRuTaskVo.getNextAssignee());
        renewalRegister.setRenewalContVehinsId(contInsurance.getContVehinsId());
        renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example1);
        //财务付款表
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",renewalRegisterVo.getRenewalTaskNo()).andEqualTo("paymentType",BizTypeEnums.RENEWAL.getType());
        ContPay contPayGet =  contPayRepository.selectOneByExample(example);
        ContPay contPay = new ContPay();
        contPay.setPaymentType(BizTypeEnums.RENEWAL.getType());
        contPay.setBizCode(renewalRegisterVo.getRenewalTaskNo());
        contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
        contPay.setPayFund(PayFundNameEnums.INSURANCE_COST.getType());
        contPay.setPayAmount(renewalRegisterVo.getRequesAmount());
        contPay.setRecAccBank(renewalRegisterVo.getRecAccBank());
        contPay.setRecAccBranch(renewalRegisterVo.getRecAccBranch());
        contPay.setRecAccountName(renewalRegisterVo.getRecAccountName());
        contPay.setRecAccountNo(renewalRegisterVo.getRecAccountNo());
        contPay.setRecEleBankNo(renewalRegisterVo.getRecEleBankNo());
        if(contPayGet==null){
            contPayRepository.insertData(contPay);
        }else{
            contPayRepository.updateByExampleSelectiveData(contPay,example);
        }

    }

    /**
     * @Title:
     * @Description: 资管复核
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @Override
    @Transactional
    public void renewalRegisterReview(RenewalRegisterVo renewalRegisterVo,SysUser sysUser) {
        ActRuTaskVo task =  ActRenewalRegisterUtils.approvalAgree(renewalRegisterVo.getTaskId());
        //审批日志登入
        saveWorkFlowLog(renewalRegisterVo,task,ActTypeEnums.APPROVAL.getType(),sysUser);

        Example example1 = SqlUtil.newExample(RenewalRegister.class);
        example1.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
        RenewalRegister renewalRegister = renewalRegisterRepository.selectOneByExample(example1);
        renewalRegister.setRenewalStatus(task.getTaskCode());
        renewalRegister.setPresentUser(task.getNextAssignee());
        renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example1);
    }

    /**
     * @Title:
     * @Description: 财务制单
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @Override
    public void renewalRegisterVoucher(RenewalRegisterVo renewalRegisterVo,SysUser sysUser) {
        ActRuTaskVo task = ActRenewalRegisterUtils.approvalAgree(renewalRegisterVo.getTaskId());
        saveWorkFlowLog(renewalRegisterVo,task,ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新财务付款表
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",renewalRegisterVo.getRenewalTaskNo()).andEqualTo("paymentType",BizTypeEnums.RENEWAL.getType());
        ContPay contPay = new ContPay();
        contPay.setPayAccBank(renewalRegisterVo.getPayAccBank());
        contPay.setPayAccBranch(renewalRegisterVo.getPayAccBranch());
        contPay.setPayAccountName(renewalRegisterVo.getPayAccountName());
        contPay.setPayAccountNo(renewalRegisterVo.getPayAccountNo());
        contPay.setPayEleBankNo(renewalRegisterVo.getPayEleBankNo());
        contPayRepository.updateByExampleSelectiveData(contPay,example);

        Example example1 = SqlUtil.newExample(RenewalRegister.class);
        example1.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
        RenewalRegister renewalRegister = renewalRegisterRepository.selectOneByExample(example1);
        renewalRegister.setRenewalStatus(task.getTaskCode());
        renewalRegister.setPresentUser(task.getNextAssignee());
        renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example1);

    }

    /**
     * @Title:
     * @Description: 财务付款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @Override
    @Transactional
    public void renewalRegisterPayment(RenewalRegisterVo renewalRegisterVo,SysUser sysUser) {
        ActRuTaskVo task =  ActRenewalRegisterUtils.approvalAgree(renewalRegisterVo.getTaskId());
        saveWorkFlowLog(renewalRegisterVo,task,ActTypeEnums.APPROVAL.getType(),sysUser);
        ContPay contPay = new ContPay();
        contPay.setPayStatus(PayStatusEnums.WITHDRAWING.getType());
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",renewalRegisterVo.getRenewalTaskNo()).andEqualTo("paymentType",BizTypeEnums.RENEWAL.getType());
        contPayRepository.updateByExampleSelectiveData(contPay,example);
        //录入原件归档表
        saveOrigFile(renewalRegisterVo);
        if(task.getEndFlag()){
            Example example1 = SqlUtil.newExample(RenewalRegister.class);
            example1.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
            RenewalRegister renewalRegister = renewalRegisterRepository.selectOneByExample(example1);
            renewalRegister.setRenewalStatus(task.getTaskCode());
            renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example1);
        }
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @Override
    public void renewalRegisterSendBack(RenewalRegisterVo renewalRegisterVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo =  ActRenewalRegisterUtils.approvalReturnSuperior(renewalRegisterVo.getTaskId());
        //更新续保任务登记表
        Example example1 = SqlUtil.newExample(RenewalRegister.class);
        example1.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
        RenewalRegister renewalRegister = renewalRegisterRepository.selectOneByExample(example1);
        renewalRegister.setRenewalStatus(actRuTaskVo.getTaskCode());
        renewalRegister.setPresentUser(actRuTaskVo.getNextAssignee());
        renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example1);

        saveWorkFlowLog(renewalRegisterVo,actRuTaskVo,ActTypeEnums.SENDBACK.getType(),sysUser);
    }

    /**
     * @Description: 保存邮寄附件
     * @author:ningyangyang
     * @param renewalRegisterVo
     */
    @Transactional
    public void saveOrigFile(RenewalRegisterVo renewalRegisterVo){

        //存入邮寄附件
        OrigFile origFile = new OrigFile();
        origFile.setBizCode(renewalRegisterVo.getRenewalTaskNo());
        OrigFile origFile1 = new OrigFile();
        try {
            origFile1 = ResponseEntityUtils.getRestResponseData(origFileRpc.findOrigFileByContNo(renewalRegisterVo.getContNo()));
        } catch (FmsRpcException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new FmsServiceException("取得归档信息失败");
        }
        origFile.setBizCodeType(OrigFileBizCodeTypeEnum.INSURANCE_TYPE.getType());
        origFile.setOrigFileType(BizCodeTypeEnums.ORIG_RENEWAL_SORT_FILE.getCodeType());
        origFile.setOrigFileStatus(OrigFileStatusEnums.VERIFIED.getType());
        if(origFile1 != null){
            origFile.setFileRecordNo(origFile1.getFileRecordNo());
        }
        Example example = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo",renewalRegisterVo.getContNo());
        Contract contract = contractRepository.selectOneByExample(example);
        origFile.setOrigFileUser(contract.getApplyUser());
        origFile.setOrigFileGroup(contract.getGroupCode());
        //合同生效时间 --当日
        Long contractValidDate  = DateUtils.getNowDate().getTime();
        Long archday = null;
        try {
             archday = new Long(ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.INSURANCE_ARCHIVAL_DAYS)));

        } catch (FmsRpcException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw  new FmsServiceException("取得系统常量失败");
        }
        Long archdays =   archday * 24 * 3600 * 1000;
        Date date = new Date(contractValidDate+archdays);
        origFile.setOrigDeadline(date);
        origFileRepository.insertData(origFile);
        List<BasFileType> basFileTypeList = null;
        //附件详情存入
        try {
             basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(BizCodeTypeEnums.ORIG_RENEWAL_SORT_FILE.getCodeType()));
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("请求失败");
        }
        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(basFileTypeList)){
            for(BasFileType basFileType:basFileTypeList){
                OrigFileDetail origFileDetail = new OrigFileDetail();
                    origFileDetail.setBizCodeType(origFile.getBizCodeType());
                    origFileDetail.setBizCode(origFile.getBizCode());
                origFileDetail.setFileType(basFileType.getFileType());
                origFileDetail.setFileCount(basFileType.getFileQtyLimit());
                // 续保文件 没有邮寄操作 初始状态：待归档
                origFileDetail.setOrigFileDetailStatus(OrigFileDetailStatusEnums.TO_BE_SORTED.getType());
                origFileDetail.setOrigFlag(YesNoFlagEnums.YES.getType());
                origFileDetailList.add(origFileDetail);
            }
        }
        origFileDetailRepository.insertDataList(origFileDetailList);
    }

    /**
     * @Title:
     * @Description: 保存审批日志
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    public void saveWorkFlowLog(RenewalRegisterVo renewalRegisterVo, ActRuTaskVo actRuTaskVo, String actType, @AuthUserInfo SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(renewalRegisterVo.getRenewalTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.RENEWAL.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(renewalRegisterVo.getRemark1());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 修改续保任务一览
     * @param renewalRegisterModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    public void modifyRenewalRegister(RenewalRegisterModifyVo renewalRegisterModifyVo){
        renewalRegisterRepository.updateByPrimaryKeySelectiveData(renewalRegisterModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过renewalRegisterId删除续保任务一览
     * @param renewalRegisterDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    public void deleteRenewalRegister(RenewalRegisterDeleteVo renewalRegisterDeleteVo){
        renewalRegisterRepository.deleteData(renewalRegisterDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过renewalRegisterId集合删除续保任务一览
     * @param renewalRegisterDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    public void deleteRenewalRegistersByRenewalRegisterIds(RenewalRegisterDeleteListVo renewalRegisterDeleteListVo){
        renewalRegisterRepository.deleteDataList(renewalRegisterDeleteListVo.getRenewalRegisterIds(),renewalRegisterDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据renewalRegisterId获取续保任务一览
     * @param renewalRegisterId
     * @return RenewalRegister
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    public RenewalRegister findRenewalRegisterByRenewalRegisterId(String renewalRegisterId){
        return renewalRegisterRepository.selectByPrimaryKey(renewalRegisterId);
    }

    /**
     * @Title:
     * @Description: 更新续保任务登记表并启动流程
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date
     */
    @Transactional
    public void saveContInsuranceFromRenewalRegister(RenewalRegisterVo renewalRegisterVo,SysUser sysUser){
        //续保任务号
        String renewalTakNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.INSURANCE_RENEWAL.getType());
        renewalRegisterVo.setRenewalTaskNo(renewalTakNo);
        //启动工作流
        ActRuTaskVo task =  ActRenewalRegisterUtils.startRenewalRegister(renewalTakNo, ServiceTypeEnums.RENEWAL_REGISTER.getDesc(),ServiceTypeEnums.RENEWAL_REGISTER.getDesc());
        //融保险
        if(FinFlagEnums.FIN_INSUR.getType().equals(renewalRegisterVo.getFinFlag())){
            ActRuTaskVo task1 =  ActRenewalRegisterUtils.approvalAgreeToWithdraw(task.getId());
            //日志
            saveWorkFlowLog(renewalRegisterVo,task1,ActTypeEnums.SUBMIT.getType(),sysUser);
            Example example = SqlUtil.newExample(RenewalRegister.class);
            example.createCriteria().andEqualTo("renewalRegisterId",renewalRegisterVo.getRenewalRegisterId());
            RenewalRegister renewalRegister = new RenewalRegister();
            renewalRegister.setRenewalTaskNo(renewalTakNo);  //任务号
            renewalRegister.setRenewalStatus(task1.getTaskCode());
            renewalRegister.setPresentUser(task1.getNextAssignee());
            renewalRegister.setInsurPurType(InsurPurTypeEnums.BY_FIN_COMP.getType());
            renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example);

        }else if(FinFlagEnums.NOT_FIN_INSUR.getType().equals(renewalRegisterVo.getFinFlag()) && InsurPurTypeEnums.BY_FIN_COMP.getType().equals(renewalRegisterVo.getInsurPurType())){
            ActRuTaskVo task1 =  ActRenewalRegisterUtils.approvalAgreeToReceipt(task.getId());
            //日志
            saveWorkFlowLog(renewalRegisterVo,task1,ActTypeEnums.SUBMIT.getType(),sysUser);
            //不融保险且由万量购买
            Example example = SqlUtil.newExample(RenewalRegister.class);
            example.createCriteria().andEqualTo("renewalRegisterId",renewalRegisterVo.getRenewalRegisterId());
            RenewalRegister renewalRegister = new RenewalRegister();
            renewalRegister.setCustomPaymentAmount(renewalRegisterVo.getCustomPaymentAmount()); //客户打款金额
            renewalRegister.setRenewalTaskNo(renewalTakNo);  //任务号
            renewalRegister.setRenewalStatus(task1.getTaskCode());
            renewalRegister.setPresentUser(task1.getNextAssignee());
            renewalRegister.setInsurPurType(renewalRegisterVo.getInsurPurType());
            renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example);
            //录入财务待收款表
            ContCharge contCharge = new ContCharge();
            contCharge.setChargeBizType(BizTypeEnums.RENEWAL.getType());
            contCharge.setChargeBizId(renewalTakNo);
            contCharge.setChargeFund(PayFundNameEnums.INSURANCE_COST.getType());
            contCharge.setChargeAmount(renewalRegisterVo.getCustomPaymentAmount());
            contCharge.setChargeStatus(ChargeStatusEnums.TO_BE_RECEIVE.getType());
            contChargeRepository.insertData(contCharge);
        }else if(FinFlagEnums.NOT_FIN_INSUR.getType().equals(renewalRegisterVo.getFinFlag()) && InsurPurTypeEnums.BY_COSTUME.getType().equals(renewalRegisterVo.getInsurPurType())){
            //不融保险且由客户自己购买，结束流程
            ActRuTaskVo task1 = ActRenewalRegisterUtils.approvalAgreeToEnd(task.getId());
            //日志
            saveWorkFlowLog(renewalRegisterVo,task1,ActTypeEnums.SUBMIT.getType(),sysUser);
            ContInsurance contInsurance = new ContInsurance();
            contInsurance.setContNo(renewalRegisterVo.getContNo());
            contInsurance.setInsuranceType(renewalRegisterVo.getInsuranceType());
            contInsuranceRepository.insertData(contInsurance);
            //续保归档
            saveOrigFile(renewalRegisterVo);
            if(task1.getEndFlag() == true){
                Example example = SqlUtil.newExample(RenewalRegister.class);
                example.createCriteria().andEqualTo("renewalRegisterId",renewalRegisterVo.getRenewalRegisterId());
                RenewalRegister renewalRegister = new RenewalRegister();
                renewalRegister.setRenewalTaskNo(renewalTakNo);  //任务号
                renewalRegister.setRenewalStatus(task1.getTaskCode());
                renewalRegister.setRenewalContVehinsId(contInsurance.getContVehinsId());
                renewalRegister.setInsurPurType(renewalRegisterVo.getInsurPurType());
                renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example);
            }
        }

    }

    /**
     * @Title:
     * @Description: 再次资管确认提交
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date
     */
    @Override
    @Transactional
    public void reSaveContInsuranceFromRenewalRegister(RenewalRegisterVo renewalRegisterVo, SysUser sysUser) {
        //融保险
        if(FinFlagEnums.FIN_INSUR.getType().equals(renewalRegisterVo.getFinFlag())){
            ActRuTaskVo task1 =  ActRenewalRegisterUtils.approvalAgreeToWithdraw(renewalRegisterVo.getTaskId());
            //日志
            saveWorkFlowLog(renewalRegisterVo,task1,ActTypeEnums.SUBMIT.getType(),sysUser);
            Example example = SqlUtil.newExample(RenewalRegister.class);
            example.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
            RenewalRegister renewalRegister = new RenewalRegister();
            renewalRegister.setRenewalStatus(task1.getTaskCode());
            renewalRegister.setPresentUser(task1.getNextAssignee());
            renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example);

        }else if(FinFlagEnums.NOT_FIN_INSUR.getType().equals(renewalRegisterVo.getFinFlag()) && InsurPurTypeEnums.BY_FIN_COMP.getType().equals(renewalRegisterVo.getInsurPurType())){
            ActRuTaskVo task1 =  ActRenewalRegisterUtils.approvalAgreeToReceipt(renewalRegisterVo.getTaskId());
            //日志
            saveWorkFlowLog(renewalRegisterVo,task1,ActTypeEnums.SUBMIT.getType(),sysUser);
            //不融保险且由万量购买
            Example example = SqlUtil.newExample(RenewalRegister.class);
            example.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
            RenewalRegister renewalRegister = new RenewalRegister();
            renewalRegister.setCustomPaymentAmount(renewalRegisterVo.getCustomPaymentAmount()); //客户打款金额
            renewalRegister.setRenewalStatus(task1.getNextAssignee());
            renewalRegister.setPresentUser(task1.getNextAssignee());
            renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example);
            //录入财务待收款表
            Example example1 = SqlUtil.newExample(ContCharge.class);
            example1.createCriteria().andEqualTo("chargeBizType",BizTypeEnums.RENEWAL.getType()).andEqualTo("chargeBizId",renewalRegisterVo.getRenewalTaskNo());
            ContCharge contCharge = new ContCharge();
            contCharge.setChargeAmount(renewalRegisterVo.getCustomPaymentAmount());
            contCharge.setChargeStatus(ChargeStatusEnums.TO_BE_RECEIVE.getType());
            contChargeRepository.updateByExampleSelectiveData(contCharge,example1);
        }else if(FinFlagEnums.NOT_FIN_INSUR.getType().equals(renewalRegisterVo.getFinFlag()) && InsurPurTypeEnums.BY_COSTUME.getType().equals(renewalRegisterVo.getInsurPurType())){
            //不融保险且由客户自己购买，结束流程
            ActRuTaskVo task1 = ActRenewalRegisterUtils.approvalAgreeToEnd(renewalRegisterVo.getTaskId());
            //日志
            saveWorkFlowLog(renewalRegisterVo,task1,ActTypeEnums.SUBMIT.getType(),sysUser);
            ContInsurance contInsurance = new ContInsurance();
            contInsurance.setContNo(renewalRegisterVo.getContNo());
            contInsurance.setInsuranceType(renewalRegisterVo.getInsuranceType());
            contInsuranceRepository.insertData(contInsurance);
            if(task1.getEndFlag() == true){
                Example example = SqlUtil.newExample(RenewalRegister.class);
                example.createCriteria().andEqualTo("renewalTaskNo",renewalRegisterVo.getRenewalTaskNo());
                RenewalRegister renewalRegister = new RenewalRegister();
                renewalRegister.setRenewalStatus(task1.getTaskCode());
                renewalRegister.setRenewalContVehinsId(contInsurance.getContVehinsId());
                renewalRegister.setInsurPurType(renewalRegisterVo.getInsurPurType());
                renewalRegisterRepository.updateByExampleSelectiveData(renewalRegister,example);
            }
        }

    }

    /**
     * @Title:
     * @Description: 续保付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public String printRenewalRegister(RenewalRegisterVo renewalRegisterVo){
        if(renewalRegisterVo == null){
            throw new FmsServiceException("未找到相关数据");
        }
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(renewalRegisterVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        if(renewalRegisterVo.getRequesAmount()!=null){
            pdfVariables.put("requesAmount", StringUtils.defaultString(renewalRegisterVo.getRequesAmount().toString()));
        }
        pdfVariables.put("recAccountName", StringUtils.defaultString(renewalRegisterVo.getRecAccountName()));
        pdfVariables.put("recAccBranch", renewalRegisterVo.getRecAccBank()+" "+renewalRegisterVo.getRecAccBranch());
        pdfVariables.put("recAccountNo", renewalRegisterVo.getRecAccountNo());
        pdfVariables.put("payAccountName", renewalRegisterVo.getPayAccountName());
        if(renewalRegisterVo.getPayAccBank() != null && renewalRegisterVo.getPayAccBranch() != null){
            pdfVariables.put("payAccBranch", renewalRegisterVo.getPayAccBank()+" "+renewalRegisterVo.getPayAccBranch());
        }
        pdfVariables.put("payAccountNo", renewalRegisterVo.getPayAccountNo());
        pdfVariables.put("lessor", renewalRegisterVo.getLessor());
        pdfVariables.put("name", renewalRegisterVo.getName());
        pdfVariables.put("vinNo", renewalRegisterVo.getVinNo());
        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_RENEWAL_REGISTER.getType());
        return filePath;
    }

}
