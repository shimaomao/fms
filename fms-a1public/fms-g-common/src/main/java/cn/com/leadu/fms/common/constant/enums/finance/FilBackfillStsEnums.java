package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * Created by ningyangyang on 2018/7/9.
 *  回填状态
 */
public enum FilBackfillStsEnums {

     BEING_BACKFILL("2","回填中"),
    ALREADY_BACKFILL("1","已回填"),
    WAIT_BACKFILL("0","待回填");

    private String type;

    private String desc;

    FilBackfillStsEnums(String type, String desc) {
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
