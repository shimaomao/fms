package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonExcelService;
import cn.com.leadu.fms.business.service.CommonFinancialVoucherDataService;
import cn.com.leadu.fms.business.vo.CommonFinVouData;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.constant.FinVouDetailValueConstants;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.postbiz.ContCostTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.CostItemEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.finance.repository.ContOverdueRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.postbiz.repository.ContCostRepository;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.finance.rpc.baseinfo.BasBankInfoRpc;
import cn.com.leadu.fms.finance.rpc.prebiz.ContractRpc;
import cn.com.leadu.fms.finance.service.ContReceiptService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptPostVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.ContReceiptSaveVo;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.ContReceiptModifyVo;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.ContReceiptDeleteVo;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.ContReceiptDeleteListVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ContCost;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lijunjun
 * @ClassName: ContReceiptService
 * @Description:  融资合同还款计划信息业务实现层
 * @date 2018-05-07
 */
@Slf4j
@Service
public class ContReceiptServiceImpl implements ContReceiptService {

    /**
     * @Fields  : 财务凭证明细共通
     * @author qiaomengnan
     */
    @Autowired
    private CommonFinancialVoucherDataService commonFinancialVoucherDataService;

    /**
     * @Fields  :  融资合同还款计划信息repository
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    @Autowired
    private ContOverdueRepository contOverdueRepository;

    @Autowired
    private CommonExcelService commonExcelService;

    /**
     * 合同信息rpc
     */
    @Autowired
    private ContractRpc contractRpc;

    /**
     * 银行信息维护rpc
     */
    @Autowired
    private BasBankInfoRpc basBankInfoRpc;

    /**
     * 客户费用信息Repository
     */
    @Autowired
    private ContCostRepository contCostRepository;

