package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.*;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import com.alibaba.fastjson.JSON;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 2018/9/4.
 */
@Component
@Slf4j
public class ActBasicChangeUtils {


    /**
     * @Fields : 单例辅助
     * @author lijunjun
     */
    private static ActBasicChangeUtils actBasicChangeUtils = null;

    /**
     * @Fields : 每个流程节点的审批状态名称
     * @author lijunjun
     */
    private static Map<String, String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields : 需要设置用户的节点
     * @author lijunjun
     */
    private static String[] userDefKeys = null;


    public ActBasicChangeUtils() {

        actBasicChangeUtils = this;
        approvalStatusNames.put(ActBasicChangeEnums.BASIC_CHANGE_APPLY.getFlag(), ActBasicChangeEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActBasicChangeEnums.BASIC_CHANGE_APPROVAL.getFlag(), ActBasicChangeEnums.APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(ActBasicChangeEnums.BASIC_CHANGE_REVIEW.getFlag(), ActBasicChangeEnums.REVIEW_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[]{
                ActBasicChangeEnums.BASIC_CHANGE_APPLY.getFlag(),
                ActBasicChangeEnums.BASIC_CHANGE_APPROVAL.getFlag()
        };
    }

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    /**
     * @return
     * @throws
     * @Title:
     * @Description: 启动原件归档
     * @param: serviceId 业务id
     * @param: serviceType 业务类型
     * @param: serviceName 业务名称
     * @author lijunjun
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo startBasicChangeApply(String serviceId, String serviceType, String serviceName, Map<String, Object> paramVariables) {
        //当前登录用户就是申请录入人员
        String applyUser = UserInfoUtils.getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActFileBorrowTaskEnums.PARAM_VARIABLES.getFlag(), paramVariables);
        //设置申请人
        variables.put(ActBasicChangeEnums.APPLY_USER.getFlag(), applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.BASIC_CHANGE.getKey(),
                ActProcessInstanceKeyEnums.BASIC_CHANGE.getDesc(), serviceType, serviceName, serviceId, applyUser, UserInfoUtils.getUser().getUserName());
        //启动流程
        ProcessInstance processInstance = actBasicChangeUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.BASIC_CHANGE.getKey(), serviceId, variables);
        //第一条任务是申请录入人的
        Task task = actBasicChangeUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String, Object> taskVariables = setApprovalUser(task);
        //同意条件
        taskVariables.put(getApprovalStatusName(task.getTaskDefinitionKey()),ActStatusEnums.AGREE.getFlag());
        actBasicChangeUtils.taskService.complete(task.getId(), taskVariables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 审核通过
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actBasicChangeUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        if (ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置操作人的节点则进行设置操作人
            return approval(ActStatusEnums.AGREE.getFlag(),taskId, setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActStatusEnums.AGREE.getFlag(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActStatusEnums.RETURN_SUPERIOR.getFlag(),taskId);
    }

    /**
     * @Description: 取消任务
     * @param: task
     * @return:
     * @Author: lijunjun
     * @Date: 2018/7/26 16:16
     */
    public static ActRuTaskVo approvalCancel(Task task){
        return approval(ActStatusEnums.CANCEL.getFlag(),task);
    }

    /**
     * @Title:
     * @Description: 基本信息变更取消 (根据业务id取消流程)
     * @param: serviceId
     * @return
     * @throws
     * @author lijunjuun
     * @date 2018/4/24 10:32
     */
    public static ActRuTaskVo applyCancel(String serviceId){
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务id不能为空");
        List<Task> tasks = actBasicChangeUtils.taskService.createTaskQuery().processInstanceBusinessKey(serviceId)
                .processDefinitionKey(ActProcessInstanceKeyEnums.BASIC_CHANGE.getKey()).list();
        if(ArrayUtils.isNotNullAndLengthNotZero(tasks) && tasks.size() > 1){
            throw new FmsServiceException("当前任务数量过多");
        }else if(ArrayUtils.isNullOrLengthZero(tasks))
            throw new FmsServiceException("当前不存在任务节点");
        else{
            return approvalCancel(tasks.get(0));
        }
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: task
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    public static ActRuTaskVo approval(Integer status,Task task){
        if(task == null)
            throw new FmsServiceException("任务不能为空");
        Map<String,Object> variables = new HashMap<>();
        if (StringUtils.isNotTrimBlank(getApprovalStatusName(task.getTaskDefinitionKey()))){
            variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        }
        actBasicChangeUtils.taskService.complete(task.getId(),variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task,setExecutionVariables(variables,task.getExecutionId()));
    }

    private static boolean setExecutionVariables(Map<String,Object> variables,String executionId){
        if(variables != null && variables.size() > 0 && StringUtils.isNotTrimBlank(executionId)){
            if(ArrayUtils.isNotNullAndLengthNotZero(actBasicChangeUtils.runtimeService.createExecutionQuery().executionId(executionId).list())) {
                for (String key : variables.keySet()) {
                    actBasicChangeUtils.runtimeService.setVariableLocal(executionId, key, variables.get(key));
                }
                return true;
            }
        }
        return false;
    }

    /**
     * @Title:
     * @Description:   设置相应节点的审批人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setUser(Task task){
        if(task.getTaskDefinitionKey().equals(ActBasicChangeEnums.BASIC_CHANGE_APPLY.getFlag())){
            return setApprovalUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActBasicChangeEnums.BASIC_CHANGE_APPROVAL.getFlag())){
            return setReviewUser(task);
        } else {
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @param: variables
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        if (StringUtils.isNotTrimBlank(getApprovalStatusName(task.getTaskDefinitionKey()))){
            variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
            actBasicChangeUtils.taskService.complete(taskId,variables);
        } else {
            actBasicChangeUtils.taskService.complete(taskId);
        }
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空 ");
        }
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actBasicChangeUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 获取当前节点对应的状态参数
     * @param: taskDefinitionKey
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  15:35
     */
    public static String getApprovalStatusName(String taskDefinitionKey){
        if(StringUtils.isTrimBlank(taskDefinitionKey)){
            throw new FmsServiceException("taskDefinitionKey不能为空");
        }
        //流程节点状态名称
        String approvalStatusName = approvalStatusNames.get(taskDefinitionKey);
        return approvalStatusName;
    }

    /**
     * @param task 任务
     * @return
     * @throws
     * @Title:
     * @Description: 设置审核人
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setApprovalUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActBasicChangeEnums.APPROVAL_USER.getFlag()))) {
            String userUnit = formPropertyMap.get(ActBasicChangeEnums.APPROVAL_USER_UNIT.getFlag());
            String userId = formPropertyMap.get(ActBasicChangeEnums.APPROVAL_USER_ID.getFlag());
            Object user = ActUtils.getNextUser(userId, userUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(user));
            results.put(ActBasicChangeEnums.APPROVAL_USER.getFlag(), user);
        }
        return results;
    }

    /**
     * @param task 任务
     * @return
     * @throws
     * @Title:
     * @Description: 设置审核人
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setReviewUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActBasicChangeEnums.REVIEW_USER.getFlag()))) {
            String userUnit = formPropertyMap.get(ActBasicChangeEnums.REVIEW_USER_UNIT.getFlag());
            String userId = formPropertyMap.get(ActBasicChangeEnums.REVIEW_USER_ID.getFlag());
            Object user = ActUtils.getNextUser(userId, userUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(user));
            results.put(ActBasicChangeEnums.REVIEW_USER.getFlag(), user);
        }
        return results;
    }

    private static Map<String, Object> getTaskVariables(String executionId) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = actBasicChangeUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }
}