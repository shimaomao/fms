package cn.com.leadu.fms.system.validator.sysrole.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.system.validator.sysrole.validator.SysRoleSaveValidator;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: SysUserVo
 * @Description: 用户注册时载体
 * @date 2018/1/9
 */
@Data
public class SysRoleSaveVo extends BaseVo<SysRole> {

    @NotBlank(message = "角色名称不能为空")
    private String roleName;//角色名称

    @NotBlank(message = "角色代码不能为空")
    @SysRoleSaveValidator(message ="角色代码已经存在")
    private String role; //代码

    @NotBlank(message = "启用标识不能为空")
    private String enableFlag;//启用

    @NotBlank(message = "排序不能为空")
    private String orderNo; //排序


}
