package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author huzongcheng
 * @ClassName: ActDepositChangeEnums
 * @Description: 保证金变更元素属性标识
 */
public enum ActCapitalAssetsEnums {

    APPLY_USER("applyUser", "申请人标识"),
    MANAGER_USER("managerUser", "总经理标识"),

    APPLY_STATUS("applyStatus", "提交申请状态标识"),
    MANAGER_STATUS("managerStatus", "总经理审批状态标识"),


    CAPITAL_ASSETS_APPLY("capital_assets_apply", "提交申请任务key"),
    CAPITAL_ASSETS_MANAGER("capital_assets_manager", "初审任务key"),


    MANAGER_USER_UNIT("managerUserUnit", "总经理用户单位标识"),
    MANAGER_USER_ID("managerUserId", "总经理用户单位id标识");

    private String flag;

    private String desc;

    ActCapitalAssetsEnums(String flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag() {
        return this.flag;
    }

    public String getDesc() {
        return this.desc;
    }

}
