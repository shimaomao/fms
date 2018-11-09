package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author huchenghao
 * @ClassName: ContInsuranceEnums
 * @Description:
 * @date 2018/3/27
 */
public enum ContractEnums {

    CREATE_ITEM("1","待生成合同"),
    PRINT_ITEM("2","待打印"),
    AGREE_ITEM("3","待文件审核"),
    ADVANCE_ITEM("4","待放款"),
    ARCHIVE_ITEM("5","待归档");


    private String type;

    private String desc;

    ContractEnums(String type, String desc){
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
