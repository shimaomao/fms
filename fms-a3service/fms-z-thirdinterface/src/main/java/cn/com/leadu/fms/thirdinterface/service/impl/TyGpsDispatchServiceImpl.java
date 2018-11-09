package cn.com.leadu.fms.thirdinterface.service.impl;

import cn.com.leadu.fms.common.constant.GpsTyConstants;
import cn.com.leadu.fms.common.constant.enums.thirdinterface.TyGpsResultEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchQueryVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchVo;
import cn.com.leadu.fms.thirdinterface.config.WebGpsTyProperties;
import cn.com.leadu.fms.thirdinterface.rpc.ty.TyGpsQueryRpc;
import cn.com.leadu.fms.thirdinterface.rpc.ty.TyGpsSendRpc;
import cn.com.leadu.fms.thirdinterface.service.TyGpsDispatchService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchServiceImpl
 * @Description: gps天易派单接口service
 * @date 2018/7/4
 */
@Slf4j
@Service
public class TyGpsDispatchServiceImpl implements TyGpsDispatchService {

    /**
     * @Fields  : 天易派单rpc
     * @author qiaomengnan
     */
    @Autowired
    private TyGpsSendRpc tyGpsSendRpc;

    /**
     * @Fields  : 天易查单rpc
     * @author qiaomengnan
     */
    @Autowired
    private TyGpsQueryRpc tyGpsQueryRpc;

    /**
     * @Fields  : 天易配置
     * @author qiaomengnan
     */
    @Autowired
    private WebGpsTyProperties webGpsTyProperties;

    /**
     * @Fields  : json转换器
     * @author qiaomengnan
     */
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Title:
     * @Description:  gps天易派单
     * @param tyGpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 03:23:14
     */
    public TyGpsDispatchVo sendGpsDispatch(TyGpsDispatchVo tyGpsDispatchVo){
        if(StringUtils.isTrimBlank(webGpsTyProperties.getCarAccount()))
            throw new FmsServiceException("拉车账号不能为空");
        tyGpsDispatchVo.setCarAccount(webGpsTyProperties.getCarAccount());
        try {
            LogUtils.infoLine(log,"gps天易派单请求参数:" + objectMapper.writeValueAsString(tyGpsDispatchVo));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            LogUtils.infoLine(log,"gps天易派单请求参数转换失败");
        }
        Response response = tyGpsSendRpc.sendGpsDispatch(tyGpsDispatchVo);
        LogUtils.infoLine(log,"gps天易派单请求结果:\n" + response +"\n");
        if(response != null && response.body() != null) {
            return JSON.parseObject(response.body().toString(), new TypeReference<TyGpsDispatchVo>() {});
        } else {
            throw new FmsServiceException("gps天易派单接口请求失败");
        }
    }

    /**
     * @Title:
     * @Description:  gps天易查单
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 03:23:14
     */
    public TyGpsDispatchQueryVo findGpsDisPatch(String applyNo){
        if(StringUtils.isTrimBlank(applyNo))
            throw new FmsServiceException("工单号不能为空");
        LogUtils.infoLine(log,"gps天易查单请求参数:" + applyNo);
        Response response = tyGpsQueryRpc.queryGpsDispatch(applyNo);
        LogUtils.infoLine(log,"gps天易查单请求结果:\n" + response +"\n");
        if(response != null && response.body() != null) {
            String body = response.body().toString();
            Map<String,Object> resultMap = JSON.parseObject(body);
            String result = resultMap.get(GpsTyConstants.RESULT) == null?null:resultMap.get(GpsTyConstants.RESULT).toString();
            if(StringUtils.isTrimBlank(result))
                LogUtils.infoLine(log,"gps天易查单请求结果result参数错误:\n" + result +"\n");
            if(TyGpsResultEnums.SUCCESS.getResult().equals(result)){
                String data = resultMap.get(GpsTyConstants.DATA) == null?null:resultMap.get(GpsTyConstants.DATA).toString();
                if(StringUtils.isTrimBlank(data))
                    LogUtils.infoLine(log,"gps天易查单请求结果data参数错误:\n" + data +"\n");
                TyGpsDispatchQueryVo tyGpsDispatchQueryVo = JSON.parseObject(data,new TypeReference<TyGpsDispatchQueryVo>(){});
                tyGpsDispatchQueryVo.setResult(result);
                return tyGpsDispatchQueryVo;
            } else
                return JSON.parseObject(body,new TypeReference<TyGpsDispatchQueryVo>(){});
        } else {
            throw new FmsServiceException("gps天易查单接口请求失败");
        }
    }

}
