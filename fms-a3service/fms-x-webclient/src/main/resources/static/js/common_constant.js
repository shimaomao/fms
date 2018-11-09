/**
 * Created by qiaohao on 2018/2/26.
 */
/**
 * 新数据字典类型
 */
var CommonCodeUtils = new Object();

CommonCodeUtils.phonePattern = '^1[345789]\\d{9}$';

//字典类型
CommonCodeUtils.codeTypes = {
    gender:'gender',
    common_parent_id:'common_parent_id',
    common_status:'common_status',
    enableFlag:'enableFlag',
    menuLevel:'menuLevel',
    sys_widget_type:'sys_widget_type',
    sys_widget_mod:'sys_widget_mod',
    // 车辆等级
    vehicleLevel:'vehicleLevel',
    // 组织类别
    parentType:'parentType',
    // 項目类型
    tplType:'tplType',
    //經銷商合作类型
    partnerType:"partnerType",
    //放款模式
    remitType:"remitType",
    //菜单权限类型
    sys_validMenuType:'sys_validMenuType',
    /*短信发送状态*/
    msgStatus:'msgStatus',
    //是否实际文件
    actualFile:'actualFile',
    //是否必填
    requiredState:'requiredState',
    //取消原因
    cancelReason:'cancelReason',
    //订单状态
    bizStatus:'bizStatus',
    //财务付款审批意见
    contPaymentActType:'contPaymentActType',
    //合同文件核查审批意见
    contInspectActType:'contInspectActType',
    //财务付款退回原因
    contPaymentReason:'contPaymentReason',
    //合同文件核查退回原因
    contInspectReason:'contInspectReason',
    //融资合同取消原因
    contractCancelReason:'contractCancelReason',
    //开户行
    openingBank:'openingBank',
    //店面属性
    salesType:'salesType',
    //银行账号状态
    accountNoStatus:'accountNoStatus',
    //实际销售方状态
    salesTaskStatus:'salesTaskStatus',
    //所属集团
    withinGroup:'withinGroup',
    //保险理赔状态
    insurClaimStatus:'insurClaimStatus',
    //是否需要退还
    returnFlag:'returnFlag',
    //退还方式
    returnMode:'returnMode',
    //逾期风险等级
    overdueRisk:'overdueRisk',
    //机构类型
    organizationType:'organizationType',
    // 车辆类型
    vehicleForm: 'vehicleForm',
    //续保任务状态
    renewalStatus:'renewalStatus',
    // 车辆种类
    vehicleType: 'vehicleType',
    // 牌照属性
    licenseAttr: 'licenseAttr',
    // 租金支付模式
    rentPayMode: 'rentPayMode',
    // GPS安装情况
    gpsInstMode: 'gpsInstMode',
    // 还款频率
    repayRate: 'repayRate',
    // 还款方式
    repayMode: 'repayMode',
    // 保证金返还方式
    depositRtnMode: 'depositRtnMode',
    // 融资期限
    finPeriodType: 'finPeriodType',
    // 手续费收取方式
    chargePayMode: 'chargePayMode',
    //婚姻状况
    marriageStatus:'marriageStatus',
    //户口类型
    censusType:'censusType',
    //学历
    eduBgType:'eduBgType',
    //证件类型
    certifType:'certifType',
    //行业所属类别
    industryType:'industryType',
    // 利率方式
    intrstRateMode:'intrstRateMode',
    // 是否挂靠
    linkFlag:'linkFlag',
    //居住年份
    resideYear:'resideYear',
    //房产类型
    propertyType:'propertyType',
    //区域级别
    areaLevel:'areaLevel',
    //融资方式
    finMode:'finMode',
    //是否可修改
    editMode:'editMode',
    //是否和车款一起支付
    payMode:'payMode',
    //申请类型
    applyType:'applyType',
    //车辆种类
    vehicleType1:'vehicleType1',
    //车辆分类
    vehicleType2:'vehicleType2',
    //客户职业
    professionType:'professionType',
    //客户职位
    positionType:'positionType',
    //居住状况
    resideCond:'resideCond',
    //关系类型(个人)
    relationType:'relationType',
    //关系类型(企业)
    relationTypeComp:'relationTypeComp',
    //企业性质
    compType:'compType',
    //民族
    ethnicType:'ethnicType',
    //融资申请风控审批操作状态
    applyApproveActType:'applyApproveActType',
    //融资申请风控审批有条件同意操作状态
    applyAgreeConditionalActType:'applyAgreeConditionalActType',
    //副总有条件同意操作状态
    applyAgreeConditionalActType2:'applyAgreeConditionalActType2',
    // 合同生成前确认
    confirmBefCont:'confirmBefCont',
    //审批操作
    contRequestPayActType:"contRequestPayActType",
    // 合同打印操作类型
    contPrintActType:'contPrintActType',
    // 合同打印退回原因
    printSendBackReason:'printSendBackReason',
    // 合同资管操作类型
    contQualificationActType:'contQualificationActType',
    // 合同资管退回原因
    qualificationSendBackReason:'qualificationSendBackReason',
    //申请审批退回原因
    appSendBackReason:'appSendBackReason',
    //申请审批拒绝原因
    appRefuseReason:'appRefuseReason',
    //流程日志操作分类
    actType:'actType',
    //	订单状态
    bizStatus:'bizStatus',
    //用户管理级别
    userDeptLevel:'userDeptLevel',
    //黑名单级别
    blackLevel:'blackLevel',
    //黑名单来源
    source:'source' ,
    //归档状态
    origFileStatus:'origFileStatus',
    //文件状态
    origFileDetailStatus:'origFileDetailStatus',
    //资料邮寄业务类型
    bizCodeType:'bizCodeType',
    //收款业务类型
    receiptBizType:'receiptBizType',
    //勾稽状态
    receiptExamStatus:'receiptExamStatus',
    //回填状态
    filBackfillSts:'filBackfillSts',
    //提前还款类型
    prepaymentType:'prepaymentType',
    //提前还款明细类型
    prepaymDetailItem:'prepaymDetailItem',
    //提前还款状态
    prepaymentSts:'prepaymentSts',
    //任务处理状态
    assignmentSts:'assignmentSts',
    //催收类型
    assignmentType:'assignmentType',
    //是否邮寄
    postFlag:'postFlag',
    //规则类型
    ruleType:'ruleType',
    //规则项目属性
    ruleItemType:'ruleItemType',
    //当前是否逾期
    overdueFlag:'overdueFlag',
    //逻辑类型
    logicType:'logicType',
    //当前逾期状态
    overdueCondCd:'overdueCondCd',
    //关系类型
    relationType:'relationType',
    //客户可联性
    connectType:'connectType',
    //工作稳定性
    jobType:'jobType',
    //收入类型
    incomeType:'incomeType',
    //居住类型
    resideType:'resideType',
    //居住地真实性
    addrValidType:'addrValidType',
    //车辆适用情况
    vehicleCondType:'vehicleCondType',
    //担保人可联性
    guaranteeConnType:'guaranteeConnType',
    //联系人可联性
    contactConnType:'contactConnType',
    //配偶可联性
    mateConnType:'mateConnType',
    //保险理赔审核
    insurClaimApproveType:'insurClaimApproveType',
    //逾期状态详情
    overdueDetail:'overdueDetail',
    //是否是风险账户
    riskFlag:'riskFlag',
    //是否有效
    validFlag:'validFlag',
    //续保审核操作分类
    renewalRegisterReviewType:'renewalRegisterReviewType',
    //解抵押状态
    mortgateSts:'mortgateSts',
    //是否新能源车
    newEnergy:'newEnergy',
    //定金是否抵扣车款
    deductibleFees : 'deductibleFees',
    //报价类型
    quotationType:'quotationType',
    //生肖
    chineseZodiac:'chineseZodiac',
    //经营地址类型
    compAddrType:'compAddrType',
    //gps厂商
    gpsSeller:'gpsSeller',
    //GPS是否派单
    gpsDispatchFlag: 'gpsDispatchFlag',
    //GPS安装状态
    gpsInstallStatus: 'gpsInstallStatus',
    //企业类型1
    companyType:'companyType',
    //申请类型2
    companyType2:'companyType2',
    //企业类型2_企业
    companyTypeComp:'companyTypeComp',
    //企业类型2_经销商
    companyTypeSale:'companyTypeSale',
    //是否共同借款人
    isCommonBorrower:'isCommonBorrower',
    //月结状态
    monthlySts:'monthlySts',
    //准驾车型
    quasiDriveModel:'quasiDriveModel',
    //是否有房产
    isHaveProperty:'isHaveProperty',
    //发票类型
    invoiceType:'invoiceType',
    //开票类型
    invoiceDataType:'invoiceDataType',
    //凭证状态
    invoiceVoucherStatus:'invoiceVoucherStatus',
    //客户来源
    customerSource:'customerSource',
    //购车目的
    purposePurchase:'purposePurchase',
    //选择原因
    chooseReason:'chooseReason',
    //是否配偶
    whetherSpouse:'whetherSpouse',
    //业务类别
    serviceCategory:'serviceCategory',
    //是否需要交押金
    depositFlag:'depositFlag',
    //资方类型
    management:'management',
    //抵押类型
    mortgageProcess:'mortgageProcess',
    //借阅审批操作类型
    origFileBorrowExamineType:'origFileBorrowExamineType',
    //付款操作
    paymentActType : 'paymentActType',
    //是否抵扣租金
    deductFlag:'deductFlag',
    //是否融保险
    finFlag:'finFlag',
    //保险购买类型
    insurPurType:'insurPurType',
    //是否需要归档
    origFlag:'origFlag',
    //车辆类型
    vehicleTypeOrig:'vehicleTypeOrig',
    //保险类型1
    insuranceType1:'insuranceType1',
    //保险类型2
    insuranceType2:'insuranceType2',
    //付款/收款 款项名称
    payFundName : 'payFundName',
    //是否确认付款
    confirmPayStatus : 'confirmPayStatus',
    //gps厂商
    gpsAccType:'gpsAccType',
    //抵押资方
    mortgageAccType:'mortgageAccType',
    //保险公司
    insuranceAccType:'insuranceAccType',
    //个人账户
    personAccType:'personAccType',
    //yesNoFlag
    yesNoFlag:'yesNoFlag',
    //盗抢险投保渠道
    theftInsuranceType:'theftInsuranceType',
    //匹配类型
    factorType:'factorType',
    //报价器画面申请类型
    quoApplyType:'quoApplyType',
    //借贷方向
    crdrFlag:'crdrFlag',
    //是否默认账号
    accDefault:'accDefault',
    //抵押状态
    mortgageStatus:'mortgageStatus',
    //回租抵押抵押状态
    mortgageRemindStatus:'mortgageRemindStatus',
    //还款日
    repayDay:'repayDay',
    //扣款状态
    repayStatus:'repayStatus',
    //信用卡或贷款状态
    creditStatus:'creditStatus',
    //gps派工人
    dispatchWorkerUser:'dispatchWorkerUser',
    //领取方式
    borrowGetWay:'borrowGetWay',
    //财务凭证管理发送状态
    finVouSummarySendStatus:'finVouSummarySendStatus',
    //还款状态
    paymentSts:'paymentSts',
    //通用审批（只有提交和退回）
    generalApproval:'generalApproval',
    //总经理审批
    manageApprovalActType:'manageApprovalActType',
    //是否共同担保人
    isCommGuarantee:'isCommGuarantee',
    // 过户状态
    transferSts:'transferSts',
    // 保险处置
    insurancDealType:'insurancDealType',
    // 变更类型
    changeType:'changeType',
    // 数据来源
    dataSourceType:'dataSourceType',
    // 催收级别
    collectionLevel:'collectionLevel',
    // 派单类型
    dispatchType:'dispatchType',
    // 还款意愿
    repayDesireType:'repayDesireType',
    //年检状态
    annualInspectStatus:'annualInspectStatus',
    //风控主管派单状态
    applyDispatchStatus:'applyDispatchStatus',
    //风控审批结果
    windcontrApprovalStatus:'windcontrApprovalStatus',
    //终审审批结果
    finalApprovalStatus:'finalApprovalStatus',
    // 车辆处置方式
    disposalStatus:'disposalStatus',
    // 车辆处置状态
    vehicleDisposalStatus:'vehicleDisposalStatus',

    //指标状态
    licenseIdxStatus:'licenseIdxStatus',
    //开票状态
    invoiceStatus: 'invoiceStatus',
    //维修记录来源
    maintainFlag: 'maintainFlag',
    //诉讼类型
    lawsuitType: 'lawsuitType',
    //诉讼原因
    lawsuitReason: 'lawsuitReason',
    //库管管理车辆状态
    secHandStatus:'secHandStatus',
    //关系类型
    relation:'relation',
    //案件状态
    caseStatus:'caseStatus',
    //结案原因
    lawsuitEndReason:'lawsuitEndReason',
    //库存来源
    secHandCarSource :"secHandCarSource",
    //收车结果
    retrieveResult:'retrieveResult',
    //地址类型
    addressType:'addressType',
    //录入区分
    quotationEntryDistinction:'quotationEntryDistinction',
    //租赁期限
    leasePeriod:'leasePeriod',
    //是否已打印
    printStatus:'printStatus',
    //销货清单标志
    goodsListFlag:'goodsListFlag',
    //金蝶发票种类
    infoKind:'infoKind',
    //开票区分
    invoiceFlag:'invoiceFlag',
    //订单状态
    applyStatus:'applyStatus',
    //款项状态
    fundStatus:'fundStatus',
    //借阅用途
    borrowPurpose:'borrowPurpose',
    //还款计划详情还款状态
    equRepayStatus:'equRepayStatus',
    //过户退保操作分类
    surrenderChargeActType:'surrenderChargeActType',
    //是否超期(剩余归档天数)
    daysRemainingStatus:'daysRemainingStatus',
}

