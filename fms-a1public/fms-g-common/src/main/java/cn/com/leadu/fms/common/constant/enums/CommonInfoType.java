package cn.com.leadu.fms.common.constant.enums;

/**
 * @author qiaomengnan
 * @ClassName: CommonInfoType
 * @Description: 消息类型
 * @date 2018/5/10
 */
public enum CommonInfoType {

    TASK("0","我的任务");

    private String type;

    private String desc;

    CommonInfoType(String type,String desc){
        this.type = type;
        this.desc = desc;
    }

    public String getType(){
        return this.type;
    }

    public String getDesc(){
        return this.desc;
    }

}
