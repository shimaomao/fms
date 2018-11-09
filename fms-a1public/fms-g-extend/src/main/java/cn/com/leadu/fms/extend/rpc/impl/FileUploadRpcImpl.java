package cn.com.leadu.fms.extend.rpc.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.extend.config.WebProperties;
import cn.com.leadu.fms.extend.config.WebServiceNames;
import cn.com.leadu.fms.extend.response.ResponseFailEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.extend.rpc.FileUploadRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author qiaomengnan
 * @ClassName: FileUploadRpcImpl
 * @Description: rpc传递文件
 * @date 2018/2/6
 */
@Slf4j
@Component
public class FileUploadRpcImpl implements FileUploadRpc {

    @Autowired
    private RestTemplate commonRestTemplate;

    /**
     * @Title:
     * @Description:   对象传参并指定文件和名称
     * @param requestUrl
     * @param object
     * @param fileName
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/23 03:34:43
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, Object object ,String fileName, MultipartFile ...multipartFiles){
        try{
            return fileUpload(requestUrl,object,fileName,ArrayUtils.asList(multipartFiles));
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse(ResponseFailEnums.FILE_UPLOAD_ERROR), HttpStatus.OK);
        }
    }

    /**
     * @Title:
     * @Description:   对象传参并指定文件和名称
     * @param requestUrl
     * @param object
     * @param fileName
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/23 03:34:43
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, Object object ,String fileName, List<MultipartFile> multipartFiles){
        try{
            Map<String,Object> params = getParams(object);
            params.put(fileName,multipartFiles);
            return fileUpload(requestUrl,params);
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse(ResponseFailEnums.FILE_UPLOAD_ERROR), HttpStatus.OK);
        }
    }


    /**
     * @Title:
     * @Description:   对象传参
     * @param requestUrl
     * @param object
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/23 03:34:43
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, Object object){
        try{
            Map<String,Object> params = getParams(object);
            return fileUpload(requestUrl,params);
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse(ResponseFailEnums.FILE_UPLOAD_ERROR), HttpStatus.OK);
        }
    }

    /**
     * @Title:
     * @Description:   封装对象参数
     * @param object
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/23 03:26:10
     */
    private Map<String,Object> getParams(Object object) throws IllegalAccessException {
        Map<String,Object> params = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            params.put(field.getName(),field.get(object));
        }
        return params;
    }


    /**
     * @Title:
     * @Description:  通过远程url已经定义好的参数上传文件
     * @param requestUrl
     * @param params
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/06 10:25:36
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, Map<String,Object> params){
        try{
            HttpHeaders headers = getHeader(requestUrl);
            MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();
            for(String paramKey : params.keySet()){
                Object paramValue =  params.get(paramKey);
                if(paramValue instanceof MultipartFile){
                    MultipartFile paramValueTmp = (MultipartFile) paramValue;
                    formParams.add(paramKey, getFileByteArray(paramValueTmp));
                }else if(paramValue instanceof List){
                    List paramValueTmp = (List)paramValue;
                    if(ArrayUtils.isNotNullAndLengthNotZero(paramValueTmp) && paramValueTmp.get(0) instanceof MultipartFile){
                        setParamFileByteArrays(formParams,paramKey,paramValueTmp);
                    }else{
                        formParams.add(paramKey,paramValue);
                    }
                }else if(paramValue instanceof MultipartFile []){
                    setParamFileByteArrays(formParams,paramKey,(MultipartFile [])paramValue);
                }else{
                    formParams.add(paramKey,paramValue);
                }
            }
            HttpEntity<MultiValueMap<String, Object>> requestParams = new HttpEntity<>(formParams, headers);
            ResponseEntity<RestResponse> result = commonRestTemplate.exchange(requestUrl,HttpMethod.POST, requestParams, RestResponse.class);
            return result;
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse(ResponseFailEnums.FILE_UPLOAD_ERROR), HttpStatus.OK);
        }
    }

    /**
     * @Title:
     * @Description:  通过远程url和文件名及文件值上传文件
     * @param requestUrl
     * @param fileName
     * @param multipartFile
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/06 10:43:40
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName, MultipartFile multipartFile){
        try {
            HttpHeaders headers = getHeader(requestUrl);
            MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();
            formParams.add(fileName, getFileByteArray(multipartFile));
            HttpEntity<MultiValueMap<String, Object>> requestParams = new HttpEntity<>(formParams, headers);
            ResponseEntity<RestResponse> result = commonRestTemplate.exchange(requestUrl,HttpMethod.POST, requestParams, RestResponse.class);
            return result;
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse(ResponseFailEnums.FILE_UPLOAD_ERROR), HttpStatus.OK);
        }
    }

    /**
     * @Title:
     * @Description:   通过远程url和文件名及文件值集合上传文件
     * @param requestUrl
     * @param fileName
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/06 11:00:08
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName, List<MultipartFile> multipartFiles){
        try{
            HttpHeaders headers = getHeader(requestUrl);
            MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();
            for(MultipartFile multipartFile : multipartFiles){
                formParams.add("originalFilenames",multipartFile.getOriginalFilename());
                formParams.add(fileName,getFileByteArray(multipartFile));
            }

            HttpEntity<MultiValueMap<String, Object>> requestParams = new HttpEntity<>(formParams, headers);
            ResponseEntity<RestResponse> result = commonRestTemplate.exchange(requestUrl,HttpMethod.POST, requestParams, RestResponse.class);
            return result;
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse(ResponseFailEnums.FILE_UPLOAD_ERROR), HttpStatus.OK);
        }
    }


    /**
     * @Title:
     * @Description:   通过远程url和文件名及文件值集合上传文件
     * @param requestUrl
     * @param fileName
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/06 11:00:08
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName,Map<String,Object> params, List<MultipartFile> multipartFiles){
        try{
            HttpHeaders headers = getHeader(requestUrl);
            MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();
            for(MultipartFile multipartFile : multipartFiles){
                formParams.add("originalFilenames",multipartFile.getOriginalFilename());
                formParams.add(fileName,getFileByteArray(multipartFile));
            }
            for(String paramKey : params.keySet()){
                formParams.add(paramKey,params.get(paramKey));
            }
            HttpEntity<MultiValueMap<String, Object>> requestParams = new HttpEntity<>(formParams, headers);
            ResponseEntity<RestResponse> result = commonRestTemplate.exchange(requestUrl,HttpMethod.POST, requestParams, RestResponse.class);
            return result;
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse(ResponseFailEnums.FILE_UPLOAD_ERROR), HttpStatus.OK);
        }
    }


    /**
     * @Title:
     * @Description:   通过远程url和文件名及文件值集合上传文件
     * @param requestUrl
     * @param fileName
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/06 11:00:08
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName, MultipartFile ...multipartFiles){
        return fileUpload(requestUrl,fileName,Arrays.asList(multipartFiles));
    }


    /**
     * @Title:
     * @Description:   通过远程url和文件名及文件值集合上传文件
     * @param requestUrl
     * @param fileName
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/06 11:00:08
     */
    public ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName,Map<String,Object> params, MultipartFile ...multipartFiles){
        return fileUpload(requestUrl,fileName,params,Arrays.asList(multipartFiles));
    }

    /**
     * @Title:
     * @Description:   新建header，并根据请求url存入不同的数据
     * @param requestUrl
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/23 04:59:00
     */
    private HttpHeaders getHeader(String requestUrl){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        if(WebServiceNames.isFmsAgent(requestUrl)){
            if(WebProperties.isAuthorization(requestUrl)) {
                headers.add(WebProperties.AUTHORIZATION, WebProperties.getLoginUserBearerCookieValue());
            }
        }else{
            headers.add(WebProperties.loginUserHeader(), UserInfoUtils.getUserStr());
            headers.add(WebProperties.chainHeader(), UserInfoUtils.getChainHeader());
        }
        return headers;
    }

    private void setParamFileByteArrays(MultiValueMap<String, Object> formParams,String fileName,List<MultipartFile> multipartFiles){
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                formParams.add(fileName,getFileByteArray(multipartFile));
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void setParamFileByteArrays(MultiValueMap<String, Object> formParams,String fileName,MultipartFile ...multipartFiles){
         setParamFileByteArrays(formParams,fileName,Arrays.asList(multipartFiles));
    }

    private ByteArrayResource getFileByteArray(MultipartFile multipartFile){
        try {
            return new ByteArrayResource(multipartFile.getBytes()) {
                @Override
                public String getFilename() {
                    return multipartFile.getOriginalFilename();
                }
            };
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

}
