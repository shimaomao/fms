package cn.com.leadu.fms.common.annotation;

import cn.com.leadu.fms.common.util.DateUtils;

import java.lang.annotation.*;

/**
 * @author qiaomengnan
 * @ClassName: ExcelImportTitle
 * @Description: excel导入时用的注解
 * @date 2018/5/9
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelImportTitle {

    String value() default "";

    int sort() default 0;

    String [] dateFormats() default {DateUtils.formatStr_yyyyMMddHHmmss};

}
