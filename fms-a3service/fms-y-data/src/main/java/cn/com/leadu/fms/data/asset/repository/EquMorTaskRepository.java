package cn.com.leadu.fms.data.asset.repository;

import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTaskRepository
 * @Description: 资方抵押任务Repository层
 * @date 2018-05-30
 */
public interface EquMorTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增资方抵押任务
	 * @param equMorTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int insertData(EquMorTask equMorTask);

	/**
	 * @Title:
	 * @Description: 批量保存资方抵押任务
	 * @param equMorTasks
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int insertDataList(List<EquMorTask> equMorTasks);

	/**
	 * @Title:
	 * @Description: 修改资方抵押任务
	 * @param equMorTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByPrimaryKeyData(EquMorTask equMorTask);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押任务
	 * @param equMorTasks
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByPrimaryKeyDataList(List<EquMorTask> equMorTasks);

	/**
	 * @Title:
	 * @Description: 动态修改资方抵押任务
	 * @param equMorTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByPrimaryKeySelectiveData(EquMorTask equMorTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押任务
	 * @param equMorTasks
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorTask> equMorTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押任务
	 * @param equMorTask
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByExampleData(EquMorTask equMorTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押任务
	 * @param equMorTask
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByExampleSelectiveData(EquMorTask equMorTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据equMorTaskId删除资方抵押任务
	 * @param equMorTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int deleteData(EquMorTask equMorTask);

	/**
	 * @Title:
	 * @Description: 根据equMorTaskId集合批量删除资方抵押任务
	 * @param equMorTaskIds
	 * @param equMorTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int deleteDataList(List equMorTaskIds, EquMorTask equMorTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除资方抵押任务
	 * @param example
	 * @param equMorTask
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int deleteExampleData(Example example, EquMorTask equMorTask);

	/**
	 * @Title:
	 * @Description: 查询全部资方抵押任务
	 * @return List<EquMorTask>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	List<EquMorTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个资方抵押任务
	 * @param example
	 * @return EquMorTask
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	EquMorTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询资方抵押任务
	 * @param example
	 * @return List<EquMorTask>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	List<EquMorTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过equMorTaskId查询资方抵押任务
	 * @param equMorTaskId
	 * @return EquMorTask
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	EquMorTask selectByPrimaryKey(Object equMorTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押任务
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<EquMorTask>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	PageInfoExtend<EquMorTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押任务vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改资方抵押任务
	 * @param equMorTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByPrimaryKeyData(EquMorTask equMorTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押任务,并进行排他
	 * @param equMorTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByPrimaryKeyDataList(List<EquMorTask> equMorTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改资方抵押任务,并进行排他
	 * @param equMorTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(EquMorTask equMorTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押任务,并进行排他
	 * @param equMorTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorTask> equMorTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押任务,并进行排他
	 * @param equMorTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByExampleData(EquMorTask equMorTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押任务,并进行排他
	 * @param equMorTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	int updateByExampleSelectiveData(EquMorTask equMorTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据任务号,更新任务状态和所在节点人
	 * @param equMorTaskNo
	 * @param equMorTask
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/07/09 05:04:51
	 */
	int updateByEquMorTaskNoSelectiveData(String equMorTaskNo,EquMorTask equMorTask);

}
