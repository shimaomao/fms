package cn.com.leadu.fms.common.util;

/**
 * @author qiaomengnan
 * @ClassName: UrlMatching
 * @Description: 匹配url
 * @date 2018/1/14
 */
public class UrlMatchingUtils {

    /**
     * 验证访问的路径是否需要验证,true需要验证，false不需要验证
     * @param requestUri
     * @param notAuthUrls
     * @return
     */
    public static boolean matching(String requestUri,String[] notAuthUrls){
        boolean result = true;
        if(notAuthUrls != null) {
            for (String notAuthUrl : notAuthUrls) {
                if (notAuthUrl.indexOf("/**") == -1) {
                    if (requestUri.equals(notAuthUrl))
                        result = false;
                } else {
                    String notAuthUrlTemp = notAuthUrl.replace("/**", "");
                    if (requestUri.startsWith(notAuthUrlTemp))
                        result = false;
                }
            }
        }
        return result;
    }

}
