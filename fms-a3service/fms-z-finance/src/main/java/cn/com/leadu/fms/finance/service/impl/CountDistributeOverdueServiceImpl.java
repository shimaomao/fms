package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonRuleService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.AddressTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.AssignmentStsEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DataSourceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.CstmRelationIdentityTypeEnums;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContOverdueRepository;
import cn.com.leadu.fms.data.finance.repository.FinRepaySkedRepository;
import cn.com.leadu.fms.data.postbiz.repository.*;
import cn.com.leadu.fms.data.prebiz.repository.*;
import cn.com.leadu.fms.finance.service.CountDistributeOverdueService;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleOverdueAssignmentVo;
import cn.com.leadu.fms.pojo.postbiz.entity.*;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.OverdueDataVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.CstmPersonAddTelVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Title: fms
 * @Description: 逾期数据统计和分配
 * @author: ningyangyang
 * @date 2018/5/22 16:25
 */
@Slf4j
@Service
public class CountDistributeOverdueServiceImpl implements CountDistributeOverdueService {

    /**
     * @Fields  : 任务号获取service
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  :  融资合同还款计划信息repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 财务还款计划信息repository
     */
    @Autowired
    private FinRepaySkedRepository finRepaySkedRepository;

    /**
     * @Fields  : 逾期合同repository
     */
    @Autowired
    private OverdueContRepository overdueContRepository;

    /**
     * 逾期罚息Repository
     */
    @Autowired
    private ContOverdueRepository contOverdueRepository;

    /**
     * 逾期客户Repository
     */
    @Autowired
    private OverdueCstmRepository overdueCstmRepository;

    /**
     * 当日逾期任务Repository
     */
    @Autowired
    private OverdueAssignmentRepository overdueAssignmentRepository;

    /**
     * 客户个人信息Repository
     */
    @Autowired
    private CstmPersonRepository cstmPersonRepository;

    /**
     * 客户企业信息Repository
     */
    @Autowired
    private CstmCompanyRepository cstmCompanyRepository;

    /**
     * 客户联系人信息Repository
     */
    @Autowired
    private CstmContactRepository cstmContactRepository;

    /**
     * 担保人信息Repository
     */
    @Autowired
    private GuaranteePersRepository guaranteePersRepository;

    /**
     * 担保企业信息Repository
     */
    @Autowired
    private GuaranteeCompRepository guaranteeCompRepository;

    /**
     * 共同借款人信息Repository
     */
    @Autowired
    private CommonBorrowerRepository commonBorrowerRepository;

    /**
     * 逾期客户地址信息Repository
     */
    @Autowired
    private OverdueCstmAddrRepository overdueCstmAddrRepository;

    /**
     * 逾期客户电话信息Repository
     */
    @Autowired
    private OverdueCstmTelRepository overdueCstmTelRepository;

    /**
     * 上门催收任务信息Repository
     */
    @Autowired
    private CollectionTaskRepository collectionTaskRepository;

    /**
     * 诉讼任务信息Repository
     */
    @Autowired
    private LawsuitTaskRepository lawsuitTaskRepository;

    /**
     * 收车任务信息Repository
     */
    @Autowired
    private RetrieveCarsTaskRepository retrieveCarsTaskRepository;

    /**
     * 系统常量共通Service
     */
    @Autowired
    private CommonConstantService commonConstantService;
    /**
     * 规则引擎共通共通Service
     */
    @Autowired
    private CommonRuleService commonRuleService;
    /**
     * 催收人员信息Repository
     */
    @Autowired
    private CollectionPersonRepository collectionPersonRepository;
    /**
     * 订单信息Repository
     */
    @Autowired
    private ApplyRepository applyRepository;

