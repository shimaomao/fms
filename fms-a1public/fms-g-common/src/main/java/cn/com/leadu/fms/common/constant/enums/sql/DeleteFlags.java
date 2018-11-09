package cn.com.leadu.fms.common.constant.enums.sql;

/**
 * @author qiaomengnan
 * @ClassName: DeleteFlag
 * @Description:
 * @date 2018/2/5
 */
public enum DeleteFlags {

    EXIST(0,"未删除"),
    NOT_EXIST(1,"已删除");

    private Integer flag;

    private String desc;

    DeleteFlags(Integer flag, String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public Integer getFlag(){
        return flag;
    }

}
