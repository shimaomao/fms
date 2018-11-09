package cn.com.leadu.fms.oauth2.pojo.vo;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: SysUserVo
 * @Description: 承载rpc传递过来的用户信息
 * @date 2018/3/7
 */
@Data
public class SysUserVo {

    private String userId;

    private String user;

    private String userPassword;

    private String roleNames;

}
