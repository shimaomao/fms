package cn.com.leadu.fms.common.constant.enums.thirdinterface;

/**
 * @author yanggang
 * @ClassName: MessageTypeEnums
 * @Description: 短信类型
 * @date 2018/6/19
 */
public enum MessageTypeEnums {

    //还款短信类型
    REPAY("repay", "还款短信类型"),
    //其他短信类型
    OTHER("other", "其他短信类型");

    private String type;

    private String desc;

    MessageTypeEnums(String type, String desc){
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
