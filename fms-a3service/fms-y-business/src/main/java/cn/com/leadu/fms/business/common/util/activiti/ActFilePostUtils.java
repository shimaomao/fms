package cn.com.leadu.fms.business.common.util.activiti;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFilePostEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
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
 * @author qiaomengnan
 * @ClassName: ActFilePostUtils
 * @Description: 原件邮寄工作流工具类
 * @date 2018/5/8
 */
@Component
@Slf4j
public class ActFilePostUtils {

    /**
     * @Fields  : 单例辅助
     * @author qiaomengnan
     */
    private static ActFilePostUtils actFilePostUtils = null;

    public ActFilePostUtils(){
        actFilePostUtils = this;
    }

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * @Title:
     * @Description: 启动原件邮寄
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo startFilePost(String serviceId, String serviceType, String serviceName){
        //当前登录用户就是申请录入人员
        String postUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        //设置原件邮寄人
        variables.put(ActFilePostEnums.FILE_POST_USER.getFlag(),postUser);
        ActUtils.putVariables(variables,ActProcessInstanceKeyEnums.FILE_POST.getKey(),
                ActProcessInstanceKeyEnums.FILE_POST.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actFilePostUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.FILE_POST.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actFilePostUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 完成原件邮寄
     * @param: taskId 任务id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/8 20:17
     */
    public static ActRuTaskVo completeFilePost(String taskId){
        //第一条任务是申请录入人的
        Task task = actFilePostUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        //拿到表单属性
        Map<String,String> formData = ActUtils.getTaskFormData(taskId);
        String userUnit = formData.get(ActFilePostEnums.FILE_POST_RECEIVE_USER_UNIT.getFlag());
        String userId = formData.get(ActFilePostEnums.FILE_POST_RECEIVE_USER_ID.getFlag());
        //取到签收人
        Object receiveUser =  ActUtils.getNextUser(userId,userUnit);
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        variables.put(ActFilePostEnums.FILE_POST_RECEIVE_USER.getFlag(),receiveUser);
        //确认邮寄
        actFilePostUtils.taskService.complete(taskId,variables);
        //返回任务详情
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @Title:
     * @Description: 原件邮寄启动并完成
     * @param:  serviceId 业务id
     * @param:  serviceType 业务类型
     * @param:  serviceName 业务名称
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/8 20:16
     */
    public static ActRuTaskVo startFilePostAndComplete(String serviceId, String serviceType, String serviceName){
        //当前登录用户就是申请录入人员
        String postUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String,Object> variables = new HashMap<>();
        //设置原件邮寄人
        variables.put(ActFilePostEnums.FILE_POST_USER.getFlag(),postUser);
        ActUtils.putVariables(variables,ActProcessInstanceKeyEnums.FILE_POST.getKey(),
                ActProcessInstanceKeyEnums.FILE_POST.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actFilePostUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.FILE_POST.getKey(),serviceId,variables);
        //第一条任务是申请录入人的
        Task task = actFilePostUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();

        //拿到表单属性
        Map<String,String> formData = ActUtils.getTaskFormData(task.getId());
        String userUnit = formData.get(ActFilePostEnums.FILE_POST_RECEIVE_USER_UNIT.getFlag());
        String userId = formData.get(ActFilePostEnums.FILE_POST_RECEIVE_USER_ID.getFlag());
        //取到签收人
        Object receiveUser =  ActUtils.getNextUser(userId,userUnit);
        Map<String,Object> completeVariables = new HashMap<>();
        completeVariables.put(ActFilePostEnums.FILE_POST_RECEIVE_USER.getFlag(),receiveUser);
        //确认邮寄
        actFilePostUtils.taskService.complete(task.getId(),completeVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }


}
