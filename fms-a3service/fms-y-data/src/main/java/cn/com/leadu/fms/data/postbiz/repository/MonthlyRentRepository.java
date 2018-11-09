package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: MonthlyRentRepository
 * @Description: 月度租金到账率Repository层
 */
public interface MonthlyRentRepository {

	/**
	 * @Title:
	 * @Description: 新增月度租金到账率
	 * @param monthlyRent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int insertData(MonthlyRent monthlyRent);

	/**
	 * @Title:
	 * @Description: 批量保存月度租金到账率
	 * @param monthlyRents
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int insertDataList(List<MonthlyRent> monthlyRents);

	/**
	 * @Title:
	 * @Description: 修改月度租金到账率
	 * @param monthlyRent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByPrimaryKeyData(MonthlyRent monthlyRent);

	/**
	 * @Title:
	 * @Description: 批量修改月度租金到账率
	 * @param monthlyRents
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByPrimaryKeyDataList(List<MonthlyRent> monthlyRents);

	/**
	 * @Title:
	 * @Description: 动态修改月度租金到账率
	 * @param monthlyRent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByPrimaryKeySelectiveData(MonthlyRent monthlyRent);

	/**
	 * @Title:
	 * @Description: 批量动态修改月度租金到账率
	 * @param monthlyRents
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByPrimaryKeySelectiveDataList(List<MonthlyRent> monthlyRents);

	/**
	 * @Title:
	 * @Description: 根据条件修改月度租金到账率
	 * @param monthlyRent
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByExampleData(MonthlyRent monthlyRent, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改月度租金到账率
	 * @param monthlyRent
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByExampleSelectiveData(MonthlyRent monthlyRent, Example example);

	/**
	 * @Title:
	 * @Description: 根据monthlyRentId删除月度租金到账率
	 * @param monthlyRent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int deleteData(MonthlyRent monthlyRent);

	/**
	 * @Title:
	 * @Description: 根据monthlyRentId集合批量删除月度租金到账率
	 * @param monthlyRentIds
	 * @param monthlyRent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int deleteDataList(List monthlyRentIds, MonthlyRent monthlyRent);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除月度租金到账率
	 * @param example
	 * @param monthlyRent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int deleteExampleData(Example example, MonthlyRent monthlyRent);

	/**
	 * @Title:
	 * @Description: 查询全部月度租金到账率
	 * @return List<MonthlyRent>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	List<MonthlyRent> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个月度租金到账率
	 * @param example
	 * @return MonthlyRent
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	MonthlyRent selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询月度租金到账率
	 * @param example
	 * @return List<MonthlyRent>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	List<MonthlyRent> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过monthlyRentId查询月度租金到账率
	 * @param monthlyRentId
	 * @return MonthlyRent
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	MonthlyRent selectByPrimaryKey(Object monthlyRentId);

	/**
	 * @Title:
	 * @Description: 分页查询月度租金到账率
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<MonthlyRent>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	PageInfoExtend<MonthlyRent> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询月度租金到账率vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改月度租金到账率
	 * @param monthlyRent,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByPrimaryKeyData(MonthlyRent monthlyRent, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改月度租金到账率,并进行排他
	 * @param monthlyRents
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByPrimaryKeyDataList(List<MonthlyRent> monthlyRents, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改月度租金到账率,并进行排他
	 * @param monthlyRent
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(MonthlyRent monthlyRent, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改月度租金到账率,并进行排他
	 * @param monthlyRents
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByPrimaryKeySelectiveDataList(List<MonthlyRent> monthlyRents, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改月度租金到账率,并进行排他
	 * @param monthlyRent
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByExampleData(MonthlyRent monthlyRent, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改月度租金到账率,并进行排他
	 * @param monthlyRent
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:11:34
	 */
	int updateByExampleSelectiveData(MonthlyRent monthlyRent, Example example, boolean exclusive);

}
