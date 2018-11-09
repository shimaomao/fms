package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActLawsuitTaskUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DispatchTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.LawsuitRegisterRepository;
import cn.com.leadu.fms.data.postbiz.repository.LawsuitTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueContRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCont;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskSearchVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.LawsuitTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskService
 * @Description: 诉讼任务信息业务实现层
 */
@Service
public class LawsuitTaskServiceImpl implements LawsuitTaskService {

    /**
     * @Fields  : 诉讼任务信息repository
     */
    @Autowired
    private LawsuitTaskRepository lawsuitTaskRepository;
    @Autowired
    private NumGenerateService numGenerateService;
    @Autowired
    private WorkflowLogService workflowLogService;
    @Autowired
    private BizFilesService bizFilesService;
    @Autowired
    private LawsuitRegisterRepository lawsuitRegisterRepository;
    @Autowired
    private OverdueContRepository overdueContRepository;

    /**
     * @Title:
     * @Description: 分页查询诉讼任务信息
     * @param lawsuitTaskSearchVo
     * @return PageInfoExtend<LawsuitTask>
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    public PageInfoExtend<LawsuitTaskSearchVo> findLawsuitTasksByPage(LawsuitTaskSearchVo lawsuitTaskSearchVo){
        // 参数构造
        lawsuitTaskSearchVo = buildParams(lawsuitTaskSearchVo);
        PageInfoExtend<LawsuitTaskSearchVo> pageInfo = lawsuitTaskRepository.selectListVoByPage("selectLawsuitTasksByPage", lawsuitTaskSearchVo,lawsuitTaskSearchVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 根据lawsuitTaskNo获取诉讼任务信息
     * @param lawsuitTaskNo
     * @return LawsuitTaskSearchVo
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    public LawsuitTaskSearchVo findLawsuitTasksByTaskNo(String lawsuitTaskNo) {
        if (StringUtils.isTrimBlank(lawsuitTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        // 获取诉讼任务信息
        LawsuitTaskSearchVo lawsuitTaskSearchVo = lawsuitTaskRepository.selectLawsuitTasksByTaskNo(lawsuitTaskNo);
        return lawsuitTaskSearchVo;
    }

    /**
     * @param lawsuitTaskNo
     * @return LawsuitTaskSearchVo
     * @throws
     * @Title:
     * @Description: 根据lawsuitTaskNo获取诉讼登记信息
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    public LawsuitTaskSearchVo findLawsuitRegistersByTaskNo(String lawsuitTaskNo) {
        // 获取诉讼任务信息
        LawsuitTaskSearchVo lawsuitTaskSearchVo = lawsuitTaskRepository.selectLawsuitRegistersByTaskNo(lawsuitTaskNo);

        //获取提交的附件
        List<BizFiles> bizFilesList = bizFilesService.findBizFilesList(lawsuitTaskNo, BizCodeTypeEnums.LAWSUIT_REGISTER_FILE.getCodeType());
        if (ArrayUtils.isNotNullAndLengthNotZero(bizFilesList)){
            lawsuitTaskSearchVo.setBizFilesList(bizFilesList);
        }
        return lawsuitTaskSearchVo;
    }

    /**
     * @param overdueContId
     * @return overdueContId
     * @throws
     * @Title:
     * @Description: 根据overdueContId获取诉讼基本信息
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    public LawsuitTaskSearchVo findLawsuitTasksByOverdueContId(String overdueContId) {
        if (StringUtils.isTrimBlank(overdueContId)){
            throw new FmsServiceException("参数不正确");
        }
        LawsuitTaskSearchVo lawsuitTaskSearchVo = lawsuitTaskRepository.selectLawsuitTasksByOverdueContId(overdueContId);
        return lawsuitTaskSearchVo;
    }

    /**
     * @Title:
     * @Description: 根据overdueContId获取逾期客户Id
     * @param overdueContId
     * @return overdueContId
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    public String findOverdueCstmIdByOverdueContId(String overdueContId) {
        if (StringUtils.isTrimBlank(overdueContId)){
            throw new FmsServiceException("参数不正确");
        }
        Example example = SqlUtil.newExample(OverdueCont.class);
        example.createCriteria().andEqualTo("overdueContId", overdueContId);
        OverdueCont overdueCont = overdueContRepository.selectOneByExample(example);
        if (overdueCont == null){
            throw new FmsServiceException("逾期合同信息不存在");
        }
        return overdueCont.getOverdueCstmId();
    }

    private LawsuitTaskSearchVo buildParams(LawsuitTaskSearchVo lawsuitTaskSearchVo) {
        // 申请编号
        if (StringUtils.isNotTrimBlank(lawsuitTaskSearchVo.getApplyNo())){
            lawsuitTaskSearchVo.setApplyNo(SqlUtil.likePattern(lawsuitTaskSearchVo.getApplyNo()));
        } else {
            lawsuitTaskSearchVo.setApplyNo(null);
        }
        // 合同编号
        if (StringUtils.isNotTrimBlank(lawsuitTaskSearchVo.getContNo())){
            lawsuitTaskSearchVo.setContNo(SqlUtil.likePattern(lawsuitTaskSearchVo.getContNo()));
        } else {
            lawsuitTaskSearchVo.setContNo(null);
        }
        // 车架号
        if (StringUtils.isNotTrimBlank(lawsuitTaskSearchVo.getVinNo())){
            lawsuitTaskSearchVo.setVinNo(SqlUtil.likePattern(lawsuitTaskSearchVo.getVinNo()));
        } else {
            lawsuitTaskSearchVo.setVinNo(null);
        }
        // 车牌号
        if (StringUtils.isNotTrimBlank(lawsuitTaskSearchVo.getVehicleLicenseNo())){
            lawsuitTaskSearchVo.setVehicleLicenseNo(SqlUtil.likePattern(lawsuitTaskSearchVo.getVehicleLicenseNo()));
        } else {
            lawsuitTaskSearchVo.setVehicleLicenseNo(null);
        }
        // 承租人
        if (StringUtils.isNotTrimBlank(lawsuitTaskSearchVo.getCstmName())){
            lawsuitTaskSearchVo.setCstmName(SqlUtil.likePattern(lawsuitTaskSearchVo.getCstmName()));
        } else {
            lawsuitTaskSearchVo.setCstmName(null);
        }
        // 发起人
        if (StringUtils.isNotTrimBlank(lawsuitTaskSearchVo.getSubmitUser())){
            lawsuitTaskSearchVo.setSubmitUser(SqlUtil.likePattern(lawsuitTaskSearchVo.getSubmitUser()));
        } else {
            lawsuitTaskSearchVo.setSubmitUser(null);
        }
        // 任务状态
        if (StringUtils.isTrimBlank(lawsuitTaskSearchVo.getLawsuitTaskStatus())){
            lawsuitTaskSearchVo.setLawsuitTaskStatus(null);
        }
        // 派单类型
        if (StringUtils.isTrimBlank(lawsuitTaskSearchVo.getDispatchType())){
            lawsuitTaskSearchVo.setDispatchType(null);
        }
        // 登记人
        if (StringUtils.isNotTrimBlank(lawsuitTaskSearchVo.getRegisterUser())){
            lawsuitTaskSearchVo.setRegisterUser(SqlUtil.likePattern(lawsuitTaskSearchVo.getRegisterUser()));
        } else {
            lawsuitTaskSearchVo.setRegisterUser(null);
        }
        return lawsuitTaskSearchVo;
    }

    /**
     * @Title:
     * @Description: 诉讼任务申请发起
     * @param lawsuitTaskSearchVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    @Transactional
    public void saveLawsuitTask(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser){
        String status ;
        if (StringUtils.isNotTrimBlank(lawsuitTaskSearchVo.getTaskId())){
            // 任务id不为空，审核退回重新提交的数据
            // 继续工作流
            ActRuTaskVo actRuTaskVo = ActLawsuitTaskUtils.approvalAgree(lawsuitTaskSearchVo.getTaskId());
            status = actRuTaskVo.getTaskCode();//任务状态
            if (StringUtils.equals(DispatchTypeEnums.COMPANY.getType(), lawsuitTaskSearchVo.getDispatchType())){
                //如果是公司内部 登记人设定为派单人
                lawsuitTaskSearchVo.setRegisterUser(lawsuitTaskSearchVo.getDispatchUser());
            }
            lawsuitTaskSearchVo.setLawsuitTaskStatus(actRuTaskVo.getTaskCode());//任务状态
            lawsuitTaskSearchVo.setPresentUser(actRuTaskVo.getNextAssignee());//当前节点用户
            // 更新诉讼任务表
            lawsuitTaskRepository.updateByPrimaryKeySelectiveData(lawsuitTaskSearchVo.getEntity());
        } else {
            // taskId为空，首次发起申请
            // 校验合同是否存在未结束的任务
            isLawsuitTaskExit(lawsuitTaskSearchVo.getOverdueContId());
            if (StringUtils.equals(DispatchTypeEnums.COMPANY.getType(), lawsuitTaskSearchVo.getDispatchType())){
                //如果是公司内部 登记人设定为派单人
                lawsuitTaskSearchVo.setRegisterUser(lawsuitTaskSearchVo.getDispatchUser());
            }
            //生成任务号
            String taskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.LAWSUIT.getType());
            // 开启工作流
            ActRuTaskVo actRuTaskVo = ActLawsuitTaskUtils.startLawsuitTaskApply(taskNo, lawsuitTaskSearchVo.getCstmName(), lawsuitTaskSearchVo.getRegisterUser());
            status = actRuTaskVo.getTaskCode();//任务状态
            // 登录诉讼任务表
            insertLawsuitTask(lawsuitTaskSearchVo, sysUser, taskNo, actRuTaskVo);

        }
        // 保存流程日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.SUBMIT.getType(), lawsuitTaskSearchVo, status);
    }

    /**
     * @param overdueContId
     * @return
     * @throws
     * @Title:
     * @Description: 校验合同是否存在未结束的任务
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    public void isLawsuitTaskExit(String overdueContId) {
        if (StringUtils.isTrimBlank(overdueContId)){
            throw new FmsServiceException("参数不正确");
        }
        Example example = SqlUtil.newExample(LawsuitTask.class);
        example.createCriteria().andEqualTo("overdueContId", overdueContId);
        // 获取当前合同对应的所有任务数据
        List<LawsuitTask> lawsuitTaskList = lawsuitTaskRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(lawsuitTaskList)){
            for (LawsuitTask lawsuitTask : lawsuitTaskList){
                // 如果状态为空，则说明是自动程序产生的数据，还未开启工作流，不做check
                if (StringUtils.isNotTrimBlank(lawsuitTask.getLawsuitTaskStatus())){
                    if (!StringUtils.equals(BizStatusEnums.LAWSUIT_REFUSE.getType(), lawsuitTask.getLawsuitTaskStatus())
                            && !StringUtils.equals(BizStatusEnums.LAWSUIT_END.getType(), lawsuitTask.getLawsuitTaskStatus())){
                        throw new FmsServiceException("当前合同存在未结束的任务，请先结束任务再发起");
                    }
                }
            }
        }
    }

    /**
     * 登录诉讼任务表
     * @param lawsuitTaskSearchVo
     * @param sysUser
     * @param taskNo
     * @param actRuTaskVo
     */
    private void insertLawsuitTask(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser, String taskNo, ActRuTaskVo actRuTaskVo) {
        // 诉讼任务表初始化
        lawsuitTaskSearchVo.setLawsuitTaskNo(taskNo);//任务号
        lawsuitTaskSearchVo.setLawsuitTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        lawsuitTaskSearchVo.setPresentUser(actRuTaskVo.getNextAssignee());//当前节点用户
        lawsuitTaskSearchVo.setSubmitUser(sysUser.getUser());// 发起人
        lawsuitTaskSearchVo.setSubmitDate(DateUtils.getNowDate());// 发起时间
        // 登录诉讼任务表
        lawsuitTaskRepository.insertData(lawsuitTaskSearchVo.getEntity());
    }

