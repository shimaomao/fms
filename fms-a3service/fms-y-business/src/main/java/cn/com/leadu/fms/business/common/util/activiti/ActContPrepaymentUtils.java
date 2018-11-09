package cn.com.leadu.fms.business.common.util.activiti;/**
 * Created by yyq on 2018/5/17.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContPrepaymentEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContPrepaymentStatusEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
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
import java.util.List;
import java.util.Map;

/**
 * @program: fms
 * @description: 提前还款工作流工具类
 * @author: yangyiquan
 * @create: 2018-05-17 14:30
 **/
@Component
@Slf4j
public class ActContPrepaymentUtils {
    /**
     * 单例
     */
    private static ActContPrepaymentUtils actContPrepaymentUtils = null;

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

    public ActContPrepaymentUtils(){
        actContPrepaymentUtils = this;
        approvalStatusNames.put(ActContPrepaymentEnums.CONT_PREPAYMENT_APPLY.getFlag(),ActContPrepaymentEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActContPrepaymentEnums.CONT_PREPAYMENT_APPROVAL.getFlag(),ActContPrepaymentEnums.APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(ActContPrepaymentEnums.CONT_PREPAYMENT_REVIEW.getFlag(),ActContPrepaymentEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActContPrepaymentEnums.CONT_PREPAYMENT_CONFIRM.getFlag(),ActContPrepaymentEnums.CONFIRM_STATUS.getFlag());
        approvalStatusNames.put(ActContPrepaymentEnums.CONT_PREPAYMENT_PAYMENT.getFlag(),ActContPrepaymentEnums.PAYMENT_STATUS.getFlag());
        approvalStatusNames.put(ActContPrepaymentEnums.CONT_PREPAYMENT_CHECK.getFlag(),ActContPrepaymentEnums.CHECK_STATUS.getFlag());
        approvalStatusNames.put(ActContPrepaymentEnums.CONT_PREPAYMENT_EXPORT.getFlag(),ActContPrepaymentEnums.EXPORT_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[] {ActContPrepaymentEnums.CONT_PREPAYMENT_APPLY.getFlag(),
                ActContPrepaymentEnums.CONT_PREPAYMENT_APPROVAL.getFlag(),
                ActContPrepaymentEnums.CONT_PREPAYMENT_REVIEW.getFlag(),
                ActContPrepaymentEnums.CONT_PREPAYMENT_PAYMENT.getFlag(),
        };
    }

    /**
     * @Title:
     * @Description: 启动提前还款申请
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018/5/17 15:22
     */
    public static ActRuTaskVo startContPrepaymentAndSubmit(String serviceId, String serviceType, String serviceName){
        //当前登录用户就是申请人员
        String applyUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActContPrepaymentEnums.APPLY_USER.getFlag(),applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.CONT_PREPAYMENT.getKey(),
                ActProcessInstanceKeyEnums.CONT_PREPAYMENT.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actContPrepaymentUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.CONT_PREPAYMENT.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actContPrepaymentUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables = setApprovalUser(task);
        //自动设置为完成
        actContPrepaymentUtils.taskService.complete(task.getId(),taskVariables);
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
        Task task = actContPrepaymentUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActContPrepaymentStatusEnums.AGREE.getStatus(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActContPrepaymentStatusEnums.AGREE.getStatus(),taskId);
        }
    }

    /** 
    * @Description: 跳过下一级,直接财务确认
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/21 11:27
    */ 
    public static ActRuTaskVo skipAgreeConfirm(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actContPrepaymentUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActContPrepaymentStatusEnums.SKIP.getStatus(),taskId,setConfirmUser(task));
        }else{
            //否则正常走下一步
            return approval(ActContPrepaymentStatusEnums.SKIP.getStatus(),taskId);
        }
    }

    /**
    * @Description: 确认付款或确认收款到车辆出库
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/6/21 11:27
    */
    public static ActRuTaskVo approveAgreeExport(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actContPrepaymentUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        //如果是需要设置审批人的节点则进行设置审批人
        return approval(ActContPrepaymentStatusEnums.VEH_EXPORT.getStatus(),taskId,setExportUser(task));
    }

    /**
     * @Description: 初审到财务审核
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/6/21 11:27
     */
    public static ActRuTaskVo AgreePayment(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actContPrepaymentUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActContPrepaymentStatusEnums.PAYMENT.getStatus(),taskId,setPaymentUser(task));
        }else{
            //否则正常走下一步
            return approval(ActContPrepaymentStatusEnums.PAYMENT.getStatus(),taskId);
        }
    }

    /**
     * @Description: 财务审核到总经理审核
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/6/21 11:27
     */
    public static ActRuTaskVo AgreeCheck(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actContPrepaymentUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActContPrepaymentStatusEnums.AGREE.getStatus(),taskId,setCheckUser(task));
        }else{
            //否则正常走下一步
            return approval(ActContPrepaymentStatusEnums.AGREE.getStatus(),taskId);
        }
    }

    /**
     * @Title:
     * @Description:   设置相应节点的审批人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setUser(Task task){

        if(task.getTaskDefinitionKey().equals(ActContPrepaymentEnums.CONT_PREPAYMENT_APPROVAL.getFlag())){
            //初审节点设置复核人
            return setReviewUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContPrepaymentEnums.CONT_PREPAYMENT_REVIEW.getFlag())){
            //复审节点设置财务确认人
            return setConfirmUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContPrepaymentEnums.CONT_PREPAYMENT_APPLY.getFlag())){
            //提交节点设置初审人
            return setApprovalUser(task);
        }
        else{
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
        return approval(ActContPrepaymentStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 退回到初审
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/8/23  14:11
     */
    public static ActRuTaskVo approvalBackApproval(String taskId){
        return approval(ActContPrepaymentStatusEnums.BACK_APPROVAL.getStatus(),taskId);
    }
    /**
     * @Title:
     * @Description: 退回到复审
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/8/23  14:11
     */
    public static ActRuTaskVo approvalBackReview(String taskId){
        return approval(ActContPrepaymentStatusEnums.BACK_REVIEW.getStatus(),taskId);
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
        actContPrepaymentUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
    * @Description: 结束提前还款流程
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/25 19:43
    */
    public static ActRuTaskVo overInstances(String serviceId,String remark){
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务id不能为空");
        List<Task> tasks = actContPrepaymentUtils.taskService.createTaskQuery().processInstanceBusinessKey(serviceId)
                .processDefinitionKey(ActProcessInstanceKeyEnums.CONT_PREPAYMENT.getKey()).list();
        if(ArrayUtils.isNotNullAndLengthNotZero(tasks) && tasks.size() > 1){
            throw new FmsServiceException("当前任务数量过多");
        }else if(ArrayUtils.isNullOrLengthZero(tasks))
            throw new FmsServiceException("当前不存在任务节点");
        else{
            actContPrepaymentUtils.runtimeService.deleteProcessInstance(tasks.get(0).getProcessInstanceId(), remark);
            return ActUtils.getActRuTaskVoAndNextInfo(tasks.get(0));
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
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actContPrepaymentUtils.taskService.complete(taskId,variables);
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
        if(StringUtils.isTrimBlank(taskVariables.get(ActContPrepaymentEnums.APPROVAL_USER.getFlag()))){
            String approvalUserId = formPropertyMap.get(ActContPrepaymentEnums.APPROVAL_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActContPrepaymentEnums.APPROVAL_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUser(approvalUserId,approvalUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(approvalUser));
            results.put(ActContPrepaymentEnums.APPROVAL_USER.getFlag(),approvalUser);
        }
        return results;
    }

    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actContPrepaymentUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }

    /**
     * @Title:
     * @Description:   设置复核人
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
        if(StringUtils.isTrimBlank(taskVariables.get(ActContPrepaymentEnums.REVIEW_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContPrepaymentEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContPrepaymentEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContPrepaymentEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
    * @Description: 设置财务确认人,这一步没有退回
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/5/18 10:14
    */
    private static Map<String,Object> setConfirmUser(Task task){
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务确认人信息
        Map<String,Object> results = new HashMap<>();
        String confirmUserUnit = formPropertyMap.get(ActContPrepaymentEnums.CONFIRM_USER_UNIT.getFlag());
        String confirmUserId = formPropertyMap.get(ActContPrepaymentEnums.CONFIRM_USER_ID.getFlag());
        Object confirmUser = ActUtils.getNextUser(confirmUserId,confirmUserUnit);
        LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(confirmUser));
        results.put(ActContPrepaymentEnums.CONFIRM_USER.getFlag(),confirmUser);
        return results;
    }

    /**
     * @Description: 设置财务审核人
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/18 10:14
     */
    private static Map<String,Object> setPaymentUser(Task task){
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务确认人信息
        Map<String,Object> results = new HashMap<>();
        String paymentUserUnit = formPropertyMap.get(ActContPrepaymentEnums.PAYMENT_USER_UNIT.getFlag());
        String paymentUserId = formPropertyMap.get(ActContPrepaymentEnums.PAYMENT_USER_ID.getFlag());
        Object paymentUser = ActUtils.getNextUser(paymentUserId,paymentUserUnit);
        LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的财务审核人是: " + JSON.toJSONString(paymentUser));
        results.put(ActContPrepaymentEnums.PAYMENT_USER.getFlag(),paymentUser);
        return results;
    }

    /**
     * @Description: 设置总经理
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/18 10:14
     */
    private static Map<String,Object> setCheckUser(Task task){
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务确认人信息
        Map<String,Object> results = new HashMap<>();
        String checkUserUnit = formPropertyMap.get(ActContPrepaymentEnums.CHECK_USER_UNIT.getFlag());
        String checkUserId = formPropertyMap.get(ActContPrepaymentEnums.CHECK_USER_ID.getFlag());
        Object checkUser = ActUtils.getNextUser(checkUserId,checkUserUnit);
        LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的总经理是: " + JSON.toJSONString(checkUser));
        results.put(ActContPrepaymentEnums.CHECK_USER.getFlag(),checkUser);
        return results;
    }

    /**
     * @Description: 设置总经理
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/18 10:14
     */
    private static Map<String,Object> setExportUser(Task task){
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务确认人信息
        Map<String,Object> results = new HashMap<>();
        String exportUserUnit = formPropertyMap.get(ActContPrepaymentEnums.EXPORT_USER_UNIT.getFlag());
        String exportUserId = formPropertyMap.get(ActContPrepaymentEnums.EXPORT_USER_ID.getFlag());
        Object exportUser = ActUtils.getNextUser(exportUserId,exportUserUnit);
        LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的车辆出库人是: " + JSON.toJSONString(exportUser));
        results.put(ActContPrepaymentEnums.EXPORT_USER.getFlag(), exportUser);
        return results;
    }

}
