package cn.com.leadu.fms.thirdinterface.service.impl;

import cn.com.leadu.fms.common.constant.enums.file.FileTypePathEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.CommonFileUtils;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.*;
import cn.com.leadu.fms.thirdinterface.rpc.goldentax.GoldenTaxInvoiceRpc;
import cn.com.leadu.fms.thirdinterface.rpc.goldentax.GoldenTaxPrintinvRpc;
import cn.com.leadu.fms.thirdinterface.service.GoldenTaxService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxServiceImpl
 * @Description: 金税service
 * @date 2018/9/12 0012
 */
@Slf4j
@Service
public class GoldenTaxServiceImpl implements GoldenTaxService {

    @Autowired
    private GoldenTaxInvoiceRpc goldenTaxInvoiceRpc;

    @Autowired
    private GoldenTaxPrintinvRpc goldenTaxPrintinvRpc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Title:
     * @Description:   开票
     * @param goldenTaxInvoiceSendVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 06:48:25
     */
    public GoldenTaxInvoiceResultVo invoice(GoldenTaxInvoiceSendVo goldenTaxInvoiceSendVo) {
        if(goldenTaxInvoiceSendVo == null || goldenTaxInvoiceSendVo.getOrder() == null)
            throw new FmsServiceException("未接收到发票信息");
        if(ArrayUtils.isNullOrLengthZero(goldenTaxInvoiceSendVo.getOrder().getDetail()))
            throw new FmsServiceException("未接收到商品明细信息");
        //封装传递参数
        String sendFileData = null;
        try {
            sendFileData = objectMapper.writeValueAsString(goldenTaxInvoiceSendVo);
            LogUtils.infoLine(log, String.format("金税开票请求参数:%s",sendFileData));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            LogUtils.infoLine(log,"金税开票请求参数转换失败");
        }
        String sendFile = CommonFileUtils.writeTxtFile(FileTypePathEnums.GOLDEN_TAX_FILES,sendFileData);
        Response response = goldenTaxInvoiceRpc.invoice(goldenTaxInvoiceSendVo);
        LogUtils.infoLine(log, String.format("金税开票请求结果:\n%s\n",response));
        if(response != null && response.body() != null){
            return getGoldenTaxInvoiceResultVo(response,sendFile);
        } else {
            throw new FmsServiceException("金税开票请求失败");
        }
    }

    /**
     * @Title:
     * @Description:   打印
     * @param goldenTaxPrintinvVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 07:02:14
     */
    public GoldenTaxInvoiceResultVo printinv(GoldenTaxPrintinvVo goldenTaxPrintinvVo) {
        if(goldenTaxPrintinvVo == null)
            throw new FmsServiceException("未接收到发票打印参数");
        //封装传递参数
        Map<String,Object> params = new HashMap<>();
        params.put("invoice",goldenTaxPrintinvVo);
        String sendFileData = null;
        try {
            sendFileData = objectMapper.writeValueAsString(params);
            LogUtils.infoLine(log, String.format("金税发票打印请求参数:%s",sendFileData));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            LogUtils.infoLine(log,"金税发票打印请求参数转换失败");
        }
        String sendFile = CommonFileUtils.writeTxtFile(FileTypePathEnums.GOLDEN_TAX_FILES,sendFileData);
        Response response = goldenTaxPrintinvRpc.printinv(params);
        LogUtils.infoLine(log, String.format("金税发票打印请求结果:\n%s\n",response));
        if(response != null && response.body() != null){
            return getGoldenTaxInvoiceResultVo(response,sendFile);
        }else{
            throw new FmsServiceException("金税发票打印请求失败");
        }
    }

    /**
     * @Title:
     * @Description:   构造返回结果
     * @param response
     * @param sendFile
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 10:21:28
     */
    private GoldenTaxInvoiceResultVo getGoldenTaxInvoiceResultVo(Response response,String sendFile){
        if(response != null && response.body() != null){
            String returnFileData = response.body().toString();
            String returnFile = CommonFileUtils.writeTxtFile(FileTypePathEnums.GOLDEN_TAX_FILES,returnFileData);
            String jsonString = response.body().toString();
            GoldenTaxInvoiceResultVo goldenTaxInvoiceResultVo = null;
            if(StringUtils.isNotTrimBlank(jsonString)){
                Map<String,Object> jsonMap = JSON.parseObject(jsonString);
                if(StringUtils.isNotTrimBlank(jsonMap.get("info"))){
                    goldenTaxInvoiceResultVo = JSON.parseObject(jsonMap.get("info").toString(),new TypeReference<GoldenTaxInvoiceResultVo>(){});
                    goldenTaxInvoiceResultVo.setCode(StringUtils.getValue(jsonMap.get("code")));
                    goldenTaxInvoiceResultVo.setMessage(StringUtils.getValue(jsonMap.get("message")));
                }else{
                    goldenTaxInvoiceResultVo = JSON.parseObject(jsonString,new TypeReference<GoldenTaxInvoiceResultVo>(){});
                }
                goldenTaxInvoiceResultVo.setSendFile(sendFile);
                goldenTaxInvoiceResultVo.setReturnFile(returnFile);
            }
            return goldenTaxInvoiceResultVo;
        }
        return null;
    }

}
