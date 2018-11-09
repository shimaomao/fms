package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @program: fms
 * @description: 申请有条件同意审批类型
 * @author: yangyiquan
 * @create: 2018-06-22 11:54
 **/
public enum ApplyConditionalAgreeEnums {
    //有条件同意使用
    AGREE("0","同意"),
    CONDITIONAL_AGREE("2","有条件同意"),
    BACK("1","退回"),
    REFUSE("3","拒绝"),
    BACK_APPLY("4","退回业务员"),

    //录入员是否同意使用
    NOT_AGREE("1","不同意");


    private String type;

    private String desc;

    ApplyConditionalAgreeEnums(String type, String desc){
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
