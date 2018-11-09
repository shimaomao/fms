package cn.com.leadu.fms.activiti.service.impl;

import cn.com.leadu.fms.activiti.service.ActRuTaskService;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationFlagEnums;
import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActUtils;
import cn.com.leadu.fms.common.constant.enums.sql.PageFlags;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.activiti.repository.ActRuTaskRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.PageInfoExtendUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.activiti.entity.ActRuTask;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskServiceImpl
 * @Description:
 * @date 2018/3/14
 */
@Service
@Slf4j
public class ActRuTaskServiceImpl implements ActRuTaskService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ActRuTaskRepository actRuTaskRepository;

    /**
     * @Title:
     * @Description:   查询个人任务和候选任务
     * @param actRuTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:09:34
     */
    public PageInfoExtend<ActRuTaskVo> findActRuTaskVosByCandidateOrAssigned(ActRuTaskVo actRuTaskVo, SysUser sysUser){
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(sysUser.getUser());
        //查询所拥有的个人和候选任务
        List<Task> tasks = null;
        if(StringUtils.isNotTrimBlank(actRuTaskVo.getName()))
            taskQuery.taskNameLike(SqlUtil.likePattern(actRuTaskVo.getName()));
        if(StringUtils.isNotTrimBlank(actRuTaskVo.getProcessDefinitionKey()))
            taskQuery.processDefinitionKey(actRuTaskVo.getProcessDefinitionKey());
        if(actRuTaskVo.getPageFlag() == null || PageFlags.PAGE.getFlag().equals(actRuTaskVo.getPageFlag()))
            tasks = taskQuery
                .orderByTaskCreateTime()
                .desc().listPage(actRuTaskVo.getStart(),actRuTaskVo.getPageSize());
        else
            tasks = taskQuery
                    .orderByTaskCreateTime()
                    .desc().list();
        List<ActRuTaskVo> actRuTaskVos = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(tasks)){
            for(Task task : tasks){
                //返回vo
                ActRuTaskVo taskVo = EntityUtils.getEntity(task,new ActRuTaskVo());
                //业务id
                ActUtils.setDefaultValue(taskVo);
                //加入集合
                actRuTaskVos.add(taskVo);
            }
        }
        return PageInfoExtendUtils.getPageInfoExtend(actRuTaskVos,taskQuery.count(),actRuTaskVo.getPageQuery());
    }


    /**
     * @Title:
     * @Description:   审批任务
     * @param actRuTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 08:49:31
     */
    public void approvalActRuTask(ActRuTaskVo actRuTaskVo){
        TaskQuery taskQuery = taskService.createTaskQuery().taskId(actRuTaskVo.getId());
        Task task = taskQuery.singleResult();
        Map<String,Object> taskResult = new HashMap();
        taskService.complete(task.getId(),taskResult);
    }

    /**
     * @Title:
     * @Description: 根据业务key集合查询任务
     * @param businessKeys
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    public List<ActRuTask> findActRuTasksByBusinessKeys(List<String> businessKeys){
        return actRuTaskRepository.selectActRuTasksByBusinessKeys(businessKeys);
    }

}
