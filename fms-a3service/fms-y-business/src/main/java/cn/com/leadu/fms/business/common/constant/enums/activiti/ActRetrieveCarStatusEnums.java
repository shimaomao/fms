package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by ningyangyang on 2018/9/20.
 *  收车状态枚举
 */
public enum ActRetrieveCarStatusEnums {

    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    REFUSE(2,"拒绝"),
    AUDIT_BACK(3,"总经理退回"),
    FINANCIAL_BACK(4,"财务审核退回"),
    TO_AUDIT(5,"到总经理审核"),
    TO_FINANCIAL(6,"到财务审核");

    private Integer status;

    private String desc;

    ActRetrieveCarStatusEnums(Integer status, String desc){
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
