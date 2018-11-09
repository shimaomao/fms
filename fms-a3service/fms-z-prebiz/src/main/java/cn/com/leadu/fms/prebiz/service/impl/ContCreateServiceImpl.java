package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.CommonPdfUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.*;
import cn.com.leadu.fms.business.service.impl.CommonPdfServiceImpl;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BankOrganizationTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.LicenseIdxEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.RentPayModeEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.common.vo.PdfCreateVo;
import cn.com.leadu.fms.data.baseinfo.repository.BasSalesRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.LicenseIdxRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasRepayRule;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleContractTemplateVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountVo;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import cn.com.leadu.fms.common.constant.enums.finance.PaymentTypeEnums;
import cn.com.leadu.fms.business.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.business.rpc.system.SysTplTypesRpc;
import cn.com.leadu.fms.prebiz.rpc.baseinfo.BasBankInfoRpc;
import cn.com.leadu.fms.prebiz.rpc.baseinfo.BasRepayRuleRpc;
import cn.com.leadu.fms.prebiz.service.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;
import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.CONTRACT_NUM_TYPE;

/**
 * @author huchenghao
 * @ClassName: ContCreateServiceImpl
 * @Description: 合同生成确认业务实现层
 * @date 2018-03-23
 */
@Slf4j
@Service
public class ContCreateServiceImpl implements ContCreateService{
    @Autowired
    private BasRepayRuleRpc basRepayRuleRpc;
    @Autowired
    private CstmPersAddrService cstmPersAddrService;
    @Autowired
    private ContractFinanceService contractFinanceService;
    @Autowired
    private ContractVehicleService contractVehicleService;
    @Autowired
    private ContReceiptPayService contReceiptPayService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private CstmPersonService cstmPersonService;
    @Autowired
    private CstmCompanyService cstmCompanyService;
    @Autowired
    private ContRepayAccountService contRepayAccountService;

    @Autowired
    private WorkflowLogService workflowLogService;

    @Autowired
    private BizFilesService bizFilesService;

    @Autowired
    private BasFileTypeRpc basFileTypeRpc;

    @Autowired
    private CommonPdfService commonPdfService;

    @Autowired
    private CommonRuleService commonRuleService;

    @Autowired
    private BasBankInfoRpc basBankInfoRpc;

    @Autowired
    private GuaranteePersService guaranteePersService;

    @Autowired
    private GuaranteeCompService guaranteeCompService;

    @Autowired
    private StockAssetsService stockAssetsService;
    /**
     * @Fields  :
     */
    @Autowired
    private CommonConstantService  commonConstantService;

    /**
     * @Fields  :共同借款人信息
     */
    @Autowired
    private CommonBorrowerService commonBorrowerService;

    @Autowired
    private LicenseIdxRepository licenseIdxRepository;

    /**
     * @Fields  :实际销售方Repository
     */
    @Autowired
    private BasSalesRepository basSalesRepository;

