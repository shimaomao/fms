package cn.com.leadu.fms.common.util;

/**
 * @description:
 * @author:qianh .
 * @since:2017/11/18
 */
public class RandomUtils {

    /**
     * @Title: getRandNum
     * @Description:按区间产生随机数
     * @param min
     * @param max
     * @return int
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/18 02:24:47
     */
	public static int getRandNum(int min, int max) {
		int randNum = min + (int) (Math.random() * ((max - min) + 1));
		return randNum;
	}

    /**
     * @Title: getSixRandomCode
     * @Description:产生6位随机验证码
     * @param
     * @return java.lang.String
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/18 02:24:23
     */
	public static String getSixRandomCode() {
		return String.valueOf(getRandNum(100000, 999999));
	}
}
