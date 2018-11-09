package cn.com.leadu.fms.webclient.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author qiaomengnan
 * @ClassName: CookieUtils
 * @Description: cookie操作类
 * @date 2018/1/15
 */
public class CookieUtils {

    /**
     * @Title:
     * @Description: 根据key获取值
     * @param cKey
     * @return String
     * @throws
     * @author qiaomengnan
     * @date 2018/01/15 04:17:03
     */
    public static String getCookieValue(String cKey){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie != null && cookie.getName() != null && cookie.getName().equals(cKey)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