    /**
     * @param lawsuitTaskSearchVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 风控经理审核通过
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    @Transactional
    public void lawsuitApproval(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(lawsuitTaskSearchVo.getTaskId())
                || StringUtils.isTrimBlank(lawsuitTaskSearchVo.getLawsuitTaskNo()) ){
            throw new FmsServiceException("参数不正确");
        }
        // 工作流
        ActRuTaskVo actRuTaskVo = ActLawsuitTaskUtils.approvalAgree(lawsuitTaskSearchVo.getTaskId());
        // 更新诉讼任务表
        updateLawsuitTask(lawsuitTaskSearchVo, actRuTaskVo);

        // 保存流程日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.APPROVAL.getType(), lawsuitTaskSearchVo, actRuTaskVo.getTaskCode());
    }

    /**
     * @param lawsuitTaskSearchVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 退回
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    @Transactional
    public void lawsuitBack(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser) {

        if (StringUtils.isTrimBlank(lawsuitTaskSearchVo.getLawsuitTaskNo())
                || StringUtils.isTrimBlank(lawsuitTaskSearchVo.getTaskId())){
            throw new FmsServiceException("参数不正确");
        }
        // 工作流
        ActRuTaskVo actRuTaskVo = ActLawsuitTaskUtils.approvalReturnSuperior(lawsuitTaskSearchVo.getTaskId());
        // 更新诉讼任务表
        updateLawsuitTask(lawsuitTaskSearchVo, actRuTaskVo);

        // 保存流程日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.SENDBACK.getType(), lawsuitTaskSearchVo, actRuTaskVo.getTaskCode());
    }

    /**
     * @param lawsuitTaskSearchVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 拒绝
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    @Transactional
    public void lawsuitRefuse(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser) {

        if (StringUtils.isTrimBlank(lawsuitTaskSearchVo.getLawsuitTaskNo())
                || StringUtils.isTrimBlank(lawsuitTaskSearchVo.getTaskId())){
            throw new FmsServiceException("参数不正确");
        }
        // 工作流
        ActRuTaskVo actRuTaskVo = ActLawsuitTaskUtils.approvalRefuse(lawsuitTaskSearchVo.getTaskId());
        Example example = SqlUtil.newExample(LawsuitTask.class);
        example.createCriteria().andEqualTo("lawsuitTaskNo", lawsuitTaskSearchVo.getLawsuitTaskNo());
        LawsuitTask lawsuitTask = lawsuitTaskRepository.selectOneByExample(example);
        if (lawsuitTask == null){
            throw new FmsServiceException("诉讼任务不存在");
        }
        lawsuitTask.setPresentUser(actRuTaskVo.getNextAssignee());//当前节点用户
        lawsuitTask.setLawsuitTaskStatus(BizStatusEnums.LAWSUIT_REFUSE.getType());//任务状态
        // 更新诉讼任务表
        lawsuitTaskRepository.updateByPrimaryKeySelectiveData(lawsuitTask);

        // 保存流程日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.REFUSE.getType(), lawsuitTaskSearchVo, actRuTaskVo.getTaskCode());
    }

    /**
     * @param lawsuitTaskSearchVo
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 诉讼任务登记暂存
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    @Transactional
    public void registerTemporary(LawsuitTaskSearchVo lawsuitTaskSearchVo) {
        // 更新诉讼任务表
        lawsuitTaskRepository.updateByPrimaryKeySelectiveData(lawsuitTaskSearchVo.getEntity());
        // 保存诉讼登记表
        saveLawsuitRegister(lawsuitTaskSearchVo);

        if (ArrayUtils.isNotNullAndLengthNotZero(lawsuitTaskSearchVo.getBizFilesList())){
            //保存附件信息
            bizFilesService.modifyBizFilesList(lawsuitTaskSearchVo.getBizFilesList(),lawsuitTaskSearchVo.getLawsuitTaskNo(),
                    BizCodeTypeEnums.LAWSUIT_REGISTER_FILE.getCodeType());
        }

    }

    /**
     * @Title:
     * @Description: 诉讼任务登记提交
     * @param lawsuitTaskSearchVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @Override
    @Transactional
    public void registerSave(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(lawsuitTaskSearchVo.getTaskId())
                || StringUtils.isTrimBlank(lawsuitTaskSearchVo.getLawsuitTaskNo())){
            throw new FmsServiceException("taskId不能为空");
        }
        // 开启工作流
        ActRuTaskVo actRuTaskVo =ActLawsuitTaskUtils.approvalAgree(lawsuitTaskSearchVo.getTaskId());
        // 更新诉讼任务表
        updateLawsuitTaskRegister(lawsuitTaskSearchVo, actRuTaskVo);

        // 保存诉讼登记表
        saveLawsuitRegister(lawsuitTaskSearchVo);

        if (ArrayUtils.isNotNullAndLengthNotZero(lawsuitTaskSearchVo.getBizFilesList())){
            //保存附件信息
            bizFilesService.modifyBizFilesList(lawsuitTaskSearchVo.getBizFilesList(),lawsuitTaskSearchVo.getLawsuitTaskNo(),
                    BizCodeTypeEnums.LAWSUIT_REGISTER_FILE.getCodeType());
        } else {
            throw new FmsServiceException("请上传诉讼登记附件");
        }

        // 保存流程日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.SUBMIT.getType(), lawsuitTaskSearchVo, actRuTaskVo.getTaskCode());
    }

    /**
     * 更新诉讼任务表
     * @param lawsuitTaskSearchVo
     * @param actRuTaskVo
     */
    private void updateLawsuitTaskRegister(LawsuitTaskSearchVo lawsuitTaskSearchVo, ActRuTaskVo actRuTaskVo) {
        // 更新诉讼任务表
        Example example = SqlUtil.newExample(LawsuitTask.class);
        example.createCriteria().andEqualTo("lawsuitTaskNo", lawsuitTaskSearchVo.getLawsuitTaskNo());
        LawsuitTask lawsuitTask = lawsuitTaskRepository.selectOneByExample(example);
        if (lawsuitTask == null){
            throw new FmsServiceException("诉讼任务不存在");
        }
        lawsuitTaskSearchVo.setPresentUser(actRuTaskVo.getNextAssignee());//当前节点用户
        lawsuitTaskSearchVo.setLawsuitTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        // 更新诉讼任务表
        lawsuitTaskRepository.updateByPrimaryKeySelectiveData(lawsuitTaskSearchVo.getEntity());
    }

