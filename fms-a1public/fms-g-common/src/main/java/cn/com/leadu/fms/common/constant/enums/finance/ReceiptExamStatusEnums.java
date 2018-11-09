package cn.com.leadu.fms.common.constant.enums.finance;/**
 * Created by ningyangyang on 2018/6/10.
 */

/**
 * @Title: fms
 * @Description: 勾稽状态
 * @author: ningyangyang
 * @date 2018/6/10 19:16
 */
public enum  ReceiptExamStatusEnums {

    ALREADY_CLAIM("0","已认领"),
    ALREADY_CHECKED("1","已勾稽");

    private String type;

    private String desc;

    ReceiptExamStatusEnums(String type, String desc) {
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
