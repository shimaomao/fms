package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.*;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.FormService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: fms
 * @description: 过户工作流工具类
 * @author: wangxue
 * @create: 2018-09-06 11:30
 **/
@Component
@Slf4j
public class ActTransferTaskUtils {

    /**
     * 单例
     */
    private static ActTransferTaskUtils actTransferInfoUtils = null;

    /**
     * @Fields  : 每个流程节点的审批状态名称
     * @author yangyiquan
     */
    private static Map<String,String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields  : 需要设置用户的节点
     * @author yangyiquan
     */
    private static String [] userDefKeys = null;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    public ActTransferTaskUtils(){
        actTransferInfoUtils = this;
        approvalStatusNames.put(ActTransferTaskEnums.TRANSFER_TASK_APPLY.getFlag(), ActTransferTaskEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActTransferTaskEnums.TRANSFER_TASK_APPROVAL.getFlag(), ActTransferTaskEnums.APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(ActTransferTaskEnums.TRANSFER_TASK_SETTLEMENT.getFlag(), ActTransferTaskEnums.SETTLEMENT_STATUS.getFlag());
        approvalStatusNames.put(ActTransferTaskEnums.TRANSFER_TASK_REVIEW.getFlag(), ActTransferTaskEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActTransferTaskEnums.TRANSFER_TASK_TOUCHING.getFlag(), ActTransferTaskEnums.TOUCHING_STATUS.getFlag());
        approvalStatusNames.put(ActTransferTaskEnums.TRANSFER_TASK_CHECK.getFlag(), ActTransferTaskEnums.CHECK_STATUS.getFlag());
        approvalStatusNames.put(ActTransferTaskEnums.TRANSFER_TASK_LOAN.getFlag(), ActTransferTaskEnums.LOAN_STATUS.getFlag());
        approvalStatusNames.put(ActTransferTaskEnums.TRANSFER_TASK_RECEIPT.getFlag(), ActTransferTaskEnums.RECEIPT_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[] {ActTransferTaskEnums.TRANSFER_TASK_APPLY.getFlag(),
                ActTransferTaskEnums.TRANSFER_TASK_APPROVAL.getFlag(),
                ActTransferTaskEnums.TRANSFER_TASK_SETTLEMENT.getFlag(),
                ActTransferTaskEnums.TRANSFER_TASK_REVIEW.getFlag(),
                ActTransferTaskEnums.TRANSFER_TASK_TOUCHING.getFlag(),
                ActTransferTaskEnums.TRANSFER_TASK_CHECK.getFlag(),
        };
    }

    /**
     * @Title:
     * @Description: 启动过户申请
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018/5/17 15:22
     */
    public static ActRuTaskVo startTransferAndSubmit(String serviceId, String serviceName){
        //当前登录用户就是申请人员
        String applyUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActTransferTaskEnums.APPLY_USER.getFlag(),applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.TRANSFER_TASK.getKey(),
                ActProcessInstanceKeyEnums.TRANSFER_TASK.getDesc(),"",serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actTransferInfoUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.TRANSFER_TASK.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actTransferInfoUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        // 提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables = setApprovalUser(task);
        //自动设置为完成
        actTransferInfoUtils.taskService.complete(task.getId(),taskVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 审批通过
     * @param:  taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actTransferInfoUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActTransferTaskStatusEnums.AGREE.getStatus(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActTransferTaskStatusEnums.AGREE.getStatus(),taskId);
        }
    }

    /**
     * @Description: 资管复审到财务审核
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/6/21 11:27
     */
    public static ActRuTaskVo agreeTouching(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actTransferInfoUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActTransferTaskStatusEnums.PAYMENT.getStatus(),taskId,setTouchingUser(task));
        }else{
            //否则正常走下一步
            return approval(ActTransferTaskStatusEnums.PAYMENT.getStatus(),taskId);
        }
    }

