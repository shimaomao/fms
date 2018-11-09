package cn.com.leadu.fms.oauth2.pojo.vo;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: SysClientVo
 * @Description: 承载rpc传递过来的客户端用户信息
 * @date 2018/3/7
 */
@Data
public class SysClientVo {

    private Integer id;

    private String clientId;//client标识

    private String clientSecret;//密钥

    private String scopes;

    private String auth_types;

    private String roles;

}
