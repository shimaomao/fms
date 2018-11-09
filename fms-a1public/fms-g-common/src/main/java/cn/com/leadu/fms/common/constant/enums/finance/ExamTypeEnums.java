package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * Created by ningyangyang on 2018/6/10.
 *  @Description: 勾稽类型
 */
public enum ExamTypeEnums {

    IMPORT_RECIPT("0","财务收款租金勾稽"),
    INTER_RECIPT("2","抵扣租金勾稽"),
    FIN_RECEIPT("1","财务待收款款项自动勾稽");

    private String type;

    private String desc;

    ExamTypeEnums(String type, String desc) {
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
