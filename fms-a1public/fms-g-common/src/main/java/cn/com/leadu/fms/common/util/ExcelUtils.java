package cn.com.leadu.fms.common.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: FileInfoConstants
 * @Description: 文件信息常量
 * @date 2018/5/14
 */
public class ExcelUtils {

    /**
     * @Fields  : excel后缀名
     * @author qiaomengnan
     */
    public static final String EXCEL_SUFFIX_XLSX = ".xlsx";


    public static String getExcelName(){
        return CommonFileUtils.joinFilePath(UUIDUtils.getUUID() , EXCEL_SUFFIX_XLSX) ;
    }

    public static String getExcelCompletePath(){
        return CommonFileUtils.joinFilePath(CommonFileUtils.getRootPath() , getExcelName());
    }

    public static String getExcelCompletePath(String fileName){
        return CommonFileUtils.joinFilePath(CommonFileUtils.getRootPath() , fileName + EXCEL_SUFFIX_XLSX);
    }

    public static String getExcelName(String name){
        return name + EXCEL_SUFFIX_XLSX;
    }

    /**
     * 创建带有特殊式样的单元格，比如背景色、纵向文字、加粗等
     * @param row 行对象
     * @param i 单元格的index
     * @param wb 模板类
     * @return
     */
    public static Cell createNewCell(Row row , int i, XSSFWorkbook wb) {
        //初始化单元格格式,有边框
        XSSFCellStyle cellStyle = wb.createCellStyle();
        ExcelUtils.setCellStyle(cellStyle);
        Cell cell = row.createCell(i);
        cell.setCellStyle(cellStyle);
        return cell;
    }

    /**
     * 创建单元格(普通单元格，没有特殊样式比如背景色、纵向文字、加粗等)
     * @param row 行对象
     * @param i 单元格的index
     * @param cellStyleCommon 共通style
     * @return
     */
    public static Cell createNewCellCommon(Row row , int i, XSSFCellStyle cellStyleCommon) {
        Cell cell = row.createCell(i);
        cell.setCellStyle(cellStyleCommon);
        return cell;
    }

    /**
     * 创建带有边框并且有背景颜色的单元格
     * @param row 行对象
     * @param i 单元格的index
     * @param wb 模板类
     * @param index 背景颜色索引
     * @return
     */
    public static Cell createNewBackgroundCell(Row row , int i, XSSFWorkbook wb,short index) {
        //初始化单元格格式,有边框
        XSSFCellStyle cellStyle = wb.createCellStyle();
        ExcelUtils.setCellStyle(cellStyle);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND );
        cellStyle.setFillForegroundColor(index);
        Cell cell = row.createCell(i);
        cell.setCellStyle(cellStyle);
        return cell;
    }

    /**
     * 设定单元格边框
     * @param cellStyle 单元格样式
     */
    public static void setCellStyle(XSSFCellStyle cellStyle){
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中

    }

    /**
     * 给单元格设值共通
     * @param cell 单元格对象
     * @param value 单元格值
     * @param wb 模板类
     * @return
     */
    public static void setCellValue(Cell cell , Object value, XSSFWorkbook wb) {
        XSSFDataFormat df = wb.createDataFormat();
        if(value == null){
            cell.setCellValue("");
            cell.setCellType(Cell.CELL_TYPE_STRING);
        } else {
            if(value instanceof BigDecimal){
                CellStyle cellStyle = cell.getCellStyle();
                cellStyle.setDataFormat(df.getFormat(getFormater(value))); //小数点后保留两位，可以写
                cell.setCellStyle(cellStyle);
                cell.setCellValue(getDoubleValueFromObj(value));
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            } else {
                cell.setCellValue(value.toString());
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
        }
    }

    /**
     * 金额数值千分位format:xx,xxx,xxx.xx
     * @param value
     * @return
     */
    private static String getFormater(Object value){
        String text = value.toString();
        if (text.indexOf(".") > 0) {
            if (text.length() - text.indexOf(".") - 1 == 0) {
                return "#,#0";
            } else if (text.length() - text.indexOf(".") - 1 == 1) {
                return "#,#0.0";
            } else {
                return "#,#0.00";
            }
        } else {
            return "#,#0";
        }
    }

    private static double getDoubleValueFromObj(Object obj){
        try {
            return Double.parseDouble(obj.toString());
        }catch (Exception e){
            return 0;
        }
    }

}
