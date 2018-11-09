package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.rpc.finance.AssisAccountTypeRpc;
import cn.com.leadu.fms.business.rpc.finance.FinancialVoucherDetailRpc;
import cn.com.leadu.fms.business.rpc.finance.SubjectAssisAccountRpc;
import cn.com.leadu.fms.business.service.*;
import cn.com.leadu.fms.business.vo.CommonFinVouData;
import cn.com.leadu.fms.common.constant.FinVouDetailValueConstants;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.FinVouSummarySendStatusEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherAssisRepository;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherDataRepository;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherSummaryRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.finance.entity.*;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qiaomengnan
 * @ClassName: CommonFinVoucherServiceImpl
 * @Description: 财务凭证核算共通
 * @date 2018/6/20
 */
@Slf4j
@Service
public class CommonFinancialVoucherDataServiceImpl implements CommonFinancialVoucherDataService {
    
    /** 
     * @Fields  : 凭证模板service
     * @author qiaomengnan
     */
    @Autowired(required = false)
    private CommonFinancialVoucherDetailService commonFinancialVoucherDetailService;

    /** 
     * @Fields  : 凭证模板rpc
     * @author qiaomengnan
     */ 
    @Autowired
    private FinancialVoucherDetailRpc financialVoucherDetailRpc;

    /** 
     * @Fields  : 凭证科目辅助核算管理service
     * @author qiaomengnan
     */ 
    @Autowired(required = false)
    private CommonSubjectAssisAccountService commonSubjectAssisAccountService;

    /** 
     * @Fields  : 凭证科目辅助核算管理rpc
     * @author qiaomengnan
     */ 
    @Autowired
    private SubjectAssisAccountRpc subjectAssisAccountRpc;

    /** 
     * @Fields  : 凭证科目辅助核算service
     * @author qiaomengnan
     */ 
    @Autowired(required = false)
    private CommonAssisAccountTypeService commonAssisAccountTypeService;

    /** 
     * @Fields  : 凭证科目辅助核算rpc
     * @author qiaomengnan
     */ 
    @Autowired
    private AssisAccountTypeRpc assisAccountTypeRpc;

