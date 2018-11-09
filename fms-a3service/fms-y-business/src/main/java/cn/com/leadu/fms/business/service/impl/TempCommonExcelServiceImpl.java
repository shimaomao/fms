package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.rpc.baseinfo.BasAreaRpc;
import cn.com.leadu.fms.business.rpc.system.SysCodeRpc;
import cn.com.leadu.fms.business.service.TempCommonExcelService;
import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.common.vo.CommonCodeVo;
import cn.com.leadu.fms.common.vo.ExcelVo;
import cn.com.leadu.fms.data.base.repository.JdbcTemplateRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaTreeVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author qiaomengnan
 * @ClassName: CommonExcelServiceImpl
 * @Description:
 * @date 2018/5/9
 */
@Service
@Slf4j
public class TempCommonExcelServiceImpl implements TempCommonExcelService {

    @Autowired
    private JdbcTemplateRepository jdbcTemplateRepository;

    @Autowired
    private SysCodeRpc sysCodeRpc;

    @Autowired
    private BasAreaRpc basAreaRpc;


    @Transactional
    public List saveImportExcelToData(String filePath, Class clazz){
        List results = importExcelToData(filePath,clazz);
        jdbcTemplateRepository.insertList(results);
        return results;
    }

    public List importExcelToData(String filePath, Class clazz){

        try {
            List<Object> entityList = new ArrayList<>();

            //获取当前类需要导入的字段标识
            Field[] fields = clazz.getDeclaredFields();

            //保存文件的头部以及对应的属性变量
            Map<String,Field> rowHeaders =new HashMap<>();
            Map<String,Method> rowHeaderMethods = new HashMap<>();
            List<String> fieldRowNames = new ArrayList<>();

            for (Field field : fields) {
                if (field.isAnnotationPresent(ExcelImportTitle.class)) {
                    if(StringUtils.isNotTrimBlank(field.getAnnotation(ExcelImportTitle.class).value())) {
                        field.setAccessible(true);
                        String fieldName = field.getName();
                        String value = field.getAnnotation(ExcelImportTitle.class).value().trim();
                        rowHeaders.put(value, field);
                        rowHeaderMethods.put(value,clazz.getMethod("set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1),field.getType()));
                        fieldRowNames.add(value);

                    }
                }
            }


            InputStream inputStream = new FileInputStream(new File(CommonFileUtils.setRootPath(filePath)));
            //读取excel文件
            Workbook workbook = WorkbookFactory.create(inputStream);

            for(int numSheet = 0 ; numSheet < workbook.getNumberOfSheets(); numSheet ++){
                Sheet sheet = workbook.getSheetAt(numSheet);
                if(sheet == null)
                    continue;

                if(sheet.getFirstRowNum() == sheet.getLastRowNum())
                    continue;

                //拿到第一列
                Row firstRow = sheet.getRow(sheet.getFirstRowNum());
                if(firstRow == null)
                    continue;

                //保存头文件对应的列下标
                Map<Integer,String> rowHeadersIndex =new HashMap<>();
                List<String> columnRowNames = new ArrayList<>();
                for(int columnNum = 0 ; columnNum < firstRow.getLastCellNum() ; columnNum ++){
                    Cell cell = firstRow.getCell(columnNum);
                    if(cell != null && StringUtils.isNotTrimBlank(cell.getStringCellValue())) {
                        rowHeadersIndex.put(columnNum,cell.getStringCellValue().trim());
                        columnRowNames.add(cell.getStringCellValue().trim());
                    }
                }


                //检测实体中的列和excel中的列是否一致
                if(fieldRowNames.size() != columnRowNames.size())
                    throw new FmsServiceException("导入的列值不对应");

                for(String rowName : fieldRowNames){
                    if(!columnRowNames.contains(rowName))
                        throw new FmsServiceException("导入的列值不对应," + rowName);
                }


                for(int rowNum = sheet.getFirstRowNum() + 1; rowNum <= sheet.getLastRowNum(); rowNum++){
                    Row row = sheet.getRow(rowNum);
                    if(row == null)
                        continue;

                    //每行都是一个对象
                    Object obj = clazz.newInstance();
                    //是否每个值都是空
                    boolean emptyResult = true;
                    for(int columnNum = 0 ; columnNum <= row.getLastCellNum() ; columnNum ++){
                        String value = null;
                        Cell cell = row.getCell(columnNum);
                        //cell.getValue
                        if(cell != null) {
                            if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && (HSSFDateUtil.isCellDateFormatted(cell) ||
                                    cell.getCellStyle().getDataFormatString().contains("年"))){
                                //如果是时间格式
                                Date date = cell.getDateCellValue();
                                value = DateUtils.dateToStr(date,DateUtils.formatStr_yyyyMMdd);
                            }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && cell.getCellStyle().getDataFormatString().contains("%")){
//                                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                DecimalFormat df = new DecimalFormat("0.######");
                                value = df.format(cell.getNumericCellValue());
                            }else {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                value = cell.getStringCellValue().trim();
                            }

                        }
                        String rowName = rowHeadersIndex.get(columnNum);
                        if(StringUtils.isNotTrimBlank(rowName)) {
                            Field field = rowHeaders.get(rowName);
                            Method method = rowHeaderMethods.get(rowName);
                            method.invoke(obj, getValue(field, value));
                            if(StringUtils.isNotTrimBlank(value))
                                emptyResult = false;
                        }
                    }
                    //false说明是有值不为空的,一行的值全部为空,则直接过滤
                    if(!emptyResult)
                        entityList.add(obj);
                }

            }
            return entityList;
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("导入excel数据失败");
        }

    }


