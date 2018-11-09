package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BizActStatusService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ChargePayModeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.DepositRtnModeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.Financials;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.baseinfo.repository.BasVehicleRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyConditionalAgree.ApplyConditionalAgreeVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contconfirmbef.ContConfirmBefVo;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import cn.com.leadu.fms.prebiz.rpc.product.ProductRpc;
import cn.com.leadu.fms.prebiz.rpc.system.SysParamRpc;
import cn.com.leadu.fms.prebiz.service.*;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;
import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.APPLY_NUM_TYPE;
import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.CONTRACT_NUM_TYPE;
import static cn.com.leadu.fms.common.constant.enums.prebiz.ChargePayModeEnums.INSTALMENT_CHARGE;
import static cn.com.leadu.fms.common.constant.enums.prebiz.ChargePayModeEnums.ONETIME_CHARGE;
import static cn.com.leadu.fms.common.constant.enums.prebiz.DepositRtnModeEnums.INSTALMENT_DEPOSIT;


/**
 * @author liujinge
 * @ClassName: ContractService
 * @Description: 合同生成前确认业务实现层
 * @date 2018-03-23
 */
@Slf4j
@Service
public class ContConfirmBefServiceImpl implements ContConfirmBefService {

    /**
     * @Fields  :
     */
    @Autowired
    private ApplyService applyService;
    /**
     * @Fields  :
     */
    @Autowired
    private ApplyFinanceService applyFinanceService;

    /**
     * @Fields  :
     */
    @Autowired
    private ApplyVehicleService applyVehicleService;

    /**
     * @Fields  :
     */
    @Autowired
    private ApplyFinDetailService applyFinDetailService;

    /**
     * @Fields  :
     */
    @Autowired
    private ContractService contractService;

    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  :
     */
    @Autowired
    private ContractVehicleService contractVehicleService;

    /**
     * @Fields  :
     */
    @Autowired
    private ContractFinanceService contractFinanceService;

    /**
     * @Fields  :
     */
    @Autowired
    private ContFinDetailService contFinDetailService;

    /**
     * @Fields  :
     */
    @Autowired
    private ContPayService contPayService;

    @Autowired
    private ProductRpc productRpc;
    /**
     * @Fields  :
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  :
     */
    @Autowired
    private BizActStatusService bizActStatusService;

    /**
     * @Fields  :
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  :
     */
    @Autowired
    private QuotationDeviceService  quotationDeviceService;
    /*
     * @Fields  :
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    @Autowired
    private BasVehicleRepository basVehicleRepository;

    /**
     * @Fields  :客户个人基本信息service
     */
    @Autowired
    private CstmPersonService  cstmPersonService;

    /**
     * @Fields  :客户企业基本信息service
     */
    @Autowired
    private CstmCompanyService cstmCompanyService;

    /**
     * @Fields  :申请录入service
     */
    @Autowired
    private ApplyInputService applyInputService;

    private String pramKey = "requestPayMode";

