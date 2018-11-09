package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActBasicChangeUtils;
import cn.com.leadu.fms.business.service.CommonSysGroupService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.ChangeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.SolveTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysGroupParentTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysRoleEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.BasicChangeTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.ChangeLesseeTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.DeferTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.DepositChangeTaskRepository;
import cn.com.leadu.fms.data.system.repository.SysGroupRepository;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.entity.BasicChangeTask;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import cn.com.leadu.fms.pojo.postbiz.entity.DepositChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeCompHistoryVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangePersHistoryVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeTaskCancelVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.ChangeInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.PersContactsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.ValidContractChangeVo;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.postbiz.service.BasicChangeTaskService;
import cn.com.leadu.fms.postbiz.service.ChangeLesseeService;
import cn.com.leadu.fms.postbiz.service.DeferTaskService;
import cn.com.leadu.fms.postbiz.service.DepositChangeTaskService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskService
 * @Description: 基本信息变更任务业务实现层
 * @date 2018-08-31
 */
@Service
public class BasicChangeTaskServiceImpl implements BasicChangeTaskService {

    /**
     * @Fields  : 基本信息变更任务repository
     */
    @Autowired
    private BasicChangeTaskRepository basicChangeTaskRepository;

    @Autowired
    private DeferTaskRepository deferTaskRepository;

    @Autowired
    private DepositChangeTaskRepository depositChangeTaskRepository;

    @Autowired
    private ChangeLesseeTaskRepository changeLesseeTaskRepository;

    @Autowired
    private WorkflowLogService workflowLogService;

    @Autowired
    private DepositChangeTaskService depositChangeTaskService;
    /**
     * @Fields  : 合同展期任务service
     */
    @Autowired
    private DeferTaskService deferTaskService;
    /**
     * @Fields  : 承租人变更任务service
     */
    @Autowired
    private ChangeLesseeService changeLesseeService;
    /**
     * @Fields  : 用户信息repository
     */
    @Autowired
    private SysUserRepository sysUserRepository;
    /**
     * @Fields  : 用户组信息repository
     */
    @Autowired
    private SysGroupRepository sysGroupRepository;

    /**
     * @Fields  : 用户组共通方法service
     */
    @Autowired
    private CommonSysGroupService commonSysGroupService;