    private Object getValue(Field field,String cellValue){
        try {
            if(StringUtils.isTrimBlank(cellValue))
//                return null;
return "";
            if (field.getType() == Integer.class)
                return Integer.valueOf(cellValue);
            else if (field.getType() == Double.class)
                return Double.valueOf(cellValue);
            else if (field.getType() == Float.class)
                return Float.valueOf(cellValue);
            else if (field.getType() == BigDecimal.class)
                return new BigDecimal(cellValue);
            else if (field.getType() == Date.class) {
                if(StringUtils.isTrimBlank(cellValue))
                    return null;
                String [] dateFormats = field.getAnnotation(ExcelImportTitle.class).dateFormats();
                Date result = null;
                for(String dateFormat : dateFormats){
                    try {
                        result = DateUtils.strToDate(cellValue, dateFormat);
                        break;
                    }catch (Exception ex){
                        log.error(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                if(result == null)
                    throw new FmsServiceException("日期转换失败");
                return result;
            }
            else if (field.getType() == String.class)
                return cellValue;
            else
                throw new FmsServiceException(field.getDeclaringClass() + "值类型还未定义");
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("值转换失败");
        }
    }


    public void exportList(String title, Object data, Class clazz, OutputStream out, int excelType) throws Exception {
        List datas = new ArrayList();
        datas.add(data);
        exportList(title,datas,clazz,out,excelType);
    }

    public void exportList(String title, List datas, Class clazz, OutputStream out, int excelType) throws Exception {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet(title);
        sheet.setDefaultColumnWidth(10);

        Method[] methods= clazz.getDeclaredMethods();
        List<Method> getterMethods=new ArrayList<Method>();
        List<ExcelVo> excelDtos = new ArrayList<>();
        //是否有数据字典的值
        boolean isCommonCodeValue = false;
        //是否有省市的值
        boolean isBasAreaValue = false;
        for(Method method:methods){
            //必须是get方法以及包含ExcelTitle注解
            if(method.isAnnotationPresent(ExcelTitle.class) && method.getName().contains("get") ) {
                int [] types = method.getAnnotation(ExcelTitle.class).types();
                //必须是本次类型包含 或者 默认全部导出的情况下
                if(IntegerUtils.isNullOrLengthZero(types) || IntegerUtils.containValue(types,excelType)) {
                    getterMethods.add(method);
                    ExcelVo ExcelVo = new ExcelVo();
                    ExcelVo.setMethod(method);
                    ExcelVo.setSort(method.getAnnotation(ExcelTitle.class).sort());
                    excelDtos.add(ExcelVo);
                    if (StringUtils.isNotTrimBlank(method.getAnnotation(ExcelTitle.class).codeType()))
                        isCommonCodeValue = true;
                    if (StringUtils.isNotTrimBlank(method.getAnnotation(ExcelTitle.class).areaType()))
                        isBasAreaValue = true;
                }
            }
        }

        Collections.sort(excelDtos, new Comparator<ExcelVo>() {
            @Override
            public int compare(ExcelVo o1, ExcelVo o2) {
                if(o1.getSort() > o2.getSort())
                    return 1;
                else
                    return -1;
            }
        });

        int index = 0;
        XSSFRow row=sheet.createRow(index);
        for(int i=0;i<excelDtos.size();i++){
            XSSFCell cell=row.createCell(i);
            //设置列名
            XSSFRichTextString text=new XSSFRichTextString(getExcelTitleName(excelType, excelDtos.get(i).getMethod()));
            cell.setCellValue(text);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        }

        //数据不为空则进行下一步读取值得操作
        if(ArrayUtils.isNotNullAndLengthNotZero(datas)){

            Map<String,CommonCodeVo> commonCodeVos = null;
            if(isCommonCodeValue)
                commonCodeVos = ResponseEntityUtils.getRestResponseData(sysCodeRpc.findCommonCodeValues());

            Map<String,BasAreaTreeVo> basAreaTreeVos = null;
            if(isBasAreaValue)
                basAreaTreeVos = ResponseEntityUtils.getRestResponseData(basAreaRpc.findBasAreaByTree());

            //设置数据
            for(Object obj:datas){
                index++;
                row=sheet.createRow(index);
                for(int i=0;i<excelDtos.size();i++){
                    XSSFCell cellData =row.createCell(i);
                    XSSFRichTextString textData = null;
                    //String value=new String(getterMethods.get(i).invoke(obj, null) +"");
                    //获取值
                    String value=new String(excelDtos.get(i).getMethod().invoke(obj, null) +"");
                    //值转换
                    value = getValue(value,excelDtos.get(i).getMethod().getAnnotation(ExcelTitle.class),commonCodeVos,basAreaTreeVos);
                    if(value != null && !value.equals("null")){
                        textData=new XSSFRichTextString(value);
                    }else{
                        textData=new XSSFRichTextString(" ");
                    }
                    cellData.setCellValue(textData);
                    cellData.setCellType(HSSFCell.CELL_TYPE_STRING);
                }
            }
        }

        try {
            workbook.write(out);
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            log.error("导出excel中error",ex);
        }
    }

    private String getValue(String value,ExcelTitle excelTitle,Map<String,CommonCodeVo> commonCodeVos,Map<String,BasAreaTreeVo> basAreaTreeVos){
        String codeType = excelTitle.codeType();
        String joinDelimiter = excelTitle.joinDelimiter();
        //单个值转换数据字典
        if(StringUtils.isNotTrimBlank(codeType,value) && StringUtils.isTrimBlank(joinDelimiter)){
            value = getCodeValueName(commonCodeVos,codeType,value);
        }
        //值转换数据字典列表
        if(StringUtils.isNotTrimBlank(codeType,value,joinDelimiter)){
            String [] values = StringUtils.split(joinDelimiter,value);
            if(ArrayUtils.isNotNullAndLengthNotZero(values)){
                StringBuffer results = new StringBuffer();
                for(String valueTmp : values) {
                    results.append(getCodeValueName(commonCodeVos, codeType, valueTmp));
                    results.append(joinDelimiter);
                }
                results = results.deleteCharAt(results.length() - 1);
                value = results.toString();
            }
        }
        //如果是省市
        if(StringUtils.isNotTrimBlank(excelTitle.areaType()) && CommonAreaConstants.BAS_AREA_VALUE.equals(excelTitle.areaType()))
            value = getAreaName(basAreaTreeVos,value);
        return value;
    }

    private String getCodeValueName(Map<String,CommonCodeVo> commonCodeVos,String codeType,String value){
        if(commonCodeVos != null) {
            CommonCodeVo commonCodeVo = commonCodeVos.get(StringUtils.joinDelimiter(StringUtils.LINE, codeType,value));
            if(commonCodeVo != null)
                return commonCodeVo.getCodeValueName();
        }
        return null;
    }

    private String getAreaName(Map<String,BasAreaTreeVo> basAreaTreeVos,String value){
        if(basAreaTreeVos != null){
            BasAreaTreeVo basAreaTreeVo = basAreaTreeVos.get(CommonAreaConstants.PROVINCE);
            if(basAreaTreeVo != null) {
                if(basAreaTreeVo.getAreaMap() != null)
                    return basAreaTreeVo.getAreaMap().get(value);
            }
        }
        return value;
    }

    public String getExcelTitleName(Integer excelType,Class clazz){
        String name = null;
        if(clazz.isAnnotationPresent(ExcelTitle.class)) {
            ExcelTitle excelTitle = ((ExcelTitle) clazz.getAnnotation(ExcelTitle.class));
            name = getExcelTitleName(excelType,excelTitle);
        }
        if(StringUtils.isTrimBlank(name))
            throw new FmsServiceException("请设置excel文件名称");
        return name;
    }

    public String getExcelTitleName(Integer excelType,Method method){
        String name = getExcelTitleName(excelType, method.getAnnotation(ExcelTitle.class));
        if(StringUtils.isTrimBlank(name))
            throw new FmsServiceException("请设置excel列名称");
        return name;
    }

    public String getExcelTitleName(Integer excelType,ExcelTitle excelTitle ){
        String name = null;
        int[] types = excelTitle.types();
        String[] typeValues = excelTitle.typeValues();
        if (IntegerUtils.isNotNullAndNotLengthZero(types) && ArrayUtils.isNotNullAndLengthNotZero(typeValues)) {
            //在设置多种类型,以及多种名称的情况下
            if (types.length != typeValues.length)
                throw new FmsServiceException("请设置正确的文件title");
            for (int i = 0; i < types.length; i++) {
                if (excelType.equals(types[i])) {
                    name = typeValues[i];
                    break;
                }
            }
        } else if (IntegerUtils.isNullOrLengthZero(types) || IntegerUtils.containValue(types, excelType))
            //在类型为空或者设置了多种类型,名称只有一种的情况下
            name = excelTitle.value();
        return name;
    }

}