    /**
     * @Title:
     * @Description:  通过合同查询
     * @param contNo  合同号
     * @throws
     * @author huchenghao
     * @date 2018-3-23 18:30:19
     */
    public ContCreateVo findContCreateByContNo(String contNo){
        ContCreateVo contCreateVo = contractService.findContCreateDetailByContNo(contNo);
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(contNo);
        contCreateVo.setSaleGroupCode(contractVehicleVo.getSaleGroupCode());
        contCreateVo.setSaleGroupName(contractVehicleVo.getSaleGroupName());
        contCreateVo.setColor(contractVehicleVo.getCarAppearance());//车辆颜色
        //构造定金默认参数
        contCreateVo.setVehDeposit(contCreateVo.getVehDeposit() == null ? BigDecimal.ZERO : contCreateVo.getVehDeposit());
        contCreateVo.setDeductibleFees(StringUtils.isTrimBlank(contCreateVo.getDeductibleFees()) ? "" : contCreateVo.getDeductibleFees());
//        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contNo);
//        contCreateVo.setContNo(contNo);
//        contCreateVo.setApplyNo(contractFinanceVo.getApplyNo());
//        contCreateVo.setInitPerc(contractFinanceVo.getInitPerc());
//        contCreateVo.setInitAmount(contractFinanceVo.getInitAmount());
//        contCreateVo.setDepositPerc(contractFinanceVo.getDepositPerc());
//        contCreateVo.setDeposit(contractFinanceVo.getDeposit());
//        contCreateVo.setFinTotal(contractFinanceVo.getFinTotal());
//        contCreateVo.setInvestTotal(contractFinanceVo.getInvestTotal());
        if(StringUtils.isNotTrimBlank(contCreateVo.getBelonGroup())) {//用户代码不为空
            //取出用户区域数据
            String paramValue = commonConstantService.findSysParamValue(CommonParamConstants.USER_REGION_CONSTANT);
            String[] paramValues = paramValue.split(",");
            for (int code = 0; code < paramValues.length; code++) {
                 if(contCreateVo.getBelonGroup().equals(paramValues[code])){
                     contCreateVo.setSyspambelonGroup(paramValues[code]);
                     break;
                 }
            }
        }
        return contCreateVo;
    }

