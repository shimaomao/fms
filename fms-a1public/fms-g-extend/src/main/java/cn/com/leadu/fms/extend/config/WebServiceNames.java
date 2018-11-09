package cn.com.leadu.fms.extend.config;

import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: WebServiceNames
 * @Description:
 * @date 2018/3/23
 */
@ConfigurationProperties(prefix = "fms.feigns.serverNames")
@Component
@Data
public class WebServiceNames {

    private static WebServiceNames webServiceNames = null;

    private static final String HTTP = "http://";

    public WebServiceNames(){
        webServiceNames = this;
    }

    private String fmsAgent;

    private String fmsOauth2;

    private String fmsSystem;

    private String fmsFile;

    private String fmsActiviti;

    private String fmsBaseInfo;

    private String fmsPostBiz;

    private String fmsPreBiz;

    private String fmsProduct;

    /**
     * @Fields  : 名称map集合,以下标做标识
     * @author qiaomengnan
     */
    private Map<Integer,String> nameMaps = null;

    private static String getUrlPath(String serviceName,String path){
        if(StringUtils.isNotTrimBlank(path) && !path.startsWith("/"))
            path = "/" + path;
        return HTTP + serviceName + path;
    }

    /**
     * @Title:
     * @Description: 通过服务标识和路径 拼出一个完成的url
     * @param:  serviceFlag 服务标识
     * @param:  path 路径
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19 0019 17:01
     */
    public static String getUrlPath(Integer serviceFlag,String path){
        if(serviceFlag == null)
            throw new FmsServiceException("服务标识不能为空");
        if(StringUtils.isTrimBlank(path))
            throw new FmsServiceException("服务数据路径不能为空");
        String serviceName = webServiceNames.getNameMaps().get(serviceFlag);
        if(StringUtils.isTrimBlank(serviceName))
            throw new FmsServiceException("服务不存在");
        return webServiceNames.getUrlPath(serviceName,path);
    }

    public static String getFmsAgentUrl(String path){
        return getUrlPath(webServiceNames.getFmsAgent(),path);
    }

    public static String getFmsOauth2Url(String path){
        return getUrlPath(webServiceNames.getFmsOauth2(),path);
    }

    public static String getFmsSystemUrl(String path){
        return getUrlPath(webServiceNames.getFmsSystem(),path);
    }

    public static String getFmsFileUrl(String path){
        return getUrlPath(webServiceNames.getFmsFile(),path);
    }

    public static String getFmsActivitiUrl(String path){
        return getUrlPath(webServiceNames.getFmsActiviti(),path);
    }

    public static String getFmsBaseInfoUrl(String path){
        return getUrlPath(webServiceNames.getFmsBaseInfo(),path);
    }

    public static String getFmsPostBizUrl(String path){
        return getUrlPath(webServiceNames.getFmsPostBiz(),path);
    }

    public static String getFmsPreBizUrl(String path){
        return getUrlPath(webServiceNames.getFmsPreBiz(),path);
    }

    public static String getFmsProductUrl(String path){
        return getUrlPath(webServiceNames.getFmsProduct(),path);
    }

    public static boolean isFmsAgent(String requestUrl){
        if(StringUtils.isNotTrimBlank(requestUrl) && requestUrl.contains(webServiceNames.fmsAgent))
            return true;
        return false;
    }

}
