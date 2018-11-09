package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActDepositChangeUtils;
import cn.com.leadu.fms.business.rpc.system.SysTplTypeRpc;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.postbiz.ContCostTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.CostItemEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DisposalStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehicleDisposalStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.postbiz.repository.ContCostRepository;
import cn.com.leadu.fms.data.postbiz.repository.DepositChangeTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmRepository;
import cn.com.leadu.fms.data.postbiz.repository.VehicleDisposalRepository;
import cn.com.leadu.fms.data.prebiz.repository.*;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.postbiz.entity.ContCost;
import cn.com.leadu.fms.pojo.postbiz.entity.DepositChangeTask;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositApproveVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositFinanceVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositVehicleTypeVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.DepositChangeTaskService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.*;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeTaskService
 * @Description: 保证金变更任务业务实现层
 */
@Service
public class DepositChangeTaskServiceImpl implements DepositChangeTaskService {

    @Autowired
    private NumGenerateService numGenerateService;
    @Autowired
    private BizFilesService bizFilesService;
    @Autowired
    private WorkflowLogService workflowLogService;
    @Autowired
    private CommonPdfService commonPdfService;
    @Autowired
    private SysTplTypeRpc sysTplTypeRpc;

    @Autowired
    private DepositChangeTaskRepository depositChangeTaskRepository;
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;
    @Autowired
    private GuaranteeCompRepository guaranteeCompRepository;
    @Autowired
    private GuaranteePersRepository guaranteePersRepository;
    @Autowired
    private ContChargeRepository contChargeRepository;
    @Autowired
    private ContReceiptRepository contReceiptRepository;
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;
    @Autowired
    private OverdueCstmRepository overdueCstmRepository;
    @Autowired
    private VehicleDisposalRepository vehicleDisposalRepository;
    @Autowired
    private ContCostRepository contCostRepository;
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;
    @Autowired
    private ContractVehicleRepository contractVehicleRepository;


