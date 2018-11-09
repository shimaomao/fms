package cn.com.leadu.fms.prebiz.service.impl;/**
 * Created by yyq on 2018/6/12.
 */

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SAVEINFO;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;
import static cn.com.leadu.fms.common.util.DateUtils.formatStr_yyyyMMdd;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationFlagEnums;
import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonFinBackfillService;
import cn.com.leadu.fms.business.service.CommonFinancialVoucherDataService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.CommonRuleService;
import cn.com.leadu.fms.business.service.CommonSysUserInfoService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.business.vo.CommonFinVouData;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.FinVouDetailValueConstants;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.CommonUserUnitsEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ChargeDetailFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ChargeStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ExamTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.FilBackfillStsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.InputModeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.LicenseAttrEnums;
import cn.com.leadu.fms.common.constant.enums.finance.OverDueStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayFundNameEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ReceiptBizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ReceiptExamStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.VoucherTypeEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.InfoCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileBizCodeTypeEnum;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileDetailStatusEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.ContCostTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.CostItemEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ChargePayModeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.DeductibleFeeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.DepositRtnModeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.CommonUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.Financials;
import cn.com.leadu.fms.common.util.JsonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.asset.repository.MortgageRemindRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.finance.repository.FinBackfillDetailRepository;
import cn.com.leadu.fms.data.finance.repository.FinBackfillRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.data.postbiz.repository.ContCostRepository;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContFinDetailRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleArchivalDaysVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeReceiptVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.postbiz.entity.ContCost;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay.ContReceiptPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import cn.com.leadu.fms.prebiz.rpc.baseinfo.BasBankInfoRpc;
import cn.com.leadu.fms.prebiz.rpc.finance.ContChargeRpc;
import cn.com.leadu.fms.prebiz.rpc.finance.ContRepaySkedRpc;
import cn.com.leadu.fms.prebiz.service.ContPayService;
import cn.com.leadu.fms.prebiz.service.ContReceiptPayService;
import cn.com.leadu.fms.prebiz.service.ContRequestPayService;
import cn.com.leadu.fms.prebiz.service.ContractFinanceService;
import cn.com.leadu.fms.prebiz.service.ContractService;
import cn.com.leadu.fms.prebiz.service.ContractVehicleService;
import com.alibaba.fastjson.JSON;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @program: fms
 * @description: 合同请款收款相关service
 * @author: yangyiquan
 * @create: 2018-06-12 21:13
 **/
@Service
@Slf4j
public class ContReceiptPayServiceImpl implements ContReceiptPayService {

    /**
     * @Fields  : 银行信息维护rpc
     */
    @Autowired
    private BasBankInfoRpc basBankInfoRpc;
    /**
     * @Fields  : 财务待收款rpc
     */
    @Autowired
    private ContChargeRpc contChargeRpc;

    /**
     * @Fields  : 融资合同还款计划rpc
     */
    @Autowired
    private ContRepaySkedRpc contRepaySkedRpc;

    /**
     * @Fields  : 财务待收款repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;

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
     * @Fields  :资料邮寄附件详情Repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;

    /**
     * @Fields  :融资回填信息Repository
     */
    @Autowired
    private FinBackfillRepository finBackfillRepository;

    /**
     * @Fields  :融资回填明细信息Repository
     */
    @Autowired
    private FinBackfillDetailRepository finBackfillDetailRepository;

    /**
     * @Fields : 财务付款service
     */
    @Autowired
    private ContPayService contPayService;

    /**
     * @Fields  : 财务付款表repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 合同融资信息repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    /**
     * @Fields  : 合同融资信息repository
     */
    @Autowired
    private ContractFinanceService contractFinanceService;
    @Autowired
    private ContractVehicleService contractVehicleService;

    /**
     * @Fields  :资料邮寄附件Repository
     */
    @Autowired
    private OrigFileRepository origFileRepository;

    /**
     * @Fields  :融资费用明细信息Repository
     */
    @Autowired
    private ContFinDetailRepository contFinDetailRepository;
    /**
     * @Fields  : 销售还款计划信息repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 合同融资信息Service
     */
    @Autowired
    private ContRequestPayService contRequestPayService;

    @Autowired
    private WorkflowLogService workflowLogService;

    @Autowired
    private CommonRuleService commonRuleService;
    /**
     * 合同信息业务层
     */
    @Autowired
    private ContractService contractService;

    /**
     * @Fields  :合同Repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  : 通用pdfservice
     * @author qiaomengnan
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * 合同信息业务层
     */
    @Autowired
    private BasFileTypeRpc basFileTypeRpc;

    /**
     * CommonConstantService
     */
    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Fields  : 财务凭证明细共通
     * @author qiaomengnan
     */
    @Autowired
    private CommonFinancialVoucherDataService commonFinancialVoucherDataService;

    /**
     * @Fields  : 财务回填
     * @author qiaomengnan
     */
    @Autowired
    private CommonFinBackfillService commonFinBackfillService;

    /**
     * @Fields  : 消息提示共通repository
     */
    @Autowired
    private CommonSysUserInfoService commonSysUserInfoService;

    @Autowired
    private MortgageRemindRepository mortgageRemindRepository;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields  : 业务编号管理repository
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 客户费用信息repository
     */
    @Autowired
    private ContCostRepository contCostRepository;

    /**
     * @Fields  : 开票信息Repository层
     */
    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     * @param contNo
     * @Description: 财务收款所需信息：根据合同编号查询合同待付款信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 10:27
     */
    @Override
    public ContReceiptPayVo findContReceiptPayVoByContNo(String contNo) {
        //通过合同编号查询合同确认收款时合同融资相关信息
        ContReceiptPayVo contReceiptPayVo = contractFinanceRepository.selectContReceiptPayFinanceByContNo(contNo);
        if(StringUtils.isTrimBlank(contReceiptPayVo.getChargeFirstRent())){//默认收首期租金
            contReceiptPayVo.setChargeFirstRent(YesNoFlagEnums.YES.getType());
        }
        List<ContChargeReceiptVo> contChargeReceiptVoList = new ArrayList<>();
        //查询财务待收款数据
        try {
            contChargeReceiptVoList = ResponseEntityUtils.getRestResponseData(contChargeRpc.fingContChargeAndReceiptByBizIdAndBizType(contNo, BizTypeEnums.CONT_NO.getType(),null));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            throw new FmsServiceException("获取财务待收款数据失败");
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(contChargeReceiptVoList)){
            contReceiptPayVo.setContChargeReceiptVoList(contChargeReceiptVoList);
        }else{
            contReceiptPayVo.setContChargeReceiptVoList(this.getContChargeList(contReceiptPayVo,contNo));
        }
        //计算应收总金额
        BigDecimal totalAccount = BigDecimal.ZERO;
        for(ContChargeReceiptVo contCharge : contReceiptPayVo.getContChargeReceiptVoList()){
            contCharge.setChargeAmount(contCharge.getChargeAmount()==null?BigDecimal.ZERO:contCharge.getChargeAmount());
            totalAccount = totalAccount.add(contCharge.getChargeAmount());
        }
        contReceiptPayVo.setTotalAmount(totalAccount);
        return contReceiptPayVo;
    }

    /**
     * @param contReceiptPayVo
     * @Description: 暂存合同待付款信息（没有暂存了）
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 17:28
     */
    @Override
    @Transactional
    public void saveContCharge(ContReceiptPayVo contReceiptPayVo) {
        saveCommon(contReceiptPayVo, SAVEINFO.getType(), null);
    }

    /**
     * @param contReceiptPayVo
     * @Description: 提交财务确认收款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 17:39
     */
    @Override
    @Transactional
    public void submitContCharge(ContReceiptPayVo contReceiptPayVo) {
        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(contReceiptPayVo.getTaskId());
        // 确认收款共通操作
        saveCommon(contReceiptPayVo, SUBMIT.getType(), actRuTaskVo);
        // 初始化抵扣金额
        BigDecimal totalChargeDeductionAmount = BigDecimal.ZERO;
        if (ArrayUtils.isNotNullAndLengthNotZero(contReceiptPayVo.getContChargeReceiptVoList())){
            for (ContChargeReceiptVo contChargeReceiptVo : contReceiptPayVo.getContChargeReceiptVoList()){
                // 合计所有抵扣金额
                totalChargeDeductionAmount = totalChargeDeductionAmount.add(BigDecimalUtils.getNotNullBigDecimal(contChargeReceiptVo.getChargeDeductionAmount()));
            }
        }
        // 重新赋值定金金额
        contReceiptPayVo.setChargeDeductionAmount(BigDecimalUtils.getNotNullBigDecimal(contReceiptPayVo.getVehDeposit()).add(totalChargeDeductionAmount));
        //保存财务凭证数据
        Map<String,Object> contReceiptPayVoMap = JSON.parseObject(JSON.toJSONString(contReceiptPayVo));
        //设置科目代码动态值和项目付款金额
        setFinassSubjectCdToReceiptMap(contReceiptPayVo, contReceiptPayVoMap);
        //获取收款财务凭证类型
        String voucherType = getReceiptVoucherType(contReceiptPayVo.getContNo());

        saveFinVouDatas(contReceiptPayVoMap,contReceiptPayVo.getVinNo(),contReceiptPayVo.getApplyNo(),contReceiptPayVo.getContNo(), voucherType);
    }

