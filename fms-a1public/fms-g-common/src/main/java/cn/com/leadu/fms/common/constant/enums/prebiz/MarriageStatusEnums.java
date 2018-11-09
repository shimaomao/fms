package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * 婚姻状态
 */
public enum MarriageStatusEnums {

    MARRIED("0","已婚"),
    MARRIED_WITH_CHILDREN("1","已婚有子女"),
    UNMARRIED("2","未婚"),
    DIVORCED("3","离异"),
    DEATH_SPOUSE("4","丧偶");

    private String status;

    private String desc;

    MarriageStatusEnums(String status, String desc){
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