    /**
     * @Title:
     * @Description:  通过合同查询详情
     * @param contNo  合同号
     * @throws
     * @author huchenghao
     * @date 2018-3-23 18:30:19
     */
    public ContCreateVo findContCreateDetailByContNo(String contNo){
        ContCreateVo contCreateVo = contractService.findContCreateDetailByContNo(contNo);
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(contNo);
        contCreateVo.setSaleGroupCode(contractVehicleVo.getSaleGroupCode());
        contCreateVo.setSaleGroupName(contractVehicleVo.getSaleGroupName());
//        contCreateVo.setInitPerc(BigDecimalUtils.multiplyPercent(contCreateVo.getInitPerc()));
//        contCreateVo.setDepositPerc(BigDecimalUtils.multiplyPercent(contCreateVo.getDepositPerc()));
        // 取得附件信息
        Contract contract = contractService.findContractByContractNo(contNo);
        if(StringUtils.isTrimBlank(contract.getContractFileType())){
            throw new FmsServiceException("未获取到合同模板类型!");
        }
        contCreateVo.setFileType(contract.getContractFileType());
        contCreateVo.setBizFilesList(bizFilesService.findBizFilesList(contNo,contract.getContractFileType()));
//        CommonBizFilesVo bizFilesVo  = bizFilesService.findBizFilesByBizCode(contNo, contract.getContractFileType());
//        contCreateVo.setBizFilesVo(bizFilesVo);
        return contCreateVo;
    }
    /**
     * @Title:
     * @Description:  保存合同信息
     * @param contCreateVo  合同
     * @throws
     * @author huchenghao
     * @date 2018-4-2 18:30:19
     */
    @Transactional
    public void saveContCreate(ContCreateVo contCreateVo){
        /*//验证车架号
        boolean validVinNoResult = contractService.validVinNo(contCreateVo.getContNo(),contCreateVo.getVinNo());
        if(validVinNoResult){
            throw new FmsServiceException("车架号已存在");
        }*/

        //工作流处理
        ActRuTaskVo actRuTaskVo =  ActContractGenerationUtils.approvalAgree(contCreateVo.getTaskId());

        //更新合同生成项目
        Contract contractUpd = new Contract();
        contractUpd.setColor(contCreateVo.getColor());
        contractUpd.setVinNo(contCreateVo.getVinNo());
        contractUpd.setEngineNo(contCreateVo.getEngineNo());
        contractUpd.setGroupCode(contCreateVo.getGroupCode());
        contractUpd.setGroupBankNo(contCreateVo.getGroupBankNo());
        contractUpd.setLicenseIdxNo(contCreateVo.getLicenseIdxNo());

        //根据合同编号取得合同信息
        Contract contract = contractService.findContractByContractNo(contCreateVo.getContNo());
        if(contract == null){
            throw new FmsServiceException( "合同信息不存在");
        }
        //更新该合同中指标编号对应的指标信息(数据库合同中指标编号不为空并且合同是多次生成与选取指标编号不一致)
        if (StringUtils.isNotTrimBlank(contract.getLicenseIdxNo()) && !contract.getLicenseIdxNo().equals(contCreateVo.getLicenseIdxNo())) {
            Example example = new Example(LicenseIdx.class);
            example.createCriteria().andEqualTo("licenseIdxNo", contract.getLicenseIdxNo());
            LicenseIdx LicenseIdx = licenseIdxRepository.selectOneByExample(example);
            LicenseIdx.setLicenseIdxStatus(LicenseIdxEnums.ALREADYUSED.getType());//未使用
            LicenseIdx.setUseContNo(null);//合同编号
            LicenseIdx.setUseAppointDate(null);//指标预约日期
            licenseIdxRepository.updateByPrimaryKeyData(LicenseIdx);
        }
        //更新合同状态
        String contractBizStatusUpd = actRuTaskVo.getTaskCode();
        if(StringUtils.isTrimBlank(contractBizStatusUpd)){
            throw new FmsServiceException( "订单状态取得失败");
        }
        contractUpd.setBizStatus(contractBizStatusUpd);
        contractUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        contractUpd.setContractDate(new Date());//合同生成日期
        contractService.updateContractByContractId(contractUpd,contract.getContractId());

        //还款日取得
        String repayDay = contCreateVo.getRepayDay();
        ContractFinance contractFinance = new ContractFinance();
        contractFinance.setContNo(contCreateVo.getContNo());
        contractFinance.setRepayDay(repayDay);
        contractFinanceService.updateContractFinanceByContNo(contractFinance);

        //保存定金
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(contCreateVo.getContNo());
        contractVehicleVo.setVehDeposit(contCreateVo.getVehDeposit());
        contractVehicleVo.setDeductibleFees(contCreateVo.getDeductibleFees());
        contractVehicleService.modifyContractVehicleVo(contractVehicleVo);

        //保存客户还款卡信息
        ContRepayAccountVo contRepayAccountVo=new ContRepayAccountVo();
        contRepayAccountVo.setApplyNo(contCreateVo.getApplyNo());
        contRepayAccountVo.setContNo(contCreateVo.getContNo());
        contRepayAccountVo.setVehicleNo(contCreateVo.getVehicleNo());
        contRepayAccountVo.setAccountName(contCreateVo.getAccountName());
        contRepayAccountVo.setCertifNo(contCreateVo.getCertifNo());
        contRepayAccountVo.setAccMobileNo(contCreateVo.getAccMobileNo());
        contRepayAccountVo.setAccBank(contCreateVo.getAccBank());
        contRepayAccountVo.setAccountNo(contCreateVo.getAccountNo());

        //根据合同编号查询客户还款信息是否存在
        ContRepayAccount contRepayAccount= contRepayAccountService.findContRepayAccountByContNo(contCreateVo.getContNo());
        if(contRepayAccount != null){//存在则更新
            contRepayAccountVo.setRepayAccId(contRepayAccount.getRepayAccId());
            contRepayAccountService.modifyContRepayAccountByVo(contRepayAccountVo);
        }else{//不存在则插入
            contRepayAccountService.saveContRepayAccount(contRepayAccountVo);
        }

//        //保存财务付款信息
//        ContPay contPay = new ContPay();
//        contPay.setBizCode(contCreateVo.getContNo());
//        contPay.setPaymentType(PaymentTypeEnums.CONTREQUEST.getType());
//        contPay.setRecAccBank(contCreateVo.getRecAccBank());
//        contPay.setRecAccountNo(contCreateVo.getRecAccountNo());
//        contPay.setRecAccountName(contCreateVo.getRecAccountName());
//        contPayService.updateContPayByBizCodeAndPaymentType(contPay);

        //取得合同文件需要设值的项目
        Map<String,String> contractPdfVarsMap = getVariablesMap(contCreateVo);

        //规则引擎取得合同模板
        RuleContractTemplateVo ruleTemplateVo = new RuleContractTemplateVo();
        ruleTemplateVo.setLicenseAttr(contractPdfVarsMap.get("licenseAttr"));
        ruleTemplateVo.setWithinGroup(contractPdfVarsMap.get("withinGroup"));
        ruleTemplateVo.setVehicleType2(contractPdfVarsMap.get("vehicleType2"));
        ruleTemplateVo.setProduct(contractPdfVarsMap.get("product"));

        commonRuleService.get(ruleTemplateVo, RuleTypeEnums.CONTRACT.getType(),RuleTypeEnums.CONTRACT.getKey());
        String contractType = ruleTemplateVo.getTemplate();
        contractUpd.setContractFileType(contractType);

        //删除原来的附件
        bizFilesService.deleteBizFilesByBizCode(contCreateVo.getContNo(),contractType);

        List<BizFiles> bizFilesList=new ArrayList<BizFiles>();
        //根据文件类型取得 合同附件类型
        List<BasFileType> basFileTypeList = new ArrayList<>();
        try {
            basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(contractType));
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
            if(basFileType.getFileType().contains("_hkjhb")){
                //还款计划表
                pdfFile = contractRepaySkedPdf(contCreateVo.getContNo(), basFileType.getFileType());

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
                                    saveBizfies( bizFilesPer, bizFilesList, contCreateVo,contractType, basFileType,pdfFile);
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
                                    saveBizfies( bizFilesComp, bizFilesList, contCreateVo,contractType, basFileType,pdfFile);
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
               saveBizfies( bizFiles, bizFilesList, contCreateVo,contractType, basFileType,pdfFile);
           }else {
               if(!basFileType.getFileTypeExpr().contains("guaCompFlag")&&!basFileType.getFileTypeExpr().contains("guaPersFlag")){
                   saveBizfies( bizFiles, bizFilesList, contCreateVo,contractType, basFileType,pdfFile);
               }
           }
        }

