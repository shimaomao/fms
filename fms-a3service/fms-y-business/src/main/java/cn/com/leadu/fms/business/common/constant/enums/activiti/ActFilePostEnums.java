package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActFilePostEnums
 * @Description:
 * @date 2018/5/8 0008
 */
public enum ActFilePostEnums {

    FILE_POST_USER("filePostUser","原件邮寄人"),
    FILE_POST_RECEIVE_USER("filePostReceiveUser","原件签收人"),
    FILE_POST_RECEIVE_USER_UNIT("filePostReceiveUserUnit","签收人单位"),
    FILE_POST_RECEIVE_USER_ID("filePostReceiveUserId","签收人单位id");

    private String flag;

    private String desc;

    ActFilePostEnums(String flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag(){
        return this.flag;
    }

    public String getDesc(){
        return this.desc;
    }

}
