package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeRepository
 * @Description: 辅助核算类型管理Repository层
 * @date 2018-06-23
 */
public interface AssisAccountTypeRepository {

	/**
	 * @Title:
	 * @Description: 新增辅助核算类型管理
	 * @param assisAccountType
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int insertData(AssisAccountType assisAccountType);

	/**
	 * @Title:
	 * @Description: 批量保存辅助核算类型管理
	 * @param assisAccountTypes
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int insertDataList(List<AssisAccountType> assisAccountTypes);

	/**
	 * @Title:
	 * @Description: 修改辅助核算类型管理
	 * @param assisAccountType
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByPrimaryKeyData(AssisAccountType assisAccountType);

	/**
	 * @Title:
	 * @Description: 批量修改辅助核算类型管理
	 * @param assisAccountTypes
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByPrimaryKeyDataList(List<AssisAccountType> assisAccountTypes);

	/**
	 * @Title:
	 * @Description: 动态修改辅助核算类型管理
	 * @param assisAccountType
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByPrimaryKeySelectiveData(AssisAccountType assisAccountType);

	/**
	 * @Title:
	 * @Description: 批量动态修改辅助核算类型管理
	 * @param assisAccountTypes
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<AssisAccountType> assisAccountTypes);

	/**
	 * @Title:
	 * @Description: 根据条件修改辅助核算类型管理
	 * @param assisAccountType
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByExampleData(AssisAccountType assisAccountType, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改辅助核算类型管理
	 * @param assisAccountType
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByExampleSelectiveData(AssisAccountType assisAccountType, Example example);

	/**
	 * @Title:
	 * @Description: 根据assisAccountTypeId删除辅助核算类型管理
	 * @param assisAccountType
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int deleteData(AssisAccountType assisAccountType);

	/**
	 * @Title:
	 * @Description: 根据assisAccountTypeId集合批量删除辅助核算类型管理
	 * @param assisAccountTypeIds
	 * @param assisAccountType
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int deleteDataList(List assisAccountTypeIds, AssisAccountType assisAccountType);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除辅助核算类型管理
	 * @param example
	 * @param assisAccountType
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int deleteExampleData(Example example, AssisAccountType assisAccountType);

	/**
	 * @Title:
	 * @Description: 查询全部辅助核算类型管理
	 * @return List<AssisAccountType>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	List<AssisAccountType> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个辅助核算类型管理
	 * @param example
	 * @return AssisAccountType
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	AssisAccountType selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询辅助核算类型管理
	 * @param example
	 * @return List<AssisAccountType>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	List<AssisAccountType> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过assisAccountTypeId查询辅助核算类型管理
	 * @param assisAccountTypeId
	 * @return AssisAccountType
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	AssisAccountType selectByPrimaryKey(Object assisAccountTypeId);

	/**
	 * @Title:
	 * @Description: 分页查询辅助核算类型管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<AssisAccountType>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	PageInfoExtend<AssisAccountType> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询辅助核算类型管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改辅助核算类型管理
	 * @param assisAccountType,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByPrimaryKeyData(AssisAccountType assisAccountType, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改辅助核算类型管理,并进行排他
	 * @param assisAccountTypes
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByPrimaryKeyDataList(List<AssisAccountType> assisAccountTypes, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改辅助核算类型管理,并进行排他
	 * @param assisAccountType
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(AssisAccountType assisAccountType, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改辅助核算类型管理,并进行排他
	 * @param assisAccountTypes
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<AssisAccountType> assisAccountTypes, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改辅助核算类型管理,并进行排他
	 * @param assisAccountType
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByExampleData(AssisAccountType assisAccountType, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改辅助核算类型管理,并进行排他
	 * @param assisAccountType
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	int updateByExampleSelectiveData(AssisAccountType assisAccountType, Example example, boolean exclusive);

}
