package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonRuleService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.InsuranceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.DeductibleFeeEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContInsuranceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleInsuranceVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import cn.com.leadu.fms.prebiz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.*;

/**
 * @author liujinge
 * @ClassName: ContInsuranceService
 * @Description: 合同车辆保险信息业务实现层
 * @date 2018-03-23
 */
@Service
public class ContRequestPayServiceImpl implements ContRequestPayService {

    /**
     * @Fields  : 合同车辆保险信息repository
     */
    @Autowired
    private ContInsuranceRepository contInsuranceRepository;

    @Autowired
    private WorkflowLogService workflowLogService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private ApplyService applyService;

    @Autowired
    private CommonRuleService commonRuleService;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields : 合同融资费用明细信息
     */
    @Autowired
    private ContFinDetailService contFinDetailService;

    /**
     * @Fields : 融资合同还款信息
     */
    @Autowired
    private ContRepayAccountService contRepayAccountService;

    /**
     * @Fields : 合同车辆信息
     */
    @Autowired
    private ContractVehicleService contractVehicleService;

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
    * @Description: 请款共通操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 11:04
    */ 
    private void contReqPayCommon(ContRequestPayVo contRequestPayVo, String act, ActRuTaskVo actRuTaskVo){
        //保存财务付款表
        List<ContFinPayVo> contFinPayVoList = contRequestPayVo.getContFinPayVoList();
        for(ContFinPayVo contFinPayVo : contFinPayVoList){
            if(StringUtils.isNotTrimBlank(contFinPayVo.getContPay().getContPayId())){
                contPayRepository.updateByPrimaryKeySelectiveData(contFinPayVo.getContPay());
            }else{
                contFinPayVo.getContPay().setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
                contPayRepository.insertData(contFinPayVo.getContPay());
            }
        }

        //退回以外更新数据
        Contract contractUpd  = new Contract();
        //提交，保存请款日期
        if(SUBMIT.getType().equals(act)){
            contractUpd.setContractRequestDate(new Date());
        }

        //根据合同编号更新合同状态
        String contNo = contRequestPayVo.getContNo();

        if(!SENDBACK.getType().equals(act)){
            //合同车辆保险信息,先查询有没有数据，有则修改，无则保存
            Example example= SqlUtil.newExample(ContInsurance.class);
            example.createCriteria().andEqualTo("contNo",contNo);
            ContInsurance contInsurance  =contInsuranceRepository.selectOneByExample(example);
            if(contInsurance==null){
                contInsurance= EntityUtils.getEntity(contRequestPayVo, new ContInsurance());
                //取得保险类型
                RuleInsuranceVo ruleInsuranceVo = new RuleInsuranceVo();
                Contract contract = contractService.findContractByContractNo(contRequestPayVo.getContNo());
                Apply apply = applyService.findApplyByApplyNo(contRequestPayVo.getApplyNo());
                ruleInsuranceVo.setApplyType(contract.getApplyType());
                ruleInsuranceVo.setCompanyType1(apply.getCompanyType1());
                ruleInsuranceVo.setCompanyType2(apply.getCompanyType2());
                commonRuleService.get(ruleInsuranceVo, RuleTypeEnums.INSURANCE.getType(),RuleTypeEnums.INSURANCE.getKey());
                contInsurance.setInsuranceType(ruleInsuranceVo.getInsuranceType());
                contInsurance.setInsuranceStatus(InsuranceStatusEnums.INSURANCE_VALID.getType());
                contInsuranceRepository.insertData(contInsurance);
            }else{//保存保险信息
                contInsurance.setInsCompName(contRequestPayVo.getInsCompName());
//                contInsurance.setInsFee(contRequestPayVo.getInsFee());
//                contInsurance.setInsPolicyNo(contRequestPayVo.getInsPolicyNo());
//                contInsurance.setValidEndDay(contRequestPayVo.getValidEndDay());
//                contInsurance.setValidStartDay(contRequestPayVo.getValidStartDay());
//                contInsurance.setInsuranceStatus(contRequestPayVo.getInsuranceStatus());
                contInsuranceRepository.updateByPrimaryKeySelectiveData(contInsurance);
            }
            //更新附件信息
            bizFilesService.modifyBizFilesList(contRequestPayVo.getBizFilesList(),contRequestPayVo.getContNo(),
                    BizCodeTypeEnums.REQUEST_PAY.getCodeType());
//            if(!StringUtils.isTrimBlank(contRequestPayVo.getBizFilesVo())){
//                bizFilesService.saveBizFiles(contRequestPayVo.getBizFilesVo().getBizFilesListVos(), contRequestPayVo.getContNo(), BizCodeTypeEnums.REQUEST_PAY.getCodeType());
//            }
        }
        //暂存以外的操作，更新合同状态
        String contractBizStatusUpd = "";
        if(!SAVEINFO.getType().equals(act)){
            //根据合同编号取得订单信息
            Contract contract = contractService.findContractByContractNo(contRequestPayVo.getContNo());
            if(contract == null){
                throw new FmsServiceException( "合同信息不存在");
            }
            //更新合同状态
            contractBizStatusUpd = actRuTaskVo.getTaskCode();
            if(StringUtils.isTrimBlank(contractBizStatusUpd)){
                throw new FmsServiceException( "订单状态取得失败");
            }
            contractUpd.setBizStatus(contractBizStatusUpd);
            contractUpd.setPresentUser(actRuTaskVo.getNextAssignee());
            contractService.updateContractByContractId(contractUpd, contract.getContractId());
        }
        //日志信息
        if(!SAVEINFO.getType().equals(act)){
            //合同日志录入
            WorkflowLog workflowLog = new WorkflowLog();
            workflowLog.setUser(contRequestPayVo.getUser());
            workflowLog.setActWidgetId(RequestUtils.getRequestUri());
            workflowLog.setRemark1(contRequestPayVo.getMemo());
            workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
            workflowLog.setWfLogNo(contRequestPayVo.getApplyNo());
            workflowLog.setWfLogSubNo(contRequestPayVo.getContNo());
            workflowLog.setStatus(contractBizStatusUpd);
            workflowLog.setActType(act);
            workflowLogService.insertWorkFlowLog(workflowLog);
        }
    }

