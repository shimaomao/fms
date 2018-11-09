package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonFinancialVoucherDataService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.vo.CommonFinVouData;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.FinVouDetailValueConstants;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContOverdueRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.data.prebiz.repository.GuaranteeCompRepository;
import cn.com.leadu.fms.data.prebiz.repository.GuaranteePersRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.finance.rpc.baseinfo.BasBankInfoRpc;
import cn.com.leadu.fms.finance.rpc.prebiz.ContractRpc;
import cn.com.leadu.fms.finance.rpc.system.SysParamRpc;
import cn.com.leadu.fms.finance.service.ContRepaySkedService;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.ContRepaySkedDeleteListVo;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.ContRepaySkedDeleteVo;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.ContRepaySkedModifyVo;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.ContRepaySkedSaveVo;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static cn.com.leadu.fms.common.constant.enums.finance.OverDueStatusEnums.ALREADY_OVERDUE;

/**
 * @author lijunjun
 * @ClassName: ContRepaySkedService
 * @Description:  融资合同还款计划信息业务实现层
 * @date 2018-05-08
 */
@Slf4j
@Service
public class ContRepaySkedServiceImpl implements ContRepaySkedService {

    /**
     * @Fields  :  融资合同还款计划信息repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 逾期罚息repository
     */
    @Autowired
    private ContOverdueRepository contOverdueRepository;

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
     * @Fields  : 系统常量调用rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    @Autowired
    private ContractRpc contractRpc;

    /**
     * 银行信息维护rpc
     */
    @Autowired
    private BasBankInfoRpc basBankInfoRpc;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private GuaranteeCompRepository guaranteeCompRepository;

    @Autowired
    private GuaranteePersRepository guaranteePersRepository;

    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Fields  : 财务凭证明细共通
     * @author qiaomengnan
     */
    @Autowired
    private CommonFinancialVoucherDataService commonFinancialVoucherDataService;

