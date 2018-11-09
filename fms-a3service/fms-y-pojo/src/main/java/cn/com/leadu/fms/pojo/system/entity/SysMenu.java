package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.annotation.ChildTreeId;
import cn.com.leadu.fms.common.annotation.ParentTreeId;
import cn.com.leadu.fms.common.annotation.TreeText;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ningyangyang
 * @ClassName: SysMenuDao
 * @Description: 系统菜单实体
 * @date 2018-03-07
 */
@Data
public class SysMenu extends BaseEntity<SysMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 菜单id
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	@ChildTreeId
	private String menuId;

	/**
	 * @Fields  : 菜单名称
	 */
	@TreeText
	private String menuName;

	/**
	 * @Fields  : 启用标识
	 */
	private String enableFlag;

	/**
	 * @Fields  : 父菜单
	 */
	@ParentTreeId
	private String parMenuId;

	/**
	 * @Fields  : 菜单级别
	 */
	private String menuLevel;

	/**
	 * @Fields  : 菜单链接
	 */
	private String menuLink;

	/**
	 * @Fields  : 排序
	 */
	private Integer orderNo;


}