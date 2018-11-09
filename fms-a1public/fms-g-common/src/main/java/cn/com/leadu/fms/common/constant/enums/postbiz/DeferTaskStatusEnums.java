package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by ningyangyang on 2018/10/9.
 *  合同展期任务状态
 */
public enum DeferTaskStatusEnums {

    REFUSE("3399","展期申请拒绝"),
    CANCEL("3398","展期申请取消");

    private String type;

    private String desc;

    DeferTaskStatusEnums(String type, String desc) {
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