CommonCodeUtils.paramKeys = {
    //过户保证金
    transfer_deposit: 'transfer_deposit',
}

CommonCodeUtils.fileTypePaths = {
    sysTpl:'sysTpl',
    pyFiles:'pyFiles',
    bizFiles:'bizFiles',
    upLoad:'upLoad'
}
CommonCodeUtils.secondPath = {
    payMentFiles:'payMentFiles',  //付款附件
    rePayMentFiles:'rePayMentFiles',  //还款附件
    contReceiptFiles:'contReceiptFiles',//收款明细
    vehMaintainFiles:'vehMaintainFiles',//收款明细附件
}
CommonCodeUtils.carkey = {
    carkey:'carkey'
}
CommonCodeUtils.role = {
    YW:'YW101',
    QY:'QY101',
    FK101:'FK101',
    FK102:'FK102',
}
CommonCodeUtils.applyType = {
    person:'1',//申请类型-个人
    company:'2'//申请类型-企业
}
CommonCodeUtils.changeType = {
    basicChange:'1',//变更类型-基本信息变更
    deferTask:'2',//变更类型-合同展期
    depositChange:'3',//变更类型-保证金变更
    changeLessee:'4',//变更承租人
}
CommonCodeUtils.dispatchType = {
    company:'1',//公司内部
    other:'2',//第三方
}

