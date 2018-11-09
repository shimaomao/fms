package cn.com.leadu.fms.prebiz.service.impl;/**
 * Created by ningyangyang on 2018/10/31.
 */

import cn.com.leadu.fms.business.common.util.activiti.ActDeferTaskUtils;
import cn.com.leadu.fms.business.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.business.service.*;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BankOrganizationTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.OverDueStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ChargePayModeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.DepositRtnModeEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.baseinfo.repository.BasVehicleRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.ChangeLesseeTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.DeferTaskRepository;
import cn.com.leadu.fms.data.prebiz.repository.*;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleContractTemplateVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedAlreadyPayInfoVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.rpc.baseinfo.BasBankInfoRpc;
import cn.com.leadu.fms.prebiz.service.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/10/31 9:49
 */
@Slf4j
@Service
public class DeferContCreateServiceImpl implements DeferContCreateService{


    /**
     * @Fields  : 合同展期任务Repository
     */
    @Autowired
    private DeferTaskRepository deferTaskRepository;

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
     * @Fields  :pdfService
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * @Fields  :合同融资信息repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    /**
     * @Fields  :付款信息repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Title:
     * @Description:  根据contNo获取展期合同的当前合同信息
     * @param deferTaskVo
     * @return DeferTaskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    @Transactional
    public DeferTaskVo findDeferTaskVoByContNo(DeferTaskVo deferTaskVo) {
        DeferTask deferTask1 = null;
        if(StringUtils.isNotTrimBlank(deferTaskVo.getDeferTaskNo())){
            //获取任务信息
            Example example = SqlUtil.newExample(DeferTask.class);
            example.createCriteria().andEqualTo("deferTaskNo",deferTaskVo.getDeferTaskNo());
            deferTask1 = deferTaskRepository.selectOneByExample(example);
        }
        //合同号不能未空
        if(StringUtils.isTrimBlank(deferTaskVo.getContNo())){
            if(StringUtils.isTrimBlank(deferTaskVo.getDeferTaskNo())){
                throw new FmsServiceException("获取合同信息失败");
            }else{
                if(deferTask1 != null){
                    deferTaskVo.setContNo(deferTask1.getContNo());
                }else{
                    throw new FmsServiceException("获取合同信息失败");
                }
            }
        }
        //当前合同信息
        DeferTaskVo deferTask = deferTaskRepository.selectDeferTaskVoByContNo(deferTaskVo);
        if(deferTask != null){
            //已还款信息
            ContRepaySkedAlreadyPayInfoVo contRepaySkedAlreadyPayInfoVo =   commonGetRepayInfoService.commonGetRepayInfo(deferTask.getContNo());
            if(contRepaySkedAlreadyPayInfoVo != null){
                deferTask.setAlreadyPayAmount(contRepaySkedAlreadyPayInfoVo.getAlreadyRepayAmount());
                deferTask.setAlreadyPayPeriod(contRepaySkedAlreadyPayInfoVo.getAlreadyRepayNper());
            }
        }
        //如果taskId存在，查找展期附件和展期任务信息
        //if(StringUtils.isNotTrimBlank(deferTaskVo.getTaskId())){
        if(StringUtils.isNotTrimBlank(deferTaskVo.getDeferTaskNo())){
            deferTask.setInterestRate(deferTask1.getInterestRate()); //利率
            deferTask.setDeferMaturity(deferTask1.getDeferMaturity()); //展期期限
            deferTask.setRent(deferTask1.getRent()); //月供
            deferTask.setIrr(deferTask1.getIrr()); //irr
            deferTask.setDeferDeposit(deferTask1.getDeferDeposit());//展期保证金
            deferTask.setBackDeposit(deferTask1.getBackDeposit()); //退还保证金
            //申请附件
            deferTask.setBizFilesList(bizFilesService.findBizFilesList(deferTaskVo.getDeferTaskNo(), BizCodeTypeEnums.DEFER_CONTRACT_FILE.getCodeType())); //申请附件信息
            //取得合同文件需要设值的项目
            Map<String,String> contractPdfVarsMap = getVariablesMap(deferTaskVo);
            //规则引擎取得合同模板
            RuleContractTemplateVo ruleTemplateVo = new RuleContractTemplateVo();
            ruleTemplateVo.setLicenseAttr(contractPdfVarsMap.get("licenseAttr"));
            ruleTemplateVo.setWithinGroup(contractPdfVarsMap.get("withinGroup"));
            ruleTemplateVo.setVehicleType2(contractPdfVarsMap.get("vehicleType2"));
            ruleTemplateVo.setProduct(contractPdfVarsMap.get("product"));

            commonRuleService.get(ruleTemplateVo, RuleTypeEnums.CONTRACT.getType(),RuleTypeEnums.CONTRACT.getKey());
            String contractType = ruleTemplateVo.getTemplate();
            StringBuffer bizCodeType =  new StringBuffer(contractType);
            bizCodeType.append("_ZQ");
            //设置附件类型
            deferTask.setFileType(bizCodeType.toString());
            //合同生成附件
            deferTask.setContractGenerateFileList(bizFilesService.findBizFilesList(deferTaskVo.getDeferTaskNo(), bizCodeType.toString())); //生成合同附件
            //合同打印附件
            deferTask.setContractPrintFileList(bizFilesService.findBizFilesList(deferTaskVo.getDeferTaskNo(), BizCodeTypeEnums.DEFER_CONTRACT_PRINT_FILE.getCodeType())); //合同打印附件信息
            //收付款信息
            this.setContPayInfo(deferTask,deferTaskVo.getDeferTaskNo());
        }
        //}
        return deferTask;
    }

    /**
     * @Title:
     * @Description:  获取付款信息
     * @param deferTaskVo
     * @return DeferTaskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-8 14:35:16
     */
    private void setContPayInfo(DeferTaskVo deferTaskVo,String taskNo){
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",taskNo).andEqualTo("paymentType",BizTypeEnums.DEFER_CONTRACT.getType());
        ContPay contPay = contPayRepository.selectOneByExample(example);
        if(contPay != null){
            deferTaskVo.setPayAccBranch(contPay.getPayAccBranch());
            deferTaskVo.setPayAccBank(contPay.getPayAccBank());
            deferTaskVo.setPayAccountName(contPay.getPayAccountName());
            deferTaskVo.setPayAccountNo(contPay.getPayAccountNo());
            deferTaskVo.setRecAccBank(contPay.getRecAccBank());
            deferTaskVo.setRecAccountName(contPay.getRecAccountName());
            deferTaskVo.setRecAccountNo(contPay.getRecAccountNo());
        }
    }

