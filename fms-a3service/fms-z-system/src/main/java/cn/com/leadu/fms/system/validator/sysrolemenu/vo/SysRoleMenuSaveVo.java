package cn.com.leadu.fms.system.validator.sysrolemenu.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import lombok.Data;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuVo
 * @Description: 菜单角色设置保存时载体及验证
 * @date 2018-03-15
 */
@Data
public class SysRoleMenuSaveVo extends BaseVo<SysRoleMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 角色菜单id
	 */
	private String roleMenuId;

	/**
	 * @Fields  : 角色id
	 */
	private String roleId;

	/**
	 * @Fields  : 菜单id
	 */
	private String menuId;

}