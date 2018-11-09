package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActPilferMonthlyUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.ApproveFlagEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayFundNameEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.cost.service.MonthlyPilferInsuranceService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.MonthlyPilferInsuranceRepository;
import cn.com.leadu.fms.data.cost.repository.PilferInsuranceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.MonthlyPilferInsuranceVo;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.MonthlyPilferInsuranceSaveVo;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.MonthlyPilferInsuranceModifyVo;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.MonthlyPilferInsuranceDeleteVo;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.MonthlyPilferInsuranceDeleteListVo;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceService
 * @Description: 盗抢险月结任务信息业务实现层
 * @date 2018-05-31
 */
@Service
public class MonthlyPilferInsuranceServiceImpl implements MonthlyPilferInsuranceService {

    /**
     * @Fields  : 业务编号管理
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 盗抢险月结任务信息repository
     */
    @Autowired
    private MonthlyPilferInsuranceRepository monthlyPilferInsuranceRepository;

    /**
     * @Fields  : 盗抢险信息repository
     */
    @Autowired
    private PilferInsuranceRepository pilferInsuranceRepository;

    /**
     * @Fields  : 财务付款表repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 审批日志录入service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询盗抢险月结任务信息
     * @param monthlyPilferInsuranceVo
     * @return PageInfoExtend<MonthlyPilferInsurance>
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    public PageInfoExtend<MonthlyPilferInsurance> findMonthlyPilferInsurancesByPage(MonthlyPilferInsuranceVo monthlyPilferInsuranceVo){
        Example example = SqlUtil.newExample(MonthlyPilferInsurance.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<MonthlyPilferInsurance> pageInfo = monthlyPilferInsuranceRepository.selectListByExamplePage(example,monthlyPilferInsuranceVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存盗抢险月结任务信息
     * @param monthlyPilferInsuranceSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    public void saveMonthlyPilferInsurance(MonthlyPilferInsuranceSaveVo monthlyPilferInsuranceSaveVo){
        monthlyPilferInsuranceRepository.insertData(monthlyPilferInsuranceSaveVo.getEntity());
    }

    /**
     * @param monthlyPilferInsuranceVo
     * @Description: 保存盗抢险月结任务信息，包括盗抢险信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/31 20:41
     */
    @Override
    @Transactional
    public void saveMonthlyPilferInsuranceWithPI(MonthlyPilferInsuranceVo monthlyPilferInsuranceVo) {
        MonthlyPilferInsurance monthlyPilferInsurance = new MonthlyPilferInsurance();
        if (StringUtils.isTrimBlank(monthlyPilferInsuranceVo.getMonthlyPilferInsuranceNo())) {//如果月结号不存在
            //获取新的月结号
            String newMonthlyPilferInsuranceNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.MONTHLY_PILFER_INSURANCE_NUM_TYPE.getType());
            monthlyPilferInsurance.setMonthlyPilferInsuranceNo(newMonthlyPilferInsuranceNo);
            //保存附件信息
            bizFilesService.modifyBizFilesList(monthlyPilferInsuranceVo.getBizFilesList(),newMonthlyPilferInsuranceNo,
                    BizCodeTypeEnums.PILFER_INSURANC_EMONTHLY_FILE.getCodeType());
        }else{
            //设置月结号
            monthlyPilferInsurance.setMonthlyPilferInsuranceNo(monthlyPilferInsuranceVo.getMonthlyPilferInsuranceNo());
            //保存附件信息
            bizFilesService.modifyBizFilesList(monthlyPilferInsuranceVo.getBizFilesList(),monthlyPilferInsuranceVo.getMonthlyPilferInsuranceNo(),
                    BizCodeTypeEnums.PILFER_INSURANC_EMONTHLY_FILE.getCodeType());
        }

        //计算月结总金额
        BigDecimal totalCost = new BigDecimal("0");
        for(PilferInsurance pilferInsurance:monthlyPilferInsuranceVo.getPilferInsurances()){
            //为明细设置月结号
            pilferInsurance.setMonthlyPilferInsuranceNo(monthlyPilferInsurance.getMonthlyPilferInsuranceNo());
            totalCost = totalCost.add(pilferInsurance.getBillPilferInsuranceCost());
        }
        if (totalCost.compareTo(monthlyPilferInsuranceVo.getTotalCost()) != 0) {
            throw new FmsServiceException("月结总金额计算有误！");
        }
        monthlyPilferInsurance.setTotalCost(totalCost);

