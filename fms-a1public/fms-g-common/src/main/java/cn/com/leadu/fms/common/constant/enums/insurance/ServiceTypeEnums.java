package cn.com.leadu.fms.common.constant.enums.insurance;/**
 * Created by ningyangyang on 2018/6/12.
 */

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/6/12 18:01
 */
public enum  ServiceTypeEnums {

    RENEWAL_REGISTER("renewal_register","保险续保"),
    DEFER_TASK("defer_task","合同展期任务"),
    CHANGE_LESSEE("change_lessee","变更承租人");

    private String type;

    private String desc;

    ServiceTypeEnums(String type, String desc) {
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
