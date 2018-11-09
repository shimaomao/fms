package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.service.MonthlyRentExcelExportService;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.ExcelUtils;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author qinmuqiao
 * @ClassName: MonthlyRentExcelExportServiceImpl
 * @Description: 导出月度到账率excel
 * @date 2018-03-26
 */

@Service
@Slf4j
public class MonthlyRentExcelExportServiceImpl implements MonthlyRentExcelExportService {

    /**
     * 按照指定模板导出测试
     * @param sysTplType 模板实体类
     * @param out
     * @throws Exception
     */
    public void monthlyRectExport(SysTplType sysTplType, MonthlyRent monthlyRent, OutputStream out) throws Exception {
        XSSFWorkbook wb = null; //初始化excel模板
        String model = sysTplType.getTplContent();
        try {
            //根据模板路径得到文件流
            File file = new File(model);
            InputStream input = new FileInputStream(file);

            if(input == null) {
                throw new RuntimeException("model excel file load error :/" + model + " , check model file is exists !");
            }
            //项目中的excel模板要求必须以.xlsx结尾，否则报错
            if(model.endsWith(".xlsx"))
                wb = new XSSFWorkbook(input);
            else
                throw new RuntimeException("model file format is not valid , this : " + model + " , eg:.xlsx or xls");
        } catch (IOException e) {

            throw new RuntimeException("model excel file load error :" + model);
        }

        //拿到第一个sheet
        XSSFSheet source =  wb.getSheetAt(0);

        Row row0 = source.getRow(0);
        Cell cell0 = row0.getCell(5);
        cell0.setCellValue("日期：" + monthlyRent.getCensusMonth());


        Row rowOne = source.getRow(1); //拿到需要设定数值的行
        //根据模板给需要设值的单元格设值
        String cloName = "截止" + monthlyRent.getCensusMonth().substring(4) + "月累计应收";
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(rowOne,0,wb),cloName, wb);


        String cloNameThree = "截止" + monthlyRent.getCensusMonth().substring(4) + "月累累计实收";
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(rowOne,3,wb),cloNameThree, wb);


        Row row5 = source.createRow(2);
        row5.setHeightInPoints(40);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5,0,wb),"其中：累计逾期", wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5,1,wb),BigDecimalUtils.getNotNullBigDecimal(monthlyRent.getOverdueRent()).toString(), wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5,2,wb),monthlyRent.getOverdueCount(), wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5,3,wb),"其中：累计逾期实收", wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5,4,wb),BigDecimalUtils.getNotNullBigDecimal(monthlyRent.getOverdueReceipt()).toString(), wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5,5,wb),monthlyRent.getOverdueReCount(), wb);


        Row row6 = source.createRow(3); //合计行创建
        row6.setHeightInPoints(40);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6,0,wb),monthlyRent.getCensusMonth().substring(4) + "月应收", wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6,1,wb),BigDecimalUtils.getNotNullBigDecimal(monthlyRent.getMonthRent()).toString(), wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6,2,wb),monthlyRent.getMonthCount(), wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6,3,wb),monthlyRent.getCensusMonth().substring(4) + "月实收", wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6,4,wb),BigDecimalUtils.getNotNullBigDecimal(monthlyRent.getReceiptAmount()).toString(), wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6,5,wb),monthlyRent.getReceiptCount(), wb);

        try {
            wb.write(out);
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            log.error("导出excel中error",ex);
        }
    }
}
