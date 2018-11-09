package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyOverdue;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: MonthlyOverdueRepository
 * @Description: 逾期率统计Repository层
 */
public interface MonthlyOverdueRepository {

	/**
	 * @Title:
	 * @Description: 新增逾期率统计
	 * @param monthlyOverdue
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int insertData(MonthlyOverdue monthlyOverdue);

	/**
	 * @Title:
	 * @Description: 批量保存逾期率统计
	 * @param monthlyOverdues
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int insertDataList(List<MonthlyOverdue> monthlyOverdues);

	/**
	 * @Title:
	 * @Description: 修改逾期率统计
	 * @param monthlyOverdue
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByPrimaryKeyData(MonthlyOverdue monthlyOverdue);

	/**
	 * @Title:
	 * @Description: 批量修改逾期率统计
	 * @param monthlyOverdues
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByPrimaryKeyDataList(List<MonthlyOverdue> monthlyOverdues);

	/**
	 * @Title:
	 * @Description: 动态修改逾期率统计
	 * @param monthlyOverdue
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByPrimaryKeySelectiveData(MonthlyOverdue monthlyOverdue);

	/**
	 * @Title:
	 * @Description: 批量动态修改逾期率统计
	 * @param monthlyOverdues
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<MonthlyOverdue> monthlyOverdues);

	/**
	 * @Title:
	 * @Description: 根据条件修改逾期率统计
	 * @param monthlyOverdue
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByExampleData(MonthlyOverdue monthlyOverdue, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改逾期率统计
	 * @param monthlyOverdue
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByExampleSelectiveData(MonthlyOverdue monthlyOverdue, Example example);

	/**
	 * @Title:
	 * @Description: 根据monthlyOverdueId删除逾期率统计
	 * @param monthlyOverdue
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int deleteData(MonthlyOverdue monthlyOverdue);

	/**
	 * @Title:
	 * @Description: 根据monthlyOverdueId集合批量删除逾期率统计
	 * @param monthlyOverdueIds
	 * @param monthlyOverdue
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int deleteDataList(List monthlyOverdueIds, MonthlyOverdue monthlyOverdue);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除逾期率统计
	 * @param example
	 * @param monthlyOverdue
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int deleteExampleData(Example example, MonthlyOverdue monthlyOverdue);

	/**
	 * @Title:
	 * @Description: 查询全部逾期率统计
	 * @return List<MonthlyOverdue>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	List<MonthlyOverdue> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个逾期率统计
	 * @param example
	 * @return MonthlyOverdue
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	MonthlyOverdue selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询逾期率统计
	 * @param example
	 * @return List<MonthlyOverdue>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	List<MonthlyOverdue> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过monthlyOverdueId查询逾期率统计
	 * @param monthlyOverdueId
	 * @return MonthlyOverdue
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	MonthlyOverdue selectByPrimaryKey(Object monthlyOverdueId);

	/**
	 * @Title:
	 * @Description: 分页查询逾期率统计
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<MonthlyOverdue>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	PageInfoExtend<MonthlyOverdue> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询逾期率统计vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改逾期率统计
	 * @param monthlyOverdue,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByPrimaryKeyData(MonthlyOverdue monthlyOverdue, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改逾期率统计,并进行排他
	 * @param monthlyOverdues
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByPrimaryKeyDataList(List<MonthlyOverdue> monthlyOverdues, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改逾期率统计,并进行排他
	 * @param monthlyOverdue
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(MonthlyOverdue monthlyOverdue, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改逾期率统计,并进行排他
	 * @param monthlyOverdues
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<MonthlyOverdue> monthlyOverdues, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改逾期率统计,并进行排他
	 * @param monthlyOverdue
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByExampleData(MonthlyOverdue monthlyOverdue, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改逾期率统计,并进行排他
	 * @param monthlyOverdue
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-25 17:12:17
	 */
	int updateByExampleSelectiveData(MonthlyOverdue monthlyOverdue, Example example, boolean exclusive);

}
