package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.rpc.system.SysTplTypeRpc;
import cn.com.leadu.fms.business.service.MonthlyOverdueExcelExportService;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.OverdueTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.CompanyType;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.constant.enums.sql.PageFlags;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.MonthlyOverdueRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverduesVo;
import cn.com.leadu.fms.data.postbiz.repository.MonthlyRentRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyOverdue;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent.MonthlyRentVo;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.postbiz.service.MonthlyOverdueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: MonthlyOverdueService
 * @Description: 逾期率统计业务实现层
 */
@Service
public class MonthlyOverdueServiceImpl implements MonthlyOverdueService {

    /**
     * 销售还款计划信息Repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;
    @Autowired
    private SysTplTypeRpc sysTplTypeRpc;

    /**
     * 月度租金到账率信息Repository
     */
    @Autowired
    private MonthlyRentRepository monthlyRentRepository;

    /**
     * 逾期率统计信息Repository
     */
    @Autowired
    private MonthlyOverdueRepository monthlyOverdueRepository;

    @Autowired
    private MonthlyOverdueExcelExportService monthlyOverdueExcelExportService;


    /**
     * @Title:
     * @Description: 分页查询逾期统计信息
     * @param monthlyOverduesVo
     * @return PageInfoExtend<MonthlyOverduesVo>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    public PageInfoExtend<MonthlyOverduesVo> findMonthlyOverduesVosByPage(MonthlyOverduesVo monthlyOverduesVo){
        //报表开始日期
        if(StringUtils.isTrimBlank(monthlyOverduesVo.getBeginMonthlyOverdueDate()))
            monthlyOverduesVo.setBeginMonthlyOverdueDate(null);
        else
            monthlyOverduesVo.setBeginMonthlyOverdueDate(monthlyOverduesVo.getBeginMonthlyOverdueDate().replace("-",""));//去除时间之间的连接符号
        //报表结束日期
        if(StringUtils.isTrimBlank(monthlyOverduesVo.getEndMonthlyOverdueDate()))
            monthlyOverduesVo.setEndMonthlyOverdueDate(null);
        else
            monthlyOverduesVo.setEndMonthlyOverdueDate(monthlyOverduesVo.getEndMonthlyOverdueDate().replace("-",""));//去除时间之间的连接符号
        PageInfoExtend<MonthlyOverduesVo> pageInfo = monthlyOverdueRepository.selectListVoByPage("selectMonthlyOverduesListByPage",monthlyOverduesVo,monthlyOverduesVo.getPageQuery());
        List<MonthlyOverduesVo> dataList = pageInfo.getData();
        if(ArrayUtils.isNotNullAndLengthNotZero(dataList)){
            for (MonthlyOverduesVo vo : dataList){
                //构建数值
                buildData(vo);
            }
        }
        return pageInfo;
    }

    /**
     * 构建数值
     * @param vo
     */
    private void buildData(MonthlyOverduesVo vo) {
        String orderRetailOverdue=vo.getOrderRetailOverdue();//零售逾期，按照overdueType(0-6)排序的7组数据，逗号隔开
        String orderRetailAmount=vo.getOrderRetailAmount();//零售总应收，按照overdueType(0-6)排序的7组数据，逗号隔开
        String orderParOverdue=vo.getOrderParOverdue();//经销商逾期，按照overdueType(0-6)排序的7组数据，逗号隔开
        String orderParOverAmount=vo.getOrderParAmount();//经销商总应收，按照overdueType(0-6)排序的7组数据，逗号隔开
        String orderTotalOverdue=vo.getOrderTotalOverdue();//总逾期，按照overdueType(0-6)排序的7组数据，逗号隔开
        String orderTotalAmount=vo.getOrderTotalAmount();//总应收，按照overdueType(0-6)排序的7组数据，逗号隔开
        String [] orderRetailOverdueArray=orderRetailOverdue.split(",");//零售逾期
        String [] orderRetailAmountArray=orderRetailAmount.split(",");//零售总应收
        String [] orderParOverdueArray=orderParOverdue.split(",");//经销商逾期
        String [] orderParAmountArray=orderParOverAmount.split(",");//经销商总应收
        String [] orderTotalOverdueArray=orderTotalOverdue.split(",");//总逾期
        String [] orderTotalAmountArray=orderTotalAmount.split(",");//总应收

        String censusMonth=CommonUtils.yearMonthFmt(vo.getCensusMonth());//将月份（201809）并转化为（2018年09月）格式
        BigDecimal retailOverdue=new BigDecimal(orderRetailOverdueArray[0]);//零售逾期0
        BigDecimal retailOverdue1=new BigDecimal(orderRetailOverdueArray[1]);//零售逾期1
        BigDecimal retailOverdue2=new BigDecimal(orderRetailOverdueArray[2]);//零售逾期2
        BigDecimal retailOverdue3=new BigDecimal(orderRetailOverdueArray[3]);//零售逾期3
        BigDecimal retailOverdue4=new BigDecimal(orderRetailOverdueArray[4]);//零售逾期4
        BigDecimal retailOverdue5=new BigDecimal(orderRetailOverdueArray[5]);//零售逾期5
        BigDecimal retailOverdue6=new BigDecimal(orderRetailOverdueArray[6]);//零售逾期6

        BigDecimal parOverdue=new BigDecimal(orderParOverdueArray[0]);//经销商逾期0
        BigDecimal parOverdue1=new BigDecimal(orderParOverdueArray[1]);//经销商逾期1
        BigDecimal parOverdue2=new BigDecimal(orderParOverdueArray[2]);//经销商逾期2
        BigDecimal parOverdue3=new BigDecimal(orderParOverdueArray[3]);//经销商逾期3
        BigDecimal parOverdue4=new BigDecimal(orderParOverdueArray[4]);//经销商逾期4
        BigDecimal parOverdue5=new BigDecimal(orderParOverdueArray[5]);//经销商逾期5
        BigDecimal parOverdue6=new BigDecimal(orderParOverdueArray[6]);//经销商逾期6

        BigDecimal totalOverdue=new BigDecimal(orderTotalOverdueArray[0]);//总逾期
        BigDecimal retailAmount=new BigDecimal(orderRetailAmountArray[0]);//零售总应收
        BigDecimal parAmount=new BigDecimal(orderParAmountArray[0]);//经销商总应收
        BigDecimal totalAmount=new BigDecimal(orderTotalAmountArray[0]);//总应收

        //初始化值
        BigDecimal zero=new BigDecimal(0);
        BigDecimal retailOverdueRatio1=zero;
        BigDecimal retailOverdueRatio2=zero;
        BigDecimal retailOverdueRatio3=zero;
        BigDecimal retailOverdueRatio4=zero;
        BigDecimal retailOverdueRatio5=zero;
        BigDecimal retailOverdueRatio6=zero;

        BigDecimal retailOverdueRate1=zero;
        BigDecimal retailOverdueRate2=zero;
        BigDecimal retailOverdueRate3=zero;
        BigDecimal retailOverdueRate4=zero;
        BigDecimal retailOverdueRate5=zero;
        BigDecimal retailOverdueRate6=zero;

        BigDecimal parOverdueRatio1=zero;
        BigDecimal parOverdueRatio2=zero;
        BigDecimal parOverdueRatio3=zero;
        BigDecimal parOverdueRatio4=zero;
        BigDecimal parOverdueRatio5=zero;
        BigDecimal parOverdueRatio6=zero;

        BigDecimal parOverdueRate1=zero;
        BigDecimal parOverdueRate2=zero;
        BigDecimal parOverdueRate3=zero;
        BigDecimal parOverdueRate4=zero;
        BigDecimal parOverdueRate5=zero;
        BigDecimal parOverdueRate6=zero;

        BigDecimal totalOverdueRate1=zero;
        BigDecimal totalOverdueRate2=zero;
        BigDecimal totalOverdueRate3=zero;
        BigDecimal totalOverdueRate4=zero;
        BigDecimal totalOverdueRate5=zero;
        BigDecimal totalOverdueRate6=zero;

        BigDecimal retailOverdueRate=zero;
        BigDecimal parOverdueRate=zero;
        BigDecimal totalOverdueRate= zero;

        BigDecimal overdue1=zero;
        BigDecimal overdue2=zero;
        BigDecimal overdue3=zero;
        BigDecimal overdue4=zero;
        BigDecimal overdue5=zero;
        BigDecimal overdue6=zero;

        retailOverdueRatio1= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue1,retailOverdue,4));//零售逾期占比1
        retailOverdueRatio2= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue2,retailOverdue,4));//零售逾期占比2
        retailOverdueRatio3= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue3,retailOverdue,4));//零售逾期占比3
        retailOverdueRatio4= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue4,retailOverdue,4));//零售逾期占比4
        retailOverdueRatio5= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue5,retailOverdue,4));//零售逾期占比5
        retailOverdueRatio6= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue6,retailOverdue,4));//零售逾期占比6

        parOverdueRatio1= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue1,parOverdue,4));//经销商逾期占比1
        parOverdueRatio2= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue2,parOverdue,4));//经销商逾期占比2
        parOverdueRatio3= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue3,parOverdue,4));//经销商逾期占比3
        parOverdueRatio4= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue4,parOverdue,4));//经销商逾期占比4
        parOverdueRatio5= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue5,parOverdue,4));//经销商逾期占比5
        parOverdueRatio6= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue6,parOverdue,4));//经销商逾期占比6

        retailOverdueRate= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue,retailAmount,4));//计算零售逾期率0
        retailOverdueRate1= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue1,retailAmount,4));//计算零售逾期率1
        retailOverdueRate2= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue2,retailAmount,4));//计算零售逾期率2
        retailOverdueRate3= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue3,retailAmount,4));//计算零售逾期率3
        retailOverdueRate4= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue4,retailAmount,4));//计算零售逾期率4
        retailOverdueRate5= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue5,retailAmount,4));//计算零售逾期率5
        retailOverdueRate6= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(retailOverdue6,retailAmount,4));//计算零售逾期率6

        parOverdueRate= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue,parAmount,4));//计算经销商逾期率0
        parOverdueRate1= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue1,parAmount,4));//计算经销商逾期率1
        parOverdueRate2= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue2,parAmount,4));//计算经销商逾期率2
        parOverdueRate3= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue3,parAmount,4));//计算经销商逾期率3
        parOverdueRate4= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue4,parAmount,4));//计算经销商逾期率4
        parOverdueRate5= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue5,parAmount,4));//计算经销商逾期率5
        parOverdueRate6= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(parOverdue6,parAmount,4));//计算经销商逾期率6

        totalOverdueRate= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(totalOverdue,totalAmount,4));//计算总逾期率0
        totalOverdueRate1= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[1]),totalAmount,4));//计算总逾期率1
        totalOverdueRate2= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[2]),totalAmount,4));//计算总逾期率2
        totalOverdueRate3= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[3]),totalAmount,4));//计算总逾期率3
        totalOverdueRate4= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[4]),totalAmount,4));//计算总逾期率4
        totalOverdueRate5= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[5]),totalAmount,4));//计算总逾期率5
        totalOverdueRate6= BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[6]),totalAmount,4));//计算总逾期率6

        overdue1=BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[1]),totalOverdue,4));//逾期1-7占比
        overdue2=BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[2]),totalOverdue,4));//逾期8-15占比
        overdue3=BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[3]),totalOverdue,4));//逾期16-30占比
        overdue4=BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[4]),totalOverdue,4));//逾期31-60占比
        overdue5=BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[5]),totalOverdue,4));//逾期61-90占比
        overdue6=BigDecimalUtils.multiplyPercent(BigDecimalUtils.divide(new BigDecimal(orderTotalOverdueArray[6]),totalOverdue,4));//逾期90+占比

        //更新monthlyOverduesVo各个属性值
        vo.setCensusMonth(censusMonth);//统计月份
        vo.setRetailOverdue(retailOverdue);//零售逾期
        vo.setParOverdue(parOverdue);//经销商逾期
        vo.setTotalOverdue(totalOverdue);//总逾期
        vo.setRetailAmount(retailAmount);//零售总应收
        vo.setParAmount(parAmount);//经销商总应收
        vo.setTotalAmount(totalAmount);//总应收
        vo.setRetailOverdueRate(retailOverdueRate);//零售逾期率
        vo.setParOverdueRate(parOverdueRate);//经销商逾期率
        vo.setTotalOverdueRate(totalOverdueRate);//总逾期率
        vo.setOverdue1(overdue1);//逾期1-7占比
        vo.setOverdue2(overdue2);//逾期8-15占比
        vo.setOverdue3(overdue3);//逾期16-30占比
        vo.setOverdue4(overdue4);//逾期31-60占比
        vo.setOverdue5(overdue5);//逾期61-90占比
        vo.setOverdue6(overdue6);//逾期90+占比

        //零售逾期
        vo.setRetailOverdue1(retailOverdue1);
        vo.setRetailOverdue2(retailOverdue2);
        vo.setRetailOverdue3(retailOverdue3);
        vo.setRetailOverdue4(retailOverdue4);
        vo.setRetailOverdue5(retailOverdue5);
        vo.setRetailOverdue6(retailOverdue6);
        //经销商逾期
        vo.setParOverdue1(parOverdue1);
        vo.setParOverdue2(parOverdue2);
        vo.setParOverdue3(parOverdue3);
        vo.setParOverdue4(parOverdue4);
        vo.setParOverdue5(parOverdue5);
        vo.setParOverdue6(parOverdue6);
        //零售逾期占比
        vo.setRetailOverdueRatio1(retailOverdueRatio1);
        vo.setRetailOverdueRatio2(retailOverdueRatio2);
        vo.setRetailOverdueRatio3(retailOverdueRatio3);
        vo.setRetailOverdueRatio4(retailOverdueRatio4);
        vo.setRetailOverdueRatio5(retailOverdueRatio5);
        vo.setRetailOverdueRatio6(retailOverdueRatio6);
        //零售逾期率
        vo.setRetailOverdueRate1(retailOverdueRate1);
        vo.setRetailOverdueRate2(retailOverdueRate2);
        vo.setRetailOverdueRate3(retailOverdueRate3);
        vo.setRetailOverdueRate4(retailOverdueRate4);
        vo.setRetailOverdueRate5(retailOverdueRate5);
        vo.setRetailOverdueRate6(retailOverdueRate6);
        //经销商逾期占比
        vo.setParOverdueRatio1(parOverdueRatio1);
        vo.setParOverdueRatio2(parOverdueRatio2);
        vo.setParOverdueRatio3(parOverdueRatio3);
        vo.setParOverdueRatio4(parOverdueRatio4);
        vo.setParOverdueRatio5(parOverdueRatio5);
        vo.setParOverdueRatio6(parOverdueRatio6);
        //经销商逾期率
        vo.setParOverdueRate1(parOverdueRate1);
        vo.setParOverdueRate2(parOverdueRate2);
        vo.setParOverdueRate3(parOverdueRate3);
        vo.setParOverdueRate4(parOverdueRate4);
        vo.setParOverdueRate5(parOverdueRate5);
        vo.setParOverdueRate6(parOverdueRate6);
        //总逾期率
        vo.setTotalOverdueRate1(totalOverdueRate1);
        vo.setTotalOverdueRate2(totalOverdueRate2);
        vo.setTotalOverdueRate3(totalOverdueRate3);
        vo.setTotalOverdueRate4(totalOverdueRate4);
        vo.setTotalOverdueRate5(totalOverdueRate5);
        vo.setTotalOverdueRate6(totalOverdueRate6);
    }


    /**
     * @Title:
     * @Description: 每月定位统计逾期数据
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    @Override
    public void analyseMonthlyOverdue() {
        // 获取上个月的月份
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date beforeTime = calendar.getTime();
        // 日期格式为YYYYMM
        String searchMonth = DateUtils.dateToStr(beforeTime, DateUtils.formatStr_yyyyMM_NO);
        //  获取本月的第一天
        Calendar lastCalendar = Calendar.getInstance();
        lastCalendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,日期为本月第一天
        String lastDayStr = DateUtils.dateToStr(lastCalendar.getTime(), DateUtils.formatStr_yyyyMMdd);
        // 每月逾期率统计
        monthlyOverdueCensus(searchMonth);
        // 月度租金到账率统计分析
        monthlyRentCensus(DateUtils.strToDate(lastDayStr, DateUtils.formatStr_yyyyMMdd), searchMonth);
    }

    /**
     * @Title:
     * @Description: 每月逾期率统计
     * @param searchMonth 上月的月份
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    private void monthlyOverdueCensus(String searchMonth) {
        MonthlyOverdueVo monthlyOverdueVo = new MonthlyOverdueVo();
        monthlyOverdueVo.setCensusMonth(searchMonth);
        // 零售总应收
        List<String> companyTypeList = new ArrayList<>();
        companyTypeList.add(CompanyType.person.getType());
        companyTypeList.add(CompanyType.comp.getType());
        monthlyOverdueVo.setRetailAmount(getSumPrincipal(companyTypeList));
        // 经销商总应收
        companyTypeList = new ArrayList<>();
        companyTypeList.add(CompanyType.sale.getType());
        monthlyOverdueVo.setParAmount(getSumPrincipal(companyTypeList));
        // 总应收
        monthlyOverdueVo.setTotalAmount(getSumPrincipal(null));
        // 本次处理需要新增的数据
        List<MonthlyOverdue> addMonthlyOverdueList = new ArrayList<>();
        // 逾期1-7
        addMonthlyOverdueList.add(getMonthlyOverdue(1, 7, monthlyOverdueVo, OverdueTypeEnums.ONE_SEVEN.getType()));
        // 逾期8-15
        addMonthlyOverdueList.add(getMonthlyOverdue(8, 15, monthlyOverdueVo, OverdueTypeEnums.EIGHT_FIFTEEN.getType()));
        // 逾期16-30
        addMonthlyOverdueList.add(getMonthlyOverdue(16, 30, monthlyOverdueVo, OverdueTypeEnums.SIXTEEN_THIRTY.getType()));
        // 逾期31-60
        addMonthlyOverdueList.add(getMonthlyOverdue(31, 60, monthlyOverdueVo, OverdueTypeEnums.THIRTY_ONE_SIXTY.getType()));
        // 逾期60-90
        addMonthlyOverdueList.add(getMonthlyOverdue(61, 90, monthlyOverdueVo, OverdueTypeEnums.SIXTY_NINETY.getType()));
        // 逾期90+
        addMonthlyOverdueList.add(getMonthlyOverdue(91, null, monthlyOverdueVo, OverdueTypeEnums.NINETY_GREATER.getType()));
        // 合计数据
        addMonthlyOverdueList.add(getMonthlyOverdue(null, null, monthlyOverdueVo, OverdueTypeEnums.TOTAL.getType()));
        // 保存数据
        monthlyOverdueRepository.insertDataList(addMonthlyOverdueList);
    }

    /**
     * @Title:
     * @Description: 根据条件，获取逾期客户的剩余未还本金合计
     * @param minOverdueDay 最小逾期天数
     * @param maxOverdueDay 最大逾期天数
     * @param monthlyOverdueVo 数据
     * @param overdueType 逾期类型
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    private MonthlyOverdue getMonthlyOverdue(Integer minOverdueDay, Integer maxOverdueDay, MonthlyOverdueVo monthlyOverdueVo, String overdueType) {
        MonthlyOverdue monthlyOverdue = new MonthlyOverdue();
        // 取得零售逾期
        List<String> companyTypeList = new ArrayList<>();
        companyTypeList.add(CompanyType.person.getType());
        companyTypeList.add(CompanyType.comp.getType());
        monthlyOverdue.setRetailOverdue(getOverdueSumPrincipal(companyTypeList, minOverdueDay, maxOverdueDay));
        // 取得经销商逾期
        companyTypeList = new ArrayList<>();
        companyTypeList.add(CompanyType.sale.getType());
        monthlyOverdue.setParOverdue(getOverdueSumPrincipal(companyTypeList, minOverdueDay, maxOverdueDay));
        // 取得总逾期
        monthlyOverdue.setTotalOverdue(getOverdueSumPrincipal(null, minOverdueDay, maxOverdueDay));
        // 零售总应收
        monthlyOverdue.setRetailAmount(monthlyOverdueVo.getRetailAmount());
        // 经销商总应收
        monthlyOverdue.setParAmount(monthlyOverdueVo.getParAmount());
        // 总应收
        monthlyOverdue.setTotalAmount(monthlyOverdueVo.getTotalAmount());
        // 月份
        monthlyOverdue.setCensusMonth(monthlyOverdueVo.getCensusMonth());
        // 生成日期
        monthlyOverdue.setAnalyseTime(new Date());
        // 逾期类型
        monthlyOverdue.setOverdueType(overdueType);
        return monthlyOverdue;
    }

    /**
     * @Title:
     * @Description: 根据条件，获取逾期客户的剩余未还本金合计
     * @param companyTypeList 申请类型1
     * @param minOverdueDay 最小逾期天数
     * @param maxOverdueDay 最大逾期天数
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    private BigDecimal getOverdueSumPrincipal(List<String> companyTypeList, Integer minOverdueDay, Integer maxOverdueDay) {
        MonthlyOverdueVo monthlyOverdueVo = new MonthlyOverdueVo();
        monthlyOverdueVo.setCompanyTypeList(companyTypeList); // 申请类型1
        monthlyOverdueVo.setMinOverdueDay(minOverdueDay); // 最小逾期天数
        monthlyOverdueVo.setMaxOverdueDay(maxOverdueDay); // 最大逾期天数
        BigDecimal sumPrincipal = contRepaySkedRepository.selectOverdueSumPrincipalByCompanyType(monthlyOverdueVo);
        if (sumPrincipal == null) {
            return BigDecimal.ZERO;
        }
        return sumPrincipal;
    }

    /**
     * @Title:
     * @Description: 根据条件，获取客户的剩余未还本金合计
     * @param companyTypeList 申请类型1
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    private BigDecimal getSumPrincipal(List<String> companyTypeList) {
        BigDecimal sumPrincipal = contRepaySkedRepository.selectSumPrincipalByCompanyType(companyTypeList);
        if (sumPrincipal == null) {
            return BigDecimal.ZERO;
        }
        return sumPrincipal;
    }

    /**
     * @Title:
     * @Description: 月度租金到账率统计分析
     * @param lastDay 本月的第一天
     * @param searchMonth 上月的月份
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    private void monthlyRentCensus(Date lastDay, String searchMonth) {
        // 查询本月应收金额信息
        ContRepaySkedVo contRepaySkedVo = new ContRepaySkedVo();
        contRepaySkedVo.setRepayDate(lastDay); // 还款日期（本月月初时间）
        List<String> repayStatusList = new ArrayList<>();
        repayStatusList.add(RepayStatusEnums.TO_BE_WITHHELD.getType()); // 待扣款
        repayStatusList.add(RepayStatusEnums.WITHDRAWING.getType()); // 扣款中
        repayStatusList.add(RepayStatusEnums.WITHDRAWING_FAILURE.getType()); // 失败
        contRepaySkedVo.setRepayStatusList(repayStatusList); // 扣款状态集合
        // 获取累计逾期应收金额合计以及客户数
        MonthlyRentVo monthlyRentVo = contRepaySkedRepository.selectOverdueSumRentAndCount(contRepaySkedVo);
        // 本次新增的数据
        MonthlyRent addMonthlyRent = new MonthlyRent();
        addMonthlyRent.setCensusMonth(DateUtils.dateToStr(new Date(), DateUtils.formatStr_yyyyMM_NO)); // 本月月份
        addMonthlyRent.setOverdueRent(monthlyRentVo.getOverdueRent()); // 累计逾期金额
        addMonthlyRent.setOverdueCount(monthlyRentVo.getOverdueCount()); // 累计逾期客户数
        // 保存本月新增的数据
        monthlyRentRepository.insertData(addMonthlyRent);
        // 获取上个月的统计数据
        MonthlyRent updMonthlyRent = findMonthlyRentByCensusMonth(searchMonth);
        if (updMonthlyRent == null) {
            // 取得数据为空的场合
            updMonthlyRent = new MonthlyRent();
            updMonthlyRent.setCensusMonth(searchMonth); // 统计的月份
        }
        //获取上月的累计逾期实收金额信息
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastDay);
        calendar.add(Calendar.MONTH, -1);
        contRepaySkedVo.setRepayDate(calendar.getTime()); // 还款日期(上月初的时间)
        contRepaySkedVo.setSearchMonth(searchMonth); // 查询月份
        contRepaySkedVo.setRepayStatusList(null); // 扣款状态集合
        // 获取累计逾期实收金额合计以及客户数
        MonthlyRentVo overdueReceiptVo = contRepaySkedRepository.selectOverdueSumRentAndCount(contRepaySkedVo);
        updMonthlyRent.setOverdueReceipt(overdueReceiptVo.getOverdueRent()); // 累计逾期实收金额
        updMonthlyRent.setOverdueReCount(overdueReceiptVo.getOverdueCount()); // 累计逾期实收客户数
        // 取得本月应收金额及合同个数
        contRepaySkedVo.setSearchMonth(searchMonth); // 查询月份
        contRepaySkedVo.setRepayStatusList(null); // 扣款状态集合
        contRepaySkedVo.setRepayDate(null); // 还款日期
        MonthlyRentVo monthRentVo = contRepaySkedRepository.selectSumRentAndCountByMonth(contRepaySkedVo);
        updMonthlyRent.setMonthRent(monthRentVo.getMonthRent()); // 本月应收金额
        updMonthlyRent.setMonthCount(monthRentVo.getMonthCount()); // 本月应收客户数
        // 获取本月实收金额及客户个数
        repayStatusList = new ArrayList<>();
        repayStatusList.add(RepayStatusEnums.WITHDRAWING_SUCCESS.getType()); // 成功
        repayStatusList.add(RepayStatusEnums.PREPAYMENT.getType()); // 已提前结清
        contRepaySkedVo.setRepayStatusList(repayStatusList); // 扣款状态集合
        contRepaySkedVo.setSearchMonth(searchMonth); // 查询月份
        MonthlyRentVo monthReceiptVo = contRepaySkedRepository.selectSumRentAndCountByMonth(contRepaySkedVo);
        updMonthlyRent.setReceiptAmount(monthReceiptVo.getMonthRent()); // 本月实收金额
        updMonthlyRent.setReceiptCount(monthReceiptVo.getMonthCount()); // 本月实收客户数
        if (StringUtils.isNotTrimBlank(updMonthlyRent.getMonthlyRentId())) {
            // 更新数据
            monthlyRentRepository.updateByPrimaryKeySelectiveData(updMonthlyRent);
        } else {
            // 新增数据
            updMonthlyRent.setOverdueRent(updMonthlyRent.getOverdueReceipt()); // 累计逾期金额
            updMonthlyRent.setOverdueCount(updMonthlyRent.getOverdueReCount()); // 累计逾期客户数
            monthlyRentRepository.insertData(updMonthlyRent);
        }
    }

    /**
     * @Title:
     * @Description: 根据统计月份，获取月度租金到账率数据
     * @param censusMonth 月份
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    private MonthlyRent findMonthlyRentByCensusMonth(String censusMonth) {
        Example example = new Example(MonthlyRent.class);
        example.createCriteria().andEqualTo("censusMonth", censusMonth);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return monthlyRentRepository.selectOneByExample(example);

    }

    /**
     * @Title:
     * @Description:  模板出excel
     * @param httpServletResponse,monthlyOverduesVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 03:06:04
     */
    public void excelExport(HttpServletResponse httpServletResponse , MonthlyOverduesVo monthlyOverduesVo){
        monthlyOverduesVo.setPageFlag(PageFlags.NOT_PAGE.getFlag());
        PageInfoExtend<MonthlyOverduesVo> pageInfo=this.findMonthlyOverduesVosByPage(monthlyOverduesVo);//根据查询条件查出需要导出的数据
        List<MonthlyOverduesVo> dataList = pageInfo.getData();//获取查询结果

        //获取模板
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey(TplTypeKeyEnums.MONTHLY_OVERDUE.getType())); //模板key需要用枚举
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成文件失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,生成文件失败");
        }
        //生成excel
        try{
            String fileName = sysTplType.getTplTypeName();
            OutputStream outputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + ExcelUtils.getExcelName(new String(new String(fileName.getBytes("gb2312"), "iso8859-1"))));
            monthlyOverdueExcelExportService.monthlyOverdueExport(sysTplType,dataList,outputStream);
        }catch (Exception ex){
            ex.printStackTrace();
//            log.error(ex.getMessage());
            throw new FmsServiceException("生成excel失败");
        }
    }

}