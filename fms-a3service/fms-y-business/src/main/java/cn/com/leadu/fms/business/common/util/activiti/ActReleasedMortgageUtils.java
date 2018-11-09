package cn.com.leadu.fms.business.common.util.activiti;/**
 * Created by ningyangyang on 2018/6/3.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActReleasedMortgageEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActReleasedMortgageStsEnums;
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
 * @Title: fms
 * @Description:  解抵押工作流工具类
 * @author: ningyangyang
 * @date 2018/6/3 13:16
 */
@Component
@Slf4j
public class ActReleasedMortgageUtils {

    /**
     * 单例
     */
    private static  ActReleasedMortgageUtils actReleasedMortgageUtils = null;

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

    @Autowired
    private FormService formService;

    public ActReleasedMortgageUtils(){
        actReleasedMortgageUtils = this;
        approvalStatusNames.put(ActReleasedMortgageEnums.RELEASED_MORTGAGE_APPLY.getFlag(),ActReleasedMortgageEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActReleasedMortgageEnums.RELEASED_MORTGAGE_REVIEW.getFlag(),ActReleasedMortgageEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActReleasedMortgageEnums.RELEASED_MORTGAGE_RECEIPT.getFlag(),ActReleasedMortgageEnums.RECEIPT_STATUS.getFlag());
        approvalStatusNames.put(ActReleasedMortgageEnums.RELEASED_MORTGAGE_VOUCHER.getFlag(),ActReleasedMortgageEnums.VOUCHER_STATUS.getFlag());
        approvalStatusNames.put(ActReleasedMortgageEnums.RELEASED_MORTGAGE_FINANCE.getFlag(),ActReleasedMortgageEnums.FINANCE_STATUS.getFlag());
        approvalStatusNames.put(ActReleasedMortgageEnums.RELEASED_MORTGAGE_CONFIRM.getFlag(),ActReleasedMortgageEnums.CONFIRM_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[] {ActReleasedMortgageEnums.RELEASED_MORTGAGE_APPLY.getFlag(),
                ActReleasedMortgageEnums.RELEASED_MORTGAGE_REVIEW.getFlag(),
                ActReleasedMortgageEnums.RELEASED_MORTGAGE_VOUCHER.getFlag(),
        };
    }
    /**
     * @Title:
     * @Description: 启动解抵押流程并等待审核
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/5/17 15:22
     */
    public static ActRuTaskVo startReleasedMortgageAndWaitReview(String serviceId, String serviceType, String serviceName){
        //当前登录用户就是申请人员
        String applyUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActReleasedMortgageEnums.APPLY_USER.getFlag(),applyUser);
        variables.put(ActReleasedMortgageEnums.CONFIRM_USER.getFlag(),applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.RELEASED_MORTGAGE.getKey(),
                ActProcessInstanceKeyEnums.RELEASED_MORTGAGE.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actReleasedMortgageUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.RELEASED_MORTGAGE.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actReleasedMortgageUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables =  setReviewUser(task);
        //自动设置为完成
        actReleasedMortgageUtils.taskService.complete(task.getId(),taskVariables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 审批通过(单分支)
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actReleasedMortgageUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActReleasedMortgageStsEnums.AGREE.getFlag(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActReleasedMortgageStsEnums.AGREE.getFlag(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 审批通过到制单
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalAgreeToVoucher(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actReleasedMortgageUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActReleasedMortgageStsEnums.GOTO_VOUCHER.getFlag(),taskId,setVoucherUser(task));
        }else{
            //否则正常走下一步
            return approval(ActReleasedMortgageStsEnums.GOTO_VOUCHER.getFlag(),taskId);
        }
    }
    /**
     * @Title:
     * @Description: 审批通过到财务确认收款
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalAgreeToReceipt(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actReleasedMortgageUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActReleasedMortgageStsEnums.GOTO_RECEIPT.getFlag(),taskId,setReceiptUser(task));
        }else{
            //否则正常走下一步
            return approval(ActReleasedMortgageStsEnums.GOTO_RECEIPT.getFlag(),taskId);
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
        return approval(ActReleasedMortgageStsEnums.RETURN_SUPERIOR.getFlag(),taskId);
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

        if(task.getTaskDefinitionKey().equals(ActReleasedMortgageEnums.RELEASED_MORTGAGE_APPLY.getFlag())){
            //初审节点设置复核人
            return setReviewUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActReleasedMortgageEnums.RELEASED_MORTGAGE_VOUCHER.getFlag())){
            //设置财务人
            return setFinanceUser(task);
        }
//        else if(task.getTaskDefinitionKey().equals(ActReleasedMortgageEnums.RELEASED_MORTGAGE_RECEIPT.getFlag())){
//            //设置终审人
//            return setConfirmUser(task);
//        }
//        else if(task.getTaskDefinitionKey().equals(ActReleasedMortgageEnums.RELEASED_MORTGAGE_FINANCE.getFlag())){
//            //设置终审人
//            return setConfirmUser(task);
//        }
        else{
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
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
        actReleasedMortgageUtils.taskService.complete(taskId,variables);
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
        actReleasedMortgageUtils.taskService.complete(taskId,variables);
        ActRuTaskVo actRuTaskVo = ActUtils.getActRuTaskVoAndNextInfo(task);
        return actRuTaskVo;
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

    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actReleasedMortgageUtils.runtimeService.getVariables(executionId);
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
        if(StringUtils.isTrimBlank(taskVariables.get(ActReleasedMortgageEnums.REVIEW_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActReleasedMortgageEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActReleasedMortgageEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActReleasedMortgageEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }
    /**
     * @Title:
     * @Description:   设置制单人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setVoucherUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActReleasedMortgageEnums.VOUCHER_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActReleasedMortgageEnums.VOUCHER_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActReleasedMortgageEnums.VOUCHER_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActReleasedMortgageEnums.VOUCHER_USER.getFlag(),reviewUser);
        }
        return results;
    }
    /**
     * @Title:
     * @Description:   设置财务人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setFinanceUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果财务付款人为空，则进行放入
        String reviewUserUnit = formPropertyMap.get(ActReleasedMortgageEnums.FINANCE_USER_UNIT.getFlag());
        String reviewUserId = formPropertyMap.get(ActReleasedMortgageEnums.FINANCE_USER_ID.getFlag());
        Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
        if(StringUtils.isTrimBlank(taskVariables.get(ActReleasedMortgageEnums.FINANCE_USER.getFlag()))){
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActReleasedMortgageEnums.FINANCE_USER.getFlag(),reviewUser);
            results.put(ActReleasedMortgageEnums.NEXT_USER.getFlag(),reviewUser);
        }else {
            results.put(ActReleasedMortgageEnums.NEXT_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置财务确认收款人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setReceiptUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActReleasedMortgageEnums.RECEIPT_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActReleasedMortgageEnums.RECEIPT_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActReleasedMortgageEnums.RECEIPT_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActReleasedMortgageEnums.RECEIPT_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置解抵押确认人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setConfirmUser(Task task){
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        String confirmUserUnit = formPropertyMap.get(ActReleasedMortgageEnums.CONFIRM_USER_UNIT.getFlag());
        String confirmUserId = formPropertyMap.get(ActReleasedMortgageEnums.CONFIRM_USER_ID.getFlag());
        Object confirmUser = ActUtils.getNextUser(confirmUserId,confirmUserUnit);
        LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的终审人是: " + JSON.toJSONString(confirmUser));
        results.put(ActReleasedMortgageEnums.CONFIRM_USER.getFlag(),confirmUser);

        return results;
    }

}
