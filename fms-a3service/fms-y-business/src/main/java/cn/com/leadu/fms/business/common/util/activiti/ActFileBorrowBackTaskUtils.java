package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFileBorrowBackTaskEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFileBorrowTaskEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFileBorrowTaskStatusEnums;
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
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ActFileBorrowBackTaskUtils
 * @Description: 借阅归还工作流
 * @date 2018/6/7
 */
@Component
@Slf4j
public class ActFileBorrowBackTaskUtils {

    /**
     * 单例
     */
    private static ActFileBorrowBackTaskUtils actFileBorrowBackTaskUtils = null;

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

    public ActFileBorrowBackTaskUtils(){
        actFileBorrowBackTaskUtils = this;
        approvalStatusNames.put(ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_REVIEW.getFlag(),ActFileBorrowBackTaskEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_MAKE_VOUCHER.getFlag(),ActFileBorrowBackTaskEnums.MAKE_VOUCHER_STATUS.getFlag());
        approvalStatusNames.put(ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_PAYMENT.getFlag(),ActFileBorrowBackTaskEnums.PAY_STATUS.getFlag());
        approvalStatusNames.put(ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_CONFIRM.getFlag(),ActFileBorrowBackTaskEnums.CONFIRM_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[] {
                ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_APPLY.getFlag(),
                ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_REVIEW.getFlag(),
                ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_MAKE_VOUCHER.getFlag(),
                ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_PAYMENT.getFlag()
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
    public static ActRuTaskVo startFileBorrowBackTask(String serviceId, String serviceType, String serviceName, Map<String, Object> paramVariables){
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
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.FILE_BORROW_BACK_TASK.getKey(),
                ActProcessInstanceKeyEnums.FILE_BORROW_BACK_TASK.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actFileBorrowBackTaskUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.FILE_BORROW_BACK_TASK.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actFileBorrowBackTaskUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables =  setReviewUser(task);
        actFileBorrowBackTaskUtils.taskService.complete(task.getId(),taskVariables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 资管复核通过-资管确认
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo reviewComplete(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actFileBorrowBackTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        //return approval(ActFileBorrowTaskStatusEnums.COMPLETE.getFlag(),taskId);

        if (ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置操作人的节点则进行设置操作人
            return approval(ActFileBorrowTaskStatusEnums.COMPLETE.getFlag(),taskId,setConfirmer(task));
        }else{
            //否则正常走下一步
            return approval(ActFileBorrowTaskStatusEnums.COMPLETE.getFlag(),taskId);
        }
    }


    /**
     * @Title:
     * @Description: 资管复核通过
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo reviewAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actFileBorrowBackTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        if (ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置操作人的节点则进行设置操作人
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId);
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
     * @Description: 设置财务制单人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setMakeVoucher(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowBackTaskEnums.MAKE_VOUCHER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActFileBorrowBackTaskEnums.MAKE_VOUCHER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActFileBorrowBackTaskEnums.MAKE_VOUCHER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActFileBorrowBackTaskEnums.MAKE_VOUCHER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description: 设置财务打款人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setPayer(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowBackTaskEnums.PAYER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActFileBorrowBackTaskEnums.PAYER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActFileBorrowBackTaskEnums.PAYER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActFileBorrowBackTaskEnums.PAYER.getFlag(),reviewUser);
            results.put(ActFileBorrowBackTaskEnums.NEXT_USER.getFlag(),reviewUser);
        }else{
            results.put(ActFileBorrowBackTaskEnums.NEXT_USER.getFlag(),taskVariables.get(ActFileBorrowBackTaskEnums.PAYER.getFlag()));
        }
        return results;
    }

    /**
     * @Title:
     * @Description: 设置资管最终确认人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/08/06 02:53:21
     */
    private static Map<String,Object> setConfirmer(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowBackTaskEnums.CONFIRM_USER.getFlag()))){
            String confirmUserUnit = formPropertyMap.get(ActFileBorrowBackTaskEnums.CONFIRM_UNIT.getFlag());
            String confirmUserId = formPropertyMap.get(ActFileBorrowBackTaskEnums.CONFIRM_ID.getFlag());
            Object confirmUser = ActUtils.getNextUser(confirmUserId,confirmUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的资管确认人是: " + JSON.toJSONString(confirmUser));
            results.put(ActFileBorrowBackTaskEnums.CONFIRM_USER.getFlag(),confirmUser);
            results.put(ActFileBorrowBackTaskEnums.NEXT_USER.getFlag(),confirmUser);
        }else{
            results.put(ActFileBorrowBackTaskEnums.NEXT_USER.getFlag(),taskVariables.get(ActFileBorrowBackTaskEnums.CONFIRM_USER.getFlag()));
        }
        return results;
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
        if(task.getTaskDefinitionKey().equals(ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_APPLY.getFlag())){
            return setReviewUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_REVIEW.getFlag())){
            return setMakeVoucher(task);
        } else if (task.getTaskDefinitionKey().equals(ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_MAKE_VOUCHER.getFlag())) {
            return setPayer(task);
        }else if (task.getTaskDefinitionKey().equals(ActFileBorrowBackTaskEnums.BORROW_BACK_TASK_PAYMENT.getFlag())) {
            return setConfirmer(task);
        }else{
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
        if (getApprovalStatusName(task.getTaskDefinitionKey()) != null){
            variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        }
        actFileBorrowBackTaskUtils.taskService.complete(taskId,variables);
        ActRuTaskVo actRuTaskVo =  ActUtils.getActRuTaskVoAndNextInfo(task);
        return actRuTaskVo;
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
        actFileBorrowBackTaskUtils.taskService.complete(taskId,variables);
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
     * @Title:
     * @Description: 设置资管复核人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setReviewUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActFileBorrowBackTaskEnums.REVIEW_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActFileBorrowBackTaskEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActFileBorrowBackTaskEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActFileBorrowBackTaskEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }

    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actFileBorrowBackTaskUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }
}
