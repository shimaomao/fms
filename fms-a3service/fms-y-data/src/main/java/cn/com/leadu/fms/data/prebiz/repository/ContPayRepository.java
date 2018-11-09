package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.vo.contpay.ContPayVo;
import java.util.List;
import tk.mybatis.mapper.entity.Example;

/**
 * @author liujinge
 * @ClassName: ContPayRepository
 * @Description: 财务付款表Repository层
 * @date 2018-04-11
 */
public interface ContPayRepository {

	/**
	 * @Title:
	 * @Description: 新增财务付款表
	 * @param contPay
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int insertData(ContPay contPay);

	/**
	 * @Title:
	 * @Description: 批量保存财务付款表
	 * @param contPays
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int insertDataList(List<ContPay> contPays);

	/**
	 * @Title:
	 * @Description: 修改财务付款表
	 * @param contPay
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int updateByPrimaryKeyData(ContPay contPay);

	/**
	 * @Title:
	 * @Description: 批量修改财务付款表
	 * @param contPays
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int updateByPrimaryKeyDataList(List<ContPay> contPays);

	/**
	 * @Title:
	 * @Description: 动态修改财务付款表
	 * @param contPay
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int updateByPrimaryKeySelectiveData(ContPay contPay);

	/**
	 * @Title:
	 * @Description: 动态修改财务付款表,并进行排他
	 * @param contPay
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(ContPay contPay, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务付款表
	 * @param contPays
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContPay> contPays);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务付款表
	 * @param contPay
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int updateByExampleData(ContPay contPay, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务付款表
	 * @param contPay
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int updateByExampleSelectiveData(ContPay contPay, Example example);

	/**
	 * @Title:
	 * @Description: 根据contPayId删除财务付款表
	 * @param contPay
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int deleteData(ContPay contPay);

	/**
	 * @Title:
	 * @Description: 根据contPayId集合批量删除财务付款表
	 * @param contPayIds
	 * @param contPay
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int deleteDataList(List contPayIds, ContPay contPay);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务付款表
	 * @param example
	 * @param contPay
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	int deleteExampleData(Example example, ContPay contPay);

	/**
	 * @Title:
	 * @Description: 查询全部财务付款表
	 * @return List<ContPay>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	List<ContPay> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务付款表
	 * @param example
	 * @return ContPay
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	ContPay selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务付款表
	 * @param example
	 * @return List<ContPay>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	List<ContPay> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contPayId查询财务付款表
	 * @param contPayId
	 * @return ContPay
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	ContPay selectByPrimaryKey(Object contPayId);

	/**
	 * @Title:
	 * @Description: 分页查询财务付款表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContPay>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	PageInfoExtend<ContPay> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务付款表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ContPay>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	PageInfoExtend<ContPay> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务付款表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ContPay>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:16
	 */
	PageInfoExtend<ContPayVo> selectListVosByPage(String methodName, Object param, PageQuery pageQuery);

}
