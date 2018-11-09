package cn.com.leadu.fms.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author qiaomengnan
 * @ClassName: ResponseUtils
 * @Description: response工具类
 * @date 2018/6/25
 */
public class ResponseUtils {

    public static void outExcel(HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment; filename=" + ExcelUtils.getExcelName(new String(new String(fileName.getBytes("gb2312"), "iso8859-1"))));
    }

}
