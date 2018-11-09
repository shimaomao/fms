package cn.com.leadu.fms.common.constant.enums.sql;

/**
 * @author qiaomengnan
 * @ClassName: PageFlags
 * @Description: 是否分页
 * @date 2018/4/19
 */
public enum PageFlags {

    PAGE("0","分页"),
    NOT_PAGE("1","不分页"),
    PAGE_FLAG("pageFlag","分页参数标识");

    private String flag;

    private String desc;

    PageFlags(String flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag() {
        return flag;
    }
}
