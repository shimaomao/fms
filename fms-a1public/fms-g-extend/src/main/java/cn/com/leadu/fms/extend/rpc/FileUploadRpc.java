package cn.com.leadu.fms.extend.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: FileUploadRpc
 * @Description: rpc传递文件
 * @date 2018/2/6
 */
public interface FileUploadRpc {

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
    ResponseEntity<RestResponse> fileUpload(String requestUrl, Map<String,Object> params);

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
    ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName, MultipartFile multipartFile);


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
    ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName, List<MultipartFile> multipartFiles);


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
    ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName, MultipartFile ...multipartFiles);

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
    ResponseEntity<RestResponse> fileUpload(String requestUrl, String fileName,Map<String,Object> params, MultipartFile ...multipartFiles);

}
