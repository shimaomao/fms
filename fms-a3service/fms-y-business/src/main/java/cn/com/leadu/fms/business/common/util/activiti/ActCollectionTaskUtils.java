package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActCollectionTaskEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DispatchTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import com.alibaba.fastjson.JSON;
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
 * Created by root on 2018/9/12.
 */
@Component
@Slf4j
public class ActCollectionTaskUtils {

    /**
     * @Fields : 单例辅助
     * @author lijunjun
     */
    private static ActCollectionTaskUtils actCollectionTaskUtils = null;

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


    public ActCollectionTaskUtils() {

        actCollectionTaskUtils = this;
        approvalStatusNames.put(ActCollectionTaskEnums.COLLECTION_TASK_DISPATCH.getFlag(), ActCollectionTaskEnums.DISPATCH_STATUS.getFlag());
        approvalStatusNames.put(ActCollectionTaskEnums.COLLECTION_TASK_APPROVAL.getFlag(), ActCollectionTaskEnums.APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(ActCollectionTaskEnums.COLLECTION_TASK_MANAGER.getFlag(), ActCollectionTaskEnums.MANAGER_STATUS.getFlag());
        approvalStatusNames.put(ActCollectionTaskEnums.COLLECTION_TASK_CONFIRM.getFlag(), ActCollectionTaskEnums.CONFIRM_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[]{
                ActCollectionTaskEnums.COLLECTION_TASK_APPLY.getFlag(),
                ActCollectionTaskEnums.COLLECTION_TASK_DISPATCH.getFlag(),
                ActCollectionTaskEnums.COLLECTION_TASK_APPROVAL.getFlag(),
                ActCollectionTaskEnums.COLLECTION_TASK_MANAGER.getFlag(),
                ActCollectionTaskEnums.COLLECTION_TASK_REGISTER.getFlag()
        };
    }

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    /**
     * 启动上门催收
     * @param serviceId
     * @param serviceName
     * @return
     */
    public static ActRuTaskVo startCollectionTaskApply(String serviceId, String serviceName) {
        //当前登录用户就是申请录入人员
        String applyUser = UserInfoUtils.getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        //设置申请人
        variables.put(ActCollectionTaskEnums.APPLY_USER.getFlag(), applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.COLLECTION_TASK.getKey(),
                ActProcessInstanceKeyEnums.COLLECTION_TASK.getDesc(), "", serviceName, serviceId, applyUser, UserInfoUtils.getUser().getUserName());
        //启动流程
        ProcessInstance processInstance = actCollectionTaskUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.COLLECTION_TASK.getKey(), serviceId, variables);
        //第一条任务是申请录入人的
        Task task = actCollectionTaskUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到派单人的信息,并设置派单人
        Map<String, Object> taskVariables = setDispatchUser(task);
        actCollectionTaskUtils.taskService.complete(task.getId(), taskVariables);
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
        Task task = actCollectionTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
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
     * @Description: 副总审核通过
     * @param:  taskId
     * @param:  collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo dispatchApprovalAgree(String taskId, CollectionTaskVo collectionTaskVo){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actCollectionTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        if (ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置操作人的节点则进行设置操作人
            return approval(ActStatusEnums.AGREE.getFlag(),taskId, setApprovalUser(task, collectionTaskVo));
        }else{
            //否则正常走下一步
            return approval(ActStatusEnums.AGREE.getFlag(),taskId);
        }
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
        if(task.getTaskDefinitionKey().equals(ActCollectionTaskEnums.COLLECTION_TASK_APPLY.getFlag())){
            return setDispatchUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActCollectionTaskEnums.COLLECTION_TASK_DISPATCH.getFlag())){
            return setApprovalUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActCollectionTaskEnums.COLLECTION_TASK_APPROVAL.getFlag())){
            return setManagerUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActCollectionTaskEnums.COLLECTION_TASK_MANAGER.getFlag())){
            return setRegisterUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActCollectionTaskEnums.COLLECTION_TASK_REGISTER.getFlag())){
            return setConfirmUser(task);
        } else {
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }

    /**
     * 审核任务
     * @param status
     * @param taskId
     * @return
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空 ");
        }
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actCollectionTaskUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * 审核
     * @param status
     * @param taskId
     * @param variables
     * @return
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        if (StringUtils.isNotTrimBlank(getApprovalStatusName(task.getTaskDefinitionKey()))){
            variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        }
        actCollectionTaskUtils.taskService.complete(taskId, variables);
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
     * 设置派单人
     * @param task
     * @return
     */
    private static Map<String, Object> setDispatchUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果派单人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActCollectionTaskEnums.DISPATCH_USER.getFlag()))) {
            String userUnit = formPropertyMap.get(ActCollectionTaskEnums.DISPATCH_USER_UNIT.getFlag());
            String userId = formPropertyMap.get(ActCollectionTaskEnums.DISPATCH_USER_ID.getFlag());
            Object user = ActUtils.getNextUser(userId, userUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的派单人是: " + JSON.toJSONString(user));
            results.put(ActCollectionTaskEnums.DISPATCH_USER.getFlag(), user);
        }
        return results;
    }

    /**
     * 设置风控审核人
     * @param task
     * @return
     */
    private static Map<String, Object> setApprovalUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果派单人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActCollectionTaskEnums.APPROVAL_USER.getFlag()))) {
            String userUnit = formPropertyMap.get(ActCollectionTaskEnums.APPROVAL_USER_UNIT.getFlag());
            String userId = formPropertyMap.get(ActCollectionTaskEnums.APPROVAL_USER_ID.getFlag());
            Object user = ActUtils.getNextUser(userId, userUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的风控审核人是: " + JSON.toJSONString(user));
            results.put(ActCollectionTaskEnums.APPROVAL_USER.getFlag(), user);
        }
        return results;
    }

    /**
     * 设置风控经理审核人
     * @param task
     * @return
     */
    private static Map<String, Object> setApprovalUser(Task task, CollectionTaskVo collectionTaskVo) {
        // 设定副总人员
        Map<String, Object> results = setApprovalUser(task);
        //如果派单人为空，则进行放入
        if (StringUtils.equals(DispatchTypeEnums.COMPANY.getType(), collectionTaskVo.getDispatchType())) {
            // 如果是公司内部 登记人设定为指定派单人
            results.put(ActCollectionTaskEnums.REGISTER_USER.getFlag(), collectionTaskVo.getDispatchUser());
        } else {
            // 如果是公司内部 登记人设定为登记人
            results.put(ActCollectionTaskEnums.REGISTER_USER.getFlag(), collectionTaskVo.getRegisterUser());
        }
        return results;
    }

    /**
     * 设置副总审核人
     * @param task
     * @return
     */
    private static Map<String, Object> setManagerUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果派单人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActCollectionTaskEnums.MANAGER_USER.getFlag()))) {
            String userUnit = formPropertyMap.get(ActCollectionTaskEnums.MANAGER_USER_UNIT.getFlag());
            String userId = formPropertyMap.get(ActCollectionTaskEnums.MANAGER_USER_ID.getFlag());
            Object user = ActUtils.getNextUser(userId, userUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的副总审核人是: " + JSON.toJSONString(user));
            results.put(ActCollectionTaskEnums.MANAGER_USER.getFlag(), user);
        }
        return results;
    }

    /**
     * 设置催收结果登记人
     * @param task
     * @return
     */
    private static Map<String, Object> setRegisterUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果派单人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActCollectionTaskEnums.REGISTER_USER.getFlag()))) {
            String userUnit = formPropertyMap.get(ActCollectionTaskEnums.REGISTER_USER_UNIT.getFlag());
            String userId = formPropertyMap.get(ActCollectionTaskEnums.REGISTER_USER_ID.getFlag());
            Object user = ActUtils.getNextUser(userId, userUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的催收结果登记人是: " + JSON.toJSONString(user));
            results.put(ActCollectionTaskEnums.REGISTER_USER.getFlag(), user);
        }
        return results;
    }


    /**
     * 设置催收结果确认人
     * @param task
     * @return
     */
    private static Map<String, Object> setConfirmUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果派单人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActCollectionTaskEnums.CONFIRM_USER.getFlag()))) {
            String userUnit = formPropertyMap.get(ActCollectionTaskEnums.CONFIRM_USER_UNIT.getFlag());
            String userId = formPropertyMap.get(ActCollectionTaskEnums.CONFIRM_USER_ID.getFlag());
            Object user = ActUtils.getNextUser(userId, userUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的催收结果确认人是: " + JSON.toJSONString(user));
            results.put(ActCollectionTaskEnums.CONFIRM_USER.getFlag(), user);
        }
        return results;
    }

    private static Map<String, Object> getTaskVariables(String executionId) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = actCollectionTaskUtils.runtimeService.getVariables(executionId);
        return taskVariables;
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
     * @Title:
     * @Description: 审核拒绝
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalRefuse(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actCollectionTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        return approval(ActStatusEnums.REFUSE.getFlag(),taskId);
    }
}
