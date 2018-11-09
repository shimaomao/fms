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
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ningyangyang on 2018/5/21.
 */
@Component
@Slf4j
public class ActRenewalRegisterUtils {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * @Fields : 单例辅助
     * @author ningyangyang
     */
    private static ActRenewalRegisterUtils actRenewalRegisterUtils = null;

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

    public ActRenewalRegisterUtils() {
        actRenewalRegisterUtils = this;
        approvalStatusNames.put(ActRenewalRegisterEnums.MANAGEMENT_CONFIRM.getFlag(), ActRenewalRegisterEnums.CONFIRM_STATUS.getFlag());
        approvalStatusNames.put(ActRenewalRegisterEnums.FINANCE_RECEIPT.getFlag(), ActRenewalRegisterEnums.RECEIPT_STATUS.getFlag());
        approvalStatusNames.put(ActRenewalRegisterEnums.MANAGEMENT_WITHDRAW.getFlag(), ActRenewalRegisterEnums.WITHDRAW_STATUS.getFlag());
        approvalStatusNames.put(ActRenewalRegisterEnums.MANAGEMENT_REVIEW.getFlag(), ActRenewalRegisterEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActRenewalRegisterEnums.FINANCE_VOUCHER.getFlag(), ActRenewalRegisterEnums.VOUCHER_STATUS.getFlag());
        approvalStatusNames.put(ActRenewalRegisterEnums.FINANCE_PAYMENT.getFlag(), ActRenewalRegisterEnums.PAYMENT_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[]{
                ActRenewalRegisterEnums.MANAGEMENT_CONFIRM.getFlag(),
                ActRenewalRegisterEnums.FINANCE_RECEIPT.getFlag(),
                ActRenewalRegisterEnums.MANAGEMENT_WITHDRAW.getFlag(),
                ActRenewalRegisterEnums.MANAGEMENT_REVIEW.getFlag(),
                ActRenewalRegisterEnums.FINANCE_VOUCHER.getFlag(),
        };
    }

    /**
     * @return ActRuTaskVo
     * @throws
     * @Title:
     * @Description: 启动续保流程
     * @param: serviceId 业务id
     * @param: serviceType 业务类型
     * @param: serviceName 业务名称
     * @author ningyangyang
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo startRenewalRegister(String serviceId, String serviceType, String serviceName) {
        //当前登录用户就是保单上传人员
        String uploadRegisterUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActRenewalRegisterEnums.MANAGEMENT_CONFIRM_USER.getFlag(), uploadRegisterUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.RENEWAL_REGISTER.getKey(),
                ActProcessInstanceKeyEnums.RENEWAL_REGISTER.getDesc(), serviceType, serviceName, serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actRenewalRegisterUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.RENEWAL_REGISTER.getKey(), serviceId, variables);
        //第一条任务是保单上传人的
        Task task = actRenewalRegisterUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到续保审核人的信息,并设置续保审核人
        //Map<String, Object> taskVariables = setRenewalRegisterUser(task);
        //自动设置为完成
        //actRenewalRegisterUtils.taskService.complete(task.getId(), taskVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 续保审核通过
     * @return ActRuTaskVo
     * @throws
     * @param: taskId 任务Id
     * @author ningyangyang
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actRenewalRegisterUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActRenewalRegisterStatusEnums.AGREE.getFlag(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActRenewalRegisterStatusEnums.AGREE.getFlag(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 资管确认类型到结束
     * @return ActRuTaskVo
     * @throws
     * @param: taskId 任务Id
     * @author ningyangyang
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo approvalAgreeToEnd(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actRenewalRegisterUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        return approval(ActRenewalRegisterStatusEnums.COMPLETE.getFlag(),taskId);
    }
    /**
     * @Title:
     * @Description: 资管确认类型到确认收款
     * @return ActRuTaskVo
     * @throws
     * @param: taskId 任务Id
     * @author ningyangyang
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo approvalAgreeToReceipt(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actRenewalRegisterUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActRenewalRegisterStatusEnums.TO_RECEIPT.getFlag(),taskId,setReceiptUser(task));
        }else{
            //否则正常走下一步
            return approval(ActRenewalRegisterStatusEnums.TO_RECEIPT.getFlag(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 资管确认类型到资管请款
     * @return ActRuTaskVo
     * @throws
     * @param: taskId 任务Id
     * @author ningyangyang
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo approvalAgreeToWithdraw(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actRenewalRegisterUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActRenewalRegisterStatusEnums.TO_WITHDRAW.getFlag(),taskId,setWithdrawUser(task));
        }else{
            //否则正常走下一步
            return approval(ActRenewalRegisterStatusEnums.TO_WITHDRAW.getFlag(),taskId);
        }
    }



    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActRenewalRegisterStatusEnums.RETURN_SUPERIOR.getFlag(), taskId);
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
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actRenewalRegisterUtils.taskService.complete(taskId,variables);
        ActRuTaskVo actRuTaskVo = ActUtils.getActRuTaskVoAndNextInfo(task);
        return actRuTaskVo;
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
     * @date 2018/4/16 15:35
     */
    public static ActRuTaskVo approval(Integer status, String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actRenewalRegisterUtils.taskService.complete(taskId,variables);
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
     * @Description:   设置相应节点的审批人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setUser(Task task){

        if(task.getTaskDefinitionKey().equals(ActRenewalRegisterEnums.FINANCE_RECEIPT.getFlag())){
            //设置请款人
            return setWithdrawUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActRenewalRegisterEnums.MANAGEMENT_WITHDRAW.getFlag())){
            //设置资管复核人
            return setReviewUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActRenewalRegisterEnums.MANAGEMENT_REVIEW.getFlag())){
            //设置财务制单人
            return setVoucherUser(task);
        } else if(task.getTaskDefinitionKey().equals(ActRenewalRegisterEnums.FINANCE_VOUCHER.getFlag())){
            //设置财务付款人
            return setPaymentUser(task);
        }else {
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }

    /**
     * @Title:
     * @Description:   设置请款人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setWithdrawUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果财务制单人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActRenewalRegisterEnums.MANAGEMENT_WITHDRAW_USER.getFlag()))){
            String managementWithdrawUserUnit = formPropertyMap.get(ActRenewalRegisterEnums.MANAGEMENT_WITHDRAW_USER_UNIT.getFlag());
            String managementWithdrawUserId = formPropertyMap.get(ActRenewalRegisterEnums.MANAGEMENT_WITHDRAW_USER_ID.getFlag());
            Object managementWithdrawUser = ActUtils.getNextUser(managementWithdrawUserId, managementWithdrawUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的财务制单人是: " + JSON.toJSONString(managementWithdrawUser));
            results.put(ActRenewalRegisterEnums.MANAGEMENT_WITHDRAW_USER.getFlag(), managementWithdrawUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置资管复核人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setReviewUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果财务制单人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActRenewalRegisterEnums.MANAGEMENT_REVIEW_USER.getFlag()))){
            String financePaymentUserUnit = formPropertyMap.get(ActRenewalRegisterEnums.MANAGEMENT_REVIEW_USER_UNIT.getFlag());
            String financePaymentUserId = formPropertyMap.get(ActRenewalRegisterEnums.MANAGEMENT_REVIEW_USER_ID.getFlag());
            Object financePaymentUser = ActUtils.getNextUser(financePaymentUserId, financePaymentUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的财务付款人是: " + JSON.toJSONString(financePaymentUser));
            results.put(ActRenewalRegisterEnums.MANAGEMENT_REVIEW_USER.getFlag(), financePaymentUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description: 设置财务确认收款人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setReceiptUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审核人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审核人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审核人信息
        Map<String, Object> results = new HashMap<>();
        //如果续保审核人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActRenewalRegisterEnums.FINANCE_RECEIPT_USER.getFlag()))) {
            String approvalUserId = formPropertyMap.get(ActRenewalRegisterEnums.FINANCE_RECEIPT_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActRenewalRegisterEnums.FINANCE_RECEIPT_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUser(approvalUserId, approvalUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的续保审核人是: " + JSON.toJSONString(approvalUser));
            results.put(ActRenewalRegisterEnums.FINANCE_RECEIPT_USER.getFlag(), approvalUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description: 设置财务制单人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setVoucherUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审核人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审核人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审核人信息
        Map<String, Object> results = new HashMap<>();
        //如果续保审核人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActRenewalRegisterEnums.FINANCE_VOUCHER_USER.getFlag()))) {
            String approvalUserId = formPropertyMap.get(ActRenewalRegisterEnums.FINANCE_VOUCHER_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActRenewalRegisterEnums.FINANCE_VOUCHER_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUser(approvalUserId, approvalUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的续保审核人是: " + JSON.toJSONString(approvalUser));
            results.put(ActRenewalRegisterEnums.FINANCE_VOUCHER_USER.getFlag(), approvalUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description: 设置财务付款人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setPaymentUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审核人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审核人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审核人信息
        Map<String, Object> results = new HashMap<>();
        //如果续保审核人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActRenewalRegisterEnums.FINANCE_PAYMENT_USER.getFlag()))) {
            String approvalUserId = formPropertyMap.get(ActRenewalRegisterEnums.FINANCE_PAYMENT_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActRenewalRegisterEnums.FINANCE_PAYMENT_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUser(approvalUserId, approvalUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的续保审核人是: " + JSON.toJSONString(approvalUser));
            results.put(ActRenewalRegisterEnums.FINANCE_PAYMENT_USER.getFlag(), approvalUser);
            results.put(ActRenewalRegisterEnums.NEXT_USER.getFlag(),approvalUser);
        }
        return results;
    }

    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actRenewalRegisterUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }
}