    /**
    * @Description: 获取收款财务凭证类型
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/2 20:48
    */
    private String getReceiptVoucherType(String contNo) {
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);
        String voucherType = "";
        if(LicenseAttrEnums.FINANCE_LEASE.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.RECEIPT_0.getType();
        }else if(LicenseAttrEnums.LEASE_DIRECT.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.RECEIPT_1.getType();
        }else if(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.RECEIPT_2.getType();
        }
        if(StringUtils.isTrimBlank(voucherType)){
            throw new FmsServiceException("获取财务凭证类型失败");
        }
        return voucherType;
    }

    /**
    * @Description: 设置收款动态科目代码和项目付款金额
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/1 11:58
    */
    private void setFinassSubjectCdToReceiptMap(ContReceiptPayVo contReceiptPayVo, Map<String, Object> contReceiptPayVoMap) {
        //遍历融资项枚举
        for(PayFundNameEnums payFundNameEnums : PayFundNameEnums.values()){
            //获取收款明细中包含融资项的明细
            List<ContChargeReceiptVo> contChargeReceiptVoList = contReceiptPayVo.getContChargeReceiptVoList().stream().filter(contChargeReceiptVo -> payFundNameEnums.getType().equals(contChargeReceiptVo.getChargeFund())).collect(Collectors.toList());
            if(contChargeReceiptVoList != null && contChargeReceiptVoList.size()>0){
                ContChargeReceiptVo contChargeReceiptVo = contChargeReceiptVoList.get(0);
                //设置动态科目代码
                setFinassSubjectCdToMap(payFundNameEnums.getType() + FinVouDetailValueConstants.FINASS_SUBJECT_SUFFIX, contChargeReceiptVo.getFinassSubjectCd(), contChargeReceiptVo.getRecAccountNo(), contReceiptPayVoMap);
                // 设置项目付款金额
                contReceiptPayVoMap.put(payFundNameEnums.getType() + "Act", BigDecimalUtils.getNotNullBigDecimal(contChargeReceiptVo.getReceiptAmount()));// 借方:实际收款金额
                contReceiptPayVoMap.put(payFundNameEnums.getType(), BigDecimalUtils.getNotNullBigDecimal(contChargeReceiptVo.getReceiptAmount())
                        .add(BigDecimalUtils.getNotNullBigDecimal(contChargeReceiptVo.getChargeDeductionAmount())));// 贷方:实际收款金额+抵扣金额
            }
        }
    }

    /**
     * @param contReceiptPayVo
     * @Description: 退回财务确认收款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 17:39
     */
    @Override
    @Transactional
    public void backContCharge(ContReceiptPayVo contReceiptPayVo) {
        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(contReceiptPayVo.getTaskId());
        //合同日志录入
        saveCommon(contReceiptPayVo, SENDBACK.getType(), actRuTaskVo);
    }

    /**
    * @Description: 确认收款共通操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 17:43
    */
    private void saveCommon(ContReceiptPayVo contReceiptPayVo, String act, ActRuTaskVo actRuTaskVo){
        if(SUBMIT.getType().equals(act)){
            //开票信息
            List<Invoice> invoiceList = new ArrayList<>();
            //计算应收总金额
            BigDecimal totalAmount = BigDecimal.ZERO;
            //计算实收总金额
            BigDecimal totalActualAmount = BigDecimal.ZERO;
            //计算抵扣金额
            BigDecimal totalChargeDeductionAmount = BigDecimal.ZERO;
            for(ContChargeReceiptVo contChargeReceiptVo : contReceiptPayVo.getContChargeReceiptVoList()){
                contChargeReceiptVo.setChargeStatus(ChargeStatusEnums.COLLECTION.getType());
                totalAmount = totalAmount.add(contChargeReceiptVo.getChargeAmount());
                totalActualAmount = totalActualAmount.add(contChargeReceiptVo.getReceiptAmount());
                // 抵扣金额合计
                totalChargeDeductionAmount = totalChargeDeductionAmount.add(contChargeReceiptVo.getChargeDeductionAmount()==null?BigDecimal.ZERO:contChargeReceiptVo.getChargeDeductionAmount());
            }
            if(totalAmount.compareTo(contReceiptPayVo.getTotalAmount()) != 0){
                throw new FmsServiceException("应收金额计算有误！");
            }

            if(totalActualAmount.compareTo(contReceiptPayVo.getTotalActualAmount()) != 0){
                throw new FmsServiceException("实收金额计算有误！");
            }

            //实收金额加抵扣金额大于应收金额，保存一条数据待勾稽
            if(totalActualAmount.add(totalChargeDeductionAmount).compareTo(totalAmount) > 0){
                ContReceipt contReceipt = new ContReceipt();
                contReceipt.setInputMode(InputModeEnums.SHORTFALL.getType());//数据来源 2-差额
                contReceipt.setReceiptAmount(totalActualAmount.add(totalChargeDeductionAmount).subtract(totalAmount));//到账金额=实收金额+抵扣金额-应收金额
                contReceipt.setRestAmount(totalActualAmount.add(totalChargeDeductionAmount).subtract(totalAmount));//剩余金额=实收金额+抵扣金额-应收金额
                String memo = "首期款差额,合同号：" + contReceiptPayVo.getContNo();
                contReceipt.setMemo(memo);//备注
                //登录财务收款表
                contReceiptRepository.insertData(contReceipt);
            }
            //保存财务收款数据
            for(ContChargeReceiptVo contChargeReceiptVo : contReceiptPayVo.getContChargeReceiptVoList()){
                if (PayFundNameEnums.INIT_AMOUNT.getType().equals(contChargeReceiptVo.getChargeFund())) {
                    //通过合同编号查询合同确认收款时合同融资相关信息
                    ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(contReceiptPayVo.getContNo());
                    //如果是回租赁，不生成首付款开票信息
                    if (!LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())) {
                        saveInvoice(InvoiceTypeEnums.INIT_AMOUNT.getType(),contReceiptPayVo.getContNo(),contChargeReceiptVo,invoiceList);
                    }
                } else if (PayFundNameEnums.CHARGE.getType().equals(contChargeReceiptVo.getChargeFund())) {//手续费
                    saveInvoice(InvoiceTypeEnums.CHARGE.getType(),contReceiptPayVo.getContNo(),contChargeReceiptVo,invoiceList);
                }
                ContCharge contCharge = EntityUtils.getEntity(contChargeReceiptVo, new ContCharge());
                contCharge.setChargeActualAmount(contChargeReceiptVo.getReceiptAmount());// 实际收款金额重新赋值
                //保存财务待收款数据
                if(StringUtils.isNotTrimBlank(contCharge.getContChargeId())){
                    contChargeRepository.updateByPrimaryKeySelectiveData(contCharge);
                }else{
                    contChargeRepository.insertData(contCharge);
                }
                //保存收款数据
                ContReceipt contReceipt = EntityUtils.getEntity(contChargeReceiptVo, new ContReceipt());
                contReceipt.setMemo(contChargeReceiptVo.getMemoReceipt());//收款备注
                contReceipt.setInputMode(InputModeEnums.INPUT.getType());
                if(StringUtils.isNotTrimBlank(contReceipt.getContReceiptId())){
                    contReceiptRepository.updateByPrimaryKeySelectiveData(contReceipt);
                } else {
                    if (StringUtils.isNotTrimBlank(contReceipt.getReceiptAmount()) && contReceipt.getReceiptAmount().compareTo(BigDecimal.ZERO) > 0) {
                        contReceiptRepository.insertData(contReceipt);
                    }
                }

                //保存勾稽数据
                ContReceiptExam contReceiptExam = new ContReceiptExam();
                contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType());
                contReceiptExam.setReceiptBizId(contCharge.getContChargeId());
                contReceiptExam.setContReceiptId(contReceipt.getContReceiptId());
                contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());
                contReceiptExam.setReceiptExamAmount(contReceipt.getReceiptAmount());
                contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());
                if(StringUtils.isNotTrimBlank(contChargeReceiptVo.getContReceiptExamId())){
                    contReceiptExam.setContReceiptExamId(contChargeReceiptVo.getContReceiptExamId());
                    contReceiptExamRepository.updateByPrimaryKeySelectiveData(contReceiptExam);
                }else{
                    contReceiptExamRepository.insertData(contReceiptExam);
                }
            }
            //插入开票信息
            invoiceRepository.insertDataList(invoiceList);

            //保存待收款合计
           /* ContCharge contChargeTotal = new ContCharge();
            contChargeTotal.setChargeBizType(BizTypeEnums.CONT_NO.getType());
            contChargeTotal.setChargeBizId(contReceiptPayVo.getContNo());
            contChargeTotal.setChargeFund(PayFundNameEnums.TOTAL.getType());
            contChargeTotal.setChargeAmount(totalAmount);
            contChargeTotal.setChargeStatus(ChargeStatusEnums.COLLECTION.getType());
            contChargeTotal.setChargeDetailFlag(ChargeDetailFlagEnums.TOTAL.getType());
            contChargeRepository.insertData(contChargeTotal);*/

            //更新是否收首期租金
            Contract contract = new Contract();
            contract.setChargeFirstRent(contReceiptPayVo.getChargeFirstRent());
            contractService.updateContractByContNo(contract, contReceiptPayVo.getContNo());

        }
