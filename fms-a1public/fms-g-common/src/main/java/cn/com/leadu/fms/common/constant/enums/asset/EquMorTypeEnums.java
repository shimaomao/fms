package cn.com.leadu.fms.common.constant.enums.asset;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTypeEnums
 * @Description:
 * @date 2018/6/11
 */
public enum  EquMorTypeEnums {

    OTHER("0","资方抵押"),
    SEA_WING("1","海翼资方抵押");

    private String type;

    private String desc;

    EquMorTypeEnums(String type, String desc){
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
