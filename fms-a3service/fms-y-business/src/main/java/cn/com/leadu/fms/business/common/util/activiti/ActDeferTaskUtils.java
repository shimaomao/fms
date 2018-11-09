package cn.com.leadu.fms.business.common.util.activiti;/**
 * Created by ningyangyang on 2018/9/5.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActDeferTaskEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActDeferTaskStatusEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActReleasedMortgageEnums;
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
 * @Description: 合同展期任务流程
 * @author: ningyangyang
 * @date 2018/9/5 13:55
 */
@Component
@Slf4j
public class ActDeferTaskUtils {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * @Fields : 单例辅助
     * @author ningyangyang
     */
    private static ActDeferTaskUtils actDeferTaskUtils = null;

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

    public ActDeferTaskUtils(){
        actDeferTaskUtils = this;
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_APPLY.getFlag(), ActDeferTaskEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_APPROVE.getFlag(), ActDeferTaskEnums.APPROVE_STATUS.getFlag());
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_REVIEW.getFlag(), ActDeferTaskEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_AUDIT.getFlag(), ActDeferTaskEnums.AUDIT_STATUS.getFlag());
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_CONT_GENERATE.getFlag(), ActDeferTaskEnums.GENERATE_STATUS.getFlag());
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_CONT_PRINT.getFlag(), ActDeferTaskEnums.PRINT_STATUS.getFlag());
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_CONT_AUDIT.getFlag(), ActDeferTaskEnums.CONT_AUDIT_STATUS.getFlag());
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_FINANCE_APPROVE.getFlag(), ActDeferTaskEnums.FINANCE_STATUS.getFlag());
        approvalStatusNames.put(ActDeferTaskEnums.DEFER_TASK_MANAGER_APPROVE.getFlag(), ActDeferTaskEnums.MANAGER_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[]{
                ActDeferTaskEnums.DEFER_TASK_APPLY.getFlag(),
                ActDeferTaskEnums.DEFER_TASK_APPROVE.getFlag(),
                ActDeferTaskEnums.DEFER_TASK_REVIEW.getFlag(),
                ActDeferTaskEnums.DEFER_TASK_AUDIT.getFlag(),
                ActDeferTaskEnums.DEFER_TASK_CONT_GENERATE.getFlag(),
                ActDeferTaskEnums.DEFER_TASK_CONT_PRINT.getFlag(),
                ActDeferTaskEnums.DEFER_TASK_CONT_AUDIT.getFlag(),
                ActDeferTaskEnums.DEFER_TASK_FINANCE_APPROVE.getFlag()
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
    public static ActRuTaskVo startDeferTask(String serviceId, String serviceName) {
        //当前登录用户就是保单上传人员
        String uploadRegisterUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActDeferTaskEnums.APPLY_USER.getFlag(), uploadRegisterUser);
        variables.put(ActDeferTaskEnums.CONT_GENERATOR.getFlag(), uploadRegisterUser);
        variables.put(ActDeferTaskEnums.CONT_PRINTER.getFlag(), uploadRegisterUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.DEFER_TASK.getKey(),
                ActProcessInstanceKeyEnums.DEFER_TASK.getDesc(), "", serviceName, serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actDeferTaskUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.DEFER_TASK.getKey(), serviceId, variables);
        //第一条任务是保单上传人的
        Task task = actDeferTaskUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //获取风控信息下一节点审批人
        Map<String, Object> taskVariables = setApproveUser(task);
        //自动设置为完成
        actDeferTaskUtils.taskService.complete(task.getId(), taskVariables);
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
        Task task = actDeferTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActDeferTaskStatusEnums.AGREE.getStatus(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActDeferTaskStatusEnums.AGREE.getStatus(),taskId);
        }
    }
    /**
     * @Title:
     * @Description: 审批通过(直接结束)
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/5  14:11
     */
    public static ActRuTaskVo approvalAgreeToEnd(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actDeferTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");

            //否则正常走下一步
            return approval(ActDeferTaskStatusEnums.AGREE.getStatus(),taskId);

    }

    /**
     * @Title:
     * @Description: 审批通过到财务审核
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/5  14:11
     */
    public static ActRuTaskVo approvalAgreeToFinance(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actDeferTaskUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");

            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActDeferTaskStatusEnums.AGREE_FINANCE.getStatus(),taskId,setFinanceApprove(task));

    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/5  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActDeferTaskStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 审批拒绝
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/10/9  14:11
     */
    public static ActRuTaskVo approvalToRefuse(String taskId){
        //否则正常走下一步
        return approval(ActDeferTaskStatusEnums.REFUSE.getStatus(),taskId);

    }

    /**
     * @Title:
     * @Description: 审批取消
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/1011  14:11
     */
    public static ActRuTaskVo applyCancel(String taskNo){
        if(StringUtils.isTrimBlank(taskNo))
            throw new FmsServiceException("任务号不能为空");
        List<Task> tasks = actDeferTaskUtils.taskService.createTaskQuery().processInstanceBusinessKey(taskNo)
                .processDefinitionKey(ActProcessInstanceKeyEnums.DEFER_TASK.getKey()).list();
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
        return approval(ActDeferTaskStatusEnums.CANCEL.getStatus(), taskId);
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/5 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actDeferTaskUtils.taskService.complete(taskId,variables);
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
     * @date 2018/9/5 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actDeferTaskUtils.taskService.complete(taskId,variables);
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
     * @date 2018/9/5  15:35
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
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setUser(Task task){

        if(task.getTaskDefinitionKey().equals(ActDeferTaskEnums.DEFER_TASK_APPLY.getFlag())){
            //申请节点设置复核人
            return setApproveUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActDeferTaskEnums.DEFER_TASK_APPROVE.getFlag())){
            //风控初审设置复审人
            return setReviewUser(task);
        }
        else if(task.getTaskDefinitionKey().equals(ActDeferTaskEnums.DEFER_TASK_REVIEW.getFlag())){
            //风控复审设置业务副总
            return setAuditUser(task);
        }
        else if(task.getTaskDefinitionKey().equals(ActDeferTaskEnums.DEFER_TASK_AUDIT.getFlag())){
            //设置合同生成节点人
            return setContGenerator(task);
        }
        else if(task.getTaskDefinitionKey().equals(ActDeferTaskEnums.DEFER_TASK_CONT_GENERATE.getFlag())){
            //设置合同打印节点人
            return setContPrinter(task);
        }
        else if(task.getTaskDefinitionKey().equals(ActDeferTaskEnums.DEFER_TASK_CONT_PRINT.getFlag())){
            //设置合同审核节点人
            return setContAuditor(task);
        }else if(task.getTaskDefinitionKey().equals(ActDeferTaskEnums.DEFER_TASK_FINANCE_APPROVE.getFlag())){
            //设置总经理节点人
            return setManagerApprove(task);
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
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setApproveUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActDeferTaskEnums.APPROVE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActDeferTaskEnums.APPROVE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDeferTaskEnums.APPROVE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的风控初审人是: " + JSON.toJSONString(reviewUser));
            results.put(ActDeferTaskEnums.APPROVE_USER.getFlag(),reviewUser);
        }
        return results;
    }
    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actDeferTaskUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }
    /**
     * @Title:
     * @Description:   设置风控复审人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setReviewUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActDeferTaskEnums.REVIEW_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActDeferTaskEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDeferTaskEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的风控复审人是: " + JSON.toJSONString(reviewUser));
            results.put(ActDeferTaskEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置业务副总
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setAuditUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActDeferTaskEnums.AUDIT_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActDeferTaskEnums.AUDIT_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDeferTaskEnums.AUDIT_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的业务副总是: " + JSON.toJSONString(reviewUser));
            results.put(ActDeferTaskEnums.AUDIT_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置合同生成节点用户
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setContGenerator(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActDeferTaskEnums.CONT_GENERATOR.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActDeferTaskEnums.CONT_GENERATOR_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDeferTaskEnums.CONT_GENERATOR_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的合同生成用户是: " + JSON.toJSONString(reviewUser));
            results.put(ActDeferTaskEnums.CONT_GENERATOR.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置合同打印节点用户
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setContPrinter(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActDeferTaskEnums.CONT_PRINTER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActDeferTaskEnums.CONT_PRINTER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDeferTaskEnums.CONT_PRINTER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的合同打印用户是: " + JSON.toJSONString(reviewUser));
            results.put(ActDeferTaskEnums.CONT_PRINTER.getFlag(),reviewUser);
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
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setContAuditor(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActDeferTaskEnums.CONT_AUDITOR.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActDeferTaskEnums.CONT_AUDITOR_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDeferTaskEnums.CONT_AUDITOR_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的合同审核用户是: " + JSON.toJSONString(reviewUser));
            results.put(ActDeferTaskEnums.CONT_AUDITOR.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置财务审核节点用户
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setFinanceApprove(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果财务复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActDeferTaskEnums.FINANCE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActDeferTaskEnums.FINANCE_APPROVE_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDeferTaskEnums.FINANCE_APPROVE_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的财务审核用户是: " + JSON.toJSONString(reviewUser));
            results.put(ActDeferTaskEnums.FINANCE_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置财务审核节点用户
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/05 02:53:21
     */
    private static Map<String,Object> setManagerApprove(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果总经理复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActDeferTaskEnums.MANAGER_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActDeferTaskEnums.MANAGER_APPROVE_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDeferTaskEnums.MANAGER_APPROVE_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的总经理是: " + JSON.toJSONString(reviewUser));
            results.put(ActDeferTaskEnums.MANAGER_USER.getFlag(),reviewUser);
        }
        return results;
    }



}
