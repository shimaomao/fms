package cn.com.leadu.fms.webclient.file.controller;

import cn.com.leadu.fms.common.util.CommonFileUtils;
import cn.com.leadu.fms.extend.config.WebServiceNames;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.extend.rpc.FileUploadRpc;
import cn.com.leadu.fms.webclient.file.rpc.DemoUploadFileRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author qiaomengnan
 * @ClassName: DemoUploadFileController
 * @Description: 文件上传demo
 * @date 2018/3/23
 */
@RestController
@RequestMapping("demo_upload_file")
public class DemoUploadFileController {

    @Autowired
    private FileUploadRpc fileUploadRpc;

    /**
     * @Title:  
     * @Description:   单个文件上传
     * @param multipartFile
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/03/23 11:02:13
     */
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> uploadFile(@RequestParam("file") MultipartFile multipartFile){
        System.out.println(multipartFile);
        return null;
    }

    /**
     * @Title:
     * @Description:   多个文件上传
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/23 11:02:44
     */
    @RequestMapping(value = "uploadFiles",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> uploadFiles(@RequestParam("file") MultipartFile[] multipartFiles) throws IOException{
        //CommonFileUtils.writerRootPathUUIDName(multipartFiles);
        //fileUploadRpc.fileUpload(WebServiceNames.utils.getFmsAgentUrl(DemoUploadFileRpc.uploadFilesUrl),"file",multipartFiles);
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(CommonFileUtils.writerRootPathUUIDNameReturnFileCompletePath(multipartFiles)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   删除文件
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 04:59:13
     */
    @RequestMapping(value = "deleteFile",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> deleteFile(){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(),
                HttpStatus.OK);
    }




}
