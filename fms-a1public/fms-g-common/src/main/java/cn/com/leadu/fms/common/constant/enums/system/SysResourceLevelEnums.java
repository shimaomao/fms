package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceLevelEnum
 * @Description: 菜单等级枚举
 * @date 2018/1/23
 */
public enum SysResourceLevelEnums {

    ONE(0, "一级菜单"),
    TWO(1,"二级菜单"),
    THREE(2,"三级菜单");

    private Integer level;
    private String desc;

    SysResourceLevelEnums(Integer level, String desc){
        this.level = level;
        this.desc = desc;
    }

    public Integer getLevel(){
        return this.level;
    }

    public String getLevelToStr(){
        return this.level.toString();
    }

}
