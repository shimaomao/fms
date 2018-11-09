package cn.com.leadu.fms.pojo.system.vo.sysrolemenu;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuVo
 * @Description: 菜单角色设置载体
 * @date 2018-03-15
 */
@Data
public class SysRoleMenuVo extends PageQuery<SysRoleMenu> {

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

	/**
	 * @Fields  : 角色菜单id
	 */
	private List<String> roleMenuIds;
	/**
	 * 菜单Id
	 */
	private List<String> menuIds;
}