package cn.com.leadu.fms.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanggang
 * @ClassName: TyGpsUtils
 * @Description:天易GPS工具类
 * @date 2018/6/22
 */
public class TyGpsUtils {

    /**
     * @Fields  : 调用返回值
     * @author yanggang
     */
    private static final Map<String,String> result=new HashMap<>();
    static {
        result.put("0","调用成功");
        result.put("1","参数错误");
        result.put("2","用户鉴权失败");
        result.put("9","其他错误");
    }
    public  static  String getResult(String key){
        return result.get(key);
    }
}
