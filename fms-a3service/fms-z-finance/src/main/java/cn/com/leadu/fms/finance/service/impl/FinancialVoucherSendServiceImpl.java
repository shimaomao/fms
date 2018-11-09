package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.FinVouSummarySendStatusEnums;
import cn.com.leadu.fms.common.constant.enums.thirdinterface.KingDeeResultEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherSendRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.finance.rpc.thirdinterface.KingDeeRpc;
import cn.com.leadu.fms.finance.service.FinancialVoucherAssisService;
import cn.com.leadu.fms.finance.service.FinancialVoucherDataService;
import cn.com.leadu.fms.finance.service.FinancialVoucherSendService;
import cn.com.leadu.fms.finance.service.FinancialVoucherSummaryService;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherAssis;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSend;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSummary;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSendServiceImpl
 * @Description: 财务发送管理service
 * @date 2018/7/23
 */@Slf4j
@Service
public class FinancialVoucherSendServiceImpl implements FinancialVoucherSendService {

    /**
     * @Fields  : 财务发送管理repository
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherSendRepository financialVoucherSendRepository;

    /** 
     * @Fields  : 财务凭证核算数据service
     * @author qiaomengnan
     */ 
    @Autowired
    private FinancialVoucherAssisService financialVoucherAssisService;

    /**
     * @Fields  : 财务凭证数据service
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherDataService financialVoucherDataService;

    /**
     * @Fields  : 财务凭证数据管理service
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherSummaryService financialVoucherSummaryService;

    /**
     * @Fields  : 金蝶rpc
     * @author qiaomengnan
     */
    @Autowired
    private KingDeeRpc kingDeeRpc;

