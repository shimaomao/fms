package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @program: fms
 * @description: 申请有条件同意审批类型
 * @author: yangyiquan
 * @create: 2018-06-23
 **/
public enum ApproveAgreeFlagEnums {
    CONDITIONAL_AGREE("1","有条件同意"),
    NOT_CONDITIONAL_AGREE("0","非有条件同意");


    private String type;

    private String desc;

    ApproveAgreeFlagEnums(String type, String desc){
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