CommonCodeUtils.invoiceStatus = {
    noInvoice: 0, //未开票
    invoice: 1, //已打印
}
CommonCodeUtils.printStatus = {
    noPrint: 0, //未开票
    print: 1, //已打印
}
CommonCodeUtils.assignmentSts = {
    pre:'0',//催收状态-未处理
    pos:'1',//催收状态-已处理
    payed:'2'//催收状态-已还款
}
CommonCodeUtils.disposalType = {
    redemption:'1',//车辆处置类型-赎回
    capitalAssets:'2',//车辆处置类型-转固定资产
    depositChange:'3',//车辆处置类型-增加保证金
}
CommonCodeUtils.dataSource = {
    auto:'1',//自动程序
    hand:'2',//手动发起
}
CommonCodeUtils.borrowPurpose = {
    normal:'01',//常规
    transfer:'02',//过户
}

//附件类型
CommonCodeUtils.basFileTypes = {
    //申请附件类型(个人)
    perApplyFile:'perApplyFile',
    //申请附件类型(企业)
    compApplyFile:'compApplyFile',
    //风控初审上传附件类型
    applyRiskApproveFile:'applyRiskApproveFile',
    //风控复审上传附件类型
    approveFile:'approveFile',
    //合同附件类型
    contractFile:'contractFile',
    //请款上传附件类型
    requestPayFile:'requestPayFile',
    //经销商上传附件类型
    partnerFile:'partnerFile',
    //实际销售方附件类型
    salesFile:'salesFile',
    //保险理赔附件
    insuranceFile:'insuranceFile',
    //盗抢险附件
    pilferInsuranceFile:'pilferInsuranceFile',
    //续保一览附件
    renewalRegisterFile:'renewalRegisterFile',
    //收车机构附件
    carCollectCompFile:'carCollectCompFile',
    //解抵押附件
    mortgageRegisterFile:'mortgageRegisterFile',
    //家访附件
    applyVisitFile:'applyVisitFile',
    //解抵押申请附件
    mortgageRelFile:'mortgageRelFile',
    //解抵押确认附件
    mortgageRelConfFile:'mortgageRelConfFile',
    //原件归档附件
    origSortFile:'origSortFile',
    //续保归档附件
    origRenewalSortFile:'origRenewalSortFile',
    //抵押附件
    equMorFile: 'equMorFile',
    //抵押费用附件
    equMorChargeFile: 'equMorChargeFile',
    //银行账号维护附件
    basBankInfoFile: 'basBankInfoFile',
    //gps月结申请附件
    gpsDispatchMonthlyFile:'gpsDispatchMonthlyFile',
    //盗抢险月结申请附件
    pilferInsuranceMonthlyFile:'pilferInsuranceMonthlyFile',
    //开票变更申请附件
    invoiceChangeFile:'invoiceChangeFile',
    //展期申请合同附件
    deferContractFile:'deferContractFile',
    //展期申请合同生成附件
    deferContractGenerateFile:'deferContractGenerateFile',
    //展期合同打印附件
    deferContractPrintFile:'deferContractPrintFile',
    //增加保证金申请附件
    depositChangeFile: 'depositChangeFile',
    //增加保证金生成合同附件
    depositChangeContractFile: 'depositChangeContractFile',
    //增加保证金补充协议附件
    depositChangeSuppleFile: 'depositChangeSuppleFile',
    // 过户附件
    transferFile:'transferFile',
    // 上门催收附件
    collectionFile:'collectionFile',
    // // 转固定资产附件
    capitalAssetsFile:'capitalAssetsFile',
    // 车辆赎回附件
    vehicleRedeemFile:'vehicleRedeemFile',
    // 车辆出库附件
    vehicleExportFile:'vehicleExportFile',
    //变更承租人合同生成
    changeContGenerateFile:'directRentFile_BG',
    //变更承租人合同打印
    changeContPrintFile:'changeContPrintFile',
    // 诉讼附件
    lawsuitRegisterFile:'lawsuitRegisterFile',
    //委派登记附件
    registerFile:'registerFile',
    //入库附件
    storageFile:'storageFile',
    //指标附件
    indexAnnexFile:'indexAnnexFile',
    // 过户申请附件
    transferApplyFile: 'transferApplyFile',

    // 车辆维修附件
    vehMaintainFile: 'vehMaintainFile',

    // 回租抵押附件
    mortgageRemindFile: 'mortgageRemindFile',
    // 回租抵押解押附件
    mortgageRemindUnLockFile: 'mortgageRemindUnLockFile',
}

