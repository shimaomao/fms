package cn.com.leadu.fms.business.common.util.activiti;/**
 * Created by yyq on 2018/6/5.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationStatusEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActPilferMonthlyEnums;
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
import java.util.Map;

/**
 * @program: fms
 * @description: 盗抢险月结审批流
 * @author: yangyiquan
 * @create: 2018-06-05 20:45
 **/
@Component
@Slf4j
public class ActPilferMonthlyUtils {
    /**
     * 单例
     */
    private static ActPilferMonthlyUtils actPilferMonthlyUtils = null;

    /**
     * @Fields  : 每个流程节点的审批（通过还是退回）状态名称
     * @author yangyiquan
     */
    private static Map<String,String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields  : 需要为下个节点设置用户的节点
     * @author yangyiquan
     */
    private static String [] userDefKeys = null;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    public ActPilferMonthlyUtils(){
        actPilferMonthlyUtils = this;
        approvalStatusNames.put(ActPilferMonthlyEnums.PILFER_MONTHLY_APPLY.getFlag(),ActPilferMonthlyEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActPilferMonthlyEnums.PILFER_MONTHLY_REVIEW.getFlag(),ActPilferMonthlyEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActPilferMonthlyEnums.PILFER_MONTHLY_VOUCHER.getFlag(),ActPilferMonthlyEnums.VOUCHER_STATUS.getFlag());
        approvalStatusNames.put(ActPilferMonthlyEnums.PILFER_MONTHLY_SETTLEMENT.getFlag(),ActPilferMonthlyEnums.SETTLEMENT_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[] {ActPilferMonthlyEnums.PILFER_MONTHLY_APPLY.getFlag(),
                ActPilferMonthlyEnums.PILFER_MONTHLY_REVIEW.getFlag(),
                ActPilferMonthlyEnums.PILFER_MONTHLY_VOUCHER.getFlag()};
    }

    /**
     * @Description: 启动盗抢险月结申请
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:21
     */
    public static ActRuTaskVo startMonthlyAndSubmit(String serviceId, String serviceType, String serviceName){
        //当前登录用户就是申请人员
        String applyUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActPilferMonthlyEnums.APPLY_USER.getFlag(),applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.PILFER_MONTHLY.getKey(),
                ActProcessInstanceKeyEnums.PILFER_MONTHLY.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actPilferMonthlyUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.PILFER_MONTHLY.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actPilferMonthlyUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables = setReviewUser(task);
        //自动设置为完成
        actPilferMonthlyUtils.taskService.complete(task.getId(),taskVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Description: 审批通过
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:41
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,是否需要设置下级审批人
        Task task = actPilferMonthlyUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActContGenerationStatusEnums.AGREE.getStatus(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActContGenerationStatusEnums.AGREE.getStatus(),taskId);
        }
    }

    /**
     * @Description: 退回上一级
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 15:06
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActContGenerationStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
    }

    /**
     * @Description: 审批
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:43
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actPilferMonthlyUtils.taskService.complete(taskId,variables);
        ActRuTaskVo actRuTaskVo =  ActUtils.getActRuTaskVoAndNextInfo(task);
        return actRuTaskVo;
    }
    /**
     * @Description: 审批
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:44
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");

        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actPilferMonthlyUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Description: 获取当前节点对应的状态参数名
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:46
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
     * @Description: 设置相应节点的审批人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:50
     */
    private static Map<String,Object> setUser(Task task){
        if(task.getTaskDefinitionKey().equals(ActPilferMonthlyEnums.PILFER_MONTHLY_APPLY.getFlag())){
            //申请节点设置复核人
            return setReviewUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActPilferMonthlyEnums.PILFER_MONTHLY_REVIEW.getFlag())){
            //复核节点设置财务制单人
            return setVoucherUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActPilferMonthlyEnums.PILFER_MONTHLY_VOUCHER.getFlag())){
            //制单节点设置付款人
            return setSettlementUser(task);
        }
        else{
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }

    /**
     * @Description: 设置复核人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:28
     */
    private static Map<String,Object> setReviewUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String,Object> results = new HashMap<>();
        //如果申请审批人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActPilferMonthlyEnums.REVIEW_USER.getFlag()))){
            String approvalUserId = formPropertyMap.get(ActPilferMonthlyEnums.REVIEW_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActPilferMonthlyEnums.REVIEW_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUser(approvalUserId,approvalUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的复核审批人是: " + JSON.toJSONString(approvalUser));
            results.put(ActPilferMonthlyEnums.REVIEW_USER.getFlag(),approvalUser);
        }
        return results;
    }

    /**
     * @Description: 设置制单人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:56
     */
    private static Map<String,Object> setVoucherUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActPilferMonthlyEnums.VOUCHER_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActPilferMonthlyEnums.VOUCHER_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActPilferMonthlyEnums.VOUCHER_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批制单人是: " + JSON.toJSONString(reviewUser));
            results.put(ActPilferMonthlyEnums.VOUCHER_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Description: 设置付款人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:58
     */
    private static Map<String,Object> setSettlementUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActPilferMonthlyEnums.SETTLEMENT_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActPilferMonthlyEnums.SETTLEMENT_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActPilferMonthlyEnums.SETTLEMENT_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批付款人是: " + JSON.toJSONString(reviewUser));
            results.put(ActPilferMonthlyEnums.SETTLEMENT_USER.getFlag(),reviewUser);
            results.put(ActPilferMonthlyEnums.NEXT_USER.getFlag(),reviewUser);
        }else{
            results.put(ActPilferMonthlyEnums.NEXT_USER.getFlag(),taskVariables.get(ActPilferMonthlyEnums.SETTLEMENT_USER.getFlag()));
        }
        return results;
    }




    /**
     * @Description: 获取流程节点参数
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 14:32
     */
    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actPilferMonthlyUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }
}
