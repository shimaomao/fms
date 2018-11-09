package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.asset.rpc.prebiz.BizFilesRpc;
import cn.com.leadu.fms.asset.rpc.system.SysParamRpc;
import cn.com.leadu.fms.asset.service.EquMorDetailService;
import cn.com.leadu.fms.asset.validator.equmordetail.vo.*;
import cn.com.leadu.fms.business.common.util.CommonCodeUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActEquMorUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActReleasedMortgageUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.asset.ContDetailFlagEnums;
import cn.com.leadu.fms.common.constant.enums.asset.EquMorRepayDetailEnums;
import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.constant.enums.asset.ReliefTaskStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileBizCodeTypeEnum;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.common.vo.PdfCreateVo;
import cn.com.leadu.fms.data.asset.repository.EquMorDetailRepository;
import cn.com.leadu.fms.data.asset.repository.EquMorRepayDetailRepository;
import cn.com.leadu.fms.data.asset.repository.EquRelTaskRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.pojo.asset.entity.EquRelTask;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorArchiveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailArchiveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.*;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailService
 * @Description: 资方抵押明细业务实现层
 * @date 2018-05-30
 */
@Service
@Slf4j
public class EquMorDetailServiceImpl implements EquMorDetailService {

    /**
     * @Fields  : 资方抵押明细repository
     */
    @Autowired
    private EquMorDetailRepository equMorDetailRepository;

    /**
     * @Fields  : 财务待收款repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;

    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 解押任务repository
     */
    @Autowired
    private EquRelTaskRepository equRelTaskRepository;

    /**
     * @Fields  : 财务付款repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 附件信息Service
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields  : 工作流Service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 附件信息rpc
     */
    @Autowired
    private BizFilesRpc bizFilesRpc;

    /**
     * @Fields  : 财务收款Repository
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    /**
     * @Fields  : 财务勾稽Repository
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Fields  : 系统常量Rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 通用pdfservice
     * @author yanfengbo
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * @Fields  : 资方抵押还款计划明细表repository
     * @author qiaomengnan
     */
    @Autowired
    private EquMorRepayDetailRepository equMorRepayDetailRepository;