//        if(1==1)
//            throw new FmsServiceException("111");

        //更新合同状态，登录日志
        this.updateBizStatusAndWorkFlowLog(contReceiptPayVo.getContNo(),contReceiptPayVo.getApplyNo(),SUBMIT.getType(),
                contReceiptPayVo.getMemo(),contReceiptPayVo.getUser(),actRuTaskVo);
    }

    /**
    * @Description: 首期租金开票信息
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/15 17:27
    */
    private void saveFirstRentInvoice(String contNo, ContRepaySked contRepaySked) {
        Contract contract = contractService.findContractByContractNo(contNo);
        //如果首期租金扣款状态成功
        if (RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())) {

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

            //开票类型租金
            String invoiceType = InvoiceTypeEnums.RENT.getType();
            //查询合同融资信息
            ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(contNo);
            //构造开票信息
            Invoice invoice = new Invoice();
            invoice.setInvoiceDataType(invoiceType);
            invoice.setContNo(contNo);
            invoice.setDetailNo(contRepaySked.getPeriod()+"");
            invoice.setReceiveDate(new Date());

            invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());//未开票
            invoice.setInvoiceVoucherStatus(YesNoFlagEnums.NO.getType());//未生成凭证
            //如果是回租赁
            if(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())){
                invoice.setReceiveAccount(contRepaySked.getRentActual());//应收金额=实际租金
                invoice.setReceiveActualAccount(contRepaySked.getReceiptAmount());//实收金额=到账金额
                invoice.setInvoiceAmount(contRepaySked.getInterest());//开票金额=当期利息
                invoice.setInvoiceTax(invoiceTax6);
            }else{
                invoice.setReceiveAccount(contRepaySked.getRentActual());//应收金额=实际租金
                invoice.setReceiveActualAccount(contRepaySked.getReceiptAmount());//实收金额=到账金额
                invoice.setInvoiceAmount(contRepaySked.getReceiptAmount());//开票金额=实收金额
                invoice.setInvoiceTax(invoiceTax16);
            }
            //开票金额大于0，保存
            if(BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).compareTo(BigDecimal.ZERO)>0){
                invoiceRepository.insertData(invoice);
            }
        }
    }

    /**
     * @Description: 构造开票信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/21 11:20
     */
    private void saveInvoice(String invoiceType,String contNo, ContChargeReceiptVo contChargeReceiptVo, List<Invoice> invoiceList) {
        //构造开票信息
        Invoice invoice = new Invoice();
        invoice.setInvoiceDataType(invoiceType);
        invoice.setContNo(contNo);
        invoice.setReceiveDate(new Date());
        invoice.setReceiveAccount(contChargeReceiptVo.getChargeAmount());//应收金额=应收款金额
        invoice.setReceiveActualAccount(contChargeReceiptVo.getReceiptAmount());//实收金额=到账金额
        invoice.setInvoiceAmount(contChargeReceiptVo.getReceiptAmount());//开票金额=到账金额
        invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());//未开票
        invoice.setInvoiceVoucherStatus(YesNoFlagEnums.NO.getType());//未生成凭证
        BigDecimal invoiceTax;
        //获取税率
        try {
            //首付税率16
            if(InvoiceTypeEnums.INIT_AMOUNT.getType().equals(invoiceType)){
                invoiceTax = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.INVOICE_TAX_16));
                invoice.setDetailNo("0");
            }else{//税率6
                invoiceTax = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.INVOICE_TAX_6));
            }
        } catch (Exception e) {
            throw new FmsServiceException("获取开票税率失败");
        }
        invoice.setInvoiceTax(invoiceTax);
        //开票金额大于0，保存
        if(BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).compareTo(BigDecimal.ZERO)>0){
            invoiceList.add(invoice);
        }
    }

    /**
    * @Description: 构造待收款数据
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 14:03
    */ 
    private List<ContChargeReceiptVo> getContChargeList(ContReceiptPayVo contReceiptPayVo, String contNo){
        List<ContChargeReceiptVo> contChargeList = new ArrayList<>();
        //首付款
        ContChargeReceiptVo contChargeInitAmount = new ContChargeReceiptVo();
        contChargeInitAmount.setChargeBizType(BizTypeEnums.CONT_NO.getType());
        contChargeInitAmount.setChargeBizId(contNo);
        contChargeInitAmount.setChargeFund(PayFundNameEnums.INIT_AMOUNT.getType());
        contChargeInitAmount.setChargeAmount(contReceiptPayVo.getInitAmount());
        contChargeInitAmount.setChargeDeductionAmount(BigDecimal.ZERO);
        contChargeInitAmount.setChargeDetailFlag(ChargeDetailFlagEnums.DETAIL.getType());
        contChargeInitAmount.setReceiptAmount(contChargeInitAmount.getChargeAmount());
        contChargeList.add(contChargeInitAmount);
        //保证金
        ContChargeReceiptVo contChargeDeposit = new ContChargeReceiptVo();
        contChargeDeposit.setChargeBizType(BizTypeEnums.CONT_NO.getType());
        contChargeDeposit.setChargeBizId(contNo);
        contChargeDeposit.setChargeFund(PayFundNameEnums.DEPOSIT.getType());
        contChargeDeposit.setChargeDeductionAmount(BigDecimal.ZERO);
        contChargeDeposit.setChargeAmount(contReceiptPayVo.getDeposit());
        contChargeDeposit.setChargeDetailFlag(ChargeDetailFlagEnums.DETAIL.getType());
        contChargeDeposit.setReceiptAmount(contChargeDeposit.getChargeAmount());
        contChargeList.add(contChargeDeposit);
        //续保押金
        ContChargeReceiptVo contChargeRenewalDeposit = new ContChargeReceiptVo();
        contChargeRenewalDeposit.setChargeBizType(BizTypeEnums.CONT_NO.getType());
        contChargeRenewalDeposit.setChargeBizId(contNo);
        contChargeRenewalDeposit.setChargeFund(PayFundNameEnums.RENEWAL_DEPOSIT.getType());
        contChargeRenewalDeposit.setChargeDeductionAmount(BigDecimal.ZERO);
        contChargeRenewalDeposit.setChargeAmount(contReceiptPayVo.getRenewalDeposit());
        contChargeRenewalDeposit.setChargeDetailFlag(ChargeDetailFlagEnums.DETAIL.getType());
        contChargeRenewalDeposit.setReceiptAmount(contChargeRenewalDeposit.getChargeAmount());
        contChargeList.add(contChargeRenewalDeposit);
        //手续费用
        ContChargeReceiptVo contChargeCharge = new ContChargeReceiptVo();
        contChargeCharge.setChargeBizType(BizTypeEnums.CONT_NO.getType());
        contChargeCharge.setChargeBizId(contNo);
        contChargeCharge.setChargeFund(PayFundNameEnums.CHARGE.getType());
        contChargeCharge.setChargeDeductionAmount(BigDecimal.ZERO);
        contChargeCharge.setChargeAmount(contReceiptPayVo.getCharge());
        contChargeCharge.setChargeDetailFlag(ChargeDetailFlagEnums.DETAIL.getType());
        contChargeCharge.setReceiptAmount(contChargeCharge.getChargeAmount());
        contChargeList.add(contChargeCharge);
        //定金金额(定金是否抵扣车款为否)
        if(DeductibleFeeEnums.NO_DEDUCTION.getType().equals(contReceiptPayVo.getDeductibleFees())){
            ContChargeReceiptVo contChargeVehDeposit = new ContChargeReceiptVo();
            contChargeVehDeposit.setChargeBizType(BizTypeEnums.CONT_NO.getType());
            contChargeVehDeposit.setChargeBizId(contNo);
            contChargeVehDeposit.setChargeFund(PayFundNameEnums.VEH_DEPOSIT.getType());
            contChargeVehDeposit.setChargeAmount(contReceiptPayVo.getVehDeposit());
            contChargeVehDeposit.setChargeDeductionAmount(BigDecimal.ZERO);
            contChargeVehDeposit.setChargeDetailFlag(ChargeDetailFlagEnums.DETAIL.getType());
            contChargeVehDeposit.setReceiptAmount(contChargeVehDeposit.getChargeAmount());
            contChargeList.add(contChargeVehDeposit);
        }

        //首期租金
        ContChargeReceiptVo contChargeRent = new ContChargeReceiptVo();
        contChargeRent.setChargeBizType(BizTypeEnums.CONT_NO.getType());
        contChargeRent.setChargeBizId(contNo);
        contChargeRent.setChargeFund(PayFundNameEnums.FIRST_RENT.getType());
        contChargeRent.setChargeAmount(contReceiptPayVo.getRent());
        contChargeRent.setChargeDeductionAmount(BigDecimal.ZERO);
        contChargeRent.setChargeDetailFlag(ChargeDetailFlagEnums.DETAIL.getType());
        contChargeRent.setReceiptAmount(contChargeRent.getChargeAmount());
        contChargeList.add(contChargeRent);

        //设置默认收款到账时间
        for(ContChargeReceiptVo contChargeReceiptVo : contChargeList){
            if(contChargeReceiptVo.getReceiptAmount() != null && contChargeReceiptVo.getReceiptAmount().compareTo(BigDecimal.ZERO)>0){
                contChargeReceiptVo.setReceiptDate(new Date());
            }
        }
        return contChargeList;
    }

    /**
     * @param contNo
     * @Description: 财务制单，付款：根据合同号查询合同请款信息, 包括付款信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 16:05
     */
    @Override
    public ContRequestPayVo findContRequestPayWithContPayByContNo(String contNo) {
        ContRequestPayVo contRequestPayVo = contRequestPayService.findContRequestPayByContNo(contNo);
        //付款项默认未付款
        for(ContFinPayVo contFinPayVo : contRequestPayVo.getContFinPayVoList()){
            if(PayStatusEnums.WITHDRAWING.getType().equals(contFinPayVo.getContPay().getPayStatus())){
                contFinPayVo.setConfirmPayStatus(YesNoFlagEnums.YES.getType());
            }else{
                contFinPayVo.setConfirmPayStatus(YesNoFlagEnums.NO.getType());
            }
        }
        ContPay contPay = contPayService.findContPayByBizCodeAndPaymentType(BizTypeEnums.CONT_NO.getType(),contNo);
        contRequestPayVo.setContPay(contPay);

        List<ContChargeReceiptVo> contChargeReceiptVoList = new ArrayList<>();
        //查询财务待收款数据
        try {
            contChargeReceiptVoList  = ResponseEntityUtils.getRestResponseData(contChargeRpc.fingContChargeAndReceiptByBizIdAndBizType(contNo,BizTypeEnums.CONT_NO.getType(),null));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            throw new FmsServiceException("获取财务待收款数据失败");
        }
        contRequestPayVo.setContChargeReceiptVoList(contChargeReceiptVoList);
        return contRequestPayVo;
    }

    /**
     * @param contNo
     * @Description: 打印
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/19 11:43
     */
    @Override
    @Transactional
    public String printContMakeVoucher(String contNo) {
        ContRequestPayVo contRequestPayVo = this.findContRequestPayWithContPayByContNo(contNo);
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(contRequestPayVo);
        BigDecimal totalFinAmount = BigDecimal.ZERO;//融资总额
        BigDecimal totalPayAmount = BigDecimal.ZERO;//付款总额
        BigDecimal insuranceTotalFinAmount = BigDecimal.ZERO;//保险融资总额
        BigDecimal insurancePayAmount = BigDecimal.ZERO;//商业保险
        BigDecimal insuranceAPayAmount = BigDecimal.ZERO;//玻璃险
        BigDecimal insuranceBPayAmount = BigDecimal.ZERO;//划痕险

        Map<String, String> mapping = new HashMap<>();
        mapping.put("carprice", "FIN01");//车款
        mapping.put("purchasetax", "FIN02");//购置税
        mapping.put("gps", "");//gps
        mapping.put("insurance", "FIN05");//保险
        mapping.put("insuranceA", "FIN05A");//玻璃险
        mapping.put("insuranceB", "FIN05B");//划痕险
        mapping.put("extra", "FIN06");//精品/加装费
        mapping.put("extend", "");
        mapping.put("others", "FIN08");//其他
        mapping.put("license", "FIN07");//上牌费
        mapping.put("collectingPoundage", "FIN03");//手续费
        for(ContFinPayVo contFinPayVo : contRequestPayVo.getContFinPayVoList()){
            pdfVariables.put("finAmount"+mapping.get(contFinPayVo.getFinItem()), getObjString(contFinPayVo.getFinAmount()));
            pdfVariables.put("payAmount"+mapping.get(contFinPayVo.getFinItem()), getObjString(contFinPayVo.getContPay().getPayAmount()));
            if(StringUtils.isTrimBlank(pdfVariables.get("recAccBank"+mapping.get(contFinPayVo.getFinItem())))){
                pdfVariables.put("recAccBank"+mapping.get(contFinPayVo.getFinItem()), getObjString(contFinPayVo.getContPay().getRecAccBranch()));
                pdfVariables.put("recAccountNo"+mapping.get(contFinPayVo.getFinItem()), getObjString(contFinPayVo.getContPay().getRecAccountNo()));
                pdfVariables.put("recAccountName"+mapping.get(contFinPayVo.getFinItem()), getObjString(contFinPayVo.getContPay().getRecAccountName()));
            }

            if(StringUtils.isNotTrimBlank(contFinPayVo.getFinItem()) && contFinPayVo.getFinItem().startsWith(FinItemEnums.INSURANCE.getCode())){
                //累加所有保险相关融资额
                insuranceTotalFinAmount = insuranceTotalFinAmount.add(contFinPayVo.getFinAmount());
            }
            if(FinItemEnums.INSURANCE.getCode().equals(contFinPayVo.getFinItem())){
                //累加所有年份商业保险付款金额
                insurancePayAmount = insurancePayAmount.add(contFinPayVo.getContPay().getPayAmount());
            }
            if(FinItemEnums.INSURANCE_A.getCode().equals(contFinPayVo.getFinItem())){
                //累加所有年份玻璃险付款金额
                insuranceAPayAmount = insuranceAPayAmount.add(contFinPayVo.getContPay().getPayAmount());
            }
            if(FinItemEnums.INSURANCE_B.getCode().equals(contFinPayVo.getFinItem())){
                //累加所有年份划痕险付款金额
                insuranceBPayAmount = insuranceBPayAmount.add(contFinPayVo.getContPay().getPayAmount());
            }
            totalFinAmount = totalFinAmount.add(contFinPayVo.getFinAmount());
            totalPayAmount = totalPayAmount.add(contFinPayVo.getContPay().getPayAmount());
        }
        pdfVariables.put("totalFinAmount", totalFinAmount.toString());
        pdfVariables.put("totalPayAmount", totalPayAmount.toString());
        pdfVariables.put("finAmount"+mapping.get(FinItemEnums.INSURANCE.getCode()),getBigdecimalString(insuranceTotalFinAmount));
        pdfVariables.put("payAmount"+mapping.get(FinItemEnums.INSURANCE.getCode()),getBigdecimalString(insurancePayAmount));
        pdfVariables.put("payAmount"+mapping.get(FinItemEnums.INSURANCE_A.getCode()),getBigdecimalString(insuranceAPayAmount));
        pdfVariables.put("payAmount"+mapping.get(FinItemEnums.INSURANCE_B.getCode()),getBigdecimalString(insuranceBPayAmount));

        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(), formatStr_yyyyMMdd));

        //需要从数据字典中取值
        Map<String,String> codeValues = new HashMap<>();
        //业务类别
        codeValues.put("licenseAttr","licenseAttrName");

        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.CONT_MAKE_VOUCHER.getType(),codeValues);
        return filePath;
    }

    /** 
    * @Description: 打印pdf时将0转换成空字符串
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/27 15:56
    */ 
    private String getBigdecimalString(BigDecimal bigDecimal){
        if(bigDecimal == null || bigDecimal.intValue() == 0){
            return "";
        }else{
            return bigDecimal.toString();
        }
    }

    /** 
    * @Description: 打印pdf时获取字符串
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/28 11:12
    */ 
    private String getObjString(Object obj){
        if(obj == null){
            return "";
        }else{
            return obj.toString();
        }
    }

    /**
     * @param contRequestPayVo
     * @Description: 贷前合同财务制单
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/14 17:50
     */
    @Override
    @Transactional
    public void submitContMakeVoucher(ContRequestPayVo contRequestPayVo) {
        //财务制单共通操作
        this.saveMakeVoucherCommon(contRequestPayVo);
        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(contRequestPayVo.getTaskId());
        //更新合同状态，登录日志
        this.updateBizStatusAndWorkFlowLog(contRequestPayVo.getContNo(),contRequestPayVo.getApplyNo(),SUBMIT.getType(),
                contRequestPayVo.getMemo(),contRequestPayVo.getUser(),actRuTaskVo);
    }

    /** 
    * @Description: 财务制单共通操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/14 17:54
    */
    @Override
    public void saveMakeVoucherCommon(ContRequestPayVo contRequestPayVo) {
        //保存请款付款明细,这里的contPay中的收款银行是财务收款时录入的，付款银行是制单时选择的，每条都一样
        List<ContFinPayVo> contFinPayVoList = contRequestPayVo.getContFinPayVoList();
//        BigDecimal payAmountTotal = BigDecimal.ZERO;
        for(ContFinPayVo contFinPayVo : contFinPayVoList){
            contFinPayVo.getContPay().setPayAccBank(contRequestPayVo.getContPay().getPayAccBank());
            contFinPayVo.getContPay().setPayAccBranch(contRequestPayVo.getContPay().getPayAccBranch());
            contFinPayVo.getContPay().setPayAccountName(contRequestPayVo.getContPay().getPayAccountName());
            contFinPayVo.getContPay().setPayAccountNo(contRequestPayVo.getContPay().getPayAccountNo());
            contFinPayVo.getContPay().setPayEleBankNo(contRequestPayVo.getContPay().getPayEleBankNo());
//            payAmountTotal = payAmountTotal.add(contFinPayVo.getContPay().getPayAmount());
            contPayRepository.updateByPrimaryKeySelectiveData(contFinPayVo.getContPay());
        }

        //保存制单财务付款表
//        ContPay contPay = contRequestPayVo.getContPay();
//        contPay.setBizCode(contRequestPayVo.getContNo());
//        contPay.setPaymentType(BizTypeEnums.CONT_NO.getType());
//        contPay.setPayAmount(payAmountTotal);
//        contPay.setPayFund(PayFundNameEnums.CONT_MAKE_VOUCHER.getType());
//        contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
//        if(StringUtils.isNotTrimBlank(contPay.getContPayId())){
//            contPayRepository.updateByPrimaryKeySelectiveData(contPay);
//        }else{
//            contPayRepository.insertData(contPay);
//        }
    }

    /**
     * @param contRequestPayVo
     * @Description: 财务付款确认
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 16:40
     */
    @Override
    @Transactional
    public void submitContPayment(ContRequestPayVo contRequestPayVo) {
        Contract oldContract = contractService.findContractByContractNo(contRequestPayVo.getContNo());
        Contract contract = new Contract();//给更新的项目设值用
        boolean isAll = true;//是否全部付款标志
        List<ContRepaySked> contRepaySkedList = null;//还款计划表
        //保存请款付款明细
        List<ContFinPayVo> contFinPayVoList = contRequestPayVo.getContFinPayVoList();
        for(ContFinPayVo contFinPayVo : contFinPayVoList){
            if(YesNoFlagEnums.YES.getType().equals(contFinPayVo.getConfirmPayStatus())){//确认付款
                if(oldContract.getContractValidDate() == null){//合同生效日期日期为空
                    if(FinItemEnums.CARPRICE.getCode().equals(contFinPayVo.getFinItem())){//保存合同生效日期=付车款日期
                        contract.setContractValidDate(contFinPayVo.getContPay().getPayDate());
                        //合同付款时共同操作
                        contRepaySkedList = payCommon(contRequestPayVo, contract);
                    }
                }
                contFinPayVo.getContPay().setPayStatus(PayStatusEnums.WITHDRAWING.getType());
                contPayRepository.updateByPrimaryKeySelectiveData(contFinPayVo.getContPay());
            }
            if(contFinPayVo.getContPay().getPayAmount().compareTo(BigDecimal.ZERO)>0 && YesNoFlagEnums.NO.getType().equals(contFinPayVo.getConfirmPayStatus())){
                isAll = false;
            }
        }
        if(isAll){//全部付款才能走流程
            //如果走最后一个流程时合同生效日期还没有值，说明未付车款
            if (contract.getContractValidDate() == null && oldContract.getContractValidDate() == null) {
                contract.setContractValidDate(new Date());
                //合同付款时共同操作
                contRepaySkedList =  payCommon(contRequestPayVo, contract);
            }

            //工作流引擎
            ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(contRequestPayVo.getTaskId());

            //更新合同状态，登录日志
            this.updateBizStatusAndWorkFlowLog(contRequestPayVo.getContNo(),contRequestPayVo.getApplyNo(),SUBMIT.getType(),
                    contRequestPayVo.getMemo(),contRequestPayVo.getUser(),actRuTaskVo);
            //如果是回租赁，则插入抵押提醒明细表
            this.saveMortgageRemind(contRequestPayVo.getContNo());
            //生成财务放款凭证
            creatPaymentVoucher(contRequestPayVo);

            //生成合同签约凭证
            creatPaycontVoucher(contRequestPayVo,contRepaySkedList);
        }
        //更新合同相关信息
        contractService.updateContractByContNo(contract, contRequestPayVo.getContNo());
    }

    /**
    * @Description: 合同付款时共同操作
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/7 13:40
    */
    private List<ContRepaySked> payCommon(ContRequestPayVo contRequestPayVo, Contract contract) {
        List<ContRepaySked> contRepaySkedList;
        //设置租赁期限开始日和结束日
        setStartAndEndDate(contRequestPayVo, contract);
        //删除原先还款计划表
        Example example = SqlUtil.newExample(ContRepaySked.class);
        example.createCriteria().andEqualTo("contNo", contRequestPayVo.getContNo());
        contRepaySkedRepository.deleteExampleData(example,new ContRepaySked());
        //生成还款计划表
        contRepaySkedList = this.getContRepaySked(contRequestPayVo.getContNo());
        contRepaySkedRepository.insertDataList(contRepaySkedList);
        //保存首期租金发票
        saveFirstRentInvoice(contRequestPayVo.getContNo(),contRepaySkedList.get(0));

        //保存邮寄附件信息
        saveOrigFile(contRequestPayVo.getContNo());

        //生成待回填数据
        saveBackFill(contRequestPayVo);

        //给gps派单用户发送消息
        this.noticeGps(contRequestPayVo.getContNo(),contRequestPayVo.getPersonName());
        //给盗抢险录入用户发送消息
        this.noticePilfer(contRequestPayVo.getContNo(),contRequestPayVo.getPersonName());
        //给给归档用户发送消息
        this.noticeOrigFile(contRequestPayVo.getContNo(),contRequestPayVo.getPersonName());
        // 保存客户费用信息,以及生成保证金的抵扣租金明细
        saveContCostAndContReceipt(contRequestPayVo.getContNo());
        return contRepaySkedList;
    }

    /**
    * @Description: 设置租赁期限开始日和结束日
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/7 10:59
    */
    private void setStartAndEndDate(ContRequestPayVo contRequestPayVo, Contract contract) {
        if(StringUtils.isTrimBlank(contRequestPayVo.getContractDate())){
            throw new FmsServiceException("合同生成日期获取失败");
        }
        if(StringUtils.isTrimBlank(contRequestPayVo.getRepayDay())){
            throw new FmsServiceException("每期支付日期获取失败");
        }
        if(StringUtils.isTrimBlank(contRequestPayVo.getRentPayMode())){
            throw new FmsServiceException("租金支付模式获取失败");
        }
        if(StringUtils.isTrimBlank(contRequestPayVo.getFinPeriodType())){
            throw new FmsServiceException("融资期限获取失败");
        }
        //首期支付日
        Date firstRepayDate = DateUtils.strToDate(DateUtils.getRepayDate(contRequestPayVo.getContractDate(), contRequestPayVo.getRepayDay(), 1, contRequestPayVo.getRentPayMode()),DateUtils.formatStr_yyyyMMd_NO);
        //最后一期支付日
        Date lastRepayDate = DateUtils.strToDate(DateUtils.getRepayDate(contRequestPayVo.getContractDate(), contRequestPayVo.getRepayDay(), Integer.parseInt(contRequestPayVo.getFinPeriodType()), contRequestPayVo.getRentPayMode()),DateUtils.formatStr_yyyyMMd_NO);
        if(firstRepayDate == null || lastRepayDate == null){
            throw new FmsServiceException("首期支付日或尾期支付日计算有误");
        }
        //租赁期限开始日
        Date leaseTermStartDate = firstRepayDate;
        //租赁期限结束日
        Date leaseTermEndDate = lastRepayDate;
        /*//期初支付
        if(RentPayModeEnums.END_PAY.getType().equals(contRequestPayVo.getRentPayMode())){
            //租赁期限开始日=首期支付日
            leaseTermStartDate = firstRepayDate;
            //租赁期限结束日=首期支付日+(租赁期限+1)月-1天
            leaseTermEndDate = DateUtils.getAddDay(DateUtils.getAddMonth(firstRepayDate,Integer.parseInt(contRequestPayVo.getFinPeriodType())),-1);
        }
        //期末支付
        if(RentPayModeEnums.BEGIN_PAY.getType().equals(contRequestPayVo.getRentPayMode())){
            //租赁期限开始日=首期支付日-1月+1天
            leaseTermStartDate = DateUtils.getAddDay(DateUtils.getAddMonth(firstRepayDate,-1),1);
            //租赁期限结束日=首期支付日+租赁期限
            leaseTermEndDate = DateUtils.getAddMonth(firstRepayDate,Integer.parseInt(contRequestPayVo.getFinPeriodType())-1);
        }*/
        if(leaseTermStartDate != null && leaseTermEndDate != null){
            contract.setLeaseTermStartDate(leaseTermStartDate);
            contract.setLeaseTermEndDate(leaseTermEndDate);
        }
    }

    /**
     * @Description: 保存客户费用信息以及生成保证金的抵扣租金明细
     * @param: contNo 合同编号
     * @param: contReceiptId 财务还款ID
     * @return:
     * @Author: wangxue
     * @Date: 2018/8/13 15:11
     */
    private void saveContCostAndContReceipt(String contNo) {
        // 获取合同融资信息
        Example example = new Example(ContractFinance.class);
        example.createCriteria().andEqualTo("contNo", contNo);
        ContractFinance contractFinance = contractFinanceRepository.selectOneByExample(example);
        // 财务付款信息
        ContReceipt contReceipt = null;
        // 保证金
        BigDecimal deposit = BigDecimal.ZERO;
        if (contractFinance != null && contractFinance.getDeposit() != null && contractFinance.getDeposit().compareTo(BigDecimal.ZERO) > 0) {
            // 保存财务待收款信息
            contReceipt = new ContReceipt();
            //数据来源 2-抵扣租金
            contReceipt.setInputMode(InputModeEnums.INTER.getType());
            //到账金额
            contReceipt.setReceiptAmount(contractFinance.getDeposit());
            //剩余金额
            contReceipt.setRestAmount(contractFinance.getDeposit());
            String memo = "保证金,合同号：" + contNo;
            contReceipt.setMemo(memo);//备注
            //登录财务收款表
            contReceiptRepository.insertData(contReceipt);
            deposit = contractFinance.getDeposit();
        }
        // 保存客户费用信息
        ContCost contCost = new ContCost();
        // 合同编号
        contCost.setContNo(contNo);
        // 财务收款ID
        if (contReceipt != null) {
            contCost.setContReceiptId(contReceipt.getContReceiptId());
        }
        // 保证金
        contCost.setCostAmount(deposit);
        // 款项：保证金
        contCost.setCostItem(CostItemEnums.DEPOSIT.getType());
        // 类型：收取
        contCost.setCostType(ContCostTypeEnums.COLLECT.getType());
        contCostRepository.insertData(contCost);
    }

    /**
    * @Description: 生成财务放款凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/13 15:11
    */
    private void creatPaymentVoucher(ContRequestPayVo contRequestPayVo) {
        //生成财务放款凭证
        Map<String,Object> contRequestPayVoMap = JSON.parseObject(JSON.toJSONString(contRequestPayVo));
        //设置科目代码动态值和其他值
        setFinassSubjectCdToPayMap(contRequestPayVo, contRequestPayVoMap);
        //获取财务凭证类型
        String voucherType = getPaymentVoucherType(contRequestPayVo.getContNo());
        // 获取应付车款数值
        BigDecimal carpriceBorrow = getBigDecimal(contRequestPayVoMap.get(FinVouDetailValueConstants.CARPRICE_BORROW));
        // 获取实付车款数值
        BigDecimal carprice = getBigDecimal(contRequestPayVoMap.get(FinItemEnums.CARPRICE.getCode()));
        // 订金重新赋值：应付车款-实付车款
        contRequestPayVoMap.put(FinVouDetailValueConstants.VEH_DEPOSIT, carpriceBorrow.subtract(carprice));
        //保存财务放款凭证
        saveFinVouDatas(contRequestPayVoMap,contRequestPayVo.getVinNo(),contRequestPayVo.getApplyNo(),contRequestPayVo.getContNo(), voucherType);
    }

    /**
     * Object转BigDecimal类型
     *
     * @param value 要转的object类型
     * @return 转成的BigDecimal类型数据
     * @Author: lijunjun
     * @Date: 2018/11/5 15:11
     */
    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal){
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        } else {
            ret = BigDecimal.ZERO;
        }
        return ret;
     }

    /**
    * @Description: 生成合同签约凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/14 16:44
    */
    private void creatPaycontVoucher(ContRequestPayVo contRequestPayVo, List<ContRepaySked> contRepaySkedList) {
        //获取财务凭证类型
        String voucherType = getPaycontVoucherType(contRequestPayVo.getContNo());
        if(VoucherTypeEnums.PAYCONT_1.getType().equals(voucherType)){//经营租赁不生成凭证
            return;
        }
        //生成合同签约凭证数据
        Map<String,Object> contRequestPayVoMap = JSON.parseObject(JSON.toJSONString(contRequestPayVo));
        //设置金额
        setPaycontToPayMap(contRequestPayVo, contRequestPayVoMap,contRepaySkedList);
        //保存合同签约凭证
        saveFinVouDatas(contRequestPayVoMap,contRequestPayVo.getVinNo(),contRequestPayVo.getApplyNo(),contRequestPayVo.getContNo(), voucherType);
    }

    /**
    * @Description: 获取付款财务凭证类型
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/2 20:44
    */
    private String getPaymentVoucherType(String contNo) {
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);
        String voucherType = "";
        if(LicenseAttrEnums.FINANCE_LEASE.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.PAYMENT_0.getType();
        }else if(LicenseAttrEnums.LEASE_DIRECT.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.PAYMENT_1.getType();
        }else if(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.PAYMENT_2.getType();
        }
        if(StringUtils.isTrimBlank(voucherType)){
            throw new FmsServiceException("获取放款财务凭证类型失败");
        }
        return voucherType;
    }

    /**
    * @Description: 获取签约财务凭证类型
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/13 15:40
    */
    private String getPaycontVoucherType(String contNo) {
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);
        String voucherType = "";
        if(LicenseAttrEnums.FINANCE_LEASE.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.PAYCONT_0.getType();
        }else if(LicenseAttrEnums.LEASE_DIRECT.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.PAYCONT_1.getType();
        }else if(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())){
            voucherType = VoucherTypeEnums.PAYCONT_2.getType();
        }
        if(StringUtils.isTrimBlank(voucherType)){
            throw new FmsServiceException("获取签约财务凭证类型失败");
        }
        return voucherType;
    }

    /**
    * @Description: 设置付款动态科目代码和金额
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/1 13:56
    */
    private void setFinassSubjectCdToPayMap(ContRequestPayVo contRequestPayVo, Map<String, Object> contRequestPayVoMap) {
        //设置动态科目代码
        setFinassSubjectCdToMap(FinVouDetailValueConstants.PAY_CD, "", contRequestPayVo.getContPay().getPayAccountNo(), contRequestPayVoMap);
        //遍历融资项枚举
        for(FinItemEnums finItemEnums : FinItemEnums.values()){
            //获取当前融资项的付款明细
            List<ContFinPayVo> contFinPayVoList = contRequestPayVo.getContFinPayVoList().stream().filter(contFinPayVo -> finItemEnums.getCode().equals(contFinPayVo.getFinItem())).collect(Collectors.toList());
            if(contFinPayVoList != null && contFinPayVoList.size()>0){
                ContFinPayVo contFinPayVo = contFinPayVoList.get(0);
                //设置供应商辅助核算代码
                setAssisFinassSupplyCdToMap(finItemEnums.getCode() + FinVouDetailValueConstants.FINASS_SUBJECT_SUFFIX, contFinPayVo.getContPay().getRecAccountNo(), contRequestPayVoMap);
                //设置项目付款金额
                contRequestPayVoMap.put(finItemEnums.getCode(), BigDecimalUtils.getNotNullBigDecimal(contFinPayVo.getContPay().getPayAmount()));
                //如果是车款
                if(finItemEnums.getCode().equals(FinItemEnums.CARPRICE.getCode())){
                    //借：应付车款 = 车款融资额
                    contRequestPayVoMap.put(FinVouDetailValueConstants.CARPRICE_BORROW, contFinPayVo.getFinAmount());
                    //贷：实付车款 = 车款实际付款金额
                    contRequestPayVoMap.put(FinItemEnums.CARPRICE.getCode(), contFinPayVo.getContPay().getPayAmount());
                }
            }
        }
        //重新单独设置保险金额(付款额)
        BigDecimal insuranceAmount = BigDecimal.ZERO;
        //获取所有保险项目
        List<ContFinPayVo> contFinPayVoList = contRequestPayVo.getContFinPayVoList().stream().filter(contFinPayVo -> contFinPayVo.getFinItem().startsWith(FinItemEnums.INSURANCE.getCode())).collect(Collectors.toList());
        if(contFinPayVoList != null && contFinPayVoList.size()>0){
            for (ContFinPayVo contFinPayVo : contFinPayVoList){
                insuranceAmount = insuranceAmount.add(BigDecimalUtils.getNotNullBigDecimal(contFinPayVo.getContPay().getPayAmount()));
            }
        }
        contRequestPayVoMap.put(FinItemEnums.INSURANCE.getCode(), insuranceAmount);

    }

    /**
    * @Description: 设置合同签约相关金额
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/13 16:23
    */
    private void setPaycontToPayMap(ContRequestPayVo contRequestPayVo, Map<String, Object> contRequestPayVoMap, List<ContRepaySked> contRepaySkedList) {
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contRequestPayVo.getContNo());
        BigDecimal rentActualTotal = BigDecimal.ZERO;//还款租金总额
        BigDecimal interestTotal = BigDecimal.ZERO;//利息总额
        if(contRepaySkedList == null){
            try {
                //查询当前还款计划表
                contRepaySkedList = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findAllContRepaySkedByContNo(contRequestPayVo.getContNo()));
            } catch (FmsRpcException e) {
                log.error(e.getMessage());
                e.printStackTrace();
                throw new FmsServiceException("获取融资合同还款计划信息失败");
            }
        }

        if(ArrayUtils.isNullOrLengthZero(contRepaySkedList)){
            throw new FmsServiceException("融资合同还款计划信息不存在");
        }
        for(ContRepaySked contRepaySked : contRepaySkedList){
            if (RepayTypeEnums.RENT.getType().equals(contRepaySked.getRepayType())
                    || RepayTypeEnums.FINAL_AMOUNT.getType().equals(contRepaySked.getRepayType())) {//如果是租金或尾付才累加
                rentActualTotal = rentActualTotal.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()));
                interestTotal = interestTotal.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getInterest()));
            }
        }
        //设置融资租赁租金
        BigDecimal totalRent = rentActualTotal.add(BigDecimalUtils.getNotNullBigDecimal(contractFinanceVo.getInitAmount()));
        contRequestPayVoMap.put(FinVouDetailValueConstants.TOTAL_RENT, totalRent);
        //设置业务类型
        String licenseAttr = commonConstantService.findSysCodeValueName("licenseAttr", contractFinanceVo.getLicenseAttr());
        contRequestPayVoMap.put(FinVouDetailValueConstants.LICENSE_ATTR, licenseAttr);
        //获取正租赁税率
        BigDecimal rentTax;
        //保险总额
        BigDecimal insuranceTotal = BigDecimal.ZERO;
        //其他项总额
        BigDecimal otherTotal = BigDecimal.ZERO;
        //回租赁：其他应付款
        BigDecimal allTotal = BigDecimal.ZERO;
        try {
            rentTax = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.RENT_TAX));
        } catch (Exception e) {
            throw new FmsServiceException("获取正租赁税率失败");
        }
        for(ContFinPayVo contFinPayVo : contRequestPayVo.getContFinPayVoList()){
            if (FinItemEnums.COLLECTING_POUNDAGE.getCode().equals(contFinPayVo.getFinItem())
                    || FinItemEnums.CHARGEFEE.getCode().equals(contFinPayVo.getFinItem())) {
                continue;
            }
            allTotal = allTotal.add(BigDecimalUtils.getNotNullBigDecimal(contFinPayVo.getFinAmount()));
            if(FinItemEnums.CARPRICE.getCode().equals(contFinPayVo.getFinItem())){//设置车款
                contRequestPayVoMap.put(FinItemEnums.CARPRICE.getCode(), BigDecimalUtils.getNotNullBigDecimal(contFinPayVo.getFinAmount()).divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP));
            }else if(FinItemEnums.PURTAX.getCode().equals(contFinPayVo.getFinItem())){////设置购置税
                contRequestPayVoMap.put(FinItemEnums.PURTAX.getCode(), BigDecimalUtils.getNotNullBigDecimal(contFinPayVo.getFinAmount()).divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP));
            }else if(StringUtils.isNotTrimBlank(contFinPayVo.getFinItem()) && contFinPayVo.getFinItem().startsWith(FinItemEnums.INSURANCE.getCode())){//保险总额
                insuranceTotal = insuranceTotal.add(BigDecimalUtils.getNotNullBigDecimal(contFinPayVo.getFinAmount()));
            }else{//累加其他项
                otherTotal = otherTotal.add(BigDecimalUtils.getNotNullBigDecimal(contFinPayVo.getFinAmount()));
            }
        }
        //设置保险金额
        contRequestPayVoMap.put(FinItemEnums.INSURANCE.getCode(), insuranceTotal.divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP));
        //设置精品及其他金额
        contRequestPayVoMap.put(FinItemEnums.EXTRA.getCode(), otherTotal.divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP));
        //设置未实现销项税（融资租赁租金/1.17*0.17）
        BigDecimal outputTax = totalRent.divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP).multiply(rentTax);
        contRequestPayVoMap.put(FinVouDetailValueConstants.OUTPUT_TAX, outputTax);
        //设置利息
        contRequestPayVoMap.put(FinVouDetailValueConstants.INTEREST_TOTAL, interestTotal.divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP));

        //如果是回租赁,其他应付款=付款项累加，利息=所有利息累加
        if(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())){
            contRequestPayVoMap.put(FinItemEnums.EXTRA.getCode(), allTotal);
            contRequestPayVoMap.put(FinVouDetailValueConstants.INTEREST_TOTAL, interestTotal);
        }
    }

    /**
    * @Description: 根据银行账号设置财务科目代码
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/1 14:20
    */
    private void setFinassSubjectCdToMap(String cdCode,String finassSubjectCd,String accountNo,Map<String, Object> dataMap){
        if(StringUtils.isTrimBlank(finassSubjectCd) && StringUtils.isNotTrimBlank(accountNo)){
            try {
                //根据银行账号获取财务科目代码
                finassSubjectCd =  ResponseEntityUtils.getRestResponseData(basBankInfoRpc.findFinassSubjectCd(accountNo));
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new FmsServiceException("取得财务科目代码失败");
            }
        }
        if(StringUtils.isNotTrimBlank(finassSubjectCd)){
            dataMap.put(cdCode,finassSubjectCd);
        }else{
            dataMap.put(cdCode,"");
        }
    }

    /**
    * @Description: 根据银行账号设置供应商辅助核算代码
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/10 14:14
    */
    private void setAssisFinassSupplyCdToMap(String cdCode,String accountNo,Map<String, Object> dataMap){
        String assisFinassSupplyCd = "";
        BasBankInfo basBankInfo = null;
        if(StringUtils.isNotTrimBlank(accountNo)){
            try {
                //根据银行账号获取银行信息
                basBankInfo =  ResponseEntityUtils.getRestResponseData(basBankInfoRpc.findBasBankInfoByAccountNo(accountNo));
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new FmsServiceException("取得银行信息失败");
            }
        }
        if(basBankInfo != null){
            assisFinassSupplyCd = basBankInfo.getAssisFinassSupplyCd();
        }
        dataMap.put(cdCode,StringUtils.isNotTrimBlank(assisFinassSupplyCd) ? assisFinassSupplyCd : "");
    }

    /**
     * @Title:
     * @Description: 获取并保存财务凭证数据
     * @param: dataMap
     * @param: vinNo
     * @param: applyNo
     * @param: contNo
     * @param: voucherType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/2 0002 21:25
     */
    private void saveFinVouDatas(Map<String,Object> dataMap,String vinNo,String applyNo,String contNo,String voucherType){
        //车架号后6位
        dataMap.put(FinVouDetailValueConstants.VIN_NO_6, StringUtils.subStringLater(vinNo,6));
        //获取财务核算代码
        ContractVo contractVo = contractService.findContractVoFinassCodes(applyNo,contNo);
        if(contractVo != null) {
            //取到订单申请人的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_CSTM_CODE, contractVo.getFinassCstmCode());
            //申请人姓名
            dataMap.put(FinVouDetailValueConstants.APPLY_PERSON_NAME, contractVo.getApplyPersonName());
            //实际销售方的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_SALES_CODE, contractVo.getFinassSalesCode());
            //出租人的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_GROUP_CODE, contractVo.getFinassGroupCode());
        }
        //获取凭证明细数据
        CommonFinVouData commonFinVouData = commonFinancialVoucherDataService.getFinVoucherData(voucherType,dataMap,contNo);
        //保存凭证明细数据
        commonFinancialVoucherDataService.saveCommonFinVouData(commonFinVouData);
    }

    /**
     * @param contRequestPayVo
     * @Description: 财务付款退回
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 16:40
     */
    @Override
    @Transactional
    public void backContPayment(ContRequestPayVo contRequestPayVo) {

        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(contRequestPayVo.getTaskId());
        //更新合同状态，登录日志
        this.updateBizStatusAndWorkFlowLog(contRequestPayVo.getContNo(),contRequestPayVo.getApplyNo(),SENDBACK.getType(),
                contRequestPayVo.getMemo(),contRequestPayVo.getUser(),actRuTaskVo);
    }

    /**
     * @param contNo
     * @Description: 构造还款计划表并返回
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/10 16:20
     */
    @Override
    public List<ContRepaySked> getContRepaySked(String contNo) {
        //取得合同融资信息，生成还款计划表
        ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(contNo);

        Contract contract = contractService.findContractByContractNo(contNo);
        //还款日取得
        String repayDay = contractFinanceVo.getRepayDay();
        if(StringUtils.isTrimBlank(repayDay)){
            throw new FmsServiceException("还款日不能为空");
        }
//        try {
//            repayDay = ResponseEntityUtils.getRestResponseData(basRepayRuleRpc.findRepayDay(repayDate));
//        }catch (FmsRpcException ex){
//            log.error(ex.getMessage());
//            ex.printStackTrace();
//            throw new FmsServiceException( "还款日取得失败");
//        }

        String[][] contRepaySkedArray;
        // 年供产品以外
        if(contractFinanceVo.getAnnualSupplyAmount().intValue() > 0){
            // 年供产品
            contRepaySkedArray = Financials.findmyrepaymentplanAnnual(contractFinanceVo.getFinTotal(), contractFinanceVo.getAnnualSupplyAmount(),
                    contractFinanceVo.getFinPeriodType(), contractFinanceVo.getRepayRate(), BigDecimalUtils.dividePercent6(contractFinanceVo.getIntrstRate()), contractFinanceVo.getRepayMode(), repayDay, contractFinanceVo.getRentPayMode());
        }else{
            contRepaySkedArray = Financials.findmyrepaymentplan(contractFinanceVo.getFinTotal(), contractFinanceVo.getFinalAmount(),
                    contractFinanceVo.getFinPeriodType(), contractFinanceVo.getRepayRate(), BigDecimalUtils.dividePercent6(contractFinanceVo.getIntrstRate()), contractFinanceVo.getRepayMode(), repayDay, contractFinanceVo.getRentPayMode());

        }
        List<ContRepaySked> contRepaySkedList = new ArrayList<>();
        //期数
        int period = Integer.valueOf(contractFinanceVo.getFinPeriodType())/Integer.valueOf(contractFinanceVo.getRepayRate());
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
        //生成还款计划表
        for(int i=1; i< contRepaySkedArray.length; i++){
            if(!StringUtils.isTrimBlank(contRepaySkedArray[i][0])){
                ContRepaySked contRepaySked = new ContRepaySked();

                contRepaySked.setContNo(contractFinanceVo.getContNo());
                contRepaySked.setPeriod(i);//期数
                contRepaySkedArray[i][0] = DateUtils.getRepayDate(contract.getContractDate(), repayDay, i, contractFinanceVo.getRentPayMode());
                contRepaySked.setRepayDate(DateUtils.strToDate(contRepaySkedArray[i][0], DateUtils.formatStr_yyyyMMd_NO));//还款日期

                //成交日期
                contRepaySked.setDealDate(DateUtils.getNowDate());
                contRepaySked.setRent(new BigDecimal(contRepaySkedArray[i][1]));//每期客户租金
                contRepaySked.setPrincipal(new BigDecimal(contRepaySkedArray[i][2]));//当期本金
                contRepaySked.setInterest(new BigDecimal(contRepaySkedArray[i][3]));//当期利息
                contRepaySked.setRestPrincipal(new BigDecimal(contRepaySkedArray[i][4]));//当期剩余本金;
                contRepaySked.setIntrstMonthRate(new BigDecimal(contRepaySkedArray[i][5]));//当期月利率;
                contRepaySked.setRepayType(RepayTypeEnums.RENT.getType());//还款类别-租金
                //实际客户租金
                rentActual = new BigDecimal(contRepaySkedArray[i][1]);
                if(ChargePayModeEnums.INSTALMENT_CHARGE.getType().equals(contractFinanceVo.getChargePayMode())){
                    //最后一期
                    if(i == period){
                        charge = contractFinanceVo.getCharge().subtract(chargeSum);
                    }
                    contRepaySked.setCharge(charge);
                    rentActual = rentActual.add(charge);
                    chargeSum = chargeSum.add(charge);
                }
                if(DepositRtnModeEnums.INSTALMENT_DEPOSIT.getType().equals(contractFinanceVo.getDepositRtnMode())){
                    //最后一期
                    if(i == period){
                        deposit = contractFinanceVo.getDeposit().subtract(depositSum);
                    }
                    contRepaySked.setDeposit(deposit);
                    rentActual = rentActual.subtract(deposit);
                    depositSum = depositSum.add(deposit);
                }
                /*//有尾款时，最后一期租金包含尾款
                if(contractFinanceVo.getFinalAmount() !=null){
                    if(i == period){
                        rentActual = rentActual.add(contractFinanceVo.getFinalAmount());
                    }
                }*/
                //每月牌照使用费
                if(contractFinanceVo.getLicenseFee() != null){
                    rentActual = rentActual.add(contractFinanceVo.getLicenseFee());
                }
                contRepaySked.setRentActual(rentActual);
                setContRepaySked(contRepaySked, contractFinanceVo.getContNo());
                contRepaySkedList.add(contRepaySked);
            }
        }

        List<ContChargeReceiptVo> contChargeReceiptVoList = new ArrayList<>();
        //查询首付财务待收款数据
        try {
            contChargeReceiptVoList  = ResponseEntityUtils.getRestResponseData(contChargeRpc.fingContChargeAndReceiptByBizIdAndBizType(contNo,BizTypeEnums.CONT_NO.getType(),null));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            throw new FmsServiceException("获取财务待收款数据失败");
        }
        //首期租金
        List<ContChargeReceiptVo> firstRent = contChargeReceiptVoList.stream().filter(contChargeReceiptVo -> PayFundNameEnums.FIRST_RENT.getType().equals(contChargeReceiptVo.getChargeFund())).collect(Collectors.toList());
        //首付款
        List<ContChargeReceiptVo> initAmount = contChargeReceiptVoList.stream().filter(contChargeReceiptVo -> PayFundNameEnums.INIT_AMOUNT.getType().equals(contChargeReceiptVo.getChargeFund())).collect(Collectors.toList());

        //如果收首期租金
        if(YesNoFlagEnums.YES.getType().equals(contract.getChargeFirstRent())
                && ArrayUtils.isNotNullAndLengthNotZero(firstRent)){
            contRepaySkedList.get(0).setReceiptAmount(BigDecimalUtils.getNotNullBigDecimal(firstRent.get(0).getReceiptAmount()).add(BigDecimalUtils.getNotNullBigDecimal(firstRent.get(0).getChargeDeductionAmount())));//已收金额=实收金额+抵扣金额
            contRepaySkedList.get(0).setReceiptDate(firstRent.get(0).getReceiptDate());  //到账日期
            if(BigDecimalUtils.getNotNullBigDecimal(firstRent.get(0).getReceiptAmount()).compareTo(contRepaySkedList.get(0).getRentActual())>=0){
                contRepaySkedList.get(0).setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());//扣款状态=成功
            }
        }

        //生成首付
        ContRepaySked contRepaySked = new ContRepaySked();
        contRepaySked.setContNo(contractFinanceVo.getContNo());
        contRepaySked.setPeriod(0);//期数
        contRepaySked.setRepayDate(contRepaySkedList.get(0).getRepayDate());//还款日期=首付还款日期
        contRepaySked.setDealDate(DateUtils.getNowDate());//成交日期
        contRepaySked.setRent(contractFinanceVo.getInitAmount());//每期客户租金=首付金额
        contRepaySked.setRentActual(contractFinanceVo.getInitAmount());//实际租金=首付金额
        contRepaySked.setPrincipal(contractFinanceVo.getInitAmount());//当期本金=首付金额
        contRepaySked.setInterest(BigDecimal.ZERO);//当期利息=0
        contRepaySked.setRestPrincipal(contRepaySkedList.get(0).getRestPrincipal().add(contRepaySkedList.get(0).getPrincipal()));//当期剩余本金=第一期剩余本金+第一期当期本金
        contRepaySked.setOverdueStatus(OverDueStatusEnums.NOT_OVERDUE.getType());//逾期状态-正常
        contRepaySked.setRepayType(RepayTypeEnums.INIT_AMOUNT.getType());//首付
        if(ArrayUtils.isNotNullAndLengthNotZero(initAmount)){
            if(BigDecimalUtils.getNotNullBigDecimal(initAmount.get(0).getReceiptAmount()).compareTo(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()))>=0){
                contRepaySked.setReceiptDate(initAmount.get(0).getReceiptDate());//到账日期
                contRepaySked.setReceiptAmount(BigDecimalUtils.getNotNullBigDecimal(initAmount.get(0).getReceiptAmount()).add(BigDecimalUtils.getNotNullBigDecimal(initAmount.get(0).getChargeDeductionAmount())));//已收金额=实收金额+抵扣金额
                contRepaySked.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());//扣款状态-成功
            }else{
                contRepaySked.setReceiptDate(initAmount.get(0).getReceiptDate());//到账日期
                contRepaySked.setReceiptAmount(BigDecimalUtils.getNotNullBigDecimal(initAmount.get(0).getReceiptAmount()).add(BigDecimalUtils.getNotNullBigDecimal(initAmount.get(0).getChargeDeductionAmount())));//已收金额=实收金额+抵扣金额
                contRepaySked.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());//扣款状态-待扣款
            }
        }

        contRepaySkedList.add(contRepaySked);
        //如果有尾付，生成尾付
        if(contractFinanceVo.getFinalAmount() !=null && contractFinanceVo.getFinalAmount().compareTo(BigDecimal.ZERO)>0){
            ContRepaySked contRepaySkedFinal = new ContRepaySked();
            contRepaySkedFinal.setContNo(contractFinanceVo.getContNo());
            contRepaySkedFinal.setPeriod(period+1);//期数
            contRepaySkedFinal.setRepayDate(contRepaySkedList.get(period-1).getRepayDate());//还款日期=尾付还款日期
            contRepaySkedFinal.setDealDate(DateUtils.getNowDate());//成交日期
            contRepaySkedFinal.setRent(contractFinanceVo.getFinalAmount());//每期客户租金=尾付金额
            contRepaySkedFinal.setRentActual(contractFinanceVo.getFinalAmount());//实际租金=尾付金额
            contRepaySkedFinal.setPrincipal(contractFinanceVo.getFinalAmount());//当期本金=尾付金额
            contRepaySkedFinal.setInterest(BigDecimal.ZERO);//当期利息=0
            contRepaySkedFinal.setRestPrincipal(BigDecimal.ZERO);//当期剩余本金=0
            contRepaySkedFinal.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());//扣款状态-待扣款
            contRepaySkedFinal.setOverdueStatus(OverDueStatusEnums.NOT_OVERDUE.getType());//逾期状态-正常
            contRepaySkedFinal.setRepayType(RepayTypeEnums.FINAL_AMOUNT.getType());//尾付
            contRepaySkedList.add(contRepaySkedFinal);

            //修改最后一期金额
            contRepaySkedList.get(period-1).setRent(contRepaySkedList.get(period-1).getRent().subtract(contractFinanceVo.getFinalAmount()));//租金-尾付
            contRepaySkedList.get(period-1).setRentActual(contRepaySkedList.get(period-1).getRentActual().subtract(contractFinanceVo.getFinalAmount()));//实际租金-尾付
            contRepaySkedList.get(period-1).setPrincipal(contRepaySkedList.get(period-1).getPrincipal().subtract(contractFinanceVo.getFinalAmount()));//当前本金-尾付
            contRepaySkedList.get(period-1).setRestPrincipal(contractFinanceVo.getFinalAmount());//剩余本金=尾付
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
     * @Description: 保存邮寄附件
     * @author: ningyangyang
     * @param contNo
     */
    public void saveOrigFile(String contNo){
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);

        String str1 = "WL";
        //共通方法取得 日期+编号
        String str3 = numGenerateService.getNumGenerateByNumType(NumTypeEnums.ORIG_FILE_NUM.getType());

        //存入邮寄附件
        OrigFile origFile = new OrigFile();
        origFile.setBizCode(contNo);
        origFile.setBizCodeType(OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());
        origFile.setFileRecordNo(str1.concat(str3));
        origFile.setOrigFileType(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr()) ?
                BizCodeTypeEnums.ORIG_SORT_FILE2.getCodeType() : BizCodeTypeEnums.ORIG_SORT_FILE1.getCodeType());
        origFile.setOrigFileStatus(OrigFileStatusEnums.VERIFIED.getType());

        //合同信息
        Example example = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo",contNo);
        Contract contract = contractRepository.selectOneByExample(example);
        //合同融资信息
        ContractFinanceVo contractFinaceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);

        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(contNo);

        Example example1 = SqlUtil.newExample(ContFinDetail.class);
        example1.createCriteria().andEqualTo("contNo", contNo);
        //融资费用明细信息
        List<ContFinDetail> contFinDetails = contFinDetailRepository.selectListByExample(example1);

        origFile.setOrigFileUser(contract.getApplyUser());
        origFile.setOrigFileGroup(contract.getGroupCode());
        //合同生效时间 --当日--车款付款日期
        Long contractValidDate  = DateUtils.getNowDate().getTime();
