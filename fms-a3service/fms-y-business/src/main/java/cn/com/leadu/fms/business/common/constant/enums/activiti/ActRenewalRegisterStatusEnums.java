package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by ningyangyang on 2018/6/12.
 */
public enum ActRenewalRegisterStatusEnums {

    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    COMPLETE(2,"结束"),
    TO_RECEIPT(3,"财务确认收款"),
    TO_WITHDRAW(4,"资管请款");

    private Integer flag;

    private String desc;

    ActRenewalRegisterStatusEnums(Integer flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public Integer getFlag(){
        return this.flag;
    }

    public String getDesc(){
        return this.desc;
    }
}
