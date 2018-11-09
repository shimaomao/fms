package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActStatusEnums;
import cn.com.leadu.fms.business.rpc.system.SysUserRpc;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.CommonInfoLevel;
import cn.com.leadu.fms.common.constant.enums.CommonInfoType;
import cn.com.leadu.fms.common.constant.enums.CommonUserInfoReadStatusEnums;
import cn.com.leadu.fms.common.constant.enums.CommonUserUnitsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.entity.BaseUser;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.system.repository.SysInfoRepository;
import cn.com.leadu.fms.data.system.repository.SysUserInfoRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysInfo;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.FormService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qiaomengnan
 * @ClassName: ActUtils
 * @Description: 工作流通用工具类
 * @date 2018/4/8
 */
@Component
@Slf4j
public class ActUtils {

    /**
     * @Fields  : 单例辅助
     * @author qiaomengnan
     */
    private static ActUtils actUtils = null;

    /**
     * @Fields  : 每个流程中serviceType的含义
     * @author qiaomengnan
     */
    private static Map<String,Map<Object,String>> processInstanceServiceType = new HashMap<>();

    /**
     * @Title:
     * @Description:   注入单例
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/10 02:19:36
     */
    public ActUtils(){
        actUtils = this;
        //合同生成
        Map<Object,String> contServiceType = new HashMap<>();
        contServiceType.put(ApplyTypeEnums.PERSON.getType(),ApplyTypeEnums.PERSON.getDesc());
        contServiceType.put(ApplyTypeEnums.COMPANY.getType(),ApplyTypeEnums.COMPANY.getDesc());
        processInstanceServiceType.put(ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getKey(),contServiceType);
    }

    @Autowired
    private SysUserRpc sysUserRpc;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private SysInfoRepository sysInfoRepository;

    @Autowired
    private SysUserInfoRepository sysUserInfoRepository;