    /**
     * @Description: 资管复审和财务确认流程直接结束
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/6/21 11:27
     */
    public static ActRuTaskVo agreeDirectEnd(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actTransferInfoUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        // 流程直接结束
        return approval(ActTransferTaskStatusEnums.DIRECT_END.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description:   设置相应节点的审批人
     * @param task 任务
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setUser(Task task){
        if (ActTransferTaskEnums.TRANSFER_TASK_APPLY.getFlag().equals(task.getTaskDefinitionKey())) {
            // 申请节点，设置过户审核人
            return setApprovalUser(task);
        } else if(ActTransferTaskEnums.TRANSFER_TASK_APPROVAL.getFlag().equals(task.getTaskDefinitionKey())){
            //初审节点设置费用结算人
            return setSettlementUser(task);
        } else if(ActTransferTaskEnums.TRANSFER_TASK_SETTLEMENT.getFlag().equals(task.getTaskDefinitionKey())){
            //费用结算节点，设置资管复审人
            return setReviewUser(task);
        } else if(ActTransferTaskEnums.TRANSFER_TASK_REVIEW.getFlag().equals(task.getTaskDefinitionKey())){
            // 资管复审节点，设置财务审核人
            return setTouchingUser(task);
        }  else if(ActTransferTaskEnums.TRANSFER_TASK_TOUCHING.getFlag().equals(task.getTaskDefinitionKey())){
            // 财务审核节点，设置总经理审核人
            return setCheckUser(task);
        } else if(ActTransferTaskEnums.TRANSFER_TASK_CHECK.getFlag().equals(task.getTaskDefinitionKey())){
            // 总经理审核节点，设置确认付款人
            return setLoanUser(task);
        } else{
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActTransferTaskStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 退回到财务审核节点
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/8/23  14:11
     */
    public static ActRuTaskVo approvalBackTouching(String taskId){
        return approval(ActTransferTaskStatusEnums.BASK_TOUCHING.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);

        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actTransferInfoUtils.taskService.complete(taskId,variables);
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
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actTransferInfoUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 获取当前节点对应的状态参数
     * @param: taskDefinitionKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  15:35
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
     * @Description:   设置审批人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setApprovalUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String,Object> results = new HashMap<>();
        //如果申请审批人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActTransferTaskEnums.APPROVAL_USER.getFlag()))){
            String approvalUserId = formPropertyMap.get(ActTransferTaskEnums.APPROVAL_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActTransferTaskEnums.APPROVAL_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUser(approvalUserId,approvalUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(approvalUser));
            results.put(ActTransferTaskEnums.APPROVAL_USER.getFlag(),approvalUser);
        }
        return results;
    }

    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actTransferInfoUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }

    /**
     * @Title:
     * @Description:   设置资管复核人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
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
        if(StringUtils.isTrimBlank(taskVariables.get(ActTransferTaskEnums.REVIEW_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActTransferTaskEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActTransferTaskEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的资管复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActTransferTaskEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }/**
     * @Title:
     * @Description:   设置资管复核人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setSettlementUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActTransferTaskEnums.SETTLEMENT_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActTransferTaskEnums.SETTLEMENT_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActTransferTaskEnums.SETTLEMENT_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的资管复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActTransferTaskEnums.SETTLEMENT_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Description: 设置财务审核人
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/18 10:14
     */
    private static Map<String,Object> setTouchingUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务确认人信息
        Map<String,Object> results = new HashMap<>();
        if(StringUtils.isTrimBlank(taskVariables.get(ActTransferTaskEnums.TOUCHING_USER.getFlag()))){
            String paymentUserUnit = formPropertyMap.get(ActTransferTaskEnums.TOUCHING_USER_UNIT.getFlag());
            String paymentUserId = formPropertyMap.get(ActTransferTaskEnums.TOUCHING_USER_ID.getFlag());
            Object paymentUser = ActUtils.getNextUser(paymentUserId,paymentUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的财务审核人是: " + JSON.toJSONString(paymentUser));
            results.put(ActTransferTaskEnums.TOUCHING_USER.getFlag(),paymentUser);
        }
        return results;
    }

    /**
     * @Description: 设置总经理审核
     * @param:
     * @return:
     * @Author: wangxue
     * @Date: 2018/9/06 10:14
     */
    private static Map<String,Object> setCheckUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务确认人信息
        Map<String,Object> results = new HashMap<>();
        if(StringUtils.isTrimBlank(taskVariables.get(ActTransferTaskEnums.CHECK_USER.getFlag()))){
            String checkUserUnit = formPropertyMap.get(ActTransferTaskEnums.CHECK_USER_UNIT.getFlag());
            String checkUserId = formPropertyMap.get(ActTransferTaskEnums.CHECK_USER_ID.getFlag());
            Object checkUser = ActUtils.getNextUser(checkUserId,checkUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的总经理是: " + JSON.toJSONString(checkUser));
            results.put(ActTransferTaskEnums.CHECK_USER.getFlag(),checkUser);
        }
        return results;
    }

    /**
     * @Description: 设置财务确认付款人
     * @param:
     * @return:
     * @Author: wangxue
     * @Date: 2018/9/06 10:14
     */
    private static Map<String,Object> setLoanUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务确认人信息
        Map<String,Object> results = new HashMap<>();
        if(StringUtils.isTrimBlank(taskVariables.get(ActTransferTaskEnums.LOAN_USER.getFlag()))){
            String checkUserUnit = formPropertyMap.get(ActTransferTaskEnums.LOAN_USER_UNIT.getFlag());
            String checkUserId = formPropertyMap.get(ActTransferTaskEnums.LOAN_USER_ID.getFlag());
            Object checkUser = ActUtils.getNextUser(checkUserId,checkUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的确认付款人是: " + JSON.toJSONString(checkUser));
            results.put(ActTransferTaskEnums.LOAN_USER.getFlag(),checkUser);
        }
        return results;
    }

}
