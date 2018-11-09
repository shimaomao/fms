package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeReceiptVo;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ContChargeRepository
 * @Description: 财务待收款Repository层
 * @date 2018-06-01
 */
public interface ContChargeRepository {

	/**
	 * @Title:
	 * @Description: 新增财务待收款
	 * @param contCharge
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int insertData(ContCharge contCharge);

	/**
	 * @Title:
	 * @Description: 批量保存财务待收款
	 * @param contCharges
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int insertDataList(List<ContCharge> contCharges);

	/**
	 * @Title:
	 * @Description: 修改财务待收款
	 * @param contCharge
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByPrimaryKeyData(ContCharge contCharge);

	/**
	 * @Title:
	 * @Description: 批量修改财务待收款
	 * @param contCharges
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByPrimaryKeyDataList(List<ContCharge> contCharges);

	/**
	 * @Title:
	 * @Description: 动态修改财务待收款
	 * @param contCharge
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByPrimaryKeySelectiveData(ContCharge contCharge);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务待收款
	 * @param contCharges
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContCharge> contCharges);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务待收款
	 * @param contCharge
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByExampleData(ContCharge contCharge, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务待收款
	 * @param contCharge
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByExampleSelectiveData(ContCharge contCharge, Example example);

	/**
	 * @Title:
	 * @Description: 根据contChargeId删除财务待收款
	 * @param contCharge
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int deleteData(ContCharge contCharge);

	/**
	 * @Title:
	 * @Description: 根据contChargeId集合批量删除财务待收款
	 * @param contChargeIds
	 * @param contCharge
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int deleteDataList(List contChargeIds, ContCharge contCharge);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务待收款
	 * @param example
	 * @param contCharge
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int deleteExampleData(Example example, ContCharge contCharge);

	/**
	 * @Title:
	 * @Description: 查询全部财务待收款
	 * @return List<ContCharge>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	List<ContCharge> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务待收款
	 * @param example
	 * @return ContCharge
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	ContCharge selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务待收款
	 * @param example
	 * @return List<ContCharge>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	List<ContCharge> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contChargeId查询财务待收款
	 * @param contChargeId
	 * @return ContCharge
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	ContCharge selectByPrimaryKey(Object contChargeId);

	/**
	 * @Title:
	 * @Description: 分页查询财务待收款
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContCharge>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	PageInfoExtend<ContCharge> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务待收款vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改财务待收款
	 * @param contCharge,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByPrimaryKeyData(ContCharge contCharge, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改财务待收款,并进行排他
	 * @param contCharges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByPrimaryKeyDataList(List<ContCharge> contCharges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改财务待收款,并进行排他
	 * @param contCharge
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(ContCharge contCharge, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务待收款,并进行排他
	 * @param contCharges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContCharge> contCharges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务待收款,并进行排他
	 * @param contCharge
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByExampleData(ContCharge contCharge, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务待收款,并进行排他
	 * @param contCharge
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:46
	 */
	int updateByExampleSelectiveData(ContCharge contCharge, Example example, boolean exclusive);

	/** 
	* @Description: 根据业务类型和业务号查询待收款数据和收款数据
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/28 11:04
	*/ 
    List<ContChargeReceiptVo> selectContChargeAndReceiptByBizIdAndBizType(String chargeBizId, String chargeBizType,String chargeFund);
}
