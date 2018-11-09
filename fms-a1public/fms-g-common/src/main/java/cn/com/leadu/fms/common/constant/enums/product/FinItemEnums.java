package cn.com.leadu.fms.common.constant.enums.product;

/**
 * @author qiaomengnan
 * @ClassName: FinItemEnums
 * @Description: 合同融资项代码
 * @date 2018/5/25
 */
public enum FinItemEnums {
    //车款,购置税，保险费（分年），GPS,加装费，精品,上牌费，延保，其他
    CARPRICE("carprice","车款"),
    PURTAX("purchasetax","购置税"),
    GPS("gps","GPS"),
    INSURANCE("insurance","保险费"),
        INSURANCE_A("insuranceA","玻璃险"),//不是融资项目
        INSURANCE_B("insuranceB","划痕险"),//不是融资项目
        COLLECTING_POUNDAGE("collectingPoundage","代收手续费"),//不是融资项目
    EXTRA ("extra","精品/加装费"),
    LICENSE("license","上牌费"),
    EXTEND("extend","延保"),
    OTHERS("others","其他"),
    CHARGEFEE("chargeFee","手续费")
    ;

    private String code;

    private String desc;

    FinItemEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public String getCode() {
        return code;
    }

    public String getDesc(){
        return desc;
    }

}
