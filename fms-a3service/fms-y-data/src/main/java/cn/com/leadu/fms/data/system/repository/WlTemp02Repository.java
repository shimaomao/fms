package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.WlTemp02;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTemp02Repository
 * @Description: 数据迁移Repository层
 * @date 2018-08-04
 */
public interface WlTemp02Repository {

	/**
	 * @Title:
	 * @Description: 新增数据迁移
	 * @param wlTemp02
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int insertData(WlTemp02 wlTemp02);

	/**
	 * @Title:
	 * @Description: 批量保存数据迁移
	 * @param wlTemp02s
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int insertDataList(List<WlTemp02> wlTemp02s);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTemp02
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByPrimaryKeyData(WlTemp02 wlTemp02);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移
	 * @param wlTemp02s
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByPrimaryKeyDataList(List<WlTemp02> wlTemp02s);

	/**
	 * @Title:
	 * @Description: 动态修改数据迁移
	 * @param wlTemp02
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByPrimaryKeySelectiveData(WlTemp02 wlTemp02);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移
	 * @param wlTemp02s
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTemp02> wlTemp02s);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移
	 * @param wlTemp02
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByExampleData(WlTemp02 wlTemp02, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移
	 * @param wlTemp02
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByExampleSelectiveData(WlTemp02 wlTemp02, Example example);

	/**
	 * @Title:
	 * @Description: 根据temp02Id删除数据迁移
	 * @param wlTemp02
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int deleteData(WlTemp02 wlTemp02);

	/**
	 * @Title:
	 * @Description: 根据temp02Id集合批量删除数据迁移
	 * @param temp02Ids
	 * @param wlTemp02
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int deleteDataList(List temp02Ids, WlTemp02 wlTemp02);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除数据迁移
	 * @param example
	 * @param wlTemp02
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int deleteExampleData(Example example, WlTemp02 wlTemp02);

	/**
	 * @Title:
	 * @Description: 查询全部数据迁移
	 * @return List<WlTemp02>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	List<WlTemp02> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个数据迁移
	 * @param example
	 * @return WlTemp02
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	WlTemp02 selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询数据迁移
	 * @param example
	 * @return List<WlTemp02>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	List<WlTemp02> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过temp02Id查询数据迁移
	 * @param temp02Id
	 * @return WlTemp02
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	WlTemp02 selectByPrimaryKey(Object temp02Id);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<WlTemp02>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	PageInfoExtend<WlTemp02> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTemp02,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByPrimaryKeyData(WlTemp02 wlTemp02, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移,并进行排他
	 * @param wlTemp02s
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByPrimaryKeyDataList(List<WlTemp02> wlTemp02s, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改数据迁移,并进行排他
	 * @param wlTemp02
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(WlTemp02 wlTemp02, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移,并进行排他
	 * @param wlTemp02s
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTemp02> wlTemp02s, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移,并进行排他
	 * @param wlTemp02
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByExampleData(WlTemp02 wlTemp02, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移,并进行排他
	 * @param wlTemp02
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:45
	 */
	int updateByExampleSelectiveData(WlTemp02 wlTemp02, Example example, boolean exclusive);

}