    /**
     * @Title:
     * @Description: 逾期数据统计和分配（定时任务）
     * @throws
     * @author wangxue
     * @date 2018-9-3 17:11:36
     */
    @Override
    public void distributeOverdueData() {
        // 从销售还款计划表中获取车辆的逾期信息
        // 设置查询条件
        List<String> repayStatusList = new ArrayList<>();
        repayStatusList.add(RepayStatusEnums.TO_BE_WITHHELD.getType());
        repayStatusList.add(RepayStatusEnums.WITHDRAWING.getType());
        repayStatusList.add(RepayStatusEnums.WITHDRAWING_FAILURE.getType());
        List<OverdueDataVo> overdueDataVoList = contRepaySkedRepository.selectOverdueDataVoGroupByContNo(repayStatusList);
        // 获取当前全部的逾期客户信息
        Example overdueCstmExample = new Example(OverdueCstm.class);
        overdueCstmExample.createCriteria().andEqualTo("overdueFlag", YesNoFlagEnums.YES.getType());
        List<OverdueCstm> overdueCstms = overdueCstmRepository.selectListByExample(overdueCstmExample);
        // 本次处理需要将当前是否逾期更新不逾期的逾期客户ID集合
        List<String> delOverdueCstmIdList = new ArrayList<>();
        // 获取当前逾期客户对应的逾期客户ID
        Map<String,String> overdueCstmIdMap = getOverdueCstmIdMapFromList(overdueCstms, delOverdueCstmIdList);
        // 逾期合同的历史逾期次数和历史最高逾期天数
        Map<String, OverdueContVo> overdueHisMap = getOverdueHistoryData();
        // 客户的逾期合同信息,客户的证件号码作为mapKey
        Map<String, List<OverdueDataVo>> overdueDataVoMap = new HashMap<>();
        // 逾期客户信息
        Map<String, OverdueCstm> overdueCstmMap = new HashMap<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueDataVoList)) {
            for (OverdueDataVo overdueDataVo : overdueDataVoList) {
                // 循环取得的逾期数据
                overdueDataHandler(overdueDataVo, overdueDataVoMap, overdueCstmMap, overdueCstmIdMap, overdueHisMap);
            }
            // 保存更新逾期客户和逾期合同信息
            saveOverdueContAndCstm(overdueDataVoMap, overdueCstmMap,delOverdueCstmIdList);
        }
    }

    /**
     * @Title:
     * @Description: 获得OverdueCstm对象数据
     * @param  overdueDataVo 要处理的逾期数据
     * @param  overdueDataVoMap 逾期客户的合同信息Map
     * @param  overdueCstmMap 逾期客户信息Map
     * @param  overdueCstmIdMap 逾期客户的逾期客户IDMap
     * @param  overdueHisMap 合同的历史最高逾期天数及逾期次数
     * @throws
     * @author wangxue
     * @date 2018-9-4 16:11:36
     */
    private void overdueDataHandler(OverdueDataVo overdueDataVo, Map<String, List<OverdueDataVo>> overdueDataVoMap, Map<String, OverdueCstm> overdueCstmMap
            , Map<String,String> overdueCstmIdMap, Map<String, OverdueContVo> overdueHisMap) {
        // 当前逾期天数
        overdueDataVo.setOverdueDays(DateUtils.getDay(overdueDataVo.getMinRepayDate(), new Date()));
        // 根据合同号获取当前逾期罚息
        BigDecimal overdueAmount = contOverdueRepository.selectContOverdueAmountByContNo(overdueDataVo.getContNo());
        overdueDataVo.setOverdueAmount(overdueAmount == null ? BigDecimal.ZERO : overdueAmount);
        // 当前逾期总额
        overdueDataVo.setOverdueSum(overdueDataVo.getOverdueRent().add(overdueDataVo.getOverdueAmount()));
        // 当前销售未还剩余本金
        BigDecimal restPrincipalAmount =  contRepaySkedRepository.selectRestPrincipalAmountByContNo(overdueDataVo.getContNo());
        overdueDataVo.setRestPrincipal(restPrincipalAmount == null ? BigDecimal.ZERO : restPrincipalAmount);
        // 当前财务未还剩余本金,关联销售还款计划表，查询未还款的数据
        BigDecimal finRestPrincipalAmount = finRepaySkedRepository.selectRestPrincipalAmountByContNo(overdueDataVo.getContNo());
        overdueDataVo.setFinRestPrincipal(finRestPrincipalAmount == null ? BigDecimal.ZERO : finRestPrincipalAmount);
        // 已还期数
        Integer repayPeriods = contRepaySkedRepository.selectAlreadyRepaySkeCountByContNo(overdueDataVo.getContNo());
        overdueDataVo.setRepayPeriods(repayPeriods);  //已还期数
        // 历史最高逾期天数和逾期次数
        if (StringUtils.isTrimBlank(overdueDataVo.getOverdueContId())) {
            // 初次或再次逾期新增的场合，从逾期合同信息表中获取历史最高逾期天数和逾期次数
            OverdueContVo overdueContVo = overdueHisMap.get(overdueDataVo.getContNo());
            if (overdueContVo != null) {
                // 历史最高逾期天数
                overdueDataVo.setOverdueDaysHis(overdueContVo.getOverdueDaysHis());
                // 逾期次数
                overdueDataVo.setOverdueTimes(overdueContVo.getOverdueTimes() + 1);
            } else {
                // 历史最高逾期天数
                overdueDataVo.setOverdueDaysHis(overdueDataVo.getOverdueDays());
                // 逾期次数
                overdueDataVo.setOverdueTimes(1);
            }
        }
        if (overdueDataVo.getOverdueDays().compareTo(overdueDataVo.getOverdueDaysHis()) > 0) {
            // 当前逾期天数大于最高逾期天数的场合
            overdueDataVo.setOverdueDaysHis(overdueDataVo.getOverdueDays());
        }
        // 根据证件号码，从overdueDataVoMap中获取客户的逾期合同信息list
        List<OverdueDataVo> tempOverdueDataVos = overdueDataVoMap.get(overdueDataVo.getCertifNo());
        OverdueCstm overdueCstm;
        if (ArrayUtils.isNullOrLengthZero(tempOverdueDataVos)) {
            //
            tempOverdueDataVos = new ArrayList<>();
            overdueCstm = getOverdueCstm(overdueDataVo, overdueCstmIdMap.get(overdueDataVo.getCertifNo()));
        } else {
            // overdueDataVoMap中客户信息存在的场合, 累加逾期金额等数据
            overdueCstm = overdueCstmMap.get(overdueDataVo.getCertifNo());
            setOverdueCstmAdd(overdueCstm, overdueDataVo);
        }
        // 以件号码作为mapkey，以逾期客户信息作为value保存到overdueCstmMap中
        overdueCstmMap.put(overdueCstm.getCertifNo(), overdueCstm);
        overdueDataVo.setOverdueCstmId(overdueCstm.getOverdueCstmId());
        // 将不同客户的逾期合同分为各自的逾期合同信息list，然后以证件号码作为mapkey，以逾期合同list作为value保存到overdueDataVoMap中
        tempOverdueDataVos.add(overdueDataVo);
        overdueDataVoMap.put(overdueDataVo.getCertifNo(), tempOverdueDataVos);
    }

    /**
     * @Title:
     * @Description: 保存和更新逾期合同信息及逾期客户信息，更新当期逾期任务数据
     * @param  overdueDataVoMap 逾期客户的合同信息Map
     * @param  overdueCstmMap 逾期客户信息Map
     * @throws
     * @author wangxue
     * @date 2018-9-3 17:11:36
     */
    private void saveOverdueContAndCstm(Map<String, List<OverdueDataVo>> overdueDataVoMap, Map<String, OverdueCstm> overdueCstmMap, List<String> delOverdueCstmIdList) {
        // 获取当前是否逾期为“1：是”的全部逾期客户ID
        List<String> delOverdueContIdList = overdueContRepository.selectOverdueContIdsByOverdueFlag();
        // 当日逾期任务，新增数据
        List<OverdueAssignment> addOverdueAssignmentList = new ArrayList<>();
        // 当日新增的逾期客户数据
        List<OverdueCstm> addOverdueCstmList = new ArrayList<>();
        // 当日跟新的的逾期客户数据
        List<OverdueCstm> updOverdueCstmList = new ArrayList<>();
        // 当日新增的逾期客户数据
        List<OverdueCont> addOverdueContList = new ArrayList<>();
        // 当日更新的逾期客户数据
        List<OverdueCont> updOverdueContList = new ArrayList<>();
        // 当日逾期任务，更新数据
        List<String> updOverdueAssignmentList = new ArrayList<>();
        // 新增逾期合同的订单编号集合
        List<String> applyNoList = new ArrayList<>();
        // 保存或更新逾期客户及逾期合同信息
        for (Map.Entry entry : overdueCstmMap.entrySet()) {
            OverdueCstm overdueCstm = (OverdueCstm)entry.getValue();
            if (StringUtils.isTrimBlank(overdueCstm.getOverdueCstmId())) {
                // 新增逾期客户信息
                overdueCstm.setFirstOverdueDate(new Date());
                // 逾期客户ID
                overdueCstm.setOverdueCstmId(UUIDUtils.getUUID());
                addOverdueCstmList.add(overdueCstm);
                // 当日逾期任务数据新增
                OverdueAssignment overdueAssignment = new OverdueAssignment();
                overdueAssignment.setOverdueCstmId(overdueCstm.getOverdueCstmId()); // 逾期客户ID
                overdueAssignment.setAssignDate(new Date()); // 初登日期
                overdueAssignment.setFistOverdueFlag(YesNoFlagEnums.YES.getType()); // 是否新进数：是
                overdueAssignment.setAssignmentSts(AssignmentStsEnums.UNTREATED.getType()); // 任务处理状态
                // 根据规则分配人员
                // 查询出该客户最新的订单的风控初审人员
                String riskApproveUser = "";
                if (StringUtils.isNotTrimBlank(overdueCstm.getCertifNo())) {
                    riskApproveUser = applyRepository.selectApproveUserByCertifNo(overdueCstm.getCertifNo());
                }
                //规则引擎取得天数
                RuleOverdueAssignmentVo ruleOverdueAssignmentVo = new RuleOverdueAssignmentVo();
                ruleOverdueAssignmentVo.setRiskApproveUser(riskApproveUser);
                commonRuleService.get(ruleOverdueAssignmentVo, RuleTypeEnums.OVERDUE_ASSIGNMENT.getType(), RuleTypeEnums.OVERDUE_ASSIGNMENT.getKey());
                String collectionType = ruleOverdueAssignmentVo.getCollectionType();
                overdueAssignment.setAssignmentType(collectionType); // 催收类别
                overdueAssignment.setAssignUser(getRandomCollectionPersonName(collectionType)); // 分配人员账号
                addOverdueAssignmentList.add(overdueAssignment);
            } else {
                delOverdueCstmIdList.remove(overdueCstm.getOverdueCstmId());
                updOverdueCstmList.add(overdueCstm);
                // 当日逾期任务,更新的数据
                updOverdueAssignmentList.add(overdueCstm.getOverdueCstmId());
            }
            // 处理当前客户的逾期合同数据
            saveOrUpdateOverdueCont(overdueDataVoMap.get(overdueCstm.getCertifNo()), overdueCstm.getOverdueCstmId(),delOverdueContIdList, applyNoList, addOverdueContList, updOverdueContList);
        }
        // 获取进入过逾期客户表送的全部订单号
        List<String> oldApplyNoList = null;
        if (StringUtils.isNotTrimBlank(applyNoList)) {
            oldApplyNoList = overdueContRepository.selectAllApplyNosByOverdue();
        }
        oldApplyNoList = oldApplyNoList == null ? new ArrayList<>() : oldApplyNoList;
        // 新增逾期客户数据
        overdueCstmRepository.insertDataList(addOverdueCstmList);
        // 更新逾期客户数据
        overdueCstmRepository.updateByPrimaryKeySelectiveDataList(updOverdueCstmList);
        // 新增逾期合同数据
        overdueContRepository.insertDataList(addOverdueContList);
        // 更新逾期客户数据
        overdueContRepository.updateByPrimaryKeySelectiveDataList(updOverdueContList);
        // 处理历史逾期当前不逾期的数据
        // 根据逾期合同ID，删除当前不逾期的数据（逾期合同ID not in 当前逾期的逾期合同DI集合）
        if (ArrayUtils.isNotNullAndLengthNotZero(delOverdueContIdList)) {
            OverdueCont overdueCont = new OverdueCont();
            overdueCont.setOverdueFlag(YesNoFlagEnums.NO.getType()); // 当前是否逾期
            overdueCont.setOverdueHandleDate(new Date()); // 逾期处理日期
            Example example = new Example(OverdueCont.class);
            example.createCriteria().andEqualTo("overdueFlag", YesNoFlagEnums.YES.getType()).andIn("overdueContId", delOverdueContIdList);
            overdueContRepository.updateByExampleSelectiveData(overdueCont, example);
        }
        // 根据逾期客户ID，删除当前不逾期的数据（逾期客户ID not in 当前逾期的逾期客户DI集合）
        if (ArrayUtils.isNotNullAndLengthNotZero(delOverdueCstmIdList)) {
            OverdueCstm overdueCstm = new OverdueCstm();
            overdueCstm.setOverdueFlag(YesNoFlagEnums.NO.getType());
            Example example = new Example(OverdueCstm.class);
            example.createCriteria().andEqualTo("overdueFlag", YesNoFlagEnums.YES.getType()).andIn("overdueCstmId", delOverdueCstmIdList);
            overdueCstmRepository.updateByExampleSelectiveData(overdueCstm, example);
        }

        // 保存更新当日逾期任务数据
        saveOverdueAssignment(addOverdueAssignmentList, updOverdueAssignmentList, delOverdueCstmIdList);
        // 保存逾期客户的地址和电话信息
        saveOverdueCstmAddrAndTel(applyNoList, oldApplyNoList);
        // 保存上门催收任务数据
        saveCollectionTask(addOverdueCstmList, updOverdueCstmList);
        // 保存收车任务数据
        saveRetrieveCarTask(addOverdueContList, updOverdueContList);
        // TODO 保存诉讼任务数据，流入到诉讼池暂时不做
//        saveLawsuitTask(addOverdueContList, updOverdueContList);
    }

    /**
     * @Title:
     * @Description: 保存逾期合同信息
     * @param  overdueDataVoList 逾期合同信息集合
     * @param  overdueCstmId 逾期客户ID
     * @param  delOverdueContIdList 逾期客户ID集合
     * @param  applyNoList 新增的订单编号集合
     * @param  addOverdueContList 新增的逾期合同数据
     * @param  updOverdueContList 更新的逾期合同数据
     * @throws
     * @author wangxue
     * @date 2018-9-3 17:11:36
     */
    private void saveOrUpdateOverdueCont(List<OverdueDataVo> overdueDataVoList, String overdueCstmId,List<String> delOverdueContIdList, List<String> applyNoList
            ,List<OverdueCont> addOverdueContList, List<OverdueCont> updOverdueContList) {
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueDataVoList)) {
            for (OverdueDataVo overdueDataVo : overdueDataVoList) {
                if (StringUtils.isTrimBlank(overdueDataVo.getOverdueContId())) {
                    // 新增数据
                    OverdueCont overdueCont = overdueDataVo.getEntity();
                    // 逾期客户ID
                    overdueCont.setOverdueCstmId(overdueCstmId);
                    // 初登日期
                    overdueCont.setFirstOverdueDate(new Date());
                    // 当前是否逾期
                    overdueCont.setOverdueFlag(YesNoFlagEnums.YES.getType());
                    // 生成逾期客户ID
                    overdueCont.setOverdueContId(UUIDUtils.getUUID());
                    addOverdueContList.add(overdueCont);
                    // 新增订单编号
                    if (ArrayUtils.notEqualsContains(applyNoList, overdueCont.getApplyNo())) {
                        applyNoList.add(overdueCont.getApplyNo());
                    }
                } else {
                    // 更新数据
                    OverdueCont overdueCont = new OverdueCont();
                    // 当前逾期天数
                    overdueCont.setOverdueDays(overdueDataVo.getOverdueDays());
                    // 当前逾期期数
                    overdueCont.setOverduePeriods(overdueDataVo.getOverduePeriods());
                    // 当前逾期本金
                    overdueCont.setOverduePrincipal(overdueDataVo.getOverduePrincipal());
                    // 当前逾期租金
                    overdueCont.setOverdueRent(overdueDataVo.getOverdueRent());
                    // 当前逾期罚息
                    overdueCont.setOverdueAmount(overdueDataVo.getOverdueAmount());
                    // 当前逾期总额
                    overdueCont.setOverdueSum(overdueDataVo.getOverdueSum());
                    // 当前销售未还剩余本金
                    overdueCont.setRestPrincipal(overdueDataVo.getRestPrincipal());
                    // 当前财务未还剩余本金
                    overdueCont.setFinRestPrincipal(overdueDataVo.getFinRestPrincipal());
                    // 已还期数
                    overdueCont.setRepayPeriods(overdueDataVo.getRepayPeriods());
                    // 历史最高逾期天数
                    overdueCont.setOverdueDaysHis(overdueDataVo.getOverdueDaysHis());
                    // 逾期合同ID
                    overdueCont.setOverdueContId(overdueDataVo.getOverdueContId());
                    // 合同编号
                    overdueCont.setContNo(overdueDataVo.getContNo());
                    // 订单编号
                    overdueCont.setApplyNo(overdueDataVo.getApplyNo());
                    // 修改数据的订单编号
                    if (ArrayUtils.notEqualsContains(applyNoList, overdueCont.getApplyNo())) {
                        applyNoList.add(overdueCont.getApplyNo());
                    }
                    updOverdueContList.add(overdueCont);
                    delOverdueContIdList.remove(overdueDataVo.getOverdueContId());
                }
            }
        }
    }

    /**
     * @Title:
     * @Description: 保存更新当日逾期任务数据
     * @param addOverdueAssignmentList 新增当日逾期任务集合
     * @param updOverdueAssignmentList 更新当日逾期任务集合
     * @param delOverdueCstmIdList 本次不在逾期的逾期客户ID集合
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void saveOverdueAssignment(List<OverdueAssignment> addOverdueAssignmentList, List<String> updOverdueAssignmentList,List<String> delOverdueCstmIdList) {
        // 新增当日逾期任务数据
        if (ArrayUtils.isNotNullAndLengthNotZero(addOverdueAssignmentList)) {
            overdueAssignmentRepository.insertDataList(addOverdueAssignmentList);
        }
        // 更新当日逾期任务的是否新进数为0：否
        if (ArrayUtils.isNotNullAndLengthNotZero(updOverdueAssignmentList)) {
            OverdueAssignment overdueAssignment = new OverdueAssignment();
            overdueAssignment.setFistOverdueFlag(YesNoFlagEnums.NO.getType());
            Example example = new Example(OverdueAssignment.class);
            example.createCriteria().andNotEqualTo("assignmentSts", AssignmentStsEnums.CANCEL.getType()).andIn("overdueCstmId", updOverdueAssignmentList);
            overdueAssignmentRepository.updateByExampleSelectiveData(overdueAssignment, example);
        }
        // 更新当日逾期任务的处理状态为2：作废
        if (ArrayUtils.isNotNullAndLengthNotZero(delOverdueCstmIdList)) {
            OverdueAssignment overdueAssignment = new OverdueAssignment();
            overdueAssignment.setAssignmentSts(AssignmentStsEnums.CANCEL.getType());
            overdueAssignment.setCancelDate(new Date());
            Example example = new Example(OverdueAssignment.class);
            example.createCriteria().andNotEqualTo("assignmentSts", AssignmentStsEnums.CANCEL.getType()).andIn("overdueCstmId", delOverdueCstmIdList);
            overdueAssignmentRepository.updateByExampleSelectiveData(overdueAssignment, example);
        }
    }

    /**
     * @Title:
     * @Description: 保存逾期客户的地址和电话信息
     * @param  applyNoList 新增申请编号集合
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void saveOverdueCstmAddrAndTel(List<String> applyNoList, List<String> oldApplyNoList) {
        // 逾期客户地址信息
        List<OverdueCstmAddr> overdueCstmAddrList = new ArrayList<>();
        // 逾期客户电话信息
        List<OverdueCstmTel> overdueCstmTelList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(applyNoList)) {
            for (String applyNo : applyNoList) {
                if (ArrayUtils.equalsContains(oldApplyNoList, applyNo)) {
                    // 当前申请编号在逾期合同表中有数据，则不登录该订单的地址信息和合同信息
                    continue;
                }
                // 根据申请编号获取客户个人信息
                String certifNo = null; // 主贷人证件号
                CstmPersonAddTelVo cstmPersonAddTelVo = cstmPersonRepository.selectCstmPersonAddTelVoByApplyNo(applyNo);
                if (cstmPersonAddTelVo != null) {
                    getCstmAddTelByCstmPersonAddTelVo(cstmPersonAddTelVo, overdueCstmAddrList, overdueCstmTelList);
                    certifNo = cstmPersonAddTelVo.getCertifNo();
                    // 获取共同借款人的信息
                    getCommonBorrower(certifNo, applyNo, overdueCstmAddrList, overdueCstmTelList);
                } else {
                    // 获取企业客户信息
                    Example example_comp = new Example(CstmCompany.class);
                    example_comp.createCriteria().andEqualTo("applyNo", applyNo);
                    CstmCompany cstmCompany = cstmCompanyRepository.selectOneByExample(example_comp);
                    setgetCstmAddTelByCstmCompany(cstmCompany, overdueCstmAddrList, overdueCstmTelList);
                    if (cstmCompany != null) {
                        certifNo = cstmCompany.getSocialCertifNo();
                    }
                }
                // 取得联系人、担保人、担保企业的地址和电话信息
                getContractGuaranteeData(certifNo, applyNo, overdueCstmAddrList, overdueCstmTelList);
            }
            // 保存地址信息
            if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmAddrList)) {
                overdueCstmAddrRepository.insertDataList(overdueCstmAddrList);
            }
            // 保存电话信息
            if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmTelList)) {
                overdueCstmTelRepository.insertDataList(overdueCstmTelList);
            }
        }
    }

    /**
     * @Title:
     * @Description: 获取联系人、担保人、担保企业的地址和电话信息
     * @param  certifNo 证件号
     * @param  applyNo 申请编号
     * @param  overdueCstmAddrList 逾期客户地址信息
     * @param  overdueCstmTelList 逾期客户电话信息
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void getContractGuaranteeData(String certifNo, String applyNo, List<OverdueCstmAddr> overdueCstmAddrList, List<OverdueCstmTel> overdueCstmTelList) {
        // 根据申请编号获取联系人信息
        Example contractExample = new Example(CstmContact.class);
        contractExample.createCriteria().andEqualTo("applyNo", applyNo);
        List<CstmContact> cstmContractList = cstmContactRepository.selectListByExample(contractExample);
        if (ArrayUtils.isNotNullAndLengthNotZero(cstmContractList)) {
            for (CstmContact cstmContact : cstmContractList) {
                // 联系人地址
                addOverdueCstmAddrToList(certifNo,applyNo,cstmContact.getName(), CstmRelationIdentityTypeEnums.CONTACT.getCode()
                        , AddressTypeEnums.RESIDE_ADDR.getType(),cstmContact.getResideAddr(), overdueCstmAddrList);
                // 联系人电话信息
                addOverdueCstmTelToList(certifNo,applyNo,cstmContact.getName(),CstmRelationIdentityTypeEnums.CONTACT.getCode(), cstmContact.getMobileNo(), overdueCstmTelList);
            }
        }
        // 根据订单编号 获取担保人信息
        Example guaranteeExample = new Example(CstmContact.class);
        guaranteeExample.createCriteria().andEqualTo("applyNo", applyNo);
        List<GuaranteePers> guaranteePersList = guaranteePersRepository.selectListByExample(guaranteeExample);
        if (ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList)) {
            for (GuaranteePers guaranteePers : guaranteePersList) {
                // 联系人地址
                // 主贷人的单位地址信息
                addOverdueCstmAddrToList(certifNo,applyNo,guaranteePers.getName(),CstmRelationIdentityTypeEnums.GUARANTEE_PERSON.getCode()
                        , AddressTypeEnums.COMPANY_ADDR.getType(),guaranteePers.getCompAddr(), overdueCstmAddrList);
                // 主贷人的居住地址信息
                addOverdueCstmAddrToList(certifNo,applyNo,guaranteePers.getName(),CstmRelationIdentityTypeEnums.GUARANTEE_PERSON.getCode()
                        , AddressTypeEnums.RESIDE_ADDR.getType(),guaranteePers.getResideAddr(), overdueCstmAddrList);
                // 主贷人的户籍地址信息
                addOverdueCstmAddrToList(certifNo,applyNo, guaranteePers.getName(),CstmRelationIdentityTypeEnums.GUARANTEE_PERSON.getCode()
                        , AddressTypeEnums.CENSUS_ADDR.getType(),guaranteePers.getCensusAddr(), overdueCstmAddrList);
                // 主贷人的房产地址信息
                addOverdueCstmAddrToList(certifNo,applyNo,guaranteePers.getName(),CstmRelationIdentityTypeEnums.GUARANTEE_PERSON.getCode()
                        , AddressTypeEnums.PROPERTY_ADDR.getType(),guaranteePers.getPropertyAddr(), overdueCstmAddrList);
                // 配偶工作地址
                addOverdueCstmAddrToList(certifNo,applyNo,guaranteePers.getMateName(),CstmRelationIdentityTypeEnums.GUARANTEE_PERSON_MATE.getCode()
                        , AddressTypeEnums.COMPANY_ADDR.getType(),guaranteePers.getMateCompAddr(), overdueCstmAddrList);
                // 主贷人电话信息
                addOverdueCstmTelToList(certifNo,applyNo,guaranteePers.getName(),CstmRelationIdentityTypeEnums.GUARANTEE_PERSON.getCode(), guaranteePers.getMobileNo(), overdueCstmTelList);
                // 配偶电话信息
                addOverdueCstmTelToList(certifNo,applyNo,guaranteePers.getMateName(),CstmRelationIdentityTypeEnums.GUARANTEE_PERSON_MATE.getCode(), guaranteePers.getMateMobileNo(), overdueCstmTelList);
            }
        }

        // 根据订单编号 获取担保企业信息
        Example guaCompanyExample = new Example(CstmContact.class);
        guaCompanyExample.createCriteria().andEqualTo("applyNo", applyNo);
        List<GuaranteeComp> guaranteeCompList = guaranteeCompRepository.selectListByExample(guaCompanyExample);
        if (ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList)) {
            for (GuaranteeComp guaranteeComp : guaranteeCompList) {
                // 企业客户的单位地址
                addOverdueCstmAddrToList(certifNo,applyNo,guaranteeComp.getName(),CstmRelationIdentityTypeEnums.GUARANTEE_COMPANY.getCode()
                        , AddressTypeEnums.COMPANY_ADDR.getType(),guaranteeComp.getCompAddr(), overdueCstmAddrList);
                // 企业客户的联系电话
                addOverdueCstmTelToList(certifNo,applyNo,guaranteeComp.getName() ,CstmRelationIdentityTypeEnums.GUARANTEE_COMPANY.getCode(), guaranteeComp.getCompTel(), overdueCstmTelList);
                // 企业法人的联系电话
                addOverdueCstmTelToList(certifNo,applyNo,guaranteeComp.getCompLegalRep(),CstmRelationIdentityTypeEnums.GUARANTEE_COMPANY_LEGAL.getCode(), guaranteeComp.getMobileNo(), overdueCstmTelList);
            }
        }
    }
    /**
     * @Title:
     * @Description: 获取共同借款人的地址和电话信息
     * @param  certifNo 证件号
     * @param  applyNo 申请编号
     * @param  overdueCstmAddrList 逾期客户地址信息
     * @param  overdueCstmTelList 逾期客户电话信息
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void getCommonBorrower(String certifNo, String applyNo, List<OverdueCstmAddr> overdueCstmAddrList, List<OverdueCstmTel> overdueCstmTelList) {
        // 根据申请编号获取共同借款人信息
        Example example = new Example(CstmContact.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        List<CommonBorrower> commonBorrowerList = commonBorrowerRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(commonBorrowerList)) {
            for (CommonBorrower commonBorrower : commonBorrowerList) {
                // 共同借款人地址
                addOverdueCstmAddrToList(certifNo,applyNo,commonBorrower.getName(),CstmRelationIdentityTypeEnums.COMMON_BORR.getCode()
                        , AddressTypeEnums.COMPANY_ADDR.getType(),commonBorrower.getCompAddr(), overdueCstmAddrList);
                // 共同借款人电话信息
                addOverdueCstmTelToList(certifNo,applyNo,commonBorrower.getName(),CstmRelationIdentityTypeEnums.COMMON_BORR.getCode(), commonBorrower.getMobileNo(), overdueCstmTelList);
            }
        }
    }

    /**
     * @Title:
     * @Description: 获取主贷人的地址信息和电话信息（个人客户）
     * @param  cstmPersonAddTelVo 客户个人信息
     * @param  overdueCstmAddrList 逾期客户地址信息
     * @param  overdueCstmTelList 逾期客户电话信息
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void getCstmAddTelByCstmPersonAddTelVo(CstmPersonAddTelVo cstmPersonAddTelVo, List<OverdueCstmAddr> overdueCstmAddrList
            , List<OverdueCstmTel> overdueCstmTelList) {
        String certifNo = cstmPersonAddTelVo.getCertifNo(); // 主贷人证件号
        String applyNo = cstmPersonAddTelVo.getApplyNo(); // 申请编号
        // 主贷人的单位地址信息
        addOverdueCstmAddrToList(certifNo,applyNo,cstmPersonAddTelVo.getName(),CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode()
                , AddressTypeEnums.COMPANY_ADDR.getType(),cstmPersonAddTelVo.getCompAddr(), overdueCstmAddrList);
        // 主贷人的居住地址信息
        addOverdueCstmAddrToList(certifNo,applyNo,cstmPersonAddTelVo.getName(),CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode()
                , AddressTypeEnums.RESIDE_ADDR.getType(),cstmPersonAddTelVo.getResideAddr(), overdueCstmAddrList);
        // 主贷人的户籍地址信息
        addOverdueCstmAddrToList(certifNo,applyNo,cstmPersonAddTelVo.getName(),CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode()
                , AddressTypeEnums.CENSUS_ADDR.getType(),cstmPersonAddTelVo.getCensusAddr(), overdueCstmAddrList);
        // 主贷人的房产地址信息
        addOverdueCstmAddrToList(certifNo,applyNo,cstmPersonAddTelVo.getName(),CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode()
                , AddressTypeEnums.PROPERTY_ADDR.getType(),cstmPersonAddTelVo.getPropertyAddr(), overdueCstmAddrList);
        // 配偶工作地址
        addOverdueCstmAddrToList(certifNo,applyNo,cstmPersonAddTelVo.getMateName(),CstmRelationIdentityTypeEnums.MATE.getCode()
                , AddressTypeEnums.COMPANY_ADDR.getType(),cstmPersonAddTelVo.getMateCompAddr(), overdueCstmAddrList);

        // 主贷人电话信息
        addOverdueCstmTelToList(certifNo,applyNo,cstmPersonAddTelVo.getName(),CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode(), cstmPersonAddTelVo.getMobileNo(), overdueCstmTelList);
        // 配偶电话信息
        addOverdueCstmTelToList(certifNo,applyNo,cstmPersonAddTelVo.getMateName(),CstmRelationIdentityTypeEnums.MATE.getCode(), cstmPersonAddTelVo.getMateMobile(), overdueCstmTelList);
        // 实价用车人电话
        addOverdueCstmTelToList(certifNo,applyNo,cstmPersonAddTelVo.getDriver(),CstmRelationIdentityTypeEnums.DRIVER.getCode(), cstmPersonAddTelVo.getDriverMobno(), overdueCstmTelList);
    }

    /**
     * @Title:
     * @Description: 获取主贷人的地址信息和电话信息(企业客户)
     * @param  cstmCompany 客户企业信息
     * @param  overdueCstmAddrList 逾期客户地址信息
     * @param  overdueCstmTelList 逾期客户电话信息
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void setgetCstmAddTelByCstmCompany(CstmCompany cstmCompany, List<OverdueCstmAddr> overdueCstmAddrList, List<OverdueCstmTel> overdueCstmTelList) {
        if (cstmCompany == null) {
            return;
        }
        String socialCertifNo = cstmCompany.getSocialCertifNo();// 统一社会信用代码
        String applyNo = cstmCompany.getApplyNo();
        // 企业客户的单位地址
        addOverdueCstmAddrToList(socialCertifNo,applyNo,cstmCompany.getName(),CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode()
                , AddressTypeEnums.COMPANY_ADDR.getType(),cstmCompany.getCompAddr(), overdueCstmAddrList);

        // 企业客户的联系电话
        addOverdueCstmTelToList(socialCertifNo,applyNo,cstmCompany.getName(),CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode(), cstmCompany.getCompTel(), overdueCstmTelList);
        // 企业法人的联系电话
        addOverdueCstmTelToList(socialCertifNo,applyNo,cstmCompany.getCompLegalRep(),CstmRelationIdentityTypeEnums.COMPANY_LEGAL.getCode(), cstmCompany.getMobileNo(), overdueCstmTelList);
        // 企业联系人的联系电话
        addOverdueCstmTelToList(socialCertifNo,applyNo,cstmCompany.getContactName(),CstmRelationIdentityTypeEnums.COMPANY_CONTACT.getCode(), cstmCompany.getContactMobno(), overdueCstmTelList);
        // 实际用车人的联系电话
        addOverdueCstmTelToList(socialCertifNo,applyNo,cstmCompany.getDriver(),CstmRelationIdentityTypeEnums.DRIVER.getCode(), cstmCompany.getDriverMobno(), overdueCstmTelList);
    }

    /**
     * @Title:
     * @Description: 获取逾期客户地址信息
     * @param  certifNo 主贷人证件号
     * @param  applyNo 申请编号
     * @param  cstmName 客户姓名
     * @param  relationType 关系类型
     * @param  addType 地址类型
     * @param  address 地址
     * @param  overdueCstmAddrList 客户地址信息集合
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void addOverdueCstmAddrToList(String certifNo, String applyNo, String cstmName, String relationType, String addType
            , String address, List<OverdueCstmAddr> overdueCstmAddrList) {
        if (StringUtils.isNotTrimBlank(certifNo) && StringUtils.isNotTrimBlank(applyNo) && StringUtils.isNotTrimBlank(address)) {
            OverdueCstmAddr overdueCstmAddr = new OverdueCstmAddr();
            // 主贷人证件号
            overdueCstmAddr.setCertifNo(certifNo);
            // 申请编号
            overdueCstmAddr.setApplyNo(applyNo);
            // 客户姓名
            overdueCstmAddr.setCstmName(cstmName);
            // 关系类型
            overdueCstmAddr.setRelationType(relationType);
            // 地址类型
            overdueCstmAddr.setAddrType(addType);
            // 地址
            overdueCstmAddr.setAddress(address);
            // 是否有效 1:有效
            overdueCstmAddr.setValidFlag(YesNoFlagEnums.YES.getType());
            overdueCstmAddrList.add(overdueCstmAddr);
        }
    }

    /**
     * @Title:
     * @Description: 获取逾期客户地址信息
     * @param  certifNo 主贷人证件号
     * @param  applyNo 申请编号
     * @param  cstmName 客户姓名
     * @param  relationType 关系类型
     * @param  telNo 电话号码
     * @param  overdueCstmTelList 客户电话信息集合
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void addOverdueCstmTelToList(String certifNo, String applyNo, String cstmName, String relationType, String telNo
            , List<OverdueCstmTel> overdueCstmTelList) {
        if (StringUtils.isNotTrimBlank(certifNo) && StringUtils.isNotTrimBlank(applyNo) && StringUtils.isNotTrimBlank(telNo)) {
            OverdueCstmTel overdueCstmTel = new OverdueCstmTel();
            // 主贷人证件号
            overdueCstmTel.setCertifNo(certifNo);
            // 申请编号
            overdueCstmTel.setApplyNo(applyNo);
            // 客户姓名
            overdueCstmTel.setCstmName(cstmName);
            // 关系类型
            overdueCstmTel.setRelationType(relationType);
            // 电话号码
            overdueCstmTel.setTelNo(telNo);
            overdueCstmTelList.add(overdueCstmTel);
        }
    }

    /**
     * @Title:
     * @Description: 获得OverdueCstm对象数据
     * @param  overdueDataVo 逾期数据
     * @param  overdueCstmId 逾期客户ID
     * @return OverdueCstm
     * @throws
     * @author wangxue
     * @date 2018-9-3 17:11:36
     */
    private OverdueCstm getOverdueCstm(OverdueDataVo overdueDataVo, String overdueCstmId){
        OverdueCstm overdueCstm = new OverdueCstm();
        // 逾期客户ID
        if (StringUtils.isNotTrimBlank(overdueCstmId)) {
            overdueCstm.setOverdueCstmId(overdueCstmId);
        }
        // 申请类型
        overdueCstm.setApplyType(overdueDataVo.getApplyType());
        // 客户姓名
        overdueCstm.setCstmName(overdueDataVo.getCstmName());
        // 证件号码
        overdueCstm.setCertifNo(overdueDataVo.getCertifNo());
        // 当前逾期天数
        overdueCstm.setOverdueDays(overdueDataVo.getOverdueDays());
        // 当前逾期期数
        overdueCstm.setOverduePeriods(overdueDataVo.getOverduePeriods());
        // 当前逾期本金
        overdueCstm.setOverduePrincipal(overdueDataVo.getOverduePrincipal());
        // 当前逾期租金
        overdueCstm.setOverdueRent(overdueDataVo.getOverdueRent());
        // 当前逾期罚息
        overdueCstm.setOverdueAmount(overdueDataVo.getOverdueAmount());
        // 当前逾期总额
        overdueCstm.setOverdueSum(overdueDataVo.getOverdueSum());
        // 当前销售未还剩余本金
        overdueCstm.setRestPrincipal(overdueDataVo.getRestPrincipal());
        // 当前财务未还剩余本金
        overdueCstm.setFinRestPrincipal(overdueDataVo.getFinRestPrincipal());
        // 历史最高逾期天数
        overdueCstm.setOverdueDaysHis(overdueDataVo.getOverdueDaysHis());
        // 当前是否逾期
        overdueCstm.setOverdueFlag(YesNoFlagEnums.YES.getType());
        return overdueCstm;
    }

    /**
     * @Title:
     * @Description: 获得处理逾期客户的逾期相关金额
     * @param  overdueCstm 逾期客户信息
     * @param  overdueDataVo 逾期数据
     * @throws
     * @author wangxue
     * @date 2018-9-4 17:11:36
     */
    private void setOverdueCstmAdd(OverdueCstm overdueCstm, OverdueDataVo overdueDataVo) {
        // 当前逾期天数
        if (overdueCstm.getOverdueDays().compareTo(overdueDataVo.getOverdueDays()) < 0) {
            overdueCstm.setOverdueDays(overdueDataVo.getOverdueDays());
        }
        // 当前逾期期数
        overdueCstm.setOverduePeriods(overdueCstm.getOverduePeriods() + overdueDataVo.getOverduePeriods());
        // 当前逾期本金
        overdueCstm.setOverduePrincipal(overdueCstm.getOverduePrincipal().add(overdueDataVo.getOverduePrincipal()));
        // 当前逾期租金
        overdueCstm.setOverdueRent(overdueCstm.getOverdueRent().add(overdueDataVo.getOverdueRent()));
        // 当前逾期罚息
        overdueCstm.setOverdueAmount(overdueCstm.getOverdueAmount().add(overdueDataVo.getOverdueAmount()));
        // 当前逾期总额
        overdueCstm.setOverdueSum(overdueCstm.getOverdueSum().add(overdueDataVo.getOverdueSum()));
        // 当前销售未还剩余本金
        overdueCstm.setRestPrincipal(overdueCstm.getRestPrincipal().add(overdueDataVo.getRestPrincipal()));
        // 当前财务未还剩余本金
        overdueCstm.setFinRestPrincipal(overdueCstm.getFinRestPrincipal().add(overdueDataVo.getFinRestPrincipal()));
        // 历史最高逾期天数
        if (overdueCstm.getOverdueDaysHis().compareTo(overdueDataVo.getOverdueDaysHis()) < 0) {
            overdueCstm.setOverdueDaysHis(overdueDataVo.getOverdueDaysHis());
        }
    }

    /**
     * @Title:
     * @Description: 获取当前正在逾期的客户对应的逾期客户ID（以证件号码作为mapKey）
     * @param overdueCstmList 逾期客户信息集合
     * @param delOverdueCstmIdList 逾期客户ID集合
     * @return Map<String, String>
     * @throws
     * @author wangxue
     * @date 2018-9-3 17:11:36
     */
    private Map<String,String> getOverdueCstmIdMapFromList(List<OverdueCstm> overdueCstmList, List<String> delOverdueCstmIdList) {
        Map<String,String> resultMap = new HashMap<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmList)) {
            for (OverdueCstm overdueCstm : overdueCstmList) {
                delOverdueCstmIdList.add(overdueCstm.getOverdueCstmId());
                resultMap.put(overdueCstm.getCertifNo(), overdueCstm.getOverdueCstmId());
            }
        }
        return resultMap;
    }

    /**
     * @Title:
     * @Description: 逾期合同的历史逾期次数和历史最高逾期天数
     * @return Map<String, OverdueContVo>
     * @throws
     * @author wangxue
     * @date 2018-9-3 17:11:36
     */
    private Map<String, OverdueContVo> getOverdueHistoryData() {
        Map<String, OverdueContVo> resultMap = new HashMap<>();
        List<OverdueContVo> tempList = overdueContRepository.selectOverdueDaysHisAndOverdueTimes();
        if (ArrayUtils.isNotNullAndLengthNotZero(tempList)) {
            for (OverdueContVo overdueContVo : tempList) {
                resultMap.put(overdueContVo.getContNo(), overdueContVo);
            }
        }
        return resultMap;
    }

    /**
     * @Title:
     * @Description: 根据条件将逾期客户信息保存到上门催收表（家访池）
     * @param addOverdueCstmList 新增的逾期客户数据
     * @param updOverdueCstmList 更新的逾期客户数据
     * @throws
     * @author wangxue
     * @date 2018-9-19 17:11:36
     */
    private void saveCollectionTask(List<OverdueCstm> addOverdueCstmList, List<OverdueCstm> updOverdueCstmList) {
        // 获取系统常量，进入家访池中客户的逾期天数
        String strOverdueDays = commonConstantService.findSysParamValue(CommonParamConstants.COLLECTION_OVERDUE_DAY);
        Integer overdueDays = StringUtils.isTrimBlank(strOverdueDays) ? 0 : Integer.parseInt(strOverdueDays);
        // 查询上门催收表中原有的逾期客户ID
        List<String> oldOverdueCstmIdList = collectionTaskRepository.selectAllOverdueCstmIds();
        // 新增的上门催收数据
        List<CollectionTask> addCollectionTaskList = new ArrayList<>();
        // 新增的逾期客户数据
        addOverdueCstmHandler(addOverdueCstmList, addCollectionTaskList, oldOverdueCstmIdList, overdueDays);
        // 更新的逾期客户数据
        addOverdueCstmHandler(updOverdueCstmList, addCollectionTaskList, oldOverdueCstmIdList, overdueDays);
        // 插入上门催收任务数据
        if (ArrayUtils.isNotNullAndLengthNotZero(addCollectionTaskList)) {
            collectionTaskRepository.insertDataList(addCollectionTaskList);
        }
    }

    /**
     * @Title:
     * @Description: 处理逾期客户数据
     * @param overdueCstmList 逾期客户数据
     * @param addCollectionTaskList 需要新增的上门催收任务数据
     * @param oldOverdueCstmIdList 已存在于家访池的逾期客户ID
     * @throws
     * @author wangxue
     * @date 2018-9-19 17:11:36
     */
    private void addOverdueCstmHandler(List<OverdueCstm> overdueCstmList,List<CollectionTask> addCollectionTaskList
            ,List<String> oldOverdueCstmIdList, Integer overdueDays) {
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmList)) {
            for (OverdueCstm overdueCstm : overdueCstmList) {
                if (overdueDays.compareTo(overdueCstm.getOverdueDays()) <= 0) {
                    // 客户当前逾期天数大于等于overdueDays时，进入上门催收任务表
                    if (ArrayUtils.equalsContains(oldOverdueCstmIdList, overdueCstm.getOverdueCstmId())) {
                        // 判断是否上门催收表中是否有该逾期客户任务数据，如果有，则进入下一次循环
                        continue;
                    }
                    CollectionTask collectionTask = new CollectionTask();
                    // 上门催收任务号
                    collectionTask.setCollectionTaskNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.COLLECTION_TASK_NUM_TYPE.getType()));
                    // 逾期客户ID
                    collectionTask.setOverdueCstmId(overdueCstm.getOverdueCstmId());
                    // 数据来源
                    collectionTask.setDataSource(DataSourceTypeEnums.AUTO.getType());
                    // 任务状态：待申请提交
                    collectionTask.setCollectionTaskStatus(BizStatusEnums.COLLECTION_TOBE_APPLY.getType());
                    addCollectionTaskList.add(collectionTask);
                }
            }
        }
    }

    /**
     * @Title:
     * @Description: 根据条件将逾期合同信息保存到收车池
     * @param addOverdueContList 新增的逾期合同数据
     * @param updOverdueContList 更新的逾期合同数据
     * @throws
     * @author wangxue
     * @date 2018-9-19 17:11:36
     */
    private void saveRetrieveCarTask(List<OverdueCont> addOverdueContList, List<OverdueCont> updOverdueContList) {
        // 获取系统常量，进入家访池中客户的逾期天数
        String strOverdueDays = commonConstantService.findSysParamValue(CommonParamConstants.RETRIEVE_OVERDUE_DAY);
        Integer overdueDays = StringUtils.isTrimBlank(strOverdueDays) ? 0 : Integer.parseInt(strOverdueDays);
        // 查询收车任务表中原有的逾期合同ID
        List<String> oldOverdueContIdList = retrieveCarsTaskRepository.selectAllOverdueContIds();
        // 新增的收车任务数据
        List<RetrieveCarsTask> retrieveCarsTaskList = new ArrayList<>();
        String taskType = "retrieve"; // 类型：收车
        // 新增的逾期客户数据
        addOverdueContToRetrieveCarOrLawsuit(addOverdueContList, retrieveCarsTaskList, new ArrayList<>(), taskType, oldOverdueContIdList, overdueDays);
        // 新增的逾期客户数据
        addOverdueContToRetrieveCarOrLawsuit(updOverdueContList, retrieveCarsTaskList, new ArrayList<>(), taskType, oldOverdueContIdList, overdueDays);
        // 保存收车任务数据
        if (ArrayUtils.isNotNullAndLengthNotZero(retrieveCarsTaskList)) {
            retrieveCarsTaskRepository.insertDataList(retrieveCarsTaskList);
        }
    }

    /**
     * @Title:
     * @Description: 根据条件将逾期合同信息保存诉讼池
     * @param addOverdueContList 新增的逾期合同数据
     * @param updOverdueContList 更新的逾期合同数据
     * @throws
     * @author wangxue
     * @date 2018-9-19 17:11:36
     */
    private void saveLawsuitTask(List<OverdueCont> addOverdueContList, List<OverdueCont> updOverdueContList) {
        // 获取系统常量，进入家访池中客户的逾期天数
        String strOverdueDays = commonConstantService.findSysParamValue(CommonParamConstants.LAWSUIT_OVERDUE_DAY);
        Integer overdueDays = StringUtils.isTrimBlank(strOverdueDays) ? 0 : Integer.parseInt(strOverdueDays);
        // 查询诉讼任务表中原有的逾期合同ID
        List<String> oldOverdueContIdList =  lawsuitTaskRepository.selectAllOverdueContIds();
        // 新增的诉讼任务数据
        List<LawsuitTask> lawsuitTaskList = new ArrayList<>();
        String taskType = "lawsuit"; // 类型：诉讼
        // 新增的逾期客户数据
        addOverdueContToRetrieveCarOrLawsuit(addOverdueContList, new ArrayList<>(), lawsuitTaskList, taskType, oldOverdueContIdList, overdueDays);
        // 新增的逾期客户数据
        addOverdueContToRetrieveCarOrLawsuit(updOverdueContList, new ArrayList<>(), lawsuitTaskList, taskType, oldOverdueContIdList, overdueDays);
        // 保存诉讼任务数据
        if (ArrayUtils.isNotNullAndLengthNotZero(lawsuitTaskList)) {
            lawsuitTaskRepository.insertDataList(lawsuitTaskList);
        }
    }

    /**
     * @Title:
     * @Description: 处于逾期合同数据
     * @param overdueContList 逾期合同数据
     * @param retrieveCarsTaskList 新增的收车任务任务数据
     * @param lawsuitTaskList 新增的诉讼任务任务数据
     * @param taskType 任务类型
     * @param oldOverdueContIdList 历史已进入的逾期合同ＩＤ
     * @param overdueDays 逾期天数
     * @throws
     * @author wangxue
     * @date 2018-9-19 17:11:36
     */
    private void addOverdueContToRetrieveCarOrLawsuit(List<OverdueCont> overdueContList,List<RetrieveCarsTask> retrieveCarsTaskList
            ,List<LawsuitTask> lawsuitTaskList, String taskType,List<String> oldOverdueContIdList, Integer overdueDays) {
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueContList)) {
            for (OverdueCont overdueCont : overdueContList) {
                // 合同的当前逾期天数大于等于overdueDays时，进入收车池和诉讼池中
                if (overdueDays.compareTo(overdueCont.getOverdueDays()) <= 0) {
                    if (ArrayUtils.equalsContains(oldOverdueContIdList, overdueCont.getOverdueContId())) {
                        continue;
                    }
                    if ("retrieve".equals(taskType)) {
                        // 收车任务数据
                        RetrieveCarsTask retrieveCarsTask = new RetrieveCarsTask();
                        // 收车任务号
                        retrieveCarsTask.setRetrieveCarTaskNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.RETRIEVE_CAR_TASK_NUM_TYPE.getType()));
                        // 逾期合同ID
                        retrieveCarsTask.setOverdueContId(overdueCont.getOverdueContId());
                        // 合同编号
                        retrieveCarsTask.setContNo(overdueCont.getContNo());
                        // 任务状态：收车待申请提交
                        retrieveCarsTask.setTaskStatus(BizStatusEnums.RECOVERY_TOBE_APPLY.getType());
                        retrieveCarsTaskList.add(retrieveCarsTask);
                    } else if ("lawsuit".equals(taskType)) {
                        // 诉讼任务
                        LawsuitTask lawsuitTask = new LawsuitTask();
                        // 诉讼任务号
                        lawsuitTask.setLawsuitTaskNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.LAWSUIT.getType()));
                        // 逾期合同ID
                        lawsuitTask.setOverdueContId(overdueCont.getOverdueContId());
                        // 合同编号
                        lawsuitTask.setContNo(overdueCont.getContNo());
                        lawsuitTaskList.add(lawsuitTask);
                    }
                }
            }
        }
    }

    /**
     * @Title:
     * @Description: 根据催收类别，随机回去该类别的用户
     * @param collectionType 催收类别
     * @return 用户账号
     * @throws
     * @author wangxue
     * @date 2018-9-19 17:11:36
     */
    private String getRandomCollectionPersonName(String collectionType) {
        Example example = SqlUtil.newExample(CollectionPerson.class);
        example.createCriteria().andEqualTo("collectionType", collectionType);
        List<CollectionPerson> personList = collectionPersonRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(personList)) {
            int index = RandomUtils.getRandNum(0, personList.size() - 1);
            return personList.get(index).getCollectionPersonNum();
        }
        return null;
    }

}
