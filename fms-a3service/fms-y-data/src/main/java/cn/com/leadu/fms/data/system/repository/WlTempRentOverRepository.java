package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.WlTempRentOver;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTempRentOverRepository
 * @Description: 数据迁移Repository层
 * @date 2018-08-04
 */
public interface WlTempRentOverRepository {

	/**
	 * @Title:
	 * @Description: 新增数据迁移
	 * @param wlTempRentOver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int insertData(WlTempRentOver wlTempRentOver);

	/**
	 * @Title:
	 * @Description: 批量保存数据迁移
	 * @param wlTempRentOvers
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int insertDataList(List<WlTempRentOver> wlTempRentOvers);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTempRentOver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByPrimaryKeyData(WlTempRentOver wlTempRentOver);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移
	 * @param wlTempRentOvers
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByPrimaryKeyDataList(List<WlTempRentOver> wlTempRentOvers);

	/**
	 * @Title:
	 * @Description: 动态修改数据迁移
	 * @param wlTempRentOver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByPrimaryKeySelectiveData(WlTempRentOver wlTempRentOver);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移
	 * @param wlTempRentOvers
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTempRentOver> wlTempRentOvers);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移
	 * @param wlTempRentOver
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByExampleData(WlTempRentOver wlTempRentOver, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移
	 * @param wlTempRentOver
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByExampleSelectiveData(WlTempRentOver wlTempRentOver, Example example);

	/**
	 * @Title:
	 * @Description: 根据rentOverId删除数据迁移
	 * @param wlTempRentOver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int deleteData(WlTempRentOver wlTempRentOver);

	/**
	 * @Title:
	 * @Description: 根据rentOverId集合批量删除数据迁移
	 * @param rentOverIds
	 * @param wlTempRentOver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int deleteDataList(List rentOverIds, WlTempRentOver wlTempRentOver);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除数据迁移
	 * @param example
	 * @param wlTempRentOver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int deleteExampleData(Example example, WlTempRentOver wlTempRentOver);

	/**
	 * @Title:
	 * @Description: 查询全部数据迁移
	 * @return List<WlTempRentOver>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	List<WlTempRentOver> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个数据迁移
	 * @param example
	 * @return WlTempRentOver
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	WlTempRentOver selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询数据迁移
	 * @param example
	 * @return List<WlTempRentOver>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	List<WlTempRentOver> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过rentOverId查询数据迁移
	 * @param rentOverId
	 * @return WlTempRentOver
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	WlTempRentOver selectByPrimaryKey(Object rentOverId);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<WlTempRentOver>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	PageInfoExtend<WlTempRentOver> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTempRentOver,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByPrimaryKeyData(WlTempRentOver wlTempRentOver, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移,并进行排他
	 * @param wlTempRentOvers
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByPrimaryKeyDataList(List<WlTempRentOver> wlTempRentOvers, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改数据迁移,并进行排他
	 * @param wlTempRentOver
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(WlTempRentOver wlTempRentOver, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移,并进行排他
	 * @param wlTempRentOvers
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTempRentOver> wlTempRentOvers, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移,并进行排他
	 * @param wlTempRentOver
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByExampleData(WlTempRentOver wlTempRentOver, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移,并进行排他
	 * @param wlTempRentOver
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:17
	 */
	int updateByExampleSelectiveData(WlTempRentOver wlTempRentOver, Example example, boolean exclusive);

}
