package cn.com.leadu.fms.business.common.util.activiti;/**
 * Created by ningyangyang on 2018/9/20.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActRetrieveCarEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActRetrieveCarStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DispatchTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
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
 * @Title: fms
 * @Description: 收车任务
 * @author: ningyangyang
 * @date 2018/9/20 13:44
 */
@Component
@Slf4j
public class ActRetrieveCarUtils {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * 单例
     */
    private static ActRetrieveCarUtils actRetrieveCarUtils = null;

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

    public ActRetrieveCarUtils(){
        actRetrieveCarUtils = this;
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_APPLY.getFlag(), ActRetrieveCarEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_DISPATCH.getFlag(), ActRetrieveCarEnums.DISPATCH_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_APPROVE.getFlag(), ActRetrieveCarEnums.APPROVE_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_REVIEW.getFlag(), ActRetrieveCarEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_CHECK.getFlag(), ActRetrieveCarEnums.CHECK_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_REGISTER.getFlag(), ActRetrieveCarEnums.REGISTER_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_STORAGE.getFlag(), ActRetrieveCarEnums.STORAGE_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_HANDOVER.getFlag(), ActRetrieveCarEnums.HANDOVER_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_FINANCIAL.getFlag(), ActRetrieveCarEnums.FINANCIAL_STATUS.getFlag());
        approvalStatusNames.put(ActRetrieveCarEnums.RETRIEVE_TASK_AUDIT.getFlag(), ActRetrieveCarEnums.AUDIT_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[]{
                ActRetrieveCarEnums.RETRIEVE_TASK_APPLY.getFlag(),
                ActRetrieveCarEnums.RETRIEVE_TASK_DISPATCH.getFlag(),
                ActRetrieveCarEnums.RETRIEVE_TASK_APPROVE.getFlag(),
                ActRetrieveCarEnums.RETRIEVE_TASK_REVIEW.getFlag(),
                //ActRetrieveCarEnums.RETRIEVE_TASK_CHECK.getFlag(),
                ActRetrieveCarEnums.RETRIEVE_TASK_REGISTER.getFlag(),
                ActRetrieveCarEnums.RETRIEVE_TASK_STORAGE.getFlag(),
                ActRetrieveCarEnums.RETRIEVE_TASK_HANDOVER.getFlag(),
                ActRetrieveCarEnums.RETRIEVE_TASK_FINANCIAL.getFlag(),
        };
    }

