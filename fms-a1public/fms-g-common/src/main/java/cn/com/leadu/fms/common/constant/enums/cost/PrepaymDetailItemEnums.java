package cn.com.leadu.fms.common.constant.enums.cost;/**
 * Created by yyq on 2018/5/11.
 */

/**
 * @program: fms
 * @description: 提前还款明细类型
 * @author: yangyiquan
 * @create: 2018-05-11 18:21
 **/
public enum PrepaymDetailItemEnums {

    REST_PRINCIPAL("restPrincipal", "剩余本金"),
    OVERDUE_RENT("overdueRent", "逾期租金"),
    OVERDUE_INTEREST("overdueInterest", "逾期罚息"),
    LIQUIDATED_DAMAGES("liquidatedDamages", "违约金"),
    SERVICE_CHARGE("serviceCharge", "手续费"),
    TRANSFER_DEPOSIT("transferDeposit", "过户保证金"),
    OTHER_ADD("otherAdd", "其他增项"),
    DEPOSIT("deposit", "保证金(减项)"),
    RENEWAL_DEPOSIT("renewalDeposit", "续保押金(减项)"),
    RECOVERY_CHARGE("recoveryCharge", "收车费用"),
    OTHER_SUBTRACT("otherSubtract", "其他减项");


    private String type;

    private String desc;

    PrepaymDetailItemEnums(String type, String desc){
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
