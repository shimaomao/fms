package cn.com.leadu.fms.insurance.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActInsurClaimCheckUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.*;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.InputModeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayFundNameEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.InsurClaimStatusEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.ReturnModeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehMaintainEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.insurance.repository.ContInsurClaimRepository;
import cn.com.leadu.fms.data.postbiz.repository.VehMaintainRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.insurance.rpc.prebiz.BizFilesRpc;
import cn.com.leadu.fms.insurance.service.ContInsurClaimService;
import cn.com.leadu.fms.insurance.service.InsurClaimCheckService;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimDeleteListVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimDeleteVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimModifyVo;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.tools.ant.taskdefs.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimService
 * @Description: 保险理赔业务实现层
 * @date 2018-05-14
 */
@Slf4j
@Service
public class ContInsurClaimServiceImpl implements ContInsurClaimService {

    /**
     * @Fields : 保险理赔repository
     */
    @Autowired
    private ContInsurClaimRepository contInsurClaimRepository;

    @Autowired
    private BizFilesRpc bizFilesRpc;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields : 业务编号管理业务service
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields : 财务付款Repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields : 日志service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields : 车辆维修记录Repository
     */
    @Autowired
    private VehMaintainRepository vehMaintainRepository;

    /**
     * @param contInsurClaimVo
     * @return PageInfoExtend<ContInsurClaim>
     * @throws
     * @Title:
     * @Description: 分页查询保险理赔一览
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public PageInfoExtend<ContInsurClaimVo> findContInsurClaimsByPage(ContInsurClaimVo contInsurClaimVo) {
        contInsurClaimVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());
        if (StringUtils.isTrimBlank(contInsurClaimVo.getContNo()))
            contInsurClaimVo.setContNo(null);
        else
            contInsurClaimVo.setContNo(SqlUtil.likePattern(contInsurClaimVo.getContNo()));

        if (StringUtils.isTrimBlank(contInsurClaimVo.getName()))
            contInsurClaimVo.setName(null);
        else
            contInsurClaimVo.setName(SqlUtil.likePattern(contInsurClaimVo.getName()));

        //出租人区域
        if(StringUtils.isTrimBlank(contInsurClaimVo.getGroupDistrict()))
            contInsurClaimVo.setGroupDistrict(null);
        else
            contInsurClaimVo.setGroupDistrict(SqlUtil.likePattern(contInsurClaimVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(contInsurClaimVo.getVinNo()))
            contInsurClaimVo.setVinNo(null);
        else
            contInsurClaimVo.setVinNo(SqlUtil.likePattern(contInsurClaimVo.getVinNo()));

        //车牌号
        if(StringUtils.isTrimBlank(contInsurClaimVo.getVehicleLicenseNo()))
            contInsurClaimVo.setVehicleLicenseNo(null);
        else
            contInsurClaimVo.setVehicleLicenseNo(SqlUtil.likePattern(contInsurClaimVo.getVehicleLicenseNo()));

        //发动机号
        if(StringUtils.isTrimBlank(contInsurClaimVo.getEngineNo()))
            contInsurClaimVo.setEngineNo(null);
        else
            contInsurClaimVo.setEngineNo(SqlUtil.likePattern(contInsurClaimVo.getEngineNo()));
        PageInfoExtend pageInfo = contInsurClaimRepository.selectListVoByPage("selectContInsurClaimsByPage", contInsurClaimVo, contInsurClaimVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 分页查询保险理赔查询页面
     * @author yanfengbo
     * @date
     */
    public PageInfoExtend<ContInsurClaimVo> findContInsurClaimsByPageSelect(ContInsurClaimVo contInsurClaimVo) {
        contInsurClaimVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());
        if (StringUtils.isTrimBlank(contInsurClaimVo.getContNo()))
            contInsurClaimVo.setContNo(null);
        else
            contInsurClaimVo.setContNo(SqlUtil.likePattern(contInsurClaimVo.getContNo()));

