package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author yanfengbo
 * @ClassName:  BasBankInfoStatusEnums
 * @Description: 银行账号状态
 * @date
 */
public enum BasBankInfoStatusEnums {
    TO_BE_APPROVAL("1100","待审批"),
    RETURN("1101","以退回"),
    AGREE_APPROVAL("1102","审批通过");

    private String type;

    private String desc;

    BasBankInfoStatusEnums(String type, String desc) {
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