    /**
     * @Title:
     * @Description: 退回
     * @param contRequestPayVo
     * @return ContInsurance
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:30:19
     */
    @Transactional
    @Override
    public void sendBack(ContRequestPayVo contRequestPayVo){
        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(contRequestPayVo.getTaskId());

        //合同日志录入
        contReqPayCommon(contRequestPayVo, SENDBACK.getType(), actRuTaskVo);

    }

    /**
     * @Title:
     * @Description:  提交
     * @param contRequestPayVo
     * @return ContInsurance
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:30:19
     */
    @Transactional
    @Override
    public void submitContRequestPay(ContRequestPayVo contRequestPayVo){

        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(contRequestPayVo.getTaskId());
        //更新财务付款表
        contReqPayCommon(contRequestPayVo, SUBMIT.getType(), actRuTaskVo);

    }

    @Transactional
    @Override
    public void saveContRequestPay(ContRequestPayVo contRequestPayVo) {
        contReqPayCommon(contRequestPayVo, SAVEINFO.getType(), null);
    }

    /**
     * @Title:
     * @Description:  通过合同查询记录车辆保险信息
     * @param contNo  合同号
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:30:19
     */
    @Override
    public ContRequestPayVo findContRequestPayByContNo(String contNo){
        //根据合同号查询合同融资相关信息
        ContRequestPayVo contRequestPayVo = contractFinanceRepository.selectContractRequestFinanceByContNo(contNo);
        //查询付款项目明细
        List<ContFinPayVo> contFinPayVoList = this.findRequestContFinDetail(contNo,contRequestPayVo);
        contRequestPayVo.setContFinPayVoList(contFinPayVoList);

        contRequestPayVo.setBizFilesList(bizFilesService.findBizFilesList(contNo,BizCodeTypeEnums.REQUEST_PAY.getCodeType()));
//        CommonBizFilesVo bizFilesVo = bizFilesService.findBizFilesByBizCode(contNo, BizCodeTypeEnums.REQUEST_PAY.getCodeType());
//        if(StringUtils.isTrimBlank(bizFilesVo)){
//            contRequestPayVo.setBizFilesVo(new CommonBizFilesVo());
//        }else{
//            contRequestPayVo.setBizFilesVo(bizFilesVo);
//        }
        return  contRequestPayVo;
    }

