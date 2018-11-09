package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActChangeLesseeUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BasAreaNameService;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.MarriageStatusEnums;
import cn.com.leadu.fms.common.constant.enums.riskmgmt.PycreditTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.ChangeLesseeTaskRepository;
import cn.com.leadu.fms.data.prebiz.repository.*;
import cn.com.leadu.fms.data.riskmgmt.repository.*;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.*;
import cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetail.AccountDetailVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskcompany.RiskCompanyVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskperson.RiskPersonVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchk.RiskTelchkVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.thirdinterface.*;
import cn.com.leadu.fms.riskmgmt.constant.CommonConstants;
import cn.com.leadu.fms.riskmgmt.rpc.prebiz.ApplyInputRpc;
import cn.com.leadu.fms.riskmgmt.rpc.thirdinterface.PyInterfaceRpc;
import cn.com.leadu.fms.riskmgmt.service.*;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
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
 * @ClassName: ApplyRiskService
 * @Description: 风控管理
 * @date 2018-06-05
 */
@Slf4j
@Service
public class ApplyRiskServiceImpl implements ApplyRiskService {
    /**
     * @Fields  : 日志业务层
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    @Autowired
    private ApplyInputRpc applyInputRpc;
    @Autowired
    private PyInterfaceRpc pyInterfaceRpc;
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
    private PycreditAntiService pycreditAntiService;
    @Autowired
    private PycreditAddrService pycreditAddrService;
    @Autowired
    private PycreditPersonBkcheckService pycreditPersonBkcheckService;
    @Autowired
    private PycreditCorpBkcheckService pycreditCorpBkcheckService;
    @Autowired
    private PycreditDriverService pycreditDriverService;
    @Autowired
    private PycreditCorpRiskService pycreditCorpRiskService;
    @Autowired
    private PycreditCorpDebtService pycreditCorpDebtService;
    @Autowired
    private CommonConstantService commonConstantService;
    /**
     * @Fields  : 客户企业基本信息repository
     */
    @Autowired
    private CstmCompanyRepository cstmCompanyRepository;
    /**
     * @Fields  : 客户个人基本信息repository
     */
    @Autowired
    private CstmPersonRepository cstmPersonRepository;
    /**
     * @Fields  : 客户个人职业信息repository
     */
    @Autowired
    private CstmPersJobRepository cstmPersJobRepository;
    /**
     * @Fields  : 客户个人地址信息repository
     */
    @Autowired
    private CstmPersAddrRepository cstmPersAddrRepository;
    /**
     * @Fields  : 购买合理性repository
     */
    @Autowired
    private RationalityPurchaseRepository rationalityPurchaseRepository;
    /**
     * @Fields  : 申请信息repository
     */
    @Autowired
    private ApplyRepository applyRepository;
    /**
     * @Fields  : 融资信息repository
     */
    @Autowired
    private ApplyFinanceRepository applyFinanceRepository;
    /**
     * @Fields  : 风控电核信息repository
     */
    @Autowired
    private RiskTelchkRepository riskTelchkRepository;
    /**
     * @Fields  : 风控企业信息repository
     */
    @Autowired
    private RiskMgmtCompRepository riskMgmtCompRepository;
    /**
     * @Fields  : 风控个人信息repository
     */
    @Autowired
    private RiskMgmtPersonRepository riskMgmtPersonRepository;
    /**
     * @Fields  : 个人风险信息repository
     */
    @Autowired
    private RiskPersonRepository riskPersonRepository;
    /**
     * @Fields  : 企业风险信息repository
     */
    @Autowired
    private RiskCompanyRepository riskCompanyRepository;
    /**
     * @Fields  : 风控担保人信息repository
     */
    @Autowired
    private RiskMgmtGuaranteeRepository riskMgmtGuaranteeRepository;
    /**
     * @Fields : 个人人行征信信息repository
     */
    @Autowired
    private PbcCreditRepository pbcCreditRepository;

    /**
     * @Fields  : 银行流水repository
     */
    @Autowired
    private AccountDetailRepository accountDetailRepository;

    /**
     * @Fields  : 银行流水明细repository
     */
    @Autowired
    private AccountDetailListRepository accountDetailListRepository;
    /**
     * @Fields  : 鹏元查询一览repository
     */
    @Autowired
    private PycreditListRepository pycreditListRepository;
    /**
     * @Fields  : 反欺诈repository
     */
    @Autowired
    private PycreditAntiRepository pycreditAntiRepository;
    /**
     * @Fields  : 地址核查repository
     */
    @Autowired
    private PycreditAddrRepository pycreditAddrRepository;
    /**
     * @Fields  : 卡核查及交易repository
     */

    /**
     * @Fields  : 个人银行卡核查repository
     */
    @Autowired
    private PycreditPersonBkcheckRepository pycreditPersonBkcheckRepository;
    /**
     * @Fields  : 企业银行卡核查repository
     */
    @Autowired
    private PycreditCorpBkcheckRepository pycreditCorpBkcheckRepository;
    /**
     * @Fields  : 驾驶证核查repository
     */
    @Autowired
    private PycreditDriverRepository pycreditDriverRepository;
    /**
     * @Fields  : 企业风险repository
     */
    @Autowired
    private PycreditCorpRiskRepository pycreditCorpRiskRepository;
    /**
     * @Fields  : 企业债务repository
     */
    @Autowired
    private PycreditCorpDebtRepository pycreditCorpDebtRepository;
    /**
     * @Fields  : 变更承租人repository
     */
    @Autowired
    private ChangeLesseeTaskRepository changeLesseeTaskRepository;
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
     * @param applyNo
     * @return ApplyRiskVo
     * @throws
     * @Title:
     * @Description: 风控初审画面初始数据(这里保存了鹏元征信数据)
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    @Transactional
    public ApplyRiskVo findApplyRiskInit(String applyNo,String flag) {
        ApplyRiskVo applyRiskVo = new ApplyRiskVo();
        //根据申请编号，取得申请信息，包括融资信息和客户基本信息
        getApplyInfo(applyNo, applyRiskVo,flag);

        //取得电话核实信息
        getRiskTelchkInfo(applyNo, applyRiskVo);

        //生成鹏元征信查询一览
        getPycreditListVoList(applyNo, applyRiskVo);

        //取得风控信息
        getRiskMgmtInfo(applyNo, applyRiskVo);

        //附件信息
        applyRiskVo.setBizFilesList(bizFilesService.findBizFilesList(applyNo,BizCodeTypeEnums.APPLY_RISK_APPROVE_FILE.getCodeType()));
//        CommonBizFilesVo bizFilesVo = bizFilesService.findBizFilesByBizCode(applyNo, BizCodeTypeEnums.APPLY_RISK_APPROVE_FILE.getCodeType());
//        if(StringUtils.isTrimBlank(bizFilesVo)){
//            applyRiskVo.setBizFilesVo(new CommonBizFilesVo());
//        }else{
//            applyRiskVo.setBizFilesVo(bizFilesVo);
//        }


        return applyRiskVo;
    }

    /**
     * @param applyRiskVo
     * @Description: 保存风控数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/6 15:34
     */
    @Override
    @Transactional
    public void saveApplyRiskInit(ApplyRiskVo applyRiskVo) {
        Apply apply = applyRiskVo.getApply();
        if(ApplyTypeEnums.COMPANY.getType().equals(apply.getApplyType())){
            //更新企业信息
            CstmCompany cstmCompany = applyRiskVo.getCstmCompany();
            cstmCompanyRepository.updateByPrimaryKeySelectiveData(cstmCompany);

            //保存公司风险信息
            saveRiskMgmtCompInfo(applyRiskVo);
        }else{//个人信息
            //更新个人基本信息
            CstmPerson cstmPerson = applyRiskVo.getCstmPerson();
            cstmPersonRepository.updateByPrimaryKeySelectiveData(cstmPerson);
            //更新个人职业信息
            CstmPersJob cstmPersJob = applyRiskVo.getCstmPersJob();
            cstmPersJobRepository.updateByPrimaryKeySelectiveData(cstmPersJob);
            //更新个人地址信息
            CstmPersAddr cstmPersAddr = applyRiskVo.getCstmPersAddr();
            cstmPersAddrRepository.updateByPrimaryKeySelectiveData(cstmPersAddr);
            //保存个人风险信息
            saveRiskMgmtPersonInfo(applyRiskVo);

        }
        //更新购车合理性
        RationalityPurchase rationalityPurchase = applyRiskVo.getRationalityPurchase();
        rationalityPurchaseRepository.updateByPrimaryKeySelectiveData(rationalityPurchase);
        //更新申请融资信息
        ApplyFinanceVo applyFinanceVo = applyRiskVo.getApplyFinanceVo();
        if(applyFinanceVo != null){
            applyFinanceRepository.updateByPrimaryKeySelectiveData(applyFinanceVo.getEntity());
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getRiskTelchkVoList())){
            //更新或插入风控电核信息
            List<RiskTelchkVo> riskTelchkVoList = applyRiskVo.getRiskTelchkVoList();
            List<RiskTelchk> riskTelchkList = new ArrayList<>();
            for(RiskTelchkVo riskTelchkVo:riskTelchkVoList){
                RiskTelchk riskTelchk = EntityUtils.getEntity(riskTelchkVo, new RiskTelchk());
                riskTelchk.setApplyNo(apply.getApplyNo());
                riskTelchkList.add(riskTelchk);
            }
            if(StringUtils.isNotTrimBlank(riskTelchkVoList.get(0).getRiskTelchkId())){
                //如果id不为空，更新数据
                riskTelchkRepository.updateByPrimaryKeySelectiveDataList(riskTelchkList);
            }else{//插入电核数据
                riskTelchkRepository.insertDataList(riskTelchkList);
            }
        }
        //保存银行流水信息
        this.saveAccountDetail(applyRiskVo);

