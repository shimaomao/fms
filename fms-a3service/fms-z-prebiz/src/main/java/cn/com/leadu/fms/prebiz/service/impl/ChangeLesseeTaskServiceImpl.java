package cn.com.leadu.fms.prebiz.service.impl;/**
 * Created by ningyangyang on 2018/9/11.
 */

import cn.com.leadu.fms.business.common.util.activiti.ActChangeLesseeUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.business.service.*;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BankOrganizationTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.ServiceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.ChangeLesseeStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.CompanyType;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.baseinfo.repository.BasVehicleRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.ChangeLesseeTaskRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.data.prebiz.repository.RationalityPurchaseRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleContractTemplateVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedAlreadyPayInfoVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.rpc.baseinfo.BasBankInfoRpc;
import cn.com.leadu.fms.prebiz.service.*;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanySaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonSaveVo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SAVEINFO;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;
import static cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums.PRE_APPLY_INPUT_COMP;
import static cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums.PRE_APPLY_INPUT_PER;
import static cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums.COMPANY;
import static cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums.PERSON;

/**
 * @Title: fms
 * @Description: 变更承租人任务
 * @author: ningyangyang
 * @date 2018/9/11 9:41
 */
@Log4j
@Service
public class ChangeLesseeTaskServiceImpl implements ChangeLesseeTaskService{
    /**
     * @Fields  : 任务号获取service
     */
    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Fields  : 个人地址信息service
     */
    @Autowired
    private CstmPersAddrService cstmPersAddrService;
    /**
     * @Fields  : 个人职业信息service
     */
    @Autowired
    private CstmPersJobService cstmPersJobService;
    /**
     * @Fields  : 个人配偶信息service
     */
    @Autowired
    private CstmPersMateService cstmPersMateService;
    /**
     * @Fields  : 个人基本信息service
     */
    @Autowired
    private CstmPersonService cstmPersonService;
    /**
     * @Fields  : 企业基本信息service
     */
    @Autowired
    private CstmCompanyService cstmCompanyService;
    /**
     * @Fields  : 企业股东信息service
     */
    @Autowired
    private StockAssetsService stockAssetsService;
    /**
     * @Fields  : 购买合理性repository
     */
    @Autowired
    private RationalityPurchaseRepository rationalityPurchaseRepository;
    /**
     * @Fields  : 联系人信息service
     */
    @Autowired
    private CstmContactService cstmContactService;
    /**
     * @Fields  : 担保人service
     */
    @Autowired
    private GuaranteePersService guaranteePersService;
    /**
     * @Fields  : 担保人service
     */
    @Autowired
    private GuaranteeCompService guaranteeCompService;
    /**
     * @Fields  : 共同借款人service
     */
    @Autowired
    private CommonBorrowerService commonBorrowerService;
    /**
     * @Fields  : 附件信息service
     */
    @Autowired
    private BizFilesService bizFilesService;
    /**
     * @Fields  : 申请信息service
     */
    @Autowired
    private ApplyService applyService;
    /**
     * @Fields  : 日志信息service
     */
    @Autowired
    private WorkflowLogService workflowLogService;
    /**
     * @Fields  : 购车合理性service
     */
    @Autowired
    private RationalityPurchaseService rationalityPurchaseService;
    /**
     * @Fields  : 承租人变更repository
     */
    @Autowired
    private ChangeLesseeTaskRepository changeLesseeTaskRepository;
    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private  ContractRepository contractRepository;
    /**
     * @Fields  : 规则service
     */
    @Autowired
    private CommonRuleService commonRuleService;
    /**
     * @Fields  : 附件类型Rpc
     */
    @Autowired
    private BasFileTypeRpc basFileTypeRpc;
    /**
     * @Fields  :pdfService
     */
    @Autowired
    private CommonPdfService commonPdfService;
    /**
     * @Fields  :合同信息Service
     */
    @Autowired
    private ContractService contractService;
    /**
     * @Fields  :合同融资信息Service
     */
    @Autowired
    private ContractFinanceService contractFinanceService;
    /**
     * @Fields  :合同车辆融资信息Service
     */
    @Autowired
    private ContractVehicleService contractVehicleService;
    /**
     * @Fields  :系统常量Service
     */
    @Autowired
    private CommonConstantService commonConstantService;
    /**
     * @Fields  : 银行信息Rpc
     */
    @Autowired
    private BasBankInfoRpc basBankInfoRpc;
    /**
     * @Fields  : 财务收款Service
     */
    @Autowired
    private ContReceiptPayService contReceiptPayService;
    /**
     * @Fields  : 还款计划已还信息Service
     */
    @Autowired
    private CommonGetRepayInfoService commonGetRepayInfoService;
    /**
     * @Fields  : 车辆信息Repository
     */
    @Autowired
    private BasVehicleRepository basVehicleRepository;
    /**
     * @Fields  :还款计划Repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;
    /**
     * @Title:
     * @Description:  暂存申请录入信息
     * @param applyInputVo
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Transactional
    public ApplyInputVo saveApplyInputVo(ApplyInputVo applyInputVo,SysUser sysUser){
        //如果taskNo不存在,插入数据
        if(StringUtils.isTrimBlank(applyInputVo.getApplyNo())){
            ChangeLesseeTask changeTask =  findChangeLesseeTaskByContNo(applyInputVo.getContNo());
            if(changeTask != null){
                throw new FmsServiceException("该条合同有正在进行中的变更承租人任务");
            }
            // 取得申请编号
            String taskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.CHANGE_LESSEE_TASK_NUM_TYPE.getType());
            //申请信息
            saveApply(applyInputVo,taskNo,sysUser);
            //设置任务号
            applyInputVo.setApplyNo(taskNo);
            //客户信息tab
            if(PERSON.getType().equals(applyInputVo.getApplyType())){
                //保存个人客户基本信息
                saveCstmPerson(applyInputVo,taskNo);
            }else{
                //保存企业客户基本信息
                saveCstmComp(applyInputVo,taskNo);
            }
            // 个人和企业共通的关系人信息保存
            saveCommonInfo(applyInputVo, taskNo);
            //更新附件
            updateBizFiles(applyInputVo,applyInputVo.getApplyNo());
            //启动工作流引擎
            ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.startChangeLesseeTask(taskNo, applyInputVo.getApplyType(),modifyServiceName(applyInputVo));
            //更新任务表
            updateChangeLesseeTask(actRuTaskVo,applyInputVo);
           // ApplyInputVo applyInput = new ApplyInputVo();
            applyInputVo.setApplyNo(taskNo);
            applyInputVo.setTaskId(actRuTaskVo.getId());
            applyInputVo.setApplyType(applyInputVo.getApplyType());
        }else {
            //否则更新数据
            if(PERSON.getType().equals(applyInputVo.getApplyType())){
                //修改客户基本信息
                modifyCstmPersonInfo(applyInputVo);
            }else{
                //修改企业信息
                modifyCstmCompInfo(applyInputVo);
            }
            //修改共同信息
            modifyCommonInfo(applyInputVo);
            //更新订单信息
            modifyApply(applyInputVo);
            //更新附件
            updateBizFiles(applyInputVo,applyInputVo.getApplyNo());
            //修改任务信息
            ActChangeLesseeUtils.modifyServiceName(applyInputVo.getTaskId(),modifyServiceName(applyInputVo));
        }
        return applyInputVo;
    }

    /**
     * @Title:
     * @Description:  提交申请录入信息
     * @param applyInputVo
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Transactional
   public void submitApplyInputVo(ApplyInputVo applyInputVo, SysUser sysUser){
        //工作流引擎
        ActRuTaskVo actRuTaskVo = null;
        //没有任务号
        if(StringUtils.isTrimBlank(applyInputVo.getApplyNo())){
            ChangeLesseeTask changeTask =  findChangeLesseeTaskByContNo(applyInputVo.getContNo());
            if(changeTask != null){
                throw new FmsServiceException("该条合同有正在进行中的变更承租人任务");
            }
            if(StringUtils.isNotTrimBlank(applyInputVo.getTaskId()))
                throw new FmsServiceException("任务已经存在，请不要重复启动");
            // 取得任务号
            String taskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.CHANGE_LESSEE_TASK_NUM_TYPE.getType());
            //申请信息
            saveApply(applyInputVo,taskNo,sysUser);
            //设置任务号
            applyInputVo.setApplyNo(taskNo);
            //客户信息tab
            if(PERSON.getType().equals(applyInputVo.getApplyType())){
                //保存个人客户基本信息
                saveCstmPerson(applyInputVo,taskNo);
            }else{
                //保存企业客户基本信息
                saveCstmComp(applyInputVo,taskNo);
            }
            // 个人和企业共通的关系人信息保存
            saveCommonInfo(applyInputVo, taskNo);
             actRuTaskVo = ActChangeLesseeUtils.startAndSubChangeLesseeTask(taskNo, applyInputVo.getApplyType(),modifyServiceName(applyInputVo));  //开始并提交

        }else{
            //有任务号
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
            //更新订单信息
            modifyApply(applyInputVo);
            //修改任务信息
            ActChangeLesseeUtils.modifyServiceName(applyInputVo.getTaskId(),modifyServiceName(applyInputVo));
            //工作流引擎
            actRuTaskVo = ActChangeLesseeUtils.approvalAgree(applyInputVo.getTaskId());  //提交进入下一节点

        }
        //更新附件
        updateBizFiles(applyInputVo,applyInputVo.getApplyNo());
        //订单日志保存
        saveWorkFlowLog(actRuTaskVo,applyInputVo, SUBMIT.getType(),sysUser);
        //更新任务表
        updateChangeLesseeTask(actRuTaskVo,applyInputVo);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取承租人变更
     * @param contNo
     * @return ChangeLesseeTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-17 15:14:54
     */
    private ChangeLesseeTask findChangeLesseeTaskByContNo(String contNo){
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("contNo",contNo).andNotEqualTo("taskStatus", ChangeLesseeStatusEnums.COMPLETE.getType()).andNotEqualTo("taskStatus",ChangeLesseeStatusEnums.REFUSE.getType()).andNotEqualTo("taskStatus",ChangeLesseeStatusEnums.CANCEL.getType());
        return changeLesseeTaskRepository.selectOneByExample(example);
    }

