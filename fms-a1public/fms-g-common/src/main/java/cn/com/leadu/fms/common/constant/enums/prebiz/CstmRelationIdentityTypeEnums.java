package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author qiaomengnan
 * @ClassName: CstmRelationIdentityTypeEnums
 * @Description:
 * @date 2018/5/16
 */
public enum CstmRelationIdentityTypeEnums {

    PRINCIPAL_LENDER("0","主贷人"),
    MATE("1","配偶"),
    CONTACT("2","联系人"),
    GUARANTEE_PERSON("3","个人担保"),
    GUARANTEE_COMPANY("4","企业担保"),
    COMMON_BORR("5","共同承租人"),
    GUARANTEE_PERSON_MATE("6","担保人配偶"),
    DRIVER("7","实际用车人"),
    COMPANY_LEGAL("8","企业法人"),
    COMPANY_CONTACT("9","企业联系人"),
    GUARANTEE_COMPANY_LEGAL("10","担保企业法人")
    ;


    private String code;

    private String type;

    CstmRelationIdentityTypeEnums(String code, String type){
        this.code = code;
        this.type = type;
    }

    public String getCode(){
        return this.code;
    }

    public String getType(){
        return this.type;
    }

    public static String getTypeByCode(String code) {
        CstmRelationIdentityTypeEnums[] enums = CstmRelationIdentityTypeEnums.values();
        for(int i = 0; i < enums.length; i++) {
            if (enums[i].getCode().equals(code)) {
                return enums[i].getType();
            }
        }
        return "";

    }

}
