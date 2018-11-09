package cn.com.leadu.fms.file.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author qiaomengnan
 * @ClassName: DemoUploadFileController
 * @Description: 文件上传demo
 * @date 2018/3/23
 */
@RestController
@RequestMapping("demo_upload_file")
public class DemoUploadFileController {

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
    public ResponseEntity<RestResponse> uploadFiles(@RequestParam("file") MultipartFile[] multipartFiles, @AuthUserInfo SysUser sysUser){
        System.out.println(multipartFiles.length);
        return null;
    }

}
