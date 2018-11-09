package cn.com.leadu.fms.data.cost.repository;

import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceRepository
 * @Description: 盗抢险月结任务信息Repository层
 * @date 2018-05-31
 */
public interface MonthlyPilferInsuranceRepository {

	/**
	 * @Title:
	 * @Description: 新增盗抢险月结任务信息
	 * @param monthlyPilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int insertData(MonthlyPilferInsurance monthlyPilferInsurance);

	/**
	 * @Title:
	 * @Description: 批量保存盗抢险月结任务信息
	 * @param monthlyPilferInsurances
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int insertDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances);

	/**
	 * @Title:
	 * @Description: 修改盗抢险月结任务信息
	 * @param monthlyPilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByPrimaryKeyData(MonthlyPilferInsurance monthlyPilferInsurance);

	/**
	 * @Title:
	 * @Description: 批量修改盗抢险月结任务信息
	 * @param monthlyPilferInsurances
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByPrimaryKeyDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances);

	/**
	 * @Title:
	 * @Description: 动态修改盗抢险月结任务信息
	 * @param monthlyPilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByPrimaryKeySelectiveData(MonthlyPilferInsurance monthlyPilferInsurance);

	/**
	 * @Title:
	 * @Description: 批量动态修改盗抢险月结任务信息
	 * @param monthlyPilferInsurances
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByPrimaryKeySelectiveDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances);

	/**
	 * @Title:
	 * @Description: 根据条件修改盗抢险月结任务信息
	 * @param monthlyPilferInsurance
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByExampleData(MonthlyPilferInsurance monthlyPilferInsurance, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改盗抢险月结任务信息
	 * @param monthlyPilferInsurance
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByExampleSelectiveData(MonthlyPilferInsurance monthlyPilferInsurance, Example example);

	/**
	 * @Title:
	 * @Description: 根据monthlyPilferInsuranceId删除盗抢险月结任务信息
	 * @param monthlyPilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int deleteData(MonthlyPilferInsurance monthlyPilferInsurance);

	/**
	 * @Title:
	 * @Description: 根据monthlyPilferInsuranceId集合批量删除盗抢险月结任务信息
	 * @param monthlyPilferInsuranceIds
	 * @param monthlyPilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int deleteDataList(List monthlyPilferInsuranceIds,MonthlyPilferInsurance monthlyPilferInsurance);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除盗抢险月结任务信息
	 * @param example
	 * @param monthlyPilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int deleteExampleData(Example example,MonthlyPilferInsurance monthlyPilferInsurance);

	/**
	 * @Title:
	 * @Description: 查询全部盗抢险月结任务信息
	 * @return List<MonthlyPilferInsurance>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	List<MonthlyPilferInsurance> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个盗抢险月结任务信息
	 * @param example
	 * @return MonthlyPilferInsurance
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	MonthlyPilferInsurance selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询盗抢险月结任务信息
	 * @param example
	 * @return List<MonthlyPilferInsurance>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	List<MonthlyPilferInsurance> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过monthlyPilferInsuranceId查询盗抢险月结任务信息
	 * @param monthlyPilferInsuranceId
	 * @return MonthlyPilferInsurance
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	MonthlyPilferInsurance selectByPrimaryKey(Object monthlyPilferInsuranceId);

	/**
	 * @Title:
	 * @Description: 分页查询盗抢险月结任务信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<MonthlyPilferInsurance>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	PageInfoExtend<MonthlyPilferInsurance> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询盗抢险月结任务信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改盗抢险月结任务信息
	 * @param monthlyPilferInsurance,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByPrimaryKeyData(MonthlyPilferInsurance monthlyPilferInsurance,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改盗抢险月结任务信息,并进行排他
	 * @param monthlyPilferInsurances
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByPrimaryKeyDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改盗抢险月结任务信息,并进行排他
	 * @param monthlyPilferInsurance
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(MonthlyPilferInsurance monthlyPilferInsurance,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改盗抢险月结任务信息,并进行排他
	 * @param monthlyPilferInsurances
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByPrimaryKeySelectiveDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改盗抢险月结任务信息,并进行排他
	 * @param monthlyPilferInsurance
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByExampleData(MonthlyPilferInsurance monthlyPilferInsurance, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改盗抢险月结任务信息,并进行排他
	 * @param monthlyPilferInsurance
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	int updateByExampleSelectiveData(MonthlyPilferInsurance monthlyPilferInsurance, Example example,boolean exclusive);

}
