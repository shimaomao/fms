package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.prebiz.*;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysRoleEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.QuotationDeviceRepository;
import cn.com.leadu.fms.data.system.repository.SysGroupParentRepository;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.prebiz.entity.QuotationDevice;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.prebiz.rpc.system.SysParamRpc;
import cn.com.leadu.fms.prebiz.service.QuotationDeviceService;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.QuotationDeviceDeleteListVo;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.QuotationDeviceDeleteVo;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.QuotationDeviceModifyVo;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.QuotationDeviceSaveVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

import static cn.com.leadu.fms.common.util.DateUtils.getDateForString;

/**
 * @author lijunjun
 * @ClassName: QuotationDeviceService
 * @Description: 报价器信息业务实现层
 * @date 2018-05-23
 */
@Service
@Slf4j
public class QuotationDeviceServiceImpl implements QuotationDeviceService {

    private static final Logger logger = LoggerFactory.getLogger(QuotationDeviceServiceImpl.class);

    /**
     * @Fields  : 报价器信息repository
     */
    @Autowired
    private QuotationDeviceRepository quotationDeviceRepository;

    /**
     * @Fields  : 系統常量Rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 生成pdfRpc
     */
    @Autowired
    private CommonPdfService commonPdfService;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysGroupParentRepository sysGroupParentRepository;

