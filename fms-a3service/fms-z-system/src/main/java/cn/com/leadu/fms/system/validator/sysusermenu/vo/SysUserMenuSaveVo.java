package cn.com.leadu.fms.system.validator.sysusermenu.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import lombok.Data;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuVo
 * @Description: 用户角色设置保存时载体及验证
 * @date 2018-03-17
 */
@Data
public class SysUserMenuSaveVo extends BaseVo<SysUserMenu> {

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

}