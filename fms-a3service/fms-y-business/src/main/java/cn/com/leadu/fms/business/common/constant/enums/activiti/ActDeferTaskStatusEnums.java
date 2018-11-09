package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by ningyangyang on 2018/9/5.
 * 展期任务状态
 */
public enum ActDeferTaskStatusEnums {

    AGREE(0,"同意"),
    AGREE_FINANCE(3,"到财务审核"),
    RETURN_SUPERIOR(1,"退回上一级"),
    CANCEL(2,"取消"),
    REFUSE(4,"拒绝");

    private Integer status;

    private String desc;

    ActDeferTaskStatusEnums(Integer status, String desc){
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus(){
        return this.status;
    }

    public String getDesc(){
        return this.desc;
    }
}
