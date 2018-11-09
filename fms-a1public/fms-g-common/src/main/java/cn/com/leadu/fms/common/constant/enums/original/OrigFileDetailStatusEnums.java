package cn.com.leadu.fms.common.constant.enums.original;

/**
 * @description: 文件状态
 * @author:ningyangyang
 * @since:2018/5/3
 */
public enum OrigFileDetailStatusEnums {
//    CANCEL("9","不需归档"),
    TO_BE_MAILED("0","待邮寄"), //初始状态
    ALREADY_MAILED("1","待签收"),//资管邮寄后
    TO_BE_SORTED("2","待归档"),//资管确认收到
    BE_SORTED("3", "已归档"),//归档
    BE_BACK("4","被退回"),
    BE_BORROW("5","借阅中"),//借阅流程开始
    BE_BORROWED("6","已借出"),//借阅流程结束
    BACKING("7","归还中");//借阅归还流程开始

    private String type;

    private String desc;

    OrigFileDetailStatusEnums(String type, String desc) {
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
