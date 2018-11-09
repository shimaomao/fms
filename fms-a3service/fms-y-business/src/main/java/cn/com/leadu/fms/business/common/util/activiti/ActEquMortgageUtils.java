package cn.com.leadu.fms.business.common.util.activiti;


import cn.com.leadu.fms.business.common.constant.enums.activiti.ActEquMortgageStatusEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
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

import static cn.com.leadu.fms.business.common.constant.enums.activiti.ActEquMortgageFlagEnums.*;
import static cn.com.leadu.fms.business.common.constant.enums.activiti.ActEquMortgageStatusEnums.AGREE;
import static cn.com.leadu.fms.business.common.constant.enums.activiti.ActEquMortgageStatusEnums.RETURN_SUPERIOR;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;

/**
 * @author qiaomengnan
 * @ClassName: ActEquMortgageUtils
 * @Description: 资方抵押流程(先抵押后放款)
 * @date 2018/6/7
 */
@Component
@Slf4j
public class ActEquMortgageUtils {

    /**
     * @Fields  : 单例辅助
     * @author qiaomengnan
     */
    private static ActEquMortgageUtils actEquMortgageUtils = null;

    /**
     * @Fields  : 每个流程节点的审批状态名称
     * @author qiaomengnan
     */
    private static Map<String,String> approvalStatusNames = new HashMap<>();

    /**
     * @Fields  : 需要设置用户的节点
     * @author qiaomengnan
     */
    private static Map<String,String[]>  userDefKeys = new HashMap<>();

    /**
     * @Fields  : 需要设置用户节点的用户单位
     * @author qiaomengnan
     */
    private static Map<String,Map<String,String>> userDefUnitKeys = new HashMap<>();