//融资申请风控审批操作分类对应url
CommonCodeUtils.applyApproveActTypeUrls = {
    0 : 'apply_approve/approval',
    1 : 'apply_approve/sendBack',
    2 : 'apply_approve/sendBackTop',
    3 : 'apply_approve/refuse'
}
//融资申请风控审批操作类型对应操作
CommonCodeUtils.actType = {
    0 : 'approve',
    1 : 'sendBack',
    2 : 'sendBackToPar',
    3 : 'refuse'
}
CommonCodeUtils.companyType = {
    person:1,
    company:2,
    sale:3
}

CommonCodeUtils.companyType2 = {
    person:1,
    company1:21,
    company2:22,
    company3:23,
    company4:24,
    sale1:31,
    sale2:32,
    sale3:33,
    sale4:34
}

CommonCodeUtils.receiptBizType = {
    repaymentAmount: 0
}

CommonCodeUtils.urlType = {
    front: 0,
    back: 1
}


CommonCodeUtils.yesNoFlag = {
    yes: 1,
    no : 0
}

CommonCodeUtils.organizationType = {
    userGroup:0,  //用户组
    basSales:1,  //实际销售方
    basPartner:2,  //经销商
    carCollectComp:3,  //收车机构
    gpsManuFacturer:4,  //gps厂商
    mortgages:5,  //抵押资方
    insuranceCompany:6,  //保险公司
    individualAccount:7,  //个人账户
}

CommonCodeUtils.settleStatus = {
    monthlyKnot: 2
}

CommonCodeUtils.finVouSummarySendStatus = {
    send: 1
}

//消息提醒url
CommonCodeUtils.taskInfoUrl = {
    insurance: '92330c8b59b111e8b94c08002792b05d-app/insurance_renewal_register_list-续保任务一览',
    applyList: 'a7c6db064ec211e8abab08002792b05d-app/prebiz_apply_list_search-申请一览查询',
    gpsDispatchList: '205462935ff911e8820108002792b05d-app/cost_gps_dispatch_list-GPS派单录入',
    pilferInsuranceList: '4f98b454656711e8820108002792b05d-app/cost_pilfer_insurance_list-盗抢险信息录入',
    origFileArchive: '49b7dd2b63b111e8820108002792b05d-app/orig_file_archive-原件归档',
    equMorDetailList: 'e4761fb763eb11e8820108002792b05d-app/asset_equ_mor_detail_list-资方解押申请',
}

//我的任务具体类型请求的url
/**
 * 一级key,流程类型
 * 二级key,当前任务所走到的环节
 * 三级key,type -> 当前环节确认时请求的类型 0.页面 1.后台url , url -> 请求的url
 */
