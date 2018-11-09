package cn.com.leadu.fms.common.config;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.SystemUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: WebFilePaths
 * @Description:
 * @date 2018/3/26
 */
@ConfigurationProperties(prefix = "fms.filePaths")
@Component
@Data
public class WebFilePaths {

    public static String windowsPartition  = "C:";

    private static WebFilePaths webFilePaths = null;

    public WebFilePaths(){
        webFilePaths = this;
    }

    private String fileRootPath;

    /**
     * @Title:
     * @Description:   返回当前系统根路径
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:37:08
     */
    public static String getRootPath(){
        if(SystemUtils.isWindows())
            return windowsPartition + webFilePaths.fileRootPath;
        else
            return webFilePaths.fileRootPath;
    }

    public static String fileRootPath(){
        return webFilePaths.getFileRootPath();
    }

    public static String replaceWinPath(String path){
        if(StringUtils.isNotTrimBlank(path))
            path = path.replace(windowsPartition,"");
        return path;
    }

}