    /**
     * 保存诉讼登记表
     * @param lawsuitTaskSearchVo
     */
    private void saveLawsuitRegister(LawsuitTaskSearchVo lawsuitTaskSearchVo) {
        // 初始化诉讼登记表更新List
        List<LawsuitRegister> lawsuitRegisterUpdList = new ArrayList<>();
        // 初始化诉讼登记表新增List
        List<LawsuitRegister> lawsuitRegisterIntList = new ArrayList<>();
        // 获取诉讼登记表历史数据
        List<LawsuitRegisterVo> oldLawsuitRegisterVoList = lawsuitTaskRepository.selectLawsuitRegisterVosByLawsuitTaskNo(lawsuitTaskSearchVo.getLawsuitTaskNo());
        // 画面获取的登记信息List
        for (LawsuitRegisterVo lawsuitRegisterVo : lawsuitTaskSearchVo.getLawsuitRegisterVoList()){
            if (ArrayUtils.isNotNullAndLengthNotZero(oldLawsuitRegisterVoList)){
                for (LawsuitRegisterVo oldLawsuitRegisterVo : oldLawsuitRegisterVoList){
                    if (StringUtils.isNotTrimBlank(lawsuitRegisterVo.getLawsuitRegisterId())){
                        // 如果有主键，则是更新,判断诉讼登记Id是否相同
                        if (StringUtils.equals(lawsuitRegisterVo.getLawsuitRegisterId(), oldLawsuitRegisterVo.getLawsuitRegisterId())){
                            // 判断诉讼跟进信息是否有修改
                            if (isLawsuitTaskChange(oldLawsuitRegisterVo, lawsuitRegisterVo)){
                                // 如果有主键且跟进信息被修改过，则是更新登记信息
                                lawsuitRegisterUpdList.add(lawsuitRegisterVo.getEntity());
                            }
                        }
                    } else {
                        // 如果没有主键，则是新增登记信息
                        lawsuitRegisterVo.setLawsuitTaskNo(lawsuitTaskSearchVo.getLawsuitTaskNo());//设定任务号
                        lawsuitRegisterIntList.add(lawsuitRegisterVo.getEntity());
                    }
                }
            } else {
                // 如果没有旧数据，则是新增登记信息
                lawsuitRegisterVo.setLawsuitTaskNo(lawsuitTaskSearchVo.getLawsuitTaskNo());//设定任务号
                lawsuitRegisterIntList.add(lawsuitRegisterVo.getEntity());
            }

        }
        // 更新诉讼登记表
        if (ArrayUtils.isNotNullAndLengthNotZero(lawsuitRegisterUpdList)){
            lawsuitRegisterRepository.updateByPrimaryKeySelectiveDataList(lawsuitRegisterUpdList);
        }
        // 插入诉讼登记表
        if (ArrayUtils.isNotNullAndLengthNotZero(lawsuitRegisterIntList)){
            lawsuitRegisterRepository.insertDataList(lawsuitRegisterIntList);
        }
    }

