package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActStatusEnums
 * @Description: 工作流状态
 * @date 2018/7/20
 */
public enum ActStatusEnums {

    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    REFUSE(3,"拒绝"),
    CANCEL(5,"取消"),;

    private Integer flag;

    private String desc;

    ActStatusEnums(Integer flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public Integer getFlag(){
        return this.flag;
    }

    public String getDesc(){
        return this.desc;
    }


}
