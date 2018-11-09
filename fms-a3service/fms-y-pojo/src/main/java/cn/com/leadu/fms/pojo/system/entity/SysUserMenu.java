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
 * @ClassName: SysUserMenuDao
 * @Description: 用户角色设置实体
 * @date 2018-03-17
 */
@Data
public class SysUserMenu extends BaseEntity<SysUserMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户菜单ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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