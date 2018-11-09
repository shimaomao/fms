package cn.com.leadu.fms.business.common.util.activiti;/**
 * Created by ningyangyang on 2018/9/13.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActChangeLesEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActChangeLesStatusEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: fms
 * @Description: 变更承租人工作流
 * @author: ningyangyang
 * @date 2018/9/13 17:12
 */
@Component
@Slf4j
public class ActChangeLesseeUtils {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * @Fields : 单例辅助
     * @author ningyangyang
     */
    private static ActChangeLesseeUtils actChangeLesseeUtils = null;

    /**
     * @Fields  : 每个流程节点的审批状态名称
     * @author ningyangyang
     */
    private static Map<String,String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields : 需要设置用户的节点
     * @author ningyangyang
     */
    private static String[] userDefKeys = null;

    public ActChangeLesseeUtils(){
        actChangeLesseeUtils = this;
        approvalStatusNames.put(ActChangeLesEnums.CHANGE_TASK_APPLY.getFlag(), ActChangeLesEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActChangeLesEnums.CHANGE_TASK_APPROVE.getFlag(), ActChangeLesEnums.APPROVE_STATUS.getFlag());
        approvalStatusNames.put(ActChangeLesEnums.CHANGE_TASK_REVIEW.getFlag(), ActChangeLesEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActChangeLesEnums.CHANGE_TASK_CONT_CREATE.getFlag(), ActChangeLesEnums.GENERATE_STATUS.getFlag());
        approvalStatusNames.put(ActChangeLesEnums.CHANGE_TASK_CONT_PRINT.getFlag(), ActChangeLesEnums.PRINT_STATUS.getFlag());
        approvalStatusNames.put(ActChangeLesEnums.CHANGE_TASK_CONT_AUDIT.getFlag(), ActChangeLesEnums.CONT_AUDIT_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[]{
                ActChangeLesEnums.CHANGE_TASK_APPLY.getFlag(),
                ActChangeLesEnums.CHANGE_TASK_APPROVE.getFlag(),
                ActChangeLesEnums.CHANGE_TASK_CONT_PRINT.getFlag(),
        };
    }

    /**
     * @return ActRuTaskVo
     * @throws
     * @Title:
     * @Description: 启动展期合同流程
     * @param: serviceId 业务id
     * @param: serviceType 业务类型
     * @param: serviceName 业务名称
     * @author ningyangyang
     * @date 2018/9/5 20:16
     */
    public static ActRuTaskVo startChangeLesseeTask(String serviceId, String serviceType, String serviceName) {
        //当前登录用户就是保单上传人员
        String uploadRegisterUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActChangeLesEnums.APPLY_USER.getFlag(), uploadRegisterUser);
        variables.put(ActChangeLesEnums.CONT_GENERATOR.getFlag(), uploadRegisterUser);
        variables.put(ActChangeLesEnums.CONT_PRINTER.getFlag(), uploadRegisterUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.CHANGE_LESSEE_TASK.getKey(),
                ActProcessInstanceKeyEnums.CHANGE_LESSEE_TASK.getDesc(), serviceType, serviceName, serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actChangeLesseeUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.CHANGE_LESSEE_TASK.getKey(), serviceId, variables);
        //第一条任务是保单上传人的
        Task task = actChangeLesseeUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
//        //获取风控信息下一节点审批人
//        Map<String, Object> taskVariables = setApproveUser(task);
//        //自动设置为完成
//        actDeferTaskUtils.taskService.complete(task.getId(), taskVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }
    /**
     * @return ActRuTaskVo
     * @throws
     * @Title:
     * @Description: 启动并提交展期合同流程
     * @param: serviceId 业务id
     * @param: serviceType 业务类型
     * @param: serviceName 业务名称
     * @author ningyangyang
     * @date 2018/9/5 20:16
     */
    public static ActRuTaskVo startAndSubChangeLesseeTask(String serviceId, String serviceType, String serviceName) {
        //当前登录用户就是保单上传人员
        String uploadRegisterUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActChangeLesEnums.APPLY_USER.getFlag(), uploadRegisterUser);
        variables.put(ActChangeLesEnums.CONT_GENERATOR.getFlag(), uploadRegisterUser);
        variables.put(ActChangeLesEnums.CONT_PRINTER.getFlag(), uploadRegisterUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.CHANGE_LESSEE_TASK.getKey(),
                ActProcessInstanceKeyEnums.CHANGE_LESSEE_TASK.getDesc(), serviceType, serviceName, serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actChangeLesseeUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.CHANGE_LESSEE_TASK.getKey(), serviceId, variables);
        //第一条任务是保单上传人的
        Task task = actChangeLesseeUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
//        //获取风控信息下一节点审批人
        Map<String, Object> taskVariables = setApproveUser(task);
//        //自动设置为完成
        //actChangeLesseeUtils.taskService.complete(task.getId(), taskVariables);
        approval(ActChangeLesStatusEnums.AGREE.getStatus(),task.getId(),taskVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 审批通过(单节点)
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/5  14:11
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actChangeLesseeUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActChangeLesStatusEnums.AGREE.getStatus(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActChangeLesStatusEnums.AGREE.getStatus(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/13  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActChangeLesStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 变更任务拒绝
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/10/9  14:11
     */
    public static ActRuTaskVo approvalToRefuse(String taskId){
        return approval(ActChangeLesStatusEnums.REFUSE.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 变更任务取消
     * @param:  taskNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/10/11  14:11
     */
    public static ActRuTaskVo applyCancel(String taskNo){
        if(StringUtils.isTrimBlank(taskNo))
            throw new FmsServiceException("任务号不能为空");
        List<Task> tasks = actChangeLesseeUtils.taskService.createTaskQuery().processInstanceBusinessKey(taskNo)
                .processDefinitionKey(ActProcessInstanceKeyEnums.CHANGE_LESSEE_TASK.getKey()).list();
        if(ArrayUtils.isNotNullAndLengthNotZero(tasks) && tasks.size() > 1){
            throw new FmsServiceException("当前任务数量过多");
        }else if(ArrayUtils.isNullOrLengthZero(tasks))
            throw new FmsServiceException("当前不存在任务节点");
        else{
            return approveCancel(tasks.get(0).getId());
        }
    }
    /**
     * @Title:
     * @Description: 申请取消
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/1011  14:11
     */
    public static ActRuTaskVo approveCancel(String taskId) {
        return approval(ActChangeLesStatusEnums.CANCEL.getStatus(), taskId);
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/13 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actChangeLesseeUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @param: variables
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/13 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actChangeLesseeUtils.taskService.complete(taskId,variables);
        ActRuTaskVo actRuTaskVo = ActUtils.getActRuTaskVoAndNextInfo(task);
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 获取当前节点对应的状态参数
     * @param: taskDefinitionKey
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/13  15:35
     */
    public static String getApprovalStatusName(String taskDefinitionKey){
        if(StringUtils.isTrimBlank(taskDefinitionKey))
            throw new FmsServiceException("taskDefinitionKey不能为空");
        //流程节点状态名称
        String approvalStatusName = approvalStatusNames.get(taskDefinitionKey);
        if(StringUtils.isTrimBlank(approvalStatusName)){
            throw  new FmsServiceException("taskDefinitionKey对应的状态标识不存在");
        }
        return approvalStatusName;
    }

    /**
     * @Title:
     * @Description:   设置相应节点的审批人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/13 02:53:21
     */
    private static Map<String,Object> setUser(Task task){

        if(task.getTaskDefinitionKey().equals(ActChangeLesEnums.CHANGE_TASK_APPLY.getFlag())){
            //申请节点设置初审人
            return setApproveUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActChangeLesEnums.CHANGE_TASK_APPROVE.getFlag())){
            //风控初审设置复审人
            return setReviewUser(task);
        }
        else if(task.getTaskDefinitionKey().equals(ActChangeLesEnums.CHANGE_TASK_CONT_PRINT.getFlag())){
            //设置合同审核节点人
            return setContAuditor(task);
        }
        else{
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }


    /**
     * @Title:
     * @Description:   设置风控初审人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/13 02:53:21
     */
    private static Map<String,Object> setApproveUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActChangeLesEnums.APPROVE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActChangeLesEnums.APPROVE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActChangeLesEnums.APPROVE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的风控初审人是: " + JSON.toJSONString(reviewUser));
            results.put(ActChangeLesEnums.APPROVE_USER.getFlag(),reviewUser);
        }
        return results;
    }
    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actChangeLesseeUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }

    /**
     * @Title:
     * @Description:   设置风控复审人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/13 02:53:21
     */
    private static Map<String,Object> setReviewUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActChangeLesEnums.REVIEW_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActChangeLesEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActChangeLesEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的风控复审人是: " + JSON.toJSONString(reviewUser));
            results.put(ActChangeLesEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置合同审核节点用户
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/13 02:53:21
     */
    private static Map<String,Object> setContAuditor(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActChangeLesEnums.CONT_AUDITOR.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActChangeLesEnums.CONT_AUDITOR_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActChangeLesEnums.CONT_AUDITOR_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的合同审核用户是: " + JSON.toJSONString(reviewUser));
            results.put(ActChangeLesEnums.CONT_AUDITOR.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description: 修改业务名称
     * @param:  taskId 任务id
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/15  11:57
     */
    public static void modifyServiceName(String taskId,String serviceName){
        if(StringUtils.isTrimBlank(taskId))
            new FmsServiceException("任务id不能为空");
        if(StringUtils.isTrimBlank(serviceName))
            new FmsServiceException("业务名称不能为空");
        modifyVariable(taskId, ActFlagEnums.SERVICE_NAME.getFlag(),serviceName);
    }

    /**
     * @Title:
     * @Description:
     * @param: taskId 任务id
     * @param: key 任务id
     * @param: value 任务id
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/15  11:57
     */
    private static void modifyVariable(String taskId,String key,String value){
        actChangeLesseeUtils.taskService.setVariable(taskId,key,value);
    }

}
