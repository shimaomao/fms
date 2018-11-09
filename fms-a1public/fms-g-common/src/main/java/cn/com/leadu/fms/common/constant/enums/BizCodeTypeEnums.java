package cn.com.leadu.fms.common.constant.enums;

/**
 * @author qiaomengnan
 * @ClassName: BizCodeTypeEnums
 * @Description: 代码类型
 * @date 2018/4/11
 */
public enum BizCodeTypeEnums {

    PRE_APPLY_INPUT_PER("perApplyFile","个人申请附件"),
    PRE_APPLY_INPUT_COMP("compApplyFile","企业申请附件"),
    APPLY_ARPPROVE("approveFile","审批附件"),
    APPLY_RISK_APPROVE_FILE("applyRiskApproveFile","风控初审附件"),
    CONTRACT("contractFile","合同附件"),
    REQUEST_PAY("requestPayFile","请款附件"),
    PARTNER("partnerFile","经销商附件"),
    BAS_SALES("salesFile","实际销售方附件"),
    ORIG_SORT_FILE("origSortFile","原件归档附件"),
    ORIG_SORT_FILE1("origSortFile1","经营租赁"),
    ORIG_SORT_FILE2("origSortFile2","回租赁"),
    ORIG_RENEWAL_SORT_FILE("origRenewalSortFile","续保归档附件"),
    CONT_INSUR_CLAIM("insuranceFile","保险理赔附件"),
    RENEWAL_REGISTER("renewalRegisterFile","续保任务附件"),
    MORTGAGE_REGISTER_POST("mortgageRegisterPost","解抵押邮寄附件"),
    MORTGAGE_REGISTER("mortgageRegisterFile","解抵押附件"),
    EQU_MORTGAGE_REL_FILE("mortgageRelFile","资方解抵押申请附件"),
    EQU_MORTGAGE_REL_CONF_FILE("mortgageRelConfFile","资方解抵押确认附件"),
    CAR_COLLECT_COMP("carCollectCompFile","收车机构附件"),
    EQU_MOR_FILE("equMorFile","资方抵押资料上传"),
    EQU_MOR_CHARGE_FILE("equMorChargeFile","资方抵押导入费用资料上传"),
    EQU_MOR_DETAIL_INFO("equMorDetailInfo","抵押明细附件"),
    APPLY_VISIT("applyVisitFile","家访附件"),
    PILFER_INSURANCE_FILE("pilferInsuranceFile","盗抢险附件"),
    BAS_BANK_INFO_FILE("basBankInfoFile","银行账号附件"),
    GPS_DISPATCH_MONTHLY_FILE("gpsDispatchMonthlyFile","gps月结申请附件"),
    PILFER_INSURANC_EMONTHLY_FILE("pilferInsuranceMonthlyFile","盗抢险月结申请附件"),
    INVOICE_CHANGE_FILE("invoiceChangeFile","开票信息变更申请附件"),
    COLLECTION_FILE("collectionFile","上门催收登记附件"),
    LAWSUIT_REGISTER_FILE("lawsuitRegisterFile","诉讼登记附件"),
    DEFER_CONTRACT_FILE("deferContractFile","合同展期申请附件"),
    DEFER_CONTRACT_GENERATE_FILE("deferContractGenerateFile","合同展期合同生成附件"),
    DEFER_CONTRACT_GENERATE_FILE_1("deferContractGenerateFile1","合同展期合同生成附件"),
    DEFER_CONTRACT_PRINT_FILE("deferContractPrintFile","合同展期合同打印附件"),
    DEPOSIT_CHANGE_FILE("depositChangeFile","增加保证金申请附件"),
    DEPOSIT_CHANGE_CONTRACT_FILE("depositChangeContractFile","增加保证金合同附件"),
    DEPOSIT_CHANGE_CONTRACT_FILE_1("depositChangeContractFile1","增加保证金合同附件"),
    DEPOSIT_CHANGE_SUPPLE_FILE("depositChangeSuppleFile","增加保证金补充协议附件"),
    TRANSFER_FILE("transferFile", "过户附件"),
    TRANSFER_APPLY_FILE("transferApplyFile", "过户申请附件"),
    CHANGE_CONTRACT_GENERATE_FILE("changeLesseeDirectRentFile","变更承租人合同直租附件"),
    CHANGE_CONTRACT_PRINT_FILE("changeContPrintFile","变更承租人合同打印附件"),
    CAPITAL_ASSETS_FILE("capitalAssetsFile", "转固定资产附件"),
    VEHICLE_REDEEM_FILE("vehicleRedeemFile", "车辆赎回附件"),
    VEHICLE_EXPORT_FILE("vehicleExportFile", "车辆出库附件"),
    REGISTER_FILE("registerFile","收车委派登记附件"),
    STORAGE_FILE("storageFile","收车车辆入库附件"),
    INDEXANNEX_FILE("indexAnnexFile","指标信息附件"),
    VEHMAINTAIN_FILE("vehMaintainFile","车辆维修附件"),
    VEHMAINTAIN_FILE_1("vehMaintainFile1","车辆维修附件"),
    mortgageRemindFile("mortgageRemindFile","回租抵押附件"),
    mortgageRemindFile_1("mortgageRemindFile1","回租抵押附件"),
    mortgageRemindUnLockFile("mortgageRemindUnLockFile","回租抵押附件"),
    mortgageRemindUnLockFile_1("mortgageRemindUnLockFile1","回租抵押附件");


    private String codeType;

    private String desc;

    BizCodeTypeEnums(String codeType,String desc){
        this.codeType = codeType;
        this.desc = desc;
    }

    public String getCodeType(){
        return this.codeType;
    }

    public String getDesc(){
        return this.desc;
    }

}
