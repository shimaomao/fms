package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @ClassName: ActContPrepaymentStatusEnums
 * @Description: 提前还款状态
 * Created by yyq on 2018/6/21.
 */
public enum ActContPrepaymentStatusEnums {
    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    SKIP(2,"跳过下一级"),
    PAYMENT(3,"到财务审核"),
    BACK_APPROVAL(4,"退回到初审"),
    BACK_REVIEW(5,"退回到复审"),
    VEH_EXPORT(6,"到车辆出库");


    private Integer status;

    private String desc;

    ActContPrepaymentStatusEnums(Integer status, String desc){
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
