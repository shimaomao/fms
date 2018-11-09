package cn.com.leadu.fms.common.constant.enums.asset;/**
 * Created by ningyangyang on 2018/6/1.
 */

/**
 * @Title: fms
 * @Description:  解押任务状态
 * @author: ningyangyang
 * @date 2018/6/1 11:25
 */
public enum ReliefTaskStatusEnums {

    RELEASED_MORTGAGE("","资方抵押解除"),
    TO_BE_REVIEW("0701","资管复审");

    private String type;

    private String desc;

    ReliefTaskStatusEnums(String type, String desc){
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
