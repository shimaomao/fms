package cn.com.leadu.fms.extend.interceptor;

import cn.com.leadu.fms.extend.pojo.vo.RequestParamsLog;
import cn.com.leadu.fms.extend.service.ConstantService;
import cn.com.leadu.fms.extend.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author qiaomengnan
 * @ClassName: ParameterInterceptor
 * @Description: 拦截请求参数并打印
 * @date 2018/1/7
 */
@Slf4j
public class ParameterInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterInterceptor.class);

    private static final String LOG_ATTR_PARAM_FLAG = "log_attr_param_flag";

    private LogService logService;

    private ConstantService constantService;

    public ParameterInterceptor(){}

    public ParameterInterceptor(LogService logService,ConstantService constantService){
        this.logService = logService;
        this.constantService = constantService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String requestParams = null;
            //如果两个都没进就只打印路径
            boolean isture = true;
            //1.from表单提交(get也能抓到参数)
            Enumeration<String> parameterNames = request.getParameterNames();
            if (parameterNames != null && parameterNames.hasMoreElements()) {
                StringBuffer stringBuffer = new StringBuffer("{");
                while (parameterNames.hasMoreElements()) {
                    String value = (String) parameterNames.nextElement();//调用nextElement方法获得元素
                    String parameter = request.getParameter(value);
                    stringBuffer.append("\"" + value + "\":\"" + parameter + "\",");
                }
                StringBuffer stringBufferNew = new StringBuffer(stringBuffer.toString().substring(0, stringBuffer.length() - 1));
                stringBufferNew.append("}");
                requestParams = stringBufferNew.toString();
                StringBuffer parameter = new StringBuffer("request_url=[").append(request.getRequestURI()).append("] request_params:[").append(stringBufferNew.toString()).append("]");
                LOGGER.info(parameter.toString());
                isture = false;
            }
            //2.json,xml提交
            ServletInputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);
                StringBuffer sb = new StringBuffer();
                String result = "";
                while ((result = br.readLine()) != null) {
                    sb.append(result);
                }
                if (sb.length() > 0) {
                    requestParams = sb.toString();
                    StringBuffer parameter = new StringBuffer("request_url=[").append(request.getRequestURI()).append("] request_params_body:[").append(sb.toString()).append("]");
                    LOGGER.info(parameter.toString());
                    isture = false;
                }
            }
            //如果两个都没进就只打印路径
            if (isture) {
                StringBuffer parameter = new StringBuffer("request_url=[").append(request.getRequestURI()).append("]");
                LOGGER.info(parameter.toString());
            }
            if(logService != null) {
                RequestParamsLog requestParamsLog = new RequestParamsLog();
                requestParamsLog.setRequestUrl(request.getRequestURI());
                requestParamsLog.setRequestParams(requestParams);
                requestParamsLog.setStartTime(new Date());
                request.setAttribute(LOG_ATTR_PARAM_FLAG, requestParamsLog);
            }
        } catch (Exception ex) {
            LOGGER.error("request_resolve_error:", ex);
        } finally {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        try {
            if(logService != null) {
                Object result = request.getAttribute(LOG_ATTR_PARAM_FLAG);
                RequestParamsLog requestParamsLog = null;
                if (result != null) {
                    requestParamsLog = (RequestParamsLog) result;
                    requestParamsLog.setEndTime(new Date());
                    logService.saveLog(requestParamsLog);
                }
            }
            if(constantService != null)
                constantService.clearLocal();
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
