package cn.com.leadu.fms.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qiaomengnan
 * @ClassName: PatternUtils
 * @Description: 正则表达式工具类
 * @date 2018/6/21
 */
public class PatternMatcherUtils {

    /**
     * @Fields : 查找带有 ${} 的内容
     * @author qiaomengnan
     */
    public static final String TEMPLATE_VARIABLE = "(\\$\\{[^\\}]+})";

    /**
     * @param data
     * @param compile
     * @return
     * @throws
     * @Title:
     * @Description: 查找内容, 以list形式返回
     * @author qiaomengnan
     * @date 2018/06/21 02:57:49
     */
    public static List<String> find(String data, String compile) {
        Pattern pattern = Pattern.compile(compile);
        Matcher matcher = pattern.matcher(data);
        List<String> results = null;
        while (matcher.find()) {
            if (results == null)
                results = new ArrayList<>();
            results.add(matcher.group(0));
        }
        return results;
    }

    /**
     * @param data
     * @return
     * @throws
     * @Title:
     * @Description: 查找模板中的变量 以及 变量对应的原生值
     * @author qiaomengnan
     * @date 2018/06/21 03:02:17
     */
    public static Map<String, String> findTemplateVariables(String data) {
        Pattern pattern = Pattern.compile(TEMPLATE_VARIABLE);
        Matcher matcher = pattern.matcher(data);
        Map<String, String> results = null;
        while (matcher.find()) {
            if (results == null)
                results = new HashMap<>();
            String result = matcher.group(0);
            if (StringUtils.isNotTrimBlank(result))
                results.put(result.replace("$", "").replace("{", "").replace("}", ""), result);
        }
        return results;
    }

    /**
     * @param data
     * @param object
     * @return
     * @throws
     * @Title:
     * @Description: 查找模板中的变量 以及 变量对应的原生值 并替换返回替换后的内容
     * @author qiaomengnan
     * @date 2018/06/21 03:02:17
     */
    public static String replaceTemplateVariables(String data,Object object){
        Map<String,String> keys = findTemplateVariables(data);
        Map<String,String> values = JsonUtils.objectToMap(object);
        if(keys != null && keys.size() > 0){
            for (String key : keys.keySet()) {
                //如果值为空,则赋值空字符串
                if(values == null || values.get(key) == null)
                    data = data.replace(keys.get(key), "");
                else {
                    data = data.replace(keys.get(key), values.get(key));
                }
            }
        }
        return data;
    }

    /**
     * @Title:
     * @Description: 判断是否是整型
     * @param: str
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/29 0029 17:37
     */
    public static boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * @Title:
     * @Description: 判断是否是double型
     * @param: str
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/29 0029 17:37
     */
    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

}
