package cn.com.leadu.fms.thirdinterface.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: WebKingDeeProperties
 * @Description: 金蝶接口配置
 * @date 2018/7/17
 */
@ConfigurationProperties(prefix = "fms.gps.kingDee")
@Component
@Data
public class WebKingDeeProperties {

    /**
     * @Fields  : 客户接入地址
     * @author qiaomengnan
     */
    private String cusUrl;

    /**
     * @Fields  : 凭证接入地址
     * @author qiaomengnan
     */
    private String voucherUrl;

}
