package cn.com.leadu.fms.business.service.impl;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonFinBackfillService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.FillBackFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.LicenseAttrEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinBackfillDetailRepository;
import cn.com.leadu.fms.data.finance.repository.FinRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.finance.repository.FinBackfillRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail.FinBackfillDetailVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/**
 * @author lijunjun
 * @ClassName: FinBackfillService
 * @Description: 融资回填业务实现层
 * @date 2018-05-11
 */
@Service
@Slf4j
public class CommonFinBackfillServiceImpl implements CommonFinBackfillService {

    private static final Logger logger = LoggerFactory.getLogger(CommonFinBackfillServiceImpl.class);

    /**
     * @Fields  : 融资回填repository
     */
    @Autowired
    private FinBackfillRepository finBackfillRepository;

    /**
     * @Fields  : 融资回填repository
     */
    @Autowired
    private FinBackfillDetailRepository finBackfillDetailRepository;


    /**
     * @Fields  : 财务还款计划repository
     */
    @Autowired
    private FinRepaySkedRepository finRepaySkedRepository;

    /**
     * @Fields  : 合同融资信息repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    /**
     * @Fields  : 销售还款计划信息repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 系统Rpc
     */
    @Autowired
    private CommonConstantService commonConstantService;


    /**
     * @Title:
     * @Description: 财务回填
     * @param finBackfillVo
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Transactional
    @Override
    public void finBackfill(FinBackfillVo finBackfillVo){

        List<FinRepaySked> finRepaySkedInsertList = new ArrayList<>();
        List<ContRepaySked> contRepaySkedList = new ArrayList<>();

        //回租赁税率
        String leasebackTaxResultParam = commonConstantService.findSysParamValue(CommonParamConstants.LEASE_BACK_TAX);
        String rentTaxResultParam = commonConstantService.findSysParamValue(CommonParamConstants.RENT_TAX);
        if(StringUtils.isTrimBlank(leasebackTaxResultParam)){
            throw new FmsServiceException("回租税率取得失败");
        }
        if(StringUtils.isTrimBlank(rentTaxResultParam)){
            throw new FmsServiceException("正租税率取得失败");
        }
        BigDecimal leasebackTax = new BigDecimal(leasebackTaxResultParam);
        BigDecimal rentTax = new BigDecimal(rentTaxResultParam);

        //获取融资还款计划信息
        ContRepaySkedVo contRepaySkedVo1 = new ContRepaySkedVo();
        contRepaySkedVo1.setContNo(finBackfillVo.getContNo());
        contRepaySkedVo1.setRepayStatus(RepayStatusEnums.PREPAYMENT.getType());
        List<ContRepaySkedVo> contRepaySkedVoList = finBackfillRepository.selectContRepaySkedByfinBackfillVo(contRepaySkedVo1);

        double cashFlows[] = new double[contRepaySkedVoList.size() + 1];//用于调用IRR方法的参数-回租赁
        double zjarr[] = new double[contRepaySkedVoList.size()];//用于调用findmyrepaymentplanByirr方法的参数 每期租金组合 按期数排序-回租赁

        //财务实际投资额
        BigDecimal totalRent = finBackfillVo.getInvestTotal();

        //获取合同融资信息
        ContractFinanceVo contractFinance = contractFinanceRepository.selectContractFinanceVoByContNo(finBackfillVo.getContNo());

        //取得现金流
        getArrayRent(contRepaySkedVoList, totalRent, cashFlows, zjarr, rentTax, contractFinance.getLicenseAttr());
        //计算irr
        double intrst_rate_year = CommonUtils.round2(Financials.getIRR(cashFlows));//得到IRR 是百分制 回租赁

        //财务本金
        BigDecimal restPrincipal;
        BigDecimal principal;
        if(LicenseAttrEnums.LEASE_BACK.getType().equals(finBackfillVo.getLicenseAttr())){
            restPrincipal = contractFinance.getInvestTotal();
        } else {
            restPrincipal = totalRent;
        }
        // 正租赁回填算法
        // 取得第一年的财务本金
        BigDecimal baseAmount = getBasAmount(finBackfillVo.getFinBackfillDetailVoList());

        //根据还款计划表生成回填数据
        for (int i = 1 ; i <= contRepaySkedVoList.size();  i ++ ){
            ContRepaySkedVo contRepaySkedVo = contRepaySkedVoList.get(i-1);
            if (LicenseAttrEnums.LEASE_BACK.getType().equals(finBackfillVo.getLicenseAttr())){//回租赁的场合
                //财务融资额(不含税)
                //不重新计算
                FinRepaySked finRepaySked = new FinRepaySked();
                finRepaySked.setContNo(contRepaySkedVo.getContNo());
                finRepaySked.setPeriod(contRepaySkedVo.getPeriod());
                finRepaySked.setDealDate(contRepaySkedVo.getDealDate());
                finRepaySked.setRepayDate(contRepaySkedVo.getRepayDate());
                finRepaySked.setIntrstMonthRate(contRepaySkedVo.getIntrstMonthRate());
                finRepaySked.setRent(contRepaySkedVo.getRent());
                finRepaySked.setPrincipal(contRepaySkedVo.getPrincipal());
                BigDecimal interest = BigDecimalUtils.divide(contRepaySkedVo.getInterest(), BigDecimal.ONE.add(leasebackTax), 2);
                finRepaySked.setInterest(interest);
                finRepaySked.setRestPrincipal(contRepaySkedVo.getRestPrincipal());
                BigDecimal revenue = BigDecimalUtils.divide(contRepaySkedVo.getInterest(), BigDecimal.ONE.add(leasebackTax), 2);
                finRepaySked.setRevenue(revenue);//主营收入 利息/（1+税率）
                BigDecimal tax = BigDecimalUtils.divide(contRepaySkedVo.getInterest(), BigDecimal.ONE.add(leasebackTax), 2).multiply(leasebackTax);
                finRepaySked.setTax(tax);//税金 利息/（1+税率）*税率
                finRepaySkedInsertList.add(finRepaySked);

                ContRepaySked contRepaySkedUpd = new ContRepaySked();
                contRepaySkedUpd.setRepaySkedId(contRepaySkedVo.getRepaySkedId());
                contRepaySkedUpd.setFinRent(finRepaySked.getRent());//财务租金
                contRepaySkedUpd.setFinRprincipal(finRepaySked.getPrincipal());//财务本金
                contRepaySkedUpd.setFinRinterest(finRepaySked.getInterest());//财务利息
                contRepaySkedUpd.setFinRestPrincipal(contRepaySkedVo.getRestPrincipal());//财务剩余本金
                contRepaySkedUpd.setFinRtax(finRepaySked.getTax());//财务税金
                contRepaySkedUpd.setFinRevenue(finRepaySked.getRevenue());//财务主营收入
                contRepaySkedList.add(contRepaySkedUpd);
            } else {
                if(baseAmount.compareTo(BigDecimal.ZERO) == 0){
                    baseAmount = contractFinance.getInvestTotal();
                }
                //最后一条明细
                if (i == contRepaySkedVoList.size()) {
                    principal = restPrincipal;
                    restPrincipal = new BigDecimal(0);
                }else{
                    // 财务本金= 销售本金*basAmount/申请总额
                    principal = BigDecimalUtils.divide(contRepaySkedVo.getPrincipal().multiply(baseAmount),contractFinance.getInvestTotal(),2 );
                    restPrincipal = restPrincipal.subtract(principal);
                }
                FinRepaySked finRepaySked = new FinRepaySked();
                // 财务租金
                finRepaySked.setRent(contRepaySkedVo.getRent());
                finRepaySked.setPrincipal(principal);
                // 主营收入= 租金/（1+税率）
                BigDecimal revenue = BigDecimalUtils.divide(contRepaySkedVo.getRent(), BigDecimal.ONE.add(rentTax), 2);
                // 财务利息 = 主营收入-财务本金
                finRepaySked.setInterest(revenue.subtract(principal));
                // 剩余本金
                finRepaySked.setRestPrincipal(restPrincipal);
                finRepaySked.setContNo(contRepaySkedVo.getContNo());
                finRepaySked.setPeriod(contRepaySkedVo.getPeriod());
                finRepaySked.setDealDate(contRepaySkedVo.getDealDate());
                finRepaySked.setRepayDate(contRepaySkedVo.getRepayDate());
                finRepaySked.setIntrstMonthRate(contRepaySkedVo.getIntrstMonthRate());

                finRepaySked.setRevenue(finRepaySked.getInterest());//主营收入 利息
                finRepaySked.setTax(contRepaySkedVo.getRent().multiply(rentTax));//税金 销售租金*税率
                finRepaySkedInsertList.add(finRepaySked);

                ContRepaySked contRepaySkedUpd = new ContRepaySked();
                contRepaySkedUpd.setRepaySkedId(contRepaySkedVo.getRepaySkedId());
                contRepaySkedUpd.setFinRent(finRepaySked.getRent());//财务租金
                contRepaySkedUpd.setFinRprincipal(finRepaySked.getPrincipal());//财务本金
                contRepaySkedUpd.setFinRinterest(finRepaySked.getInterest());//财务利息
                contRepaySkedUpd.setFinRestPrincipal(restPrincipal);//财务剩余本金
                contRepaySkedUpd.setFinRtax(contRepaySkedVo.getRent().multiply(rentTax));//财务税金=销售租金*税率
                contRepaySkedUpd.setFinRevenue(finRepaySked.getRevenue());//财务主营收入
                contRepaySkedList.add(contRepaySkedUpd);

            }
        }
        // 更新irr
        FinBackfill finBackfill = new FinBackfill();
        finBackfill.setFilBackfillId(finBackfillVo.getFilBackfillId());
        if(FillBackFlagEnums.NORMAL_PRODUCT.getType().equals(contractFinance.getFillBackFlag())) {
            finBackfill.setIntrstRateYear(contractFinance.getIntrstRate());
        }else{
            finBackfill.setIntrstRateYear(new BigDecimal(intrst_rate_year));
        }
        //更新财务回填表
        finBackfillRepository.updateByPrimaryKeySelectiveData(finBackfill);

        //登录财务还款计划表
//        if (ArrayUtils.isNotNullAndLengthNotZero(finRepaySkedInsertList)){
//            finRepaySkedRepository.insertDataList(finRepaySkedInsertList);
//        }
        //更新销售还款计划表
        if (ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedList)){
            contRepaySkedRepository.updateByPrimaryKeySelectiveDataList(contRepaySkedList);
        }
    }
    /**
     * @Title:
     * @Description: 财务回填共通
     * @param contNo
     * @throws
     * @author liujinge
     * @date 2018-5-11 16:12:19
     */
    @Transactional
    @Override
    public void finBackfillByContNo(String contNo){
        Example example = SqlUtil.newExample(FinBackfill.class);
        example.createCriteria().andEqualTo("contNo",contNo);
        FinBackfill finBackfill = finBackfillRepository.selectOneByExample(example);
        if(finBackfill == null){
            return;
        }
        FinBackfillVo finBackfillVo = finBackfillRepository.selectFinBackfillByFilBackfillId(finBackfill.getFilBackfillId());
        finBackfill(finBackfillVo);
    }