        //更新附件信息
        if(!StringUtils.isTrimBlank(applyRiskVo.getBizFilesList())){
            bizFilesService.modifyBizFilesList(applyRiskVo.getBizFilesList(),applyRiskVo.getApply().getApplyNo(),
                    BizCodeTypeEnums.APPLY_RISK_APPROVE_FILE.getCodeType());
        }

        if(YesNoFlagEnums.YES.getType().equals(applyRiskVo.getSaveFlag())){
            if(StringUtils.equals(YesNoFlagEnums.YES.getType(),applyRiskVo.getIsChangeLessee())){
                //承租人变更流程
                ActRuTaskVo actRuTaskVo =  ActChangeLesseeUtils.approvalAgree(applyRiskVo.getTaskId());
                //保存日志信息
                this.saveWorkFlowLog(actRuTaskVo,applyRiskVo,ActTypeEnums.APPROVAL.getType(),applyRiskVo.getUser());
            }else{
                //流程引擎，提交下一步
                ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(applyRiskVo.getTaskId());
                //保存日志，更新状态
                approveCommon(applyRiskVo, ActTypeEnums.APPROVAL.getType(), actRuTaskVo);
            }
           }

    }
    /**
     * @param applyNo
     * @param applyRiskVo
     * @return ApplyRiskVo
     * @throws
     * @Title:
     * @Description: 取得风险信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskMgmtInfo(String applyNo, ApplyRiskVo applyRiskVo) {
        //申请类型
        String applyType = applyRiskVo.getApply().getApplyType();

        applyRiskVo.setRiskPersonVoGuarList(new ArrayList<RiskPersonVo>());
        applyRiskVo.setRiskPersonVoBorrList(new ArrayList<RiskPersonVo>());
        applyRiskVo.setRiskCompanyVoGuarList(new ArrayList<RiskCompanyVo>());
        applyRiskVo.setAccountDetailVoList(new ArrayList<AccountDetailVo>());
        applyRiskVo.setRiskPersonVoGuMateList(new ArrayList<RiskPersonVo>());
        applyRiskVo.setRiskMgmtGuaranteeList(new ArrayList<RiskMgmtGuarantee>());

        if (ApplyTypeEnums.COMPANY.getType().equals(applyType)) {
            getRiskMgmtCompInfo(applyNo, applyRiskVo);
        } else {
            getRiskMgmtPersInfo(applyNo, applyRiskVo);
        }
    }

    /**
     * @param applyRiskVo
     * @return ApplyRiskVo
     * @throws
     * @Title:
     * @Description: 取得个人/企业风险信息的共通处理
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskCommon(ApplyRiskVo applyRiskVo) {
        //担保人银行流水
        if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getGuaranteePersList())){
            for(int i=0; i<applyRiskVo.getGuaranteePersList().size(); i++){
                AccountDetailVo accountDetailVo = new AccountDetailVo();
                accountDetailVo.setName(applyRiskVo.getGuaranteePersList().get(i).getName());
                accountDetailVo.setRelation(GUARANTEE_PERSON.getCode());
                accountDetailVo.setAccountDetailLists(getAccountDetailListNew());
                accountDetailVo.setApplyNo(applyRiskVo.getApply().getApplyNo());
                applyRiskVo.getAccountDetailVoList().add(accountDetailVo);

                //担保人
                RiskMgmtGuarantee riskMgmtGuarantee =  new RiskMgmtGuarantee();
                riskMgmtGuarantee.setGuaranteeName(applyRiskVo.getGuaranteePersList().get(i).getName());
                riskMgmtGuarantee.setApplyNo(applyRiskVo.getApply().getApplyNo());
                applyRiskVo.getRiskMgmtGuaranteeList().add(riskMgmtGuarantee);
            }
        }
        //担保企业风险信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getGuaranteeCompList())){
            for(int i=0; i<applyRiskVo.getGuaranteeCompList().size(); i++){
                RiskCompanyVo riskCompanyVo = new RiskCompanyVo();
                riskCompanyVo.setName(applyRiskVo.getGuaranteeCompList().get(i).getName());
                riskCompanyVo.setRelation(GUARANTEE_COMPANY.getCode());
                riskCompanyVo.setApplyNo(applyRiskVo.getApply().getApplyNo());
                //地址匹配
                String belongCity = applyRiskVo.getApplyFinanceVo().getGroupDistrict();
                String compCity = commonConstantService.findBasAreaName(applyRiskVo.getGuaranteeCompList().get(i).getCompCity());
                if(StringUtils.equals(belongCity,compCity))
                    riskCompanyVo.setApplyAddrMatch("一致");
                else
                    riskCompanyVo.setApplyAddrMatch("不一致");
                applyRiskVo.getRiskCompanyVoGuarList().add(riskCompanyVo);

                AccountDetailVo accountDetailVo = new AccountDetailVo();
                accountDetailVo.setName(applyRiskVo.getGuaranteeCompList().get(i).getName());
                accountDetailVo.setRelation(GUARANTEE_COMPANY.getCode());
                accountDetailVo.setAccountDetailLists(getAccountDetailListNew());
                accountDetailVo.setApplyNo(applyRiskVo.getApply().getApplyNo());
                applyRiskVo.getAccountDetailVoList().add(accountDetailVo);

                RiskMgmtGuarantee riskMgmtGuarantee =  new RiskMgmtGuarantee();
                riskMgmtGuarantee.setGuaranteeName(applyRiskVo.getGuaranteeCompList().get(i).getName());
                riskMgmtGuarantee.setApplyNo(applyRiskVo.getApply().getApplyNo());
                applyRiskVo.getRiskMgmtGuaranteeList().add(riskMgmtGuarantee);
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
    private void saveRiskMgmtPersonInfo(ApplyRiskVo applyRiskVo){
        String applyNo = applyRiskVo.getApply().getApplyNo();
        //风控个人信息
        RiskMgmtPerson riskMgmtPersonOld = riskMgmtPersonService.findRiskMgmtPersonByApplyNo(applyNo);
        //当前申请编号的风控信息存在
        if(riskMgmtPersonOld != null){
            //保存风控个人(承租个人)信息
            RiskMgmtPerson riskMgmtPerson = applyRiskVo.getRiskMgmtPerson();
            riskMgmtPersonRepository.updateByPrimaryKeySelectiveData(riskMgmtPerson,true);

            List<RiskPersonVo> commonBorrowerList= applyRiskVo.getRiskPersonVoBorrList();

            //保存风控担保人信息
            List<RiskMgmtGuarantee> riskMgmtGuaranteeList = applyRiskVo.getRiskMgmtGuaranteeList();
            for (RiskMgmtGuarantee riskMgmtGuarantee : riskMgmtGuaranteeList){
                if(StringUtils.isNotTrimBlank(riskMgmtGuarantee.getRiskMgmtGuaranteeId()))
                    riskMgmtGuaranteeRepository.updateByPrimaryKeySelectiveData(riskMgmtGuarantee);
                else
                    riskMgmtGuaranteeRepository.insertData(riskMgmtGuarantee);
            }

            //保存承租人风险信息
            riskPersonRepository.updateByPrimaryKeySelectiveData(applyRiskVo.getRiskPersonVoMain().getEntity());
            //保存承租人征信信息
            pbcCreditRepository.updateByPrimaryKeySelectiveData(applyRiskVo.getRiskPersonVoMain().getPbcCredit());
            //保存担保企业风险信息
            for(RiskCompanyVo riskCompanyVo : applyRiskVo.getRiskCompanyVoGuarList()){
                if (GUARANTEE_COMPANY.getCode().equals(riskCompanyVo.getRelation())) {
                    //担保企业的风险信息
                    if(StringUtils.isNotTrimBlank(riskCompanyVo.getRiskCompanyId()))
                        riskCompanyRepository.updateByPrimaryKeySelectiveData(riskCompanyVo.getEntity());
                    else
                      riskCompanyRepository.insertData(riskCompanyVo.getEntity());
                }
            }
            //保存担保人风险信息
            for(RiskPersonVo riskPersonVo : applyRiskVo.getRiskPersonVoGuarList()){
                if (GUARANTEE_PERSON.getCode().equals(riskPersonVo.getRelation())) {
                    //保存担保人风险信息
                    if(StringUtils.isNotTrimBlank(riskPersonVo.getRiskPersonId()))
                        riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVo.getEntity());
                    else
                        riskPersonRepository.insertData(riskPersonVo.getEntity());
                }
            }

            //保存担保人配偶风险信息
            if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getRiskPersonVoGuMateList())){
                for(RiskPersonVo riskPersonVoMate : applyRiskVo.getRiskPersonVoGuMateList()){
                    //保存担保人配偶风险信息
                    if(StringUtils.isNotTrimBlank(riskPersonVoMate.getRiskPersonId()))
                        riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVoMate.getEntity());
                    else
                        riskPersonRepository.insertData(riskPersonVoMate.getEntity());
                }
            }

            //保存共同借款人人风险信息
            for(RiskPersonVo riskPersonVo : applyRiskVo.getRiskPersonVoBorrList()){
                if (COMMON_BORR.getCode().equals(riskPersonVo.getRelation())) {
                    if(StringUtils.isNotTrimBlank(riskPersonVo.getRiskPersonId()))
                        riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVo.getEntity());
                    else
                        riskPersonRepository.insertData(riskPersonVo.getEntity());
//                    riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVo.getEntity());
                }
            }

        }else{
            //当前申请编号的风控信息不存在
            //保存风控个人(主贷人)信息
            riskMgmtPersonRepository.insertData(applyRiskVo.getRiskMgmtPerson());
            //保存主贷人风险信息（插入）
            riskPersonRepository.insertData(applyRiskVo.getRiskPersonVoMain().getEntity());
            //保存承租人人行征信信息
            pbcCreditRepository.insertData(applyRiskVo.getRiskPersonVoMain().getPbcCredit());
            //担保人风险信息
            if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getRiskPersonVoGuarList())){
                for(RiskPersonVo riskPersonVo : applyRiskVo.getRiskPersonVoGuarList()){
                    if (GUARANTEE_PERSON.getCode().equals(riskPersonVo.getRelation())) {
                        //保存担保人风险信息
                        riskPersonRepository.insertData(riskPersonVo.getEntity());
                    }
                }
            }
            //担保人配偶风险信息
            if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getRiskPersonVoGuMateList())){
                for(RiskPersonVo riskPersonVoMate : applyRiskVo.getRiskPersonVoGuMateList()){
                    //保存担保人风险信息
                    riskPersonRepository.insertData(riskPersonVoMate.getEntity());
                }
            }
            //保存风控担保人信息
            riskMgmtGuaranteeRepository.insertDataList(applyRiskVo.getRiskMgmtGuaranteeList());

            //保存担保企业风险信息
            for(RiskCompanyVo riskCompanyGuarVo : applyRiskVo.getRiskCompanyVoGuarList()){
                riskCompanyRepository.insertData(riskCompanyGuarVo.getEntity());
            }

            //保存共同借款人人风险信息
            for(RiskPersonVo riskPersonVo : applyRiskVo.getRiskPersonVoBorrList()){
                if (COMMON_BORR.getCode().equals(riskPersonVo.getRelation())) {
                    riskPersonRepository.insertData(riskPersonVo.getEntity());
                }
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
    private void saveAccountDetail(ApplyRiskVo applyRiskVo) {
        for(AccountDetailVo accountDetailVo : applyRiskVo.getAccountDetailVoList()){
            if(StringUtils.isNotTrimBlank(accountDetailVo.getAccountDetailId())){
                accountDetailRepository.updateByPrimaryKeySelectiveData(accountDetailVo.getEntity());
                //保存流水明细信息
                accountDetailListRepository.updateByPrimaryKeySelectiveDataList(accountDetailVo.getAccountDetailLists());
            }else{
                AccountDetail accountDetail = getEntity(accountDetailVo,new AccountDetail());
                accountDetailRepository.insertData(accountDetail);
                //保存流水明细信息
                for (AccountDetailList accountDetailList : accountDetailVo.getAccountDetailLists()){
                    accountDetailList.setAccountDetailId(accountDetail.getAccountDetailId());
                    accountDetailListRepository.insertData(accountDetailList);
                }
            }
        }
    }

    /**
     * @param applyNo
     * @param applyRiskVo
     * @return ApplyRiskVo
     * @throws
     * @Title:
     * @Description: 取得个人风险信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskMgmtPersInfo(String applyNo, ApplyRiskVo applyRiskVo) {
        //构造新数据
        //其他申请编号的
        String certifNo = applyRiskVo.getCstmPerson().getCertifNo();
        RiskMgmtPerson riskMgmtPersonMain = riskMgmtPersonService.findRiskMgmtPersonByMain(certifNo,applyNo);
        if (StringUtils.isNotTrimBlank(riskMgmtPersonMain)) {
            String applyNoMain = riskMgmtPersonMain.getApplyNo();
            riskMgmtPersonMain.setRiskMgmtPersonId(null);
            riskMgmtPersonMain.setApplyNo(applyNo);
            //主贷人的
            applyRiskVo.setRiskMgmtPerson(riskMgmtPersonMain);
            //根据申请编号取得风险信息
            List<RiskPerson> riskPersonList = riskPersonService.findRiskPersonListByApplyNo(applyNoMain);
            List<PbcCredit> pbcCreditList = pbcCreditService.findPbcCreditListByApplyNo(applyNoMain);
            List<AccountDetailVo> accountDetailVoList = accountDetailService.findAccountDetailVoListByApplyNo(applyNoMain);

            if (ArrayUtils.isNotNullAndLengthNotZero(riskPersonList)) {
                for (int i = 0; i < riskPersonList.size(); i++) {
                    if (PRINCIPAL_LENDER.getCode().equals(riskPersonList.get(i).getRelation())) {
                        //主贷人的风险信息
                        RiskPersonVo riskPersonVo = getEntity(riskPersonList.get(i), new RiskPersonVo());
                        riskPersonVo.setRiskPersonId(null);
                        riskPersonVo.setApplyNo(applyNo);
                        applyRiskVo.setRiskPersonVoMain(riskPersonVo);
                    }
                }
            }
            if (ArrayUtils.isNotNullAndLengthNotZero(pbcCreditList)) {
                for (int i = 0; i < pbcCreditList.size(); i++) {
                    if (PRINCIPAL_LENDER.getCode().equals(pbcCreditList.get(i).getRelation())) {
                        //主贷人的人行信息
                        PbcCredit pbcCredit = pbcCreditList.get(i);
                        pbcCredit.setPbcCreditId(null);
                        pbcCredit.setApplyNo(applyNo);
                        applyRiskVo.getRiskPersonVoMain().setPbcCredit(pbcCredit);
                    }
                }
            }
            //银行流水信息
            if (ArrayUtils.isNotNullAndLengthNotZero(accountDetailVoList)) {
                for (int i = 0; i < accountDetailVoList.size(); i++) {
                    if (PRINCIPAL_LENDER.getCode().equals(accountDetailVoList.get(i).getRelation())) {
                        AccountDetailVo accountDetailVo = accountDetailVoList.get(i);
                        getAccountDetailVoNew(accountDetailVo, applyNo);
                        applyRiskVo.getAccountDetailVoList().add(accountDetailVo);
                    }
                }
            }
        } else {
            //主贷人
            RiskMgmtPerson riskMgmtPersonNew = new RiskMgmtPerson();

            if(applyRiskVo.getCstmPersJob().getSalary() != null){
                riskMgmtPersonNew.setLesseeSalary(applyRiskVo.getCstmPersJob().getSalary().multiply(new BigDecimal("10000")).divide(new BigDecimal("12"), 0, BigDecimal.ROUND_HALF_UP));
            }

            if(applyRiskVo.getCstmPersJob().getElseSalary() != null){
                riskMgmtPersonNew.setLesseeElseSalary(applyRiskVo.getCstmPersJob().getElseSalary().multiply(new BigDecimal("10000")).divide(new BigDecimal("12"), 0, BigDecimal.ROUND_HALF_UP));
            }
            riskMgmtPersonNew.setRent(applyRiskVo.getApplyFinanceVo().getRent());
            riskMgmtPersonNew.setApplyNo(applyNo);
            applyRiskVo.setRiskMgmtPerson(riskMgmtPersonNew);

            //个人风险信息载体
            RiskPersonVo riskPersonVoMain = new RiskPersonVo();
            riskPersonVoMain.setName(applyRiskVo.getCstmPerson().getName());
            riskPersonVoMain.setRelation(PRINCIPAL_LENDER.getCode());
            if(ApplyTypeEnums.PERSON.getType().equals(applyRiskVo.getApply().getApplyType())){
                String belongCity = applyRiskVo.getApplyFinanceVo().getGroupDistrict();
                String resideCity = commonConstantService.findBasAreaName(applyRiskVo.getCstmPersAddr().getResideCity());
                if(StringUtils.equals(belongCity,resideCity))
                    riskPersonVoMain.setApplyAddrMatch("一致");
                else
                    riskPersonVoMain.setApplyAddrMatch("不一致");
            }

            riskPersonVoMain.setApplyNo(applyNo);
            PbcCredit pbcCreditMain = new PbcCredit();
            pbcCreditMain.setName(applyRiskVo.getCstmPerson().getName());
            pbcCreditMain.setRelation(PRINCIPAL_LENDER.getCode());
            pbcCreditMain.setApplyNo(applyNo);
            riskPersonVoMain.setPbcCredit(pbcCreditMain);
            applyRiskVo.setRiskPersonVoMain(riskPersonVoMain);

            //主贷人银行流水信息
            AccountDetailVo accountDetailVo = new AccountDetailVo();
            accountDetailVo.setName(applyRiskVo.getCstmPerson().getName());
            accountDetailVo.setRelation(PRINCIPAL_LENDER.getCode());
            accountDetailVo.setAccountDetailLists(getAccountDetailListNew());
            accountDetailVo.setApplyNo(applyNo);
            applyRiskVo.getAccountDetailVoList().add(accountDetailVo);
        }
        //主贷人以外的信息
        //共同借款人风险信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getCommonBorrowerList())){
            //
            for(int i=0; i<applyRiskVo.getCommonBorrowerList().size(); i++){
                RiskPersonVo riskPersonVo = new RiskPersonVo();
                riskPersonVo.setName(applyRiskVo.getCommonBorrowerList().get(i).getName());
                riskPersonVo.setRelation(COMMON_BORR.getCode());
                riskPersonVo.setApplyNo(applyNo);
                applyRiskVo.getRiskPersonVoBorrList().add(riskPersonVo);
            }
        }
        //担保人风险信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getGuaranteePersList())){
            //
            for(int i=0; i<applyRiskVo.getGuaranteePersList().size(); i++){
                RiskPersonVo riskPersonVo = new RiskPersonVo();
                riskPersonVo.setName(applyRiskVo.getGuaranteePersList().get(i).getName());
                riskPersonVo.setRelation(GUARANTEE_PERSON.getCode());
                //担保人与承租人关系
                riskPersonVo.setGuaranteeRelation(applyRiskVo.getGuaranteePersList().get(i).getRelation());
                riskPersonVo.setApplyNo(applyNo);
                applyRiskVo.getRiskPersonVoGuarList().add(riskPersonVo);
            }
        }
        //担保企业风险信息，担保人银行流水
        getRiskCommon(applyRiskVo);


        //查询老数据
        //风控个人信息
        RiskMgmtPerson riskMgmtPerson = riskMgmtPersonService.findRiskMgmtPersonByApplyNo(applyNo);
        //当前申请编号的风控信息存在
        if (StringUtils.isNotTrimBlank(riskMgmtPerson)) {
            //主贷人的信息
            applyRiskVo.setRiskMgmtPerson(riskMgmtPerson);
            //担保人信息
            List<RiskMgmtGuarantee> riskMgmtGuaranteeListNow =
                    this.compareList(riskMgmtGuaranteeService.findRiskMgmtGuaranteeListByApplyNo(applyNo), applyRiskVo.getRiskMgmtGuaranteeList());
            //保存比较之后的信息
            applyRiskVo.setRiskMgmtGuaranteeList(riskMgmtGuaranteeListNow);
            //根据申请编号取得风险信息
            List<RiskPerson> riskPersonList = riskPersonService.findRiskPersonListByApplyNo(applyNo);
            List<PbcCredit> pbcCreditList = pbcCreditService.findPbcCreditListByApplyNo(applyNo);
            List<RiskCompany> riskCompanieList = riskCompanyService.findRiskCompanyListByApplyNo(applyNo);
            List<AccountDetailVo> accountDetailVoList = accountDetailService.findAccountDetailVoListByApplyNo(applyNo);

            if (ArrayUtils.isNotNullAndLengthNotZero(riskPersonList)) {
                //担保人风险信息
                List<RiskPersonVo> riskPersonVosOld = new ArrayList<>();
                //共同借款人风险信息
                List<RiskPersonVo> riskPersonVoBorrListOld = new ArrayList<>();
                for (int i = 0; i < riskPersonList.size(); i++) {
                    if (PRINCIPAL_LENDER.getCode().equals(riskPersonList.get(i).getRelation())) {
                        //主贷人的风险信息
                        applyRiskVo.setRiskPersonVoMain(getEntity(riskPersonList.get(i), new RiskPersonVo()));
                    }
                    if (GUARANTEE_PERSON.getCode().equals(riskPersonList.get(i).getRelation())) {
                        //担保人的风险信息
                        riskPersonVosOld.add(getEntity(riskPersonList.get(i), new RiskPersonVo()));
                    }
                    if (COMMON_BORR.getCode().equals(riskPersonList.get(i).getRelation())) {
                        //共同借款人的风险信息
                        riskPersonVoBorrListOld.add(getEntity(riskPersonList.get(i), new RiskPersonVo()));
                    }
                }
                //比较担保人风险信息
                List<RiskPersonVo> riskPersonVosNow =
                        this.compareList(riskPersonVosOld, applyRiskVo.getRiskPersonVoGuarList());
                applyRiskVo.setRiskPersonVoGuarList(riskPersonVosNow);
                //比较共同借款人风险信息
                List<RiskPersonVo> riskPersonVoBorrListNow =
                        this.compareList(riskPersonVoBorrListOld, applyRiskVo.getRiskPersonVoBorrList());
                applyRiskVo.setRiskPersonVoBorrList(riskPersonVoBorrListNow);
            }
            if (ArrayUtils.isNotNullAndLengthNotZero(pbcCreditList)) {
                for (int i = 0; i < pbcCreditList.size(); i++) {
                    if (PRINCIPAL_LENDER.getCode().equals(pbcCreditList.get(i).getRelation())) {
                        //主贷人的人行信息
                        applyRiskVo.getRiskPersonVoMain().setPbcCredit(pbcCreditList.get(i));
                    }
                }
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
                        this.compareList(riskCompanyVoOld, applyRiskVo.getRiskCompanyVoGuarList());
                applyRiskVo.setRiskCompanyVoGuarList(riskCompanyVoNow);
            }
            //银行流水信息
            if (ArrayUtils.isNotNullAndLengthNotZero(accountDetailVoList)) {
                applyRiskVo.setAccountDetailVoList(this.compareList(accountDetailVoList,applyRiskVo.getAccountDetailVoList()));
//                applyRiskVo.setAccountDetailVoList(accountDetailVoList);
            }
        }
    }

    /** 
    * @Description:  保存公司风险信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/7 10:57
    */ 
    private void saveRiskMgmtCompInfo(ApplyRiskVo applyRiskVo){
        String applyNo = applyRiskVo.getApply().getApplyNo();
        //查询风控企业信息
        RiskMgmtComp riskMgmtCompOld = riskMgmtCompService.findRiskMgmtCompByApplyNo(applyNo);
        //当前申请编号的风控信息存在
        if(riskMgmtCompOld != null){
            //保存风控企业(承租企业)信息
            RiskMgmtComp riskMgmtComp = applyRiskVo.getRiskMgmtComp();
            riskMgmtCompRepository.updateByPrimaryKeySelectiveData(riskMgmtComp,true);
            //保存风控担保人信息
            List<RiskMgmtGuarantee> riskMgmtGuaranteeList = applyRiskVo.getRiskMgmtGuaranteeList();
            for (RiskMgmtGuarantee riskMgmtGuarantee : riskMgmtGuaranteeList){
                if(StringUtils.isNotTrimBlank(riskMgmtGuarantee.getRiskMgmtGuaranteeId()))
                    riskMgmtGuaranteeRepository.updateByPrimaryKeySelectiveData(riskMgmtGuarantee);
                else
                    riskMgmtGuaranteeRepository.insertData(riskMgmtGuarantee);
            }
            //保存企业风险信息
            riskCompanyRepository.updateByPrimaryKeySelectiveData(applyRiskVo.getRiskCompanyVoMain().getEntity());
            //保存担保企业风险信息
            for(RiskCompanyVo riskCompanyVo : applyRiskVo.getRiskCompanyVoGuarList()){
                if (GUARANTEE_COMPANY.getCode().equals(riskCompanyVo.getRelation())) {
                    //担保企业的风险信息
                    if(StringUtils.isNotTrimBlank(riskCompanyVo.getRiskCompanyId()))
                        riskCompanyRepository.updateByPrimaryKeySelectiveData(riskCompanyVo.getEntity());
                    else
                        riskCompanyRepository.insertData(riskCompanyVo.getEntity());
                }
            }
            //保存担保人风险信息
            for(RiskPersonVo riskPersonVo : applyRiskVo.getRiskPersonVoGuarList()){
                if (GUARANTEE_PERSON.getCode().equals(riskPersonVo.getRelation())) {
                    if(StringUtils.isNotTrimBlank(riskPersonVo.getRiskPersonId())){
                        //保存担保人风险信息
                        riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVo.getEntity());
                        //保存担保人 人行征信
                        PbcCredit pbcCredit = riskPersonVo.getPbcCredit();
                        pbcCreditRepository.updateByPrimaryKeySelectiveData(pbcCredit);
                    }else{
                        //保存担保人风险信息
                        riskPersonRepository.insertData(riskPersonVo.getEntity());
                        //保存担保人 人行征信
                        PbcCredit pbcCredit = riskPersonVo.getPbcCredit();
                        pbcCreditRepository.insertData(pbcCredit);
                    }
                }
            }

            //保存担保人配偶风险信息
            if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getRiskPersonVoGuMateList())){
                for(RiskPersonVo riskPersonVoMate : applyRiskVo.getRiskPersonVoGuMateList()){
                    //保存担保人风险信息
                    if(StringUtils.isNotTrimBlank(riskPersonVoMate.getRiskPersonId()))
                        riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonVoMate.getEntity());
                    else
                        riskPersonRepository.insertData(riskPersonVoMate.getEntity());
                }
            }

        }else{
            //当前申请编号的风控信息不存在
            //保存风控企业(承租企业)信息
            RiskMgmtComp riskMgmtComp = applyRiskVo.getRiskMgmtComp();
            riskMgmtCompRepository.insertData(riskMgmtComp);
            //保存企业风险信息（插入）
            RiskCompanyVo riskCompanyVo = applyRiskVo.getRiskCompanyVoMain();
            riskCompanyRepository.insertData(riskCompanyVo.getEntity());
            //担保人风险信息
            if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getRiskPersonVoGuarList())){
                for(RiskPersonVo riskPersonVo : applyRiskVo.getRiskPersonVoGuarList()){
                    if (GUARANTEE_PERSON.getCode().equals(riskPersonVo.getRelation())) {
                        //保存担保人风险信息
                        riskPersonRepository.insertData(riskPersonVo.getEntity());
                        //保存担保人 人行征信
                        PbcCredit pbcCredit = riskPersonVo.getPbcCredit();
                        pbcCreditRepository.insertData(pbcCredit);
                    }
                }
            }
            //担保人配偶风险信息
            if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getRiskPersonVoGuMateList())){
                for(RiskPersonVo riskPersonVoMate : applyRiskVo.getRiskPersonVoGuMateList()){
                    //保存担保人风险信息
                    riskPersonRepository.insertData(riskPersonVoMate.getEntity());
                }
            }
            //保存风控担保人信息
            riskMgmtGuaranteeRepository.insertDataList(applyRiskVo.getRiskMgmtGuaranteeList());

            //保存担保企业风险信息
            for(RiskCompanyVo riskCompanyGuarVo : applyRiskVo.getRiskCompanyVoGuarList()){
                riskCompanyRepository.insertData(riskCompanyGuarVo.getEntity());
            }
        }
    }

    /**
     * @param applyNo
     * @param applyRiskVo
     * @return ApplyRiskVo
     * @throws
     * @Title:
     * @Description: 取得企业风险信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskMgmtCompInfo(String applyNo, ApplyRiskVo applyRiskVo) {
        //构造新数据
        //其他申请编号的
        String certifNo = applyRiskVo.getCstmCompany().getSocialCertifNo();
        RiskMgmtComp riskMgmtCompMain = riskMgmtCompService.findRiskMgmtCompByMain(certifNo,applyNo);
        if (StringUtils.isNotTrimBlank(riskMgmtCompMain)) {
            String applyNoMain = riskMgmtCompMain.getApplyNo();
            //主贷人的
            riskMgmtCompMain.setRiskMgmtCompId(null);
            riskMgmtCompMain.setApplyNo(applyNo);
            applyRiskVo.setRiskMgmtComp(riskMgmtCompMain);
            //根据申请编号取得风险信息
            List<RiskCompany> riskCompanyList = riskCompanyService.findRiskCompanyListByApplyNo(applyNoMain);
            List<AccountDetailVo> accountDetailVoList = accountDetailService.findAccountDetailVoListByApplyNo(applyNoMain);

            if (ArrayUtils.isNotNullAndLengthNotZero(riskCompanyList)) {
                for (int i = 0; i < riskCompanyList.size(); i++) {
                    if (PRINCIPAL_LENDER.getCode().equals(riskCompanyList.get(i).getRelation())) {
                        //主贷人的风险信息
                        RiskCompanyVo riskCompanyVoOld = EntityUtils.getEntity(riskCompanyList.get(i), new RiskCompanyVo());
                        riskCompanyVoOld.setRiskCompanyId(null);
                        riskCompanyVoOld.setApplyNo(applyNo);
                        applyRiskVo.setRiskCompanyVoMain(riskCompanyVoOld);
                    }
                }
            }
            //银行流水信息
            if (ArrayUtils.isNotNullAndLengthNotZero(accountDetailVoList)) {
                for (int i = 0; i < accountDetailVoList.size(); i++) {
                    if (PRINCIPAL_LENDER.getCode().equals(accountDetailVoList.get(i).getRelation())) {
                        AccountDetailVo accountDetailVo = accountDetailVoList.get(i);
                        getAccountDetailVoNew(accountDetailVo, applyNo);
                        applyRiskVo.getAccountDetailVoList().add(accountDetailVo);
                    }
                }
            }
        } else {
            //主贷人
            RiskMgmtComp riskMgmtCompNew = new RiskMgmtComp();
            riskMgmtCompNew.setRent(applyRiskVo.getApplyFinanceVo().getRent());
            riskMgmtCompNew.setApplyNo(applyNo);
            applyRiskVo.setRiskMgmtComp(riskMgmtCompNew);

            RiskCompanyVo riskPersonVoMain = new RiskCompanyVo();
            riskPersonVoMain.setName(applyRiskVo.getCstmCompany().getName());
            riskPersonVoMain.setRelation(PRINCIPAL_LENDER.getCode());
            riskPersonVoMain.setApplyNo(applyNo);
            //地址匹配
            String belongCity = applyRiskVo.getApplyFinanceVo().getGroupDistrict();
            String compCity = commonConstantService.findBasAreaName(applyRiskVo.getCstmCompany().getCompCity());
            if(StringUtils.equals(belongCity,compCity))
                riskPersonVoMain.setApplyAddrMatch("一致");
            else
                riskPersonVoMain.setApplyAddrMatch("不一致");
//            PbcCredit pbcCreditMain = new PbcCredit();
//            pbcCreditMain.setName(applyRiskVo.getCstmCompany().getName());
//            pbcCreditMain.setRelation(PRINCIPAL_LENDER.getCode());
//            pbcCreditMain.setApplyNo(applyNo);
//            riskPersonVoMain.setPbcCredit(pbcCreditMain);
            applyRiskVo.setRiskCompanyVoMain(riskPersonVoMain);

            //主贷人银行流水信息
            AccountDetailVo accountDetailVo = new AccountDetailVo();
            accountDetailVo.setName(applyRiskVo.getCstmCompany().getName());
            accountDetailVo.setRelation(PRINCIPAL_LENDER.getCode());
            accountDetailVo.setApplyNo(applyNo);
            accountDetailVo.setAccountDetailLists(getAccountDetailListNew());
            applyRiskVo.getAccountDetailVoList().add(accountDetailVo);

        }
        //主贷人以外的信息
        //担保人风险信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getGuaranteePersList())){
            //
            for(int i=0; i<applyRiskVo.getGuaranteePersList().size(); i++){
                RiskPersonVo riskPersonVo = new RiskPersonVo();
                riskPersonVo.setName(applyRiskVo.getGuaranteePersList().get(i).getName());
                riskPersonVo.setRelation(GUARANTEE_PERSON.getCode());
                riskPersonVo.setApplyNo(applyNo);
                //地址匹配
                String belongCity = applyRiskVo.getApplyFinanceVo().getGroupDistrict();
                String resideCity = commonConstantService.findBasAreaName(applyRiskVo.getGuaranteePersList().get(i).getResideCity());
                if(StringUtils.equals(belongCity,resideCity))
                    riskPersonVo.setApplyAddrMatch("一致");
                else
                    riskPersonVo.setApplyAddrMatch("不一致");
                PbcCredit pbcCredit = new PbcCredit();
                pbcCredit.setName(applyRiskVo.getGuaranteePersList().get(i).getName());
                pbcCredit.setRelation(GUARANTEE_PERSON.getCode());
                pbcCredit.setApplyNo(applyNo);
                riskPersonVo.setPbcCredit(pbcCredit);
                applyRiskVo.getRiskPersonVoGuarList().add(riskPersonVo);

                //担保人配偶
                if(MarriageStatusEnums.MARRIED.getStatus().equals(applyRiskVo.getGuaranteePersList().get(i).getMarriageStatus())//已婚
                        || MarriageStatusEnums.MARRIED_WITH_CHILDREN.getStatus().equals(applyRiskVo.getGuaranteePersList().get(i).getMarriageStatus())) {//已婚有子女
                    //担保人配偶：银行卡核查，反欺诈分析，地址核验，卡核查及交易
                    RiskPersonVo riskPersonVoMate = new RiskPersonVo();
                    riskPersonVoMate.setName(applyRiskVo.getGuaranteePersList().get(i).getMateName());
                    riskPersonVoMate.setRelation(GUARANTEE_PERSON_MATE.getCode());
                    riskPersonVoMate.setApplyNo(applyNo);
                    applyRiskVo.getRiskPersonVoGuMateList().add(riskPersonVoMate);
                }
            }
        }
        //担保企业风险信息，担保人银行流水
        getRiskCommon(applyRiskVo);

        //查询老数据
        //风控企业信息
        RiskMgmtComp riskMgmtComp = riskMgmtCompService.findRiskMgmtCompByApplyNo(applyNo);

        //当前申请编号的风控信息存在
        if (StringUtils.isNotTrimBlank(riskMgmtComp)) {
            //主贷人的信息
            applyRiskVo.setRiskMgmtComp(riskMgmtComp);
            //担保人信息
            List<RiskMgmtGuarantee> riskMgmtGuaranteeNow =
                    this.compareList(riskMgmtGuaranteeService.findRiskMgmtGuaranteeListByApplyNo(applyNo),applyRiskVo.getRiskMgmtGuaranteeList());
            applyRiskVo.setRiskMgmtGuaranteeList(riskMgmtGuaranteeNow);
            //根据申请编号取得风险信息
            List<RiskCompany> riskCompanieList = riskCompanyService.findRiskCompanyListByApplyNo(applyNo);
            List<RiskPerson> riskPersonList = riskPersonService.findRiskPersonListByApplyNo(applyNo);
            List<PbcCredit> pbcCreditList = pbcCreditService.findPbcCreditListByApplyNo(applyNo);
            List<AccountDetailVo> accountDetailVoList = accountDetailService.findAccountDetailVoListByApplyNo(applyNo);

            if (ArrayUtils.isNotNullAndLengthNotZero(riskCompanieList)) {
                //定义老数据
                List<RiskCompanyVo> riskCompanyVoOld = new ArrayList<>();
                for (int i = 0; i < riskCompanieList.size(); i++) {
                    if(PRINCIPAL_LENDER.getCode().equals(riskCompanieList.get(i).getRelation())){
                        applyRiskVo.setRiskCompanyVoMain(getEntity(riskCompanieList.get(i), new RiskCompanyVo()));
                    }
                    if (GUARANTEE_COMPANY.getCode().equals(riskCompanieList.get(i).getRelation())) {
                        //担保企业的风险信息
                        riskCompanyVoOld.add(getEntity(riskCompanieList.get(i), new RiskCompanyVo()));
                    }
                }
                applyRiskVo.setRiskCompanyVoGuarList(this.compareList(riskCompanyVoOld,applyRiskVo.getRiskCompanyVoGuarList()));
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
                applyRiskVo.setRiskPersonVoGuarList(this.compareList(riskPersonVoOld,applyRiskVo.getRiskPersonVoGuarList()));
                applyRiskVo.setRiskPersonVoGuMateList(this.compareList(riskPersonVoMateOld,applyRiskVo.getRiskPersonVoGuMateList()));
            }

            //银行流水信息
            if (ArrayUtils.isNotNullAndLengthNotZero(accountDetailVoList)) {
                applyRiskVo.setAccountDetailVoList(this.compareList(accountDetailVoList,applyRiskVo.getAccountDetailVoList()));
//                applyRiskVo.setAccountDetailVoList(accountDetailVoList);
            }
        }

    }

    /**
     * @param accountDetailVo
     * @param applyNo
     * @return List<AccountDetailList>
     * @throws
     * @Title:
     * @Description: 生成初期银行流水明细
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getAccountDetailVoNew(AccountDetailVo accountDetailVo, String applyNo) {
        accountDetailVo.setAccountDetailId(null);
        accountDetailVo.setApplyNo(applyNo);
        for(int i=0; i<accountDetailVo.getAccountDetailLists().size(); i++){
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
        for(int i=-6; i<0; i++){
            AccountDetailList accountDetailList = new AccountDetailList();
            Date detailDate = DateUtils.getAddMonth(now, i);
            accountDetailList.setYearMon(DateUtils.getStringDate(detailDate, DateUtils.formatStr_yyyymm));
            accountDetailLists.add(accountDetailList);
        }
        return accountDetailLists;
    }


    /**
     * @param applyNo
     * @param applyRiskVo
     * @return ApplyRiskVo
     * @throws
     * @Title:
     * @Description: 取得鹏元查询一览
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getPycreditListVoList(String applyNo, ApplyRiskVo applyRiskVo) {

        //生成鹏元查询一览(新数据)
        List<PycreditList> pycreditListNew = new ArrayList<>();
        String applyType = applyRiskVo.getApply().getApplyType();
        //个人
        if (ApplyTypeEnums.PERSON.getType().equals(applyType)) {
            //承租人:反欺诈分析,地址核验,卡核查及交易,银行卡核查,驾驶证核查
            if (StringUtils.isNotTrimBlank(applyRiskVo.getCstmPerson())) {
                PycreditList pycreditListMain = new PycreditList();
                convertPy(applyRiskVo.getCstmPerson(), PRINCIPAL_LENDER.getCode(), pycreditListMain);
                convertPy(applyRiskVo.getCstmPersAddr(), PRINCIPAL_LENDER.getCode(), pycreditListMain);
                convertPy(applyRiskVo.getCstmPersJob(), PRINCIPAL_LENDER.getCode(), pycreditListMain);
                addPycreditTypes(pycreditListNew, pycreditListMain, PYCREDIT_TYPE_PER_MAIN);

            }
            //共同借款人:反欺诈分析,地址核验,卡核查及交易,银行卡核查
            if (ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getCommonBorrowerList())) {
                for (CommonBorrower commonBorrower : applyRiskVo.getCommonBorrowerList()) {
                    PycreditList pycreditListBorr = new PycreditList();
                    convertPy(commonBorrower, COMMON_BORR.getCode(), pycreditListBorr);
                    addPycreditTypes(pycreditListNew, pycreditListBorr, PYCREDIT_TYPE_PER_GUAR);
                }
            }

            //担保人：反欺诈分析，地址核验，卡核查及交易，银行卡核查
            if (ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getGuaranteePersList())) {
                for (GuaranteePers guaranteePers : applyRiskVo.getGuaranteePersList()) {
                    PycreditList pycreditListGuar = new PycreditList();
                    convertPy(guaranteePers, GUARANTEE_PERSON.getCode(), pycreditListGuar);
                    addPycreditTypes(pycreditListNew, pycreditListGuar, PYCREDIT_TYPE_PER_GUAR);
                }
            }

            //担保企业：银行卡核查，企业查验-风险和债务
            if (ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getGuaranteeCompList())) {
                for (GuaranteeComp guaranteeComp : applyRiskVo.getGuaranteeCompList()) {
                    PycreditList pycreditListGuar = new PycreditList();
                    convertPy(guaranteeComp, GUARANTEE_COMPANY.getCode(), pycreditListGuar);
                    addPycreditTypes(pycreditListNew, pycreditListGuar, PYCREDIT_TYPE_COMP_MAIN);
                }
            }

        } else {
            //企业：企业查验-风险和债务，银行卡核查，
            if (StringUtils.isNotTrimBlank(applyRiskVo.getCstmCompany())) {
                CstmCompany cstmCompany = applyRiskVo.getCstmCompany();
                PycreditList pycreditListCompMain = new PycreditList();
                convertPy(cstmCompany, PRINCIPAL_LENDER.getCode(), pycreditListCompMain);
                addPycreditTypes(pycreditListNew, pycreditListCompMain, PYCREDIT_TYPE_COMP_MAIN);
            }

            //担保人：反欺诈分析，地址核验，卡核查及交易，银行卡核查，驾驶证核查(实际用车人)
            if (ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getGuaranteePersList())) {
                for (GuaranteePers guaranteePers : applyRiskVo.getGuaranteePersList()) {
                    //实际用车人
                    if (guaranteePers.getName().equals(applyRiskVo.getCstmCompany().getDriver())) {
                        PycreditList pycreditListGuar = new PycreditList();
                        //个人担保
                        convertPy(guaranteePers, GUARANTEE_PERSON.getCode(), pycreditListGuar);
                        //实际用车人的驾驶证核查
                        pycreditListGuar.setArchviesNo(applyRiskVo.getCstmCompany().getDriverLicenseNo());
                        pycreditListGuar.setCarModels(conversionQuasiDriveModel(applyRiskVo.getCstmCompany().getQuasiDriveModel()));
                        if(applyRiskVo.getCstmCompany().getFirstIssueDate() != null){
                            pycreditListGuar.setFirstGetDate(DateUtils.getStringDate(applyRiskVo.getCstmCompany().getFirstIssueDate()));
                        }

                        addPycreditTypes(pycreditListNew, pycreditListGuar, PYCREDIT_TYPE_PER_MAIN);
                    } else {
                        PycreditList pycreditListGuar = new PycreditList();
                        convertPy(guaranteePers, GUARANTEE_PERSON.getCode(), pycreditListGuar);
                        addPycreditTypes(pycreditListNew, pycreditListGuar, PYCREDIT_TYPE_PER_GUAR);
                    }
                    if(MarriageStatusEnums.MARRIED.getStatus().equals(guaranteePers.getMarriageStatus())//已婚
                            || MarriageStatusEnums.MARRIED_WITH_CHILDREN.getStatus().equals(guaranteePers.getMarriageStatus())) {//已婚有子女
                        //担保人配偶：银行卡核查，反欺诈分析，地址核验，卡核查及交易
                        PycreditList pycreditListGuarMate = new PycreditList();
                        convertPy(guaranteePers, GUARANTEE_PERSON_MATE.getCode(), pycreditListGuarMate);
                        addPycreditTypes(pycreditListNew, pycreditListGuarMate, PYCREDIT_TYPE_PER_GUAR);
                    }
                }
            }
            //担保企业：银行卡核查，企业查验-风险和债务
            if (ArrayUtils.isNotNullAndLengthNotZero(applyRiskVo.getGuaranteeCompList())) {
                for (GuaranteeComp guaranteeComp : applyRiskVo.getGuaranteeCompList()) {
                    PycreditList pycreditListGuar = new PycreditList();
                    convertPy(guaranteeComp, GUARANTEE_COMPANY.getCode(), pycreditListGuar);
                    addPycreditTypes(pycreditListNew, pycreditListGuar, PYCREDIT_TYPE_COMP_MAIN);
                }
            }
        }


        List<PycreditListVo> pycreditListVos = new ArrayList<>();
        for(PycreditList pycreditList : pycreditListNew){
            pycreditListVos.add(EntityUtils.getEntity(pycreditList, new PycreditListVo()));
        }
        applyRiskVo.setPycreditListVoList(pycreditListVos);

        //根据applyNo检索，如果存在则取得老数据
        List<PycreditListVo> pycreditListVoList = pycreditListService.findPycreditListByApplyNo(applyNo);

        //比较，获取最新list
        List<PycreditListVo> nowList = this.compareList(pycreditListVoList,applyRiskVo.getPycreditListVoList());
        //插入最新构造的数据
        for(PycreditListVo pycreditListVo : nowList){
            //保存鹏元查询一览并把id返回页面
            if(StringUtils.isTrimBlank(pycreditListVo.getPycreditId())){
                PycreditList pycreditList = pycreditListVo.getEntity();
                pycreditListRepository.insertData(pycreditList);
                pycreditListVo.setPycreditId(pycreditList.getPycreditId());
            }
        }
        //保存最新的list
        applyRiskVo.setPycreditListVoList(nowList);
    }

    /** 
    * @Description: 比较listOld和listNew，如果listNew中元素在listOld中存在，
     * 获取listOld中的，否则使用listNew中的元素，返回新的list,list中元素需重写equals方法
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/12 11:51
    */ 
    public <T> List<T> compareList(List<T> listOld,List<T> listNew){
        List<T> nowList = new ArrayList<T>();
        if(ArrayUtils.isNullOrLengthZero(listOld)){
            return listNew;
        }

        for(T newObj : listNew){
            if(listOld.contains(newObj)){
                nowList.add(listOld.get(listOld.indexOf(newObj)));
            }else{
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
        String applyNo = CommonUtils.getPropertyValueByObject("applyNo", cstmInfo).toString();
        //获取所有地址信息
        Map<String,String> areaMap = basAreaService.getBasAreaCodeAndName();
        pycreditList.setApplyNo(applyNo);
        pycreditList.setRelation(relationType);

        if(cstmInfo instanceof CstmPerson){
            pycreditList.setName(((CstmPerson) cstmInfo).getName());
            pycreditList.setDocumentNo(((CstmPerson) cstmInfo).getCertifNo());
            pycreditList.setPhone(((CstmPerson)cstmInfo).getMobileNo());
            pycreditList.setArchviesNo(((CstmPerson)cstmInfo).getLicenseNo());
            pycreditList.setCarModels(conversionQuasiDriveModel(((CstmPerson) cstmInfo).getQuasiDriveModel()));
            if(((CstmPerson)cstmInfo).getFirstIssueDate() != null){
                pycreditList.setFirstGetDate(DateUtils.getStringDate(((CstmPerson)cstmInfo).getFirstIssueDate()));
            }
        }
        if(cstmInfo instanceof CstmPersAddr){
            String areaCensus = this.getAreaName(cstmInfo,"census",areaMap);
            String areaReside = this.getAreaName(cstmInfo,"reside",areaMap);

            pycreditList.setCensusAddr(areaCensus.concat(getString(((CstmPersAddr) cstmInfo).getCensusAddr())));
            pycreditList.setResideAddr(areaReside.concat(getString((((CstmPersAddr) cstmInfo).getResideAddr()))));
        }
        if(cstmInfo instanceof CstmPersJob){
            String areaComp = this.getAreaName(cstmInfo,"comp",areaMap);
            pycreditList.setCompAddr(areaComp.concat(getString((((CstmPersJob) cstmInfo).getCompAddr()))));
        }

        if(cstmInfo instanceof CommonBorrower){
            String areaComp = this.getAreaName(cstmInfo,"comp",areaMap);
            pycreditList.setName(((CommonBorrower) cstmInfo).getName());
            pycreditList.setDocumentNo(((CommonBorrower) cstmInfo).getCertifNo());
            pycreditList.setPhone(((CommonBorrower)cstmInfo).getMobileNo());
            pycreditList.setCensusAddr(areaComp.concat(getString((((CommonBorrower) cstmInfo).getCompAddr()))));
        }
        //担保人
        if(cstmInfo instanceof GuaranteePers && GUARANTEE_PERSON.getCode().equals(relationType)){
            pycreditList.setName(((GuaranteePers) cstmInfo).getName());
            pycreditList.setDocumentNo(((GuaranteePers) cstmInfo).getCertifNo());
            pycreditList.setPhone(((GuaranteePers)cstmInfo).getMobileNo());
            pycreditList.setCensusAddr(this.getAreaName(cstmInfo,"census",areaMap)+getString(((GuaranteePers) cstmInfo).getCensusAddr()));
            pycreditList.setResideAddr(this.getAreaName(cstmInfo,"reside",areaMap)+getString(((GuaranteePers) cstmInfo).getResideAddr()));
            pycreditList.setCensusAddr(this.getAreaName(cstmInfo,"comp",areaMap)+getString(((GuaranteePers) cstmInfo).getCompAddr()));
        }
        //担保人配偶
        if(cstmInfo instanceof GuaranteePers && GUARANTEE_PERSON_MATE.getCode().equals(relationType)){
            pycreditList.setName(((GuaranteePers) cstmInfo).getMateName());
            pycreditList.setDocumentNo(((GuaranteePers) cstmInfo).getMateCertifNo());
            pycreditList.setPhone(((GuaranteePers)cstmInfo).getMateMobileNo());
//            pycreditList.setCensusAddr(this.getAreaName(cstmInfo,"census",areaMap)+getString(((GuaranteePers) cstmInfo).getCensusAddr()));
//            pycreditList.setResideAddr(this.getAreaName(cstmInfo,"reside",areaMap)+getString(((GuaranteePers) cstmInfo).getResideAddr()));
            pycreditList.setCensusAddr(this.getAreaName(cstmInfo,"mateComp",areaMap)+getString(((GuaranteePers) cstmInfo).getMateCompAddr()));
        }

        if(cstmInfo instanceof CstmCompany){
            pycreditList.setName(((CstmCompany) cstmInfo).getName());
            pycreditList.setDocumentNo(((CstmCompany) cstmInfo).getSocialCertifNo());
            pycreditList.setCompAddr(this.getAreaName(cstmInfo,"comp",areaMap)+getString(((CstmCompany)cstmInfo).getCompAddr()));
        }
        if(cstmInfo instanceof GuaranteeComp){
            pycreditList.setName(((GuaranteeComp) cstmInfo).getName());
            pycreditList.setDocumentNo(((GuaranteeComp) cstmInfo).getSocialCertifNo());
            pycreditList.setCompAddr(this.getAreaName(cstmInfo,"comp",areaMap)+getString(((GuaranteeComp)cstmInfo).getCompAddr()));
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
    private String conversionQuasiDriveModel(String quasiDriveModel){
        if(StringUtils.isTrimBlank(quasiDriveModel)){
            return "";
        }else{
            String carModels = "";
            String[] models = quasiDriveModel.split(StringUtils.COMMA);
            for(String model : models){
                try {//如果已经是准架车型，这里转换会报错，直接返回准驾车型就行了
                    Integer.parseInt(model);
                } catch (NumberFormatException e) {
                    return quasiDriveModel;
                }
                String modelName = commonConstantService.findSysCodeValueName("quasiDriveModel",model);
                if(StringUtils.isTrimBlank(modelName)){
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
    private String getAreaName(Object obj,String pre,Map areaMap){
        String area = "";
        try {
            area = areaMap.get(CommonUtils.getPropertyValueByObject(pre+"Prov", obj).toString()).toString()
                    + areaMap.get(CommonUtils.getPropertyValueByObject(pre+"City", obj).toString()).toString()
                    +areaMap.get(CommonUtils.getPropertyValueByObject(pre+"County", obj).toString()).toString();
        } catch (Exception e) {
            log.error(e.getMessage());
            area="";
        }
        return area;
    }

    private String getString (Object obj){
        if(obj == null){
            return "";
        }else{
            return obj.toString();
        }
    }

    /**
     * @param applyNo
     * @param applyRiskVo
     * @return ApplyRiskVo
     * @throws
     * @Title:
     * @Description: 取得电核信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getRiskTelchkInfo(String applyNo, ApplyRiskVo applyRiskVo) {
        applyRiskVo.setRiskTelchkVoList(riskTelchkService.findRiskTelchkByApplyNo(applyNo));
    }

    /**
     * @param applyNo
     * @param applyRiskVo
     * @return ApplyRiskVo
     * @throws
     * @Title:
     * @Description: 取得申请录入相关信息
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    private void getApplyInfo(String applyNo, ApplyRiskVo applyRiskVo,String flag) {
        ApplyRiskVo applyRiskVoRtn;
            try {
                applyRiskVoRtn = ResponseEntityUtils.getRestResponseData(applyInputRpc.findApplyInputRiskByApplyNo(applyNo,flag));
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("订单不存在");
            }
            //申请融资信息
            applyRiskVo.setApplyFinanceVo(applyRiskVoRtn.getApplyFinanceVo());
            //申请信息
            applyRiskVo.setApply(applyRiskVoRtn.getApply());
            //风险融资额
            applyRiskVo.setRiskAmount(applyRiskVoRtn.getRiskAmount());
        //企业基本信息
        applyRiskVo.setCstmCompany(applyRiskVoRtn.getCstmCompany());
        //个人基本信息
        applyRiskVo.setCstmPerson(applyRiskVoRtn.getCstmPerson());
        //个人地址
        applyRiskVo.setCstmPersAddr(applyRiskVoRtn.getCstmPersAddr());
        //个人职业
        applyRiskVo.setCstmPersJob(applyRiskVoRtn.getCstmPersJob());
        //担保人信息
        applyRiskVo.setGuaranteePersList(applyRiskVoRtn.getGuaranteePersList());
        //担保企业信息
        applyRiskVo.setGuaranteeCompList(applyRiskVoRtn.getGuaranteeCompList());
        //共同借款人信息
        applyRiskVo.setCommonBorrowerList(applyRiskVoRtn.getCommonBorrowerList());
        //购车合理性
        applyRiskVo.setRationalityPurchase(applyRiskVoRtn.getRationalityPurchase());

    }

    /** 
    * @Description: 审批共通操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/23 11:49
    */ 
    private void approveCommon(ApplyRiskVo applyRiskVo, String act, ActRuTaskVo actRuTaskVo) {
        Apply apply = applyRiskVo.getApply();
        if(apply == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        //更新订单状态
        String applyBizStatusUpd = actRuTaskVo.getTaskCode();
        if(StringUtils.isTrimBlank(applyBizStatusUpd)){
            throw new FmsServiceException( "订单状态取得失败");
        }
        Apply applyUpd = new Apply();
        applyUpd.setApplyId(apply.getApplyId());
        applyUpd.setBizStatus(applyBizStatusUpd);
        applyUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        //风控初审派单人为空则赋值为当前用户
        if(StringUtils.isTrimBlank(apply.getApproveUser())){
            applyUpd.setApproveUser(applyRiskVo.getUser());
        }
        applyRepository.updateByPrimaryKeySelectiveData(applyUpd);
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(applyRiskVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(applyRiskVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(apply.getApplyNo());
        workflowLog.setStatus(applyBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /** 
    * @Description: 退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/23 14:15
    */ 
    @Override
    @Transactional
    public void backApplyRisk(ApplyRiskVo applyRiskVo){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(applyRiskVo.getTaskId());
        //日志共通
        approveCommon(applyRiskVo, ActTypeEnums.SENDBACK.getType(), actRuTaskVo);
    }

    /**
    * @Description: 退回到业务员
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/24 10:28
    */
    @Override
    @Transactional
    public void backToApply(ApplyRiskVo applyRiskVo){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnDealer(applyRiskVo.getTaskId());
        //日志共通
        approveCommon(applyRiskVo, ActTypeEnums.SENDBACKTOP.getType(), actRuTaskVo);
    }

    /**
     * 保存日志信息
     * @param applyRiskVo
     */
    private void saveWorkFlowLog(ActRuTaskVo actRuTaskVo, ApplyRiskVo applyRiskVo, String actType, String sysUser) {
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser);
        workflowLog.setActType(actType);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setWfLogType(BizTypeEnums.CHANGE_LESSEE.getType());
        workflowLog.setWfLogNo(applyRiskVo.getTaskNo());
        workflowLog.setRemark1(applyRiskVo.getMemo());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("taskNo",applyRiskVo.getTaskNo());
        ChangeLesseeTask changeLesseeTask = changeLesseeTaskRepository.selectOneByExample(example);
        if(changeLesseeTask == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        changeLesseeTask.setTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        changeLesseeTask.setPresentUser(actRuTaskVo.getNextAssignee()); //下一节点审批人
        changeLesseeTaskRepository.updateByExampleData(changeLesseeTask,example);  //更新信息
    }
}