    /**
    * @Description: 查询合同请款融资项目费用明细
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/25 14:03
    */
    @Override
    public List<ContFinPayVo> findRequestContFinDetail(String contNo,ContRequestPayVo contRequestPayVo){
        //根据合同编号查询请款明细
        List<ContFinPayVo> ContFinPayVos= contFinDetailService.findContFinDetailsWithContPay(contNo);
        List<ContFinPayVo> contFinPayVoList = new ArrayList<>();

        for(ContFinPayVo contFinPayVo : ContFinPayVos){
            if(contFinPayVo.getContPay() == null ){
                contFinPayVo.setContPay(new ContPay());
            }

            if(StringUtils.isTrimBlank(contFinPayVo.getContPay().getContPayId())){
                //如果付款表不存在，设置默认付款额为融资额
                contFinPayVo.getContPay().setBizCode(contNo);
                contFinPayVo.getContPay().setPaymentType(BizTypeEnums.CONT_NO.getType());
                contFinPayVo.getContPay().setPayAmount(contFinPayVo.getFinAmount());
                contFinPayVo.getContPay().setPayFund(contFinPayVo.getFinItem()+contFinPayVo.getFinItemYear());
                //如果是车款的话，如果定金是否抵扣车款为是，则车款付款金额=融资额-定金金额），车款默认收款账号为实际销售方的收款账号
                if(StringUtils.equals(contFinPayVo.getFinItem(), FinItemEnums.CARPRICE.getCode())){//车款代码"FIN01"
                    if(StringUtils.equals(DeductibleFeeEnums.DEDUCTION.getType(),contRequestPayVo.getDeductibleFees())){
                        if(contRequestPayVo.getVehDeposit() != null){
                            contFinPayVo.getContPay().setPayAmount(contFinPayVo.getFinAmount().subtract(contRequestPayVo.getVehDeposit()));
                        }
                    }
                    //设置为实际销售银行
                    contFinPayVo.getContPay().setRecAccBank(contRequestPayVo.getAccBank());
                    contFinPayVo.getContPay().setRecAccountNo(contRequestPayVo.getAccountNo());
                    contFinPayVo.getContPay().setRecAccountName(contRequestPayVo.getAccountName());
                    contFinPayVo.getContPay().setRecEleBankNo(contRequestPayVo.getEleAccountNo());
                }
            }
            contFinPayVoList.add(contFinPayVo);
            if(StringUtils.equals(contFinPayVo.getFinItem(), FinItemEnums.INSURANCE.getCode())) {//保险代码"FIN05"
                //玻璃险
                ContFinPayVo contFinPayVoA = new ContFinPayVo();
                contFinPayVoA.setFinAmount(new BigDecimal("0"));
                contFinPayVoA.setFinItemName("店内玻璃险");
                contFinPayVoA.setFinItemYear(contFinPayVo.getFinItemYear());
                contFinPayVoA.setFinItem(FinItemEnums.INSURANCE_A.getCode());
                ContPay contPayAOld = this.findRequestContPay(BizTypeEnums.CONT_NO.getType(),contNo,FinItemEnums.INSURANCE_A.getCode()+contFinPayVo.getFinItemYear());
                if(contPayAOld != null){
                    contFinPayVoA.setContPay(contPayAOld);
                }else{
                    ContPay contPayA = new ContPay();
                    contPayA.setPayAmount(new BigDecimal("0"));
                    contPayA.setPayFund(FinItemEnums.INSURANCE_A.getCode()+contFinPayVo.getFinItemYear());
                    contPayA.setBizCode(contNo);
                    contPayA.setPaymentType(BizTypeEnums.CONT_NO.getType());
                    contFinPayVoA.setContPay(contPayA);
                }
                contFinPayVoList.add(contFinPayVoA);
                //划痕险
                ContFinPayVo contFinPayVoB = new ContFinPayVo();
                contFinPayVoB.setFinAmount(new BigDecimal("0"));
                contFinPayVoB.setFinItemName("店内划痕险");
                contFinPayVoB.setFinItemYear(contFinPayVo.getFinItemYear());
                contFinPayVoB.setFinItem(FinItemEnums.INSURANCE_B.getCode());
                ContPay contPayBOld = this.findRequestContPay(BizTypeEnums.CONT_NO.getType(),contNo,FinItemEnums.INSURANCE_B.getCode()+contFinPayVo.getFinItemYear());
                if(contPayBOld != null){
                    contFinPayVoB.setContPay(contPayBOld);
                }else {
                    ContPay contPayB = new ContPay();
                    contPayB.setPayAmount(new BigDecimal("0"));
                    contPayB.setPayFund(FinItemEnums.INSURANCE_B.getCode()+contFinPayVo.getFinItemYear());
                    contPayB.setBizCode(contNo);
                    contPayB.setPaymentType(BizTypeEnums.CONT_NO.getType());
                    contFinPayVoB.setContPay(contPayB);
                }
                contFinPayVoList.add(contFinPayVoB);
            }
        }

        //代收手续费
        ContFinPayVo contFinPayVoC = new ContFinPayVo();
        contFinPayVoC.setFinAmount(contRequestPayVo.getSalesCharge());
        contFinPayVoC.setFinItemName(FinItemEnums.COLLECTING_POUNDAGE.getDesc());
        contFinPayVoC.setFinItemYear(0);
        contFinPayVoC.setFinItem(FinItemEnums.COLLECTING_POUNDAGE.getCode());
        ContPay contPayCOld = this.findRequestContPay(BizTypeEnums.CONT_NO.getType(),contNo,FinItemEnums.COLLECTING_POUNDAGE.getCode());
        if(contPayCOld != null){
            contFinPayVoC.setContPay(contPayCOld);
        }else {
            ContPay contPayC = new ContPay();
            contPayC.setPayAmount(contRequestPayVo.getSalesCharge());
            contPayC.setPayFund(FinItemEnums.COLLECTING_POUNDAGE.getCode());
            contPayC.setBizCode(contNo);
            contPayC.setPaymentType(BizTypeEnums.CONT_NO.getType());
            contFinPayVoC.setContPay(contPayC);
        }
        contFinPayVoList.add(contFinPayVoC);
        return contFinPayVoList;
    }

    /**
     * @Description: 查询财务付款表（业务类型，业务关联号，付款款项）
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/25 17:20
     */
    private ContPay findRequestContPay(String paymentType,String bizCode,String payFund) {
        ContPay contPay = contPayService.findContPayListByBizCodeAndPayFundAndPaymentType(paymentType,bizCode, payFund);
        return contPay;
    }
}
