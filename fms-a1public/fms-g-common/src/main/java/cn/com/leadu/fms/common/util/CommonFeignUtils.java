package cn.com.leadu.fms.common.util;

import cn.com.leadu.fms.common.exception.FmsServiceException;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonFeignUtils
 * @Description: feign共通封装处理
 * @date 2018/4/2
 */
@Slf4j
public class CommonFeignUtils {

    /**
     * @Title:
     * @Description:   通过feign返回的response封装返回ResponseEntity
     * @param response
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/02 09:22:19
     */
    public static ResponseEntity getResponseEntity(Response response) {
        try {
            Map<String, Collection<String>> headers = response.headers();
            HttpHeaders httpHeaders = new HttpHeaders();

            headers.forEach((key, values) -> {
                List<String> headerValues = new LinkedList<>();
                headerValues.addAll(values);
                httpHeaders.put(key, headerValues);
            });
            Response.Body body = response.body();
            InputStream inputStream = body.asInputStream();//HttpURLInputStream
            InputStreamResource resource = new InputStreamResource(inputStream);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .headers(httpHeaders)
                    .body(resource);
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("文件输出失败");
        }
    }


    /**
     * @Title:
     * @Description:   通过feign返回的response封装返回ResponseEntity
     * @param response
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/02 09:22:19
     */
    public static ResponseEntity getResponseEntity(Response response,MediaType contentType){
        try {
            Map<String, Collection<String>> headers = response.headers();
            HttpHeaders httpHeaders = new HttpHeaders();

            headers.forEach((key, values) -> {
                List<String> headerValues = new LinkedList<>();
                headerValues.addAll(values);
                httpHeaders.put(key, headerValues);
            });
            Response.Body body = response.body();
            InputStream inputStream = body.asInputStream();//HttpURLInputStream
            InputStreamResource resource = new InputStreamResource(inputStream);
            return ResponseEntity
                    .ok()
                    .contentType(contentType)
                    .headers(httpHeaders)
                    .body(resource);
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("文件输出失败");
        }
    }

}
