package cn.com.leadu.fms.common.util;

import java.io.IOException;

/**
 * @author qiaomengnan
 * @ClassName: PythonUtils
 * @Description:
 * @date 2018/5/15
 */
public class PythonUtils {

    /**
     * @Title:
     * @Description:   解析模型
     * @param excelPath
     * @param txtPath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/15 05:51:44
     */
    public static void modelAnalysis(String excelPath,String txtPath) throws IOException {
        String pythonName= "hpl_ai_grading_no_3f.py";
        //调用python代码
        Process proc = Runtime.getRuntime().exec("python /data/"+pythonName+" " +
                excelPath +" " +
                "gb2312 " +
                txtPath +" " +
                "utf8");
    }

}