    /**
     * @return ActRuTaskVo
     * @throws
     * @Title:
     * @Description: 启动收车任务流程
     * @param: serviceId 业务id
     * @param:
     * @param: serviceName 业务名称
     * @author ningyangyang
     * @date 2018/9/20 20:16
     */
    public static ActRuTaskVo startRetrieveCarTask(String serviceId, String serviceName) {
        //当前登录用户就是保单上传人员
        String uploadRegisterUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActRetrieveCarEnums.APPLY_USER.getFlag(), uploadRegisterUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.RETRIEVE_CAR.getKey(),
                ActProcessInstanceKeyEnums.RETRIEVE_CAR.getDesc(), "", serviceName, serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actRetrieveCarUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.RETRIEVE_CAR.getKey(), serviceId, variables);
        //第一条任务是保单上传人的
        Task task = actRetrieveCarUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //获取主管派单下一节点审批人
        Map<String, Object> taskVariables = setDispatchUser(task);
        //自动设置为完成
        actRetrieveCarUtils.taskService.complete(task.getId(), taskVariables);
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
     * @date 2018/9/20  14:11
     */
    public static ActRuTaskVo approvalAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actRetrieveCarUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActRetrieveCarStatusEnums.AGREE.getStatus(),taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActRetrieveCarStatusEnums.AGREE.getStatus(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 审批通过(需要设置委派和登记人)
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/20  14:11
     */
    public static ActRuTaskVo approvalAgreeDispatch(String taskId,RetrieveCarsTaskVo retrieveCarsTaskVo){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actRetrieveCarUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActRetrieveCarStatusEnums.AGREE.getStatus(),taskId,setApprovalUser(task,retrieveCarsTaskVo));
        }else{
            //否则正常走下一步
            return approval(ActRetrieveCarStatusEnums.AGREE.getStatus(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 审批通过(到总经理审批)
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/20  14:11
     */
    public static ActRuTaskVo approvalToCheck(String taskId,RetrieveCarsTaskVo retrieveCarsTaskVo){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actRetrieveCarUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActRetrieveCarStatusEnums.TO_AUDIT.getStatus(),taskId,setCheckUser(task,retrieveCarsTaskVo));
        }else{
            //否则正常走下一步
            return approval(ActRetrieveCarStatusEnums.TO_AUDIT.getStatus(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 审批通过(到财务审批)
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/20  14:11
     */
    public static ActRuTaskVo approvalToFinancial(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actRetrieveCarUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActRetrieveCarStatusEnums.TO_FINANCIAL.getStatus(),taskId,setNodeUser(task,ActRetrieveCarEnums.FINANCIAL_USER.getFlag(),ActRetrieveCarEnums.FINANCIAL_USER_UNIT.getFlag(),ActRetrieveCarEnums.FINANCIAL_USER_ID.getFlag()));
        }else{
            //否则正常走下一步
            return approval(ActRetrieveCarStatusEnums.TO_FINANCIAL.getStatus(),taskId);
        }
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/20  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActRetrieveCarStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 退回主管派单
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/20  14:11
     */
    public static ActRuTaskVo approvalReturnToDispatch(String taskId){
        return approval(ActRetrieveCarStatusEnums.AUDIT_BACK.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 退回委派与登记
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/20  14:11
     */
    public static ActRuTaskVo approvalReturnToRegister(String taskId){
        return approval(ActRetrieveCarStatusEnums.FINANCIAL_BACK.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 拒绝
     * @param:  taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/20  14:11
     */
    public static ActRuTaskVo approvalRefuse(String taskId){
        return approval(ActRetrieveCarStatusEnums.REFUSE.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/9/20 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actRetrieveCarUtils.taskService.complete(taskId,variables);
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
     * @date 2018/9/20 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actRetrieveCarUtils.taskService.complete(taskId,variables);
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
     * @date 2018/9/20  15:35
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

        if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_APPLY.getFlag())){
            //申请主管派单人
            return setDispatchUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_DISPATCH.getFlag())){
            //设置风控初审人
            return setNodeUser(task,ActRetrieveCarEnums.APPROVE_USER.getFlag(),ActRetrieveCarEnums.APPROVE_USER_UNIT.getFlag(),ActRetrieveCarEnums.APPROVE_USER_ID.getFlag());
        }else if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_APPROVE.getFlag())){
            //设置业务副总
            return setNodeUser(task,ActRetrieveCarEnums.REVIEW_USER.getFlag(),ActRetrieveCarEnums.REVIEW_USER_UNIT.getFlag(),ActRetrieveCarEnums.REVIEW_USER_ID.getFlag());
        }else if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_REVIEW.getFlag())){
            //设置总经理
            return setNodeUser(task,ActRetrieveCarEnums.CHECK_USER.getFlag(),ActRetrieveCarEnums.AUDIT_USER_UNIT.getFlag(),ActRetrieveCarEnums.AUDIT_USER_ID.getFlag());
        }else if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_CHECK.getFlag())){
            //设置委派登记人
            return setNodeUser(task,ActRetrieveCarEnums.REGISTER_USER.getFlag(),ActRetrieveCarEnums.REGISTER_USER_UNIT.getFlag(),ActRetrieveCarEnums.REGISTER_USER_ID.getFlag());
        }else if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_REGISTER.getFlag())){
            //设置车辆入库人
            return setNodeUser(task,ActRetrieveCarEnums.STORAGE_USER.getFlag(),ActRetrieveCarEnums.STORAGE_USER_UNIT.getFlag(),ActRetrieveCarEnums.STORAGE_USER_ID.getFlag());
        }else if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_STORAGE.getFlag())){
            //设置确认交接人
            return setNodeUser(task,ActRetrieveCarEnums.HANDOVER_USER.getFlag(),ActRetrieveCarEnums.HANDOVER_USER_UNIT.getFlag(),ActRetrieveCarEnums.HANDOVER_USER_ID.getFlag());
        }else if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_HANDOVER.getFlag())){
            //设置财务审核人
            return setNodeUser(task,ActRetrieveCarEnums.FINANCIAL_USER.getFlag(),ActRetrieveCarEnums.FINANCIAL_USER_UNIT.getFlag(),ActRetrieveCarEnums.FINANCIAL_USER_ID.getFlag());
        }else if(task.getTaskDefinitionKey().equals(ActRetrieveCarEnums.RETRIEVE_TASK_FINANCIAL.getFlag())){
            //设置总经理
            return setNodeUser(task,ActRetrieveCarEnums.AUDIT_USER.getFlag(),ActRetrieveCarEnums.AUDIT_USER_UNIT.getFlag(),ActRetrieveCarEnums.AUDIT_USER_ID.getFlag());
        } else{
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }

    /**
     * @Title:
     * @Description:   设置任务节点人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/20 02:53:21
     */
    private static Map<String,Object> setNodeUser(Task task,String user,String unit,String id){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        //如果主管派单人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(user))){
            String UserUnit = formPropertyMap.get(unit);
            String UserId = formPropertyMap.get(id);
            Object User = ActUtils.getNextUser(UserId,UserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的下一节点审批人是: " + JSON.toJSONString(User));
            results.put(user,User);
        }
        return results;
    }


    /**
     * @Title:
     * @Description:   设置主管派单人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/20 02:53:21
     */
    private static Map<String,Object> setDispatchUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();

        //如果主管派单人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActRetrieveCarEnums.DISPATCH_USER.getFlag()))){
            String UserUnit = formPropertyMap.get(ActRetrieveCarEnums.DISPATCH_USER_UNIT.getFlag());
            String UserId = formPropertyMap.get(ActRetrieveCarEnums.DISPATCH_USER_ID.getFlag());
            Object User = ActUtils.getNextUser(UserId,UserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的主管派单人是: " + JSON.toJSONString(User));
            results.put(ActRetrieveCarEnums.DISPATCH_USER.getFlag(),User);
        }
        return results;
    }


    /**
     * @Title:
     * @Description:   设置总经理审批人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/20 02:53:21
     */
    private static Map<String,Object> setCheckUser(Task task,RetrieveCarsTaskVo retrieveCarsTaskVo){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        if(DispatchTypeEnums.COMPANY.getType().equals(retrieveCarsTaskVo.getDispachType())){
            results.put(ActRetrieveCarEnums.REGISTER_USER.getFlag(),retrieveCarsTaskVo.getDispachPeople());
        }else{
            results.put(ActRetrieveCarEnums.REGISTER_USER.getFlag(),retrieveCarsTaskVo.getRegisterPeople());
        }
        //如果总经理人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActRetrieveCarEnums.CHECK_USER.getFlag()))){
            String UserUnit = formPropertyMap.get(ActRetrieveCarEnums.AUDIT_USER_UNIT.getFlag());
            String UserId = formPropertyMap.get(ActRetrieveCarEnums.AUDIT_USER_ID.getFlag());
            Object User = ActUtils.getNextUser(UserId,UserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的总经理是: " + JSON.toJSONString(User));
            results.put(ActRetrieveCarEnums.CHECK_USER.getFlag(),User);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置风控审核人
     * @param task 任务
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/09/20 02:53:21
     */
    private static Map<String,Object> setApprovalUser(Task task,RetrieveCarsTaskVo retrieveCarsTaskVo){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的风控初审信息
        Map<String,Object> results = new HashMap<>();
        if(DispatchTypeEnums.COMPANY.getType().equals(retrieveCarsTaskVo.getDispachType())){
            results.put(ActRetrieveCarEnums.REGISTER_USER.getFlag(),retrieveCarsTaskVo.getDispachPeople());
        }else{
            results.put(ActRetrieveCarEnums.REGISTER_USER.getFlag(),retrieveCarsTaskVo.getRegisterPeople());
        }
        //如果总经理人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActRetrieveCarEnums.APPROVE_USER.getFlag()))){
            String UserUnit = formPropertyMap.get(ActRetrieveCarEnums.APPROVE_USER_UNIT.getFlag());
            String UserId = formPropertyMap.get(ActRetrieveCarEnums.APPROVE_USER_ID.getFlag());
            Object User = ActUtils.getNextUser(UserId,UserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的风控审核人是: " + JSON.toJSONString(User));
            results.put(ActRetrieveCarEnums.APPROVE_USER.getFlag(),User);
        }
        return results;
    }




    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actRetrieveCarUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }
}