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
 * @ClassName: ActOrigFileSortUtils
 * @Description: 原件归档工作流工具类
 * @author lijunjun
 * @date 2018/5/8
 */
@Component
@Slf4j
public class ActOrigFileSortUtils {

    /**
     * @Fields  : 单例辅助
     * @author lijunjun
     */
    private static ActOrigFileSortUtils actOrigFileSortUtils = null;

    /**
     * @Fields  : 每个流程节点的审批状态名称
     * @author lijunjun
     */
    private static Map<String,String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields  : 需要设置用户的节点
     * @author lijunjun
     */
    private static String [] userDefKeys = null;

    public ActOrigFileSortUtils(){

        actOrigFileSortUtils = this;
        approvalStatusNames.put(ActOrigFileSortEnums.ORIG_FILE_REVIEW.getFlag(),ActOrigFileSortEnums.REVIEW_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[] { ActOrigFileSortEnums.ORIG_FILE_SORT_APPLY.getFlag()};
    }

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * @Title:
     * @Description: 启动原件归档
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo startOrigFileSort(String serviceId, String serviceType, String serviceName, Map<String, Object> paramVariables){
        //当前登录用户就是申请录入人员
        String postUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActFileBorrowTaskEnums.PARAM_VARIABLES.getFlag(), paramVariables);
        //设置原件归档人
        variables.put(ActOrigFileSortEnums.APPLY_USER.getFlag(),postUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.ORIG_FILE_SORT.getKey(),
                ActProcessInstanceKeyEnums.ORIG_FILE_SORT.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actOrigFileSortUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.ORIG_FILE_SORT.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actOrigFileSortUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String,Object> taskVariables =  setReviewUser(task);
        actOrigFileSortUtils.taskService.complete(task.getId(),taskVariables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 资管复核通过
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo origFileReviewAgree(String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空");
        }
        Task task = actOrigFileSortUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task == null){
            throw new FmsServiceException("任务不存在");
        }
        if (ArrayUtils.equalsContains(userDefKeys,task.getTaskDefinitionKey())){
            //如果是需要设置操作人的节点则进行设置操作人
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId, setUser(task));
        }else{
            //否则正常走下一步
            return approval(ActFileBorrowTaskStatusEnums.AGREE.getFlag(),taskId);
        }
    }


    /**
     * @Title:
     * @Description:   设置相应节点的审批人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/04/09 02:53:21
     */
    private static Map<String,Object> setUser(Task task){
        if(task.getTaskDefinitionKey().equals(ActOrigFileSortEnums.ORIG_FILE_SORT_APPLY.getFlag())){
            return setReviewUser(task);
        } else {
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
     * @author lijunjun
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId){
        if(StringUtils.isTrimBlank(taskId)){
            throw new FmsServiceException("任务id不能为空 ");
        }
        Map<String,Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
        actOrigFileSortUtils.taskService.complete(taskId,variables);
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
     * @author lijunjun
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status,String taskId,Map<String,Object> variables){
        Task task = ActUtils.getTask(taskId);
        if (StringUtils.isNotTrimBlank(getApprovalStatusName(task.getTaskDefinitionKey()))){
            variables.put(getApprovalStatusName(task.getTaskDefinitionKey()),status);
            actOrigFileSortUtils.taskService.complete(taskId,variables);
        } else {
            actOrigFileSortUtils.taskService.complete(taskId);
        }
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 获取当前节点对应的状态参数
     * @param: taskDefinitionKey
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  15:35
     */
    public static String getApprovalStatusName(String taskDefinitionKey){
        if(StringUtils.isTrimBlank(taskDefinitionKey)){
            throw new FmsServiceException("taskDefinitionKey不能为空");
        }
        //流程节点状态名称
        String approvalStatusName = approvalStatusNames.get(taskDefinitionKey);
        return approvalStatusName;
    }

    /**
     * @Title:
     * @Description: 设置资料邮寄人
     * @param task 任务
     * @return
     * @throws
     * @author lijunjun
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
        if(StringUtils.isTrimBlank(taskVariables.get(ActOrigFileSortEnums.REVIEW_USER.getFlag()))){
            String reviewUserUnit = formPropertyMap.get(ActOrigFileSortEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActOrigFileSortEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId,reviewUserUnit);
            LogUtils.infoLine(log,"流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActOrigFileSortEnums.REVIEW_USER.getFlag(),reviewUser);
        }
        return results;
    }


    private static Map<String,Object> getTaskVariables(String executionId){
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String,Object> taskVariables = actOrigFileSortUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  taskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId){
        return approval(ActFileBorrowTaskStatusEnums.RETURN_SUPERIOR.getFlag(),taskId);
    }

}
