package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author huzongcheng
 * @ClassName: ActDepositChangeEnums
 * @Description: 保证金变更元素属性标识
 */
public enum ActDepositChangeEnums {

    APPLY_USER("applyUser", "申请人标识"),
    APPROVAL_USER("approvalUser", "初审人标识"),
    REVIEW_USER("reviewUser", "复审人标识"),
    PRE_AGREE_USER("preAgreeUser", "副总审核人标识"),
    CONTRACT_CREATE_USER("contractCreateUser", "合同生成人标识"),
    SUPPLE_USER("suppleUser", "补充协议提交人标识"),
    CONTRACT_APPROVE_USER("contractApproveUser", "合同复核人标识"),
    RECEIPT_USER("receiptUser", "财务收款人标识"),
    EXPORT_USER("exportUser", "出库审核人标识"),

    APPLY_STATUS("applyStatus", "提交申请状态标识"),
    APPROVAL_STATUS("approvalStatus", "初审状态标识"),
    REVIEW_STATUS("reviewStatus", "复审状态标识"),
    PRE_AGREE_STATUS("preAgreeStatus", "副总审核状态标识"),
    CONTRACT_CREATE_STATUS("contractCreateStatus", "合同生成状态标识"),
    SUPPLE_STATUS("suppleStatus", "补充协议上传状态标识"),
    CONTRACT_APPROVE_STATUS("contractApproveStatus", "合同复核状态标识"),
    RECEIPT_STATUS("receiptStatus", "财务收款状态标识"),
    EXPORT_STATUS("exportStatus", "出库状态标识"),


    DEPOSIT_CHANGE_APPLY("deposit_change_apply", "提交申请任务key"),
    DEPOSIT_CHANGE_APPROVAL("deposit_change_approval", "初审任务key"),
    DEPOSIT_CHANGE_REVIEW("deposit_change_review", "复审任务key"),
    DEPOSIT_CHANGE_PRE_AGREE("deposit_change_pre_agree", "副总审核任务key"),
    DEPOSIT_CHANGE_CONTRACT_CREATE("deposit_change_contract_create", "合同生成任务key"),
    DEPOSIT_CHANGE_SUPPLE("deposit_change_supple", "补充协议上传任务key"),
    DEPOSIT_CHANGE_CONTRACT_APPROVE("deposit_change_contract_approve", "合同复核任务key"),
    DEPOSIT_CHANGE_RECEIPT("deposit_change_receipt", "财务收款任务key"),
    DEPOSIT_CHANGE_EXPORT("deposit_change_export", "出库任务key"),



    APPROVAL_USER_UNIT("approvalUserUnit", "初审用户单位标识"),
    APPROVAL_USER_ID("approvalUserId", "初审用户单位id标识"),
    REVIEW_USER_UNIT("reviewUserUnit", "复审用户单位标识"),
    REVIEW_USER_ID("reviewUserId", "复审用户单位id标识"),
    PRE_AGREE_USER_UNIT("preAgreeUserUnit", "副总审核单位标识"),
    PRE_AGREE_USER_ID("preAgreeUserId", "副总审核单位id标识"),
    CONTRACT_CREATE_USER_UNIT("contractCreateUserUnit", "合同生成单位标识"),
    CONTRACT_CREATE_USER_ID("contractCreateUserId", "合同生成单位id标识"),
    SUPPLE_USER_UNIT("suppleUserUnit", "补充协议上传单位标识"),
    SUPPLE_USER_ID("suppleUserId", "补充协议上传单位id标识"),
    CONTRACT_APPROVE_USER_UNIT("contractApproveUserUnit", "合同复核单位标识"),
    CONTRACT_APPROVE_USER_ID("contractApproveUserId", "合同复核单位id标识"),
    RECEIPT_USER_UNIT("receiptUserUnit", "财务收款单位标识"),
    RECEIPT_USER_ID("receiptUserId", "财务收款单位id标识"),
    EXPORT_USER_UNIT("exportUserUnit", "出库单位标识"),
    EXPORT_USER_ID("exportUserId", "出库单位id标识");

    private String flag;

    private String desc;

    ActDepositChangeEnums(String flag, String desc) {
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
