package cn.com.leadu.fms.extend.filter;

import cn.com.leadu.fms.extend.request.BodyReaderHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author qiaomengnan
 * @ClassName: ParameterFilter
 * @Description: 注入拓展request
 * @date 2018/1/7
 */

public class ParameterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new BodyReaderHttpServletRequestWrapper((HttpServletRequest)servletRequest),servletResponse);
    }

    @Override
    public void destroy() {

    }
}
