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
 * @description:   保险理赔流程工具类
 * @author:ningyangyang
 * @since:2018/5/18
 */
@Component
@Slf4j
public class ActInsurClaimCheckUtils {

    /**
     * 单例
     */
    private static  ActInsurClaimCheckUtils actInsurClaimCheckUtils = null;

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

  public ActInsurClaimCheckUtils(){
      actInsurClaimCheckUtils = this;
      approvalStatusNames.put(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_APPLY.getFlag(),ActInsurClaimCheckEnums.APPLY_STATUS.getFlag());
      approvalStatusNames.put(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_APPROVE.getFlag(),ActInsurClaimCheckEnums.APPROVAL_STATUS.getFlag());
      approvalStatusNames.put(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_RECEIVABLES.getFlag(),ActInsurClaimCheckEnums.RECEIVABLES_STATUS.getFlag());
      approvalStatusNames.put(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_REVIEW.getFlag(),ActInsurClaimCheckEnums.REVIEW_STATUS.getFlag());
      approvalStatusNames.put(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_CONFIRM.getFlag(),ActInsurClaimCheckEnums.LOAN_STATUS.getFlag());
      //需要设置用户的节点
      userDefKeys = new String[] {ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_APPLY.getFlag(),
              ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_APPROVE.getFlag(),
              ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_RECEIVABLES.getFlag(),
              ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_REVIEW.getFlag()
      };
  }

    /**
     * @Title:
     * @Description: 启动保险理赔申请并待审批
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/5/17 15:22
     */
    public static ActRuTaskVo startInsurClaimCheckAndWaitApprove(String serviceId, String serviceType, String serviceName){
        //当前登录用户就是申请人员
        String applyUser = UserInfoUtils.getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        //设置申请人
        variables.put(ActInsurClaimCheckEnums.APPLY_USER.getFlag(),applyUser);
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.INSUR_CLAIM_CHECK.getKey(),
                ActProcessInstanceKeyEnums.INSUR_CLAIM_CHECK.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actInsurClaimCheckUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.INSUR_CLAIM_CHECK.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task  = actInsurClaimCheckUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        //Map<String,Object> taskVariables =  setApprovalUser(task);
        //自动设置为完成
        //actInsurClaimCheckUtils.taskService.complete(task.getId(),taskVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }



    /**
     * @Title:
     * @Description: 审批通过共通(也适用于保险理赔资管复核节点退还方式为"退还客户"时资管复核审批通过后继续走下一流程)
     * @param:  taskId
     * @return
     * @throws
     * @author yanfengbo
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actInsurClaimCheckUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActContInsurClaimStatusEnums.AGREE.getStatus(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActContInsurClaimStatusEnums.AGREE.getStatus(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 保险理赔退还方式为"抵扣租金"时资管复核审批通过后直接结束流程
     * @param:  taskId
     * @return
     * @throws
     * @author yanfengbo
     */
    public static ActRuTaskVo approvalAgreeToEnd(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actInsurClaimCheckUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        return approval(ActContInsurClaimStatusEnums.COMPLETE.getStatus(),taskId);
    }


    /**
     * @Title:
     * @Description: 由申请直接结束流程
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo applyToEnd(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actInsurClaimCheckUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        //否则正常走下一步
        return approval(ActContInsurClaimStatusEnums.COMPLETE.getStatus(),taskId);
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

        if(task.getTaskDefinitionKey().equals(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_APPROVE.getFlag())){
            //设置财务收款节点
            return setReceivablesUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_REVIEW.getFlag())){
            //设置终审人
            return setConfirmUser(task);
        }
        else if(task.getTaskDefinitionKey().equals(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_APPLY.getFlag())){
            //设置审批人
            return setApprovalUser(task);
        }
        else if(task.getTaskDefinitionKey().equals(ActInsurClaimCheckEnums.INSUR_CLAIM_CHECK_RECEIVABLES.getFlag())){
            //设置财务制单节点
            return setReviewUser(task);
        }
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
        actInsurClaimCheckUtils.taskService.complete(taskId,variables);
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
        actInsurClaimCheckUtils.taskService.complete(taskId,variables);
        ActRuTaskVo actRuTaskVo = ActUtils.getActRuTaskVoAndNextInfo(task);
        return actRuTaskVo;
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
        return approval(ActContGenerationStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
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
     * @author ningyangyang
     * @date 2018/05/18 02:53:21
     */
    private static Map<String,Object> setApprovalUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String,Object> results = new HashMap<>();
        //如果申请审批人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActInsurClaimCheckEnums.APPROVAL_USER.getFlag()))){
            String approvalUserId = formPropertyMap.get(ActInsurClaimCheckEnums.APPROVAL_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActInsurClaimCheckEnums.APPROVAL_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUser(approvalUserId,approvalUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(approvalUser));
            results.put(ActContPrepaymentEnums.APPROVAL_USER.getFlag(),approvalUser);
        }
        return results;
    }
    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actInsurClaimCheckUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }


    /**
     * @Title:
     * @Description:   设置财务收款节点
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setReceivablesUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActInsurClaimCheckEnums.RECEIVABLES_USER.getFlag()))){
            String receivablesUserUnit = formPropertyMap.get(ActInsurClaimCheckEnums.RECEIVABLES_USER_UNIT.getFlag());
            String receivablesUserId = formPropertyMap.get(ActInsurClaimCheckEnums.RECEIVABLES_USER_ID.getFlag());
            Object receivablesUser = ActUtils.getNextUser(receivablesUserId,receivablesUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(receivablesUser));
            results.put(ActInsurClaimCheckEnums.RECEIVABLES_USER.getFlag(),receivablesUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置终审人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setConfirmUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActInsurClaimCheckEnums.CONFIRM_USER.getFlag()))) {
            String confirmUserUnit = formPropertyMap.get(ActInsurClaimCheckEnums.CONFIRM_USER_UNIT.getFlag());
            String confirmUserId = formPropertyMap.get(ActInsurClaimCheckEnums.CONFIRM_USER_ID.getFlag());
            Object confirmUser = ActUtils.getNextUser(confirmUserId, confirmUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的终审人是: " + JSON.toJSONString(confirmUser));
            results.put(ActInsurClaimCheckEnums.CONFIRM_USER.getFlag(), confirmUser);
            results.put(ActInsurClaimCheckEnums.NEXT_USER.getFlag(), confirmUser);
        }else {
            results.put(ActInsurClaimCheckEnums.NEXT_USER.getFlag(),taskVariables.get(ActInsurClaimCheckEnums.CONFIRM_USER.getFlag()));
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置财务制单节点
     * @param task 任务
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018/10/18 16:21:21
     */
    private static Map<String,Object> setReviewUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String,Object> results = new HashMap<>();
        //如果申请审批人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActInsurClaimCheckEnums.REVIEW_USER.getFlag()))){
            String reviewUserId = formPropertyMap.get(ActInsurClaimCheckEnums.REVIEW_USER_ID.getFlag());
            String reviewUserUnit = formPropertyMap.get(ActInsurClaimCheckEnums.REVIEW_USER_UNIT.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActInsurClaimCheckEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }

}
