package cn.com.leadu.fms.system.validator.syswidgetattribute.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeVo
 * @Description: 项目权限管理修改时载体及验证
 * @date 2018-03-09
 */
@Data
public class SysWidgetAttributeModifyVo extends BaseVo<SysWidgetAttribute> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 权限管理ID
	 */
	@NotBlank(message = "权限管理ID不能为空")
	private String widgetConId;

	/**
	 * @Fields  : 画面ID
	 */
	@NotBlank(message = "画面ID不能为空")
	private String frmWidgetId;

	/**
	 * @Fields  : 项目ID
	 */
	@NotBlank(message = "项目ID不能为空")
	private String eleWidgetId;

	/**
	 * @Fields  : 项目显示权限
	 */
	@NotBlank(message = "项目显示权限不能为空")
	private String showMod;

	/**
	 * @Fields  : 项目编辑权限
	 */
	@NotBlank(message = "项目编辑权限不能为空")
	private String writeMod;

	/**
	 * @Fields  : 项目是否必须
	 */
	@NotBlank(message = "项目是否必须不能为空")
	private String checkMod;

}