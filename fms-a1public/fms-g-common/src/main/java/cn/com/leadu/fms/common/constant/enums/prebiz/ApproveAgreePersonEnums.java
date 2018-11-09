package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @program: fms
 * @description: 申请有条件同意审批人
 * @author: yangyiquan
 * @create: 2018-06-22 11:54
 **/
public enum ApproveAgreePersonEnums {
    DIR_AGREE("1","主管有条件同意"),
    PRE_AGREE("2","副总有条件同意");


    private String type;

    private String desc;

    ApproveAgreePersonEnums(String type, String desc){
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
