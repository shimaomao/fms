package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author huchenghao
 * @ClassName: AreaEnums
 * @Description:区域等级
 * @date 2018/3/24
 */
public enum AreaEnums {

    PROVINCE("1","省份"),
    CITY("2","城市"),
    AREA("3","区县");

    private String type;

    private String desc;

    AreaEnums(String type, String desc){
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
