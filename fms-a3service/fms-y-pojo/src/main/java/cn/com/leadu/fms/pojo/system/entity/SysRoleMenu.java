package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenu
 * @Description: 用户角色表实体
 * @date 2018-03-21
 */
@Data
public class SysRoleMenu extends BaseEntity<SysRoleMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 角色菜单id
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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