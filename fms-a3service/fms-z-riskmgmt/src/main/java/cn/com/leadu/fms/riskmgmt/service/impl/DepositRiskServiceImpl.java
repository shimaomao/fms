package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActDepositChangeUtils;
import cn.com.leadu.fms.business.service.BasAreaNameService;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.MarriageStatusEnums;
import cn.com.leadu.fms.common.constant.enums.riskmgmt.PycreditTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.DepositChangeTaskRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.GuaranteeCompRepository;
import cn.com.leadu.fms.data.prebiz.repository.GuaranteePersRepository;
import cn.com.leadu.fms.data.riskmgmt.repository.*;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.entity.DepositChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.riskmgmt.entity.*;
import cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetail.AccountDetailVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.depositrisk.DepositRiskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskcompany.RiskCompanyVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskperson.RiskPersonVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.riskmgmt.rpc.prebiz.ApplyInputRpc;
import cn.com.leadu.fms.riskmgmt.service.*;
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

import static cn.com.leadu.fms.common.constant.enums.prebiz.CstmRelationIdentityTypeEnums.*;
import static cn.com.leadu.fms.common.util.EntityUtils.getEntity;

/**
 * @author liujinge
 * @ClassName: DepositRiskServiceImpl
 * @Description: 保证金变更风控审批
 * @date 2018-06-05
 */
@Slf4j
@Service
public class DepositRiskServiceImpl implements DepositRiskService {
    /**
     * @Fields : 日志业务层
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    @Autowired
    private ApplyInputRpc applyInputRpc;
    @Autowired
    private RiskTelchkService riskTelchkService;
    @Autowired
    private RiskMgmtPersonService riskMgmtPersonService;
    @Autowired
    private RiskMgmtCompService riskMgmtCompService;
    @Autowired
    private RiskMgmtGuaranteeService riskMgmtGuaranteeService;
    @Autowired
    private RiskPersonService riskPersonService;
    @Autowired
    private PbcCreditService pbcCreditService;
    @Autowired
    private RiskCompanyService riskCompanyService;
    @Autowired
    private AccountDetailService accountDetailService;
    @Autowired
    private PycreditListService pycreditListService;
    @Autowired
    private BizFilesService bizFilesService;
    @Autowired
    private BasAreaNameService basAreaService;
    @Autowired
    private CommonConstantService commonConstantService;
    /**
     * @Fields : 个人风险信息repository
     */
    @Autowired
    private RiskPersonRepository riskPersonRepository;
    /**
     * @Fields : 企业风险信息repository
     */
    @Autowired
    private RiskCompanyRepository riskCompanyRepository;
    /**
     * @Fields : 风控担保人信息repository
     */
    @Autowired
    private RiskMgmtGuaranteeRepository riskMgmtGuaranteeRepository;
    /**
     * @Fields : 个人人行征信信息repository
     */
    @Autowired
    private PbcCreditRepository pbcCreditRepository;

    /**
     * @Fields : 银行流水repository
     */
    @Autowired
    private AccountDetailRepository accountDetailRepository;

    /**
     * @Fields : 银行流水明细repository
     */
    @Autowired
    private AccountDetailListRepository accountDetailListRepository;
    /**
     * @Fields : 鹏元查询一览repository
     */
    @Autowired
    private PycreditListRepository pycreditListRepository;
    @Autowired
    private DepositChangeTaskRepository depositChangeTaskRepository;
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;
    @Autowired
    private GuaranteeCompRepository guaranteeCompRepository;
    @Autowired
    private GuaranteePersRepository guaranteePersRepository;
    //承租人个人的鹏元接口类型：反欺诈分析,地址核验,卡核查及交易,银行卡核查,驾驶证核查
    private String[] PYCREDIT_TYPE_PER_MAIN = {
            PycreditTypeEnums.ANTI.getType(),
            PycreditTypeEnums.ADDR1.getType(),
            PycreditTypeEnums.ADDR2.getType(),
//            PycreditTypeEnums.CARD_CHECK.getType(),
            PycreditTypeEnums.PERSON_BKCHECK.getType(),
            PycreditTypeEnums.DRIVER.getType(),
//            PycreditTypeEnums.DRIVER1.getType(),
//            PycreditTypeEnums.DRIVER2.getType(),
//            PycreditTypeEnums.DRIVER3.getType(),
//            PycreditTypeEnums.DRIVER4.getType(),
//            PycreditTypeEnums.DRIVER5.getType()
    };
    //企业的鹏元接口类型
    private String[] PYCREDIT_TYPE_COMP_MAIN = {
            PycreditTypeEnums.CORP_RISK.getType(),
            PycreditTypeEnums.CORP_DEBT.getType(),
            PycreditTypeEnums.CORP_BKCHECK.getType()
    };
    //个人的鹏元接口类型，不包含驾驶证
    private String[] PYCREDIT_TYPE_PER_GUAR = {
            PycreditTypeEnums.ANTI.getType(),
            PycreditTypeEnums.ADDR1.getType(),
            PycreditTypeEnums.ADDR2.getType(),
//            PycreditTypeEnums.CARD_CHECK.getType(),
            PycreditTypeEnums.PERSON_BKCHECK.getType(),
    };


