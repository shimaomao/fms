package cn.com.leadu.fms.common.constant.enums.asset;

/**
 * @author qiaomengnan
 * @ClassName: ContDetailFlagEnums
 * @Description: 资方抵押费用明细区分
 * @date 2018/6/7
 */
public enum ContDetailFlagEnums {

    TOTAL("0","合计"),
    DETAIL("1","明细");

    private String flag;

    private String desc;


    ContDetailFlagEnums(String flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag(){
        return this.flag;
    }

}