    /**
     * @Title:
     * @Description: 分页查询报价器信息
     * @param quotationDeviceVo
     * @return PageInfoExtend<QuotationDevice>
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    public PageInfoExtend<QuotationDeviceVo> findQuotationDevicesByPage(QuotationDeviceVo quotationDeviceVo,SysUserVo sysUser){
        if (StringUtils.isNotTrimBlank(quotationDeviceVo.getName())){
            quotationDeviceVo.setName(SqlUtil.likePattern(quotationDeviceVo.getName()));
        } else {
            quotationDeviceVo.setName(null);
        }
        if (StringUtils.isTrimBlank(quotationDeviceVo.getApplyType())){
            quotationDeviceVo.setApplyType(null);
        }
        //录入区分
        if (StringUtils.isTrimBlank(quotationDeviceVo.getQuotationEntryDistinction())){
            quotationDeviceVo.setQuotationEntryDistinction(null);
        }

        /*PageInfoExtend<QuotationDeviceVo> pageInfo = quotationDeviceRepository.selectListVoByPage("selectQuotationDevicesByPage", quotationDeviceVo, quotationDeviceVo.getPageQuery());*/
        return screening(quotationDeviceVo,sysUser);
    }

    /**
     * @Description: 分页报价单一览信息过滤条件
     * @param:
     * @return:
     * @Author:
     * @Date: 
     */
    public PageInfoExtend<QuotationDeviceVo> screening(QuotationDeviceVo quotationDeviceVo, SysUserVo sysUser){
        List<String> roleList = new ArrayList<>();
        sysUser.setRoles(sysUserRepository.selectSysUserVoById(sysUser.getUserId()).getRoles());
        for(SysRole role:sysUser.getRoles()){
            roleList.add(role.getRole());
        }
        PageInfoExtend<QuotationDeviceVo> pageInfo = null;
        if(roleList.contains(SysRoleEnums.YW.getId())){
            quotationDeviceVo.setSysUser(sysUser.getUser());
            pageInfo = quotationDeviceRepository.selectListVoByPage("selectQuotationDevicesByPage", quotationDeviceVo, quotationDeviceVo.getPageQuery());
        }else if(roleList.contains(SysRoleEnums.QY.getId())){
            List<String> groupCodes = new ArrayList<>();
            groupCodes.add(sysUser.getGroupCode());
            Example example = SqlUtil.newExample(SysGroupParent.class);
            example.createCriteria().andEqualTo("parentGroup",sysUser.getGroupCode());
            List<SysGroupParent> groups = sysGroupParentRepository.selectListByExample(example);
            if(ArrayUtils.isNotNullAndLengthNotZero(groups)){
                for(SysGroupParent group:groups){
                    groupCodes.add(group.getGroupCode());
                }
            }
            quotationDeviceVo.setSysUserGroup(groupCodes);
            pageInfo = quotationDeviceRepository.selectListVoByPage("selectQuotationDevicesByPage", quotationDeviceVo, quotationDeviceVo.getPageQuery());
        }else{
            pageInfo = quotationDeviceRepository.selectListVoByPage("selectQuotationDevicesByPage", quotationDeviceVo, quotationDeviceVo.getPageQuery());
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存报价器信息
     * @param quotationDeviceSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    public void saveQuotationDevice(QuotationDeviceSaveVo quotationDeviceSaveVo){
        quotationDeviceRepository.insertData(quotationDeviceSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改报价器信息
     * @param quotationDeviceModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    public void modifyQuotationDevice(QuotationDeviceModifyVo quotationDeviceModifyVo){
        quotationDeviceRepository.updateByPrimaryKeySelectiveData(quotationDeviceModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过quotationDeviceId删除报价器信息
     * @param quotationDeviceDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    public void deleteQuotationDevice(QuotationDeviceDeleteVo quotationDeviceDeleteVo){
        quotationDeviceRepository.deleteData(quotationDeviceDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过quotationDeviceId集合删除报价器信息
     * @param quotationDeviceDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    public void deleteQuotationDevicesByQuotationDeviceIds(QuotationDeviceDeleteListVo quotationDeviceDeleteListVo){
        quotationDeviceRepository.deleteDataList(quotationDeviceDeleteListVo.getQuotationDeviceIds(),quotationDeviceDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  获取计算所需参数
     * @return QuotationDeviceVo
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    public QuotationDeviceVo findSysParam(){
        QuotationDeviceVo quotationDeviceVo = new QuotationDeviceVo();
        try{
            //保险费率
            String commercialInsuranceRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.COMMERCIAL_INSURANCE_RATE)));
            //购置税税率
            String purchaseTaxRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.PURCHASE_TAX_RATE)));
            if (StringUtils.isNotTrimBlank(commercialInsuranceRateResult)){
                quotationDeviceVo.setCommercialInsuranceRate(commercialInsuranceRateResult);
            }
            if (StringUtils.isNotTrimBlank(purchaseTaxRateResult)){
                quotationDeviceVo.setPurchaseTaxRate(purchaseTaxRateResult);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new FmsServiceException(e.getMessage());
        }

        return quotationDeviceVo;
    }

    /**
     * @Title:
     * @Description:  根据quotationDeviceId获取报价器信息
     * @param quotationDeviceId
     * @return QuotationDevice
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    public QuotationDeviceVo findQuotationDeviceByQuotationDeviceId(String quotationDeviceId){
        return quotationDeviceRepository.selectQuotationDeviceByQuotationDeviceId(quotationDeviceId);
    }

    private void checkQuotationDevice(QuotationDeviceVo quotationDeviceVo, String commercialInsuranceRate, String purchaseTaxRate, String flag){
        //尾付比例和年供比例不能同时录入
        if ((quotationDeviceVo.getTailProportion() != null && quotationDeviceVo.getTailProportion().compareTo(BigDecimal.ZERO) != 0)
                && (quotationDeviceVo.getAnnualSupplyRate() != null && quotationDeviceVo.getAnnualSupplyRate().compareTo(BigDecimal.ZERO) != 0)){
            throw new FmsServiceException("尾付比例和年供比例不能同时录入");
        }
        //尾付金额和年供金额不能同时录入
        if ((quotationDeviceVo.getTailMoney() != null && quotationDeviceVo.getTailMoney().compareTo(BigDecimal.ZERO) != 0)
                && (quotationDeviceVo.getAnnualSupplyRate() != null && quotationDeviceVo.getAnnualSupplyRate().compareTo(BigDecimal.ZERO) != 0)){
            throw new FmsServiceException("尾付金额和年供金额不能同时录入");
        }
        //购置税=车辆标签价/11.7
//        if (CommonUtils.roundUpBigDecimal(BigDecimalUtils.divide(quotationDeviceVo.getCehicleLabelPrice(), new BigDecimal(purchaseTaxRate), 4)).compareTo(quotationDeviceVo.getPurchaseTax()) != 0){
//            throw new FmsServiceException("购置税计算不正确");
//        }
        //商业保险=车辆标签价*4%
//        if (CommonUtils.roundUpBigDecimal(quotationDeviceVo.getCehicleLabelPrice().multiply(
//                new BigDecimal(commercialInsuranceRate))).compareTo(quotationDeviceVo.getCommercialInsurance()) != 0){
//            throw new FmsServiceException("商业保险计算不正确");
//        }
        // 申请金额=车辆成交价+购置税+商业保险+上牌综合服务+交强险车船税+精品/选装
        BigDecimal total = quotationDeviceVo.getCehicleTransactionPrice().add(quotationDeviceVo.getPurchaseTax()).add(quotationDeviceVo.getCommercialInsurance())
                .add(quotationDeviceVo.getBoardServiceCharge()).add(quotationDeviceVo.getHighRiskVehicleTax()).add(quotationDeviceVo.getFineQuality());
        if ((new BigDecimal(Math.ceil(total.doubleValue()))).compareTo(quotationDeviceVo.getApplicationAmount()) != 0){
            throw new FmsServiceException("申请金额计算不正确");
        }
        //首付款=申请金额*首付比例 || 首付比例=首付款/申请金额
        if (CommonUtils.roundUpBigDecimal(quotationDeviceVo.getApplicationAmount().multiply(quotationDeviceVo.getDownPaymentRatio())
                .multiply(new BigDecimal("0.01"))).compareTo(quotationDeviceVo.getFirstPayment()) != 0 &&
                BigDecimalUtils.divide(quotationDeviceVo.getFirstPayment().multiply(new BigDecimal("100")), quotationDeviceVo.getApplicationAmount(), 0).compareTo(quotationDeviceVo.getDownPaymentRatio()) != 0){
            throw new FmsServiceException("首付款计算不正确");
        }
        //融资额=申请金额-首付款
        if (new BigDecimal(Math.ceil((quotationDeviceVo.getApplicationAmount().subtract(quotationDeviceVo.getFirstPayment()).doubleValue()))).compareTo(new BigDecimal(Math.ceil(quotationDeviceVo.getFinancingAmount().doubleValue()))) != 0){
            throw new FmsServiceException("融资额计算不正确");
        }
        //保证金=申请金额*保证金比例
        if (CommonUtils.roundUpBigDecimal(quotationDeviceVo.getApplicationAmount().multiply(quotationDeviceVo.getMarginLevel()).multiply(new BigDecimal("0.01")))
                .compareTo(quotationDeviceVo.getBond()) != 0 &&
                BigDecimalUtils.divide(quotationDeviceVo.getBond().multiply(new BigDecimal("100")), quotationDeviceVo.getApplicationAmount(), 0).compareTo(quotationDeviceVo.getMarginLevel()) != 0){
            throw new FmsServiceException("保证金计算不正确");
        }
        //大客户补贴金额=车辆标签价*大客户补贴比例
//        if (CommonUtils.roundUpBigDecimal(quotationDeviceVo.getCehicleLabelPrice().multiply(quotationDeviceVo.getCustomerSubsidyRatio())
//                .multiply(new BigDecimal("0.01"))).compareTo(quotationDeviceVo.getCustomerSubsidyAmount()) != 0){
//            throw new FmsServiceException("大客户补贴金额计算不正确");
//        }
        //直租年供的场合
        if ("1".equals(flag)){
            //年供金额=融资额*年供比例
            if (CommonUtils.roundUpBigDecimal(quotationDeviceVo.getFinancingAmount().multiply(quotationDeviceVo.getAnnualSupplyRate())
                    .multiply(new BigDecimal("0.01"))).compareTo(quotationDeviceVo.getAnnualSupplyAmount()) != 0){
                throw new FmsServiceException("年供金额计算不正确");
            }
        } else {
            //尾付款=申请金额*尾付比例
            if (CommonUtils.roundUpBigDecimal(quotationDeviceVo.getApplicationAmount().multiply(quotationDeviceVo.getTailProportion())
                    .multiply(new BigDecimal("0.01"))).compareTo(quotationDeviceVo.getTailMoney()) != 0 &&
                    BigDecimalUtils.divide(quotationDeviceVo.getTailMoney().multiply(new BigDecimal("100")), quotationDeviceVo.getApplicationAmount(), 0).compareTo(quotationDeviceVo.getTailProportion()) != 0){
                throw new FmsServiceException("尾付款计算不正确");
            }
        }
    }
    /**
     * @Title:
     * @Description: 做非空判断
     * @param quotationDeviceVo
     * @param quotationDeviceVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-8-23 17:02:03
     */
    private QuotationDeviceVo getQuotationDeviceVo(QuotationDeviceVo quotationDeviceVo){
        quotationDeviceVo.setCehicleLabelPrice(quotationDeviceVo.getCehicleLabelPrice()==null?BigDecimal.ZERO:quotationDeviceVo.getCehicleLabelPrice());
        quotationDeviceVo.setCehiclePurchasingPrice(quotationDeviceVo.getCehiclePurchasingPrice()==null?BigDecimal.ZERO:quotationDeviceVo.getCehiclePurchasingPrice());
        quotationDeviceVo.setCehicleTransactionPrice(quotationDeviceVo.getCehicleTransactionPrice()==null?BigDecimal.ZERO:quotationDeviceVo.getCehicleTransactionPrice());
        quotationDeviceVo.setPurchaseTax(quotationDeviceVo.getPurchaseTax()==null?BigDecimal.ZERO:quotationDeviceVo.getPurchaseTax());
        quotationDeviceVo.setCommercialInsurance(quotationDeviceVo.getCommercialInsurance()==null?BigDecimal.ZERO:quotationDeviceVo.getCommercialInsurance());
        quotationDeviceVo.setBoardServiceCharge(quotationDeviceVo.getBoardServiceCharge()==null?BigDecimal.ZERO:quotationDeviceVo.getBoardServiceCharge());
        quotationDeviceVo.setHighRiskVehicleTax(quotationDeviceVo.getHighRiskVehicleTax()==null?BigDecimal.ZERO:quotationDeviceVo.getHighRiskVehicleTax());
        quotationDeviceVo.setFineQuality(quotationDeviceVo.getFineQuality()==null?BigDecimal.ZERO:quotationDeviceVo.getFineQuality());
        quotationDeviceVo.setApplicationAmount(quotationDeviceVo.getApplicationAmount()==null?BigDecimal.ZERO:quotationDeviceVo.getApplicationAmount());
        quotationDeviceVo.setServiceCharge(quotationDeviceVo.getServiceCharge()==null?BigDecimal.ZERO:quotationDeviceVo.getServiceCharge());
        quotationDeviceVo.setFinancingAmount(quotationDeviceVo.getFinancingAmount()==null?BigDecimal.ZERO:quotationDeviceVo.getFinancingAmount());
        quotationDeviceVo.setAnnualSupplyAmount(quotationDeviceVo.getAnnualSupplyAmount()==null?BigDecimal.ZERO:quotationDeviceVo.getAnnualSupplyAmount());
        quotationDeviceVo.setMonthlySupply(quotationDeviceVo.getMonthlySupply()==null?BigDecimal.ZERO:quotationDeviceVo.getMonthlySupply());
        return quotationDeviceVo;
    }

    /**
     * @Title:
     * @Description: 保存报价器信息
     * @param quotationDeviceVo
     * @param inputMode 1-融资申请
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @Override
    @Transactional
    public QuotationDeviceVo saveQuotationDeviceInfo(QuotationDeviceVo quotationDeviceVo, String inputMode){
        quotationDeviceVo =  getQuotationDeviceVo(quotationDeviceVo);
        QuotationDevice quotationDevice = new QuotationDevice();
        if (StringUtils.isNotTrimBlank(quotationDeviceVo.getQuotationDeviceId())){
            Example example = SqlUtil.newExample(QuotationDevice.class);
            example.createCriteria().andEqualTo("quotationDeviceId", quotationDeviceVo.getQuotationDeviceId());
            quotationDevice = quotationDeviceRepository.selectOneByExample(example);
            if (quotationDevice == null){
                throw new FmsServiceException("报价器信息不存在");
            }
        }
        String serviceChargeRate = "";//手续费
        String incomeTaxRate = "";//企业所得税税率
        String vatTaxRate = "";//增值税税率
        String commercialInsuranceRate = "";//保险费率
        String purchaseTaxRate = "";//购置税税率
        String saleContractStampTaxRate = "";//购销合同印花税税率
        String leaseholdContractStampTaxRate = "";//租赁合同印花税率
        String loanContractStampTaxRate = "";//借款合同印花税率
        String businessCommissionRate = "";//业务用金系数
        //月供
        String repayMode = "";//还款方式 1-等额本金 2-等额本息
        String repayRate = "";//还款频率
        try{
            String repayModeResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.REPAY_MODE)));
            String repayRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.REPAY_RATE)));
            String serviceChargeRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.SERVICE_CHARGE_RATE)));
            String incomeTaxRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.INCOME_TAX_RATE)));
            String vatTaxRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.VAT_TAX_RATE)));
            String commercialInsuranceRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.COMMERCIAL_INSURANCE_RATE)));
            String purchaseTaxRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.PURCHASE_TAX_RATE)));
            String saleContractStampTaxRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.SALE_CONTRACT_STAMP_TAX_RATE)));
            String leaseholdContractStampTaxRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.LEASEHOLD_CONTRACT_STAMP_TAX_RATE)));
            String loanContractStampTaxRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.LOAN_CONTRACT_STAMP_TAX_RATE)));
            String businessCommissionRateResult = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey((CommonParamConstants.BUSINESS_COMMISSION_RATE)));
            if (StringUtils.isNotTrimBlank(businessCommissionRateResult)){
                businessCommissionRate = businessCommissionRateResult;
            }
            if (StringUtils.isNotTrimBlank(loanContractStampTaxRateResult)){
                loanContractStampTaxRate = loanContractStampTaxRateResult;
            }
            if (StringUtils.isNotTrimBlank(leaseholdContractStampTaxRateResult)){
                leaseholdContractStampTaxRate = leaseholdContractStampTaxRateResult;
            }
            if (StringUtils.isNotTrimBlank(saleContractStampTaxRateResult)){
                saleContractStampTaxRate = saleContractStampTaxRateResult;
            }
            if (StringUtils.isNotTrimBlank(repayModeResult)){
                repayMode = repayModeResult;
            }
            if (StringUtils.isNotTrimBlank(repayModeResult)){
                repayRate = repayRateResult;
            }
            if (StringUtils.isNotTrimBlank(serviceChargeRateResult)){
                serviceChargeRate = serviceChargeRateResult;
            }
            if (StringUtils.isNotTrimBlank(incomeTaxRateResult)){
                incomeTaxRate = incomeTaxRateResult;
            }
            if (StringUtils.isNotTrimBlank(vatTaxRateResult)){
                vatTaxRate = vatTaxRateResult;
            }
            if (StringUtils.isNotTrimBlank(commercialInsuranceRateResult)){
                commercialInsuranceRate = commercialInsuranceRateResult;
            }
            if (StringUtils.isNotTrimBlank(purchaseTaxRateResult)){
                purchaseTaxRate = purchaseTaxRateResult;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new FmsServiceException(e.getMessage());
        }

        String flag = getFlag(quotationDeviceVo);
        //报价单计算处理的场合
        if(StringUtils.isTrimBlank(inputMode)){
            //后台验证Check
            try{
                checkQuotationDevice(quotationDeviceVo, commercialInsuranceRate, purchaseTaxRate, flag);
            }catch (Exception e){
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new FmsServiceException(e.getMessage());
            }
        }

        //贸易收入=车辆成交价-车辆采购价
        quotationDeviceVo.setTradeIncome(CommonUtils.TrimBigDecimal(quotationDeviceVo.getCehicleTransactionPrice())
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getCehiclePurchasingPrice())));
        //融资期限
        BigDecimal loanTerm = new BigDecimal(quotationDeviceVo.getLoanTerm() == null?0:quotationDeviceVo.getLoanTerm());
        quotationDeviceVo.setLoanTerm(quotationDeviceVo.getLoanTerm());

        if ("1".equals(flag)) {
            //直租年供的场合
            double customerInterestRate = BigDecimalUtils.dividePercent6(
                    CommonUtils.TrimBigDecimal(quotationDeviceVo.getCustomerInterestRate())).doubleValue();
            DecimalFormat df = new DecimalFormat("0.0000");
            //报价类型是直租年供的场合
            double sumCustomerInterestRate = 0.0;
            //初始化rate
            double rate = 0.0;
            for (int i=1;i<loanTerm.intValue();i++){
                if (loanTerm.intValue() == 36){
                    if (i <= 3){
                        rate += Double.parseDouble(df.format(Math.pow((1 + customerInterestRate/12), -(i*12))));
                    }
                    if (i != 12 && i != 24 && i != 36) {
                        sumCustomerInterestRate += Double.parseDouble(df.format(Math.pow((1 + customerInterestRate/12), -i)));
                    }
                } else if(loanTerm.intValue() == 48){
                    if (i <= 4){
                        rate += Double.parseDouble(df.format(Math.pow((1 + customerInterestRate/12), -(i*12))));
                    }
                    if (i != 12 && i != 24 && i !=36 && i != 48) {
                        sumCustomerInterestRate += Double.parseDouble(df.format(Math.pow((1 + customerInterestRate/12), -i)));
                    }
                }
            }
            BigDecimal M16 = CommonUtils.TrimBigDecimal(quotationDeviceVo.getAnnualSupplyAmount().multiply(new BigDecimal(rate)));
            quotationDeviceVo.setMonthlySupply(CommonUtils.roundUpBigDecimal(BigDecimalUtils.divide(
                    CommonUtils.TrimBigDecimal(quotationDeviceVo.getFinancingAmount()).subtract(M16), new BigDecimal(sumCustomerInterestRate), 0)));

            //贷款利息=月供*(贷款期限-贷款期限/12) + 年供*贷款期限/12 - 融资额
            BigDecimal amount1 = CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply())
                    .multiply(loanTerm.subtract(BigDecimalUtils.divide(loanTerm, new BigDecimal("12"), 0)));
            BigDecimal amount2 = quotationDeviceVo.getAnnualSupplyAmount().multiply(BigDecimalUtils.divide(loanTerm, new BigDecimal("12"), 0));
            quotationDeviceVo.setLoanInterest(CommonUtils.roundUpBigDecimal(amount1.add(amount2).subtract(quotationDeviceVo.getFinancingAmount()==null?BigDecimal.ZERO:quotationDeviceVo.getFinancingAmount())));
        } else {
            String rentPayMode;
            if (StringUtils.isNotTrimBlank(quotationDeviceVo.getRentPayMode())){
                rentPayMode = quotationDeviceVo.getRentPayMode();//根据设定的支付方式
            } else {
                rentPayMode = RentPayModeEnums.END_PAY.getType();//固定为期初支付
            }
            String [][] rent = Financials.findmyrepaymentplan(quotationDeviceVo.getFinancingAmount(),
                    quotationDeviceVo.getTailMoney(),
                    String.valueOf(loanTerm.intValue()),
                    repayRate,
                    BigDecimalUtils.dividePercent6(quotationDeviceVo.getCustomerInterestRate()),
                    repayMode,
                    "1", rentPayMode);
            quotationDeviceVo.setMonthlySupply(CommonUtils.roundUpBigDecimal(new BigDecimal(rent[0][0])));

            //贷款利息=月供*融资期限+尾款金额-融资额
            quotationDeviceVo.setLoanInterest(CommonUtils.roundUpBigDecimal(CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply())
                    .multiply(CommonUtils.TrimBigDecimal(loanTerm)))
                    .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getTailMoney()))
                    .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getFinancingAmount())));
        }

        //项目粗利=贷款利息+贸易收入+手续费+大客户补贴金额-返还经销商手续费-渠道佣金-现金奖励-内部提成
        quotationDeviceVo.setProjectCoarseProfit(CommonUtils.roundUpBigDecimal(CommonUtils.TrimBigDecimal(quotationDeviceVo.getLoanInterest())
                .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getTradeIncome()))
                .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getServiceCharge()))
                .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getCustomerSubsidyAmount()))
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getRestitutionFee()))
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getChannelCommission()))
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getCashReward()))
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getInternalFormation()))));

        //静态收益率=贷款利息/融资额
        quotationDeviceVo.setStaticRateOfReturn(BigDecimalUtils
                .divide(CommonUtils.TrimBigDecimal(quotationDeviceVo.getLoanInterest()), CommonUtils.TrimBigDecimal(quotationDeviceVo.getFinancingAmount()), 4).multiply(new BigDecimal("100")));

        if (QuotationTypeFlagEnums.FINANCE_LEASE.getType().equals(flag) || QuotationTypeFlagEnums.LEASE_BACK.getType().equals(flag)){
            if (StringUtils.isNotTrimBlank(quotationDeviceVo.getQuotationType())
                    && QuotationTypeEnums.FINANCE_LEASE.getType().equals(quotationDeviceVo.getQuotationType())){
                //融资租赁的场合
                //增值税节税=(首付款+月供*贷款期限+尾款金额)/1.16 * 16% + 手续费/1.06 *6%
                BigDecimal amount1 = CommonUtils.TrimBigDecimal(quotationDeviceVo.getFirstPayment())
                        .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply()).multiply(CommonUtils.TrimBigDecimal(loanTerm)))
                        .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getTailMoney()));
                BigDecimal amount2 = BigDecimalUtils.divide(amount1, BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 2).multiply(new BigDecimal(vatTaxRate))
                        .add(BigDecimalUtils.divide(CommonUtils.TrimBigDecimal(quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 2)
                                .multiply(new BigDecimal(serviceChargeRate)));
                quotationDeviceVo.setVatTaxSaving(CommonUtils.roundUpBigDecimal(amount2));

                //所得税节税=（月供*贷款期限 + 尾款金额+首付款）/1.16 *25%
                BigDecimal amount3 = CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply()).multiply(CommonUtils.TrimBigDecimal(loanTerm))
                        .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getTailMoney())).add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getFirstPayment()));
                quotationDeviceVo.setIncomeTaxSaving(CommonUtils.roundUpBigDecimal(BigDecimalUtils.divide(amount3, BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 2).multiply(new BigDecimal(incomeTaxRate))));
            } else if (StringUtils.isNotTrimBlank(quotationDeviceVo.getQuotationType())
                    && QuotationTypeEnums.OPERATION_LEASE.getType().equals(quotationDeviceVo.getQuotationType())){
                //经营租赁的场合
                //增值税节税=(首付款+月供*贷款期限)/1.16 * 16% + 手续费/1.06 *6%
                BigDecimal amount1 = CommonUtils.TrimBigDecimal(quotationDeviceVo.getFirstPayment())
                        .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply()).multiply(CommonUtils.TrimBigDecimal(loanTerm)));
                BigDecimal amount2 = BigDecimalUtils.divide(amount1, BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 2).multiply(new BigDecimal(vatTaxRate))
                        .add(BigDecimalUtils.divide(CommonUtils.TrimBigDecimal(quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 2)
                                .multiply(new BigDecimal(serviceChargeRate)));
                quotationDeviceVo.setVatTaxSaving(CommonUtils.roundUpBigDecimal(amount2));
                //所得税节税=（月供*贷款期限 + 首付款）/1.16 *25%
                BigDecimal amount3 = CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply()).multiply(CommonUtils.TrimBigDecimal(new BigDecimal(quotationDeviceVo.getLoanTerm() == null?0:quotationDeviceVo.getLoanTerm())))
                        .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getFirstPayment()));
                quotationDeviceVo.setIncomeTaxSaving(CommonUtils.roundUpBigDecimal(BigDecimalUtils.divide(amount3, BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 2).multiply(new BigDecimal(incomeTaxRate))));
            }else if (StringUtils.isNotTrimBlank(quotationDeviceVo.getQuotationType())
                    && QuotationTypeEnums.LEASE_BACK.getType().equals(quotationDeviceVo.getQuotationType())){
                //增值税节税=0
                quotationDeviceVo.setVatTaxSaving(BigDecimal.ZERO);
                //所得税节税=0
                quotationDeviceVo.setIncomeTaxSaving(BigDecimal.ZERO);
            }
        }else if(QuotationTypeFlagEnums.OPERATION_LEASE.getType().equals(flag)){
            //直租年供的场合
            //增值税节税=(月供*(贷款期限-贷款期限/12) + 年供*贷款期限/12)/1.16 * 0.16 + 手续费/1.06 *0.06
            BigDecimal amount1 = CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply())
                    .multiply(loanTerm.subtract(BigDecimalUtils.divide(loanTerm, new BigDecimal("12"), 0)));
            BigDecimal amount2 = CommonUtils.TrimBigDecimal(quotationDeviceVo.getAnnualSupplyAmount())
                    .multiply(BigDecimalUtils.divide(loanTerm, new BigDecimal("12"), 0));
            BigDecimal amount3 = BigDecimalUtils.divide(amount1.add(amount2), BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 0)
                    .multiply(new BigDecimal(vatTaxRate));
            BigDecimal amount4 = BigDecimalUtils.divide(CommonUtils.TrimBigDecimal(quotationDeviceVo.getServiceCharge()),
                    BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 0).multiply(new BigDecimal(serviceChargeRate));
            quotationDeviceVo.setVatTaxSaving(CommonUtils.roundUpBigDecimal(amount3.add(amount4)));

            //所得税节税=(月供*(贷款期限-贷款期限/12) + 年供*贷款期限/12)/1.16 * 0.25
            BigDecimal amount5 = BigDecimalUtils.divide(amount1.add(amount2), BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 0).multiply(new BigDecimal(incomeTaxRate));
            quotationDeviceVo.setIncomeTaxSaving(CommonUtils.roundUpBigDecimal(amount5));
        }
        //需动用资金=融资额+返还经销商手续费+渠道佣金+现金奖励-保证金-续保押金-贸易收入+内部提成-手续费
        quotationDeviceVo.setNeedToUseFunds(CommonUtils.roundUpBigDecimal(CommonUtils.TrimBigDecimal(quotationDeviceVo.getFinancingAmount())
                .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getRestitutionFee()))
                .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getChannelCommission()))
                .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getCashReward()))
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getBond()))
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getRenewDeposit()))
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getTradeIncome()))
                .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getInternalFormation()))
                .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getServiceCharge()))));
        double[] cashFlows = getCashFlows(loanTerm, quotationDeviceVo, flag);
        String intrst_rate_year = CommonUtils.checkNum(Financials.getIRR(cashFlows));//得到IRR 是百分制
        quotationDeviceVo.setIrr(new BigDecimal(intrst_rate_year));

        if ("0".equals(flag)){
            //融资租赁或经营租赁的场合
            if (QuotationTypeEnums.FINANCE_LEASE.getType().equals(quotationDeviceVo.getQuotationType())){
                //融资租赁的场合
                //=C5*3/10000+(E17*E12+E14+E16)*0.5/10000+((C20+E6+C9+C7)/1.16*16%-(E6+C9)/1.06*6%)+((C20+E6+C9+C7)/1.16-(E6+C9)/1.06-C7)*25%+C11+E11+(E9)*0.8%
                BigDecimal bigDecimal1 = quotationDeviceVo.getCehicleTransactionPrice().multiply(new BigDecimal(saleContractStampTaxRate));
                BigDecimal bigDecimal2 = (quotationDeviceVo.getMonthlySupply()
                        .multiply(new BigDecimal(String.valueOf(quotationDeviceVo.getLoanTerm())))
                        .add(quotationDeviceVo.getFirstPayment())
                        .add(quotationDeviceVo.getTailMoney()))
                        .multiply(new BigDecimal(loanContractStampTaxRate));
                BigDecimal bigDecimala = (BigDecimalUtils.divide(quotationDeviceVo.getLoanInterest()
                        .add(quotationDeviceVo.getCommercialInsurance()==null? BigDecimal.ZERO:quotationDeviceVo.getCommercialInsurance())
                        .add(quotationDeviceVo.getServiceCharge())
                        .add(quotationDeviceVo.getBoardServiceCharge()==null?BigDecimal.ZERO:quotationDeviceVo.getBoardServiceCharge()), BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 4))
                        .multiply(new BigDecimal(vatTaxRate));
                BigDecimal bigDecimalb = (BigDecimalUtils.divide(quotationDeviceVo.getCommercialInsurance()==null?BigDecimal.ZERO:quotationDeviceVo.getCommercialInsurance()
                        .add(quotationDeviceVo.getServiceCharge()==null?BigDecimal.ZERO:quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4))
                        .multiply(new BigDecimal(serviceChargeRate));
                BigDecimal bigDecimal3 = bigDecimala.subtract(bigDecimalb);
                BigDecimal bigDecimal4 = BigDecimalUtils.divide(quotationDeviceVo.getLoanInterest() == null?BigDecimal.ZERO:quotationDeviceVo.getLoanInterest()
                        .add(quotationDeviceVo.getCommercialInsurance()==null?BigDecimal.ZERO:quotationDeviceVo.getCommercialInsurance())
                        .add(quotationDeviceVo.getServiceCharge()==null?BigDecimal.ZERO:quotationDeviceVo.getServiceCharge())
                        .add(quotationDeviceVo.getBoardServiceCharge()==null?BigDecimal.ZERO:quotationDeviceVo.getBoardServiceCharge()), BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 4);
                BigDecimal bigDecimal5 = (BigDecimalUtils.divide(quotationDeviceVo.getCommercialInsurance()==null?BigDecimal.ZERO:quotationDeviceVo.getCommercialInsurance()
                        .add(quotationDeviceVo.getServiceCharge()==null?BigDecimal.ZERO:quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4))
                        .subtract(quotationDeviceVo.getBoardServiceCharge()==null?BigDecimal.ZERO:quotationDeviceVo.getBoardServiceCharge());
                BigDecimal bigDecimal6 = (bigDecimal4.subtract(bigDecimal5)).multiply(new BigDecimal(incomeTaxRate));
                BigDecimal bigDecimal7 = quotationDeviceVo.getChannelCommission()==null?BigDecimal.ZERO:quotationDeviceVo.getChannelCommission().add(quotationDeviceVo.getCashReward())
                        .add(quotationDeviceVo.getFinancingAmount()==null?BigDecimal.ZERO:quotationDeviceVo.getFinancingAmount().multiply(new BigDecimal(businessCommissionRate)));

                BigDecimal bigDecimal8 = CommonUtils.roundUpBigDecimal(bigDecimal1.add(bigDecimal2).add(bigDecimal3).add(bigDecimal6).add(bigDecimal7));
                quotationDeviceVo.setTax(bigDecimal8);
            } else {
                //经营租赁的场合
                //=C5*3/10000+(E17*E12+E14+E16)*1/1000+((C20+C6+E6+C9+C7)/1.16*16%-(E6+C9)/1.06*6%)+((C20+C6+E6+C9+C7)/1.16-C6-(E6+C9)/1.06-C7)*25%+C11+E11+(E9)*0.8%
                BigDecimal bigDecimal1 = quotationDeviceVo.getCehicleTransactionPrice().multiply(new BigDecimal(saleContractStampTaxRate));
                BigDecimal bigDecimal2 = (quotationDeviceVo.getMonthlySupply()
                        .multiply(new BigDecimal(String.valueOf(quotationDeviceVo.getLoanTerm())))
                        .add(quotationDeviceVo.getFirstPayment())
                        .add(quotationDeviceVo.getTailMoney()))
                        .multiply(new BigDecimal(leaseholdContractStampTaxRate));
                BigDecimal bigDecimala = BigDecimalUtils.divide(quotationDeviceVo.getLoanInterest()
                        .add(quotationDeviceVo.getPurchaseTax())
                        .add(quotationDeviceVo.getCommercialInsurance())
                        .add(quotationDeviceVo.getServiceCharge())
                        .add(quotationDeviceVo.getBoardServiceCharge()), BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 4).multiply(new BigDecimal(vatTaxRate));
                BigDecimal bigDecimalb = BigDecimalUtils.divide(quotationDeviceVo.getCommercialInsurance()
                        .add(quotationDeviceVo.getServiceCharge())
                        .multiply(new BigDecimal(serviceChargeRate)), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4);
                BigDecimal bigDecimal3 = bigDecimala.subtract(bigDecimalb);
                BigDecimal bigDecimal4 = BigDecimalUtils.divide(quotationDeviceVo.getLoanInterest()
                        .add(quotationDeviceVo.getPurchaseTax())
                        .add(quotationDeviceVo.getCommercialInsurance())
                        .add(quotationDeviceVo.getServiceCharge())
                        .add(quotationDeviceVo.getBoardServiceCharge()), BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 4)
                        .subtract(quotationDeviceVo.getPurchaseTax());
                BigDecimal bigDecimal5 = BigDecimalUtils.divide(quotationDeviceVo.getCommercialInsurance()
                        .add(quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4)
                        .subtract(quotationDeviceVo.getBoardServiceCharge());
                BigDecimal bigDecimal6 = bigDecimal1.add(bigDecimal2).add(bigDecimal3)
                        .add(bigDecimal4.subtract(bigDecimal5).multiply(new BigDecimal(incomeTaxRate)))
                        .add(quotationDeviceVo.getChannelCommission())
                        .add(quotationDeviceVo.getCashReward())
                        .add(quotationDeviceVo.getFinancingAmount().multiply(new BigDecimal(businessCommissionRate)));
                quotationDeviceVo.setTax(bigDecimal6);
            }
        } else if ("1".equals(flag)){
            //直租年供的场合
            //=C5*3/10000+(E17*(E12-E12/12)+E16*E12/12+E14)*0.5/10000+(C20+E6+C7+C9)/1.16*16%-(E6+C9)/1.06*6%+((C20+E6+C7+C9)/1.16-(E6+C9)/1.06-C7)*25%+C11+E11+E9*0.8%
            BigDecimal bigDecimal1 = quotationDeviceVo.getCehicleTransactionPrice().multiply(new BigDecimal(saleContractStampTaxRate));
            BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(quotationDeviceVo.getLoanTerm()))
                    .subtract(BigDecimalUtils.divide(new BigDecimal(String.valueOf(quotationDeviceVo.getLoanTerm())), new BigDecimal("12"), 0))
                    .multiply(quotationDeviceVo.getMonthlySupply());
            BigDecimal bigDecimal3 = quotationDeviceVo.getAnnualSupplyAmount()
                    .multiply(BigDecimalUtils.divide(new BigDecimal(String.valueOf(quotationDeviceVo.getLoanTerm())), new BigDecimal("12"), 0))
                    .add(quotationDeviceVo.getFirstPayment());
            BigDecimal bigDecimal4 = bigDecimal2.add(bigDecimal3).multiply(new BigDecimal(loanContractStampTaxRate));
            BigDecimal bigDecimal5 = BigDecimalUtils.divide(quotationDeviceVo.getLoanInterest()
                    .add(quotationDeviceVo.getCommercialInsurance())
                    .add(quotationDeviceVo.getBoardServiceCharge())
                    .add(quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4)
                    .multiply(new BigDecimal(serviceChargeRate));
            BigDecimal bigDecimal6 = BigDecimalUtils.divide(quotationDeviceVo.getCommercialInsurance()
                    .add(quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4)
                    .multiply(new BigDecimal(serviceChargeRate));
            BigDecimal bigDecimal7 = BigDecimalUtils.divide(quotationDeviceVo.getLoanInterest()
                    .add(quotationDeviceVo.getCommercialInsurance())
                    .add(quotationDeviceVo.getBoardServiceCharge())
                    .add(quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(vatTaxRate)), 4);
            BigDecimal bigDecimal8 = BigDecimalUtils.divide(quotationDeviceVo.getCommercialInsurance()
                    .add(quotationDeviceVo.getServiceCharge()), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4)
                    .subtract(quotationDeviceVo.getBoardServiceCharge());
            BigDecimal bigDecimal9 = bigDecimal7.subtract(bigDecimal8).multiply(new BigDecimal(incomeTaxRate));
            BigDecimal bigDecimal10 = CommonUtils.roundUpBigDecimal(bigDecimal1.add(bigDecimal4).add(bigDecimal5)
                    .subtract(bigDecimal6).add(bigDecimal9)
                    .add(quotationDeviceVo.getChannelCommission())
                    .add(quotationDeviceVo.getCashReward())
                    .add(quotationDeviceVo.getFinancingAmount().multiply(new BigDecimal(businessCommissionRate))));
            quotationDeviceVo.setTax(bigDecimal10);
        } else {
            //回租赁的场合
            //=(E17*E12+E14+E16)*0.5/10000+C20/1.06*6%+C20/1.06*25%+C11+E11+E9*0.8%
            BigDecimal bigDecimal1 = (quotationDeviceVo.getMonthlySupply().multiply(new BigDecimal(String.valueOf(quotationDeviceVo.getLoanTerm())))
                    .add(quotationDeviceVo.getFirstPayment())
                    .add(quotationDeviceVo.getTailMoney()))
                    .multiply(new BigDecimal(loanContractStampTaxRate));
            BigDecimal bigDecimal2 = BigDecimalUtils.divide(quotationDeviceVo.getLoanInterest(), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4)
                    .multiply(new BigDecimal(serviceChargeRate));
            BigDecimal bigDecimal3 = BigDecimalUtils.divide(quotationDeviceVo.getLoanInterest(), BigDecimal.ONE.add(new BigDecimal(serviceChargeRate)), 4)
                    .multiply(new BigDecimal(incomeTaxRate));
            BigDecimal bigDecimal4 = CommonUtils.roundUpBigDecimal(bigDecimal1.add(bigDecimal2).add(bigDecimal3)
                    .add(quotationDeviceVo.getChannelCommission())
                    .add(quotationDeviceVo.getCashReward()).add(quotationDeviceVo.getFinancingAmount().multiply(new BigDecimal(businessCommissionRate))));
            quotationDeviceVo.setTax(bigDecimal4);
        }

        if (StringUtils.isNotTrimBlank(quotationDeviceVo.getQuotationDeviceId())){
            //如果主键Id有值，说明是更新操作
            quotationDeviceVo.setQuotationDate(quotationDevice.getQuotationDate());
            quotationDeviceVo.setGenerationDate(quotationDevice.getGenerationDate());
            quotationDeviceVo.setCreateTime(quotationDeviceVo.getCreateTime());
            quotationDeviceVo.setCreator(quotationDevice.getCreator());
            quotationDeviceVo.setDelFlag(quotationDevice.getDelFlag());
            QuotationDevice quotationDeviceUpd = quotationDeviceVo.getEntity();
            //更新报价器表
            if(!"2".equals(inputMode)){
                if(!"1".equals(inputMode)){
                    quotationDeviceRepository.updateByPrimaryKeySelectiveData(quotationDeviceUpd, true);
                }else{
                    quotationDeviceRepository.updateByPrimaryKeySelectiveData(quotationDeviceUpd);
                }
                quotationDeviceVo = EntityUtils.getEntity(quotationDeviceUpd, quotationDeviceVo);
            }
        } else {
            //如果主键Id没有值，说明是插入操作
            //将生成日期与报价时间设为当前时间
            Date nowDate = DateUtils.strToDate(DateUtils.getCurrentDateTime(), DateUtils.formatStr_yyyyMMddHHmmss);
            quotationDeviceVo.setQuotationDate(nowDate);
            quotationDeviceVo.setGenerationDate(nowDate);
            //订单提出用户和订单提出机构代码
            quotationDeviceVo.setApplyUser(quotationDeviceVo.getApplyUserContr());
            quotationDeviceVo.setApplyGroup(quotationDeviceVo.getApplyGroupContr());
            //登录报价器表
            if(!"2".equals(inputMode)){
                //录入区分(是报价录入还是提单)
                if(!"1".equals(inputMode)){
                    quotationDeviceVo.setQuotationEntryDistinction(QuotationEntryDistinctionEnums.BAO_JIA.getType());
                }else {
                    quotationDeviceVo.setQuotationEntryDistinction(QuotationEntryDistinctionEnums.TI_DAN.getType());
                }
                QuotationDevice quotationDeviceInsert = quotationDeviceVo.getEntity();
                quotationDeviceRepository.insertData(quotationDeviceInsert);
                quotationDeviceVo = EntityUtils.getEntity(quotationDeviceInsert, quotationDeviceVo);
            }

        }
        return quotationDeviceVo;
    }

    private double[] getCashFlows(BigDecimal loanTerm, QuotationDeviceVo quotationDeviceVo, String flag){
        double cashFlows[] = new double[loanTerm.intValue()];//用于调用IRR方法的参数
        cashFlows[0] = CommonUtils.TrimBigDecimal(quotationDeviceVo.getNeedToUseFunds()).multiply(new BigDecimal(-1))
                .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply())).doubleValue();
        //
        if (cashFlows[0] > 0){
            throw new FmsServiceException("需动用资金小于0，计算IRR失败");
        }
        if ("1".equals(flag)){
            for (int i=1;i<loanTerm.intValue();i++){
                //每一年的最后一期，年供
                if(i == loanTerm.intValue() - 1){
                    cashFlows[i] = CommonUtils.TrimBigDecimal(quotationDeviceVo.getAnnualSupplyAmount())
                            .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getBond())).doubleValue();
                }else if((i+1) % 12 == 0){
                    cashFlows[i] = CommonUtils.TrimBigDecimal(quotationDeviceVo.getAnnualSupplyAmount()).doubleValue();
                }else if(i == loanTerm.intValue() - 12){
                    cashFlows[i] = CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply())
                            .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getRenewDeposit())).doubleValue();
                }else {
                    cashFlows[i] = CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply()).doubleValue();
                }
            }
        } else {
            for (int i=1;i<loanTerm.intValue();i++){
                // 最后一年的第一期，减去续保押金
                if (i == loanTerm.intValue() - 12){
                    cashFlows[i] = CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply())
                            .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getRenewDeposit())).doubleValue();
                } else if(i == loanTerm.intValue() - 1){
                    // 最后一期，尾款-保证金+租金
                    cashFlows[i] = CommonUtils.TrimBigDecimal(quotationDeviceVo.getTailMoney())
                            .subtract(CommonUtils.TrimBigDecimal(quotationDeviceVo.getBond()))
                            .add(CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply())).doubleValue();
                } else {
                    //其他，月供
                    cashFlows[i] = CommonUtils.TrimBigDecimal(quotationDeviceVo.getMonthlySupply()).doubleValue();
                }
            }
        }
        return cashFlows;
    }

    /**
     * @Title:
     * @Description: 融资申请信息转换为报价单信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-2 10:18:12
     */
    @Transactional
    public QuotationDeviceVo convertToQuotation(ApplyInputVo applyInputVo) {

        QuotationDeviceVo quotationDeviceVo = initQuotationDeviceVo();
        ApplyFinanceVo applyFinanceVo = applyInputVo.getApplyFinanceVo();
        List<ApplyVehicleVo> applyVehicleVoList = applyInputVo.getApplyVehicleVoList();
        quotationDeviceVo = convertApplyFinance(applyFinanceVo, quotationDeviceVo);//融资信息转换
        quotationDeviceVo = convertApplyVehicle(applyVehicleVoList, quotationDeviceVo);//车辆信息转化
        quotationDeviceVo.setApplyType(applyInputVo.getApplyType() + applyFinanceVo.getVehicleForm());//申请类型
        quotationDeviceVo.setName(applyInputVo.getCstmName());
        quotationDeviceVo.setQuotationDate(DateUtils.getNowDate());//生成日期
        return quotationDeviceVo;
    }

    private QuotationDeviceVo initQuotationDeviceVo() {
        QuotationDeviceVo quotationDeviceVo = new QuotationDeviceVo();
        //融资申请不存在项目初期化
//        渠道佣金
        quotationDeviceVo.setChannelCommission(new BigDecimal("0"));
//        现金奖励
        quotationDeviceVo.setCashReward(new BigDecimal("0"));
//        内部提成
        quotationDeviceVo.setInternalFormation(new BigDecimal("0"));
//        大客户补贴比例
        quotationDeviceVo.setCustomerSubsidyRatio(new BigDecimal("0"));
        quotationDeviceVo.setCustomerSubsidyAmount(new BigDecimal("0"));
        quotationDeviceVo.setHighRiskVehicleTax(new BigDecimal("0"));//交强险车船税
        return quotationDeviceVo;
    }

    private QuotationDeviceVo convertApplyFinance(ApplyFinanceVo applyFinanceVo, QuotationDeviceVo quotationDeviceVo){
        //报价器id
        quotationDeviceVo.setQuotationDeviceId(applyFinanceVo.getQuotationDeviceId());
        //产品方案
        quotationDeviceVo.setProduct(applyFinanceVo.getProduct());
        //业务类型
        quotationDeviceVo.setQuotationType(applyFinanceVo.getLicenseAttr());
        //出租人
        quotationDeviceVo.setGroupCode(applyFinanceVo.getBelongGroup());
        quotationDeviceVo.setGroupName(applyFinanceVo.getBelongGroupName());
        //客户利率
        quotationDeviceVo.setCustomerInterestRate(applyFinanceVo.getIntrstRate());
        //申请金额-->	投资总额
        quotationDeviceVo.setApplicationAmount(applyFinanceVo.getInvestTotal());
        //融资额
        quotationDeviceVo.setFinancingAmount(applyFinanceVo.getFinTotal());
        //手续费
//        quotationDeviceVo.setServiceCharge(applyFinanceVo.getCharge());
        //贷款期限
        quotationDeviceVo.setLoanTerm(Integer.valueOf(applyFinanceVo.getFinPeriodType()));
        //首付款
        quotationDeviceVo.setDownPaymentRatio(applyFinanceVo.getInitPerc());
        quotationDeviceVo.setFirstPayment(applyFinanceVo.getInitAmount());
        //保证金
        quotationDeviceVo.setMarginLevel(applyFinanceVo.getDepositPerc());
        quotationDeviceVo.setBond(applyFinanceVo.getDeposit());
        //尾付款
        quotationDeviceVo.setTailProportion(applyFinanceVo.getFinalPerc());
        quotationDeviceVo.setTailMoney(applyFinanceVo.getFinalAmount());
        //年供
        quotationDeviceVo.setAnnualSupplyRate(applyFinanceVo.getAnnualSupplyRate());
        quotationDeviceVo.setAnnualSupplyAmount(applyFinanceVo.getAnnualSupplyAmount());

        quotationDeviceVo.setRentPayMode(applyFinanceVo.getRentPayMode());//租金支付模式

        return quotationDeviceVo;
    }

    private QuotationDeviceVo convertApplyVehicle(List<ApplyVehicleVo> applyVehicleVoList, QuotationDeviceVo quotationDeviceVo) {

        //融资费用项目转换
        Map<String, String> finItemMap = new HashMap<String, String>(){
            {
                put(FinItemEnums.CARPRICE.getCode(), "cehicleTransactionPrice");//车款
                put(FinItemEnums.PURTAX.getCode() , "purchaseTax");//购置税
                put(FinItemEnums.INSURANCE.getCode() , "commercialInsurance");//商业保险
                put(FinItemEnums.LICENSE.getCode() , "boardServiceCharge");//上牌费
                put(FinItemEnums.GPS.getCode() , "boardServiceCharge");//gps费用
                put(FinItemEnums.EXTEND.getCode() , "fineQuality");//精品/选装
                put(FinItemEnums.EXTRA.getCode() , "fineQuality");//精品/选装
            }
        };
        BigDecimal renewalDeposit = BigDecimal.ZERO;
        BigDecimal salesCharge = BigDecimal.ZERO;
        BigDecimal charge = BigDecimal.ZERO;
        BigDecimal backPurchase = BigDecimal.ZERO;
        BigDecimal channelCommission = BigDecimal.ZERO;
        BigDecimal cashReward = BigDecimal.ZERO;
        BigDecimal internalFormation = BigDecimal.ZERO;
        BigDecimal cehicleLabelPrice = BigDecimal.ZERO;//标签价
        for(int i = 0; i< applyVehicleVoList.size(); i++){
            //车型
            quotationDeviceVo.setVehicleCode(applyVehicleVoList.get(0).getVehicleCode());
            quotationDeviceVo.setVehicleName(applyVehicleVoList.get(0).getVehicleName());

            BigDecimal vehicleCount = new BigDecimal(applyVehicleVoList.get(i).getVehicleCount().toString());
            charge = charge.add(BigDecimalUtils.getNotNullBigDecimal(applyVehicleVoList.get(i).getCharge()).multiply(vehicleCount));
            renewalDeposit = renewalDeposit.add(BigDecimalUtils.getNotNullBigDecimal(applyVehicleVoList.get(i).getRenewalDeposit()).multiply(vehicleCount));//续保押金
            salesCharge = salesCharge.add(BigDecimalUtils.getNotNullBigDecimal(applyVehicleVoList.get(i).getSalesCharge()).multiply(vehicleCount));//代收手续费
            backPurchase = backPurchase.add(BigDecimalUtils.getNotNullBigDecimal(applyVehicleVoList.get(i).getBackPurchase()).multiply(vehicleCount));//回购价
            channelCommission = channelCommission.add(BigDecimalUtils.getNotNullBigDecimal(applyVehicleVoList.get(i).getChannelCommission()).multiply(vehicleCount));//取到佣金
            cashReward = cashReward.add(BigDecimalUtils.getNotNullBigDecimal(applyVehicleVoList.get(i).getCashReward()).multiply(vehicleCount));//现金奖励
            internalFormation = internalFormation.add(BigDecimalUtils.getNotNullBigDecimal(applyVehicleVoList.get(i).getInternalFormation()).multiply(vehicleCount));//内部提成
            cehicleLabelPrice = cehicleLabelPrice.add(BigDecimalUtils.getNotNullBigDecimal(applyVehicleVoList.get(i).getGuidePrice()).multiply(vehicleCount));//标签价
            //
            List<ApplyFinDetailVo> applyFinDetailVoList = applyVehicleVoList.get(i).getApplyFinDetailVoList();
            //融资费用
            if(ArrayUtils.isNotNullAndLengthNotZero(applyFinDetailVoList)){
                for(int j = 0;j < applyFinDetailVoList.size(); j++){
                    //融资项目
                    String finItemKey = applyFinDetailVoList.get(j).getFinItem();
                    if(finItemMap.containsKey(finItemKey)){
                        String propertyKey = finItemMap.get(finItemKey);
                        //取得报价器该项目的值
                        Object value = ReflectUtils.getFieldValue(propertyKey, quotationDeviceVo);
                        if (value != null) {
                            BigDecimal valueCal = new BigDecimal(value.toString());
                            valueCal = valueCal.add(applyFinDetailVoList.get(j).getFinAmount().multiply(vehicleCount));
                            ReflectUtils.setObjectValue(quotationDeviceVo, propertyKey, valueCal.toString());
                        } else {
                            ReflectUtils.setObjectValue(quotationDeviceVo, propertyKey, applyFinDetailVoList.get(j).getFinAmount().multiply(vehicleCount).toString());
                        }
                    }
                }
            }
        }
        quotationDeviceVo.setRenewDeposit(renewalDeposit);//续保押金
        quotationDeviceVo.setServiceCharge(charge);//手续费
        quotationDeviceVo.setRestitutionFee(salesCharge);//代收手续费
        quotationDeviceVo.setCehiclePurchasingPrice(quotationDeviceVo.getCehicleTransactionPrice());// 采购价=成交价
        quotationDeviceVo.setCehicleLabelPrice(cehicleLabelPrice);//标签价=指导价
        quotationDeviceVo.setBackPurchase(backPurchase); //回购价
        quotationDeviceVo.setChannelCommission(channelCommission);//渠道佣金
        quotationDeviceVo.setCashReward(cashReward);//现金奖励
        quotationDeviceVo.setInternalFormation(internalFormation);//内部提成
        return quotationDeviceVo;
    }

    /**
     * @Title:
     * @Description: 打印报价器单
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/06/13 01:48:00
     */
    @Transactional
    @Override
    public QuotationDeviceVo printQuotationDevice(QuotationDeviceVo quotationDeviceVo, String inputMode,SysUser sysUser){
        //获取需要输出的报价单数据
        QuotationDeviceVo quotationDeviceVoResult = saveQuotationDeviceInfo(quotationDeviceVo, inputMode);

        //收付款合计
        quotationDeviceVoResult.setFirstPaymentTotal(quotationDeviceVoResult.getFirstPayment().
                add(quotationDeviceVoResult.getBond()).add(quotationDeviceVoResult.getServiceCharge()).add(quotationDeviceVoResult.getRenewDeposit()));
        //尾款值的修改
        BigDecimal tailMoney = BigDecimal.ZERO;
        if (quotationDeviceVoResult.getBackPurchase() == null || quotationDeviceVoResult.getBackPurchase().compareTo(BigDecimal.ZERO) == 0) {
            //回购价有值的话，尾款不出力
            tailMoney = quotationDeviceVoResult.getTailMoney();
        }
        String flag = getFlag(quotationDeviceVo);
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(quotationDeviceVoResult);
        pdfVariables.put("userName",sysUser.getUserName());
        pdfVariables.put("userMobileNo",sysUser.getUserMobileNo());
        if (tailMoney != null) {
            pdfVariables.put("tailMoney",BigDecimalUtils.getValueDoublePreToStrFormat(tailMoney));
        }
        if (quotationDeviceVoResult.getCehicleLabelPrice() != null) {
            pdfVariables.put("cehicleLabelPrice",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getCehicleLabelPrice()));
        }
        if (quotationDeviceVoResult.getCehicleTransactionPrice() != null) {
            pdfVariables.put("cehicleTransactionPrice",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getCehicleTransactionPrice()));
        }
        if (quotationDeviceVoResult.getFineQuality() != null) {
            pdfVariables.put("fineQuality",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getFineQuality()));
        }
        if (quotationDeviceVoResult.getPurchaseTax() != null) {
            pdfVariables.put("purchaseTax",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getPurchaseTax()));
        }
        if (quotationDeviceVoResult.getCommercialInsurance() != null) {
            pdfVariables.put("commercialInsurance",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getCommercialInsurance()));
        }
        if (quotationDeviceVoResult.getBoardServiceCharge() != null) {
            pdfVariables.put("boardServiceCharge",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getBoardServiceCharge()));
        }
        if (quotationDeviceVoResult.getFinancingAmount() != null) {
            pdfVariables.put("financingAmount",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getFinancingAmount()));
        }
        if (quotationDeviceVoResult.getServiceCharge() != null) {
            pdfVariables.put("serviceCharge",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getServiceCharge()));
        }
        if (quotationDeviceVoResult.getRenewDeposit() != null) {
            pdfVariables.put("renewDeposit",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getRenewDeposit()));
        }
        if (quotationDeviceVoResult.getFirstPayment() != null) {
            pdfVariables.put("firstPayment",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getFirstPayment()));
        }
        if (quotationDeviceVoResult.getBond() != null) {
            pdfVariables.put("bond",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getBond()));
        }
        if (quotationDeviceVoResult.getAnnualSupplyAmount() != null) {
            pdfVariables.put("annualSupplyAmount",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getAnnualSupplyAmount()));
        }
        if (quotationDeviceVoResult.getBackPurchase() != null) {
            pdfVariables.put("backPurchase",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getBackPurchase()));
        }
        if (quotationDeviceVoResult.getMonthlySupply() != null) {
            pdfVariables.put("monthlySupply",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getMonthlySupply()));
        }
        if (quotationDeviceVoResult.getFirstPaymentTotal() != null && quotationDeviceVoResult.getMonthlySupply() != null) {
            pdfVariables.put("firstPaymentTotal",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getFirstPaymentTotal().add(quotationDeviceVoResult.getMonthlySupply())));
        }
        if (quotationDeviceVoResult.getVatTaxSaving() != null) {
            pdfVariables.put("vatTaxSaving",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getVatTaxSaving()));
        }
        if (quotationDeviceVoResult.getIncomeTaxSaving() != null) {
            pdfVariables.put("incomeTaxSaving",BigDecimalUtils.getValueDoublePreToStrFormat(quotationDeviceVoResult.getIncomeTaxSaving()));
        }

        if(pdfVariables == null){
            throw new FmsServiceException("取值错误,生成报价单信息失败");
        }
        String filePath;
        if (QuotationTypeFlagEnums.OPERATION_LEASE.getType().equals(flag)){
            //年供的场合
            //输出pdf
            filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.ANNUAL_SUPPLY_QUOTATION_DEVICE.getType());
        } else if (QuotationTypeFlagEnums.LEASE_BACK.getType().equals(flag)){
            //回租赁的场合
            //输出pdf
            filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.LEASE_BACK_QUOTATION_DEVICE.getType());
        } else {
            //融资租赁或者经营租赁的场合
            filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.DIRECT_LEASING_QUOTATION_DEVICE.getType());
        }
        quotationDeviceVoResult.setFilePath(filePath);
        return quotationDeviceVoResult;
    }

    private String getFlag(QuotationDeviceVo quotationDeviceVo){
        String flag ;
        if (StringUtils.isNotTrimBlank(quotationDeviceVo.getQuotationType())
                && (QuotationTypeEnums.FINANCE_LEASE.getType().equals(quotationDeviceVo.getQuotationType())
                || QuotationTypeEnums.OPERATION_LEASE.getType().equals(quotationDeviceVo.getQuotationType()))){
            flag = QuotationTypeFlagEnums.FINANCE_LEASE.getType();//融资租赁或者经营租赁  直租
            if (quotationDeviceVo.getAnnualSupplyRate() != null && quotationDeviceVo.getAnnualSupplyRate().compareTo(BigDecimal.ZERO) != 0){
                flag = QuotationTypeFlagEnums.OPERATION_LEASE.getType();//年供
            }
        } else {
            flag = QuotationTypeFlagEnums.LEASE_BACK.getType();//回租赁
        }
        return flag;
    }
}
