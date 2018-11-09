package cn.com.leadu.fms.common.constant.enums.insurance;/**
 * Created by ningyangyang on 2018/6/9.
 */

/**
 * @Title: fms
 * @Description: 保险购买方式
 * @author: ningyangyang
 * @date 2018/6/9 16:01
 */
public enum  InsurPurTypeEnums {

    BY_COSTUME("0","客户购买"),
    BY_FIN_COMP("1","万量购买");

    private String type;

    private String desc;

    InsurPurTypeEnums(String type, String desc) {
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
