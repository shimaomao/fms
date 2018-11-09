package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVisit;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyVisitRepository
 * @Description: 贷前家访Repository层
 * @date 2018-06-04
 */
public interface ApplyVisitRepository {

	/**
	 * @Title:
	 * @Description: 新增贷前家访
	 * @param applyVisit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int insertData(ApplyVisit applyVisit);

	/**
	 * @Title:
	 * @Description: 批量保存贷前家访
	 * @param applyVisits
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int insertDataList(List<ApplyVisit> applyVisits);

	/**
	 * @Title:
	 * @Description: 修改贷前家访
	 * @param applyVisit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByPrimaryKeyData(ApplyVisit applyVisit);

	/**
	 * @Title:
	 * @Description: 批量修改贷前家访
	 * @param applyVisits
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByPrimaryKeyDataList(List<ApplyVisit> applyVisits);

	/**
	 * @Title:
	 * @Description: 动态修改贷前家访
	 * @param applyVisit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByPrimaryKeySelectiveData(ApplyVisit applyVisit);

	/**
	 * @Title:
	 * @Description: 批量动态修改贷前家访
	 * @param applyVisits
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<ApplyVisit> applyVisits);

	/**
	 * @Title:
	 * @Description: 根据条件修改贷前家访
	 * @param applyVisit
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByExampleData(ApplyVisit applyVisit, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改贷前家访
	 * @param applyVisit
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByExampleSelectiveData(ApplyVisit applyVisit, Example example);

	/**
	 * @Title:
	 * @Description: 根据applyVisitId删除贷前家访
	 * @param applyVisit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int deleteData(ApplyVisit applyVisit);

	/**
	 * @Title:
	 * @Description: 根据applyVisitId集合批量删除贷前家访
	 * @param applyVisitIds
	 * @param applyVisit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int deleteDataList(List applyVisitIds,ApplyVisit applyVisit);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除贷前家访
	 * @param example
	 * @param applyVisit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int deleteExampleData(Example example,ApplyVisit applyVisit);

	/**
	 * @Title:
	 * @Description: 查询全部贷前家访
	 * @return List<ApplyVisit>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	List<ApplyVisit> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个贷前家访
	 * @param example
	 * @return ApplyVisit
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	ApplyVisit selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询贷前家访
	 * @param example
	 * @return List<ApplyVisit>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	List<ApplyVisit> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过applyVisitId查询贷前家访
	 * @param applyVisitId
	 * @return ApplyVisit
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	ApplyVisit selectByPrimaryKey(Object applyVisitId);

	/**
	 * @Title:
	 * @Description: 分页查询贷前家访
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ApplyVisit>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	PageInfoExtend<ApplyVisit> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询贷前家访vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改贷前家访
	 * @param applyVisit,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByPrimaryKeyData(ApplyVisit applyVisit,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改贷前家访,并进行排他
	 * @param applyVisits
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByPrimaryKeyDataList(List<ApplyVisit> applyVisits,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改贷前家访,并进行排他
	 * @param applyVisit
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(ApplyVisit applyVisit,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改贷前家访,并进行排他
	 * @param applyVisits
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<ApplyVisit> applyVisits,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改贷前家访,并进行排他
	 * @param applyVisit
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByExampleData(ApplyVisit applyVisit, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改贷前家访,并进行排他
	 * @param applyVisit
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	int updateByExampleSelectiveData(ApplyVisit applyVisit, Example example,boolean exclusive);

}
