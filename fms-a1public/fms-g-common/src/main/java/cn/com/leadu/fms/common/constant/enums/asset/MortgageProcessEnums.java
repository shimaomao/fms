package cn.com.leadu.fms.common.constant.enums.asset;

/**
 * @author qiaomengnan
 * @ClassName: MortgageProcessEnums
 * @Description: 资方抵押类型
 * @date 2018/6/7
 */
public enum  MortgageProcessEnums {

    EQU_MOR("0","资方抵押申请(先抵押后放款)"),
    EQU_MOR_PAY("1","资方抵押申请(先放款后抵押)");

    private String type;

    private String desc;

    MortgageProcessEnums(String type, String desc){
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