    /**
     * @Fields  : 序号生成service
     * @author qiaomengnan
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Title:
     * @Description:  发送财务凭证数据
     * @param voucherSummaryIds 凭证管理id集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 04:21:03
     */
    @Transactional
    public KingDeeResultVo sendFinancialVoucher(List<String> voucherSummaryIds,SysUser sysUser){
        //财务凭证管理id
        if(ArrayUtils.isNotNullAndLengthNotZero(voucherSummaryIds)) {
            //获取财务凭证管理集合
            List<FinancialVoucherSummary> finVouSummaryList = financialVoucherSummaryService.findFinancialVoucherSummaryListByIds(voucherSummaryIds);
            if(ArrayUtils.isNotNullAndLengthNotZero(finVouSummaryList)){
                //check是否已经有发送过的数据
                finVouSummaryList.forEach(financialVoucherSummary -> {
                    if(financialVoucherSummary != null && FinVouSummarySendStatusEnums.SEND.getStatus().equals(financialVoucherSummary.getSendStatus()))
                        throw new FmsServiceException("凭证号" + financialVoucherSummary.getVoucherNo() + "已发送过，不可重复发送");
                });
                //获取财务凭证号集合
                List<String> voucherNos = finVouSummaryList.stream().map(FinancialVoucherSummary::getVoucherNo).collect(Collectors.toList());
                if(ArrayUtils.isNotNullAndLengthNotZero(voucherNos)){
                    //财务凭证号对应的凭证区域
                    Map<String,String> voucherGroups = new HashMap<>();
                    finVouSummaryList.forEach(financialVoucherSummary -> {
                        voucherGroups.put(financialVoucherSummary.getVoucherNo(),financialVoucherSummary.getVoucherGroup());
                    });
                    //获取财务凭证数据
                    List<FinancialVoucherData> finVouDataList = financialVoucherDataService.findFinancialVoucherDatas(voucherNos);
                    if(ArrayUtils.isNotNullAndLengthNotZero(finVouDataList)){
                        //财务凭证id
                        List<String> finVouDataIds = finVouDataList.stream().map(FinancialVoucherData::getVoucherDataId).collect(Collectors.toList());Collectors.toList();
                        //同步客户信息
                        kingDeeCus(finVouDataIds);
                        //金蝶凭证数据
                        List<KingDeeVchVo> kingDeeVchVos = getKingDeeVchVo(finVouDataList,voucherGroups);
                        //发送时间
                        Date sendTime = new Date();
                        //发送金蝶凭证数据
                        KingDeeResultFileVo kingDeeResultFileVo = kingDeeVoucher(kingDeeVchVos);
                        if(kingDeeResultFileVo == null)
                            throw new FmsServiceException("凭证核算代码发送失败");
                        //保存发送状态
                        String sendBatchNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.FIN_VOU_SEND.getType());
                        String sendStatus = null;
                        if(KingDeeResultEnums.SUCCESS.getResult().equals(kingDeeResultFileVo.getCode()))
                            //调用成功
                            sendStatus = YesNoFlagEnums.YES.getType();
                        else
                            //调用失败
                            sendStatus = YesNoFlagEnums.NO.getType();
                        //保存发送记录
                        saveSend(voucherNos,sendBatchNo,sendTime,sysUser,kingDeeResultFileVo.getSendFile(),kingDeeResultFileVo.getReturnFile(),sendStatus);
                        //更新最后一次发送状态
                        financialVoucherSummaryService.modifyFinVouSummaryStatus(voucherSummaryIds,sendStatus,sendBatchNo);
                        return EntityUtils.getEntity(kingDeeResultFileVo,new KingDeeResultVo());
                    }
                }
            }
        }
        return null;
    }


    /**
     * @Title:
     * @Description:  保存发送记录
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/28 03:58:37
     */
    private void saveSend(List<String> voucherNos,String sendBatchNo,Date sendTime,SysUser sysUser,String sendFile,String returnFile,String status){
        if(ArrayUtils.isNotNullAndLengthNotZero(voucherNos) && StringUtils.isNotTrimBlank(sendBatchNo)) {
            StringBuffer voucherNoStr = new StringBuffer();
            for (String str: voucherNos) {
                voucherNoStr.append(str + StringUtils.COMMA);
            }
            if(voucherNoStr.length() > 0)
                voucherNoStr = voucherNoStr.deleteCharAt(voucherNoStr.length() - 1);
            FinancialVoucherSend send = new FinancialVoucherSend();
            send.setSendBatchNo(sendBatchNo);
            send.setVoucherNo(voucherNoStr.toString());
            send.setSendTime(sendTime);
            send.setSendUser(sysUser.getUser());
            send.setSendFile(sendFile);
            send.setReturnFile(returnFile);
            send.setSendStatus(status);
            financialVoucherSendRepository.insertData(send);
        }
    }

    /**
     * @Title:
     * @Description:   同步客户信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/28 03:22:04
     */
    private void kingDeeCus(List<String> vouDataIds){
        if(ArrayUtils.isNotNullAndLengthNotZero(vouDataIds)){
            List<KingDeeCusVo> kingDeeCusVos = financialVoucherAssisService.findKingDeeCusVosByVouDataIds(vouDataIds);
            try {
                KingDeeResultFileVo kingDeeResultFileVo = ResponseEntityUtils.getRestResponseData(kingDeeRpc.kingDeeCus(kingDeeCusVos));
                if(kingDeeResultFileVo == null)
                    throw new FmsServiceException("同步金蝶用户失败");
                else{
                    if(KingDeeResultEnums.SUCCESS.getResult().equals(kingDeeResultFileVo.getCode())){
                        //调用成功

                    }else{
                        //调用失败
                        throw new FmsServiceException("同步金蝶用户失败");
                    }
                }
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("同步金蝶用户失败");
            }
        }
    }

    /**
     * @Title:
     * @Description:   发送凭证核算数据
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/28 03:28:47
     */
    private KingDeeResultFileVo kingDeeVoucher(List<KingDeeVchVo> kingDeeVchVos){
        try {
            KingDeeResultFileVo kingDeeResultFileVo = ResponseEntityUtils.getRestResponseData(kingDeeRpc.kingDeeVoucher(kingDeeVchVos));
            return kingDeeResultFileVo;
        } catch (FmsRpcException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("凭证核算代码发送失败");
        }
    }

    /**
     * @Title:
     * @Description:   构建金蝶财务凭证数据
     * @param finVouDataList
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 05:31:10
     */
    private List<KingDeeVchVo> getKingDeeVchVo(List<FinancialVoucherData> finVouDataList,Map<String,String> voucherGroups){
        if(ArrayUtils.isNotNullAndLengthNotZero(finVouDataList) && voucherGroups != null){
            //得到每个凭证对应的财务核算数据
            List<String> vouDataIds = finVouDataList.stream().map(FinancialVoucherData::getVoucherDataId).collect(Collectors.toList());
            List<FinancialVoucherAssis> finVouAssisList = financialVoucherAssisService.findFinVouAssisListByVouDataIds(vouDataIds);
            Map<String,List<FinancialVoucherAssis>> finVouAssisMap = new HashMap<>();
            if(ArrayUtils.isNotNullAndLengthNotZero(finVouAssisList)){
                finVouAssisList.forEach(financialVoucherAssis ->{
                    if(finVouAssisMap.get(financialVoucherAssis.getVoucherDataId()) == null){
                        finVouAssisMap.put(financialVoucherAssis.getVoucherDataId(),new ArrayList<>());
                    }
                    finVouAssisMap.get(financialVoucherAssis.getVoucherDataId()).add(financialVoucherAssis);
                });
            }
            Map<String,KingDeeVchVo> kingDeeVchMap = new LinkedHashMap<>();
            for(FinancialVoucherData finVouData : finVouDataList){
                if(finVouData != null){
                    //凭证号对应的金蝶凭证数据
                    if(kingDeeVchMap.get(finVouData.getVoucherNo()) == null){
                        KingDeeVchVo kingDeeVchVo = new KingDeeVchVo();
                        //凭证字 voucherGroup
                        kingDeeVchVo.setVchGroup(voucherGroups.get(finVouData.getVoucherNo()));
                        //凭证号  voucherNo
                        kingDeeVchVo.setVchNum(finVouData.getVoucherNo());
                        //凭证日期 voucherBizDate
                        kingDeeVchVo.setVchDate(finVouData.getVoucherBizDate());
                        //附件数 1
                        kingDeeVchVo.setVchAttachment("1");
                        //业务日期   voucherBizDate
                        kingDeeVchVo.setVchTranDate(finVouData.getVoucherBizDate());
                        // 凭证明细类对象数组
                        kingDeeVchVo.setVouchEntry(new ArrayList<>());
                        //保存凭证号
                        kingDeeVchMap.put(finVouData.getVoucherNo(),kingDeeVchVo);
                    }
                    //金蝶凭证明细
                    KingDeeVchEntryVo kingDeeVchEntryVo = new KingDeeVchEntryVo();
                    //科目代码   subjectCd
                    kingDeeVchEntryVo.setAcctID(finVouData.getSubjectCd());
                    //摘要      summary
                    kingDeeVchEntryVo.setVchExp(finVouData.getSummary());
                    //借方金额    debitAmount
                    kingDeeVchEntryVo.setVchDebit(finVouData.getDebitAmount());
                    //贷方金额   creditAmount
                    kingDeeVchEntryVo.setVchCredit(finVouData.getCreditAmount());
                    //核算项目ID
                    kingDeeVchEntryVo.setItemID(getItemId(finVouAssisMap.get(finVouData.getVoucherDataId())));
                    //保存对应的金蝶凭证明细
                    kingDeeVchMap.get(finVouData.getVoucherNo()).getVouchEntry().add(kingDeeVchEntryVo);
                }
            }
            return new ArrayList<>(kingDeeVchMap.values());
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   获取itemId
     * @param finVouAssisList
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 11:48:10
     */
    private String getItemId(List<FinancialVoucherAssis> finVouAssisList){
        if(ArrayUtils.isNotNullAndLengthNotZero(finVouAssisList)){
            final StringBuffer result = new StringBuffer();
            finVouAssisList.forEach(financialVoucherAssis -> {
                result.append(financialVoucherAssis.getAssisAccountValue() + StringUtils.SLANT);
            });
            if(result.length() > 0)
                return result.deleteCharAt(result.length() - 1).toString();
        }
        return null;
    }

}
