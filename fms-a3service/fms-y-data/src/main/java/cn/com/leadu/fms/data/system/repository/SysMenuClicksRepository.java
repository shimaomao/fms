package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysMenuClicks;
import cn.com.leadu.fms.pojo.system.vo.sysmenuclicks.SysMenuClicksVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksRepository
 * @Description: 利率因子Repository层
 * @date 2018-05-03
 */
public interface SysMenuClicksRepository {

	/**
	 * @Title:
	 * @Description: 新增利率因子
	 * @param sysMenuClicks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int insertData(SysMenuClicks sysMenuClicks);

	/**
	 * @Title:
	 * @Description: 批量保存利率因子
	 * @param sysMenuClickss
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int insertDataList(List<SysMenuClicks> sysMenuClickss);

	/**
	 * @Title:
	 * @Description: 修改利率因子
	 * @param sysMenuClicks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int updateByPrimaryKeyData(SysMenuClicks sysMenuClicks);

	/**
	 * @Title:
	 * @Description: 批量修改利率因子
	 * @param sysMenuClickss
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int updateByPrimaryKeyDataList(List<SysMenuClicks> sysMenuClickss);

	/**
	 * @Title:
	 * @Description: 动态修改利率因子
	 * @param sysMenuClicks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int updateByPrimaryKeySelectiveData(SysMenuClicks sysMenuClicks);

	/**
	 * @Title:
	 * @Description: 批量动态修改利率因子
	 * @param sysMenuClickss
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysMenuClicks> sysMenuClickss);

	/**
	 * @Title:
	 * @Description: 根据条件修改利率因子
	 * @param sysMenuClicks
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int updateByExampleData(SysMenuClicks sysMenuClicks, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改利率因子
	 * @param sysMenuClicks
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int updateByExampleSelectiveData(SysMenuClicks sysMenuClicks, Example example);

	/**
	 * @Title:
	 * @Description: 根据menuClicksId删除利率因子
	 * @param sysMenuClicks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int deleteData(SysMenuClicks sysMenuClicks);

	/**
	 * @Title:
	 * @Description: 根据menuClicksId集合批量删除利率因子
	 * @param menuClicksIds
	 * @param sysMenuClicks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int deleteDataList(List menuClicksIds, SysMenuClicks sysMenuClicks);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除利率因子
	 * @param example
	 * @param sysMenuClicks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	int deleteExampleData(Example example, SysMenuClicks sysMenuClicks);

	/**
	 * @Title:
	 * @Description: 查询全部利率因子
	 * @return List<SysMenuClicks>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	List<SysMenuClicks> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个利率因子
	 * @param example
	 * @return SysMenuClicks
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	SysMenuClicks selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询利率因子
	 * @param example
	 * @return List<SysMenuClicks>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	List<SysMenuClicks> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过menuClicksId查询利率因子
	 * @param menuClicksId
	 * @return SysMenuClicks
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	SysMenuClicks selectByPrimaryKey(Object menuClicksId);

	/**
	 * @Title:
	 * @Description: 分页查询利率因子
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysMenuClicks>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	PageInfoExtend<SysMenuClicks> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询利率因子vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	PageInfoExtend<SysMenuClicksVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据用户获取常用菜单List
	 * @param sysMenuClicksVo
	 * @return SysMenuClicksVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	List<SysMenuClicksVo> selectSysMenuClicksByUser(SysMenuClicksVo sysMenuClicksVo);
}
