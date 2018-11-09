package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author huchenghao
 * @ClassName: ContInsuranceEnums
 * @Description:
 * @date 2018/3/27
 */
public enum ContInsuranceEnums {

    AGREE_ITEM("1","有效"),
    DISAGREE_ITEM("2","失效");

    private String type;

    private String memo;

    ContInsuranceEnums(String type, String memo){
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
