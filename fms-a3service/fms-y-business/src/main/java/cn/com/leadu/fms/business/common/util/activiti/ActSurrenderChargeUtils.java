package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActSurrenderChargeEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActSurrenderChargeStatusEnums;
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
 * Created by leadu on 2018/10/26.
 */
@Component
@Slf4j
public class ActSurrenderChargeUtils {

    /**
     * 单例
     */
    private static ActSurrenderChargeUtils actSurrenderChargeUtils = null;

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

    public ActSurrenderChargeUtils(){
        actSurrenderChargeUtils = this;
        approvalStatusNames.put(ActSurrenderChargeEnums.SURRENDER_CHARGE_APPLY.getFlag(), ActSurrenderChargeEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActSurrenderChargeEnums.SURRENDER_CHARGE_APPROVE.getFlag(), ActSurrenderChargeEnums.APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(ActSurrenderChargeEnums.SURRENDER_CHARGE_RECEIVABLES.getFlag(), ActSurrenderChargeEnums.RECEIVABLES_STATUS.getFlag());
        approvalStatusNames.put(ActSurrenderChargeEnums.SURRENDER_CHARGE_REVIEW.getFlag(), ActSurrenderChargeEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActSurrenderChargeEnums.SURRENDER_CHARGE_CONFIRM.getFlag(), ActSurrenderChargeEnums.LOAN_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[] {ActSurrenderChargeEnums.SURRENDER_CHARGE_APPLY.getFlag(),
                ActSurrenderChargeEnums.SURRENDER_CHARGE_APPROVE.getFlag(),
                ActSurrenderChargeEnums.SURRENDER_CHARGE_RECEIVABLES.getFlag(),
                ActSurrenderChargeEnums.SURRENDER_CHARGE_REVIEW.getFlag()
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
     * @author fangshaofeng
     * @date 2018/10/26 15:22
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
        variables.put(ActSurrenderChargeEnums.APPLY_USER.getFlag(),applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.SURRENDER_CHARGE.getKey(),
                ActProcessInstanceKeyEnums.SURRENDER_CHARGE.getDesc(),"",serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actSurrenderChargeUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.SURRENDER_CHARGE.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actSurrenderChargeUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        // 提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables = setApprovalUser(task);
        //自动设置为完成
        actSurrenderChargeUtils.taskService.complete(task.getId(),taskVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 审批通过
     * @param:  taskId
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018/10/26 15:22
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actSurrenderChargeUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActSurrenderChargeStatusEnums.AGREE.getStatus(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActSurrenderChargeStatusEnums.AGREE.getStatus(),taskId);
        }
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
        if (ActSurrenderChargeEnums.SURRENDER_CHARGE_APPLY.getFlag().equals(task.getTaskDefinitionKey())) {
            // 申请节点，设置审核人
            return setApprovalUser(task);
        } else if(ActSurrenderChargeEnums.SURRENDER_CHARGE_APPROVE.getFlag().equals(task.getTaskDefinitionKey())){
            //设置财务收款人
            return setReceivablesUser(task);
        } else if(ActSurrenderChargeEnums.SURRENDER_CHARGE_RECEIVABLES.getFlag().equals(task.getTaskDefinitionKey())){
            //费用结算节点，设置资管复审人
            return setReviewUser(task);
        } else if(ActSurrenderChargeEnums.SURRENDER_CHARGE_REVIEW.getFlag().equals(task.getTaskDefinitionKey())){
            // 资管复审节点，设置财务审核人
            return setConfirmUser(task);
        }  else{
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018/10/26  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActSurrenderChargeStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018/10/26 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);

        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actSurrenderChargeUtils.taskService.complete(taskId,variables);
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
     * @author fangshaofeng
     * @date 2018/10/26 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actSurrenderChargeUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 获取当前节点对应的状态参数
     * @param: taskDefinitionKey
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018/10/26 15:35
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
     * @author fangshaofeng
      * @date 2018/10/26 15:35
     */
    private static Map<String,Object> setApprovalUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String,Object> results = new HashMap<>();
        //如果申请审批人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActSurrenderChargeEnums.APPROVAL_USER.getFlag()))){
            String approvalUserId = formPropertyMap.get(ActSurrenderChargeEnums.APPROVAL_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActSurrenderChargeEnums.APPROVAL_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUser(approvalUserId,approvalUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(approvalUser));
            results.put(ActSurrenderChargeEnums.APPROVAL_USER.getFlag(),approvalUser);
        }
        return results;
    }

    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actSurrenderChargeUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }

    /**
     * @Title:
     * @Description:   设置资管复核人
     * @param task 任务
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018/10/26 14:53:21
     */
    private static Map<String,Object> setReviewUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActSurrenderChargeEnums.REVIEW_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActSurrenderChargeEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActSurrenderChargeEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的资管复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActSurrenderChargeEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }/**
     * @Title:
     * @Description:   设置财务收款人
     * @param task 任务
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018/10/26 14:53:21
     */
    private static Map<String,Object> setReceivablesUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActSurrenderChargeEnums.RECEIVABLES_USER.getFlag()))){
            String receivablesUserUnit = formPropertyMap.get(ActSurrenderChargeEnums.RECEIVABLES_USER_UNIT.getFlag());
            String receivablesUserId = formPropertyMap.get(ActSurrenderChargeEnums.RECEIVABLES_USER_ID.getFlag());
            Object receivablesUser = ActUtils.getNextUser(receivablesUserId,receivablesUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的财务收款人是: " + JSON.toJSONString(receivablesUser));
            results.put(ActSurrenderChargeEnums.RECEIVABLES_USER.getFlag(),receivablesUser);
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
    private static Map<String,Object> setConfirmUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务确认人信息
        Map<String,Object> results = new HashMap<>();
        if(StringUtils.isTrimBlank(taskVariables.get(ActSurrenderChargeEnums.CONFIRM_USER.getFlag()))){
            String confirmUserUnit = formPropertyMap.get(ActSurrenderChargeEnums.CONFIRM_USER_UNIT.getFlag());
            String confirmUserId = formPropertyMap.get(ActSurrenderChargeEnums.CONFIRM_USER_ID.getFlag());
            Object confirmUser = ActUtils.getNextUser(confirmUserId,confirmUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的财务审核人是: " + JSON.toJSONString(confirmUser));
            results.put(ActSurrenderChargeEnums.CONFIRM_USER.getFlag(),confirmUser);
        }
        return results;
    }
}
