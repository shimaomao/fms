package cn.com.leadu.fms.data.cost.repository;

import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.CstmDetailVo;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.PilferInsuranceVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceRepository
 * @Description: 盗抢险信息Repository层
 * @date 2018-05-31
 */
public interface PilferInsuranceRepository {

	/**
	 * @Title:
	 * @Description: 新增盗抢险信息
	 * @param pilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int insertData(PilferInsurance pilferInsurance);

	/**
	 * @Title:
	 * @Description: 批量保存盗抢险信息
	 * @param pilferInsurances
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int insertDataList(List<PilferInsurance> pilferInsurances);

	/**
	 * @Title:
	 * @Description: 修改盗抢险信息
	 * @param pilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByPrimaryKeyData(PilferInsurance pilferInsurance);

	/**
	 * @Title:
	 * @Description: 批量修改盗抢险信息
	 * @param pilferInsurances
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByPrimaryKeyDataList(List<PilferInsurance> pilferInsurances);

	/**
	 * @Title:
	 * @Description: 动态修改盗抢险信息
	 * @param pilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByPrimaryKeySelectiveData(PilferInsurance pilferInsurance);

	/**
	 * @Title:
	 * @Description: 批量动态修改盗抢险信息
	 * @param pilferInsurances
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByPrimaryKeySelectiveDataList(List<PilferInsurance> pilferInsurances);

	/**
	 * @Title:
	 * @Description: 根据条件修改盗抢险信息
	 * @param pilferInsurance
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByExampleData(PilferInsurance pilferInsurance, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改盗抢险信息
	 * @param pilferInsurance
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByExampleSelectiveData(PilferInsurance pilferInsurance, Example example);

	/**
	 * @Title:
	 * @Description: 根据pilferInsuranceId删除盗抢险信息
	 * @param pilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int deleteData(PilferInsurance pilferInsurance);

	/**
	 * @Title:
	 * @Description: 根据pilferInsuranceId集合批量删除盗抢险信息
	 * @param pilferInsuranceIds
	 * @param pilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int deleteDataList(List pilferInsuranceIds,PilferInsurance pilferInsurance);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除盗抢险信息
	 * @param example
	 * @param pilferInsurance
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int deleteExampleData(Example example,PilferInsurance pilferInsurance);

	/**
	 * @Title:
	 * @Description: 查询全部盗抢险信息
	 * @return List<PilferInsurance>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	List<PilferInsurance> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个盗抢险信息
	 * @param example
	 * @return PilferInsurance
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	PilferInsurance selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询盗抢险信息
	 * @param example
	 * @return List<PilferInsurance>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	List<PilferInsurance> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pilferInsuranceId查询盗抢险信息
	 * @param pilferInsuranceId
	 * @return PilferInsurance
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	PilferInsurance selectByPrimaryKey(Object pilferInsuranceId);

	/**
	 * @Title:
	 * @Description: 分页查询盗抢险信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PilferInsurance>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	PageInfoExtend<PilferInsurance> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询盗抢险信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改盗抢险信息
	 * @param pilferInsurance,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByPrimaryKeyData(PilferInsurance pilferInsurance,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改盗抢险信息,并进行排他
	 * @param pilferInsurances
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByPrimaryKeyDataList(List<PilferInsurance> pilferInsurances,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改盗抢险信息,并进行排他
	 * @param pilferInsurance
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PilferInsurance pilferInsurance,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改盗抢险信息,并进行排他
	 * @param pilferInsurances
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByPrimaryKeySelectiveDataList(List<PilferInsurance> pilferInsurances,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改盗抢险信息,并进行排他
	 * @param pilferInsurance
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByExampleData(PilferInsurance pilferInsurance, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改盗抢险信息,并进行排他
	 * @param pilferInsurance
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	int updateByExampleSelectiveData(PilferInsurance pilferInsurance, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据合同号查询一条客户基本信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	CstmDetailVo selectOneCstmDetailByContNo(String contNo);

}
