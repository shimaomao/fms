package cn.com.leadu.fms.file.service.impl;

import cn.com.leadu.fms.business.service.CommonExcelService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.ExcelUtils;
import cn.com.leadu.fms.common.constant.enums.ExportExcelFlagEnums;
import cn.com.leadu.fms.common.constant.enums.sql.PageFlags;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.IntegerUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.extend.config.WebProperties;
import cn.com.leadu.fms.extend.config.WebServiceNames;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.file.rpc.system.SysParamRpc;
import cn.com.leadu.fms.file.service.ExcelService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.*;

/**
 * @author qiaomengnan
 * @ClassName: ExcelServiceImpl
 * @Description: excel统一导出service实现类
 * @date 2018/1/31
 */
@Service
@Slf4j
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private RestTemplate commonRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SysParamRpc sysParamRpc;

    @Autowired
    private CommonExcelService commonExcelService;

    /**
     * @Title:
     * @Description:  生成excel文件
     * @param params
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 03:06:04
     */
    public void excelExport(Map<String,Object> params, HttpServletResponse httpServletResponse){
        try{
            if(params == null)
                throw new FmsServiceException("请传递生成excel的必要参数");
            Integer excelType = IntegerUtils.getValue(params.get(ExcelTypeConstants.EXCEL_TYPE));
            if(excelType != null)
                ExcelTypeConstants.checkType(excelType.intValue());
            else
                excelType = ExcelTypeConstants.ONE;
            //判断是否标识了启用excel最大导出数量
            Integer excelDataMax = IntegerUtils.getValue(params.get(ExportExcelFlagEnums.EXCEL_DATA_MAX.getFlag()));
            if(excelDataMax != null){
                 String result = ResponseEntityUtils.getRestResponseData(sysParamRpc.findSysParamByParamKey(CommonParamConstants.EXCEL_DATA_MAX));
                 if(StringUtils.isNotTrimBlank(result))
                     excelDataMax = IntegerUtils.getValue(result);
                 else
                     excelDataMax = 10000;
                params.put(CommonParamConstants.EXCEL_DATA_MAX,IntegerUtils.getValue(excelDataMax));
            }
            params.put(PageFlags.PAGE_FLAG.getFlag(),PageFlags.NOT_PAGE.getFlag());
            String requestUrl = WebServiceNames.getUrlPath(IntegerUtils.getValue(params.get(ExportExcelFlagEnums.SERVICE_FLAG.getFlag())),
                    StringUtils.getValue(params.get(ExportExcelFlagEnums.REQUEST_URL.getFlag())));
            UriComponentsBuilder uriComponentsBuilder =  UriComponentsBuilder.fromHttpUrl(requestUrl);
            for(String key : params.keySet()){
                uriComponentsBuilder.queryParam(key,params.get(key));
            }
            ResponseEntity<RestResponse> responseEntity =  commonRestTemplate.exchange(uriComponentsBuilder.build().toUriString(), HttpMethod.GET,getHttpEntity(),RestResponse.class);
            RestResponse restResponse = responseEntity.getBody();
            PageInfoExtend pageInfoExtend = objectMapper.readValue(objectMapper.writeValueAsString(restResponse.getData()),PageInfoExtend.class);
            Class clazz = Class.forName(pageInfoExtend.getClazz());
            List results = objectMapper.readValue(objectMapper.writeValueAsString(pageInfoExtend.getData()),constructParametricType(List.class,clazz));
            String fileName = commonExcelService.getExcelTitleName(excelType,clazz);
            OutputStream outputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + ExcelUtils.getExcelName(new String(new String(fileName.getBytes("gb2312"), "iso8859-1"))));
            commonExcelService.exportList(fileName,results,clazz,outputStream,excelType.intValue());
        }catch (Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("生成excel失败");
        }
    }

    public JavaType constructParametricType(Class<?> rawType, JavaType... parameterTypes) {
        return objectMapper.getTypeFactory().constructParametricType(rawType,parameterTypes);
    }

    public JavaType constructParametricType(Class<?> collectionClass, Class<?> elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    private HttpEntity getHttpEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(WebProperties.loginUserHeader(), UserInfoUtils.getUserStr());
        headers.add(WebProperties.chainHeader(), UserInfoUtils.getChainHeader());
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        return httpEntity;
    }

}
