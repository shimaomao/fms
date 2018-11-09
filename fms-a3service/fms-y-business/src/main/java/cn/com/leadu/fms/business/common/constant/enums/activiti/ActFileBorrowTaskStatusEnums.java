package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by root on 2018/6/6.
 */
public enum ActFileBorrowTaskStatusEnums {

    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    COMPLETE(2,"结束");

    private Integer flag;

    private String desc;

    ActFileBorrowTaskStatusEnums(Integer flag,String desc){
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
