package cn.com.leadu.fms.system.validator.sysuser.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: SysUserModifyPwdVo
 * @Description:
 * @date 2018/1/19
 */
@Data
public class SysUserModifyPwdVo extends BaseVo<SysUser> {

    @NotBlank(message = "用户id不能为空")
    private String userId;  //用户id

    @NotBlank(message = "用户密码不能为空")
    private String userPassword;//用户密码

}