    /**
     * @Fields  : 用户变量对应的描述
     * @author qiaomengnan
     */
    private static Map<String,String> usersDesc = new HashMap<>();

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    /**
     * @Title:
     * @Description:   启动流程
     * @param serviceId     业务id
     * @param serviceType   业务类型
     * @param memo   备注
     * @param submit 是否提交
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/10 03:48:13
     */
    public static ActRuTaskVo start(String serviceId, String serviceType, String serviceName,String memo,boolean submit){
        ActRuTaskVo actRuTaskVo = null;
        //当前登录用户就是申请录入人员
        String applyUser = UserInfoUtils.getUserName();
        //任务发起人账号
        String startUser = UserInfoUtils.getUserName();
        //任务发起人姓名
        String startUserName = UserInfoUtils.getUser().getUserName();
        if(StringUtils.isTrimBlank(serviceId))
            throw new FmsServiceException("业务id不能为空");
        if(StringUtils.isTrimBlank(applyUser))
            throw new FmsServiceException("申请人不能为空");
        if(StringUtils.isTrimBlank(serviceName))
            throw new FmsServiceException("业务名称不能为空");
        Map<String,Object> variables = new HashMap<>();
        variables.put(APPLY_USER.getFlag(),applyUser);
        variables.put(IMPORT_USER.getFlag(),applyUser);
        variables.put(UPLOAD_USER.getFlag(),applyUser);
        ActUtils.putVariables(variables,ActProcessInstanceKeyEnums.EQU_MORTGAGE.getKey(),
                ActProcessInstanceKeyEnums.EQU_MORTGAGE.getDesc(),serviceType,serviceName,serviceId,startUser,startUserName);
        //启动流程
        ProcessInstance processInstance = actEquMortgageUtils.runtimeService.startProcessInstanceByKey(ActProcessInstanceKeyEnums.EQU_MORTGAGE.getKey(),serviceId,variables);
        //查询出第一个任务
        Task task = actEquMortgageUtils.taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //如果是启动并提交
        if(submit){
            //任务参数
            Map<String,Object> taskVariables = new HashMap<>();
            //设置状态
            taskVariables.put(APPLY_STATUS.getFlag(),AGREE.getStatus());
            //完成任务
            actEquMortgageUtils.taskService.complete(task.getId(),taskVariables);
            //获取下一节点信息
            actRuTaskVo = ActUtils.getActRuTaskVoAndNextInfo(task);
            //保存日志
            ActUtils.saveWorkFlowLog(memo,actRuTaskVo.getTaskCode(),SUBMIT.getType(),serviceId,BizTypeEnums.EQU_MORTGAGE);
        }else {
            //获取下一节点信息
            actRuTaskVo = ActUtils.getActRuTaskVoAndNextInfo(task);
        }
        //返回数据
        return actRuTaskVo;
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
    public static ActRuTaskVo approvalAgree(Task task,String taskDefinitionKey,String memo,String serviceId){
        ActRuTaskVo actRuTaskVo = ActUtils.approval(AGREE.getStatus(),task,taskDefinitionKey
                ,userDefKeys,userDefUnitKeys,usersDesc,approvalStatusNames);
        ActUtils.saveWorkFlowLog(memo,actRuTaskVo.getTaskCode(),SUBMIT.getType(),serviceId,BizTypeEnums.EQU_MORTGAGE);
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
    public static ActRuTaskVo approvalReturnSuperior(Task task,String taskDefinitionKey,String memo,String serviceId){
        ActRuTaskVo actRuTaskVo = ActUtils.approval(RETURN_SUPERIOR.getStatus(),task,taskDefinitionKey
                ,userDefKeys,userDefUnitKeys,usersDesc,approvalStatusNames);
        ActUtils.saveWorkFlowLog(memo,actRuTaskVo.getTaskCode(),SENDBACK.getType(),serviceId,BizTypeEnums.EQU_MORTGAGE);
        return actRuTaskVo;
    }

    /**
     * @Title:
     * @Description: 取消
     * @param: task
     * @param: taskDefinitionKey
     * @param: memo
     * @param: serviceId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/3 0003 20:57
     */
    public static ActRuTaskVo approvalCancel(Task task,String taskDefinitionKey,String memo,String serviceId){
        ActRuTaskVo actRuTaskVo = ActUtils.approval(ActEquMortgageStatusEnums.CANCEL.getStatus(),task,taskDefinitionKey
                ,userDefKeys,userDefUnitKeys,usersDesc,approvalStatusNames);
        ActUtils.saveWorkFlowLog(memo,actRuTaskVo.getTaskCode(), ActTypeEnums.CANCEL.getType(),serviceId,BizTypeEnums.EQU_MORTGAGE);
        return actRuTaskVo;
    }

    public ActEquMortgageUtils(){
        //注入单例工具类
        actEquMortgageUtils = this;
        //保存每个流程节点的审批状态名称
        approvalStatusNames.put(EQU_MOR_APPLY.getFlag(),APPLY_STATUS.getFlag());
        approvalStatusNames.put(EQU_MOR_IMPORT.getFlag(),IMPORT_STATUS.getFlag());
        approvalStatusNames.put(EQU_MOR_UPLOAD.getFlag(),UPLOAD_STATUS.getFlag());
        approvalStatusNames.put(EQU_MOR_REVIEW.getFlag(),REVIEW_STATUS.getFlag());
        approvalStatusNames.put(EQU_MOR_TOUCHING.getFlag(),TOUCHING_STATUS.getFlag());
        approvalStatusNames.put(EQU_MOR_APPROVAL.getFlag(),APPROVAL_STATUS.getFlag());
        approvalStatusNames.put(EQU_MOR_PAY.getFlag(),PAY_STATUS.getFlag());
        approvalStatusNames.put(EQU_MOR_RECEIPT.getFlag(),RECEIPT_STATUS.getFlag());

        //需要设置用户的节点

        //资料归档设置资管复核
        userDefKeys.put(EQU_MOR_UPLOAD.getFlag(),new String[]{REVIEW_USER.getFlag()});
        //资管复核设置财务制单、财务收款
        userDefKeys.put(EQU_MOR_REVIEW.getFlag(),new String[]{TOUCHING_USER.getFlag(),RECEIPT_USER.getFlag()});
        //财务制单设置总经理审批
        userDefKeys.put(EQU_MOR_TOUCHING.getFlag(),new String[]{APPROVAL_USER.getFlag()});
        //总经理审批设置财务付款
        userDefKeys.put(EQU_MOR_APPROVAL.getFlag(),new String[]{PAY_USER.getFlag()});

        //资料归档节点用户的单位名称和id名称
        Map<String,String> equMorUploadMap = new HashMap<>();
        equMorUploadMap.put(ActFlagEnums.USER_UNIT.getFlag(),REVIEW_USER_UNIT.getFlag());
        equMorUploadMap.put(ActFlagEnums.USER_ID.getFlag(),REVIEW_USER_ID.getFlag());
        userDefUnitKeys.put(EQU_MOR_UPLOAD.getFlag(),equMorUploadMap);

        //资料复核节点用户的单位名称和id名称
        Map<String,String> equMorReviewMap = new HashMap<>();
        equMorReviewMap.put(ActFlagEnums.USER_UNIT.getFlag(),TOUCHING_USER_UNIT.getFlag());
        equMorReviewMap.put(ActFlagEnums.USER_ID.getFlag(),TOUCHING_USER_ID.getFlag());
        userDefUnitKeys.put(EQU_MOR_REVIEW.getFlag(),equMorReviewMap);

        //财务制单节点用户的单位名称和id名称
        Map<String,String> equMorTouchingMap = new HashMap<>();
        equMorTouchingMap.put(ActFlagEnums.USER_UNIT.getFlag(),APPROVAL_USER_UNIT.getFlag());
        equMorTouchingMap.put(ActFlagEnums.USER_ID.getFlag(),APPROVAL_USER_ID.getFlag());
        userDefUnitKeys.put(EQU_MOR_TOUCHING.getFlag(),equMorTouchingMap);

        //总经理审批节点用户的单位名称和id名称
        Map<String,String> equMorApprovalMap = new HashMap<>();
        equMorApprovalMap.put(ActFlagEnums.USER_UNIT.getFlag(),PAY_USER_UNIT.getFlag());
        equMorApprovalMap.put(ActFlagEnums.USER_ID.getFlag(),PAY_USER_ID.getFlag());
        userDefUnitKeys.put(EQU_MOR_APPROVAL.getFlag(),equMorApprovalMap);

        //流程节点对应的名称
        usersDesc.put(REVIEW_USER_UNIT.getFlag(),REVIEW_USER.getDesc());
        usersDesc.put(TOUCHING_USER_UNIT.getFlag(),TOUCHING_USER.getDesc());
        usersDesc.put(APPROVAL_USER_UNIT.getFlag(),APPROVAL_USER.getDesc());
        usersDesc.put(PAY_USER_UNIT.getFlag(),PAY_USER_UNIT.getDesc());
    }

}
