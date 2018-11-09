package cn.com.leadu.fms.pojo.system.vo.syswidget;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysWidget;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: SysWidgetVo
 * @Description: 画面控件管理载体
 * @date 2018-03-09
 */
@Data
public class SysWidgetVo extends PageQuery<SysWidget> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 画面管理ID
	 */
	private String widgetUuid;

	/**
	 * @Fields  : 识别ID
	 */
	private String widgetId;

	/**
	 * @Fields  : 类型
	 */
	private String widgetType;

	/**
	 * @Fields  : 名称
	 */
	private String widgetName;

	/**
	 * @Fields  : 提示信息
	 */
	private String memo;

	/**
	 * @Fields  : 画面管理ID
	 */
	private List<String> widgetUuids;

}