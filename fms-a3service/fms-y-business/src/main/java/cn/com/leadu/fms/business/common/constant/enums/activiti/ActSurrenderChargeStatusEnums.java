package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by leadu on 2018/10/26.
 */
public enum ActSurrenderChargeStatusEnums {

    //通用操作
    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级");

    private Integer status;

    private String desc;

    ActSurrenderChargeStatusEnums(Integer status, String desc){
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
