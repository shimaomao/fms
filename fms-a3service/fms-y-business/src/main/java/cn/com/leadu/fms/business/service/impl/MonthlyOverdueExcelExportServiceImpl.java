package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.service.MonthlyOverdueExcelExportService;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.ExcelUtils;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverduesVo;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@Slf4j
public class MonthlyOverdueExcelExportServiceImpl implements MonthlyOverdueExcelExportService {

    /**
     * 按照指定模板导出测试
     * @param sysTplType 模板实体类
     * @param out
     * @throws Exception
     */
    public void monthlyOverdueExport(SysTplType sysTplType, List<MonthlyOverduesVo> vos, OutputStream out) throws Exception {
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
        if(ArrayUtils.isNullOrLengthZero(vos)){
            try {
                wb.write(out);
            } catch (IOException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                log.error("导出excel中error",ex);
            }
        } else {
            //拿到第一个sheet
            XSSFSheet source1 = wb.getSheetAt(0);
            int nowRowNum1 = 2; //由于模板中循环是从第3行开始的，这里index设定为2
            //根据模板给需要设值的单元格设值
            for (int i = 0; i < vos.size(); i++) {
                Row row = source1.createRow(nowRowNum1 + i); // 创建行
                //设定此行的单元格
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 0, wb), vos.get(i).getCensusMonth(), wb);//月份
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 1, wb), vos.get(i).getRetailOverdue(), wb);//零售逾期
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 2, wb), vos.get(i).getParOverdue(), wb);//经销商逾期
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 3, wb), vos.get(i).getTotalOverdue(), wb);//总逾期
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 4, wb), vos.get(i).getRetailAmount(), wb);//零售总应收
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 5, wb), vos.get(i).getParAmount(), wb);//经销商总应收
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 6, wb), vos.get(i).getTotalAmount(), wb);////总应收
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 7, wb), vos.get(i).getRetailOverdueRate(), wb);//零售逾期率
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 8, wb), vos.get(i).getParOverdueRate(), wb);//经销商逾期率
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row, 9, wb), vos.get(i).getTotalOverdueRate(), wb);//总逾期率
            }

            //拿到第二个sheet
            XSSFSheet source2 = wb.getSheetAt(1);
            int nowRowNum2 = 1; //由于模板中循环是从第2行开始的，这里index设定为2
            //根据模板给需要设值的单元格设值
            for (int i = 0; i / 8 < vos.size(); i = i + 8) {
                source2.addMergedRegion(new CellRangeAddress(nowRowNum2 + i, nowRowNum2 + i + 7, 0, 0));//合并单元格（起始行，结束行，起始列，结束列）
                Row row1 = source2.createRow(nowRowNum2 + i); // 创建行
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row1, 0, wb), vos.get(i / 8).getCensusMonth(), wb);//月份
                ExcelUtils.createNewCell(row1, 1, wb).setCellValue("零售逾期（元）");
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row1, 2, wb), vos.get(i / 8).getRetailOverdue1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row1, 3, wb), vos.get(i / 8).getRetailOverdue2(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row1, 4, wb), vos.get(i / 8).getRetailOverdue3(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row1, 5, wb), vos.get(i / 8).getRetailOverdue4(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row1, 6, wb), vos.get(i / 8).getRetailOverdue5(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row1, 7, wb), vos.get(i / 8).getRetailOverdue6(), wb);
                Row row2 = source2.createRow(nowRowNum2 + i + 1); // 创建行
                ExcelUtils.createNewCell(row2, 0, wb).setCellValue("");//解决合并单元格后无边框问题
                ExcelUtils.createNewCell(row2, 1, wb).setCellValue("经销商逾期（元）");
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row2, 2, wb), vos.get(i / 8).getParOverdue1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row2, 3, wb), vos.get(i / 8).getParOverdue2(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row2, 4, wb), vos.get(i / 8).getParOverdue3(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row2, 5, wb), vos.get(i / 8).getParOverdue4(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row2, 6, wb), vos.get(i / 8).getParOverdue5(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row2, 7, wb), vos.get(i / 8).getParOverdue6(), wb);
                Row row3 = source2.createRow(nowRowNum2 + i + 2); // 创建行
                ExcelUtils.createNewCell(row3, 0, wb).setCellValue("");
                ExcelUtils.createNewCell(row3, 1, wb).setCellValue("零售逾期占比（%）");
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row3, 2, wb), vos.get(i / 8).getRetailOverdueRatio1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row3, 3, wb), vos.get(i / 8).getRetailOverdueRatio2(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row3, 4, wb), vos.get(i / 8).getRetailOverdueRatio3(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row3, 5, wb), vos.get(i / 8).getRetailOverdueRatio4(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row3, 6, wb), vos.get(i / 8).getRetailOverdueRatio5(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row3, 7, wb), vos.get(i / 8).getRetailOverdueRatio6(), wb);
                Row row4 = source2.createRow(nowRowNum2 + i + 3); // 创建行
                ExcelUtils.createNewCell(row4, 0, wb).setCellValue("");
                ExcelUtils.createNewCell(row4, 1, wb).setCellValue("零售逾期率（%）");
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row4, 2, wb), vos.get(i / 8).getRetailOverdueRate1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row4, 3, wb), vos.get(i / 8).getRetailOverdueRate2(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row4, 4, wb), vos.get(i / 8).getRetailOverdueRate3(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row4, 5, wb), vos.get(i / 8).getRetailOverdueRate4(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row4, 6, wb), vos.get(i / 8).getRetailOverdueRate5(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row4, 7, wb), vos.get(i / 8).getRetailOverdueRate6(), wb);
                Row row5 = source2.createRow(nowRowNum2 + i + 4); // 创建行
                ExcelUtils.createNewCell(row5, 0, wb).setCellValue("");
                ExcelUtils.createNewCell(row5, 1, wb).setCellValue("经销商逾期占比（%）");
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5, 2, wb), vos.get(i / 8).getParOverdueRatio1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5, 3, wb), vos.get(i / 8).getParOverdueRatio2(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5, 4, wb), vos.get(i / 8).getParOverdueRatio3(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5, 5, wb), vos.get(i / 8).getParOverdueRatio4(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5, 6, wb), vos.get(i / 8).getParOverdueRatio5(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row5, 7, wb), vos.get(i / 8).getParOverdueRatio6(), wb);
                Row row6 = source2.createRow(nowRowNum2 + i + 5); // 创建行
                ExcelUtils.createNewCell(row6, 0, wb).setCellValue("");
                ExcelUtils.createNewCell(row6, 1, wb).setCellValue("经销商逾期率（%）");
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6, 2, wb), vos.get(i / 8).getParOverdueRate1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6, 3, wb), vos.get(i / 8).getParOverdueRate2(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6, 4, wb), vos.get(i / 8).getParOverdueRate3(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6, 5, wb), vos.get(i / 8).getParOverdueRate4(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6, 6, wb), vos.get(i / 8).getParOverdueRate5(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row6, 7, wb), vos.get(i / 8).getParOverdueRate6(), wb);
                Row row7 = source2.createRow(nowRowNum2 + i + 6); // 创建行
                ExcelUtils.createNewCell(row7, 0, wb).setCellValue("");
                ExcelUtils.createNewCell(row7, 1, wb).setCellValue("总逾期占比（%）");
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row7, 2, wb), vos.get(i / 8).getOverdue1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row7, 3, wb), vos.get(i / 8).getOverdue2(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row7, 4, wb), vos.get(i / 8).getOverdue3(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row7, 5, wb), vos.get(i / 8).getOverdue4(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row7, 6, wb), vos.get(i / 8).getOverdue5(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row7, 7, wb), vos.get(i / 8).getOverdue6(), wb);
                Row row8 = source2.createRow(nowRowNum2 + i + 7); // 创建行
                ExcelUtils.createNewCell(row8, 0, wb).setCellValue("");
                ExcelUtils.createNewCell(row8, 1, wb).setCellValue("总逾期率（%）");
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row8, 2, wb), vos.get(i / 8).getTotalOverdueRate1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row8, 3, wb), vos.get(i / 8).getTotalOverdueRate2(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row8, 4, wb), vos.get(i / 8).getTotalOverdueRate3(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row8, 5, wb), vos.get(i / 8).getTotalOverdueRate4(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row8, 6, wb), vos.get(i / 8).getTotalOverdueRate5(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row8, 7, wb), vos.get(i / 8).getTotalOverdueRate6(), wb);
            }
            try {
                wb.write(out);
            } catch (IOException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                log.error("导出excel中error", ex);
            }
        }
    }
}
