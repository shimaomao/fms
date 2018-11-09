package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by ningyangyang on 2018/6/4.
 */
public enum ActReleasedMortgageStsEnums {

    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    GOTO_VOUCHER(2,"制单"),
    GOTO_RECEIPT(3,"财务确认收款");

    private Integer flag;

    private String desc;

    ActReleasedMortgageStsEnums(Integer flag,String desc){
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
