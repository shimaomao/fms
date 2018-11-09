package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author yangyiquan
 * @ClassName: DeductibleFeeEnums
 * @Description: 定金是否抵扣车款
 * @date 2018/5/25
 */
public enum DeductibleFeeEnums {

    NO_DEDUCTION("0","否"),
    DEDUCTION("1","是");

    private String type;

    private String desc;

    DeductibleFeeEnums(String type, String desc){
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
