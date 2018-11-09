package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * Created by ningyangyang on 2018/8/9.
 *  申请类别
 */
public enum CompanyType {

    person("1","个人"),
    comp("2","企业"),
    sale("3","经销商");

    private String type;

    private String desc;

    CompanyType(String type, String desc){
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
