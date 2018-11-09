package cn.com.leadu.fms.business.common.util.activiti;
/**
 * Created by yyq on 2018/5/17.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActCapitalAssetsEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActStatusEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
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
 * @program: fms
 * @description: 转固定资产工作流工具类
 * @author: huzongcheng
 **/
@Component
@Slf4j
public class ActCapitalAssetsUtils {
    /**
     * 单例
     */
    private static ActCapitalAssetsUtils actCapitalAssetsUtils = null;

    /**
     * @Fields : 每个流程节点的审批状态名称
     * @author yangyiquan
     */
    private static Map<String, String> approvalStatusNames = new HashMap<>();

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    public ActCapitalAssetsUtils() {
        actCapitalAssetsUtils = this;
        approvalStatusNames.put(ActCapitalAssetsEnums.CAPITAL_ASSETS_APPLY.getFlag(), ActCapitalAssetsEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActCapitalAssetsEnums.CAPITAL_ASSETS_MANAGER.getFlag(), ActCapitalAssetsEnums.MANAGER_STATUS.getFlag());
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 启动保证金变更申请
     * @param: serviceId 业务id
     * @param: serviceType 业务类型
     * @param: serviceName 业务名称
     * @author yangyiquan
     * @date 2018/5/17 15:22
     */
    public static ActRuTaskVo startCapitalAsstesAndSubmit(String serviceId, String serviceName) {
        //当前登录用户就是申请人员
        String applyUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActCapitalAssetsEnums.APPLY_USER.getFlag(), applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.CAPITAL_ASSETS.getKey(),
          ActProcessInstanceKeyEnums.CAPITAL_ASSETS.getDesc(), null, serviceName, serviceId, startUser, startUserName);
        //启动流程
        ProcessInstance processInstance = actCapitalAssetsUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.CAPITAL_ASSETS.getKey(), serviceId, variables);
        //第一条任务是申请录入人的
        Task task = actCapitalAssetsUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String, Object> taskVariables = setApprovalUser(task);
        taskVariables.put(getApprovalStatusName(task.getTaskDefinitionKey()), ActStatusEnums.AGREE.getFlag());
        //自动设置为完成
        actCapitalAssetsUtils.taskService.complete(task.getId(), taskVariables);
        //返回任务详情信息
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 审批通过
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalAgree(String taskId) {
        if (StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        Task task = actCapitalAssetsUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null)
            throw new FmsServiceException("任务不存在");
        //否则正常走下一步
        return approval(taskId);
    }




    /**
     * @return
     * @throws
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(String taskId) {
        if (StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");
        Task task = ActUtils.getTask(taskId);
        actCapitalAssetsUtils.taskService.complete(taskId);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 获取当前节点对应的状态参数
     * @param: taskDefinitionKey
     * @author qiaomengnan
     * @date 2018/4/16  15:35
     */
    public static String getApprovalStatusName(String taskDefinitionKey) {
        if (StringUtils.isTrimBlank(taskDefinitionKey))
            throw new FmsServiceException("taskDefinitionKey不能为空");
        //流程节点状态名称
        String approvalStatusName = approvalStatusNames.get(taskDefinitionKey);
        if (StringUtils.isTrimBlank(approvalStatusName)) {
            throw new FmsServiceException("taskDefinitionKey对应的状态标识不存在");
        }
        return approvalStatusName;
    }


    /**
     * @param task 任务
     * @return
     * @throws
     * @Title:
     * @Description: 设置审批人
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setApprovalUser(Task task) {
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String, Object> results = new HashMap<>();
        // 设定总经理审批人
        String managerUserId = formPropertyMap.get(ActCapitalAssetsEnums.MANAGER_USER_ID.getFlag());
        String managerUserUnit = formPropertyMap.get(ActCapitalAssetsEnums.MANAGER_USER_UNIT.getFlag());
        Object managerUser = ActUtils.getNextUser(managerUserId, managerUserUnit);
        LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(managerUser));
        results.put(ActCapitalAssetsEnums.MANAGER_USER.getFlag(), managerUser);
        return results;
    }

}