    /**
     * @Fields  : 业务编号管理
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Title:
     * @Description: 分页查询 融资合同还款计划信息
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedsByPage(ContRepaySkedVo contRepaySkedVo){
        // 合同编号做模糊处理
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getGroupDistrict())){
            contRepaySkedVo.setGroupDistrict(SqlUtil.likePattern(contRepaySkedVo.getGroupDistrict()));
        } else {
            contRepaySkedVo.setGroupDistrict(null);
        }
        //还款开始时间
        if(StringUtils.isTrimBlank(contRepaySkedVo.getRepayDateSearchStart())){
            contRepaySkedVo.setRepayDateSearchStart(null);
        }
        //还款结束时间
        if(StringUtils.isTrimBlank(contRepaySkedVo.getRepayDateSearchEnd())){
            contRepaySkedVo.setRepayDateSearchEnd(null);
        }
        //款项类型
        if(StringUtils.isTrimBlank(contRepaySkedVo.getReceiptBizType())){
            contRepaySkedVo.setReceiptBizType(null);
        }
        //客户姓名
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getName()))
            contRepaySkedVo.setName(SqlUtil.likePattern(contRepaySkedVo.getName()));
        else
            contRepaySkedVo.setName(null);
        //车架号
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getVinNo())){
            contRepaySkedVo.setVinNo(SqlUtil.likePattern(contRepaySkedVo.getVinNo()));
        }else{
            contRepaySkedVo.setVinNo(null);
        }
        //应收金额
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getRentActual())){
            contRepaySkedVo.setRentActual(contRepaySkedVo.getRentActual());
        }else{
            contRepaySkedVo.setRentActual(null);
        }
        //实际还款日期
        if(StringUtils.isTrimBlank(contRepaySkedVo.getReceiptDateSearch())){
            contRepaySkedVo.setReceiptDateSearch(null);
        }
        //合同号
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getContNo())){
            contRepaySkedVo.setContNo(SqlUtil.likePattern(contRepaySkedVo.getContNo()));
        }else{
            contRepaySkedVo.setContNo(null);
        }
        //申请类型
        if(StringUtils.isTrimBlank(contRepaySkedVo.getCompanyType1()))
            contRepaySkedVo.setCompanyType1(null);
        else
            contRepaySkedVo.setCompanyType1(contRepaySkedVo.getCompanyType1());

        //分类
        if(StringUtils.isTrimBlank(contRepaySkedVo.getCompanyType2()))
            contRepaySkedVo.setCompanyType2(null);
        else
            contRepaySkedVo.setCompanyType2(contRepaySkedVo.getCompanyType2());
        //扣款状态
        List<String> repayStatusList = new ArrayList<>();
        repayStatusList.add(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());//成功
        repayStatusList.add(RepayStatusEnums.PREPAYMENT.getType());//已提前结清
        contRepaySkedVo.setRepayStatusList(repayStatusList);
        PageInfoExtend<ContRepaySkedVo> pageInfo = contRepaySkedRepository.selectListVoByPage("selectContRepaySkedsByPage", contRepaySkedVo, contRepaySkedVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 分页查询 融资合同还款计划信息
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    public PageInfoExtend<ContRepaySkedVo> findContReceiptDetailsByPage(ContRepaySkedVo contRepaySkedVo){
        //业务类型
//        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getLicenseAttr()))
//            contRepaySkedVo.setLicenseAttr(contRepaySkedVo.getLicenseAttr());
//        else
//            contRepaySkedVo.setLicenseAttr(null);
        //还款日开始时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getStartTime()))
            contRepaySkedVo.setStartTime(contRepaySkedVo.getStartTime());
        else
            contRepaySkedVo.setStartTime(null);
        //还款日结束时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getEndTime()))
            contRepaySkedVo.setEndTime(contRepaySkedVo.getEndTime());
        else
            contRepaySkedVo.setEndTime(null);

        //到账日期开始时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getStartTime2()))
            contRepaySkedVo.setStartTime2(contRepaySkedVo.getStartTime2());
        else
            contRepaySkedVo.setStartTime2(null);
        //到账日期结束时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getEndTime2()))
            contRepaySkedVo.setEndTime2(contRepaySkedVo.getEndTime2());
        else
            contRepaySkedVo.setEndTime2(null);
        //款项类型
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getReceiptBizType()))
            contRepaySkedVo.setReceiptBizType(contRepaySkedVo.getReceiptBizType());
        else
            contRepaySkedVo.setReceiptBizType(null);

        //凭证状态
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getVoucherStatus()))
            contRepaySkedVo.setVoucherStatus(contRepaySkedVo.getVoucherStatus());
        else
            contRepaySkedVo.setVoucherStatus(null);

        //区域
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getGroupDistrict()))
            contRepaySkedVo.setGroupDistrict(SqlUtil.likePattern(contRepaySkedVo.getGroupDistrict()));
        else
            contRepaySkedVo.setGroupDistrict(null);
        //客户姓名
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getName()))
            contRepaySkedVo.setName(SqlUtil.likePattern(contRepaySkedVo.getName()));
        else
            contRepaySkedVo.setName(null);
        //扣款状态
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getRepayStatus()))
            contRepaySkedVo.setRepayStatus(contRepaySkedVo.getRepayStatus());
        else
            contRepaySkedVo.setRepayStatus(null);
        //车架号
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getVinNo())){
            contRepaySkedVo.setVinNo(SqlUtil.likePattern(contRepaySkedVo.getVinNo()));
        }else{
            contRepaySkedVo.setVinNo(null);
        }
        //实际还款日
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getReceDate())){
            contRepaySkedVo.setReceDate(contRepaySkedVo.getReceDate());
        }else{
            contRepaySkedVo.setReceDate(null);
        }
        //应收租金    需要处理
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getRent())){
            contRepaySkedVo.setRent(contRepaySkedVo.getRent());
        }else{
            contRepaySkedVo.setRent(null);
        }
        //开票日期
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getInvoDate())){
            contRepaySkedVo.setInvoDate(contRepaySkedVo.getInvoDate());
        }else{
            contRepaySkedVo.setInvoDate(null);
        }
        //开票备注
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getInvoiceMemo())){
            contRepaySkedVo.setInvoiceMemo(SqlUtil.likePattern(contRepaySkedVo.getInvoiceMemo()));
        }else{
            contRepaySkedVo.setInvoiceMemo(null);
        }
        //合同号
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getContNo())){
            contRepaySkedVo.setContNo(SqlUtil.likePattern(contRepaySkedVo.getContNo()));
        }else{
            contRepaySkedVo.setContNo(null);
        }
        //付款备注
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getMemo())){
            contRepaySkedVo.setMemo(SqlUtil.likePattern(contRepaySkedVo.getMemo()));
        }else{
            contRepaySkedVo.setMemo(null);
        }
        contRepaySkedVo.setApplyType(ApplyTypeEnums.PERSON.getType());
        PageInfoExtend<ContRepaySkedVo> pageInfo = contRepaySkedRepository.selectListVoByPage("selectContReceiptDetailsByPage", contRepaySkedVo, contRepaySkedVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 分页查询已认领详情
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedClaimeByPage(ContRepaySkedVo contRepaySkedVo){
        if(StringUtils.isTrimBlank(contRepaySkedVo.getReceiptBizType())){
            contRepaySkedVo.setReceiptBizType(null);
        }
        if(StringUtils.isTrimBlank(contRepaySkedVo.getRepaySkedId())){
            contRepaySkedVo.setRepaySkedId(null);
        }
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getReceiptBizType()) && ReceiptBizTypeEnums.REPAYMENT_AMOUNT.getType().equals(contRepaySkedVo.getReceiptBizType())){
            PageInfoExtend<ContRepaySkedVo> pageInfo = contRepaySkedRepository.selectListVoByPage("selectContRepaySkedClaimeByPage", contRepaySkedVo, contRepaySkedVo.getPageQuery());
            return pageInfo;
        } else {
            PageInfoExtend<ContRepaySkedVo> pageInfo = contRepaySkedRepository.selectListVoByPage("selectContRepaySkedClaimesByPage", contRepaySkedVo, contRepaySkedVo.getPageQuery());
            return pageInfo;
        }
    }

    /**
     * @Title:
     * @Description: 保存 融资合同还款计划信息
     * @param contRepaySkedSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    public void saveContRepaySked(ContRepaySkedSaveVo contRepaySkedSaveVo){
        contRepaySkedRepository.insertData(contRepaySkedSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 取消认领
     * @param contRepaySkedVo
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @Transactional
    public void cancelClaime(ContRepaySkedVo contRepaySkedVo){
        List<ContRepaySkedVo> contRepaySkedVoList = contRepaySkedVo.getContRepaySkedVoList();
        if(contRepaySkedVoList == null || (contRepaySkedVoList != null && contRepaySkedVoList.size() < 1)){
            throw  new FmsServiceException("请您选择需要取消认领的数据！");
        }
        List<ContReceipt> contReceiptList = new ArrayList<>();
        for (ContRepaySkedVo contRepaySkedVo1 : contRepaySkedVoList){
            Example example = SqlUtil.newExample(ContReceiptExam.class);
            example.createCriteria().andEqualTo("contReceiptExamId", contRepaySkedVo1.getContReceiptExamId());
            ContReceiptExam contReceiptExam = contReceiptExamRepository.selectOneByExample(example);
            //删除财务勾稽表
            contReceiptExamRepository.deleteData(contReceiptExam);
            if (contReceiptExam != null){
                Example example1 = SqlUtil.newExample(ContReceipt.class);
                example1.createCriteria().andEqualTo("contReceiptId", contReceiptExam.getContReceiptId());
                ContReceipt contReceipt = contReceiptRepository.selectOneByExample(example1);
                contReceipt.setRestAmount(TrimBigDecimal(contReceiptExam.getReceiptExamAmount()).add(TrimBigDecimal(contReceipt.getRestAmount())));
                contReceiptList.add(contReceipt);
            }
        }

        //更新财务付款表
        contReceiptRepository.updateByPrimaryKeySelectiveDataList(contReceiptList);
    }

    /**
     * @Title:
     * @Description: 修改 融资合同还款计划信息
     * @param contRepaySkedModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    public void modifyContRepaySked(ContRepaySkedModifyVo contRepaySkedModifyVo){
        contRepaySkedRepository.updateByPrimaryKeySelectiveData(contRepaySkedModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过repaySkedId删除 融资合同还款计划信息
     * @param contRepaySkedDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    public void deleteContRepaySked(ContRepaySkedDeleteVo contRepaySkedDeleteVo){
        contRepaySkedRepository.deleteData(contRepaySkedDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过repaySkedId集合删除 融资合同还款计划信息
     * @param contRepaySkedDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    public void deleteContRepaySkedsByRepaySkedIds(ContRepaySkedDeleteListVo contRepaySkedDeleteListVo){
        contRepaySkedRepository.deleteDataList(contRepaySkedDeleteListVo.getRepaySkedIds(),contRepaySkedDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据repaySkedId获取 融资合同还款计划信息
     * @param repaySkedId
     * @return ContRepaySked
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    public ContRepaySked findContRepaySkedByRepaySkedId(String repaySkedId){
        return contRepaySkedRepository.selectByPrimaryKey(repaySkedId);
    }

    /**
     * @Title:
     * @Description:  检查是否有合同还款逾期并做处理
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 15:46:43
     */
    @Override
    @Transactional
    public void checkContRepaySked() {
        //逾期时间判定条件
        Calendar calendar =  Calendar.getInstance();
        String jugDay = DateUtils.dateToStr(calendar.getTime(),DateUtils.formatStr_yyyyMMdd);
        Example example = SqlUtil.newExample(ContRepaySked.class);
        //example.createCriteria().andEqualTo("overdueStatus",NOT_OVERDUE.getType());
        Example.Criteria criteria = example.createCriteria();
        List<String> repayStatusList = new ArrayList<>();
        repayStatusList.add(RepayStatusEnums.TO_BE_WITHHELD.getType());
        repayStatusList.add(RepayStatusEnums.WITHDRAWING.getType());
        repayStatusList.add(RepayStatusEnums.WITHDRAWING_FAILURE.getType());
        criteria.andIn("repayStatus",repayStatusList);
       // criteria.andEqualTo("repayStatus",TO_BE_WITHHELD.getType()).orEqualTo("repayStatus",WITHDRAWING.getType()).orEqualTo("repayStatus",WITHDRAWING_FAILURE.getType());
        criteria.andLessThan("repayDate",jugDay);
        List<ContRepaySked> ContRepaySkedList = contRepaySkedRepository.selectListByExample(example);
        List<ContRepaySked> ContRepaySkedUpDateList = new ArrayList<>();  //逾期合同集合
        List<ContOverdue> contOverdueUpdateList = new ArrayList<>();
        List<ContOverdue> contOverdueSaveList = new ArrayList<>();
        String  overdueDayRate;
        try {
            overdueDayRate =   ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey("overdue_day_rate"));
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("逾期日利率获取失败");
        }

