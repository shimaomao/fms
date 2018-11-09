package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActRetrieveCarUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayFundNameEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileBizCodeTypeEnum;
import cn.com.leadu.fms.common.constant.enums.postbiz.DispatchTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.RetrieveTaskStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehicleDisposalStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.CommonFileUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.JsonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueContRepository;
import cn.com.leadu.fms.data.postbiz.repository.RetrieveCarsTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.VehicleDisposalRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCont;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.CollectionTaskService;
import cn.com.leadu.fms.postbiz.service.OverdueContService;
import cn.com.leadu.fms.postbiz.service.RetrieveCarsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskService
 * @Description: 收车任务业务实现层
 */
@Service
public class RetrieveCarsTaskServiceImpl implements RetrieveCarsTaskService {

    /**
     * @Fields  : 收车任务repository
     */
    @Autowired
    private RetrieveCarsTaskRepository retrieveCarsTaskRepository;

    /**
     * @Fields  : 逾期合同信息service
     * @author qiaomengnan
     */
    @Autowired
    private OverdueContService overdueContService;
    /**
     * @Fields  : 日志信息service
     * @author ningyangyang
     */
    @Autowired
    private WorkflowLogService workflowLogService;
    /**
     * @Fields  :付款信息repository
     * @author ningyangyang
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 附件信息保存service
     */
    @Autowired
    private BizFilesService bizFilesService;
    /**
     * @Fields  : 任务号service
     */
    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Fields  : 归档明细repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;
    /**
     * @Fields  : 车辆处置repository
     */
    @Autowired
    private VehicleDisposalRepository vehicleDisposalRepository;
    @Autowired
    private CollectionTaskService collectionTaskService;
    /**
     * @Fields  : 附件信息repository
     */
    @Autowired
    private OrigFileRepository origFileRepository;
    /**
     * @Fields  : 逾期合同repository
     */
    @Autowired
    private OverdueContRepository overdueContRepository;
    /**
     * @Fields  : pdf打印service
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * @Title:
     * @Description: 分页查询收车任务
     * @param retrieveCarsTaskVo
     * @return PageInfoExtend<RetrieveCarsTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    public PageInfoExtend<RetrieveCarsTaskVo> findRetrieveCarsTaskVosByPage(RetrieveCarsTaskVo retrieveCarsTaskVo){
        //收车入力条件
        setSelectParams(retrieveCarsTaskVo);
        PageInfoExtend<RetrieveCarsTaskVo> pageInfo = retrieveCarsTaskRepository.selectListVoByPage("selectRetrieveCarsTaskVos",retrieveCarsTaskVo,retrieveCarsTaskVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 查询条件入力
     * @param taskVo 任务对象
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    private void setSelectParams(RetrieveCarsTaskVo taskVo){
        if(StringUtils.isNotTrimBlank(taskVo.getApplyNo()))
            taskVo.setApplyNo(SqlUtil.likePattern(taskVo.getApplyNo()));
        else
            taskVo.setApplyNo(null);
        if(StringUtils.isNotTrimBlank(taskVo.getContNo()))
            taskVo.setContNo(SqlUtil.likePattern(taskVo.getContNo()));
        else
            taskVo.setContNo(null);
        if(StringUtils.isNotTrimBlank(taskVo.getOverdueContVinNo()))
            taskVo.setOverdueContVinNo(SqlUtil.likePattern(taskVo.getOverdueContVinNo()));
        else
            taskVo.setOverdueContVinNo(null);
        if(StringUtils.isNotTrimBlank(taskVo.getVehicleLicenseNo()))
            taskVo.setVehicleLicenseNo(SqlUtil.likePattern(taskVo.getVehicleLicenseNo()));
        else
            taskVo.setVehicleLicenseNo(null);
        if(StringUtils.isNotTrimBlank(taskVo.getCstmName()))
            taskVo.setCstmName(SqlUtil.likePattern(taskVo.getCstmName()));
        else
            taskVo.setCstmName(null);
        if(StringUtils.isNotTrimBlank(taskVo.getSubmitUser()))
            taskVo.setSubmitUser(SqlUtil.likePattern(taskVo.getSubmitUser()));
        else
            taskVo.setSubmitUser(null);
        if(StringUtils.isNotTrimBlank(taskVo.getTaskStatus()))
            taskVo.setTaskStatus(taskVo.getTaskStatus());
        else
            taskVo.setTaskStatus(null);
        if(StringUtils.isNotTrimBlank(taskVo.getDispachType()))
            taskVo.setDispachType(taskVo.getDispachType());
        else
            taskVo.setDispachType(null);
        if(StringUtils.isNotTrimBlank(taskVo.getRegisterPeople()))
            taskVo.setRegisterPeople(SqlUtil.likePattern(taskVo.getRegisterPeople()));
        else
            taskVo.setRegisterPeople(null);
    }




    /**
     * @Title:
     * @Description:  根据retrieveCarId获取收车任务
     * @param retrieveCarId
     * @return RetrieveCarsTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    public RetrieveCarsTask findRetrieveCarsTaskByRetrieveCarId(String retrieveCarId){
        return retrieveCarsTaskRepository.selectByPrimaryKey(retrieveCarId);
    }

    /**
     * @Title:
     * @Description:  根据收车任务号，获取收车任务
     * @param retrieveCarTaskNo 收车任务号
     * @return RetrieveCarsTask
     * @throws
     * @author wangxue
     * @date 2018-9-12 15:55:56
     */
    @Override
    public RetrieveCarsTask findRetrieveCarsTaskByretRieveCarTaskNo(String retrieveCarTaskNo) {
        Example example = new Example(RetrieveCarsTask.class);
        example.createCriteria().andEqualTo("retrieveCarTaskNo", retrieveCarTaskNo);
        return retrieveCarsTaskRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:   发起收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:34:41
     */
    @Transactional
    public void retrieveCarsTaskLaunch(RetrieveCarsTaskVo retrieveCarsTaskVo , SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = null;
        //第一次提交任务
        if(StringUtils.isTrimBlank(retrieveCarsTaskVo.getTaskId())){
            RetrieveCarsTask task = checkRetrieveCarsTaskLaunch(retrieveCarsTaskVo,sysUser);
            if(StringUtils.isNotTrimBlank(task.getRetrieveCarId())){
                retrieveCarsTaskRepository.updateByPrimaryKeySelectiveData(task,true);
            }
            else{
                String taskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.RETRIEVE_CAR_TASK_NUM_TYPE.getType());//任务号
                task.setRetrieveCarTaskNo(taskNo);
                retrieveCarsTaskRepository.insertData(task);
            }
            actRuTaskVo = ActRetrieveCarUtils.startRetrieveCarTask(task.getRetrieveCarTaskNo(),task.getContNo());
            retrieveCarsTaskVo.setRetrieveCarTaskNo(task.getRetrieveCarTaskNo());
            retrieveCarsTaskVo.setTaskStatus(actRuTaskVo.getTaskCode());
            retrieveCarsTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());
        }else{
            actRuTaskVo = ActRetrieveCarUtils.approvalAgree(retrieveCarsTaskVo.getTaskId());
        }
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
        //保存日志信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo,ActTypeEnums.SUBMIT.getType(),sysUser);
    }

    /**
     * @Title:
     * @Description:   check发起收车任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 10:42:31
     */
    private RetrieveCarsTask checkRetrieveCarsTaskLaunch(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        if(retrieveCarsTaskVo == null)
            throw new FmsServiceException("未接收到收车任务信息");
        if(StringUtils.isTrimBlank(retrieveCarsTaskVo.getContNo()))
            throw new FmsServiceException("未接收到逾期合同号信息");
        //验证合同是否已经在收车中
        Example example = SqlUtil.newExample(RetrieveCarsTask.class);
        example.createCriteria().andEqualTo("contNo",retrieveCarsTaskVo.getContNo());
        example.and(example.createCriteria().andNotEqualTo("taskStatus", RetrieveTaskStatusEnums.REFUSE.getType()).andNotEqualTo("taskStatus",RetrieveTaskStatusEnums.COMPLETE.getType()).andNotEqualTo("taskStatus",RetrieveTaskStatusEnums.TOBE_APPLY.getType()));
        //example.createCriteria().andEqualTo("contNo",retrieveCarsTaskVo.getContNo()).andNotEqualTo("taskStatus","4414").andNotEqualTo("taskStatus","4413").orIsNull("taskStatus");
        RetrieveCarsTask task = retrieveCarsTaskRepository.selectOneByExample(example);
        if(task != null && StringUtils.isNotTrimBlank(task.getPresentUser()))
            throw new FmsServiceException(String.format("合同号:%s,该任务正在进行收车任务，请等待收车结束后再申请",task.getContNo()));
        //查询合同是否存在
//        Example example1 = SqlUtil.newExample(OverdueCont.class);
//        example1.createCriteria().andEqualTo("overdueContId",retrieveCarsTaskVo.getOverdueContId());
        OverdueCont overdueCont = overdueContRepository.selectByPrimaryKey(retrieveCarsTaskVo.getOverdueContId());
        if(overdueCont == null)
            throw new FmsServiceException("逾期合同信息不存在");
        //
        //check通过,构建收车任务并返回
        if(task == null)
            task = new RetrieveCarsTask();
        //合同号
        task.setContNo(retrieveCarsTaskVo.getContNo());
        //逾期合同id
        task.setOverdueContId(overdueCont.getOverdueContId());
        //任务发起人
        task.setSubmitUser(sysUser.getUser());
        //任务发起日期
        task.setSubmitDate(new Date());
        //收车原因
        task.setRetrieveReason(retrieveCarsTaskVo.getRetrieveReason());
        return task;
    }

    /**
     * @Title:
     * @Description:   风控主管派单
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/17 02:50:49
     */
    @Transactional
    public void retrieveCarsTaskRisk(RetrieveCarsTaskVo retrieveCarsTaskVo,SysUser sysUser){
        ActRuTaskVo actRuTaskVo = null;
        //第一次申请，走风控审核
        if(judgeIsFirstSubmit(retrieveCarsTaskVo)){
            actRuTaskVo = ActRetrieveCarUtils.approvalAgreeDispatch(retrieveCarsTaskVo.getTaskId(),retrieveCarsTaskVo);
        }else{
            //第二次提交，直接到总经理审核
            actRuTaskVo = ActRetrieveCarUtils.approvalToCheck(retrieveCarsTaskVo.getTaskId(),retrieveCarsTaskVo);
        }
        checkRetrieveCarsTaskRisk(retrieveCarsTaskVo);
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //选择公司用户时，登记人员 默认为派单人员
        if(StringUtils.equals(retrieveCarsTaskVo.getDispachType(),DispatchTypeEnums.COMPANY.getType())){
            retrieveCarsTaskVo.setRegisterPeople(retrieveCarsTaskVo.getDispachPeople());
        }
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);

    }
    /**
     * @Title:
     * @Description:  判断是否第一次提交
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ninguyangyang
     * @date 2018/09/20 02:50:49
     */
    private Boolean judgeIsFirstSubmit(RetrieveCarsTaskVo retrieveCarsTaskVo){
        Example example = SqlUtil.newExample(RetrieveCarsTask.class);
        example.createCriteria().andEqualTo("contNo",retrieveCarsTaskVo.getContNo());
        List<RetrieveCarsTask> retrieveCarsTaskList = retrieveCarsTaskRepository.selectListByExample(example);
        if(retrieveCarsTaskList.size()>1){
            return false;
        }
        return true;
    }

    /**
     * @Title:
     * @Description:   检查风控主管派单
     * @param retrieveCarsTaskVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/09/17 02:54:37
     */
    private void checkRetrieveCarsTaskRisk(RetrieveCarsTaskVo retrieveCarsTaskVo) {
        if(StringUtils.isTrimBlank(retrieveCarsTaskVo.getDispachType()))
            throw new FmsServiceException("请选择派单类型");
        if(StringUtils.equals(retrieveCarsTaskVo.getDispachType(), DispatchTypeEnums.COMPANY.getType())){
            //公司
            if(StringUtils.isTrimBlank(retrieveCarsTaskVo.getDispachPeople()))
                throw new FmsServiceException("请选择派单人");
            //retrieveCarsTaskVo.setRegisterPeople("");
            retrieveCarsTaskVo.setThirdDispachOrg("");
            retrieveCarsTaskVo.setThirdDispachMobile("");
            retrieveCarsTaskVo.setThirdDispachContact("");
        } else if (StringUtils.equals(retrieveCarsTaskVo.getDispachType(), DispatchTypeEnums.THIRD_COM.getType())){
            //第三方
            if(StringUtils.isTrimBlank(retrieveCarsTaskVo.getRegisterPeople()))
                throw new FmsServiceException("请选择登记人");
            if(StringUtils.isTrimBlank(retrieveCarsTaskVo.getThirdDispachOrg()))
                throw new FmsServiceException("请输入第三方派单机构");
            if(StringUtils.isTrimBlank(retrieveCarsTaskVo.getRegisterPeople()))
                throw new FmsServiceException("请输入第三方机构联系人");
            if(StringUtils.isTrimBlank(retrieveCarsTaskVo.getRegisterPeople()))
                throw new FmsServiceException("请输入第三方机构联系电话");
            retrieveCarsTaskVo.setDispachPeople("");
        } else
            throw new FmsServiceException(String.format("派单类型不存在,%s",retrieveCarsTaskVo.getDispachType()));
    }
    
    /**
     * @Title:
     * @Description: 收车任务审批
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 11:32:25
     */
    @Transactional
    public void retrieveCarsTaskApprove(RetrieveCarsTaskVo retrieveCarsTaskVo,SysUser sysUser){
        //流程任务
        ActRuTaskVo actRuTaskVo  = ActRetrieveCarUtils.approvalAgree(retrieveCarsTaskVo.getTaskId());
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description:   通过收车任务id查询收车任务
     * @param retrieveCarId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 02:36:21
     */
    public RetrieveCarsTaskVo findRetrieveCarsTaskVoById(String retrieveCarId){
        if(StringUtils.isNotTrimBlank(retrieveCarId))
            return retrieveCarsTaskRepository.selectRetrieveCarsTaskVoById(retrieveCarId);
        return null;
    }

    /**
     * @Title:
     * @Description:   根据收车任务号获取收车任务详情
     * @param retrieveCarTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/18 01:50:17
     */
    public RetrieveCarsTaskVo findRetrieveCarsTaskVoByTaskNo(String retrieveCarTaskNo){
        if(StringUtils.isNotTrimBlank(retrieveCarTaskNo)){
            RetrieveCarsTaskVo retrieveCarsTaskVo =  retrieveCarsTaskRepository.selectRetrieveCarsTaskVoByTaskNo(retrieveCarTaskNo);
            //收车委派等级附件
            retrieveCarsTaskVo.setRegisterFileList(bizFilesService.findBizFilesList(retrieveCarsTaskVo.getRetrieveCarTaskNo(), BizCodeTypeEnums.REGISTER_FILE.getCodeType()));
            //收车入库附件
            retrieveCarsTaskVo.setStorageFileList(bizFilesService.findBizFilesList(retrieveCarsTaskVo.getRetrieveCarTaskNo(), BizCodeTypeEnums.STORAGE_FILE.getCodeType()));
            //获取归档附件
            Example example = SqlUtil.newExample(OrigFile.class);
            example.createCriteria().andEqualTo("bizCode",retrieveCarsTaskVo.getContNo()).andEqualTo("bizCodeType", OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());
            OrigFile origFile = origFileRepository.selectOneByExample(example);
            if(origFile != null){
                retrieveCarsTaskVo.setFileType(origFile.getOrigFileType());
                retrieveCarsTaskVo.setOrigSortFileList(bizFilesService.findBizFilesList(retrieveCarsTaskVo.getContNo(),origFile.getOrigFileType()));
            }else{
                throw new FmsServiceException("收车归档信息不能为空，请联系管理员");
            }
            //归档明细
            Example example1  = SqlUtil.newExample(OrigFileDetail.class);
            example1.createCriteria().andEqualTo("bizCode",retrieveCarsTaskVo.getContNo()).andEqualTo("fileType","carkey1");
            OrigFileDetail origFileDetail =  origFileDetailRepository.selectOneByExample(example1);
            if(origFileDetail != null){
                //车钥匙状态
                retrieveCarsTaskVo.setCarKeyStatus(origFileDetail.getOrigFileDetailStatus());
            }else{
                throw new FmsServiceException("车钥匙状态不能为空，请联系管理员");
            }
            //获取收付款信息
            getCostInfo(retrieveCarsTaskVo);
            return retrieveCarsTaskVo;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:  收车任务的委派和登记
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 01:50:17
     */
    @Override
    @Transactional
    public void retrieveCarsTaskRegister(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        //如果收车失败，则入库信息都置空
        if(YesNoFlagEnums.NO.getType().equals(retrieveCarsTaskVo.getRetrieveResult())){
            //retrieveCarsTaskVo.setStorageDate(DateUtils.getDateTime("1990-01-01"));
            retrieveCarsTaskVo.setStorageAddr("");
            retrieveCarsTaskVo.setAgent("");
            retrieveCarsTaskVo.setAgentMobileNo("");
            retrieveCarsTaskVo.setVinNo("");
            //retrieveCarsTaskVo.setMileAge(BigDecimal.ZERO);
            //retrieveCarsTaskVo.setActRetrAmount(BigDecimal.ZERO);
        }
        if(StringUtils.equals(retrieveCarsTaskVo.getFlag(),YesNoFlagEnums.YES.getType())){
            retrieveCarsTaskRepository.updateByPrimaryKeySelectiveData(retrieveCarsTaskVo.getEntity());
        }else{
            //流程信息
            ActRuTaskVo actRuTaskVo = null;
            //根据是否收车成功，走不同的节点
            if(YesNoFlagEnums.YES.getType().equals(retrieveCarsTaskVo.getRetrieveResult())){
                actRuTaskVo = ActRetrieveCarUtils.approvalAgree(retrieveCarsTaskVo.getTaskId());
            }else{
                actRuTaskVo = ActRetrieveCarUtils.approvalToFinancial(retrieveCarsTaskVo.getTaskId());
            }
            //保存日至流程信息
            saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
            //更新任务表
            updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
        }
        //保存收款信息
        saveRetrieveCostInfo(retrieveCarsTaskVo);
        //保存附件信息
        bizFilesService.modifyBizFilesList(retrieveCarsTaskVo.getRegisterFileList(),retrieveCarsTaskVo.getRetrieveCarTaskNo(), BizCodeTypeEnums.REGISTER_FILE.getCodeType());
    }

    /**
     * @Title:
     * @Description:  收车任务车辆入库
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @Override
    @Transactional
    public void retrieveCarsTaskStorage(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        //流程信息
        ActRuTaskVo actRuTaskVo = ActRetrieveCarUtils.approvalAgree(retrieveCarsTaskVo.getTaskId());
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
        //保存附件信息
        bizFilesService.modifyBizFilesList(retrieveCarsTaskVo.getStorageFileList(),retrieveCarsTaskVo.getRetrieveCarTaskNo(), BizCodeTypeEnums.STORAGE_FILE.getCodeType());
    }

    /**
     * @Title:
     * @Description:  收车任务确认交接
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @Override
    @Transactional
    public void retrieveCarsTaskHandover(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        //流程信息
        ActRuTaskVo actRuTaskVo = ActRetrieveCarUtils.approvalAgree(retrieveCarsTaskVo.getTaskId());
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务财务审核
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/19 10:34:41
     */
    @Override
    @Transactional
    public void retrieveCarsTaskFinancial(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        //流程信息
        ActRuTaskVo actRuTaskVo = ActRetrieveCarUtils.approvalAgree(retrieveCarsTaskVo.getTaskId());
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
        //更新财务付款信息
        saveRetrieveCostInfo(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务总经理审核
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/20 10:34:41
     */
    @Override
    @Transactional
    public void retrieveCarsTaskAudit(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        //流程信息
        ActRuTaskVo actRuTaskVo = ActRetrieveCarUtils.approvalAgree(retrieveCarsTaskVo.getTaskId());
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
        //车辆处置
        saveVehicleDisposalInfo(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务拒绝
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @Override
    @Transactional
    public void retrieveCarsTaskRefuse(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        //流程任务信息
        ActRuTaskVo actRuTaskVo = ActRetrieveCarUtils.approvalRefuse(retrieveCarsTaskVo.getTaskId());
        //更新任务表
        retrieveCarsTaskVo.setPresentUser(""); //下一节点审批人
        retrieveCarsTaskVo.setTaskStatus(RetrieveTaskStatusEnums.REFUSE.getType()); //任务状态
        Example example = SqlUtil.newExample(RetrieveCarsTask.class);
        example.createCriteria().andEqualTo("retrieveCarTaskNo",retrieveCarsTaskVo.getRetrieveCarTaskNo());
        retrieveCarsTaskRepository.updateByExampleSelectiveData(retrieveCarsTaskVo.getEntity(),example);
        //更新日志流程信息
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(retrieveCarsTaskVo.getRetrieveCarTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.RETRIEVE_CAR.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(retrieveCarsTaskVo.getMemo());
        workflowLog.setStatus(RetrieveTaskStatusEnums.REFUSE.getType());
        workflowLog.setActType(ActTypeEnums.REFUSE.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description:  收车任务退回
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @Override
    @Transactional
    public void retrieveCarsTaskSendBack(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        //流程信息
        ActRuTaskVo actRuTaskVo = ActRetrieveCarUtils.approvalReturnSuperior(retrieveCarsTaskVo.getTaskId());
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.SENDBACK.getType(),sysUser);
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务退回(总经理退回)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @Override
    @Transactional
    public void retrieveCarsTaskAuditSendBack(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = null;
        if(judgeIsFirstSubmit(retrieveCarsTaskVo)){
            actRuTaskVo = ActRetrieveCarUtils.approvalReturnSuperior(retrieveCarsTaskVo.getTaskId());
        }else{
            actRuTaskVo =  ActRetrieveCarUtils.approvalReturnToDispatch(retrieveCarsTaskVo.getTaskId());
        }
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.SENDBACK.getType(),sysUser);
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description:  收车任务退回(财务审核退回)
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/21 10:34:41
     */
    @Override
    @Transactional
    public void retrieveCarsTaskFinanceSendBack(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser) {
        //流程信息
        ActRuTaskVo actRuTaskVo = null;
        //根据是否收车成功，走不同的节点
        if(YesNoFlagEnums.YES.getType().equals(retrieveCarsTaskVo.getRetrieveResult())){
            actRuTaskVo = ActRetrieveCarUtils.approvalReturnSuperior(retrieveCarsTaskVo.getTaskId());
        }else{
            actRuTaskVo = ActRetrieveCarUtils.approvalReturnToRegister(retrieveCarsTaskVo.getTaskId());
        }
        //保存日至流程信息
        saveWorkFlowLog(retrieveCarsTaskVo,actRuTaskVo, ActTypeEnums.SENDBACK.getType(),sysUser);
        //更新任务表
        updateRetrieveCarsTask(retrieveCarsTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description:  检查是否有正在进行的任务
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/25 10:34:41
     */
    @Override
    public RetrieveCarsTask checkRetrieveCarsTask(RetrieveCarsTaskVo retrieveCarsTaskVo) {
        //验证合同是否已经在收车中
        Example example = SqlUtil.newExample(RetrieveCarsTask.class);
        example.createCriteria().andEqualTo("contNo",retrieveCarsTaskVo.getContNo());
        example.and(example.createCriteria().andNotEqualTo("taskStatus",RetrieveTaskStatusEnums.REFUSE.getType()).andNotEqualTo("taskStatus",RetrieveTaskStatusEnums.COMPLETE.getType()).andNotEqualTo("taskStatus",RetrieveTaskStatusEnums.TOBE_APPLY.getType()));
        //example.createCriteria().andEqualTo("contNo",retrieveCarsTaskVo.getContNo()).andNotEqualTo("taskStatus","4414").andNotEqualTo("taskStatus","4413").orIsNull("taskStatus");
        RetrieveCarsTask task = retrieveCarsTaskRepository.selectOneByExample(example);
        if(task != null && StringUtils.isNotTrimBlank(task.getPresentUser()))
            return task;
        return null;
    }


    /**
     * @Title:
     * @Description: 审批日志保存
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Transactional
    private void saveWorkFlowLog(RetrieveCarsTaskVo retrieveCarsTaskVo, ActRuTaskVo actRuTaskVo, String actType, SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(retrieveCarsTaskVo.getRetrieveCarTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.RETRIEVE_CAR.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(retrieveCarsTaskVo.getMemo());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }
    /**
     * @Title:
     * @Description: 更新收车任务表
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Transactional
    private void updateRetrieveCarsTask(RetrieveCarsTaskVo retrieveCarsTaskVo,ActRuTaskVo actRuTaskVo){
        retrieveCarsTaskVo.setPresentUser(actRuTaskVo.getNextAssignee()); //下一节点审批人
        retrieveCarsTaskVo.setTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        Example example = SqlUtil.newExample(RetrieveCarsTask.class);
        example.createCriteria().andEqualTo("retrieveCarTaskNo",retrieveCarsTaskVo.getRetrieveCarTaskNo());
        retrieveCarsTaskRepository.updateByExampleSelectiveData(retrieveCarsTaskVo.getEntity(),example);
    }
    /**
     * @Title:
     * @Description: 保存收付款信息
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-19 14:35:16
     */
    @Transactional
    private void saveRetrieveCostInfo(RetrieveCarsTaskVo retrieveCarsTaskVo){
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",retrieveCarsTaskVo.getRetrieveCarTaskNo()).andEqualTo("paymentType",BizTypeEnums.RETRIEVE_CAR.getType());
        ContPay contPay = contPayRepository.selectOneByExample(example);
        if(contPay == null){
            contPay = new ContPay();
            contPay.setBizCode(retrieveCarsTaskVo.getRetrieveCarTaskNo());
            contPay.setPaymentType(BizTypeEnums.RETRIEVE_CAR.getType());
            contPay.setRecAccountName(retrieveCarsTaskVo.getRecAccountName());
            contPay.setRecAccBranch(retrieveCarsTaskVo.getRecAccBranch());
            contPay.setRecAccountNo(retrieveCarsTaskVo.getRecAccountNo());
            contPay.setPayAmount(retrieveCarsTaskVo.getActRetrAmount());
            contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());
            contPay.setPayFund(PayFundNameEnums.RETR_AMOUNT.getType());
            contPayRepository.insertData(contPay);
        }else{
            contPay.setRecAccountName(retrieveCarsTaskVo.getRecAccountName());
            contPay.setRecAccBranch(retrieveCarsTaskVo.getRecAccBranch());
            contPay.setRecAccountNo(retrieveCarsTaskVo.getRecAccountNo());
            contPay.setPayAccBranch(retrieveCarsTaskVo.getPayAccBranch());
            contPay.setPayAccountName(retrieveCarsTaskVo.getPayAccountName());
            contPay.setPayAccountNo(retrieveCarsTaskVo.getPayAccountNo());
            contPayRepository.updateByExampleSelectiveData(contPay,example);
        }
    }

    /**
     * @Title:
     * @Description: 得到收付款信息
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-19 14:35:16
     */
    private void getCostInfo(RetrieveCarsTaskVo retrieveCarsTaskVo){
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode",retrieveCarsTaskVo.getRetrieveCarTaskNo()).andEqualTo("paymentType",BizTypeEnums.RETRIEVE_CAR.getType());
        ContPay contPay = contPayRepository.selectOneByExample(example);
        if(contPay != null){
            retrieveCarsTaskVo.setRecAccBranch(contPay.getRecAccBranch());
            retrieveCarsTaskVo.setRecAccountName(contPay.getRecAccountName());
            retrieveCarsTaskVo.setRecAccountNo(contPay.getRecAccountNo());
            retrieveCarsTaskVo.setPayAccBranch(contPay.getPayAccBranch());
            retrieveCarsTaskVo.setPayAccountNo(contPay.getPayAccountNo());
            retrieveCarsTaskVo.setPayAccountName(contPay.getPayAccountName());
        }
    }

    /**
     * @Title:
     * @Description: 收车成功生成车辆处置信息
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-27 14:35:16
     */
    private void saveVehicleDisposalInfo(RetrieveCarsTaskVo retrieveCarsTaskVo){
        //如果收车成功，则生成一条收车数据
        if(StringUtils.equals(retrieveCarsTaskVo.getRetrieveResult(),YesNoFlagEnums.YES.getType())){
            VehicleDisposal vehicleDisposal = new VehicleDisposal();
            vehicleDisposal.setContNo(retrieveCarsTaskVo.getContNo()); //合同号
            vehicleDisposal.setRecoveryTaskNo(retrieveCarsTaskVo.getRetrieveCarTaskNo()); //收车任务号
            vehicleDisposal.setVehicleDisposalStatus(VehicleDisposalStatusEnums.TO_BE_DISPOSE.getType());
            vehicleDisposalRepository.insertData(vehicleDisposal);
        }
    }

    /**
     * 委托书下载
     *
     * @param retrieveCarsTaskVo
     * @return
     */
    @Override
    public FileVo downLoadLetter(String retrieveCarsTaskVo) {
        if (StringUtils.isTrimBlank(retrieveCarsTaskVo)){
            throw new FmsServiceException("参数不正确");
        }
        // 获取当前客户所有合同生成委托书需要的数据
        List<CollectionLetterVo> collectionLetterVoList = retrieveCarsTaskRepository.selectproxyDownloadInfo(retrieveCarsTaskVo);
        // 初始化文件List
        List<FileVo> files = new ArrayList<>();
        // 构建需要生成的文件List
        String cstmName = collectionTaskService.getFiles(collectionLetterVoList, files);
        FileVo fileVo = new FileVo();
        // 获取打包下载路径
        String fileZipPath = CommonFileUtils.filesToZip(files,null);
        fileVo.setFilePath(fileZipPath);
        fileVo.setFileName("收车委托书（"+ cstmName +"）.zip");
        return fileVo;
    }

    /**
     * @Title:
     * @Description:  收车任务打印付款表
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/10/13 10:34:41
     */
    @Override
    public String printPaymentOrder(RetrieveCarsTaskVo retrieveCarsTaskVo) {
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(retrieveCarsTaskVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        //付款金额
        pdfVariables.put("totalShouldPay", StringUtils.defaultString(StringUtils.getValue(Math.abs(retrieveCarsTaskVo.getActRetrAmount().floatValue()))));

        pdfVariables.put("payAccountName", retrieveCarsTaskVo.getPayAccountName()); //付款户名
        pdfVariables.put("payAccountNo", retrieveCarsTaskVo.getPayAccountNo()); //付款账号
        pdfVariables.put("payAccBranch", retrieveCarsTaskVo.getPayAccBranch()); //付款银行
        pdfVariables.put("recAccBranch", retrieveCarsTaskVo.getRecAccBranch()); //收款银行
        pdfVariables.put("recAccountName", retrieveCarsTaskVo.getRecAccountName()); //收款户名
        pdfVariables.put("recAccountNo", retrieveCarsTaskVo.getRecAccountNo()); //收款账号
        pdfVariables.put("lessor", retrieveCarsTaskVo.getLessor()); //出租人
        pdfVariables.put("name", retrieveCarsTaskVo.getCstmName());//承租人
        pdfVariables.put("vinNo", retrieveCarsTaskVo.getVinNo());//车架号

        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_RETRIEVE.getType());
        return filePath;
    }

}
