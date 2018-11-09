package cn.com.leadu.fms.data.asset.repository;

import cn.com.leadu.fms.pojo.asset.entity.EquRelTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskRepository
 * @Description: 资方解押任务Repository层
 * @date 2018-05-30
 */
public interface EquRelTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增资方解押任务
	 * @param equRelTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int insertData(EquRelTask equRelTask);

	/**
	 * @Title:
	 * @Description: 批量保存资方解押任务
	 * @param equRelTasks
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int insertDataList(List<EquRelTask> equRelTasks);

	/**
	 * @Title:
	 * @Description: 修改资方解押任务
	 * @param equRelTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByPrimaryKeyData(EquRelTask equRelTask);

	/**
	 * @Title:
	 * @Description: 批量修改资方解押任务
	 * @param equRelTasks
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByPrimaryKeyDataList(List<EquRelTask> equRelTasks);

	/**
	 * @Title:
	 * @Description: 动态修改资方解押任务
	 * @param equRelTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByPrimaryKeySelectiveData(EquRelTask equRelTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方解押任务
	 * @param equRelTasks
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquRelTask> equRelTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方解押任务
	 * @param equRelTask
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByExampleData(EquRelTask equRelTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方解押任务
	 * @param equRelTask
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByExampleSelectiveData(EquRelTask equRelTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据equRelTaskId删除资方解押任务
	 * @param equRelTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int deleteData(EquRelTask equRelTask);

	/**
	 * @Title:
	 * @Description: 根据equRelTaskId集合批量删除资方解押任务
	 * @param equRelTaskIds
	 * @param equRelTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int deleteDataList(List equRelTaskIds, EquRelTask equRelTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除资方解押任务
	 * @param example
	 * @param equRelTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int deleteExampleData(Example example, EquRelTask equRelTask);

	/**
	 * @Title:
	 * @Description: 查询全部资方解押任务
	 * @return List<EquRelTask>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	List<EquRelTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个资方解押任务
	 * @param example
	 * @return EquRelTask
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	EquRelTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询资方解押任务
	 * @param example
	 * @return List<EquRelTask>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	List<EquRelTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过equRelTaskId查询资方解押任务
	 * @param equRelTaskId
	 * @return EquRelTask
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	EquRelTask selectByPrimaryKey(Object equRelTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询资方解押任务
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<EquRelTask>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	PageInfoExtend<EquRelTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询资方解押任务vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改资方解押任务
	 * @param equRelTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByPrimaryKeyData(EquRelTask equRelTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改资方解押任务,并进行排他
	 * @param equRelTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByPrimaryKeyDataList(List<EquRelTask> equRelTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改资方解押任务,并进行排他
	 * @param equRelTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(EquRelTask equRelTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方解押任务,并进行排他
	 * @param equRelTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquRelTask> equRelTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方解押任务,并进行排他
	 * @param equRelTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByExampleData(EquRelTask equRelTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方解押任务,并进行排他
	 * @param equRelTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	int updateByExampleSelectiveData(EquRelTask equRelTask, Example example, boolean exclusive);

}
