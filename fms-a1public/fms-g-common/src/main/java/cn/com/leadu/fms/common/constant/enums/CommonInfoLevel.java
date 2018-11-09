package cn.com.leadu.fms.common.constant.enums;

/**
 * @author qiaomengnan
 * @ClassName: CommonInfoLevel
 * @Description: 消息级别
 * @date 2018/5/10
 */
public enum CommonInfoLevel {

    IMPORTANT("0","重要"),
    SIMPLE("1","一般");
    private String level;

    private String desc;

    CommonInfoLevel(String level,String desc){
        this.level = level;
        this.desc = desc;
    }

    public String getLevel(){
        return this.level;
    }

    public String getDesc(){
        return this.desc;
    }

}
