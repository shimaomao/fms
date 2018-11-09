package cn.com.leadu.fms.file.controller;

import cn.com.leadu.fms.common.util.CommonFileUtils;
import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FileDownloadController
 * @Description: 文件相关接口
 * @date 2018/4/2
 */
@RestController
@RequestMapping("file")
public class FileController {

    /**
     * @Title:
     * @Description:  上传文件
     * @param files 文件流
     * @param originalFilenames 文件真实名称
     * @param fileTypePath 文件类型
     * @param secondPath 二级目录
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/02 10:36:15
     */
    @RequestMapping(value = "uploadFiles" , method = RequestMethod.POST)
    public ResponseEntity<RestResponse> uploadFiles(@RequestParam("files") MultipartFile[] files,
                                                    @RequestParam("originalFilenames") List<String> originalFilenames,
                                                    @RequestParam(value = "fileTypePath",required = false) String fileTypePath,
                                                    @RequestParam(value = "secondPath",required = false) String secondPath) throws IOException{
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(CommonFileUtils.writerRootPathUUIDName(files,originalFilenames,fileTypePath,secondPath)),
                HttpStatus.OK);
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
    public void downloadFile(String fileCompletePath,String fileName, HttpServletResponse response) throws IOException {
        CommonFileUtils.writerFile(fileCompletePath,fileName,response);
    }

    /**
     * @Title:
     * @Description:   将文件集合打包成一个zip
     * @param files
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 11:50:24
     */
    @RequestMapping(value = "filesToZip" , method = RequestMethod.POST)
    public ResponseEntity<RestResponse> filesToZip(@RequestBody List<FileVo> files, String zipFileName){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(
                        CommonFileUtils.filesToZip(files,zipFileName)
                ),HttpStatus.OK);
    }

}
