package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationStatusEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.common.util.MapUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.FormService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActContractGenerationUtils
 * @Description: 合同生成工具类
 * @date 2018/4/8
 */
@Component
@Slf4j
public class ActContractGenerationUtils {

    /**
     * @Fields  : 单例辅助
     * @author qiaomengnan
     */
    private static ActContractGenerationUtils actContractGenerationUtils = null;

    /**
     * @Fields  : 每个流程节点的审批状态名称
     * @author qiaomengnan
     */
    private static Map<String,String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields  : 需要设置用户的节点
     * @author qiaomengnan
     */
    private static String [] userDefKeys = null;

    /**
     * @Title:
     * @Description:   注入单例
     * @Description:   注入单例
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/10 02:19:36
     */
    public ActContractGenerationUtils(){
        //注入单例工具类
        actContractGenerationUtils = this;
        //保存每个流程节点的审批状态名称
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_APPLY.getFlag(),ActContGenerationFlagEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_APPROVAL.getFlag(),ActContGenerationFlagEnums.APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_RISK.getFlag(),ActContGenerationFlagEnums.RISK_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_DIRAGREE.getFlag(),ActContGenerationFlagEnums.DIRAGREE_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PREAGREE.getFlag(),ActContGenerationFlagEnums.PREAGREE_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_MANAGE.getFlag(),ActContGenerationFlagEnums.MANAGE_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_SALES.getFlag(),ActContGenerationFlagEnums.SALES_STATUS.getFlag());

        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_CONFIRM.getFlag(),ActContGenerationFlagEnums.CONFIRM_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_GENERATE.getFlag(),ActContGenerationFlagEnums.PROCESS_GENERATE_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_QUALIFICATION.getFlag(),ActContGenerationFlagEnums.PROCESS_QUALIFICATION_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_PRINT.getFlag(),ActContGenerationFlagEnums.PROCESS_PRINT_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_REQUES_FUNDS.getFlag(),ActContGenerationFlagEnums.PROCESS_REQUES_FUNDS_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_APPROVAL.getFlag(),ActContGenerationFlagEnums.PROCESS_APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_CHARGE.getFlag(),ActContGenerationFlagEnums.PROCESS_CHARGE_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_VOUCHER.getFlag(),ActContGenerationFlagEnums.PROCESS_VOUCHER_STATUS.getFlag());
        approvalStatusNames.put(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_LOAN.getFlag(),ActContGenerationFlagEnums.PROCESS_LOAN_STATUS.getFlag());
        //需要设置用户的节点
        userDefKeys = new String[] {ActContGenerationFlagEnums.CONTRACT_GENERATION_APPLY.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_APPROVAL.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_RISK.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_DIRAGREE.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_PREAGREE.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_GENERATE.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_REQUES_FUNDS.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_APPROVAL.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_CHARGE.getFlag(),
                ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_VOUCHER.getFlag()
        };

    }

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    /**
     * @Title:
     * @Description: 启动申请录入
     * @param: serviceId 业务id
     * @param: serviceType 申请类型(个人企业)
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/14
     */
    public static ActRuTaskVo startContractGeneration(String serviceId,String serviceType,String serviceName,Map<String,String> paramVariables){
        if(StringUtils.notEquals(ApplyTypeEnums.PERSON.getType(), serviceType) && StringUtils.notEquals(ApplyTypeEnums.COMPANY.getType(),serviceType))
            throw new FmsServiceException("订单申请类型不存在");
        //当前登录用户就是申请录入人员
        String applyUser = UserInfoUtils.getUserName();
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务id不能为空");
        if(StringUtils.isTrimBlank(applyUser))
            throw new FmsServiceException("申请人不能为空");
//        if(StringUtils.isTrimBlank(serviceName))
//            throw new FmsServiceException("业务名称不能为空");
        String confirmUser = applyUser;
        String processGenerateUser = applyUser;
        String processPrintUser = applyUser;
        String salesUser = applyUser;
        String processRequesFundsUser = applyUser;
        //构建参数
        Map<String,Object> variables = getContractGenerationVariables(serviceId,applyUser,confirmUser,processGenerateUser,processPrintUser,salesUser,processRequesFundsUser,
                ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getDesc(),serviceType,serviceName);

        //其他参数（用户组代码）
        variables.put(ActContGenerationFlagEnums.PARAM_VARIABLES.getFlag(), paramVariables);
        //启动申请录入流程
        ProcessInstance processInstance = actContractGenerationUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actContractGenerationUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }


    /**
     * @Title:
     * @Description: 提交申请录入
     * @param: serviceId 业务id
     * @param: serviceType 申请类型(个人企业)
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/14
     */
    public static ActRuTaskVo submitContractGenerationInfo(String taskId, String serviceType, String serviceName, Map<String, String> paramVariables){
        if(StringUtils.notEquals(ApplyTypeEnums.PERSON.getType(), serviceType) && StringUtils.notEquals(ApplyTypeEnums.COMPANY.getType(),serviceType))
            throw new FmsServiceException("订单申请类型不存在");
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        if(StringUtils.isTrimBlank(serviceName))
            throw new FmsServiceException("业务名称不能为空");
        Task task = actContractGenerationUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables = setApprovalUser(task,StringUtils.getValue(paramVariables.get("groupCode")));
        //暂存的信息客户名称可能会被更改,此处做对之前的客户名称更新
        taskVariables.put(ActFlagEnums.SERVICE_NAME.getFlag(),serviceName);
        //其他参数（用户组代码）
        taskVariables.put(ActContGenerationFlagEnums.PARAM_VARIABLES.getFlag(), paramVariables);
        //同意条件
        taskVariables.put(getApprovalStatusName(task.getTaskDefinitionKey()),ActContGenerationStatusEnums.AGREE.getStatus());
        //设置为完成
        actContractGenerationUtils.taskService.complete(task.getId(),taskVariables);
        ActRuTaskVo actRuTaskVo = ActUtils.getActRuTaskVoAndNextInfo(task);
        return actRuTaskVo;
    }


    /**
     * @Title:
     * @Description: 提交申请录入并进入审批
     * @param serviceId 业务id
     * @param serviceType 申请类型(个人企业)
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 02:35:10
     */
    public static ActRuTaskVo startContractGenerationAndSubmit(String serviceId,String serviceType,String serviceName, Map<String,String> paramVariables){
        //当前登录用户就是申请录入人员
        String applyUser = UserInfoUtils.getUserName();
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务id不能为空");
        if(StringUtils.isTrimBlank(applyUser))
            throw new FmsServiceException("申请人不能为空");
        if(StringUtils.isTrimBlank(serviceName))
            throw new FmsServiceException("业务名称不能为空");
        String confirmUser = applyUser;
        String processGenerateUser = applyUser;
        String processPrintUser = applyUser;
        String salesUser = applyUser;
        String processRequesFundsUser = applyUser;
        //构建参数
        Map<String,Object> variables = getContractGenerationVariables(serviceId,applyUser,confirmUser,processGenerateUser,processPrintUser,salesUser,processRequesFundsUser,
                ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getDesc(),serviceType,serviceName);
        //其他参数（用户组代码）
        variables.put(ActContGenerationFlagEnums.PARAM_VARIABLES.getFlag(), paramVariables);
        //启动申请录入流程
        ProcessInstance processInstance =  actContractGenerationUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actContractGenerationUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables = setApprovalUser(task);
        //同意条件
        taskVariables.put(getApprovalStatusName(task.getTaskDefinitionKey()),ActContGenerationStatusEnums.AGREE.getStatus());
        //自动设置为完成
        actContractGenerationUtils.taskService.complete(task.getId(),taskVariables);
        ActRuTaskVo actRuTaskVo = ActUtils.getActRuTaskVoAndNextInfo(task);
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 合同生成确认通过
     * @param contractList
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 09:44:36
     */
    public static ActRuTaskVo confirmAgree(List<Contract> contractList,String taskId,Map<String,String> contNoAndServiceNameMap){
        return confirmCompleteAgree(contractList,taskId,ActContGenerationStatusEnums.AGREE.getStatus(),contNoAndServiceNameMap);
    }

    /**
     * @Title:
     * @Description: 合同生成确认拒绝
     * @param contractList
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 09:44:36
     */
    public static ActRuTaskVo confirmRefuse(List<Contract> contractList,String taskId){
        return confirmCompleteRefuse(contractList,taskId,ActContGenerationStatusEnums.REFUSE.getStatus());
    }

    /**
     * @Title:
     * @Description: 合同生成确认通过
     * @param contractList
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 09:44:36
     */
    public static ActRuTaskVo confirmCompleteAgree(List<Contract> contractList,String taskId,Integer status,Map<String,String> contNoAndServiceNameMap){
        if(ArrayUtils.isNullOrLengthZero(contractList))
            throw new FmsServiceException("合同列表不能为空");
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        List<Map<String,String>> contractMapList = new ArrayList<>();
        for(Contract contract : contractList){
            Map<String,String> contractMap = new HashMap<>();
            contractMap.put(ActContGenerationFlagEnums.APPLY_NO.getFlag(),contract.getApplyNo());
            contractMap.put(ActContGenerationFlagEnums.CONT_NO.getFlag(),contract.getContNo());
            contractMapList.add(contractMap);
        }
        Task task = actContractGenerationUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActContGenerationFlagEnums.CONTRACT_QUANTITYS.getFlag(),contractMapList);
        variables.put(ActContGenerationFlagEnums.CONFIRM_STATUS.getFlag(),status);
        actContractGenerationUtils.taskService.complete(taskId,variables);
        //确认通过以后，查出所有的合同任务
        List<Task> tasks = actContractGenerationUtils.taskService.createTaskQuery().processInstanceId(task.getProcessInstanceId()).list();
        if(ArrayUtils.isNotNullAndLengthNotZero(tasks)){
            //给每个流程放入自己的serviceName
            for(Task tmpTask : tasks){
                String serviceName = "";
                //拿到任务流程的参数
                Map<String,Object> variables2 = actContractGenerationUtils.runtimeService.getVariables(tmpTask.getExecutionId());
                if(variables2 != null){
                    String contNo = MapUtils.getMapValueToString(variables2.get(ActContGenerationFlagEnums.CONTRACT_QUANTITY.getFlag()),ActContGenerationFlagEnums.CONT_NO.getFlag());
                    if(StringUtils.isNotTrimBlank(contNo) && contNoAndServiceNameMap !=null){
                        for(String key : contNoAndServiceNameMap.keySet()){
                            if(contNo.equals(key)){
                                serviceName = contNoAndServiceNameMap.get(key);
                            }
                        }
                    }
                }
                actContractGenerationUtils.runtimeService.setVariableLocal(tmpTask.getExecutionId(),ActFlagEnums.SERVICE_NAME.getFlag(),serviceName);
            }
        }
        return ActUtils.getActRuTaskVoAndNextInfo(task,setExecutionVariables(variables,task.getExecutionId()));
    }

    /**
     * @Title:
     * @Description: 合同生成确认拒绝
     * @param contractList
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 09:44:36
     */
    public static ActRuTaskVo confirmCompleteRefuse(List<Contract> contractList,String taskId,Integer status){
        if(ArrayUtils.isNullOrLengthZero(contractList))
            throw new FmsServiceException("合同列表不能为空");
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        List<Map<String,String>> contractMapList = new ArrayList<>();
        for(Contract contract : contractList){
            Map<String,String> contractMap = new HashMap<>();
            contractMap.put(ActContGenerationFlagEnums.APPLY_NO.getFlag(),contract.getApplyNo());
            contractMap.put(ActContGenerationFlagEnums.CONT_NO.getFlag(),contract.getContNo());
            contractMapList.add(contractMap);
        }
        Task task = actContractGenerationUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActContGenerationFlagEnums.CONTRACT_QUANTITYS.getFlag(),contractMapList);
        variables.put(ActContGenerationFlagEnums.CONFIRM_STATUS.getFlag(),status);
        actContractGenerationUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task,setExecutionVariables(variables,task.getExecutionId()));
    }

    /**
     * @Title:
     * @Description: 融资申请取消 (根据业务id取消流程)
     * @param: serviceId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/24 10:32
     */
    public static ActRuTaskVo applyCancel(String serviceId){
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务id不能为空");
        List<Task> tasks = actContractGenerationUtils.taskService.createTaskQuery().processInstanceBusinessKey(serviceId)
                .processDefinitionKey(ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getKey()).list();
        if(ArrayUtils.isNotNullAndLengthNotZero(tasks) && tasks.size() > 1){
            throw new FmsServiceException("当前任务数量过多");
        }else if(ArrayUtils.isNullOrLengthZero(tasks))
            throw new FmsServiceException("当前不存在任务节点");
        else{
            return approvalCancel(tasks.get(0));
        }
    }

    /**
     * @Title:
     * @Description: 融资申请合同取消 (根据业务id和合同号取消流程)
     * @param: serviceId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/24 10:32
     */
    public static ActRuTaskVo applyContCancel(String serviceId,String contNo){
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务id不能为空");
        List<Task> tasks = actContractGenerationUtils.taskService.createTaskQuery().processInstanceBusinessKey(serviceId)
                .processDefinitionKey(ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getKey()).list();
        if(ArrayUtils.isNullOrLengthZero(tasks)){
            throw new FmsServiceException("当前不存在任务节点");
        }else{
            ActRuTaskVo actRuTaskVo = null;
            for(Task task : tasks){
                //获取当前合同生成子流程的合同号
                Object result = actContractGenerationUtils.runtimeService.getVariable(task.getExecutionId(),ActContGenerationFlagEnums.CONTRACT_QUANTITY.getFlag());

                //合同号如果相等 则执行取消操作
                if(result != null){
                    Map<String,String> contractQuantity = (Map<String,String>)result;
                    if(contNo.equals(contractQuantity.get(ActContGenerationFlagEnums.CONT_NO.getFlag()))) {
                        actRuTaskVo = approvalCancel(task);
                        break;
                    }
                }
            }
            if(actRuTaskVo == null)
                throw new FmsServiceException("未找到对应的合同任务");
            return actRuTaskVo;
        }
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
        Task task = actContractGenerationUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
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
     * @Description: 带状态通过
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/22 16:33
     */
    public static ActRuTaskVo approvalWithState(String taskId,Integer state){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actContractGenerationUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        if(ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(state,taskId,setUser(task));
        }else{
            //否则正常走下一步
            return approval(state,taskId);
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
        ActRuTaskVo actRuTaskVo = approval(ActContGenerationStatusEnums.RETURN_SUPERIOR.getStatus(),taskId);
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 退回经销商
     * @param:  taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalReturnDealer(String taskId){
        return approval(ActContGenerationStatusEnums.RETURN_DEALER.getStatus(),taskId);
    }

    /**
     * @Title:
     * @Description: 建议拒绝
     * @param:  taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalRefuse(String taskId){
        return approval(ActContGenerationStatusEnums.REFUSE.getStatus(),taskId);
    }


    /**
     * @Title:
     * @Description: 建议拒绝
     * @param:  task
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalRefuse(Task task){
        return approval(ActContGenerationStatusEnums.REFUSE.getStatus(),task);
    }

    /** 
    * @Description: 取消任务
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/26 16:16
    */ 
    public static ActRuTaskVo approvalCancel(Task task){
        return approval(ActContGenerationStatusEnums.CANCEL.getStatus(),task);
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
            throw new FmsServiceException("任务id不能为空");
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actContractGenerationUtils.taskService.complete(taskId,variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task,setExecutionVariables(variables,task.getExecutionId()));
    }

    private static boolean setExecutionVariables(Map<String,Object> variables,String executionId){
        if(variables != null && variables.size() > 0 && StringUtils.isNotTrimBlank(executionId)){
            if(ArrayUtils.isNotNullAndLengthNotZero(actContractGenerationUtils.runtimeService.createExecutionQuery().executionId(executionId).list())) {
                for (String key : variables.keySet()) {
                    actContractGenerationUtils.runtimeService.setVariableLocal(executionId, key, variables.get(key));
                }
                return true;
            }
        }
        return false;
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
        actContractGenerationUtils.taskService.complete(taskId,variables);
        ActRuTaskVo actRuTaskVo =  ActUtils.getActRuTaskVoAndNextInfo(task,setExecutionVariables(variables,task.getExecutionId()));
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: task
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    public static ActRuTaskVo approval(Integer status,Task task){
        if(task == null)
            throw new FmsServiceException("任务不能为空");
        Map<String,Object> variables = new HashMap<>();
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actContractGenerationUtils.taskService.complete(task.getId(),variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task,setExecutionVariables(variables,task.getExecutionId()));
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
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setUser(Task task){

        if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_APPLY.getFlag())){
            //申请录入节点设置区域经理审核人
            return setApprovalUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_APPROVAL.getFlag())){
            //设置风控初审人
            return setRiskUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_RISK.getFlag())){
            //设置主管审核人
            return setDirAgreeUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_DIRAGREE.getFlag())){
            //设置副总审核人
            return setPreAgreeUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_PREAGREE.getFlag())){
            //设置总经理审核人
            return setManageUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_GENERATE.getFlag())){
            //设置资管审核人
            return setProcessQualificationUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_REQUES_FUNDS.getFlag())){
            //设置文件审核人
            return setProcessApprovalUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_APPROVAL.getFlag())){
            //出纳收款人
            return setProcessChargeUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_CHARGE.getFlag())){
            //出纳制单人
            return setProcessVoucherUser(task);
        }else if(task.getTaskDefinitionKey().equals(ActContGenerationFlagEnums.CONTRACT_GENERATION_PROCESS_VOUCHER.getFlag())){
            //财务打款人
            return setProcessLoanUser(task);
        }else{
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }


    /**
     * @Title:
     * @Description:   设置区域经理审核人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setApprovalUser(Task task){
        String groupCode = "";//用户组代码
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String,Object> results = new HashMap<>();
        //如果申请审批人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.APPROVAL_USER.getFlag()))){
            String approvalUserId = formPropertyMap.get(ActContGenerationFlagEnums.APPROVAL_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.APPROVAL_USER_UNIT.getFlag());
//            Object approvalUser = ActUtils.getNextUser(approvalUserId,approvalUserUnit);
            Object paramVariables = taskVariables.get(ActContGenerationFlagEnums.PARAM_VARIABLES.getFlag());
            if(paramVariables != null){
                Map<String,String> paramsMap = (Map<String,String>) paramVariables;
                groupCode = paramsMap.get("groupCode");
            }
            Object approvalUser = ActUtils.getNextUserWithGroupCode(approvalUserId,approvalUserUnit,groupCode);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(approvalUser));
            results.put(ActContGenerationFlagEnums.APPROVAL_USER.getFlag(),approvalUser);
            results.put(ActContGenerationFlagEnums.NEXT_USER.getFlag(),approvalUser);
        }else{
            results.put(ActContGenerationFlagEnums.NEXT_USER.getFlag(),taskVariables.get(ActContGenerationFlagEnums.APPROVAL_USER.getFlag()));
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置区域经理审核人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setApprovalUser(Task task,String groupCode){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String,Object> results = new HashMap<>();
        //如果申请审批人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.APPROVAL_USER.getFlag()))){
            String approvalUserId = formPropertyMap.get(ActContGenerationFlagEnums.APPROVAL_USER_ID.getFlag());
            String approvalUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.APPROVAL_USER_UNIT.getFlag());
            Object approvalUser = ActUtils.getNextUserWithGroupCode(approvalUserId,approvalUserUnit,groupCode);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(approvalUser));
            results.put(ActContGenerationFlagEnums.APPROVAL_USER.getFlag(),approvalUser);
            results.put(ActContGenerationFlagEnums.NEXT_USER.getFlag(),approvalUser);
        }else{
            results.put(ActContGenerationFlagEnums.NEXT_USER.getFlag(),taskVariables.get(ActContGenerationFlagEnums.APPROVAL_USER.getFlag()));
        }
        return results;
    }

    /**
     * @Title:
     * @Description: 修改风控初审人员
     * @param: executionId
     * @param: user
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/3 0003 18:27
     */
    public static void modifyRiskUser(String executionId,String user){
        actContractGenerationUtils.runtimeService.setVariable(executionId,ActContGenerationFlagEnums.RISK_USER.getFlag(),user);
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
    private static Map<String,Object> setRiskUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.RISK_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.RISK_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContGenerationFlagEnums.RISK_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContGenerationFlagEnums.RISK_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Description: 设置主管是审批人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/23 16:10
     */
    private static Map<String,Object> setDirAgreeUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.DIRAGREE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.DIR_AGREE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContGenerationFlagEnums.DIR_AGREE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContGenerationFlagEnums.DIRAGREE_USER.getFlag(),reviewUser);
        }
        return results;
    }

    private static Map<String,Object> setPreAgreeUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.PREAGREE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.PRE_AGREE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContGenerationFlagEnums.PRE_AGREE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContGenerationFlagEnums.PREAGREE_USER.getFlag(),reviewUser);
        }
        return results;
    }

    private static Map<String,Object> setManageUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.MANAGE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.MANAGE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContGenerationFlagEnums.MANAGE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContGenerationFlagEnums.MANAGE_USER.getFlag(),reviewUser);
        }
        return results;
    }

    private static Map<String,Object> setProcessQualificationUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.PROCESS_QUALIFICATION_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_QUALIFICATION_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_QUALIFICATION_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContGenerationFlagEnums.PROCESS_QUALIFICATION_USER.getFlag(),reviewUser);
        }
        return results;
    }

    private static Map<String,Object> setProcessApprovalUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.PROCESS_APPROVAL_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_APPROVAL_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_APPROVAL_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContGenerationFlagEnums.PROCESS_APPROVAL_USER.getFlag(),reviewUser);
        }
        return results;
    }

    private static Map<String,Object> setProcessChargeUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.PROCESS_CHARGE_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_CHARGE_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_CHARGE_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContGenerationFlagEnums.PROCESS_CHARGE_USER.getFlag(),reviewUser);
        }
        return results;
    }

    private static Map<String,Object> setProcessVoucherUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String,Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.PROCESS_VOUCHER_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_VOUCHER_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_VOUCHER_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批人是: " + JSON.toJSONString(reviewUser));
            results.put(ActContGenerationFlagEnums.PROCESS_VOUCHER_USER.getFlag(),reviewUser);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   设置财务打款人
     * @param task 任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setProcessLoanUser(Task task){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String,String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务打款人信息
        Map<String,Object> results = new HashMap<>();
        //如果合同生成财务打款人为空，则进行放入
        if(StringUtils.isTrimBlank(taskVariables.get(ActContGenerationFlagEnums.PROCESS_LOAN_USER.getFlag()))){
            String processLoanUnit = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_LOAN_UNIT.getFlag());
            String processLoanId = formPropertyMap.get(ActContGenerationFlagEnums.PROCESS_LOAN_ID.getFlag());
            Object processLoanUser = ActUtils.getNextUser(processLoanId,processLoanUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的合同生成财务打款人是: " + JSON.toJSONString(processLoanUser));
            results.put(ActContGenerationFlagEnums.PROCESS_LOAN_USER.getFlag(),processLoanUser);
            results.put(ActContGenerationFlagEnums.NEXT_USER.getFlag(),processLoanUser);
        }else{
            results.put(ActContGenerationFlagEnums.NEXT_USER.getFlag(),taskVariables.get(ActContGenerationFlagEnums.PROCESS_LOAN_USER.getFlag()));
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   构建参数
     * @param serviceId 业务id
     * @param applyUser 申请人id
     * @param confirmUser 合同生成前确认人id
     * @param processGenerateUser  合同生成人id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 01:56:10
     */
    private static Map<String,Object> getContractGenerationVariables(Object serviceId, Object applyUser,
                                                                     Object confirmUser,Object processGenerateUser,String processPrintUser,
                                                                     String salesUser ,String processRequesFundsUser,String taskTitle,String serviceType,String serviceName){
        Map<String,Object> variables = new HashMap<>();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //申请录入人id
        variables.put(ActFlagEnums.APPLY_USER.getFlag(),applyUser);
        //合同生成前确认人id
        variables.put(ActContGenerationFlagEnums.CONFIRM_USER.getFlag(),confirmUser);
        //合同生成人id
        variables.put(ActContGenerationFlagEnums.PROCESS_GENERATE_USER.getFlag(),processGenerateUser);
        //合同打印人id
        variables.put(ActContGenerationFlagEnums.PROCESS_PRINT_USER.getFlag(),processPrintUser);
        //业务员确认id
        variables.put(ActContGenerationFlagEnums.SALES_USER.getFlag(),salesUser);
        //请款人id
        variables.put(ActContGenerationFlagEnums.PROCESS_REQUES_FUNDS_USER.getFlag(),processRequesFundsUser);
        ActUtils.putVariables(variables,ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getKey(),
                ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getDesc(),serviceType,serviceName,serviceId.toString(),startUser,startUserName);
        return variables;
    }





}