    /**
     *  保存个人申请所有信息
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
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getCstmContactList()))
            cstmContactService.saveCstmContact(applyInputVo.getCstmContactList(),applyNum);
        //保存担保信息
        saveGuaranteeList(applyInputVo,applyNum);
        //保存共同借款人
        saveCommonBrorrowerList(applyInputVo,applyNum);
    }

    /**
     * @description: 保存业务附件
     * @param applyInputVo
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    public void updateBizFiles(ApplyInputVo applyInputVo,String applyNum){
        if(StringUtils.equals(applyInputVo.getApplyType(),PERSON.getType())){
            bizFilesService.modifyBizFilesList(applyInputVo.getBizFilesList(),
                    applyNum, BizCodeTypeEnums.PRE_APPLY_INPUT_PER.getCodeType());
        }else if(StringUtils.equals(applyInputVo.getApplyType(),COMPANY.getType())){
            bizFilesService.modifyBizFilesList(applyInputVo.getBizFilesList(),
                    applyNum,BizCodeTypeEnums.PRE_APPLY_INPUT_COMP.getCodeType());
        }
    }
    /**
     * @description: 保存申请信息
     * @param applyInputVo
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    private void saveApply(ApplyInputVo applyInputVo, String taskNo,SysUser sysUser) {
        ChangeLesseeTask changeLesseeTask = new ChangeLesseeTask();
        //任务号
        changeLesseeTask.setTaskNo(taskNo);
        //申请类型
        changeLesseeTask.setApplyType(applyInputVo.getApplyType());
        //企业信息1
        changeLesseeTask.setCompanyType1(applyInputVo.getCompanyType1());
        //企业信息2
        changeLesseeTask.setCompanyType2(applyInputVo.getCompanyType2());
        //如果是个人，设置默认值
        if(ApplyTypeEnums.PERSON.getType().equals(applyInputVo.getApplyType())){
            changeLesseeTask.setCompanyType1(CompanyType.person.getType());
            changeLesseeTask.setCompanyType2(CompanyType.person.getType());
        }
        //审批备注
        changeLesseeTask.setRemark(applyInputVo.getRemark());
        //订单提出账号
        changeLesseeTask.setSubmitUser(sysUser.getUser());
        //订单创建日期
        changeLesseeTask.setSubmitDate(DateUtils.getNowDate());
        //合同号
        changeLesseeTask.setContNo(applyInputVo.getContNo());
        //变更原因说明
        changeLesseeTask.setChangeReason(applyInputVo.getChangeReason());
        changeLesseeTaskRepository.insertData(changeLesseeTask);
    }
    /**
     * 保存购车合理性信息
     * @param applyInputVo
     */
    @Transactional
    public void saveRationalityPur(ApplyInputVo applyInputVo,String taskNo){
        if(applyInputVo.getRationalityPurchase()!=null){
            RationalityPurchase rationalityPurchase = applyInputVo.getRationalityPurchase();
            rationalityPurchase.setApplyNo(taskNo);
            rationalityPurchaseRepository.insertData(rationalityPurchase);
        }else{
            RationalityPurchase rationalityPurchase = new RationalityPurchase();
            rationalityPurchase.setApplyNo(taskNo);
            rationalityPurchaseRepository.insertData(rationalityPurchase);
        }
    }
    /**
     * 批量保存担保信息
     * @param applyInputVo
     */
    public void saveGuaranteeList(ApplyInputVo applyInputVo,String taskNo){
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteePersList()))
            guaranteePersService.saveGuaranteePresList(applyInputVo.getGuaranteePersList(),taskNo);
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteeCompList()))
            guaranteeCompService.saveGuaranteeCompList(applyInputVo.getGuaranteeCompList(),taskNo);
    }
    /**
     * 批量保存共同借款人信息
     * @param applyInputVo
     */
    public void saveCommonBrorrowerList(ApplyInputVo applyInputVo,String taskNo){
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getCommonBorrowerList()))
            commonBorrowerService.saveCommonBorrowerList(applyInputVo.getCommonBorrowerList(),taskNo);
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
    }

    /**
     *  修改申请信息
     * @param applyInputVo
     * @param applyInputVo
     */
    private void modifyApply(ApplyInputVo applyInputVo) {
        //更新订单状态
        //String applyNo = applyInputVo.getApplyNo();
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("taskNo",applyInputVo.getApplyNo());
        ChangeLesseeTask changeLesseeTask = changeLesseeTaskRepository.selectOneByExample(example);
        if(changeLesseeTask == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        //企业类型
        changeLesseeTask.setCompanyType1(applyInputVo.getCompanyType1());
        changeLesseeTask.setCompanyType2(applyInputVo.getCompanyType2());
        //如果是个人，设置默认值
        if(ApplyTypeEnums.PERSON.getType().equals(applyInputVo.getApplyType())){
            changeLesseeTask.setCompanyType1(CompanyType.person.getType());
            changeLesseeTask.setCompanyType2(CompanyType.person.getType());
        }
        //审批备注
        changeLesseeTask.setRemark(applyInputVo.getRemark());
        //变更原因说明
        changeLesseeTask.setChangeReason(applyInputVo.getChangeReason());
        changeLesseeTaskRepository.updateByExampleData(changeLesseeTask,example);


    }

    /**
     * 保存日志信息
     * @param applyInputVo
     */
    private void saveWorkFlowLog(ActRuTaskVo actRuTaskVo,ApplyInputVo applyInputVo,String actType,SysUser sysUser) {
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setActType(actType);
        workflowLog.setWfLogType(BizTypeEnums.CHANGE_LESSEE.getType());
        workflowLog.setWfLogNo(applyInputVo.getApplyNo());
        workflowLog.setRemark1(applyInputVo.getRemark());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
        //updateChangeLesseeTask(actRuTaskVo, applyInputVo);
    }

    /**
     * 更新任务表
     * @param applyInputVo
     */
    private void updateChangeLesseeTask(ActRuTaskVo actRuTaskVo, ApplyInputVo applyInputVo) {
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("taskNo",applyInputVo.getApplyNo());
        ChangeLesseeTask changeLesseeTask = changeLesseeTaskRepository.selectOneByExample(example);
        if(changeLesseeTask == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        changeLesseeTask.setTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        changeLesseeTask.setPresentUser(actRuTaskVo.getNextAssignee()); //下一节点审批人
        changeLesseeTaskRepository.updateByExampleData(changeLesseeTask,example);  //更新信息
    }


    /**
     * @Title:
     * @Description: 根据任务编号，获取全部订单的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @Override
    public ApplyInputVo findApplyInputVoByApplyNo(String applyNo) {
        ApplyInputVo applyInputVo = new ApplyInputVo();
        this.findCustomerByApplyNo(applyInputVo, applyNo);
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
        //获取变更任务信息
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("taskNo",applyNo);
        ChangeLesseeTask changeLesseeTask = changeLesseeTaskRepository.selectOneByExample(example);

        //根据contNo获取applyNo
        Example example1 = SqlUtil.newExample(Contract.class);
        example1.createCriteria().andEqualTo("contNo",changeLesseeTask.getContNo());
        ContractVo contract =  contractRepository.selectContractVoByContractNo(changeLesseeTask.getContNo());
        //车架号
        applyInputVo.setVinNo(contract.getVinNo());
        //出租人
        applyInputVo.setGroupName(contract.getGroupName());
        //合同号
        applyInputVo.setContNo(contract.getContNo());

//       //取得客户基本信息
        CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(contract.getApplyNo());
        applyInputVo.setCstmPerson(cstmPerson);
//        //取得企业信息
        CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(contract.getApplyNo());
       applyInputVo.setCstmCompany(cstmCompany);
         Apply apply =  applyService.findApplyByApplyNo(contract.getApplyNo());
        ChangeLesseeTaskVo changeLesseeTaskVo  = EntityUtils.getEntity(changeLesseeTask,new ChangeLesseeTaskVo());
        changeLesseeTaskVo.setApplyNo(contract.getApplyNo());
        applyInputVo.setChangeLesseeTask(changeLesseeTaskVo);
        applyInputVo.setApply(apply);
        //获取附件信息
        if(changeLesseeTask.getApplyType().equals(PERSON.getType())){
            applyInputVo.setBizFilesList(bizFilesService.findBizFilesList(applyNo,PRE_APPLY_INPUT_PER.getCodeType()));
        }else if(changeLesseeTask.getApplyType().equals(COMPANY.getType())){
            applyInputVo.setBizFilesList(bizFilesService.findBizFilesList(applyNo,PRE_APPLY_INPUT_COMP.getCodeType()));
        }
        //取得合同文件需要设值的项目
        Map<String,String> contractPdfVarsMap = getVariablesMap(changeLesseeTaskVo);

        //取得合同信息
        //根据contNo获取applyNo
//        Example example1 = SqlUtil.newExample(Contract.class);
//        example1.createCriteria().andEqualTo("contNo",changeLesseeTaskVo.getContNo());
//        Contract contract =  contractRepository.selectOneByExample(example1);

        //规则引擎取得合同模板
        RuleContractTemplateVo ruleTemplateVo = new RuleContractTemplateVo();
        ruleTemplateVo.setLicenseAttr(contractPdfVarsMap.get("licenseAttr"));
        ruleTemplateVo.setWithinGroup(contractPdfVarsMap.get("withinGroup"));
        ruleTemplateVo.setVehicleType2(contractPdfVarsMap.get("vehicleType2"));
        ruleTemplateVo.setProduct(contractPdfVarsMap.get("product"));

        commonRuleService.get(ruleTemplateVo, RuleTypeEnums.CONTRACT.getType(),RuleTypeEnums.CONTRACT.getKey());
        String contractType = ruleTemplateVo.getTemplate();
        //contract.setContractFileType(contractType);
        StringBuffer bizCodeType =  new StringBuffer(contractType);
        bizCodeType.append("_BG");
        //合同附件类型
        applyInputVo.setContractFileType(bizCodeType.toString());
        //获取合同生成附件
        applyInputVo.setContGenerateFilesList(bizFilesService.findBizFilesList(applyNo,bizCodeType.toString()));
        //获取合同打印附件
        applyInputVo.setContPrintFilesList(bizFilesService.findBizFilesList(applyNo,BizCodeTypeEnums.CHANGE_CONTRACT_PRINT_FILE.getCodeType()));
    }


    /**
     * @Title:
     * @Description: 根据订单编号，获取风控审批用申请录入信息
     * @param applyNo 订单编号
     * @return ApplyRiskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 20:18:12
     */
    @Override
    public ApplyRiskVo findApplyInputRiskByTaskNo(String applyNo) {
        ApplyRiskVo applyRiskVo = new ApplyRiskVo();

        //获取变更任务信息
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("taskNo",applyNo);
        ChangeLesseeTask changeLesseeTask = changeLesseeTaskRepository.selectOneByExample(example);

        //申请类型为企业
        if(StringUtils.equals(ApplyTypeEnums.COMPANY.getType(),changeLesseeTask.getApplyType())){
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
        //担保个人信息
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
     * @Description: 修改任务信息
     * @param applyInputVo
     * @return ApplyRiskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-15 20:18:12
     */
    private String modifyServiceName(ApplyInputVo applyInputVo){
        if(StringUtils.equals(applyInputVo.getApplyType(),PERSON.getType())){
            if(applyInputVo.getCstmPerson() != null){
                return applyInputVo.getCstmPerson().getName();
            }
        }else if(StringUtils.equals(applyInputVo.getApplyType(),COMPANY.getType())){
            if(applyInputVo.getCstmCompany() != null){
                return applyInputVo.getCstmCompany().getName();
            }
        }
        return null;
    }


    /**
     * @Title:
     * @Description: 承租人变更合同生成
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @Override
    @Transactional
    public void changeContGenerate(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.approvalAgree(changeLesseeTaskVo.getTaskId());
        //合同生成
        saveContcreate(changeLesseeTaskVo);
        //保存审批日志信息
        saveWorkFlowLog(changeLesseeTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新任务表
        updateChangeLesseeTask(changeLesseeTaskVo,actRuTaskVo);
    }


    /**
     * 合同信息
     */
    private void saveContcreate(ChangeLesseeTaskVo changeLesseeTaskVo){
        //取得合同文件需要设值的项目
        Map<String,String> contractPdfVarsMap = getVariablesMap(changeLesseeTaskVo);

        //取得合同信息
        //根据contNo获取applyNo
        Example example1 = SqlUtil.newExample(Contract.class);
        example1.createCriteria().andEqualTo("contNo",changeLesseeTaskVo.getContNo());
        Contract contract =  contractRepository.selectOneByExample(example1);

        //规则引擎取得合同模板
        RuleContractTemplateVo ruleTemplateVo = new RuleContractTemplateVo();
        ruleTemplateVo.setLicenseAttr(contractPdfVarsMap.get("licenseAttr"));
        ruleTemplateVo.setWithinGroup(contractPdfVarsMap.get("withinGroup"));
        ruleTemplateVo.setVehicleType2(contractPdfVarsMap.get("vehicleType2"));
        ruleTemplateVo.setProduct(contractPdfVarsMap.get("product"));

        commonRuleService.get(ruleTemplateVo, RuleTypeEnums.CONTRACT.getType(),RuleTypeEnums.CONTRACT.getKey());
        String contractType = ruleTemplateVo.getTemplate();
        contract.setContractFileType(contractType);
        StringBuffer bizCodeType =  new StringBuffer(contractType);
        bizCodeType.append("_BG");
        //String contractType = contract.getContractFileType();
        //删除原来的附件
        //bizFilesService.deleteBizFilesByBizCode(contCreateVo.getContNo(),contractType);
//        List<BasFileType> BasFileTypes =new ArrayList<>();
//        try {
//            BasFileTypes = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(BizCodeTypeEnums.CHANGE_CONTRACT_GENERATE_FILE.getCodeType()));
//        }catch (FmsRpcException ex){
//            log.error(ex.getMessage());
//            ex.printStackTrace();
//            throw new FmsServiceException("合同附件类型取得失败");
//        }

        List<BizFiles> bizFilesList=new ArrayList<BizFiles>();
        //根据文件类型取得 合同附件类型
        List<BasFileType> basFileTypeList = new ArrayList<>();
        try {
            basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(contract.getContractFileType()));
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("合同附件类型取得失败");
        }
        //根据附件类型取得合同模板，并生成合同
        for(BasFileType basFileType:basFileTypeList){
            Boolean pdfCreateFlag = true;
            String pdfFile = "";
            BizFiles bizFiles=new BizFiles();
            //附件显示区分
            if(StringUtils.isNotTrimBlank(basFileType.getSubType())){
                if(!StringUtils.splitCommaToList(basFileType.getSubType()).contains("1")){
                    continue;
                }
            }
            //业务显示条件表达式
            if(StringUtils.isNotTrimBlank(basFileType.getFileTypeExpr())){
                Map<String,String> checkMap = CommonUtils.getExprMap(basFileType.getFileTypeExpr());
                for(String key : checkMap.keySet()){
                    //当前合同不满足处理条件，则不生成pdf
                    if(!checkMap.get(key).equals(contractPdfVarsMap.get(key))){
                        pdfCreateFlag = false;
                        continue;
                    }
                }
                //当前合同不满足处理条件，不生成pdf
                if(!pdfCreateFlag){
                    continue;
                }

            }
            //还款计划表
            if(basFileType.getFileType().contains("_hkjhb")){
                //还款计划表
                pdfFile = contractRepaySkedPdf(contract.getContNo(), basFileType.getFileType(),changeLesseeTaskVo);

            }else{
                if(StringUtils.isTrimBlank(basFileType.getFileTypeExpr())){
                    pdfFile = commonPdfService.create(contractPdfVarsMap, basFileType.getFileType());
                }else {
                    //担保个人有多条
                    if(basFileType.getFileTypeExpr().contains("guaPersFlag")){
                        //担保人信息字符串转成json数组
                        String jsonArrayStr = contractPdfVarsMap.get("jsonArrayStrPer");
                        JSONArray jsonArrayNew = new JSONArray();
                        JSONArray jsonArray = null;
                        if(StringUtils.isNotTrimBlank(jsonArrayStr)){
                            jsonArray = jsonArrayNew.parseArray(jsonArrayStr);

                            for (int i = 0;i<jsonArray.size();i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                // 遍历json对象存储的键值对
                                Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
                                Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
                                while (iterator.hasNext()) {
                                    Map.Entry<String, Object> stringMap = iterator.next();
                                    contractPdfVarsMap.put(stringMap.getKey(), stringMap.getValue().toString());
                                }
                                pdfFile = commonPdfService.create(contractPdfVarsMap, basFileType.getFileType());

                                //附件信息保存
                                BizFiles bizFilesPer=new BizFiles();
                                saveBizfies( bizFilesPer, bizFilesList, changeLesseeTaskVo,contractType, basFileType,pdfFile);
                            }
                        }
                    }
                    //担保企业有多条
                    if(basFileType.getFileTypeExpr().contains("guaCompFlag")){
                        //担保企业信息字符串转成json数组
                        String jsonArrayStr = contractPdfVarsMap.get("jsonArrayStrComp");
                        JSONArray jsonArrayNew = new JSONArray();
                        JSONArray jsonArray = null;
                        if(StringUtils.isNotTrimBlank(jsonArrayStr)){
                            jsonArray = jsonArrayNew.parseArray(jsonArrayStr);

                            for (int i = 0;i<jsonArray.size();i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                // 遍历json对象存储的键值对
                                Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
                                Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
                                while (iterator.hasNext()) {
                                    Map.Entry<String, Object> stringMap = iterator.next();
                                    contractPdfVarsMap.put(stringMap.getKey(), stringMap.getValue().toString());
                                }
                                pdfFile = commonPdfService.create(contractPdfVarsMap, basFileType.getFileType());

                                //附件信息保存
                                BizFiles bizFilesComp=new BizFiles();
                                saveBizfies( bizFilesComp, bizFilesList, changeLesseeTaskVo,contractType, basFileType,pdfFile);
                            }
                        }
                    }
                    if(!basFileType.getFileTypeExpr().contains("guaCompFlag")&&!basFileType.getFileTypeExpr().contains("guaPersFlag")){
                        pdfFile = commonPdfService.create(contractPdfVarsMap, basFileType.getFileType());
                    }
                }
            }

            //附件信息保存
            if(StringUtils.isTrimBlank(basFileType.getFileTypeExpr())){
                saveBizfies( bizFiles, bizFilesList, changeLesseeTaskVo,contractType, basFileType,pdfFile);
            }else {
                if(!basFileType.getFileTypeExpr().contains("guaCompFlag")&&!basFileType.getFileTypeExpr().contains("guaPersFlag")){
                    saveBizfies( bizFiles, bizFilesList, changeLesseeTaskVo,contractType, basFileType,pdfFile);
                }
            }
        }
        //合同车辆融资信息
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(changeLesseeTaskVo.getContNo());
        //保存补充协议
        changeLesseeContCreate(changeLesseeTaskVo,bizFilesList,contractPdfVarsMap,contract,contractVehicleVo);
        if(bizFilesList.size()>0){
            bizFilesService.modifyBizFilesList(bizFilesList,changeLesseeTaskVo.getTaskNo(),bizCodeType.toString());
        }
    }

    private void saveBizfies(BizFiles bizFiles,List<BizFiles> bizFilesList,ChangeLesseeTaskVo changeLesseeTaskVo,String contractType,BasFileType basFileType,String pdfFile){
        bizFiles.setBizCode(changeLesseeTaskVo.getContNo());
        bizFiles.setBizCodeType(contractType);
        bizFiles.setFileType(basFileType.getFileType());
        bizFiles.setFileName(basFileType.getFileTypeName()+changeLesseeTaskVo.getContNo()+".pdf");
        bizFiles.setFilePath(pdfFile);
        bizFilesList.add(bizFiles);
    }

    /*
   取得合同文件pdf需要设值的动态项目
    */
    private Map<String,String> getVariablesMap(ChangeLesseeTaskVo changeLesseeTaskVo) {
        //转换为map
        Map<String,String> varsMap = new HashMap<>();
        //合同信息
        ContractVo contractVo = contractService.findContractVoByContractNo(changeLesseeTaskVo.getContNo());

        //变更前个人客户信息
        CstmPerson oldCstmPerson = cstmPersonService.findCstmPersonByApplyNo(contractVo.getApplyNo());
        //变更前企业客户信息
        CstmCompany oldCstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(contractVo.getApplyNo());
        //变更前联系人信息
        List<CstmContact> oldCstmContactList = cstmContactService.findCstmContactsByApplyNo(contractVo.getApplyNo());
        //取得变更前客户地址信息
        CstmPersAddr oldCstmPersAddr = cstmPersAddrService.findCstmPersAddrByApplyNo(contractVo.getApplyNo());


        //合同融资信息
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(changeLesseeTaskVo.getContNo());

        //合同车辆融资信息
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(changeLesseeTaskVo.getContNo());
        //融资费用明细
        List<ContFinDetailVo> contFinDetailVoList = contractVehicleVo.getContFinDetailVoList();

        //变更后客户个人信息
        CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(changeLesseeTaskVo.getTaskNo());
        //变更后取得客户地址信息
        CstmPersAddr cstmPersAddr = cstmPersAddrService.findCstmPersAddrByApplyNo(changeLesseeTaskVo.getTaskNo());

        //变更后客户企业信息
        CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(changeLesseeTaskVo.getTaskNo());
        //变更后企业股东信息
        List<StockAssets> stockAssetsList = stockAssetsService.findStockAssetsListByApplyNo(changeLesseeTaskVo.getTaskNo());

        //担保人信息
        //取得变更后客户保证人信息
        List<GuaranteePers> guaranteePersList = guaranteePersService.findGuaranteePersByApplyNo(changeLesseeTaskVo.getTaskNo());
        //取得变更后客户保证企业信息
        List<GuaranteeComp> guaranteeCompList = guaranteeCompService.findGuaranteeCompsByApplyNo(changeLesseeTaskVo.getTaskNo());

        //变更后共同借款人信息
        List<CommonBorrower> commonBorrowerList = commonBorrowerService.findCommonBorrowersByApplyNo(changeLesseeTaskVo.getTaskNo());
        //变更后联系人信息
        List<CstmContact> cstmContactList = cstmContactService.findCstmContactsByApplyNo(changeLesseeTaskVo.getTaskNo());

        if(StringUtils.isNotTrimBlank(cstmCompany)){
            varsMap = JsonUtils.objectToMap(contractVo,contractFinanceVo,contractVehicleVo,cstmCompany);
            varsMap.put("identificationNumber",cstmCompany.getSocialCertifNo());
            varsMap.put("resideAddr",cstmCompany.getRegisterAddr());
            setStockAssetsVarsMap(stockAssetsList,varsMap);
            varsMap.put("lesseeContact",cstmCompany.getContactName());
            varsMap.put("lesseePhone",cstmCompany.getCompTel());
            varsMap.put("certifType","统一社会信用代码");
        }else{
            varsMap = JsonUtils.objectToMap(contractVo,contractFinanceVo,contractVehicleVo,cstmPerson,cstmPersAddr);
            //证件类型(取字典值)
            String certifTypeName = commonConstantService.findSysCodeValueName("certifType", cstmPerson.getCertifType());
            varsMap.put("certifType",certifTypeName);
            varsMap.put("identificationNumber",cstmPerson.getCertifNo());
            varsMap.put("lesseePhone",cstmPerson.getMobileNo());
        }
        //旧的信息
        if(StringUtils.isNotTrimBlank(oldCstmCompany)){
            varsMap.put("oldIdentificationNumber",oldCstmCompany.getSocialCertifNo());
            varsMap.put("oldResideAddr",oldCstmCompany.getCompAddr()); //地址信息
            varsMap.put("oldLesseeContact",oldCstmCompany.getContactName()); //联系人
            varsMap.put("oldLesseeContactTel",oldCstmCompany.getContactMobno()); //联系人电话
            varsMap.put("oldLesseeName",oldCstmCompany.getName()); //乙方姓名
            varsMap.put("oldLesseePhone",oldCstmCompany.getCompTel()); //乙方号码
            varsMap.put("oldCertifType","统一社会信用代码");

        }else{
            //证件类型(取字典值)
            String certifTypeName = commonConstantService.findSysCodeValueName("certifType", oldCstmPerson.getCertifType());
            varsMap.put("oldCertifType",certifTypeName);
            if(oldCstmPersAddr != null){
                varsMap.put("oldResideAddr",oldCstmPersAddr.getResideAddr()); //地址信息
            }
            varsMap.put("oldIdentificationNumber",oldCstmPerson.getCertifNo()); //证件号码
            varsMap.put("oldLesseeName",oldCstmPerson.getName()); //乙方姓名
            varsMap.put("oldLesseePhone",oldCstmPerson.getMobileNo());  //乙方号码
            if(ArrayUtils.isNotNullAndLengthNotZero(oldCstmContactList)){
                varsMap.put("oldLesseeContact",oldCstmContactList.get(0).getName()); //联系人
                varsMap.put("oldLesseeContactTel",oldCstmContactList.get(0).getMobileNo()); //联系人电话
            }

        }
        if("1".equals(contractFinanceVo.getVehicleForm())){
            varsMap.put("vehicleForm1","√");
        }else{
            varsMap.put("vehicleForm2","√");
        }

        //实际销售方
        varsMap.put("salesName",contractVehicleVo.getSaleGroupName());

        //设置contCreateVo
        setContCreatVarsMap(contractVo, varsMap);

        //担保人信息
        setGuaranteeVarsMap(guaranteePersList,guaranteeCompList, varsMap);

        //共同借款人
        setCommonBorrowersMap(commonBorrowerList,varsMap,cstmPerson);

        //各融资项目
        setFinItemsVarsMap(contFinDetailVoList, varsMap);

        //合同编号
        setContNoVarsMap(contractVo.getContNo(),varsMap);

        //变更后联系人信息
        setCstmContactMap(cstmContactList,varsMap);
        //固定值
        setConstant(varsMap);
        //出租人
        varsMap.put("groupName",contractFinanceVo.getBelongGroupName());
        //出租人证件号码(出租统一社会信用代码)
        varsMap.put("groupSocialCertifNo",contractFinanceVo.getSocialCertifNo());

        //金额-大写
//        首付款、保证金、经销商手续费（如有）、续保押金，确认收款后才可放款，首期租金
        varsMap.put("manageFee","0");
        BigDecimal receiptAmount = contractFinanceVo.getInitAmount().add(contractFinanceVo.getDeposit()).add(contractFinanceVo.getRent()).add(contractVehicleVo.getCharge()).
                add(contractVehicleVo.getRenewalDeposit()).add(contractVehicleVo.getSalesCharge());
        varsMap.put("receiptAmount", receiptAmount.toString());
        varsMap.put("payAmount", contractFinanceVo.getInvestTotal().subtract(receiptAmount).toString());
        varsMap.put("finTotalFor", CommonUtils.changeMoney(contractFinanceVo.getFinTotal()));
        //年供金额大写
        varsMap.put("annualSupplyAmountFor",CommonUtils.changeMoney(contractFinanceVo.getAnnualSupplyAmount()));
        //首付金额大写
        varsMap.put("initAmountFor",CommonUtils.changeMoney(contractFinanceVo.getInitAmount()));
        //保证金大写
        varsMap.put("depositFor",CommonUtils.changeMoney(contractFinanceVo.getDeposit()));
        //每期租金
        if(contractFinanceVo.getRent()!=null){
            varsMap.put("rent",contractFinanceVo.getRent().toString());
        }
        //每期租金大写
        varsMap.put("rentFor",CommonUtils.changeMoney(contractFinanceVo.getRent()));
        //手续费大写
        varsMap.put("chargeFor",CommonUtils.changeMoney(contractVehicleVo.getCharge()));
        //续保押金大写
        varsMap.put("renewalDepositFor",CommonUtils.changeMoney(contractVehicleVo.getRenewalDeposit()));
        //投资总额大写
        varsMap.put("investTotalFor",CommonUtils.changeMoney(contractFinanceVo.getInvestTotal()));

        //《车辆转让意向书》甲方同意以人民币......(有回购价取回购价，没回购价取尾款，尾款也没有取1000)
        BigDecimal backPurchase;
        if(contractVehicleVo.getBackPurchase()!=null&&contractVehicleVo.getBackPurchase().compareTo(BigDecimal.ZERO)>0){
            backPurchase = contractVehicleVo.getBackPurchase();
        }else {
            if (contractFinanceVo.getFinalAmount()!=null&&contractFinanceVo.getFinalAmount().compareTo(BigDecimal.ZERO)>0){
                backPurchase = contractFinanceVo.getFinalAmount();
            }else {
                backPurchase = new BigDecimal("1000.00");
            }
        }
        varsMap.put("money",backPurchase.toString());
        varsMap.put("moneyFor",CommonUtils.changeMoney(backPurchase));

        //合同《主要条款》中如果是"回购价"项目(有回购价取回购价，没回购价取尾款，尾款也没有取0)
        BigDecimal backPurchaseMoney;
        if(contractVehicleVo.getBackPurchase()!=null&&contractVehicleVo.getBackPurchase().compareTo(BigDecimal.ZERO)>0){
            backPurchaseMoney = contractVehicleVo.getBackPurchase();
        }else {
            if (contractFinanceVo.getFinalAmount()!=null&&contractFinanceVo.getFinalAmount().compareTo(BigDecimal.ZERO)>0){
                backPurchaseMoney = contractFinanceVo.getFinalAmount();
            }else {
                backPurchaseMoney = new BigDecimal("0.00");
            }
        }
        varsMap.put("backPurchaseMoney",backPurchaseMoney.toString());
        varsMap.put("backPurchaseMoneyFor",CommonUtils.changeMoney(backPurchaseMoney));

        //合同《主要条款》中如果是"尾款"项目(有尾款取尾款，没尾款取回购价，回购价也没有取0)
        BigDecimal tailMoney;
        if(contractFinanceVo.getFinalAmount()!=null&&contractFinanceVo.getFinalAmount().compareTo(BigDecimal.ZERO)>0){
            tailMoney = contractFinanceVo.getFinalAmount();
        }else {
            if (contractVehicleVo.getBackPurchase()!=null&&contractVehicleVo.getBackPurchase().compareTo(BigDecimal.ZERO)>0){
                tailMoney = contractVehicleVo.getBackPurchase();
            }else {
                tailMoney = new BigDecimal("0.00");
            }
        }
        varsMap.put("tailMoney",tailMoney.toString());
        varsMap.put("tailMoneyFor",CommonUtils.changeMoney(tailMoney));

        //直租合同《担保保函》(个人和企业)债务人民币......
        BigDecimal debtMoney;
        if(contractFinanceVo.getAnnualSupplyAmount().compareTo(BigDecimal.ZERO)!=0) {
            debtMoney = contractFinanceVo.getRent().multiply(new BigDecimal(contractFinanceVo.getFinPeriodType()).subtract(BigDecimalUtils.divide(new BigDecimal(contractFinanceVo.getFinPeriodType()), new BigDecimal("12"), 0))).add(
                    contractFinanceVo.getAnnualSupplyAmount().multiply(BigDecimalUtils.divide(new BigDecimal(contractFinanceVo.getFinPeriodType()), new BigDecimal("12"), 0))).add(backPurchase);
        }else {
            debtMoney = (contractFinanceVo.getRent().multiply(new BigDecimal(contractFinanceVo.getFinPeriodType()))).add(backPurchase);
        }
        varsMap.put("debtMoney",debtMoney.toString());
        varsMap.put("debtMoneyFor",CommonUtils.changeMoney(debtMoney));
        varsMap.put("debtMoney"+1,debtMoney.toString());
        varsMap.put("debtMoneyFor"+1,CommonUtils.changeMoney(debtMoney));

        //回租合同《机动车买卖合同》签订时打印"年","月","日"
        varsMap.put("ymd","年   月   日");

        //《咨询服务合同》乙方同意支付甲方服务费人民币.....(手续费+代收手续费)
        varsMap.put("chargeAndSalesCharge",contractVehicleVo.getCharge().add(contractVehicleVo.getSalesCharge()).toString());

        //回租合同《收款确认书》合计金额(少融资项中其他费用和gps费)
        BigDecimal backTotalMoneyShort = contractFinanceVo.getInitAmount().add(contractFinanceVo.getRent()).add(contractVehicleVo.getCharge()).
                add(contractVehicleVo.getRenewalDeposit()).add(contractVehicleVo.getSalesCharge());
        varsMap.put("backTotalMoneyShort",backTotalMoneyShort.toString());
        if(StringUtils.isTrimBlank(varsMap.get("others"))){
            varsMap.put("others","0.00");
        }
        if(StringUtils.isTrimBlank(varsMap.get("gps"))){
            varsMap.put("gps","0.00");
        }
        //回租合同《收款确认书》合计金额
        varsMap.put("backTotalMoney",new BigDecimal(varsMap.get("others")).add(backTotalMoneyShort).add(new BigDecimal(varsMap.get("gps"))).toString());
        //回租合同《收款确认书》支付款项
        varsMap.put("backTotalMoney"+1,new BigDecimal(varsMap.get("others")).add(backTotalMoneyShort).add(new BigDecimal(varsMap.get("gps"))).toString());
        //回租合同《收款确认书》剩余转让价款
        varsMap.put("SurplusBackTotalMoney",contractFinanceVo.getInvestTotal().subtract(new BigDecimal(varsMap.get("others")).add(backTotalMoneyShort).add(new BigDecimal(varsMap.get("gps")))).toString());

        //还款日
        String repayDay = contractFinanceVo.getRepayDay();

        varsMap.put("repayDay",repayDay);
        varsMap.put("contractDate", DateUtils.getCurrentDateString());
        //首期还款日
        String firstRepayDate = DateUtils.getRepayDate(contractVo.getContractDate(), repayDay, 1, contractFinanceVo.getRentPayMode());
        varsMap.put("contractValidDate", DateUtils.getStringDate( DateUtils.strToDate(firstRepayDate, DateUtils.formatStr_yyyyMMd_NO) ,DateUtils.formatStr_yyyyMMddChinese));

        //第二期租金支付日期
        int period = Integer.valueOf(contractFinanceVo.getFinPeriodType())/Integer.valueOf(contractFinanceVo.getRepayRate());
        String secondRepayDate = DateUtils.getRepayDate(contractVo.getContractDate(), repayDay, 2, contractFinanceVo.getRentPayMode());
        varsMap.put("secondRepayDate",DateUtils.getStringDate( DateUtils.strToDate(secondRepayDate, DateUtils.formatStr_yyyyMMd_NO) ,DateUtils.formatStr_yyyyMMddChinese));

        //最后一期还款日
        String lastRepayDate1 = DateUtils.getRepayDate(contractVo.getContractDate(), repayDay, period+1, contractFinanceVo.getRentPayMode());
        Date lastRepayDate2 = DateUtils.getAddDay(DateUtils.strToDate(lastRepayDate1, DateUtils.formatStr_yyyyMMd_NO), "-1");
        String lastRepayDate = DateUtils.dateToStr(lastRepayDate2, DateUtils.formatStr_yyyyMMd_NO);
        varsMap.put("lastRepayDay",DateUtils.getStringDate( DateUtils.strToDate(lastRepayDate, DateUtils.formatStr_yyyyMMd_NO) ,DateUtils.formatStr_yyyyMMddChinese));

        //心享车合同《车辆回购协议》中回购期限末(最后一期还款日往后一个月)（回购期限起始为首期还款日）
        String backPurchaseLastDate = DateUtils.dateToStr(DateUtils.getAddMonth(lastRepayDate2, 1), DateUtils.formatStr_yyyyMMd_NO);
        varsMap.put("backPurchaseLastDate",DateUtils.getStringDate( DateUtils.strToDate(backPurchaseLastDate, DateUtils.formatStr_yyyyMMd_NO) ,DateUtils.formatStr_yyyyMMddChinese));

        //心享车合同《主要条款》中车辆处置费取1000
        varsMap.put("vehicleDisposalFee",new BigDecimal("1000.00").toString());
        varsMap.put("vehicleDisposalFeeFor",CommonUtils.changeMoney(new BigDecimal("1000.00")));

        BasBankInfo basBankInfoGroup;
        BasBankInfo basBankInfoSales;
        //取得出租人银行账号信息
        try {
            basBankInfoGroup = ResponseEntityUtils.getRestResponseData(basBankInfoRpc.findBasBankInfoByOrg(BankOrganizationTypeEnums.USER_GROUP.getType(), contractFinanceVo.getBelongGroup()));
            basBankInfoSales = ResponseEntityUtils.getRestResponseData(basBankInfoRpc.findBasBankInfoByOrg(BankOrganizationTypeEnums.BAS_SALES.getType(), contractVehicleVo.getSaleGroupCode()));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("银行账号取得失败");
        }

        //出租人账号信息
        varsMap.put("accBank",basBankInfoGroup.getAccBranchBank());
        varsMap.put("accountNo",basBankInfoGroup.getAccountNo());
        varsMap.put("accountName",basBankInfoGroup.getAccountName());

        //实价销售方账号信息
        varsMap.put("accBankSale",basBankInfoSales.getAccBranchBank());
        varsMap.put("accountNoSale",basBankInfoSales.getAccountNo());
        varsMap.put("accountNameSale",basBankInfoSales.getAccountName());

        //设置项目重复信息
        //出租人地址重复
        varsMap.put("registeredAddr"+ 0, varsMap.get("registeredAddr"));
        //承租人地址重复
        varsMap.put("resideAddr" + 0,varsMap.get("resideAddr"));
        //融资额重复
        varsMap.put("finTotal"+ 0, varsMap.get("finTotal"));
        //投资总额重复
        varsMap.put("investTotal" + 0,varsMap.get("investTotal"));
        //实际销售方重复
        varsMap.put("salesName" + 0,contractVehicleVo.getSaleGroupName());
        //出租人名称重复
        varsMap.put("groupName" + 0,contractFinanceVo.getBelongGroupName());
        varsMap.put("groupName" + 2,contractFinanceVo.getBelongGroupName());
        varsMap.put("groupName" + 3,contractFinanceVo.getBelongGroupName());
        //承租人名称重复
        varsMap.put("name" + 0,varsMap.get("name"));
        //大写
        varsMap.put("finTotalFor0",CommonUtils.changeMoney(contractFinanceVo.getFinTotal()));
        varsMap.put("receiptAmount"+ 0, varsMap.get("receiptAmount"));

        //设置合同处理规则项目
        //企业 个人：applyType
        if(ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList)){
            varsMap.put("guaPersFlag", "1");
        }else{
            varsMap.put("guaPersFlag", "0");
        }

        if(ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList)){
            varsMap.put("guaCompFlag", "1");
        }else{
            varsMap.put("guaCompFlag", "0");
        }


        if((contractVehicleVo.getCharge()!=null&&contractVehicleVo.getCharge().compareTo(BigDecimal.ZERO)>0)||
                (contractVehicleVo.getSalesCharge()!=null&&contractVehicleVo.getSalesCharge().compareTo(BigDecimal.ZERO)>0)){
            varsMap.put("createFlag", "1");
        }else {
            varsMap.put("createFlag", "0");
        }
        //还款计划已还信息载体
        ContRepaySkedAlreadyPayInfoVo contRepaySkedAlreadyPayInfoVo = commonGetRepayInfoService.commonGetRepayInfo(contractVo.getContNo());
        varsMap.put("finPeriodType",StringUtils.getValue(IntegerUtils.getValue(contractFinanceVo.getFinPeriodType())-contRepaySkedAlreadyPayInfoVo.getAlreadyRepayNper()));//剩余融资期限
        //还款起始日
        varsMap.put("contractValidDate",DateUtils.dateToStr(contRepaySkedAlreadyPayInfoVo.getStartValiDate(),DateUtils.formatStr_yyyyMMddChinese));
        //首付款
        varsMap.put("initAmountFor",CommonUtils.changeMoney(BigDecimal.ZERO));
        varsMap.put("initAmount",StringUtils.getValue(BigDecimal.ZERO));
        return varsMap;
    }
    /*
        * 设置联系人
        */
    private void setCstmContactMap(List<CstmContact> cstmContactList,Map<String, String> varsMap){
        if(ArrayUtils.isNotNullAndLengthNotZero(cstmContactList)){
            for(int i = 0;i<cstmContactList.size();i++){
                varsMap.put("contactName"+i,cstmContactList.get(i).getName());//联系人姓名
                varsMap.put("contactNo"+i,cstmContactList.get(i).getMobileNo());//联系人姓名
            }
        }
    }

    /*
    * 设置企业股东参数
    */
    private void setStockAssetsVarsMap(List<StockAssets> stockAssetsList, Map<String, String> varsMap) {
        int i = 1;
        for(StockAssets stockAssets :stockAssetsList){
//          股东名称
            varsMap.put("shareholderName"+i,stockAssets.getShareholderName());
//          股份比例
            varsMap.put("shareRatio"+i,stockAssets.getShareRatio().toString());
            i++;
        }
    }

    /*
     *固定值设置
     */
    private void setConstant(Map<String, String> varsMap){
        varsMap.put("lessorPhone", "0592-3208899");

        //回租赁出租人账号信息
        varsMap.put("accBankFix","万量（厦门）融资租赁有限公司");
        varsMap.put("accountNoFix","129030100100305399");
        varsMap.put("accountNameFix","兴业银行厦门同安支行");
    }

    /*
     *设置承租人参数(如果没共同借款人就只取承租人承租人，如果有共同借款人就取承租人和共同借款人)
     */
    private void setCommonBorrowersMap(List<CommonBorrower> commonBorrowerList,Map<String, String> varsMap,CstmPerson cstmPerson){
        if(ArrayUtils.isNotNullAndLengthNotZero(commonBorrowerList) && cstmPerson != null){
            String commonBorrowerNameStr = "";
            for (CommonBorrower commonBorrower : commonBorrowerList){
                if(StringUtils.isNotTrimBlank(commonBorrower.getName()))
                    commonBorrowerNameStr = commonBorrowerNameStr+commonBorrower.getName()+"、";
            }
            String name = cstmPerson.getName()+"、"+commonBorrowerNameStr;
            if(name.length() > 0)
                varsMap.put("name",name.substring(0,name.length()-1));
        }
    }

    /*
     * 设置融资费用明细参数
     */
    private void setFinItemsVarsMap(List<ContFinDetailVo> contFinDetailVoList, Map<String, String> varsMap) {
        for(ContFinDetailVo contFinDetailVo :contFinDetailVoList){
            if(varsMap.containsKey(contFinDetailVo.getFinItem())){
                varsMap.put(contFinDetailVo.getFinItem(), contFinDetailVo.getFinAmount().add(new BigDecimal(varsMap.get(contFinDetailVo.getFinItem()))).toString());
            }else{
                varsMap.put(contFinDetailVo.getFinItem(), contFinDetailVo.getFinAmount().toString());
            }
            if(contFinDetailVo.getFinItemYear()>0){
                varsMap.put(contFinDetailVo.getFinItem()+contFinDetailVo.getFinItemYear(), contFinDetailVo.getFinAmount().toString());
            }
            varsMap.put(contFinDetailVo.getFinItem() + "For",CommonUtils.change(varsMap.get(contFinDetailVo.getFinItem())));
        }
    }

    /*
     * 设置合同编号（多个）
     */
    private void setContNoVarsMap(String contNo, Map<String, String> varsMap) {
        for(int i=1; i<10; i++){
            varsMap.put("contNo-"+i, contNo+"-"+i);
            varsMap.put("contNo"+i,contNo);
        }
    }

    /*
     *设置画面入力的参数
     */
    private void setContCreatVarsMap(ContractVo contractVo, Map<String, String> varsMap) {
        varsMap.put("engineNo",contractVo.getEngineNo());
        varsMap.put("vinNo",contractVo.getVinNo());
        varsMap.put("color", contractVo.getColor());
    }

    /*
     *设置担保人参数
     */
    private void setGuaranteeVarsMap(List<GuaranteePers> guaranteePersList, List<GuaranteeComp> guaranteeCompList, Map<String, String> varsMap) {

        //担保人
        JSONArray jsonArrayPer = new JSONArray();
        if(ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList)){
            for(int i = 0; i<guaranteePersList.size(); i++){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("guaCertifNoGR",guaranteePersList.get(i).getCertifNo());
                jsonObject.put("compNameGR",guaranteePersList.get(i).getCompName());
                jsonObject.put("guaAddrGR",guaranteePersList.get(i).getResideAddr());
                jsonObject.put("guaPhoneGR",guaranteePersList.get(i).getMobileNo());
                jsonArrayPer.add(jsonObject);
            }
            varsMap.put("jsonArrayStrPer",jsonArrayPer.toString());
        }

        //担保企业
        JSONArray jsonArrayComp = new JSONArray();
        if(ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList)){
            for(int i = 0; i<guaranteeCompList.size(); i++){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("guaCertifNoQY", guaranteeCompList.get(i).getSocialCertifNo());
                jsonArrayComp.add(jsonObject);
            }
            varsMap.put("jsonArrayStrComp",jsonArrayComp.toString());
        }

        //《融资租赁与保证合同》担保人信息
        int index=1;
        if(ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList)){
            for(GuaranteePers guaranteePers:guaranteePersList){
                varsMap.put("guaName"+index, guaranteePers.getName());
                varsMap.put("guaCertifNo"+index, guaranteePers.getCertifNo());
                varsMap.put("guaAddr"+index, guaranteePers.getResideAddr());
                varsMap.put("guaPhone"+index, guaranteePers.getMobileNo());
                varsMap.put("guaContact"+index, guaranteePers.getName());
                index = index+1;
            }
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList)){
            for(GuaranteeComp guaranteeComp:guaranteeCompList){
                varsMap.put("guaName"+index, guaranteeComp.getName());
                varsMap.put("guaCertifNo"+index, guaranteeComp.getSocialCertifNo());
                varsMap.put("guaAddr"+index, guaranteeComp.getRegisterAddr());
                varsMap.put("guaPhone"+index, guaranteeComp.getContactMobno());
                varsMap.put("guaContact"+index, guaranteeComp.getCompContactPers());
            }

        }
    }

    /**
     * @Description: 生成还款计划表
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/10 17:14
     */
    private String contractRepaySkedPdf(String contNo, String tplType,ChangeLesseeTaskVo changeLesseeTaskVo){

        //最近未还的期数
        ContRepaySkedVo contRepaySkedVo = contRepaySkedRepository.selectContRepaySkedToBePay(contNo);

        //尾付
        ContRepaySked contRepaySkedFin = null;
        //获取合同融资信息
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);
        //期数
        int period = Integer.valueOf(contractFinanceVo.getFinPeriodType())/Integer.valueOf(contractFinanceVo.getRepayRate());

        List<ContRepaySked> contRepaySkedList = new ArrayList();
        contRepaySkedList = contReceiptPayService.getContRepaySked(contNo);
        //提取尾付,尾付必定是最后一期
        if(period+1 == contRepaySkedList.get(contRepaySkedList.size()-1).getPeriod()){
            contRepaySkedFin = contRepaySkedList.get(contRepaySkedList.size() - 1);
        }
        //去除首付和尾付(尾付期数：period+1)
        contRepaySkedList = contRepaySkedList.stream().filter(s -> 0 != s.getPeriod() && period+1 != s.getPeriod()).collect(Collectors.toList());
        if(contRepaySkedFin != null){//最后一期加上尾付金额
            contRepaySkedList.get(contRepaySkedList.size()-1).setRentActual(BigDecimalUtils.getNotNullBigDecimal(contRepaySkedFin.getRentActual()).add(
                    BigDecimalUtils.getNotNullBigDecimal(contRepaySkedList.get(contRepaySkedList.size()-1).getRentActual())
            ));
        }

        //生成划款计划表pdf
        ContractVehicleFinanceVo contractVehicleFinanceVo = contractVehicleService.findContractVehicleFinanceVoByContNo(contNo);
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(contractVehicleFinanceVo);


        //变更后客户个人信息
        CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(changeLesseeTaskVo.getTaskNo());
        //变更后客户企业信息
        CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(changeLesseeTaskVo.getTaskNo());
        if(StringUtils.isNotTrimBlank(cstmCompany)){
            //设置客户信息
            pdfVariables.put("name",cstmCompany.getName());
        }else{
            //设置客户信息
            pdfVariables.put("name",cstmPerson.getName());
        }

        BigDecimal totalRent = BigDecimal.ZERO;
        for(int i = (contRepaySkedVo.getPeriod()-1),j = 0;i < contRepaySkedList.size();i++,j++){
            pdfVariables.put("repayDay" + (j + 1), DateUtils.dateToStr(contRepaySkedList.get(i).getRepayDate(), DateUtils.formatStr_yyyyMMdd));
            pdfVariables.put("rent" + (j + 1), BigDecimalUtils.getNotNullString(contRepaySkedList.get(i).getRentActual()));
            totalRent = totalRent.add(contRepaySkedList.get(i).getRentActual());
        }

        pdfVariables.put("initAmount", BigDecimalUtils.getNotNullString(BigDecimal.ZERO));//首付
        //租金合计
        pdfVariables.put("totalRent", BigDecimalUtils.getNotNullString(totalRent.add(contractFinanceVo.getInitAmount())));
        pdfVariables.put("totalRentFor", CommonUtils.change(BigDecimalUtils.getNotNullString(totalRent.add(contractFinanceVo.getInitAmount()))));
        pdfVariables.put("contractValidDate", DateUtils.dateToStr(contRepaySkedVo.getRepayDate(), DateUtils.formatStr_yyyyMMdd));//起始日期
        pdfVariables.put("lastRepayDay", DateUtils.dateToStr(DateUtils.getAddDay(DateUtils.getAddMonth(contRepaySkedList.get(contRepaySkedList.size()-1).getRepayDate(),1),"-1"), DateUtils.formatStr_yyyyMMdd));//结束日期
        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, tplType);
        return filePath;
    }



    /**
     * @Title:
     * @Description: 承租人变更补充协议
     * @param changeLesseeTaskVo 变更承租人任务vo
     * @param bizFilesList 附件集合
     * @param contractPdfVarsMap 合同生成所需值map
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-29 15:14:54
     */
    private void changeLesseeContCreate(ChangeLesseeTaskVo changeLesseeTaskVo,List<BizFiles> bizFilesList,Map<String,String> contractPdfVarsMap,Contract contract,ContractVehicleVo contractVehicleVo){
        //pdf的参数
       Map<String,String> pdfVariables = JsonUtils.objectToMap(changeLesseeTaskVo);
        //还款计划已还信息载体
        ContRepaySkedAlreadyPayInfoVo contRepaySkedAlreadyPayInfoVo = commonGetRepayInfoService.commonGetRepayInfo(contract.getContNo());
        //取得车型
        Example example = SqlUtil.newExample(BasVehicle.class);
        example.createCriteria().andEqualTo("vehicleCode",contractVehicleVo.getVehicleCode());
        BasVehicle basVehicle = basVehicleRepository.selectOneByExample(example);


//        varsMap.put("oldCertifType",certifTypeName);
//        varsMap.put("oldResideAddr",oldCstmPersAddr.getResideAddr()); //地址信息
//        varsMap.put("oldIdentificationNumber",oldCstmPerson.getCertifNo()); //证件号码
//        varsMap.put("oldLesseePhone",oldCstmPerson.getMobileNo());  //乙方号码
//        varsMap.put("oldLesseeContact",oldCstmContactList.get(0).getName()); //联系人
//        varsMap.put("oldLesseeContactTel",oldCstmContactList.get(0).getMobileNo()); //联系人电话
//        varsMap.put("oldLesseeName",oldCstmCompany.getName()); //乙方姓名
//        varsMap.put("oldLesseePhone",oldCstmCompany.getCompTel()); //乙方号码
//        //赋值
          pdfVariables.put("groupName",contractPdfVarsMap.get("groupName")); //甲方
          pdfVariables.put("name",contractPdfVarsMap.get("oldLesseeName"));// 乙方
          pdfVariables.put("groupAddress",contractPdfVarsMap.get("registeredAddr"));//甲方地址
          pdfVariables.put("groupPhone",contractPdfVarsMap.get("lessorPhone"));//甲方电话
          pdfVariables.put("address",contractPdfVarsMap.get("oldResideAddr")); //乙方地址
          pdfVariables.put("identificationNumber",contractPdfVarsMap.get("oldIdentificationNumber")); //证件号码/统一社会信用代码
          pdfVariables.put("lesseeName",contractPdfVarsMap.get("oldLesseeContact")); //联系人
          pdfVariables.put("lesseePhone",contractPdfVarsMap.get("oldLesseeContactTel"));//联系人号码
          //pdfVariables.put("date",DateUtils.dateToStr(contract.getContractValidDate(),DateUtils.formatStr_yyyyMMddChinese));//合同签订日期
          pdfVariables.put("contNo",contract.getContNo());//合同号
          pdfVariables.put("vehicleName",basVehicle.getVehicleName());//车型
          pdfVariables.put("vinNo",contract.getVinNo());//车架号
          pdfVariables.put("phase",contRepaySkedAlreadyPayInfoVo.getAlreadyRepayNper().toString());//已还期数
          pdfVariables.put("rent",contRepaySkedAlreadyPayInfoVo.getAlreadyRepayAmount().toString());//已还金额
//        //pdf路径
          String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.BCXY_HTJY_BGCZR.getType());
