package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysWidget;
import cn.com.leadu.fms.pojo.system.vo.syswidget.SysWidgetVo;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysWidgetService
 * @Description: 画面控件管理业务层
 * @date 2018-03-09
 */
public interface SysWidgetService {

	/**
	 * @Title:
	 * @Description: 分页查询画面控件管理
	 * @param sysWidgetVo
	 * @return PageInfoExtend<SysWidget>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	PageInfoExtend<SysWidget> findSysWidgetsByPage(SysWidgetVo sysWidgetVo);

	/**
	 * @Title:
	 * @Description:   查出全部类型是画面的画面控件数据Map的形式返回
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	Map<String, String> findSysWidgetByTree();

}
