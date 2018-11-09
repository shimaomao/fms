package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author wangxue
 * @ClassName: ActTransferTaskStatusEnums
 * @Description: 过户流程处理状态
 * @date 2018/9/6
 */
public enum ActTransferTaskStatusEnums {

    //通用操作
    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    PAYMENT(2,"到财务审核"),
    BASK_TOUCHING(3,"退回到财务审核"),
    DIRECT_END(4,"流程直接结束");

    private Integer status;

    private String desc;

    ActTransferTaskStatusEnums(Integer status, String desc){
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
