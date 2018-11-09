package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActContGenerationStatusEnums
 * @Description: 合同生成状态
 * @date 2018/4/16 0016
 */
public enum ActContGenerationStatusEnums {

    //通用操作
    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    RETURN_DEALER(2,"退回经销商"),
    REFUSE(3,"拒绝"),
    CANCEL(5,"取消"),

    //特例操作
    CONDITIONAL_AGREE(2,"主管、副总审核，有条件通过"),
    DIRAGREE_BACK_APPLY(4,"主管审核，退回到业务员"),
    MANAGE_DIRECTOR(4,"总经理审核，退回到风控经理"),
    SALE_PRESIDENT(1,"业务员确认，走向副总审核"),
    SALE_CONFIRM(0,"副总审核，走向合同生成前确认"),
    MANAGE(4,"副总审核，走向总经理审核");



    private Integer status;

    private String desc;

    ActContGenerationStatusEnums(Integer status, String desc){
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
