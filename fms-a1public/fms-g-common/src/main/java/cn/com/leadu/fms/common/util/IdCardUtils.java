package cn.com.leadu.fms.common.util;

import java.util.Calendar;

/**
 * Created by system on 2017/11/17.
 */
public class IdCardUtils {
    /** 中国公民身份证号码最小长度。 */
    public  final int CHINA_ID_MIN_LENGTH = 15;

    /** 中国公民身份证号码最大长度。 */
    public  final int CHINA_ID_MAX_LENGTH = 18;
    /**
     * 根据身份编号获取年龄
     *
     * @param idCard
     *            身份编号
     * @return 年龄
     */
    public static int getAgeByIdCard(String idCard) {
        int iAge = 0;
        Calendar cal = Calendar.getInstance();
        String year = idCard.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 根据身份编号获取生日
     *
     * @param idCard 身份编号
     * @return 生日(yyyyMMdd)
     */
    public static String getBirthByIdCard(String idCard) {
        return idCard.substring(6, 14);
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M-男，F-女，N-未知)
     */
    public static String getGenderByIdCard(String idCard) {
        String sGender = "N";

        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "0";//男
        } else {
            sGender = "1";//女
        }
        return sGender;
    }

    public static  void  main(String [] a){
        String idcard="460200199209275127";
        String sex= getGenderByIdCard(idcard);
        System.out.println("性别:" + sex);
        int age= getAgeByIdCard(idcard);
        System.out.println("年龄:" + age);
        String sr=getBirthByIdCard(idcard);
        System.out.println("生日:" + sr);
    }
}
