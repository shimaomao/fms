package cn.com.leadu.fms.common.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: JsonUtils
 * @Description: json工具类
 * @date 2018/6/12
 */
public class JsonUtils {


    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @Title:
     * @Description:   对象转map
     * @param object
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/12 05:56:20
     */
    public static Map<String,String> objectToMap(Object object){
        try {
            String strJson = objectMapper.writeValueAsString(object);
            Map<String,Object> value = JSON.parseObject(strJson);
            Map<String,String> result = new HashMap<>();
            outMap(value,result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   对象集合转map
     * @param objects
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 02:34:55
     */
    public static Map<String,String> objectToMap(Object ...objects){
        Map<String,String> result = new HashMap<>();
        for(Object object : objects){
           Map<String,String> resultTmp = objectToMap(object);
           if(resultTmp != null)
               result.putAll(resultTmp);
        }
        return result;
    }


    /**
     * @Title:
     * @Description:   将嵌套map中的值 全部拿出来
     * @param value
     * @param result
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 02:31:49
     */
    private static void outMap(Map<String,Object> value,Map<String,String> result){
        if(value != null){
            for(String key : value.keySet()){
                if(value.get(key) != null) {
                    if(value.get(key) instanceof Map)
                        outMap((Map<String,Object>)value.get(key),result);
                    else {
                        result.put(key,value.get(key).toString());
                    }
                }
            }
        }
    }

}
