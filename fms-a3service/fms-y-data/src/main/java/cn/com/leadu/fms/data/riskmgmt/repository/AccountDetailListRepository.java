package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: AccountDetailListRepository
 * @Description: 银行流水明细Repository层
 * @date 2018-06-04
 */
public interface AccountDetailListRepository {

	/**
	 * @Title:
	 * @Description: 新增银行流水明细
	 * @param accountDetailList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int insertData(AccountDetailList accountDetailList);

	/**
	 * @Title:
	 * @Description: 批量保存银行流水明细
	 * @param accountDetailLists
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int insertDataList(List<AccountDetailList> accountDetailLists);

	/**
	 * @Title:
	 * @Description: 修改银行流水明细
	 * @param accountDetailList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByPrimaryKeyData(AccountDetailList accountDetailList);

	/**
	 * @Title:
	 * @Description: 批量修改银行流水明细
	 * @param accountDetailLists
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByPrimaryKeyDataList(List<AccountDetailList> accountDetailLists);

	/**
	 * @Title:
	 * @Description: 动态修改银行流水明细
	 * @param accountDetailList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByPrimaryKeySelectiveData(AccountDetailList accountDetailList);

	/**
	 * @Title:
	 * @Description: 批量动态修改银行流水明细
	 * @param accountDetailLists
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByPrimaryKeySelectiveDataList(List<AccountDetailList> accountDetailLists);

	/**
	 * @Title:
	 * @Description: 根据条件修改银行流水明细
	 * @param accountDetailList
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByExampleData(AccountDetailList accountDetailList, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改银行流水明细
	 * @param accountDetailList
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByExampleSelectiveData(AccountDetailList accountDetailList, Example example);

	/**
	 * @Title:
	 * @Description: 根据accountDetailListId删除银行流水明细
	 * @param accountDetailList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int deleteData(AccountDetailList accountDetailList);

	/**
	 * @Title:
	 * @Description: 根据accountDetailListId集合批量删除银行流水明细
	 * @param accountDetailListIds
	 * @param accountDetailList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int deleteDataList(List accountDetailListIds,AccountDetailList accountDetailList);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除银行流水明细
	 * @param example
	 * @param accountDetailList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int deleteExampleData(Example example,AccountDetailList accountDetailList);

	/**
	 * @Title:
	 * @Description: 查询全部银行流水明细
	 * @return List<AccountDetailList>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	List<AccountDetailList> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个银行流水明细
	 * @param example
	 * @return AccountDetailList
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	AccountDetailList selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询银行流水明细
	 * @param example
	 * @return List<AccountDetailList>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	List<AccountDetailList> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过accountDetailListId查询银行流水明细
	 * @param accountDetailListId
	 * @return AccountDetailList
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	AccountDetailList selectByPrimaryKey(Object accountDetailListId);

	/**
	 * @Title:
	 * @Description: 分页查询银行流水明细
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<AccountDetailList>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	PageInfoExtend<AccountDetailList> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询银行流水明细vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改银行流水明细
	 * @param accountDetailList,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByPrimaryKeyData(AccountDetailList accountDetailList,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改银行流水明细,并进行排他
	 * @param accountDetailLists
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByPrimaryKeyDataList(List<AccountDetailList> accountDetailLists,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改银行流水明细,并进行排他
	 * @param accountDetailList
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(AccountDetailList accountDetailList,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改银行流水明细,并进行排他
	 * @param accountDetailLists
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByPrimaryKeySelectiveDataList(List<AccountDetailList> accountDetailLists,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改银行流水明细,并进行排他
	 * @param accountDetailList
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByExampleData(AccountDetailList accountDetailList, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改银行流水明细,并进行排他
	 * @param accountDetailList
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:56
	 */
	int updateByExampleSelectiveData(AccountDetailList accountDetailList, Example example,boolean exclusive);

}
