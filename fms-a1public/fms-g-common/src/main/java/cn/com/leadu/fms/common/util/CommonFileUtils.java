package cn.com.leadu.fms.common.util;

import cn.com.leadu.fms.common.config.WebFilePaths;
import cn.com.leadu.fms.common.constant.enums.file.FileTypeEnums;
import cn.com.leadu.fms.common.constant.enums.file.FileTypePathEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.vo.FileVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by qiaohao on 2017/9/14.
 */
@Slf4j
public class CommonFileUtils {

    public static final String SLANT_LINE = "/";


    /**
     * @Title:
     * @Description: 获取文件根路径 区分系统
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  18:25
     */
    public static String getRootPath(){
        return WebFilePaths.getRootPath();
    }

    /**
     * @Title:
     * @Description: 获取文件根路径 不区分系统
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/9 0009 10:53
     */
    public static String getFileRootPath(){
        return WebFilePaths.fileRootPath();
    }

    /**
     * @Title:
     * @Description:   返回文件类型完整路径
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 06:37:24
     */
    public static String getRootPath(String filePath){
        return joinFilePath(WebFilePaths.getRootPath() , filePath) ;
    }

    /**
     * @Title:
     * @Description:   返回文件类型完整路径
     * @param fileTypeEnums
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 06:37:24
     */
    public static String getRootPath(FileTypeEnums fileTypeEnums){
        return joinFilePath(WebFilePaths.getRootPath() , fileTypeEnums.getFilePath()) ;
    }

    /**
     * @Title:
     * @Description:   返回文件类型完整路径加文件名称
     * @param fileTypeEnums
     * @param fileName
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 06:37:39
     */
    public static String getRootPath(FileTypeEnums fileTypeEnums,String fileName){
        String res = joinFilePath(WebFilePaths.getRootPath() , fileTypeEnums.getFilePath()) ;
        return joinFilePath(res,fileName);
    }

    /**
     * @Title:
     * @Description: 设置文件根路径，如果是windows加上盘符，否则不加
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/16  18:25
     */
    public static String setRootPath(String filePath){
        if(SystemUtils.isWindows() && !filePath.startsWith(WebFilePaths.windowsPartition))
            return WebFilePaths.windowsPartition + filePath;
        else
            return filePath;
    }

    /**
     * 按行读取项目中文件，并且换行
     * @return
     */
    public static String readLineFileln(String filePath,Class clazz) throws Exception{
        InputStream inputStream = clazz.getResourceAsStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String lineTxt = null;
        StringBuffer result =new StringBuffer();
        while((lineTxt = bufferedReader.readLine()) != null){
            result.append(lineTxt+"\n");
        }
        return result.toString();
    }

