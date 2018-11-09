package cn.com.leadu.fms.common.util;

import cn.com.leadu.fms.common.exception.FmsRuntimeException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiaohao on 2017/8/23.
 */
public class StringUtils {

    public static final String COMMA = ",";

    public static final String SEMICOLON = ";";

    public static final String LINE = "_";

    public static final String COLON = ":";

    public static final String SLANT = "/";

    /**
     * 返回是否为null trim后的空字符串
     *
     * @param param
     * @return
     */
    public static boolean isTrimBlank(Object param) {
        if (param == null)
            return true;
        else if (param.toString().trim().equals(""))
            return true;
        else
            return false;
    }

    /**
     * 返回是否不为null 或者trim后的空字符串
     * @param param
     * @return
     */
    public static boolean isNotTrimBlank(Object param) {
        return !isTrimBlank(param);
    }

    /**
     * 返回是否不为null 或者trim后的空字符串
     * @param params
     * @return
     */
    public static boolean isNotTrimBlank(Object ...params) {
        for(Object param : params){
            if(isTrimBlank(param))
                return false;
        }
        return true;
    }

    /**
     * @Title:
     * @Description:   判断数据是否存在
     * @param param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/28 11:58:48
     */
    public static boolean isExits(Object param){
        if(isNotTrimBlank(param) && !"undefined".equals(param))
            return true;
        return false;
    }

    /**
     * @Title:
     * @Description:   判断数据是否不存在
     * @param param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/28 11:58:59
     */
    public static boolean isNotExits(Object param){
        return !isExits(param);
    }

    /**
     * @Title:
     * @Description:   判断数据是否都不存在
     * @param params
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/02 07:43:34
     */
    public static boolean isNotExits(Object ...params){
        boolean res = true;
        for(Object param : params){
            if(isExits(param))
                return false;
        }
        return res;
    }

    /**
     * @Title:
     * @Description:   是否包含为空或者null的字符串
     * @param params
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 03:45:59
     */
    public static boolean isContainTrimBlank(Object ...params){
        for(Object param : params){
            if(isTrimBlank(param))
                return true;
        }
        return false;
    }


    /**
     * 是否包含不为null 或者trim后的空字符串
     * @param params
     * @return
     */
    public static boolean isContainNotTrimBlank(Object ...params) {
        for(Object param : params) {
            if (param != null && !param.toString().trim().equals(""))
                return true;
        }
        return false;
    }

    /**
     * 判断两个值是否相等
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        return str1 == null?str2 == null:str1.equals(str2);
    }

    /**
     * 判断两个值是否不相等
     * @param str1
     * @param str2
     * @return
     */
    public static boolean notEquals(String str1, String str2) {
        return !equals(str1,str2);
    }

    /**
     * 判断str1 是否包含 str2
     * @param str1
     * @param str2
     * @return
     */
    public static boolean container(String str1, String str2){
        return str1.indexOf(str2) != -1;
    }

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String lineToHump(String str){
        Pattern linePattern = Pattern.compile("_(\\w)");
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        String regexStr = "[A-Z]";
        Matcher matcher = Pattern.compile(regexStr).matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            matcher.appendReplacement(sb, "_" + g.toLowerCase());
        }
        matcher.appendTail(sb);
        if (sb.charAt(0) == '_') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    /**
     * @Title:
     * @Description:  字符串衔接
     * @param values
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/25 02:12:53
     */
    public static String join(String ...values){
        StringBuffer result = new StringBuffer();
        for(String value : values)
            if(isNotTrimBlank(value))
                result.append(value);
        return result.toString();
    }

    /**
     * @Title:
     * @Description:   字符串通过分隔符衔接
     * @param delimiter
     * @param values
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 02:22:09
     */
    public static String joinDelimiter(String delimiter,String ...values){
        String result = null;
        if(isNotTrimBlank(delimiter) && ArrayUtils.isNotNullAndLengthNotZero(values)){
            StringBuffer stringBuffer = new StringBuffer();
            for(String value : values){
                if(isNotTrimBlank(value)) {
                    stringBuffer.append(value);
                    stringBuffer.append(delimiter);
                }
            }
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            result = stringBuffer.toString();
        }
        return result;
    }