    /**
     * @Fields  : 合同融资信息repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

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
     * @Description: 分页查询 融资合同还款计划信息
     * @param contReceiptVo
     * @return PageInfoExtend<ContReceipt>
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public PageInfoExtend<ContReceiptVo> findContReceiptsByPage(ContReceiptVo contReceiptVo){
        // 收款账号模糊处理
        if(StringUtils.isNotTrimBlank(contReceiptVo.getRecAccountNo())){
            contReceiptVo.setRecAccountNo(SqlUtil.likePattern(contReceiptVo.getRecAccountNo()));
        } else {
            contReceiptVo.setRecAccountNo(null);
        }
        //到账日期
        if(StringUtils.isTrimBlank(contReceiptVo.getReceiptDateSearch())){
            contReceiptVo.setReceiptDateSearch(null);
        }
        //收款备注
        if(StringUtils.isNotTrimBlank(contReceiptVo.getMemo()))
            contReceiptVo.setMemo(SqlUtil.likePattern(contReceiptVo.getMemo()));
        else
            contReceiptVo.setMemo(null);
       /* //付款户名
        if(StringUtils.isNotTrimBlank(contReceiptVo.getPayAccountName()))
            contReceiptVo.setPayAccountName(SqlUtil.likePattern(contReceiptVo.getPayAccountName()));
        else
            contReceiptVo.setPayAccountName(null);*/
        //收款户名
        if(StringUtils.isNotTrimBlank(contReceiptVo.getRecAccountName()))
            contReceiptVo.setRecAccountName(SqlUtil.likePattern(contReceiptVo.getRecAccountName()));
        else
            contReceiptVo.setRecAccountName(null);
        PageInfoExtend<ContReceiptVo> pageInfo = contReceiptRepository.selectListVoByPage("selectContReceiptsByPage", contReceiptVo, contReceiptVo.getPageQuery());
        return pageInfo;
    }


    /**
     * @Title:
     * @Description: 分页查询收款导入明细信息
     * @param contReceiptVo
     * @return PageInfoExtend<ContReceipt>
     * @throws
     * @author ningyangyang
     * @date 2018-5-7 18:04:31
     */
    public PageInfoExtend<ContReceiptVo> findContReceiptsImport(ContReceiptVo contReceiptVo){
        // 收款账号模糊处理
        if(StringUtils.isNotTrimBlank(contReceiptVo.getRecAccountNo())){
            contReceiptVo.setRecAccountNo(SqlUtil.likePattern(contReceiptVo.getRecAccountNo()));
        } else {
            contReceiptVo.setRecAccountNo(null);
        }
        if(StringUtils.isTrimBlank(contReceiptVo.getReceiptDateSearch())){
            contReceiptVo.setReceiptDateSearch(null);
        }
        if(StringUtils.isNotTrimBlank(contReceiptVo.getPayAccountName()))
            contReceiptVo.setPayAccountName(SqlUtil.likePattern(contReceiptVo.getPayAccountName()));
        else
            contReceiptVo.setPayAccountName(null);
        //收款户名
        if(StringUtils.isNotTrimBlank(contReceiptVo.getRecAccountName()))
            contReceiptVo.setRecAccountName(SqlUtil.likePattern(contReceiptVo.getRecAccountName()));
        else
            contReceiptVo.setRecAccountName(null);
        //备注
        if(StringUtils.isNotTrimBlank(contReceiptVo.getMemo()))
            contReceiptVo.setMemo(SqlUtil.likePattern(contReceiptVo.getMemo()));
        else
            contReceiptVo.setMemo(null);
        PageInfoExtend<ContReceiptVo> pageInfo = contReceiptRepository.selectListVoByPage("selectContReceiptsImport", contReceiptVo, contReceiptVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存 融资合同还款计划信息
     * @param contReceiptSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public void saveContReceipt(ContReceiptSaveVo contReceiptSaveVo){
        contReceiptRepository.insertData(contReceiptSaveVo.getEntity());
    }

    /**
    * @Description: 手动勾稽
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/6 21:21
    */
    @Override
    @Transactional
    public void manualReceipt(ContReceiptPostVo contReceiptPostVo){
        //保存财务收款数据
        for(ContReceiptVo contReceiptVo : contReceiptPostVo.getContReceiptVoList()){
            contReceiptVo.setInputMode(InputModeEnums.INPUT.getType());
            contReceiptVo.setRestAmount(contReceiptVo.getReceiptAmount());//剩余金额=收款金额
            ContReceipt contReceipt = contReceiptVo.getEntity();
            contReceiptRepository.insertData(contReceipt);
            //把id更新到收款明细里
            contReceiptVo.setContReceiptId(contReceipt.getContReceiptId());
        }
        //调用勾稽方法
        this.receipt(contReceiptPostVo);
    }

    /**
     * @Title:
     * @Description: 勾稽
     * @param contReceiptPostVo
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Transactional
    public void receipt(ContReceiptPostVo contReceiptPostVo){
        if(ArrayUtils.isNullOrLengthZero(contReceiptPostVo.getContReceiptVoList())){
            throw new FmsServiceException("至少选择一条收款明细！");
        }
        if(ArrayUtils.isNullOrLengthZero(contReceiptPostVo.getContRepaySkedVoList())){
            throw new FmsServiceException("至少选择一条待勾稽租金明细！");
        }
        List<ContReceiptVo> contReceiptVoList = contReceiptPostVo.getContReceiptVoList();
        List<ContRepaySkedVo> contRepaySkedVoList = contReceiptPostVo.getContRepaySkedVoList();

        //添加的开票信息
        List<Invoice> invoiceList = new ArrayList<>();
        //更新的开票信息
        List<Invoice> updateInvoiceList = new ArrayList<>();
        //待更新财务收款信息List
        List<ContReceipt> contReceiptList = new ArrayList<>();
        //待更新融资合同还款计划信息List
        List<ContRepaySked> contRepaySkedList = new ArrayList<>();
        //待更新财务勾稽表信息List
        List<ContReceiptExam> contReceiptExamUpdateList = new ArrayList<>();
        //待录入财务勾稽表信息List
        List<ContReceiptExam> contReceiptExamInsertList = new ArrayList<>();
        //待更新还款逾期罚息表
        List<ContOverdue> contOverdueUpdateList = new ArrayList<>();
        //待更新逾期罚息数据对应的老数据
        List<ContOverdue> contOverdueOldList = new ArrayList<>();
        // 待处插入的客户费用信息
        List<ContCost> contCostList = new ArrayList<>();
        //初始化待勾稽租金
        BigDecimal toBeReceiptAmount = BigDecimal.ZERO;
        //初始化剩余金额
        BigDecimal restAmount ;
        //待勾稽租金按照收款日期升序，优先勾稽
        contReceiptVoListSort(contReceiptVoList);
        //收款明细按照到账日期升序，优先勾稽
        contRepaySkedVoVoListSort(contRepaySkedVoList);
        List<Integer> contRepaySkedNumList = new ArrayList<>();
        boolean flag = false;
        ContOverdue contOverdue = new ContOverdue();//还款逾期罚息实体
        ContRepaySked contRepaySked = new ContRepaySked();//客户还款计划表实体
        ContReceipt contReceipt = new ContReceipt();//财务收款
        ContCost contCost = null;// 客户费用

        int contReceiptVoListSize;
        if (ArrayUtils.isNullOrLengthZero(contReceiptVoList)){
            contReceiptVoListSize = 1;
        } else {
            contReceiptVoListSize = contReceiptVoList.size();
        }
        for(int i=0;i< contReceiptVoListSize ;i++){
            if(ArrayUtils.isNullOrLengthZero(contReceiptVoList)){
                restAmount = BigDecimal.ZERO;
            } else {
                Example contReceiptVoExample = SqlUtil.newExample(ContReceipt.class);
                contReceiptVoExample.createCriteria().andEqualTo("contReceiptId", contReceiptVoList.get(i).getContReceiptId());
                //查询收款明细信息（财务收款表）
                contReceipt = contReceiptRepository.selectOneByExample(contReceiptVoExample);
                restAmount = contReceipt.getRestAmount();
            }
            // TODO 根据财务收款ID，获取客户费用的保证金信息
            contCost = findContCostByContReceiptId(contReceiptVoList.get(i).getContReceiptId());

            for(int j=0;j<contRepaySkedVoList.size();j++){
                //当前待勾稽明细已处理
                if (contRepaySkedNumList.contains(j)) {
                    continue;
                }
                if (!flag){
                    if("0".equals(contRepaySkedVoList.get(j).getReceiptBizType())){
                        //还款金额
                        Example contRepaySkedExample = SqlUtil.newExample(ContRepaySked.class);
                        contRepaySkedExample.createCriteria().andEqualTo("repaySkedId", contRepaySkedVoList.get(j).getRepaySkedId());
                        //查询租金明细信息（融资合同还款计划表）
                        contRepaySked = contRepaySkedRepository.selectOneByExample(contRepaySkedExample);
                        if(contRepaySked == null){
                            throw new FmsServiceException("融资合同还款计划信息不存在");
                        }
                        //待勾稽金额=实际租金减去已收金额
                        toBeReceiptAmount = TrimBigDecimal(contRepaySked.getRentActual()).subtract(TrimBigDecimal(contRepaySked.getReceiptAmount()));
                    } else if ("1".equals(contRepaySkedVoList.get(j).getReceiptBizType())){
                        //逾息金额
                        Example contOverdueSkedExample = SqlUtil.newExample(ContOverdue.class);
                        contOverdueSkedExample.createCriteria().andEqualTo("contOverdueId", contRepaySkedVoList.get(j).getRepaySkedId());
                        //查询租金明细信息（还款逾期罚息表信息）
                        contOverdue = contOverdueRepository.selectOneByExample(contOverdueSkedExample);
                        if(contOverdue == null){
                            throw new FmsServiceException("还款逾期罚息信息不存在");
                        }
                        //把老数据拷贝一份
                        contOverdueOldList.add(EntityUtils.getEntity(contOverdue, new ContOverdue()));
                        //待勾稽金额=罚息金额-已收金额-罚息免除金额
                        toBeReceiptAmount = TrimBigDecimal(contOverdue.getOverdueAmount()).subtract(TrimBigDecimal(contOverdue.getReceiptAmount()))
                                .subtract(TrimBigDecimal(contOverdue.getExemptAmount()));
                    }

                    Example example = SqlUtil.newExample(ContReceiptExam.class);
                    example.createCriteria().andEqualTo("receiptBizType", contRepaySkedVoList.get(j).getReceiptBizType())
                            .andEqualTo("receiptBizId", contRepaySkedVoList.get(j).getRepaySkedId()).andNotEqualTo("receiptExamStatus",ReceiptExamStatusEnums.ALREADY_CHECKED.getType());
                    //查询待勾稽租金信息(财务勾稽表)
                    List<ContReceiptExam>  contReceiptExamList = contReceiptExamRepository.selectListByExample(example);
                    if (ArrayUtils.isNotNullAndLengthNotZero(contReceiptExamList)){
                        for (ContReceiptExam contReceiptExam : contReceiptExamList){
                            toBeReceiptAmount = toBeReceiptAmount.subtract(contReceiptExam.getReceiptExamAmount());
                            if ("1".equals(contReceiptPostVo.getSolveFlag())){
                                contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());//1-已勾稽
                                contReceiptExamUpdateList.add(contReceiptExam);
                            }
                        }
                    }
                }
                //前台没有选择收款明细
                if(ArrayUtils.isNullOrLengthZero(contReceiptVoList)){
                    if(toBeReceiptAmount.compareTo(BigDecimal.ZERO) != 0){
                        throw new FmsServiceException("待勾稽租金未认领，不能勾稽");
                    }
                    contRepaySkedNumList.add(j);
                    flag = false;
                    continue;
                }

                if(TrimBigDecimal(restAmount).compareTo(TrimBigDecimal(toBeReceiptAmount)) >= 0) {
                    //如果剩余金额 >= 待勾稽租金的场合

                    //更新财务收款表 剩余金额 = 当前剩余金额 - 待勾稽租金
                    if (contReceipt != null) {
                        // TODO 判断是否插入抵扣租金的客户费用信息
                        setAddContCostData(contCost, TrimBigDecimal(toBeReceiptAmount), contCostList);
                        // 更新财务付款表的剩余金额
                        contReceipt.setRestAmount(TrimBigDecimal(restAmount).subtract(TrimBigDecimal(toBeReceiptAmount)));
                        restAmount = TrimBigDecimal(restAmount).subtract(TrimBigDecimal(toBeReceiptAmount));
                        contReceiptList.add(contReceipt);
                    }
                    // 勾稽的场合
                    if ("1".equals(contReceiptPostVo.getSolveFlag())){
                        if (ReceiptBizTypeEnums.REPAYMENT_AMOUNT.getType().equals(contRepaySkedVoList.get(j).getReceiptBizType())){
                            //更新融资合同还款计划表 扣款状态=成功
                            contRepaySked.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());//2-成功
                            contRepaySked.setRecAccBank(contReceipt.getRecAccBank());//实际收款银行=收款明细.付款银行
                            contRepaySked.setRecAccountNo(contReceipt.getRecAccountNo());//实际收款账号=收款明细.付款账号
                            contRepaySked.setRecAccountName(contReceipt.getRecAccountName());//实际收款户名=收款明细.付款户名
                            contRepaySked.setReceiptAmount(contRepaySkedVoList.get(j).getRentActual());//已收金额=实际租金
//                            contRepaySked.setInvoiceDate(contRepaySkedVoList.get(j).getInvoiceDate());//开票时间
                            contRepaySked.setMemo(contRepaySkedVoList.get(j).getMemoChecked());//备注
                            contRepaySked.setReceiptDate(contReceipt.getReceiptDate());//收款时间
                            if(StringUtils.isTrimBlank(contRepaySked.getReceiptDate())){
                                // 勾稽明细没有到账日期的场合，默认为收款日期
                                contRepaySked.setReceiptDate(contRepaySked.getRepayDate());
                            }
                            // 实际收款日期 <= 应收款日的场合，逾期状态更新为正常
                            if(contRepaySked.getRepayDate().compareTo(contRepaySked.getReceiptDate()) >= 0){
                                contRepaySked.setOverdueStatus(OverDueStatusEnums.NOT_OVERDUE.getType());// 0-正常
                            }
                            if(InputModeEnums.SHORTFALL.getType().equals(contReceipt.getInputMode())){
                                contRepaySked.setDeductionAmount(TrimBigDecimal(contRepaySked.getDeductionAmount()).add(TrimBigDecimal(toBeReceiptAmount)));//抵扣租金+待勾稽金额
                            }
                            contRepaySkedList.add(contRepaySked);
                        } else if(ReceiptBizTypeEnums.OVERDUE_AMOUNT.getType().equals(contRepaySkedVoList.get(j).getReceiptBizType())){
                            //更新还款逾期罚息表 扣款状态=成功
                            contOverdue.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());//2-成功
                            contOverdue.setReceiptAmount(contRepaySkedVoList.get(j).getOverdueAmount().subtract(TrimBigDecimal(contOverdue.getExemptAmount())));//已收金额=逾期罚息额-免除额
                            contOverdue.setRestOverdueAmount(BigDecimal.ZERO);//剩余罚息金额=0
//                            contOverdue.setInvoiceDate(contRepaySkedVoList.get(j).getInvoiceDate());//开票时间
                            contOverdue.setMemo(contRepaySkedVoList.get(j).getMemoChecked());//备注
                            contOverdue.setReceiptDate(contReceipt.getReceiptDate());//收款时间
                            contOverdueUpdateList.add(contOverdue);
                        }
                    }
                    //向财务勾稽表登录数据
                    ContReceiptExam newContReceiptExam = new ContReceiptExam();
                    newContReceiptExam.setReceiptBizType(contRepaySkedVoList.get(j).getReceiptBizType());
                    newContReceiptExam.setReceiptBizId(contRepaySkedVoList.get(j).getRepaySkedId());
                    newContReceiptExam.setContReceiptId(contReceiptVoList.get(i).getContReceiptId());
                    newContReceiptExam.setReceiptExamAmount(toBeReceiptAmount);
                    if("1".equals(contReceiptPostVo.getSolveFlag())){
                        newContReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());//1-已勾稽
                    } else {
                        // 认领的场合
                        newContReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CLAIM.getType());//0-已认领
                    }
                    contReceiptExamInsertList.add(newContReceiptExam);
                    //生成财务凭证
                    /*if(InputModeEnums.IMPORT.getType().equals(contReceipt.getInputMode()) || InputModeEnums.INPUT.getType().equals(contReceipt.getInputMode())){
                        //只有画面录入或导入的收款才生成财务凭证
                        saveFinVouDatas(contRepaySkedVoList.get(j),newContReceiptExam.getReceiptExamAmount(),contReceipt);
                    }*/
                    contRepaySkedNumList.add(j);
                    flag = false;
                    if(restAmount.compareTo(BigDecimal.ZERO) == 0){
                        break;
                    }
                } else {
                    if(contReceipt != null){
                        if (contReceipt.getRestAmount().compareTo(BigDecimal.ZERO) > 0) {
                            // TODO 判断是否插入抵扣租金的客户费用信息
                            setAddContCostData(contCost, TrimBigDecimal(contReceipt.getRestAmount()), contCostList);
                        }
                        //更新财务收款表 剩余金额 = 0
                        contReceipt.setRestAmount(BigDecimal.ZERO);
                        contReceiptList.add(contReceipt);

                        if (ReceiptBizTypeEnums.REPAYMENT_AMOUNT.getType().equals(contRepaySkedVoList.get(j).getReceiptBizType())){
                            //更新融资合同还款计划表
                            contRepaySked.setReceiptAmount(TrimBigDecimal(contRepaySked.getReceiptAmount()).add(TrimBigDecimal(restAmount)));//已收金额+剩余金额
                            contRepaySked.setReceiptDate(contReceipt.getReceiptDate());//收款时间
                            contRepaySked.setMemo(contRepaySkedVoList.get(j).getMemoChecked());//备注
                            if(InputModeEnums.SHORTFALL.getType().equals(contReceipt.getInputMode())){
                                contRepaySked.setDeductionAmount(TrimBigDecimal(contRepaySked.getDeductionAmount()).add(TrimBigDecimal(restAmount)));//抵扣租金+剩余金额
                            }
                        } else if(ReceiptBizTypeEnums.OVERDUE_AMOUNT.getType().equals(contRepaySkedVoList.get(j).getReceiptBizType())){
                            //更新还款逾期罚息表
                            contOverdue.setReceiptAmount(TrimBigDecimal(contOverdue.getReceiptAmount()).add(TrimBigDecimal(restAmount)));//已收金额+剩余金额
                            contOverdue.setRestOverdueAmount(TrimBigDecimal(contOverdue.getRestOverdueAmount()).subtract(TrimBigDecimal(restAmount)));//剩余罚息金额-剩余金额
                            contOverdue.setReceiptDate(contReceipt.getReceiptDate());//收款时间
                            contOverdue.setMemo(contRepaySkedVoList.get(j).getMemoChecked());//备注
                        }

                        //向财务勾稽表登录数据 勾稽金额 = 剩余金额；勾稽状态 = 已勾稽
                        ContReceiptExam newContReceiptExam = new ContReceiptExam();
                        newContReceiptExam.setReceiptBizType(contRepaySkedVoList.get(j).getReceiptBizType());
                        newContReceiptExam.setReceiptBizId(contRepaySkedVoList.get(j).getRepaySkedId());
                        newContReceiptExam.setContReceiptId(contReceiptVoList.get(i).getContReceiptId());
                        newContReceiptExam.setReceiptExamAmount(restAmount);
                        if("1".equals(contReceiptPostVo.getSolveFlag())){
                            newContReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());//1-已勾稽
                        } else {
                            newContReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CLAIM.getType());//0-已认领
                        }
                        contReceiptExamInsertList.add(newContReceiptExam);
                        //生成财务凭证
                        /*if(InputModeEnums.IMPORT.getType().equals(contReceipt.getInputMode()) || InputModeEnums.INPUT.getType().equals(contReceipt.getInputMode())){
                            //只有画面录入或导入的收款才生成财务凭证
                            saveFinVouDatas(contRepaySkedVoList.get(j),newContReceiptExam.getReceiptExamAmount(),contReceipt);
                        }*/
                        toBeReceiptAmount = TrimBigDecimal(toBeReceiptAmount).subtract(TrimBigDecimal(restAmount));
                        flag = true;
                        break;
                    }
                }
            }
        }
        // TODO 保存客户费用信息
        if (ArrayUtils.isNotNullAndLengthNotZero(contCostList)) {
            contCostRepository.insertDataList(contCostList);
        }
        //将最后未完全勾稽的数据放进list更新，实体重写equalsf方法，为各自的id
        if(StringUtils.isNotTrimBlank(contRepaySked.getRepaySkedId()) && !contRepaySkedList.contains(contRepaySked)){
            contRepaySkedList.add(contRepaySked);
        }
        if(StringUtils.isNotTrimBlank(contOverdue.getContOverdueId()) && !contOverdueUpdateList.contains(contOverdue)){
            contOverdueUpdateList.add(contOverdue);
        }
        //保存开票信息，只保存实际有收款的数据，下面为保存备注信息的数据不开票
        saveInvoice(contRepaySkedList,contOverdueUpdateList,contOverdueOldList,invoiceList,updateInvoiceList);


        //保存备注
        for(ContRepaySkedVo contRepaySkedVo : contRepaySkedVoList) {
            if (ReceiptBizTypeEnums.REPAYMENT_AMOUNT.getType().equals(contRepaySkedVo.getReceiptBizType())) {
                ContRepaySked contRepaySkedNew = new ContRepaySked();
                contRepaySkedNew.setRepaySkedId(contRepaySkedVo.getRepaySkedId());
//                contRepaySkedNew.setInvoiceDate(contRepaySkedVo.getInvoiceDate());
                contRepaySkedNew.setMemo(contRepaySkedVo.getMemoChecked());
                if (StringUtils.isNotTrimBlank(contRepaySkedNew.getRepaySkedId()) && !contRepaySkedList.contains(contRepaySkedNew)) {
                    contRepaySkedList.add(contRepaySkedNew);
                }
            } else if (ReceiptBizTypeEnums.OVERDUE_AMOUNT.getType().equals(contRepaySkedVo.getReceiptBizType())) {
                ContOverdue contOverduedNew = new ContOverdue();
                contOverduedNew.setContOverdueId(contRepaySkedVo.getRepaySkedId());
//                contOverduedNew.setInvoiceDate(contRepaySkedVo.getInvoiceDate());
                contOverduedNew.setMemo(contRepaySkedVo.getMemoChecked());
                if (StringUtils.isNotTrimBlank(contOverduedNew.getContOverdueId()) && !contOverdueUpdateList.contains(contOverduedNew)) {
                    contOverdueUpdateList.add(contOverduedNew);
                }
            }
        }

        //更新融资还款计划表
        contRepaySkedRepository.updateByPrimaryKeySelectiveDataList(contRepaySkedList);
        //更新还款逾期罚息表
        contOverdueRepository.updateByPrimaryKeySelectiveDataList(contOverdueUpdateList);
        //更新财务收款表
        contReceiptRepository.updateByPrimaryKeySelectiveDataList(contReceiptList);
        //登录财务勾稽表
        contReceiptExamRepository.insertDataList(contReceiptExamInsertList);
        //更新财务勾稽表
        contReceiptExamRepository.updateByPrimaryKeySelectiveDataList(contReceiptExamUpdateList);
        //插入开票信息
        invoiceRepository.insertDataList(invoiceList);
        //更新开票信息
        invoiceRepository.updateByPrimaryKeySelectiveDataList(updateInvoiceList);
        //根据本次更新的还款计划表处理对应的逾期罚息表
        updateOverdue(contRepaySkedList);

    }
    /**
     * @Description: 修复逾期数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/20 15:20
     */
    private void updateOverdue(List<ContRepaySked> contRepaySkedList) {
        if(ArrayUtils.isNullOrLengthZero(contRepaySkedList)){
            return;
        }
        List<String> contOverdueDelList = new ArrayList<>();
        List<ContOverdue> contOverdueUpdList = new ArrayList<>();
        for(int i=0;i<contRepaySkedList.size();i++){
            ContRepaySked contRepaySked = contRepaySkedList.get(i);
            if(RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())){
                //收款成功的根据合同编号和期数取得逾期数据
                //逾息金额
                Example contOverdueExample = SqlUtil.newExample(ContOverdue.class);
                contOverdueExample.createCriteria().andEqualTo("contNo", contRepaySked.getContNo()).andEqualTo("period",contRepaySked.getPeriod());
                //查询租金明细信息（还款逾期罚息表信息）
                ContOverdue contOverdue = contOverdueRepository.selectOneByExample(contOverdueExample);
                if(contOverdue != null){
                    // 应还款日>=实际还款日
                    if(contRepaySked.getRepayDate().compareTo(contRepaySked.getReceiptDate()) >= 0){
                        // 该逾期数据没有关联的业务数据，可删除
                        if(contOverdue.getReceiptAmount().compareTo(BigDecimal.ZERO) == 0  && contOverdue.getExemptAmount().compareTo(BigDecimal.ZERO) == 0 ){
                            contOverdueDelList.add(contOverdue.getContOverdueId());
                        }else{
                            updateOverdueAmount(contRepaySked,contOverdue);
                            contOverdueUpdList.add(contOverdue);
                        }
                    }else{
                        updateOverdueAmount(contRepaySked,contOverdue);
                        contOverdueUpdList.add(contOverdue);
                    }
                }
            }
        }
        //更新还款逾期罚息表
        if(ArrayUtils.isNotNullAndLengthNotZero(contOverdueUpdList)){
            contOverdueRepository.updateByPrimaryKeySelectiveDataList(contOverdueUpdList);
        }
        //更新还款逾期罚息表
        if(ArrayUtils.isNotNullAndLengthNotZero(contOverdueDelList)){
            contOverdueRepository.deleteDataList(contOverdueDelList,new ContOverdue());
        }
    }

    // 根据实际收款日期计算罚息金额
    private void updateOverdueAmount(ContRepaySked contRepaySked, ContOverdue contOverdue) {
        //逾期天数
        int days = DateUtils.getDay(contRepaySked.getRepayDate(),contRepaySked.getReceiptDate());
        if(days < 0){
            days = 0;
        }
        //逾期罚息 = 租金*日利率*天数
        BigDecimal overDueAmount = contRepaySked.getRent().multiply(BigDecimalUtils.dividePercent(contOverdue.getOverdueDayRate())).multiply(new BigDecimal(days)).setScale(0,BigDecimal.ROUND_UP);
        contOverdue.setOverdueDays(days);
        //罚息金额
        contOverdue.setOverdueAmount(overDueAmount);
        //罚息剩余金额 = 罚息金额-罚息已收金额-罚息免除金额
        contOverdue.setRestOverdueAmount(overDueAmount.subtract(contOverdue.getReceiptAmount()).subtract(contOverdue.getExemptAmount()));
        if(contOverdue.getRestOverdueAmount().compareTo(BigDecimal.ZERO) <= 0){
            contOverdue.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());
        }
    }

    /**
     * @Description: 保存开票信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/20 15:20
     */
    private void saveInvoice(List<ContRepaySked> contRepaySkedList, List<ContOverdue> contOverdueUpdateList, List<ContOverdue> contOverdueOldList, List<Invoice> invoiceList,List<Invoice> updateInvoiceList) {
        //存放已查询过的合同
        Map<String, ContractFinanceVo> contractFinanceMap = new HashMap<>();
        ContractFinanceVo contractFinanceVo = null;
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
        //保存租金开票信息
        if(ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedList)){
            for (ContRepaySked contRepaySked : contRepaySkedList) {
                //如果扣款状态不成功，不开票
                if (!RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())) {
                    continue;
                }
                //开票类型，默认是租金
                String invoiceType = InvoiceTypeEnums.RENT.getType();
                if(RepayTypeEnums.INIT_AMOUNT.getType().equals(contRepaySked.getRepayType())){
                    invoiceType = InvoiceTypeEnums.INIT_AMOUNT.getType();
                } else if (RepayTypeEnums.FINAL_AMOUNT.getType().equals(contRepaySked.getRepayType())) {
                    invoiceType = InvoiceTypeEnums.FINAL_AMOUNT.getType();
                }
                //查询合同融资信息
                contractFinanceVo = contractFinanceMap.get(contRepaySked.getContNo());
                if(contractFinanceVo == null){
                    contractFinanceMap.put(contRepaySked.getContNo(), contractFinanceRepository.selectContractFinanceVoByContNo(contRepaySked.getContNo()));
                    contractFinanceVo = contractFinanceMap.get(contRepaySked.getContNo());
                }
                //查询开票信息
                Invoice invoice = findInvoice(invoiceType,contRepaySked.getContNo(),contRepaySked.getPeriod()+"");
                //构造开票信息
                invoice.setInvoiceDataType(invoiceType);
                invoice.setContNo(contRepaySked.getContNo());
                invoice.setDetailNo(contRepaySked.getPeriod()+"");
                invoice.setReceiveDate(new Date());
                //如果是回租赁
                if(LicenseAttrEnums.LEASE_BACK.getType().equals(contractFinanceVo.getLicenseAttr())){
                    invoice.setReceiveAccount(contRepaySked.getRentActual());//应收金额=实际租金
                    invoice.setReceiveActualAccount(contRepaySked.getReceiptAmount());//实收金额=到账金额
                    //如果未开票
                    if (StringUtils.isTrimBlank(invoice.getInvoiceStatus()) ||
                            InvoiceStatusEnums.NO_INVOICE.equals(invoice.getInvoiceStatus())) {
                        invoice.setInvoiceAmount(contRepaySked.getInterest());//开票金额=当期利息
                        invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());//未开票
                        invoice.setInvoiceVoucherStatus(YesNoFlagEnums.NO.getType());//未生成凭证
                    }
                    invoice.setInvoiceTax(invoiceTax6);
                }else{
                    invoice.setReceiveAccount(contRepaySked.getRentActual());//应收金额=实际租金
                    invoice.setReceiveActualAccount(contRepaySked.getReceiptAmount());//实收金额=到账金额
                    //如果未开票
                    if (StringUtils.isTrimBlank(invoice.getInvoiceStatus()) ||
                            InvoiceStatusEnums.NO_INVOICE.equals(invoice.getInvoiceStatus())) {
                        invoice.setInvoiceAmount(contRepaySked.getReceiptAmount().subtract(TrimBigDecimal(contRepaySked.getDeductionAmount())));//开票金额=到账金额-抵扣金额
                        invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());//未开票
                        invoice.setInvoiceVoucherStatus(YesNoFlagEnums.NO.getType());//未生成凭证
                    }
                    invoice.setInvoiceTax(invoiceTax16);
                }
                //开票金额大于0，保存
                if(TrimBigDecimal(invoice.getInvoiceAmount()).compareTo(BigDecimal.ZERO)>0){
                    if (StringUtils.isTrimBlank(invoice.getInvoiceId())) {
                        invoiceList.add(invoice);
                    }else{
                        updateInvoiceList.add(invoice);
                    }
                }
            }
        }
        //罚息开票金额
        if(ArrayUtils.isNotNullAndLengthNotZero(contOverdueUpdateList) && ArrayUtils.isNotNullAndLengthNotZero(contOverdueOldList)){
            for (ContOverdue contOverdue : contOverdueUpdateList) {
                //构造开票信息
                Invoice invoice = new Invoice();
                invoice.setInvoiceDataType(InvoiceTypeEnums.OVERDUE.getType());
                invoice.setContNo(contOverdue.getContNo());
                invoice.setDetailNo(contOverdue.getPeriod()+"");
                invoice.setReceiveDate(new Date());
                invoice.setInvoiceTax(invoiceTax6);//税率6
                invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());//未开票
                invoice.setInvoiceVoucherStatus(YesNoFlagEnums.NO.getType());//未生成凭证
                //拿到对应的修改前逾期罚息
                ContOverdue contOverdueOld = contOverdueOldList.get(contOverdueOldList.indexOf(contOverdue));
                //应收金额 = 罚息额-免除额
                invoice.setReceiveAccount(contOverdue.getOverdueAmount().subtract(TrimBigDecimal(contOverdue.getExemptAmount())));
                //实收金额 = 本次收款额-上次收款额
                invoice.setReceiveActualAccount(TrimBigDecimal(contOverdue.getReceiptAmount()).subtract(TrimBigDecimal(contOverdueOld.getReceiptAmount())));
                //开票金额 = 本次收款额-上次收款额
                invoice.setInvoiceAmount(TrimBigDecimal(contOverdue.getReceiptAmount()).subtract(TrimBigDecimal(contOverdueOld.getReceiptAmount())));
                //开票金额大于0，保存
                if(TrimBigDecimal(invoice.getInvoiceAmount()).compareTo(BigDecimal.ZERO)>0){
                    invoiceList.add(invoice);
                }
            }
        }
    }

    /**
     * @Description: 查找已开票信息,没有就新构建一个
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/20 15:57
     */
    @Override
    public Invoice findInvoice(String invoiceDataType, String contNo, String detailNo) {
        //合同融资信息
        Example invoiceExample = SqlUtil.newExample(Invoice.class);
        Example.Criteria criteria = invoiceExample.createCriteria();
        criteria.andEqualTo("contNo", contNo).andEqualTo("invoiceDataType",invoiceDataType);
        if(StringUtils.isNotTrimBlank(detailNo)){
            criteria.andEqualTo("detailNo", detailNo);
        }
        Invoice invoice = invoiceRepository.selectOneByExample(invoiceExample);

        return invoice == null ? new Invoice() : invoice;
    }

    /**
     * @Description: 登录当前抵扣租金的客户费用信息
     * @param: contCost 收取的保证金
     * @param: amount 抵扣金额
     * @param: addContCostList 新增客户费用信息集合
     * @return:
     * @Author: wangxue
     * @Date: 2018/8/10 15:48
     */
    private void setAddContCostData(ContCost contCost, BigDecimal amount, List<ContCost> addContCostList) {
        if (contCost != null) {
            ContCost newContCost = new ContCost();
            // 合同编号
            newContCost.setContNo(contCost.getContNo());
            // 金额
            newContCost.setCostAmount(BigDecimal.ZERO.subtract(amount));
            // 款项：保证金
            newContCost.setCostItem(contCost.getCostItem());
            // 类型  02:抵扣
            newContCost.setCostType(ContCostTypeEnums.DEDUCTION.getType());
            //收款明细id
            newContCost.setContReceiptId(contCost.getContReceiptId());
            //
            addContCostList.add(newContCost);
        }
    }

    /**
     * @Description: 根据财务收款ID，获取合同的保证金客户费用信息
     * @param: contReceiptId 财务收款ID
     * @return:
     * @Author: wangxue
     * @Date: 2018/8/10 15:48
     */
    private ContCost findContCostByContReceiptId(String contReceiptId) {
        Example example = SqlUtil.newExample(ContCost.class);
        example.createCriteria().andEqualTo("contReceiptId", contReceiptId);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return contCostRepository.selectOneByExample(example);
    }

    /**
    * @Description: 生成财务凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/10 15:48
     * @param contRepaySkedVo
     * @param receiptExamAmount
     * @param contReceipt
     */
    private void saveFinVouDatas(ContRepaySkedVo contRepaySkedVo, BigDecimal receiptExamAmount, ContReceipt contReceipt) {
        Map<String, Object> dataMap = new HashMap<>();
        //设置合同编号
        dataMap.put(FinVouDetailValueConstants.CONT_NO, contRepaySkedVo.getContNo());
        //设置凭证相关金额
        setFinVouAmount(contRepaySkedVo, receiptExamAmount, dataMap);

        //设置动态科目代码
        setFinassSubjectCdToMap(FinVouDetailValueConstants.SUBJECT_CD_DYN, contReceipt.getRecAccountNo(), dataMap);

        //获取财务核算代码
        ContractVo contractVo;
        try {
            contractVo = ResponseEntityUtils.getRestResponseData(contractRpc.findContractVoFinassCodes(contRepaySkedVo.getApplyNo(), contRepaySkedVo.getContNo()));
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("获取财务核算代码信息失败");
        }
        if(contractVo != null) {
            //车架号后6位
            dataMap.put(FinVouDetailValueConstants.VIN_NO_6, StringUtils.subStringLater(contractVo.getVinNo(),6));
            //取到订单申请人的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_CSTM_CODE, contractVo.getFinassCstmCode());
            //申请人姓名
            dataMap.put(FinVouDetailValueConstants.APPLY_PERSON_NAME, contractVo.getApplyPersonName());
            //实际销售方的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_SALES_CODE, contractVo.getFinassSalesCode());
            //出租人的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_GROUP_CODE, contractVo.getFinassGroupCode());
            //凭证区域
            dataMap.put(FinVouDetailValueConstants.VOUCHER_GROUP, contractVo.getGroupDistrict());
        }
        //获取财务凭证类型
        String voucherType = getRentalVoucherType(contractVo.getLicenseAttr());
        //获取凭证明细数据
        CommonFinVouData commonFinVouData = commonFinancialVoucherDataService.getFinVoucherData(voucherType,dataMap,contRepaySkedVo.getContNo());
        //保存凭证明细数据
        commonFinancialVoucherDataService.saveCommonFinVouData(commonFinVouData);
    }

    /**
    * @Description: 设置凭证相关金额
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/10 17:48
    */
    private void setFinVouAmount(ContRepaySkedVo contRepaySkedVo, BigDecimal receiptExamAmount, Map<String, Object> dataMap) {
        dataMap.put(FinVouDetailValueConstants.RENT, receiptExamAmount);
        if (ReceiptBizTypeEnums.REPAYMENT_AMOUNT.getType().equals(contRepaySkedVo.getReceiptBizType())){
            dataMap.put(FinVouDetailValueConstants.RECEIPT_RENT, receiptExamAmount);
            dataMap.put(FinVouDetailValueConstants.OVERDUE_AMOUNT, BigDecimal.ZERO);
        }else{
            dataMap.put(FinVouDetailValueConstants.RECEIPT_RENT, BigDecimal.ZERO);
            dataMap.put(FinVouDetailValueConstants.OVERDUE_AMOUNT, receiptExamAmount);
        }
    }

    /**
     * @Description: 获取财务凭证类型
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/8/2 20:44
     */
    private String getRentalVoucherType(String licenseAttr) {
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
                e.printStackTrace();
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
     * @Title:
     * @Description: 修改 融资合同还款计划信息
     * @param contReceiptModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public void modifyContReceipt(ContReceiptModifyVo contReceiptModifyVo){
        contReceiptRepository.updateByPrimaryKeySelectiveData(contReceiptModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contReceiptId删除 融资合同还款计划信息
     * @param contReceiptDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public void deleteContReceipt(ContReceiptDeleteVo contReceiptDeleteVo){
        contReceiptRepository.deleteData(contReceiptDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contReceiptId集合删除 融资合同还款计划信息
     * @param contReceiptDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public void deleteContReceiptsByContReceiptIds(ContReceiptDeleteListVo contReceiptDeleteListVo){
        contReceiptRepository.deleteDataList(contReceiptDeleteListVo.getContReceiptIds(),contReceiptDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据contReceiptId获取 融资合同还款计划信息
     * @param contReceiptId
     * @return ContReceipt
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public ContReceipt findContReceiptByContReceiptId(String contReceiptId){
        return contReceiptRepository.selectByPrimaryKey(contReceiptId);
    }

    /**
     * @Title:
     * @Description:  取消认领
     * @param contReceiptVo
     * @return ContReceipt
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Transactional
    public void cancelClaime(ContReceiptVo contReceiptVo){
        if(contReceiptVo.getContRepaySkedVoList() == null || (contReceiptVo.getContRepaySkedVoList() != null &&
                contReceiptVo.getContRepaySkedVoList().size() == 0)){
            throw new FmsServiceException("至少选择一条待认领详情！");
        }
        for (ContRepaySkedVo contRepaySkedVo : contReceiptVo.getContRepaySkedVoList()){
            Example example = SqlUtil.newExample(ContReceiptExam.class);
            example.createCriteria().andEqualTo("receiptBizId", contRepaySkedVo.getRepaySkedId());
            example.createCriteria().andEqualTo("receiptBizType", contRepaySkedVo.getReceiptBizType());
            ContRepaySked contRepaySked = contRepaySkedRepository.selectOneByExample(example);
            contRepaySkedRepository.deleteExampleData(example, contRepaySked);
        }

    }

    //收款明细按照到账日期升序
    private void contReceiptVoListSort(List<ContReceiptVo> list) {
        Collections.sort(list, new Comparator<ContReceiptVo>() {
            @Override
            public int compare(ContReceiptVo o1, ContReceiptVo o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date dt1 = o1.getReceiptDate();
                    Date dt2 = o2.getReceiptDate();
                    if (dt1.getTime() > dt2.getTime()) {
                        return 1;
                    } else if (dt1.getTime() < dt2.getTime()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

    //待勾稽租金按照收款日期升序
    private void contRepaySkedVoVoListSort(List<ContRepaySkedVo> list) {
        Collections.sort(list, new Comparator<ContRepaySkedVo>() {
            @Override
            public int compare(ContRepaySkedVo o1, ContRepaySkedVo o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date dt1 = o1.getReceiptDate();
                    Date dt2 = o2.getReceiptDate();
                    if (dt1.getTime() > dt2.getTime()) {
                        return 1;
                    } else if (dt1.getTime() < dt2.getTime()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

    private BigDecimal TrimBigDecimal(BigDecimal decimal){
        if(decimal == null){
            return BigDecimal.ZERO;
        }
        return decimal;
    }

    /**
     * @Title:
     * @Description:   导入收款明细
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 11:51:40
     */
    @Transactional
    public void importContReceipts(String filePath){
        List<ContReceipt> contReceipts = commonExcelService.importExcelToData(filePath,ContReceipt.class);
        for(ContReceipt contReceipt : contReceipts){
            contReceipt.setRestAmount(contReceipt.getReceiptAmount());
        }
        contReceiptRepository.insertDataList(contReceipts);
    }

    /**
     * @Title:
     * @Description:   收款明细导入模板下载
     * @param httpServletResponse
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/05/11 11:51:40
     */
    @Override
    public void exportContReceiptModalExcel(HttpServletResponse httpServletResponse) {
        try {
            ResponseUtils.outExcel(httpServletResponse,"收款明细导入模板");
            commonExcelService.exportList("收款明细导入模板",null,ContReceipt.class,httpServletResponse.getOutputStream(), ExcelTypeConstants.TWO);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("收款明细导入模板生成失败");
        }
    }

}
