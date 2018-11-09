package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @ClassName: ActDepositChangeStatusEnums
 * @Description: 保证金变更状态
 */
public enum ActDepositChangeStatusEnums {
    AGREE(0, "同意"),
    RETURN_SUPERIOR(1, "退回上一级"),
    REFUSE(2, "拒绝"),
    SEND_TO_APPLY(3, "退回到申请"),
    END(4, "结束"),
    SEND_TO_REWIEW(5, "申请提交给复审"),
    EXPORT(6, "合同审核到出库"),
    CANCEL(7, "申请取消");


    private Integer status;

    private String desc;

    ActDepositChangeStatusEnums(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getDesc() {
        return this.desc;
    }
}
