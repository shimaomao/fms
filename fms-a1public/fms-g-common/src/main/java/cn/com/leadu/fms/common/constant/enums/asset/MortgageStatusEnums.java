package cn.com.leadu.fms.common.constant.enums.asset;

/**
 * @author qiaomengnan
 * @ClassName: MortgageStatusEnums
 * @Description: 资方抵押状态
 * @date 2018/6/6
 */
public enum  MortgageStatusEnums {

    NOT_MOR("5","未抵押"),
    EQU_MOR_SUCCESS("0","已抵押"),
    EQU_REL("1","已解押"),
    RESOLVING_RELIEF("2","解抵押中"),
    CANCEL("3","取消抵押"),
    EQU_MOR("4","抵押中"),
    INVALID("9","无效");

    private String status;

    private String name;

    MortgageStatusEnums(String status, String name){
        this.status = status;
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

}
