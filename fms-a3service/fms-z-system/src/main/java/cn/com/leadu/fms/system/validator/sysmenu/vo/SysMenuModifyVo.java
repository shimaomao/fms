package cn.com.leadu.fms.system.validator.sysmenu.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author ningyangyang
 * @ClassName: SysMenuVo
 * @Description: 系统菜单修改时载体及验证
 * @date 2018-03-07
 */
@Data
public class SysMenuModifyVo extends BaseVo<SysMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 菜单id
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String menuId;

	/**
	 * @Fields  : 菜单名称
	 */
	@NotBlank(message = "菜单名称不能为空")
	private String menuName;

	/**
	 * @Fields  : 启用标识
	 */
	@NotBlank(message = "启用标识不能为空")
	private String enableFlag;

	/**
	 * @Fields  : 上级菜单id
	 */
	private String parMenuId;

	/**
	 * @Fields  : 菜单等级
	 */
	@NotBlank(message = "菜单等级不能为空")
	private String menuLevel;

	/**
	 * @Fields  : 菜单链接
	 */
	private String menuLink;

	/**
	 * @Fields  : 菜单排序
	 */
	@NotNull(message = "排序不能为空")
	private Integer orderNo;

}