    /**
     * @Fields  : 财务核算序号service
     * @author qiaomengnan
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 财务凭证数据repository
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherDataRepository financialVoucherDataRepository;

    /**
     * @Fields  : 财务凭证核算数据repository
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherAssisRepository financialVoucherAssisRepository;

    /**
     * @Fields  : 财务凭证管理数据repository
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherSummaryRepository financialVoucherSummaryRepository;

    /**
     * @Title:
     * @Description:  根据凭证类型，获取凭证模板管理数据
     * @param voucherType 凭证类型
     * @param parentData 数据源
     * @param voucherBizCode 业务号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 06:27:33
     */
    public CommonFinVouData getFinVoucherData(String voucherType, Object parentData,String voucherBizCode){
        if(StringUtils.isTrimBlank(voucherType))
            throw new FmsServiceException("凭证类型不能为空");
        if(parentData == null)
            throw new FmsServiceException("凭证数据源不能为空");
        if(StringUtils.isTrimBlank(voucherBizCode))
            throw new FmsServiceException("业务号不能为空");
        List<FinancialVoucherDetail> finVouDetails = null;
        if(commonFinancialVoucherDetailService != null)
            finVouDetails = commonFinancialVoucherDetailService.findFinancialVoucherDetailsByVoucherType(voucherType);
        else{
            try {
                finVouDetails = ResponseEntityUtils.getRestResponseData(
                        financialVoucherDetailRpc.findFinancialVoucherDetailsByVoucherType(voucherType)
                ) ;
            } catch (FmsRpcException ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
                throw new FmsServiceException("获取凭证明细失败");
            }
        }
        //凭证模板不能为空
        if(ArrayUtils.isNotNullAndLengthNotZero(finVouDetails)){
            //抽出凭证模板类型中的科目代码
            List<String> subjectCds =  finVouDetails.stream().map(FinancialVoucherDetail::getSubjectCd).collect(Collectors.toList());
            if(ArrayUtils.isNotNullAndLengthNotZero(subjectCds)){
                //将用户传入的值源头转成map
                Map<String,Object> parentDataMap = null;
                if(parentData instanceof Map)
                    parentDataMap = (Map<String, Object>) parentData;
                else
                    parentDataMap = JSON.parseObject(JSON.toJSONString(parentData));
                //科目代码可能是变量,所以需要替换其值
                subjectCds = replaceSubjectCds(subjectCds,parentDataMap);

                //抽出凭证模板类型中的动态科目代码
                /*List<String> subjectCdDyns =  finVouDetails.stream().map(FinancialVoucherDetail::getSubjectCdDyn).collect(Collectors.toList());
                if (ArrayUtils.isNotNullAndLengthNotZero(subjectCdDyns)) {
                    for (String subjectCdDyn : subjectCdDyns) {
                        if (StringUtils.isNotTrimBlank(subjectCdDyn)) {
                            subjectCdDyn = subjectCdDyn.replace("$", "").replace("{", "").replace("}", "");
                            if (StringUtils.isNotTrimBlank(parentDataMap.get(subjectCdDyn))) {
                                subjectCds.add(parentDataMap.get(subjectCdDyn).toString());
                            }
                        }
                    }
                }*/
                //根据科目代码拿到科目辅助核算
                List<SubjectAssisAccount> subAssList = getSubAssList(subjectCds);
                //抽出科目辅助核算中的核算类型
                List<String> assAccTypes = subAssList.stream().map(SubjectAssisAccount::getAssisAccountType).collect(Collectors.toList());
                //科目辅助核算  key 科目代码 value 相同科目代码的辅助核算
                Map<String,List<SubjectAssisAccount>> subAssListMap = getSubAssMap(subAssList);
                //科目辅助核算类型 key 辅助核算类型 value 相同的辅助核算类型
                Map<String,List<AssisAccountType>> assAccTypesMap = getAssAccTypesMap(getAssAccTypes(assAccTypes));
                //根据凭证类型，取得凭证明细
                //最终的凭证数据
                List<FinancialVoucherData> finVouDatas = new ArrayList<>();
                //最终的凭证核算数据
                List<FinancialVoucherAssis> finVouAssList = new ArrayList<>();
                //固定业务日期,后面生成的日期都采用此值
                Date voucherBizDate = new Date();
                //财务凭证管理
                List<FinancialVoucherSummary> finVouSummarys = new ArrayList<>();
                //生成凭证号
                String voucherNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.FIN_VOU_DATA_NUM_TYPE.getType());

                for(FinancialVoucherDetail finVouDetail : finVouDetails){
                    getFinancialVoucherDatas(voucherNo, parentDataMap,finVouDetail,subAssListMap,assAccTypesMap,finVouAssList,finVouDatas,voucherBizCode,voucherBizDate);
                }
                for(int i = 0;i<finVouDatas.size();i++) {
                    finVouDatas.get(i).setVoucherDetailNo(i+1);
                }

                //构建财务凭证管理
                finVouSummarys.add(getFinancialVoucherSummary(voucherBizCode,voucherBizDate,voucherType,voucherNo));

                CommonFinVouData commonFinVouData = new CommonFinVouData();
                commonFinVouData.setFinVouAssList(finVouAssList);
                commonFinVouData.setFinVouDatas(finVouDatas);
                commonFinVouData.setFinVouSummarys(finVouSummarys);
                //凭证区域
                String voucherGroup = getVoucherGroup(parentDataMap);
                setVoucherGroups(commonFinVouData,voucherGroup);
                return commonFinVouData;
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   保存财务凭证数据
     * @param commonFinVouData
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/07/21 02:48:18
     */
    @Transactional
    public void saveCommonFinVouData(CommonFinVouData commonFinVouData){
        if(commonFinVouData != null){
            if(ArrayUtils.isNotNullAndLengthNotZero(commonFinVouData.getFinVouDatas()))
                financialVoucherDataRepository.insertDataList(commonFinVouData.getFinVouDatas());
            if(ArrayUtils.isNotNullAndLengthNotZero(commonFinVouData.getFinVouAssList()))
                financialVoucherAssisRepository.insertDataList(commonFinVouData.getFinVouAssList());
            if(ArrayUtils.isNotNullAndLengthNotZero(commonFinVouData.getFinVouSummarys()))
                financialVoucherSummaryRepository.insertDataList(commonFinVouData.getFinVouSummarys());
        }
    }

    /**
    * @Description: 获取凭证区域
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/2 14:38
    */
    private String getVoucherGroup(Map<String, Object> dataMap) {
        Object voucherGroup = dataMap.get(FinVouDetailValueConstants.VOUCHER_GROUP);
        if(ObjectUtils.isNull(voucherGroup) || StringUtils.isTrimBlank(voucherGroup.toString())){
            throw new FmsServiceException("凭证区域不能为空");
        }
        return voucherGroup.toString();
    }

    /**
     * @Title:
     * @Description:   设置凭证区域
     * @param commonFinVouData
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 09:52:00
     */
    public CommonFinVouData setVoucherGroups(CommonFinVouData commonFinVouData,String voucherGroup){
        if(commonFinVouData != null && ArrayUtils.isNotNullAndLengthNotZero(commonFinVouData.getFinVouSummarys())){
            commonFinVouData.getFinVouSummarys().forEach(financialVoucherSummary -> {
                financialVoucherSummary.setVoucherGroup(voucherGroup);
            });
        }
        return commonFinVouData;
    }

    /**
     * @Title:
     * @Description:   替换科目代码中的变量
     * @param subjectCds
     * @param parentDataMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/28 05:09:01
     */
    private List<String> replaceSubjectCds(List<String> subjectCds,Map<String,Object> parentDataMap){
        if(ArrayUtils.isNotNullAndLengthNotZero(subjectCds)){
            for(int i = 0; i< subjectCds.size() ; i++ ){
                String subjectCd = subjectCds.get(i);
                if(StringUtils.isNotTrimBlank(subjectCd)){
                    Map<String,String> variables = PatternMatcherUtils.findTemplateVariables(subjectCd);
                    if(variables != null){
                        subjectCd = getValue(subjectCd,variables,parentDataMap);
                        subjectCds.set(i,subjectCd);
                    }
                }
            }
        }
        return subjectCds;
    }

    /**
     * @Title:
     * @Description:   构建财务凭证数据
     * @param parentDataMap 数据来源map
     * @param finVouDetail 财务凭证模板,一个凭证模板算一组,一组生成一个凭证号
     * @param subAssListMap  科目辅助核算  key 科目代码 value 相同科目代码的辅助核算
     * @param asccAccTypesMap 科目辅助核算类型 key 辅助核算类型 value 相同的辅助核算类型
     * @param finVouAssList  最终的凭证核算数据
     * @param finVouDatas 最终的凭证数据
     * @param voucherBizDate 业务日期
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 08:04:48
     */
    private void getFinancialVoucherDatas(String voucherNo, Map<String,Object> parentDataMap,FinancialVoucherDetail finVouDetail ,Map<String,List<SubjectAssisAccount>> subAssListMap
            ,Map<String,List<AssisAccountType>> asccAccTypesMap,List<FinancialVoucherAssis> finVouAssList,List<FinancialVoucherData> finVouDatas,String voucherBizCode,Date voucherBizDate
            ){

        //核算账簿及相应的模板值
        String voucherAccountNo = finVouDetail.getVoucherAccountNo();
        Map<String,String> voucherAccountNoVariables = PatternMatcherUtils.findTemplateVariables(voucherAccountNo);
        //摘要格式及相应的模板值
        String summary = finVouDetail.getSummary();
        Map<String,String> summaryVariables = PatternMatcherUtils.findTemplateVariables(summary);
        //借方金额及相应的模板值
        String debitAmountItem = finVouDetail.getDebitAmountItem();
        Map<String,String> debitAmountItemVariables = PatternMatcherUtils.findTemplateVariables(debitAmountItem);
        //贷方金额及相应的模板值
        String creditAmountItem = finVouDetail.getCreditAmountItem();
        Map<String,String> creditAmountItemVariables = PatternMatcherUtils.findTemplateVariables(creditAmountItem);
        //科目代码及相应的模板值
        String subjectCd = finVouDetail.getSubjectCd();
        Map<String,String> subjectCdVariables = PatternMatcherUtils.findTemplateVariables(subjectCd);
        //科目动态代码及相应的模板值
        String subjectCdDyn = finVouDetail.getSubjectCdDyn();
        Map<String,String> subjectCdDynVariables = new HashMap<>();
        if(StringUtils.isNotTrimBlank(subjectCdDyn)){
            subjectCdDynVariables = PatternMatcherUtils.findTemplateVariables(subjectCdDyn);
        }

        //如果是循环状态
        if(YesNoFlagEnums.YES.getType().equals(finVouDetail.getCycleFlag())){
            //得到循环对象
            Object cycleObject = parentDataMap.get(finVouDetail.getCycleList());
            if(cycleObject != null){
                List<Map<String,Object>> cycleList = (List<Map<String,Object>>)cycleObject;
                //循环相应的对象
                for(Map<String,Object> dataMap : cycleList){
                    //获取财务凭证数据
                    FinancialVoucherData finVouData = getFinancialVoucherData(voucherAccountNo,voucherAccountNoVariables,summary,
                            summaryVariables,debitAmountItem,debitAmountItemVariables,creditAmountItem,creditAmountItemVariables,dataMap
                            ,parentDataMap,subjectCd,subjectCdVariables,subjectCdDyn,subjectCdDynVariables);
                    if(finVouData != null){
                        //设置财务凭证数据默认值
                        setFinVouData(finVouData,finVouDetail,voucherBizCode,voucherNo,voucherBizDate);
                        finVouDatas.add(finVouData);
                        //构建凭证核算数据
                        finVouAssList.addAll(getFinancialVoucherAssisList(finVouData,dataMap,parentDataMap,subAssListMap,asccAccTypesMap,subjectCd));
                    }
                }
            }
        }else{
            //非循环状态
            FinancialVoucherData finVouData = getFinancialVoucherData(voucherAccountNo,voucherAccountNoVariables,summary,
                    summaryVariables,debitAmountItem,debitAmountItemVariables,creditAmountItem,creditAmountItemVariables,null
                    ,parentDataMap,subjectCd,subjectCdVariables,subjectCdDyn,subjectCdDynVariables);
            if(finVouData != null){
                //设置财务核算数据默认值
                setFinVouData(finVouData,finVouDetail,voucherBizCode,voucherNo,voucherBizDate);
                finVouDatas.add(finVouData);
                //构建凭证核算数据
                finVouAssList.addAll(getFinancialVoucherAssisList(finVouData,null,parentDataMap,subAssListMap,asccAccTypesMap,subjectCd));
            }
        }

    }

    /**
     * @Title:
     * @Description:  构建财务凭证管理
     * @param voucherBizCode 业务号
     * @param voucherBizDate 业务日期
     * @param voucherType 凭证类型
     * @param voucherNo 财务凭证号
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/07/21 02:34:14
     */
    private FinancialVoucherSummary getFinancialVoucherSummary(String voucherBizCode,Date voucherBizDate,String voucherType,String voucherNo){
        //构建财务凭证管理
        FinancialVoucherSummary financialVoucherSummary = new FinancialVoucherSummary();
        financialVoucherSummary.setVoucherSummaryId(UUIDUtils.getUUID());
        financialVoucherSummary.setVoucherBizCode(voucherBizCode);
        financialVoucherSummary.setVoucherBizDate(voucherBizDate);
        financialVoucherSummary.setVoucherType(voucherType);
        financialVoucherSummary.setVoucherNo(voucherNo);
        financialVoucherSummary.setSendStatus(FinVouSummarySendStatusEnums.NO_SEND.getStatus());
        return  financialVoucherSummary;
    }

    /**
     * @Title:
     * @Description:   获取科目辅助核算管理
     * @param subjectCds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 01:49:19
     */
    private List<SubjectAssisAccount> getSubAssList(List<String> subjectCds){
        List<SubjectAssisAccount> subjectAssisAccounts = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(subjectCds)){
            if(commonSubjectAssisAccountService != null)
                subjectAssisAccounts = commonSubjectAssisAccountService.findSubjectAssisAccountsBySubjectCds(subjectCds);
            else{
                try {
                    subjectAssisAccounts = ResponseEntityUtils.getRestResponseData(subjectAssisAccountRpc.findSubjectAssisAccountsBySubjectCds(subjectCds));
                } catch (FmsRpcException ex) {
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                    throw new FmsServiceException("获取科目辅助核算管理失败");
                }
            }
        }
        return subjectAssisAccounts;
    }

    /**
     * @Title:
     * @Description:   获取科目辅助核算管理
     * @param subjectAssisAccounts
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 01:49:19
     */
    private Map<String,List<SubjectAssisAccount>> getSubAssMap(List<SubjectAssisAccount> subjectAssisAccounts){
        Map<String,List<SubjectAssisAccount>> subAssMap = new HashMap<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(subjectAssisAccounts)){
            for(SubjectAssisAccount subAss : subjectAssisAccounts){
                if(subAssMap.get(subAss.getSubjectCd()) == null)
                    subAssMap.put(subAss.getSubjectCd(),new ArrayList<>());
                subAssMap.get(subAss.getSubjectCd()).add(subAss);
            }
        }
        return subAssMap;
    }

