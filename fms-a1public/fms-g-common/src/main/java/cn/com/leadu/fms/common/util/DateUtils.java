package cn.com.leadu.fms.common.util;

import cn.com.leadu.fms.common.constant.enums.prebiz.RentPayModeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by qiaohao on 2017/9/15.
 */
public class DateUtils {
    public static final String formatStr_yyyyMMddHHmmssS_ = "yyyyMMddHHmmss";
    public static final String formatStr_yyyyMMddHHmmssS = "yyyy-MM-dd HH:mm:ss.S";
    public static final String formatStr_yyyyMMddHHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String formatStr_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String formatStr_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
    public static final String formatStr_yyyyMMddHH = "yyyy-MM-dd HH";
    public static final String formatStr_yyyyMMdd_bias = "yyyy/MM/dd";
    public static final String formatStr_yyyyMMdd = "yyyy-MM-dd";
    public static final String formatStr_yyyyMM = "yyyy-MM";
    public static final String formatStr_yyyyMM_NO = "yyyyMM";
    public static final String formatStr_yyyyMMd_NO = "yyyyMMdd";
    public static final String formatStr_HHmmss = "HH:mm:ss";
    public static final String formatStr_yyyy = "yyyy";
    public static final String formatStr_yyyyMMddDelimiter = "-";
    public static final String formatStr_dd = "dd";
    public static final String formatStr_yyyymm = "yyyy.MM";
    public static final String formatStr_mm = "MM";
    public static final String formatStr_yyyyMMddChinese = "yyyy年MM月dd日";
    public static final String max_date_str = "20991231235959";


    public static Date getNowDate(){
        return new Date();
    }

    public static String getNowDateStr(String format){
        if(StringUtils.isTrimBlank(format))
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(getNowDate());
    }

