package cn.com.leadu.fms.business.common.util.activiti;
/**
 * Created by yyq on 2018/5/17.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActDepositChangeEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActDepositChangeStatusEnums;
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
import java.util.List;
import java.util.Map;

/**
 * @program: fms
 * @description: 保证金变更工作流工具类
 * @author: huzongcheng
 **/
@Component
@Slf4j
public class ActDepositChangeUtils {
    /**
     * 单例
     */
    private static ActDepositChangeUtils actDepositChangeUtils = null;

    /**
     * @Fields : 每个流程节点的审批状态名称
     * @author yangyiquan
     */
    private static Map<String, String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields : 需要设置用户的节点
     * @author yangyiquan
     */
    private static String[] userDefKeys = null;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    public ActDepositChangeUtils() {
        actDepositChangeUtils = this;
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_APPLY.getFlag(), ActDepositChangeEnums.APPLY_STATUS.getFlag());
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_APPROVAL.getFlag(), ActDepositChangeEnums.APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_REVIEW.getFlag(), ActDepositChangeEnums.REVIEW_STATUS.getFlag());
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_PRE_AGREE.getFlag(), ActDepositChangeEnums.PRE_AGREE_STATUS.getFlag());
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_CONTRACT_CREATE.getFlag(), ActDepositChangeEnums.CONTRACT_CREATE_STATUS.getFlag());
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_SUPPLE.getFlag(), ActDepositChangeEnums.SUPPLE_STATUS.getFlag());
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_CONTRACT_APPROVE.getFlag(), ActDepositChangeEnums.CONTRACT_APPROVE_STATUS.getFlag());
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_RECEIPT.getFlag(), ActDepositChangeEnums.RECEIPT_STATUS.getFlag());
        approvalStatusNames.put(ActDepositChangeEnums.DEPOSIT_CHANGE_EXPORT.getFlag(), ActDepositChangeEnums.EXPORT_STATUS.getFlag());

        //需要设置用户的节点
        userDefKeys = new String[]{ActDepositChangeEnums.DEPOSIT_CHANGE_APPLY.getFlag(),
                ActDepositChangeEnums.DEPOSIT_CHANGE_APPROVAL.getFlag(),
                ActDepositChangeEnums.DEPOSIT_CHANGE_REVIEW.getFlag(),
                ActDepositChangeEnums.DEPOSIT_CHANGE_PRE_AGREE.getFlag(),
                ActDepositChangeEnums.DEPOSIT_CHANGE_CONTRACT_CREATE.getFlag(),
                ActDepositChangeEnums.DEPOSIT_CHANGE_SUPPLE.getFlag(),
                ActDepositChangeEnums.DEPOSIT_CHANGE_CONTRACT_APPROVE.getFlag(),
                ActDepositChangeEnums.DEPOSIT_CHANGE_RECEIPT.getFlag(),
        };
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 启动保证金变更申请
     * @param: serviceId 业务id
     * @param: serviceType 业务类型
     * @param: serviceName 业务名称
     * @param flag 是否需要初审
     * @author yangyiquan
     * @date 2018/5/17 15:22
     */
    public static ActRuTaskVo startDepositChangeAndSubmit(String serviceId, String serviceName, boolean flag) {
        //当前登录用户就是申请人员
        String applyUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        //构建参数
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActDepositChangeEnums.APPLY_USER.getFlag(), applyUser);
        variables.put(ActDepositChangeEnums.CONTRACT_CREATE_USER.getFlag(), applyUser);
        variables.put(ActDepositChangeEnums.SUPPLE_USER.getFlag(), applyUser);
        ActUtils.putVariables(variables, ActProcessInstanceKeyEnums.DEPOSIT_CHANGE.getKey(),
                ActProcessInstanceKeyEnums.DEPOSIT_CHANGE.getDesc(), null, serviceName, serviceId, startUser, startUserName);
        //启动流程
        ProcessInstance processInstance = actDepositChangeUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.DEPOSIT_CHANGE.getKey(), serviceId, variables);
        //第一条任务是申请录入人的
        Task task = actDepositChangeUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //提前获取到审批人的信息,并设置审批人
        Map<String, Object> taskVariables = setApprovalUser(task, flag);
        //如果需要经过初审
        if(flag){
            taskVariables.put(getApprovalStatusName(task.getTaskDefinitionKey()), ActDepositChangeStatusEnums.AGREE.getStatus());
        } else {
            taskVariables.put(getApprovalStatusName(task.getTaskDefinitionKey()), ActDepositChangeStatusEnums.SEND_TO_REWIEW.getStatus());
        }
        //自动设置为完成
        actDepositChangeUtils.taskService.complete(task.getId(), taskVariables);
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
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actDepositChangeUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null)
            throw new FmsServiceException("任务不存在");
        if (ArrayUtils.equalsContains(userDefKeys, task.getTaskDefinitionKey())) {
     //如果是需要设置审批人的节点则进行设置审批人
     return approval(ActDepositChangeStatusEnums.AGREE.getStatus(), taskId, setUser(task, true));
     } else {
     //否则正常走下一步
     return approval(ActDepositChangeStatusEnums.AGREE.getStatus(), taskId);
     }
     }

     /**
     * @return
     * @throws
     * @Title:
     * @Description: 申请提交给复审
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo submitToReview(String taskId) {
        return approval(ActDepositChangeStatusEnums.SEND_TO_REWIEW.getStatus(), taskId);
    }

    /**
     * @param task 任务
     * @param flag 是否需要初审、是否需要经过财务
     * @return
     * @throws
     * @Title:
     * @Description: 设置相应节点的审批人
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setUser(Task task, boolean flag) {
        if (task.getTaskDefinitionKey().equals(ActDepositChangeEnums.DEPOSIT_CHANGE_APPLY.getFlag())) {
            //申请节点设置复核人
            return setApprovalUser(task, flag);
        } else if (task.getTaskDefinitionKey().equals(ActDepositChangeEnums.DEPOSIT_CHANGE_APPROVAL.getFlag())) {
            //初审节点设置复核人
            return setReviewUser(task);
        } else if (task.getTaskDefinitionKey().equals(ActDepositChangeEnums.DEPOSIT_CHANGE_REVIEW.getFlag())) {
            //复审节点设置副总审核人
            return setPreAgreeUser(task);
        } else if (task.getTaskDefinitionKey().equals(ActDepositChangeEnums.DEPOSIT_CHANGE_PRE_AGREE.getFlag())) {
            //副总审核节点设置合同生成人
            return setContractCreateUser(task);
        } else if (task.getTaskDefinitionKey().equals(ActDepositChangeEnums.DEPOSIT_CHANGE_CONTRACT_CREATE.getFlag())) {
            //合同生成节点补充协议上传人
            return setSuppleUser(task);
        } else if (task.getTaskDefinitionKey().equals(ActDepositChangeEnums.DEPOSIT_CHANGE_SUPPLE.getFlag())) {
            //补充协议上传节点设置合同复核);
            return setContractApproveUser(task);
        } else if (task.getTaskDefinitionKey().equals(ActDepositChangeEnums.DEPOSIT_CHANGE_CONTRACT_APPROVE.getFlag())) {
            if(flag){
                //合同复核节点设置财务收款人
                return setReceiptUser(task);
            } else {
                //合同复核节点设置出库操作人
                return setExportUser(task);
            }
        } else if (task.getTaskDefinitionKey().equals(ActDepositChangeEnums.DEPOSIT_CHANGE_RECEIPT.getFlag())) {
            //财务收款节点设置出库操作人
            return setExportUser(task);
        } else {
            throw new FmsServiceException("此任务节点不需要设置审批人");
        }
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 退回上一级
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalReturnSuperior(String taskId) {
        return approval(ActDepositChangeStatusEnums.RETURN_SUPERIOR.getStatus(), taskId);
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 退回到申请
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalSendToApply(String taskId) {
        return approval(ActDepositChangeStatusEnums.SEND_TO_APPLY.getStatus(), taskId);
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 拒绝
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalRefuse(String taskId) {
        return approval(ActDepositChangeStatusEnums.REFUSE.getStatus(), taskId);
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 合同复合到入库
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalExport(String taskId) {
        if (StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空");
        //审批通过时需要判断当前节点,需要设置下级审批人
        Task task = actDepositChangeUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null)
            throw new FmsServiceException("任务不存在");
        if (ArrayUtils.equalsContains(userDefKeys, task.getTaskDefinitionKey())) {
            //如果是需要设置审批人的节点则进行设置审批人
            return approval(ActDepositChangeStatusEnums.EXPORT.getStatus(), taskId, setUser(task, false));
        } else {
            //否则正常走下一步
            return approval(ActDepositChangeStatusEnums.EXPORT.getStatus(), taskId);
        }
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 结束
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalEnd(String taskId) {
        return approval(ActDepositChangeStatusEnums.END.getStatus(), taskId);
    }


    /**
     * @return
     * @throws
     * @Title:
     * @Description: 出库操作
     * @param: status
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    public static ActRuTaskVo export(String taskId) {
        return approval(ActDepositChangeStatusEnums.AGREE.getStatus(), taskId);
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
    private static ActRuTaskVo approval(Integer status, String taskId) {
        if (StringUtils.isTrimBlank(taskId))
            throw new FmsServiceException("任务id不能为空 ");
        Map<String, Object> variables = new HashMap<>();
        Task task = ActUtils.getTask(taskId);

        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()), status);
        actDepositChangeUtils.taskService.complete(taskId, variables);
        return ActUtils.getActRuTaskVoAndNextInfo(task);
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 审核任务
     * @param: status
     * @param: taskId
     * @param: variables
     * @author qiaomengnan
     * @date 2018/4/16 15:35
     */
    private static ActRuTaskVo approval(Integer status, String taskId, Map<String, Object> variables) {
        Task task = ActUtils.getTask(taskId);
        variables.put(getApprovalStatusName(task.getTaskDefinitionKey()), status);
        actDepositChangeUtils.taskService.complete(taskId, variables);
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
     * @param flag 是否需要初审
     * @return
     * @throws
     * @Title:
     * @Description: 设置审批人
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setApprovalUser(Task task, boolean flag) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的审批人信息
        Map<String, Object> results = new HashMap<>();
        // 如果需要初审，则设定初审人
        if(flag){
            //如果申请审批人为空，则进行放入
            if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.APPROVAL_USER.getFlag()))) {
                String approvalUserId = formPropertyMap.get(ActDepositChangeEnums.APPROVAL_USER_ID.getFlag());
                String approvalUserUnit = formPropertyMap.get(ActDepositChangeEnums.APPROVAL_USER_UNIT.getFlag());
                Object approvalUser = ActUtils.getNextUser(approvalUserId, approvalUserUnit);
                LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(approvalUser));
                results.put(ActDepositChangeEnums.APPROVAL_USER.getFlag(), approvalUser);
            }
        } else { // 如果不需要初审，则直接到复审
            //如果申请审批人为空，则进行放入
            if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.REVIEW_USER.getFlag()))) {
                String reviewUserId = formPropertyMap.get(ActDepositChangeEnums.REVIEW_USER_ID.getFlag());
                String reviewUserUnit = formPropertyMap.get(ActDepositChangeEnums.REVIEW_USER_UNIT.getFlag());
                Object reviewUser = ActUtils.getNextUser(reviewUserId, reviewUserUnit);
                LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的申请审批人是: " + JSON.toJSONString(reviewUser));
                results.put(ActDepositChangeEnums.REVIEW_USER.getFlag(), reviewUser);
            }
        }
        return results;
    }

    private static Map<String, Object> getTaskVariables(String executionId) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = actDepositChangeUtils.runtimeService.getVariables(executionId);
        return taskVariables;
    }

    /**
     * @param task 任务
     * @return
     * @throws
     * @Title:
     * @Description: 设置复核人
     * @author qiaomengnan
     * @date 2018/04/09 02:53:21
     */
    private static Map<String, Object> setReviewUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果审批复核人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.REVIEW_USER.getFlag()))) {
            String reviewUserUnit = formPropertyMap.get(ActDepositChangeEnums.REVIEW_USER_UNIT.getFlag());
            String reviewUserId = formPropertyMap.get(ActDepositChangeEnums.REVIEW_USER_ID.getFlag());
            Object reviewUser = ActUtils.getNextUser(reviewUserId, reviewUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的审批复核人是: " + JSON.toJSONString(reviewUser));
            results.put(ActDepositChangeEnums.REVIEW_USER.getFlag(), reviewUser);
        }
        return results;
    }

    /**
     * @Description: 设置副总审核人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/18 10:14
     */
    private static Map<String, Object> setPreAgreeUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的副总审核人信息
        Map<String, Object> results = new HashMap<>();
        //如果副总审核人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.PRE_AGREE_USER.getFlag()))) {
            String preAgreeUserUnit = formPropertyMap.get(ActDepositChangeEnums.PRE_AGREE_USER_UNIT.getFlag());
            String preAgreeUserId = formPropertyMap.get(ActDepositChangeEnums.PRE_AGREE_USER_ID.getFlag());
            Object preAgreeUser = ActUtils.getNextUser(preAgreeUserId, preAgreeUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的副总审核人是: " + JSON.toJSONString(preAgreeUser));
            results.put(ActDepositChangeEnums.PRE_AGREE_USER.getFlag(), preAgreeUser);
        }
        return results;
    }

    /**
     * @Description: 设置合同生成人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/18 10:14
     */
    private static Map<String, Object> setContractCreateUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的副总审核人信息
        Map<String, Object> results = new HashMap<>();
        //如果合同生成人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.CONTRACT_CREATE_USER.getFlag()))) {
            String contractCreateUserUnit = formPropertyMap.get(ActDepositChangeEnums.CONTRACT_CREATE_USER_UNIT.getFlag());
            String contractCreateUserId = formPropertyMap.get(ActDepositChangeEnums.CONTRACT_CREATE_USER_ID.getFlag());
            Object contractCreateUser = ActUtils.getNextUser(contractCreateUserId, contractCreateUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的合同生成人是: " + JSON.toJSONString(contractCreateUser));
            results.put(ActDepositChangeEnums.CONTRACT_CREATE_USER.getFlag(), contractCreateUser);
        }
        return results;
    }

    /**
     * @Description: 设置补充协议上传人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/18 10:14
     */
    private static Map<String, Object> setSuppleUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的补充协议上传人信息
        Map<String, Object> results = new HashMap<>();
        //如果补充协议上传人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.SUPPLE_USER.getFlag()))) {
            String suppleUserUnit = formPropertyMap.get(ActDepositChangeEnums.SUPPLE_USER_UNIT.getFlag());
            String suppleUserId = formPropertyMap.get(ActDepositChangeEnums.SUPPLE_USER_ID.getFlag());
            Object suppleUser = ActUtils.getNextUser(suppleUserId, suppleUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的补充协议上传人是: " + JSON.toJSONString(suppleUser));
            results.put(ActDepositChangeEnums.SUPPLE_USER.getFlag(), suppleUser);
        }
        return results;
    }

    /**
     * @Description: 设置合同复核人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/18 10:14
     */
    private static Map<String, Object> setContractApproveUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的合同复核人信息
        Map<String, Object> results = new HashMap<>();
        //如果合同复核人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.CONTRACT_APPROVE_USER.getFlag()))) {
            String contractApproveUserUnit = formPropertyMap.get(ActDepositChangeEnums.CONTRACT_APPROVE_USER_UNIT.getFlag());
            String contractApproveUserId = formPropertyMap.get(ActDepositChangeEnums.CONTRACT_APPROVE_USER_ID.getFlag());
            Object contractApproveUser = ActUtils.getNextUser(contractApproveUserId, contractApproveUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的合同复核人是: " + JSON.toJSONString(contractApproveUser));
            results.put(ActDepositChangeEnums.CONTRACT_APPROVE_USER.getFlag(), contractApproveUser);
        }
        return results;
    }

    /**
     * @Description: 设置财务收款人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/18 10:14
     */
    private static Map<String, Object> setReceiptUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务收款人信息
        Map<String, Object> results = new HashMap<>();
        //如果财务收款人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.RECEIPT_USER.getFlag()))) {
            String receiptUserUnit = formPropertyMap.get(ActDepositChangeEnums.RECEIPT_USER_UNIT.getFlag());
            String receiptUserId = formPropertyMap.get(ActDepositChangeEnums.RECEIPT_USER_ID.getFlag());
            Object receiptUser = ActUtils.getNextUser(receiptUserId, receiptUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的财务收款人是: " + JSON.toJSONString(receiptUser));
            results.put(ActDepositChangeEnums.RECEIPT_USER.getFlag(), receiptUser);
        }
        return results;
    }

    /**
     * @Description: 设置出库操作人
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/18 10:14
     */
    private static Map<String, Object> setExportUser(Task task) {
        //为了防止是退回后,再次进行提交,所以要进行查询流程参数,判断每个流程的具体审批人是否已经被设置过
        Map<String, Object> taskVariables = getTaskVariables(task.getExecutionId());
        //拿出表单每个节点审批人的信息
        Map<String, String> formPropertyMap = ActUtils.getTaskFormData(task.getId());
        //最终返回的财务收款人信息
        Map<String, Object> results = new HashMap<>();
        //如果财务收款人为空，则进行放入
        if (StringUtils.isTrimBlank(taskVariables.get(ActDepositChangeEnums.EXPORT_USER.getFlag()))) {
            String exportUserUnit = formPropertyMap.get(ActDepositChangeEnums.EXPORT_USER_UNIT.getFlag());
            String exportUserId = formPropertyMap.get(ActDepositChangeEnums.EXPORT_USER_ID.getFlag());
            Object exportUser = ActUtils.getNextUser(exportUserId, exportUserUnit);
            LogUtils.infoLine(log, "流程实例: " + task.getProcessInstanceId() + "的出库操作人是: " + JSON.toJSONString(exportUser));
            results.put(ActDepositChangeEnums.EXPORT_USER.getFlag(), exportUser);
        }
        return results;
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 申请取消
     * @param: taskId
     * @author qiaomengnan
     * @date 2018/4/16  14:11
     */
    public static ActRuTaskVo approvalCancel(String taskId) {
        return approval(ActDepositChangeStatusEnums.CANCEL.getStatus(), taskId);
    }

    /**
     * @Title:
     * @Description: 保证金申请取消 (根据业务id取消流程)
     * @param: serviceId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/24 10:32
     */
    public static ActRuTaskVo applyCancel(String serviceId){
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务id不能为空");
        List<Task> tasks = actDepositChangeUtils.taskService.createTaskQuery().processInstanceBusinessKey(serviceId)
                .processDefinitionKey(ActProcessInstanceKeyEnums.DEPOSIT_CHANGE.getKey()).list();
        if(ArrayUtils.isNotNullAndLengthNotZero(tasks) && tasks.size() > 1){
            throw new FmsServiceException("当前任务数量过多");
        }else if(ArrayUtils.isNullOrLengthZero(tasks))
            throw new FmsServiceException("当前不存在任务节点");
        else{
            return approvalCancel(tasks.get(0).getId());
        }
    }

}
