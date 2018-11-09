package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author wangxue
 * @ClassName: FinItemTypeEnums
 * @Description:
 * @date 2018/3/24
 */
public enum ApplyTypeEnums {


    PERSON("1","个人"),
    COMPANY("2","企业");

    private String type;

    private String desc;

    ApplyTypeEnums(String type, String desc){
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
