package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author yanfengbo
 * @ClassName:  罚息免除审核状态
 * @Description:
 * @date
 */
public enum ActOverdueExemptStatusEnums {
    AGREE(0,"同意"),
    RETURN(1,"退回");

    private Integer status;

    private String desc;

    ActOverdueExemptStatusEnums(Integer status, String desc){
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
