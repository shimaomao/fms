package cn.com.leadu.fms.webclient.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: WebClientProperties
 * @Description: WebClient项目配置
 * @date 2018/1/9
 */
@Slf4j
@ConfigurationProperties(prefix = "fms.web.client")
@Component
@Data
public class WebClientProperties {

    private String clientId;

    private String clientSecret;

    private String grantType;

    private Map<String,Map<String,Map<String,String>>> excelExportUrls;

    private String basic;

    public String getBasic(){
        try{
            if(basic == null) {
                String clientId = getClientId();
                String clientSecret = getClientSecret();
                byte[] basicByte = (clientId + ":" + clientSecret).getBytes("utf-8");
                basic = "Basic " + new String(Base64.encodeBase64(basicByte),"utf-8");
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }finally {
            return basic;
        }
    }

}
