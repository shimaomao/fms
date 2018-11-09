package cn.com.leadu.fms.webclient.file.controller;

import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.extend.config.WebServiceNames;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.extend.rpc.FileUploadRpc;
import cn.com.leadu.fms.webclient.file.rpc.FileRpc;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: FileDownloadController
 * @Description: 文件相关接口
 * @date 2018/4/2
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileRpc fileRpc;

    @Autowired
    private FileUploadRpc fileUploadRpc;

    /**
     * @Title:
     * @Description:   上传文件
     * @param files
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/02 10:39:52
     */
    @RequestMapping(value = "uploadFiles" , method = RequestMethod.POST)
    public ResponseEntity<RestResponse> uploadFiles(@RequestParam("files") MultipartFile[] files,
                                                    @RequestParam(value = "fileTypePath",required = false) String fileTypePath,
                                                    @RequestParam(value = "secondPath",required = false) String secondPath){
        Map<String,Object> params = new HashMap<>();
        if(StringUtils.isExits(fileTypePath))
            params.put("fileTypePath",fileTypePath);
        if(StringUtils.isExits(secondPath))
            params.put("secondPath",secondPath);
        return fileUploadRpc.fileUpload(WebServiceNames.getFmsAgentUrl(FileRpc.uploadFilesUrl),"files",params,files);
    }

    /**
     * @Title:
     * @Description:   根据文件路径下载文件
     * @param fileCompletePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/02 05:17:44
     */
    @RequestMapping(value = "downloadFile" , method = RequestMethod.GET)
    public ResponseEntity downloadFile(String fileCompletePath,String fileName) throws IOException {
        Response response = fileRpc.downloadFile(fileCompletePath,fileName);
        return CommonFeignUtils.getResponseEntity(response,MediaType.APPLICATION_OCTET_STREAM);
    }

    /**
     * @Title:
     * @Description: 虚拟接口,给前端控件模拟删除使用
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/9 0009 16:45
     */
    @RequestMapping(value = "deleteFile" , method = RequestMethod.POST)
    public ResponseEntity<RestResponse> deleteFiles(){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   将文件集合打包成一个zip
     * @param files
     * @param zipFileName 压缩包名称
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 11:50:24
     */
    @RequestMapping(value = "filesToZip" , method = RequestMethod.POST)
    public ResponseEntity<RestResponse> filesToZip(@RequestBody List<FileVo> files, String zipFileName){
        return fileRpc.filesToZip(files, zipFileName);
    }

}
