package cn.com.leadu.fms.extend.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qiaomengnan
 * @ClassName: RequestUtils
 * @Description:
 * @date 2018/3/27
 */
public class RequestUtils {

    public static HttpServletRequest getRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes != null){
            return ((ServletRequestAttributes)requestAttributes).getRequest();
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   获取访问的路由url
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 02:46:31
     */
    public static String getRequestUri(){
        HttpServletRequest request = getRequest();
        if(request != null)
            return request.getRequestURI();
        return null;
    }

    /**
     * @Title:
     * @Description:   获取访问的完整url
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 02:46:53
     */
    public static String getRequestUrl(){
        HttpServletRequest request = getRequest();
        if(request != null)
            return request.getRequestURL().toString();
        return null;
    }

}
