package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: AccountDetailRepository
 * @Description: 银行流水Repository层
 * @date 2018-06-04
 */
public interface AccountDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增银行流水
	 * @param accountDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int insertData(AccountDetail accountDetail);

	/**
	 * @Title:
	 * @Description: 批量保存银行流水
	 * @param accountDetails
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int insertDataList(List<AccountDetail> accountDetails);

	/**
	 * @Title:
	 * @Description: 修改银行流水
	 * @param accountDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByPrimaryKeyData(AccountDetail accountDetail);

	/**
	 * @Title:
	 * @Description: 批量修改银行流水
	 * @param accountDetails
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByPrimaryKeyDataList(List<AccountDetail> accountDetails);

	/**
	 * @Title:
	 * @Description: 动态修改银行流水
	 * @param accountDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByPrimaryKeySelectiveData(AccountDetail accountDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改银行流水
	 * @param accountDetails
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByPrimaryKeySelectiveDataList(List<AccountDetail> accountDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改银行流水
	 * @param accountDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByExampleData(AccountDetail accountDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改银行流水
	 * @param accountDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByExampleSelectiveData(AccountDetail accountDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据accountDetailId删除银行流水
	 * @param accountDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int deleteData(AccountDetail accountDetail);

	/**
	 * @Title:
	 * @Description: 根据accountDetailId集合批量删除银行流水
	 * @param accountDetailIds
	 * @param accountDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int deleteDataList(List<String> accountDetailIds, AccountDetail accountDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除银行流水
	 * @param example
	 * @param accountDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int deleteExampleData(Example example,AccountDetail accountDetail);

	/**
	 * @Title:
	 * @Description: 查询全部银行流水
	 * @return List<AccountDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	List<AccountDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个银行流水
	 * @param example
	 * @return AccountDetail
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	AccountDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询银行流水
	 * @param example
	 * @return List<AccountDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	List<AccountDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过accountDetailId查询银行流水
	 * @param accountDetailId
	 * @return AccountDetail
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	AccountDetail selectByPrimaryKey(Object accountDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询银行流水
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<AccountDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	PageInfoExtend<AccountDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询银行流水vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改银行流水
	 * @param accountDetail,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByPrimaryKeyData(AccountDetail accountDetail,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改银行流水,并进行排他
	 * @param accountDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByPrimaryKeyDataList(List<AccountDetail> accountDetails,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改银行流水,并进行排他
	 * @param accountDetail
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(AccountDetail accountDetail,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改银行流水,并进行排他
	 * @param accountDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByPrimaryKeySelectiveDataList(List<AccountDetail> accountDetails,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改银行流水,并进行排他
	 * @param accountDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByExampleData(AccountDetail accountDetail, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改银行流水,并进行排他
	 * @param accountDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	int updateByExampleSelectiveData(AccountDetail accountDetail, Example example,boolean exclusive);

}
