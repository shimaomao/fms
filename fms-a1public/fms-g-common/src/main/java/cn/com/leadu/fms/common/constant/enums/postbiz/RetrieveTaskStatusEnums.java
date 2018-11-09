package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by ningyangyang on 2018/9/27.
 *  收车任务状态
 */
public enum RetrieveTaskStatusEnums {

    REFUSE("4114","拒绝"),
    COMPLETE("4113","完成"),
    TOBE_APPLY("4135","收车待申请提交");

    private String type;

    private String desc;

    RetrieveTaskStatusEnums(String type, String desc) {
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
