package cn.com.leadu.fms.pojo.system.vo.sysusermenu;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuVo
 * @Description: 用户角色设置载体
 * @date 2018-03-17
 */
@Data
public class SysUserMenuVo extends PageQuery<SysUserMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户菜单ID
	 */
	private String userMenuId;

	/**
	 * @Fields  : 用户id
	 */
	private String userId;

	/**
	 * @Fields  : 菜单id
	 */
	private String menuId;

	/**
	 * @Fields  : 用户菜单ID
	 */
	private List<String> userMenuIds;

}