//        Long contractValidDate = contract.getContractValidDate().getTime();
        Long archday;
        try {
            //系统常量中取得归档期限天数
//            Long archday = new Long(ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(SysParamTypeEnums.ARCHIVAL_DAYS.getType())));
            archday = new Long(commonConstantService.findSysParamValue(CommonParamConstants.ARCHIVAL_DAYS));
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new FmsServiceException("取得系统常量失败");
        }
        //规则引擎取得天数
        RuleArchivalDaysVo ruleArchivalDaysVo = new RuleArchivalDaysVo();
        ruleArchivalDaysVo.setBelongGroup(contractFinaceVo.getBelongGroup());
        commonRuleService.get(ruleArchivalDaysVo, RuleTypeEnums.ARCHIVAL_DAYS.getType(), RuleTypeEnums.ARCHIVAL_DAYS.getKey());
        if(StringUtils.isNotTrimBlank(ruleArchivalDaysVo.getArchivalDays())){
            archday = Long.valueOf(ruleArchivalDaysVo.getArchivalDays());
        }
        //计算归档期限
        Long archdays =   archday * 24 * 3600 * 1000;
        Date date = new Date(contractValidDate+archdays);
        origFile.setOrigDeadline(date);
        origFileRepository.insertData(origFile);

        List<BizFiles> origFileList = new ArrayList<>();//归档附件保存申请和请款附件
        //插入申请附件
        List<BizFiles> applyBizfilesList = bizFilesService.findBizFilesList(contract.getApplyNo(),
                ApplyTypeEnums.PERSON.getType().equals(contract.getApplyType()) ? BizCodeTypeEnums.PRE_APPLY_INPUT_PER.getCodeType() : BizCodeTypeEnums.PRE_APPLY_INPUT_COMP.getCodeType());
        for(BizFiles bizFiles : applyBizfilesList){
            bizFiles.setFileId(null);
            bizFiles.setBizCode(contNo);
            bizFiles.setBizCodeType(origFile.getOrigFileType());
            bizFiles.setFileType(origFile.getOrigFileType()+"Apply");
            origFileList.add(bizFiles);
        }
        //插入请款附件
        List<BizFiles> requestBizfilesList = bizFilesService.findBizFilesList(contNo,BizCodeTypeEnums.REQUEST_PAY.getCodeType());
        for(BizFiles bizFiles : requestBizfilesList){
            bizFiles.setFileId(null);
            bizFiles.setBizCodeType(origFile.getOrigFileType());
            bizFiles.setFileType(origFile.getOrigFileType()+"Request");
            origFileList.add(bizFiles);
        }
        bizFilesService.saveBizFilesList(origFileList);

        //设置根据业务归档附件的map:融资项目
        Map<String, String> checkDataMap = new HashMap<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(contFinDetails)){
            for(ContFinDetail contFinDetail : contFinDetails){
                if(contFinDetail.getFinAmount() != null && contFinDetail.getFinAmount().compareTo(BigDecimal.ZERO) >0 ){
                    checkDataMap.put(contFinDetail.getFinItem()+"Flag","1");
                }
            }
        }

        //根据合同附件类型设置是否归档map
        //        担保保函（如有）
        //        咨询服务合同（如有）
        //        股东会决议（如有）
        //       《车辆的返还标准》（如有）
        //        车辆买卖回购协议（如有）
        //合同附件
        List<BizFiles> contBizfilesList = bizFilesService.findBizFilesList(contNo,contract.getContractFileType());
        //合同附件类型
        List<BasFileType> contBasFileTypeList = null;
        try {
            contBasFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(contract.getContractFileType()));
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //取到每一个附件类型对应的附件
        for(BasFileType basFileType : contBasFileTypeList){
            List<BizFiles> oneTypeList = contBizfilesList.stream().filter(bizFile -> StringUtils.equals(bizFile.getFileType(),basFileType.getFileType())).collect(Collectors.toList());
            if(ArrayUtils.isNotNullAndLengthNotZero(oneTypeList)){//如果存在附件
                if(basFileType.getFileTypeName().contains("担保保函"))
                    checkDataMap.put("directFile21Flag","1");
                else if(basFileType.getFileTypeName().contains("咨询服务合同"))
                    checkDataMap.put("directFile22Flag","1");
                else if(basFileType.getFileTypeName().contains("股东会决议"))
                    checkDataMap.put("directFile23Flag","1");
                else if(basFileType.getFileTypeName().contains("车辆的返还标准"))
                    checkDataMap.put("directFile24Flag","1");
                else if(basFileType.getFileTypeName().contains("车辆买卖回购协议"))
                    checkDataMap.put("directFile25Flag","1");
            }
        }

        //GPS盗抢险投保单或店里VPS盗抢险投保单（若没有在保险公司投保）
        checkDataMap.put("theftInsuranceFlag",contractVehicleVo.getTheftInsuranceFlag());


