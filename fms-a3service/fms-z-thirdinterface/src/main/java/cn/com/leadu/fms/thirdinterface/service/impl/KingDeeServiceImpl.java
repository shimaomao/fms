package cn.com.leadu.fms.thirdinterface.service.impl;

import cn.com.leadu.fms.common.constant.enums.file.FileTypePathEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.CommonFileUtils;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeResultFileVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeResultVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeVchVo;
import cn.com.leadu.fms.thirdinterface.rpc.kingdee.KingDeeCusRpc;
import cn.com.leadu.fms.thirdinterface.rpc.kingdee.KingDeeVoucherRpc;
import cn.com.leadu.fms.thirdinterface.service.KingDeeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeServiceImpl
 * @Description: 金蝶接口service
 * @date 2018/7/17 0017
 */
@Slf4j
@Service
public class KingDeeServiceImpl implements KingDeeService {

    /**
     * @Fields  : 金蝶客户接口
     * @author qiaomengnan
     */
    @Autowired
    private KingDeeCusRpc kingDeeCusRpc;

    /** 
     * @Fields  : 金蝶数据接口
     * @author qiaomengnan
     */ 
    @Autowired
    private KingDeeVoucherRpc kingDeeVoucherRpc;


    /**
     * @Fields  : json转换器
     * @author qiaomengnan
     */
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * @Title:
     * @Description:   金蝶客户同步
     * @param kingDeeCusVos 客户信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:23:51
     */
    public KingDeeResultVo kingDeeCus(List<KingDeeCusVo> kingDeeCusVos){
        if(ArrayUtils.isNotNullAndLengthNotZero(kingDeeCusVos)){
            try {
                LogUtils.infoLine(log,"金蝶客户同步请求参数:" + objectMapper.writeValueAsString(kingDeeCusVos));
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
                LogUtils.infoLine(log,"金蝶客户同步请求参数转换失败");
            }
            Response response = kingDeeCusRpc.cus(kingDeeCusVos);
            LogUtils.infoLine(log,"金蝶客户同步请求结果:\n" + response +"\n");
            if(response != null && response.body() != null){
                return JSON.parseObject(response.body().toString(),new TypeReference<KingDeeResultVo>(){});
            }else{
                throw new FmsServiceException("金蝶客户同步接口请求失败");
            }

        }else{
            throw new FmsServiceException("未接收到客户信息");
        }
    }

    /**
     * @Title:
     * @Description:   金蝶财务核算代码同步
     * @param kingDeeVchVos 核算代码信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:24:49
     */
    public KingDeeResultFileVo kingDeeVoucher(List<KingDeeVchVo> kingDeeVchVos){
        if(ArrayUtils.isNotNullAndLengthNotZero(kingDeeVchVos)){
            String sendFileData = null;
            try {
                sendFileData = objectMapper.writeValueAsString(kingDeeVchVos);
                LogUtils.infoLine(log,"金蝶财务核算代码同步请求参数:" + sendFileData);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
                LogUtils.infoLine(log,"金蝶财务核算代码同步请求参数转换失败");
            }
            String sendFile = CommonFileUtils.writeTxtFile(FileTypePathEnums.KING_DEE_FILES,sendFileData);
            Response response = kingDeeVoucherRpc.voucher(kingDeeVchVos);
            LogUtils.infoLine(log,"金蝶财务核算代码同步请求结果:\n" + response +"\n");
            if(response != null && response.body() != null){
                String returnFileData = response.body().toString();
                String returnFile = CommonFileUtils.writeTxtFile(FileTypePathEnums.KING_DEE_FILES,returnFileData);
                KingDeeResultFileVo kingDeeResultFileVo = JSON.parseObject(response.body().toString(),new TypeReference<KingDeeResultFileVo>(){});
                kingDeeResultFileVo.setSendFile(sendFile);
                kingDeeResultFileVo.setReturnFile(returnFile);
                return kingDeeResultFileVo;
            }else{
                throw new FmsServiceException("金蝶财务核算代码同步请求失败");
            }
        }else{
            throw new FmsServiceException("未接收到财务核算代码信息");
        }
    }

}
