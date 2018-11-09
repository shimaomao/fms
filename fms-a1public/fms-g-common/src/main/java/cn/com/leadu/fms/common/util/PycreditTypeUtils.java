package cn.com.leadu.fms.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: PycreditTypeConstants
 * @Description:鹏元接口返回值对应解析
 * @date 2018/6/13
 */
public class PycreditTypeUtils {

    /**
     * @Fields  : 反欺诈查询状态描述
     * @author qiaomengnan
     */
    private static final Map<String,String>  treatResult = new HashMap<>();

    static {
        treatResult.put("1","查得");
        treatResult.put("2","未查得");
        treatResult.put("3","其它原因未查得");
    }
    public static String getTreatResult(String key){
        return treatResult.get(key);
    }
    /**
     * @Fields  : 身份认证信息-认证信息
     * @author yanggang
     */
    private static final Map<String,String>  result = new HashMap<>();

    static {
        result.put("1","一致");
        result.put("2","不一致");
    }
    public static String getResult(String key){
        return result.get(key);
    }
    /**
     * @Fields  : 手机状态
     * @author yanggang
     */
    private static final Map<String,String>  phoneStatus = new HashMap<>();

    static {
        phoneStatus.put("1","正常在用");
        phoneStatus.put("2","停机");
        phoneStatus.put("3","未启用");
        phoneStatus.put("4","已销号");
        phoneStatus.put("5","其他");
        phoneStatus.put("6","预销号");
    }
    public static String getPhoneStatus(String key){
        return phoneStatus.get(key);
    }
    /**
     * @Fields  : 运营商名称
     * @author yanggang
     */
    private static final Map<String,String>  operator = new HashMap<>();

    static {
        operator.put("1","中国电信");
        operator.put("2","中国移动");
        operator.put("3","中国联通");
    }
    public static String getOperator(String key){
        return operator.get(key);
    }
}
