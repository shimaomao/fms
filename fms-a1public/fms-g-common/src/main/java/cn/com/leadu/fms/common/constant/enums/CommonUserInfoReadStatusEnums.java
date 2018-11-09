package cn.com.leadu.fms.common.constant.enums;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoReadStatusEnums
 * @Description: 用户消息读取状态
 * @date 2018/4/25 0025
 */
public enum CommonUserInfoReadStatusEnums {

    UNREAD("0","未读"),
    READ("1","已读");

    private String status;

    private String desc;

    CommonUserInfoReadStatusEnums(String status, String desc){
        this.status = status;
        this.desc = desc;
    }

    public String getStatus(){
        return status;
    }

}