    private BigDecimal getBasAmount(List<FinBackfillDetailVo> finBackfillDetailVoList) {
        BigDecimal basAmount = new BigDecimal(BigInteger.ZERO);
        if(ArrayUtils.isNotNullAndLengthNotZero(finBackfillDetailVoList)){
            for(int i=0;i<finBackfillDetailVoList.size();i++){
                if((StringUtils.isTrimBlank(finBackfillDetailVoList.get(i).getFinItemYear())
                        || finBackfillDetailVoList.get(i).getFinItemYear() <= 1)
                        && !YesNoFlagEnums.YES.getType().equals(finBackfillDetailVoList.get(i).getShowDetail())){
                    basAmount.add(BigDecimalUtils.getNotNullBigDecimal(finBackfillDetailVoList.get(i).getActualCostAmount()));
                }
            }
        }
        return basAmount;
    }

    private List<ContRepaySkedVo> getRentList(List<ContRepaySkedVo> contRepaySkedVoListAll) {
        List<ContRepaySkedVo> contRepaySkedList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedVoListAll)){
            for(int i=0;i<contRepaySkedVoListAll.size();i++){
                if(RepayTypeEnums.RENT.getType().equals(contRepaySkedVoListAll.get(i))){
                    contRepaySkedList.add(contRepaySkedVoListAll.get(i));
                }
            }
        }
        return contRepaySkedList;
    }

    private void getArrayRent(List<ContRepaySkedVo> contRepaySkedVoList, BigDecimal totalRent, double cashFlows[], double zjarr[], BigDecimal rentTax, String licenseAttr){
        //第一条租金为合计金额
        //财务实际融资
        cashFlows[0] = -totalRent.doubleValue();
        if (ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedVoList)){
            for(int i=0;i<contRepaySkedVoList.size();i++){
                if(LicenseAttrEnums.LEASE_BACK.getType().equals(licenseAttr)){
                    zjarr[i] = contRepaySkedVoList.get(i).getRent().doubleValue();
                    cashFlows[i+1] = contRepaySkedVoList.get(i).getRent().doubleValue();
                }else{
                    zjarr[i] = CommonUtils.roundUpBigDecimal(BigDecimalUtils.divide(contRepaySkedVoList.get(i).getRent(), BigDecimal.ONE.add(rentTax), 0)).doubleValue();
                    cashFlows[i+1] = CommonUtils.roundUpBigDecimal(BigDecimalUtils.divide(contRepaySkedVoList.get(i).getRent(), BigDecimal.ONE.add(rentTax), 0)).doubleValue();
                }
            }
        }
    }

}
