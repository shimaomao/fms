package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @author qiaomengnan
 * @ClassName: VoucherTypeEnums
 * @Description: 财务凭证类型
 * @date 2018/6/30 0030
 */
public enum VoucherTypeEnums {

    PAYCONT_0("paycont0","融资租赁合同签约凭证"),
    RECEIPT_0("receipt0","融资租赁收款凭证"),
    PAYMENT_0("payment0","融资租赁放款凭证"),
    RENTAL_0("rental0","融资租赁租金凭证"),
    INIT_0("init0","融资租赁首付款凭证"),
    CHARGE_0("charge0","融资租赁手续费凭证"),
    RENT_0("rent0","融资租赁尾款及结清款凭证"),

    PAYCONT_1("paycont1","经营租赁合同签约凭证"),
    RECEIPT_1("receipt1","经营租赁收款凭证"),
    PAYMENT_1("payment1","经营租赁放款凭证"),
    RENTAL_1("rental1","经营租赁租金凭证"),
    INIT_1("init1","经营租赁首付款凭证"),
    CHARGE_1("charge1","经营租赁手续费凭证"),
    RENT_1("rent1","经营租赁尾款及结清款凭证"),

    PAYCONT_2("paycont2","回租赁合同签约凭证"),
    RECEIPT_2("receipt2","回租赁收款凭证"),
    PAYMENT_2("payment2","回租赁放款凭证"),
    RENTAL_2("rental2","回租赁租金凭证"),
    INIT_2("init2","回租赁首付款凭证"),
    CHARGE_2("charge2","回租赁手续费凭证"),
    RENT_2("rent2","回租赁尾款及结清款凭证"),


    INIT("init","首付款凭证"),
    CHARGE("charge","手续费凭证"),
    RENT("rent","尾款及结清款凭证");

    private String type;

    private String name;

    VoucherTypeEnums(String type,String name){
        this.type = type;
        this.name = name;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

}
