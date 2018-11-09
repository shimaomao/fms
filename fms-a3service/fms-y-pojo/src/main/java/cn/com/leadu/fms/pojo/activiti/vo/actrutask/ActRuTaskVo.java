package cn.com.leadu.fms.pojo.activiti.vo.actrutask;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskVo
 * @Description: 任务vo
 * @date 2018/3/14
 */
@ExcelTitle("我的任务")
@Data
public class ActRuTaskVo extends PageQuery<ActRuTaskVo> {

    @Column(name = "ID_")
    private String id;

    @Column(name = "REV_")
    private Integer rev;

    @Column(name = "EXECUTION_ID_")
    private String executionId;

    @Column(name = "PROC_INST_ID_")
    private String procInstId;

    @Column(name = "PROC_DEF_ID_")
    private String procDefId;

    @Column(name = "NAME_")
    private String name;

    @Column(name = "PARENT_TASK_ID_")
    private String parentTaskId;

    @Column(name = "DESCRIPTION_")
    private String description;

    @Column(name = "TASK_DEF_KEY_")
    private String taskDefKey;

    @Column(name = "OWNER_")
    private String owner;

    @Column(name = "ASSIGNEE_")
    private String assignee;

    @Column(name = "DELEGATION_")
    private String delegation;

    @Column(name = "PRIORITY_")
    private Integer priority;

    @Column(name = "CREATE_TIME_")
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
    private Date createTime;

    @Column(name = "DUE_DATE_")
    private Date DUE_DATE_;

    @Column(name = "CATEGORY_")
    private String category;

    @Column(name = "SUSPENSION_STATE_")
    private Integer suspensionState;

    @Column(name = "TENANT_ID_")
    private String tenantId;

    @Column(name = "FORM_KEY_")
    private String formKey;

    private String taskDefinitionKey;

    private Date dueDate;

    private String processDefinitionKey;

    private String codeName;

    private Map<String, Object> taskLocalVariables;

    private Map<String, Object> processVariables;

    private String title;

    private String processInstanceName;

    private Integer processInstanceVersion;

    private String serviceId;

    private String serviceType;

    private String serviceTypeDesc;

    private String serviceRemark;

    private String processInstanceType;

    private Map<String,Object> serviceParameter;

    private String applyUser;

    private String serviceName;

    private String nextAssignee;

    private String taskCode;

    private String subTaskCode;

    private String startUser; //任务发起人账号

    private String startUserName; //任务发起人姓名

    /**
     * @Fields  : 是否结束流程
     * @author qiaomengnan
     */
    private Boolean endFlag = false;

    /**
     * @Fields  : 上一节点处理人
     * @author qiaomengnan
     */
    private String superiorTaskUser;

    private String businessKey;

    @ExcelTitle(value = "流程名称" , sort = 1)
    public String getTitle(){
        return this.title;
    }

    @ExcelTitle(value = "当前环节" , sort = 2)
    public String getName(){
        return this.name;
    }

    @ExcelTitle(value = "任务业务号" , sort = 3)
    public String getServiceId(){
        return this.serviceId;
    }

    @ExcelTitle(value = "任务信息" , sort = 4)
    public String getServiceName(){
        return this.serviceName;
    }

    @ExcelTitle(value = "任务信息备注" , sort = 5)
    public String getServiceRemark(){
        return this.serviceRemark;
    }

    @ExcelTitle(value = "最新操作时间" , sort = 6)
    public String getCreateTimeStr(){
        return DateUtils.dateToStr(this.createTime,DateUtils.formatStr_yyyyMMddHHmmss);
    }

}
