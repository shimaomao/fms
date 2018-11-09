package cn.com.leadu.fms.system.validator.sysusermenu.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuVo
 * @Description: 用户角色设置修改时载体及验证
 * @date 2018-03-17
 */
@Data
public class SysUserMenuModifyVo extends BaseVo<SysUserMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户菜单ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String userMenuId;

	/**
	 * @Fields  : 用户id
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String userId;

	/**
	 * @Fields  : 菜单id
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String menuId;

}