        if (StringUtils.isTrimBlank(contInsurClaimVo.getName()))
            contInsurClaimVo.setName(null);
        else
            contInsurClaimVo.setName(SqlUtil.likePattern(contInsurClaimVo.getName()));
        PageInfoExtend pageInfo = contInsurClaimRepository.selectListVoByPage("selectContInsurClaimsByPageSelect", contInsurClaimVo, contInsurClaimVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 保险理赔excel导出
     * @author yanfengbo
     * @date
     */
    public PageInfoExtend<ContInsurClaimVo> findContInsurClaimsByPageSelect2(ContInsurClaimVo contInsurClaimVo) {
        contInsurClaimVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());
        if (StringUtils.isTrimBlank(contInsurClaimVo.getContNo()))
            contInsurClaimVo.setContNo(null);
        else
            contInsurClaimVo.setContNo(SqlUtil.likePattern(contInsurClaimVo.getContNo()));

        if (StringUtils.isTrimBlank(contInsurClaimVo.getName()))
            contInsurClaimVo.setName(null);
        else
            contInsurClaimVo.setName(SqlUtil.likePattern(contInsurClaimVo.getName()));

        //出租人区域
        if(StringUtils.isTrimBlank(contInsurClaimVo.getGroupDistrict()))
            contInsurClaimVo.setGroupDistrict(null);
        else
            contInsurClaimVo.setGroupDistrict(SqlUtil.likePattern(contInsurClaimVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(contInsurClaimVo.getVinNo()))
            contInsurClaimVo.setVinNo(null);
        else
            contInsurClaimVo.setVinNo(SqlUtil.likePattern(contInsurClaimVo.getVinNo()));

        //车牌号
        if(StringUtils.isTrimBlank(contInsurClaimVo.getVehicleLicenseNo()))
            contInsurClaimVo.setVehicleLicenseNo(null);
        else
            contInsurClaimVo.setVehicleLicenseNo(SqlUtil.likePattern(contInsurClaimVo.getVehicleLicenseNo()));

        //发动机号
        if(StringUtils.isTrimBlank(contInsurClaimVo.getEngineNo()))
            contInsurClaimVo.setEngineNo(null);
        else
            contInsurClaimVo.setEngineNo(SqlUtil.likePattern(contInsurClaimVo.getEngineNo()));
        PageInfoExtend pageInfo = contInsurClaimRepository.selectListVoByPage("selectContInsurClaimsByPageSelect2", contInsurClaimVo, contInsurClaimVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param contInsurClaimVo
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 保存保险理赔
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Transactional
    public void saveContInsurClaim(ContInsurClaimVo contInsurClaimVo, SysUser sysUser) {
        //serviceId和taskId不为空时则是退回待提交,此时继续走下一节点,不要从开流程,而且此时的退回操作只有在"退还客户"时或"抵扣租金"才会退回,此时做更新操作,否则是初次提交做录入
        if (StringUtils.isNotTrimBlank(contInsurClaimVo.getServiceId())) {
            ActRuTaskVo actRuTaskVo2=null;
            //根据任务号取初次申请时数据库中保存的“退还方式”类型
            Example example1 = SqlUtil.newExample(ContInsurClaim.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("contInsurClaimNo", contInsurClaimVo.getServiceId());
            ContInsurClaim contInsurClaimOne = contInsurClaimRepository.selectOneByExample(example1);

            /*
            *
            *如果初次申请选择的"是否退还"为是，“退还方式”类型为“退还客户时”，说明初次申请录入的是财务付款表，这里做相关更新
            *
            */
            if(contInsurClaimOne.getReturnMode().equals(ReturnModeEnums.RETURN.getType())){
                //如果新选的操作属性"是否退还"为是
                if (contInsurClaimVo.getReturnFlag().equals(YesNoFlagEnums.YES.getType())) {
                    //如果新选的操作属性"是否退还"为是,"退还方式"为退还客户时,更新财务付款表
                    if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.RETURN.getType())) {
                        //根据保险理赔任务号和业务类型查询财务付款表(为了取到付款表id从而更新付款表)
                        ContPay contPayOne = contInsurClaimRepository.selectContPayByContInsurClaimNo(contInsurClaimVo.getServiceId(), BizTypeEnums.CONT_INSUR_CLAIM.getType());
                        //更新财务付款表
                        ContPay contPay = new ContPay();
                        //取需要更新的数据id
                        contPay.setContPayId(contPayOne.getContPayId());
                        //理赔金额--->付款金额
                        contPay.setPayAmount(contInsurClaimVo.getClaimAmount());
                        //收款银行
                        contPay.setRecAccBank(contInsurClaimVo.getAccBank());
                        contPay.setRecAccBranch(contInsurClaimVo.getRecAccBranch());
                        //收款银行户名
                        contPay.setRecAccountName(contInsurClaimVo.getAccountName());
                        //收款账号
                        contPay.setRecAccountNo(contInsurClaimVo.getAccountNo());
                        contPayRepository.updateByPrimaryKeySelectiveData(contPay);

                        //启动工作流(继续走下一节点)
                        actRuTaskVo2 = ActInsurClaimCheckUtils.approvalAgree(contInsurClaimVo.getTaskId());

                    } else if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.DEDUCTION.getType())) { //如果新选的操作属性"是否退还"为是,"退还方式"为抵扣租金时,录入财务收款表,并删除原来的财务付款数据

                        //删除原来的财务付款数据
                        ContPay contPay = new ContPay();
                        Example example = SqlUtil.newExample(ContPay.class);
                        Example.Criteria criteria = example.createCriteria();
                        criteria.andEqualTo("bizCode", contInsurClaimVo.getServiceId());
                        contPayRepository.deleteExampleData(example, contPay);
                        //工作流
                        actRuTaskVo2 = ActInsurClaimCheckUtils.approvalAgree(contInsurClaimVo.getTaskId());
                    }

                }else if (contInsurClaimVo.getReturnFlag().equals(YesNoFlagEnums.NO.getType())) { //如果新选的操作属性"是否退还"为否
                    //删除原来的财务付款数据
                    ContPay contPay = new ContPay();
                    Example example = SqlUtil.newExample(ContPay.class);
                    Example.Criteria criteria = example.createCriteria();
                    criteria.andEqualTo("bizCode", contInsurClaimVo.getServiceId());
                    contPayRepository.deleteExampleData(example, contPay);
                    //工作流
                    actRuTaskVo2 = ActInsurClaimCheckUtils.applyToEnd(contInsurClaimVo.getTaskId());
                    //录入车辆维修记录
                    saveVehMaintainFromInsurClaim(contInsurClaimVo,contInsurClaimVo.getContInsurClaimNo());
                }else {
                    throw new FmsServiceException("申请失败!");
                }
            }else {
                /*
                *
                *如果初次申请选择的"是否退还"为是，“退还方式”类型为“抵扣租金”。或初次申请选择的"是否退还"为否时则不做或处理直接录入
                *
                */
                //如果新选的操作属性"是否退还"为是
                if (contInsurClaimVo.getReturnFlag().equals(YesNoFlagEnums.YES.getType())) {
                    //如果新选的操作属性"是否退还"为是,"退还方式"为退还客户时,录入财务付款表
                    if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.RETURN.getType())) {
                        ContPay contPay = new ContPay();
                        //业务类型
                        contPay.setPaymentType(BizTypeEnums.CONT_INSUR_CLAIM.getType());
                        //理赔任务号--->业务关联号
                        contPay.setBizCode(contInsurClaimVo.getServiceId());
                        //付款状态
                        contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
                        //"理赔金额"名称--->款项名称
                        contPay.setPayFund(PayFundNameEnums.INSURANCE_CLAIM.getType());
                        //理赔金额--->付款金额
                        contPay.setPayAmount(contInsurClaimVo.getClaimAmount());
                        //收款银行
                        contPay.setRecAccBank(contInsurClaimVo.getAccBank());
                        contPay.setRecAccBranch(contInsurClaimVo.getRecAccBranch());
                        //收款账号
                        contPay.setRecAccountNo(contInsurClaimVo.getAccountNo());
                        //收款户名
                        contPay.setRecAccountName(contInsurClaimVo.getAccountName());
                        contPayRepository.insertData(contPay);
                        //启动工作流(继续走下一节点)
                        actRuTaskVo2 = ActInsurClaimCheckUtils.approvalAgree(contInsurClaimVo.getTaskId());

                    } else if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.DEDUCTION.getType())) { //如果新选的操作属性"是否退还"为是,"退还方式"为抵扣租金时
                        //工作流
                        actRuTaskVo2 = ActInsurClaimCheckUtils.approvalAgree(contInsurClaimVo.getTaskId());
                    }

                }else if (contInsurClaimVo.getReturnFlag().equals(YesNoFlagEnums.NO.getType())) { //如果新选的操作属性"是否退还"为否

                    //工作流
                    actRuTaskVo2 = ActInsurClaimCheckUtils.applyToEnd(contInsurClaimVo.getTaskId());
                    //录入车辆维修记录
                    saveVehMaintainFromInsurClaim(contInsurClaimVo,contInsurClaimVo.getContInsurClaimNo());
                }else {
                    throw new FmsServiceException("申请失败!");
                }
            }

            //保存日志
            saveWorkFlowLog(contInsurClaimVo, actRuTaskVo2, ActTypeEnums.SUBMIT.getType(), sysUser.getUser());

            //更新保险理赔表
            //状态
            contInsurClaimVo.setInsurClaimStatus(actRuTaskVo2.getTaskCode());
            //当前节点用户
            contInsurClaimVo.setPresentUser(actRuTaskVo2.getNextAssignee());
            ContInsurClaim contInsurClaim = EntityUtils.getEntity(contInsurClaimVo, new ContInsurClaim());
            contInsurClaimRepository.updateByPrimaryKeySelectiveData(contInsurClaim);
            //保存附件信息
            bizFilesService.modifyBizFilesList(contInsurClaimVo.getBizFilesList(),contInsurClaimVo.getContInsurClaimNo(),
                    BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType());
            //修改附件信息
            /*if (contInsurClaimVo.getBizfilesVo() != null) {
                bizFilesService.updateBizFiles(contInsurClaimVo.getBizfilesVo().getBizFilesListVos(), contInsurClaimVo.getContInsurClaimId(), BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType());
            }*/
        } else {
            //取任务号
            String contInsurClaimNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.CONT_INSUR_CLAIM_NUM_TYPE.getType());
            contInsurClaimVo.setContInsurClaimNo(contInsurClaimNo);
            //启动工作流
            ActRuTaskVo actRuTaskVo = ActInsurClaimCheckUtils.startInsurClaimCheckAndWaitApprove(contInsurClaimNo, InsurClaimStatusEnums.INSUR_CLAIM_AUDIT.getDesc(), InsurClaimStatusEnums.INSUR_CLAIM_AUDIT.getDesc());
            ActRuTaskVo actRuTaskVo1 = null;
            //理赔金需要退还时
            if (contInsurClaimVo.getReturnFlag().equals(YesNoFlagEnums.YES.getType())) {
                //理赔金需要退还并且退还方式为抵扣租金时
                if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.DEDUCTION.getType())) {
                    //工作流
                    actRuTaskVo1 = ActInsurClaimCheckUtils.approvalAgree(actRuTaskVo.getId());
                } if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.RETURN.getType())) { //理赔金需要退还并且退还方式为退还客户时,录入财务付款表
                    ContPay contPay = new ContPay();
                    //业务类型
                    contPay.setPaymentType(BizTypeEnums.CONT_INSUR_CLAIM.getType());
                    //理赔任务号--->业务关联号
                    contPay.setBizCode(contInsurClaimNo);
                    //付款状态
                    contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
                    //"理赔金额"名称--->款项名称
                    contPay.setPayFund(PayFundNameEnums.INSURANCE_CLAIM.getType());
                    //理赔金额--->付款金额
                    contPay.setPayAmount(contInsurClaimVo.getClaimAmount());
                    //收款银行
                    contPay.setRecAccBank(contInsurClaimVo.getAccBank());
                    contPay.setRecAccBranch(contInsurClaimVo.getRecAccBranch());
                    //收款账号
                    contPay.setRecAccountNo(contInsurClaimVo.getAccountNo());
                    //收款户名
                    contPay.setRecAccountName(contInsurClaimVo.getAccountName());
                    contPayRepository.insertData(contPay);

                    //工作流
                    actRuTaskVo1 = ActInsurClaimCheckUtils.approvalAgree(actRuTaskVo.getId());
                }
            } else if (contInsurClaimVo.getReturnFlag().equals(YesNoFlagEnums.NO.getType())) { //理赔金不需要退还时
                //工作流
                actRuTaskVo1 = ActInsurClaimCheckUtils.applyToEnd(actRuTaskVo.getId());
                //录入车辆维修记录
                saveVehMaintainFromInsurClaim(contInsurClaimVo,contInsurClaimNo);
            } else {
                throw new FmsServiceException("申请失败!");
            }

            //保存日志
            saveWorkFlowLog(contInsurClaimVo, actRuTaskVo1, ActTypeEnums.SUBMIT.getType(), sysUser.getUser());
            //录入保险理赔信息
            String contInsurClaimId = UUIDUtils.getUUID();
            contInsurClaimVo.setContInsurClaimNo(contInsurClaimNo);
            contInsurClaimVo.setContInsurClaimId(contInsurClaimId);
            contInsurClaimVo.setInsurClaimStatus(actRuTaskVo1.getTaskCode());
            //当前节点用户
            contInsurClaimVo.setPresentUser(actRuTaskVo1.getNextAssignee());

            //保存附件信息
            bizFilesService.modifyBizFilesList(contInsurClaimVo.getBizFilesList(),contInsurClaimNo,
                    BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType());
            //保存附件信息
           /* if (contInsurClaimVo.getBizfilesVo() != null) {
                bizFilesService.saveBizFiles(contInsurClaimVo.getBizfilesVo().getBizFilesListVos(), contInsurClaimId, BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType());
            }*/
            ContInsurClaim contInsurClaim = contInsurClaimVo.getEntity();
            contInsurClaimRepository.insertData(contInsurClaim);
        }
    }

    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 审批日志
     * @author yanfengbo
     * @date
     */

    public void saveWorkFlowLog(ContInsurClaimVo contInsurClaimVo, ActRuTaskVo actRuTaskVo, String actType, String sysUser) {
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser);
        workflowLog.setWfLogNo(contInsurClaimVo.getContInsurClaimNo());
        workflowLog.setWfLogType(BizTypeEnums.CONT_INSUR_CLAIM.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contInsurClaimVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(actType);
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }


    /**
     * @Title:
     * @Description: 流程结束后录入一条车辆维修记录
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public void saveVehMaintainFromInsurClaim(ContInsurClaimVo contInsurClaimVo,String contInsurClaimNo){
        //录入车辆维修记录
        VehMaintain vehMaintain = new VehMaintain();
        //来源
        vehMaintain.setMaintainFlag(VehMaintainEnums.MAINTAINCLAIM.getType());
        //理赔号
        vehMaintain.setContInsurClaimNo(contInsurClaimNo);
        //车架号
        vehMaintain.setVinNo(contInsurClaimVo.getVinNo());
        //发动机号
        vehMaintain.setEngineNo(contInsurClaimVo.getEngineNo());
        //车牌号
        vehMaintain.setVehicleLicenseNo(contInsurClaimVo.getVehicleLicenseNo());
        //维修日期--->事故日期
        vehMaintain.setMaintainDate(contInsurClaimVo.getAccidentTime());
        //维修金额--->理赔金额
        vehMaintain.setMaintainAmount(contInsurClaimVo.getClaimAmount());
        //维修备注--->情况说明
        vehMaintain.setMaintainMemo(contInsurClaimVo.getDescription());
        vehMaintainRepository.insertData(vehMaintain);
    }

    /**
     * @param contInsurClaimModifyVo
     * @return
     * @throws
     * @Title:
     * @Description: 修改保险理赔
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public void modifyContInsurClaim(ContInsurClaimModifyVo contInsurClaimModifyVo) {
        contInsurClaimRepository.updateByPrimaryKeySelectiveData(contInsurClaimModifyVo.getEntity());
    }

    /**
     * @param contInsurClaimDeleteVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过contInsurClaimId删除保险理赔
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public void deleteContInsurClaim(ContInsurClaimDeleteVo contInsurClaimDeleteVo) {
        contInsurClaimRepository.deleteData(contInsurClaimDeleteVo.getEntity());
    }

    /**
     * @param contInsurClaimDeleteListVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过contInsurClaimId集合删除保险理赔
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public void deleteContInsurClaimsByContInsurClaimIds(ContInsurClaimDeleteListVo contInsurClaimDeleteListVo) {
        contInsurClaimRepository.deleteDataList(contInsurClaimDeleteListVo.getContInsurClaimIds(), contInsurClaimDeleteListVo.getEntity());
    }

    /**
     * @param contInsurClaimId
     * @return ContInsurClaim
     * @throws
     * @Title:
     * @Description: 根据contInsurClaimId获取保险理赔
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public ContInsurClaim findContInsurClaimByContInsurClaimId(String contInsurClaimId) {
        return contInsurClaimRepository.selectByPrimaryKey(contInsurClaimId);
    }

    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 根据保险理赔id或保险信息id查询一条明细
     * @author yanfengbo
     * @date
     */
    public ContInsurClaimVo findDetailedByContNo(String contVehinsId, String contInsurClaimId, String serviceId) {
        //如果保险理赔id为空,则根据保险信息id查询合同车辆保险信息
        if ((StringUtils.isTrimBlank(contInsurClaimId) || contInsurClaimId.equals("undefined")) && StringUtils.isNotTrimBlank(contVehinsId)) {
            return contInsurClaimRepository.selectContInsuranceByContVehinsId(contVehinsId);
            //如果保险理赔id不为空,则查询保险理赔表和合同车辆信息表
        } else if (StringUtils.isNotTrimBlank(contInsurClaimId) && !contInsurClaimId.equals("undefined") && StringUtils.isNotTrimBlank(contVehinsId)) {
            ContInsurClaimVo contInsurClaimVo = contInsurClaimRepository.selectContInsurClaimAndContInsurance(contInsurClaimId, contVehinsId);
            //是否退还为"是"时
            if (contInsurClaimVo.getReturnFlag().equals(YesNoFlagEnums.YES.getType())) {
                //是否退还为是,退还方式为退还客户时
                if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.RETURN.getType())) {
                    //根据保险理赔任务号和业务类型查询财务付款表
                    ContPay contPay = contInsurClaimRepository.selectContPayByContInsurClaimNo(contInsurClaimVo.getContInsurClaimNo(), BizTypeEnums.CONT_INSUR_CLAIM.getType());
                    contInsurClaimVo.setAccBank(contPay.getRecAccBank());
                    contInsurClaimVo.setAccountName(contPay.getRecAccountName());
                    contInsurClaimVo.setAccountNo(contPay.getRecAccountNo());
                    contInsurClaimVo.setRecAccBranch(contPay.getRecAccBranch());

                }
            }

            //查询附件
            contInsurClaimVo.setBizFilesList(bizFilesService.findBizFilesList(contInsurClaimVo.getContInsurClaimNo(), BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType()));
            //附件详情
           /* try {
                CommonBizFilesVo bizFilesVo = ResponseEntityUtils.getRestResponseData(bizFilesRpc.findBizFilesContInsurClaim(contInsurClaimId));
                contInsurClaimVo.setBizfilesVo(bizFilesVo);
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
            }*/
            return contInsurClaimVo;
        } else if (StringUtils.isNotTrimBlank(serviceId)) { //保险理赔状态为退回时
            Example example = SqlUtil.newExample(ContInsurClaim.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("contInsurClaimNo", serviceId);
            //根据任务号取唯一一条保险理赔信息
            ContInsurClaim contInsurClaim = contInsurClaimRepository.selectOneByExample(example);
            //查询保险理赔表和合同车辆信息表
            ContInsurClaimVo contInsurClaimVo = contInsurClaimRepository.selectContInsurClaimAndContInsurance(contInsurClaim.getContInsurClaimId(), contInsurClaim.getContVehinsId());
            //是否退还为是时
            if (contInsurClaim.getReturnFlag().equals(YesNoFlagEnums.YES.getType())) {
                //是否退还为是,退还方式为退还客户时
                if (contInsurClaim.getReturnMode().equals(ReturnModeEnums.RETURN.getType())) {
                    //根据保险理赔任务号和业务类型查询财务付款表
                    ContPay contPay = contInsurClaimRepository.selectContPayByContInsurClaimNo(serviceId, BizTypeEnums.CONT_INSUR_CLAIM.getType());
                    contInsurClaimVo.setAccBank(contPay.getRecAccBank());
                    contInsurClaimVo.setAccountName(contPay.getRecAccountName());
                    contInsurClaimVo.setAccountNo(contPay.getRecAccountNo());
                }
            }

            //查询附件
            contInsurClaimVo.setBizFilesList(bizFilesService.findBizFilesList(serviceId, BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType()));
            //附件详情
         /*   try {
                CommonBizFilesVo bizFilesVo = ResponseEntityUtils.getRestResponseData(bizFilesRpc.findBizFilesContInsurClaim(contInsurClaimVo.getContInsurClaimId()));
                contInsurClaimVo.setBizfilesVo(bizFilesVo);
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
            }*/
            return contInsurClaimVo;
        } else {
            throw new FmsServiceException("获取理赔信息失败");
        }
    }

    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 取保险理赔详情
     * @author yanfengbo
     * @date
     */
    public ContInsurClaimVo findDetailContInsurClaim(String serviceId) {
        Example example = SqlUtil.newExample(ContInsurClaim.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contInsurClaimNo", serviceId);
        //根据任务号取唯一一条保险理赔信息
        ContInsurClaim contInsurClaim = contInsurClaimRepository.selectOneByExample(example);
        //查询保险理赔表和合同车辆信息表
        ContInsurClaimVo contInsurClaimVo = contInsurClaimRepository.selectContInsurClaimAndContInsurance(contInsurClaim.getContInsurClaimId(), contInsurClaim.getContVehinsId());
        //是否退还为是时
        if (contInsurClaim.getReturnFlag().equals(YesNoFlagEnums.YES.getType())) {
            //是否退还为是,退还方式为退还客户时
            if (contInsurClaim.getReturnMode().equals(ReturnModeEnums.RETURN.getType())) {
                //根据保险理赔任务号和业务类型查询财务付款表
                ContPay contPay = contInsurClaimRepository.selectContPayByContInsurClaimNo(serviceId, BizTypeEnums.CONT_INSUR_CLAIM.getType());
                contInsurClaimVo.setContPayId(contPay.getContPayId());
                contInsurClaimVo.setAccBank(contPay.getRecAccBank());
                contInsurClaimVo.setAccountName(contPay.getRecAccountName());
                contInsurClaimVo.setAccountNo(contPay.getRecAccountNo());
                contInsurClaimVo.setPayAccBank(contPay.getPayAccBank());
                contInsurClaimVo.setPayAccountName(contPay.getPayAccountName());
                contInsurClaimVo.setPayAccountNo(contPay.getPayAccountNo());
                contInsurClaimVo.setPayAccBranch(contPay.getPayAccBranch());
                contInsurClaimVo.setRecAccBranch(contPay.getRecAccBranch());
            }
        }
        //查询附件
        contInsurClaimVo.setBizFilesList(bizFilesService.findBizFilesList(serviceId, BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType()));
        //附件详情
       /* try {
            CommonBizFilesVo bizFilesVo = ResponseEntityUtils.getRestResponseData(bizFilesRpc.findBizFilesContInsurClaim(contInsurClaimVo.getContInsurClaimId()));
            contInsurClaimVo.setBizfilesVo(bizFilesVo);
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }*/
        return contInsurClaimVo;
    }
}
