package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeDao
 * @Description: 项目权限管理实体
 * @date 2018-03-09
 */
@Data
public class SysWidgetAttribute extends BaseEntity<SysWidgetAttribute> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 权限管理ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String widgetConId;

	/**
	 * @Fields  : 画面ID
	 */
	private String frmWidgetId;

	/**
	 * @Fields  : 项目ID
	 */
	private String eleWidgetId;

	/**
	 * @Fields  : 项目显示权限
	 */
	private String showMod;

	/**
	 * @Fields  : 项目编辑权限
	 */
	private String writeMod;

	/**
	 * @Fields  : 项目是否必须
	 */
	private String checkMod;

}