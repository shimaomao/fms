package cn.com.leadu.fms.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author qiaomengnan
 * @ClassName: AnnotationUtils
 * @Description: 注解工具类
 * @date 2018/3/29
 */
public class AnnotationUtils {

    /**
     * @Title:
     * @Description: 根据注解查找第一个类字段
     * @param annotation
     * @param clazz
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:02:15
     */
    public static Field findField(Class annotation,Class clazz){
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            if(field.getAnnotation(annotation) != null)
                return field;
        }
        return null;
    }


}