    /**
     * @Title:
     * @Description:   字符串通过分隔符衔接
     * @param delimiter
     * @param values
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 02:22:09
     */
    public static String joinDelimiter(String delimiter,List<String> values){
        return joinDelimiter(delimiter, values.toArray(new String[] {}));
    }


    /**
     * @Title:
     * @Description: 通过分隔符分割，返回一个String类型数组
     * @param delimiter
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 02:27:22
     */
    public static String[] split(String delimiter,String value){
        String [] results = null;
        if(isNotTrimBlank(value,delimiter))
            results = value.split(delimiter);
        return results;
    }

    /**
     * @Title:
     * @Description:   通过分隔符分割，返回一个List类型数组
     * @param delimiter
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 02:36:01
     */
    public static List<String> splitToList(String delimiter, String value){
        String [] resultArray = split(delimiter, value);
        List<String> results = null;
        if(ArrayUtils.isNotNullAndLengthNotZero(resultArray))
            results = ArrayUtils.asList(resultArray);
        return results;
    }

    /**
     * @Title:
     * @Description:  如果值为null则给予空字符串
     * @param str
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:08:20
     */
    public static String defaultString(String str) {
        return str == null?"":str;
    }

    /**
     * @Title:
     * @Description:   通过英文,号分割字符创,返回一个数组回去
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/19 05:33:35
     */
    public static String[] splitComma(String value){
        return split(COMMA,value);
    }

    /**
     * @Title:
     * @Description:   通过英文,号分割字符创,返回一个list回去
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/19 05:33:35
     */
    public static List<String> splitCommaToList(String value){
        return splitToList(COMMA,value);
    }

    /**
     * @Title:
     * @Description:   字符串格式化，左补0返回指定长度
     * @param num,strLength
     * @return
     * @throws
     * @author liujinge
     * @date 2018/03/26 05:33:35
     */
    public static String addZeroForNum(int num, int strLength) {
        String str = String.valueOf(num);
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);// 左补0
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }

    /**
     * @Title:
     * @Description:   获取Object的String值
     * @param val
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 09:50:57
     */
    public static String getValue(Object val){
        if(val == null)
            return null;
        return val.toString();
    }

    /**
     * @Title:
     * @Description:   获取Object的String值
     * @param val
     * @param defaultValue 默认值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/09 09:50:57
     */
    public static String getValue(Object val,String defaultValue){
        if(val == null)
            return defaultValue;
        return val.toString();
    }

   /**
    * @Title:
    * @Description: 按照字典顺序比较两个字符串
    * @param: val1
    * @param: val2
    * @return
    * @throws
    * @author qiaomengnan
    * @date
    */
    public static int compare(String val1,String val2) {
        if (isContainTrimBlank(val1, val2))
            throw new FmsRuntimeException("对比的值不能为空");
        return val1.compareTo(val2);
    }

    /**
     * @Title:
     * @Description: 截取字符串后num位
     * @param: value
     * @param: num
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 14:24
     */
    public static String subStringLater(String value,int num){
        if(StringUtils.isNotTrimBlank(value))
            return value.substring(value.length() - num);
        return value;
    }

    /**
     * @Title:
     * @Description: 从开始为接截取length长度的字符串
     * @param value 字符串
     * @param length 长度
     * @return String
     * @throws
     * @author wangxue
     * @date 2018/10/10 0030 14:24
     */
    public static String subStringBegin(String value,int length){
        if(StringUtils.isNotTrimBlank(value) && value.length() > length)
            return value.substring(0, length);
        return value;
    }

    /**
     * @Title:
     * @Description:   将一个值的前几位转换成大写
     * @param value 值
     * @param num 几位
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:39:50
     */
    public static String toLowerCaseFirst(String value , int num){
        if(StringUtils.isNotTrimBlank(value) && num != 0 && value.length() >= num){
            return value.substring(0,num).toUpperCase() + value.substring(num);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   将一个值的前1位转换成大写
     * @param value 值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:39:50
     */
    public static String toLowerCaseFirstOne(String value){
        return toLowerCaseFirst(value,1);
    }

    /**
     * @Title:
     * @Description: 过滤空格
     * @param:  value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/20 0020 13:49
     */
    public static String trim(String value){
        if(value == null)
            return null;
        return value.trim();
    }

}
