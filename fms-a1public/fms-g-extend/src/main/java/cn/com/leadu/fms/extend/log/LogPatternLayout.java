package cn.com.leadu.fms.extend.log;

import ch.qos.logback.classic.PatternLayout;

/**
 * @author qiaomengnan
 * @ClassName: LogPatternLayout
 * @Description: 注入自定义日志类
 * @date 2018/1/7
 */

public class LogPatternLayout extends PatternLayout {

    static {
        defaultConverterMap.put("fms", LogMessageConverter.class.getName());
    }

}
