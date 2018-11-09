package cn.com.leadu.fms.common.constant.enums.asset;

/**
 * Created by yyq on 2018/5/22.
 */
/** 
* @Description:解抵押状态
* @Author: yangyiquan
* @Date: 2018/5/22 20:16
*/ 
public enum MortgateStsEnums {
    WAIT_MORTGEGA("0","待解除抵押登记"),
    WAIT_POST("1","待邮寄"),
    ALREDAY_POST("2","已邮寄");

    private String type;

    private String desc;

    MortgateStsEnums(String type, String desc){
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
