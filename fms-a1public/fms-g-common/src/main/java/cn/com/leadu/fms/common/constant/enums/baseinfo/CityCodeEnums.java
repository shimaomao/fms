package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author qiaomengnan
 * @ClassName: TestStationEnum
 * @Description: 枚举 常量
 * @date 2018/1/7
 */
public enum CityCodeEnums {

    SHANG_HAI("101", "上海"),
    GUANG_ZHOU("102","广州"),
    BEI_JING("103","北京");

    private String code;
    private String name;

    CityCodeEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CityCodeEnums getEnum(String code){
        if(code==null || "".equals(code)){
            return null;
        }
        for (CityCodeEnums e : CityCodeEnums.values()) {
            if (code.equals(e.getCode())) {
                return e;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public static void main(String[] args) {
        System.out.println(CityCodeEnums.SHANG_HAI.code);
        System.out.println(CityCodeEnums.BEI_JING.name);
    }

}