    /**
     * @Title:
     * @Description: 展期合同生成
     * @param deferTaskVo 展期实体Vo
     * @param  sysUser 当前登陆用户信息
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @Override
    @Transactional
    public void generateDeferContract(DeferTaskVo deferTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActDeferTaskUtils.approvalAgree(deferTaskVo.getTaskId());
        //合同生成
        saveContcreate(deferTaskVo);
        //日志保存
        saveWorkFlowLog(deferTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新展期任务信息
        updateDeferTaskInfo(deferTaskVo,actRuTaskVo);
    }

    /**
     * 合同信息
     */
    private void saveContcreate(DeferTaskVo deferTaskVo){
        //取得合同文件需要设值的项目
        Map<String,String> contractPdfVarsMap = getVariablesMap(deferTaskVo);

        //取得合同信息
        //根据contNo获取applyNo
        Example example1 = SqlUtil.newExample(Contract.class);
        example1.createCriteria().andEqualTo("contNo",deferTaskVo.getContNo());
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
        bizCodeType.append("_ZQ");
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
                pdfFile = contractRepaySkedPdf(contract.getContNo(), basFileType.getFileType(),deferTaskVo);

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
                                saveBizfies( bizFilesPer, bizFilesList, deferTaskVo,contractType, basFileType,pdfFile);
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
                                saveBizfies( bizFilesComp, bizFilesList, deferTaskVo,contractType, basFileType,pdfFile);
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
                saveBizfies( bizFiles, bizFilesList, deferTaskVo,contractType, basFileType,pdfFile);
            }else {
                if(!basFileType.getFileTypeExpr().contains("guaCompFlag")&&!basFileType.getFileTypeExpr().contains("guaPersFlag")){
                    saveBizfies( bizFiles, bizFilesList, deferTaskVo,contractType, basFileType,pdfFile);
                }
            }
        }
        //合同车辆融资信息
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(deferTaskVo.getContNo());
        //保存补充协议
        saveDeferBcxy(deferTaskVo,bizFilesList,contract);
        if(bizFilesList.size()>0){
            bizFilesService.modifyBizFilesList(bizFilesList,deferTaskVo.getDeferTaskNo(),bizCodeType.toString());
        }
    }

    /*
 取得合同文件pdf需要设值的动态项目
  */
    private Map<String,String> getVariablesMap(DeferTaskVo deferTaskVo) {
        //转换为map
        Map<String,String> varsMap = new HashMap<>();
        //合同信息
        ContractVo contractVo = contractService.findContractVoByContractNo(deferTaskVo.getContNo());

        //个人客户信息
        CstmPerson oldCstmPerson = cstmPersonService.findCstmPersonByApplyNo(contractVo.getApplyNo());
        //企业客户信息
        CstmCompany oldCstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(contractVo.getApplyNo());
        //联系人信息
        List<CstmContact> oldCstmContactList = cstmContactService.findCstmContactsByApplyNo(contractVo.getApplyNo());
        //客户地址信息
        CstmPersAddr oldCstmPersAddr = cstmPersAddrService.findCstmPersAddrByApplyNo(contractVo.getApplyNo());


        //合同融资信息
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(deferTaskVo.getContNo());

        //合同车辆融资信息
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(deferTaskVo.getContNo());
        //融资费用明细
        List<ContFinDetailVo> contFinDetailVoList = contractVehicleVo.getContFinDetailVoList();
        //股东信息
        List<StockAssets> stockAssetsList = stockAssetsService.findStockAssetsListByApplyNo(contractVo.getApplyNo());
        //变更后客户个人信息
        //CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(changeLesseeTaskVo.getTaskNo());
        //变更后取得客户地址信息
        //CstmPersAddr cstmPersAddr = cstmPersAddrService.findCstmPersAddrByApplyNo(changeLesseeTaskVo.getTaskNo());

        //变更后客户企业信息
        //CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(changeLesseeTaskVo.getTaskNo());
        //变更后企业股东信息
        //List<StockAssets> stockAssetsList = stockAssetsService.findStockAssetsListByApplyNo(changeLesseeTaskVo.getTaskNo());

        //担保人信息
        //客户保证人信息
        List<GuaranteePers> guaranteePersList = guaranteePersService.findGuaranteePersByApplyNo(contractVo.getApplyNo());
        //客户保证企业信息
        List<GuaranteeComp> guaranteeCompList = guaranteeCompService.findGuaranteeCompsByApplyNo(contractVo.getApplyNo());

        //共同借款人信息
        List<CommonBorrower> commonBorrowerList = commonBorrowerService.findCommonBorrowersByApplyNo(contractVo.getApplyNo());
        //联系人信息
        //List<CstmContact> cstmContactList = cstmContactService.findCstmContactsByApplyNo(changeLesseeTaskVo.getTaskNo());

        if(StringUtils.isNotTrimBlank(oldCstmCompany)){
            varsMap = JsonUtils.objectToMap(contractVo,contractFinanceVo,contractVehicleVo,oldCstmCompany);
            varsMap.put("identificationNumber",oldCstmCompany.getSocialCertifNo());
            varsMap.put("resideAddr",oldCstmCompany.getRegisterAddr());
            setStockAssetsVarsMap(stockAssetsList,varsMap);
            varsMap.put("lesseeContact",oldCstmCompany.getContactName());
            varsMap.put("lesseePhone",oldCstmCompany.getCompTel());
            varsMap.put("certifType","统一社会信用代码");
        }else{
            varsMap = JsonUtils.objectToMap(contractVo,contractFinanceVo,contractVehicleVo,oldCstmPerson,oldCstmPersAddr);
            //证件类型(取字典值)
            String certifTypeName = commonConstantService.findSysCodeValueName("certifType", oldCstmPerson.getCertifType());
            varsMap.put("certifType",certifTypeName);
            varsMap.put("identificationNumber",oldCstmPerson.getCertifNo());
            varsMap.put("lesseePhone",oldCstmPerson.getMobileNo());
        }
        //旧的信息
//        if(StringUtils.isNotTrimBlank(oldCstmCompany)){
//            varsMap.put("oldIdentificationNumber",oldCstmCompany.getSocialCertifNo());
//            varsMap.put("oldResideAddr",oldCstmCompany.getCompAddr()); //地址信息
//            varsMap.put("oldLesseeContact",oldCstmCompany.getContactName()); //联系人
//            varsMap.put("oldLesseeContactTel",oldCstmCompany.getContactMobno()); //联系人电话
//            varsMap.put("oldLesseeName",oldCstmCompany.getName()); //乙方姓名
//            varsMap.put("oldLesseePhone",oldCstmCompany.getCompTel()); //乙方号码
//            varsMap.put("oldCertifType","统一社会信用代码");
//
//        }else{
//            //证件类型(取字典值)
//            String certifTypeName = commonConstantService.findSysCodeValueName("certifType", oldCstmPerson.getCertifType());
//            varsMap.put("oldCertifType",certifTypeName);
//            varsMap.put("oldResideAddr",oldCstmPersAddr.getResideAddr()); //地址信息
//            varsMap.put("oldIdentificationNumber",oldCstmPerson.getCertifNo()); //证件号码
//            varsMap.put("oldLesseeName",oldCstmPerson.getName()); //乙方姓名
//            varsMap.put("oldLesseePhone",oldCstmPerson.getMobileNo());  //乙方号码
//            varsMap.put("oldLesseeContact",oldCstmContactList.get(0).getName()); //联系人
//            varsMap.put("oldLesseeContactTel",oldCstmContactList.get(0).getMobileNo()); //联系人电话
//        }
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
        setCommonBorrowersMap(commonBorrowerList,varsMap,oldCstmPerson);

        //各融资项目
        setFinItemsVarsMap(contFinDetailVoList, varsMap);

        //合同编号
        setContNoVarsMap(contractVo.getContNo(),varsMap);

        //变更后联系人信息
        setCstmContactMap(oldCstmContactList,varsMap);
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

    private void saveBizfies(BizFiles bizFiles,List<BizFiles> bizFilesList,DeferTaskVo deferTaskVo,String contractType,BasFileType basFileType,String pdfFile){
        bizFiles.setBizCode(deferTaskVo.getContNo());
        bizFiles.setBizCodeType(contractType);
        bizFiles.setFileType(basFileType.getFileType());
        bizFiles.setFileName(basFileType.getFileTypeName()+deferTaskVo.getContNo()+".pdf");
        bizFiles.setFilePath(pdfFile);
        bizFilesList.add(bizFiles);
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
     *固定值设置
     */
    private void setConstant(Map<String, String> varsMap){
        varsMap.put("lessorPhone", "0592-3208899");

        //回租赁出租人账号信息
        varsMap.put("accBankFix","万量（厦门）融资租赁有限公司");
        varsMap.put("accountNoFix","129030100100305399");
        varsMap.put("accountNameFix","兴业银行厦门同安支行");
    }


    /**
     * @Description: 生成还款计划表
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/10 17:14
     */
    private String contractRepaySkedPdf(String contNo, String tplType,DeferTaskVo deferTaskVo){

        //最近未还的期数
        ContRepaySkedVo contRepaySkedVo = contRepaySkedRepository.selectContRepaySkedToBePay(contNo);

        //尾付
        ContRepaySked contRepaySkedFin = null;
        //获取合同融资信息
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);
        //期数
        int period = Integer.valueOf(contractFinanceVo.getFinPeriodType())/Integer.valueOf(contractFinanceVo.getRepayRate());

        //获取还款计划表
        List<ContRepaySked> contRepaySkedList = new ArrayList();
        contRepaySkedList = getContrepaySkedList(deferTaskVo);
        //提取尾付,尾付必定是最后一期
//        if(period+1 == contRepaySkedList.get(contRepaySkedList.size()-1).getPeriod()){
//            contRepaySkedFin = contRepaySkedList.get(contRepaySkedList.size() - 1);
//        }
        //去除首付和尾付(尾付期数：period+1)
//        contRepaySkedList = contRepaySkedList.stream().filter(s -> 0 != s.getPeriod() && period+1 != s.getPeriod()).collect(Collectors.toList());
//        if(contRepaySkedFin != null){//最后一期加上尾付金额
//            contRepaySkedList.get(contRepaySkedList.size()-1).setRentActual(BigDecimalUtils.getNotNullBigDecimal(contRepaySkedFin.getRentActual()).add(
//                    BigDecimalUtils.getNotNullBigDecimal(contRepaySkedList.get(contRepaySkedList.size()-1).getRentActual())
//            ));
//        }

        //生成划款计划表pdf
        ContractVehicleFinanceVo contractVehicleFinanceVo = contractVehicleService.findContractVehicleFinanceVoByContNo(contNo);
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(contractVehicleFinanceVo);


        //变更后客户个人信息
        CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(contractFinanceVo.getApplyNo());
        //变更后客户企业信息
        CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(contractFinanceVo.getApplyNo());
        if(StringUtils.isNotTrimBlank(cstmCompany)){
            //设置客户信息
            pdfVariables.put("name",cstmCompany.getName());
        }else{
            //设置客户信息
            pdfVariables.put("name",cstmPerson.getName());
        }

        BigDecimal totalRent = BigDecimal.ZERO;
        for(int i =  0;i < contRepaySkedList.size();i++){
            pdfVariables.put("repayDay" + ( i + 1), DateUtils.dateToStr(contRepaySkedList.get(i).getRepayDate(), DateUtils.formatStr_yyyyMMdd));
            pdfVariables.put("rent" + (i + 1), BigDecimalUtils.getNotNullString(contRepaySkedList.get(i).getRentActual()));
            totalRent = totalRent.add(contRepaySkedList.get(i).getRentActual());
        }

        pdfVariables.put("initAmount", BigDecimalUtils.getNotNullString(BigDecimal.ZERO));//首付
        //租金合计
        pdfVariables.put("totalRent", BigDecimalUtils.getNotNullString(totalRent));
        pdfVariables.put("totalRentFor", CommonUtils.change(BigDecimalUtils.getNotNullString(totalRent)));
        pdfVariables.put("contractValidDate", DateUtils.dateToStr(contRepaySkedList.get(0).getRepayDate(), DateUtils.formatStr_yyyyMMdd));//起始日期
        pdfVariables.put("lastRepayDay", DateUtils.dateToStr(DateUtils.getAddDay(DateUtils.getAddMonth(contRepaySkedList.get(contRepaySkedList.size()-1).getRepayDate(),1),"-1"), DateUtils.formatStr_yyyyMMdd));//结束日期
        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, tplType);
        return filePath;
    }

    /**
     * @Title:
     * @Description: 生成展期的还款计划表
     * @param deferTaskVo
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    private List<ContRepaySked> getContrepaySkedList(DeferTaskVo deferTaskVo){
        //取得合同融资信息，生成还款计划表
        ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(deferTaskVo.getContNo());
        //还款日取得
        String repayDay = contractFinanceVo.getRepayDay();
        if(StringUtils.isTrimBlank(repayDay)){
            throw new FmsServiceException("还款日不能为空");
        }
        //获取合同信息
        Example example  = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo",deferTaskVo.getContNo());
        Contract contract = contractRepository.selectOneByExample(example);
        //删除原来的尾付
        Example example1 = SqlUtil.newExample(ContRepaySked.class);
        example1.createCriteria().andEqualTo("contNo",deferTaskVo.getContNo()).andEqualTo("repayType", RepayTypeEnums.FINAL_AMOUNT.getType());
        //尾付的日期
        Date validateTime = contRepaySkedRepository.selectOneByExample(example1).getRepayDate();
        //contRepaySkedRepository.deleteExampleData(example1,new ContRepaySked());
        String[][] contRepaySkedArray = Financials.findmyrepaymentplan(deferTaskVo.getDeferAmount(), BigDecimal.ZERO,
                deferTaskVo.getDeferMaturity(), contractFinanceVo.getRepayRate(), BigDecimalUtils.dividePercent(deferTaskVo.getInterestRate()), contractFinanceVo.getRepayMode(), repayDay, contractFinanceVo.getRentPayMode());
        List<ContRepaySked> contRepaySkedList = new ArrayList<>();
        //期数
        int period  = Integer.valueOf(deferTaskVo.getDeferMaturity())/Integer.valueOf(contractFinanceVo.getRepayRate());
        //每期手续费
        BigDecimal charge = null;
        if(ChargePayModeEnums.INSTALMENT_CHARGE.getType().equals(contractFinanceVo.getChargePayMode())){
            charge = contractFinanceVo.getCharge().divide(new BigDecimal(period), 0, BigDecimal.ROUND_HALF_UP);
        }
        //每期返还保证金
        BigDecimal deposit = null;
        if(DepositRtnModeEnums.INSTALMENT_DEPOSIT.getType().equals(contractFinanceVo.getDepositRtnMode())){
            deposit = contractFinanceVo.getDeposit().divide(new BigDecimal(period), 0, BigDecimal.ROUND_HALF_UP);
        }

        //手续费合计
        BigDecimal chargeSum = new BigDecimal(0);
        //保证金合计
        BigDecimal depositSum = new BigDecimal(0);
        //实际租金
        BigDecimal rentActual = null;
        //原来还款的期数
        int finPeriodType = Integer.valueOf(contractFinanceVo.getFinPeriodType());
        //生成还款计划表
        for(int i=1; i< contRepaySkedArray.length; i++){
            if(!StringUtils.isTrimBlank(contRepaySkedArray[i][0])){
                ContRepaySked contRepaySked = new ContRepaySked();

                contRepaySked.setContNo(deferTaskVo.getContNo());
                contRepaySked.setPeriod(i+finPeriodType);//期数
                contRepaySkedArray[i][0] = DateUtils.getRepayDate(validateTime, repayDay, i, contractFinanceVo.getRentPayMode());
                contRepaySked.setRepayDate(DateUtils.strToDate(contRepaySkedArray[i][0], DateUtils.formatStr_yyyyMMd_NO));//还款日期


                //实际客户租金
                rentActual = new BigDecimal(contRepaySkedArray[i][1]);
//                if(ChargePayModeEnums.INSTALMENT_CHARGE.getType().equals(contractFinanceVo.getChargePayMode())){
//                    //最后一期
//                    if(i == period){
//                        charge = contractFinanceVo.getCharge().subtract(chargeSum);
//                    }
//                    contRepaySked.setCharge(charge);
//                    rentActual = rentActual.add(charge);
//                    chargeSum = chargeSum.add(charge);
//                }
//                if(DepositRtnModeEnums.INSTALMENT_DEPOSIT.getType().equals(contractFinanceVo.getDepositRtnMode())){
//                    //最后一期
//                    if(i == period){
//                        deposit = contractFinanceVo.getDeposit().subtract(depositSum);
//                    }
//                    contRepaySked.setDeposit(deposit);
//                    rentActual = rentActual.subtract(deposit);
//                    depositSum = depositSum.add(deposit);
//                }

                //成交日期
                contRepaySked.setDealDate(DateUtils.getNowDate());
                contRepaySked.setRent(new BigDecimal(contRepaySkedArray[i][1]));//每期客户租金
                contRepaySked.setPrincipal(new BigDecimal(contRepaySkedArray[i][2]));//当期本金
                contRepaySked.setInterest(new BigDecimal(contRepaySkedArray[i][3]));//当期利息
                contRepaySked.setRestPrincipal(new BigDecimal(contRepaySkedArray[i][4]));//当期剩余本金;
                contRepaySked.setIntrstMonthRate(new BigDecimal(contRepaySkedArray[i][5]));//当期月利率;
                //每月牌照使用费
                if(contractFinanceVo.getLicenseFee() != null){
                    rentActual = rentActual.add(contractFinanceVo.getLicenseFee());
                }
                contRepaySked.setRentActual(rentActual);
                setContRepaySked(contRepaySked, contractFinanceVo.getContNo());
                contRepaySkedList.add(contRepaySked);
            }
        }
        return contRepaySkedList;
    }

    /**
     * @Description: 还款计划表初始值
     * @param contRepaySked
     */
    private void setContRepaySked(ContRepaySked contRepaySked, String contNo) {
        //扣款状态-待扣款
        contRepaySked.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
        //逾期状态-正常
        contRepaySked.setOverdueStatus(OverDueStatusEnums.NOT_OVERDUE.getType());
    }

    /**
     * @Description: 保存展期生成合同-补充协议
     * @param deferTaskVo
     */
    private void saveDeferBcxy(DeferTaskVo deferTaskVo,List<BizFiles> bizFilesList,Contract contract){
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(deferTaskVo);
        //赋值
        pdfVariables.put("groupName",deferTaskVo.getLessor()); //甲方
        pdfVariables.put("name",deferTaskVo.getLessee());// 乙方
        pdfVariables.put("contNo",deferTaskVo.getContNo());//合同号
        pdfVariables.put("date",DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));//当前时间
        pdfVariables.put("phase",String.valueOf(deferTaskVo.getAlreadyPayPeriod())); //已还期数
        pdfVariables.put("TailMoney",String.valueOf(deferTaskVo.getBalancePayment())); //尾款
        pdfVariables.put("TailMoney1",String.valueOf(deferTaskVo.getBalancePayment())); //尾款
        pdfVariables.put("contNo2",(deferTaskVo.getContNo()+"-ZQ"));
        //pdf路径
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.BCXY_WKZQ.getType());
        //根据文件类型取得 合同附件类型