CommonCodeUtils.actRuTaskApprovalUrl = {
    contract_generation : {
        approvalReturnDealerType: 2,
        name:'contract_generation',
        contract_generation_apply: {name:'contract_generation_apply',type:CommonCodeUtils.urlType.front,url:{1:'/app/prebiz_apply_input',2:'/app/prebiz_apply_input_company'},serviceType:CommonCodeUtils.yesNoFlag.yes},
        contract_generation_approval: {name:'contract_generation_approval',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_apply_approve'},
        contract_generation_risk: {name:'contract_generation_risk',type:CommonCodeUtils.urlType.front,url:{1:'/app/risk_person_save',2:'/app/risk_company_save'},serviceType:CommonCodeUtils.yesNoFlag.yes},
        contract_generation_diragree: {name:'contract_generation_diragree',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_apply_conditional_agree'},
        contract_generation_preagree: {name:'contract_generation_preagree',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_apply_conditional_agree'},
        contract_generation_manage: {name:'contract_generation_manage',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_apply_manage_approve'},
        contract_generation_sales: {name:'contract_generation_sales',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_apply_agree'},
        contract_generation_confirm:{name:'contract_generation_confirm',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_cont_confirm_bef'},
        contract_generation_process_generate: {name:'contract_generation_process_generate',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_cont_create'},
        contract_generation_process_qualification: {name:'contract_generation_process_qualification',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_cont_qualification'},
        contract_generation_process_print: {name:'contract_generation_process_print',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_cont_print'},
        contract_generation_process_reques_funds: {name:'contract_generation_process_reques_funds',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_cont_request_pay'},
        contract_generation_process_approval:{name:'contract_generation_process_approval',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_cont_inspect'},
        contract_generation_process_charge:{name:'contract_generation_process_charge',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_cont_charge'},
        contract_generation_process_voucher:{name:'contract_generation_process_voucher',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_cont_make_voucher'},
        contract_generation_process_loan:{name:'contract_generation_process_loan',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_receipt_cont_payment'}
    },
    file_post : {
        name:'file_post',
        file_post_receive: {name:'file_post_receive',type:CommonCodeUtils.urlType.front,url:'/app/prebiz_file_send_list'}
    },
    cont_prepayment : {
        name : 'cont_prepayment',
        cont_prepayment_apply : {name:'cont_prepayment_apply',type:CommonCodeUtils.urlType.front,url:'/app/cost_cont_prepayment_modify'},
        cont_prepayment_approval : {name:'cont_prepayment_approval',type:CommonCodeUtils.urlType.front,url:'/app/cost_cont_prepayment_approve'},
        cont_prepayment_review : {name:'cont_prepayment_review',type:CommonCodeUtils.urlType.front,url:'/app/cost_cont_prepayment_approve'},
        cont_prepayment_confirm : {name:'cont_prepayment_confirm',type:CommonCodeUtils.urlType.front,url:'/app/cost_cont_prepayment_receipt_confirm'},
        cont_prepayment_payment :{name:'cont_prepayment_payment',type:CommonCodeUtils.urlType.front,url:'/app/cost_cont_prepayment_payment'},
        cont_prepayment_check :{name:'cont_prepayment_check',type:CommonCodeUtils.urlType.front,url:'/app/cost_cont_prepayment_check'},
        cont_prepayment_export :{name:'cont_prepayment_export',type:CommonCodeUtils.urlType.front,url:'/app/cost_cont_prepayment_vehicle_export'},
    },
    insur_claim_check:{
        insur_claim_check:'insur_claim_check',
        insur_claim_check_apply:{name:'insur_claim_check_apply',type:CommonCodeUtils.urlType.front,url:'/app/insurance_cont_insur_claim_save'},
        insur_claim_check_approve:{name:'insur_claim_check_apply',type:CommonCodeUtils.urlType.front,url:'/app/insurance_cont_insur_claim_approve'},
        insur_claim_check_receivables:{name:'insur_claim_check_receivables',type:CommonCodeUtils.urlType.front,url:'/app/insurance_cont_insur_claim_receivables'},
        insur_claim_check_review:{name:'insur_claim_check_review',type:CommonCodeUtils.urlType.front,url:'/app/finance_cont_insur_claim_make_voucher'},
        insur_claim_check_confirm:{name:'insur_claim_check_confirm',type:CommonCodeUtils.urlType.front,url:'/app/finance_cont_insur_claim_payment'},
    },
    bas_bank_info:{
        bas_bank_info:'bas_bank_info',
        bas_bank_info_operation:{name:'bas_bank_info_operation',type:CommonCodeUtils.urlType.front,url:'/app/baseinfo_bas_bank_info_handler'},
        bas_bank_info_approve:{name:'bas_bank_info_approve',type:CommonCodeUtils.urlType.front,url:'/app/baseinfo_bas_bank_info_approve'},
    },

    bas_sales:{
        bas_sales:'bas_sales',
        bas_sales_operation:{name:'bas_sales_operation',type:CommonCodeUtils.urlType.front,url:'/app/baseinfo_bas_sales_modify'},
        bas_sales_approve:{name:'bas_sales_approve',type:CommonCodeUtils.urlType.front,url:'/app/baseinfo_bas_sales_approve'},
    },
    overdue_exempt:{
        overdue_exempt:'overdue_exempt',
        overdue_exempt_submit:{name:'overdue_exempt_submit',type:CommonCodeUtils.urlType.front,url:'/app/cost_overdue_exempt_modify'},
        overdue_exempt_approve:{name:'overdue_exempt_approve',type:CommonCodeUtils.urlType.front,url:'/app/cost_overdue_exempt_approve'},
    },
    released_mortgage:{
        released_mortgage:'released_mortgage',
        released_mortgage_apply:{name:'released_mortgage_apply',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_detail_apply'},
        released_mortgage_review:{name:'released_mortgage_review',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_detail_review'},
        released_mortgage_receipt:{name:'released_mortgage_receipt',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_detail_receipt'},
        released_mortgage_voucher:{name:'released_mortgage_voucher',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_detail_voucher'},
        released_mortgage_finance:{name:'released_mortgage_finance',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_detail_finance'},
        released_mortgage_confirm:{name:'released_mortgage_confirm',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_detail_confirm'},
    },
    gps_monthly : {
        name : 'gps_monthly',
        gps_monthly_apply : {name:'gps_monthly_apply',type:CommonCodeUtils.urlType.front,url:'/app/cost_gps_dispatch_monthly_modify'},
        gps_monthly_review : {name:'gps_monthly_review',type:CommonCodeUtils.urlType.front,url:'/app/cost_gps_dispatch_monthly_approve'},
        gps_monthly_voucher : {name:'gps_monthly_voucher',type:CommonCodeUtils.urlType.front,url:'/app/finance_gps_monthly_make_voucher'},
        gps_monthly_settlement : {name:'gps_monthly_settlement',type:CommonCodeUtils.urlType.front,url:'/app/finance_gps_monthly_payment'}
    },
    pilfer_monthly : {
        name : 'pilfer_monthly',
        pilfer_monthly_apply : {name:'pilfer_monthly_apply',type:CommonCodeUtils.urlType.front,url:'/app/cost_pilfer_insurance_monthly_modify'},
        pilfer_monthly_review : {name:'pilfer_monthly_review',type:CommonCodeUtils.urlType.front,url:'/app/cost_monthly_pilfer_insurance_approve'},
        pilfer_monthly_voucher : {name:'pilfer_monthly_voucher',type:CommonCodeUtils.urlType.front,url:'/app/finance_pilfer_monthly_make_voucher'},
        pilfer_monthly_settlement : {name:'pilfer_monthly_settlement',type:CommonCodeUtils.urlType.front,url:'/app/finance_pilfer_monthly_payment'}
    },
    equ_mortgage:{
        name:'equ_mortgage',
        equ_mor_apply:{name:'equ_mor_apply',type:CommonCodeUtils.urlType.front,url: 'serviceTypeUrls',serviceTypeUrls:{
            0 : '/app/asset_equ_mor_apply_input',
            1 : '/app/asset_equ_mor_sea_wing_apply_input'
        }},
        equ_mor_import:{name:'equ_mor_import',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_import_tab'},
        equ_mor_upload:{name:'equ_mor_upload',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_archive_tab'},
        equ_mor_review:{name:'equ_mor_review',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_archive_review'},
        equ_mor_touching:{name:'equ_mor_touching',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_finance_touching_tab'},
        equ_mor_approval:{name:'equ_mor_approval',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_manager_approval'},
        equ_mor_pay:{name:'equ_mor_pay',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_finance_pay_tab'},
        equ_mor_receipt:{name:'equ_mor_receipt',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_finance_receipt_tab'},
    },
    equ_mortgage_pay:{
        name:'equ_mortgage_pay',
        equ_mortgage_pay_apply:{name:'equ_mortgage_pay_apply',type:CommonCodeUtils.urlType.front,url: 'serviceTypeUrls',serviceTypeUrls:{
            0 : '/app/asset_equ_mor_apply_input',
            1 : '/app/asset_equ_mor_sea_wing_apply_input'
        }},
        equ_mortgage_pay_import:{name:'equ_mortgage_pay_import',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_import_tab'},
        equ_mortgage_pay_review:{name:'equ_mortgage_pay_review',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_import_review'},
        equ_mortgage_pay_touching:{name:'equ_mortgage_pay_touching',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_finance_touching_tab'},
        equ_mortgage_pay_approval:{name:'equ_mortgage_pay_approval',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_manager_approval'},
        equ_mortgage_pay_pay:{name:'equ_mortgage_pay_pay',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_finance_pay_tab'},
        equ_mortgage_pay_receipt:{name:'equ_mortgage_pay_receipt',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_charge_finance_receipt_tab'},
        equ_mortgage_pay_upload:{name:'equ_mortgage_pay_upload',type:CommonCodeUtils.urlType.front,url:'/app/asset_equ_mor_archive_tab'},
    },
    file_borrow_task:{
        name:'file_borrow_task',
        borrow_task_apply:{name:'borrow_task_apply',type:CommonCodeUtils.urlType.front,url:'/app/original_file_borrow_detail'},
        finance_confirm:{name:'finance_confirm',type:CommonCodeUtils.urlType.front,url:'/app/original_file_borrow_task_finance'},
        borrow_task_examine:{name:'borrow_task_examine',type:CommonCodeUtils.urlType.front,url:'/app/original_file_borrow_examine'},
        borrow_task_mail:{name:'borrow_task_mail',type:CommonCodeUtils.urlType.front,url:'/app/original_file_borrow_mail'},
        borrow_task_reExamine:{name:'borrow_task_reExamine',type:CommonCodeUtils.urlType.front,url:'/app/original_file_borrow_re_examine'},
    },
    file_borrow_back_task:{
        name:'file_borrow_back_task',
        borrow_back_task_apply:{name:'borrow_back_task_apply',type:CommonCodeUtils.urlType.front,url:'/app/original_file_borrow_back_send_detail'},
        borrow_back_task_review:{name:'borrow_back_task_review',type:CommonCodeUtils.urlType.front,url:'/app/original_file_borrow_back_send_examine'},
        borrow_back_task_make_voucher:{name:'borrow_back_task_make_voucher',type:CommonCodeUtils.urlType.front,url:'/app/finance_borrow_task_make_voucher'},
        borrow_back_task_payment:{name:'borrow_back_task_payment',type:CommonCodeUtils.urlType.front,url:'/app/finance_borrow_task_payment'},
        borrow_back_task_confirm:{name:'borrow_back_task_confirm',type:CommonCodeUtils.urlType.front,url:'/app/original_borrow_task_confirm'},
    },
    orig_file_sort:{
        name:'orig_file_sort',
        orig_file_sort_apply:{name:'orig_file_sort_apply',type:CommonCodeUtils.urlType.front,url:'/app/orig_file_sort'},
        orig_file_review:{name:'orig_file_sort_examine',type:CommonCodeUtils.urlType.front,url:'/app/orig_file_sort_examine'},
    },
    renewal_register:{
        name:'renewal_register',
        management_confirm:{name:'management_confirm',type:CommonCodeUtils.urlType.front,url:'/app/insurance_renewal_register_confirm'},
        finance_receipt:{name:'finance_receipt',type:CommonCodeUtils.urlType.front,url:'/app/insurance_renewal_register_receipt'},
        management_withdraw:{name:'management_withdraw',type:CommonCodeUtils.urlType.front,url:'/app/insurance_renewal_register_withdraw'},
        management_review:{name:'management_review',type:CommonCodeUtils.urlType.front,url:'/app/insurance_renewal_register_review'},
        finance_voucher:{name:'finance_voucher',type:CommonCodeUtils.urlType.front,url:'/app/insurance_renewal_register_voucher'},
        finance_payment:{name:'finance_payment',type:CommonCodeUtils.urlType.front,url:'/app/insurance_renewal_register_payment'},
    },
    invoice_change:{
        name:'invoice_change',
        invoice_change_apply:{name:'invoice_change_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_invoice_change_save'},
        invoice_change_approval:{name:'invoice_change_approval',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_invoice_change_approval'},
    },
    basic_change:{
        name:'basic_change',
        basic_change_apply:{name:'basic_change_apply',type:CommonCodeUtils.urlType.front,url:{1:'/app/postbiz_person_basic_change_save', 2:'/app/postbiz_company_basic_change_save'},serviceType:CommonCodeUtils.yesNoFlag.yes},
        basic_change_approval:{name:'basic_change_approval',type:CommonCodeUtils.urlType.front,url:{1:'/app/postbiz_person_basic_change_approval', 2:'/app/postbiz_company_basic_change_approval'},serviceType:CommonCodeUtils.yesNoFlag.yes},
        basic_change_review:{name:'basic_change_review',type:CommonCodeUtils.urlType.front,url:{1:'/app/postbiz_person_basic_change_review', 2:'/app/postbiz_company_basic_change_review'},serviceType:CommonCodeUtils.yesNoFlag.yes},
    },
    defer_task:{
        name:'defer_task',
        defer_task_apply:{name:'defer_task_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_apply_page'},
        defer_task_approve:{name:'defer_task_approve',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_approve_page'},
        defer_task_review:{name:'defer_task_review',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_approve_page'},
        defer_task_audit:{name:'defer_task_audit',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_approve_page'},
        defer_task_cont_generate:{name:'defer_task_cont_generate',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_contract_generate_page'},
        defer_task_cont_print:{name:'defer_task_cont_print',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_contract_print_page'},
        defer_task_cont_audit:{name:'defer_task_cont_audit',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_contract_approve_page'},
        defer_task_finance_approve:{name:'defer_task_finance_approve',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_financial_approve_page'},
        defer_task_manager_approve:{name:'defer_task_manager_approve',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_defer_task_manager_approve_page'},
    },
    deposit_change:{
        name:'deposit_change',
        deposit_change_apply:{name:'deposit_change_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_deposit_change_apply'},
        deposit_change_approval:{name:'deposit_change_approval',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_risk_save'},
        deposit_change_review:{name:'deposit_change_review',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_risk_review_save'},
        deposit_change_pre_agree:{name:'deposit_change_pre_agree',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_risk_review_save'},
        deposit_change_contract_create:{name:'deposit_change_contract_create',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_deposit_contract_create'},
        deposit_change_supple:{name:'deposit_change_supple',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_deposit_contract_sign'},
        deposit_change_contract_approve:{name:'deposit_change_contract_approve',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_deposit_contract_approve'},
        deposit_change_receipt:{name:'deposit_change_receipt',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_deposit_finance_receipt'},
        deposit_change_export:{name:'deposit_change_export',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_deposit_change_export'},
    },
    // 过户任务
    transfer_task:{
        name:'transfer_task',
        transfer_task_apply:{name:'transfer_task_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_transfer_apply'},
        transfer_task_approval:{name:'transfer_task_approval',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_transfer_approve'},
        transfer_task_settlement:{name:'transfer_task_settlement',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_transfer_settlement'},
        transfer_task_review:{name:'transfer_task_review',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_transfer_approve'},
        transfer_task_receipt:{name:'transfer_task_receipt',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_transfer_receipt'},
        transfer_task_touching:{name:'transfer_task_touching',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_transfer_touching'},
        transfer_task_check:{name:'transfer_task_check',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_transfer_approve'},
        transfer_task_loan:{name:'transfer_task_loan',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_transfer_approve'},
    },
    collection_task:{
        name:'collection_task',
        collection_task_apply:{name:'collection_task_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_collection_task_save'},
        collection_task_dispatch:{name:'collection_task_dispatch',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_collection_task_dispatch'},
        collection_task_approval:{name:'collection_task_approval',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_collection_task_approval'},
        collection_task_manager:{name:'collection_task_manager',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_collection_task_manager'},
        collection_task_register:{name:'collection_task_register',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_collection_task_register'},
        collection_task_confirm:{name:'collection_task_confirm',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_collection_task_confirm'},
    },
    change_lessee_task:{
        name:'change_lessee_task',
        change_task_apply:{name:'change_task_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_save'},
        change_task_approve:{name:'change_task_approve',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_approval'},
        change_task_review:{name:'change_task_review',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_approval'},
        change_task_cont_create:{name:'change_task_cont_create',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_cont_create'},
        change_task_cont_print:{name:'change_task_cont_print',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_cont_print'},
        change_task_cont_audit:{name:'change_task_cont_audit',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_basic_change_cont_audit'},
    },
    capital_assets:{
        name:'capital_assets',
        capital_assets_manager:{name:'capital_assets_manager',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_capital_assets_manager'}
    },
    lawsuit_task:{
        name:'lawsuit_task',
        lawsuit_task_apply:{name:'lawsuit_task_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_lawsuit_task_save'},
        lawsuit_task_approval:{name:'lawsuit_task_approval',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_lawsuit_task_approval'},
        lawsuit_task_demanager:{name:'collection_task_demanager',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_lawsuit_task_demanager'},
        lawsuit_task_manager:{name:'lawsuit_task_manager',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_lawsuit_task_manager'},
        lawsuit_task_register:{name:'lawsuit_task_register',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_lawsuit_task_register'},
    },
    retrieve_car:{
        name:'retrieve_car',
        retrieve_task_apply:{name:'retrieve_task_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_launch'},
        retrieve_task_dispatch:{name:'retrieve_task_dispatch',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_risk'},
        retrieve_task_approve:{name:'retrieve_task_approve',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_approve'},
        retrieve_task_review:{name:'retrieve_task_review',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_approve'},
        retrieve_task_check:{name:'retrieve_task_check',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_approve'},
        retrieve_task_register:{name:'retrieve_task_register',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_register'},
        retrieve_task_storage:{name:'retrieve_task_storage',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_storage'},
        retrieve_task_handover:{name:'retrieve_task_handover',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_handover'},
        retrieve_task_financial:{name:'retrieve_task_financial',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_financial'},
        retrieve_task_audit:{name:'retrieve_task_audit',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_retrieve_cars_task_audit'},
    },
    surrender_charge:{
        name:'surrender_charge',
        surrender_charge_apply:{name:'surrender_charge_apply',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_surrender_charge_apply'},
        surrender_charge_approve:{name:'surrender_charge_approve',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_surrender_charge_approve'},
        surrender_charge_receivables:{name:'surrender_charge_receivables',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_surrender_charge_receivables'},
        surrender_charge_review:{name:'surrender_charge_review',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_surrender_charge_review'},
        surrender_charge_confirm:{name:'surrender_charge_confirm',type:CommonCodeUtils.urlType.front,url:'/app/postbiz_surrender_charge_confirm'},
    }

}

//流程key
CommonCodeUtils.processInstanceTypes = {
    contract_generation: 'contract_generation'
}


//字典值
CommonCodeUtils.codeValues={
    common_parent_id:'0',
    common_org_parent_name:'组织机构',
    common_bas_file_type_parent_name:'附件类别',
    common_gender_man:'0',
    common_role_menu_name:'选择用户角色',
    common_menu_name:'角色菜单',
    common_user_menu_name:'选择用户',
    //规则项目结果
    ruleItemTypeConsequence:'0',
    //规则项目条件
    ruleItemTypeCondition: '1',
    //提前还款状态，退回待二次提交
    prepaymentSts : '0705',
    //提前还款已付款，退回待二次提交
    prepaymentStsEnd : '0704',
    //提前还款失效
    contPrepaymentInvalid : '0799',
    //提前还款生效
    contPrepaymentValid : '0704',
    //合同已生效
    contractValid : '0206',
    //合同未结清状态
    uncleared : '0',
    //过户处理暂存，待提交
    transferStsSave : '3520'
}

//业务编码
CommonCodeUtils.bizTypes={
    //融资申请
    apply:'01',
    //合同生成
    contract : '02',
    //原件归档
    origSort:'03',
    //原件借阅
    origBorrow:'04',
    //续保
    renewal:'05',
    //保險理賠
    contInsurClaim:'06',
    //提前还款
    contPrepayment:'07',
    //借阅归还
    origBorrowBack:'08',

    //罚息免除
    overdueExempt:'10',
    //银行账号维护
    basBankInfo:'11',
    //实际销售方
    basSales:'12',
    //展期合同
    deferContract:'33',

    //资方抵押
    equMortgage:'09',
    //资方解抵押
    relief:'22',
    //gps编码
    gps:'23',
    //盗抢险编码
    pilfer:'24',
    //开票信息变更
    invoiceChange:'31',
    //基本信息变更
    basicChange:'32',
    //增加保证金
    depositChange:'34',
    // 过户申请
    transfer:'35',
    // 上门催收
    collectionTask:'37',
    //变更承租人
    changeLessee:'38',
    //转固定资产
    capitalAssets:'39',
    //诉讼
    lawsuit:'40',
    //收车
    retrieveCar:'41',
    //指标未使用状态
    UnusedState:'0',


}

//角色
CommonCodeUtils.roles = {
    riskFirst:'FK102',
    dispatchRole:'FK102'//派单角色
}

//资方
CommonCodeUtils.managements = {
    seaWing: 0
}

//gps厂商
CommonCodeUtils.gpsSellerTypes = {
    ty: '0'
}

//保存所有的数据字典,key以codeType_codeValue拼接
CommonCodeUtils.commonCodeValues = {};

//保存所有的数据字典,key为codeType,值为该codeType下的集合
CommonCodeUtils.commonCodeValuesTree = {};

//保存系统常量
CommonCodeUtils.commonParamValues = {};

//根据系统常量key获取系统常量
CommonCodeUtils.getCommonParam = function(paramKey){
    return  CommonCodeUtils.commonParamValues[paramKey];
}

//根据系统常量key获取系统常量名称
CommonCodeUtils.getCommonParamName = function(paramKey){
    return this.getCommonParam(paramKey)['paramName'];
}

//根据系统常量key获取系统常量值
CommonCodeUtils.getCommonParamValue = function(paramKey){
    return this.getCommonParam(paramKey)['paramValue'];
}

//根据字典类型和字典值获取字典显示名称
CommonCodeUtils.getCodeValueName = function(codeType,codeValue){
    try{
        var codeObj = CommonCodeUtils.commonCodeValues[codeType + CommonStringUtils.LINE + codeValue];
        if(CommonObjectUtils.isExist(codeObj))
            return codeObj.codeValueName;
        return null;
    }catch (err){
        console.error(err);
        return null;
    }
}

//根据字典类型获取下方的字典集合
CommonCodeUtils.getCommonCodes = function(codeType){
    try{
        var result = CommonCodeUtils.commonCodeValuesTree[codeType];
        if(CommonArrayUtils.isNotNullAndLengthNotZero(result))
            return result.sort(CommonNumberUtils.compare('orderNo'))
        return result;
    }catch (err){
        console.error(err);
        return null;
    }
}

//根据字典类型获取字典集合,并且字典集合符合codeValues
CommonCodeUtils.getCommonCodesByValues = function(codeType,codeValues){
    try{
        codeValues = codeValues.replace('，',CommonStringUtils.COMMA);
        var codeValuesArr = codeValues.split(CommonStringUtils.COMMA);
        var resultArr = [];
        var tempArr = this.getCommonCodes(codeType);
        for (var i = 0; i < tempArr.length; i++) {
            if (CommonArrayUtils.vagueContains(tempArr[i].codeValue, codeValuesArr)) {
                resultArr.push(tempArr[i]);
            }
        }
        return resultArr;
    }catch (err){
        console.error(err);
        return null;
    }
}
//用户消息读取状态
CommonCodeUtils.userInfoReadStatus = {
    unread: 0,
    read: 1
}

CommonCodeUtils.commonCodeValueVersionName = "commonCodeValueVersion";
CommonCodeUtils.commonCodeValuesName = "commonCodeValues";
CommonCodeUtils.commonCodeValuesTreeName = "commonCodeValuesTree";

CommonCodeUtils.commonParamValueVersionName = "commonParamValueVersion";
CommonCodeUtils.commonParamValuesName = "commonParamValues";


//数据字典初始化
CommonCodeUtils.initCommonCodeValues = function(){

    var confirmRequest = false;
    var commonCodeValues = localStorage[CommonCodeUtils.commonCodeValuesName];
    var commonCodeValuesTree = localStorage[CommonCodeUtils.commonCodeValuesTreeName];

    //判断两个关键值是否为空,为空则去取值
    if(CommonObjectUtils.isNotExist(commonCodeValues) || CommonObjectUtils.isNotExist(commonCodeValuesTree)){
        confirmRequest = true;
    }

    //如果值已经为空则不用判断version了，直接拿值
    if(!confirmRequest){
        var version = localStorage[CommonCodeUtils.commonCodeValueVersionName];
        //对比数据字典的版本,不一致去取值
        $.ajax({
            type : "get",
            url  : "sys_code/findCommonCodeValueVersion",
            async : false,
            dataType : 'json',
            success : function(data){
                if(version != data.data){
                    confirmRequest = true;
                }
            },
            error : function(data){
                confirmRequest = true;
            }
        });
    }

    if(confirmRequest){
        $.ajax({
            type : "get",
            url : "sys_code/findCommonCodeValuesAll",
            async : false,
            dataType : 'json',
            success : function(data){

                CommonCodeUtils.setCommonCodeValues(data.data);
                // CommonCodeUtils.commonCodeValues = data.data.commonCodeValues;
                // CommonCodeUtils.commonCodeValuesTree = data.data.commonCodeValuesTree;
                // localStorage[CommonCodeUtils.commonCodeValuesName] = JSON.stringify(CommonCodeUtils.commonCodeValues);
                // localStorage[CommonCodeUtils.commonCodeValuesTreeName] = JSON.stringify(CommonCodeUtils.commonCodeValuesTree);
                // localStorage[CommonCodeUtils.commonCodeValueVersionName] = data.data.commonCodeValueVersion;
                //console.log("ajax的:" + localStorage[CommonCodeUtils.commonCodeValuesName]);
                //console.log("ajax的:" + localStorage[CommonCodeUtils.commonCodeValuesTreeName]);
            },
            error : function(XMLHttpRequest){
                if(XMLHttpRequest.status != 401)
                    alert("字典取值失败,请联系管理员");
            }
        });
    }else{
        CommonCodeUtils.commonCodeValues = JSON.parse(commonCodeValues);
        CommonCodeUtils.commonCodeValuesTree = JSON.parse(commonCodeValuesTree);
        //console.log("localStorage的:" + JSON.stringify(CommonCodeUtils.commonCodeValues));
        //console.log("localStorage的:" + JSON.stringify(CommonCodeUtils.commonCodeValuesTree));
    }

}

//设置数据字典的值
CommonCodeUtils.setCommonCodeValues = function(data){
    CommonCodeUtils.commonCodeValues = data.commonCodeValues;
    CommonCodeUtils.commonCodeValuesTree = data.commonCodeValuesTree;

    localStorage[CommonCodeUtils.commonCodeValuesName] = JSON.stringify(CommonCodeUtils.commonCodeValues);
    localStorage[CommonCodeUtils.commonCodeValuesTreeName] = JSON.stringify(CommonCodeUtils.commonCodeValuesTree);
    localStorage[CommonCodeUtils.commonCodeValueVersionName] = data.commonCodeValueVersion;
}

CommonCodeUtils.setCommonParamValues = function(data){
    CommonCodeUtils.commonParamValues = data.commonParamValues;

    localStorage[CommonCodeUtils.commonParamValuesName] = JSON.stringify(CommonCodeUtils.commonParamValues);
    localStorage[CommonCodeUtils.commonParamValueVersionName] = data.commonParamValueVersion;
}


//系统常量初始化
CommonCodeUtils.initCommonParamValues = function(){
    var confirmRequest = false;
    var commonParamValues = localStorage[CommonCodeUtils.commonParamValuesName];
    //判断系统常量是否为空,为空则去取值
    if(CommonObjectUtils.isNotExist(commonParamValues)){
        confirmRequest = true;
    }
    //如果值已经为空则不用判断version了，直接拿值
    if(!confirmRequest){
        var version = localStorage[CommonCodeUtils.commonParamValueVersionName];
        //对比常量字典的版本,不一致去取值
        $.ajax({
            type : "get",
            url  : "sys_param/findSysParamsValueVersion",
            async : false,
            dataType : 'json',
            success : function(data){
                if(version != data.data){
                    confirmRequest = true;
                }
            },
            error : function(data){
                confirmRequest = true;
            }
        });
    }
    if(confirmRequest){
        $.ajax({
            type : "get",
            url : "sys_param/findSysParamsValue",
            async : false,
            dataType : 'json',
            success : function(data){
                CommonCodeUtils.setCommonParamValues(data.data);
            },
            error : function(XMLHttpRequest){
                if(XMLHttpRequest.status != 401)
                    alert("系统常量取值失败,请联系管理员");
            }
        });
    }else{
        CommonCodeUtils.commonParamValues = JSON.parse(commonParamValues);
    }
}



CommonCodeUtils.initCommonCodeValues();
CommonCodeUtils.initCommonParamValues();