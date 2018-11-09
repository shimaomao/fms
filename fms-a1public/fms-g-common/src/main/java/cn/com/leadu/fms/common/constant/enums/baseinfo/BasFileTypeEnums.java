package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author qiaomengnan
 * @ClassName: 文件类型Enums
 * @Description:
 * @date 2018/6/6
 */
public enum BasFileTypeEnums {

    CAR_KEY("carkey","车钥匙"),
    EQU_MOR_DETAIL_INFO("equMorDetailInfo","抵押明细附件"),
    EQU_REL_DETAIL_INFO("equRelDetailInfo","解押附件明细"),
    ;

    private String type;

    private String desc;

    BasFileTypeEnums(String type, String desc) {
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
