package cn.com.leadu.fms.common.constant.enums.asset;

/**
 * @author qiaomengnan
 * @ClassName: ContMortgageFlag
 * @Description: 合同是否适合抵押
 * @date 2018/5/31
 */
public enum MortgageFlag {

    INAPPROPRIATE("0","不合适"),
    APPROPRIATE("1","合适");

    private String flag;

    private String desc;

    MortgageFlag(String flag, String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag(){
        return flag;
    }

}
