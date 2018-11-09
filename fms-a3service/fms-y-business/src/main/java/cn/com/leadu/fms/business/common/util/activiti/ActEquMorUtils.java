package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.asset.repository.EquMorTaskRepository;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: ActEquMorUtils
 * @Description: 抵押流程工具类
 * @date 2018/6/11
 */
@Component
@Slf4j
public class ActEquMorUtils {

    /**
     * @Fields  : 单例辅助
     * @author qiaomengnan
     */
    private static ActEquMorUtils actEquMorUtils = null;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private EquMorTaskRepository equMorTaskRepository;

    /**
     * @Title:
     * @Description:   启动工作流
     * @param serviceId 业务id
     * @param serviceType 业务类型
     * @param serviceName 业务名称
     * @param proInsType 流程类型
     * @param memo  备注
     * @param submit    是否提交
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/10 03:59:31
     */
    public static ActRuTaskVo start(String serviceId, String serviceType, String serviceName,String proInsType,String memo,boolean submit){
        ActRuTaskVo actRuTaskVo = null;
        if(ActProcessInstanceKeyEnums.EQU_MORTGAGE.getKey().equals(proInsType)){
            actRuTaskVo = ActEquMortgageUtils.start(serviceId, serviceType, serviceName,memo,submit);
        }else if(ActProcessInstanceKeyEnums.EQU_MORTGAGE_PAY.getKey().equals(proInsType)){
            actRuTaskVo = ActEquMortgagePayUtils.start(serviceId, serviceType, serviceName,memo,submit);
        }else{
            throw new FmsServiceException("流程类型不存在" + proInsType);
        }
        modifyEquMorTaskStatus(serviceId,actRuTaskVo);
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 审批通过
     * @param:  taskId
     * @param:  taskDefinitionKey
     * @param:  memo
     * @param:  serviceId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalAgree(String taskId, String taskDefinitionKey, String memo, String serviceId){
        checkTaskValue(taskId, taskDefinitionKey, memo, serviceId);
        ActRuTaskVo actRuTaskVo = null;
        Task task = actEquMorUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        Object object = actEquMorUtils.runtimeService.getVariable(task.getExecutionId(), ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag());
        if(object != null){
            if(ActProcessInstanceKeyEnums.EQU_MORTGAGE.getKey().equals(object)){
                actRuTaskVo = ActEquMortgageUtils.approvalAgree(task, taskDefinitionKey, memo, serviceId);
            }else if(ActProcessInstanceKeyEnums.EQU_MORTGAGE_PAY.getKey().equals(object)){
                actRuTaskVo = ActEquMortgagePayUtils.approvalAgree(task, taskDefinitionKey, memo, serviceId);
            }else{
                throw new FmsServiceException("流程类型不存在" + object);
            }
        }else{
            throw new FmsServiceException("流程类型不存在" + object);
        }
        modifyEquMorTaskStatus(serviceId,actRuTaskVo);
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @param:  taskDefinitionKey
     * @param:  memo
     * @param:  serviceId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId,String taskDefinitionKey,String memo,String serviceId){
        checkTaskValue(taskId, taskDefinitionKey, memo, serviceId);
        ActRuTaskVo actRuTaskVo = null;
        Task task = actEquMorUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        Object object = actEquMorUtils.runtimeService.getVariable(task.getExecutionId(), ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag());
        if(object != null){
            if(ActProcessInstanceKeyEnums.EQU_MORTGAGE.getKey().equals(object)){
                actRuTaskVo = ActEquMortgageUtils.approvalReturnSuperior(task, taskDefinitionKey, memo, serviceId);
            }else if(ActProcessInstanceKeyEnums.EQU_MORTGAGE_PAY.getKey().equals(object)){
                actRuTaskVo = ActEquMortgagePayUtils.approvalReturnSuperior(task, taskDefinitionKey, memo, serviceId);
            }else{
                throw new FmsServiceException("流程类型不存在" + object);
            }
        }else{
            throw new FmsServiceException("流程类型不存在" + object);
        }
        modifyEquMorTaskStatus(serviceId,actRuTaskVo);
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 取消
     * @param:  taskId
     * @param:  taskDefinitionKey
     * @param:  memo
     * @param:  serviceId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalCancel(String taskId,String taskDefinitionKey,String memo,String serviceId){
        checkTaskValue(taskId, taskDefinitionKey, memo, serviceId);
        ActRuTaskVo actRuTaskVo = null;
        Task task = actEquMorUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        Object object = actEquMorUtils.runtimeService.getVariable(task.getExecutionId(), ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag());
        if(object != null){
            if(ActProcessInstanceKeyEnums.EQU_MORTGAGE.getKey().equals(object)){
                actRuTaskVo = ActEquMortgageUtils.approvalCancel(task, taskDefinitionKey, memo, serviceId);
            }else if(ActProcessInstanceKeyEnums.EQU_MORTGAGE_PAY.getKey().equals(object)){
                actRuTaskVo = ActEquMortgagePayUtils.approvalCancel(task, taskDefinitionKey, memo, serviceId);
            }else{
                throw new FmsServiceException("流程类型不存在" + object);
            }
        }else{
            throw new FmsServiceException("流程类型不存在" + object);
        }
        modifyEquMorTaskStatus(serviceId,actRuTaskVo);
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description:   修改任务节点所在人
     * @param serviceId
     * @param actRuTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/09 05:08:59
     */
    private static void modifyEquMorTaskStatus(String serviceId,ActRuTaskVo actRuTaskVo){
        if(StringUtils.isNotTrimBlank(serviceId) && actRuTaskVo != null) {
            EquMorTask equMorTask = new EquMorTask();
            equMorTask.setMortgageServStatus(actRuTaskVo.getTaskCode());
            equMorTask.setPresentUser(actRuTaskVo.getNextAssignee());
            actEquMorUtils.equMorTaskRepository.updateByEquMorTaskNoSelectiveData(serviceId, equMorTask);
        }
    }

    public ActEquMorUtils(){
        actEquMorUtils = this;
    }

    private static void checkTaskValue(String taskId,String taskDefinitionKey,String memo,String serviceId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        if(StringUtils.isTrimBlank(taskDefinitionKey))
            throw new FmsServiceException("任务流程key不能为空");
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务号不能为空");
        if(StringUtils.isTrimBlank(memo))
            throw new FmsServiceException("备注不能为空");
    }

}
