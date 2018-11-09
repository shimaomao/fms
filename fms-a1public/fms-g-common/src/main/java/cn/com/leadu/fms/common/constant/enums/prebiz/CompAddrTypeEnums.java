package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * Created by ningyangyang on 2018/6/29.
 *  经营地址类型
 */
public enum CompAddrTypeEnums {

    OWN("0","自有"),
    LEASE("1","租赁"),
    OTHER("2","其它");

    private String type;

    private String memo;

    CompAddrTypeEnums(String type, String memo){
        this.type = type;
        this.memo = memo;
    }

    public String getType() {
        return type;
    }

    public String getMemo() {
        return memo;
    }
}
