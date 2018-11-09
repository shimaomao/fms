package cn.com.leadu.fms.common.constant.enums.asset;/**
 * Created by ningyangyang on 2018/6/1.
 */

/**
 * @Title: fms
 * @Description: 解抵押状态
 * @author: ningyangyang
 * @date 2018/6/1 14:56
 */
public enum  ReliefStatusEnums {

    RELIEF("1","解押"),
    RESOLVING_RELIEF("2","解抵押中");

    private String type;

    private String desc;

    ReliefStatusEnums(String type, String desc){
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
