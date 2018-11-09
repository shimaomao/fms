package cn.com.leadu.fms.common.util;

import java.io.*;

/**
 * @author qiaomengnan
 * @ClassName: CommonFileConstants
 * @Description: txt工具类
 * @date 2018/5/15
 */
public class TxtUtils {

    /**
     * @Fields  : txt后缀名
     * @author qiaomengnan
     */
    public static final String TXT_SUFFIX = ".txt";

    /**
     * @Title:
     * @Description:  返回txt文件名称
     * @param name
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/15 10:20:09
     */
    public static String getTxtName(String name){
        return name + TXT_SUFFIX;
    }


    /**
     * @Title:
     * @Description:   拿到模型评分段
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/15 05:48:27
     */
    public static String getModelScoringSegment(String filePath) throws Exception {

        File file = new File(filePath);
        int num = 1;
        while(!file.exists()){
            //如果不存在的话 等待python将文件生成 每次休眠3秒 10次之后直接退出
            Thread.sleep(3000);
            if(num > 10)
                break;
            num ++;
        }

        if(file.exists()){
            //解析txt拿到模型评分段
            FileInputStream inputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String lineTxt = null;
            int index = 0;
            while((lineTxt = bufferedReader.readLine()) != null) {
                if (index != 0) {
                    String [] lineTxts = lineTxt.split(",");
                    return lineTxts[2].trim();
                }
                index ++;
            }
        }

        return null;
    }

}
