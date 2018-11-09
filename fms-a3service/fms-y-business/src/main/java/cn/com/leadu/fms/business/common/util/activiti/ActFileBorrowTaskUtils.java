package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFileBorrowTaskEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFileBorrowTaskStatusEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.common.constant.enums.original.FileTypeCodeEnums;
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
import java.util.Map;

/**
 * Created by root on 2018/6/5.
 */
@Component
@Slf4j
public class ActFileBorrowTaskUtils {

    /**
     * 单例
     */
    private static ActFileBorrowTaskUtils actFileBorrowTaskUtils = null;

    /**
     * @Fields  : 每个流程节点的审批状态名称
     * @author ningyangyang
     */
    private static Map<String,String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields  : 需要设置用户的节点
     * @author ningyangyang
     */
    private static String [] userDefKeys = null;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    public ActFileBorrowTaskUtils(){
        actFileBorrowTaskUtils = this;
        approvalStatusNames.put(ActFileBorrowTaskEnums.BORROW_TASK_APPLY.getFlag(),ActFileBorrowTaskEnums.FILE_TYPE_CODE.getFlag());
        approvalStatusNames.put(ActFileBorrowTaskEnums.FINANCE_CONFIRM.getFlag(),ActFileBorrowTaskEnums.FINANCE_CONFIRM_STATUS.getFlag());
        approvalStatusNames.put(ActFileBorrowTaskEnums.BORROW_TASK_EXAMINE.getFlag(),ActFileBorrowTaskEnums.EXAMINE_STATUS.getFlag());
        approvalStatusNames.put(ActFileBorrowTaskEnums.BORROW_TASK_MAIL.getFlag(),ActFileBorrowTaskEnums.MAIL_STATUS.getFlag());
        approvalStatusNames.put(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE.getFlag(),ActFileBorrowTaskEnums.RE_EXAMINE_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[] {
                ActFileBorrowTaskEnums.BORROW_TASK_APPLY.getFlag(),
                ActFileBorrowTaskEnums.FINANCE_CONFIRM.getFlag(),
                ActFileBorrowTaskEnums.BORROW_TASK_EXAMINE.getFlag(),
//                ActFileBorrowTaskEnums.BORROW_TASK_MAIL.getFlag(),
                ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE.getFlag()
        };
    }

    /**
     * @Title:
     * @Description: 启动原件借阅流程
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @param:  fileTypeCode 判断类型
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/5/17 15:22
     */
    public static ActRuTaskVo startFileBorrowTask(String serviceId, String serviceType, String serviceName, String fileTypeCode, Map<String,Object> paramVariables){
        //当前登录用户就是申请人员
        String applyUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActFileBorrowTaskEnums.PARAM_VARIABLES.getFlag(), paramVariables);
        variables.put(ActFileBorrowTaskEnums.APPLY_USER.getFlag(), applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.FILE_BORROW_TASK.getKey(),
                ActProcessInstanceKeyEnums.FILE_BORROW_TASK.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actFileBorrowTaskUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.FILE_BORROW_TASK.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actFileBorrowTaskUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables =  setNextOperateUser(task, fileTypeCode);
        actFileBorrowTaskUtils.taskService.complete(task.getId(),taskVariables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 申请通过
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo applyAgree(String taskId, String fileTypeCode){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actFileBorrowTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        //如果是需要设置操作人的节点则进行设置操作人
        return approval(Integer.valueOf(fileTypeCode),taskId,setNextOperateUser(task, fileTypeCode));
    }

    /**
     * @Title:
     * @Description: 获取下一节点操作人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setNextOperateUser(Task task, String fileTypeCode){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        if (StringUtils.isNotTrimBlank(fileTypeCode) && FileTypeCodeEnums.NOT_CARKEY.getType().equals(fileTypeCode)){
            //fileTypeCode为0 走资管邮寄资料节点
//            //如果邮寄人人为空，则进行放入
//            setMailVariables(taskVariables, formPropertyMap, task, results);
            //如果复核人员为空
            setReExamineUserVariables(taskVariables, formPropertyMap, task, results);;
        }else if (StringUtils.isNotTrimBlank(fileTypeCode) && FileTypeCodeEnums.CARKEY_DEPOSIT_FLAG_YES.getType().equals(fileTypeCode)){
            //fileTypeCode为1 走财务确认节点
            //如果财务确认人人为空，则进行放入
            setFinanceConfirmVariables(taskVariables, formPropertyMap, task, results);
        }else if (StringUtils.isNotTrimBlank(fileTypeCode) && FileTypeCodeEnums.CARKEY_DEPOSIT_FLAG_NO.getType().equals(fileTypeCode)){
            //fileTypeCode为0 走资管邮寄资料节点
            //如果审核人人为空，则进行放入
            setExamineVariables(taskVariables, formPropertyMap, task, results);
        }
        results.put(ActFileBorrowTaskEnums.FILE_TYPE_CODE.getFlag(), fileTypeCode);
        return results;
    }

    /**
     * @Title:
     * @Description: 财务确认通过
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo financeConfirmAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actFileBorrowTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        if (ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置操作人的节点则进行设置操作人
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId,setReExamineUser(task));
        }else{
            //否则正常走下一步
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId);
        }
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
    public static ActRuTaskVo borrowTaskExamineAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actFileBorrowTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        if (ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置操作人的节点则进行设置操作人
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId,setReExamineUser(task));
        }else{
            //否则正常走下一步
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 资管邮寄资料通过
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo borrowTaskMailAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actFileBorrowTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId);
    }

    /**
     * @Title:
     * @Description: 复核取消，直接结束
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo borrowTaskOverComplete(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actFileBorrowTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        //否则正常走下一步
        return approval(ActFileBorrowTaskStatusEnums.COMPLETE.getFlag(),taskId);
    }

    /**
     * @Title:
     * @Description: 资管复审通过
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo borrowTaskReExamineAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actFileBorrowTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        if (ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置操作人的节点则进行设置操作人
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId,setMailUser(task));
        }else {
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(), taskId);
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
        return approval(ActFileBorrowTaskStatusEnums.RETURN_SUPERIOR.getFlag(),taskId);
    }

    /**
     * @Title:
     * @Description: 设置资料邮寄人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setMailUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        setMailVariables(taskVariables, formPropertyMap, task, results);
        return results;
    }

    /**
     * @Title:
     * @Description: 设置资料邮寄人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setReExamineUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE_USER.getFlag(),reviewUser);
        }
        return results;
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
        String approvalStatusName = getApprovalStatusName(task.getTaskDefinitionKey());
        if (StringUtils.isNotTrimBlank(approvalStatusName)){
            variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        }
        actFileBorrowTaskUtils.taskService.complete(taskId,variables);
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
     * @author lijunjun
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        String approvalStatusName = getApprovalStatusName(task.getTaskDefinitionKey());
        if (StringUtils.isNotTrimBlank(approvalStatusName)){
            variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        }
        actFileBorrowTaskUtils.taskService.complete(taskId,variables);
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
        //返回流程节点状态名称
        return approvalStatusNames.get(taskDefinitionKey);
    }

    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actFileBorrowTaskUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }

    private static void setMailVariables(Map<String,Object> taskVariables, Map<String,String> formPropertyMap, Task task, Map<String,Object> results){
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowTaskEnums.MAIL_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActFileBorrowTaskEnums.BORROW_TASK_MAIL_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActFileBorrowTaskEnums.BORROW_TASK_MAIL_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActFileBorrowTaskEnums.MAIL_USER.getFlag(),reviewUser);
        }
    }

    private static void setFinanceConfirmVariables(Map<String,Object> taskVariables, Map<String,String> formPropertyMap, Task task, Map<String,Object> results){
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowTaskEnums.FINANCE_CONFIRM_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActFileBorrowTaskEnums.FINANCE_CONFIRM_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActFileBorrowTaskEnums.FINANCE_CONFIRM_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActFileBorrowTaskEnums.FINANCE_CONFIRM_USER.getFlag(),reviewUser);
        }
    }

    private static void setExamineVariables(Map<String,Object> taskVariables, Map<String,String> formPropertyMap, Task task, Map<String,Object> results){
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowTaskEnums.BORROW_TASK_EXAMINE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActFileBorrowTaskEnums.BORROW_TASK_EXAMINE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActFileBorrowTaskEnums.BORROW_TASK_EXAMINE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActFileBorrowTaskEnums.BORROW_TASK_EXAMINE_USER.getFlag(),reviewUser);
        }
    }
    private static void setReExamineUserVariables(Map<String,Object> taskVariables, Map<String,String> formPropertyMap, Task task, Map<String,Object> results){
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActFileBorrowTaskEnums.BORROW_TASK_REEXAMINE_USER.getFlag(),reviewUser);
        }

    }
}
