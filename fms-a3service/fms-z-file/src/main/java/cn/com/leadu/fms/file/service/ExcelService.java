package cn.com.leadu.fms.file.service;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ExcelService
 * @Description: excel统一导出service
 * @date 2018/1/31
 */
public interface ExcelService {

    /**
     * @Title:
     * @Description:  生成excel文件
     * @param params
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 03:06:04
     */
    void excelExport(Map<String,Object> params, HttpServletResponse httpServletResponse);

}