//        //根据文件类型取得 合同附件类型
//        List<BasFileType> basFileTypeList = new ArrayList<>();
//        try {
//            basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE.getCodeType()));
//        }catch (FmsRpcException ex){
//            log.error(ex.getMessage());
//            ex.printStackTrace();
//            throw new FmsServiceException("合同附件类型取得失败");
//        }
        //List<BizFiles> bizFilesList = new ArrayList<>();
//        for(BasFileType basFileType:basFileTypeList){
//            if(basFileType.getFileType().equals(BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE_1.getCodeType())){
                StringBuffer bizCodeType =  new StringBuffer(contract.getContractFileType());
                bizCodeType.append("_BG");
                BizFiles bizFiles = new BizFiles();
                bizFiles.setBizCode(changeLesseeTaskVo.getTaskNo());
                bizFiles.setBizCodeType(bizCodeType.toString());
                bizFiles.setFileType(new StringBuffer(contract.getContractFileType()).append("_bcxy").toString());
                bizFiles.setFileName(contract.getContNo()+"补充协议"+".pdf");
                bizFiles.setFilePath(filePath);
                bizFilesList.add(bizFiles);
//            }
//        }
    }


    /**
     * @Title:
     * @Description: 审批日志保存
     * @param
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Transactional
    private void saveWorkFlowLog(ChangeLesseeTaskVo changeLesseeTaskVo, ActRuTaskVo actRuTaskVo, String actType, SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(changeLesseeTaskVo.getTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.CHANGE_LESSEE.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(changeLesseeTaskVo.getMemo());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
        //updateChangeLesseeTask(changeLesseeTaskVo, actRuTaskVo);

    }
    /**
     * @Title:
     * @Description: 更新任务表信息
     * @param
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Transactional
    private void updateChangeLesseeTask(ChangeLesseeTaskVo changeLesseeTaskVo, ActRuTaskVo actRuTaskVo) {
        //更新任务表
        changeLesseeTaskVo.setTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        changeLesseeTaskVo.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点人
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("taskNo",changeLesseeTaskVo.getTaskNo());
        changeLesseeTaskRepository.updateByExampleSelectiveData(changeLesseeTaskVo.getEntity(),example);
    }



}
