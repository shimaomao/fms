package cn.com.leadu.fms.thirdinterface.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: WebGpsTyProperties
 * @Description: 天易gps派单配置文件
 * @date 2018/7/4
 */
@ConfigurationProperties(prefix = "fms.gps.ty")
@Component
@Data
public class WebGpsTyProperties {

    /**
     * @Fields  : 请求工单设备实时位置信息获取接口url
     * @author qiaomengnan
     */
    private String queryUrl;

    /**
     * @Fields  : 请求派单接口url
     * @author qiaomengnan
     */
    private String sendUrl;

    /**
     * @Fields  : 拉车账号
     * @author qiaomengnan
     */
    private String carAccount;

}
