package cn.com.leadu.fms.common.util;

import org.slf4j.Logger;

/**
 * @author qiaomengnan
 * @ClassName: LogConstants
 * @Description: 日志输出内容常量类
 * @date 2018/2/25
 */
public class LogUtils {

    public static final String starsLine = "***************************";

    public static void infoLine(Logger logger, String content){
        logger.info(starsLine+content+starsLine);
    }

}
