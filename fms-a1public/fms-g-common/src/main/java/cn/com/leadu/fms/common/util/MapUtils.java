package cn.com.leadu.fms.common.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: MapUtils
 * @Description: map工具类
 * @date 2018/4/14
 */
public class MapUtils {

    /**
     * @Title:
     * @Description: 对象强转map
     * @param:  val
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/14  16:28
     */
    public static Map getMap(Object val){
        if(val != null) {
            return (Map)val;
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 对象强转map，并取出一个值
     * @param:  val
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/14  16:28
     */
    public static String getMapValueToString(Object val,String key){
        Map map = getMap(val);
        if(map != null && map.get(key) != null) {
            return map.get(key).toString();
        }
        return null;
    }

}
