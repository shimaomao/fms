package cn.com.leadu.fms.activiti.service.impl;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFlagEnums;
import cn.com.leadu.fms.common.constant.enums.activiti.ActProcdefKeys;
import cn.com.leadu.fms.common.constant.enums.activiti.ActUserLeaveStatusEnums;
import cn.com.leadu.fms.activiti.service.ActIdMembershipService;
import cn.com.leadu.fms.activiti.service.ActReProcdefService;
import cn.com.leadu.fms.activiti.service.ActUserLeaveService;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.ActUserLeaveDeleteListVo;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.ActUserLeaveDeleteVo;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.ActUserLeaveModifyVo;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.ActUserLeaveSaveVo;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.data.activiti.repository.ActUserLeaveRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeave;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleave.ActUserLeaveVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveService
 * @Description: 用户请假业务实现层
 * @date 2018-03-14
 */
@Service
public class ActUserLeaveServiceImpl implements ActUserLeaveService {

    /**
     * @Fields  : 用户请假repository
     */
    @Autowired
    private ActUserLeaveRepository actUserLeaveRepository;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ActReProcdefService actReProcdefService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private ActIdMembershipService actIdMembershipService;

    @Autowired
    private TaskService taskService;


    /**
     * @Title:
     * @Description: 分页查询用户请假
     * @param actUserLeaveVo
     * @return PageInfoExtend<ActUserLeave>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    public PageInfoExtend<ActUserLeave> findActUserLeavesByPage(ActUserLeaveVo actUserLeaveVo,SysUser sysUser){
        //        //获取项目经理用户
//        List<String> projectManagerIds = null;
//        //获取部门经理用户
//        List<String> divisionManagerIds = null;
//        //总经理
//        List<String> generalManagerIds = null;
//        variables.put("projectManagerIds", projectManagerIds);
//        variables.put("divisionManagerIds", divisionManagerIds);
//        variables.put("generalManagerIds", generalManagerIds);
//        variables.put("type", ActProcdefKeys.ACT_USER_LEAVE.getKey());
//        variables.put("title", applySysUser.getUserName() + "的请假");
//        variables.put("applyUserId",applySysUser.getUserId());
        Example example = SqlUtil.newExample(ActUserLeave.class);
        example.createCriteria().andEqualTo("sysUserId",sysUser.getUserId());
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ActUserLeave> pageInfo = actUserLeaveRepository.selectListByExamplePage(example,actUserLeaveVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存用户请假
     * @param actUserLeaveSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Transactional
    public void saveActUserLeave(ActUserLeaveSaveVo actUserLeaveSaveVo,SysUser sysUser){
        startActUserLeaveProcess(actUserLeaveSaveVo.getEntity(),sysUser);
    }

    /**
     * @Title:
     * @Description: 修改用户请假
     * @param actUserLeaveModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    public void modifyActUserLeave(ActUserLeaveModifyVo actUserLeaveModifyVo){
        actUserLeaveRepository.updateByPrimaryKeySelectiveData(actUserLeaveModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过leaveId删除用户请假
     * @param actUserLeaveDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    public void deleteActUserLeave(ActUserLeaveDeleteVo actUserLeaveDeleteVo){
        actUserLeaveRepository.deleteData(actUserLeaveDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过leaveId集合删除用户请假
     * @param actUserLeaveDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    public void deleteActUserLeavesByLeaveIds(ActUserLeaveDeleteListVo actUserLeaveDeleteListVo){
        actUserLeaveRepository.deleteDataList(actUserLeaveDeleteListVo.getLeaveIds(),actUserLeaveDeleteListVo.getEntity());
    }


    /**
     * @Title:
     * @Description:  根据leaveId获取用户请假
     * @param leaveId
     * @return ActUserLeave
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    public ActUserLeaveVo findActUserLeaveByLeaveId(String leaveId){
        ActUserLeaveVo vo = EntityUtils.getEntity(actUserLeaveRepository.selectByPrimaryKey(leaveId),new ActUserLeaveVo());

        return vo;
    }

    public void startActUserLeaveProcess(ActUserLeave actUserLeave, SysUser applySysUser){
        Map<String, Object> variables = new HashMap<>();
        actUserLeave.setSysUserId(applySysUser.getUserId());
        actUserLeave.setLeaveStatus(ActUserLeaveStatusEnums.APPROVAL.getStatus());
        actUserLeaveRepository.insertData(actUserLeave);
        variables.put(ActFlagEnums.TASK_TITLE.getFlag(), ActProcdefKeys.ACT_USER_LEAVE_ALL.getDesc());
        variables.put(ActFlagEnums.START_USER.getFlag(), applySysUser.getUser());
        variables.put(ActFlagEnums.START_USER_NAME.getFlag(), applySysUser.getUserName());
        variables.put(ActFlagEnums.SUPERIOR_TASK_USER.getFlag(),applySysUser.getUserName());
        variables.put(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag(),ActProcdefKeys.ACT_USER_LEAVE_ALL.getKey());
        variables.put(ActFlagEnums.SERVICE_ID.getFlag(),actUserLeave.getLeaveId());
        variables.put("day", actUserLeave.getLeaveDay());
        runtimeService.startProcessInstanceByKey(ActProcdefKeys.ACT_USER_LEAVE_ALL.getKey(),actUserLeave.getLeaveId(),variables);
    }

    /**
     * @Title:
     * @Description:   审批通过
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/19 10:32:17
     */
    public void adopt(String taskId){
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActFlagEnums.SUPERIOR_TASK_USER.getFlag(), UserInfoUtils.getUserName());
        taskService.complete(taskId,variables);
    }

}
