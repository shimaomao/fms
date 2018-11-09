package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.WlTemp01;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTemp01Repository
 * @Description: 数据迁移Repository层
 * @date 2018-08-04
 */
public interface WlTemp01Repository {

	/**
	 * @Title:
	 * @Description: 新增数据迁移
	 * @param wlTemp01
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int insertData(WlTemp01 wlTemp01);

	/**
	 * @Title:
	 * @Description: 批量保存数据迁移
	 * @param wlTemp01s
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int insertDataList(List<WlTemp01> wlTemp01s);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTemp01
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByPrimaryKeyData(WlTemp01 wlTemp01);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移
	 * @param wlTemp01s
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByPrimaryKeyDataList(List<WlTemp01> wlTemp01s);

	/**
	 * @Title:
	 * @Description: 动态修改数据迁移
	 * @param wlTemp01
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByPrimaryKeySelectiveData(WlTemp01 wlTemp01);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移
	 * @param wlTemp01s
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTemp01> wlTemp01s);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移
	 * @param wlTemp01
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByExampleData(WlTemp01 wlTemp01, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移
	 * @param wlTemp01
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByExampleSelectiveData(WlTemp01 wlTemp01, Example example);

	/**
	 * @Title:
	 * @Description: 根据temp01Id删除数据迁移
	 * @param wlTemp01
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int deleteData(WlTemp01 wlTemp01);

	/**
	 * @Title:
	 * @Description: 根据temp01Id集合批量删除数据迁移
	 * @param temp01Ids
	 * @param wlTemp01
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int deleteDataList(List temp01Ids, WlTemp01 wlTemp01);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除数据迁移
	 * @param example
	 * @param wlTemp01
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int deleteExampleData(Example example, WlTemp01 wlTemp01);

	/**
	 * @Title:
	 * @Description: 查询全部数据迁移
	 * @return List<WlTemp01>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	List<WlTemp01> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个数据迁移
	 * @param example
	 * @return WlTemp01
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	WlTemp01 selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询数据迁移
	 * @param example
	 * @return List<WlTemp01>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	List<WlTemp01> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过temp01Id查询数据迁移
	 * @param temp01Id
	 * @return WlTemp01
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	WlTemp01 selectByPrimaryKey(Object temp01Id);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<WlTemp01>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	PageInfoExtend<WlTemp01> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTemp01,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByPrimaryKeyData(WlTemp01 wlTemp01, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移,并进行排他
	 * @param wlTemp01s
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByPrimaryKeyDataList(List<WlTemp01> wlTemp01s, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改数据迁移,并进行排他
	 * @param wlTemp01
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(WlTemp01 wlTemp01, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移,并进行排他
	 * @param wlTemp01s
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTemp01> wlTemp01s, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移,并进行排他
	 * @param wlTemp01
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByExampleData(WlTemp01 wlTemp01, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移,并进行排他
	 * @param wlTemp01
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:17:09
	 */
	int updateByExampleSelectiveData(WlTemp01 wlTemp01, Example example, boolean exclusive);

}
