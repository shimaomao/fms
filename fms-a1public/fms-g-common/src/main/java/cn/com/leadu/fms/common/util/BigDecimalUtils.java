package cn.com.leadu.fms.common.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by wangxue on 2018/4/17.
 */
@Slf4j
public class BigDecimalUtils {

    public static final String PERMUL = "1";//乘100
    public static final String PERDIV = "2";//除100
    public static final String PERNO = "0";//不做处理

    /**
     * @Title:
     * @Description: 返回100
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 20:26
     */
    public static BigDecimal getPercent(){
        return new BigDecimal("100.0");
    }

    /**
     * @Fields  : 返回0
     * @author qiaomengnan
     */
    public static BigDecimal getZero(){
        return new BigDecimal("0");
    }

    /***
     * 计算Value除以100的商
     * @param value 被除数
     * @return 商
     * */
    public static BigDecimal dividePercent(BigDecimal value) {
        return divide(value, getPercent(), 4);
    }

    /***
     * 计算Value除以100的商
     * @param value 被除数
     * @return 商
     * */
    public static BigDecimal dividePercent6(BigDecimal value) {
        return divide(value, getPercent(), 6);
    }

    /***
     * 计算Value除以divisor的商
     * @param value 被除数
     * @param divisor 除数
     * @return 商
     * */
    public static BigDecimal divide(BigDecimal value, BigDecimal divisor, int scale) {
        if (value == null || divisor == null || divisor.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return value.divide(divisor, scale, BigDecimal.ROUND_HALF_UP);
        } catch (ArithmeticException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            return BigDecimal.ZERO;
        }
    }
    /***
     * 计算Value除以divisor的商(向上取整)
     * @param value 被除数
     * @param divisor 除数
     * @return 商
     * */
    public static BigDecimal divideRoundUp(BigDecimal value, BigDecimal divisor) {
        if (value == null || divisor == null || divisor.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return value.divide(divisor, BigDecimal.ROUND_CEILING);
        } catch (ArithmeticException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

    /***
     * 计算Value乘上100的积(保留 两位小数)
     * @param value 被除数
     * @return 积
     * */
    public static BigDecimal multiplyPercent(BigDecimal value) {
        return multiply(value, getPercent(), 2);
    }
    /***
     * 计算Value乘上100的积(向上取整)
     * @param value
     * @return 积
     * */
    public static BigDecimal multiplyPercentRoundUp(BigDecimal value) {
        return multiplyRoundUp(value, getPercent());
    }

    /***
     * 计算Value除以divisor的商
     * @param value 被乘数
     * @param multiplier 乘数
     * @return 积
     * */
    public static BigDecimal multiply(BigDecimal value, BigDecimal multiplier, int scale) {
        if (value == null || multiplier == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal result = value.multiply(multiplier);
        return result.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * @Title:
     * @Description:   两数相乘并向上取整
     * @param value
     * @param multiplier
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/04 06:10:50
     */
    public static BigDecimal multiplyRoundUp(BigDecimal value, BigDecimal multiplier){
        if (value == null || multiplier == null) {
            return BigDecimal.ZERO;
        }
        return value.multiply(multiplier.divide(getPercent())).setScale(0,BigDecimal.ROUND_UP);
    }

    /**
     * @Title:
     * @Description:   两数相乘并向上取整(不除以100)
     * @param value
     * @param multiplier
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/06/04 06:10:50
     */
    public static BigDecimal multiplyCeil(BigDecimal value, BigDecimal multiplier){
        if (value == null || multiplier == null) {
            return BigDecimal.ZERO;
        }
        return value.multiply(multiplier).setScale(0,BigDecimal.ROUND_UP);
    }

    /**
     * @Title:
     * @Description:   判断两个值是否相等
     * @param val1
     * @param val2
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/04 06:40:06
     */
    public static boolean equal(BigDecimal val1,BigDecimal val2){
        return val1.compareTo(val2)  == 0;
    }

    /**
     * @Title:
     * @Description:   判断两个值是否不相等
     * @param val1
     * @param val2
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/04 06:40:06
     */
    public static boolean notEqual(BigDecimal val1,BigDecimal val2){
        return !equal(val1,val2);
    }

    /***
     * 比较value是否在区间内(value >= startVal and value < endVal)
     * @param value
     * @param startVal 区间开始值
     * @param endVal 区间结束值
     * @return 比较结果
     * */
    public static boolean isValueSection(BigDecimal value, BigDecimal startVal, BigDecimal endVal){
        startVal = startVal == null ? BigDecimal.ZERO : startVal;
        endVal = endVal == null ? BigDecimal.ZERO : endVal;
        value = value == null ? BigDecimal.ZERO : value;
        if (startVal.compareTo(endVal) == 0) {
            if (value.compareTo(startVal) == 0) {
                return true;
            }
            return false;
        } else {
            if (value.compareTo(startVal) >= 0 && value.compareTo(endVal) < 0) {
                return true;
            }
            return false;
        }
    }

    /**
     * @Description: 打印pdf时将0和null转换成空字符串
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/27 15:56
     */
    public static String getNotNullZeroString(BigDecimal bigDecimal){
        if(bigDecimal == null || bigDecimal.intValue() == 0){
            return "";
        }else{
            return bigDecimal.toString();
        }
    }

    /** 
    * @Description: 打印pdf时将0和null转换成0
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/29 16:35
    */ 
    public static String getNotNullString(BigDecimal bigDecimal){
        if(bigDecimal == null || bigDecimal.intValue() == 0){
            return "0";
        }else{
            return bigDecimal.toString();
        }
    }

    /** 
    * @Description: 获取bigdeciaml的值，如果是null返回0
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/7 15:14
    */ 
    public static BigDecimal getNotNullBigDecimal(BigDecimal bigDecimal){
        return bigDecimal == null ? BigDecimal.ZERO : bigDecimal;
    }

    /**
     * @Title:
     * @Description: 值相加
     * @param:  values
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/9 0009 13:06
     */
    public static BigDecimal adds(BigDecimal ...values){
        BigDecimal result = new BigDecimal("0");
        if(ArrayUtils.isNotNullAndLengthNotZero(values)){
            for(BigDecimal value : values){
                if(value != null)
                    result = result.add(value);
            }
        }
        return result;
    }

    /** 
    * @Description: 四舍五入保留两位小数
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/19 13:54
    */ 
    public static BigDecimal getRoundHalfUpValue2(BigDecimal value){
        if(value != null)
            return value.setScale(2,BigDecimal.ROUND_HALF_UP);
        return BigDecimal.ZERO;
    }

    /**
     * @Title:
     * @Description: 返回只带两位小数的值 并且不四舍五入
     * @param:  value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 20:29
     */
    public static BigDecimal getValueDoublePre(BigDecimal value){
        if(value != null)
            return value.setScale(2,BigDecimal.ROUND_DOWN);
        return null;
    }

    /**
     * @Title:
     * @Description: 返回只带两位小数的值,并转换为string 并且不四舍五入
     * @param:  value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 20:29
     */
    public static String getValueDoublePreToStr(BigDecimal value){
        if(value != null)
            return value.setScale(2,BigDecimal.ROUND_DOWN).toString();
        return null;
    }


    /**
     * @Title:
     * @Description: 返回只带两位小数的值，并逗号格式化 并且不四舍五入
     * @param:  value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 20:31
     */
    public static String getValueDoublePreToStrFormat(BigDecimal value){
        value = getValueDoublePre(value);
        if(value != null) {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            return df.format(value);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   是否大于
     * @param val1
     * @param val2
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 01:14:09
     */
    public static boolean gt(BigDecimal val1, BigDecimal val2){
        if(val1 == null || val2 == null)
            return false;
        return val1.compareTo(val2) > 0;
    }

    /**
     * @Title:
     * @Description:   是否小于等于
     * @param val1
     * @param val2
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 01:24:46
     */
    public static boolean ltEq(BigDecimal val1, BigDecimal val2){
        if(val1 == null || val2 == null)
            return false;
        return val1.compareTo(val2) < 1;
    }


}
