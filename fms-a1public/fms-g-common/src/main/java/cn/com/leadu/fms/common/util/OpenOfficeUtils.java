package cn.com.leadu.fms.common.util;

import cn.com.leadu.fms.common.config.WebOpenOfficeServers;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

import java.io.File;

/**
 * @author qiaomengnan
 * @ClassName: OpenOfficeUtils
 * @Description:
 * @date 2018/3/30
 */
public class OpenOfficeUtils {

    /**
     * @Title:
     * @Description:   连接openOffice打印PDF
     * @param filePath
     * @param outPath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/02 01:48:47
     */
    public static void outPdf(String filePath,String outPath) throws Exception{
        DocumentConverter converter = new StreamOpenOfficeDocumentConverter(
                WebOpenOfficeServers.getOpenOfficeConnection());
        converter.convert(new File(filePath), new File(outPath));
    }

}