    /**
     * 判断跟进信息是否被修改
     * @param oldEntity
     * @param newEntity
     * @return
     */
    private Boolean isLawsuitTaskChange(LawsuitRegisterVo oldEntity, LawsuitRegisterVo newEntity){
        if (StringUtils.notEquals(oldEntity.getCourt(), newEntity.getCourt())
                || StringUtils.notEquals(oldEntity.getCaseRecordNo(), newEntity.getCaseRecordNo())
                || StringUtils.notEquals(oldEntity.getCaseStatus(), newEntity.getCaseStatus())
                || oldEntity.getCaseDate().getTime() != newEntity.getCaseDate().getTime()
                || StringUtils.notEquals(oldEntity.getJudge(), newEntity.getJudge())
                || StringUtils.notEquals(oldEntity.getJudgeContactNo(), newEntity.getJudgeContactNo())
                || StringUtils.notEquals(oldEntity.getCaseIntroduce(), newEntity.getCaseIntroduce())
                || BigDecimalUtils.notEqual(oldEntity.getLawsuitAmount(), newEntity.getLawsuitAmount())
                || BigDecimalUtils.notEqual(oldEntity.getJudgmentAmount(), newEntity.getJudgmentAmount())
                || StringUtils.notEquals(oldEntity.getCaseRecordNo(), newEntity.getCaseRecordNo())){
            // 受理法院 立案案号 案件状态 案件时间 承办法官 承办法官联系方式 案件说明 诉讼金额 判决金额 执行案号只要有变更，则需要更新
            return true;
        }
        return false;
    }