//        List<BasFileType> basFileTypeList = new ArrayList<>();
//        try {
//            basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE.getCodeType()));
//        }catch (FmsRpcException ex){
//            log.error(ex.getMessage());
//            ex.printStackTrace();
//            throw new FmsServiceException("合同附件类型取得失败");
//        }
        //List<BizFiles> bizFilesList = new ArrayList<>();
        //for(BasFileType basFileType:basFileTypeList){
            //if(basFileType.getFileType().equals(BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE_1.getCodeType())){
                StringBuffer bizCodeType =  new StringBuffer(contract.getContractFileType());
                bizCodeType.append("_ZQ");
                BizFiles bizFiles = new BizFiles();
                bizFiles.setBizCode(deferTaskVo.getDeferTaskNo());
                bizFiles.setBizCodeType(bizCodeType.toString());
                bizFiles.setFileType("bcxy_ZQ");
                bizFiles.setFileName(contract.getContNo()+"补充协议"+".pdf");
                bizFiles.setFilePath(filePath);
                bizFilesList.add(bizFiles);
           // }
        //}
        //bizFilesService.modifyBizFilesList(bizFilesList,deferTaskVo.getDeferTaskNo(),BizCodeTypeEnums.DEFER_CONTRACT_GENERATE_FILE.getCodeType());
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
    private void saveWorkFlowLog(DeferTaskVo deferTaskVo, ActRuTaskVo actRuTaskVo, String actType, SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(deferTaskVo.getDeferTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.DEFER_CONTRACT.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(deferTaskVo.getMemo());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 更新展期任务表信息
     * @param
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-17 14:35:16
     */
    @Transactional
    private void updateDeferTaskInfo(DeferTaskVo deferTaskVo, ActRuTaskVo actRuTaskVo) {
        //更新任务表
        deferTaskVo.setDeferTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        deferTaskVo.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点人
        Example example = SqlUtil.newExample(DeferTask.class);
        example.createCriteria().andEqualTo("deferTaskNo",deferTaskVo.getDeferTaskNo());
        deferTaskRepository.updateByExampleSelectiveData(deferTaskVo.getEntity(),example);
    }
}
