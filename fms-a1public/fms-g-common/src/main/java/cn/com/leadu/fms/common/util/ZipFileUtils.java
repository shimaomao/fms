package cn.com.leadu.fms.common.util;

import cn.com.leadu.fms.common.vo.FileVo;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author qiaomengnan
 * @ClassName: ZipFileUtils
 * @Description: zip文件工具类
 * @date 2018/7/18
 */
@Slf4j
public class ZipFileUtils {

    /**
     * @Fields  : zip后缀
     * @author qiaomengnan
     */
    public static final String ZIP_SUFFIX = ".zip";

    /**
     * @Title: 将文件打包成一个zip
     * @Description:
     * @param files
     * @param outPath
     * @param zipFileName 文件名
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 11:17:42
     */
    public static String toZip(List<FileVo> files, String outPath, String zipFileName){
        if(ArrayUtils.isNotNullAndLengthNotZero(files) && StringUtils.isNotTrimBlank(outPath)){

            ZipOutputStream zipOut = null;
            FileInputStream inputStream = null;
            try {
                File outPathDir = new File(outPath);
                if(!outPathDir.exists())
                    outPathDir.mkdirs();
                String zipName = StringUtils.isTrimBlank(zipFileName) ? UUIDUtils.getUUID() : zipFileName; //自定义文件名
                String zipFilePath = CommonFileUtils.joinFilePath(outPath,zipName + ZIP_SUFFIX);
                File zipFile = new File(zipFilePath);
                if(!zipFile.exists())
                    zipFile.createNewFile();
                zipOut = new ZipOutputStream(new FileOutputStream(zipFilePath));
                Map<String,Integer> fileNamesMap = new HashMap<>();
                for(FileVo fileVo : files){
                    File file = new File(CommonFileUtils.setRootPath(fileVo.getFileCompletePath()));
                    if(file.exists()) {
                        byte[] buf = new byte[1024];
                        if(fileNamesMap.get(fileVo.getFileName()) == null) {
                            fileNamesMap.put(fileVo.getFileName(),0);
                            zipOut.putNextEntry(new ZipEntry(fileVo.getFileName()));
                        } else{
                            Integer res = fileNamesMap.get(fileVo.getFileName()) + 1;
                            fileNamesMap.put(fileVo.getFileName(),res);
                            String fileName = String.format("%s_%s%s",CommonFileUtils.getFileNameNoSuffix(fileVo.getFileName()),res,CommonFileUtils.getFileNameSuffix(fileVo.getFileName()));
                            zipOut.putNextEntry(new ZipEntry(fileName));
                        }
                        int len;
                        inputStream = new FileInputStream(file);
                        while ((len = inputStream.read(buf)) != -1) {
                            zipOut.write(buf, 0, len);
                        }
                        zipOut.closeEntry();
                        inputStream.close();
                    }
                }
                return zipFilePath;
            } catch (Exception ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
            } finally {
                try {
                    if(inputStream != null)
                        inputStream.close();
                    if(zipOut != null)
                        zipOut.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                }
            }
        }
        return null;
    }

}