//        附件三（租金支付表）（年供产品需提供）
        checkDataMap.put("annualSupplyFlag",
                contractFinaceVo.getAnnualSupplyAmount().compareTo(BigDecimal.ZERO)>0 ? "1" : "0");

        //附件详情存入
        try {
            String fileType = origFile.getOrigFileType();
            if(StringUtils.isTrimBlank(fileType)){
                throw new FmsServiceException("未获取到合同模板类型!");
            }
            List<BasFileType> basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(fileType));
            List<OrigFileDetail> origFileDetailList = new ArrayList<>();
            for(BasFileType basFileType:basFileTypeList){
                boolean origFileDelFlag = true;

                //不是最低层级:子节点不为空
                if(ArrayUtils.isNotNullAndLengthNotZero(CommonTreeDataUtils.getChildResults(basFileTypeList, basFileType.getFileType()))){
                    continue;
                }
                //如果业务逻辑不满足，则不需要归档
                if(StringUtils.isNotTrimBlank(basFileType.getFileTypeExpr())){
                    Map<String,String> fileTypeExpr = CommonUtils.getExprMap(basFileType.getFileTypeExpr());
                    for(String key : fileTypeExpr.keySet()){
                        //当前合同不满足处理条件，则不归档
                        if(!fileTypeExpr.get(key).equals(StringUtils.defaultString(checkDataMap.get(key)))){
                            origFileDelFlag = false;
                            break;
                        }
                    }
                    if(!origFileDelFlag){
                        continue;
                    }
                }

                OrigFileDetail origFileDetail = new OrigFileDetail();
                origFileDetail.setBizCodeType(OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());
                origFileDetail.setBizCode(contNo);
                origFileDetail.setFileType(basFileType.getFileType());
                origFileDetail.setFileCount(basFileType.getFileQtyLimit());
                //默认需要归档
                origFileDetail.setOrigFlag(YesNoFlagEnums.YES.getType());
                origFileDetail.setOrigFileDetailStatus(OrigFileDetailStatusEnums.TO_BE_MAILED.getType());
                origFileDetailList.add(origFileDetail);
            }
            origFileDetailRepository.insertDataList(origFileDetailList);
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /** 
    * @Description: 生成待回填数据 
    * @param:  
    * @return:  
    * @Author: lijunjun
    * @Date: 2018/6/28 10:42
    */ 
    private void saveBackFill(ContRequestPayVo contRequestPayVo) {
        List<FinBackfillDetail> finBackfillDetailInsertList = new ArrayList<>();
        Example example = SqlUtil.newExample(ContFinDetail.class);
        example.createCriteria().andEqualTo("contNo", contRequestPayVo.getContNo());
        //融资费用明细信息
//        List<ApplyFinDetail> applyFinDetailList = applyFinDetailRepository.selectListByExample(example);
        List<ContFinDetail> contFinDetails = contFinDetailRepository.selectListByExample(example);
        //合同融资信息
        Example contractFinacneExample = SqlUtil.newExample(ContractFinance.class);
        contractFinacneExample.createCriteria().andEqualTo("contNo", contRequestPayVo.getContNo());
        ContractFinance contractFinance = contractFinanceRepository.selectOneByExample(contractFinacneExample);

        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(contRequestPayVo.getContNo());
        //正租赁税率
        BigDecimal taxRate = BigDecimal.ZERO;
        try{
//            String result = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.RENT_TAX)));
            String result = commonConstantService.findSysParamValue(CommonParamConstants.RENT_TAX);
            if (StringUtils.isNotTrimBlank(result)){
                taxRate = BigDecimalUtils.dividePercent(new BigDecimal(result));
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            throw new FmsServiceException("获取系统常量失败");
        }
        if (contractFinance == null){
            throw new FmsServiceException("合同融资信息不存在");
        }

        if (ArrayUtils.isNotNullAndLengthNotZero(contFinDetails)){
            for (ContFinDetail contFinDetail : contFinDetails){
                FinBackfillDetail finBackfillDetail = new FinBackfillDetail();
                finBackfillDetail.setContNo(contRequestPayVo.getContNo());//合同编号
                finBackfillDetail.setFinItem(contFinDetail.getFinItem());//融资项目代码
                finBackfillDetail.setFinItemYear(contFinDetail.getFinItemYear());//融资项目年限
                finBackfillDetail.setFinAmount(contFinDetail.getFinAmount());//融资项目金额
                finBackfillDetail.setShowDetail(YesNoFlagEnums.NO.getType());//参与计算

                //回租赁的场合给出默认值
                if (LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinance.getLicenseAttr())) {
                    finBackfillDetail.setActualFinAmount(contFinDetail.getFinAmount());//实际发票金额 回租赁的场合：融资费用金额 正租赁的场合：空白"
                    finBackfillDetail.setActualCostAmount(contFinDetail.getFinAmount());//实际成本金额 回租赁的场合：融资费用金额 正租赁的场合：空白"
                    finBackfillDetail.setActualTaxAmount(BigDecimal.ZERO);//实际成本金额 回租赁的场合：0 正租赁的场合：空白"
                }
                finBackfillDetailInsertList.add(finBackfillDetail);

            }
            //增加代收手续费
            FinBackfillDetail finBackfillDetail = new FinBackfillDetail();
            //手续费
            finBackfillDetail.setContNo(contRequestPayVo.getContNo());//合同编号
            finBackfillDetail.setFinItem(FinItemEnums.COLLECTING_POUNDAGE.getCode());//融资项目代码
            finBackfillDetail.setFinItemYear(0);//融资项目年限
            finBackfillDetail.setFinAmount(contractVehicleVo.getSalesCharge());//融资项目金额
            finBackfillDetail.setShowDetail(YesNoFlagEnums.YES.getType());//只用来展示
            //回租赁的场合给出默认值
            if (LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinance.getLicenseAttr())) {
                finBackfillDetail.setActualFinAmount(contractVehicleVo.getSalesCharge());//实际发票金额 回租赁的场合：融资费用金额 正租赁的场合：空白"
                finBackfillDetail.setActualCostAmount(contractVehicleVo.getSalesCharge());//实际成本金额 回租赁的场合：融资费用金额 正租赁的场合：空白"
                finBackfillDetail.setActualTaxAmount(BigDecimal.ZERO);//实际成本金额 回租赁的场合：0 正租赁的场合：空白"
            }
            finBackfillDetailInsertList.add(finBackfillDetail);
        }

        FinBackfill finBackfill = new FinBackfill();
        finBackfill.setContNo(contRequestPayVo.getContNo());//合同编号
        if (LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinance.getLicenseAttr())){
            finBackfill.setFilBackfillSts(FilBackfillStsEnums.ALREADY_BACKFILL.getType());//回填状态 1-已回填 回租赁的场合
            finBackfill.setInputTax(BigDecimal.ZERO);//进项税金
            finBackfill.setOutputTax(BigDecimal.ZERO);//销项税金
            finBackfill.setInvestTotal(contractFinance.getInvestTotal());//财务实际投资额
            finBackfill.setFinTotal(contractFinance.getFinTotal());//财务实际融资额
            finBackfill.setInitAmount(contractFinance.getInitAmount());//财务首付金额
            finBackfill.setFinalAmount(contractFinance.getFinalAmount());//财务尾付金额
            finBackfill.setIntrstRateYear(contractFinance.getSettleIntrstRate());//财务实际收益年利率
        } else {
            finBackfill.setFilBackfillSts(FilBackfillStsEnums.WAIT_BACKFILL.getType());
            finBackfill.setInputTax(BigDecimal.ZERO);//进项税金
            finBackfill.setOutputTax(BigDecimal.ZERO);//销项税金
            finBackfill.setInvestTotal(BigDecimal.ZERO);//财务实际投资额
            finBackfill.setFinTotal(BigDecimal.ZERO);//财务实际融资额
            finBackfill.setInitAmount(BigDecimalUtils.divide(CommonUtils.TrimBigDecimal(contractFinance.getInitAmount()), BigDecimal.ONE.add(taxRate), 2));//财务首付金额
            finBackfill.setFinalAmount(BigDecimalUtils.divide(CommonUtils.TrimBigDecimal(contractFinance.getFinalAmount()), BigDecimal.ONE.add(taxRate), 2));//财务尾付金额
        }

        //融资回填明细表登录
        if (ArrayUtils.isNotNullAndLengthNotZero(finBackfillDetailInsertList)){
            finBackfillDetailRepository.insertDataList(finBackfillDetailInsertList);
        }
        //融资回填表登录
        finBackfillRepository.insertData(finBackfill);
        FinBackfillVo finBackfillVo = new FinBackfillVo();
        BeanUtils.copyProperties(finBackfill, finBackfillVo);
        finBackfillVo.setLicenseAttr(contractFinance.getLicenseAttr());
        if (LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinance.getLicenseAttr())){
            //回租赁的场合，自动调用回填处理
            commonFinBackfillService.finBackfill(finBackfillVo);
        }

    }

    /** 
    * @Description: 更新合同状态，登录日志共通操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/14 18:31
    */ 
    private void updateBizStatusAndWorkFlowLog(String contNo,String applyNo,String act,String memo,String user, ActRuTaskVo actRuTaskVo) {
        //更新合同信息
        Contract contract = contractService.findContractByContractNo(contNo);
        if(contract == null){
            throw new FmsServiceException( "合同信息不存在");
        }
        contract.setBizStatus(actRuTaskVo.getTaskCode());
        if(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_LOAN.getFlag().equals(actRuTaskVo.getTaskDefinitionKey())
                && SUBMIT.getType().equals(act)){//如果是最后一步财务付款
            if(StringUtils.isNotTrimBlank(actRuTaskVo.getSubTaskCode())){
                contract.setBizStatus(actRuTaskVo.getSubTaskCode());//合同已生效
            }else{
                contract.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());//合同已生效
            }
        }
        contract.setPresentUser(actRuTaskVo.getNextAssignee());
        contractService.updateContractByContractId(contract, contract.getContractId());

        //合同日志录入
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(user);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(memo);
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(applyNo);
        workflowLog.setWfLogSubNo(contNo);
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        if(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_LOAN.getFlag().equals(actRuTaskVo.getTaskDefinitionKey())
                && SUBMIT.getType().equals(act)){//如果是最后一步财务付款
            if(StringUtils.isNotTrimBlank(actRuTaskVo.getSubTaskCode())){
                workflowLog.setStatus(actRuTaskVo.getSubTaskCode());//合同已生效
            }else{
                workflowLog.setStatus(BizStatusEnums.CONTRACT_EFFECT.getType());//合同已生效
            }
        }
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /** 
    * @Description: 车款放款完成后给GPS派单用户发送消息提醒
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/19 16:23
    */ 
    private void noticeGps(String contNo,String personName){
        Map<String,String> map = new HashMap<>();
//        map.put("contNo", contNo);
        map.put("personName", personName);
        String defaultTpl = "您好，有一条新合同承租人为：${personName}，车款放款已完成";
        commonSysUserInfoService.infoPoint(CommonUserUnitsEnums.USER.getUnit(),"os_xm02", TplTypeKeyEnums.NOTICE_GPS.getType(),map, InfoCodeTypeEnums.GPS_DISPATCH_LIST.getType(),defaultTpl);
    }

    /**
     * @Description: 车款放款完成后给盗抢险录入用户发送消息提醒
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/19 16:23
     */
    private void noticePilfer(String contNo,String personName){
        Map<String,String> map = new HashMap<>();
//        map.put("contNo", contNo);
        map.put("personName", personName);
        String defaultTpl = "您好，有一条新合同承租人为：${personName}，车款放款已完成";
        commonSysUserInfoService.infoPoint(CommonUserUnitsEnums.USER.getUnit(),"os_xm02", TplTypeKeyEnums.NOTICE_PILFER.getType(),map, InfoCodeTypeEnums.PILFER_INSURANCE_LIST.getType(),defaultTpl);
    }

    /**
     * @Description: 车款放款完成后给归档用户（业务员、资管）发送消息提醒
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/19 16:23
     */
    private void noticeOrigFile(String contNo,String personName){
        Map<String,String> map = new HashMap<>();
//        map.put("contNo", contNo);
        map.put("personName", personName);
        String defaultTpl = "您好，有一条新合同承租人为：${personName}，车款放款已完成";
        commonSysUserInfoService.infoPoint(CommonUserUnitsEnums.USER.getUnit(),"os_xm03", TplTypeKeyEnums.NOTICE_ORIG_FILE.getType(),map, InfoCodeTypeEnums.ORIG_FILE_ARCHIVE.getType(),defaultTpl);
    }

    /**
     * @Description: 回租赁则保存一条抵押提醒信息
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/7/30 16:23
     */
    private void saveMortgageRemind(String contNo){
        ContractFinanceVo contractFinanceVo =  contractFinanceService.findContractFinanceVoByContNo(contNo);
        if(contractFinanceVo != null){
            if(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())){
                MortgageRemind mortgageRemind  = new MortgageRemind();
                mortgageRemind.setContNo(contNo);
                mortgageRemindRepository.insertData(mortgageRemind);
            }
        }
    }

}