        if(bizFilesList.size()>0){
            bizFilesService.saveBizFilesList(bizFilesList);
        }

        //合同日志录入
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contCreateVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contCreateVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(contCreateVo.getApplyNo());
        workflowLog.setWfLogSubNo(contCreateVo.getContNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(SUBMIT.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);

        //更新合同信息
        contractService.updateContractByContractId(contractUpd,contract.getContractId());
        //更新该合同选取的指标信息
        if (StringUtils.isNotTrimBlank(contractUpd.getLicenseIdxNo())) {
            Example example = new Example(LicenseIdx.class);
            example.createCriteria().andEqualTo("licenseIdxNo", contractUpd.getLicenseIdxNo());
            LicenseIdx LicenseIdx = licenseIdxRepository.selectOneByExample(example);
            LicenseIdx.setLicenseIdxStatus(LicenseIdxEnums.APPOINTMENT.getType());//预约中状态
            LicenseIdx.setUseContNo(contCreateVo.getContNo());//合同编号
            LicenseIdx.setUseAppointDate(new Date());//指标预约日期
            licenseIdxRepository.updateByPrimaryKeySelectiveData(LicenseIdx);
        }
    }

    /**
    * @Description: 取消合同
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/10/10 18:29
    */
    @Override
    public void cancelContCreate(ContCreateVo contCreateVo) {

        //工作流处理
        ActRuTaskVo actRuTaskVo =  ActContractGenerationUtils.approvalRefuse(contCreateVo.getTaskId());

        //更新合同生成项目
        Contract contractUpd = new Contract();
        //根据合同编号取得合同信息
        Contract contract = contractService.findContractByContractNo(contCreateVo.getContNo());
        if(contract == null){
            throw new FmsServiceException( "合同信息不存在");
        }
        //更新合同状态
        String contractBizStatusUpd = BizStatusEnums.CONTRACT_CANCEL.getType();
        if(StringUtils.isTrimBlank(contractBizStatusUpd)){
            throw new FmsServiceException( "订单状态取得失败");
        }
        contractUpd.setBizStatus(contractBizStatusUpd);
        contractUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        contractService.updateContractByContractId(contractUpd,contract.getContractId());

        //合同日志录入
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contCreateVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contCreateVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(contCreateVo.getApplyNo());
        workflowLog.setWfLogSubNo(contCreateVo.getContNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(ActTypeEnums.CANCEL.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }


    private void saveBizfies(BizFiles bizFiles,List<BizFiles> bizFilesList,ContCreateVo contCreateVo,String contractType,BasFileType basFileType,String pdfFile){
        bizFiles.setBizCode(contCreateVo.getContNo());
        bizFiles.setBizCodeType(contractType);
        bizFiles.setFileType(basFileType.getFileType());
        bizFiles.setFileName(basFileType.getFileTypeName()+contCreateVo.getContNo()+".pdf");
        bizFiles.setFilePath(pdfFile);
        bizFilesList.add(bizFiles);
    }

    /*
    取得合同文件pdf需要设值的动态项目
     */
    private Map<String,String> getVariablesMap(ContCreateVo contCreateVo) {

        //合同信息
        ContractVo contractVo = contractService.findContractVoByContractNo(contCreateVo.getContNo());

        //合同融资信息
        ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contCreateVo.getContNo());

        //合同车辆融资信息
        ContractVehicleVo contractVehicleVo = contractVehicleService.findContractVehicleVoByContNo(contCreateVo.getContNo());
        //融资费用明细
        List<ContFinDetailVo> contFinDetailVoList = contractVehicleVo.getContFinDetailVoList();

        //客户个人信息
        CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(contCreateVo.getApplyNo());
        //取得客户地址信息
        CstmPersAddr cstmPersAddr = cstmPersAddrService.findCstmPersAddrByApplyNo(contCreateVo.getApplyNo());

        //客户企业信息
        CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(contCreateVo.getApplyNo());
        //企业股东信息
        List<StockAssets> stockAssetsList = stockAssetsService.findStockAssetsListByApplyNo(contCreateVo.getApplyNo());

        //担保人信息
        //取得客户保证人信息
        List<GuaranteePers> guaranteePersList = guaranteePersService.findGuaranteePersByApplyNo(contractVo.getApplyNo());
        //取得客户保证企业信息
        List<GuaranteeComp> guaranteeCompList = guaranteeCompService.findGuaranteeCompsByApplyNo(contractVo.getApplyNo());

        //共同借款人信息
        List<CommonBorrower> commonBorrowerList = commonBorrowerService.findCommonBorrowersByApplyNo(contCreateVo.getApplyNo());

        //转换为map
        Map<String,String> varsMap = new HashMap<>();
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
        if("1".equals(contractFinanceVo.getVehicleForm())){
            varsMap.put("vehicleForm1","√");
        }else{
            varsMap.put("vehicleForm2","√");
        }

        //实际销售方
        varsMap.put("salesName",contractVehicleVo.getSaleGroupName());

        //实际销售方信息(用于心享车合同的车辆回购协议)
        if (StringUtils.isNotTrimBlank(contractVehicleVo.getSaleGroupCode())){
            Example exampleSales = SqlUtil.newExample(BasSales.class);
            exampleSales.createCriteria().andEqualTo("salesCode", contractVehicleVo.getSaleGroupCode());
            BasSales basSales = basSalesRepository.selectOneByExample(exampleSales);
            if(basSales!=null){
                //通讯地址--->注册地址
                varsMap.put("salesAddress",basSales.getRegisterAddress());
                //联系电话
                varsMap.put("salesTel",basSales.getContactTel1());
            }
        }

        //设置contCreateVo
        setContCreatVarsMap(contCreateVo, varsMap);

        //担保人信息
        setGuaranteeVarsMap(guaranteePersList,guaranteeCompList, varsMap);

        //共同借款人
        setCommonBorrowersMap(commonBorrowerList,varsMap,cstmPerson);

        //各融资项目
        setFinItemsVarsMap(contFinDetailVoList, varsMap);

        //合同编号
        setContNoVarsMap(contractVo.getContNo(),varsMap);

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
        varsMap.put("finTotalFor",CommonUtils.changeMoney(contractFinanceVo.getFinTotal()));
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
        if(contractFinanceVo.getAnnualSupplyRate().compareTo(BigDecimal.ZERO)!=0) {
            debtMoney = contractFinanceVo.getRent().multiply(new BigDecimal(contractFinanceVo.getFinPeriodType()).subtract(BigDecimalUtils.divide(new BigDecimal(contractFinanceVo.getFinPeriodType()), new BigDecimal("12"), 0))).add(
                    contractFinanceVo.getAnnualSupplyAmount().multiply(BigDecimalUtils.divide(new BigDecimal(contractFinanceVo.getFinPeriodType()), new BigDecimal("12"), 0))).add(backPurchaseMoney);
        }else {
            debtMoney = (contractFinanceVo.getRent().multiply(new BigDecimal(contractFinanceVo.getFinPeriodType()))).add(backPurchaseMoney);
        }
        varsMap.put("debtMoney",debtMoney.toString());
        varsMap.put("debtMoneyFor",CommonUtils.changeMoney(debtMoney));
        varsMap.put("debtMoney"+1,debtMoney.toString());
        varsMap.put("debtMoneyFor"+1,CommonUtils.changeMoney(debtMoney));

        //回租合同《机动车买卖合同》签订时打印"年","月","日"
        varsMap.put("ymd","年   月   日");

        //《咨询服务合同》乙方同意支付甲方服务费人民币.....(手续费+代收手续费)
        varsMap.put("chargeAndSalesCharge",contractVehicleVo.getCharge().add(contractFinanceVo.getSalesCharge()).toString());

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
        varsMap.put("contractDate",DateUtils.getCurrentDateString());
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
                (contractFinanceVo.getSalesCharge()!=null&&contractFinanceVo.getSalesCharge().compareTo(BigDecimal.ZERO)>0)){
            varsMap.put("createFlag", "1");
        }else {
            varsMap.put("createFlag", "0");
        }

        return varsMap;
    }
    /*
     *设置画面入力的参数
     */
    private void setContCreatVarsMap(ContCreateVo contCreateVo, Map<String, String> varsMap) {
        varsMap.put("engineNo",contCreateVo.getEngineNo());
        varsMap.put("vinNo",contCreateVo.getVinNo());
        varsMap.put("color", contCreateVo.getColor());
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
    private String contractRepaySkedPdf(String contNo, String tplType){
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
        BigDecimal totalRent = BigDecimal.ZERO;
        for(int i = 0;i < contRepaySkedList.size();i++){
            pdfVariables.put("repayDay" + (i + 1), DateUtils.dateToStr(contRepaySkedList.get(i).getRepayDate(), DateUtils.formatStr_yyyyMMdd));
            pdfVariables.put("rent" + (i + 1), BigDecimalUtils.getNotNullString(contRepaySkedList.get(i).getRentActual()));
            totalRent = totalRent.add(contRepaySkedList.get(i).getRentActual());
        }

        pdfVariables.put("initAmount", BigDecimalUtils.getNotNullString(contractFinanceVo.getInitAmount()));//首付
        //租金合计
        pdfVariables.put("totalRent", BigDecimalUtils.getNotNullString(totalRent.add(contractFinanceVo.getInitAmount())));
        pdfVariables.put("totalRentFor", CommonUtils.change(BigDecimalUtils.getNotNullString(totalRent.add(contractFinanceVo.getInitAmount()))));
        pdfVariables.put("contractValidDate", DateUtils.dateToStr(contRepaySkedList.get(0).getRepayDate(), DateUtils.formatStr_yyyyMMdd));//起始日期
        pdfVariables.put("lastRepayDay", DateUtils.dateToStr(DateUtils.getAddDay(DateUtils.getAddMonth(contRepaySkedList.get(contRepaySkedList.size()-1).getRepayDate(),1),"-1"), DateUtils.formatStr_yyyyMMdd));//结束日期
        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, tplType);
        return filePath;
    }
}
