package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author yanfengbo
 * @ClassName: 保险理赔状态
 * @Description:
 * @date  
 */
public enum ActContInsurClaimStatusEnums {
    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    COMPLETE(2,"结束");


    private Integer status;

    private String desc;

    ActContInsurClaimStatusEnums(Integer status, String desc){
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
