package cn.com.leadu.fms.common.constant;

import cn.com.leadu.fms.common.exception.FmsServiceException;

/**
 * @author qiaomengnan
 * @ClassName: ExcelTypeConstants
 * @Description: excel通用导出类型枚举
 * @date 2018/4/20
 */
public class ExcelTypeConstants {

    public static final int ONE = 1;

    public static final int TWO = 2;

    public static final int THREE = 3;

    public static final int FOUR = 4;

    public static final int FIVE = 5;

    public static final int SEX = 6;

    public static final int SEVEN = 7;

    public static final int EIGHT = 8;

    public static final int NINE = 9;

    //excel导出类型
    public static final String EXCEL_TYPE = "excelType";

    public static void checkType(int type){
        if(type != ONE && type != TWO && type != THREE && type != FOUR && type != FIVE && type != SEX && type != SEVEN && type != EIGHT && type != NINE)
            throw new FmsServiceException("excel类型不存在");
    }

}