    /**
     * @param depositTaskNo
     * @return DepositRiskVo 保证金变更任务号
     * @throws
     * @Title:
     * @Description: 风控初审画面初始数据(这里保存了鹏元征信数据)
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    @Transactional
    public DepositRiskVo findApplyRiskInit(String depositTaskNo) {
        DepositRiskVo depositRiskVo = new DepositRiskVo();
        //根据任务号，取得增加保证金申请信息
        getApplyInfo(depositTaskNo, depositRiskVo);

        //生成鹏元征信查询一览
        getPycreditListVoList(depositTaskNo, depositRiskVo);

        //取得风控信息
        getRiskMgmtInfo(depositTaskNo, depositRiskVo);

        return depositRiskVo;
    }

    /**
     * @param depositRiskVo
     * @Description: 保存风控数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/6 15:34
     */
    @Override
    @Transactional
    public void saveApplyRiskInit(DepositRiskVo depositRiskVo, SysUser sysUser) {
        if (ApplyTypeEnums.COMPANY.getType().equals(depositRiskVo.getDepositChangeApplyVo().getApplyType())) {
            //保存公司风险信息
            saveRiskMgmtCompInfo(depositRiskVo);
        } else {//个人信息
            //保存个人风险信息
            saveRiskMgmtPersonInfo(depositRiskVo);
        }
        //保存银行流水信息
        this.saveAccountDetail(depositRiskVo);


        // TODO: 2018/9/12  
        if (YesNoFlagEnums.YES.getType().equals(depositRiskVo.getSaveFlag())) {
            DepositChangeTask task = getDepositChangeTaskByTaskNo(depositRiskVo.getDepositChangeApplyVo().getDepositTaskNo());
            if (task == null) {
                throw new FmsServiceException("保证金变更任务不存在");
            }
            //工作流信息
            ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalAgree(depositRiskVo.getTaskId());
            task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
            task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
            saveWorkFlowLog(task, depositRiskVo.getRemark(), actRuTaskVo, ActTypeEnums.APPROVAL.getType(), sysUser);
        }

    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 初审、复审退回操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void sendBack(DepositRiskVo vo, SysUser sysUser) {
        String depositTaskNo = vo.getDepositChangeApplyVo().getDepositTaskNo();
        DepositChangeTask task = getDepositChangeTaskByTaskNo(depositTaskNo);
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo;
        //如果是风控初审的退回，或者业务副总的退回则直接退回到上一节点
        if (BizStatusEnums.DEPOSIT_FIS_APPLY_APPROVE.getType().equals(task.getDepositTaskStatus()) || //风控初审退回
                BizStatusEnums.DEPOSIT_SEC_APPLY_APPROVE.getType().equals(task.getDepositTaskStatus()) //风控初审退回
                || BizStatusEnums.DEPOSIT_SEND_BACK_APPROVE.getType().equals(task.getDepositTaskStatus()) //风控初审退回
                || BizStatusEnums.DEPOSIT_MANAGER_APPROVE.getType().equals(task.getDepositTaskStatus()) //业务副总退回
                || BizStatusEnums.DEPOSIT_SEC_MANAGER_APPROVE.getType().equals(task.getDepositTaskStatus())) { //业务副总退回
            actRuTaskVo = ActDepositChangeUtils.approvalReturnSuperior(vo.getTaskId());
        } else { //如果是风控复审的退回，要根据是否有担保人来判断如何退回
            boolean flag = getDepositFlag(depositTaskNo);
            //如果有担保人，则退回到上一节点
            if (flag) {
                actRuTaskVo = ActDepositChangeUtils.approvalReturnSuperior(vo.getTaskId());
            } else {//没有，则退回到申请
                actRuTaskVo = ActDepositChangeUtils.approvalSendToApply(vo.getTaskId());
            }
        }
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, ActTypeEnums.SENDBACK.getType(), sysUser);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 初审、复审拒绝操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void refuse(DepositRiskVo vo, SysUser sysUser) {
        String depositTaskNo = vo.getDepositChangeApplyVo().getDepositTaskNo();
        DepositChangeTask task = getDepositChangeTaskByTaskNo(depositTaskNo);
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalRefuse(vo.getTaskId());
        task.setDepositTaskStatus(BizStatusEnums.DEPOSIT_CHANGE_REFUSE.getType()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, ActTypeEnums.REFUSE.getType(), sysUser);
    }

    /**
     * @param depositTaskNo
     * @param depositRiskVo
     * @return DepositRiskVo
     * @throws
     * @Title:
     * @Description: 取得风险信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskMgmtInfo(String depositTaskNo, DepositRiskVo depositRiskVo) {
        String applyType = depositRiskVo.getDepositChangeApplyVo().getApplyType();

        depositRiskVo.setRiskPersonVoGuarList(new ArrayList<RiskPersonVo>());
        depositRiskVo.setRiskCompanyVoGuarList(new ArrayList<RiskCompanyVo>());
        depositRiskVo.setAccountDetailVoList(new ArrayList<AccountDetailVo>());
        depositRiskVo.setRiskPersonVoGuMateList(new ArrayList<RiskPersonVo>());
        depositRiskVo.setRiskMgmtGuaranteeList(new ArrayList<RiskMgmtGuarantee>());

        if (ApplyTypeEnums.COMPANY.getType().equals(applyType)) {
            getRiskMgmtCompInfo(depositTaskNo, depositRiskVo);
        } else {
            getRiskMgmtPersInfo(depositTaskNo, depositRiskVo);
        }
    }

    /**
     * @param depositRiskVo
     * @return DepositRiskVo
     * @throws
     * @Title:
     * @Description: 取得个人/企业风险信息的共通处理
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskCommon(DepositRiskVo depositRiskVo) {
        //担保人银行流水
        if (ArrayUtils.isNotNullAndLengthNotZero(depositRiskVo.getGuaranteePersList())) {
            for (int i = 0; i < depositRiskVo.getGuaranteePersList().size(); i++) {
                AccountDetailVo accountDetailVo = new AccountDetailVo();
                accountDetailVo.setName(depositRiskVo.getGuaranteePersList().get(i).getName());
                accountDetailVo.setRelation(GUARANTEE_PERSON.getCode());
                accountDetailVo.setAccountDetailLists(getAccountDetailListNew());
                accountDetailVo.setApplyNo(depositRiskVo.getDepositChangeApplyVo().getDepositTaskNo());
                depositRiskVo.getAccountDetailVoList().add(accountDetailVo);

                //担保人
                RiskMgmtGuarantee riskMgmtGuarantee = new RiskMgmtGuarantee();
                riskMgmtGuarantee.setGuaranteeName(depositRiskVo.getGuaranteePersList().get(i).getName());
                riskMgmtGuarantee.setApplyNo(depositRiskVo.getDepositChangeApplyVo().getDepositTaskNo());
                depositRiskVo.getRiskMgmtGuaranteeList().add(riskMgmtGuarantee);
            }
        }
        //担保企业风险信息
        if (ArrayUtils.isNotNullAndLengthNotZero(depositRiskVo.getGuaranteeCompList())) {
            for (int i = 0; i < depositRiskVo.getGuaranteeCompList().size(); i++) {
                RiskCompanyVo riskCompanyVo = new RiskCompanyVo();
                riskCompanyVo.setName(depositRiskVo.getGuaranteeCompList().get(i).getName());
                riskCompanyVo.setRelation(GUARANTEE_COMPANY.getCode());
                riskCompanyVo.setApplyNo(depositRiskVo.getDepositChangeApplyVo().getDepositTaskNo());
                //地址匹配
                String belongCity = depositRiskVo.getDepositChangeApplyVo().getGroupDistrict();
                String compCity = commonConstantService.findBasAreaName(depositRiskVo.getGuaranteeCompList().get(i).getCompCity());
                if (StringUtils.equals(belongCity, compCity))
                    riskCompanyVo.setApplyAddrMatch("一致");
                riskCompanyVo.setApplyAddrMatch("不一致");
                depositRiskVo.getRiskCompanyVoGuarList().add(riskCompanyVo);

                AccountDetailVo accountDetailVo = new AccountDetailVo();
                accountDetailVo.setName(depositRiskVo.getGuaranteeCompList().get(i).getName());
                accountDetailVo.setRelation(GUARANTEE_COMPANY.getCode());
                accountDetailVo.setAccountDetailLists(getAccountDetailListNew());
                accountDetailVo.setApplyNo(depositRiskVo.getDepositChangeApplyVo().getDepositTaskNo());
                depositRiskVo.getAccountDetailVoList().add(accountDetailVo);

                RiskMgmtGuarantee riskMgmtGuarantee = new RiskMgmtGuarantee();
                riskMgmtGuarantee.setGuaranteeName(depositRiskVo.getGuaranteeCompList().get(i).getName());
                riskMgmtGuarantee.setApplyNo(depositRiskVo.getDepositChangeApplyVo().getDepositTaskNo());
                depositRiskVo.getRiskMgmtGuaranteeList().add(riskMgmtGuarantee);
            }
        }

    }


    /**
     * @Description: 保存个人风险信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/7 18:09
     */
    private void saveRiskMgmtPersonInfo(DepositRiskVo depositRiskVo) {
        //保存风控担保人信息
        List<RiskMgmtGuarantee> riskMgmtGuaranteeList = depositRiskVo.getRiskMgmtGuaranteeList();
        for (RiskMgmtGuarantee riskMgmtGuarantee : riskMgmtGuaranteeList) {
            if (StringUtils.isNotTrimBlank(riskMgmtGuarantee.getRiskMgmtGuaranteeId()))
                riskMgmtGuaranteeRepository.updateByPrimaryKeySelectiveData(riskMgmtGuarantee);
            else
                riskMgmtGuaranteeRepository.insertData(riskMgmtGuarantee);
        }
        //保存担保企业风险信息
        for (RiskCompanyVo riskCompanyVo : depositRiskVo.getRiskCompanyVoGuarList()) {
            if (GUARANTEE_COMPANY.getCode().equals(riskCompanyVo.getRelation())) {
                //担保企业的风险信息
                if (StringUtils.isNotTrimBlank(riskCompanyVo.getRiskCompanyId()))
                    riskCompanyRepository.updateByPrimaryKeySelectiveData(riskCompanyVo.getEntity());
                else
                    riskCompanyRepository.insertData(riskCompanyVo.getEntity());
            }
        }
        //保存担保人风险信息
        for (RiskPersonVo riskPersonVo : depositRiskVo.getRiskPersonVoGuarList()) {
            if (GUARANTEE_PERSON.getCode().equals(riskPersonVo.getRelation())) {
                //保存担保人风险信息
                if (StringUtils.isNotTrimBlank(riskPersonVo.getRiskPersonId()))
                    riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVo.getEntity());
                else
                    riskPersonRepository.insertData(riskPersonVo.getEntity());
            }
        }

        //保存担保人配偶风险信息
        if (ArrayUtils.isNotNullAndLengthNotZero(depositRiskVo.getRiskPersonVoGuMateList())) {
            for (RiskPersonVo riskPersonVoMate : depositRiskVo.getRiskPersonVoGuMateList()) {
                //保存担保人配偶风险信息
                if (StringUtils.isNotTrimBlank(riskPersonVoMate.getRiskPersonId()))
                    riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVoMate.getEntity());
                else
                    riskPersonRepository.insertData(riskPersonVoMate.getEntity());
            }
        }
    }

    /**
     * @Description: 保存银行流水信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/14 14:36
     */
    private void saveAccountDetail(DepositRiskVo depositRiskVo) {
        for (AccountDetailVo accountDetailVo : depositRiskVo.getAccountDetailVoList()) {
            if (StringUtils.isNotTrimBlank(accountDetailVo.getAccountDetailId())) {
                accountDetailRepository.updateByPrimaryKeySelectiveData(accountDetailVo.getEntity());
                //保存流水明细信息
                accountDetailListRepository.updateByPrimaryKeySelectiveDataList(accountDetailVo.getAccountDetailLists());
            } else {
                AccountDetail accountDetail = getEntity(accountDetailVo, new AccountDetail());
                accountDetailRepository.insertData(accountDetail);
                //保存流水明细信息
                for (AccountDetailList accountDetailList : accountDetailVo.getAccountDetailLists()) {
                    accountDetailList.setAccountDetailId(accountDetail.getAccountDetailId());
                    accountDetailListRepository.insertData(accountDetailList);
                }
            }
        }
    }

    /**
     * @param depositTaskNo
     * @param depositRiskVo
     * @return DepositRiskVo
     * @throws
     * @Title:
     * @Description: 取得个人风险信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskMgmtPersInfo(String depositTaskNo, DepositRiskVo depositRiskVo) {
        //构造新数据
        //担保人风险信息
        if (ArrayUtils.isNotNullAndLengthNotZero(depositRiskVo.getGuaranteePersList())) {
            //
            for (int i = 0; i < depositRiskVo.getGuaranteePersList().size(); i++) {
                RiskPersonVo riskPersonVo = new RiskPersonVo();
                riskPersonVo.setName(depositRiskVo.getGuaranteePersList().get(i).getName());
                riskPersonVo.setRelation(GUARANTEE_PERSON.getCode());
                //担保人与承租人关系
                riskPersonVo.setGuaranteeRelation(depositRiskVo.getGuaranteePersList().get(i).getRelation());
                riskPersonVo.setApplyNo(depositTaskNo);
                depositRiskVo.getRiskPersonVoGuarList().add(riskPersonVo);
            }
        }
        //担保企业风险信息，担保人银行流水
        getRiskCommon(depositRiskVo);


        //担保人信息
        List<RiskMgmtGuarantee> riskMgmtGuaranteeListNow =
                this.compareList(riskMgmtGuaranteeService.findRiskMgmtGuaranteeListByApplyNo(depositTaskNo), depositRiskVo.getRiskMgmtGuaranteeList());
        //保存比较之后的信息
        depositRiskVo.setRiskMgmtGuaranteeList(riskMgmtGuaranteeListNow);
        //根据申请编号取得风险信息
        List<RiskPerson> riskPersonList = riskPersonService.findRiskPersonListByApplyNo(depositTaskNo);
        List<PbcCredit> pbcCreditList = pbcCreditService.findPbcCreditListByApplyNo(depositTaskNo);
        List<RiskCompany> riskCompanieList = riskCompanyService.findRiskCompanyListByApplyNo(depositTaskNo);
        List<AccountDetailVo> accountDetailVoList = accountDetailService.findAccountDetailVoListByApplyNo(depositTaskNo);

        if (ArrayUtils.isNotNullAndLengthNotZero(riskPersonList)) {
            //担保人风险信息
            List<RiskPersonVo> riskPersonVosOld = new ArrayList<>();
            //共同借款人风险信息
            for (int i = 0; i < riskPersonList.size(); i++) {
                if (GUARANTEE_PERSON.getCode().equals(riskPersonList.get(i).getRelation())) {
                    //担保人的风险信息
                    riskPersonVosOld.add(getEntity(riskPersonList.get(i), new RiskPersonVo()));
                }
            }
            //比较担保人风险信息
            List<RiskPersonVo> riskPersonVosNow =
                    this.compareList(riskPersonVosOld, depositRiskVo.getRiskPersonVoGuarList());
            depositRiskVo.setRiskPersonVoGuarList(riskPersonVosNow);
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(riskCompanieList)) {
            List<RiskCompanyVo> riskCompanyVoOld = new ArrayList<>();
            for (int i = 0; i < riskCompanieList.size(); i++) {
                if (GUARANTEE_COMPANY.getCode().equals(riskCompanieList.get(i).getRelation())) {
                    //担保企业的风险信息
                    riskCompanyVoOld.add(getEntity(riskCompanieList.get(i), new RiskCompanyVo()));
                }
            }
            //比较担保企业风险信息
            List<RiskCompanyVo> riskCompanyVoNow =
                    this.compareList(riskCompanyVoOld, depositRiskVo.getRiskCompanyVoGuarList());
            depositRiskVo.setRiskCompanyVoGuarList(riskCompanyVoNow);
        }
        //银行流水信息
        if (ArrayUtils.isNotNullAndLengthNotZero(accountDetailVoList)) {
            depositRiskVo.setAccountDetailVoList(this.compareList(accountDetailVoList, depositRiskVo.getAccountDetailVoList()));
//                depositRiskVo.setAccountDetailVoList(accountDetailVoList);
        }
    }

    /**
     * @Description: 保存公司风险信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/7 10:57
     */
    private void saveRiskMgmtCompInfo(DepositRiskVo depositRiskVo) {
        //保存风控担保人信息
        List<RiskMgmtGuarantee> riskMgmtGuaranteeList = depositRiskVo.getRiskMgmtGuaranteeList();
        for (RiskMgmtGuarantee riskMgmtGuarantee : riskMgmtGuaranteeList) {
            if (StringUtils.isNotTrimBlank(riskMgmtGuarantee.getRiskMgmtGuaranteeId()))
                riskMgmtGuaranteeRepository.updateByPrimaryKeySelectiveData(riskMgmtGuarantee);
            else
                riskMgmtGuaranteeRepository.insertData(riskMgmtGuarantee);
        }
        //保存担保企业风险信息
        for (RiskCompanyVo riskCompanyVo : depositRiskVo.getRiskCompanyVoGuarList()) {
            if (GUARANTEE_COMPANY.getCode().equals(riskCompanyVo.getRelation())) {
                //担保企业的风险信息
                if (StringUtils.isNotTrimBlank(riskCompanyVo.getRiskCompanyId()))
                    riskCompanyRepository.updateByPrimaryKeySelectiveData(riskCompanyVo.getEntity());
                else
                    riskCompanyRepository.insertData(riskCompanyVo.getEntity());
            }
        }
        //保存担保人风险信息
        for (RiskPersonVo riskPersonVo : depositRiskVo.getRiskPersonVoGuarList()) {
            if (GUARANTEE_PERSON.getCode().equals(riskPersonVo.getRelation())) {
                if (StringUtils.isNotTrimBlank(riskPersonVo.getRiskPersonId())) {
                    //保存担保人风险信息
                    riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVo.getEntity());
                    //保存担保人 人行征信
                    PbcCredit pbcCredit = riskPersonVo.getPbcCredit();
                    pbcCreditRepository.updateByPrimaryKeySelectiveData(pbcCredit);
                } else {
                    //保存担保人风险信息
                    riskPersonRepository.insertData(riskPersonVo.getEntity());
                    //保存担保人 人行征信
                    PbcCredit pbcCredit = riskPersonVo.getPbcCredit();
                    pbcCreditRepository.insertData(pbcCredit);
                }
            }
        }

        //保存担保人配偶风险信息
        if (ArrayUtils.isNotNullAndLengthNotZero(depositRiskVo.getRiskPersonVoGuMateList())) {
            for (RiskPersonVo riskPersonVoMate : depositRiskVo.getRiskPersonVoGuMateList()) {
                //保存担保人风险信息
                if (StringUtils.isNotTrimBlank(riskPersonVoMate.getRiskPersonId()))
                    riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVoMate.getEntity());
                else
                    riskPersonRepository.insertData(riskPersonVoMate.getEntity());
            }
        }
    }

    /**
     * @param depositTaskNo
     * @param depositRiskVo
     * @return DepositRiskVo
     * @throws
     * @Title:
     * @Description: 取得企业风险信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskMgmtCompInfo(String depositTaskNo, DepositRiskVo depositRiskVo) {
        //构造新数据
        //担保人风险信息
        if (ArrayUtils.isNotNullAndLengthNotZero(depositRiskVo.getGuaranteePersList())) {
            //
            for (int i = 0; i < depositRiskVo.getGuaranteePersList().size(); i++) {
                RiskPersonVo riskPersonVo = new RiskPersonVo();
                riskPersonVo.setName(depositRiskVo.getGuaranteePersList().get(i).getName());
                riskPersonVo.setRelation(GUARANTEE_PERSON.getCode());
                riskPersonVo.setApplyNo(depositTaskNo);
                //地址匹配
                String belongCity = depositRiskVo.getDepositChangeApplyVo().getGroupDistrict();
                String resideCity = commonConstantService.findBasAreaName(depositRiskVo.getGuaranteePersList().get(i).getResideCity());
                if (StringUtils.equals(belongCity, resideCity))
                    riskPersonVo.setApplyAddrMatch("一致");
                else
                    riskPersonVo.setApplyAddrMatch("不一致");
                PbcCredit pbcCredit = new PbcCredit();
                pbcCredit.setName(depositRiskVo.getGuaranteePersList().get(i).getName());
                pbcCredit.setRelation(GUARANTEE_PERSON.getCode());
                pbcCredit.setApplyNo(depositTaskNo);
                riskPersonVo.setPbcCredit(pbcCredit);
                depositRiskVo.getRiskPersonVoGuarList().add(riskPersonVo);

                //担保人配偶
                if (MarriageStatusEnums.MARRIED.getStatus().equals(depositRiskVo.getGuaranteePersList().get(i).getMarriageStatus())//已婚
                        || MarriageStatusEnums.MARRIED_WITH_CHILDREN.getStatus().equals(depositRiskVo.getGuaranteePersList().get(i).getMarriageStatus())) {//已婚有子女
                    //担保人配偶：银行卡核查，反欺诈分析，地址核验，卡核查及交易
                    RiskPersonVo riskPersonVoMate = new RiskPersonVo();
                    riskPersonVoMate.setName(depositRiskVo.getGuaranteePersList().get(i).getMateName());
                    riskPersonVoMate.setRelation(GUARANTEE_PERSON_MATE.getCode());
                    riskPersonVoMate.setApplyNo(depositTaskNo);
                    depositRiskVo.getRiskPersonVoGuMateList().add(riskPersonVoMate);
                }
            }
        }
        //担保企业风险信息，担保人银行流水
        getRiskCommon(depositRiskVo);

        //担保人信息
        List<RiskMgmtGuarantee> riskMgmtGuaranteeNow =
                this.compareList(riskMgmtGuaranteeService.findRiskMgmtGuaranteeListByApplyNo(depositTaskNo), depositRiskVo.getRiskMgmtGuaranteeList());
        depositRiskVo.setRiskMgmtGuaranteeList(riskMgmtGuaranteeNow);
        //根据申请编号取得风险信息
        List<RiskCompany> riskCompanieList = riskCompanyService.findRiskCompanyListByApplyNo(depositTaskNo);
        List<RiskPerson> riskPersonList = riskPersonService.findRiskPersonListByApplyNo(depositTaskNo);
        List<PbcCredit> pbcCreditList = pbcCreditService.findPbcCreditListByApplyNo(depositTaskNo);
        List<AccountDetailVo> accountDetailVoList = accountDetailService.findAccountDetailVoListByApplyNo(depositTaskNo);

        if (ArrayUtils.isNotNullAndLengthNotZero(riskCompanieList)) {
            //定义老数据
            List<RiskCompanyVo> riskCompanyVoOld = new ArrayList<>();
            for (int i = 0; i < riskCompanieList.size(); i++) {
                if (GUARANTEE_COMPANY.getCode().equals(riskCompanieList.get(i).getRelation())) {
                    //担保企业的风险信息
                    riskCompanyVoOld.add(getEntity(riskCompanieList.get(i), new RiskCompanyVo()));
                }
            }
            depositRiskVo.setRiskCompanyVoGuarList(this.compareList(riskCompanyVoOld, depositRiskVo.getRiskCompanyVoGuarList()));
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(riskPersonList)) {
            //老的担保人风险信息
            List<RiskPersonVo> riskPersonVoOld = new ArrayList<>();
            //老的担保人配偶风险信息
            List<RiskPersonVo> riskPersonVoMateOld = new ArrayList<>();
            for (int i = 0; i < riskPersonList.size(); i++) {
                if (GUARANTEE_PERSON.getCode().equals(riskPersonList.get(i).getRelation())) {
                    //担保人的风险信息
                    RiskPersonVo riskPersonVo = getEntity(riskPersonList.get(i), new RiskPersonVo());
                    //担保人人行征信
                    if (ArrayUtils.isNotNullAndLengthNotZero(pbcCreditList)) {
                        for (int j = 0; j < pbcCreditList.size(); j++) {
                            if (GUARANTEE_PERSON.getCode().equals(pbcCreditList.get(j).getRelation()) &&
                                    riskPersonVo.getName().equals(pbcCreditList.get(j).getName())) {
                                //担保人的人行信息
                                riskPersonVo.setPbcCredit(pbcCreditList.get(j));
                            }
                        }
                    }
                    riskPersonVoOld.add(riskPersonVo);
                }
                if (GUARANTEE_PERSON_MATE.getCode().equals(riskPersonList.get(i).getRelation())) {
                    //担保人配偶的风险
                    riskPersonVoMateOld.add(getEntity(riskPersonList.get(i), new RiskPersonVo()));
                }
            }
            depositRiskVo.setRiskPersonVoGuarList(this.compareList(riskPersonVoOld, depositRiskVo.getRiskPersonVoGuarList()));
            depositRiskVo.setRiskPersonVoGuMateList(this.compareList(riskPersonVoMateOld, depositRiskVo.getRiskPersonVoGuMateList()));
        }

        //银行流水信息
        if (ArrayUtils.isNotNullAndLengthNotZero(accountDetailVoList)) {
            depositRiskVo.setAccountDetailVoList(this.compareList(accountDetailVoList, depositRiskVo.getAccountDetailVoList()));
//                depositRiskVo.setAccountDetailVoList(accountDetailVoList);
        }
    }

    /**
     * @param accountDetailVo
     * @param depositTaskNo
     * @return List<AccountDetailList>
     * @throws
     * @Title:
     * @Description: 生成初期银行流水明细
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getAccountDetailVoNew(AccountDetailVo accountDetailVo, String depositTaskNo) {
        accountDetailVo.setAccountDetailId(null);
        accountDetailVo.setApplyNo(depositTaskNo);
        for (int i = 0; i < accountDetailVo.getAccountDetailLists().size(); i++) {
            accountDetailVo.getAccountDetailLists().get(i).setAccountDetailListId(null);
            accountDetailVo.getAccountDetailLists().get(i).setAccountDetailId(null);
        }
    }

    /**
     * @return List<AccountDetailList>
     * @throws
     * @Title:
     * @Description: 生成初期银行流水明细
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private List<AccountDetailList> getAccountDetailListNew() {
        List<AccountDetailList> accountDetailLists = new ArrayList<AccountDetailList>();
        Date now = DateUtils.getNowDate();
        for (int i = -6; i < 0; i++) {
            AccountDetailList accountDetailList = new AccountDetailList();
            Date detailDate = DateUtils.getAddMonth(now, i);
            accountDetailList.setYearMon(DateUtils.getStringDate(detailDate, DateUtils.formatStr_yyyymm));
            accountDetailLists.add(accountDetailList);
        }
        return accountDetailLists;
    }


    /**
     * @param depositTaskNo
     * @param depositRiskVo
     * @return DepositRiskVo
     * @throws
     * @Title:
     * @Description: 取得鹏元查询一览
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getPycreditListVoList(String depositTaskNo, DepositRiskVo depositRiskVo) {

        //生成鹏元查询一览(新数据)
        List<PycreditList> pycreditListNew = new ArrayList<>();
        //担保人：反欺诈分析，地址核验，卡核查及交易，银行卡核查
        if (ArrayUtils.isNotNullAndLengthNotZero(depositRiskVo.getGuaranteePersList())) {
            for (GuaranteePers guaranteePers : depositRiskVo.getGuaranteePersList()) {
                PycreditList pycreditListGuar = new PycreditList();
                convertPy(guaranteePers, GUARANTEE_PERSON.getCode(), pycreditListGuar);
                addPycreditTypes(pycreditListNew, pycreditListGuar, PYCREDIT_TYPE_PER_GUAR);
            }
        }
        //担保企业：银行卡核查，企业查验-风险和债务
        if (ArrayUtils.isNotNullAndLengthNotZero(depositRiskVo.getGuaranteeCompList())) {
            for (GuaranteeComp guaranteeComp : depositRiskVo.getGuaranteeCompList()) {
                PycreditList pycreditListGuar = new PycreditList();
                convertPy(guaranteeComp, GUARANTEE_COMPANY.getCode(), pycreditListGuar);
                addPycreditTypes(pycreditListNew, pycreditListGuar, PYCREDIT_TYPE_COMP_MAIN);
            }
        }

        List<PycreditListVo> pycreditListVos = new ArrayList<>();
        for (PycreditList pycreditList : pycreditListNew) {
            pycreditListVos.add(EntityUtils.getEntity(pycreditList, new PycreditListVo()));
        }
        depositRiskVo.setPycreditListVoList(pycreditListVos);

        //根据depositTaskNo检索，如果存在则取得老数据
        List<PycreditListVo> pycreditListVoList = pycreditListService.findPycreditListByApplyNo(depositTaskNo);

        //比较，获取最新list
        List<PycreditListVo> nowList = this.compareList(pycreditListVoList, depositRiskVo.getPycreditListVoList());
        //插入最新构造的数据
        for (PycreditListVo pycreditListVo : nowList) {
            //保存鹏元查询一览并把id返回页面
            if (StringUtils.isTrimBlank(pycreditListVo.getPycreditId())) {
                PycreditList pycreditList = pycreditListVo.getEntity();
                pycreditListRepository.insertData(pycreditList);
                pycreditListVo.setPycreditId(pycreditList.getPycreditId());
            }
        }
        //保存最新的list
        depositRiskVo.setPycreditListVoList(nowList);
    }

    /**
     * @Description: 比较listOld和listNew，如果listNew中元素在listOld中存在，
     * 获取listOld中的，否则使用listNew中的元素，返回新的list,list中元素需重写equals方法
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/12 11:51
     */
    public <T> List<T> compareList(List<T> listOld, List<T> listNew) {
        List<T> nowList = new ArrayList<T>();
        if (ArrayUtils.isNullOrLengthZero(listOld)) {
            return listNew;
        }

        for (T newObj : listNew) {
            if (listOld.contains(newObj)) {
                nowList.add(listOld.get(listOld.indexOf(newObj)));
            } else {
                nowList.add(newObj);
            }
        }
        return nowList;
    }


    /**
     * @param
     * @return PycreditList
     * @throws
     * @Title:
     * @Description: 添加各类型的鹏元接口
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void addPycreditTypes(List<PycreditList> pycreditListNew, PycreditList pycreditList, String[] pycredit_type_per_main) {
        for (String pycreditType : pycredit_type_per_main) {
            PycreditList pycreditListAdd = new PycreditList();
            pycreditListAdd = getEntity(pycreditList, pycreditListAdd);
            pycreditListAdd.setPycreditType(pycreditType);
            pycreditListNew.add(pycreditListAdd);
        }
    }

    /**
     * @param cstmInfo
     * @param relationType
     * @return PycreditList
     * @throws
     * @Title:
     * @Description: 转换鹏元接口数据
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private PycreditList convertPy(Object cstmInfo, String relationType, PycreditList pycreditList) {
        String depositTaskNo = CommonUtils.getPropertyValueByObject("applyNo", cstmInfo).toString();
        //获取所有地址信息
        Map<String, String> areaMap = basAreaService.getBasAreaCodeAndName();
        pycreditList.setApplyNo(depositTaskNo);
        pycreditList.setRelation(relationType);

        if (cstmInfo instanceof CstmPerson) {
            pycreditList.setName(((CstmPerson) cstmInfo).getName());
            pycreditList.setDocumentNo(((CstmPerson) cstmInfo).getCertifNo());
            pycreditList.setPhone(((CstmPerson) cstmInfo).getMobileNo());
            pycreditList.setArchviesNo(((CstmPerson) cstmInfo).getLicenseNo());
            pycreditList.setCarModels(conversionQuasiDriveModel(((CstmPerson) cstmInfo).getQuasiDriveModel()));
            if (((CstmPerson) cstmInfo).getFirstIssueDate() != null) {
                pycreditList.setFirstGetDate(DateUtils.getStringDate(((CstmPerson) cstmInfo).getFirstIssueDate()));
            }
        }
        if (cstmInfo instanceof CstmPersAddr) {
            String areaCensus = this.getAreaName(cstmInfo, "census", areaMap);
            String areaReside = this.getAreaName(cstmInfo, "reside", areaMap);

            pycreditList.setCensusAddr(areaCensus.concat(getString(((CstmPersAddr) cstmInfo).getCensusAddr())));
            pycreditList.setResideAddr(areaReside.concat(getString((((CstmPersAddr) cstmInfo).getResideAddr()))));
        }
        if (cstmInfo instanceof CstmPersJob) {
            String areaComp = this.getAreaName(cstmInfo, "comp", areaMap);
            pycreditList.setCompAddr(areaComp.concat(getString((((CstmPersJob) cstmInfo).getCompAddr()))));
        }

        if (cstmInfo instanceof CommonBorrower) {
            String areaComp = this.getAreaName(cstmInfo, "comp", areaMap);
            pycreditList.setName(((CommonBorrower) cstmInfo).getName());
            pycreditList.setDocumentNo(((CommonBorrower) cstmInfo).getCertifNo());
            pycreditList.setPhone(((CommonBorrower) cstmInfo).getMobileNo());
            pycreditList.setCensusAddr(areaComp.concat(getString((((CommonBorrower) cstmInfo).getCompAddr()))));
        }
        //担保人
        if (cstmInfo instanceof GuaranteePers && GUARANTEE_PERSON.getCode().equals(relationType)) {
            pycreditList.setName(((GuaranteePers) cstmInfo).getName());
            pycreditList.setDocumentNo(((GuaranteePers) cstmInfo).getCertifNo());
            pycreditList.setPhone(((GuaranteePers) cstmInfo).getMobileNo());
            pycreditList.setCensusAddr(this.getAreaName(cstmInfo, "census", areaMap) + getString(((GuaranteePers) cstmInfo).getCensusAddr()));
            pycreditList.setResideAddr(this.getAreaName(cstmInfo, "reside", areaMap) + getString(((GuaranteePers) cstmInfo).getResideAddr()));
            pycreditList.setCensusAddr(this.getAreaName(cstmInfo, "comp", areaMap) + getString(((GuaranteePers) cstmInfo).getCompAddr()));
        }
        //担保人配偶
        if (cstmInfo instanceof GuaranteePers && GUARANTEE_PERSON_MATE.getCode().equals(relationType)) {
            pycreditList.setName(((GuaranteePers) cstmInfo).getMateName());
            pycreditList.setDocumentNo(((GuaranteePers) cstmInfo).getMateCertifNo());
            pycreditList.setPhone(((GuaranteePers) cstmInfo).getMateMobileNo());
//            pycreditList.setCensusAddr(this.getAreaName(cstmInfo,"census",areaMap)+getString(((GuaranteePers) cstmInfo).getCensusAddr()));
//            pycreditList.setResideAddr(this.getAreaName(cstmInfo,"reside",areaMap)+getString(((GuaranteePers) cstmInfo).getResideAddr()));
            pycreditList.setCensusAddr(this.getAreaName(cstmInfo, "mateComp", areaMap) + getString(((GuaranteePers) cstmInfo).getMateCompAddr()));
        }

        if (cstmInfo instanceof CstmCompany) {
            pycreditList.setName(((CstmCompany) cstmInfo).getName());
            pycreditList.setDocumentNo(((CstmCompany) cstmInfo).getSocialCertifNo());
            pycreditList.setCompAddr(this.getAreaName(cstmInfo, "comp", areaMap) + getString(((CstmCompany) cstmInfo).getCompAddr()));
        }
        if (cstmInfo instanceof GuaranteeComp) {
            pycreditList.setName(((GuaranteeComp) cstmInfo).getName());
            pycreditList.setDocumentNo(((GuaranteeComp) cstmInfo).getSocialCertifNo());
            pycreditList.setCompAddr(this.getAreaName(cstmInfo, "comp", areaMap) + getString(((GuaranteeComp) cstmInfo).getCompAddr()));
        }
        return pycreditList;
    }

    /**
     * @Description: 将驾驶证代码转换成实际准架车型
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/8/30 15:30
     */
    private String conversionQuasiDriveModel(String quasiDriveModel) {
        if (StringUtils.isTrimBlank(quasiDriveModel)) {
            return "";
        } else {
            String carModels = "";
            String[] models = quasiDriveModel.split(StringUtils.COMMA);
            for (String model : models) {
                try {//如果已经是准架车型，这里转换会报错，直接返回准驾车型就行了
                    Integer.parseInt(model);
                } catch (NumberFormatException e) {
                    return quasiDriveModel;
                }
                String modelName = commonConstantService.findSysCodeValueName("quasiDriveModel", model);
                if (StringUtils.isTrimBlank(modelName)) {
                    throw new FmsServiceException("未从数据字典中获取到准架车型");
                }
                carModels = carModels + modelName;
            }
            return carModels;
        }
    }

    /**
     * @Description: 根据地址编码获取地址名称
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/12 20:33
     */
    private String getAreaName(Object obj, String pre, Map areaMap) {
        String area = "";
        try {
            area = areaMap.get(CommonUtils.getPropertyValueByObject(pre + "Prov", obj).toString()).toString()
                    + areaMap.get(CommonUtils.getPropertyValueByObject(pre + "City", obj).toString()).toString()
                    + areaMap.get(CommonUtils.getPropertyValueByObject(pre + "County", obj).toString()).toString();
        } catch (Exception e) {
            log.error(e.getMessage());
            area = "";
        }
        return area;
    }

    private String getString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    /**
     * @param depositTaskNo
     * @param depositRiskVo
     * @return DepositRiskVo
     * @throws
     * @Title:
     * @Description: 取得申请录入相关信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getApplyInfo(String depositTaskNo, DepositRiskVo depositRiskVo) {
        DepositChangeApplyVo vo = new DepositChangeApplyVo();
        DepositChangeTask task = getDepositChangeTaskByTaskNo(depositTaskNo);
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        String contNo = task.getContNo();
        vo = depositChangeTaskRepository.selectApplyInfoByContNo(contNo);
        vo.setDepositTaskNo(depositTaskNo); //变更任务号
        // 获取附件信息
        vo.setBizFilesList(bizFilesService.findBizFilesList(depositTaskNo, BizCodeTypeEnums.DEPOSIT_CHANGE_FILE.getCodeType()));
        // 获取个人担保人信息
        List<GuaranteePers> guaranteePersList = findGuaranteePersByApplyNo(depositTaskNo);
        vo.setGuaranteePersList(guaranteePersList);
        // 获取企业担保人信息
        List<GuaranteeComp> guaranteeCompList = findGuaranteeCompsByApplyNo(depositTaskNo);
        vo.setGuaranteeCompList(guaranteeCompList);
        vo.setSupplementDeposit(task.getSupplementDeposit()); //补充保证金
        vo.setApplyRemark(task.getApplyRemark()); //申请备注
        // 查询基本信息
        List<ContRepaySked> contRepaySkedList = findContRepaySkedByContNo(contNo);
        BigDecimal alreadyRepayAmount = BigDecimal.ZERO;//已还金额
        BigDecimal residueAmount = BigDecimal.ZERO;//剩余租金
        int alreadyRepayNper = 0;//已还期数
        for (ContRepaySked contRepaySked : contRepaySkedList) {
            if (RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())//成功
                    || RepayStatusEnums.PREPAYMENT.getType().equals(contRepaySked.getRepayStatus())) {//已提前结清
                if (!"0".equals(contRepaySked.getPeriod())) {//去掉首付那一期
                    alreadyRepayNper++;
                    alreadyRepayAmount = alreadyRepayAmount.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()));
                }
            } else {
                residueAmount = residueAmount.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()));
            }
        }
        vo.setAlreadyRepayAmount(alreadyRepayAmount); //已还金额
        vo.setAlreadyRepayNper(alreadyRepayNper); //已还期数
        vo.setResidueAmount(residueAmount); //剩余租金
        depositRiskVo.setDepositChangeApplyVo(vo);
        //将担保人和担保企业信息重新赋值
        depositRiskVo.setGuaranteePersList(vo.getGuaranteePersList());
        depositRiskVo.setGuaranteeCompList(vo.getGuaranteeCompList());
    }

    /**
     * 通过变更任务号获取变更任务
     *
     * @param depositTaskNo 变更任务号
     * @return
     */
    public DepositChangeTask getDepositChangeTaskByTaskNo(String depositTaskNo) {
        Example example = SqlUtil.newExample(DepositChangeTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("depositTaskNo", depositTaskNo);
        return depositChangeTaskRepository.selectOneByExample(example);
    }

    /**
     * @param depositTaskNo 变更任务号(订单编号)
     * @return List<GuaranteePers>
     * @throws
     * @Title:
     * @Description: 根据订单编号获取担保人信息
     * @author huzongcheng
     */
    public List<GuaranteePers> findGuaranteePersByApplyNo(String depositTaskNo) {
        Example example = SqlUtil.newExample(GuaranteePers.class);
        example.createCriteria().andEqualTo("applyNo", depositTaskNo);
        if (guaranteePersRepository.selectListByExample(example) == null) {
            List<GuaranteePers> guaranteePersList = new ArrayList<>();
            return guaranteePersList;
        }
        return guaranteePersRepository.selectListByExample(example);
    }

    /**
     * @param depositTaskNo 变更任务号(订单编号)
     * @return List<GuaranteeComp>
     * @throws
     * @Title:
     * @Description: 根据订单编号获取担保企业信息
     * @author huzongcheng
     */
    public List<GuaranteeComp> findGuaranteeCompsByApplyNo(String depositTaskNo) {
        Example example = SqlUtil.newExample(GuaranteeComp.class);
        example.createCriteria().andEqualTo("applyNo", depositTaskNo);
        if (guaranteeCompRepository.selectListByExample(example) == null) {
            List<GuaranteeComp> guaranteeCompList = new ArrayList<>();
            return guaranteeCompList;
        }
        return guaranteeCompRepository.selectListByExample(example);
    }

    /**
     * @Description: 根据合同号查询所有还款计划表
     * @param: contNo 合同编号
     * @return: List<ContRepaySked> 还款计划集合
     * @Author: huzongcheng
     */
    public List<ContRepaySked> findContRepaySkedByContNo(String contNo) {
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contNo);
        SqlUtil.setOrderByColumnAsc(example, "period");
        List<ContRepaySked> contRepaySkedList = contRepaySkedRepository.selectListByExample(example);
        return contRepaySkedList;
    }

    /**
     * 通过变更任务号判断有无担保人
     *
     * @param depositTaskNo 变更任务号
     * @return
     */
    public boolean getDepositFlag(String depositTaskNo) {
        // 获取个人担保人信息
        List<GuaranteePers> guaranteePersList = findGuaranteePersByApplyNo(depositTaskNo);
        // 获取企业担保人信息
        List<GuaranteeComp> guaranteeCompList = findGuaranteeCompsByApplyNo(depositTaskNo);
        return ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList) || ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList);
    }

    /**
     * @param
     * @return DeferTask
     * @throws
     * @Title:
     * @Description: 审批日志保存
     * @author huzongcheng
     */
    @Transactional
    private void saveWorkFlowLog(DepositChangeTask task, String remark, ActRuTaskVo actRuTaskVo, String actType, SysUser sysUser) {
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(task.getDepositTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.DEPOSIT_CHANGE.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(remark);
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
        //更新任务表
        depositChangeTaskRepository.updateByPrimaryKeyData(task, true);
    }
}