        if (StringUtils.isTrimBlank(monthlyPilferInsuranceVo.getMonthlyPilferInsuranceNo())) {//如果月结号不存在
            //插入月结数据
            monthlyPilferInsuranceRepository.insertData(monthlyPilferInsurance);
        }else{
            //更新月结数据
            Example example = SqlUtil.newExample(MonthlyPilferInsurance.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("monthlyPilferInsuranceNo",monthlyPilferInsurance.getMonthlyPilferInsuranceNo());
            monthlyPilferInsuranceRepository.updateByExampleSelectiveData(monthlyPilferInsurance,example);
        }
        //保存gps月结明细数据
        pilferInsuranceRepository.updateByPrimaryKeySelectiveDataList(monthlyPilferInsuranceVo.getPilferInsurances());

        //保存财务付款表
        ContPay contPay = new ContPay();
        contPay.setPaymentType(BizTypeEnums.THEFT_MONTHLY.getType());//盗抢险月结
        contPay.setBizCode(monthlyPilferInsurance.getMonthlyPilferInsuranceNo());
        contPay.setPayStatus(PayStatusEnums.CONFIRM.getType());//待付款
        contPay.setPayAmount(totalCost);
        contPay.setPayFund(PayFundNameEnums.PILFER_INSURANCE_COST.getType());//款项名称
        contPay.setRecAccBank(monthlyPilferInsuranceVo.getRecAccBank());
        contPay.setRecAccBranch(monthlyPilferInsuranceVo.getRecAccBranch());
        contPay.setRecAccountName(monthlyPilferInsuranceVo.getRecAccountName());
        contPay.setRecAccountNo(monthlyPilferInsuranceVo.getRecAccountNo());
        contPay.setRecEleBankNo(monthlyPilferInsuranceVo.getRecEleBankNo());
        if (StringUtils.isTrimBlank(monthlyPilferInsuranceVo.getMonthlyPilferInsuranceNo())) {//如果月结号不存在
            //插入付款数据
            contPayRepository.insertData(contPay);
        }else{
            //更新付款数据
            Example example = SqlUtil.newExample(ContPay.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("bizCode",monthlyPilferInsurance.getMonthlyPilferInsuranceNo());
            criteria.andEqualTo("paymentType",BizTypeEnums.THEFT_MONTHLY.getType());
            contPayRepository.updateByExampleSelectiveData(contPay,example);
        }

        //工作流引擎
        ActRuTaskVo actRuTaskVo = null;
        if(StringUtils.isTrimBlank(monthlyPilferInsuranceVo.getTaskId())){//任务id为空，新开始工作流
            //工作流引擎
            actRuTaskVo = ActPilferMonthlyUtils.startMonthlyAndSubmit(monthlyPilferInsurance.getMonthlyPilferInsuranceNo(),"1","盗抢险月结");
        }else{//任务id不为空，继续工作流
            //流程引擎
            actRuTaskVo = ActPilferMonthlyUtils.approvalAgree(monthlyPilferInsuranceVo.getTaskId());
        }
        //日志记录,状态记录
        PilferInsuranceApproveVo pilferInsuranceApproveVo = new PilferInsuranceApproveVo();
        pilferInsuranceApproveVo.setMonthlyPilferInsuranceNo(monthlyPilferInsurance.getMonthlyPilferInsuranceNo());
        pilferInsuranceApproveVo.setUser(monthlyPilferInsuranceVo.getPresentUser());
        this.approveCommon(pilferInsuranceApproveVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 修改盗抢险月结任务信息
     * @param monthlyPilferInsuranceModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    public void modifyMonthlyPilferInsurance(MonthlyPilferInsuranceModifyVo monthlyPilferInsuranceModifyVo){
        monthlyPilferInsuranceRepository.updateByPrimaryKeySelectiveData(monthlyPilferInsuranceModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过monthlyPilferInsuranceId删除盗抢险月结任务信息
     * @param monthlyPilferInsuranceDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    public void deleteMonthlyPilferInsurance(MonthlyPilferInsuranceDeleteVo monthlyPilferInsuranceDeleteVo){
        monthlyPilferInsuranceRepository.deleteData(monthlyPilferInsuranceDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过monthlyPilferInsuranceId集合删除盗抢险月结任务信息
     * @param monthlyPilferInsuranceDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    public void deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds(MonthlyPilferInsuranceDeleteListVo monthlyPilferInsuranceDeleteListVo){
        monthlyPilferInsuranceRepository.deleteDataList(monthlyPilferInsuranceDeleteListVo.getMonthlyPilferInsuranceIds(),monthlyPilferInsuranceDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据monthlyPilferInsuranceId获取盗抢险月结任务信息
     * @param monthlyPilferInsuranceId
     * @return MonthlyPilferInsurance
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    public MonthlyPilferInsurance findMonthlyPilferInsuranceByMonthlyPilferInsuranceId(String monthlyPilferInsuranceId){
        return monthlyPilferInsuranceRepository.selectByPrimaryKey(monthlyPilferInsuranceId);
    }

    /**
     * @param monthlyPilferInsuranceNo
     * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/1 11:41
     */
    @Override
    public MonthlyPilferInsurance findMonthlyPilferInsuranceByPilferInsuranceNo(String monthlyPilferInsuranceNo) {
        Example example = SqlUtil.newExample(MonthlyPilferInsurance.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("monthlyPilferInsuranceNo",monthlyPilferInsuranceNo);
        return monthlyPilferInsuranceRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息(含附件)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    public MonthlyPilferInsuranceVo findMonthlyPilferInsuranceVoByPilferInsuranceNo(String monthlyPilferInsuranceNo) {
        Example example = SqlUtil.newExample(MonthlyPilferInsurance.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("monthlyPilferInsuranceNo",monthlyPilferInsuranceNo);
        MonthlyPilferInsurance monthlyPilferInsurance = monthlyPilferInsuranceRepository.selectOneByExample(example);
        MonthlyPilferInsuranceVo monthlyPilferInsuranceVo = EntityUtils.getEntity(monthlyPilferInsurance, new MonthlyPilferInsuranceVo());
        //查询附件
        monthlyPilferInsuranceVo.setBizFilesList(bizFilesService.findBizFilesList(monthlyPilferInsuranceNo, BizCodeTypeEnums.PILFER_INSURANC_EMONTHLY_FILE.getCodeType()));
        return monthlyPilferInsuranceVo;
    }

    /**
     * @param pilferInsuranceApproveVo
     * @Description: 审批操作
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/1 11:54
     */
    @Override
    @Transactional
    public void approval(PilferInsuranceApproveVo pilferInsuranceApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        String act = "";
        //流程引擎
        if(ApproveFlagEnums.SUBMIT.getType().equals(pilferInsuranceApproveVo.getApprovalFlag())){//通过
            act = ActTypeEnums.APPROVAL.getType();
            actRuTaskVo = ActPilferMonthlyUtils.approvalAgree(pilferInsuranceApproveVo.getTaskId());
        }else if(ApproveFlagEnums.BACK.getType().equals(pilferInsuranceApproveVo.getApprovalFlag())){//退回
            act = ActTypeEnums.SENDBACK.getType();
            actRuTaskVo = ActPilferMonthlyUtils.approvalReturnSuperior(pilferInsuranceApproveVo.getTaskId());
        }else{
            throw new FmsServiceException("没有对应的操作");
        }
        //审批操作
        this.approveCommon(pilferInsuranceApproveVo,act,actRuTaskVo);

    }

    /** 
    * @Description: 审批共同操作 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/5 21:03
    */ 
    private void approveCommon(PilferInsuranceApproveVo pilferInsuranceApproveVo, String act, ActRuTaskVo actRuTaskVo){
        //审批操作
        //根据任务号取得盗抢险月结信息
        MonthlyPilferInsurance monthlySettlement = this.findMonthlyPilferInsuranceByPilferInsuranceNo(pilferInsuranceApproveVo.getMonthlyPilferInsuranceNo());
        if(monthlySettlement == null){
            throw new FmsServiceException( "盗抢险月结信息不存在");
        }
        //更新状态
        String contractBizStatusUpd = actRuTaskVo.getTaskCode();
        MonthlyPilferInsuranceModifyVo monthlyPilferInsuranceModifyVo = new MonthlyPilferInsuranceModifyVo();
        monthlyPilferInsuranceModifyVo.setMonthlyPilferInsuranceSts(contractBizStatusUpd);
        monthlyPilferInsuranceModifyVo.setMonthlyPilferInsuranceId(monthlySettlement.getMonthlyPilferInsuranceId());
        //当前节点用户
        monthlyPilferInsuranceModifyVo.setPresentUser(actRuTaskVo.getNextAssignee());
        this.modifyMonthlyPilferInsurance(monthlyPilferInsuranceModifyVo);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(pilferInsuranceApproveVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(pilferInsuranceApproveVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.THEFT_MONTHLY.getType());
        workflowLog.setWfLogNo(pilferInsuranceApproveVo.getMonthlyPilferInsuranceNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

}