    /**
     * 更新诉讼任务表
     * @param lawsuitTaskSearchVo
     * @param actRuTaskVo
     */
    private void updateLawsuitTask(LawsuitTaskSearchVo lawsuitTaskSearchVo, ActRuTaskVo actRuTaskVo) {
        Example example = SqlUtil.newExample(LawsuitTask.class);
        example.createCriteria().andEqualTo("lawsuitTaskNo", lawsuitTaskSearchVo.getLawsuitTaskNo());
        LawsuitTask lawsuitTask = lawsuitTaskRepository.selectOneByExample(example);
        if (lawsuitTask == null){
            throw new FmsServiceException("诉讼任务不存在");
        }
        lawsuitTask.setPresentUser(actRuTaskVo.getNextAssignee());//当前节点用户
        lawsuitTask.setLawsuitTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        // 更新诉讼任务表
        lawsuitTaskRepository.updateByPrimaryKeySelectiveData(lawsuitTask);
    }

    /**
     * 保存流程日志信息
     * @param user
     * @param actType
     * @param lawsuitTaskSearchVo
     * @param status
     */
    private void saveWorkFlowLog(String user, String actType, LawsuitTaskSearchVo lawsuitTaskSearchVo, String status) {
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(user);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setActType(actType);
        workflowLog.setWfLogType(BizTypeEnums.LAWSUIT.getType());
        workflowLog.setWfLogNo(lawsuitTaskSearchVo.getLawsuitTaskNo());
        workflowLog.setRemark1(lawsuitTaskSearchVo.getRemark());
        workflowLog.setStatus(status);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

}
