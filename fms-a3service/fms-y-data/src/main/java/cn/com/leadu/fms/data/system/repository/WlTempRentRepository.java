package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.WlTempRent;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTempRentRepository
 * @Description: 数据迁移Repository层
 * @date 2018-08-04
 */
public interface WlTempRentRepository {

	/**
	 * @Title:
	 * @Description: 新增数据迁移
	 * @param wlTempRent
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int insertData(WlTempRent wlTempRent);

	/**
	 * @Title:
	 * @Description: 批量保存数据迁移
	 * @param wlTempRents
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int insertDataList(List<WlTempRent> wlTempRents);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTempRent
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByPrimaryKeyData(WlTempRent wlTempRent);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移
	 * @param wlTempRents
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByPrimaryKeyDataList(List<WlTempRent> wlTempRents);

	/**
	 * @Title:
	 * @Description: 动态修改数据迁移
	 * @param wlTempRent
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByPrimaryKeySelectiveData(WlTempRent wlTempRent);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移
	 * @param wlTempRents
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTempRent> wlTempRents);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移
	 * @param wlTempRent
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByExampleData(WlTempRent wlTempRent, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移
	 * @param wlTempRent
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByExampleSelectiveData(WlTempRent wlTempRent, Example example);

	/**
	 * @Title:
	 * @Description: 根据rentId删除数据迁移
	 * @param wlTempRent
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int deleteData(WlTempRent wlTempRent);

	/**
	 * @Title:
	 * @Description: 根据rentId集合批量删除数据迁移
	 * @param rentIds
	 * @param wlTempRent
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int deleteDataList(List rentIds, WlTempRent wlTempRent);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除数据迁移
	 * @param example
	 * @param wlTempRent
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int deleteExampleData(Example example, WlTempRent wlTempRent);

	/**
	 * @Title:
	 * @Description: 查询全部数据迁移
	 * @return List<WlTempRent>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	List<WlTempRent> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个数据迁移
	 * @param example
	 * @return WlTempRent
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	WlTempRent selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询数据迁移
	 * @param example
	 * @return List<WlTempRent>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	List<WlTempRent> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过rentId查询数据迁移
	 * @param rentId
	 * @return WlTempRent
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	WlTempRent selectByPrimaryKey(Object rentId);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<WlTempRent>
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	PageInfoExtend<WlTempRent> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询数据迁移vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改数据迁移
	 * @param wlTempRent,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByPrimaryKeyData(WlTempRent wlTempRent, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改数据迁移,并进行排他
	 * @param wlTempRents
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByPrimaryKeyDataList(List<WlTempRent> wlTempRents, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改数据迁移,并进行排他
	 * @param wlTempRent
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(WlTempRent wlTempRent, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改数据迁移,并进行排他
	 * @param wlTempRents
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByPrimaryKeySelectiveDataList(List<WlTempRent> wlTempRents, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改数据迁移,并进行排他
	 * @param wlTempRent
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByExampleData(WlTempRent wlTempRent, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改数据迁移,并进行排他
	 * @param wlTempRent
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-8-4 18:27:19
	 */
	int updateByExampleSelectiveData(WlTempRent wlTempRent, Example example, boolean exclusive);

}
