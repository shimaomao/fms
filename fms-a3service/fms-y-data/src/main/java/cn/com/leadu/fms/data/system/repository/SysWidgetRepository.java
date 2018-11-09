package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysWidget;
import cn.com.leadu.fms.pojo.system.vo.syswidget.SysWidgetVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysWidgetRepository
 * @Description: 画面控件管理Repository层
 * @date 2018-03-09
 */
public interface SysWidgetRepository {

	/**
	 * @Title:
	 * @Description: 新增画面控件管理
	 * @param sysWidget
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int insertData(SysWidget sysWidget);

	/**
	 * @Title:
	 * @Description: 批量保存画面控件管理
	 * @param sysWidgets
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int insertDataList(List<SysWidget> sysWidgets);

	/**
	 * @Title:
	 * @Description: 修改画面控件管理
	 * @param sysWidget
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int updateByPrimaryKeyData(SysWidget sysWidget);

	/**
	 * @Title:
	 * @Description: 批量修改画面控件管理
	 * @param sysWidgets
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int updateByPrimaryKeyDataList(List<SysWidget> sysWidgets);

	/**
	 * @Title:
	 * @Description: 动态修改画面控件管理
	 * @param sysWidget
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int updateByPrimaryKeySelectiveData(SysWidget sysWidget);

	/**
	 * @Title:
	 * @Description: 批量动态修改画面控件管理
	 * @param sysWidgets
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysWidget> sysWidgets);

	/**
	 * @Title:
	 * @Description: 根据条件修改画面控件管理
	 * @param sysWidget
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int updateByExampleData(SysWidget sysWidget, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改画面控件管理
	 * @param sysWidget
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int updateByExampleSelectiveData(SysWidget sysWidget, Example example);

	/**
	 * @Title:
	 * @Description: 根据widgetUuid删除画面控件管理
	 * @param sysWidget
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int deleteData(SysWidget sysWidget);

	/**
	 * @Title:
	 * @Description: 根据widgetUuid集合批量删除画面控件管理
	 * @param widgetUuids
	 * @param sysWidget
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	int deleteDataList(List widgetUuids, SysWidget sysWidget);

	/**
	 * @Title:
	 * @Description: 查询全部画面控件管理
	 * @return List<SysWidget>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	List<SysWidget> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个画面控件管理
	 * @param example
	 * @return SysWidget
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	SysWidget selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询画面控件管理
	 * @param example
	 * @return List<SysWidget>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	List<SysWidget> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过widgetUuid查询画面控件管理
	 * @param widgetUuid
	 * @return SysWidget
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	SysWidget selectByPrimaryKey(Object widgetUuid);

	/**
	 * @Title:
	 * @Description: 分页查询画面控件管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysWidget>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	PageInfoExtend<SysWidget> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询画面控件管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysWidget>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 16:31:25
	 */
	PageInfoExtend<SysWidget> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
