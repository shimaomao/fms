package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeRepository
 * @Description: 项目权限管理Repository层
 * @date 2018-03-09
 */
public interface SysWidgetAttributeRepository {

	/**
	 * @Title:
	 * @Description: 新增项目权限管理
	 * @param sysWidgetAttribute
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int insertData(SysWidgetAttribute sysWidgetAttribute);

	/**
	 * @Title:
	 * @Description: 批量保存项目权限管理
	 * @param sysWidgetAttributes
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int insertDataList(List<SysWidgetAttribute> sysWidgetAttributes);

	/**
	 * @Title:
	 * @Description: 修改项目权限管理
	 * @param sysWidgetAttribute
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int updateByPrimaryKeyData(SysWidgetAttribute sysWidgetAttribute);

	/**
	 * @Title:
	 * @Description: 批量修改项目权限管理
	 * @param sysWidgetAttributes
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int updateByPrimaryKeyDataList(List<SysWidgetAttribute> sysWidgetAttributes);

	/**
	 * @Title:
	 * @Description: 动态修改项目权限管理
	 * @param sysWidgetAttribute
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int updateByPrimaryKeySelectiveData(SysWidgetAttribute sysWidgetAttribute);

	/**
	 * @Title:
	 * @Description: 批量动态修改项目权限管理
	 * @param sysWidgetAttributes
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysWidgetAttribute> sysWidgetAttributes);

	/**
	 * @Title:
	 * @Description: 根据条件修改项目权限管理
	 * @param sysWidgetAttribute
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int updateByExampleData(SysWidgetAttribute sysWidgetAttribute, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改项目权限管理
	 * @param sysWidgetAttribute
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int updateByExampleSelectiveData(SysWidgetAttribute sysWidgetAttribute, Example example);

	/**
	 * @Title:
	 * @Description: 根据widgetConId删除项目权限管理
	 * @param sysWidgetAttribute
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int deleteData(SysWidgetAttribute sysWidgetAttribute);

	/**
	 * @Title:
	 * @Description: 根据widgetConId集合批量删除项目权限管理
	 * @param widgetConIds
	 * @param sysWidgetAttribute
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	int deleteDataList(List widgetConIds, SysWidgetAttribute sysWidgetAttribute);

	/**
	 * @Title:
	 * @Description: 查询全部项目权限管理
	 * @return List<SysWidgetAttribute>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	List<SysWidgetAttribute> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个项目权限管理
	 * @param example
	 * @return SysWidgetAttribute
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	SysWidgetAttribute selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询项目权限管理
	 * @param example
	 * @return List<SysWidgetAttribute>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	List<SysWidgetAttribute> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过widgetConId查询项目权限管理
	 * @param widgetConId
	 * @return SysWidgetAttribute
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	SysWidgetAttribute selectByPrimaryKey(Object widgetConId);

	/**
	 * @Title:
	 * @Description: 分页查询项目权限管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysWidgetAttribute>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	PageInfoExtend<SysWidgetAttribute> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询项目权限管理vo
	 * @param methodName
	 * @param sysWidgetAttributeVo
	 * @param pageQuery
	 * @return PageInfoExtend<SysWidgetAttribute>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	PageInfoExtend<SysWidgetAttributeVo> selectListVoByPage(String methodName, SysWidgetAttributeVo sysWidgetAttributeVo, PageQuery pageQuery);

}
