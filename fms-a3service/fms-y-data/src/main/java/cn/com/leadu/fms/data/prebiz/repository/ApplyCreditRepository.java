package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCredit;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ApplyCreditRepository
 * @Description: 征信信息Repository层
 * @date 2018-05-15
 */
public interface ApplyCreditRepository {

	/**
	 * @Title:
	 * @Description: 新增征信信息
	 * @param applyCredit
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int insertData(ApplyCredit applyCredit);

	/**
	 * @Title:
	 * @Description: 批量保存征信信息
	 * @param applyCredits
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int insertDataList(List<ApplyCredit> applyCredits);

	/**
	 * @Title:
	 * @Description: 修改征信信息
	 * @param applyCredit
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int updateByPrimaryKeyData(ApplyCredit applyCredit);

	/**
	 * @Title:
	 * @Description: 批量修改征信信息
	 * @param applyCredits
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int updateByPrimaryKeyDataList(List<ApplyCredit> applyCredits);

	/**
	 * @Title:
	 * @Description: 动态修改征信信息
	 * @param applyCredit
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int updateByPrimaryKeySelectiveData(ApplyCredit applyCredit);

	/**
	 * @Title:
	 * @Description: 批量动态修改征信信息
	 * @param applyCredits
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int updateByPrimaryKeySelectiveDataList(List<ApplyCredit> applyCredits);

	/**
	 * @Title:
	 * @Description: 根据条件修改征信信息
	 * @param applyCredit
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int updateByExampleData(ApplyCredit applyCredit, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改征信信息
	 * @param applyCredit
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int updateByExampleSelectiveData(ApplyCredit applyCredit, Example example);

	/**
	 * @Title:
	 * @Description: 根据applyCreditId删除征信信息
	 * @param applyCredit
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int deleteData(ApplyCredit applyCredit);

	/**
	 * @Title:
	 * @Description: 根据applyCreditId集合批量删除征信信息
	 * @param applyCreditIds
	 * @param applyCredit
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int deleteDataList(List applyCreditIds, ApplyCredit applyCredit);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除征信信息
	 * @param example
	 * @param applyCredit
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	int deleteExampleData(Example example, ApplyCredit applyCredit);

	/**
	 * @Title:
	 * @Description: 查询全部征信信息
	 * @return List<ApplyCredit>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	List<ApplyCredit> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个征信信息
	 * @param example
	 * @return ApplyCredit
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	ApplyCredit selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询征信信息
	 * @param example
	 * @return List<ApplyCredit>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	List<ApplyCredit> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过applyCreditId查询征信信息
	 * @param applyCreditId
	 * @return ApplyCredit
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	ApplyCredit selectByPrimaryKey(Object applyCreditId);

	/**
	 * @Title:
	 * @Description: 分页查询征信信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ApplyCredit>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	PageInfoExtend<ApplyCredit> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询征信信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:26:59
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