    /**
     * @Title:
     * @Description:   获取核算类型
     * @param assisAccountTypes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 01:50:43
     */
    private List<AssisAccountType> getAssAccTypes(List<String> assisAccountTypes){
        List<AssisAccountType> assAccTypes = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(assisAccountTypes)){
            if(commonAssisAccountTypeService != null)
                assAccTypes = commonAssisAccountTypeService.findAssisAccountTypesByAccTypes(assisAccountTypes);
            else{
                try {
                    assAccTypes = ResponseEntityUtils.getRestResponseData(assisAccountTypeRpc.findAssisAccountTypesByAccTypes(assisAccountTypes));
                } catch (FmsRpcException ex) {
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                    throw new FmsServiceException("获取辅助核算类型失败");
                }
            }
        }
        return assAccTypes;
    }


    /**
     * @Title:
     * @Description:   获取核算类型
     * @param assAccTypes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 01:50:43
     */
   private Map<String,List<AssisAccountType>> getAssAccTypesMap(List<AssisAccountType> assAccTypes){
       Map<String,List<AssisAccountType>> assAccTypesMap = new HashMap<>();
       if(ArrayUtils.isNotNullAndLengthNotZero(assAccTypes)){
           for(AssisAccountType assAccType : assAccTypes){
               if(assAccTypesMap.get(assAccType.getAssisAccountType()) == null)
                   assAccTypesMap.put(assAccType.getAssisAccountType(),new ArrayList<>());
               assAccTypesMap.get(assAccType.getAssisAccountType()).add(assAccType);
           }
       }
       return assAccTypesMap;
   }




    /**
     * @Title:
     * @Description:   给凭证数据赋值上通用值
     * @param finVouData       凭证数据
     * @param finVouDetail     凭证数据模板
     * @param voucherBizCode   业务号
     * @param voucherNo        凭证号
     * @param voucherBizDate        业务日期
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/07/21 02:07:57
     */
    private void setFinVouData(FinancialVoucherData finVouData,FinancialVoucherDetail finVouDetail,String voucherBizCode,String voucherNo,Date voucherBizDate){
        //凭证号
        finVouData.setVoucherNo(voucherNo);
        //业务日期
        finVouData.setVoucherBizDate(voucherBizDate);
        //业务号
        finVouData.setVoucherBizCode(voucherBizCode);
        //凭证类型
        finVouData.setVoucherType(finVouDetail.getVoucherType());
        //分录号
        finVouData.setVoucherDetailNo(finVouDetail.getVoucherDetailNo());
        //核算账簿
        finVouData.setVoucherAccountNo(finVouDetail.getVoucherAccountNo());
        //附单据数
        finVouData.setAttachCount(finVouDetail.getAttachCount());
        //借贷方向
        finVouData.setCrdrFlag(finVouDetail.getCrdrFlag());
    }

    private FinancialVoucherData getFinancialVoucherData(String voucherAccountNo,
                                                         Map<String,String> voucherAccountNoVariables,
                                                         String summary,
                                                         Map<String,String> summaryVariables,
                                                         String debitAmountItem,
                                                         Map<String,String> debitAmountItemVariables,
                                                         String creditAmountItem,
                                                         Map<String,String> creditAmountItemVariables,
                                                         Map<String,Object> dataMap,
                                                         Map<String,Object> parentDataMap,
                                                         String subjectCd,
                                                         Map<String,String> subjectCdVariables,
                                                         String subjectCdDyn,
                                                         Map<String,String> subjectCdDynVariables
                                                    ){
        FinancialVoucherData finVouData = new FinancialVoucherData();
        finVouData.setVoucherDataId(UUIDUtils.getUUID());
        String voucherAccountNoData = null;
        String summaryData = null;
        String debitAmountData = null;
        String creditAmountData = null;
        String subjectCdData = null;
        String subjectCdDynData = null;
        if(dataMap == null) {
            debitAmountData = getdefaultValue(debitAmountItem,debitAmountItemVariables,parentDataMap);
            creditAmountData = getdefaultValue(creditAmountItem,creditAmountItemVariables,parentDataMap);
            //如果借方金额和贷方金额都为0或不存在，返回null
            if(vialidAmont(debitAmountData,creditAmountData)){
                return null;
            }
            voucherAccountNoData = getValue(voucherAccountNo, voucherAccountNoVariables,parentDataMap);
            summaryData = getValue(summary, summaryVariables,parentDataMap);
            subjectCdData = getValue(subjectCd,subjectCdVariables,parentDataMap);
            subjectCdDynData = getValue(subjectCdDyn,subjectCdDynVariables,parentDataMap);
        } else {
            debitAmountData = getdefaultValue(debitAmountItem,debitAmountItemVariables,dataMap,parentDataMap);
            creditAmountData = getdefaultValue(creditAmountItem,creditAmountItemVariables,dataMap,parentDataMap);
            //如果借方金额和贷方金额都为0或不存在，返回null
            if(vialidAmont(debitAmountData,creditAmountData)){
                return null;
            }
            voucherAccountNoData = getValue(voucherAccountNo, voucherAccountNoVariables, dataMap, parentDataMap);
            summaryData = getValue(summary,summaryVariables,dataMap,parentDataMap);
            subjectCdData = getValue(subjectCd,subjectCdVariables,dataMap,parentDataMap);
            subjectCdDynData = getValue(subjectCdDyn,subjectCdDynVariables,dataMap,parentDataMap);
        }

        finVouData.setVoucherAccountNo(voucherAccountNoData);
        finVouData.setSummary(summaryData);
        //如果科目代码动态值不为空 那么设置的是科目代码动态值
        if(StringUtils.isNotTrimBlank(subjectCdDyn))
            finVouData.setSubjectCd(subjectCdDynData);
        else
            finVouData.setSubjectCd(subjectCdData);
        if(StringUtils.isNotTrimBlank(debitAmountData) && PatternMatcherUtils.isDouble(debitAmountData))
            finVouData.setDebitAmount(new BigDecimal(debitAmountData));
        if(StringUtils.isNotTrimBlank(creditAmountData) && PatternMatcherUtils.isDouble(creditAmountData))
            finVouData.setCreditAmount(new BigDecimal(creditAmountData));
        return finVouData;
    }

    /**
    * @Description: 判断借方金额和贷方金额是否都为0或不存在
    * @param debitAmountData       借方金额
    * @param creditAmountData      贷方金额
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/1 15:45
    */
    private boolean vialidAmont(String debitAmountData, String creditAmountData) {
        if(ObjectUtils.isNull(debitAmountData,creditAmountData))
            return true;
        else{
            if(StringUtils.isNotTrimBlank(debitAmountData) && Double.parseDouble(debitAmountData) != 0)
                return false;
            if(StringUtils.isNotTrimBlank(creditAmountData) && Double.parseDouble(creditAmountData) != 0)
                return false;
        }
        return true;
    }

    /**
    * @Description: 获取map中的金额有关的值，如果没有返回0
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/31 15:59
    */
    private String getdefaultValue(String value,Map<String,String> variables,Map<String,Object> data,Map<String,Object> parentData){
        String valueName = null;
        try {
            valueName = getValue(value, variables, data, parentData);
        } catch (Exception e) {
            valueName = "0";
        }
        return valueName;
    }

    /**
     * @Description: 获取map中的金额有关的值，如果没有返回0
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/8/31 15:59
     */
    private String getdefaultValue(String value,Map<String,String> variables,Map<String,Object> data){
        String valueName = null;
        try {
            valueName = getValue(value, variables, data);
        } catch (Exception e) {
            valueName = "0";
        }
        return valueName;
    }

    /**
     * @Title:
     * @Description:   构建凭证核算数据
     * @param finVouData       凭证数据
     * @param dataMap          数据源头
     * @param parentDataMap    父数据源头
     * @param subAssListMap    科目辅助核算
     * @param asccAccTypesMap  科目辅助核算类型
     * @param subjectCd        科目代码值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 02:55:56
     */
    private List<FinancialVoucherAssis> getFinancialVoucherAssisList(FinancialVoucherData finVouData, Map<String, Object> dataMap, Map<String, Object> parentDataMap
            , Map<String, List<SubjectAssisAccount>> subAssListMap, Map<String, List<AssisAccountType>> asccAccTypesMap, String subjectCd){
        //凭证核算数据
        List<FinancialVoucherAssis> financialVoucherAssisList = new ArrayList<>();
        //非空判读
        if(ObjectUtils.isNotNull(finVouData,parentDataMap,subAssListMap,asccAccTypesMap,subjectCd)){
            //科目辅助核算
            List<SubjectAssisAccount> subAssList = subAssListMap.get(subjectCd);
            if(ArrayUtils.isNotNullAndLengthNotZero(subAssList)){
                //科目辅助核算数据
                for(SubjectAssisAccount subAss : subAssList){
                    //辅助核算类型数据 根据科目辅助核算类型获取
                    List<AssisAccountType> assAccTypes = asccAccTypesMap.get(subAss.getAssisAccountType());
                    if(ArrayUtils.isNotNullAndLengthNotZero(assAccTypes)){
                        //根据辅助核算类型衍生凭证核算数据
                        for(AssisAccountType assAccType : assAccTypes){
                            //凭证辅助核算数据
                            FinancialVoucherAssis finVouAssis = new FinancialVoucherAssis();
                            //财务凭证id
                            finVouAssis.setVoucherDataId(finVouData.getVoucherDataId());
                            //科目辅助核算类型
                            finVouAssis.setAssisAccountType(subAss.getAssisAccountType());
                            //科目辅助核算序号
                            finVouAssis.setAssisAccountOrder(subAss.getAssisAccountOrder());
                            //核算项目值设值
                            String assAccValue = assAccType.getAssisAccountValue();
                            Map<String,String> assAccValueVariables = PatternMatcherUtils.findTemplateVariables(assAccValue);
                            if(parentDataMap == null)
                                finVouAssis.setAssisAccountValue(getValue(assAccValue,assAccValueVariables,dataMap));
                            else
                                finVouAssis.setAssisAccountValue(getValue(assAccValue,assAccValueVariables,dataMap,parentDataMap));
                            financialVoucherAssisList.add(finVouAssis);
                        }
                    }
                }
            }
        }
        return financialVoucherAssisList;
    }


    /**
     * @Title:
     * @Description:   单条数据返回数据
     * @param value
     * @param variables
     * @param data
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 08:05:24
     */
    private String getValue(String value,Map<String,String> variables,Map<String,Object> data){
        if(ObjectUtils.notContainNull(value,variables,data)) {
            //模板值一定要全部替换,否则报错
            for (String key : variables.keySet()) {
                if (variables.get(key) != null && data.get(key) != null) {
                    value = value.replace(variables.get(key), data.get(key).toString());
                }else{
                    throw new FmsServiceException("生成财务凭证失败,模板值:"+key+"没有对应的数据");
                }
            }
        }
        return value;
    }

    /**
     * @Title:
     * @Description:   多条数据返回数据
     * @param value
     * @param variables
     * @param data
     * @param parentData
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 08:05:51
     */
    private String getValue(String value,Map<String,String> variables,Map<String,Object> data,Map<String,Object> parentData){
        if(ObjectUtils.notContainNull(value,variables)) {
            for (String key : variables.keySet()) {
                if (variables.get(key) != null) {
                    if (data != null && data.get(key) != null) {
                        value = value.replace(variables.get(key), data.get(key).toString());
                    } else if (parentData != null && parentData.get(key) != null) {
                        value = value.replace(variables.get(key), parentData.get(key).toString());
                    } else{
                        throw new FmsServiceException("生成财务凭证失败,模板值:"+key+"没有对应的数据");
                    }
                }
            }
        }
        return value;
    }

}
