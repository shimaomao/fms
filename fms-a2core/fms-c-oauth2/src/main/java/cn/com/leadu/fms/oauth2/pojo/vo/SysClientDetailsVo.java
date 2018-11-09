package cn.com.leadu.fms.oauth2.pojo.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author qiaomengnan
 * @ClassName: SysClient
 * @Description:
 * @date 2018/1/7
 */
@Data
public class SysClientDetailsVo implements ClientDetails {

    /**
     * client标识
     */
    private String clientId;

    /**
     * 密钥
     */
    private String clientSecret;

    /**
     * 这个客户是否仅限于一个特定的范围
     */
    private boolean isScoped = true;

    /**
     * 是否需要密钥来验证这个客户端
     */
    private boolean isSecretRequired = true;

    /**
     * 此客户端授权的授予类型
     */
    private Set<String> authorizedGrantTypes;

    /**
     * 此客户端的访问令牌有效期
     */
    private Integer accessTokenValiditySeconds;

    /**
     * 这个客户的范围
     */
    private Set<String> scope;

    /**
     * 此客户端在“authorization_code”访问授权期间使用的预定义重定向URI
     */
    private Set<String> registeredRedirectUri;

    /**
     * 获取授予OAuth客户端的权限
     */
    private List<GrantedAuthority> authorities;

    /**
     * 此客户端的刷新令牌有效期
     */
    private Integer refreshTokenValiditySeconds;

    /**
     * 这个客户端可以访问的资源
     */
    private Set<String> resourceIds;

    /**
     * 测试客户是否需要特定范围的用户批准
     * @param s
     * @return
     */
    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    /**
     * 这个客户端的附加信息，不需要OAuth协议，但可能是有用的，例如，存储描述性信息。
     * @return
     */
    private Map<String, Object> additionalInformation;


}
