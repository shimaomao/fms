package cn.com.leadu.fms.system.validator.sysrolemenu.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuVo
 * @Description: 菜单角色设置删除时载体及验证
 * @date 2018-03-15
 */
@Data
public class SysRoleMenuDeleteVo extends BaseVo<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 角色菜单id
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String roleMenuId;

}