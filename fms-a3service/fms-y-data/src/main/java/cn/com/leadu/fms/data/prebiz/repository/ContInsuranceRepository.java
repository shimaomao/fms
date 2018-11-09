package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContInsuranceRepository
 * @Description: 合同车辆保险信息Repository层
 * @date 2018-06-11
 */
public interface ContInsuranceRepository {

	/**
	 * @Title:
	 * @Description: 新增合同车辆保险信息
	 * @param contInsurance
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int insertData(ContInsurance contInsurance);

	/**
	 * @Title:
	 * @Description: 批量保存合同车辆保险信息
	 * @param contInsurances
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int insertDataList(List<ContInsurance> contInsurances);

	/**
	 * @Title:
	 * @Description: 修改合同车辆保险信息
	 * @param contInsurance
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByPrimaryKeyData(ContInsurance contInsurance);

	/**
	 * @Title:
	 * @Description: 批量修改合同车辆保险信息
	 * @param contInsurances
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByPrimaryKeyDataList(List<ContInsurance> contInsurances);

	/**
	 * @Title:
	 * @Description: 动态修改合同车辆保险信息
	 * @param contInsurance
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByPrimaryKeySelectiveData(ContInsurance contInsurance);

	/**
	 * @Title:
	 * @Description: 批量动态修改合同车辆保险信息
	 * @param contInsurances
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContInsurance> contInsurances);

	/**
	 * @Title:
	 * @Description: 根据条件修改合同车辆保险信息
	 * @param contInsurance
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByExampleData(ContInsurance contInsurance, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改合同车辆保险信息
	 * @param contInsurance
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByExampleSelectiveData(ContInsurance contInsurance, Example example);

	/**
	 * @Title:
	 * @Description: 根据contVehinsId删除合同车辆保险信息
	 * @param contInsurance
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int deleteData(ContInsurance contInsurance);

	/**
	 * @Title:
	 * @Description: 根据contVehinsId集合批量删除合同车辆保险信息
	 * @param contVehinsIds
	 * @param contInsurance
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int deleteDataList(List contVehinsIds,ContInsurance contInsurance);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除合同车辆保险信息
	 * @param example
	 * @param contInsurance
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int deleteExampleData(Example example,ContInsurance contInsurance);

	/**
	 * @Title:
	 * @Description: 查询全部合同车辆保险信息
	 * @return List<ContInsurance>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	List<ContInsurance> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个合同车辆保险信息
	 * @param example
	 * @return ContInsurance
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	ContInsurance selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询合同车辆保险信息
	 * @param example
	 * @return List<ContInsurance>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	List<ContInsurance> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contVehinsId查询合同车辆保险信息
	 * @param contVehinsId
	 * @return ContInsurance
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	ContInsurance selectByPrimaryKey(Object contVehinsId);

	/**
	 * @Title:
	 * @Description: 分页查询合同车辆保险信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContInsurance>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	PageInfoExtend<ContInsurance> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询合同车辆保险信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改合同车辆保险信息
	 * @param contInsurance,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByPrimaryKeyData(ContInsurance contInsurance,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改合同车辆保险信息,并进行排他
	 * @param contInsurances
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByPrimaryKeyDataList(List<ContInsurance> contInsurances,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改合同车辆保险信息,并进行排他
	 * @param contInsurance
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(ContInsurance contInsurance,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改合同车辆保险信息,并进行排他
	 * @param contInsurances
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContInsurance> contInsurances,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改合同车辆保险信息,并进行排他
	 * @param contInsurance
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByExampleData(ContInsurance contInsurance, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改合同车辆保险信息,并进行排他
	 * @param contInsurance
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:25:35
	 */
	int updateByExampleSelectiveData(ContInsurance contInsurance, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据状态查询车辆保险信息
	 * @param
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-11 18:48:00
	 */
	 List<ContInsuranceVo>  selectContInsuranceByStatus(ContInsuranceVo contInsurance);
}
