package cn.com.leadu.fms.common.constant.enums.insurance;

/**
 * Created by ningyangyang on 2018/7/13.
 *  短信发送状态
 */
public enum MsgStatusEnums {

    SEND_SUCCESS("000","发送成功"),
    SEND_FAILURE("999","发送失败");

    private String status;

    private String desc;

    MsgStatusEnums(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