    /**
     * @Fields  : 工作流日志Service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Title:
     * @Description:   完成任务
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 09:24:10
     */
    public static ActRuTaskVo complete(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        Task task = actUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null)
            throw new FmsServiceException("任务不存在");
        actUtils.taskService.complete(taskId);
        return getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 获取并设置任务的默认值，例如备注 业务参数等等
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17 15:09
     */
    public static void setDefaultValue(ActRuTaskVo taskVo){
        //拿到任务流程的参数
        Map<String,Object> variables = actUtils.runtimeService.getVariables(taskVo.getExecutionId());
        if(variables != null){
            taskVo.setServiceId(StringUtils.getValue(variables.get(ActFlagEnums.SERVICE_ID.getFlag())));
            taskVo.setProcessInstanceType(StringUtils.getValue(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag())));
            taskVo.setServiceParameter(variables);
            taskVo.setTitle(StringUtils.getValue(variables.get(ActFlagEnums.TASK_TITLE.getFlag())));
            taskVo.setServiceType(StringUtils.getValue(variables.get(ActFlagEnums.SERVICE_TYPE.getFlag())));
            taskVo.setServiceTypeDesc(getServiceTypeDesc(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()),variables.get(ActFlagEnums.SERVICE_TYPE.getFlag())));
            taskVo.setApplyUser(StringUtils.getValue(variables.get(ActFlagEnums.APPLY_USER.getFlag())));
            taskVo.setServiceName(StringUtils.getValue(variables.get(ActFlagEnums.SERVICE_NAME.getFlag())));
            taskVo.setCodeName(StringUtils.getValue(variables.get(ActFlagEnums.TASK_CODE_NAME.getFlag())));
            taskVo.setSuperiorTaskUser(StringUtils.getValue(variables.get(ActFlagEnums.SUPERIOR_TASK_USER.getFlag())));
            taskVo.setStartUser(StringUtils.getValue(variables.get(ActFlagEnums.START_USER.getFlag())));
            taskVo.setStartUserName(StringUtils.getValue(variables.get(ActFlagEnums.START_USER_NAME.getFlag())));
            StringBuffer remark = new StringBuffer();
            //备注
            if(ActProcessInstanceKeyEnums.CONTRACT_GENERATION.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是合同生成类型 备注需要拿到 订单编号  合同编号
                remark.append("订单编号:");
                remark.append(taskVo.getServiceId());
                String contNo = MapUtils.getMapValueToString(variables.get(ActContGenerationFlagEnums.CONTRACT_QUANTITY.getFlag()),ActContGenerationFlagEnums.CONT_NO.getFlag());

                if(StringUtils.isNotTrimBlank(contNo)) {
                    taskVo.setServiceName(StringUtils.getValue(actUtils.runtimeService.getVariableLocal(taskVo.getExecutionId(),ActFlagEnums.SERVICE_NAME.getFlag())));
                    remark.append(",");
                    remark.append("合同编号:");
                    remark.append(MapUtils.getMapValueToString(variables.get(ActContGenerationFlagEnums.CONTRACT_QUANTITY.getFlag()), ActContGenerationFlagEnums.CONT_NO.getFlag()));
                }
            }else if(ActProcessInstanceKeyEnums.FILE_POST.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是原件邮寄，备注拿到快递公司 以及快递单号
                remark.append("快递公司:");
                remark.append(taskVo.getServiceName());
                remark.append(",");
                remark.append("快递单号:");
                remark.append(taskVo.getServiceId());
            }else if(ActProcessInstanceKeyEnums.CONT_PREPAYMENT.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是提前还款，拿到合同编号
                remark.append("任务号:");
                remark.append(taskVo.getServiceId());
                remark.append("，合同编号:");
                remark.append(taskVo.getServiceName());
            }else if(ActProcessInstanceKeyEnums.INSUR_CLAIM_CHECK.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是保险理赔
                String []  str = taskVo.getServiceId().split("-");
                if(str.length == 2){
                    remark.append("合同编号:");
                    remark.append(str[0]);
                    remark.append("，报案号:");
                    remark.append(str[1]);
                }
            }else if(ActProcessInstanceKeyEnums.FILE_BORROW_TASK.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是原件借阅
                remark.append("借阅任务号:");
                remark.append(taskVo.getServiceId());
                remark.append("，归档编号:");
                remark.append(taskVo.getServiceName());
            }else if(ActProcessInstanceKeyEnums.FILE_BORROW_BACK_TASK.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是借阅归还
                remark.append("归还任务号:");
                remark.append(taskVo.getServiceId());
                remark.append("，归档编号:");
                remark.append(taskVo.getServiceName());
            }else if(ActProcessInstanceKeyEnums.ORIG_FILE_SORT.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是原件归档
                remark.append("归档任务号:");
                remark.append(taskVo.getServiceId());
            }else if(ActProcessInstanceKeyEnums.INVOICE_CHANGE.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是开票信息变更
                remark.append("开票信息变更任务号:");
                remark.append(taskVo.getServiceId());
            }else if(ActProcessInstanceKeyEnums.BASIC_CHANGE.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是基本信息变更
                remark.append("基本信息变更任务号:");
                remark.append(taskVo.getServiceId());
            }else if(ActProcessInstanceKeyEnums.DEPOSIT_CHANGE.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是原件归档
                remark.append("保证金变更任务号:");
                remark.append(taskVo.getServiceId());
            }else if(ActProcessInstanceKeyEnums.TRANSFER_TASK.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是过户任务
                remark.append("过户任务号:");
                remark.append(taskVo.getServiceId());
                remark.append("合同编号:");
                remark.append(taskVo.getServiceName());
            }else if(ActProcessInstanceKeyEnums.COLLECTION_TASK.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是上门催收任务
                remark.append("上门催收任务号:");
                remark.append(taskVo.getServiceId());
            }else if(ActProcessInstanceKeyEnums.LAWSUIT_TASK.getKey().equals(variables.get(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag()))){
                //如果是诉讼任务
                remark.append("诉讼任务号:");
                remark.append(taskVo.getServiceId());
            }
            taskVo.setServiceRemark(remark.toString());
        }
    }

    /**
     * @Title:
     * @Description: 通过任务id获取任务
     * @param:  taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16 14:27
     */
    public static Task getTask(String taskId){
        if(StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        return actUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
    }

    /**
     * @Title:
     * @Description: 获取业务类型描述
     * @param: processInstanceType 流程类型
     * @param: serviceType 业务类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17 14:53
     */
    public static String getServiceTypeDesc(Object processInstanceType , Object serviceType){
        if(processInstanceServiceType.get(processInstanceType) != null)
            return processInstanceServiceType.get(processInstanceType).get(serviceType);
        return null;
    }

    /**
     * @Title:
     * @Description: 修改业务名称
     * @param:  taskId 任务id
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19  11:57
     */
    public static void modifyServiceName(String taskId,String serviceName){
        if(StringUtils.isTrimBlank(taskId))
            new FmsServiceException("任务id不能为空");
        if(StringUtils.isTrimBlank(serviceName))
            new FmsServiceException("业务名称不能为空");
        modifyVariable(taskId,ActFlagEnums.SERVICE_NAME.getFlag(),serviceName);
    }

    /**
     * @Title:
     * @Description:
     * @param: taskId 任务id
     * @param: key 任务id
     * @param: value 任务id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19  11:57
     */
    private static void modifyVariable(String taskId,String key,String value){
        actUtils.taskService.setVariable(taskId,key,value);
    }

    /**
     * @Title:
     * @Description: 拿到task详情信息，并获取到下一节点的信息 (拿到下一步走向的人员)，前提是下一步即使是多实例，也是同一人员代理
     * @param: task 当前节点
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/7  16:29
     */
    public static ActRuTaskVo getActRuTaskVoAndNextInfo(Task task){
        return getActRuTaskVo(task,false);
    }

    /**
     * @Title:
     * @Description: 拿到task详情信息，并获取到下一节点的信息 (拿到下一步走向的人员)，前提是下一步即使是多实例，也是同一人员代理
     * @param: task 当前节点
     * @param: subProcess 是否存在子流程 true存在 false不存在
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/7  16:29
     */
    public static ActRuTaskVo getActRuTaskVoAndNextInfo(Task task,boolean subProcess){
        return getActRuTaskVo(task,subProcess);
    }

    /**
     * @Title:
     * @Description: 拿到task详情信息，并获取到下一节点的信息 (拿到下一步走向的人员)，前提是下一步即使是多实例，也是同一人员代理
     * @param: task 当前节点
     * @param: subProcess 是否存在子流程 true存在 false不存在
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/7  16:29
     */
    private static ActRuTaskVo getActRuTaskVo(Task task,boolean subProcess){
        ActRuTaskVo actRuTaskVo = EntityUtils.getEntity(task,new ActRuTaskVo());
        //找到同一流程下的下一任务
        Task nextTask = actUtils.taskService.createTaskQuery().executionId(task.getExecutionId()).singleResult();
        //子流程集合(一个流程结束后可能开启了多个相同的子流程)
        List<Task> nextTaskList = null;
        if(nextTask == null) {
            //如果同一流程下的任务没有了,可能开启了子流程,查询子流程
            if(StringUtils.equals(task.getProcessInstanceId(),task.getExecutionId())) {
                nextTaskList = actUtils.taskService.createTaskQuery().processInstanceId(task.getProcessInstanceId()).list();
                if (ArrayUtils.isNotNullAndLengthNotZero(nextTaskList))
                    nextTask = nextTaskList.get(0);
            }
        }
        if(nextTask != null){
            //存放下一任务代理人
            setNextAssignee(actRuTaskVo,nextTask);
            //判断是否有需要发送消息的地方
            Map<String, String> taskFormData = getTaskFormData(nextTask.getId());
            //判断是否有需要发送消息的地方
            sendMsg(taskFormData,task,actRuTaskVo);
            //设置下一节点的状态
            String taskCode = setTaskCode(task,taskFormData,nextTaskList,nextTask,subProcess);
            //设置上一届办理人
            setSuperiorTaskUser(nextTaskList,nextTask);
            //设置节点状态
            actRuTaskVo.setTaskCode(taskCode);
            //节点未结束
            actRuTaskVo.setEndFlag(false);
        }else{
            Map<String, String> taskFormData = getEndFormData(task.getProcessDefinitionId());
            if(taskFormData != null) {
                String taskCode = taskFormData.get(ActFlagEnums.END_STATUS.getFlag());
                actRuTaskVo.setTaskCode(taskCode);
            }
            actRuTaskVo.setNextAssignee("");//流程已经结束，下个节点人清空
            actRuTaskVo.setEndFlag(true);
        }
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 设置下一节点人物
     * @param: actRuTaskVo 下一节点vo
     * @param: nextTask 下一节点任务
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/19 0019 17:51
     */
    private static void setNextAssignee(ActRuTaskVo actRuTaskVo,Task nextTask){
        //存放下一任务代理人
        if(StringUtils.isNotTrimBlank(nextTask.getAssignee())) {
            actRuTaskVo.setNextAssignee(nextTask.getAssignee());
        }else{
            List<IdentityLink> identityLinks = actUtils.taskService.getIdentityLinksForTask(nextTask.getId());
            if(ArrayUtils.isNotNullAndLengthNotZero(identityLinks)){
                StringBuffer nextAssignees = new StringBuffer();
                identityLinks.forEach(identityLink -> {
                    nextAssignees.append(identityLink.getUserId() + StringUtils.COMMA);
                });
                if(nextAssignees.length() > 0)
                    actRuTaskVo.setNextAssignee(nextAssignees.deleteCharAt(nextAssignees.length() - 1).toString());
            }
        }
    }

    /**
     * @Title:
     * @Description:  判断是否有需要发送消息的地方
     * @param: taskFormData 下一节点formData
     * @param: task  当前节点
     * @param: actRuTaskVo 下一节点vo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/19 0019 16:20
     */
    private static void sendMsg(Map<String, String> taskFormData,Task task,ActRuTaskVo actRuTaskVo){
        //判断是否有需要发送消息的地方
        String messageStatusName = taskFormData.get(ActFlagEnums.MESSAGE_STATUS_NAME.getFlag());
        if (StringUtils.isNotTrimBlank(messageStatusName)) {
            Object result = actUtils.runtimeService.getVariable(task.getExecutionId(), messageStatusName);
            if(result != null) {
                String message = taskFormData.get(result.toString());
                if (result != null && StringUtils.isNotTrimBlank(message)) {
                    //消息存在，进行发送
                    sendInfo(message, actRuTaskVo.getNextAssignee());
                }
            }
        }
    }

    /**
     * @Title:
     * @Description:  设置下一节点的状态
     * @param: task   当前节点
     * @param: taskFormData  下一节点formData
     * @param: nextTaskList 下一节点集合 两者只可能有一个存在
     * @param: nextTask 下一节点 两者只可能有一个存在
     * @param: subProcess 是否存在子流程
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/19 0019 16:09
     */
    private static String setTaskCode(Task task,Map<String,String> taskFormData, List<Task> nextTaskList,Task nextTask,boolean subProcess){
        String taskCode = null;
        //设置将要在列表中显示的环节名称
        //用上一级节点的定义key 拼接
        String property = task.getTaskDefinitionKey() + ActFlagEnums.STATUS_NAME_SUFFIX.getFlag();
        //查看当前节点状态是否有对应statusName定义
        String statusName = taskFormData.get(property);
        //查询是否是被退回
        if(StringUtils.isNotTrimBlank(statusName)){
            //获取状态
            Object result = null;
            if(subProcess)
                result = actUtils.runtimeService.getVariableLocal(task.getExecutionId(), statusName);
            else
                result = actUtils.runtimeService.getVariable(task.getExecutionId(), statusName);
            if(result != null){
                taskCode = taskFormData.get(task.getTaskDefinitionKey() + ActFlagEnums.STATUS_NAME.getFlag() + result);
            }
        }
        //查询是否是二次提交
        if(StringUtils.isTrimBlank(taskCode)){
            statusName = taskFormData.get(ActFlagEnums.EXIST_STATUS_NAMES.getFlag());
            if(StringUtils.isNotTrimBlank(statusName)) {
                //获取状态
                Object result = null;
                if(subProcess)
                    result = actUtils.runtimeService.getVariableLocal(task.getExecutionId(), statusName);
                else
                    result = actUtils.runtimeService.getVariable(task.getExecutionId(), statusName);
                if (result != null) {
                    taskCode = taskFormData.get(ActFlagEnums.EXIST_STATUS.getFlag());
                }
            }
        }
        //取默认名称
        if(StringUtils.isTrimBlank(taskCode)){
            taskCode = taskFormData.get(ActFlagEnums.DEFAULT_STATUS.getFlag());
        }
        //存入流程变量
        if(StringUtils.isNotTrimBlank(taskCode)){
            if(ArrayUtils.isNullOrLengthZero(nextTaskList))
                actUtils.runtimeService.setVariableLocal(nextTask.getExecutionId(),ActFlagEnums.TASK_CODE_NAME.getFlag(),taskCode);
            else{
                //多个相同的子流程,设置相同的节点taskCode
                for(Task taskTmp : nextTaskList){
                    actUtils.runtimeService.setVariableLocal(taskTmp.getExecutionId(),ActFlagEnums.TASK_CODE_NAME.getFlag(),taskCode);
                }
            }
        }
        return taskCode;
    }

    /**
     * @Title:
     * @Description: 设置上一届办理人
     * @param: nextTaskList 下一节点集合 两者只可能有一个存在
     * @param: nextTask 下一节点 两者只可能有一个存在
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/19 0019 15:56
     */
    private static void setSuperiorTaskUser(List<Task> nextTaskList,Task nextTask){
        BaseUser baseUser = UserInfoUtils.getUser();
        if(baseUser != null) {
            String userName = StringUtils.isNotTrimBlank(baseUser.getUserName())?baseUser.getUserName():baseUser.getUser();
            //存放上一节点的处理人
            if (ArrayUtils.isNullOrLengthZero(nextTaskList))
                actUtils.runtimeService.setVariableLocal(nextTask.getExecutionId(), ActFlagEnums.SUPERIOR_TASK_USER.getFlag(),userName);
            else {
                //多个相同的子流程,设置相同的节点taskCode
                for (Task taskTmp : nextTaskList) {
                    actUtils.runtimeService.setVariableLocal(taskTmp.getExecutionId(), ActFlagEnums.SUPERIOR_TASK_USER.getFlag(), userName);
                }
            }
        }
    }

    /**
     * @Title:
     * @Description:   保存发送消息值
     * @param content
     * @param nextUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 03:21:23
     */
    private static void sendInfo(String content,String nextUser){
        SysInfo sysInfo = new SysInfo();
        sysInfo.setInfoContent(content);
        sysInfo.setInfoLevel(CommonInfoLevel.IMPORTANT.getLevel());
        sysInfo.setInfoType(CommonInfoType.TASK.getType());
        actUtils.sysInfoRepository.insertData(sysInfo);
        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setInfoId(sysInfo.getInfoId());
        sysUserInfo.setUser(nextUser);
        sysUserInfo.setReadStatus(CommonUserInfoReadStatusEnums.UNREAD.getStatus());
        actUtils.sysUserInfoRepository.insertData(sysUserInfo);
    }


    public static Map<String,Object> getTaskVariables(String executionId){
        Map<String,Object> taskVariables = actUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }

    /**
     * @Title:
     * @Description: 拿到当前任务的表单属性
     * @param:  taskId 任务id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/8  20:19
     */
    public static Map<String,String> getTaskFormData(String taskId){
        //拿出表单每个节点审批人的信息
        TaskFormData taskFormData = actUtils.formService.getTaskFormData(taskId);
        List<FormProperty> formProperties = taskFormData.getFormProperties();
        Map<String,String> formPropertyMap = new HashMap<>();
        for(FormProperty formProperty : formProperties){
            formPropertyMap.put(formProperty.getId(),formProperty.getName());
        }
        return formPropertyMap;
    }

    /**
     * @Title:
     * @Description:   拿到已结束流程的结束状态
     * @param processDefinitionId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 10:24:05
     */
    public static Map<String,String> getEndFormData(String processDefinitionId){
        StartFormData startFormData = actUtils.formService.getStartFormData(processDefinitionId);
        List<FormProperty> formProperties = startFormData.getFormProperties();
        if(ArrayUtils.isNotNullAndLengthNotZero(formProperties)) {
            Map<String, String> taskFormData = formProperties.stream().collect(Collectors.toMap(FormProperty::getId, FormProperty::getName));
            return taskFormData;
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 根据id和身份标识获取具体下一步代理人
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  21:07
     */
    public static Object getNextUser(String userId,String userUnit){
        //判空
        if(StringUtils.isTrimBlank(userUnit))
            throw new FmsServiceException("单位不能为空");
        //判空
        if(StringUtils.isTrimBlank(userId))
            throw new FmsServiceException("单位id不能为空");
        //下一节点用户
        Object nextUser = null;
        //保存非会签用户列表,作随机抽取一个操作
        List<String> nextUsers = null;
        //判断用户单位
        if(CommonUserUnitsEnums.USER.getUnit().equals(userUnit)){
            //个人
            nextUser = userId;
        } else if(CommonUserUnitsEnums.ROLE.getUnit().equals(userUnit)){
            //角色
            nextUsers = ActUtils.findSysUserLoginNamesByRole(userId);
        } else if(CommonUserUnitsEnums.GROUP.getUnit().equals(userUnit)){
            //组织机构
            nextUsers = ActUtils.findSysUserLoginNamesByGroupCode(userId);
        } else if(CommonUserUnitsEnums.USER_SIGN.getUnit().equals(userUnit)){
            //个人会签
            nextUser = ArrayUtils.asList(userId.split(StringUtils.COMMA));
        } else if(CommonUserUnitsEnums.ROLE_SIGN.getUnit().equals(userUnit)){
            //角色会签
            nextUser = ActUtils.findSysUserLoginNamesByRoles(ArrayUtils.asList(userId.split(StringUtils.COMMA)));
        } else if(CommonUserUnitsEnums.GROUP_SIGN.getUnit().equals(userUnit)){
            //组织机构会签
            nextUser = ActUtils.findSysUserLoginNamesByGroupCodes(ArrayUtils.asList(userId.split(StringUtils.COMMA)));
        } else {
            throw new FmsServiceException("单位:" + userUnit + ",id:" + userId + ",用户单位不存在");
        }
        //如果是多用户非会签,则采用随机方式
        if(ArrayUtils.isNotNullAndLengthNotZero(nextUsers))
            nextUser = randomGetApprovalUser(nextUsers);
        //不存在抛异常
        if( nextUser == null || ( nextUser instanceof String && StringUtils.isTrimBlank(nextUser) ) || (nextUser instanceof List && ((List)nextUser).size() < 1 ) ){
            throw new FmsServiceException("单位:" + userUnit + ",id:" + userId + ",未获取到用户信息");
        }
        LogUtils.infoLine(log,"下一节点人员是：" + JSON.toJSONString(nextUser));
        return nextUser;
    }

    /**
     * @Description:  根据id和身份标识,用户组代码获取具体下一步代理人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/12 15:00
     */
    public static Object getNextUserWithGroupCode(String userId,String userUnit,String groupCode){
        //判空
        if(StringUtils.isTrimBlank(userUnit))
            throw new FmsServiceException("单位不能为空");
        //判空
        if(StringUtils.isTrimBlank(userId))
            throw new FmsServiceException("单位id不能为空");
        //判空
        if(StringUtils.isTrimBlank(groupCode))
            throw new FmsServiceException("用户组代码不能为空");
        //下一节点用户
        Object nextUser = null;
        //保存非会签用户列表,作随机抽取一个操作
        List<String> nextUsers = null;
        //判断用户单位
        if(CommonUserUnitsEnums.USER.getUnit().equals(userUnit)){
            //个人
            nextUser = userId;
        } else if(CommonUserUnitsEnums.ROLE.getUnit().equals(userUnit)){
            //角色
            nextUsers = ActUtils.findSysUserLoginNamesByRolesWithGroupCode(ArrayUtils.asList(userId.split(StringUtils.COMMA)),groupCode);
        } else if(CommonUserUnitsEnums.USER_SIGN.getUnit().equals(userUnit)){
            //个人会签
            nextUser = ArrayUtils.asList(userId.split(StringUtils.COMMA));
        } else if(CommonUserUnitsEnums.ROLE_SIGN.getUnit().equals(userUnit)){
            //角色会签
            nextUser = ActUtils.findSysUserLoginNamesByRolesWithGroupCode(ArrayUtils.asList(userId.split(StringUtils.COMMA)),groupCode);
        }else {
            throw new FmsServiceException("单位:" + userUnit + ",id:" + userId + ",用户单位不存在");
        }
        //如果是多用户非会签,则采用随机方式
        if(ArrayUtils.isNotNullAndLengthNotZero(nextUsers))
            nextUser = randomGetApprovalUser(nextUsers);
        //不存在抛异常
        if( nextUser == null || ( nextUser instanceof String && StringUtils.isTrimBlank(nextUser) ) || (nextUser instanceof List && ((List)nextUser).size() < 1 ) ){
            throw new FmsServiceException("单位:" + userUnit + ",id:" + userId + ",用户组代码："+ groupCode +",未获取到用户信息");
        }
        LogUtils.infoLine(log,"下一节点人员是：" + JSON.toJSONString(nextUser));
        return nextUser;
    }

    /**
     * @Title:
     * @Description: 系统随机抽取代理人
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  21:07
     */
    public static String randomGetApprovalUser(List<String> approvalUsers){
        if(ArrayUtils.isNotNullAndLengthNotZero(approvalUsers)){
            int index = (int)(Math.random()*approvalUsers.size());
            return approvalUsers.get(index);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   设置共通用到的值
     * @param variables
     * @param processInstanceType
     * @param taskTitle
     * @param serviceType
     * @param serviceName
     * @param serviceId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/10 11:01:56
     */
    public static void putVariables(Map<String,Object> variables,String processInstanceType
            ,String taskTitle,String serviceType,String serviceName,String serviceId,String startUser,String startUserName){
        //流程类型key
        variables.put(ActFlagEnums.PROCESS_INSTANCE_TYPE.getFlag(), processInstanceType);
        //任务标题
        variables.put(ActFlagEnums.TASK_TITLE.getFlag(),taskTitle);
        //业务类型
        variables.put(ActFlagEnums.SERVICE_TYPE.getFlag(),serviceType);
        //业务名称
        variables.put(ActFlagEnums.SERVICE_NAME.getFlag(),serviceName);
        //业务id
        variables.put(ActFlagEnums.SERVICE_ID.getFlag(),serviceId);
        //任务发起人账号
        variables.put(ActFlagEnums.START_USER.getFlag(),startUser);
        //任务发起人姓名
        variables.put(ActFlagEnums.START_USER_NAME.getFlag(),startUserName);
    }



    /**
     * @Title:
     * @Description:   根据组织机构code查询用户列表
     * @param groupCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    public static List<String> findSysUserLoginNamesByGroupCode(String groupCode){
        try {
            return ResponseEntityUtils.getRestResponseData(actUtils.sysUserRpc.findSysUserLoginNamesByGroupCode(groupCode));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("获取用户失败");
        }
    }

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param role
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 05:13:18
     */
    public static List<String> findSysUserLoginNamesByRole(String role){
        try {
            return ResponseEntityUtils.getRestResponseData(actUtils.sysUserRpc.findSysUserLoginNamesByRole(role));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("获取用户失败");
        }
    }

    /**
     * @Title:
     * @Description:   根据组织机构code集合查询用户列表
     * @param groupCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    public static List<String> findSysUserLoginNamesByGroupCodes(List<String> groupCodes){
        try {
            return ResponseEntityUtils.getRestResponseData(actUtils.sysUserRpc.findSysUserLoginNamesByGroupCodes(groupCodes));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("获取用户失败");
        }
    }

    /**
     * @Title:
     * @Description:   根据roleId集合查询用户登录名集合
     * @param roles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 05:13:18
     */
    public static List<String> findSysUserLoginNamesByRoles(List<String> roles){
        try {
            return ResponseEntityUtils.getRestResponseData(actUtils.sysUserRpc.findSysUserLoginNamesByRoles(roles));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("获取用户失败");
        }
    }

    /**
     * @Description:  根据roleId集合和组织机构（当前机构没有则向上级查询）代码查询用户登录名集合
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/12 15:04
     */
    public static List<String> findSysUserLoginNamesByRolesWithGroupCode(List<String> roles,String groupCode){
        try {
            return ResponseEntityUtils.getRestResponseData(actUtils.sysUserRpc.findSysUserLoginNamesByRolesWithGroupCode(roles,groupCode));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("获取用户失败");
        }
    }


    /**
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: task
     * @param: taskDefinitionKeyCheck
     * @param: userDefKeys
     * @param: userDefUnitKeys
     * @param: usersDesc
     * @param: approvalStatusNames
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    public static ActRuTaskVo approval(Integer status,Task task,String taskDefinitionKeyCheck,
                                       Map<String,String[]>  userDefKeys,
                                       Map<String,Map<String,String>> userDefUnitKeys,
                                       Map<String,String> usersDesc,
                                       Map<String,String> approvalStatusNames){
        if(task == null)
            throw new FmsServiceException("任务不存在");
        String taskDefinitionKey = task.getTaskDefinitionKey();
        if(!taskDefinitionKey.equals(taskDefinitionKeyCheck))
            throw new FmsServiceException("任务节点错误");
        Object user = null;
        Map<String,Object> variables = new HashMap<>();
        //如果是审核通过,需要判断下一步是否需要设置审核人
        if(ActStatusEnums.AGREE.getFlag().equals(status)) {
            String[] userFlags = userDefKeys.get(taskDefinitionKey);
            if (ArrayUtils.isNotNullAndLengthNotZero(userFlags)) {
                //如果存在,说明下一步需要设置审核人
                //审核人以当前节点设置的人员为准
                //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
                Map<String, Object> taskVariables = ActUtils.getTaskVariables(task.getExecutionId());
                //拿出表单每个节点审批人的信息
                Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
                //拿到节点对应的用户单位信息
                Map<String, String> userInfo = userDefUnitKeys.get(taskDefinitionKey);
                //下标为0，是因为该数组设置的用户都是一样的,一个存在会保证其他也存在
                if (StringUtils.isTrimBlank(taskVariables.get(userFlags[0]))) {
                    String userUnit = formPropertyMap.get(userInfo.get(ActFlagEnums.USER_UNIT.getFlag()));
                    String userId = formPropertyMap.get(userInfo.get(ActFlagEnums.USER_ID.getFlag()));
                    user = ActUtils.getNextUser(userId, userUnit);
                    LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的" + usersDesc.get(userInfo.get(ActFlagEnums.USER_UNIT.getFlag())) + "是: " + JSON.toJSONString(user));
                    //保证该数组的用户都一样设置
                    for (String userFlag : userFlags)
                        variables.put(userFlag, user);
                } else //作多用户设置
                    user = taskVariables.get(userFlags[0]);

            }
        }
        //放入审核状态
        String approvalStatusName = approvalStatusNames.get(taskDefinitionKey);
        if(StringUtils.isNotTrimBlank(approvalStatusName)){
            variables.put(approvalStatusName,status);
        }
        if(variables.size() > 0)
            actUtils.taskService.complete(task.getId(),variables);
        else
            actUtils.taskService.complete(task.getId());
        ActRuTaskVo actRuTaskVo =  ActUtils.getActRuTaskVoAndNextInfo(task);
//        //如果下级用户是多个,则转换赋值    暂时不需要 已废弃
//        if(user != null && user instanceof List){
//            actRuTaskVo.setNextManyUser(true);
//            actRuTaskVo.setNextUsers((List<String>)user);
//            actRuTaskVo.setNextUsersStr(StringUtils.joinDelimiter(StringUtils.COMMA,actRuTaskVo.getNextUsers()));
//        }
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 保存流程日志
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/10  18:34
     */
    public static void saveWorkFlowLog(String memo,String taskCode,String actType,String serviceId,BizTypeEnums bizTypeEnum){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(UserInfoUtils.getUserName());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(memo);
        workflowLog.setStatus(taskCode);
        workflowLog.setActType(actType);
        workflowLog.setWfLogNo(serviceId);
        workflowLog.setWfLogType(bizTypeEnum.getType());
        actUtils.workflowLogService.insertWorkFlowLog(workflowLog);
    }


}
