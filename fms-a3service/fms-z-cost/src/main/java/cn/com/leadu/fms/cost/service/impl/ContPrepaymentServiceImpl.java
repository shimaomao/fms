package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContPrepaymentUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PrepaymDetailItemEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PrepaymentTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.postbiz.CostItemEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DisposalStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehicleDisposalStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.cost.rpc.finance.ContOverdueRpc;
import cn.com.leadu.fms.cost.rpc.finance.ContRepaySkedRpc;
import cn.com.leadu.fms.cost.rpc.prebiz.ContractFinanceRpc;
import cn.com.leadu.fms.cost.rpc.system.SysParamRpc;
import cn.com.leadu.fms.cost.service.ContPrepayDetailService;
import cn.com.leadu.fms.cost.service.ContPrepaymentApproveService;
import cn.com.leadu.fms.cost.service.ContPrepaymentService;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentDeleteListVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentDeleteVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentModifyVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentSaveVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.ContPrepaymentRepository;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.postbiz.repository.ContCostRepository;
import cn.com.leadu.fms.data.postbiz.repository.TransferInfoRepository;
import cn.com.leadu.fms.data.postbiz.repository.VehicleDisposalRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static cn.com.leadu.fms.common.constant.enums.BizStatusEnums.CONTRACT_EFFECT;


/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentService
 * @Description: 提前还款业务实现层
 * @date 2018-05-10
 */
@Slf4j
@Service
public class ContPrepaymentServiceImpl implements ContPrepaymentService {

    /**
     * 获取系统常量
     */
    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Fields  : 业务编号管理
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 系统常量调用rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 还款逾期罚息rpc
     */
    @Autowired
    private ContOverdueRpc contOverdueRpc;

    /**
     * @Fields  : 融资合同还款计划rpc
     */
    @Autowired
    private ContRepaySkedRpc contRepaySkedRpc;

    /**
     * @Fields  : 合同融资信息rpc
     */
    @Autowired
    ContractFinanceRpc contractFinanceRpc;

    /**
     * @Fields  : 提前还款审批service
     */
    @Autowired
    private ContPrepaymentApproveService contPrepaymentApproveService;

    /**
     * @Fields  : 提前还款repository
     */
    @Autowired
    private ContPrepaymentRepository contPrepaymentRepository;

    /**
     * @Fields  : 提前还款明细seervice
     */
    @Autowired
    private ContPrepayDetailService contPrepayDetailService;

    /**
     * @Fields  : 财务勾稽repository
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Fields  : 财务收款repository
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    /**
     * @Fields  : 财务待收款repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;

    /**
     * @Fields  : 通用pdfservice
     * @author qiaomengnan
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * @Fields  : 财务付款Repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 车辆处置Repository
     */
    @Autowired
    private VehicleDisposalRepository vehicleDisposalRepository;

    /**
     * @Fields  : 过户信息Repository
     */
    @Autowired
    private TransferInfoRepository transferInfoRepository;

    /**
     * @Fields  : 附件处理Service
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields  : 客户费用Service
     */
    @Autowired
    private ContCostRepository contCostRepository;

    /**
     * @Title:
     * @Description: 分页查询提前还款
     * @param contPrepaymentVo
     * @return PageInfoExtend<ContPrepayment>
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public PageInfoExtend<ContPrepayment> findContPrepaymentsByPage(ContPrepaymentVo contPrepaymentVo){
        Example example = SqlUtil.newExample(ContPrepayment.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContPrepayment> pageInfo = contPrepaymentRepository.selectListByExamplePage(example,contPrepaymentVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param contPrepaymentVo
     * @Description: 分页查询提前还款vo
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/10 19:57
     */
    @Override
    public PageInfoExtend<ContPrepaymentVo> findContPrepaymentListByPage(ContPrepaymentVo contPrepaymentVo) {

        //客户姓名
        if(StringUtils.isTrimBlank(contPrepaymentVo.getName()))
            contPrepaymentVo.setName(null);
        else
            contPrepaymentVo.setName(SqlUtil.likePattern(contPrepaymentVo.getName()));

        //合同编号
        if(StringUtils.isTrimBlank(contPrepaymentVo.getContNo()))
            contPrepaymentVo.setContNo(null);
        else
            contPrepaymentVo.setContNo(SqlUtil.likePattern(contPrepaymentVo.getContNo()));

        //出租人区域
        if(StringUtils.isTrimBlank(contPrepaymentVo.getGroupDistrict()))
            contPrepaymentVo.setGroupDistrict(null);
        else
            contPrepaymentVo.setGroupDistrict(SqlUtil.likePattern(contPrepaymentVo.getGroupDistrict()));

        //还款状态
        if(StringUtils.isTrimBlank(contPrepaymentVo.getPaymentStsForSer()))
            contPrepaymentVo.setPaymentStsForSer(null);
        else
            contPrepaymentVo.setPaymentStsForSer(contPrepaymentVo.getPaymentStsForSer());

        //车架号
        if(StringUtils.isTrimBlank(contPrepaymentVo.getVinNo()))
            contPrepaymentVo.setVinNo(null);
        else
            contPrepaymentVo.setVinNo(SqlUtil.likePattern(contPrepaymentVo.getVinNo()));

        //设置合同状态（合同生效(财务已付款)）
        contPrepaymentVo.setBizStatus(CONTRACT_EFFECT.getType());

        //设置个人标志
        contPrepaymentVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());
        //设置企业标志
        contPrepaymentVo.setCompanyFlag(ApplyTypeEnums.COMPANY.getType());
        //还款状态不是自动结清
        contPrepaymentVo.setPaymentSts(PaymentStsEnums.AUTOMATIC_CLEARING.getType());
        /*//（不等于）提前还款作废状态
        contPrepaymentVo.setPrepaymentSts(BizStatusEnums.CONT_PREPAYMENT_INVALID.getType());*/