        //取到未逾期且扣款未成功的合同
         Date date = new Date();
        if(ArrayUtils.isNotNullAndLengthNotZero(ContRepaySkedList)){
            for(ContRepaySked contRepaySked:ContRepaySkedList){
                    Example ex1 = SqlUtil.newExample(ContOverdue.class);
                    ex1.createCriteria().andEqualTo("contNo",contRepaySked.getContNo()).andEqualTo("period",contRepaySked.getPeriod());
                    ContOverdue  contOverdue = contOverdueRepository.selectOneByExample(ex1);
                    Example example1 = SqlUtil.newExample(Contract.class);
                    example1.createCriteria().andEqualTo("contNo",contRepaySked.getContNo());
                    Contract contract = contractRepository.selectOneByExample(example1);
                    Example example2 = SqlUtil.newExample(GuaranteeComp.class);
                    example2.createCriteria().andEqualTo("applyNo",contract.getApplyNo());
                    List<GuaranteeComp> list1 = guaranteeCompRepository.selectListByExample(example2);

                    Example example3 = SqlUtil.newExample(GuaranteePers.class);
                    example3.createCriteria().andEqualTo("applyNo",contract.getApplyNo());
                    List<GuaranteePers> list2 = guaranteePersRepository.selectListByExample(example3);
                     String doubleOverdueDayRate;
                    if(ArrayUtils.isNotNullAndLengthNotZero(list1)||ArrayUtils.isNotNullAndLengthNotZero(list2)){
                         doubleOverdueDayRate = String.valueOf(Double.valueOf(overdueDayRate)*2);
                    }else{
                         doubleOverdueDayRate = overdueDayRate;
                    }
                    //逾期日利率
                    BigDecimal overDueDayRate = new BigDecimal(doubleOverdueDayRate);
                    //逾期天数
                    int days = (int) ((date.getTime() - contRepaySked.getRepayDate().getTime()) / (1000*3600*24));
                    //逾期利率 = 租金*日利率*天数
                    BigDecimal rent = contRepaySked.getRent().multiply(BigDecimalUtils.dividePercent(overDueDayRate)).multiply(new BigDecimal(days)).setScale(0,BigDecimal.ROUND_UP);

                    if(contOverdue!=null){
                        contOverdue.setPeriod(contRepaySked.getPeriod());
                        contOverdue.setOverdueDays(days);
                        contOverdue.setOverdueDayRate(overDueDayRate);
                        //罚息金额
                        contOverdue.setOverdueAmount(rent);
                        //罚息剩余金额 = 罚息金额-罚息已收金额-罚息免除金额
                        contOverdue.setRestOverdueAmount(rent.subtract(contOverdue.getReceiptAmount()).subtract(contOverdue.getExemptAmount()));
                        contOverdue.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
                        contOverdueUpdateList.add(contOverdue);
                    }else {
                        ContOverdue  contOverDue = new ContOverdue();
                        contOverDue.setPeriod(contRepaySked.getPeriod());
                        contOverDue.setOverdueDays(days);
                        contOverDue.setOverdueDayRate(overDueDayRate);
                        contOverDue.setContNo(contRepaySked.getContNo());
                        contOverDue.setOverdueAmount(rent);
                        contOverDue.setRestOverdueAmount(rent);
                        contOverDue.setReceiptAmount(new BigDecimal(0));
                        contOverDue.setExemptAmount(new BigDecimal(0));
                        contOverDue.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
                        contOverdueSaveList.add(contOverDue);
                    }

                    //还款计划表逾期状态
                    contRepaySked.setOverdueStatus(ALREADY_OVERDUE.getType());
                    ContRepaySkedUpDateList.add(contRepaySked);

            }
            contRepaySkedRepository.updateByPrimaryKeySelectiveDataList(ContRepaySkedUpDateList);
            contOverdueRepository.updateByPrimaryKeySelectiveDataList(contOverdueUpdateList);
            contOverdueRepository.insertDataList(contOverdueSaveList);
        }

    }

    /**
     * @param contNo
     * @Description: 根据合同编号查询融资合同还款信息 ，还款时间小于当前时间且倒序排序的第一个
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/11 17:18
     */
    @Override
    public ContRepaySked findContRepaySkedByContNo(String contNo) {
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo",contNo);
        criteria.andLessThan("repayDate", DateUtils.getNowDateStr(DateUtils.formatStr_yyyyMMdd));
        SqlUtil.setOrderByColumnDesc(example,"period");
        List<ContRepaySked> contRepaySkedList = contRepaySkedRepository.selectListByExample(example);
        if(ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedList)){
            return contRepaySkedList.get(0);
        }
        return null;
    }

    /** 
    * @Description: 根据合同号查询所有还款计划表，按期数由小到大排序
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/28 20:38
    */ 
    @Override
    public List<ContRepaySked> findAllContRepaySkedByContNo(String contNo) {
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo",contNo);
        SqlUtil.setOrderByColumnAsc(example,"period");
        List<ContRepaySked> contRepaySkedList = contRepaySkedRepository.selectListByExample(example);
        return contRepaySkedList;
    }

    /**
     * @param contNo
     * @Description: 查询逾期租金合计
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 10:46
     */
    @Override
    public BigDecimal findContRepaySkedOverdueRentSum(String contNo) {
        ContRepaySkedVo contRepaySkedVo = new ContRepaySkedVo();
        contRepaySkedVo.setContNo(contNo);
        contRepaySkedVo.setRepayDate(new Date());
        //设置扣款状态
        List<String> repayStatusList = new ArrayList<>();
        repayStatusList.add(RepayStatusEnums.TO_BE_WITHHELD.getType());
        repayStatusList.add(RepayStatusEnums.WITHDRAWING.getType());
        repayStatusList.add(RepayStatusEnums.WITHDRAWING_FAILURE.getType());
        contRepaySkedVo.setRepayStatusList(repayStatusList);
        return contRepaySkedRepository.selectContRepaySkedOverdueRentSum(contRepaySkedVo);
    }

    /**
     * @param contNo
     * @Description: 计算剩余租金，如果未生成还款计划表，返回-1
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 14:14
     */
    @Override
    public BigDecimal findContRepaySkedRentSum(String contNo) {
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo",contNo);
        ContRepaySked contRepaySked = contRepaySkedRepository.selectOneByExample(example);
        if(contRepaySked==null){
            return new BigDecimal("-1");
        }
        ContRepaySkedVo contRepaySkedVo = new ContRepaySkedVo();
        //设置合同号
        contRepaySkedVo.setContNo(contNo);
        //扣款状态，不等于成功或提前结清
        List<String> repayStatusList = new ArrayList<>();
        repayStatusList.add(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());//成功
        repayStatusList.add(RepayStatusEnums.PREPAYMENT.getType());//已提前结清
        contRepaySkedVo.setRepayStatusList(repayStatusList);
        BigDecimal restNum = contRepaySkedRepository.selectContRepaySkedRentSum(contRepaySkedVo);
        if(restNum == null){
            restNum = BigDecimal.ZERO;
        }
        return restNum;
    }

    /**
     * @Title:
     * @Description: 查询即将到还款日期数据
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @Override
    public List<ContRepaySkedVo> findOnceOverdueSked(ContRepaySkedVo contRepaySkedVo) {
        List<ContRepaySkedVo> contRepaySkedVoList = contRepaySkedRepository.selectOnceOverdueSked(contRepaySkedVo);
        return contRepaySkedVoList;
    }

    /**
     * @Title:
     * @Description: 分页查询合同还款日信息
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @Override
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedDetailByPage(ContRepaySkedVo contRepaySkedVo) {
        //业务类型
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getLicenseAttr()))
            contRepaySkedVo.setLicenseAttr(contRepaySkedVo.getLicenseAttr());
        else
            contRepaySkedVo.setLicenseAttr(null);
        //还款日开始时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getStartTime()))
            contRepaySkedVo.setStartTime(contRepaySkedVo.getStartTime());
        else
            contRepaySkedVo.setStartTime(null);
        //还款日结束时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getEndTime()))
            contRepaySkedVo.setEndTime(contRepaySkedVo.getEndTime());
        else
            contRepaySkedVo.setEndTime(null);
        //区域
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getGroupDistrict()))
            contRepaySkedVo.setGroupDistrict(SqlUtil.likePattern(contRepaySkedVo.getGroupDistrict()));
        else
            contRepaySkedVo.setGroupDistrict(null);
        //客户姓名
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getName()))
            contRepaySkedVo.setName(SqlUtil.likePattern(contRepaySkedVo.getName()));
        else
            contRepaySkedVo.setName(null);
        //扣款状态
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getRepayStatus()))
            contRepaySkedVo.setRepayStatus(contRepaySkedVo.getRepayStatus());
        else
            contRepaySkedVo.setRepayStatus(null);
        //还款状态
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getPaymentSts()))
            contRepaySkedVo.setPaymentSts(contRepaySkedVo.getPaymentSts());
        else
            contRepaySkedVo.setPaymentSts(null);
        //逾期状态
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getOverdueStatus()))
            contRepaySkedVo.setOverdueStatus(contRepaySkedVo.getOverdueStatus());
        else
            contRepaySkedVo.setOverdueStatus(null);
        //车架号
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getVinNo())){
            contRepaySkedVo.setVinNo(SqlUtil.likePattern(contRepaySkedVo.getVinNo()));
        }else{
            contRepaySkedVo.setVinNo(null);
        }
       /* //实际还款日
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getReceDate())){
            contRepaySkedVo.setReceDate(contRepaySkedVo.getReceDate());
        }else{
            contRepaySkedVo.setReceDate(null);
        }*/
        //实际还款日开始时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getStartTimeReceiptDate()))
            contRepaySkedVo.setStartTimeReceiptDate(contRepaySkedVo.getStartTimeReceiptDate());
        else
            contRepaySkedVo.setStartTimeReceiptDate(null);
        //实际还款日结束时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getEndTimeReceiptDate()))
            contRepaySkedVo.setEndTimeReceiptDate(contRepaySkedVo.getEndTimeReceiptDate());
        else
            contRepaySkedVo.setEndTimeReceiptDate(null);
        //应收租金
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getRentActual())){
            contRepaySkedVo.setRentActual(contRepaySkedVo.getRentActual());
        }else{
            contRepaySkedVo.setRentActual(null);
        }
        //开票日期
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getInvoDate())){
            contRepaySkedVo.setInvoDate(contRepaySkedVo.getInvoDate());
        }else{
            contRepaySkedVo.setInvoDate(null);
        }
        //备注
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getMemo())){
            contRepaySkedVo.setMemo(SqlUtil.likePattern(contRepaySkedVo.getMemo()));
        }else{
            contRepaySkedVo.setMemo(null);
        }
        //合同编号
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getContNo())){
            contRepaySkedVo.setContNo(SqlUtil.likePattern(contRepaySkedVo.getContNo()));
        }else{
            contRepaySkedVo.setContNo(null);
        }
        contRepaySkedVo.setApplyType(ApplyTypeEnums.PERSON.getType());
        PageInfoExtend<ContRepaySkedVo> contRepaySkedVoList = contRepaySkedRepository.selectListVoByPage("selectContRepaySkedDetailByPage",contRepaySkedVo,contRepaySkedVo.getPageQuery());
        return contRepaySkedVoList;
    }

    /**
     * @Title:
     * @Description: 分页查询合同还款日信息(导出用)
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @Override
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedDetailExport(ContRepaySkedVo contRepaySkedVo) {
        //合同编号
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getContNo())){
            contRepaySkedVo.setContNo(SqlUtil.likePattern(contRepaySkedVo.getContNo()));
        }else{
            contRepaySkedVo.setContNo(null);
        }
        //业务类型
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getLicenseAttr()))
            contRepaySkedVo.setLicenseAttr(contRepaySkedVo.getLicenseAttr());
        else
            contRepaySkedVo.setLicenseAttr(null);
        //还款日开始时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getStartTime()))
            contRepaySkedVo.setStartTime(contRepaySkedVo.getStartTime());
        else
            contRepaySkedVo.setStartTime(null);
        //还款日结束时间
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getEndTime()))
            contRepaySkedVo.setEndTime(contRepaySkedVo.getEndTime());
        else
            contRepaySkedVo.setEndTime(null);
        //区域
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getGroupDistrict()))
            contRepaySkedVo.setGroupDistrict(SqlUtil.likePattern(contRepaySkedVo.getGroupDistrict()));
        else
            contRepaySkedVo.setGroupDistrict(null);
        //客户姓名
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getName()))
            contRepaySkedVo.setName(SqlUtil.likePattern(contRepaySkedVo.getName()));
        else
            contRepaySkedVo.setName(null);
        //扣款状态
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getRepayStatus()))
            contRepaySkedVo.setRepayStatus(contRepaySkedVo.getRepayStatus());
        else
            contRepaySkedVo.setRepayStatus(null);
        //车架号
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getVinNo())){
            contRepaySkedVo.setVinNo(SqlUtil.likePattern(contRepaySkedVo.getVinNo()));
        }else{
            contRepaySkedVo.setVinNo(null);
        }
        //实际还款日
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getReceDate())){
            contRepaySkedVo.setReceDate(contRepaySkedVo.getReceDate());
        }else{
            contRepaySkedVo.setReceDate(null);
        }
        //应收租金
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getRent())){
            contRepaySkedVo.setRent(contRepaySkedVo.getRent());
        }else{
            contRepaySkedVo.setRent(null);
        }
        //开票日期
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getInvoDate())){
            contRepaySkedVo.setInvoDate(contRepaySkedVo.getInvoDate());
        }else{
            contRepaySkedVo.setInvoDate(null);
        }
        //备注
        if(StringUtils.isNotTrimBlank(contRepaySkedVo.getMemo())){
            contRepaySkedVo.setMemo(SqlUtil.likePattern(contRepaySkedVo.getMemo()));
        }else{
            contRepaySkedVo.setMemo(null);
        }

        contRepaySkedVo.setApplyType(ApplyTypeEnums.PERSON.getType());
        PageInfoExtend<ContRepaySkedVo> contRepaySkedVoList = contRepaySkedRepository.selectListVoByPage("selectContRepaySkedDetailByPage",contRepaySkedVo,contRepaySkedVo.getPageQuery());
        // 企业类型2_企业数据字典集合
        Map<String,String> compMap = commonConstantService.findSysCodeValues(CommonCodeTypeConstants.COMPANY_TYPE_COMP);
        // 企业类型2_经销商数据字典集合
        Map<String,String> saleMap = commonConstantService.findSysCodeValues(CommonCodeTypeConstants.COMPANY_TYPE_SALE);
        // 企业类型数据字典集合
        Map<String,String> companyTypeMap = commonConstantService.findSysCodeValues(CommonCodeTypeConstants.PROD_COMPANY_TYPE);
        // 申请类型数据字典集合
        Map<String,String> applyTypeMap = commonConstantService.findSysCodeValues(CommonCodeTypeConstants.PROD_APPLY_TYPE);
        // 企业类型2数据字典集合
        Map<String,String> companyTypeMap2 = commonConstantService.findSysCodeValues(CommonCodeTypeConstants.PROD_COMPANY_TYPE2);

        for(ContRepaySkedVo contRepaySked:contRepaySkedVoList.getData()){
            String applyType = contRepaySked.getApplyType();
            contRepaySked.setApplyType(companyTypeMap.get(contRepaySked.getApplyType()));
            contRepaySked.setCompanyType2(companyTypeMap2.get(contRepaySked.getCompanyType2()));
//            if(StringUtils.isNotTrimBlank(contRepaySked.getCompanyType2())){
//                contRepaySked.setApplyType(companyTypeMap.get(contRepaySked.getApplyType()));
//            }else{
//                contRepaySked.setApplyType(applyTypeMap.get(contRepaySked.getApplyType()));
//            }
//            if(CompanyType.comp.getType().equals(applyType) && StringUtils.isNotTrimBlank(contRepaySked.getCompanyType2())){
//                contRepaySked.setCompanyType2(compMap.get(contRepaySked.getCompanyType2()));
//            }else if(CompanyType.sale.getType().equals(applyType) && StringUtils.isNotTrimBlank(contRepaySked.getCompanyType2())){
//                contRepaySked.setCompanyType2(saleMap.get(contRepaySked.getCompanyType2()));
//            }
        }
        return contRepaySkedVoList;
    }

    /**
     * @Title:
     * @Description: 未结清车辆租金明细表(导出用)
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @Override
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedSettleExport(ContRepaySkedVo contRepaySkedVo){
        return this.findContRepaySkedSettleEndExport(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description: 结清车辆租金明细表(导出用)
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @Override
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedSettleEndExport(ContRepaySkedVo contRepaySkedVo){
        PageInfoExtend<ContRepaySkedVo> contRepaySkedVoList=this.findContRepaySkedDetailByPage(contRepaySkedVo);
        //增加合计行
        ContRepaySkedVo vo=new ContRepaySkedVo();
        BigDecimal rentActual=BigDecimal.ZERO;//应收租金
        BigDecimal receiptAmount=BigDecimal.ZERO;//实收租金
        BigDecimal principal=BigDecimal.ZERO;//当期本金
        BigDecimal overdueAmount=BigDecimal.ZERO;//实收违约金
        BigDecimal finRprincipal=BigDecimal.ZERO;//财务本金

        for(ContRepaySkedVo contRepaySked:contRepaySkedVoList.getData()){
            //应收租金
            BigDecimal ra = contRepaySked.getRentActual()==null ? BigDecimal.ZERO : contRepaySked.getRentActual();
            rentActual = rentActual.add(ra);
            //实收租金
            BigDecimal cra=(contRepaySked.getReceiptAmount()==null ? BigDecimal.ZERO : contRepaySked.getReceiptAmount());
            receiptAmount=receiptAmount.add(cra);
            //当期本金
            BigDecimal pi=contRepaySked.getPrincipal()==null ? BigDecimal.ZERO : contRepaySked.getPrincipal();
            principal=principal.add(pi);
            //实收违约金
            BigDecimal oa=contRepaySked.getOverdueAmount()==null ? BigDecimal.ZERO : contRepaySked.getOverdueAmount();
            overdueAmount=overdueAmount.add(oa);
            //财务本金
            BigDecimal fp=contRepaySked.getFinRprincipal()==null ? BigDecimal.ZERO : contRepaySked.getFinRprincipal();
            finRprincipal=finRprincipal.add(fp);
        }
        vo.setRentActual(rentActual);//应收租金
        vo.setReceiptAmount(receiptAmount);//实收租金
        vo.setPrincipal(principal);//当期本金
        vo.setOverdueAmount(overdueAmount);//实收违约金
        vo.setFinRprincipal(finRprincipal);//财务本金
        vo.setGroupDistrict("合计");
        contRepaySkedVoList.getData().add(vo);

        return contRepaySkedVoList;
    }

    /**
     * @Title:
     * @Description: 未收租金明细表(导出用)
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @Override
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedUnpaidRentExport(ContRepaySkedVo contRepaySkedVo){
        PageInfoExtend<ContRepaySkedVo> contRepaySkedVoList = this.findContRepaySkedDetailByPage(contRepaySkedVo);
        //增加合计行
        ContRepaySkedVo vo=new ContRepaySkedVo();
        BigDecimal rentActual=BigDecimal.ZERO;//应收租金
        BigDecimal principal=BigDecimal.ZERO;//当期本金
        BigDecimal finRprincipal=BigDecimal.ZERO;//财务本金
        for(ContRepaySkedVo contRepaySked:contRepaySkedVoList.getData()){
            //应收租金
            BigDecimal ra = contRepaySked.getRentActual()==null ? BigDecimal.ZERO : contRepaySked.getRentActual();
            rentActual = rentActual.add(ra);
            //当期本金
            BigDecimal pi=contRepaySked.getPrincipal()==null ? BigDecimal.ZERO : contRepaySked.getPrincipal();
            principal=principal.add(pi);
            //财务本金
            BigDecimal fp=contRepaySked.getFinRprincipal()==null ? BigDecimal.ZERO : contRepaySked.getFinRprincipal();
            finRprincipal=finRprincipal.add(fp);
        }
        vo.setRentActual(rentActual);//应收租金
        vo.setPrincipal(principal);//当期本金
        vo.setFinRprincipal(finRprincipal);//财务本金
        vo.setGroupDistrict("合计");
        contRepaySkedVoList.getData().add(vo);
        return contRepaySkedVoList;
    }

    /**
     * @Title:
     * @Description: 实收租金明细表(导出用)
     * @param contRepaySkedVo
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @Override
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedPaidRentExport(ContRepaySkedVo contRepaySkedVo){
        if(StringUtils.isTrimBlank(contRepaySkedVo.getCensuMonth())) {
            contRepaySkedVo.setCensuMonth(DateUtils.dateToStr(new Date(), DateUtils.formatStr_yyyyMM_NO));
        }
        else {
            contRepaySkedVo.setCensuMonth(contRepaySkedVo.getCensuMonth().replace("-", ""));//去除连字符
        }
        PageInfoExtend<ContRepaySkedVo> contRepaySkedVoList = this.findContRepaySkedSettleEndExport(contRepaySkedVo);
        return  contRepaySkedVoList;
    }

    private BigDecimal TrimBigDecimal(BigDecimal decimal){
        if (decimal == null){
            return BigDecimal.ZERO;
        }
        return decimal;
    }

    /**
     * @Title:
     * @Description: 根据contReceiptExamId获取ContRepaySkedVo
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    public ContRepaySkedVo findContReceiptDetailByContReceiptExamId(String contReceiptExamId){
        if (StringUtils.isTrimBlank(contReceiptExamId)) {
            throw new FmsServiceException("contReceiptExamId不能为空");
        }
        List<String> contReceiptExamIdList = new ArrayList<>();
        contReceiptExamIdList.add(contReceiptExamId);
        List<ContRepaySkedVo> contRepaySkedVoList = contRepaySkedRepository.selectContReceiptDetailByContReceiptExamId(contReceiptExamIdList);
        if (ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedVoList)) {
            return contRepaySkedVoList.get(0);
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 开具发票
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    public void contReceiptDetailInvoice(ContRepaySkedVo contRepaySkedVo){
        //收款业务类型为0，更新销售还款计划表,为1，更新还款逾期罚息表
        if("0".equals(contRepaySkedVo.getReceiptBizType())){
            if(StringUtils.isNotTrimBlank(contRepaySkedVo.getInvoiceId())){
                contRepaySkedVo.setRepaySkedId(contRepaySkedVo.getInvoiceId());
                contRepaySkedRepository.updateByPrimaryKeySelectiveData(contRepaySkedVo.getEntity());
            }
        }else if ("1".equals(contRepaySkedVo.getReceiptBizType())){
            if (StringUtils.isNotTrimBlank(contRepaySkedVo.getInvoiceId())){
                ContOverdue contOverdue = new ContOverdue();
                //逾期罚息id
                contOverdue.setContOverdueId(contRepaySkedVo.getInvoiceId());
                //备注
                if(StringUtils.isNotTrimBlank(contRepaySkedVo.getMemo())){
                    contOverdue.setMemo(contRepaySkedVo.getMemo());
                }
                //开票日期
               /* if (contRepaySkedVo.getInvoiceDate()!=null){
                    contOverdue.setInvoiceDate(contRepaySkedVo.getInvoiceDate());
                }*/
                contOverdueRepository.updateByPrimaryKeySelectiveData(contOverdue);
            }
        }else {
            throw new FmsServiceException("无法获取收款业务类型!");
        }
    }

    /**
    * @Description: 勾稽页面手动生成凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/2 18:01
    */
    @Override
    @Transactional
    public void makeVoucher(List<String> contReceiptExamIdList) {
        if (ArrayUtils.isNullOrLengthZero(contReceiptExamIdList)) {
            throw new FmsServiceException("未获取到勾稽数据id");
        }
        List<ContRepaySkedVo> contRepaySkedVoList = contRepaySkedRepository.selectContReceiptDetailByContReceiptExamId(contReceiptExamIdList);
        if (ArrayUtils.isNullOrLengthZero(contRepaySkedVoList)) {
            throw new FmsServiceException("未获取到勾稽数据");
        }

        //去除抵扣和差额的收款
        contRepaySkedVoList = contRepaySkedVoList.stream().
                filter(contRepaySkedVo -> StringUtils.notEquals(InputModeEnums.INTER.getType(),contRepaySkedVo.getInputMode()) && StringUtils.notEquals(InputModeEnums.SHORTFALL.getType(),contRepaySkedVo.getInputMode())).collect(Collectors.toList());
        //存放已查询的合同数据
        Map<String, ContractVo> contractVoMap = new HashMap<>();
        //将勾稽数据按业务类型分组
        Map<String,List<ContRepaySkedVo>> contRepaySkedVoLicenseMap = getContRepaySkedVoLicenseMap(contRepaySkedVoList);
        //按业务类型生成凭证
        for (Map.Entry<String, List<ContRepaySkedVo>> entry : contRepaySkedVoLicenseMap.entrySet()) {
            if (ArrayUtils.isNotNullAndLengthNotZero(entry.getValue())) {
                //根据区域分组
                Map<String,List<ContRepaySkedVo>> contRepaySkedVoDistrictMap = getContRepaySkedVoDistrictMap(entry.getValue());
                //获取收款财务凭证类型
                String voucherType = getRentVoucherType(entry.getKey());
                //根据区域分组存放分录信息
                Map<String, Map<String, Object>> totalMap = new HashMap<>();
                //存放收款编号
                Map<String, String> receiptNoMap = new HashMap<>();

                //遍历每个区域
                for (List<ContRepaySkedVo> contRepaySkedVoDistrict : contRepaySkedVoDistrictMap.values()) {
                    //用来存放相同收款id的数据,key是收款id
                    Map<String, BigDecimal> receiptAmountMap = new HashMap<>();

                    //按区域生成凭证
                    for (ContRepaySkedVo contRepaySkedVo : contRepaySkedVoDistrict) {
                        //获取财务核算代码信息
                        findContractVo(contractVoMap, contRepaySkedVo);
                        //生成收款编号,key=收款id
                        if (receiptNoMap.get(contRepaySkedVo.getContReceiptId()) == null) {
                            receiptNoMap.put(contRepaySkedVo.getContReceiptId(), FinVouDetailValueConstants.RECEIPT_NAME + numGenerateService.getNumGenerateByNumType(NumTypeEnums.RECEIPT_NO.getType()));
                        }

                        if (receiptAmountMap.get(contRepaySkedVo.getContReceiptId()) == null) {
                            receiptAmountMap.put(contRepaySkedVo.getContReceiptId(), contRepaySkedVo.getReceiptExamAmount());
                        }else{
                            receiptAmountMap.put(contRepaySkedVo.getContReceiptId(),
                                    BigDecimalUtils.getNotNullBigDecimal(receiptAmountMap.get(contRepaySkedVo.getContReceiptId())).add(BigDecimalUtils.getNotNullBigDecimal(contRepaySkedVo.getReceiptExamAmount())));
                        }
                        //设置贷方租金循环对象
                        setRentMap(totalMap, contractVoMap.get(contRepaySkedVo.getContNo()),FinVouDetailValueConstants.RENT_LOOP_4,contRepaySkedVo.getReceiptExamAmount(), null,contRepaySkedVo.getContNo(),receiptNoMap,contRepaySkedVo.getContReceiptId());
                    }
                    //遍历收款数据
                    for (Map.Entry<String, BigDecimal> receiptEntry : receiptAmountMap.entrySet()) {
                        List<ContRepaySkedVo> receiptVoList = contRepaySkedVoDistrict.stream().filter(receiptVo -> receiptVo.getContReceiptId().equals(receiptEntry.getKey())).collect(Collectors.toList());
                        if (ArrayUtils.isNotNullAndLengthNotZero(receiptVoList)) {
                            ContRepaySkedVo receiptContRepaySkedVo = receiptVoList.get(0);
                            //如果出租人=收款银行
                            if (StringUtils.equals(receiptContRepaySkedVo.getRecAccountName(), receiptContRepaySkedVo.getGroupName())) {
                                //设置借方租金循环对象
                                setRentMap(totalMap,contractVoMap.get(receiptContRepaySkedVo.getContNo()),FinVouDetailValueConstants.RENT_LOOP_1,receiptEntry.getValue(),receiptContRepaySkedVo.getRecAccountNo(),null,receiptNoMap,receiptContRepaySkedVo.getContReceiptId());

                            }else{
                                //如果出租人!=收款银行
                                String recAcountNo = receiptContRepaySkedVo.getRecAccountNo();
                                if (StringUtils.isTrimBlank(recAcountNo)) {
                                    throw new FmsServiceException("收款银行账号不存在");
                                }
                                //获取财务核算代码,客户：出租人，公司：收款公司
                                ContractVo contractVo = contRepaySkedRepository.selectContractVoFinassCodesByRecAcountNo(receiptContRepaySkedVo.getGroupCode(),recAcountNo);
                                //设置借方租金循环对象
                                setRentMap(totalMap, contractVo,FinVouDetailValueConstants.RENT_LOOP_1,receiptEntry.getValue(),receiptContRepaySkedVo.getRecAccountNo(),null,receiptNoMap,receiptContRepaySkedVo.getContReceiptId());

                                //设置往来款租金循环对象
                                setRentMap(totalMap, contractVo,FinVouDetailValueConstants.RENT_LOOP_2,receiptEntry.getValue().multiply(new BigDecimal("-1")),null,null,receiptNoMap,receiptContRepaySkedVo.getContReceiptId());

                                //设置往来款租金循环对象
                                setRentMap(totalMap, contractVoMap.get(receiptContRepaySkedVo.getContNo()),FinVouDetailValueConstants.RENT_LOOP_3,receiptEntry.getValue(),null,null,receiptNoMap,receiptContRepaySkedVo.getContReceiptId());

                            }
                        }

                    }
                }
                for (Map.Entry<String, Map<String, Object>> dataMapEntry : totalMap.entrySet()) {
                    Map<String, Object> dataMap = dataMapEntry.getValue();
                    //凭证区域
                    dataMap.put(FinVouDetailValueConstants.VOUCHER_GROUP, dataMapEntry.getKey());
                    //获取凭证明细数据
                    CommonFinVouData commonFinVouData = commonFinancialVoucherDataService.getFinVoucherData(voucherType,dataMap,"汇总");
                    //保存凭证明细数据
                    commonFinancialVoucherDataService.saveCommonFinVouData(commonFinVouData);
                }
            }
        }
        updateExamVoucherStatue(contRepaySkedVoList);


    }

    /**
    * @Description: 设置贷方租金循环对象
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/5 16:29
    */
    private void setRentMap(Map<String, Map<String, Object>> totalMap, ContractVo contractVo, String rentLoopType, BigDecimal rent, String recAccountNo, String contNo, Map<String, String> receiptNoMap,String receiptId) {
        Map<String, Object> rentMap = new HashedMap();
        //设置动态科目代码
        if (StringUtils.isNotTrimBlank(recAccountNo)) {
            setFinassSubjectCdToMap(FinVouDetailValueConstants.SUBJECT_CD_DYN, recAccountNo, rentMap);
        }
        //设置合同编号
        if (StringUtils.isNotTrimBlank(contNo)) {
            rentMap.put(FinVouDetailValueConstants.CONT_NO, contNo);
        }
        //设置收款编号
        rentMap.put(FinVouDetailValueConstants.RECEIPT_NO, receiptNoMap.get(receiptId));
        //设置金额
        rentMap.put(FinVouDetailValueConstants.RENT, rent);
        //车架号后6位
        rentMap.put(FinVouDetailValueConstants.VIN_NO_6, StringUtils.subStringLater(contractVo.getVinNo(),6));
        //取到订单申请人的财务核算代码
        rentMap.put(FinVouDetailValueConstants.FINASS_CSTM_CODE, contractVo.getFinassCstmCode());
        //申请人姓名
        rentMap.put(FinVouDetailValueConstants.APPLY_PERSON_NAME, contractVo.getApplyPersonName());
        //实际销售方的财务核算代码
//        rentMap.put(FinVouDetailValueConstants.FINASS_SALES_CODE, contractVo.getFinassSalesCode());
        //出租人的财务核算代码
        rentMap.put(FinVouDetailValueConstants.FINASS_GROUP_CODE, contractVo.getFinassGroupCode());
        //凭证区域
        String voucherGroup = contractVo.getGroupDistrict();
        if (totalMap.get(voucherGroup) == null) {
            totalMap.put(voucherGroup, new HashedMap());
        }
        Map<String, Object> dataMap = totalMap.get(voucherGroup);

        if (StringUtils.isNotTrimBlank(rentLoopType)) {
            if (dataMap.get(rentLoopType) == null) {
                dataMap.put(rentLoopType, new ArrayList<>());
            }
            ((List<Map<String,Object>>)dataMap.get(rentLoopType)).add(rentMap);
        }
    }

    /**
     * @Description: 根据银行账号设置财务科目代码
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/8/1 14:20
     */
    private void setFinassSubjectCdToMap(String cdCode,String accountNo,Map<String, Object> dataMap){
        String finassSubjectCd = "";
        if(StringUtils.isNotTrimBlank(accountNo)){
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
    * @Description: 获取财务核算代码信息
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/5 15:43
    */
    private void findContractVo(Map<String, ContractVo> contractVoMap, ContRepaySkedVo contRepaySkedVo) {
        ContractVo contractVo = null;
        if (contractVoMap.get(contRepaySkedVo.getContNo()) == null) {
            try {
                contractVo = ResponseEntityUtils.getRestResponseData(contractRpc.findContractVoFinassCodes(contRepaySkedVo.getApplyNo(), contRepaySkedVo.getContNo()));
            } catch (FmsRpcException e) {
                log.error(e.getMessage());
                throw new FmsServiceException("获取财务核算代码信息失败");
            }
            if (contractVo == null) {
                throw new FmsServiceException("未获取到财务核算代码信息");
            }
            contractVoMap.put(contRepaySkedVo.getContNo(), contractVo);
        }
    }

    /**
    * @Description: 将勾稽数据按业务类型分组
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/2 17:49
    */
    private Map<String,List<ContRepaySkedVo>> getContRepaySkedVoLicenseMap(List<ContRepaySkedVo> contRepaySkedVoList){
        Map<String,List<ContRepaySkedVo>> contRepaySkedVoLicense = new HashMap<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedVoList)){
            for(ContRepaySkedVo contRepaySkedVo : contRepaySkedVoList){
                if(contRepaySkedVoLicense.get(contRepaySkedVo.getLicenseAttr()) == null)
                    contRepaySkedVoLicense.put(contRepaySkedVo.getLicenseAttr(),new ArrayList<>());
                contRepaySkedVoLicense.get(contRepaySkedVo.getLicenseAttr()).add(contRepaySkedVo);
            }
        }
        return contRepaySkedVoLicense;
    }

    /**
     * @Description: 将勾稽数据按区域分组
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/11/2 17:49
     */
    private Map<String,List<ContRepaySkedVo>> getContRepaySkedVoDistrictMap(List<ContRepaySkedVo> contRepaySkedVoList){
        Map<String,List<ContRepaySkedVo>> contRepaySkedVoDistrict = new HashMap<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedVoList)){
            for(ContRepaySkedVo contRepaySkedVo : contRepaySkedVoList){
                if(contRepaySkedVoDistrict.get(contRepaySkedVo.getGroupDistrict()) == null)
                    contRepaySkedVoDistrict.put(contRepaySkedVo.getGroupDistrict(),new ArrayList<>());
                contRepaySkedVoDistrict.get(contRepaySkedVo.getGroupDistrict()).add(contRepaySkedVo);
            }
        }
        return contRepaySkedVoDistrict;
    }

    /**
    * @Description: 获取租金财务凭证类型
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/2 18:01
    */
    private String getRentVoucherType(String licenseAttr) {
        String voucherType = "";
        if(LicenseAttrEnums.FINANCE_LEASE.getType().equals(licenseAttr)){
            voucherType = VoucherTypeEnums.RENTAL_0.getType();
        }else if(LicenseAttrEnums.LEASE_DIRECT.getType().equals(licenseAttr)){
            voucherType = VoucherTypeEnums.RENTAL_1.getType();
        }else if(LicenseAttrEnums.LEASE_BACK.getType().equals(licenseAttr)){
            voucherType = VoucherTypeEnums.RENTAL_2.getType();
        }
        if(StringUtils.isTrimBlank(voucherType)){
            throw new FmsServiceException("获取财务凭证类型失败");
        }
        return voucherType;
    }

    /**
    * @Description: 更新凭证生成状态
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/6 20:57
    */
    private void updateExamVoucherStatue(List<ContRepaySkedVo> contRepaySkedVoList) {
        if (ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedVoList)) {
            //更新凭证生成状态
            List<String> contReceiptExamIds = contRepaySkedVoList.stream().map(ContRepaySkedVo::getContReceiptExamId).collect(Collectors.toList());
            Example example = SqlUtil.newExample(ContReceiptExam.class);
            example.createCriteria().andIn("contReceiptExamId", contReceiptExamIds);
            ContReceiptExam contReceiptExam = new ContReceiptExam();
            contReceiptExam.setVoucherStatus(YesNoFlagEnums.YES.getType());
            contReceiptExamRepository.updateByExampleSelectiveData(contReceiptExam, example);
        }
    }

}
