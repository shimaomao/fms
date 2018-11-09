package cn.com.leadu.fms.webclient.file.rpc;

import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.extend.response.RestResponse;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FileRpc
 * @Description:
 * @date 2018/4/2
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FileRpc {

    String uploadFilesUrl = "api/file/file/uploadFiles";


    @RequestMapping(value = "api/file/file/downloadFile" , method = RequestMethod.GET)
    Response downloadFile(@RequestParam("fileCompletePath") String fileCompletePath,@RequestParam("fileName") String fileName);

    /**
     * @Title:
     * @Description:   将文件集合打包成一个zip
     * @param files
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 11:50:24
     */
    @RequestMapping(value = "api/file/file/filesToZip" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> filesToZip(@RequestBody List<FileVo> files, @RequestParam("zipFileName") String zipFileName);

}
