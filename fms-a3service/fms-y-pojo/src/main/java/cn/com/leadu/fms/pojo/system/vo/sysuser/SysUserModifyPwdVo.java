package cn.com.leadu.fms.pojo.system.vo.sysuser;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author huchenghao
 * @ClassName: SysUserVo
 * @Description: 用户修改密码Vo
 * @date 2018-03-20
 */
@Data
public class SysUserModifyPwdVo {
    private static final long serialVersionUID = 1L;
    /**
     * @Fields  : 用户ID
     */
    private String userId;

    /**
     * @Fields  : 用户old密码
     */
    private String userPasswordOld;
    /**
     * @Fields  : 原密码加密后
     */
    private String userPasswordToMD5;

    /**
     * @Fields  : 新密码
     */
    private String userPassword;

    /**
     * @Fields  : 确认新密码
     */
    private String userPasswordConfirm;


}