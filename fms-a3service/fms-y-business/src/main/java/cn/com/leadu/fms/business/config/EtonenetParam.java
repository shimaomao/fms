package cn.com.leadu.fms.business.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangxue
 * @ClassName: EtonenetParam
 * @Description: 发送短信用参数
 * @date 2018/3/16
 */
@Data
@ConfigurationProperties(prefix = "etonenetParam")
public class EtonenetParam {

    private String mtUrl;
    private String command;
    private String spid;
    private String sppassword;
    private String spsc;
    private String sa;
    private String haltPhoneNum;


    public String getSpsc(){
        if("0".equals(spsc))
            return "00";
        else
            return spsc;
    }
}
