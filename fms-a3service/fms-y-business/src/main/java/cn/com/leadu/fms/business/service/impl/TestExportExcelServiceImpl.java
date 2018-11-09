package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.service.TestExportExcelService;
import cn.com.leadu.fms.common.util.ExcelUtils;
import cn.com.leadu.fms.pojo.prebiz.vo.testexcel.DataList;
import cn.com.leadu.fms.pojo.prebiz.vo.testexcel.TestData;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CommonExcelServiceImpl
 * @Description:
 * @date 2018/5/9
 */
@Service
@Slf4j
public class TestExportExcelServiceImpl implements TestExportExcelService {


    /**
     * 按照指定模板导出测试
     * @param sysTplType 模板实体类
     * @param testData 填充模板的数据
     * @param out
     * @throws Exception
     */
    public void export(SysTplType sysTplType, TestData testData, OutputStream out) throws Exception {
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
                throw new RuntimeException("model file format is not valid , this : " + model + " , eg:.xlsx");
        } catch (IOException e) {

            throw new RuntimeException("model excel file load error :" + model);
        }

        //拿到第一个sheet
        XSSFSheet source =  wb.getSheetAt(0);
        Row rowOne = source.getRow(1); //拿到需要设定数值的行
        //根据模板给需要设值的单元格设值
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(rowOne,1,wb),testData.getName(), wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(rowOne,3,wb),new BigDecimal("2345555.56"), wb);
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(rowOne,5,wb),new BigDecimal("122345555.8"), wb);
        int nowRowNum = 4; //由于测试模板中循环是从第5行开始的，这里index设定为4
        BigDecimal sum = BigDecimal.ZERO; //总计
        List<DataList> list = testData.getList();
        for(int i = 0 ; i < list.size()  ; i++) {
            Row row = source.createRow(nowRowNum+i); // 创建行
            //设定此行的单元格
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,1,wb),list.get(i).getAmount(), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,2,wb),list.get(i).getDateStr(), wb);
            sum = sum.add(list.get(i).getAmount()); //总计累加
        }
        Row row = source.createRow(nowRowNum+list.size()); //合计行创建
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,1,wb),sum, wb); //合计值set

        try {
            wb.write(out);
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            log.error("导出excel中error",ex);
        }
    }


}
