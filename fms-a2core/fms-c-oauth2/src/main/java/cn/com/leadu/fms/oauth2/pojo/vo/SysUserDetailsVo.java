package cn.com.leadu.fms.oauth2.pojo.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUser
 * @Description: 系统用户
 * @date 2018/1/7 下午5:33
 */
@Data
public class SysUserDetailsVo implements UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 指示用户是启用还是禁用
     */
    private boolean isEnabled;

    /**
     * 返回授予用户的权限
     */
    private List<GrantedAuthority> authorities;

    /**
     * 指示用户的帐户是否已过期
     */
    private boolean isAccountNonExpired;

    /**
     * 指示用户是锁定还是解锁
     */
    private boolean isAccountNonLocked;

    /**
     * 指示用户的凭据（密码）是否已过期
     */
    private boolean isCredentialsNonExpired;

}