    /**
     * @Title:
     * @Description: 保存合同生成前确认(订单流程的操作)
     * @param contConfirmBefVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @Transactional
    public void confirm(ContConfirmBefVo contConfirmBefVo){
        String applyNo = contConfirmBefVo.getApplyNo();
        //根据订单编号取得订单信息
        Apply apply = applyService.findApplyByApplyNo(applyNo);
        if(apply == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        String requestPayMode;
        try {
            requestPayMode = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(pramKey));
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException( "产品信息取得失败");
        }

        //根据订单编号取得融资信息
        ApplyFinance applyFinance = applyFinanceService.findApplyFinanceByApplyNo(applyNo);
        if(apply == null){
            throw new FmsServiceException( "订单融资信息不存在");
        }

        //根据订单编号取得客户信息(承租人)
        String cstmNameStr = null;
        if(StringUtils.isNotTrimBlank(apply.getApplyType())){
            if(apply.getApplyType().equals(ApplyTypeEnums.PERSON.getType())){
                CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(applyNo);
                if(cstmPerson == null){
                    throw new FmsServiceException( "客户基本信息取得失败");
                }else {
                    if(StringUtils.isNotTrimBlank(cstmPerson.getName())){
                        cstmNameStr = cstmPerson.getName();
                    }else {
                        throw new FmsServiceException( "客户名称信息取得失败");
                    }
                }
            }else if(apply.getApplyType().equals(ApplyTypeEnums.COMPANY.getType())){
                CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(applyNo);
                if(cstmCompany == null){
                    throw new FmsServiceException( "客户基本信息取得失败");
                }else {
                    if(StringUtils.isNotTrimBlank(cstmCompany.getName())){
                        cstmNameStr = cstmCompany.getName();
                    }else {
                        throw new FmsServiceException( "客户名称信息取得失败");
                    }
                }
            }else {
                throw new FmsServiceException( "申请类型信息不存在");
            }
        }else {
            throw new FmsServiceException( "申请类型信息不存在");
        }

        //根据订单编号取得担保人(企业)的信息
        List<String> guaranteeNameList = new ArrayList<>();
        ApplyInputVo applyInputVo = applyInputService.findApplyGuaranteeByApplyNo(applyNo);
        if(applyInputVo == null){
            throw new FmsServiceException( "担保人(企业)信息取得失败");
        }
        //担保人姓名
        if(applyInputVo.getGuaranteePersList() != null){
            for (GuaranteePers guaranteePers : applyInputVo.getGuaranteePersList()){
                if(guaranteePers != null){
                    if(StringUtils.isNotTrimBlank(guaranteePers.getName())){
                        guaranteeNameList.add(guaranteePers.getName());
                    }
                }
            }
        }
        //担保企业名称
        if(applyInputVo.getGuaranteeCompList() != null){
            for (GuaranteeComp guaranteeComp : applyInputVo.getGuaranteeCompList()){
                if(guaranteeComp != null){
                    if(StringUtils.isNotTrimBlank(guaranteeComp.getName())){
                        guaranteeNameList.add(guaranteeComp.getName());
                    }
                }
            }
        }
        //通过"、"将担保人(企业)名称信息衔接成一个字符串
        String guaranteeNameStr = StringUtils.joinDelimiter("、", guaranteeNameList);


        // 根据产品代码取得产品信息
        ProductVo productVo = null;
        try {
            Map<String,Object> productVoMap = ResponseEntityUtils.getRestResponseData(productRpc.findProductVoByProduct(applyFinance.getProduct()));
            productVo = JSON.parseObject(JSON.toJSONString(productVoMap),ProductVo.class);
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException( "产品信息取得失败");
        }
        //根据订单编号取得融资车辆信息
        List<ApplyVehicle> applyVehicleList = applyVehicleService.findApplyVehiclesByApplyNo(applyNo);
        if(applyVehicleList == null || applyVehicleList.size() == 0){
            throw new FmsServiceException( "融资车辆信息取得失败");
        }
        //融资费用明细取得
        List<ApplyFinDetail> applyFinDetailList = applyFinDetailService.findApplyFinDetailsByApplyNo(applyNo);
        if(applyFinDetailList == null || applyFinDetailList.size() == 0){
            throw new FmsServiceException( "融资费用明细取得失败");
        }
        //每个车辆序号对应的融资费用明细
        Map<String, List<ApplyFinDetail>> applyFinDetailMap = new HashMap<>();
        for(int m = 0; m < applyFinDetailList.size(); m++){
            //车辆序号
            String key = applyFinDetailList.get(m).getVehicleNo();
            if(!applyFinDetailMap.containsKey(key)){
                List<ApplyFinDetail> applyFinDetailVList = new ArrayList();
                applyFinDetailVList.add(applyFinDetailList.get(m));
                applyFinDetailMap.put(key, applyFinDetailVList);
            }else{
                applyFinDetailMap.get(key).add(applyFinDetailList.get(m));
            }
        }

        //登录用List
        List<Contract> contractList = new ArrayList();
        List<ContractVehicle> contractVehicleList = new ArrayList();
        List<ContFinDetail> contFinDetailList = new ArrayList();
        List<ContractFinance> contractFinanceList = new ArrayList();
        //合同与任务信息对应关系map
        Map<String,String> contNoAndServiceNameMap = new HashMap<>();

        List<ContPay> contPayList = new ArrayList();
        //订单内，各合同的首尾付合计，保证金合计
        BigDecimal initAmountSum = new BigDecimal("0");
        BigDecimal finalAmountSum = new BigDecimal("0");
        BigDecimal depositSum = new BigDecimal("0");
        BigDecimal annualAmountSum = new BigDecimal("0");

        //根据融资车辆信息生成合同
        for (int i = 0; i < applyVehicleList.size(); i++) {
            ApplyVehicle applyVehicle = applyVehicleList.get(i);
            for (int j = 0; j < applyVehicle.getVehicleCount().intValue(); j++){
                //合同编号取得
                String contractNo = numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());
                //分公司所在城市简称大写字母+分公司代码+日期+序号
                contractNo = applyFinance.getBelongGroup()+ contractNo;
                if(StringUtils.isTrimBlank(contractNo)){
                    throw new FmsServiceException( "合同编号取得失败");
                }

                //合同信息
                Contract contract = EntityUtils.getEntity(apply, new Contract());
                initContract(contract, apply, applyVehicle);
                contract.setContNo(contractNo);
//                contract.setBizStatus(contBizStatus);
                contractList.add(contract);

                //合同车辆信息
                ContractVehicle contractVehicle = new ContractVehicle();
                initContractVehicle(contractVehicle, applyVehicle);
                contractVehicle.setContNo(contractNo);
                contractVehicleList.add(contractVehicle);
                // 根据车型代码取得车型名称,并封装合同号与任务信息的对应关系
                if(StringUtils.isNotTrimBlank(contractVehicle.getVehicleCode())){
                    String vehicleName = basVehicleRepository.findVehicleNameForContConfirm(contractVehicle.getVehicleCode());
                    if(StringUtils.isNotTrimBlank(vehicleName)&&StringUtils.isNotTrimBlank(cstmNameStr)){
                        List<String> serviceNameStrList = new ArrayList<>();
                        serviceNameStrList.add("承租人:"+cstmNameStr);
                        serviceNameStrList.add("车型:"+vehicleName);
                        if(StringUtils.isNotTrimBlank(guaranteeNameStr)){
                            serviceNameStrList.add("担保人(企业):"+guaranteeNameStr);
                        }
                        //通过英文","将任务信息list衔接成一个字符串
                        String serviceName = StringUtils.joinDelimiter(",", serviceNameStrList);
                        contNoAndServiceNameMap.put(contractNo,serviceName);
                    }else {
                        throw new FmsServiceException( "车型名称信息或客户姓名信息取得失败");
                    }
                }else {
                    throw new FmsServiceException( "车型代码信息取得失败");
                }
                //车辆对应的融资费用明细
                List<ApplyFinDetail> applyFinDetailVList = applyFinDetailMap.get(applyVehicle.getVehicleNo());

                //首尾付基数，保证金基数
                BigDecimal initAmountBas = new BigDecimal("0");
                BigDecimal finalAmountBas = new BigDecimal("0");
                BigDecimal depositBas = new BigDecimal("0");
                //投资总额
                BigDecimal investTotal = new BigDecimal("0");
                //财务打款额
                BigDecimal payAmount = new BigDecimal("0");
                //根据融资费用明细，计算首尾付基数，保证金基数，投资总额，财务付款数据
                for(int n = 0; n < applyFinDetailVList.size(); n++){
                    //合同融资费用明细
                    ContFinDetail contFinDetail = new ContFinDetail();
                    initContFinDetail(contFinDetail, applyFinDetailVList.get(n));
                    contFinDetail.setContNo(contractNo);
                    contFinDetailList.add(contFinDetail);

                    //取得各融资项目的配置，计算首尾付基准，保证金基准
                    FinItemVo finItemVo = getItemType(productVo.getFinItemVoList(), contFinDetail.getFinItem());
                    //首尾付基准
                    if(finItemVo != null && finItemVo.getInitFinalItemFlag() == 1){
                        initAmountBas = initAmountBas.add(contFinDetail.getFinAmount());
//                        finalAmountBas = finalAmountBas.add(contFinDetail.getFinAmount());
                    }
                    //尾付基准
                    if(finItemVo != null && finItemVo.getFinalItemFlag() == 1){
                        finalAmountBas = finalAmountBas.add(contFinDetail.getFinAmount());
                    }
                    //保证金基准
                    if(finItemVo != null && finItemVo.getDepositItemFlag() == 1){
                        depositBas = depositBas.add(contFinDetail.getFinAmount());
                    }
                    //投资总额
                    investTotal = investTotal.add(contFinDetail.getFinAmount());

                    //财务付款额:是否和车款一起支付
                    if(finItemVo != null && YesNoFlagEnums.YES.getType().equals(finItemVo.getPayMode())){
                        payAmount = payAmount.add(contFinDetail.getFinAmount());
                    }
                }
                if(initAmountBas.intValue() == 0 || finalAmountBas.intValue() == 0  || finalAmountBas.intValue() == 0 || depositBas.intValue() == 0){
//                     throw new FmsServiceException( "首尾付基准或者保证金基准为0");
                }

                BigDecimal initAmount = new BigDecimal("0");
                //合同融资信息
                ContractFinance contractFinance = EntityUtils.getEntity(applyFinance, new ContractFinance());
                contractFinance.setContNo(contractNo);
                contractFinance.setVehicleNo(applyVehicle.getVehicleNo());
                if(((i + 1) < applyVehicleList.size()) || (( j + 1) < applyVehicle.getVehicleCount())){
                    //首付金额 = 首付额基数*首付比例
                    initAmount = initAmountBas.multiply(
                            BigDecimalUtils.dividePercent(contractFinance.getInitPerc())).setScale(0,BigDecimal.ROUND_HALF_UP);
                    contractFinance.setInitAmount(initAmount);
                    initAmountSum = initAmountSum.add(initAmount);
                    //尾付金额 = 尾付额基数*尾付比例
                    BigDecimal finalAmount = finalAmountBas.multiply(
                            BigDecimalUtils.dividePercent(contractFinance.getFinalPerc())).setScale(0,BigDecimal.ROUND_HALF_UP);
                    contractFinance.setFinalAmount(finalAmount);
                    finalAmountSum = finalAmountSum.add(finalAmount);
                    //保证金额 = 保证金基数*保证金比例
                    BigDecimal deposit = depositBas.multiply(
                            BigDecimalUtils.dividePercent(contractFinance.getDepositPerc())).setScale(0,BigDecimal.ROUND_HALF_UP);
                    contractFinance.setDeposit(deposit);
                    depositSum = depositSum.add(deposit);

                } else {
                    // 该订单中最后一个合同
                    //首付金额= 订单首付金额-其他合同首付额合计
                    initAmount = applyFinance.getInitAmount().subtract(initAmountSum);
                    contractFinance.setInitAmount(initAmount);
                    //首付比例= 首付金额/首付基数
                    contractFinance.setInitPerc(BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(
                            applyFinance.getInitAmount().subtract(initAmountSum),
                            initAmountBas,
                            4)));
                    //尾付金额= 订单尾付金额-其他合同尾付额合计
                    contractFinance.setFinalAmount(applyFinance.getFinalAmount().subtract(finalAmountSum));
                    contractFinance.setFinalPerc(BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(
                            applyFinance.getFinalAmount().subtract(finalAmountSum),
                                finalAmountBas,4)));
                    //保证金额= 订单保证金额-其他合同保证金额合计
                    contractFinance.setDeposit(applyFinance.getDeposit().subtract(depositSum));
                    contractFinance.setDepositPerc(BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(
                            applyFinance.getDeposit().subtract(depositSum),
                                depositBas,4)));
                }
                //投资总额
                contractFinance.setInvestTotal(investTotal);
                //融资额= 投资总额-首付额
                contractFinance.setFinTotal(investTotal.subtract(initAmount));

                if(((i + 1) < applyVehicleList.size()) || (( j + 1) < applyVehicle.getVehicleCount())){
                    //年供金额 = 融资额*年供比例
                    BigDecimal annualAmount = contractFinance.getFinTotal().multiply(
                            BigDecimalUtils.dividePercent(contractFinance.getAnnualSupplyRate())).setScale(0,BigDecimal.ROUND_HALF_UP);
                    contractFinance.setAnnualSupplyAmount(annualAmount);
                    annualAmountSum = annualAmountSum.add(annualAmount);
                }else{
                    //保证金额= 订单保证金额-其他合同保证金额合计
                    contractFinance.setAnnualSupplyAmount(applyFinance.getAnnualSupplyAmount().subtract(annualAmountSum));
                    contractFinance.setAnnualSupplyRate(BigDecimalUtils.multiplyPercent(
                            applyFinance.getAnnualSupplyAmount().subtract(annualAmountSum).divide(
                                    contractFinance.getFinTotal(),4,BigDecimal.ROUND_HALF_UP)));

                }

                //期数
                int period = Integer.valueOf(contractFinance.getFinPeriodType())/Integer.valueOf(contractFinance.getRepayRate());
                //每期租金 调用报价器--根据合同融资信息，合同融资车辆，单车的融资明细信息
                QuotationDeviceVo quotationDeviceVo = cacQuotaion(EntityUtils.getEntity(contractFinance, new ApplyFinanceVo()), EntityUtils.getEntity(contractVehicle, new ApplyVehicleVo()), applyFinDetailVList);
                BigDecimal rentActual = quotationDeviceVo.getMonthlySupply();
//                String [][] rent;
//                if(contractFinance.getAnnualSupplyRate().intValue() == 0){
//                    rent = Financials.findmyrepaymentplan(contractFinance.getFinTotal(),
//                            contractFinance.getFinalAmount(),
//                            contractFinance.getFinPeriodType(),
//                            contractFinance.getRepayRate(), BigDecimalUtils.dividePercent(contractFinance.getIntrstRate()),
//                            contractFinance.getRepayMode(), "1", contractFinance.getRentPayMode());
//                }else{
//                    rent = Financials.findmyrepaymentplanAnnual(contractFinance.getFinTotal(), contractFinance.getAnnualSupplyAmount(),
//                            contractFinance.getFinPeriodType(), contractFinance.getRepayRate(), BigDecimalUtils.dividePercent(contractFinance.getIntrstRate()), contractFinance.getRepayMode(), "1", contractFinance.getRentPayMode());
//                }
//                BigDecimal rentActual = new BigDecimal(rent[0][0]);
                if(ChargePayModeEnums.INSTALMENT_CHARGE.getType().equals(contractFinance.getChargePayMode())){
                    BigDecimal charge = contractFinance.getCharge().divide(new BigDecimal(period), 0, BigDecimal.ROUND_HALF_UP);
                    rentActual = rentActual.add(charge);
                }
                if(DepositRtnModeEnums.INSTALMENT_DEPOSIT.getType().equals(contractFinance.getDepositRtnMode())){
                    BigDecimal deposit = contractFinance.getDeposit().divide(new BigDecimal(period), 0, BigDecimal.ROUND_HALF_UP);
                    rentActual = rentActual.subtract(deposit);
                }
                //每月牌照使用费
                if(contractVehicle.getLicenseFee() != null){
                    rentActual = rentActual.add(contractVehicle.getLicenseFee());
                }
                contractFinance.setRent(rentActual);
                contractFinance.setIrr(quotationDeviceVo.getIrr());
                contractFinance.setTax(quotationDeviceVo.getTax());
                contractFinance.setLoanInterest(quotationDeviceVo.getLoanInterest());
                //合同融资信息
                contractFinanceList.add(contractFinance);

                //财务付款数据

                //是否差额付款：是 付款额=付款总额-首付-一次性手续费-保证金
                if(YesNoFlagEnums.YES.getType().equals(requestPayMode)){
                    payAmount = payAmount.subtract(initAmount);
                    //一次性手续费
                    if(ONETIME_CHARGE.getType().equals(contractFinance.getChargePayMode())){
                        payAmount = payAmount.subtract(contractFinance.getCharge());
                    }
                    payAmount = payAmount.subtract(contractFinance.getDeposit());
                }
                //合同财务付款明细
//                ContPay contPay = new ContPay();
//                contPay.setPayAmount(payAmount);
//                contPay.setPaymentType(PaymentTypeEnums.CONTREQUEST.getType());
//                contPay.setBizCode(contractNo);
//                contPay.setPayStatus(PayStatusEnums.REQUEST.getType());
//                contPayList.add(contPay);
            }
        }

        //流程引擎相关处理
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.confirmAgree(contractList,contConfirmBefVo.getTaskId(),contNoAndServiceNameMap);

        //取得合同状态
        String contBizStatus = actRuTaskVo.getTaskCode();
        if(StringUtils.isTrimBlank(contBizStatus)){
            throw new FmsServiceException( "合同状态取得失败");
        }
        //更新合同状态,当前节点用户
        for(Contract contract : contractList){
            contract.setPresentUser(actRuTaskVo.getNextAssignee());
            contract.setBizStatus(contBizStatus);
        }
        //合同信息插入
        contractService.insertContracts(contractList);
        //合同融资信息
        contractFinanceService.insertContractFinances(contractFinanceList);
        //合同融资费用明细
        contFinDetailService.insertContFinDetails(contFinDetailList);
        //合同车辆
        contractVehicleService.insertContractvehicles(contractVehicleList);

        //合同财务付款数据
//        contPayService.insertContPayList(contPayList);

        //更新订单状态
        String applyBizStatusUpd = BizStatusEnums.APPLY_FINISH.getType();//订单流程结束
        Apply applyUpd = new Apply();
        applyUpd.setApplyId(apply.getApplyId());
        applyUpd.setBizStatus(applyBizStatusUpd);
        applyUpd.setPresentUser("");
        applyService.updateApplyBizStsByApplyId(applyUpd);

        //合同日志录入
        WorkflowLog workflowLog = new WorkflowLog();
        initWorkflowLog(workflowLog, contConfirmBefVo);
        workflowLog.setStatus(applyBizStatusUpd);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    private QuotationDeviceVo cacQuotaion(ApplyFinanceVo applyFinanceVo, ApplyVehicleVo applyVehicleVo, List<ApplyFinDetail> applyFinDetailList) {
        ApplyInputVo applyInputVo = new ApplyInputVo();
        applyInputVo.setApplyFinanceVo(applyFinanceVo);
        List<ApplyFinDetailVo> applyFinDetailVoList = new ArrayList<>();
        for(ApplyFinDetail applyFinDetail : applyFinDetailList){
            applyFinDetailVoList.add(EntityUtils.getEntity(applyFinDetail, new ApplyFinDetailVo()));
        }
        applyVehicleVo.setApplyFinDetailVoList(applyFinDetailVoList);
        List<ApplyVehicleVo> applyVehicleVoList = new ArrayList();
        applyVehicleVoList.add(applyVehicleVo);
        applyInputVo.setApplyVehicleVoList(applyVehicleVoList);
        QuotationDeviceVo quotationDeviceVo =  quotationDeviceService.convertToQuotation(applyInputVo);
        quotationDeviceVo =quotationDeviceService.saveQuotationDeviceInfo(quotationDeviceVo, "2");
        return quotationDeviceVo;
    }


    private void initWorkflowLog(WorkflowLog workflowLog, ContConfirmBefVo contConfirmBefVo) {
        workflowLog.setUser(contConfirmBefVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setActType(SUBMIT.getType());
        workflowLog.setRemark1(contConfirmBefVo.getRemark1());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(contConfirmBefVo.getApplyNo());
    }

    private FinItemVo getItemType(List<FinItemVo> finItemVoList, String finItem) {
        for (FinItemVo finItemVo : finItemVoList) {
            if (StringUtils.equals(finItem, finItemVo.getFinItem())) {
                return finItemVo;
            }
        }
        return null;
    }

    private void initContFinDetail(ContFinDetail contFinDetail, ApplyFinDetail applyFinDetail) {
        EntityUtils.getEntity(applyFinDetail, contFinDetail);
    }

    private void initContractVehicle(ContractVehicle contractVehicle, ApplyVehicle applyVehicle) {
        EntityUtils.getEntity(applyVehicle, contractVehicle);
        //车辆数量固定为1
        contractVehicle.setVehicleCount(1);
    }

    private void initContract(Contract contract, Apply apply, ApplyVehicle applyVehicle) {
        //订单编号
        contract.setApplyNo(applyVehicle.getApplyNo());
        contract.setVehicleNo(applyVehicle.getVehicleNo());
        contract.setApplyType(apply.getApplyType());
        contract.setApplyUser(apply.getApplyUser());
        contract.setApplyGroup(apply.getApplyGroup());
        //当前节点用户
        contract.setPresentUser(apply.getPresentUser());
        //结清状态
        contract.setPaymentSts(PaymentStsEnums.UNCLEARED.getType());
    }

    /**
    * @Description: 退回到申请
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/15 15:18
    */
    @Override
    public void returnDealer(ContConfirmBefVo contConfirmBefVo) {
        //流程引擎,退回经销商
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnDealer(contConfirmBefVo.getTaskId());
        //更新日志
        applyApproveCommon(contConfirmBefVo, ActTypeEnums.SENDBACKTOP.getType(), actRuTaskVo);
    }

    /**
    * @Description: 更新日志
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/15 16:16
    */
    private void applyApproveCommon(ContConfirmBefVo contConfirmBefVo, String act, ActRuTaskVo actRuTaskVo) {
        String applyNo = contConfirmBefVo.getApplyNo();
        //根据订单编号取得订单信息
        Apply apply = applyService.findApplyByApplyNo(applyNo);
        if(apply == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        //更新订单状态
        String applyBizStatusUpd = actRuTaskVo.getTaskCode();
        if(StringUtils.isTrimBlank(applyBizStatusUpd)){
            throw new FmsServiceException( "订单状态取得失败");
        }
        Apply applyUpd = new Apply();
        applyUpd.setApplyId(apply.getApplyId());
        applyUpd.setBizStatus(applyBizStatusUpd);
        applyUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        applyService.updateApplyBizStsByApplyId(applyUpd);
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contConfirmBefVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contConfirmBefVo.getRemark1());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(contConfirmBefVo.getApplyNo());
        workflowLog.setStatus(applyBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

}
