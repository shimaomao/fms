package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActUtils;
import cn.com.leadu.fms.business.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.business.service.*;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.*;
import cn.com.leadu.fms.common.constant.enums.product.FactorTypeEnums;
import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.ChangeLesseeTaskRepository;
import cn.com.leadu.fms.data.prebiz.repository.ApplyVisitRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.data.prebiz.repository.RationalityPurchaseRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvisit.ApplyVisitVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.pojo.product.vo.prodintrst.ProdIntrstVo;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.common.constant.PreBizRabbitMqQueues;
import cn.com.leadu.fms.prebiz.rpc.baseinfo.BasPartnerRpc;
import cn.com.leadu.fms.prebiz.rpc.product.ProductRpc;
import cn.com.leadu.fms.prebiz.rpc.system.SysParamRpc;
import cn.com.leadu.fms.prebiz.rpc.system.SysUserRpc;
import cn.com.leadu.fms.prebiz.service.*;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanySaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonSaveVo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SAVEINFO;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;
import static cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums.PRE_APPLY_INPUT_COMP;
import static cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums.PRE_APPLY_INPUT_PER;
import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.APPLY_NUM_TYPE;
import static cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums.COMPANY;
import static cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums.PERSON;
import static cn.com.leadu.fms.common.constant.enums.prebiz.ChargePayModeEnums.INSTALMENT_CHARGE;
import static cn.com.leadu.fms.common.constant.enums.prebiz.DepositRtnModeEnums.INSTALMENT_DEPOSIT;

/**
 * @author wangxue
 * @ClassName: ApplyInputService
 * @Description: 申请录入管理
 * @date 2018-03-23
 */
@Service
@Slf4j
public class ApplyInputServiceImpl implements ApplyInputService {

    @Autowired
    private ApplyFinanceService applyFinanceService;

    @Autowired
    private ApplyVehicleService applyVehicleService;

    @Autowired
    private ApplyFinDetailService applyFinDetailService;

    @Autowired
    private NumGenerateService numGenerateService;

    @Autowired
    private CstmPersonService cstmPersonService;

    @Autowired
    private GuaranteePersService guaranteePersService;

    @Autowired
    private GuaranteeCompService guaranteeCompService;

    @Autowired
    private ProductRpc productRpc;

    @Autowired
    private CstmCompanyService cstmCompanyService;
    @Autowired
    private CstmContactService cstmContactService;
    @Autowired
    private CstmPersAddrService cstmPersAddrService;
    @Autowired
    private CstmPersJobService cstmPersJobService;
    @Autowired
    private CstmPersMateService cstmPersMateService;

    @Autowired
    private ContractFinanceService contractFinanceService;

    @Autowired
    private BizActStatusService bizActStatusService;

    @Autowired
    private ContractVehicleService contractVehicleService;

    @Autowired
    private BizFilesService bizFilesService;

    @Autowired
    private ApplyService applyService;

    @Autowired
    private BasPartnerRpc basPartnerRpc;

    @Autowired
    private WorkflowLogService workflowLogService;

    @Autowired
    private BasFileTypeRpc basFileTypeRpc;

    @Autowired
    private RabbitService rabbitService;

    @Autowired
    private CstmRelationService cstmRelationService;

    @Autowired
    private CommonBorrowerService commonBorrowerService;

    @Autowired
    private CrmPersonService crmPersonService;

    @Autowired
    private CrmCompanyService crmCompanyService;

    @Autowired
    private RationalityPurchaseRepository rationalityPurchaseRepository;

    @Autowired
    private RationalityPurchaseService rationalityPurchaseService;

    @Autowired
    private StockAssetsService stockAssetsService;

    @Autowired
    private ApplyVisitRepository applyVisitRepository;

    @Autowired
    private ApplyVisitService applyVisitService;

    @Autowired
    private QuotationDeviceService quotationDeviceService;

    @Autowired
    private SysParamRpc sysParamRpc;
    /**
     * 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  : 承租人变更repository
     */
    @Autowired
    private ChangeLesseeTaskRepository changeLesseeTaskRepository;
    /**
     * 用户Rpc
     */
    @Autowired
    private SysUserRpc sysUserRpc;
    /**
     *  合同融资信息repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    // 判断融资项目是否为首尾付或保证金项目，1:是
    private final int IS_TRUE = 1;
    // 投资总额
    private final String INVEST_TOTAL = "investTotal";
    // 首尾付总额
    private final String INIT_FINAL_TOTAL = "initFinalTotal";
    // 首尾付总额
    private final String FINAL_TOTAL = "finalTotal";
    // 保证金总额
    private final String DEPOSIT_TOTAL = "depositTotal";

    /**
     * @Title:
     * @Description: 保存申请录入信息(暂存)
     * @param applyInputVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-23 10:18:12
     */
    @Override
    @Transactional
    public ApplyInputVo saveApplyInputVo(ApplyInputVo applyInputVo) {
        // 取得申请编号
        String applyNum = numGenerateService.getNumGenerateByNumType(NumTypeEnums.APPLY_NUM_TYPE.getType());
        //融资车辆tab
        saveModifyApplyFinance(applyNum,applyInputVo.getApplyFinanceVo(),applyInputVo.getApplyVehicleVoList());

        //客户信息tab
        if(PERSON.getType().equals(applyInputVo.getApplyType())){
            //保存个人客户基本信息
            saveCstmPerson(applyInputVo,applyNum);
        }else{
            //保存企业客户基本信息
            saveCstmComp(applyInputVo,applyNum);
        }
        // 个人和企业共通的关系人信息保存
        saveCommonInfo(applyInputVo, applyNum);


        //附件信息
        saveBizFiles(applyInputVo,applyNum);

        //客户名称
        String customerName = getCustomerName(applyInputVo);

        //获取区域经理
        Map<String, String> map = new HashMap<>();
        map.put("groupCode", applyInputVo.getUserGroup());
       /* //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.startContractGeneration(applyNum,applyInputVo.getApplyType(),customerName,map);*/

        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.startContractGeneration(applyNum,applyInputVo.getApplyType(),createServiceName(applyInputVo),map);
        //申请信息
        saveApply(applyInputVo,applyNum,SAVEINFO.getType(), actRuTaskVo);

        ApplyInputVo applyInput = new ApplyInputVo();
        applyInput.setApplyNo(applyNum);
        applyInput.setTaskId(actRuTaskVo.getId());
        applyInput.setApplyType(applyInputVo.getApplyType());
        return applyInput;
    }

    /**
     * @Title:
     * @Description: 个人和企业共通的保存方法
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-2 10:18:12
     */
    private void saveCommonInfo(ApplyInputVo applyInputVo, String applyNum) {
        //保存购买合理性
        saveRationalityPur(applyInputVo,applyNum);
        //保存联系人信息
        if(applyInputVo.getCstmContactList().size()>0)
            cstmContactService.saveCstmContact(applyInputVo.getCstmContactList(),applyNum);
        //保存担保人
        saveGuaranteePresList(applyInputVo,applyNum);
        //保存担保企业
        saveGuaranteeCompList(applyInputVo,applyNum);
        //保存共同借款人
        saveCommonBrorrowerList(applyInputVo,applyNum);
        //保存家访信息
        saveVisitApply(applyInputVo,applyNum);
    }


    /*
     *订单信息生成
     */
    private void saveApply(ApplyInputVo applyInputVo, String applyNum, String act, ActRuTaskVo actRuTaskVo) {
        Apply apply = new Apply();
        //订单编号
        apply.setApplyNo(applyNum);
        //申请类型
        apply.setApplyType(applyInputVo.getApplyType());
        //企业信息1
        apply.setCompanyType1(applyInputVo.getCompanyType1());
        //企业信息2
        apply.setCompanyType2(applyInputVo.getCompanyType2());
        //如果是个人，设置默认值
        if(ApplyTypeEnums.PERSON.getType().equals(apply.getApplyType())){
            apply.setCompanyType1(CompanyType.person.getType());
            apply.setCompanyType2(CompanyType.person.getType());
        }
        //设置是否家访
        apply.setVisitFlag(applyInputVo.getVisitFlag());
        //设置不家访原因
        apply.setNovisitReason(applyInputVo.getNovisitReason());
        //审批备注
        apply.setRemark(applyInputVo.getRemark());
        //订单状态
        String applyBizStatusUpd = actRuTaskVo.getTaskCode();
        //
        if(StringUtils.isTrimBlank(applyBizStatusUpd)){
            throw new FmsServiceException( "合同状态取得失败");
        }
        apply.setBizStatus(applyBizStatusUpd);
        //订单提出账号
        apply.setApplyUser(applyInputVo.getUser());
        //订单提出机构代码
        apply.setApplyGroup(applyInputVo.getUserGroup());
        //订单创建日期
        apply.setApplyCreatDate(DateUtils.getNowDate());
        //提交
        if(SUBMIT.getType().equals(act)){
            //订单提交日期
            apply.setApplyFirsbtDate(DateUtils.getNowDate());
            apply.setApplySubmitDate(DateUtils.getNowDate());
//            //直接提交(不暂存时)将当前节点用户赋给风控初审派单人
//            apply.setApproveUser(actRuTaskVo.getNextAssignee());
        }
        //当前节点
        apply.setPresentUser(actRuTaskVo.getNextAssignee());
        //订单信息保存
        applyService.saveApply(apply);

        //订单日志保存
        if(SUBMIT.getType().equals(act)){
            applyInputVo.setApplyNo(applyNum);
            saveWorkFlowLog(applyInputVo, applyBizStatusUpd);
        }
    }

