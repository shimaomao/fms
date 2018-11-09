package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author qiaomengnan
 * @ClassName: SysOrganizationTypeEnum
 * @Description:
 * @date 2018/2/3
 */
public enum SysOrganizationTypeEnums {

    COMPANY(0,"公司/集团"),
    REGION(1,"区域"),
    BRANCH(2,"分公司"),
    SP(3,"SP");

    private Integer type;

    private String desc;

    SysOrganizationTypeEnums(Integer type, String desc){
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

}