    public static String dateToStr(Date date,String format){
        if(date == null || StringUtils.isTrimBlank(format))
            return null;
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date strToDate(String dateStr,String format)  {
        if(StringUtils.isContainTrimBlank(dateStr,format))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 当前日
     * @return
     */
    public static String getCurrentDay() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("dd").format(ts);
    }
    /**
     * 当前月的 下12个的数组
     * @return
     */
    public static String getNextMonth() {
        String ret = new String();
        int nextYear = Integer.parseInt(getCurrentYear());;
        int nextMonth =Integer.parseInt(getCurrentMonth());

        nextMonth++;
        if (nextMonth > 12) {
            nextYear++;
            nextMonth = 1;
        }
        String mth = "";
        if(nextMonth<10){
            mth="0"+nextMonth;
        }else{
            mth=nextMonth+"";
        }
        ret= new String(String.valueOf(nextYear) + mth);

        return ret;
    }
    /**
     * 当前月
     * @return
     */
    public static String getCurrentMonth() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("MM").format(ts);
    }
    /**
     * 当前年
     * @return
     */
    public static String getCurrentYear() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy").format(ts);
    }
    /*
	 * 根据date类日期返回yyyymmdd类型的日期
	 *
	 */
    public static String getStringDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc
                .get(Calendar.DATE));
        return sdf.format(gc.getTime());
    }

    /*
	 * 根据date类日期返回指定格式的类型的日期
	 *
	 */
    public static String getStringDate(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc
                .get(Calendar.DATE));
        return sdf.format(gc.getTime());
    }

    /**
     * @Title: getCurrentDateString
     * @Description:获取当前时间字符串(yyyMMdd)
 *          eg:20170918
     * @param
     * @return java.lang.String
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/17 11:17:04
     */
    public static String getCurrentDateString() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMdd").format(ts);
    }
    /**
     * 获取当前时间 HHmmss
     */
    public static String getCurrentTime() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String currentTime = new SimpleDateFormat("HHmmss").format(ts);
        return currentTime;
    }


    /**
     * @Title: currentDateInRange
     * @Description:
     * @param stDate
     * @param endDate
     * @return boolean
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/17 11:22:48
     */
    public static boolean currentDateInRange(Integer stDate,Integer endDate) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(ts);
        if(currentDate == null || "".equals(currentDate)){
            return false;
        }
        return (Integer.valueOf(currentDate)>=stDate && Integer.valueOf(currentDate)<=endDate)?true:false;
    }

    /** 
    * @Description:  修改日期的月份,zl>0增加,zl<0减少 zl增加几个月 (1月31号加一月，会自动调整为2月28号或29号)
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/14 10:40
    */ 
    public static Date getAddMonth(Date startDate, int zl) {
        Calendar cal = null;
        cal = getCalendar(startDate);
        cal.add(Calendar.MONTH, zl);
        return cal.getTime();
    }

    /**
     * @Title:
     * @Description:   在指定日期上添加指数定天
     * @param date 日期
     * @param day 天数
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 11:47:10
     */
    public static Date getAddDay(Date date, Integer day){
        if(date != null && day != null) {
            Calendar calendar = getCalendar(date);
            if(calendar != null) {
                calendar.add(Calendar.DATE, day);
                return calendar.getTime();
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   在指定日期上添加指数定天
     * @param date 日期
     * @param day 天数
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 11:47:10
     */
    public static Date getAddDay(Date date, String day){
        if(date != null && StringUtils.isNotTrimBlank(day)) {
            return getAddDay(date,new Integer(day));
        }
        return null;
    }

//    public static void main(String [] args){
//
//        try {
//            System.out.println(DateUtils.dateToStr(getAddDay(strToDate("2018-02-28",formatStr_yyyyMMdd),new Integer(1)),formatStr_yyyyMMdd));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        ;
//
//    }



    /*
	 * 把Date转化成Calendar
	 */
    public static Calendar getCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }
    /*
	 * 根据string 类型日期返回date类
	 */
    public static Date getDateForString(String day) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date = sdf.parse(day);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /*
* 根据string 类型日期返回date类,格式为yyyyMMddHHmmss
*/
    public static Date getDateTime(String dateStr)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date=sdf.parse(dateStr);
            return  date;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @Title:  得到当前系统日期 :
     * @Description:   当前日期的格式字符串,日期格式为"yyyy-MM-dd HH:mi:ss"
     * @param
     * @return
     * @throws
     *
     * @author chenshunhua
     * @date 2017/11/22 03:10:32
     */
    public static String getCurrentDateTime() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date today = new Date();
        String tString = df.format(today);
        return tString;
    }

    public static  int getYear(String date1, String date2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int resYear = 0;
        try {
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(sdf.parse(date1));
            aft.setTime(sdf.parse(date2));
            resYear = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR));
            int month = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            if(month > 0){
                // 不足一年按照一年计算
                resYear = resYear + 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resYear;
    }
    /**
     * <li>功能描述：时间相减得到月数【yyyyMMdd】
     * @param date1 被减日期
     * @param date2 日期
     * @return
     * long          月数
     * @author Administrator
     */
    public static int getMonth(String date1, String date2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int resMonth = 0;
        try {
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(sdf.parse(date1));
            aft.setTime(sdf.parse(date2));
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            resMonth = Math.abs(month + result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resMonth;
    }
    /**
     * <li>功能描述：时间相减得到天数
     * @param date1 被减日期
     * @param date2 日期
     * @return
     * long          月数
     * @author Administrator
     */
    public static int getDay(Date date1,Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
    /**
     * 某年 某月中最大的天数
     * @param year
     * @param mon
     * @return
     */
    public static int getMaxDayOfMonth(int year, int mon) {
        int dqnd = year;
        int dqyd = mon;
        String dqydstr="";
        if (dqyd == 12) {
            dqnd++;
            dqyd = 1;
        } else {
            dqyd++;
        }
        if(dqyd<10){
            dqydstr="0"+dqyd;
        }else{
            dqydstr=dqyd+"";
        }
        java.sql.Date xydyt = java.sql.Date.valueOf(dqnd + "-" + dqydstr + "-01");
        Timestamp ts = new Timestamp(xydyt.getTime() - 86400000L);
        String day = new SimpleDateFormat("dd").format(ts);
        return Integer.parseInt(day);
    }

    //得到当前日期对应的下个月日期 如果下个月没有这天 则取最后一天
    public static String getNextDayByDay(String month,int day){
        String hkday=month+(day<10?"0"+day:(day+""));
        int maxdayofmonth= DateUtils.getMaxDayOfMonth(Integer.parseInt(month.substring(0, 4)),Integer.parseInt(month.substring(4, 6)));//当前月份的最大天数
        if(maxdayofmonth<day){
            hkday=month+(maxdayofmonth<10?"0"+maxdayofmonth:(maxdayofmonth+""));
        }
        return hkday;
    }

    public static String getDqsj(Date data){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(data);
    }
    //根据当前日期和还款日取得首期还款日期-期初支付
    public static String getFirstDateEndMode(String repayDay){
        String skmonth= DateUtils.getNextMonth();//下个收款月份
        return DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));
    }


    //根据当前日期和还款日取得首期还款日期-期末支付
    public static String getFirstDateBeginMode(String repayDay){
        String skmonth;
        if(Integer.valueOf(repayDay) > Integer.valueOf(DateUtils.getCurrentDay())){
            skmonth= DateUtils.getNowDateStr(DateUtils.formatStr_yyyy + DateUtils.formatStr_dd);//当月
        }else{
            skmonth= DateUtils.getNextMonth();//下个收款月份
        }
        return DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));
    }

    //根据当前日期是否最后一天
    public static boolean isEndOfMonth(Date date){
        Date nextDay = getAddDay(date,1);
        if(!dateToStr(nextDay,formatStr_mm).equals(dateToStr(date,formatStr_mm))){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param benchmarkDate
     * @param repayDay
     * @param period
     * @param rentPayMode
     * @Description: 获取每期还款日期
     * @param: benchmarkDate: 基准日期
     * @param: repayDay：还款日
     * @param: period：期数
     * @param: rentPayMode：支付模式
     * @return: java.lang.String
     * @Author: yangyiquan
     * @Date: 2018/7/13 19:26
     */
    public static String getRepayDate(Date benchmarkDate, String repayDay, int period, String rentPayMode) {
        if(period<=0){
            throw new FmsServiceException("期数必须大于0");
        }
        if(benchmarkDate == null){//基准日期
            benchmarkDate = new Date();
        }
        String skmonth;//当前还款月,String格式
        String repayDate;//每期还款日
        Date firstMonth;//首期还款月
        Date curMonth;//当前还款月
        //根据规则得出首期还款月
        if(RentPayModeEnums.BEGIN_PAY.getType().equals(rentPayMode)){//期末支付
            firstMonth = DateUtils.getAddMonth(benchmarkDate, 1);
        } else {//期初支付
            Calendar calendar = DateUtils.getCalendar(benchmarkDate);
            if(Integer.valueOf(repayDay) > calendar.get(Calendar.DAY_OF_MONTH)){// 还款日 >基准日期的日
                firstMonth = benchmarkDate;//当月
            }else{
                firstMonth = DateUtils.getAddMonth(benchmarkDate, 1);//下个收款月份
            }
        }

        curMonth = DateUtils.getAddMonth(firstMonth, period-1);//得到当前还款月

        skmonth = DateUtils.dateToStr(curMonth, DateUtils.formatStr_yyyy)+DateUtils.dateToStr(curMonth, DateUtils.formatStr_mm);//还款月（yyyyMM）

        repayDate=DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));//得到还款日期（yyyyMMdd）
        return repayDate;
    }

    /*
    * 取得最大日期 2099-12-31 23:59:59
    */
    public static Date getMaxDate(){
        return getDateTime(max_date_str);
    }

}