    /**
     * @Description: 分页查询合同一览信息
     * @param validContractChangeVo
     * @Param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/27 17:04
     */
    @Override
    public PageInfoExtend<ContractListVo> findContractListByPage(ValidContractChangeVo validContractChangeVo, SysUserVo sysUser) {
        //查询参数构造
        ValidContractChangeVo newValidContractChangeVo = buildParams(validContractChangeVo,sysUser);

        //根据用户条件进行筛选
        PageInfoExtend<ContractListVo> pageInfo = basicChangeTaskRepository.selectListVoByPage("selectContractListByPage", newValidContractChangeVo, newValidContractChangeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * 构造查询条件
     * @param validContractChangeVo
     * @return
     */
    private ValidContractChangeVo buildParams(ValidContractChangeVo validContractChangeVo,SysUserVo sysUser) {
        //合同号
        if(StringUtils.isTrimBlank(validContractChangeVo.getContNo()))
            validContractChangeVo.setContNo(null);
        else
            validContractChangeVo.setContNo(SqlUtil.likePattern(validContractChangeVo.getContNo()));

        //申请编号
        if (StringUtils.isTrimBlank(validContractChangeVo.getApplyNo()))
            validContractChangeVo.setApplyNo(null);
        else
            validContractChangeVo.setApplyNo(SqlUtil.likePattern(validContractChangeVo.getApplyNo()));

        //客户姓名
        if(StringUtils.isTrimBlank(validContractChangeVo.getName()))
            validContractChangeVo.setName(null);
        else
            validContractChangeVo.setName(SqlUtil.likePattern(validContractChangeVo.getName()));

        //申请类型
        if(StringUtils.isTrimBlank(validContractChangeVo.getApplyType()))
            validContractChangeVo.setApplyType(null);
        else
            validContractChangeVo.setApplyType(validContractChangeVo.getApplyType());

        //申请状态
        if(StringUtils.isTrimBlank(validContractChangeVo.getBizStatus()))
            validContractChangeVo.setBizStatus(null);
        else
            validContractChangeVo.setBizStatus(validContractChangeVo.getBizStatus());

        //出租人区域
        if(StringUtils.isTrimBlank(validContractChangeVo.getGroupDistrict()))
            validContractChangeVo.setGroupDistrict(null);
        else
            validContractChangeVo.setGroupDistrict(SqlUtil.likePattern(validContractChangeVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(validContractChangeVo.getVinNo()))
            validContractChangeVo.setVinNo(null);
        else
            validContractChangeVo.setVinNo(SqlUtil.likePattern(validContractChangeVo.getVinNo()));

        //产品名称
        if(StringUtils.isTrimBlank(validContractChangeVo.getProductName()))
            validContractChangeVo.setProductName(null);
        else
            validContractChangeVo.setProductName(SqlUtil.likePattern(validContractChangeVo.getProductName()));

        //合同生效日期区间(起始)
        if(StringUtils.isTrimBlank(validContractChangeVo.getValidStartTime()))
            validContractChangeVo.setValidStartTime(null);
        else
            validContractChangeVo.setValidStartTime(validContractChangeVo.getValidStartTime());
        //合同生效日期区间(结束)
        if(StringUtils.isTrimBlank(validContractChangeVo.getValidEndTime()))
            validContractChangeVo.setValidEndTime(null);
        else
            validContractChangeVo.setValidEndTime(validContractChangeVo.getValidEndTime());
        //业务类型
        if(StringUtils.isTrimBlank(validContractChangeVo.getLicenseAttr()))
            validContractChangeVo.setLicenseAttr(null);
        else
            validContractChangeVo.setLicenseAttr(validContractChangeVo.getLicenseAttr());

        validContractChangeVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());//限定只检索已经生效的合同
        validContractChangeVo.setPaymentSts(PaymentStsEnums.UNCLEARED.getType());//限定只检索未结清的合同
        return validContractChangeVo;
    }

    /**
     * @Description: 生效合同变更查询
     * @param basicChangeTaskVo
     * @param sysUser
     * @Param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/27 17:04
     */
    @Override
    public PageInfoExtend<BasicChangeTaskVo> findBasicChangeTaskListByPage(BasicChangeTaskVo basicChangeTaskVo, SysUserVo sysUser) {
        //申请编号编号查询处理
        if (StringUtils.isNotTrimBlank(basicChangeTaskVo.getApplyNo())){
            basicChangeTaskVo.setApplyNo(SqlUtil.likePattern(basicChangeTaskVo.getApplyNo()));
        } else {
            basicChangeTaskVo.setApplyNo(null);
        }
        //合同编号查询处理
        if (StringUtils.isNotTrimBlank(basicChangeTaskVo.getContNo())){
            basicChangeTaskVo.setContNo(SqlUtil.likePattern(basicChangeTaskVo.getContNo()));
        } else {
            basicChangeTaskVo.setContNo(null);
        }
        //车架号查询处理
        if (StringUtils.isNotTrimBlank(basicChangeTaskVo.getVinNo())){
            basicChangeTaskVo.setVinNo(SqlUtil.likePattern(basicChangeTaskVo.getVinNo()));
        } else {
            basicChangeTaskVo.setVinNo(null);
        }
        //承租人查询处理
        if (StringUtils.isNotTrimBlank(basicChangeTaskVo.getName())){
            basicChangeTaskVo.setName(SqlUtil.likePattern(basicChangeTaskVo.getName()));
        } else {
            basicChangeTaskVo.setName(null);
        }
        // 变更类型查询处理
        if (StringUtils.isTrimBlank(basicChangeTaskVo.getChangeType())){
            basicChangeTaskVo.setChangeType(null);
        }
        //根据用户角色过滤
        List<String> roleList = new ArrayList<>();  //角色
        List<String> userList = new ArrayList<>();//用户
        sysUser.setRoles(sysUserRepository.selectSysUserVoById(sysUser.getUserId()).getRoles());
        for(SysRole role:sysUser.getRoles()){
            roleList.add(role.getRole());
        }
        if(roleList.contains(SysRoleEnums.YW.getId())){   //业务员
            userList.add(sysUser.getUser());
        }else if(roleList.contains(SysRoleEnums.QY.getId())){ //区域经理
            List<String> getUserList =  commonSysGroupService.getUserInSameGroup(sysUser.getGroupCode());
            if(ArrayUtils.isNotNullAndLengthNotZero(getUserList)){
                userList.addAll(getUserList);
            }
        }
        if(ArrayUtils.isNullOrLengthZero(userList)){
            userList = null;
        }
        basicChangeTaskVo.setUserList(userList);
        basicChangeTaskVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());//限定只检索已经生效的合同
        basicChangeTaskVo.setPaymentSts(PaymentStsEnums.UNCLEARED.getType());//限定只检索未结清的合同
        PageInfoExtend<BasicChangeTaskVo> pageInfo = basicChangeTaskRepository.selectListVoByPage("selectBasicChangeTaskListByPage", basicChangeTaskVo, basicChangeTaskVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Description: 获取子机构的所有用户
     * @param groupCode
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/10/7 17:04
     */
//    private List<String> getUserInSameGroup(String groupCode){
//        List<SysGroupVo> sysGroupVoList = sysGroupRepository.selectSysGroupVosByTree(SysGroupParentTypeEnums.ADMIN.getType());
//        List<String> userList = new ArrayList<>();
//        // 排除用户组及子集
//        List<String> chileGroupCodeList = new ArrayList<>();
//        if (StringUtils.isNotTrimBlank(groupCode)) {
//            List<SysGroupVo> childGroupList = CommonTreeDataUtils.getChildResults(sysGroupVoList, groupCode);
//            if (ArrayUtils.isNotNullAndLengthNotZero(childGroupList)) {
//                for (SysGroupVo sysGroupVo : childGroupList) {
//                    chileGroupCodeList.add(sysGroupVo.getGroupCode());
//                }
//            }
//            chileGroupCodeList.add(groupCode);
//            userList =  sysUserRepository.selectSysUserLoginNamesByGroupCodes(chileGroupCodeList);
//        }
//
//        return userList;
//    }

    /**
     * @Description: check该客户是否存在未结束的基本信息变更任务
     * @param applyNo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/27 17:04
     */
    @Override
    public void checkBasicChangeTask(String applyNo) {
        if (StringUtils.isTrimBlank(applyNo)){
            throw new FmsServiceException("参数不正确");
        }
        Example example = SqlUtil.newExample(BasicChangeTask.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        List<BasicChangeTask> basicChangeTaskList = basicChangeTaskRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(basicChangeTaskList)){
            for (BasicChangeTask basicChangeTask : basicChangeTaskList){
                if (!StringUtils.equals(basicChangeTask.getBasicTaskStatus(), BizStatusEnums.BASIC_CHANGE_END.getType())
                && !StringUtils.equals(basicChangeTask.getBasicTaskStatus(), BizStatusEnums.BASIC_CHANGE_REFUSE.getType())){
                    throw new FmsServiceException("该客户存在未结束的基本信息变更任务，请先结束再重新申请");
                }
            }
        }
    }

    /**
     * @Description: check该任务能被取消
     * @Param: basicTaskNo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/27 17:04
     */
    @Override
    public void isTaskCanBeCancel(String basicTaskNo, SysUserVo sysUser) {
        if (StringUtils.isTrimBlank(basicTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        BasicChangeTaskCancelVo basicChangeTaskCancelVo = findBasicChangeCancelVo(basicTaskNo, sysUser);
        if (basicChangeTaskCancelVo == null){
            throw new FmsServiceException("您没有取消当前任务的权限");
        }
    }

    /**
     * 基本信息变更取消
     */
    @Override
    @Transactional
    public void basicChangeTaskCancel(BasicChangeTaskCancelVo basicChangeTaskCancelVo, SysUserVo sysUser) {
        if (StringUtils.isTrimBlank(basicChangeTaskCancelVo.getBasicTaskNo())){
            throw new FmsServiceException("参数不正确");
        }
        // 检验流程是否能被取消
        isTaskCanBeCancel(basicChangeTaskCancelVo.getBasicTaskNo(), sysUser);
        if (StringUtils.equals(ChangeTypeEnums.BASIC_CHANGE.getType(), basicChangeTaskCancelVo.getChangeType())){
            // 如果是基本信息变更取消
            if (StringUtils.equals(ChangeTypeEnums.BASIC_CHANGE.getType(), basicChangeTaskCancelVo.getChangeType())){
                // 如果是基本信息变更
                // 根据任务号取消流程
                ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.applyCancel(basicChangeTaskCancelVo.getBasicTaskNo());

                Example example = SqlUtil.newExample(BasicChangeTask.class);
                example.createCriteria().andEqualTo("basicTaskNo", basicChangeTaskCancelVo.getBasicTaskNo());
                BasicChangeTask basicChangeTask = basicChangeTaskRepository.selectOneByExample(example);
                if (basicChangeTask == null){
                    throw new FmsServiceException("变更任务不存在");
                }
                basicChangeTask.setBasicTaskStatus(BizStatusEnums.BASIC_CHANGE_CANCEL.getType());
                basicChangeTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点操作人
                //更新任务表
                basicChangeTaskRepository.updateByPrimaryKeySelectiveData(basicChangeTask);
                // 保存日志信息
                saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.CANCEL.getType(),
                        basicChangeTaskCancelVo.getBasicTaskNo(), BizTypeEnums.BASIC_CHANGE.getType(),
                        basicChangeTaskCancelVo.getRemark(), BizStatusEnums.BASIC_CHANGE_CANCEL.getType());
            }
        } else if (StringUtils.equals(ChangeTypeEnums.DEFER_TASK.getType(), basicChangeTaskCancelVo.getChangeType())){
            // 如果是合同展期
            deferTaskService.applyCancel(basicChangeTaskCancelVo.getBasicTaskNo(), basicChangeTaskCancelVo.getRemark(), sysUser.getEntity());
        } else if (StringUtils.equals(ChangeTypeEnums.DEPOSIT_CHANGE.getType(), basicChangeTaskCancelVo.getChangeType())){
            // 如果是保证金变更
            depositChangeTaskService.applyCancel(basicChangeTaskCancelVo.getBasicTaskNo(), basicChangeTaskCancelVo.getRemark(), sysUser.getEntity());
            // TODO
        } else {
            // 如果是变更承租人
            changeLesseeService.applyCacel(basicChangeTaskCancelVo.getBasicTaskNo(), basicChangeTaskCancelVo.getRemark(), sysUser.getEntity());
        }

    }

    /**
     * 保存流程日志信息
     * @param user 操作用户
     * @param actType 操作分类
     * @param wfLogNo 业务任务号
     * @param wfLogType 业务任务分类
     * @param remark 备注
     * @param status 任务状态
     */
    private void saveWorkFlowLog(String user, String actType, String wfLogNo, String wfLogType, String remark, String status) {
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(user);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setActType(actType);
        workflowLog.setWfLogType(wfLogType);
        workflowLog.setWfLogNo(wfLogNo);
        workflowLog.setRemark1(remark);
        workflowLog.setStatus(status);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 分页查询指定申请编号的企业基本信息变更历史任务
     * @param vo 参数
     * @return PageInfoExtend<BasicChangeCompHistoryVo>
     * @throws
     * @author huzongcheng
     */
    @Override
    public PageInfoExtend<BasicChangeCompHistoryVo> findBasicCompChangeHistory(BasicChangeCompHistoryVo vo) {
        //设定查询条件
        PageInfoExtend<BasicChangeCompHistoryVo> pageInfo = basicChangeTaskRepository.selectListVoByPage("selectBasicCompChangeHistorListByPage",vo,vo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 分页查询指定申请编号的个人基本信息变更历史任务
     * @param vo 参数
     * @return PageInfoExtend<BasicChangePersHistoryVo>
     * @throws
     * @author huzongcheng
     */
    @Override
    public PageInfoExtend<BasicChangePersHistoryVo> findBasicPersChangeHistory(BasicChangePersHistoryVo vo) {
        //设定查询条件
        PageInfoExtend<BasicChangePersHistoryVo> pageInfo = basicChangeTaskRepository.selectListVoByPage("selectBasicPersChangeHistorListByPage",vo,vo.getPageQuery());
        //构建联系人信息
        buildContacts(pageInfo);
        return pageInfo;
    }

    /**
     * 获取展期、增加保证金、变更承租人变更任务号
     * @param contNo 合同号
     * @return
     */
    public ChangeInfoVo findChangeInfo(String contNo) {
        ChangeInfoVo vo = new ChangeInfoVo();
        //查询展期任务号
        Example example = SqlUtil.newExample(DeferTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contNo);
        criteria.andEqualTo("deferTaskStatus", BizStatusEnums.DEFER_TASK_FINISH.getType());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        DeferTask deferTask = deferTaskRepository.selectOneByExample(example);
        if(deferTask != null) {
            vo.setDeferTaskNo(deferTask.getDeferTaskNo());
        }
        //查询增加保证金任务号
        example = SqlUtil.newExample(DepositChangeTask.class);
        example.createCriteria().andEqualTo("contNo", contNo).andEqualTo("depositTaskStatus", BizStatusEnums.DEPOSIT_CHANGE_FINISH.getType());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        DepositChangeTask depositChangeTask = depositChangeTaskRepository.selectOneByExample(example);
        if(depositChangeTask != null) {
            vo.setDepositTaskNo(depositChangeTask.getDepositTaskNo());
        }
        //查询变更承租人任务号
        example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("contNo", contNo).andEqualTo("taskStatus", BizStatusEnums.CHANGE_LESSEE_FINISH.getType());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        ChangeLesseeTask changeLesseeTask = changeLesseeTaskRepository.selectOneByExample(example);
        if(changeLesseeTask != null) {
            vo.setLesseeTaskNo(changeLesseeTask.getTaskNo());
        }
        return vo;
    }

    /**
     * 获取基本信息变更取消内容
     *
     * @param basicTaskNo 变更任务号
     */
    @Override
    public BasicChangeTaskCancelVo findBasicChangeCancelVo(String basicTaskNo, SysUserVo sysUser) {
        if (StringUtils.isTrimBlank(basicTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        BasicChangeTaskCancelVo basicChangeTaskCancelVoMap = new BasicChangeTaskCancelVo();
        basicChangeTaskCancelVoMap.setPresentUser(sysUser.getUser());
        basicChangeTaskCancelVoMap.setBasicTaskNo(basicTaskNo);
        BasicChangeTaskCancelVo basicChangeTaskCancelVo = basicChangeTaskRepository.selectBasicChangeCancelVo(basicChangeTaskCancelVoMap);
        return basicChangeTaskCancelVo;
    }

    /**
     * //构建联系人信息
     * @param pageInfo
     */
    private void buildContacts(PageInfoExtend<BasicChangePersHistoryVo> pageInfo) {
        List<BasicChangePersHistoryVo> resultList = pageInfo.getData();
        if(ArrayUtils.isNotNullAndLengthNotZero(resultList)){ //如果有历史数据，则遍历去拿到联系人集合
            for(BasicChangePersHistoryVo item : resultList){
                List<PersContactsVo> contactsList = item.getContactsList();
                if(ArrayUtils.isNotNullAndLengthNotZero(resultList)){ //如果联系人数据不为空，则构建联系人信息
                    StringBuilder contactNamesBefore = new StringBuilder(""); //变更前联系人字符串
                    StringBuilder contactNamesAfter = new StringBuilder(""); //变更后联系人字符串
                    for(PersContactsVo contactsVo : contactsList){
                        String solveType = contactsVo.getSolveType(); //数据类型
                        String name = contactsVo.getContactName(); //联系人名称
                        if(SolveTypeEnums.BEFORE_MODIFY.getType().equals(solveType) && StringUtils.isNotTrimBlank(name)){
                            contactNamesBefore.append(name).append(" "); //拼接变更前联系人
                        } else if(SolveTypeEnums.AFTER_MODIFY.getType().equals(solveType) && StringUtils.isNotTrimBlank(name)){
                            contactNamesAfter.append(name).append(" "); //拼接变更后联系人
                        }
                    }
                    item.setContactsOld(contactNamesBefore.toString()); //设定变更前联系人
                    item.setContacts(contactNamesAfter.toString()); //设定变更后联系人
                }
            }
            pageInfo.setData(resultList);
        }
    }

}
