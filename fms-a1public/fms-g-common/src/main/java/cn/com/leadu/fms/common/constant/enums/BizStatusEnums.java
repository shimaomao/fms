package cn.com.leadu.fms.common.constant.enums;

/**
 * @author wangxue
 * @ClassName: FinItemTypeEnums
 * @Description: 业务逻辑中用到的状态
 * @date 2018/3/24
 */
public enum BizStatusEnums {
    APPLY_INPUT("0101","申请录入"),
    APPLY_INPUT2("0124","待提交(风控主管审核退回)"),
    APPLY_INPUT3("0126","待提交(合同生成前确认退回)"),
    APPLY_INPUT4("0102","待提交(区域经理审核退回)"),
    APPLY_INPUT5("0103","待提交(风控初审退回)"),
    APPLY_INPUT6("0104","待提交(业务员确认退回)"),
    APPLY_VALID("0105","订单已提交"),
    WAIT_CONTRACT_CONF1("0118","待合同生成前确认"),
    WAIT_CONTRACT_CONF2("0119","待合同生成前确认(二次提交)"),

    APPLY_APPROVE("0108","待风控初审"),
    APPLY_FINISH("0199","订单流程结束"),
    //申请取消/拒绝
    APPLY_INVALID("0120","订单审批拒绝"),
    APPLY_CANCEL("0198","订单取消"),

    WAIT_CONTRACT_GENERATE("0201","合同待生成"),
    WAIT_CONTRACT_PRINT("0202","合同待打印"),
    WAIT_CONTRACT_REQUEST_FUNDS("0203","合同待请款"),
    CONTRACT_EFFECT("0206","合同生效(财务已付款)"),
    CONTRACT_CANCEL("0298","合同取消"),
    CONTRACT_INVALID("0214","合同被拒绝"),

    // 提前还款流程
    PREPAYMENT_PAYMENT_ONE("0709","待财务审核"),
    PREPAYMENT_PAYMENT_TWO("0710","二次提交待财务审核"),
    PREPAYMENT_PAYMENT_BACK("0711","总经理审核退回待财务审核"),
    PREPAYMENT_INVALID("0799","提前还款失效"),
    PREPAYMENT_VALID("0704","提前还款生效"),
    //提前还款
    CONT_PREPAYMENT_INVALID("0799","提前还款作废"),

    //续保归档没有流程
    RENEWAL_SORT("1301","续保归档"),

    //借阅流程
    BORROWED("0400","已借出"),
    BORROW_CANCEL("0410","取消借阅"),

    // 开票流程
    INVOICE_END("3100","开票流程完成"),
    INVOICE_REFUSE("3103","开票流程拒绝"),
    // 上门催收
    COLLECTION_END("3700","上门催收流程完成"),
    COLLECTION_REFUSE("3710","上门催收流程拒绝"),
    COLLECTION_TOBE_APPLY("3711","上门催收待申请提交"),
    // 基本信息变更
    BASIC_CHANGE_END("3200","基本信息变更流程完成"),
    BASIC_CHANGE_REFUSE("3205","基本信息变更流程拒绝"),
    BASIC_CHANGE_CANCEL("3206","基本信息变更流程取消"),
    // 诉讼
    LAWSUIT_END("4000","诉讼流程完成"),
    LAWSUIT_REFUSE("4008","诉讼流程拒绝"),

    // 收车
    RECOVERY_TOBE_APPLY("4135","收车待申请提交"),
    //展期
    DEFER_TASK_FINISH("3307","展期任务结束"),
    //变更承租人
    CHANGE_LESSEE_FINISH("3807","承租人变更结束"),
    // 增加保证金
    DEPOSIT_CHANGE_REFUSE("3423","拒绝"),
    DEPOSIT_CHANGE_FINISH("3407","结束"),
    DEPOSIT_CHANGE_CANCEL("3498","取消"),
    DEPOSIT_FIS_APPLY_APPROVE("3401","保证金变更提交待风控初审"),
    DEPOSIT_SEC_APPLY_APPROVE("3409","保证金变更申请二次提交待初审"),
    DEPOSIT_SEND_BACK_APPROVE("3410","复审退回待初审"),
    DEPOSIT_MANAGER_APPROVE("3403","复审通过待业务副总审核"),
    DEPOSIT_SEC_MANAGER_APPROVE("3413","复审通过二次提交业务副总审核"),
    // 过户流程
    TRANSFER_SAVE("3520", "待提交"),
    TRANSFER_APPLY("3509","退回待二次提交"),
    TRANSFER_END("3508","过户完成");

    private String type;

    private String desc;

    BizStatusEnums(String type, String desc){
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
