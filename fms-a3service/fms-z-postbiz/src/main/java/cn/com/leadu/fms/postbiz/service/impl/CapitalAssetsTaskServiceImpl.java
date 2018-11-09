package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActCapitalAssetsUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.SecHandSourceEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.SecHandStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehicleDisposalStatusEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.CapitalAssetsTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.SecHandInventoryRepository;
import cn.com.leadu.fms.data.postbiz.repository.VehicleDisposalRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.entity.CapitalAssetsTask;
import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.CapitalAssetsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.SecCarInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.CapitalAssetsTaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;

/**
 * @author huzongcheng
 * @ClassName: CapitalAssetsTaskServiceImpl
 * @Description: 转固定资产任务业务实现层
 */
@Service
public class CapitalAssetsTaskServiceImpl implements CapitalAssetsTaskService {

    @Autowired
    private NumGenerateService numGenerateService;
    @Autowired
    private WorkflowLogService workflowLogService;
    @Autowired
    private BizFilesService bizFilesService;
    @Autowired
    private CapitalAssetsTaskRepository capitalAssetsTaskRepository;
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;
    @Autowired
    private VehicleDisposalRepository vehicleDisposalRepository;
    @Autowired
    private SecHandInventoryRepository secHandInventoryRepository;


    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return VehicleDisposalVo
     * @Title:
     * @Description: 转固定资产申请发起
     * @author huzongcheng
     */
    @Transactional
    public String submitCapitalAssets(VehicleDisposalVo vo, SysUser sysUser) {
        if (getCapitalAssetsTaskByContNo(vo.getContNo()) != null) {
            throw new FmsServiceException("申请失败，该车辆已转固定资产");
        }
        //查询剩余租金集合,将租金合并为一条
        operateRepaySked(vo);
        String capitalAssetsTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.CAPITAL_ASSETS_NUM_TYPE.getType());
        //开启工作流
        ActRuTaskVo actRuTaskVo = ActCapitalAssetsUtils.startCapitalAsstesAndSubmit(capitalAssetsTaskNo, vo.getCstmName());
        CapitalAssetsTask task = new CapitalAssetsTask();
        task.setContNo(vo.getContNo()); //合同编号
        task.setCapitalAssetsTaskNo(capitalAssetsTaskNo);
        task.setResidualValue(vo.getResidualValue()); //补充保证金
        task.setApplyRemark(vo.getRemark()); //申请备注
        task.setSubmitUser(sysUser.getUser()); //任务发起人
        task.setSubmitDate(new Date()); //任务发起时间
        capitalAssetsTaskRepository.insertData(task);
        //附件信息
        saveBizFiles(vo.getBizFilesList(), capitalAssetsTaskNo, BizCodeTypeEnums.CAPITAL_ASSETS_FILE.getCodeType());
        //工作流信息
        task.setCapitalAssetsTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, SUBMIT.getType(), sysUser);
        return capitalAssetsTaskNo;
    }

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return VehicleDisposalVo
     * @Title:
     * @Description: 总经理审批
     * @author huzongcheng
     */
    @Transactional
    public void approve(CapitalAssetsVo vo, SysUser sysUser) {
        CapitalAssetsTask task = getCapitalAssetsTaskByTaskNo(vo.getCapitalTaskNo());
        if (task == null) {
            throw new FmsServiceException("转固定资产任务不存在");
        }
        //更新车辆处置任务表
        setVehicleDisposal(task.getCapitalAssetsTaskNo());
        //清除之前合并的单条还款信息
        clearContRepaySked(task.getContNo());
        //生成数据到二手车库存表中
        buildSecHandInventoryData(task);
        //工作流信息
        ActRuTaskVo actRuTaskVo = ActCapitalAssetsUtils.approvalAgree(vo.getTaskId());
        task.setCapitalAssetsTaskStatus(actRuTaskVo.getTaskCode()); //状态
        task.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点操作人
        saveWorkFlowLog(task, vo.getRemark(), actRuTaskVo, ActTypeEnums.APPROVAL.getType(), sysUser);

    }

    /**
     * 通过合同号获取变更任务
     *
     * @param contNo 合同号
     * @return
     */
    public CapitalAssetsTask getCapitalAssetsTaskByContNo(String contNo) {
        Example example = SqlUtil.newExample(CapitalAssetsTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contNo);
        return capitalAssetsTaskRepository.selectOneByExample(example);
    }

    /**
     * 通过任务号获取变更任务
     *
     * @param taskNo 任务号
     * @return
     */
    public CapitalAssetsTask getCapitalAssetsTaskByTaskNo(String taskNo) {
        Example example = SqlUtil.newExample(CapitalAssetsTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("capitalAssetsTaskNo", taskNo);
        return capitalAssetsTaskRepository.selectOneByExample(example);
    }

    /**
     * @Description: 根据合同号查询未还款的还款计划表
     * @param: contNo 合同编号
     * @return: List<ContRepaySked> 还款计划集合
     * @Author: huzongcheng
     */
    public List<ContRepaySked> findContRepaySkedByContNo(String contNo) {
        List<String> statusList = new ArrayList();
        statusList.add(RepayStatusEnums.TO_BE_WITHHELD.getType());
        statusList.add(RepayStatusEnums.WITHDRAWING_FAILURE.getType());
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contNo);
        criteria.andIn("repayStatus", statusList);
        return contRepaySkedRepository.selectListByExample(example);
    }

    /**
     * @Description: 删除之前的期数
     * @param: contNo 合同编号
     * @Author: huzongcheng
     */
    public void clearPreviousRepaySked(String contNo) {
        List<String> statusList = new ArrayList();
        statusList.add(RepayStatusEnums.TO_BE_WITHHELD.getType());
        statusList.add(RepayStatusEnums.WITHDRAWING_FAILURE.getType());
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contNo);
        criteria.andIn("repayStatus", statusList);
        contRepaySkedRepository.deleteExampleData(example, new ContRepaySked());
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
     * @param
     * @throws
     * @Title:
     * @Description: 审批日志保存
     * @author huzongcheng
     */
    @Transactional
    private void saveWorkFlowLog(CapitalAssetsTask task, String remark, ActRuTaskVo actRuTaskVo, String actType, SysUser sysUser) {
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(task.getCapitalAssetsTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.CAPITAL_ASSETS.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(remark);
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
        //更新任务表
        capitalAssetsTaskRepository.updateByPrimaryKeyData(task, true);
    }

    /**
     * 将租金合并为一条
     * @param vo
     */
    private void operateRepaySked(VehicleDisposalVo vo) {
        List<ContRepaySked> repaySkedList = findContRepaySkedByContNo(vo.getContNo());
        if (ArrayUtils.isNotNullAndLengthNotZero(repaySkedList)) {
            // 删除之前的期数
            clearPreviousRepaySked(vo.getContNo());
            BigDecimal sum = BigDecimal.ZERO;
            for (ContRepaySked item : repaySkedList) {
                //累加，计算剩余总金额
                sum = sum.add(BigDecimalUtils.getNotNullBigDecimal(item.getRentActual()));
            }
            ContRepaySked contRepaySked = new ContRepaySked();
            contRepaySked.setContNo(vo.getContNo());
            contRepaySked.setPeriod(100);
            contRepaySked.setRepayType(RepayTypeEnums.CAPITAL_ASSETS.getType());
            contRepaySked.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType()); //设定为成功
            contRepaySked.setRentActual(sum); //每期客户实际租金
            contRepaySked.setRent(sum); //每期客户租金
            contRepaySked.setRepayDate(DateUtils.getMaxDate()); //收款日期为2099-12-31
            contRepaySked.setDealDate(repaySkedList.get(0).getDealDate()); //成交日期与之前任意一期保持一致
            // 新增一条总计
            contRepaySkedRepository.insertData(contRepaySked);
        }
    }

    /**
     * 清除之前合并的单条还款信息
     *
     * @param contNo 合同号
     */
    @Transactional
    private void clearContRepaySked(String contNo) {
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contNo);
        criteria.andEqualTo("repayType", RepayTypeEnums.CAPITAL_ASSETS.getType());
        contRepaySkedRepository.deleteExampleData(example, new ContRepaySked());
    }

    /**
     * 更新车辆处置任务表的状态
     *
     * @param taskNo 入参参数
     */
    @Transactional
    private void setVehicleDisposal(String taskNo) {
        Example example = SqlUtil.newExample(VehicleDisposal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("disposalTaskNo", taskNo);
        VehicleDisposal vehicleDisposal = vehicleDisposalRepository.selectOneByExample(example);
        vehicleDisposal.setVehicleDisposalStatus(VehicleDisposalStatusEnums.CAPITAL_ASSETS.getType());
        vehicleDisposalRepository.updateByPrimaryKeyData(vehicleDisposal, true);
    }

    /**
     * 生成数据到二手车库存表中
     *
     * @param task 车辆处置任务实体类
     */
    @Transactional
    private void buildSecHandInventoryData(CapitalAssetsTask task) {
        //根据处置任务号，查询构建二手车库存表需要的数据源
        SecCarInfoVo secCarInfoVo = vehicleDisposalRepository.selectSecCarInfoByTaskNo(task.getCapitalAssetsTaskNo());
        if(secCarInfoVo == null){
            throw new FmsServiceException("生成二手车库存数据失败");
        }
        SecHandInventory secHandInventory = new SecHandInventory();
        BeanUtils.copyProperties(secCarInfoVo,secHandInventory);
        secHandInventory.setEvaluationPrice(task.getResidualValue()); //二手车评估价
        secHandInventory.setStatus(SecHandStatusEnums.IN.getType()); //库存状态，在库
        secHandInventory.setCarSource(SecHandSourceEnums.RECOVERY.getType()); //来源，收车
        secHandInventory.setHandleDate(task.getSubmitDate()); //处理时间：转固定资产任务发起时间
        secHandInventoryRepository.insertData(secHandInventory);
    }
}
