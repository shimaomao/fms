package cn.com.leadu.fms.data.cost.repository;

import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementRepository
 * @Description: gps月结任务表Repository层
 * @date 2018-05-28
 */
public interface MonthlySettlementRepository {

	/**
	 * @Title:
	 * @Description: 新增gps月结任务表
	 * @param monthlySettlement
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int insertData(MonthlySettlement monthlySettlement);

	/**
	 * @Title:
	 * @Description: 批量保存gps月结任务表
	 * @param monthlySettlements
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int insertDataList(List<MonthlySettlement> monthlySettlements);

	/**
	 * @Title:
	 * @Description: 修改gps月结任务表
	 * @param monthlySettlement
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int updateByPrimaryKeyData(MonthlySettlement monthlySettlement);

	/**
	 * @Title:
	 * @Description: 批量修改gps月结任务表
	 * @param monthlySettlements
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int updateByPrimaryKeyDataList(List<MonthlySettlement> monthlySettlements);

	/**
	 * @Title:
	 * @Description: 动态修改gps月结任务表
	 * @param monthlySettlement
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int updateByPrimaryKeySelectiveData(MonthlySettlement monthlySettlement);

	/**
	 * @Title:
	 * @Description: 批量动态修改gps月结任务表
	 * @param monthlySettlements
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int updateByPrimaryKeySelectiveDataList(List<MonthlySettlement> monthlySettlements);

	/**
	 * @Title:
	 * @Description: 根据条件修改gps月结任务表
	 * @param monthlySettlement
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int updateByExampleData(MonthlySettlement monthlySettlement, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改gps月结任务表
	 * @param monthlySettlement
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int updateByExampleSelectiveData(MonthlySettlement monthlySettlement, Example example);

	/**
	 * @Title:
	 * @Description: 根据monthlySettlementId删除gps月结任务表
	 * @param monthlySettlement
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int deleteData(MonthlySettlement monthlySettlement);

	/**
	 * @Title:
	 * @Description: 根据monthlySettlementId集合批量删除gps月结任务表
	 * @param monthlySettlementIds
	 * @param monthlySettlement
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int deleteDataList(List monthlySettlementIds,MonthlySettlement monthlySettlement);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除gps月结任务表
	 * @param example
	 * @param monthlySettlement
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	int deleteExampleData(Example example,MonthlySettlement monthlySettlement);

	/**
	 * @Title:
	 * @Description: 查询全部gps月结任务表
	 * @return List<MonthlySettlement>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	List<MonthlySettlement> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个gps月结任务表
	 * @param example
	 * @return MonthlySettlement
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	MonthlySettlement selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询gps月结任务表
	 * @param example
	 * @return List<MonthlySettlement>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	List<MonthlySettlement> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过monthlySettlementId查询gps月结任务表
	 * @param monthlySettlementId
	 * @return MonthlySettlement
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	MonthlySettlement selectByPrimaryKey(Object monthlySettlementId);

	/**
	 * @Title:
	 * @Description: 分页查询gps月结任务表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<MonthlySettlement>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	PageInfoExtend<MonthlySettlement> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询gps月结任务表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

}
