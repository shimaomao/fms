package cn.com.leadu.fms.common.util;

/**
 * @author qiaomengnan
 * @ClassName: SystemUtils
 * @Description: 系统工具类
 * @date 2018/3/26
 */
public class SystemUtils {

    /**
     * @Title:
     * @Description:   判断是否是windows类型的操作系统
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/26 02:29:41
     */
    public static boolean isWindows(){
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            return true;
        }else{
            return false;
        }
    }

}
