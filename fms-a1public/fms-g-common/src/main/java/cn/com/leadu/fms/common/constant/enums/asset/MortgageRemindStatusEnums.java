package cn.com.leadu.fms.common.constant.enums.asset;
/**
 * @author 秦慕乔
 * @ClassName: MortgageStatusEnums
 * @Description: 回租抵押 抵押状态
 * @date 2018/6/6
 */
public enum MortgageRemindStatusEnums {

    EQU_MOR_SUCCESS("0","已抵押"),
    RESOLVING_RELIEF("1","解抵押"),
    NOT_MOR("2","未抵押");


    private String status;

    private String name;

    MortgageRemindStatusEnums(String status, String name){
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
