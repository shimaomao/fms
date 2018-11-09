package cn.com.leadu.fms.common.util;

/**
 * @author qiaomengnan
 * @ClassName: ObjectUtil
 * @Description:
 * @date 2018/2/28
 */
public class ObjectUtils {

    /**
     * @Title:
     * @Description:   判断数组里的对象是否全是空
     * @param objects
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/28 04:12:37
     */
    public static boolean isNull(Object ...objects){
        boolean result = true;
        for(Object object : objects){
            if(object != null) {
                //有个对象不为空 退出 结果false
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * @Title:
     * @Description:   判断数组里的对象是否不全是空
     * @param objects
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/28 04:12:37
     */
    public static boolean isNotNull(Object ...objects){
        return !isNull(objects);
    }

    /**
     * @Title:
     * @Description: 判断数组里是否包含null
     * @param: objects
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/29 0029 17:18
     */
    public static boolean containNull(Object ...objects){
        boolean result = false;
        for(Object object : objects){
            if(object == null) {
                //包含null
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @Title:
     * @Description: 判断数组里是否不包含null
     * @param: objects
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/29 0029 17:18
     */
    public static boolean notContainNull(Object ...objects){
        return !containNull(objects);
    }

}
