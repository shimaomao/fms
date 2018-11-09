package cn.com.leadu.fms.data.cost.repository;

import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentRepository
 * @Description: 提前还款Repository层
 * @date 2018-05-10
 */
public interface ContPrepaymentRepository {

	/**
	 * @Title:
	 * @Description: 新增提前还款
	 * @param contPrepayment
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int insertData(ContPrepayment contPrepayment);

	/**
	 * @Title:
	 * @Description: 批量保存提前还款
	 * @param contPrepayments
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int insertDataList(List<ContPrepayment> contPrepayments);

	/**
	 * @Title:
	 * @Description: 修改提前还款
	 * @param contPrepayment
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int updateByPrimaryKeyData(ContPrepayment contPrepayment);

	/**
	 * @Title:
	 * @Description: 批量修改提前还款
	 * @param contPrepayments
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int updateByPrimaryKeyDataList(List<ContPrepayment> contPrepayments);

	/**
	 * @Title:
	 * @Description: 动态修改提前还款
	 * @param contPrepayment
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int updateByPrimaryKeySelectiveData(ContPrepayment contPrepayment);

	/**
	 * @Title:
	 * @Description: 批量动态修改提前还款
	 * @param contPrepayments
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContPrepayment> contPrepayments);

	/**
	 * @Title:
	 * @Description: 批量动态修改提前还款，并进行排他
	 * @param contPrepayments
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContPrepayment> contPrepayments, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改提前还款
	 * @param contPrepayment
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int updateByExampleData(ContPrepayment contPrepayment, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改提前还款
	 * @param contPrepayment
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int updateByExampleSelectiveData(ContPrepayment contPrepayment, Example example);

	/**
	 * @Title:
	 * @Description: 根据contPrepaymentId删除提前还款
	 * @param contPrepayment
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int deleteData(ContPrepayment contPrepayment);

	/**
	 * @Title:
	 * @Description: 根据contPrepaymentId集合批量删除提前还款
	 * @param contPrepaymentIds
	 * @param contPrepayment
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int deleteDataList(List contPrepaymentIds,ContPrepayment contPrepayment);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除提前还款
	 * @param example
	 * @param contPrepayment
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	int deleteExampleData(Example example,ContPrepayment contPrepayment);

	/**
	 * @Title:
	 * @Description: 查询全部提前还款
	 * @return List<ContPrepayment>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	List<ContPrepayment> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个提前还款
	 * @param example
	 * @return ContPrepayment
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	ContPrepayment selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询提前还款
	 * @param example
	 * @return List<ContPrepayment>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	List<ContPrepayment> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contPrepaymentId查询提前还款
	 * @param contPrepaymentId
	 * @return ContPrepayment
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	ContPrepayment selectByPrimaryKey(Object contPrepaymentId);

	/**
	 * @Title:
	 * @Description: 分页查询提前还款
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContPrepayment>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	PageInfoExtend<ContPrepayment> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询提前还款vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/** 
	* @Description: 通过合同号查询提前还款相关信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/19 19:59
	*/ 
	ContPrepaymentVo selectContPrepaymentByContNo(ContPrepaymentVo contPrepaymentVo);

	/**
	* @Description: 查找当日>提前还款失效日 且 合同未结清的提前还款
	* @param: uncleared 未结清状态
	* @param: prepaymentInvalid 提前还款作废状态
	* @return:
	* @Author: yangyiquan
	* @Date: 2018/10/24 17:18
	*/
	List<ContPrepaymentVo> selectInValidContPrepayment(String uncleared,String prepaymentInvalid,String prepaymentValid);
}
