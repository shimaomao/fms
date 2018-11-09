package cn.com.leadu.fms.thirdinterface.common.port.py.util;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import lombok.Data;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeVo
 * @Description: 项目权限管理载体
 * @date 2018-03-09
 */
@Data
public class SysWidgetAttributeVo extends PageQuery<SysWidgetAttribute> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 权限管理ID
	 */
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
	 * @Fields  : 项目名称
	 */
	private String eleWidgetName;

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

	/**
	 * @Fields  : 权限管理ID
	 */
	private List<String> widgetConIds;

}