    /**
     * @Title:
     * @Description: 查询资方抵押明细(申请)
     * @param equMorDetailVo
     * @return PageInfoExtend<EquMorDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:06
     */
    public List<EquMorDetailVo> findEquMorDetailVos(EquMorDetailVo equMorDetailVo){
        equMorDetailVo.setApplyTypePer(ApplyTypeEnums.PERSON.getType());
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorDetailVo.getEquMorDetailIds()))
            equMorDetailVo.setEquMorDetailIds(equMorDetailVo.getEquMorDetailIds());
        else
            equMorDetailVo.setEquMorDetailIds(null);

        if (StringUtils.isNotTrimBlank(equMorDetailVo.getEquRelTaskNo())){
            equMorDetailVo.setEquRelTaskNo(equMorDetailVo.getEquRelTaskNo());
        }else {
            equMorDetailVo.setEquRelTaskNo(null);
        }

        String  mortgageDueDays = null;
        try {
            mortgageDueDays =  ResponseEntityUtils.getRestResponseData(sysParamRpc.findSysParamByParamKey(CommonParamConstants.MORTGAGE_DUE_DAYS));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw  new FmsServiceException("获取系统常量失败");
        }
        Calendar calendar =  Calendar.getInstance();
        String jugDay =  DateUtils.dateToStr(DateUtils.getAddDay(calendar.getTime(),mortgageDueDays),DateUtils.formatStr_yyyyMMdd);
        equMorDetailVo.setJugDay(jugDay);
        equMorDetailVo.setPrePaySts("0704");
        /*equMorDetailVo.setMortgageStatus(MortgageStatusEnums.EQU_MOR_SUCCESS.getStatus());*/
        List<EquMorDetailVo> pageInfo = equMorDetailRepository.selectEquMorDetailVos(equMorDetailVo);
        for(EquMorDetailVo equMorDetail:pageInfo){
            CommonBizFilesVo commonBizFilesVo =  bizFilesService.findBizFilesByBizCode(equMorDetail.getEquMorDetailId()
                    , BizCodeTypeEnums.EQU_MORTGAGE_REL_CONF_FILE.getCodeType());
            if(commonBizFilesVo != null){
                equMorDetail.setCommonBizFilesVo(commonBizFilesVo);
            }else{
                equMorDetail.setCommonBizFilesVo(new CommonBizFilesVo());
            }
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 查询资方抵押明细(复审)
     * @param equMorDetailVo
     * @return PageInfoExtend<EquMorDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:06
     */
    public EquMorDetailVo findEquMorDetailVoList(EquMorDetailVo equMorDetailVo){
        equMorDetailVo.setApplyTypePer(ApplyTypeEnums.PERSON.getType());
        if(StringUtils.isNotTrimBlank(equMorDetailVo.getEquRelTaskNo()))
            equMorDetailVo.setEquRelTaskNo(equMorDetailVo.getEquRelTaskNo());
        else
            equMorDetailVo.setEquRelTaskNo(null);
        List<EquMorDetailVo> pageInfo = equMorDetailRepository.selectEquMorDetailVoList(equMorDetailVo);
        EquMorDetailVo reliefDetailVo = new EquMorDetailVo();

        reliefDetailVo.setBizFilesList(bizFilesService.findBizFilesList(equMorDetailVo.getEquRelTaskNo(),BizCodeTypeEnums.EQU_MORTGAGE_REL_FILE.getCodeType()));
        BigDecimal total = new BigDecimal(0);
        for(EquMorDetailVo equMorDetail:pageInfo){
            total = total.add(equMorDetail.getReliefDifference());
        }
        reliefDetailVo.setDifferenceCount(total);   //总差额
        reliefDetailVo.setEquMorDetailVoList(pageInfo);
        if(total.compareTo(new BigDecimal(0))==1){
            return reliefDetailVo;
        }else{
            Example example = SqlUtil.newExample(ContPay.class);
            example.createCriteria().andEqualTo("paymentType",BizTypeEnums.RELIEF.getType()).andEqualTo("bizCode",equMorDetailVo.getEquRelTaskNo());
            ContPay contPay =  contPayRepository.selectOneByExample(example);
            if(contPay!=null){
                reliefDetailVo.setOpeningBank(contPay.getRecAccBank());
                reliefDetailVo.setRecAccBranch(contPay.getRecAccBranch());
                reliefDetailVo.setAccountNo(contPay.getRecAccountNo());
                reliefDetailVo.setAccountName(contPay.getRecAccountName());
                reliefDetailVo.setBankCode(contPay.getRecEleBankNo());
                reliefDetailVo.setPayAccBank(contPay.getPayAccBank());
                reliefDetailVo.setPayAccBranch(contPay.getPayAccBranch());
                reliefDetailVo.setPayAccountNo(contPay.getPayAccountNo());
                reliefDetailVo.setPayAccountName(contPay.getPayAccountName());
                reliefDetailVo.setPayEleBankNo(contPay.getPayEleBankNo());
            }
            return reliefDetailVo;
        }

    }
    /**
     * @Title:
     * @Description: 保存资方抵押明细
     * @param equMorDetailSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:06
     */
    public void saveEquMorDetail(EquMorDetailSaveVo equMorDetailSaveVo){
        equMorDetailRepository.insertData(equMorDetailSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 资方抵押解除申请(初次提交)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:06
     */
    @Transactional
    public void applyEquMorDetail(EquMorDetailVo equMorDetailVo,SysUser sysUser){
        List<EquMorDetailVo> equMorDetailVoList= equMorDetailVo.getEquMorDetailVoList();
        //解押任务号
        String equRelTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.RELIEF_NUM_TYPE.getType());
        //启动工作流
        ActRuTaskVo actRuTaskVo =  ActReleasedMortgageUtils.startReleasedMortgageAndWaitReview(equRelTaskNo, ReliefTaskStatusEnums.RELEASED_MORTGAGE.getDesc(), sysUser.getUserName());
        //插入解押任务表
        EquRelTask equRelTask = new EquRelTask();
        equRelTask.setEquRelTaskNo(equRelTaskNo);
        equRelTask.setReliefStatus(actRuTaskVo.getTaskCode());
        equRelTask.setPresentUser(actRuTaskVo.getNextAssignee());
        equRelTask.setDifferenceCharge(equMorDetailVo.getDifferenceCount());
        equRelTaskRepository.insertData(equRelTask);
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorDetailVoList)){    //更新解押明细表
            for(EquMorDetailVo equMorDetail:equMorDetailVoList){
                equMorDetail.setEquRelTaskNo(equRelTaskNo);
                equMorDetail.setMortgageStatus(MortgageStatusEnums.RESOLVING_RELIEF.getStatus());
                if(equMorDetail.getReliefReceivAmount()==null)
                    equMorDetail.setReliefReceivAmount(new BigDecimal(0));
                if(equMorDetail.getReliefPenalty() == null)
                    equMorDetail.setReliefPenalty(new BigDecimal(0));
                if(equMorDetail.getReliefRestPrincipal() == null)
                    equMorDetail.setReliefRestPrincipal(new BigDecimal(0));
                if(equMorDetail.getReliefOtherCharge()==null)
                    equMorDetail.setReliefOtherCharge(new BigDecimal(0));
                if(equMorDetail.getReliefDifference() == null)
                    equMorDetail.setReliefDifference(new BigDecimal(0));
                equMorDetailRepository.updateByPrimaryKeySelectiveData(equMorDetail.getEntity());
            }
        }
        BigDecimal judge = new BigDecimal(0);
        if(equMorDetailVo.getDifferenceCount() == null)
            equMorDetailVo.setDifferenceCount(new BigDecimal(0));
        if(equMorDetailVo.getDifferenceCount().compareTo(judge)==1){   //差额总和大于0，录入财务待收款表
            ContCharge contCharge  = new ContCharge();
            contCharge.setChargeBizType(BizTypeEnums.RELIEF.getType());
            contCharge.setChargeBizId(equRelTaskNo);
            contCharge.setChargeFund(PayFundNameEnums.RELIEF_RECEIPT.getType());
            contCharge.setChargeAmount(equMorDetailVo.getDifferenceCount());
            contCharge.setChargeStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
            contChargeRepository.insertData(contCharge);
        }else{                                //小于0，录入财务付款表
            ContPay contPay = new ContPay();
            contPay.setPaymentType(BizTypeEnums.RELIEF.getType());
            contPay.setPayFund(PayFundNameEnums.RELIEF_RECEIPT.getType());
            contPay.setBizCode(equRelTaskNo);
            contPay.setPayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
            contPay.setPayAmount(equMorDetailVo.getDifferenceCount().abs());
            contPay.setRecAccBank(equMorDetailVo.getOpeningBank());
            contPay.setRecAccBranch(equMorDetailVo.getRecAccBranch());
            contPay.setRecAccountNo(equMorDetailVo.getAccountNo());
            contPay.setRecAccountName(equMorDetailVo.getAccountName());
            contPay.setRecEleBankNo(equMorDetailVo.getBankCode());
            contPayRepository.insertData(contPay);
        }
        //保存附件信息
        List<BizFiles> bizFiles =  bizFilesService.geBizFilesListByVos(equMorDetailVo.getBizFilesVoList()
                ,equRelTaskNo
                , BizCodeTypeEnums.EQU_MORTGAGE_REL_FILE.getCodeType(),true);
        bizFilesService.saveBizFilesList(bizFiles);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setWfLogNo(equRelTaskNo);
        workflowLog.setWfLogType(BizTypeEnums.RELIEF.getType());
        workflowLog.setRemark1(equMorDetailVo.getRemark1());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(SUBMIT.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);

    }

    /**
     * @Title:
     * @Description: 资方抵押解除申请(再次提交)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:06
     */
    @Override
    @Transactional
    public void modifyEquMorDetail(EquMorDetailVo equMorDetailVo, SysUser sysUser) {
        List<EquMorDetailVo> equMorDetailVoList= equMorDetailVo.getEquMorDetailVoList();
        //解押任务号
        // String equRelTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.RELIEF_NUM_TYPE.getType());
        ActRuTaskVo actRuTaskVo =  ActReleasedMortgageUtils.approvalAgree(equMorDetailVo.getTaskId());
        //更新解押任务表
        Example example = SqlUtil.newExample(EquRelTask.class);
        example.createCriteria().andEqualTo("equRelTaskNo",equMorDetailVo.getEquRelTaskNo());
        EquRelTask equRelTask = new EquRelTask();
        equRelTask.setReliefStatus(actRuTaskVo.getTaskCode());
        equRelTask.setPresentUser(actRuTaskVo.getNextAssignee());
        equRelTask.setDifferenceCharge(equMorDetailVo.getDifferenceCount());
        equRelTaskRepository.updateByExampleSelectiveData(equRelTask,example);
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorDetailVoList)){    //更新解押明细表
            for(EquMorDetailVo equMorDetail:equMorDetailVoList){
                if(equMorDetail.getReliefReceivAmount()==null)
                    equMorDetail.setReliefReceivAmount(new BigDecimal(0));
                if(equMorDetail.getReliefPenalty() == null)
                    equMorDetail.setReliefPenalty(new BigDecimal(0));
                if(equMorDetail.getReliefRestPrincipal() == null)
                    equMorDetail.setReliefRestPrincipal(new BigDecimal(0));
                if(equMorDetail.getReliefOtherCharge()==null)
                    equMorDetail.setReliefOtherCharge(new BigDecimal(0));
                if(equMorDetail.getReliefDifference() == null)
                    equMorDetail.setReliefDifference(new BigDecimal(0));
                equMorDetailRepository.updateByPrimaryKeySelectiveData(equMorDetail.getEntity());
            }
        }
        BigDecimal judge = new BigDecimal(0);
        if(equMorDetailVo.getDifferenceCount() == null)
            equMorDetailVo.setDifferenceCount(new BigDecimal(0));
        if(equMorDetailVo.getDifferenceCount().compareTo(judge)==1){   //差额总和大于0，录入财务待收款表
            Example example1 = SqlUtil.newExample(ContCharge.class);
            example1.createCriteria().andEqualTo("chargeBizId",equMorDetailVo.getEquRelTaskNo()).andEqualTo("chargeBizType",BizTypeEnums.RELIEF.getType());
            Example example2 = SqlUtil.newExample(ContPay.class);
            example2.createCriteria().andEqualTo("bizCode",equMorDetailVo.getEquRelTaskNo()).andEqualTo("paymentType",BizTypeEnums.RELIEF.getType());
            contPayRepository.deleteExampleData(example2,new ContPay());
            ContCharge contCharge  = contChargeRepository.selectOneByExample(example1);
            ContCharge jugContCharge = contCharge;
            if(jugContCharge == null){
                contCharge = new ContCharge();
            }
            contCharge.setChargeBizType(BizTypeEnums.RELIEF.getType());
            contCharge.setChargeBizId(equMorDetailVo.getEquRelTaskNo());
            contCharge.setChargeFund(PayFundNameEnums.RELIEF_RECEIPT.getType());
            contCharge.setChargeAmount(equMorDetailVo.getDifferenceCount());
            contCharge.setChargeStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
            if(jugContCharge == null){
                contChargeRepository.insertData(contCharge);
            }else{
                contChargeRepository.updateByExampleSelectiveData(contCharge,example1,true);
            }
        }else{                                //小于0，录入财务付款表
            Example example1 = SqlUtil.newExample(ContPay.class);
            example1.createCriteria().andEqualTo("bizCode",equMorDetailVo.getEquRelTaskNo()).andEqualTo("paymentType",BizTypeEnums.RELIEF.getType());
            ContPay contPay = contPayRepository.selectOneByExample(example1);
            ContPay jugContPay = contPay;
            if(jugContPay==null){
                contPay = new ContPay();
            }
            Example example2 = SqlUtil.newExample(ContCharge.class);
            example2.createCriteria().andEqualTo("chargeBizId",equMorDetailVo.getEquRelTaskNo()).andEqualTo("chargeBizType",BizTypeEnums.RELIEF.getType());
            contChargeRepository.deleteExampleData(example2,new ContCharge());
            contPay.setPaymentType(BizTypeEnums.RELIEF.getType());
            contPay.setPayFund(PayFundNameEnums.RELIEF_RECEIPT.getType());
            contPay.setBizCode(equMorDetailVo.getEquRelTaskNo());
            contPay.setPayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
            contPay.setPayAmount(equMorDetailVo.getDifferenceCount().abs());
            contPay.setRecAccBank(equMorDetailVo.getOpeningBank());
            contPay.setRecAccBranch(equMorDetailVo.getRecAccBranch());
            contPay.setRecAccountNo(equMorDetailVo.getAccountNo());
            contPay.setRecAccountName(equMorDetailVo.getAccountName());
            contPay.setRecEleBankNo(equMorDetailVo.getBankCode());
            if(jugContPay==null){
                contPayRepository.insertData(contPay);
            }else{
                contPayRepository.updateByExampleSelectiveData(contPay,example1);
            }
        }
        //保存附件信息
        bizFilesService.deleteBizFilesByBizCode(equMorDetailVo.getEquRelTaskNo(), BizCodeTypeEnums.EQU_MORTGAGE_REL_FILE.getCodeType());
        List<BizFiles> bizFiles =  bizFilesService.geBizFilesListByVos(equMorDetailVo.getBizFilesVoList()
                ,equMorDetailVo.getEquRelTaskNo()
                , BizCodeTypeEnums.EQU_MORTGAGE_REL_FILE.getCodeType(),true);
        bizFilesService.saveBizFilesList(bizFiles);
        //bizFilesService.updateBizFiles(equMorDetailVo.getCommonBizFilesVo().getBizFilesListVos(),equMorDetailVo.getEquRelTaskNo(), BizCodeTypeEnums.EQU_MORTGAGE_REL_FILE.getCodeType());
        //启动工作流
        // ActRuTaskVo actRuTaskVo =  ActReleasedMortgageUtils.startReleasedMortgageAndWaitReview(equRelTaskNo,ReliefTaskStatusEnums.RELEASED_MORTGAGE.getDesc(),ReliefTaskStatusEnums.RELEASED_MORTGAGE.getType());
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(equMorDetailVo.getEquRelTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.RELIEF.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(equMorDetailVo.getRemark1());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(SUBMIT.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);

    }

    /**
     * @Title:
     * @Description: 资方抵押明细一览
     * @param equMorDetailVo
     * @return PageInfoExtend<EquMorDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:06
     */
    @Override
    public PageInfoExtend<EquMorDetailVo> findEquMorDetailVosByPage(EquMorDetailVo equMorDetailVo) {
        equMorDetailVo.setApplyTypePer(ApplyTypeEnums.PERSON.getType());
        if(StringUtils.isNotTrimBlank(equMorDetailVo.getMainContNo()))
            equMorDetailVo.setMainContNo(SqlUtil.likePattern(equMorDetailVo.getMainContNo()));
        else
            equMorDetailVo.setMainContNo(null);
        if(StringUtils.isNotTrimBlank(equMorDetailVo.getServiceType()))
            equMorDetailVo.setServiceType(equMorDetailVo.getServiceType());
        else
            equMorDetailVo.setServiceType(null);
        if(StringUtils.isNotTrimBlank(equMorDetailVo.getVinNo()))
            equMorDetailVo.setVinNo(SqlUtil.likePattern(equMorDetailVo.getVinNo()));
        else
            equMorDetailVo.setVinNo(null);
        if(StringUtils.isNotTrimBlank(equMorDetailVo.getLessee()))
            equMorDetailVo.setLessee(SqlUtil.likePattern(equMorDetailVo.getLessee()));
        else
            equMorDetailVo.setLessee(null);
        //还款状态
        if(StringUtils.isTrimBlank(equMorDetailVo.getPaymentSts()))
            equMorDetailVo.setPaymentSts(null);
        else
            equMorDetailVo.setPaymentSts(equMorDetailVo.getPaymentSts());
        //抵押状态
        if(StringUtils.isTrimBlank(equMorDetailVo.getMortgageStatus()))
            equMorDetailVo.setMortgageStatus(null);
        else
            equMorDetailVo.setMortgageStatus(equMorDetailVo.getMortgageStatus());
//        String  mortgageDueDays = null;
//        try {
//            mortgageDueDays =  ResponseEntityUtils.getRestResponseData(sysParamRpc.findSysParamByParamKey(CommonParamConstants.MORTGAGE_DUE_DAYS));
//        } catch (FmsRpcException ex) {
//            log.error(ex.getMessage());
//            ex.printStackTrace();
//            throw  new FmsServiceException("获取系统常量失败");
//        }
//        Calendar calendar =  Calendar.getInstance();
//        String jugDay =  DateUtils.dateToStr(DateUtils.getAddDay(calendar.getTime(),mortgageDueDays),DateUtils.formatStr_yyyyMMdd);
//        equMorDetailVo.setJugDay(jugDay);
        /*equMorDetailVo.setMortgageStatus(MortgageStatusEnums.EQU_MOR_SUCCESS.getStatus());*/
        //抵押状态集合
        List<String> mortgageStatusList = new ArrayList<>();
        //已抵押
        mortgageStatusList.add(MortgageStatusEnums.EQU_MOR_SUCCESS.getStatus());
        //解抵押完成
        mortgageStatusList.add(MortgageStatusEnums.EQU_REL.getStatus());
        //解抵押中
        mortgageStatusList.add(MortgageStatusEnums.RESOLVING_RELIEF.getStatus());
        equMorDetailVo.setMortgageStatusList(mortgageStatusList);
        return equMorDetailRepository.selectListVoByPage("selectEquMorDetailVosByPage",equMorDetailVo,equMorDetailVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description:   保存资方抵押明细
     * @param equMorDetail
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 05:59:24
     */
    public void saveEquMorDetail(EquMorDetail equMorDetail){
        equMorDetailRepository.insertData(equMorDetail);
    }

    /**
     * @Title:
     * @Description:   保存资方抵押明细集合
     * @param equMorDetails
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 05:59:24
     */
    @Transactional
    public void saveEquMorDetails(List<EquMorDetail> equMorDetails){
        equMorDetailRepository.insertDataList(equMorDetails);
    }

    /**
     * @Title:
     * @Description: 审核通过到制单或确认收款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-3 17:02:06
     */
    @Override
    @Transactional
    public void approvalToVoucher(EquMorDetailVo equMorDetailVo,SysUser sysUser) {
        BigDecimal jug = new BigDecimal(0);
        ActRuTaskVo actRuTaskVo;
        if(equMorDetailVo.getDifferenceCount().compareTo(jug)==1){
            actRuTaskVo =  ActReleasedMortgageUtils.approvalAgreeToReceipt(equMorDetailVo.getTaskId());
        }else if(equMorDetailVo.getDifferenceCount().compareTo(jug)==-1||equMorDetailVo.getDifferenceCount().compareTo(jug)==0){
            actRuTaskVo=  ActReleasedMortgageUtils.approvalAgreeToVoucher(equMorDetailVo.getTaskId());
        }else{
            throw new FmsServiceException("failure");
        }
        //更新task表
        modifyReliefTask(equMorDetailVo,actRuTaskVo,sysUser,APPROVAL.getType());
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-3 17:02:06
     */
    @Override
    @Transactional
    public void sendBack(EquMorDetailVo equMorDetailVo,SysUser sysUser) {
        ActRuTaskVo actRuTaskVo =   ActReleasedMortgageUtils.approvalReturnSuperior(equMorDetailVo.getTaskId());
        //更新task表
        modifyReliefTask(equMorDetailVo,actRuTaskVo,sysUser,SENDBACK.getType());
    }

    /**
     * @Title:
     * @Description: 制单
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-3 17:02:06
     */
    @Override
    @Transactional
    public void approvalVoucher(EquMorDetailVo equMorDetailVo,SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActReleasedMortgageUtils.approvalAgree(equMorDetailVo.getTaskId());
        modifyReliefTask(equMorDetailVo,actRuTaskVo,sysUser,APPROVAL.getType());
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("paymentType",BizTypeEnums.RELIEF.getType()).andEqualTo("bizCode",equMorDetailVo.getEquRelTaskNo());
        ContPay contPay = new ContPay();
        contPay.setPayAccBank(equMorDetailVo.getPayAccBank());
        contPay.setPayAccBranch(equMorDetailVo.getPayAccBranch());
        contPay.setPayAccountNo(equMorDetailVo.getPayAccountNo());
        contPay.setPayAccountName(equMorDetailVo.getPayAccountName());
        contPay.setPayEleBankNo(equMorDetailVo.getPayEleBankNo());
        contPay.setPayStatus(RepayStatusEnums.WITHDRAWING.getType());
        contPayRepository.updateByExampleSelectiveData(contPay,example);
    }

    /**
     * @Title:
     * @Description: 财务付款
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-3 17:02:06
     */
    @Override
    @Transactional
    public void approvalFinance(EquMorDetailVo equMorDetailVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActReleasedMortgageUtils.approvalAgree(equMorDetailVo.getTaskId());
        modifyReliefTask(equMorDetailVo,actRuTaskVo,sysUser,APPROVAL.getType());
    }

    /**
     * @Title:
     * @Description: 财务确认收款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @Override
    @Transactional
    public void approvalReceipt(EquMorDetailVo equMorDetailVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActReleasedMortgageUtils.approvalAgree(equMorDetailVo.getTaskId());
        modifyReliefTask(equMorDetailVo,actRuTaskVo,sysUser,APPROVAL.getType());
        List<EquMorDetailVo> equMorDetailVos = equMorDetailVo.getEquMorDetailVoList();
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorDetailVos)){
            List<ContReceipt> contReceiptList = new ArrayList<>();
            List<ContReceiptExam> contReceiptExamList = new ArrayList<>();
            for(EquMorDetailVo equMorDetail:equMorDetailVos){
                //插入财务付款表
                ContReceipt contReceipt = new ContReceipt();
                contReceipt.setContReceiptId(UUIDUtils.getUUID());
                contReceipt.setInputMode(InputModeEnums.INPUT.getType());
                contReceipt.setReceiptAmount(equMorDetail.getReceiptAmount());
                contReceipt.setRecAccBank(equMorDetail.getOpeningBank());
                contReceipt.setRecAccBranch(equMorDetail.getRecAccBranch());
                contReceipt.setRecAccountName(equMorDetail.getAccountName());
                contReceipt.setRecAccountNo(equMorDetail.getAccountNo());
                contReceipt.setRecEleBankNo(equMorDetail.getBankCode());
                contReceipt.setRestAmount(new BigDecimal(0));
                contReceipt.setReceiptDate(equMorDetail.getReceiptDate());
                contReceipt.setMemo(equMorDetail.getMemo());
                contReceiptList.add(contReceipt);
                //contReceiptRepository.insertData(contReceipt);
                //插入财务勾稽表
                ContReceiptExam contReceiptExam  =  new ContReceiptExam();
                contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType());
                Example example = SqlUtil.newExample(ContCharge.class);
                example.createCriteria().andEqualTo("chargeBizId",equMorDetailVo.getEquRelTaskNo()).andEqualTo("chargeBizType",BizTypeEnums.RELIEF.getType());
                ContCharge contCharge = contChargeRepository.selectOneByExample(example);
                contReceiptExam.setReceiptBizId(contCharge.getContChargeId());
                contReceiptExam.setContReceiptId(contReceipt.getContReceiptId());
                contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());   //勾稽类型
                contReceiptExam.setReceiptExamAmount(equMorDetail.getReceiptAmount());
                contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());
                contReceiptExamList.add(contReceiptExam);
                //contReceiptExamRepository.insertData(contReceiptExam);
            }
            contReceiptRepository.insertDataList(contReceiptList);
            contReceiptExamRepository.insertDataList(contReceiptExamList);
        }


    }

    /**
     * @Title:
     * @Description: 解抵押确认
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @Override
    @Transactional
    public void approvalConfirm(EquMorDetailVo equMorDetailVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo =  ActReleasedMortgageUtils.approvalAgree(equMorDetailVo.getTaskId());
        modifyReliefTask(equMorDetailVo,actRuTaskVo,sysUser,APPROVAL.getType());
        EquMorDetail equMorDetail = new EquMorDetail();
        equMorDetail.setMortgageStatus(MortgageStatusEnums.EQU_REL.getStatus());
        Example example = SqlUtil.newExample(EquMorDetail.class);
        example.createCriteria().andEqualTo("equRelTaskNo",equMorDetailVo.getEquRelTaskNo());
        equMorDetailRepository.updateByExampleSelectiveData(equMorDetail,example);
        //保存附件
        List<BizFiles> bizFilesList = new ArrayList<>();
        for (EquMorDetailVo equMorDetailVo1 : equMorDetailVo.getEquMorDetailVoList()) {
            List<BizFiles> bizFilesListTmp = bizFilesService.geBizFilesListByVos(equMorDetailVo1.getBizFilesVoList()
                    ,equMorDetailVo1.getEquMorDetailId()
                    , BizCodeTypeEnums.EQU_MORTGAGE_REL_CONF_FILE.getCodeType(),true);
            bizFilesList.addAll(bizFilesListTmp);
        }
        bizFilesService.saveBizFilesList(bizFilesList);
    }

    /**
     * @Title:
     * @Description: 更新解押task表(共通)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-3 17:02:06
     */
    public void modifyReliefTask(EquMorDetailVo equMorDetailVo,ActRuTaskVo actRuTaskVo,SysUser sysUser,String ActType){
        Example example = SqlUtil.newExample(EquRelTask.class);
        example.createCriteria().andEqualTo("equRelTaskNo",equMorDetailVo.getEquRelTaskNo());
        EquRelTask equRelTask = new EquRelTask();
        equRelTask.setReliefStatus(actRuTaskVo.getTaskCode());
        equRelTask.setPresentUser(actRuTaskVo.getNextAssignee());
        equRelTaskRepository.updateByExampleSelectiveData(equRelTask,example);
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(equMorDetailVo.getEquRelTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.RELIEF.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(equMorDetailVo.getRemark1());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(ActType);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description:   根据抵押任务号查找抵押明细列表
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 04:09:29
     */
    public List<EquMorDetail> findEquMorDetailsByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo)) {
            Example example = SqlUtil.newExample(EquMorDetail.class);
            example.createCriteria().andEqualTo("equMorTaskNo", equMorTaskNo);
            return equMorDetailRepository.selectListByExample(example);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   批量更新抵押明细
     * @param equMorDetails
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 04:50:04
     */
    @Transactional
    public void modifyEquMorDetails(List<EquMorDetail> equMorDetails){
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorDetails))
            equMorDetailRepository.updateByPrimaryKeySelectiveDataList(equMorDetails);
    }

    /**
     * @Title:
     * @Description: 资方抵押资料上传
     * @param equMorArchiveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 05:45:39
     */
    @Transactional
    public void equMorArchive(EquMorArchiveVo equMorArchiveVo){
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorArchiveVo.getEquMorDetailArchiveVos())) {
            String equMorTaskNo = equMorArchiveVo.getEquMorTaskNo();
            //用作删除之前提交的附件
            List<String> equMorDetailIds = new ArrayList<>();
            //保存每条明细
            List<EquMorDetail> equMorDetails = new ArrayList<>();
            //所有的附件集合，批量保存
            List<BizFiles> bizFilesList = new ArrayList<>();
            for (EquMorDetailArchiveVo equMorDetailArchiveVo : equMorArchiveVo.getEquMorDetailArchiveVos()) {
                equMorDetails.add(equMorDetailArchiveVo.getEntity());
                //保存附件
                bizFilesList.addAll(bizFilesService.geBizFilesListByVos(equMorDetailArchiveVo.getBizFilesList()
                        , equMorDetailArchiveVo.getEquMorDetailId()
                        ,BizCodeTypeEnums.EQU_MOR_FILE.getCodeType(),true));
                equMorDetailIds.add(equMorDetailArchiveVo.getEquMorDetailId());
            }

            //防止二次提交,删除之前的附件
            bizFilesService.deleteBizFilesList(equMorDetailIds,BizCodeTypeEnums.EQU_MOR_FILE.getCodeType());
            equMorDetailRepository.updateByPrimaryKeySelectiveDataList(equMorDetails,true);
            bizFilesService.saveBizFilesList(bizFilesList);
            ActRuTaskVo actRuTaskVo =  ActEquMorUtils.approvalAgree(equMorArchiveVo.getTaskId(),
                    equMorArchiveVo.getTaskDefinitionKey(),
                    equMorArchiveVo.getMemo(),
                    equMorArchiveVo.getEquMorTaskNo()

            );
            //如果完成了流程,需要将抵押状态修改成已抵押
            if(actRuTaskVo.getEndFlag())
                modifyEquMorSuccessStatusByEquMorTaskNo(equMorTaskNo);
                insertEquMorRepayDetailList(equMorTaskNo);
            }else{
              throw new FmsServiceException("请上传资料");
             }
    }

    /**
     * @Title:
     * @Description:  资产抵押还款计划详情表插入数据
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018/06/12 10:12:45
     */
    public  void insertEquMorRepayDetailList(String equMorTaskNo){
        //录入资方抵押还款计划明细表
        List<EquMorRepayDetailVo> equMorRepayDetailVos = equMorRepayDetailRepository.selectEquMorRepayDetailVosByEquTaskNo(equMorTaskNo);
        if (ArrayUtils.isNotNullAndLengthNotZero(equMorRepayDetailVos)){
            //资产抵押还款明细
            List<EquMorRepayDetail> equMorRepayDetailList = new ArrayList<>();
            for (EquMorRepayDetailVo equMorRepayDetailVo: equMorRepayDetailVos) {
                if (equMorRepayDetailVo.getLeasePeriod() >0){
                    for (int i = 1; i <= equMorRepayDetailVo.getLeasePeriod(); i++) {
                        EquMorRepayDetailVo  repayDetailVo = new EquMorRepayDetailVo();//合同号
                        repayDetailVo.setClientContNo(equMorRepayDetailVo.getClientContNo());
                        //抵押任务号
                        repayDetailVo.setEquMorTaskNo(equMorRepayDetailVo.getEquMorTaskNo());
                        //车架号
                        repayDetailVo.setVinNo(equMorRepayDetailVo.getVinNo());
                        //租金
                        repayDetailVo.setRent(equMorRepayDetailVo.getRent());
                        //还款状态
                        repayDetailVo.setEquRepayStatus(EquMorRepayDetailEnums.UNPAY.getType());

                        //应还日期
                        repayDetailVo.setRepayDate(DateUtils.getAddMonth(equMorRepayDetailVo.getEquStartDate(),i-1));
                        //期数
                        repayDetailVo.setPeriod(i);

                        if (!equMorRepayDetailVo.getEquEndDate().after(repayDetailVo.getRepayDate())){
                            //表示前面小于后面的
                            equMorRepayDetailList.add(repayDetailVo.getEntity());
                        }else  {
                            break;
                        }
                    }
                }
            }
            equMorRepayDetailRepository.insertDataList(equMorRepayDetailList);
        }

    }

    /**
     * @Title:
     * @Description:   资方抵押资料复核
     * @param equMorDetailsInfoReviewVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:19:09
     */
    public void equMorArchiveReview(EquMorDetailsInfoReviewVo equMorDetailsInfoReviewVo){
        ActEquMorUtils.approvalAgree(equMorDetailsInfoReviewVo.getTaskId(),
                equMorDetailsInfoReviewVo.getTaskDefinitionKey(),
                equMorDetailsInfoReviewVo.getMemo(),
                equMorDetailsInfoReviewVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description:   根据抵押任务编号 查询抵押明细列表
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 11:13:30
     */
    public List<EquMorDetailVo> findEquMorDetailVosByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo))
            return equMorDetailRepository.selectEquMorDetailVosByEquMorTaskNo(OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType(), equMorTaskNo,ApplyTypeEnums.PERSON.getType(), ContDetailFlagEnums.TOTAL.getFlag());
        return null;
    }

    /**
     * @Title:
     * @Description:   根据抵押任务编号 查询抵押明细列表 并且带出文件详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 11:13:30
     */
    public List<EquMorDetailVo> findEquMorDetailVosAndFileByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo)) {
            //查询抵押明细
            List<EquMorDetailVo> equMorDetailVos = equMorDetailRepository.selectEquMorDetailVosByEquMorTaskNo(OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType(), equMorTaskNo, ApplyTypeEnums.PERSON.getType(), ContDetailFlagEnums.TOTAL.getFlag());
            //每条明细的附件信息
            for (EquMorDetailVo equMorDetailVo : equMorDetailVos) {
                equMorDetailVo.setBizFilesList(bizFilesService.findBizFilesList(equMorDetailVo.getEquMorDetailId(), BizCodeTypeEnums.EQU_MOR_FILE.getCodeType()));
            }
            return equMorDetailVos;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   修改抵押详情
     * @param equMorDetail
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 03:18:42
     */
    public void modifyEquMorDetail(EquMorDetail equMorDetail){
        if(equMorDetail != null)
            equMorDetailRepository.updateByPrimaryKeySelectiveData(equMorDetail,true);
    }


    /**
     * @Title:
     * @Description: 根据资方抵押任务获取一条抵押详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 02:59:10
     */
    public EquMorDetail findEquMorDetailByEquMorTaskNo(String equMorTaskNo){
        EquMorDetail equMorDetail = null;
        if(StringUtils.isNotTrimBlank(equMorTaskNo)) {
            Example example = SqlUtil.newExample(EquMorDetail.class);
            example.createCriteria().andEqualTo("equMorTaskNo", equMorTaskNo);
            List<EquMorDetail> equMorDetails = equMorDetailRepository.selectListByExample(example);
            if (ArrayUtils.isNotNullAndLengthNotZero(equMorDetails) && equMorDetails.size() > 1)
                throw new FmsServiceException("获取到多条抵押任务详情");
            equMorDetail = equMorDetails.get(0);
        }
        return equMorDetail;
    }

    /**
     * @Title:  
     * @Description: 根据抵押任务号更新抵押状态为抵押中
     * @param:  equMorTaskNo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/12 0012 15:35
     */
    @Transactional
    public void modifyEquMorStatusByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo))
            modifyMortgageStatusByEquMorTaskNo(MortgageStatusEnums.EQU_MOR.getStatus(),equMorTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号更新抵押状态为取消
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/12 0012 15:35
     */
    @Transactional
    public void modifyCancelStatusByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo))
            modifyMortgageStatusByEquMorTaskNo(MortgageStatusEnums.CANCEL.getStatus(),equMorTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号更新抵押状态为无效
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/12 0012 15:35
     */
    @Transactional
    public void modifyInvalidStatusByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo))
            modifyMortgageStatusByEquMorTaskNo(MortgageStatusEnums.INVALID.getStatus(),equMorTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号更新抵押状态为已完成
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/17 0017 15:31
     */
    @Transactional
    public void modifyEquMorSuccessStatusByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo))
            modifyMortgageStatusByEquMorTaskNo(MortgageStatusEnums.EQU_MOR_SUCCESS.getStatus(),equMorTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号更新抵押状态
     * @param mortgageStatus 抵押状态
     * @param equMorTaskNo 抵押任务号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 04:53:06
     */
    private void modifyMortgageStatusByEquMorTaskNo(String mortgageStatus,String equMorTaskNo){
        if(StringUtils.isTrimBlank(mortgageStatus))
            throw new FmsServiceException("抵押状态不能为空");
        if(StringUtils.isTrimBlank(equMorTaskNo))
            throw new FmsServiceException("抵押任务号不能为空");
        Example example = SqlUtil.newExample(EquMorDetail.class);
        example.createCriteria().andEqualTo("equMorTaskNo",equMorTaskNo);
        EquMorDetail equMorDetail = new EquMorDetail();
        equMorDetail.setMortgageStatus(mortgageStatus);
        equMorDetailRepository.updateByExampleSelectiveData(equMorDetail,example);
    }

    /**
     * @Title:
     * @Description: 资方解压付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    @Transactional
    public String printEquRel(EquMorDetailVo equMorDetailVo){
        if(equMorDetailVo == null){
            throw new FmsServiceException("未找到相关数据");
        }
        if(equMorDetailVo.getEquMorDetailVoList() == null){
            throw new FmsServiceException("未找到相关数据");
        }

        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(equMorDetailVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        if(equMorDetailVo.getDifferenceCount()!=null){
            pdfVariables.put("differenceCount", StringUtils.defaultString(equMorDetailVo.getDifferenceCount().toString()));
        }
        pdfVariables.put("recAccountName", equMorDetailVo.getAccountName());
        pdfVariables.put("recAccountNo", equMorDetailVo.getAccountNo());
        pdfVariables.put("recAccBranch", equMorDetailVo.getOpeningBank()+" "+equMorDetailVo.getRecAccBranch());
        pdfVariables.put("payAccountName", equMorDetailVo.getPayAccountName());
        if(equMorDetailVo.getPayAccBank()!=null&&equMorDetailVo.getPayAccBranch()!=null){
            pdfVariables.put("payAccBranch", equMorDetailVo.getPayAccBank()+" "+equMorDetailVo.getPayAccBranch());
        }
        pdfVariables.put("payAccountNo", equMorDetailVo.getPayAccountNo());
        //pdfVo封装pdf附件中客户相关信息
        PdfCreateVo pdfCreateVo=new PdfCreateVo();
        //pdf附件每页显示客户信息条数
        pdfCreateVo.setPageSize(30);
        // 附件信息(客户信息相关键值对)
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < equMorDetailVo.getEquMorDetailVoList().size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no", i + 1);
            jsonObject.put("chuzu", equMorDetailVo.getEquMorDetailVoList().get(i).getLessor());
            jsonObject.put("chengzu", equMorDetailVo.getEquMorDetailVoList().get(i).getLessee());
            jsonObject.put("chejiahao", equMorDetailVo.getEquMorDetailVoList().get(i).getVinNo());
            jsonArray.add(jsonObject);
        }
        pdfCreateVo.setFjDataArray(jsonArray);

        //输出pdf
        String filePath = commonPdfService.createWithFj(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_EQU_REL.getType(),TplTypeKeyEnums.WL_PAYMENT_FJ.getType(),pdfCreateVo);
        return filePath;
    }
}