    private void saveWorkFlowLog(ApplyInputVo applyInputVo, String applyBizStatusUpd) {
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(applyInputVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setActType(SUBMIT.getType());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(applyInputVo.getApplyNo());
        workflowLog.setRemark1(applyInputVo.getRemark());
        workflowLog.setStatus(applyBizStatusUpd);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 提交申请录入信息 (提交并保存)
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    @Override
    @Transactional
    public void submitApplyInputVo(ApplyInputVo applyInputVo) {

        if(StringUtils.isNotTrimBlank(applyInputVo.getTaskId()))
            throw new FmsServiceException("任务已经存在，请不要重复启动");
        // 取得申请编号
        String applyNum = numGenerateService.getNumGenerateByNumType(NumTypeEnums.APPLY_NUM_TYPE.getType());
        //取得风险融资额
        BigDecimal finRiskAmount = setRiskAmount(applyInputVo);
        //家访判断
        checkVisitApply(applyInputVo, finRiskAmount);
        // 融资信息check
        checkApplyFinanceData(applyInputVo.getApplyFinanceVo(), applyInputVo.getApplyVehicleVoList(), "0");

        // 附件信息check
        checkBieFile(applyInputVo.getBizfilesVo(), applyInputVo.getApplyFinanceVo().getProduct(), applyInputVo.getApplyType());
        // 计算每期租金--用万量报价器计算
//        setApplyFinanceRent(applyInputVo.getApplyFinanceVo());

        //融资车辆tab
        saveModifyApplyFinance(applyNum,applyInputVo.getApplyFinanceVo(),applyInputVo.getApplyVehicleVoList());
        //客户信息tab
        if(PERSON.getType().equals(applyInputVo.getApplyType())){
            //保存客户基本信息
            saveCstmPerson(applyInputVo,applyNum);
        }else{
            //保存企业信息
            saveCstmComp(applyInputVo,applyNum);

        }
        // 个人和企业共通的关系人信息保存
        saveCommonInfo(applyInputVo, applyNum);
        // 保存crm信息
        saveCrmInfo(applyInputVo);

        //附件信息
        saveBizFiles(applyInputVo,applyNum);


        //客户名称

        String customerName = getCustomerName(applyInputVo);

        //获取区域经理
        Map<String, String> map = new HashMap<>();
        map.put("groupCode", applyInputVo.getUserGroup());

       /* //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.startContractGenerationAndSubmit(applyNum,applyInputVo.getApplyType(),customerName,map);*/

        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.startContractGenerationAndSubmit(applyNum,applyInputVo.getApplyType(),createServiceName(applyInputVo),map);
        //申请信息
        saveApply(applyInputVo,applyNum,SUBMIT.getType(), actRuTaskVo);
        applyInputVo.setApplyNo(applyNum);
        //保存客户关系
        cstmRelationService.saveApplyRelation(applyInputVo);
        //生成模型
        rabbitService.convertAndSend(PreBizRabbitMqQueues.PRE_BIZ_CREDIT_MODEL,applyNum);
    }

    private void checkQuotaion(ApplyFinanceVo applyFinanceVo, List<ApplyVehicleVo> applyVehicleVoList) {
        ApplyInputVo applyInputVo = new ApplyInputVo();
        applyInputVo.setApplyFinanceVo(applyFinanceVo);
        applyInputVo.setApplyVehicleVoList(applyVehicleVoList);
        QuotationDeviceVo quotationDeviceVo =  quotationDeviceService.convertToQuotation(applyInputVo);
        quotationDeviceVo =quotationDeviceService.saveQuotationDeviceInfo(quotationDeviceVo, "2");
        if(quotationDeviceVo.getIrr().compareTo(applyFinanceVo.getIrr()) !=0 ||
                quotationDeviceVo.getMonthlySupply().compareTo(applyFinanceVo.getRent()) !=0 ||
//                quotationDeviceVo.getTax().compareTo(applyFinanceVo.getTax()) !=0 ||
                quotationDeviceVo.getLoanInterest().compareTo(applyFinanceVo.getLoanInterest())!=0 ) {
            //
            throw new FmsServiceException( "报价器项目不正确，请重新计算");
        }
    }

    private void saveCrmInfo(ApplyInputVo applyInputVo) {
        //保存所有CRM个人信息
        crmPersonService.getCrmPersonFromInputVo(applyInputVo);
        //保存所有CRM企业信息
        crmCompanyService.getCrmCompFromInputVo(applyInputVo);
    }

    /**
     * @Title:
     * @Description: 根据订单号修改融资信息 (提交)
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    @Override
    @Transactional
    public void subModifyApplyInputVoByApplyNo(ApplyInputVo applyInputVo) {
        // 融资信息check
        checkApplyFinanceData(applyInputVo.getApplyFinanceVo(), applyInputVo.getApplyVehicleVoList(), "0");
        // 附件信息check
        checkBieFile(applyInputVo.getBizfilesVo(), applyInputVo.getApplyFinanceVo().getProduct(), applyInputVo.getApplyType());
        // 计算每期租金--用万量报价器计算
//        setApplyFinanceRent(applyInputVo.getApplyFinanceVo());
        // 融资信息
        saveModifyApplyFinance(applyInputVo.getApplyNo(), applyInputVo.getApplyFinanceVo(), applyInputVo.getApplyVehicleVoList());
        //取得风险融资额
        BigDecimal finRiskAmount = setRiskAmount(applyInputVo);
        //家访判断
        checkVisitApply(applyInputVo, finRiskAmount);
        //客户信息tab
        if(PERSON.getType().equals(applyInputVo.getApplyType())){
            //保存客户基本信息
            modifyCstmPersonInfo(applyInputVo);
        }else{
            //保存企业信息
            modifyCstmCompInfo(applyInputVo);
        }
        //修改个人和企业的共同信息
        modifyCommonInfo(applyInputVo);

        //保存crm信息
        saveCrmInfo(applyInputVo);

        //更新附件
        updateBizFiles(applyInputVo,applyInputVo.getApplyNo());

        //客户名称
        String customerName = getCustomerName(applyInputVo);

        //获取区域经理
        Map<String, String> map = new HashMap<>();
        map.put("groupCode", applyInputVo.getUserGroup());
        /*//工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.submitContractGenerationInfo(applyInputVo.getTaskId(),applyInputVo.getApplyType(),customerName,map);*/

        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.submitContractGenerationInfo(applyInputVo.getTaskId(),applyInputVo.getApplyType(),createServiceName(applyInputVo),map);
        //更新订单信息
        modifyApply(applyInputVo, SUBMIT.getType(), actRuTaskVo);
        //保存客户关系
        cstmRelationService.saveApplyRelation(applyInputVo);
        //生成模型
        rabbitService.convertAndSend(PreBizRabbitMqQueues.PRE_BIZ_CREDIT_MODEL,applyInputVo.getApplyNo());
    }

    private BigDecimal setRiskAmount(ApplyInputVo applyInputVo) {
        String certifNo;
        //个人的场合
        if(ApplyTypeEnums.PERSON.getType().equals(applyInputVo.getApplyType())){
            certifNo = applyInputVo.getCstmPerson().getCertifNo();
        }else{
            certifNo = applyInputVo.getCstmCompany().getSocialCertifNo();
        }
        //风险融资额
        BigDecimal riskAmountHis =  applyService.riskAmount(applyInputVo.getApplyNo(),applyInputVo.getApplyType(),certifNo);
        //融资额-保证金-首期租金
        ApplyFinanceVo applyFinanceVo = applyInputVo.getApplyFinanceVo();
        BigDecimal nowRiskAmount = applyFinanceVo.getFinTotal().subtract(applyFinanceVo.getRent()).subtract(applyFinanceVo.getDeposit());
        applyInputVo.getApplyFinanceVo().setRiskFinTotal(riskAmountHis.add(nowRiskAmount));
        return riskAmountHis.add(nowRiskAmount);
    }

    /**
     * 保存申请人所有信息
     * @param applyInputVo
     */
    @Transactional
    public void saveCstmPerson(ApplyInputVo applyInputVo,String applyNo){

        if(applyInputVo.getCstmPerson()!=null)
            cstmPersonService.saveCstmPerson(EntityUtils.getEntity(applyInputVo.getCstmPerson(),new CstmPersonSaveVo()),applyNo);
        else cstmPersonService.saveCstmPerson(new CstmPersonSaveVo(),applyNo);
        if(applyInputVo.getCstmPersMate()!=null)
            cstmPersMateService.saveCstmPersMate(EntityUtils.getEntity(applyInputVo.getCstmPersMate(),new CstmPersMateSaveVo()),applyNo);
        else
            cstmPersMateService.saveCstmPersMate(new CstmPersMateSaveVo(),applyNo);
        if(applyInputVo.getCstmPersJob()!=null)
            cstmPersJobService.saveCstmPersJob(EntityUtils.getEntity(applyInputVo.getCstmPersJob(),new CstmPersJobSaveVo()),applyNo);
        else
            cstmPersJobService.saveCstmPersJob(new CstmPersJobSaveVo(),applyNo);
        if(applyInputVo.getCstmPersAddr()!=null)
            cstmPersAddrService.saveCstmPersAddr(EntityUtils.getEntity(applyInputVo.getCstmPersAddr(),new CstmPersAddrSaveVo()),applyNo);
        else
            cstmPersAddrService.saveCstmPersAddr(new CstmPersAddrSaveVo(),applyNo);
    }
    /**
     * 保存申请企业所有信息
     * @param applyInputVo
     */
    @Transactional
    public void saveCstmComp(ApplyInputVo applyInputVo,String applyNo){
        if(applyInputVo.getCstmCompany()!=null)
            cstmCompanyService.saveCstmCompany(EntityUtils.getEntity(applyInputVo.getCstmCompany(),new CstmCompanySaveVo()),applyNo);
        else
            cstmCompanyService.saveCstmCompany(new CstmCompanySaveVo(),applyNo);

        //保存股东信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getStockAssetsList()))
            stockAssetsService.saveStockAssetsList(applyInputVo.getStockAssetsList(),applyNo);
    }
    /**
     * 保存购车合理性信息
     * @param applyInputVo
     */
    public void saveRationalityPur(ApplyInputVo applyInputVo,String applyNo){
        if(applyInputVo.getRationalityPurchase()!=null){
            RationalityPurchase rationalityPurchase = applyInputVo.getRationalityPurchase();
            rationalityPurchase.setApplyNo(applyNo);
            rationalityPurchaseRepository.insertData(rationalityPurchase);
        }else{
            RationalityPurchase rationalityPurchase = new RationalityPurchase();
            rationalityPurchase.setApplyNo(applyNo);
            rationalityPurchaseRepository.insertData(rationalityPurchase);
        }
    }

    /**
     * 批量保存担保人信息
     * @param applyInputVo
     */
    public void saveGuaranteePresList(ApplyInputVo applyInputVo,String applyNo){
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteePersList()))
            guaranteePersService.saveGuaranteePresList(applyInputVo.getGuaranteePersList(),applyNo);
    }

    /**
     * 批量保存担保企业信息
     * @param applyInputVo
     */
    public void saveGuaranteeCompList(ApplyInputVo applyInputVo,String applyNo){
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteeCompList()))
            guaranteeCompService.saveGuaranteeCompList(applyInputVo.getGuaranteeCompList(),applyNo);
    }

    /**
     * 批量保存共同借款人信息
     * @param applyInputVo
     */
    public void saveCommonBrorrowerList(ApplyInputVo applyInputVo,String applyNo){
         if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getCommonBorrowerList()))
                commonBorrowerService.saveCommonBorrowerList(applyInputVo.getCommonBorrowerList(),applyNo);
    }
    /**
     * @Title:
     * @Description: 录入申请后台check
     * @param applyFinanceVo 融资信息
     * @param applyVehicleVoList 融资车辆信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 10:18:12
     */
    private void checkApplyFinanceData(ApplyFinanceVo applyFinanceVo, List<ApplyVehicleVo> applyVehicleVoList, String checkMode) {
        if (applyFinanceVo == null) {
            // 融资方案信息
            throw new FmsServiceException( "融资方案信息不能为空");
        } else if (ArrayUtils.isNullOrLengthZero(applyVehicleVoList) || ArrayUtils.isNullOrLengthZero(applyVehicleVoList.get(0).getApplyFinDetailVoList())) {
            throw new FmsServiceException( "车辆和融资明细信息不能为空");
        }
        // 根据产品代码取得产品信息
        ProductVo productVo = null;
        try {
            Map<String,Object> productVoMap = ResponseEntityUtils.getRestResponseData(productRpc.findProductVoByProduct(applyFinanceVo.getProduct()));
            productVo = JSON.parseObject(JSON.toJSONString(productVoMap),ProductVo.class);
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException( "对应的产品方案不存在");
        }
        // 判断产品方案是否存在
        if (productVo == null) {
            throw new FmsServiceException( "对应的产品方案不存在");
        }
        // 车辆和融资明细
        Map<String, BigDecimal> totalMap = sumFinanceItemTotal(productVo.getFinItemVoList(), applyVehicleVoList);
        String message = checkPercAndAmount(applyFinanceVo, productVo, totalMap);

        if("0".equals(checkMode)){
            // 报价器项目check
            checkQuotaion(applyFinanceVo, applyVehicleVoList);
            //irr范围
            if(!BigDecimalUtils.isValueSection(applyFinanceVo.getIrr(), productVo.getIrrFrom(), productVo.getIrrTo())){
                throw new FmsServiceException( "irr不在允许范围内");
            }
//            //万量税费和利息
//            if(applyFinanceVo.getTax().compareTo(applyFinanceVo.getLoanInterest()) >0){
//                throw new FmsServiceException( "税费大于利息，不可提交");
//            }
        }


        if (StringUtils.isNotTrimBlank(message)) {
            throw new FmsServiceException(message);
        }
        if(ArrayUtils.isNullOrLengthZero(productVo.getProdIntrstVoList())){
            //该产品没有配置任何利率方案
            return;
        }
        // 取得符合的利率方案
        ProdIntrstVo prodIntrstVo = checkProdIntrst(applyFinanceVo, productVo.getProdIntrstVoList());
        if (prodIntrstVo == null) {
            throw new FmsServiceException( "找不到符合的利率方案");
        } else if (!prodIntrstVo.getIntrstNo().equals(applyFinanceVo.getIntrstNo())) {
            throw new FmsServiceException( "判断选择的利率方案不对");
        }
    }

    /**
     * @Title:
     * @Description: 保存申请录入的信息
     * @param applyNum 申请编号
     * @param applyFinanceVo 融资信息
     * @param applyVehicleVoList 融资车辆信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 10:18:12
     */
    @Transactional
    private void saveApplyInputData(String applyNum, ApplyFinanceVo applyFinanceVo, List<ApplyVehicleVo> applyVehicleVoList) {
        // 融资信息
        ApplyFinance applyFinance = EntityUtils.getEntity(applyFinanceVo, new ApplyFinance());
        applyFinance.setApplyNo(applyNum);
        // 车辆信息
        List<ApplyVehicle> applyVehicleList = new ArrayList<>();
        // 融资项目明细
        List<ApplyFinDetail> applyFinDetailList = new ArrayList<>();
        int count = 1;
        for (ApplyVehicleVo applyVehicleVo : applyVehicleVoList) {
            ApplyVehicle applyVehicle = applyVehicleVo.getEntity();
            if (StringUtils.isTrimBlank(applyVehicle.getVehicleNo())) {
                // 融资车辆ID
                applyVehicle.setApplyVehicleId(null);
                applyVehicle.setVehicleNo("" + count++);
            }
            applyVehicle.setApplyNo(applyNum);
            applyVehicle.setVehicleForm(applyFinanceVo.getVehicleForm());
            applyVehicleList.add(applyVehicle);
            for (ApplyFinDetailVo applyFinDetailVo : applyVehicleVo.getApplyFinDetailVoList()) {
                ApplyFinDetail applyFinDetail = EntityUtils.getEntity(applyFinDetailVo, new ApplyFinDetail());
                // 融资年限
                if (applyFinDetail.getFinItemYear() == null) {
                    applyFinDetail.setFinItemYear(0);
                }
                applyFinDetail.setApplyNo(applyNum);
                applyFinDetail.setVehicleNo(applyVehicle.getVehicleNo());
                applyFinDetailList.add(applyFinDetail);
            }
        }
        // 保存融资信息
        applyFinanceService.saveApplyFinance(applyFinance);
        // 保存车辆信息
        if (ArrayUtils.isNotNullAndLengthNotZero(applyVehicleList)) {
            applyVehicleService.saveApplyVehicleList(applyVehicleList);
        }
        // 保存融资明细信息
        if (ArrayUtils.isNotNullAndLengthNotZero(applyFinDetailList)) {
            applyFinDetailService.saveApplyFinDetailList(applyFinDetailList);
        }
    }

    /**
     * @Title:
     * @Description: 保存录入的融资信息
     * @param applyNum 申请编号
     * @param applyFinanceVo 融资信息
     * @param applyVehicleVoList 融资车辆信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 10:18:12
     */
    private void saveModifyApplyFinance(String applyNum, ApplyFinanceVo applyFinanceVo, List<ApplyVehicleVo> applyVehicleVoList){
        // 取得融资信息
        ApplyFinance applyFinance = applyFinanceService.findApplyFinanceByApplyNo(applyNum);
        if (applyFinance != null) {
            // 更新融资车辆信息
            // 最大车辆序号
            int maxVehicleNo = 0;
            // 根据订单编号获取DB的融资信息
            List<ApplyVehicle> applyVehicleList = applyVehicleService.findApplyVehiclesByApplyNo(applyNum);
            maxVehicleNo = Integer.parseInt(applyVehicleList.get(applyVehicleList.size() - 1).getVehicleNo());
            // 当前需要保存的车辆信息
            Map<String, String> applyVehicleIdMap = new HashMap<>();
            for (ApplyVehicleVo applyVehicleVo : applyVehicleVoList) {
                applyVehicleIdMap.put(applyVehicleVo.getApplyVehicleId(), applyVehicleVo.getApplyVehicleId());
            }
            // DB中原有的融资车辆数据
            Map<String, String> applyVehicleIdDbMap = new HashMap<>();
            // 需要删除的融资车辆信息
            List<ApplyVehicle> delApplyVehicleList = new ArrayList<>();
            // 物理删除的融资明细的车辆序号
            List<String> delVehicleNoList = new ArrayList<>();
            for (ApplyVehicle applyVehicle : applyVehicleList) {
                if (!applyVehicleIdMap.containsKey(applyVehicle.getApplyVehicleId())) {
                    delApplyVehicleList.add(applyVehicle);
//                } else {
//                    delVehicleNoList.add(applyVehicle.getVehicleNo());
                }
                //删除所有已存在的融资明细信息
                delVehicleNoList.add(applyVehicle.getVehicleNo());
                applyVehicleIdDbMap.put(applyVehicle.getApplyVehicleId(), applyVehicle.getApplyVehicleId());
            }
            // 本次需要更新的融资车辆信息
            List<ApplyVehicle> updApplyVehicleList = new ArrayList<>();
            // 本次需要新增的融资车辆信息
            List<ApplyVehicle> addApplyVehicleList = new ArrayList<>();
            // 本次需要新增的融资明细信息
            List<ApplyFinDetail> addApplyFinDetailList = new ArrayList<>();
            maxVehicleNo = maxVehicleNo + 1;
            for (ApplyVehicleVo applyVehicleVo : applyVehicleVoList) {
                ApplyVehicle applyVehicle = applyVehicleVo.getEntity();
                if (applyVehicleIdDbMap.containsKey(applyVehicle.getApplyVehicleId())) {
                    // 更新车辆信息
                    updApplyVehicleList.add(applyVehicle);
                } else {
                    // 新增车辆信息
                    applyVehicle.setApplyVehicleId(null);
                    applyVehicle.setVehicleNo("" + maxVehicleNo++);
                    applyVehicle.setApplyNo(applyNum);
                    applyVehicle.setVehicleForm(applyFinanceVo.getVehicleForm());
                    addApplyVehicleList.add(applyVehicle);
                }
                // 融资项目明细信息
                for (ApplyFinDetailVo applyFinDetailVo : applyVehicleVo.getApplyFinDetailVoList()) {
                    ApplyFinDetail applyFinDetail = applyFinDetailVo.getEntity();
                    // 融资年限
                    if (applyFinDetail.getFinItemYear() == null) {
                        applyFinDetail.setFinItemYear(0);
                    }
                    applyFinDetail.setApplyNo(applyNum);
                    applyFinDetail.setVehicleNo(applyVehicle.getVehicleNo());
                    addApplyFinDetailList.add(applyFinDetail);
                }
            }
            // 更新融资信息
            applyFinanceVo.setApplyFinId(applyFinance.getApplyFinId());
            applyFinanceService.modifyApplyFinance(applyFinanceVo.getEntity());
            // 更新车辆信息
            if (ArrayUtils.isNotNullAndLengthNotZero(updApplyVehicleList)) {
                applyVehicleService.modifyApplyVehicleList(updApplyVehicleList);
            }
            // 新增车龄信息
            if (ArrayUtils.isNotNullAndLengthNotZero(addApplyVehicleList)) {
                applyVehicleService.saveApplyVehicleList(addApplyVehicleList);
            }
            // 删除车辆信息和对应的融资明细信息
            if (ArrayUtils.isNotNullAndLengthNotZero(delApplyVehicleList)) {
                applyVehicleService.deleteApplyVehicleListAndFinDetail(delApplyVehicleList);
            }
            // 物理删除融资明细
            if (ArrayUtils.isNotNullAndLengthNotZero(delVehicleNoList)) {
                applyFinDetailService.deletePhysicsApplyFinDetailsByApplyNoAndVehicleNos(applyNum, delVehicleNoList);
            }
            // 新增融资车辆明细
            if (ArrayUtils.isNotNullAndLengthNotZero(addApplyFinDetailList)) {
                applyFinDetailService.saveApplyFinDetailList(addApplyFinDetailList);
            }
        } else {
            // 保存融资车辆信息
            saveApplyInputData(applyNum, applyFinanceVo, applyVehicleVoList);
        }
    }

    /**
     * @Title:
     * @Description: check百分比例和金额是否符合条件
     * @param applyFinanceVo
     * @param productVo
     * @param totalMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 10:18:12
     */
    private String checkPercAndAmount(ApplyFinanceVo applyFinanceVo, ProductVo productVo, Map<String, BigDecimal> totalMap) {
        // 投资总额
        BigDecimal investTotal = totalMap.get(INVEST_TOTAL);
        // 首尾付投资总额
        BigDecimal initFinalTotal = totalMap.get(INIT_FINAL_TOTAL);
        // 尾付投资总额
        BigDecimal finalTotal = totalMap.get(FINAL_TOTAL);
        // 保证金投资投资总额
        BigDecimal depositTotal = totalMap.get(DEPOSIT_TOTAL);
        // 首付比例和金额
        if (BigDecimalUtils.isValueSection(applyFinanceVo.getInitPerc(), productVo.getInitPercFrom(), productVo.getInitPercTo())) {
            if (!checkPercAndAmountCal(initFinalTotal, applyFinanceVo.getInitPerc(), applyFinanceVo.getInitAmount())) {
                return "首付比例和首付金额计算不正确";
            } else {
                if (!BigDecimalUtils.isValueSection(applyFinanceVo.getInitAmount(), productVo.getInitAmountFrom(), productVo.getInitAmountTo())) {
                    return "首付金额不符合条件";
                }
            }
        } else {
            return "首付比例不符合条件";
        }
        // 尾付比例很和金额
        if (BigDecimalUtils.isValueSection(applyFinanceVo.getFinalPerc(), productVo.getFinalPercFrom(), productVo.getFinalPercTo())) {
            if (!checkPercAndAmountCal(finalTotal, applyFinanceVo.getFinalPerc(),applyFinanceVo.getFinalAmount())) {
                return "尾付比例和尾付金额计算不正确";
            } else {
                if (!BigDecimalUtils.isValueSection(applyFinanceVo.getFinalAmount(), productVo.getFinalAmountFrom(), productVo.getFinalAmountTo())) {
                    return "尾付金额不符合条件";
                }
            }
        } else {
            return "尾付比例不符合条件";
        }
        // 保证金率很和保证金
        if (BigDecimalUtils.isValueSection(applyFinanceVo.getDepositPerc(), productVo.getDepositPercFrom(), productVo.getDepositPercTo())) {
            if (!checkPercAndAmountCal(depositTotal, applyFinanceVo.getDepositPerc(), applyFinanceVo.getDeposit())) {
                return "保证金率和保证金计算不正确";
            } else {
                if (!BigDecimalUtils.isValueSection(applyFinanceVo.getDeposit(), productVo.getDepositFrom(), productVo.getDepositTo())) {
                    return "保证金不符合条件";
                }
            }
        } else {
            return "保证金率不符合条件";
        }
        // 投资总额
        if (new BigDecimal(Math.ceil(investTotal.doubleValue())).compareTo(new BigDecimal(Math.ceil(applyFinanceVo.getInvestTotal().doubleValue()))) != 0) {
            return "投资总额计算不正确";
        }
        // 融资额
        if (new BigDecimal(Math.ceil(applyFinanceVo.getFinTotal().doubleValue())).compareTo(new BigDecimal(Math.ceil((investTotal.subtract(applyFinanceVo.getInitAmount())).doubleValue()))) != 0) {
            return "融资额计算不正确";
        }

        //年供比例和年供金额
        if (BigDecimalUtils.isValueSection(applyFinanceVo.getAnnualSupplyRate(), productVo.getAnnualSupplyAmountFrom(), productVo.getAnnualSupplyAmountTo())) {
            if (!checkPercAndAmountCal(applyFinanceVo.getFinTotal(),applyFinanceVo.getAnnualSupplyRate(),applyFinanceVo.getAnnualSupplyAmount())) {
                return "年供比例和年供金额计算不正确";
            } else {
                if (!BigDecimalUtils.isValueSection(applyFinanceVo.getDeposit(), productVo.getDepositFrom(), productVo.getDepositTo())) {
                    return "年供金额不符合条件";
                }
            }
        } else {
            return "年供比例不符合条件";
        }

        return "";
    }

    private boolean checkPercAndAmountCal(BigDecimal baseTotal, BigDecimal perc, BigDecimal amount) {

        if(BigDecimalUtils.multiplyCeil(baseTotal, BigDecimalUtils.dividePercent(perc)).compareTo(amount) == 0){
            return true;
        }else if(BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(amount, baseTotal, 2)).compareTo(perc.setScale(0,BigDecimal.ROUND_HALF_UP)) == 0){  //比例
            return true;
        }else{
            return false;
        }
    }

    /**
     * @Title:
     * @Description: 判断分析当前的使用的利率方案
     * @param applyFinanceVo 融资方案信息
     * @param prodIntrstVoList 产品利率方案
     * @return String 利率方案序号
     * @throws
     * @author wangxue
     * @date 2018-3-24 10:18:12
     */
    private ProdIntrstVo checkProdIntrst(ApplyFinanceVo applyFinanceVo, List<ProdIntrstVo> prodIntrstVoList) {
        if (ArrayUtils.isNotNullAndLengthNotZero(prodIntrstVoList)) {
            for (ProdIntrstVo prodIntrstVo : prodIntrstVoList) {
                if (isIntrstFactor(applyFinanceVo, prodIntrstVo.getProdIntrstFactorVoList())) {
                    return prodIntrstVo;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * @Title:
     * @Description: 判断利率方案中的利率因子是否全部符合条件
     * @param applyFinanceVo 融资信息
     * @param prodIntrstFactorVoList 利率因子
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 10:18:12
     */
    private boolean isIntrstFactor(ApplyFinanceVo applyFinanceVo, List<ProdIntrstFactorVo> prodIntrstFactorVoList) {
        if (ArrayUtils.isNotNullAndLengthNotZero(prodIntrstFactorVoList)) {
            for (ProdIntrstFactorVo prodIntrstFactorVo : prodIntrstFactorVoList) {
                Object value = CommonUtils.getPropertyValueByObject(prodIntrstFactorVo.getFactorCode(), applyFinanceVo);
                if (value == null) {
                    return false;
                }
                if (!isProdIntrstFactor(value.toString(), prodIntrstFactorVo)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @Title:
     * @Description: 判断当前利率因子是否符合条件
     * @param value
     * @param prodIntrstFactorVo 利率因子条件
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 10:18:12
     */
    private boolean isProdIntrstFactor(String value, ProdIntrstFactorVo prodIntrstFactorVo) {
        // 等于
        if (FactorTypeEnums.EQUAL.getType().equals(prodIntrstFactorVo.getFactorType())) {
            if (StringUtils.container(prodIntrstFactorVo.getFactorValueFrom(), value)) {
                return true;
            }
        } else {
            // 区间
            BigDecimal decimalValue = new BigDecimal(value);
            if (BigDecimalUtils.isValueSection(decimalValue, new BigDecimal(prodIntrstFactorVo.getFactorValueFrom()), new BigDecimal(prodIntrstFactorVo.getFactorValueTo()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Title:
     * @Description: 计算出投资总额信息
     * @param applyVehicleVoList
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 10:18:12
     */
    private Map<String, BigDecimal> sumFinanceItemTotal(List<FinItemVo> finItemVoList, List<ApplyVehicleVo> applyVehicleVoList) {
        Map<String, BigDecimal> resultMap = new HashMap<>();
        // 投资总额
        BigDecimal investTotal = BigDecimal.ZERO;
        // 首尾付投资总额
        BigDecimal initFinalTotal = BigDecimal.ZERO;
        // 首尾付投资总额
        BigDecimal finalTotal = BigDecimal.ZERO;
        // 保证金投资投资总额
        BigDecimal depositTotal = BigDecimal.ZERO;
        // 取得首尾付项目和保证金项目
        List<String> initFinalItemList = new ArrayList<>();
        List<String> finalItemList = new ArrayList<>();
        List<String> depositItemList = new ArrayList<>();
        for (FinItemVo finItemVo : finItemVoList) {
            // 首尾付项目
            if (IS_TRUE == finItemVo.getInitFinalItemFlag()) {
                initFinalItemList.add(finItemVo.getFinItem());
            }
            // 尾付项目
            if (IS_TRUE == finItemVo.getFinalItemFlag()) {
                finalItemList.add(finItemVo.getFinItem());
            }
            // 保证金融资项目
            if (IS_TRUE == finItemVo.getDepositItemFlag()) {
                depositItemList.add(finItemVo.getFinItem());
            }
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(applyVehicleVoList)) {
            // 车辆的投资总额、首尾付投资总额、保证金投资总额
            BigDecimal vehicleInvestTotal = BigDecimal.ZERO, vehicleInitFinalTotal = BigDecimal.ZERO, vehicleFinalTotal = BigDecimal.ZERO, vehicleDepositTotal = BigDecimal.ZERO;
            for (ApplyVehicleVo applyVehicleVo : applyVehicleVoList) {
                List<ApplyFinDetailVo> applyFinDetailVoList = applyVehicleVo.getApplyFinDetailVoList();
                for (ApplyFinDetailVo applyFinDetailVo : applyFinDetailVoList) {
                    vehicleInvestTotal = vehicleInvestTotal.add(applyFinDetailVo.getFinAmount());
                    // 首尾付项目
                    if (ArrayUtils.equalsContains(initFinalItemList, applyFinDetailVo.getFinItem())) {
                        vehicleInitFinalTotal = vehicleInitFinalTotal.add(applyFinDetailVo.getFinAmount());
                    }
                    // 首尾付项目
                    if (ArrayUtils.equalsContains(finalItemList, applyFinDetailVo.getFinItem())) {
                        vehicleFinalTotal = vehicleFinalTotal.add(applyFinDetailVo.getFinAmount());
                    }
                    // 保证金融资项目
                    if (ArrayUtils.equalsContains(depositItemList, applyFinDetailVo.getFinItem())) {
                        vehicleDepositTotal = vehicleDepositTotal.add(applyFinDetailVo.getFinAmount());
                    }
                }
                investTotal = investTotal.add((vehicleInvestTotal.setScale(0,BigDecimal.ROUND_UP)).multiply(new BigDecimal(applyVehicleVo.getVehicleCount().toString())));
                initFinalTotal = initFinalTotal.add((vehicleInitFinalTotal.setScale(0,BigDecimal.ROUND_UP)).multiply(new BigDecimal(applyVehicleVo.getVehicleCount().toString())));
                finalTotal = finalTotal.add((vehicleFinalTotal.setScale(0,BigDecimal.ROUND_UP)).multiply(new BigDecimal(applyVehicleVo.getVehicleCount().toString())));
                depositTotal = depositTotal.add((vehicleDepositTotal.setScale(0,BigDecimal.ROUND_UP)).multiply(new BigDecimal(applyVehicleVo.getVehicleCount().toString())));
                vehicleInvestTotal = vehicleInitFinalTotal = vehicleFinalTotal = vehicleDepositTotal = BigDecimal.ZERO;
            }
        }
        resultMap.put(INVEST_TOTAL, investTotal.setScale(BigDecimal.ROUND_CEILING));
        resultMap.put(INIT_FINAL_TOTAL, initFinalTotal.setScale(BigDecimal.ROUND_CEILING));
        resultMap.put(FINAL_TOTAL, finalTotal.setScale(BigDecimal.ROUND_CEILING));
        resultMap.put(DEPOSIT_TOTAL, depositTotal.setScale(BigDecimal.ROUND_CEILING));
        return resultMap;
    }

    /**
     * @Title:
     * @Description: 判断附件上传是否符合条件
     * @param bizfilesVo 附件上传的信息
     * @param product 产品方案
     * @param applyType 申请类型
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    private void checkBieFile(CommonBizFilesVo bizfilesVo, String product, String applyType) {
        String bizFileType = "";
        if (PERSON.getType().equals(applyType)) {
            // 个人
            bizFileType = BizCodeTypeEnums.PRE_APPLY_INPUT_PER.getCodeType();
        } else {
            bizFileType = BizCodeTypeEnums.PRE_APPLY_INPUT_COMP.getCodeType();
        }
        // 根据基本附件类型和产品方案获取的附件类型
        List<BasFileType> fileTypeList = new ArrayList<>();
        // DB的附件类型Map
        Map<String, String> basFileTypeMap = new HashMap<>();
        try {
            // 根据附件类型获取附件类型子集
            List<BasFileType> basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(bizFileType));
            if (ArrayUtils.isNotNullAndLengthNotZero(basFileTypeList)) {
                for (BasFileType basFileType : basFileTypeList) {
                    fileTypeList.add(basFileType);
                    basFileTypeMap.put(basFileType.getFileType(), basFileType.getFileType());
                }
            }
            // 根据产方案获取附件类型
            List<BasFileTypeVo> basFileTypeVoList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.findBasFileTypeVosByProduct(product));
            if (ArrayUtils.isNotNullAndLengthNotZero(basFileTypeVoList)) {
                for (BasFileTypeVo basFileTypeVo : basFileTypeVoList) {
                    if (!basFileTypeMap.containsKey(basFileTypeVo.getFileType())) {
                        fileTypeList.add(basFileTypeVo.getEntity());
                        basFileTypeMap.put(basFileTypeVo.getFileType(), basFileTypeVo.getFileType());
                    }
                }
            }
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        // 画面呢上传的附件类型及附件个数
        Map<String, Integer> inputFileMap = new HashMap<>();
        // 附件录入
        List<BizFilesListVo> bizFilesListVoList = bizfilesVo.getBizFilesListVos();
        if (ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVoList)) {
            for (BizFilesListVo bizFilesListVo : bizFilesListVoList) {
                inputFileMap.put(bizFilesListVo.getBasFileTypeValue(), bizFilesListVo.getFileVos().size());
            }
        } else {
            bizFilesListVoList = new ArrayList<>();
        }
        // 判断当前必须上传附件的附件类型是否全部有上传附件
        for (BasFileType basFileType : fileTypeList) {
            Integer inputFileCount = inputFileMap.get(basFileType.getFileType());
            if ("1".equals(basFileType.getFileChkFlag())) {
                if (inputFileCount == null || inputFileCount == 0) {
                    throw new FmsServiceException("请上传" + basFileType.getFileTypeName() + "的附件！");
                }
            }
        }
        // 判断是否有上传附件类型意外的附件
        for (BizFilesListVo bizFilesListVo : bizFilesListVoList) {
            if (ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVo.getFileVos()) && !basFileTypeMap.containsKey(bizFilesListVo.getBasFileTypeValue())) {
                throw new FmsServiceException("请确认上传附件的附件类型是否存在！");
            }
        }
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取全部订单的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @Override
    public ApplyInputVo findApplyInputVoByApplyNo(String applyNo, String contNo) {
        ApplyInputVo applyInputVo = new ApplyInputVo();
        findCustomerByApplyNo(applyInputVo, applyNo);
        findGuaranteeInfo(applyInputVo, applyNo);
        if(StringUtils.isTrimBlank(contNo)){
            findFinanceByApplyNo(applyInputVo, applyNo);
        }else{
            findFinanceByContNo(applyInputVo, contNo);
        }
        // 取得申请机构信息
        findPartnerInfoByApplyNo(applyInputVo, applyNo);
        //获取合同信息
        Example example = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        Contract contract = contractRepository.selectOneByExample(example);
        if(contract != null){
            applyInputVo.setVinNo(contract.getVinNo());
        }
        return applyInputVo;
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取订单的融资车辆信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-4-13 17:18:12
     */
    @Override
    public ApplyInputVo findApplyFinanceVehicleByApplyNo(String applyNo, String contNo) {
        ApplyInputVo applyInputVo = new ApplyInputVo();
        if(StringUtils.isTrimBlank(contNo)){
            findFinanceByApplyNo(applyInputVo, applyNo);
        }else{
            findFinanceByContNo(applyInputVo, contNo);
        }
        // 取得申请机构信息
        findPartnerInfoByApplyNo(applyInputVo, applyNo);
        //获取销售用户
        Apply apply =  applyService.findApplyByApplyNo(applyNo);
        SysUser sysUser = null;
        try {
            sysUser =  ResponseEntityUtils.getRestResponseData(sysUserRpc.findSysUserByUsername(apply.getApplyUser())) ;
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("获取销售顾问失败");
        }
        applyInputVo.setSysUser(sysUser);
        return applyInputVo;
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取个人客户基本的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @Override
    public ApplyInputVo findApplyCstmPersonByApplyNo(String applyNo) {
        ApplyInputVo applyInputVo = new ApplyInputVo();
        findCustomerByApplyNo(applyInputVo,applyNo);
        return applyInputVo;
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取担保人(公司)的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @Override
    public ApplyInputVo findApplyGuaranteeByApplyNo(String applyNo) {
        ApplyInputVo applyInputVo = new ApplyInputVo();
        findGuaranteeInfo(applyInputVo, applyNo);
        return applyInputVo;
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取附件信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-4-16 20:18:12
     */
    @Override
    public ApplyInputVo findBizFileByApplyNo(String applyNo) {

        Apply apply =  applyService.findApplyByApplyNo(applyNo);
        ApplyInputVo applyInputVo = new ApplyInputVo();
        if(apply.getApplyType().equals(PERSON.getType())){
            CommonBizFilesVo bizFilesVo =  bizFilesService.findBizFilesByBizCode(applyNo,PRE_APPLY_INPUT_PER.getCodeType());
            applyInputVo.setBizfilesVo(bizFilesVo);
        }else if(apply.getApplyType().equals(COMPANY.getType())){
            CommonBizFilesVo bizFilesVo =  bizFilesService.findBizFilesByBizCode(applyNo,PRE_APPLY_INPUT_COMP.getCodeType());
            applyInputVo.setBizfilesVo(bizFilesVo);
        }
        // 根据订单编号取得产品方案
        ApplyFinanceVo applyFinanceVo = applyFinanceService.findApplyFinanceVoByApplyNo(applyNo);
        applyInputVo.setApplyFinanceVo(applyFinanceVo);
        return applyInputVo;
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取客户的所有基本信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    public void findCustomerByApplyNo(ApplyInputVo applyInputVo, String applyNo) {
        //取得客户联系人信息
         List<CstmContact> cstmContactList = cstmContactService.findCstmContactsByApplyNo(applyNo);
        applyInputVo.setCstmContactList(cstmContactList);
        //取得客户基本信息
        CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(applyNo);
        applyInputVo.setCstmPerson(cstmPerson);
        //取得客户配偶此信息
        CstmPersMate cstmPersMate  = cstmPersMateService.findCstmPersMateByApplyNo(applyNo);
        applyInputVo.setCstmPersMate(cstmPersMate);
        //取得客户职业信息
        CstmPersJob cstmPersJob = cstmPersJobService.findCstmPersJobByApplyNo(applyNo);
        applyInputVo.setCstmPersJob(cstmPersJob);
        //取得客户地址信息
        CstmPersAddr cstmPersAddr = cstmPersAddrService.findCstmPersAddrByApplyNo(applyNo);
        applyInputVo.setCstmPersAddr(cstmPersAddr);
        //取得企业信息
        CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(applyNo);
        applyInputVo.setCstmCompany(cstmCompany);
        Apply apply = null;
        //变更申请时查询任务表
        if(StringUtils.equals(applyNo.substring(0,2),ApplyNoPreEnums.CHANGE_LESSEE.getType())){
            Example example = SqlUtil.newExample(ChangeLesseeTask.class);
            example.createCriteria().andEqualTo("taskNo",applyNo);
            ChangeLesseeTask changeLesseeTask = changeLesseeTaskRepository.selectOneByExample(example);
            apply = EntityUtils.getEntity(changeLesseeTask,new Apply());
        }else{
            apply =  applyService.findApplyByApplyNo(applyNo);
        }
        if(apply == null){
            throw new FmsServiceException("申请信息不存在");
        }
        //企业信息
        applyInputVo.setCompanyType1(apply.getCompanyType1());
        applyInputVo.setCompanyType2(apply.getCompanyType2());
        //是否家访
        applyInputVo.setVisitFlag(apply.getVisitFlag());
        applyInputVo.setNovisitReason(apply.getNovisitReason());
        //审批备注
        applyInputVo.setRemark(apply.getRemark());
        applyInputVo.setApply(apply);
        //获取股东信息
        List<StockAssets> stockAssetsList = stockAssetsService.findStockAssetsListByApplyNo(applyNo);
        applyInputVo.setStockAssetsList(stockAssetsList);
        //获取购车合理性信息
        RationalityPurchase rationalityPurchase =   rationalityPurchaseService.findRationalityPurchaseByApplyNo(applyNo);
        applyInputVo.setRationalityPurchase(rationalityPurchase);
        //获取家访信息
        applyInputVo.setApplyVisitVo(applyVisitService.findApplyVisitByApplyNo(applyNo));
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取担保信息和共同存款人信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    public void findGuaranteeInfo(ApplyInputVo applyInputVo, String applyNo){
        //取得客户保证人信息
        List<GuaranteePers> guaranteePersList = guaranteePersService.findGuaranteePersByApplyNo(applyNo);
        applyInputVo.setGuaranteePersList(guaranteePersList);
        //取得客户保证企业信息
        List<GuaranteeComp> guaranteeCompList = guaranteeCompService.findGuaranteeCompsByApplyNo(applyNo);
        applyInputVo.setGuaranteeCompList(guaranteeCompList);
        //取得共同存款人信息
        List<CommonBorrower> commonBorrowerList = commonBorrowerService.findCommonBorrowersByApplyNo(applyNo);
        applyInputVo.setCommonBorrowerList(commonBorrowerList);
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取订单的融资车辆信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    public void findFinanceByApplyNo(ApplyInputVo applyInputVo, String applyNo){
        // 取得融资信息
        ApplyFinanceVo applyFinanceVo = applyFinanceService.findApplyFinanceVoByApplyNo(applyNo);
        applyInputVo.setApplyFinanceVo(applyFinanceVo);
        // 取得融资车辆信息和融资费用明细
        List<ApplyVehicleVo> applyVehicleVoList = applyVehicleService.findApplyVehicleVosByApplyNo(applyNo);
        applyInputVo.setApplyVehicleVoList(applyVehicleVoList);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，合同编号获取全部订单的信息
     * @param contNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    public void findFinanceByContNo(ApplyInputVo applyInputVo, String contNo){
        // 取得合同融资信息
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);
        applyInputVo.setApplyFinanceVo(EntityUtils.getEntity(contractFinanceVo, new ApplyFinanceVo()));

        // 取得合同融资车辆信息和合同融资费用明细
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(contNo);
        ApplyVehicleVo applyVehicleVo = EntityUtils.getEntity(contractVehicleVo, new ApplyVehicleVo());
        List<ApplyFinDetailVo> applyFinDetailVoList = new ArrayList<>();
        for(int i=0; i<contractVehicleVo.getContFinDetailVoList().size(); i++){
            applyFinDetailVoList.add(EntityUtils.getEntity(contractVehicleVo.getContFinDetailVoList().get(i), new ApplyFinDetailVo()));
        }
        applyVehicleVo.setApplyFinDetailVoList(applyFinDetailVoList);

        List<ApplyVehicleVo> applyVehicleVoList = new ArrayList<>();
        applyVehicleVoList.add(applyVehicleVo);
        applyInputVo.setApplyVehicleVoList(applyVehicleVoList);
    }

    /**
     * @Title:
     * @Description:   根据订单编号，或去申请机构信息
     * @param applyInputVo 申请vo
     * @param applyNo 申请编号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/13 13:48:55
     */
    private void findPartnerInfoByApplyNo(ApplyInputVo applyInputVo, String applyNo) {
        // 取得申请机构代码
        Apply apply = applyService.findApplyByApplyNo(applyNo);
        if (apply != null) {
            BasPartnerVo basPartnerVo = null;
            try {
                Map<String, Object> tempData = ResponseEntityUtils.getRestResponseData(basPartnerRpc.findBasPartnerByPartnerCode(apply.getApplyGroup()));
                basPartnerVo = JSON.parseObject(JSON.toJSONString(tempData), BasPartnerVo.class);
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
            }
            applyInputVo.setBasPartnerVo(basPartnerVo);
        }
    }

    /**
     * @Title:
     * @Description:   保存附件
     * @param applyInputVo 申请vo
     * @param applyNum 申请编号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/11 02:48:55
     */
    private void saveBizFiles(ApplyInputVo applyInputVo,String applyNum){
        if (applyInputVo.getBizfilesVo() != null && ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getBizfilesVo().getBizFilesListVos())) {
            if(applyInputVo.getApplyType().equals(PERSON.getType())){
                bizFilesService.saveBizFiles(applyInputVo.getBizfilesVo().getBizFilesListVos(),
                        applyNum, BizCodeTypeEnums.PRE_APPLY_INPUT_PER.getCodeType());
            }else{
                bizFilesService.saveBizFiles(applyInputVo.getBizfilesVo().getBizFilesListVos(),
                        applyNum, BizCodeTypeEnums.PRE_APPLY_INPUT_COMP.getCodeType());
            }
        }
    }

    /**
     * @Title:
     * @Description: 根据订单号修改融资信息(暂存数据)
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    @Override
    @Transactional
    public void modifyApplyInputVoByApplyNo(ApplyInputVo applyInputVo) {
        // 融资信息Tab
        saveModifyApplyFinance(applyInputVo.getApplyNo(), applyInputVo.getApplyFinanceVo(), applyInputVo.getApplyVehicleVoList());
        //客户信息tab
        if(PERSON.getType().equals(applyInputVo.getApplyType())){
            //保存客户基本信息
            //saveCstmPerson(applyInputVo,applyNum);
            modifyCstmPersonInfo(applyInputVo);
        }else{
            //保存企业信息
            //saveCstmComp(applyInputVo,applyNum);
            modifyCstmCompInfo(applyInputVo);

        }
        //修改担保人信息
        modifyCommonInfo(applyInputVo);


        //更新附件
        updateBizFiles(applyInputVo,applyInputVo.getApplyNo());

       /* //工作流引擎,修改业务名称
        ActUtils.modifyServiceName(applyInputVo.getTaskId(),getCustomerName(applyInputVo));*/

        //工作流引擎,修改业务名称
        ActUtils.modifyServiceName(applyInputVo.getTaskId(),createServiceName(applyInputVo));


        //更新订单信息
        modifyApply(applyInputVo, SAVEINFO.getType(), null);
    }

    /**
     *
     * @param applyInputVo
     * @param actRuTaskVo
     */
    private void modifyApply(ApplyInputVo applyInputVo, String act, ActRuTaskVo actRuTaskVo) {
        //更新订单状态
        String applyNo = applyInputVo.getApplyNo();
        //根据订单编号取得订单信息
        Apply apply = applyService.findApplyByApplyNo(applyNo);
        if(apply == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        //订单状态
        String applyBizStatusUpd = "";
        //订单提交
        if(SUBMIT.getType().equals(act)){
            applyBizStatusUpd = actRuTaskVo.getTaskCode();

            if(StringUtils.isTrimBlank(applyBizStatusUpd)){
                throw new FmsServiceException( "订单状态取得失败");
            }
            apply.setBizStatus(applyBizStatusUpd);
            //首次提交日期为空
            if(StringUtils.isTrimBlank(apply.getApplyFirsbtDate())){
                apply.setApplyFirsbtDate(DateUtils.getNowDate());
            }
            apply.setApplySubmitDate(DateUtils.getNowDate());
//            //风控初审派单人为空则赋值为当前节点用户
//            if(StringUtils.isTrimBlank(apply.getApproveUser())){
//                apply.setApproveUser(actRuTaskVo.getNextAssignee());
//            }
        }
        //当前节点用户
        if(StringUtils.isNotTrimBlank(actRuTaskVo)){
            apply.setPresentUser(actRuTaskVo.getNextAssignee());
        }
        apply.setCompanyType1(applyInputVo.getCompanyType1());
        apply.setCompanyType2(applyInputVo.getCompanyType2());
        apply.setVisitFlag(applyInputVo.getVisitFlag());
        apply.setNovisitReason(applyInputVo.getNovisitReason());
        //审批备注
        apply.setRemark(applyInputVo.getRemark());
        applyService.modifyApply(apply);

        //订单日志保存
        if(SUBMIT.getType().equals(act)){
            saveWorkFlowLog(applyInputVo, applyBizStatusUpd);
        }
    }

    /**
     * @Title:
     * @Description: 根据订单号修改个人信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    @Transactional
  public void modifyCstmPersonInfo(ApplyInputVo applyInputVo){
      //修改个人客户基本信息
      cstmPersonService.updateCstmpersonByapplyNo(applyInputVo.getCstmPerson(),applyInputVo.getApplyNo());
      //修改客户职业信息
      cstmPersJobService.updateCstmPersJobByApplyNo(applyInputVo.getCstmPersJob(),applyInputVo.getApplyNo());
      //修改客户配偶信息
      cstmPersMateService.updateCstmPersMateByapplyNo(applyInputVo.getCstmPersMate(),applyInputVo.getApplyNo());
      //修改客户地址信息
      cstmPersAddrService.updateCstmPersAddrByApplyNo(applyInputVo.getCstmPersAddr(),applyInputVo.getApplyNo());
  }
    /**
     * @Title:
     * @Description: 根据订单号修改企业信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
   @Transactional
   public void modifyCstmCompInfo(ApplyInputVo applyInputVo){
      //企业信息
       cstmCompanyService.updateCstmCompanyByApplyNo(applyInputVo.getCstmCompany(),applyInputVo.getApplyNo());
      //批量更新股东信息
      stockAssetsService.modifyStockAssetsByApplyNo(applyInputVo.getStockAssetsList(),applyInputVo.getApplyNo());
    }
    /**
     * @Title:
     * @Description: 根据订单号修改担保信息和共同借款人
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    @Transactional
    public void modifyCommonInfo(ApplyInputVo applyInputVo){
        guaranteePersService.updateGuaranteePersByApplyNo(applyInputVo.getGuaranteePersList(),applyInputVo.getApplyNo());
        guaranteeCompService.updateGuaranteeCompsByApplyNo(applyInputVo.getGuaranteeCompList(),applyInputVo.getApplyNo());
        commonBorrowerService.updateCommonBorrowersByApplyNo(applyInputVo.getCommonBorrowerList(),applyInputVo.getApplyNo());
        //修改客户联系人信息
        cstmContactService.updateCstmContactsByApplyNo(applyInputVo.getCstmContactList(),applyInputVo.getApplyNo());
        //更新购买合理性
        rationalityPurchaseService.modifyRationalityPurchaseByApplyNo(applyInputVo.getRationalityPurchase(),applyInputVo.getApplyNo());
        //修改家访信息
        modifyApplyVisitByApplyNo(applyInputVo);
    }
    /**
     * @Title:
     * @Description: 修改家访信息共同
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    public void modifyApplyVisitByApplyNo(ApplyInputVo applyInputVo){
        Example example  = SqlUtil.newExample(ApplyVisit.class);
        example.createCriteria().andEqualTo("applyNo",applyInputVo.getApplyNo());
        ApplyVisit applyVisit = applyVisitRepository.selectOneByExample(example);
        if(VisitFlagEnums.VISIT.getType().equals(applyInputVo.getVisitFlag())){
            if(applyVisit == null){
                applyVisit = EntityUtils.getEntity(applyInputVo.getApplyVisitVo(),new ApplyVisit());
                applyVisit.setApplyVisitId(null);
                applyVisit.setApplyNo(applyInputVo.getApplyNo());
                applyVisitRepository.insertData(applyVisit);
            }else{
                ApplyVisit  applyVisit1 =  applyInputVo.getApplyVisitVo().getEntity();
                applyVisit1.setDelFlag(DeleteFlags.EXIST.getFlag());
                applyVisit1.setApplyNo(applyInputVo.getApplyNo());
                applyVisit1.setApplyVisitId(applyVisit.getApplyVisitId());
                applyVisitRepository.updateByPrimaryKeyData(applyVisit1);
                if(applyInputVo.getApplyVisitVo().getBizFilesList() != null){
                    List<BizFiles> bizFilesList =  bizFilesService.geBizFilesListByVos(applyInputVo.getApplyVisitVo().getBizFilesList()
                            , applyInputVo.getApplyNo()
                            ,BizCodeTypeEnums.APPLY_VISIT.getCodeType(),true);
                    bizFilesService.deleteBizFilesByBizCode(applyInputVo.getApplyNo(),BizCodeTypeEnums.APPLY_VISIT.getCodeType());
                    bizFilesService.saveBizFilesList(bizFilesList);
                    //bizFilesService.saveBizFiles(applyInputVo.getApplyVisitVo().getBizfilesVo().getBizFilesListVos(),applyNo,BizCodeTypeEnums.APPLY_VISIT.getCodeType());
                }
                //bizFilesService.updateBizFiles(applyInputVo.getApplyVisitVo().getBizfilesVo().getBizFilesListVos(),applyInputVo.getApplyNo(),BizCodeTypeEnums.APPLY_VISIT.getCodeType());
            }
        }else
           // if(VisitFlagEnums.NOT_VISIT.getType().equals(applyInputVo.getVisitFlag()))
            {
            applyVisitRepository.deleteExampleData(example,new ApplyVisit());
            bizFilesService.deleteBizFilesByBizCode(applyInputVo.getApplyNo(),BizCodeTypeEnums.APPLY_VISIT.getCodeType());
        }
//        else if(VisitFlagEnums.CONFIRM_NOT_VISIT.getType().equals(applyInputVo.getVisitFlag())){
//            if(applyVisit == null){
//                applyVisit = EntityUtils.getEntity(applyInputVo.getApplyVisitVo(),new ApplyVisit());
//                applyVisit.setApplyNo(applyInputVo.getApplyNo());
//                applyVisitRepository.insertData(applyVisit);
//            }else{
//                ApplyVisit applyVisit1 = new ApplyVisit();
//                applyVisit1.setApplyNo(applyInputVo.getApplyVisitVo().getApplyNo());
//                applyVisit1.setApplyVisitId(applyInputVo.getApplyVisitVo().getApplyVisitId());
//                applyVisit1.setReason(applyInputVo.getApplyVisitVo().getReason());
//                applyVisit1.setDelFlag(DeleteFlags.EXIST.getFlag());
//                applyVisitRepository.updateByPrimaryKeyData(applyVisit1);
//            }
//        }
    }
    /**
     * @description: 更新业务附件
     * @param applyInputVo
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    public void updateBizFiles(ApplyInputVo applyInputVo,String applyNum){
        if(applyInputVo.getApplyType().equals(PERSON.getType())){
            bizFilesService.updateBizFiles(applyInputVo.getBizfilesVo().getBizFilesListVos(),
                    applyNum,BizCodeTypeEnums.PRE_APPLY_INPUT_PER.getCodeType());
        }else if(applyInputVo.getApplyType().equals(COMPANY.getType())){
            bizFilesService.updateBizFiles(applyInputVo.getBizfilesVo().getBizFilesListVos(),
                    applyNum,BizCodeTypeEnums.PRE_APPLY_INPUT_COMP.getCodeType());
        }
    }

    /**
     * @Title:
     * @Description: 计算融资方案信息的每月租金.
     * @param applyFinanceVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-23 10:18:12
     */
    private void setApplyFinanceRent(ApplyFinanceVo applyFinanceVo) {
        //期数
        int period = Integer.valueOf(applyFinanceVo.getFinPeriodType())/Integer.valueOf(applyFinanceVo.getRepayRate());
        //每期租金
        String [][] rent = Financials.findmyrepaymentplan(applyFinanceVo.getFinTotal(),
                applyFinanceVo.getFinalAmount(),
                applyFinanceVo.getFinPeriodType(),
                applyFinanceVo.getRepayRate(), BigDecimalUtils.dividePercent6(applyFinanceVo.getIntrstRate()),
                applyFinanceVo.getRepayMode(), "1", applyFinanceVo.getRentPayMode());
        BigDecimal rentActual = new BigDecimal(rent[0][0]);
        // 手续费
        if(INSTALMENT_CHARGE.getType().equals(applyFinanceVo.getChargePayMode())){
            BigDecimal charge = BigDecimalUtils.divide(applyFinanceVo.getCharge(), new BigDecimal(period), 0);
            rentActual = rentActual.add(charge);
        }
        // 保证金返还方式
        if(INSTALMENT_DEPOSIT.getType().equals(applyFinanceVo.getDepositRtnMode())){
            BigDecimal deposit = BigDecimalUtils.divide(applyFinanceVo.getDeposit(), new BigDecimal(period), 0);
            rentActual = rentActual.subtract(deposit);
        }
        applyFinanceVo.setRent(rentActual.setScale(BigDecimal.ROUND_CEILING));
    }

    /**
     * @Title:
     * @Description: 获取客户名称
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19  11:24
     */
    private String getCustomerName(ApplyInputVo applyInputVo){
        String customerName = null;
        if(PERSON.getType().equals(applyInputVo.getApplyType())){
            //客户名称
            if(applyInputVo != null && applyInputVo.getCstmPerson() != null)
                customerName = applyInputVo.getCstmPerson().getName();
        }else if(COMPANY.getType().equals(applyInputVo.getApplyType())){
            //企业名称
            if(applyInputVo != null && applyInputVo.getCstmCompany() != null)
                customerName = applyInputVo.getCstmCompany().getName();
        }else{
            throw new FmsServiceException(applyInputVo.getApplyType() + "申请类型不存在");
        }
        return customerName;
    }

    /**
     * @Title:
     * @Description: 生成任务信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    private String createServiceName(ApplyInputVo applyInputVo){
        //承租人
        String customerName = getCustomerName(applyInputVo);
        //车型
        String vehicleNameStr = "";
        if(applyInputVo != null && ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getApplyVehicleVoList())){
            for (ApplyVehicleVo applyVehicleVo : applyInputVo.getApplyVehicleVoList()){
                if(applyVehicleVo!=null && StringUtils.isNotTrimBlank(applyVehicleVo.getVehicleName())){
                    vehicleNameStr = vehicleNameStr + applyVehicleVo.getVehicleName() + "、";
                }
            }
            //把最后一个"、"截掉
            if(vehicleNameStr.length() > 0){
                vehicleNameStr = vehicleNameStr.substring(0,vehicleNameStr.length()-1);
            }
        }
        //担保人
        String guaranteePerStr = "";
        if(applyInputVo != null && ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteePersList())){
            for(GuaranteePers guaranteePers : applyInputVo.getGuaranteePersList()){
                if(guaranteePers!=null && StringUtils.isNotTrimBlank(guaranteePers.getName())){
                    guaranteePerStr = guaranteePerStr + guaranteePers.getName() + "、";
                }
            }
            //把最后一个"、"截掉
            if(guaranteePerStr.length() > 0){
                guaranteePerStr = guaranteePerStr.substring(0,guaranteePerStr.length()-1);
            }
        }
        //担保企业
        String guaranteeComStr = "";
        if(applyInputVo != null && ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteeCompList())){
            for(GuaranteeComp guaranteeComp : applyInputVo.getGuaranteeCompList()){
                if(guaranteeComp!=null && StringUtils.isNotTrimBlank(guaranteeComp.getName())){
                    guaranteeComStr = guaranteeComStr + guaranteeComp.getName() + "、";
                }
            }
            //把最后一个"、"截掉
            if(guaranteeComStr.length() > 0){
                guaranteeComStr = guaranteeComStr.substring(0,guaranteeComStr.length()-1);
            }
        }

        //生成任务信息
        StringBuffer serviceNameStr = new StringBuffer();
        if(StringUtils.isNotTrimBlank(customerName)){
            serviceNameStr.append("承租人:");
            serviceNameStr.append(customerName);
        }
        if(StringUtils.isNotTrimBlank(vehicleNameStr)){
            serviceNameStr.append(",");
            serviceNameStr.append("车型:");
            serviceNameStr.append(vehicleNameStr);
        }
        if(StringUtils.isNotTrimBlank(guaranteePerStr)){
            serviceNameStr.append(",");
            serviceNameStr.append("担保人(企业):");
            serviceNameStr.append(guaranteePerStr);
            if(StringUtils.isNotTrimBlank(guaranteeComStr)){
                serviceNameStr.append("、");
                serviceNameStr.append(guaranteeComStr);
            }
        }else {
            if(StringUtils.isNotTrimBlank(guaranteeComStr)){
                serviceNameStr.append(",");
                serviceNameStr.append("担保人(企业):");
                serviceNameStr.append(guaranteeComStr);
            }
        }
        return serviceNameStr.toString();
    }

    /**
     * @Title:
     * @Description: 获取申请详细信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author qiaomengnan
     * @date 2018/5/15  15:04
     */
    public ApplyInputVo findApplyDetailInfo(String applyNo) {
        ApplyInputVo applyInputVo = new ApplyInputVo();
        //取得客户联系人信息
        List<CstmContact> cstmContactList = cstmContactService.findCstmContactsByApplyNo(applyNo);
        applyInputVo.setCstmContactList(cstmContactList);
        //取得客户基本信息
        CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(applyNo);
        applyInputVo.setCstmPerson(cstmPerson);
        //取得客户配偶此信息
        CstmPersMate cstmPersMate  = cstmPersMateService.findCstmPersMateByApplyNo(applyNo);
        applyInputVo.setCstmPersMate(cstmPersMate);
        //取得客户职业信息
        CstmPersJob cstmPersJob = cstmPersJobService.findCstmPersJobByApplyNo(applyNo);
        applyInputVo.setCstmPersJob(cstmPersJob);
        //取得客户地址信息
        CstmPersAddr cstmPersAddr = cstmPersAddrService.findCstmPersAddrByApplyNo(applyNo);
        applyInputVo.setCstmPersAddr(cstmPersAddr);
        //取得企业信息
        CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(applyNo);
        applyInputVo.setCstmCompany(cstmCompany);
        Apply apply =  applyService.findApplyByApplyNo(applyNo);
        applyInputVo.setCompanyType1(apply.getCompanyType1());
        applyInputVo.setCompanyType2(apply.getCompanyType2());
        applyInputVo.setVisitFlag(apply.getVisitFlag());
        applyInputVo.setNovisitReason(apply.getNovisitReason());
        //审批备注
        applyInputVo.setRemark(apply.getRemark());
        // 根据订单编号取得产品方案
        ApplyFinanceVo applyFinanceVo = applyFinanceService.findApplyFinanceVoByApplyNo(applyNo);
        applyInputVo.setApplyFinanceVo(applyFinanceVo);
        // 取得融资车辆信息和融资费用明细
        List<ApplyVehicleVo> applyVehicleVoList = applyVehicleService.findApplyVehicleVosByApplyNo(applyNo);
        applyInputVo.setApplyVehicleVoList(applyVehicleVoList);
        return applyInputVo;
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取风控审批用申请录入信息
     * @param applyNo 订单编号
     * @return ApplyRiskVo
     * @throws
     * @author liujinge
     * @date 2018-6-4 20:18:12
     */
    @Override
    public ApplyRiskVo findApplyInputRiskByApplyNo(String applyNo,String flag) {
        ApplyRiskVo applyRiskVo = new ApplyRiskVo();


        //申请信息
        Apply apply = null;
        if(StringUtils.isNotExits(flag)){
            apply  = applyService.findApplyByApplyNo(applyNo);
            //风险融资额
            applyRiskVo.setRiskAmount(applyService.riskAmountWithApply(applyNo));
            //取得融资信息
            ApplyFinanceVo applyFinanceVo = applyFinanceService.findApplyFinanceVoByApplyNo(applyNo);
            applyRiskVo.setApplyFinanceVo(applyFinanceVo);
        }else{
            Example example = SqlUtil.newExample(ChangeLesseeTask.class);
            example.createCriteria().andEqualTo("taskNo",applyNo);
            ChangeLesseeTask changeLesseeTask = changeLesseeTaskRepository.selectOneByExample(example);
            apply = EntityUtils.getEntity(changeLesseeTask,new Apply());
            apply.setApplyNo(applyNo);
            //取得applyFinance
            ContractFinanceVo contractFinanceVo =  contractFinanceRepository.selectContractFinanceVoByContNo(changeLesseeTask.getContNo());
            ApplyFinanceVo applyFinanceVo = EntityUtils.getEntity(contractFinanceVo,new ApplyFinanceVo());
            applyRiskVo.setApplyFinanceVo(applyFinanceVo);
        }
        applyRiskVo.setApply(apply);

        //申请类型为企业
        if(ApplyTypeEnums.COMPANY.getType().equals(apply.getApplyType())){
            //企业信息
            applyRiskVo.setCstmCompany(cstmCompanyService.findCstmCompanyByApplyNo(applyNo));
        }else{
            //个人信息
            applyRiskVo.setCstmPerson(cstmPersonService.findCstmPersonByApplyNo(applyNo));
            //个人地址
            applyRiskVo.setCstmPersAddr(cstmPersAddrService.findCstmPersAddrByApplyNo(applyNo));

            //个人职业
            applyRiskVo.setCstmPersJob(cstmPersJobService.findCstmPersJobByApplyNo(applyNo));
        }
        //担保企业信息
        applyRiskVo.setGuaranteePersList(guaranteePersService.findGuaranteePersByApplyNo(applyNo));
        //担保企业信息
        applyRiskVo.setGuaranteeCompList(guaranteeCompService.findGuaranteeCompsByApplyNo(applyNo));
        //共同借款人信息
        applyRiskVo.setCommonBorrowerList(commonBorrowerService.findCommonBorrowersByApplyNo(applyNo));

        //购车合理性
        applyRiskVo.setRationalityPurchase(rationalityPurchaseService.findRationalityPurchaseByApplyNo(applyNo));

        return applyRiskVo;
    }

    /**
     * @Title:
     * @Description: check家访信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-2 10:18:12
     */
    public void checkVisitApply(ApplyInputVo applyInputVo, BigDecimal riskAmount){
        if(QuotationTypeEnums.LEASE_BACK.getType().equals(applyInputVo.getApplyFinanceVo().getLicenseAttr())){
            if(VisitFlagEnums.NOT_VISIT.getType().equals(applyInputVo.getVisitFlag())){
                throw new FmsServiceException("回租赁需要家访");
            }
        }else{
            BigDecimal minRiskAmount;
            BigDecimal maxRiskAmount;
            try {
                minRiskAmount = new BigDecimal(ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.MIN_RISK_AMOUNT)));
                maxRiskAmount = new BigDecimal(ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.MAX_RISK_AMOUNT)));
            } catch (FmsRpcException e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new FmsServiceException("取得系统常量失败");
            }
            if(riskAmount.compareTo(minRiskAmount) <= 0){
                return;
            }else if(riskAmount.compareTo(minRiskAmount) > 0 && (riskAmount.compareTo(maxRiskAmount) <= 0)){
                //个人的场合
                if(ApplyTypeEnums.PERSON.getType().equals(applyInputVo.getApplyType())){
                    if(YesNoFlagEnums.NO.getType().equals(applyInputVo.getCstmPersAddr().getIsHaveProperty())
                            && VisitFlagEnums.NOT_VISIT.getType().equals(applyInputVo.getVisitFlag())){
                        throw new FmsServiceException("没有房产需要家访");
                    }
                }else{
                    if(VisitFlagEnums.NOT_VISIT.getType().equals(applyInputVo.getVisitFlag())&& !CompAddrTypeEnums.OWN.getType().equals(applyInputVo.getCstmCompany().getCompAddrType())){
                        throw new FmsServiceException("没有房产需要家访");
                    }
                }

            }else{
                if(VisitFlagEnums.NOT_VISIT.getType().equals(applyInputVo.getVisitFlag())){
                    throw new FmsServiceException("风险融资额大于50万需要家访");
                }
            }
        }
    }
    /**
     * @Title:
     * @Description: 家访信息保存共同
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-2 10:18:12
     */
    public void saveVisitApply(ApplyInputVo applyInputVo,String applyNo){
        if(VisitFlagEnums.VISIT.getType().equals(applyInputVo.getVisitFlag())){
            ApplyVisitVo applyVisitVo = applyInputVo.getApplyVisitVo();
            if(applyVisitVo != null){
                applyVisitVo.setApplyNo(applyNo);
                applyVisitVo.setApplyVisitId(null);
                applyVisitRepository.insertData(applyVisitVo.getEntity());
                if(applyVisitVo.getBizFilesList() != null){
                    List<BizFiles> bizFilesList =  bizFilesService.geBizFilesListByVos(applyVisitVo.getBizFilesList()
                            , applyNo
                            ,BizCodeTypeEnums.APPLY_VISIT.getCodeType(),true);
                    bizFilesService.deleteBizFilesByBizCode(applyNo,BizCodeTypeEnums.APPLY_VISIT.getCodeType());
                    bizFilesService.saveBizFilesList(bizFilesList);
                    //bizFilesService.saveBizFiles(applyInputVo.getApplyVisitVo().getBizfilesVo().getBizFilesListVos(),applyNo,BizCodeTypeEnums.APPLY_VISIT.getCodeType());
                }
            }else{
                ApplyVisit applyVisit = new ApplyVisit();
                applyVisit.setApplyNo(applyNo);
                applyVisitRepository.insertData(applyVisit);
            }
        }
//        else if(VisitFlagEnums.CONFIRM_NOT_VISIT.getType().equals(applyInputVo.getVisitFlag())){
//            ApplyVisitVo applyVisitVo = applyInputVo.getApplyVisitVo();
//            if(applyVisitVo != null){
//                applyVisitVo.setApplyNo(applyNo);
//                applyVisitRepository.insertData(applyVisitVo.getEntity());
//            }
//        }
    }


    /**
     * @Title:
     * @Description: 报价单计算
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-2 10:18:12
     */
    @Override
    public QuotationDeviceVo saveQuotationDeviceInfo(ApplyInputVo applyInputVo) {
        //入力check
        checkForQuotaion(applyInputVo);
        QuotationDeviceVo quotationDeviceVo =  quotationDeviceService.convertToQuotation(applyInputVo);

        //订单提出账号
        quotationDeviceVo.setApplyUserContr(applyInputVo.getUser());
        //订单提出机构代码
        quotationDeviceVo.setApplyGroupContr(applyInputVo.getUserGroup());

        quotationDeviceVo =quotationDeviceService.saveQuotationDeviceInfo(quotationDeviceVo, "1");
        return quotationDeviceVo;
    }



    /**
     * @Title:
     * @Description: 报价单计算
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-2 10:18:12
     */
    @Override
    public QuotationDeviceVo printQuotationDeviceInfo(ApplyInputVo applyInputVo,SysUser sysUser) {
        //入力check
        checkForQuotaion(applyInputVo);
        QuotationDeviceVo quotationDeviceVo =  quotationDeviceService.convertToQuotation(applyInputVo);
        quotationDeviceVo =quotationDeviceService.printQuotationDevice(quotationDeviceVo, "1",sysUser);

        return quotationDeviceVo;
    }

    private void checkForQuotaion(ApplyInputVo applyInputVo) {
        //判断项目是否入力

        checkApplyFinanceData(applyInputVo.getApplyFinanceVo(), applyInputVo.getApplyVehicleVoList(), "1");
    }
}
