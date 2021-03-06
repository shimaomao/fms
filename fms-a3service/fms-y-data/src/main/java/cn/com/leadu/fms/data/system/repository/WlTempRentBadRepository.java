package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.WlTempRentBad;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTempRentBadRepository
 * @Description: 数据迁移Repository层
 * @date 2018-08-04
 */
public interface WlTempRentBadRepository {

	/**
	 * @Title:
	 * @Description: 新增数据迁移
	 * @param wlTempRentBad
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int insertData(WlTempRentBad wlTempRentBad);

	/**
	 * @Title:
	 * @Description: 批量保存数据迁移
	 * @param wlTempRentBads
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int insertDataList(List<WlTempRentBad> wlTempRentBads);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTempRentBad
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByPrimaryKeyData(WlTempRentBad wlTempRentBad);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移
	 * @param wlTempRentBads
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByPrimaryKeyDataList(List<WlTempRentBad> wlTempRentBads);

	/**
	 * @Title:
	 * @Description: 动态修改数据迁移
	 * @param wlTempRentBad
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByPrimaryKeySelectiveData(WlTempRentBad wlTempRentBad);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移
	 * @param wlTempRentBads
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTempRentBad> wlTempRentBads);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移
	 * @param wlTempRentBad
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByExampleData(WlTempRentBad wlTempRentBad, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移
	 * @param wlTempRentBad
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByExampleSelectiveData(WlTempRentBad wlTempRentBad, Example example);

	/**
	 * @Title:
	 * @Description: 根据rentBadId删除数据迁移
	 * @param wlTempRentBad
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int deleteData(WlTempRentBad wlTempRentBad);

	/**
	 * @Title:
	 * @Description: 根据rentBadId集合批量删除数据迁移
	 * @param rentBadIds
	 * @param wlTempRentBad
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int deleteDataList(List rentBadIds, WlTempRentBad wlTempRentBad);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除数据迁移
	 * @param example
	 * @param wlTempRentBad
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int deleteExampleData(Example example, WlTempRentBad wlTempRentBad);

	/**
	 * @Title:
	 * @Description: 查询全部数据迁移
	 * @return List<WlTempRentBad>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	List<WlTempRentBad> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个数据迁移
	 * @param example
	 * @return WlTempRentBad
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	WlTempRentBad selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询数据迁移
	 * @param example
	 * @return List<WlTempRentBad>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	List<WlTempRentBad> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过rentBadId查询数据迁移
	 * @param rentBadId
	 * @return WlTempRentBad
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	WlTempRentBad selectByPrimaryKey(Object rentBadId);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<WlTempRentBad>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	PageInfoExtend<WlTempRentBad> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTempRentBad,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByPrimaryKeyData(WlTempRentBad wlTempRentBad, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移,并进行排他
	 * @param wlTempRentBads
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByPrimaryKeyDataList(List<WlTempRentBad> wlTempRentBads, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改数据迁移,并进行排他
	 * @param wlTempRentBad
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(WlTempRentBad wlTempRentBad, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移,并进行排他
	 * @param wlTempRentBads
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTempRentBad> wlTempRentBads, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移,并进行排他
	 * @param wlTempRentBad
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByExampleData(WlTempRentBad wlTempRentBad, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移,并进行排他
	 * @param wlTempRentBad
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:18:48
	 */
	int updateByExampleSelectiveData(WlTempRentBad wlTempRentBad, Example example, boolean exclusive);

}
