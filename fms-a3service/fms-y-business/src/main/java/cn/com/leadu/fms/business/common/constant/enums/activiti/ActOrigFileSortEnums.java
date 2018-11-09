package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @ClassName: ActOrigFileSortEnums
 * @Description: activiti流程引擎key名称
 * @author lijunjun
 * @date 2018/4/8
 */
public enum ActOrigFileSortEnums {

    APPLY_USER("applyUser","申请人标识"),
    REVIEW_USER("reviewUser","复核人标识"),

    ORIG_FILE_SORT_APPLY("orig_file_sort_apply","资管归档任务key"),
    ORIG_FILE_REVIEW("orig_file_review","资管复核任务key"),

    REVIEW_STATUS("reviewStatus","资管复核状态标识"),

    REVIEW_USER_UNIT("reviewUserUnit","资管复核用户单位标识"),
    REVIEW_USER_ID("reviewUserId","资管复核用户单位id标识");

    private String flag;

    private String desc;

    ActOrigFileSortEnums(String flag,String desc){
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
