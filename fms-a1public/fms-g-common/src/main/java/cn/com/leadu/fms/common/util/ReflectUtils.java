package cn.com.leadu.fms.common.util;

import cn.com.leadu.fms.common.exception.FmsServiceException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ReflectUtils
 * @Description: 反射工具类
 * @date 2018/5/23
 */
@Slf4j
public class ReflectUtils {


    public static String getMethodGetName(Field field){
        field.setAccessible(true);
        return "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
    }

    public static String getMethodSetName(Field field){
        field.setAccessible(true);
        return "set" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
    }

    public static Method getMethodGet(Field field,Class clazz) throws NoSuchMethodException {
        return clazz.getMethod(getMethodGetName(field));
    }

    public static Method getMethodSet(Field field,Class clazz) throws NoSuchMethodException {
        return clazz.getMethod(getMethodSetName(field),field.getType());
    }

    public static Field getField(String fieldName , Class clazz) throws NoSuchFieldException {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field;
    }

    public static Object getFieldValue(String fieldName,Object param,Class clazz) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field field = getField(fieldName,clazz);
        Method method = getMethodGet(field,clazz);
        return method.invoke(param);
    }

    public static Object getFieldValue(String fieldName,Object data) {
       try {
           Class clazz = data.getClass();
           Field field = getField(fieldName, clazz);
           Method method = getMethodGet(field, clazz);
           return method.invoke(data);
       }catch (Exception ex){
           log.error(ex.getMessage());
           ex.printStackTrace();
           return null;
       }
    }


    public static <T> T setObjectValue(T data,String key,String value){
        try {
            Class clazz = data.getClass();
            Field field = ReflectUtils.getField(key, data.getClass());
            Method method = ReflectUtils.getMethodSet(field, clazz);
            method.invoke(data, getValue(field,value));
            return data;
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }


    private static Object getValue(Field field,String value){
        try {
            if(StringUtils.isTrimBlank(value))
                return null;
            if (field.getType() == Integer.class)
                return Integer.valueOf(value);
            else if (field.getType() == Double.class)
                return Double.valueOf(value);
            else if (field.getType() == Float.class)
                return Float.valueOf(value);
            else if (field.getType() == BigDecimal.class)
                return new BigDecimal(value);
            else if (field.getType() == String.class)
                return value;
            else
                throw new FmsServiceException(field.getDeclaringClass() + "值类型还未定义");
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("值转换失败");
        }
    }

}
