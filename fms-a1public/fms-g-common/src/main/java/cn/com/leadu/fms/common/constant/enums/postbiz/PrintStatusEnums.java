package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by ningyangyang on 2018/10/24.
 *  打印状态
 */
public enum PrintStatusEnums {

    NOT_PRINT("0","未打印"),
    PRINT("1","已经打印");

    private String status;

    private String desc;

    PrintStatusEnums(String status,String desc){
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
