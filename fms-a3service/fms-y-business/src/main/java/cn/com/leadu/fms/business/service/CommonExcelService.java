package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.common.annotation.ExcelTitle;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CommonExcelService
 * @Description: excel共通处理service
 * @date 2018/5/9
 */
public interface CommonExcelService {

    List saveImportExcelToData(String filePath, Class clazz);

    List importExcelToData(String filePath, Class clazz);

    String getExcelTitleName(Integer excelType,Class clazz);

    String getExcelTitleName(Integer excelType,Method method);

    String getExcelTitleName(Integer excelType,ExcelTitle excelTitle);

    void exportList(String title, List datas, Class clazz, OutputStream out, int excelType) throws Exception;

    void exportList(String title, Object data, Class clazz, OutputStream out, int excelType) throws Exception;

}
