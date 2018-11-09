package cn.com.leadu.fms.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveEnums
 * @Description: 请假审批状态
 * @date 2018/3/20
 */
public enum ActUserLeaveStatusEnums {

    APPROVAL(0,"正在审批中"),
    SUCCESS(1,"通过"),
    ERROR(2,"拒绝");

    private Integer status;

    private String desc;

    ActUserLeaveStatusEnums(Integer status,String desc){
        this.status = status;
        this.desc =desc;
    }

    public Integer getStatus(){
        return this.status;
    }

}
