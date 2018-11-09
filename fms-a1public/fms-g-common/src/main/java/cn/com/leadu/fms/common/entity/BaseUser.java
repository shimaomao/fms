package cn.com.leadu.fms.common.entity;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: BaseUser
 * @Description: user基类
 * @date 2018/1/7
 */
@Data
public class BaseUser<T> extends BaseEntity<T> {

    /**
     * @Fields  : 用户ID
     */
    private String userId;

    /**
     * @Fields  : 用户登录名称
     */
    private String user;

    /**
     * @Fields  : 用户名称
     */
    private String userName;

    /**
     * @Fields  : 用户密码
     */
    private String userPassword;

}
