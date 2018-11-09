package cn.com.leadu.fms.system.validator.sysrole.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: SysUserModifyVo
 * @Description:
 * @date 2018/1/11
 */
@Data
public class SysRoleModifyVo extends BaseVo<SysRole> {

    @NotBlank(message = "角色id不能为空")
    private String roleId; //角色id

    @NotBlank(message = "角色名称不能为空")
    private String roleName;//角色名称

    @NotBlank(message = "角色代码不能为空")
    private String role; //代码

    @NotBlank(message = "启用标识不能为空")
    private String enableFlag;//启用

    @NotBlank(message = "排序不能为空")
    private String orderNo; //排序


}
