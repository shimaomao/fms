package cn.com.leadu.fms.common.constant.enums.prebiz;

public enum ApplyStatusEnums {
    APPROVAL("1","审批中"),
    AGREE("2","通过"),
    REFUSE("3","拒绝"),
    AGREE_CONDITIONAL("4","有条件同意");

    private String type;

    private String desc;

    ApplyStatusEnums(String type, String desc){
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