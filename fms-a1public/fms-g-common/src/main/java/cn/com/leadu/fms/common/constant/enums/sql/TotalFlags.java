package cn.com.leadu.fms.common.constant.enums.sql;

/**
 * @author qiaomengnan
 * @ClassName: PageFlags
 * @Description: 是否有合计行
 * @date 2018/4/19
 */
public enum TotalFlags {

    TOTAL("0","有合计行"),
    NOT_TOTLE("1","无合计行");

    private String flag;

    private String desc;

    TotalFlags(String flag, String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag() {
        return flag;
    }
}