        PageInfoExtend<ContPrepaymentVo> pageInfo = contPrepaymentRepository.selectListVoByPage("selectContPrepaymentListByPage", contPrepaymentVo, contPrepaymentVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存提前还款
     * @param contPrepaymentSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public void saveContPrepayment(ContPrepaymentSaveVo contPrepaymentSaveVo){
        contPrepaymentRepository.insertData(contPrepaymentSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改提前还款
     * @param contPrepaymentModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public void modifyContPrepayment(ContPrepaymentModifyVo contPrepaymentModifyVo){
        contPrepaymentRepository.updateByPrimaryKeySelectiveData(contPrepaymentModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contPrepaymentId删除提前还款
     * @param contPrepaymentDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public void deleteContPrepayment(ContPrepaymentDeleteVo contPrepaymentDeleteVo){
        contPrepaymentRepository.deleteData(contPrepaymentDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contPrepaymentId集合删除提前还款
     * @param contPrepaymentDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public void deleteContPrepaymentsByContPrepaymentIds(ContPrepaymentDeleteListVo contPrepaymentDeleteListVo){
        contPrepaymentRepository.deleteDataList(contPrepaymentDeleteListVo.getContPrepaymentIds(),contPrepaymentDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据contPrepaymentId获取提前还款
     * @param contPrepaymentId
     * @return ContPrepayment
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public ContPrepayment findContPrepaymentByContPrepaymentId(String contPrepaymentId){
        return contPrepaymentRepository.selectByPrimaryKey(contPrepaymentId);
    }

    /**
     * @param contNo
     * @Description: 根据合同编号获取提前还款信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/11 14:57
     */
    @Override
    public ContPrepayment findContPrepaymentByContNo(String contNo) {
        Example example = SqlUtil.newExample(ContPrepayment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo",contNo);
        criteria.andNotEqualTo("prepaymentSts",BizStatusEnums.CONT_PREPAYMENT_INVALID.getType());
        return contPrepaymentRepository.selectOneByExample(example);
    }

    /**
     * @param contPrepaymentNo
     * @Description: 根据业务号获取提前还款信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/20 17:22
     */
    @Override
    public ContPrepayment findContPrepaymentByContPrepaymentNo(String contPrepaymentNo) {
        Example example = SqlUtil.newExample(ContPrepayment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contPrepaymentNo",contPrepaymentNo);
        return contPrepaymentRepository.selectOneByExample(example);
    }

    /** 
    * @Description: 根据合同编号查询提前还款vo
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/23 11:29
    */ 
    @Override
    public ContPrepaymentVo findContPrepaymentVoByContNo(String contNo){
        if(StringUtils.isTrimBlank(contNo)){
            throw new FmsServiceException("合同号不能为空");
        }
        ContPrepaymentVo contPrepaymentVo = new ContPrepaymentVo();
        contPrepaymentVo.setContNo(contNo);
        //设置合同状态（合同生效(财务已付款)）
        contPrepaymentVo.setBizStatus(CONTRACT_EFFECT.getType());
        //（不等于）提前还款作废状态
        contPrepaymentVo.setPrepaymentSts(BizStatusEnums.CONT_PREPAYMENT_INVALID.getType());
        //查询提前还款信息
        ContPrepaymentVo contPrepaymentVoOld = contPrepaymentRepository.selectContPrepaymentByContNo(contPrepaymentVo);
        return contPrepaymentVoOld;
    }

    /**
    * @Description: 根据业务号查询提前还款vo
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/9/26 16:54
    */
    @Override
    public ContPrepaymentVo findContPrepaymentVoByContPrepaymentNo(String contPrepaymentNo) {
        if(StringUtils.isTrimBlank(contPrepaymentNo)){
            throw new FmsServiceException("业务号不能为空");
        }
        ContPrepaymentVo contPrepaymentVo = new ContPrepaymentVo();
        contPrepaymentVo.setContPrepaymentNo(contPrepaymentNo);
        //设置合同状态（合同生效(财务已付款)）
        contPrepaymentVo.setBizStatus(CONTRACT_EFFECT.getType());
        //查询提前还款信息
        ContPrepaymentVo contPrepaymentVoOld = contPrepaymentRepository.selectContPrepaymentByContNo(contPrepaymentVo);
        return contPrepaymentVoOld;
    }

    /**
     * @param contNo
     * @Description: 根据合同编号构造提前还款和提前还款明细信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/11 15:58
     */
    @Override
    public ContPrepaymentVo findContPrepaymentWithDetailByContNo(String contNo) {
        ContPrepaymentVo contPrepaymentVo;
        //查询提前还款信息是否存在
        ContPrepaymentVo contPrepaymentVoOld = this.findContPrepaymentVoByContNo(contNo);
        if(contPrepaymentVoOld == null){
            throw new FmsServiceException("获取合同信息失败");
        }else{
            contPrepaymentVo = contPrepaymentVoOld;
        }
        //根据提前还款编号获取付款信息
        findContPayByContPreepaymentNo(contPrepaymentVo);

        //提前还款的明细信息
        List<ContPrepayDetail> ContPrepayDetails = new ArrayList<>();

        int period = 0;//当前期数
        contPrepaymentVo.setPrepaymentDate(new Date());//还款日期默认当前日期
        contPrepaymentVo.setPrepaymentType("");
        //剩余本金
        try {
            ContRepaySked contRepaySked = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findContRepaySkedByContNo(contNo));
            if(contRepaySked == null){
                //租赁期限开始之前进行放款的，根据最近一期还款计划明细取得剩余本金失败,使用融资额
                contRepaySked = new ContRepaySked();
                contRepaySked.setRestPrincipal(contPrepaymentVo.getFinTotal());
                contRepaySked.setPeriod(0);
//                throw new FmsServiceException("获取融资合同还款计划信息失败");
            }
            period = contRepaySked.getPeriod();
            ContPrepayDetail contPrepayDetailPrincipal = new ContPrepayDetail();
            contPrepayDetailPrincipal.setPrepaymDetailItem(PrepaymDetailItemEnums.REST_PRINCIPAL.getType());
            contPrepayDetailPrincipal.setContNo(contNo);
            contPrepayDetailPrincipal.setPrepayTrialAmount(contRepaySked.getRestPrincipal());
            contPrepayDetailPrincipal.setPrepayActualAmount(contRepaySked.getRestPrincipal());
            contPrepayDetailPrincipal.setOrderNo(1);
            ContPrepayDetails.add(contPrepayDetailPrincipal);

            //违约金
            ContPrepayDetail contPrepayDetailLiquidatedDamages = new ContPrepayDetail();
            contPrepayDetailLiquidatedDamages.setPrepaymDetailItem(PrepaymDetailItemEnums.LIQUIDATED_DAMAGES.getType());
            contPrepayDetailLiquidatedDamages.setContNo(contNo);
            BigDecimal prepayTrialAmount = BigDecimal.ZERO;
            String liquidatedDamagesRate1 = commonConstantService.findSysParamValue(CommonParamConstants.LIQUIDATED_DAMAGES_RATE_1);//1-24期违约金比率
            String liquidatedDamagesRate2 = commonConstantService.findSysParamValue(CommonParamConstants.LIQUIDATED_DAMAGES_RATE_2);//24-48期违约金比率
            String liquidatedDamagesFloorAmoount = commonConstantService.findSysParamValue(CommonParamConstants.LIQUIDATED_DAMAGES_FLOOR_AMOOUNT);//提前还款违约金最小值
            if(1<=contRepaySked.getPeriod() && contRepaySked.getPeriod()<=24){
                prepayTrialAmount = ContPrepayDetails.get(0).getPrepayTrialAmount().multiply(new BigDecimal(liquidatedDamagesRate1)).setScale(2,BigDecimal.ROUND_HALF_UP);
            }else if(25<=contRepaySked.getPeriod()){
                prepayTrialAmount = ContPrepayDetails.get(0).getPrepayTrialAmount().multiply(new BigDecimal(liquidatedDamagesRate2)).setScale(2,BigDecimal.ROUND_HALF_UP);
            }
            if(prepayTrialAmount.compareTo(new BigDecimal(liquidatedDamagesFloorAmoount))<0){
                prepayTrialAmount = new BigDecimal(liquidatedDamagesFloorAmoount);
            }
            contPrepayDetailLiquidatedDamages.setPrepayTrialAmount(prepayTrialAmount);
            contPrepayDetailLiquidatedDamages.setPrepayActualAmount(prepayTrialAmount);
            contPrepayDetailLiquidatedDamages.setOrderNo(2);
            ContPrepayDetails.add(contPrepayDetailLiquidatedDamages);

        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("获取融资合同还款计划信息失败");
        } catch (NumberFormatException e){
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("字符串转数字有误，请检查提前还款相关系统常量配置");
        }
        //逾期租金
        try {
            BigDecimal overdueRent = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findContRepaySkedOverdueRentSum(contNo));
            if(overdueRent == null){
                overdueRent = new BigDecimal("0");
            }
            ContPrepayDetail contPrepayDetailOverdueRent = new ContPrepayDetail();
            contPrepayDetailOverdueRent.setPrepaymDetailItem(PrepaymDetailItemEnums.OVERDUE_RENT.getType());
            contPrepayDetailOverdueRent.setContNo(contNo);
            contPrepayDetailOverdueRent.setPrepayTrialAmount(overdueRent);
            contPrepayDetailOverdueRent.setPrepayActualAmount(overdueRent);
            contPrepayDetailOverdueRent.setOrderNo(3);
            ContPrepayDetails.add(contPrepayDetailOverdueRent);
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("获取逾期租金合计信息失败");
        }

        //逾期罚息
        try {
            BigDecimal overdueInterest = ResponseEntityUtils.getRestResponseData(contOverdueRpc.findOverdueInterestSum(contNo));
            if(overdueInterest == null){
                overdueInterest = new BigDecimal("0");
            }
            System.err.print(overdueInterest);
            ContPrepayDetail contPrepayDetailOverdueInterest = new ContPrepayDetail();
            contPrepayDetailOverdueInterest.setPrepaymDetailItem(PrepaymDetailItemEnums.OVERDUE_INTEREST.getType());
            contPrepayDetailOverdueInterest.setContNo(contNo);
            contPrepayDetailOverdueInterest.setPrepayTrialAmount(overdueInterest);
            contPrepayDetailOverdueInterest.setPrepayActualAmount(overdueInterest);
            contPrepayDetailOverdueInterest.setOrderNo(4);
            ContPrepayDetails.add(contPrepayDetailOverdueInterest);
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("获取逾期罚息信息失败");
        }

        //保证金
        BigDecimal deposit = contCostRepository.selectSumCostAmountByContNo(contPrepaymentVo.getContNo(), CostItemEnums.DEPOSIT.getType());
        deposit = deposit == null ? BigDecimal.ZERO : deposit;
        ContPrepayDetail contPrepayDetailSurplusDeposit = new ContPrepayDetail();
        contPrepayDetailSurplusDeposit.setPrepaymDetailItem(PrepaymDetailItemEnums.DEPOSIT.getType());
        contPrepayDetailSurplusDeposit.setContNo(contNo);
        contPrepayDetailSurplusDeposit.setPrepayTrialAmount(deposit);
        contPrepayDetailSurplusDeposit.setPrepayActualAmount(deposit);
        contPrepayDetailSurplusDeposit.setOrderNo(5);
        ContPrepayDetails.add(contPrepayDetailSurplusDeposit);

        //续保押金
        BigDecimal renewalDeposit = contPrepaymentVo.getRenewalDeposit();
        if(renewalDeposit == null){
            renewalDeposit = BigDecimal.ZERO;
        }
        ContPrepayDetail contPrepayDetailRenewalDeposit = new ContPrepayDetail();
        contPrepayDetailRenewalDeposit.setPrepaymDetailItem(PrepaymDetailItemEnums.RENEWAL_DEPOSIT.getType());
        contPrepayDetailRenewalDeposit.setContNo(contNo);
        contPrepayDetailRenewalDeposit.setPrepayTrialAmount(renewalDeposit);
        contPrepayDetailRenewalDeposit.setPrepayActualAmount(renewalDeposit);
        contPrepayDetailRenewalDeposit.setOrderNo(6);
        ContPrepayDetails.add(contPrepayDetailRenewalDeposit);

        if(!LicenseAttrEnums.LEASE_BACK.getType().equals(contPrepaymentVo.getLicenseAttr())){
            String transferDeposit;
            //过户保证金
            try {
                transferDeposit = ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.TRANSFER_DEPOSIT));

            } catch (FmsRpcException e) {
                log.error(e.getMessage());
                e.printStackTrace();
                throw new FmsServiceException("获取提前还款手续费信息失败");
            }
            ContPrepayDetail contPrepayDetailTransferDeposit = new ContPrepayDetail();
            contPrepayDetailTransferDeposit.setPrepaymDetailItem(PrepaymDetailItemEnums.TRANSFER_DEPOSIT.getType());
            contPrepayDetailTransferDeposit.setContNo(contNo);
            contPrepayDetailTransferDeposit.setPrepayTrialAmount(new BigDecimal(transferDeposit));
            contPrepayDetailTransferDeposit.setPrepayActualAmount(new BigDecimal(transferDeposit));
            contPrepayDetailTransferDeposit.setOrderNo(7);
            ContPrepayDetails.add(contPrepayDetailTransferDeposit);
        }

        // 收车费用
        BigDecimal recoveryCharge = vehicleDisposalRepository.selectRecoveryChargeByContNo(contNo, VehicleDisposalStatusEnums.TO_BE_DISPOSE.getType());
        if (recoveryCharge != null) {
            // 当前处置任务存在的场合，提前还款类型为“强制提前还款”
            contPrepaymentVo.setPrepaymentType(PrepaymentTypeEnums.FORCIBLY_PREPAYMENT.getType());
            // 提前还款明细：收车费用
            ContPrepayDetail contPrepayDetailRecovery = new ContPrepayDetail();
            contPrepayDetailRecovery.setPrepaymDetailItem(PrepaymDetailItemEnums.RECOVERY_CHARGE.getType());
            contPrepayDetailRecovery.setContNo(contNo);
            contPrepayDetailRecovery.setPrepayTrialAmount(recoveryCharge);
            contPrepayDetailRecovery.setPrepayActualAmount(recoveryCharge);
            contPrepayDetailRecovery.setOrderNo(8);
            ContPrepayDetails.add(contPrepayDetailRecovery);
        }

        //其他增项
        BigDecimal otherAdd = BigDecimal.ZERO;
        ContPrepayDetail contPrepayDetailOtherAdd = new ContPrepayDetail();
        contPrepayDetailOtherAdd.setPrepaymDetailItem(PrepaymDetailItemEnums.OTHER_ADD.getType());
        contPrepayDetailOtherAdd.setContNo(contNo);
        contPrepayDetailOtherAdd.setPrepayTrialAmount(otherAdd);
        contPrepayDetailOtherAdd.setPrepayActualAmount(otherAdd);
        contPrepayDetailOtherAdd.setOrderNo(9);
        ContPrepayDetails.add(contPrepayDetailOtherAdd);

        //其他减项
        BigDecimal otherSubtract = BigDecimal.ZERO;
        ContPrepayDetail contPrepayDetailOtherSubtract = new ContPrepayDetail();
        contPrepayDetailOtherSubtract.setPrepaymDetailItem(PrepaymDetailItemEnums.OTHER_SUBTRACT.getType());
        contPrepayDetailOtherSubtract.setContNo(contNo);
        contPrepayDetailOtherSubtract.setPrepayTrialAmount(otherSubtract);
        contPrepayDetailOtherSubtract.setPrepayActualAmount(otherSubtract);
        contPrepayDetailOtherSubtract.setOrderNo(10);
        ContPrepayDetails.add(contPrepayDetailOtherSubtract);

        contPrepaymentVo.setContPrepayDetails(ContPrepayDetails);

        //重新计算试算总金额
        BigDecimal prepayTrialAmount = new BigDecimal(0);
        //需要相减的数据
        String[] subtractList = {PrepaymDetailItemEnums.DEPOSIT.getType(),PrepaymDetailItemEnums.RENEWAL_DEPOSIT.getType(),
                PrepaymDetailItemEnums.OTHER_SUBTRACT.getType()};
        for (ContPrepayDetail contPrepayDetail:contPrepaymentVo.getContPrepayDetails()){
            if(ArrayUtils.equalsContains(subtractList,contPrepayDetail.getPrepaymDetailItem())){
                //相减
                prepayTrialAmount = prepayTrialAmount.subtract(contPrepayDetail.getPrepayTrialAmount());
            }else{
                //相加
                prepayTrialAmount = prepayTrialAmount.add(contPrepayDetail.getPrepayTrialAmount());
            }
        }
        contPrepaymentVo.setPrepayTrialAmount(prepayTrialAmount);

        //设置租金
        setRent(contNo, contPrepaymentVo,period);
        //获取过户任务信息
        TransferInfo transferInfo = findTransferInfoByContNo(contPrepaymentVo.getContNo());
        if (transferInfo != null) {
            // 过户任务号
            contPrepaymentVo.setTransferNo(transferInfo.getTransferNo());
            // 过户流程处理状态
            contPrepaymentVo.setTransferHandleSts(transferInfo.getTransferHandleSts());
            // 过户费用总额
            contPrepaymentVo.setTransferTotalCost(transferInfo.getTotalCost());
        }
        return contPrepaymentVo;
    }

    /**
    * @Description: 根据提前还款编号获取付款信息
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/9/26 16:37
    */
    private void findContPayByContPreepaymentNo(ContPrepaymentVo contPrepaymentVo) {
        //获取付款信息
        if(StringUtils.isNotTrimBlank(contPrepaymentVo.getContPrepaymentNo())){
            Example example = SqlUtil.newExample(ContPay.class);
            example.createCriteria().andEqualTo("bizCode",contPrepaymentVo.getContPrepaymentNo()).andEqualTo("paymentType", BizTypeEnums.PREPAYMENT.getType());
            ContPay contPay = contPayRepository.selectOneByExample(example);
            if(contPay != null){
                contPrepaymentVo.setPayAccBranch(contPay.getPayAccBranch());
                contPrepaymentVo.setPayAccountName(contPay.getPayAccountName());
                contPrepaymentVo.setPayAccountNo(contPay.getPayAccountNo());
                contPrepaymentVo.setRecAccBranch(contPay.getRecAccBranch());
                contPrepaymentVo.setRecAccountName(contPay.getRecAccountName());
                contPrepaymentVo.setRecAccountNo(contPay.getRecAccountNo());
            }
        }
    }

    /**
    * @Description: 设置租金
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/4 16:06
    */
    private void setRent(String contNo, ContPrepaymentVo contPrepaymentVo,int period) {
        List<ContRepaySked> contRepaySkedList = null;
        try {
            //查询当前还款计划表
            contRepaySkedList = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findAllContRepaySkedByContNo(contNo));
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("获取融资合同还款计划信息失败");
        }
        if(contRepaySkedList == null || contRepaySkedList.size()==0){
            throw new FmsServiceException("获取融资合同还款计划信息失败");
        }
        BigDecimal alreadyRepayAmount = BigDecimal.ZERO;//已还金额
        BigDecimal residueAmount = BigDecimal.ZERO;//剩余未还租金
        int alreadyRepayNper = 0;//已还期数
        for(ContRepaySked contRepaySked : contRepaySkedList){
            if(RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())//成功
                    /*|| RepayStatusEnums.PREPAYMENT.getType().equals(contRepaySked.getRepayStatus())*/){//已提前结清
                if(0 != contRepaySked.getPeriod()){//去掉首付那一期
                    alreadyRepayNper++;
                    alreadyRepayAmount = alreadyRepayAmount.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()));
                }
            }else{
                residueAmount = residueAmount.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()));
            }

            if(period+1 == contRepaySked.getPeriod()){//获取下一期
                Date nextPayDate = contRepaySked.getRepayDate();
                contPrepaymentVo.setValidityDate(DateUtils.getAddDay(nextPayDate,-1));
            }
        }
        contPrepaymentVo.setAlreadyRepayAmount(alreadyRepayAmount);
        contPrepaymentVo.setResidueAmount(residueAmount);
        contPrepaymentVo.setAlreadyRepayNper(alreadyRepayNper);
    }

    /**
     * @param contPrepaymentNo
     * @Description: 根据业务号查询提前还款和提前还款明细信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/11 15:58
     */
    @Override
    public ContPrepaymentVo findContPrepaymentWithDetailByContPrepaymentNo(String contPrepaymentNo) {
        if (StringUtils.isTrimBlank(contPrepaymentNo)) {
            throw new FmsServiceException("提前还款任务号不能为空");
        }
        ContPrepaymentVo contPrepaymentVo;
        //查询提前还款信息是否存在
        ContPrepaymentVo contPrepaymentVoOld = this.findContPrepaymentVoByContPrepaymentNo(contPrepaymentNo);
        if(contPrepaymentVoOld == null){
            throw new FmsServiceException("获取合同信息失败");
        }else{
            contPrepaymentVo = contPrepaymentVoOld;
        }
        //根据提前还款编号获取付款信息
        findContPayByContPreepaymentNo(contPrepaymentVo);

        //提前还款的明细信息
        List<ContPrepayDetail> ContPrepayDetails = new ArrayList<>();
        ContPrepayDetails = contPrepayDetailService.findContPrepayDetailVoByContPrepaymentNo(contPrepaymentVo.getContPrepaymentNo());
        contPrepaymentVo.setContPrepayDetails(ContPrepayDetails);
        // 获取过户任务信息
        TransferInfo transferInfo = findTransferInfoByContNo(contPrepaymentVo.getContNo());
        if (transferInfo != null) {
            // 过户任务号
            contPrepaymentVo.setTransferNo(transferInfo.getTransferNo());
            // 过户流程处理状态
            contPrepaymentVo.setTransferHandleSts(transferInfo.getTransferHandleSts());
            // 过户费用总额
            contPrepaymentVo.setTransferTotalCost(transferInfo.getTotalCost());
        }
        return contPrepaymentVo;
    }

    /**
     * @param contPrepaymentVo
     * @Description: 保存提前还款和明细
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 18:57
     */
    @Transactional
    @Override
    public void saveContPrepaymentWithDetail(ContPrepaymentVo contPrepaymentVo) {
        ContPrepaymentVo contPrepaymentVoOld = findContPrepaymentVoByContNo(contPrepaymentVo.getContNo());
        if(StringUtils.isTrimBlank(contPrepaymentVo.getTaskId())){
            if (StringUtils.isNotTrimBlank(contPrepaymentVoOld.getContPrepaymentNo())) {
                throw new FmsServiceException("此合同已生成提前还款申请，请勿重复申请");
            }
        }
        //获取合同融资信息
        ContractFinanceVo contractFinanceVo = findContractFinanceVoByContNo(contPrepaymentVo.getContNo());
        int nowDate = IntegerUtils.getIntValue(DateUtils.getCurrentDay());//当前日
        int repayDay = IntegerUtils.getIntValue(contractFinanceVo.getRepayDay());//每期支付日
        if(nowDate == repayDay){
            throw new FmsServiceException("还款日当天不能申请提前还款");
        }
        //保存提前还款表信息
        ContPrepayment contPrepaymentSaveVo = this.commonSave(contPrepaymentVo);
        //工作流引擎
        ActRuTaskVo actRuTaskVo = null;
        if(StringUtils.isTrimBlank(contPrepaymentVo.getTaskId())){//任务id为空，新开始工作流
            //工作流引擎
            actRuTaskVo = ActContPrepaymentUtils.startContPrepaymentAndSubmit(contPrepaymentSaveVo.getContPrepaymentNo(),"1",contPrepaymentVo.getContNo());
//            contPrepaymentSaveVo.setPrepaymentSts(actRuTaskVo.getTaskCode());//状态
//            contPrepaymentRepository.updateByPrimaryKeySelectiveData(contPrepaymentSaveVo);
        }else{//任务id不为空，继续工作流
            //流程引擎
            actRuTaskVo = ActContPrepaymentUtils.approvalAgree(contPrepaymentVo.getTaskId());
        }

        //日志记录,状态记录
        ContPrepaymentApproveVo contPrepaymentApproveVo = new ContPrepaymentApproveVo();
        contPrepaymentApproveVo.setContPrepaymentNo(contPrepaymentSaveVo.getContPrepaymentNo());
        contPrepaymentApproveVo.setUser(contPrepaymentVo.getUser());
        contPrepaymentApproveService.contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);
    }
    /** 
    * @Description: 保存提前还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/29 15:56
    */ 
    private ContPrepayment commonSave(ContPrepaymentVo contPrepaymentVo) {
        ContPrepayment contPrepaymentSaveVo = new ContPrepayment();
        contPrepaymentSaveVo.setContNo(contPrepaymentVo.getContNo());
        if(StringUtils.isTrimBlank(contPrepaymentVo.getContPrepaymentNo())){
            //设置新的任务号
            contPrepaymentSaveVo.setContPrepaymentNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.CONT_PREPAYMENT_NO.getType()));
        }else{
            contPrepaymentSaveVo.setContPrepaymentNo(contPrepaymentVo.getContPrepaymentNo());
        }
         //保存收款信息
        if(contPrepaymentVo.getPrepayActualAmount().compareTo(BigDecimal.ZERO)<0){
            if(StringUtils.isTrimBlank(contPrepaymentVo.getRecAccBranch())){
                throw new FmsServiceException("请选择收款信息");
            }
            Example example = SqlUtil.newExample(ContPay.class);
            example.createCriteria().andEqualTo("bizCode",contPrepaymentSaveVo.getContPrepaymentNo()).andEqualTo("paymentType",BizTypeEnums.PREPAYMENT.getType());
            ContPay contPay = contPayRepository.selectOneByExample(example);
            BigDecimal payAmount = contPrepaymentVo.getPrepayActualAmount() == null ? BigDecimal.ZERO : contPrepaymentVo.getPrepayActualAmount().abs();
            if(contPay != null){
                contPay.setPayAmount(payAmount); // 付款金额
                contPay.setRecAccBank(contPrepaymentVo.getRecAccBank()); // 收款银行
                contPay.setRecAccBranch(contPrepaymentVo.getRecAccBranch());
                contPay.setRecAccountName(contPrepaymentVo.getRecAccountName());
                contPay.setRecAccountNo(contPrepaymentVo.getRecAccountNo());
                contPayRepository.updateByExampleSelectiveData(contPay,example);
            }else{
                contPay = new ContPay();
                contPay.setBizCode(contPrepaymentSaveVo.getContPrepaymentNo());
                contPay.setPaymentType(BizTypeEnums.PREPAYMENT.getType());
                contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
                contPay.setPayAmount(payAmount); // 付款金额
                contPay.setRecAccBank(contPrepaymentVo.getRecAccBank()); // 收款银行
                contPay.setRecAccBranch(contPrepaymentVo.getRecAccBranch());
                contPay.setRecAccountName(contPrepaymentVo.getRecAccountName());
                contPay.setRecAccountNo(contPrepaymentVo.getRecAccountNo());
                contPayRepository.insertData(contPay);
            }
        }
        contPrepaymentSaveVo.setPrepaymentType(contPrepaymentVo.getPrepaymentType());
        contPrepaymentSaveVo.setPrepaymentDate(contPrepaymentVo.getPrepaymentDate());
        contPrepaymentSaveVo.setValidityDate(contPrepaymentVo.getValidityDate());
        contPrepaymentSaveVo.setAlreadyRepayNper(contPrepaymentVo.getAlreadyRepayNper());
        contPrepaymentSaveVo.setAlreadyRepayAmount(contPrepaymentVo.getAlreadyRepayAmount());
        contPrepaymentSaveVo.setResidueAmount(contPrepaymentVo.getResidueAmount());

        //重新计算试算总金额和实际总金额
        BigDecimal prepayTrialAmount = new BigDecimal(0);
        BigDecimal prepayActualAmount = new BigDecimal(0);
        //需要相减的数据
        String[] subtractList = {PrepaymDetailItemEnums.DEPOSIT.getType(),PrepaymDetailItemEnums.RENEWAL_DEPOSIT.getType(),
                PrepaymDetailItemEnums.OTHER_SUBTRACT.getType()};
        for (ContPrepayDetail contPrepayDetail:contPrepaymentVo.getContPrepayDetails()){
            //设置任务号
            contPrepayDetail.setContPrepaymentNo(contPrepaymentSaveVo.getContPrepaymentNo());
            if(ArrayUtils.equalsContains(subtractList,contPrepayDetail.getPrepaymDetailItem())){
                //相减
                prepayTrialAmount = prepayTrialAmount.subtract(contPrepayDetail.getPrepayTrialAmount());
                prepayActualAmount = prepayActualAmount.subtract(contPrepayDetail.getPrepayActualAmount());
            }else{
                //相加
                prepayTrialAmount = prepayTrialAmount.add(contPrepayDetail.getPrepayTrialAmount());
                prepayActualAmount = prepayActualAmount.add(contPrepayDetail.getPrepayActualAmount());
            }
        }
        if(BigDecimalUtils.getRoundHalfUpValue2(prepayTrialAmount).compareTo(contPrepaymentVo.getPrepayTrialAmount()) != 0){
            throw new FmsServiceException("提前还款试算总金额计算有误");
        }
        if(BigDecimalUtils.getRoundHalfUpValue2(prepayActualAmount).compareTo(contPrepaymentVo.getPrepayActualAmount()) != 0){
            throw new FmsServiceException("提前还款实际总金额计算有误");
        }
        contPrepaymentSaveVo.setPrepayTrialAmount(prepayTrialAmount);
        contPrepaymentSaveVo.setPrepayActualAmount(prepayActualAmount);
        ContPrepayment contPrepayment = this.findContPrepaymentByContPrepaymentNo(contPrepaymentSaveVo.getContPrepaymentNo());
        if(StringUtils.isTrimBlank(contPrepayment)){
            //保存提前还款表
            contPrepaymentRepository.insertData(contPrepaymentSaveVo);
            //保存明细
            contPrepayDetailService.saveDataList(contPrepaymentVo.getContPrepayDetails());
        }else{
            //修改提前还款表
            contPrepaymentSaveVo.setContPrepaymentId(contPrepayment.getContPrepaymentId());
            contPrepaymentRepository.updateByPrimaryKeySelectiveData(contPrepaymentSaveVo);
            //修改明细
            contPrepayDetailService.modifyByPrimaryKeySelectiveDataList(contPrepaymentVo.getContPrepayDetails());
        }

        //保存待收款合计
        ContCharge contChargeTotal = new ContCharge();
        contChargeTotal.setChargeBizType(BizTypeEnums.PREPAYMENT.getType());
        contChargeTotal.setChargeBizId(contPrepaymentSaveVo.getContPrepaymentNo());
        contChargeTotal.setChargeFund(PayFundNameEnums.PREPAYMENT.getType());
        contChargeTotal.setChargeAmount(prepayActualAmount);
        contChargeTotal.setChargeStatus(ChargeStatusEnums.TO_BE_COLLECTION.getType());
        contChargeTotal.setChargeDetailFlag(ChargeDetailFlagEnums.TOTAL.getType());
        if(StringUtils.isTrimBlank(contPrepaymentVo.getContPrepaymentId())){
            contChargeRepository.insertData(contChargeTotal);
        }else{
            Example example = SqlUtil.newExample(ContCharge.class);
            example.createCriteria().andEqualTo("chargeBizType",BizTypeEnums.PREPAYMENT.getType())
                .andEqualTo("chargeBizId",contPrepaymentSaveVo.getContPrepaymentNo());
            contChargeRepository.updateByExampleSelectiveData(contChargeTotal,example);
        }
        return contPrepaymentSaveVo;
    }

    /**
     * @Title
     * @Description: 财务确认(不使用)
     * @param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/14 18:57
     */
    @Transactional
    @Override
    public void financeConfirm(ContReceiptVo contReceiptVo) {
        /*if (CommonUtils.TrimBigDecimal(contReceiptVo.getRestAmount()).compareTo(CommonUtils
                .TrimBigDecimal(contReceiptVo.getFinanceConfirmAmount())) >= 0){
            ContPrepayment contPrepayment = findContPrepaymentByContNo(contReceiptVo.getContNo());
            //登录财务勾稽表
            ContReceiptExam contReceiptExam = new ContReceiptExam();
            contReceiptExam.setReceiptBizType("2");//2-提前还款
            if (contPrepayment != null){
                contReceiptExam.setReceiptBizId(contPrepayment.getContPrepaymentId());
            }
            contReceiptExam.setContReceiptId(contReceiptVo.getContReceiptId());
            contReceiptExam.setReceiptExamStatus("1");//1-已勾稽
            contReceiptExam.setReceiptExamAmount(contReceiptVo.getFinanceConfirmAmount());
            contReceiptExamRepository.insertData(contReceiptExam);
            //更新财务收款表的剩余金额
            Example example = SqlUtil.newExample(ContReceipt.class);
            example.createCriteria().andEqualTo("contReceiptId", contReceiptVo.getContReceiptId());
            ContReceipt contReceipt = contReceiptRepository.selectOneByExample(example);
            if (contReceipt != null){
                contReceipt.setRestAmount(CommonUtils.TrimBigDecimal(contReceipt.getRestAmount())
                        .subtract(CommonUtils.TrimBigDecimal(contReceiptVo.getFinanceConfirmAmount())));
                contReceiptRepository.updateByPrimaryKeySelectiveData(contReceipt);
            }

            //流程引擎
            ActRuTaskVo actRuTaskVo = ActContPrepaymentUtils.approvalAgree(contReceiptVo.getTaskId());
            //财务确认通过
            ContPrepaymentApproveVo contPrepaymentApproveVo = new ContPrepaymentApproveVo();
            contPrepaymentApproveVo.setContNo(contReceiptVo.getContNo());
            contPrepaymentApproveVo.setUser(contReceiptVo.getUser());
            contPrepaymentApproveService.contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);

        }else{
            throw new FmsServiceException("剩余金额不足，不能勾稽");
        }*/
    }


    /** 
    * @Description: 打印提前还款 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/28 17:43
    */ 
    @Override
    @Transactional
    public String printPrepayment(ContPrepaymentVo contPrepaymentVo) {
        String contNo = contPrepaymentVo.getContNo();
        //先暂存
//        this.commonSave(contPrepaymentVo);
//        contPrepaymentVo = this.findContPrepaymentWithDetailByContNo(contNo);
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(contPrepaymentVo);
        BigDecimal totalRepay = BigDecimal.ZERO;//应还款总额
        BigDecimal totalRefund = BigDecimal.ZERO;//应退款总额
        BigDecimal totalPay = BigDecimal.ZERO;//应付款总额
        //提前还款明细数据
        //需要相减的数据
        String[] subtractList = {PrepaymDetailItemEnums.DEPOSIT.getType(),PrepaymDetailItemEnums.RENEWAL_DEPOSIT.getType(),
                PrepaymDetailItemEnums.OTHER_SUBTRACT.getType()};
        for(ContPrepayDetail contPrepayDetail : contPrepaymentVo.getContPrepayDetails()){
            pdfVariables.put(contPrepayDetail.getPrepaymDetailItem(), BigDecimalUtils.getNotNullString(contPrepayDetail.getPrepayActualAmount()));

            if(ArrayUtils.equalsContains(subtractList,contPrepayDetail.getPrepaymDetailItem())){
                //累加所有应退款项
                totalRefund = totalRefund.add(BigDecimalUtils.getNotNullBigDecimal(contPrepayDetail.getPrepayActualAmount()));
            }else{
                //累加所有应还款项
                totalRepay = totalRepay.add(BigDecimalUtils.getNotNullBigDecimal(contPrepayDetail.getPrepayActualAmount()));
            }
        }
        // 如果有收车费用,把收车费用赋值给其他费用
        if(StringUtils.isExits(pdfVariables.get(PrepaymDetailItemEnums.RECOVERY_CHARGE.getType()))){
            pdfVariables.put(PrepaymDetailItemEnums.OTHER_ADD.getType(),pdfVariables.get(PrepaymDetailItemEnums.RECOVERY_CHARGE.getType()));
        }
        //计算最终应还款
        totalPay = totalRepay.subtract(totalRefund);

        pdfVariables.put("totalRepay", totalRepay.toString());
        pdfVariables.put("totalRefund", totalRefund.toString());
        pdfVariables.put("totalPay", totalPay.toString());

        pdfVariables.put("nowDate1", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        pdfVariables.put("nowDate2", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        pdfVariables.put("rentCompany", StringUtils.defaultString(contPrepaymentVo.getRentPerson()));
        pdfVariables.put("addr", "地址:"+StringUtils.defaultString(contPrepaymentVo.getRegisteredAddr())
                +"客服电话：400-0000-564");
        ContRepaySked contRepaySked = null;
        List<ContRepaySked> contRepaySkedList = null;
        try {
            //查询当前还款计划表
            contRepaySked = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findContRepaySkedByContNo(contNo));
            contRepaySkedList = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findAllContRepaySkedByContNo(contNo));
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("获取融资合同还款计划信息失败");
        }
        if(contRepaySked == null){
            throw new FmsServiceException("获取融资合同还款计划信息失败");
        }
        //获取合同融资信息
        ContractFinanceVo contractFinanceVo = findContractFinanceVoByContNo(contPrepaymentVo.getContNo());
        //期数
        int period = Integer.valueOf(contractFinanceVo.getFinPeriodType())/Integer.valueOf(contractFinanceVo.getRepayRate());
        //去除首付和尾付(尾付期数：period+1)
        contRepaySkedList = contRepaySkedList.stream().filter(s -> 0 != s.getPeriod() && period+1 != s.getPeriod()).collect(Collectors.toList());
        String overPeriod = "";//逾期数
        for(ContRepaySked sked : contRepaySkedList){
            if(OverDueStatusEnums.ALREADY_OVERDUE.getType().equals(sked.getRepayStatus())){
                overPeriod = overPeriod+"第"+sked.getPeriod()+"期（"+sked.getRepayDate()+"） ";
            }
        }
        pdfVariables.put("overdueRentRemark", overPeriod);
        pdfVariables.put("restPrincipalRemark", "第"+(contRepaySked.getPeriod()+1)
                +"-"+contRepaySkedList.get(contRepaySkedList.size()-1).getPeriod()
                +"期（"+DateUtils.dateToStr(contRepaySked.getRepayDate(),DateUtils.formatStr_yyyyMMdd)
                +"至"+DateUtils.dateToStr(contRepaySkedList.get(contRepaySkedList.size()-1).getRepayDate(),DateUtils.formatStr_yyyyMMdd)+"）");
        pdfVariables.put("liquidatedDamagesRemark", "根据合同约定产生相应提前还款罚息");
        pdfVariables.put("overdueInterestRemark", "因客户逾期产生逾期违约金");
        pdfVariables.put("otherAddRemark", "因客户严重逾期产生的收回车辆产生费用");
        pdfVariables.put("totalPayRemark", "其中"+commonConstantService.findSysParamValue(CommonParamConstants.TRANSFER_DEPOSIT) +"元，车辆过户后可以退还");
        pdfVariables.put("firstRepayDate", DateUtils.dateToStr(contRepaySkedList.get(0).getRepayDate(),DateUtils.formatStr_yyyyMMdd));//起租日

        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PREPAYMENT_TQHK.getType());
        return filePath;
    }

    /**
    * @Description: 获取合同融资信息
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/27 18:57
    */
    private ContractFinanceVo findContractFinanceVoByContNo(String contNo) {
        //取得合同融资信息，生成还款计划表
        ContractFinanceVo contractFinanceVo = null;
        try {
            contractFinanceVo = ResponseEntityUtils.getRestResponseData(contractFinanceRpc.findContractFinanceVoByContNo(contNo));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("获取合同融资信息失败");
        }
        if(contractFinanceVo == null){
            throw new FmsServiceException("获取合同融资信息失败");
        }
        return contractFinanceVo;
    }

    /**
     * @param contPrepaymentNo
     * @Description: 打印提前还款结清证明
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/29 18:17
     */
    @Override
    public String printPrepaymentJQZM(String contPrepaymentNo) {
        ContPrepaymentVo contPrepaymentVo = this.findContPrepaymentWithDetailByContPrepaymentNo(contPrepaymentNo);
        if(contPrepaymentVo == null){
            throw new FmsServiceException("提前还款数据未找到");
        }
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(contPrepaymentVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        pdfVariables.put("rentCompany", StringUtils.defaultString(contPrepaymentVo.getRentPerson()));
        pdfVariables.put("rentCompany"+1, StringUtils.defaultString(contPrepaymentVo.getRentPerson()));
        pdfVariables.put("addr", StringUtils.defaultString(contPrepaymentVo.getRegisteredAddr()));
        pdfVariables.put("addr_1", StringUtils.defaultString(contPrepaymentVo.getRegisteredAddr()));
        pdfVariables.put("tel", "电话：400-0000-564");
        pdfVariables.put("website", "官网：www.winline.cn");
        pdfVariables.put("name_1", contPrepaymentVo.getName());
        pdfVariables.put("certifNo_1", contPrepaymentVo.getCertifNo());
        pdfVariables.put("contNo_1", contPrepaymentVo.getContNo());

        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PREPAYMENT_JQZM.getType());
        return filePath;
    }
    /**
     * @param contPrepaymentApproveVo
     * @Description: 打印付款单
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/8/27 18:17
     */
    public String printPaymentOrder(ContPrepaymentApproveVo contPrepaymentApproveVo){
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(contPrepaymentApproveVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        //付款金额合计
        if(contPrepaymentApproveVo.getPrepayActualAmount()!=null){
            pdfVariables.put("totalShouldPay", StringUtils.defaultString(StringUtils.getValue(Math.abs(contPrepaymentApproveVo.getPayActualAmount().floatValue()))));
        }
        // 过户费用总额
        pdfVariables.put("transferCost", StringUtils.defaultString(StringUtils.getValue(BigDecimalUtils.getNotNullBigDecimal(contPrepaymentApproveVo.getTransferTotalCost()).floatValue())));
        // 获取付款明细信息
        pdfVariables.put("recoveryCharge", StringUtils.defaultString(StringUtils.getValue(BigDecimal.ZERO.floatValue())));// 收车费用
        List<ContPrepayDetail> contPrepayDetailList = contPrepayDetailService.findContPrepayDetailVoByContPrepaymentNo(contPrepaymentApproveVo.getContPrepaymentNo());
        if (ArrayUtils.isNotNullAndLengthNotZero(contPrepayDetailList)) {
            for (ContPrepayDetail contPrepayDetail : contPrepayDetailList) {
                pdfVariables.put(contPrepayDetail.getPrepaymDetailItem()
                        , StringUtils.defaultString(StringUtils.getValue(BigDecimalUtils.getNotNullBigDecimal(contPrepayDetail.getPrepayActualAmount()).floatValue())));
            }
        }
        // 付款银行信息，收款银行信息，客户信息
        pdfVariables.put("payAccountName", contPrepaymentApproveVo.getPayAccountName());
        pdfVariables.put("payAccountNo", contPrepaymentApproveVo.getPayAccountNo());
        pdfVariables.put("payAccBranch", contPrepaymentApproveVo.getPayAccBranch());
        pdfVariables.put("recAccBranch", contPrepaymentApproveVo.getRecAccBranch());
        pdfVariables.put("recAccountName", contPrepaymentApproveVo.getRecAccountName());
        pdfVariables.put("recAccountNo", contPrepaymentApproveVo.getRecAccountNo());
        pdfVariables.put("lessor", contPrepaymentApproveVo.getRentPerson());
        pdfVariables.put("name", contPrepaymentApproveVo.getName());//承租人
        pdfVariables.put("vinNo", contPrepaymentApproveVo.getVinNo());//车架号
        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_CONT_PREPAYMENT.getType());
        return filePath;
    }

    /**
     * @Description: 车辆出库(赎回)
     * @param: vehicleDisposalVo 车辆出库信息
     * @return:
     * @Author: wangxue
     * @Date: 2018/5/14 18:57
     */
    @Override
    @Transactional
    public void prePayVehicleShipment(VehicleDisposalVo vehicleDisposalVo) {
        ContPrepayment contPrepayment = findContPrepaymentByContPrepaymentNo(vehicleDisposalVo.getDisposalTaskNo());
        if(contPrepayment == null){
            throw new FmsServiceException( "提前还款申请信息不存在");
        }
        // 获取待处置的车辆处置任务
        VehicleDisposal vehicleDisposal = findVehicleDisposalByContNo(contPrepayment.getContNo());
        if (vehicleDisposal == null) {
            throw new FmsServiceException("车辆处置任务不存在");
        }
        VehicleDisposal modifyVehicleDisposal = new VehicleDisposal();
        // 车辆处置状态 ：已出库
        modifyVehicleDisposal.setVehicleDisposalStatus(VehicleDisposalStatusEnums.OUT_STORAGE.getType());
        modifyVehicleDisposal.setShipmentDate(vehicleDisposalVo.getShipmentDate());
        modifyVehicleDisposal.setAgent(vehicleDisposalVo.getAgent());
        modifyVehicleDisposal.setAgentMobileNo(vehicleDisposalVo.getAgentMobileNo());
        modifyVehicleDisposal.setVehicleDisposalId(vehicleDisposal.getVehicleDisposalId());
        vehicleDisposalRepository.updateByPrimaryKeySelectiveData(modifyVehicleDisposal);
        // 保存附件信息
        bizFilesService.modifyBizFilesList(vehicleDisposalVo.getBizFilesList(), vehicleDisposalVo.getDisposalTaskNo(), BizCodeTypeEnums.VEHICLE_EXPORT_FILE.getCodeType());
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContPrepaymentUtils.approvalAgree(vehicleDisposalVo.getTaskId());
        // 更新提前还款任务状态，登录流程日志
        ContPrepaymentApproveVo contPrepaymentApproveVo = new ContPrepaymentApproveVo();
        contPrepaymentApproveVo.setContPrepaymentNo(vehicleDisposalVo.getDisposalTaskNo());
        contPrepaymentApproveVo.setUser(vehicleDisposalVo.getUser());
        contPrepaymentApproveVo.setMemo(vehicleDisposalVo.getRemark());
        contPrepaymentApproveService.contPrepaymentApproveCommon(contPrepaymentApproveVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);
    }

    /**
     * @Description: 根据处置任务号，获取车辆处置信息(待处置)
     * @param: disposalTaskNo 处置任务号
     * @return:
     * @Author: wangxue
     * @Date: 2018/5/14 18:57
     */
    @Override
    public VehicleDisposal findVehicleDisposalByContNo(String contNo) {
        Example example = new Example(VehicleDisposal.class);
        example.createCriteria().andEqualTo("contNo", contNo).andEqualTo("disposalStatus", DisposalStatusEnums.REDEMPTION.getType())
            .andEqualTo("vehicleDisposalStatus", VehicleDisposalStatusEnums.TO_BE_DISPOSE.getType());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return vehicleDisposalRepository.selectOneByExample(example);
    }

    /**
     * @Description: 根据合同编号，获取车辆的过户任务信息
     * @param: contNo 合同编号
     * @return:
     * @Author: wangxue
     * @Date: 2018/5/14 18:57
     */
    public TransferInfo findTransferInfoByContNo(String contNo) {
        Example example = new Example(TransferInfo.class);
        example.createCriteria().andEqualTo("contNo", contNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return transferInfoRepository.selectOneByExample(example);
    }
}
