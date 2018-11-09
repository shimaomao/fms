package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SubjectAssisAccountRepository
 * @Description: 科目辅助核算管理Repository层
 * @date 2018-06-23
 */
public interface SubjectAssisAccountRepository {

	/**
	 * @Title:
	 * @Description: 新增科目辅助核算管理
	 * @param subjectAssisAccount
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int insertData(SubjectAssisAccount subjectAssisAccount);

	/**
	 * @Title:
	 * @Description: 批量保存科目辅助核算管理
	 * @param subjectAssisAccounts
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int insertDataList(List<SubjectAssisAccount> subjectAssisAccounts);

	/**
	 * @Title:
	 * @Description: 修改科目辅助核算管理
	 * @param subjectAssisAccount
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByPrimaryKeyData(SubjectAssisAccount subjectAssisAccount);

	/**
	 * @Title:
	 * @Description: 批量修改科目辅助核算管理
	 * @param subjectAssisAccounts
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByPrimaryKeyDataList(List<SubjectAssisAccount> subjectAssisAccounts);

	/**
	 * @Title:
	 * @Description: 动态修改科目辅助核算管理
	 * @param subjectAssisAccount
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByPrimaryKeySelectiveData(SubjectAssisAccount subjectAssisAccount);

	/**
	 * @Title:
	 * @Description: 批量动态修改科目辅助核算管理
	 * @param subjectAssisAccounts
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<SubjectAssisAccount> subjectAssisAccounts);

	/**
	 * @Title:
	 * @Description: 根据条件修改科目辅助核算管理
	 * @param subjectAssisAccount
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByExampleData(SubjectAssisAccount subjectAssisAccount, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改科目辅助核算管理
	 * @param subjectAssisAccount
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByExampleSelectiveData(SubjectAssisAccount subjectAssisAccount, Example example);

	/**
	 * @Title:
	 * @Description: 根据subjectAssisAccountId删除科目辅助核算管理
	 * @param subjectAssisAccount
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int deleteData(SubjectAssisAccount subjectAssisAccount);

	/**
	 * @Title:
	 * @Description: 根据subjectAssisAccountId集合批量删除科目辅助核算管理
	 * @param subjectAssisAccountIds
	 * @param subjectAssisAccount
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int deleteDataList(List<String> subjectAssisAccountIds, SubjectAssisAccount subjectAssisAccount);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除科目辅助核算管理
	 * @param example
	 * @param subjectAssisAccount
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int deleteExampleData(Example example, SubjectAssisAccount subjectAssisAccount);

	/**
	 * @Title:
	 * @Description: 查询全部科目辅助核算管理
	 * @return List<SubjectAssisAccount>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	List<SubjectAssisAccount> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个科目辅助核算管理
	 * @param example
	 * @return SubjectAssisAccount
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	SubjectAssisAccount selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询科目辅助核算管理
	 * @param example
	 * @return List<SubjectAssisAccount>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	List<SubjectAssisAccount> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过subjectAssisAccountId查询科目辅助核算管理
	 * @param subjectAssisAccountId
	 * @return SubjectAssisAccount
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	SubjectAssisAccount selectByPrimaryKey(Object subjectAssisAccountId);

	/**
	 * @Title:
	 * @Description: 分页查询科目辅助核算管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SubjectAssisAccount>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	PageInfoExtend<SubjectAssisAccount> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询科目辅助核算管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改科目辅助核算管理
	 * @param subjectAssisAccount,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByPrimaryKeyData(SubjectAssisAccount subjectAssisAccount, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改科目辅助核算管理,并进行排他
	 * @param subjectAssisAccounts
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByPrimaryKeyDataList(List<SubjectAssisAccount> subjectAssisAccounts, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改科目辅助核算管理,并进行排他
	 * @param subjectAssisAccount
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(SubjectAssisAccount subjectAssisAccount, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改科目辅助核算管理,并进行排他
	 * @param subjectAssisAccounts
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<SubjectAssisAccount> subjectAssisAccounts, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改科目辅助核算管理,并进行排他
	 * @param subjectAssisAccount
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByExampleData(SubjectAssisAccount subjectAssisAccount, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改科目辅助核算管理,并进行排他
	 * @param subjectAssisAccount
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 16:30:14
	 */
	int updateByExampleSelectiveData(SubjectAssisAccount subjectAssisAccount, Example example, boolean exclusive);

}
