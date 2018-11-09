package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyFinanceRepository
 * @Description: 融资信息Repository层
 * @date 2018-03-24
 */
public interface ApplyFinanceRepository {

	/**
	 * @Title:
	 * @Description: 新增融资信息
	 * @param applyFinance
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int insertData(ApplyFinance applyFinance);

	/**
	 * @Title:
	 * @Description: 批量保存融资信息
	 * @param applyFinances
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int insertDataList(List<ApplyFinance> applyFinances);

	/**
	 * @Title:
	 * @Description: 修改融资信息
	 * @param applyFinance
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int updateByPrimaryKeyData(ApplyFinance applyFinance);

	/**
	 * @Title:
	 * @Description: 批量修改融资信息
	 * @param applyFinances
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int updateByPrimaryKeyDataList(List<ApplyFinance> applyFinances);

	/**
	 * @Title:
	 * @Description: 动态修改融资信息
	 * @param applyFinance
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int updateByPrimaryKeySelectiveData(ApplyFinance applyFinance);

	/**
	 * @Title:
	 * @Description: 批量动态修改融资信息
	 * @param applyFinances
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int updateByPrimaryKeySelectiveDataList(List<ApplyFinance> applyFinances);

	/**
	 * @Title:
	 * @Description: 根据条件修改融资信息
	 * @param applyFinance
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int updateByExampleData(ApplyFinance applyFinance, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改融资信息
	 * @param applyFinance
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int updateByExampleSelectiveData(ApplyFinance applyFinance, Example example);

	/**
	 * @Title:
	 * @Description: 根据applyFinId删除融资信息
	 * @param applyFinance
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int deleteData(ApplyFinance applyFinance);

	/**
	 * @Title:
	 * @Description: 根据applyFinId集合批量删除融资信息
	 * @param applyFinIds
	 * @param applyFinance
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	int deleteDataList(List applyFinIds, ApplyFinance applyFinance);

	/**
	 * @Title:
	 * @Description: 查询全部融资信息
	 * @return List<ApplyFinance>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	List<ApplyFinance> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个融资信息
	 * @param example
	 * @return ApplyFinance
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	ApplyFinance selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询融资信息
	 * @param example
	 * @return List<ApplyFinance>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	List<ApplyFinance> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过applyFinId查询融资信息
	 * @param applyFinId
	 * @return ApplyFinance
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	ApplyFinance selectByPrimaryKey(Object applyFinId);

	/**
	 * @Title:
	 * @Description: 分页查询融资信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ApplyFinance>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	PageInfoExtend<ApplyFinance> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ApplyFinance>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	PageInfoExtend<ApplyFinance> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据订单编号 获取融资信息
	 * @param applyNo 订单编号
	 * @return ApplyFinanceVo
	 * @throws
	 * @author wangxue
	 * @date 2018-3-29 17:39:58
	 */
	ApplyFinanceVo selectApplyFinanceVoByApplyNo(String applyNo);

}
