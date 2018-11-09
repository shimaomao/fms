package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author wangxue
 * @ClassName: SysUserValidMenuTypeEnums
 * @Description:
 * @date 2018/3/92
 */
public enum HomeApproveStatusEnums {

    SUBMIT("01","待提交"),
    CONFIRM("02","待确认"),
    APPROVE("03","审核中"),
    PASS("04","已通过"),
    CONDITION_PASS("05","有条件通过"),
    REFUSE("06","已拒绝"),
    CANCEL("07","已取消"),
    REQUEST_FUNDS("08","待请款"),
    LOAN("09","待放款"),
    ORIGIN("10","待归档"),
    ORIGIN1("11","待归档");

    private String type;

    private String desc;

    HomeApproveStatusEnums(String type, String desc){
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

