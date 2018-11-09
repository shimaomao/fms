package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.service.BusinessStatisticsExportService;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.*;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by admin on 2018/10/10.
 */
@Service
@Slf4j
public class BusinessStatisticsExportServiceImpl implements BusinessStatisticsExportService {

    /**
     * 当月提报数据统计导出
     * @param sysTplType 模板实体类
     * @param datalist 填充模板的数据
     * @param out
     * @throws Exception
     */
    public void singlemonthreport(SysTplType sysTplType, List<ReportStatisticsVo> datalist, List<ReportStatisticsListVo> ReportStatisticsList, OutputStream out) throws Exception {
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
        if(ArrayUtils.isNullOrLengthZero(datalist)){
            try {
                wb.write(out);
            } catch (IOException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                log.error("导出excel中error",ex);
            }
        } else {

            //拿到第一个sheet
            XSSFSheet source =  wb.getSheetAt(0);
            String contractSerachDate = datalist.get(0).getContractSerachDate();//获取合同生效日期
            Row rowOne = source.getRow(0);
            rowOne.getCell(11).setCellValue("日期:"+contractSerachDate);//拿到合同生效日期赋值
            int nowRowNum = 4; //去掉表头循环数据
            BigDecimal sumdrivingVehicle = BigDecimal.ZERO; //合计经销商试乘试驾车/救援车
            BigDecimal sumstepCar = BigDecimal.ZERO; //合计经销商代步车
            BigDecimal sumemployeesCar = BigDecimal.ZERO; //合计经销商员工购车
            BigDecimal sumcustomerEnterprise = BigDecimal.ZERO; //合计零售客户标准企业
            BigDecimal sumcustomerPerson = BigDecimal.ZERO; //合计零售客户标准个人
            BigDecimal sumcustomerLeaseback = BigDecimal.ZERO; //合计零售客户回租
            BigDecimal sumcustomersHandCar = BigDecimal.ZERO; //合计零售客户二手车
            BigDecimal sumcustomerMotorcycle = BigDecimal.ZERO; //合计零售客户摩托车
            BigDecimal sumdistributorTotal = BigDecimal.ZERO; //经销商合计
            BigDecimal sumtotalRetailCustomers = BigDecimal.ZERO; //零售客户合计
            BigDecimal summonthSum = BigDecimal.ZERO; //本月合计
            BigDecimal sumfinTotal = BigDecimal.ZERO; //合计融资额
            for(int i = 0 ; i < datalist.size(); i++) {
                ReportStatisticsVo reportStatisticsVo = datalist.get(i);
                Row row = source.createRow(nowRowNum+i); // 创建行
                //设定此行的单元格
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,0,wb),reportStatisticsVo.getGroupDistrict(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,1,wb),reportStatisticsVo.getDrivingVehicle(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,2,wb),reportStatisticsVo.getStepCar(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,3,wb),reportStatisticsVo.getEmployeesCar(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,4,wb),reportStatisticsVo.getCustomerEnterprise(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,5,wb),reportStatisticsVo.getCustomerPerson(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,6,wb),reportStatisticsVo.getCustomerLeaseback(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,7,wb),reportStatisticsVo.getCustomersHandCar(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,8,wb),reportStatisticsVo.getCustomerMotorcycle(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,9,wb),reportStatisticsVo.getDistributorTotal(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,10,wb),reportStatisticsVo.getTotalRetailCustomers(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,11,wb),reportStatisticsVo.getMonthSum(), wb);
                sumdrivingVehicle = sumdrivingVehicle.add(reportStatisticsVo.getDrivingVehicle());
                sumstepCar = sumstepCar.add(reportStatisticsVo.getStepCar());
                sumemployeesCar = sumemployeesCar.add(reportStatisticsVo.getEmployeesCar());
                sumcustomerEnterprise = sumcustomerEnterprise.add(reportStatisticsVo.getCustomerEnterprise());
                sumcustomerPerson = sumcustomerPerson.add(reportStatisticsVo.getCustomerPerson());
                sumcustomerLeaseback = sumcustomerLeaseback.add(reportStatisticsVo.getCustomerLeaseback());
                sumcustomersHandCar = sumcustomersHandCar.add(reportStatisticsVo.getCustomersHandCar());
                sumcustomerMotorcycle = sumcustomerMotorcycle.add(reportStatisticsVo.getCustomerMotorcycle());
                sumdistributorTotal = sumdistributorTotal.add(reportStatisticsVo.getDistributorTotal());
                sumtotalRetailCustomers = sumtotalRetailCustomers.add(reportStatisticsVo.getTotalRetailCustomers());
                summonthSum = summonthSum.add(reportStatisticsVo.getMonthSum());
                sumfinTotal = sumfinTotal.add(reportStatisticsVo.getFinTotal());
            }
            //创建合计行，并且赋值合计总值
            Row row = source.createRow(nowRowNum+datalist.size());
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,0,wb),"合计台数", wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,1,wb),sumdrivingVehicle, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,2,wb),sumstepCar, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,3,wb),sumemployeesCar, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,4,wb),sumcustomerEnterprise, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,5,wb),sumcustomerPerson, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,6,wb),sumcustomerLeaseback, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,7,wb),sumcustomersHandCar, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,8,wb),sumcustomerMotorcycle, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,9,wb),sumdistributorTotal, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,10,wb),sumtotalRetailCustomers, wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(row,11,wb),summonthSum, wb);
            //创建合计融资额行，并且赋值融资额总值
            Row rowend = source.createRow(nowRowNum+datalist.size()+1);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(rowend,0,wb),"合计融资额", wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(rowend,1,wb),sumfinTotal, wb);

            //拿到第二个sheet
            XSSFSheet mxsource =  wb.getSheetAt(1);
            int mxnowRowNum = 1; //去掉表头循环数据
            for(int i = 0 ; i < ReportStatisticsList.size(); i++) {
                ReportStatisticsListVo reportStatisticsListVo = ReportStatisticsList.get(i);
                Row mxrow = mxsource.createRow(mxnowRowNum+i); // 创建行
                //设定此行的单元格
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,0,wb),mxnowRowNum+i, wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,1,wb),reportStatisticsListVo.getCstmName(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,2,wb),reportStatisticsListVo.getVehicleName(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,3,wb),reportStatisticsListVo.getGuidePrice(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,4,wb),reportStatisticsListVo.getFinAmount(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,5,wb),reportStatisticsListVo.getInvestTotal(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,6,wb),reportStatisticsListVo.getInitAmount(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,7,wb),reportStatisticsListVo.getDeposit(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,8,wb),reportStatisticsListVo.getFinTotal(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,9,wb),reportStatisticsListVo.getFinalAmount(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,10,wb),reportStatisticsListVo.getBackPurchase(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,11,wb),reportStatisticsListVo.getAnnualSupplyAmount(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,12,wb),reportStatisticsListVo.getFinPeriodType(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,13,wb),reportStatisticsListVo.getLeaseTermStartDate(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,14,wb),reportStatisticsListVo.getLeaseTermEndDate(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,15,wb),reportStatisticsListVo.getProductName(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,16,wb),reportStatisticsListVo.getCompanyType1(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,17,wb),reportStatisticsListVo.getIntrstRate(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,18,wb),reportStatisticsListVo.getIrr(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,19,wb),reportStatisticsListVo.getStaticRateOfReturn(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,20,wb),reportStatisticsListVo.getSalesName(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,21,wb),reportStatisticsListVo.getApplyUser(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,22,wb),reportStatisticsListVo.getApplyFirsbtDate(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(mxrow,23,wb),reportStatisticsListVo.getContractValidDate(), wb);
            }

            try {
                wb.write(out);
            } catch (IOException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                log.error("导出excel中error",ex);
            }
        }
    }

    /**
     * 融资租赁业务统计报表导出
     * @param sysTplType 模板实体类
     * @param datalist 填充模板的数据
     * @param out
     * @throws Exception
     */
    public void reportbustatisticsexport(SysTplType sysTplType, List<BusinessStatisticsVo> datalist, List<RegionStatisticsVo> regionStatisticslist, List<BrandStatisticsVo> brandStatisticslist, OutputStream out) throws Exception {
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
        if(ArrayUtils.isNullOrLengthZero(datalist)){
            try {
                wb.write(out);
            } catch (IOException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                log.error("导出excel中error",ex);
            }
        } else {
            //初始化单元格格式,共通样式的单元格
            XSSFCellStyle cellStyleCommon = wb.createCellStyle();
            ExcelUtils.setCellStyle(cellStyleCommon);

            //拿到第一个sheet
            XSSFSheet source =  wb.getSheetAt(0);
            //表头赋值
            String contractSerachDate = datalist.get(0).getContractSerachDate();
            Row row0 = source.getRow(0); // 得到月度合计行
            row0.getCell(0).setCellValue("万量融资租赁业务统计报表-"+contractSerachDate.substring(0,4));//拿到合同生效年份赋值
            //汇总数据和客户类型分布
            Row row2 = source.getRow(2); // 得到月度合计行
            Row row3 = source.getRow(3); // 得到累计台数行
            Row row4 = source.getRow(4); // 得到总融资额行
            Row row5 = source.getRow(5); // 得到累计融资额行
            Row row6 = source.getRow(6); // 得到单台融资额行
            Row row7 = source.getRow(7); // 得到IRR行
            Row row8 = source.getRow(8); // 得到经销商台数行
            Row row9 = source.getRow(9); // 得到经销售融资额行
            Row row10 = source.getRow(10); // 得到企业客户台数行
            Row row11 = source.getRow(11); // 得到企业融资额行
            Row row12 = source.getRow(12); // 得到行零售个人台数行
            Row row13 = source.getRow(13); // 得到零售个人融资额行
            for(int i = 1 ; i <= 12; i++) {//汇总数据和客户类型分布行12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row2,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row3,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row4,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row5,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row6,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row7,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row8,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row9,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row10,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row11,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row12,i+1,cellStyleCommon),new BigDecimal(0), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row13,i+1,cellStyleCommon),new BigDecimal(0), wb);
            }
            int Unitvalue = 2;  //设定单元格开始赋值位置
            for(int i = 0 ; i < datalist.size(); i++) {
                BusinessStatisticsVo businessStatisticsVo = datalist.get(i);
                //设定此行的单元格
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row2,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getMonthlyNumber(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row3,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getCumulativeNumber(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row4,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getFinTotal(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row5,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getAccumulatedTotal(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row6,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getAveragefinTotal(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row7,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getAverageIrr(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row8,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getDistributorsVehicle(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row9,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getDistributorsFintotal(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row10,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getEnterpriseVehicle(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row11,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getEnterpriseFintotal(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row12,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getPersonalVehicle(), wb);
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row13,Unitvalue+i,cellStyleCommon),businessStatisticsVo.getPersonalFintotal(), wb);
            }
            //取出当年最大的月份数据
            BusinessStatisticsVo maxbusinessStatisticsVo = datalist.get(datalist.size()-1);
            if(Integer.parseInt(maxbusinessStatisticsVo.getEffectivedateMonth())<12){//最大月份小于12月则填充累计台数和累计融资额
                int count = Integer.parseInt(maxbusinessStatisticsVo.getEffectivedateMonth())+1;
                for(int i = count ; i <= 12; i++) {
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row3,i+1,cellStyleCommon),maxbusinessStatisticsVo.getCumulativeNumber(), wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(row5,i+1,cellStyleCommon),maxbusinessStatisticsVo.getAccumulatedTotal(), wb);
                }
            }
            //各个区域业务量分布
            Row regionrow = source.createRow(14); // 去掉汇总循环数据行
            int hzRowNum = 14;  //设置开始循环行数
            for(int i = 1 ; i <= 12; i++) {//刚开始赋值第一行12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrow,i+1,cellStyleCommon),new BigDecimal(0), wb);
            }
            for(int i = 0 ; i < regionStatisticslist.size(); i++) {
                RegionStatisticsVo regionStatisticsVo = regionStatisticslist.get(i);
                String groupDistrict = regionStatisticsVo.getGroupDistrict();//区域
                String effectivedateMonth = regionStatisticsVo.getEffectivedateMonth();//月份
                if(i==0){
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrow,1,cellStyleCommon),groupDistrict, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrow,Integer.parseInt(effectivedateMonth)+1,cellStyleCommon),new BigDecimal(regionStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!groupDistrict.equals(regionStatisticslist.get(i-1).getGroupDistrict())){//当前对象的区域不等于上一个对象的区域
                        //不等于说明要新建一行
                        hzRowNum = hzRowNum+1;
                        Row regionrows = source.createRow(hzRowNum);
                        regionrow = regionrows;
                        //新创建一行需要先赋值12个月默认值0
                        for(int j = 1 ; j <= 12; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+1,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,1,cellStyleCommon),groupDistrict, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+1,cellStyleCommon),new BigDecimal(regionStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrow,Integer.parseInt(effectivedateMonth)+1,cellStyleCommon),new BigDecimal(regionStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            source.addMergedRegion(new CellRangeAddress(14,hzRowNum,0,0));
            XSSFCellStyle cellStylesf = wb.createCellStyle();
            cellStylesf.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            for(int i = 14 ; i <= hzRowNum; i++) {//给合并单元格的左列设置边框
                Cell cell2 = source.getRow(i).createCell(0);
                cell2.setCellStyle(cellStylesf);
            }
            ExcelUtils.setCellStyle(cellStylesf);
            Cell cell = ExcelUtils.createNewCell(source.getRow(14),0, wb);
            cell.getCellStyle().setRotation((short)255);
            ExcelUtils.setCellValue(cell,"各省业务量分布", wb);

            //各个品牌业务量分布
            int ppRowNum = hzRowNum+1;  //设置开始循环行数
            Row brandnrow = source.createRow(ppRowNum); // 去掉区域循环数据行
            for(int i = 1 ; i <= 12; i++) {//刚开始赋值紧接着第一行12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(brandnrow,i+1,cellStyleCommon),new BigDecimal(0), wb);
            }
            for(int i = 0 ; i < brandStatisticslist.size(); i++) {
                BrandStatisticsVo brandStatisticsVo = brandStatisticslist.get(i);
                String vehicleName = brandStatisticsVo.getVehicleName();//品牌
                String effectivedateMonth = brandStatisticsVo.getEffectivedateMonth();//月份
                if(i==0){
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(brandnrow,1,cellStyleCommon),vehicleName, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(brandnrow,Integer.parseInt(effectivedateMonth)+1,cellStyleCommon),new BigDecimal(brandStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!vehicleName.equals(brandStatisticslist.get(i-1).getVehicleName())){//当前对象的品牌不等于上一个对象的品牌
                        //不等于说明要新建一行品牌
                        ppRowNum = ppRowNum+1;
                        Row regionrows = source.createRow(ppRowNum);
                        brandnrow = regionrows;
                        //新创建一行需要先赋值12个月默认值0
                        for(int j = 1 ; j <= 12; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+1,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,1,cellStyleCommon),vehicleName, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+1,cellStyleCommon),new BigDecimal(brandStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(brandnrow,Integer.parseInt(effectivedateMonth)+1,cellStyleCommon),new BigDecimal(brandStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            source.addMergedRegion(new CellRangeAddress(hzRowNum+1,ppRowNum,0,0));
            XSSFCellStyle cellStylepp = wb.createCellStyle();
            cellStylepp.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            for(int i = hzRowNum+1 ; i <= ppRowNum; i++) {//给合并单元格的左列设置边框
                Cell cell2 = source.getRow(i).createCell(0);
                if(i==ppRowNum)
                    cellStylepp.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                cell2.setCellStyle(cellStylepp);
            }
            ExcelUtils.setCellStyle(cellStylepp);
            Cell cell2 = ExcelUtils.createNewCell(source.getRow(hzRowNum+1),0, wb);
            cell2.getCellStyle().setRotation((short)255);
            ExcelUtils.setCellValue(cell2,"品牌分布", wb);
            try {
                wb.write(out);
            } catch (IOException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                log.error("导出excel中error",ex);
            }
        }
    }

    /**
     * 融资租赁审批数据统计报表导出
     * @param sysTplType 模板实体类
     * @param adoptdatalist 填充模板的数据
     * @param out
     * @throws Exception
     */
    public void reportApprovalstatisticsexport(SysTplType sysTplType, String yearInquiries, List<ApprovalStatisticsVo> adoptdatalist, List<ApprovalStatisticsVo> refusedatalist, List<ApprovalStatisticsVo> canceldatalist, List<ApprovalStatisticsVo> alldatalist, List<RateOfPassingStatisticsVo> rateOfPassinglist, List<IndustryStatisticsVo> adoptIndustrylist, List<IndustryStatisticsVo> refuseIndustrylist, List<IndustryStatisticsVo> cancelIndustrylist, List<IndustryStatisticsVo> allIndustrylist, List<RateOfPassingIndustryStatisticsVo> rateOfPassingIndustrylist, OutputStream out) throws Exception {
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

        //初始化单元格格式,共通样式的单元格
        XSSFCellStyle cellStyleCommon = wb.createCellStyle();
        ExcelUtils.setCellStyle(cellStyleCommon);

        //拿到第一个sheet
        XSSFSheet source =  wb.getSheetAt(0);
        //表头截至月份赋值
        Row row1 = source.getRow(1); // 得到月度合计行
        //获取截止年月
        if (!StringUtils.isExits(yearInquiries)) {
            yearInquiries = DateUtils.getCurrentDateString();//查询日期为空取到当前年月
        }else{
            yearInquiries = yearInquiries+"12";//查询日期不为空后面默认加上12个月
        }
        row1.getCell(3).setCellValue("截至"+yearInquiries.substring(0,4)+"年"+yearInquiries.substring(4,6)+"月");//拿到首次申请日期赋值
        //申请单子通过统计赋值
        int RowNum = 2;  //设置开始循环行数
        Row tgrow2 = source.createRow(RowNum); // 通过统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,2,wb,new HSSFColor.GREEN().getIndex()),"通过", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,i+2,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(0), wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(adoptdatalist)){//申请通过统计不为空赋值
            RowNum = RowNum+1;//通过数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),new BigDecimal(0), wb);
            }
            BigDecimal grossValue = BigDecimal.ZERO; //区域12个月计算总值
            int[] adoptMonth = new int[13];//定义一个存放截至月份和12个月申请通过总值数组
            for(int i = 0 ; i < adoptdatalist.size(); i++) {
                ApprovalStatisticsVo approvalStatisticsVo = adoptdatalist.get(i);
                String groupDistrict = approvalStatisticsVo.getGroupDistrict();//区域
                String effectivedateMonth = approvalStatisticsVo.getEffectivedateMonth();//月份
                //数组内数据按照月份进行累加
                adoptMonth[0]=adoptMonth[0]+Integer.parseInt(approvalStatisticsVo.getNumberOftables());
                adoptMonth[Integer.parseInt(effectivedateMonth)]=adoptMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(approvalStatisticsVo.getNumberOftables());
                if(i==0){
                    grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),groupDistrict, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!groupDistrict.equals(adoptdatalist.get(i-1).getGroupDistrict())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月总值赋值到截至月份
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),grossValue, wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        grossValue = BigDecimal.ZERO;
                        grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),groupDistrict, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            //循环完之后把最后一个区域的总值赋值到截止月份中
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),grossValue, wb);
            //循环完成之后把通过一行截止月份和12个月总值赋值
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,3,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[0]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,4,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[1]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,5,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[2]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,6,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[3]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,7,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[4]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,8,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[5]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,9,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[6]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,10,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[7]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,11,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[8]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,12,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[9]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,13,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[10]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,14,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[11]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tgrow2,15,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[12]), wb);
        }
        //申请单子拒绝统计赋值
        RowNum = RowNum+1;//拒绝数据行
        Row jjrow2 = source.createRow(RowNum); // 拒绝统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,2,wb,new HSSFColor.RED().getIndex()),"拒绝", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,i+2,wb,new HSSFColor.RED().getIndex()),new BigDecimal(0), wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(refusedatalist)){//申请拒绝统计不为空赋值
            RowNum = RowNum+1;//拒绝数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),new BigDecimal(0), wb);
            }
            BigDecimal grossValue = BigDecimal.ZERO; //区域12个月计算总值
            int[] refuseMonth = new int[13];//定义一个存放截至月份和12个月申请拒绝总值数组
            for(int i = 0 ; i < refusedatalist.size(); i++) {
                ApprovalStatisticsVo approvalStatisticsVo = refusedatalist.get(i);
                String groupDistrict = approvalStatisticsVo.getGroupDistrict();//区域
                String effectivedateMonth = approvalStatisticsVo.getEffectivedateMonth();//月份
                //数组内数据按照月份进行累加
                refuseMonth[0]=refuseMonth[0]+Integer.parseInt(approvalStatisticsVo.getNumberOftables());
                refuseMonth[Integer.parseInt(effectivedateMonth)]=refuseMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(approvalStatisticsVo.getNumberOftables());
                if(i==0){
                    grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),groupDistrict, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!groupDistrict.equals(refusedatalist.get(i-1).getGroupDistrict())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月总值赋值到截至月份
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),grossValue, wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        grossValue = BigDecimal.ZERO;
                        grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),groupDistrict, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            //循环完之后把最后一个区域的总值赋值到截止月份中
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),grossValue, wb);
            //循环完成之后把拒绝一行截止月份和12个月总值赋值
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,3,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[0]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,4,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[1]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,5,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[2]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,6,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[3]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,7,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[4]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,8,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[5]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,9,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[6]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,10,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[7]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,11,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[8]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,12,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[9]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,13,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[10]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,14,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[11]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(jjrow2,15,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[12]), wb);
        }
        //申请单子取消统计赋值
        RowNum = RowNum+1;//取消数据行
        Row qxrow2 = source.createRow(RowNum); // 取消统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,2,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),"取消", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,i+2,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(0), wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(canceldatalist)){//申请取消统计不为空赋值
            RowNum = RowNum+1;//取消数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),new BigDecimal(0), wb);
            }
            BigDecimal grossValue = BigDecimal.ZERO; //区域12个月计算总值
            int[] cancelMonth = new int[13];//定义一个存放截至月份和12个月申请取消总值数组
            for(int i = 0 ; i < canceldatalist.size(); i++) {
                ApprovalStatisticsVo approvalStatisticsVo = canceldatalist.get(i);
                String groupDistrict = approvalStatisticsVo.getGroupDistrict();//区域
                String effectivedateMonth = approvalStatisticsVo.getEffectivedateMonth();//月份
                //数组内数据按照月份进行累加
                cancelMonth[0]=cancelMonth[0]+Integer.parseInt(approvalStatisticsVo.getNumberOftables());
                cancelMonth[Integer.parseInt(effectivedateMonth)]=cancelMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(approvalStatisticsVo.getNumberOftables());
                if(i==0){
                    grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),groupDistrict, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!groupDistrict.equals(canceldatalist.get(i-1).getGroupDistrict())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月总值赋值到截至月份
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),grossValue, wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        grossValue = BigDecimal.ZERO;
                        grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),groupDistrict, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            //循环完之后把最后一个区域的总值赋值到截止月份中
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),grossValue, wb);
            //循环完成之后把取消一行截止月份和12个月总值赋值
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,3,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[0]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,4,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[1]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,5,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[2]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,6,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[3]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,7,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[4]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,8,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[5]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,9,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[6]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,10,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[7]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,11,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[8]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,12,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[9]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,13,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[10]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,14,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[11]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(qxrow2,15,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[12]), wb);
        }
        //申请单子通过拒绝取消统计赋值
        RowNum = RowNum+1;//合计数据行
        Row hjrow2 = source.createRow(RowNum); // 合计统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,2,wb,new HSSFColor.LIME().getIndex()),"合计", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,i+2,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(0), wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(alldatalist)){//申请合计统计不为空赋值
            RowNum = RowNum+1;//合计数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),new BigDecimal(0), wb);
            }
            BigDecimal grossValue = BigDecimal.ZERO; //区域12个月计算总值
            int[] allMonth = new int[13];//定义一个存放截至月份和12个月申请合计总值数组
            for(int i = 0 ; i < alldatalist.size(); i++) {
                ApprovalStatisticsVo approvalStatisticsVo = alldatalist.get(i);
                String groupDistrict = approvalStatisticsVo.getGroupDistrict();//区域
                String effectivedateMonth = approvalStatisticsVo.getEffectivedateMonth();//月份
                //数组内数据按照月份进行累加
                allMonth[0]=allMonth[0]+Integer.parseInt(approvalStatisticsVo.getNumberOftables());
                allMonth[Integer.parseInt(effectivedateMonth)]=allMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(approvalStatisticsVo.getNumberOftables());
                if(i==0){
                    grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),groupDistrict, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!groupDistrict.equals(alldatalist.get(i-1).getGroupDistrict())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月总值赋值到截至月份
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),grossValue, wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        grossValue = BigDecimal.ZERO;
                        grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),groupDistrict, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        grossValue = grossValue.add(new BigDecimal(approvalStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(approvalStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            //循环完之后把最后一个区域的总值赋值到截止月份中
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),grossValue, wb);
            //循环完成之后把合计一行截止月份和12个月总值赋值
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,3,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[0]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,4,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[1]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,5,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[2]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,6,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[3]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,7,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[4]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,8,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[5]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,9,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[6]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,10,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[7]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,11,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[8]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,12,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[9]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,13,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[10]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,14,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[11]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hjrow2,15,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[12]), wb);
        }
        //申请单子通过率统计赋值
        RowNum = RowNum+1;//通过率统数据行
        Row tglrow2 = source.createRow(RowNum); // 通过率统统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,2,wb,new HSSFColor.BLUE().getIndex()),"通过率", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,i+2,wb,new HSSFColor.BLUE().getIndex()),0+"%", wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(rateOfPassinglist)){//申请通过率统计不为空赋值
            RowNum = RowNum+1;//通过率数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),0+"%", wb);
            }
            BigDecimal adoptValue = BigDecimal.ZERO; //区域12个月申请通过总台数
            BigDecimal countValue = BigDecimal.ZERO; //区域12个月申请拒绝和取消总台数
            int[] adoptMonth = new int[13];//定义一个存放截至月份和12个月申请通过总值数组
            int[] allMonth = new int[13];//定义一个存放截至月份和12个月申请合计总值数组
            for(int i = 0 ; i < rateOfPassinglist.size(); i++) {
                RateOfPassingStatisticsVo rateOfPassingStatisticsVo = rateOfPassinglist.get(i);
                String groupDistrict = rateOfPassingStatisticsVo.getGroupDistrict();//区域
                String effectivedateMonth = rateOfPassingStatisticsVo.getEffectivedateMonth();//月份
                //数组内申请通过数据按照月份进行累加
                adoptMonth[0]=adoptMonth[0]+Integer.parseInt(rateOfPassingStatisticsVo.getAdoptnumberOftables());
                adoptMonth[Integer.parseInt(effectivedateMonth)]=adoptMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(rateOfPassingStatisticsVo.getAdoptnumberOftables());
                //数组内申请合计数据按照月份进行累加
                allMonth[0]=allMonth[0]+Integer.parseInt(rateOfPassingStatisticsVo.getNumberOftables());
                allMonth[Integer.parseInt(effectivedateMonth)]=allMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(rateOfPassingStatisticsVo.getNumberOftables());
                if(i==0){
                    adoptValue = adoptValue.add(new BigDecimal(rateOfPassingStatisticsVo.getAdoptnumberOftables()));
                    countValue = countValue.add(new BigDecimal(rateOfPassingStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),groupDistrict, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),rateOfPassingStatisticsVo.getRateOfPassing()+"%", wb);
                }else{
                    if(!groupDistrict.equals(rateOfPassinglist.get(i-1).getGroupDistrict())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月通过台数计算通过率赋值到截至月份
                        BigDecimal rateOfPassing = BigDecimalUtils.divide(adoptValue,countValue,2).multiply(new BigDecimal(100));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),rateOfPassing.toString()+"%", wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        adoptValue = BigDecimal.ZERO;
                        countValue = BigDecimal.ZERO;
                        adoptValue = adoptValue.add(new BigDecimal(rateOfPassingStatisticsVo.getAdoptnumberOftables()));
                        countValue = countValue.add(new BigDecimal(rateOfPassingStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),0+"%", wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),groupDistrict, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),rateOfPassingStatisticsVo.getRateOfPassing()+"%", wb);
                    }else{//还在原来的行数赋值
                        adoptValue = adoptValue.add(new BigDecimal(rateOfPassingStatisticsVo.getAdoptnumberOftables()));
                        countValue = countValue.add(new BigDecimal(rateOfPassingStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),rateOfPassingStatisticsVo.getRateOfPassing()+"%", wb);
                    }
                }
            }
            //循环完之后把最后一个区域的通过率到截止月份中
            BigDecimal rateOfPassing = BigDecimalUtils.divide(adoptValue,countValue,2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),rateOfPassing.toString()+"%", wb);
            //循环完成之后把合计一行截止月份和12个月总值赋值
            BigDecimal rateOfPassing0 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[0]),new BigDecimal(allMonth[0]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,3,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing0.toString()+"%", wb);
            BigDecimal rateOfPassing1 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[1]),new BigDecimal(allMonth[1]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,4,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing1.toString()+"%", wb);
            BigDecimal rateOfPassing2 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[2]),new BigDecimal(allMonth[2]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,5,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing2.toString()+"%", wb);
            BigDecimal rateOfPassing3 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[3]),new BigDecimal(allMonth[3]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,6,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing3.toString()+"%", wb);
            BigDecimal rateOfPassing4 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[4]),new BigDecimal(allMonth[4]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,7,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing4.toString()+"%", wb);
            BigDecimal rateOfPassing5 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[5]),new BigDecimal(allMonth[5]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,8,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing5.toString()+"%", wb);
            BigDecimal rateOfPassing6 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[6]),new BigDecimal(allMonth[6]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,9,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing6.toString()+"%", wb);
            BigDecimal rateOfPassing7 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[7]),new BigDecimal(allMonth[7]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,10,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing7.toString()+"%", wb);
            BigDecimal rateOfPassing8 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[8]),new BigDecimal(allMonth[8]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,11,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing8.toString()+"%", wb);
            BigDecimal rateOfPassing9 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[9]),new BigDecimal(allMonth[9]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,12,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing9.toString()+"%", wb);
            BigDecimal rateOfPassing10 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[10]),new BigDecimal(allMonth[10]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,13,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing10.toString()+"%", wb);
            BigDecimal rateOfPassing11 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[11]),new BigDecimal(allMonth[11]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,14,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing11.toString()+"%", wb);
            BigDecimal rateOfPassing12 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[12]),new BigDecimal(allMonth[12]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(tglrow2,15,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing12.toString()+"%", wb);
        }
        source.addMergedRegion(new CellRangeAddress(2,RowNum,1,1));
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        for(int i = 2 ; i <= RowNum; i++) {//给合并单元格的左列设置边框
            Cell cell = source.getRow(i).createCell(1);
            cell.setCellStyle(cellStyle);
        }
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(source.getRow(2),1,wb),"区域", wb);
        //单位行业类别申请单子通过统计赋值
        int stratRow = RowNum+1;//记录行业合并单元格开始行
        RowNum = RowNum+1;//单位行业类别申请单子通过数据行
        Row hytgrow2 = source.createRow(RowNum); // 单位行业类别申请单子通过统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,2,wb,new HSSFColor.GREEN().getIndex()),"通过", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,i+2,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(0), wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(adoptIndustrylist)){//单位行业类别申请单子通过统计不为空赋值
            RowNum = RowNum+1;//单位行业类别申请单子通过数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),new BigDecimal(0), wb);
            }
            BigDecimal grossValue = BigDecimal.ZERO; //区域12个月计算总值
            int[] adoptMonth = new int[13];//定义一个存放截至月份和12个月申请通过总值数组
            for(int i = 0 ; i < adoptIndustrylist.size(); i++) {
                IndustryStatisticsVo industryStatisticsVo = adoptIndustrylist.get(i);
                String industry = industryStatisticsVo.getIndustry();//单位行业类别
                String effectivedateMonth = industryStatisticsVo.getEffectivedateMonth();//月份
                //数组内数据按照月份进行累加
                adoptMonth[0]=adoptMonth[0]+Integer.parseInt(industryStatisticsVo.getNumberOftables());
                adoptMonth[Integer.parseInt(effectivedateMonth)]=adoptMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(industryStatisticsVo.getNumberOftables());
                if(i==0){
                    grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),industry, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!industry.equals(adoptIndustrylist.get(i-1).getIndustry())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月总值赋值到截至月份
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),grossValue, wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        grossValue = BigDecimal.ZERO;
                        grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),industry, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            //循环完之后把最后一个区域的总值赋值到截止月份中
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),grossValue, wb);
            //循环完成之后把通过一行截止月份和12个月总值赋值
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,3,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[0]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,4,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[1]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,5,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[2]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,6,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[3]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,7,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[4]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,8,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[5]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,9,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[6]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,10,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[7]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,11,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[8]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,12,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[9]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,13,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[10]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,14,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[11]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hytgrow2,15,wb,new HSSFColor.GREEN().getIndex()),new BigDecimal(adoptMonth[12]), wb);
        }
        //单位行业类别申请单子拒绝统计赋值
        RowNum = RowNum+1;//单位行业类别申请单子拒绝数据行
        Row hyjjrow2 = source.createRow(RowNum); // 单位行业类别申请单子拒绝统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,2,wb,new HSSFColor.RED().getIndex()),"拒绝", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,i+2,wb,new HSSFColor.RED().getIndex()),new BigDecimal(0), wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(refuseIndustrylist)){//单位行业类别申请单子拒绝统计不为空赋值
            RowNum = RowNum+1;//单位行业类别申请单子拒绝数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),new BigDecimal(0), wb);
            }
            BigDecimal grossValue = BigDecimal.ZERO; //区域12个月计算总值
            int[] refuseMonth = new int[13];//定义一个存放截至月份和12个月申请拒绝总值数组
            for(int i = 0 ; i < refuseIndustrylist.size(); i++) {
                IndustryStatisticsVo industryStatisticsVo = refuseIndustrylist.get(i);
                String industry = industryStatisticsVo.getIndustry();//单位行业类别
                String effectivedateMonth = industryStatisticsVo.getEffectivedateMonth();//月份
                //数组内数据按照月份进行累加
                refuseMonth[0]=refuseMonth[0]+Integer.parseInt(industryStatisticsVo.getNumberOftables());
                refuseMonth[Integer.parseInt(effectivedateMonth)]=refuseMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(industryStatisticsVo.getNumberOftables());
                if(i==0){
                    grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),industry, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!industry.equals(refuseIndustrylist.get(i-1).getIndustry())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月总值赋值到截至月份
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),grossValue, wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        grossValue = BigDecimal.ZERO;
                        grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),industry, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            //循环完之后把最后一个区域的总值赋值到截止月份中
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),grossValue, wb);
            //循环完成之后把拒绝一行截止月份和12个月总值赋值
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,3,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[0]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,4,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[1]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,5,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[2]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,6,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[3]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,7,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[4]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,8,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[5]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,9,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[6]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,10,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[7]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,11,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[8]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,12,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[9]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,13,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[10]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,14,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[11]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyjjrow2,15,wb,new HSSFColor.RED().getIndex()),new BigDecimal(refuseMonth[12]), wb);
        }
        //单位行业类别申请单子取消统计赋值
        RowNum = RowNum+1;//单位行业类别申请单子取消数据行
        Row hyqxrow2 = source.createRow(RowNum); // 单位行业类别申请单子取消统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,2,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),"取消", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,i+2,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(0), wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(refuseIndustrylist)){//单位行业类别申请单子取消统计不为空赋值
            RowNum = RowNum+1;//单位行业类别申请单子取消数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),new BigDecimal(0), wb);
            }
            BigDecimal grossValue = BigDecimal.ZERO; //区域12个月计算总值
            int[] cancelMonth = new int[13];//定义一个存放截至月份和12个月申请取消总值数组
            for(int i = 0 ; i < cancelIndustrylist.size(); i++) {
                IndustryStatisticsVo industryStatisticsVo = cancelIndustrylist.get(i);
                String industry = industryStatisticsVo.getIndustry();//单位行业类别
                String effectivedateMonth = industryStatisticsVo.getEffectivedateMonth();//月份
                //数组内数据按照月份进行累加
                cancelMonth[0]=cancelMonth[0]+Integer.parseInt(industryStatisticsVo.getNumberOftables());
                cancelMonth[Integer.parseInt(effectivedateMonth)]=cancelMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(industryStatisticsVo.getNumberOftables());
                if(i==0){
                    grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),industry, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!industry.equals(cancelIndustrylist.get(i-1).getIndustry())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月总值赋值到截至月份
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),grossValue, wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        grossValue = BigDecimal.ZERO;
                        grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),industry, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            //循环完之后把最后一个区域的总值赋值到截止月份中
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),grossValue, wb);
            //循环完成之后把取消一行截止月份和12个月总值赋值
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,3,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[0]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,4,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[1]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,5,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[2]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,6,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[3]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,7,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[4]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,8,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[5]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,9,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[6]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,10,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[7]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,11,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[8]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,12,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[9]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,13,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[10]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,14,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[11]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyqxrow2,15,wb,new HSSFColor.GREY_25_PERCENT().getIndex()),new BigDecimal(cancelMonth[12]), wb);
        }
        //单位行业类别申请单子合计统计赋值
        RowNum = RowNum+1;//单位行业类别申请单子合计数据行
        Row hyhjrow2 = source.createRow(RowNum); // 单位行业类别申请单子合计统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,2,wb,new HSSFColor.LIME().getIndex()),"合计", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,i+2,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(0), wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(allIndustrylist)){//单位行业类别申请单子合计统计不为空赋值
            RowNum = RowNum+1;//单位行业类别申请单子合计数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),new BigDecimal(0), wb);
            }
            BigDecimal grossValue = BigDecimal.ZERO; //区域12个月计算总值
            int[] allMonth = new int[13];//定义一个存放截至月份和12个月申请合计总值数组
            for(int i = 0 ; i < allIndustrylist.size(); i++) {
                IndustryStatisticsVo industryStatisticsVo = allIndustrylist.get(i);
                String industry = industryStatisticsVo.getIndustry();//单位行业类别
                String effectivedateMonth = industryStatisticsVo.getEffectivedateMonth();//月份
                //数组内数据按照月份进行累加
                allMonth[0]=allMonth[0]+Integer.parseInt(industryStatisticsVo.getNumberOftables());
                allMonth[Integer.parseInt(effectivedateMonth)]=allMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(industryStatisticsVo.getNumberOftables());
                if(i==0){
                    grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),industry, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                }else{
                    if(!industry.equals(allIndustrylist.get(i-1).getIndustry())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月总值赋值到截至月份
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),grossValue, wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        grossValue = BigDecimal.ZERO;
                        grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),new BigDecimal(0), wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),industry, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCell(regionrows,Integer.parseInt(effectivedateMonth)+3,wb),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                    }else{//还在原来的行数赋值
                        grossValue = grossValue.add(new BigDecimal(industryStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),new BigDecimal(industryStatisticsVo.getNumberOftables()), wb);
                    }
                }
            }
            //循环完之后把最后一个区域的总值赋值到截止月份中
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),grossValue, wb);
            //循环完成之后把取消一行截止月份和12个月总值赋值
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,3,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[0]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,4,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[1]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,5,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[2]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,6,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[3]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,7,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[4]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,8,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[5]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,9,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[6]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,10,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[7]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,11,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[8]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,12,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[9]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,13,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[10]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,14,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[11]), wb);
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hyhjrow2,15,wb,new HSSFColor.LIME().getIndex()),new BigDecimal(allMonth[12]), wb);
        }
        //申请单子行业通过率统计赋值
        RowNum = RowNum+1;//行业通过率统数据行
        Row hylrow2 = source.createRow(RowNum); // 行业通过率统统计数据行
        ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,2,wb,new HSSFColor.BLUE().getIndex()),"通过率", wb);
        for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,i+2,wb,new HSSFColor.BLUE().getIndex()),0+"%", wb);
        }
        if(!ArrayUtils.isNullOrLengthZero(rateOfPassingIndustrylist)){//申请行业通过率统计不为空赋值
            RowNum = RowNum+1;//行业通过率数据开始循环
            Row adoptnrow = source.createRow(RowNum);
            for(int i = 1 ; i <= 13; i++) {//刚开始赋值第一行截至月份和12个月数据默认都为0
                ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,i+2,wb),0+"%", wb);
            }
            BigDecimal adoptValue = BigDecimal.ZERO; //区域12个月申请通过总台数
            BigDecimal countValue = BigDecimal.ZERO; //区域12个月申请拒绝和取消总台数
            int[] adoptMonth = new int[13];//定义一个存放截至月份和12个月申请通过总值数组
            int[] allMonth = new int[13];//定义一个存放截至月份和12个月申请合计总值数组
            for(int i = 0 ; i < rateOfPassingIndustrylist.size(); i++) {
                RateOfPassingIndustryStatisticsVo rateOfPassingIndustryStatisticsVo = rateOfPassingIndustrylist.get(i);
                String industry = rateOfPassingIndustryStatisticsVo.getIndustry();//行业类别
                String effectivedateMonth = rateOfPassingIndustryStatisticsVo.getEffectivedateMonth();//月份
                //数组内申请通过数据按照月份进行累加
                adoptMonth[0]=adoptMonth[0]+Integer.parseInt(rateOfPassingIndustryStatisticsVo.getAdoptnumberOftables());
                adoptMonth[Integer.parseInt(effectivedateMonth)]=adoptMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(rateOfPassingIndustryStatisticsVo.getAdoptnumberOftables());
                //数组内申请合计数据按照月份进行累加
                allMonth[0]=allMonth[0]+Integer.parseInt(rateOfPassingIndustryStatisticsVo.getNumberOftables());
                allMonth[Integer.parseInt(effectivedateMonth)]=allMonth[Integer.parseInt(effectivedateMonth)]+Integer.parseInt(rateOfPassingIndustryStatisticsVo.getNumberOftables());
                if(i==0){
                    adoptValue = adoptValue.add(new BigDecimal(rateOfPassingIndustryStatisticsVo.getAdoptnumberOftables()));
                    countValue = countValue.add(new BigDecimal(rateOfPassingIndustryStatisticsVo.getNumberOftables()));
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,2,cellStyleCommon),industry, wb);
                    ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),rateOfPassingIndustryStatisticsVo.getRateOfPassing()+"%", wb);
                }else{
                    if(!industry.equals(rateOfPassingIndustrylist.get(i-1).getIndustry())){//当前对象的区域不等于上一个对象的区域
                        //新建一行时把上一个区域的12个月通过台数计算通过率赋值到截至月份
                        BigDecimal rateOfPassing = BigDecimalUtils.divide(adoptValue,countValue,2).multiply(new BigDecimal(100));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,3,cellStyleCommon),rateOfPassing.toString()+"%", wb);
                        //更换区域时将上一个区域总值赋为零,并且加上当前月份数据
                        adoptValue = BigDecimal.ZERO;
                        countValue = BigDecimal.ZERO;
                        adoptValue = adoptValue.add(new BigDecimal(rateOfPassingIndustryStatisticsVo.getAdoptnumberOftables()));
                        countValue = countValue.add(new BigDecimal(rateOfPassingIndustryStatisticsVo.getNumberOftables()));
                        //不等于说明要新建一行
                        RowNum = RowNum+1;
                        Row regionrows = source.createRow(RowNum);
                        adoptnrow = regionrows;
                        //新创建一行需要先赋值截至月份和12个月默认值0
                        for(int j = 1 ; j <= 13; j++) {
                            ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,j+2,cellStyleCommon),0+"%", wb);
                        }
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,2,cellStyleCommon),industry, wb);
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(regionrows,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),rateOfPassingIndustryStatisticsVo.getRateOfPassing()+"%", wb);
                    }else{//还在原来的行数赋值
                        adoptValue = adoptValue.add(new BigDecimal(rateOfPassingIndustryStatisticsVo.getAdoptnumberOftables()));
                        countValue = countValue.add(new BigDecimal(rateOfPassingIndustryStatisticsVo.getNumberOftables()));
                        ExcelUtils.setCellValue(ExcelUtils.createNewCellCommon(adoptnrow,Integer.parseInt(effectivedateMonth)+3,cellStyleCommon),rateOfPassingIndustryStatisticsVo.getRateOfPassing()+"%", wb);
                    }
                }
            }
            //循环完之后把最后一个区域的通过率到截止月份中
            BigDecimal rateOfPassing = BigDecimalUtils.divide(adoptValue,countValue,2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewCell(adoptnrow,3,wb),rateOfPassing.toString()+"%", wb);
            //循环完成之后把合计一行截止月份和12个月总值赋值
            BigDecimal rateOfPassing0 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[0]),new BigDecimal(allMonth[0]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,3,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing0.toString()+"%", wb);
            BigDecimal rateOfPassing1 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[1]),new BigDecimal(allMonth[1]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,4,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing1.toString()+"%", wb);
            BigDecimal rateOfPassing2 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[2]),new BigDecimal(allMonth[2]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,5,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing2.toString()+"%", wb);
            BigDecimal rateOfPassing3 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[3]),new BigDecimal(allMonth[3]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,6,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing3.toString()+"%", wb);
            BigDecimal rateOfPassing4 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[4]),new BigDecimal(allMonth[4]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,7,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing4.toString()+"%", wb);
            BigDecimal rateOfPassing5 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[5]),new BigDecimal(allMonth[5]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,8,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing5.toString()+"%", wb);
            BigDecimal rateOfPassing6 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[6]),new BigDecimal(allMonth[6]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,9,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing6.toString()+"%", wb);
            BigDecimal rateOfPassing7 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[7]),new BigDecimal(allMonth[7]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,10,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing7.toString()+"%", wb);
            BigDecimal rateOfPassing8 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[8]),new BigDecimal(allMonth[8]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,11,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing8.toString()+"%", wb);
            BigDecimal rateOfPassing9 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[9]),new BigDecimal(allMonth[9]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,12,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing9.toString()+"%", wb);
            BigDecimal rateOfPassing10 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[10]),new BigDecimal(allMonth[10]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,13,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing10.toString()+"%", wb);
            BigDecimal rateOfPassing11 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[11]),new BigDecimal(allMonth[11]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,14,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing11.toString()+"%", wb);
            BigDecimal rateOfPassing12 = BigDecimalUtils.divide(new BigDecimal(adoptMonth[12]),new BigDecimal(allMonth[12]),2).multiply(new BigDecimal(100));
            ExcelUtils.setCellValue(ExcelUtils.createNewBackgroundCell(hylrow2,15,wb,new HSSFColor.BLUE().getIndex()),rateOfPassing12.toString()+"%", wb);
        }
        source.addMergedRegion(new CellRangeAddress(stratRow,RowNum,1,1));
        XSSFCellStyle cellStyle2 = wb.createCellStyle();
        cellStyle2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        for(int i = stratRow ; i <= RowNum; i++) {//给合并单元格的左列设置边框
            Cell cell = source.getRow(i).createCell(1);
            if(i==RowNum)
                cellStyle2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cell.setCellStyle(cellStyle2);
        }
        ExcelUtils.setCellValue(ExcelUtils.createNewCell(source.getRow(stratRow),1,wb),"行业", wb);
        try {
            wb.write(out);
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            log.error("导出excel中error",ex);
        }
    }
}