    /**
     * @param vo 入参实体类
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo或者depositTaskNo获取申请页需要展示的基本信息
     * @author huzongcheng
     * @date
     */
    public DepositChangeApplyVo findApplyInfoByContNo(DepositChangeApplyVo vo) {
        String contNo;
        //任务号不为空，则是二次提交，查询上次提交输入信息
        if (StringUtils.isNotTrimBlank(vo.getDepositTaskNo())) {
            DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
            if (task == null) {
                throw new FmsServiceException("保证金变更任务不存在");
            }
            contNo = task.getContNo();
            // 获取基本信息
            vo = depositChangeTaskRepository.selectApplyInfoByContNo(contNo);
            String depositTaskNo = task.getDepositTaskNo(); //变更任务号
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
        } else {
            contNo = vo.getContNo();
            vo = depositChangeTaskRepository.selectApplyInfoByContNo(contNo);
            vo.setGuaranteePersList(new ArrayList());
            vo.setGuaranteeCompList(new ArrayList());
        }
        // 查询还款相关信息
        searchRepayInfo(vo, contNo);
        return vo;
    }

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 增加保证金申请提交
     * @author huzongcheng
     */
    @Transactional
    public void saveDepositChange(DepositChangeApplyVo vo, SysUser sysUser) {
        //增加保证金任务载体
        ActRuTaskVo actRuTaskVo = null;
        DepositChangeTask task;
        // 如果有个人或企业担保人，则需要经过初审
        boolean flag = ArrayUtils.isNotNullAndLengthNotZero(vo.getGuaranteeCompList())
                || ArrayUtils.isNotNullAndLengthNotZero(vo.getGuaranteePersList());
        //如果是二次提交，update
        if (StringUtils.isNotTrimBlank(vo.getDepositTaskNo())) {
            task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
            task.setSupplementDeposit(vo.getSupplementDeposit()); //补充保证金
            task.setApplyRemark(vo.getApplyRemark()); //申请备注
            depositChangeTaskRepository.updateByPrimaryKeyData(task, true);
            clearGuarantee(vo.getDepositTaskNo()); //清除之前提交的担保人信息
            //继续提交任务
            //如果需要经过初审
            if(flag){
                actRuTaskVo = ActDepositChangeUtils.approvalAgree(vo.getTaskId());
            } else {
                actRuTaskVo = ActDepositChangeUtils.submitToReview(vo.getTaskId());
            }
            //工作流信息
            task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
            task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
            //更新任务表
            depositChangeTaskRepository.updateByPrimaryKeyData(task, true);
        } else {
            //排他判断，是否有正在进行的申请
            boolean checkFlag = findDepositChangeTaskByContNo(vo.getContNo());
            if(!checkFlag){
                throw new FmsServiceException("该条合同有正在进行中的保证金变更申请！");
            }
            String depositTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.DEPOSIT_CHANGE_TYPE.getType());
            //开启工作流
            actRuTaskVo = ActDepositChangeUtils.startDepositChangeAndSubmit(depositTaskNo, vo.getLessee(), flag);
            task = new DepositChangeTask();
            task.setContNo(vo.getContNo()); //合同编号
            task.setDepositTaskNo(depositTaskNo);
            task.setSupplementDeposit(vo.getSupplementDeposit()); //补充保证金
            task.setApplyRemark(vo.getApplyRemark()); //申请备注
            task.setSubmitUser(sysUser.getUser()); //任务发起人
            task.setSubmitDate(new Date()); //任务发起时间
            //工作流信息
            task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
            task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
            depositChangeTaskRepository.insertData(task);
        }
        //保存担保人
        saveGuaranteePresList(vo, task.getDepositTaskNo());
        //保存担保企业
        saveGuaranteeCompList(vo, task.getDepositTaskNo());
        //附件信息
        saveBizFiles(vo.getBizFilesList(), task.getDepositTaskNo(), BizCodeTypeEnums.DEPOSIT_CHANGE_FILE.getCodeType());
        saveWorkFlowLog(task, vo.getApplyRemark(), actRuTaskVo, SUBMIT.getType(), sysUser, true);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 复审通过操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void approval(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalAgree(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, APPROVAL.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 复审退回操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void sendBack(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalReturnSuperior(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, SENDBACK.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 复审拒绝操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void refuse(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalRefuse(vo.getTaskId());
        task.setDepositTaskStatus(BizStatusEnums.DEPOSIT_CHANGE_REFUSE.getType()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, REFUSE.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 合同生成
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void contractCreate(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        String contNo = task.getContNo();
        BigDecimal amout = task.getSupplementDeposit(); //补充保证金额
        //清空之前的附件
        bizFilesService.deleteBizFilesByBizCode(vo.getDepositTaskNo(),BizCodeTypeEnums.DEPOSIT_CHANGE_CONTRACT_FILE.getCodeType());
        //本次需要保存的附件集合
        List<BizFiles> bizFilesList = new ArrayList();
        //如果保证金不为空且大于零，则生成保证金补充协议合同
        if(amout != null && BigDecimal.ZERO.compareTo(amout) < 0){
            printSuppleTpl(vo, task, bizFilesList);
        }
        //pdf出力参数集合
        Map<String, String> varsMap = new HashMap();
        //获取申请信息
        DepositChangeApplyVo applyVo = depositChangeTaskRepository.selectApplyInfoByContNo(contNo);
        // 获取个人担保人信息
        List<GuaranteePers> guaranteePersList = findGuaranteePersByApplyNo(vo.getDepositTaskNo());
        // 获取企业担保人信息
        List<GuaranteeComp> guaranteeCompList = findGuaranteeCompsByApplyNo(vo.getDepositTaskNo());
        //如果需要生成保函
        if(ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList) || ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList)){
            buildBaseParam(contNo, varsMap, applyVo);
            setGuaranteeVarsMap(guaranteePersList, guaranteeCompList, varsMap);
            //有担保人
            if(ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList)){
                printPersTpl(vo, task, bizFilesList, varsMap);
            }
            //有担保企业
            if(ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList)){
                printCompTpl(vo, task, bizFilesList, varsMap);
            }
        }
        //如果附件不为空，则进行保存
        if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesList)){
            bizFilesService.saveBizFilesList(bizFilesList);
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalAgree(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, APPROVAL.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 退回到申请
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void sendToApply(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalSendToApply(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, SENDBACKTOP.getType(), sysUser, false);
    }

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 增加保证金签订合同
     * @author huzongcheng
     */
    @Transactional
    public void suppleUpload(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task;
        task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        //附件信息
        saveBizFiles(vo.getBizFilesList(), task.getDepositTaskNo(), BizCodeTypeEnums.DEPOSIT_CHANGE_SUPPLE_FILE.getCodeType());
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalAgree(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, APPROVAL.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 签订合同页面退回
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void suppleSendBack(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalReturnSuperior(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, SENDBACK.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 合同复核通过操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void contractApproval(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        BigDecimal amount = task.getSupplementDeposit();
        ActRuTaskVo actRuTaskVo;
        //如果保证金为0
        if (amount == null || BigDecimal.ZERO.compareTo(amount) == 0) {
            //是否经过出库判断
            boolean flag = isNeedExport(task);
            // 如果收车成功车辆在库的场合，跳转到出库
            if(flag){
                actRuTaskVo = ActDepositChangeUtils.approvalExport(vo.getTaskId());
            } else { //否则，结束流程
                actRuTaskVo = ActDepositChangeUtils.approvalEnd(vo.getTaskId());
            }
        } else {
            //如果保证金不为0，则进入财务流程
            actRuTaskVo = ActDepositChangeUtils.approvalAgree(vo.getTaskId());
        }
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, APPROVAL.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 合同复核退回操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void contractSendBack(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalReturnSuperior(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, SENDBACK.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 财务确认收款通过操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void financeReceipt(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        // 更新财务相关表信息
        saveFinanceInfo(vo, task);
        //工作流信息
        ActRuTaskVo actRuTaskVo;
        //更新财务费用相关表信息
        saveContCostInfo(task);
        //是否经过出库判断
        boolean flag = isNeedExport(task);
        // 如果收车成功车辆在库的场合，跳转到出库
        if(flag){
            actRuTaskVo = ActDepositChangeUtils.approvalAgree(vo.getTaskId());
        } else { //否则，结束流程
            actRuTaskVo = ActDepositChangeUtils.approvalEnd(vo.getTaskId());
        }
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, APPROVAL.getType(), sysUser, false);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 出库操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void export(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //更新车辆处置任务表
        updateVehicleDisposal(task.getContNo(), vo);
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.export(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, APPROVAL.getType(), sysUser, false);
    }

    /**
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 申请取消操作，任意流程节点
     * @param taskNo 任务号
     * @param cancelReson 取消原因
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void applyCancel(String taskNo, String cancelReson, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(taskNo);
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //根据任务号获得taskId并进行申请取消
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.applyCancel(taskNo);
        task.setDepositTaskStatus(BizStatusEnums.DEPOSIT_CHANGE_CANCEL.getType()); //状态:取消
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, cancelReson, actRuTaskVo, CANCEL.getType(), sysUser, false);
    }

    /**
     * 更新财务相关表信息
     * @param vo
     * @param task
     */
    @Transactional
    private void saveFinanceInfo(DepositApproveVo vo, DepositChangeTask task) {
        // 给财务待收款表中增加一条数据，状态为已收款
        ContCharge contCharge = new ContCharge();
        contCharge.setChargeBizType(BizTypeEnums.DEPOSIT_CHANGE.getType());
        contCharge.setChargeBizId(vo.getDepositTaskNo());
        contCharge.setChargeFund(PayFundNameEnums.SUPPLE_DEPOSIT.getType());
        contCharge.setChargeAmount(task.getSupplementDeposit());
        contCharge.setChargeStatus(ChargeStatusEnums.COLLECTION.getType());
        contChargeRepository.insertData(contCharge);
        if (ArrayUtils.isNotNullAndLengthNotZero(vo.getDepositFinanceVoList())) {
            List<ContReceipt> contReceiptList = new ArrayList<>();
            List<ContReceiptExam> contReceiptExamList = new ArrayList<>();
            for (DepositFinanceVo item : vo.getDepositFinanceVoList()) {
                //插入财务收款表
                ContReceipt contReceipt = new ContReceipt();
                contReceipt.setContReceiptId(UUIDUtils.getUUID()); //主键
                contReceipt.setInputMode(InputModeEnums.INPUT.getType()); //数据来源
                contReceipt.setReceiptAmount(item.getReceiptAmount()); //到账金额
                contReceipt.setRecAccBank(item.getRecAccBank()); //收款银行
                contReceipt.setRecAccountName(item.getRecAccountName()); //收款户名
                contReceipt.setRecAccBranch(item.getRecAccBranch()); //收款银行分行
                contReceipt.setRecAccountNo(item.getRecAccountNo()); //收款账号
                contReceipt.setRecEleBankNo(item.getRecEleBankNo()); //收款联行号
                contReceipt.setRestAmount(new BigDecimal(0)); //剩余金额
                contReceipt.setReceiptDate(item.getReceiptDate()); //到账日期
                contReceipt.setMemo(item.getMemo()); //备注
                contReceiptList.add(contReceipt);
                //插入财务勾稽表
                ContReceiptExam contReceiptExam = new ContReceiptExam();
                contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType()); //收款业务类型
                contReceiptExam.setReceiptBizId(contCharge.getContChargeId()); // 款项业务id
                contReceiptExam.setContReceiptId(contReceipt.getContReceiptId()); // 财务收款ID
                contReceiptExam.setReceiptExamAmount(item.getReceiptAmount()); // 勾稽金额
                contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());   //勾稽类型
                contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());
                contReceiptExamList.add(contReceiptExam);
            }
            contReceiptRepository.insertDataList(contReceiptList); //批量插入财务收款表
            contReceiptExamRepository.insertDataList(contReceiptExamList); //批量插入财务勾稽表
        }
    }

    /**
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo查询是否有正在进行中的保证金变更申请
     * @author huzongcheng
     * @date
     */
    public boolean findDepositChangeTaskByContNo(String contNo) {
        Example example = SqlUtil.newExample(DepositChangeTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contNo);
        criteria.andNotEqualTo("depositTaskStatus", BizStatusEnums.DEPOSIT_CHANGE_FINISH.getType());
        criteria.andNotEqualTo("depositTaskStatus",BizStatusEnums.DEPOSIT_CHANGE_REFUSE.getType());
        criteria.andNotEqualTo("depositTaskStatus",BizStatusEnums.DEPOSIT_CHANGE_CANCEL.getType());
        return depositChangeTaskRepository.selectOneByExample(example) == null;
    }

    /**
     * @param certifNo 证件号或者社会信用号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据证件号或者社会信用号查询逾期客户id
     * @author huzongcheng
     * @date
     */
    public String findOverdueCstmId(String certifNo) {
        Example example = SqlUtil.newExample(OverdueCstm.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("certifNo", certifNo);
        OverdueCstm overdueCstm = overdueCstmRepository.selectOneByExample(example);
        return overdueCstm == null ? null : overdueCstm.getOverdueCstmId();
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 财务收款退回操作
     * @author huzongcheng
     * @date
     */
    @Transactional
    public void financeSendBack(DepositApproveVo vo, SysUser sysUser) {
        DepositChangeTask task = getDepositChangeTaskByTaskNo(vo.getDepositTaskNo());
        if (task == null) {
            throw new FmsServiceException("保证金变更任务不存在");
        }
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActDepositChangeUtils.approvalReturnSuperior(vo.getTaskId());
        task.setDepositTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, SENDBACK.getType(), sysUser, false);
    }


    /**
     * @param depositTaskNo 任务变更号
     * @param bizCodeType   业务类型
     * @return CommonBizFilesVo 附件信息
     * @throws
     * @Title:
     * @Description: 获取合同附件
     * @author hu'zong'cheng
     */
    public CommonBizFilesVo findBizFileByDepositTaskNo(String depositTaskNo, String bizCodeType) {
        CommonBizFilesVo bizFilesVo = bizFilesService.findBizFilesByBizCode(depositTaskNo, bizCodeType);
        return bizFilesVo;
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
     * 批量保存担保人信息
     *
     * @param vo
     */
    @Transactional
    public void saveGuaranteePresList(DepositChangeApplyVo vo, String depositTaskNo) {
        List<GuaranteePers> guaranteePersList = vo.getGuaranteePersList();
        if (ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList))
            for (GuaranteePers guaranteePers : guaranteePersList) {
                //二次提交时清空主键和时间
                guaranteePers.setGuarPersId(null);
                guaranteePers.setCreateTime(null);
                guaranteePers.setUpdateTime(null);
                guaranteePers.setApplyNo(depositTaskNo);
            }
        guaranteePersRepository.insertDataList(guaranteePersList);
    }

    /**
     * 批量保存担保企业信息
     *
     * @param vo
     */
    @Transactional
    public void saveGuaranteeCompList(DepositChangeApplyVo vo, String depositTaskNo) {
        List<GuaranteeComp> guaranteeCompList = vo.getGuaranteeCompList();
        if (ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList))
            for (GuaranteeComp guaranteeComp : vo.getGuaranteeCompList()) {
                //二次提交时清空主键和时间
                guaranteeComp.setGuarCompId(null);
                guaranteeComp.setCreateTime(null);
                guaranteeComp.setUpdateTime(null);
                guaranteeComp.setApplyNo(depositTaskNo);
            }
        guaranteeCompRepository.insertDataList(guaranteeCompList);
    }

    /**
     * @param bizFilesList  附件集合
     * @param depositTaskNo 变更任务号
     * @return
     * @throws
     * @Title:
     * @Description: 保存附件
     * @author qiaomengnan
     * @date 2018/04/11 02:48:55
     */
    private void saveBizFiles(List<BizFiles> bizFilesList, String depositTaskNo, String bizCodeType) {
        bizFilesService.modifyBizFilesList(bizFilesList, depositTaskNo, bizCodeType);
    }

    /**
     * @param depositTaskNo 变更任务号(订单编号)
     * @return List<GuaranteePers>
     * @throws
     * @Title:
     * @Description: 二次提交时删除之前增加的联系人
     * @author huzongcheng
     */
    public void clearGuarantee(String depositTaskNo) {
        Example example = SqlUtil.newExample(GuaranteePers.class);
        example.createCriteria().andEqualTo("applyNo", depositTaskNo);
        guaranteePersRepository.deleteExampleData(example, new GuaranteePers());
        example = SqlUtil.newExample(GuaranteeComp.class);
        example.createCriteria().andEqualTo("applyNo", depositTaskNo);
        guaranteeCompRepository.deleteExampleData(example, new GuaranteeComp());
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
        List<GuaranteePers> resultList = guaranteePersRepository.selectListByExample(example);
        if (resultList == null) {
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
        List<GuaranteeComp> resultList = guaranteeCompRepository.selectListByExample(example);
        if (resultList == null) {
            List<GuaranteeComp> guaranteeCompList = new ArrayList<>();
            return guaranteeCompList;
        }
        return guaranteeCompRepository.selectListByExample(example);
    }

    /**
     * 查询还款相关信息
     * @param vo
     * @param contNo
     */
    private void searchRepayInfo(DepositChangeApplyVo vo, String contNo) {
        List<ContRepaySked> contRepaySkedList = findContRepaySkedByContNo(contNo);
        BigDecimal alreadyRepayAmount = BigDecimal.ZERO;//已还金额
        BigDecimal residueAmount = BigDecimal.ZERO;//剩余租金
        int alreadyRepayNper = 0;//已还期数
        for (ContRepaySked contRepaySked : contRepaySkedList) {
            if (RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())) {
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
    }

    /**
     * @param flag 是否是初次申请提交
     * @return DeferTask
     * @throws
     * @Title:
     * @Description: 审批日志保存
     * @author huzongcheng
     */
    @Transactional
    private void saveWorkFlowLog(DepositChangeTask task, String remark, ActRuTaskVo actRuTaskVo,
                                 String actType, SysUser sysUser, boolean flag) {
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
        if(!flag){
            //更新任务表
            depositChangeTaskRepository.updateByPrimaryKeyData(task, true);
        }
    }

    /**
     * @Title:
     * @Description: 根据增加保证金任务号，获取增加保证金任务信息
     * @param depositTaskNo 增加保证金任务号
     * @return DepositChangeTask
     * @author wangxue
     * @date
     */
    @Override
    public DepositChangeTask findDepositChangeTaskByDepositTaskNo(String depositTaskNo) {
        Example example = new Example(DepositChangeTask.class);
        example.createCriteria().andEqualTo("depositTaskNo", depositTaskNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return depositChangeTaskRepository.selectOneByExample(example);
    }

    /**
     * 通过合同号和车辆处置方式判断流程中是否需要出库步骤
     */
    @Transactional
    private boolean isNeedExport(DepositChangeTask task) {
        //车辆处置任务表能够查到数据并且任务状态为未处置，处置方式为增加保证金
        Example example = new Example(VehicleDisposal.class);
        example.createCriteria().andEqualTo("contNo", task.getContNo());
        example.createCriteria().andEqualTo("vehicleDisposalStatus", VehicleDisposalStatusEnums.TO_BE_DISPOSE.getType());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        VehicleDisposal vehicleDisposal =  vehicleDisposalRepository.selectOneByExample(example);
        //如果有对应的车辆处置任务，更新车辆处置任务表
        if(vehicleDisposal != null){
            vehicleDisposal.setDisposalStatus(DisposalStatusEnums.DEPOSIT_CHANGE.getType()); //处置方式
            vehicleDisposal.setDisposalTaskNo(task.getDepositTaskNo()); //处置任务号
            vehicleDisposalRepository.updateByPrimaryKeySelectiveData(vehicleDisposal,true);
            return true;
        }
        return false;
    }

    /**
     * 更新的车辆处置任务表数据
     */
    @Transactional
    private void updateVehicleDisposal(String contNo, DepositApproveVo vo) {
        //车辆处置任务表能够查到数据并且任务状态为未处置，处置方式为增加保证金
        Example example = new Example(VehicleDisposal.class);
        example.createCriteria().andEqualTo("contNo", contNo);
        example.createCriteria().andEqualTo("disposalStatus", DisposalStatusEnums.DEPOSIT_CHANGE.getType());
        example.createCriteria().andEqualTo("vehicleDisposalStatus", VehicleDisposalStatusEnums.TO_BE_DISPOSE.getType());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        VehicleDisposal vehicleDisposal = vehicleDisposalRepository.selectOneByExample(example);
        if(vehicleDisposal != null){
            vehicleDisposal.setVehicleDisposalStatus(VehicleDisposalStatusEnums.OUT_STORAGE.getType()); //状态:已出库
            vehicleDisposal.setShipmentDate(vo.getShipmentDate()); //出库时间
            vehicleDisposal.setDisposalStatus(DisposalStatusEnums.DEPOSIT_CHANGE.getType()); //车辆处置方式，待出库
            vehicleDisposal.setAgent(vo.getAgent()); //经办人
            vehicleDisposal.setAgentMobileNo(vo.getAgentMobileNo()); //经办人联系方式
            vehicleDisposalRepository.updateByPrimaryKeySelectiveData(vehicleDisposal);
        }
    }

    /**
     * 更新财务费用相关表信息
     * @param task
     */
    private void saveContCostInfo(DepositChangeTask task) {
        // 保存财务待收款信息
        ContReceipt contReceipt = new ContReceipt();
        //数据来源 2-抵扣租金
        contReceipt.setInputMode(InputModeEnums.INTER.getType());
        //到账金额
        contReceipt.setReceiptAmount(task.getSupplementDeposit());
        //剩余金额
        contReceipt.setRestAmount(task.getSupplementDeposit());
        String memo = "保证金,合同号：" + task.getContNo();
        contReceipt.setMemo(memo);//备注
        //登录财务收款表
        contReceiptRepository.insertData(contReceipt);
        // 保存客户费用信息
        ContCost contCost = new ContCost();
        // 合同编号
        contCost.setContNo(task.getContNo());
        contCost.setContReceiptId(contReceipt.getContReceiptId());
        // 保证金
        contCost.setCostAmount(task.getSupplementDeposit());
        // 款项：保证金
        contCost.setCostItem(CostItemEnums.DEPOSIT.getType());
        // 类型：收取
        contCost.setCostType(ContCostTypeEnums.COLLECT.getType());
        contCostRepository.insertData(contCost);
    }

    /**
     * 生成保证金补充协议合同
     * @param vo
     * @param task
     * @param bizFilesList
     */
    private void printSuppleTpl(DepositApproveVo vo, DepositChangeTask task, List<BizFiles> bizFilesList) {
        //获取增加保证补充协议模板
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey(TplTypeKeyEnums.DEPOSIT_CHANGE_SUPPLEMENT.getType()));
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,生成合同文件失败");
        }
        String pdfUrl = printSupplement(task); //生成保证金补充协议合同
        //增加新的附件信息保存
        BizFiles bizFiles=new BizFiles();
        bizFiles.setBizCode(vo.getDepositTaskNo());
        bizFiles.setBizCodeType(BizCodeTypeEnums.DEPOSIT_CHANGE_CONTRACT_FILE.getCodeType());
        bizFiles.setFileType(BizCodeTypeEnums.DEPOSIT_CHANGE_CONTRACT_FILE_1.getCodeType());
        bizFiles.setFileName(sysTplType.getTplTypeName()+task.getContNo()+".pdf");
        bizFiles.setFilePath(pdfUrl);
        bizFilesList.add(bizFiles);
    }


    /**
     * @Title:
     * @Description: 生成保证金合同
     * @param task 增加保证金任务实体类
     * @return String
     * @throws
     */
    public String printSupplement(DepositChangeTask task) {
        //获取申请信息
        DepositChangeApplyVo vo = depositChangeTaskRepository.selectApplyInfoByContNo(task.getContNo());
        //获取车型品牌
        DepositVehicleTypeVo typeVo = depositChangeTaskRepository.selectVehicleType(task.getContNo());
        String brandType; //车型品牌
        if(typeVo == null){
            brandType = null;
        } else {
            String brand = typeVo.getBrand() == null ? "" : typeVo.getBrand();
            String type = typeVo.getType() == null ? "" : typeVo.getType();
            brandType = brand + type;
        }
        //pdf的参数
        Map<String,String> pdfVariables = new HashMap();
        // 甲方
        pdfVariables.put("groupName", vo.getLessor());
        // 乙方
        pdfVariables.put("name", vo.getLessee());
        //合同号
        pdfVariables.put("contNo", task.getContNo());
        //品牌型号
        pdfVariables.put("vehicleName", brandType);
        //车牌号
        pdfVariables.put("vehicleLicenseNo", vo.getVehicleLicenseNo());
        //保证金
        pdfVariables.put("bond", task.getSupplementDeposit().toString());
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.DEPOSIT_CHANGE_SUPPLEMENT.getType());
        return filePath;
    }

    /**
     * 构建基础参数
     * @param contNo
     * @param varsMap
     * @param applyVo
     */
    private void buildBaseParam(String contNo, Map<String, String> varsMap, DepositChangeApplyVo applyVo) {
        varsMap.put("name",applyVo.getLessee());
        varsMap.put("name0",applyVo.getLessee());
        varsMap.put("contNo",contNo);
        //设置合同编号,多个
        setContNoVarsMap(contNo,varsMap);
        //获取合同融资信息
        ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(contNo);
        //合同融资车辆信息
        ContractVehicleVo contractVehicleVo =  contractVehicleRepository.selectContractVehicleVoByContNo(contNo);
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
        //直租合同《担保保函》(个人和企业)债务人民币......
        if(contractFinanceVo != null){
            BigDecimal debtMoney;
            if(BigDecimal.ZERO.compareTo(contractFinanceVo.getAnnualSupplyAmount())!=0) {
                debtMoney = contractFinanceVo.getRent().multiply(new BigDecimal(contractFinanceVo.getFinPeriodType()).subtract(BigDecimalUtils.divide(new BigDecimal(contractFinanceVo.getFinPeriodType()), new BigDecimal("12"), 0))).add(
                        contractFinanceVo.getAnnualSupplyAmount().multiply(BigDecimalUtils.divide(new BigDecimal(contractFinanceVo.getFinPeriodType()), new BigDecimal("12"), 0))).add(backPurchaseMoney);
            }else {
                debtMoney = (contractFinanceVo.getRent().multiply(new BigDecimal(contractFinanceVo.getFinPeriodType()))).add(backPurchaseMoney);
            }
            varsMap.put("debtMoney",debtMoney.toString());
            varsMap.put("debtMoneyFor", CommonUtils.changeMoney(debtMoney));
            varsMap.put("debtMoney"+1,debtMoney.toString());
            varsMap.put("debtMoneyFor"+1,CommonUtils.changeMoney(debtMoney));
        }
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
     * 生成担保企业保函
     * @param vo
     * @param task
     * @param bizFilesList
     * @param varsMap
     */
    private void printPersTpl(DepositApproveVo vo, DepositChangeTask task, List<BizFiles> bizFilesList, Map<String, String> varsMap) {
        //获取担保保函（个人)
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey(TplTypeKeyEnums.DIRECT_RENT_FILE2.getType()));
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,生成合同文件失败");
        }
        //担保人信息字符串转成json数组
        String jsonArrayStr = varsMap.get("jsonArrayStrPer");
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
                    varsMap.put(stringMap.getKey(), stringMap.getValue().toString());
                }
                String pdfUrl = commonPdfService.create(varsMap, TplTypeKeyEnums.DIRECT_RENT_FILE2.getType());
                //增加新的附件信息保存
                BizFiles bizFiles=new BizFiles();
                bizFiles.setBizCode(vo.getDepositTaskNo());
                bizFiles.setBizCodeType(BizCodeTypeEnums.DEPOSIT_CHANGE_CONTRACT_FILE.getCodeType());
                bizFiles.setFileType(BizCodeTypeEnums.DEPOSIT_CHANGE_CONTRACT_FILE_1.getCodeType());
                bizFiles.setFileName(sysTplType.getTplTypeName()+task.getContNo()+".pdf");
                bizFiles.setFilePath(pdfUrl);
                bizFilesList.add(bizFiles);
            }
        }
    }

    /**
     * 生成担保企业担保函
     * @param vo
     * @param task
     * @param bizFilesList
     * @param varsMap
     */
    private void printCompTpl(DepositApproveVo vo, DepositChangeTask task, List<BizFiles> bizFilesList, Map<String, String> varsMap) {
        //获取担保保函（企业)
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey(TplTypeKeyEnums.DIRECT_RENT_FILE3.getType()));
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,生成合同文件失败");
        }
        //担保企业信息字符串转成json数组
        String jsonArrayStr = varsMap.get("jsonArrayStrComp");
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
                    varsMap.put(stringMap.getKey(), stringMap.getValue().toString());
                }
                String pdfUrl = commonPdfService.create(varsMap, TplTypeKeyEnums.DIRECT_RENT_FILE3.getType());
                //增加新的附件信息保存
                BizFiles bizFiles=new BizFiles();
                bizFiles.setBizCode(vo.getDepositTaskNo());
                bizFiles.setBizCodeType(BizCodeTypeEnums.DEPOSIT_CHANGE_CONTRACT_FILE.getCodeType());
                bizFiles.setFileType(BizCodeTypeEnums.DEPOSIT_CHANGE_CONTRACT_FILE_1.getCodeType());
                bizFiles.setFileName(sysTplType.getTplTypeName()+task.getContNo()+".pdf");
                bizFiles.setFilePath(pdfUrl);
                bizFilesList.add(bizFiles);
            }
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

}
