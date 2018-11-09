package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by ningyangyang on 2018/10/9.
 * 变更承租人任务状态
 */
public enum ChangeLesseeStatusEnums {

    REFUSE("3899","变更申请拒绝"),
    CANCEL("3898","变更申请取消"),
    COMPLETE("3807","变更申请完成");

    private String type;

    private String desc;

    ChangeLesseeStatusEnums(String type, String desc) {
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
