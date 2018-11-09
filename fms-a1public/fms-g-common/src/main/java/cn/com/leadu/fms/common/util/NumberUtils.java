package cn.com.leadu.fms.common.util;

import java.math.BigDecimal;

/**
 * Created by qiaohao on 2017/9/11.
 */
public class NumberUtils {

    public static boolean equals(Integer val1, Integer val2) {
        return val1 == null?val2 == null:val1.equals(val2);
    }

    public static boolean equals(Long val1, Long val2){
        return val1 == val2;
    }

    public static boolean notEquals(Integer val1, Integer val2) {
        return !equals(val1,val2);
    }

    public static boolean notEquals(Long val1, Long val2){
        return !equals(val1,val2);
    }

    /**
     * double 四舍五入
     * @param v
     * @return
     */
    public static double round2(double v) {return (new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue();}

    public static double round0(double v) {

        return (new BigDecimal(v).setScale(0, BigDecimal.ROUND_HALF_UP)).doubleValue();
    }
    public static double round4(double v) {

        return (new BigDecimal(v).setScale(4, BigDecimal.ROUND_HALF_UP)).doubleValue();
    }

    public static double formatDouble(double v, int scale) {

        return (new BigDecimal(v).setScale(scale, BigDecimal.ROUND_HALF_UP)).doubleValue();
    }

}
