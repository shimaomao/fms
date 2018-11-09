package cn.com.leadu.fms.thirdinterface.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yanggang
 * @ClassName: WebMessageProperties
 * @Description: 短信配置
 * @date 2018/6/22
 */
@ConfigurationProperties(prefix = "fms.message")
@Component
@Data
public class WebMessageProperties {

    /**
     * @Fields  : API域名
     * @author qiaomengnan
     */
    private String url;


    //还款短信对应账号(只允许发还款短信)

    /**
     * @Fields  : 账号
     * @author qiaomengnan
     */
    private String repayId;

    /**
     * @Fields  : 密码
     * @author qiaomengnan
     */
    private String repayPwd;

    //续保以及其他短信

    /**
     * @Fields  : 账号
     * @author qiaomengnan
     */
    private String otherId;

    /**
     * @Fields  : 密码
     * @author qiaomengnan
     */
    private String otherPwd;
    
    /** 
     * @Fields  :  是否测试环境
     * @author qiaomengnan
     */ 
    private Boolean test;

    /**
     * @Fields  :  测试手机号
     * @author ningyangyang
     */
    private String testMobNo;


}