    /**
     * 向指定目录输出指定文件
     * @param filePath
     * @param fileName
     * @param data
     */
    public static void outFile(String filePath,String fileName,String data){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            File file = new File(filePath);
            if(!file.isDirectory())
                file.mkdirs();
            file = new File(filePath+"/"+fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            }catch (Exception ex){
                log.error(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    /**
     * @Title:
     * @Description:   读取file文件并向输出流中写入
     * @param fileCompletePath
     * @param out
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 06:08:36
     */
    public static void writerFile(String fileCompletePath,OutputStream out) throws IOException{
        writerFile(new FileInputStream(new File(fileCompletePath)),out);
    }

    /**
     * @Title:
     * @Description:   将file文件流输出流中写入
     * @param inputStream
     * @param out
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 06:08:36
     */
    public static void writerFile(InputStream inputStream,OutputStream out) throws IOException{

        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte [] buff = new byte[1024];
            int i = bufferedInputStream.read(buff);
            while (i != -1){
                out.write(buff);
                out.flush();
                i = bufferedInputStream.read(buff);
            }
        } finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * @Title:
     * @Description:   读取文件写向response中
     * @param fileCompletePath
     * @param response
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/02 08:07:44
     */
    public static void writerFile(String fileCompletePath,String fileName, HttpServletResponse response) throws IOException {
        if(StringUtils.isTrimBlank(fileName))
            fileName = getFileName(fileCompletePath);
        else
            fileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        response.setHeader("content-type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        writerFile(setRootPath(fileCompletePath),response.getOutputStream());
    }

    /**
     * @Title:
     * @Description:   截取文件名
     * @param fileCompletePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/02 08:10:38
     */
    public static String getFileName(String fileCompletePath){
        if(StringUtils.isNotTrimBlank(fileCompletePath)){
            String [] results = fileCompletePath.split("/");
            if(ArrayUtils.isNotNullAndLengthNotZero(results)){
                return results[results.length - 1];
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   将文件保存到本地目录中，并以UUID命名
     * @param multipartFile
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:35:49
     */
    public static FileVo writerRootPathUUIDName(MultipartFile multipartFile) throws IOException{
        if(multipartFile != null) {
            String fileName = getUUIDName(multipartFile.getOriginalFilename());
            String fileSuffix = getFileSuffix(multipartFile.getOriginalFilename());
            //写入路径
            org.apache.commons.io.FileUtils.copyInputStreamToFile(multipartFile.getInputStream()
                    , new File(WebFilePaths.getRootPath(), fileName));
            return new FileVo(fileName, fileSuffix, WebFilePaths.fileRootPath(),multipartFile.getOriginalFilename());
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   将文件保存到本地目录中，并以UUID命名
     * @param multipartFile
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:35:49
     */
    public static FileVo writerRootPathUUIDName(MultipartFile multipartFile,String originalFilename) throws IOException{
        if(multipartFile != null) {
            String fileName = getUUIDName(originalFilename);
            String fileSuffix = getFileSuffix(originalFilename);
            //写入路径
            org.apache.commons.io.FileUtils.copyInputStreamToFile(multipartFile.getInputStream()
                    , new File(WebFilePaths.getRootPath(), fileName));
            return new FileVo(fileName, fileSuffix, WebFilePaths.fileRootPath(),originalFilename);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   将文件保存到本地目录中，并以UUID命名
     * @param multipartFile
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:35:49
     */
    public static FileVo writerRootPathUUIDName(MultipartFile multipartFile,String originalFilename,FileTypePathEnums fileTypePath,String secondPath) throws IOException{
        if(multipartFile != null) {
            //file文件路径枚举为空,流入默认方法
            if(fileTypePath == null)
                return writerRootPathUUIDName(multipartFile, originalFilename);
            else {
                String rootPath = WebFilePaths.getRootPath();
                //如果需要二级目录,但是二级目录为空则报错
                if(fileTypePath.getSecondPath() && StringUtils.isTrimBlank(secondPath))
                    throw new FmsServiceException("二次目录不能为空");
                //拼接一级目录
                rootPath = joinFilePath(rootPath,fileTypePath.getType());
                //如果需要日期,拼接日期
                if(fileTypePath.getDate())
                    rootPath = joinFilePath(rootPath,DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMd_NO));
                //二级目录满足,拼接
                if(fileTypePath.getSecondPath() && StringUtils.isNotTrimBlank(secondPath))
                    rootPath = joinFilePath(rootPath,secondPath);
                String fileName = getUUIDName(originalFilename);
                String fileSuffix = getFileSuffix(originalFilename);
                //写入路径
                org.apache.commons.io.FileUtils.copyInputStreamToFile(multipartFile.getInputStream()
                        , new File(rootPath, fileName));
                return new FileVo(fileName, fileSuffix, WebFilePaths.replaceWinPath(rootPath), originalFilename);
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   打包文件成zip并保存到本地目录中，并以UUID命名
     * @param files
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:35:49
     */
    public static String filesToZip(List<FileVo> files, String zipFileName){
        if(ArrayUtils.isNotNullAndLengthNotZero(files)) {
            String rootPath = joinFilePath(WebFilePaths.getRootPath(),FileTypePathEnums.DN_LOAD.getType(),DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMd_NO));
            return ZipFileUtils.toZip(files,rootPath,zipFileName);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   返回一个文件输出流
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/14 06:07:43
     */
    public static FileOutputStream getFileOutputStream(String filePath) throws FileNotFoundException {
        return new FileOutputStream(new File(filePath));
    }

    /**
     * @Title:
     * @Description:   将文件保存到本地目录中，并以UUID命名
     * @param multipartFile
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:35:49
     */
    public static String writerRootPathUUIDNameReturnFileCompletePath(MultipartFile multipartFile) throws IOException{
        if(multipartFile != null)
            return writerRootPathUUIDName(multipartFile).getFileCompletePath();
        return null;
    }


    /**
     * @Title:
     * @Description:  将文件保存到本地目录中，并以UUID命名
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:52:15
     */
    public static List<FileVo> writerRootPathUUIDName(List<MultipartFile> multipartFiles) throws IOException{
        if(ArrayUtils.isNotNullAndLengthNotZero(multipartFiles)) {
            List<FileVo> fileVos = new ArrayList<>();
            for (MultipartFile multipartFile : multipartFiles) {
                fileVos.add(writerRootPathUUIDName(multipartFile));
            }
            return fileVos;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:  将文件保存到本地目录中，并以UUID命名
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:52:15
     */
    public static List<FileVo> writerRootPathUUIDName(List<MultipartFile> multipartFiles,List<String> originalFilenames) throws IOException{
        if(ArrayUtils.isNotNullAndLengthNotZero(multipartFiles)) {
            List<FileVo> fileVos = new ArrayList<>();
            for(int i = 0 ; i < multipartFiles.size() ; i ++){
                fileVos.add(writerRootPathUUIDName(multipartFiles.get(i),originalFilenames.get(i)));
            }
            return fileVos;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:  将文件保存到本地目录中，并以UUID命名
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:52:15
     */
    public static List<FileVo> writerRootPathUUIDName(List<MultipartFile> multipartFiles,List<String> originalFilenames,FileTypePathEnums fileTypePath,String secondPath) throws IOException{
        if(ArrayUtils.isNotNullAndLengthNotZero(multipartFiles)) {
            List<FileVo> fileVos = new ArrayList<>();
            for(int i = 0 ; i < multipartFiles.size() ; i ++){
                fileVos.add(writerRootPathUUIDName(multipartFiles.get(i),originalFilenames.get(i),fileTypePath,secondPath));
            }
            return fileVos;
        }
        return null;
    }


    /**
     * @Title:
     * @Description:  将文件保存到本地目录中，并以UUID命名
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:52:15
     */
    public static List<String> writerRootPathUUIDNameReturnFileCompletePath(List<MultipartFile> multipartFiles) throws IOException{
        List<FileVo> fileVos = writerRootPathUUIDName(multipartFiles);
        if(ArrayUtils.isNotNullAndLengthNotZero(fileVos)){
            List<String> fileCompletePaths = new ArrayList<>();
            for(FileVo fileVo : fileVos){
                fileCompletePaths.add(fileVo.getFileCompletePath());
            }
            return fileCompletePaths;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:  将文件保存到本地目录中，并以UUID命名
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:52:15
     */
    public static List<String> writerRootPathUUIDNameReturnFileCompletePath(MultipartFile [] multipartFiles) throws IOException{
        return writerRootPathUUIDNameReturnFileCompletePath(ArrayUtils.asList(multipartFiles));
    }

    /**
     * @Title:
     * @Description:  将文件保存到本地目录中，并以UUID命名
     * @param multipartFiles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:52:15
     */
    public static List<FileVo> writerRootPathUUIDName(MultipartFile [] multipartFiles) throws IOException{
        if(ArrayUtils.isNotNullAndLengthNotZero(multipartFiles))
            return writerRootPathUUIDName(ArrayUtils.asList(multipartFiles));
        return null;
    }

    /**
     * @Title:
     * @Description:  将文件保存到本地目录中，并以UUID命名
     * @param multipartFiles 文件流集合
     * @param originalFilenames 文件名称集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:52:15
     */
    public static List<FileVo> writerRootPathUUIDName(MultipartFile [] multipartFiles,List<String> originalFilenames) throws IOException{
        if(ArrayUtils.isNotNullAndLengthNotZero(multipartFiles))
            return writerRootPathUUIDName(ArrayUtils.asList(multipartFiles),originalFilenames);
        return null;
    }

    /**
     * @Title:
     * @Description:   根据文件类型,写入文件
     * @param multipartFiles
     * @param originalFilenames
     * @param type
     * @param secondPath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/28 10:52:17
     */
    public static List<FileVo> writerRootPathUUIDName(MultipartFile [] multipartFiles
            ,List<String> originalFilenames
            ,String type
            ,String secondPath) throws IOException{
        //文件type不存在则流向默认的路径
        if(StringUtils.isTrimBlank(type))
           return writerRootPathUUIDName(multipartFiles, originalFilenames);
        else{
            FileTypePathEnums fileTypePathEnums = fileTypePathEnumsMap.get(type);
            if(fileTypePathEnums == null)
                throw new FmsServiceException("附件类型不存在");
            else{
                return writerRootPathUUIDName(ArrayUtils.asList(multipartFiles),originalFilenames,fileTypePathEnums,secondPath);
            }
        }
    }


    /**
     * @Title:
     * @Description:   将文件名切割，以UUID重命名后返回
     * @param originalFilename
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:53:35
     */
    public static String getUUIDName(String originalFilename){
        if(StringUtils.isNotTrimBlank(originalFilename))
            return UUIDUtils.getUUID() + getFileSuffix(originalFilename);
        return null;
    }

    /**
     * @Title:
     * @Description:   取出文件后缀
     * @param originalFilename
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 04:08:55
     */
    public static String getFileSuffix(String originalFilename){
        if(StringUtils.isNotTrimBlank(originalFilename))
            return originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
        return null;
    }

    /**
     * @Title:
     * @Description: 将文件路径拼装起来 ，并判断是否多加了 /
     * @param val1
     * @param val2
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/14 06:16:31
     */
    public static String joinFilePath(String val1,String val2){
        if(StringUtils.isNotTrimBlank(val1,val2)){
            if(val1.endsWith(SLANT_LINE) && !val2.startsWith(SLANT_LINE)){
                return val1 + val2;
            } else if(!val1.endsWith(SLANT_LINE) && val2.startsWith(SLANT_LINE)){
                return val1 + val2;
            } else if(!val1.endsWith(SLANT_LINE) && !val2.startsWith(SLANT_LINE)){
                return val1 + SLANT_LINE + val2;
            } else if(val1.endsWith(SLANT_LINE) && val2.startsWith(SLANT_LINE)){
                return val1 + val2.substring(1);
            } else{
                return null;
            }
        }
        return null;
    }


    /**
     * @Title:
     * @Description: 将文件路径拼装起来 ，并判断是否多加了 /
     * @param values
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/14 06:16:31
     */
    public static String joinFilePath(String ...values){
        String result = null;
        for(String value : values){
            if(result == null)
                result = value;
            else
                result = joinFilePath(result,value);
        }
        return result;
    }


    /**
     * @Title:
     * @Description: 写入数据到文件
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @param data  数据
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 08:21:17
     */
    public static void writeFile(String filePath,String fileName,String data){
        if(StringUtils.isNotTrimBlank(filePath,fileName,data)) {
            try {
                FileUtils.write(new File(setRootPath(filePath), fileName), data, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
                throw new FmsServiceException("写入文件失败");
            }
        }
    }

    /**
     * @Title:
     * @Description: 写入数据到文件,并根据文件路径，默认以当天时间为文件夹分割
     * @param data  数据
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 08:21:17
     */
    public static String writeTxtFile(FileTypePathEnums fileTypePathEnum,String data){
        if(fileTypePathEnum != null && StringUtils.isNotTrimBlank(data)) {
            try {
                String filePath = joinFilePath(getFileRootPath(),fileTypePathEnum.getType(),DateUtils.getNowDateStr(DateUtils.formatStr_yyyyMMd_NO));
                String fileName = TxtUtils.getTxtName(UUIDUtils.getUUID());
                FileUtils.write(new File(setRootPath(filePath), fileName), data, "UTF-8");
                return joinFilePath(filePath,fileName);
            } catch (IOException ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
                throw new FmsServiceException("写入文件失败");
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   获取文件的名称
     * @param fileName
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/25 03:08:28
     */
    public static String getFileNameNoSuffix(String fileName){
        if(StringUtils.isNotTrimBlank(fileName))
            return fileName.substring(0,fileName.lastIndexOf("."));
        return null;
    }

    /**
     * @Title:
     * @Description:   获取文件名称的后缀
     * @param fileName
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/25 03:09:03
     */
    public static String getFileNameSuffix(String fileName){
        if(StringUtils.isNotTrimBlank(fileName))
            return fileName.substring(fileName.lastIndexOf("."),fileName.length());
        return null;
    }

    /**
     * @Fields  : 初始化模板类型路径
     * @author qiaomengnan
     */
    private static final Map<String,FileTypePathEnums> fileTypePathEnumsMap = new HashMap<>();

    static {
        for(FileTypePathEnums fileTypePathEnums : FileTypePathEnums.values()){
            fileTypePathEnumsMap.put(fileTypePathEnums.getType(),fileTypePathEnums);
        }
    }


}
