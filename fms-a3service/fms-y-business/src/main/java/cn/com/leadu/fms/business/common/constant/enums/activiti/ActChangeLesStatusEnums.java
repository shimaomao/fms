package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by ningyangyang on 2018/9/13.
 *  承租人变更任务状态
 */
public enum ActChangeLesStatusEnums {

    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    REFUSE(2,"拒绝"),
    CANCEL(3,"取消");

    private Integer status;

    private String desc;

    ActChangeLesStatusEnums(Integer status, String desc){
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
