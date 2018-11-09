package cn.com.leadu.fms.common.constant.enums;

/**
 * @author wangxue
 * @ClassName: FinItemTypeEnums
 * @Description:
 * @date 2018/3/24
 */
public enum ActTypeEnums {

    //画面上只有提交操作时
    SAVEINFO("00","暂存"),
    SUBMIT("01","提交"),
    APPROVAL("02","同意"),
    REFUSE("03","拒绝"),
    SENDBACK("04","退回"),
    SENDBACKTOP("05","退回发起人"),
    CONDITIONAL_APPROVAL("06","有条件同意"),
    CANCEL("07","取消"),
    BACK_DIRECTOR("08","退回风控经理");

    private String type;

    private String desc;

    ActTypeEnums(String type, String desc){
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
