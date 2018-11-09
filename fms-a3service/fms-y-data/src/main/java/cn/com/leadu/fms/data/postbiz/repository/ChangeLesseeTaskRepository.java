package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeTaskRepository
 * @Description: 承租人变更Repository层
 */
public interface ChangeLesseeTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增承租人变更
	 * @param changeLesseeTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int insertData(ChangeLesseeTask changeLesseeTask);

	/**
	 * @Title:
	 * @Description: 批量保存承租人变更
	 * @param changeLesseeTasks
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int insertDataList(List<ChangeLesseeTask> changeLesseeTasks);

	/**
	 * @Title:
	 * @Description: 修改承租人变更
	 * @param changeLesseeTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByPrimaryKeyData(ChangeLesseeTask changeLesseeTask);

	/**
	 * @Title:
	 * @Description: 批量修改承租人变更
	 * @param changeLesseeTasks
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByPrimaryKeyDataList(List<ChangeLesseeTask> changeLesseeTasks);

	/**
	 * @Title:
	 * @Description: 动态修改承租人变更
	 * @param changeLesseeTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByPrimaryKeySelectiveData(ChangeLesseeTask changeLesseeTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改承租人变更
	 * @param changeLesseeTasks
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByPrimaryKeySelectiveDataList(List<ChangeLesseeTask> changeLesseeTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改承租人变更
	 * @param changeLesseeTask
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByExampleData(ChangeLesseeTask changeLesseeTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改承租人变更
	 * @param changeLesseeTask
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByExampleSelectiveData(ChangeLesseeTask changeLesseeTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据taskId删除承租人变更
	 * @param changeLesseeTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int deleteData(ChangeLesseeTask changeLesseeTask);

	/**
	 * @Title:
	 * @Description: 根据taskId集合批量删除承租人变更
	 * @param taskIds
	 * @param changeLesseeTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int deleteDataList(List taskIds, ChangeLesseeTask changeLesseeTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除承租人变更
	 * @param example
	 * @param changeLesseeTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int deleteExampleData(Example example, ChangeLesseeTask changeLesseeTask);

	/**
	 * @Title:
	 * @Description: 查询全部承租人变更
	 * @return List<ChangeLesseeTask>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	List<ChangeLesseeTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个承租人变更
	 * @param example
	 * @return ChangeLesseeTask
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	ChangeLesseeTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询承租人变更
	 * @param example
	 * @return List<ChangeLesseeTask>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	List<ChangeLesseeTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过taskId查询承租人变更
	 * @param taskId
	 * @return ChangeLesseeTask
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	ChangeLesseeTask selectByPrimaryKey(Object taskId);

	/**
	 * @Title:
	 * @Description: 分页查询承租人变更
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ChangeLesseeTask>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	PageInfoExtend<ChangeLesseeTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询承租人变更vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改承租人变更
	 * @param changeLesseeTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByPrimaryKeyData(ChangeLesseeTask changeLesseeTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改承租人变更,并进行排他
	 * @param changeLesseeTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByPrimaryKeyDataList(List<ChangeLesseeTask> changeLesseeTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改承租人变更,并进行排他
	 * @param changeLesseeTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(ChangeLesseeTask changeLesseeTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改承租人变更,并进行排他
	 * @param changeLesseeTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByPrimaryKeySelectiveDataList(List<ChangeLesseeTask> changeLesseeTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改承租人变更,并进行排他
	 * @param changeLesseeTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByExampleData(ChangeLesseeTask changeLesseeTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改承租人变更,并进行排他
	 * @param changeLesseeTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	int updateByExampleSelectiveData(ChangeLesseeTask changeLesseeTask, Example example, boolean exclusive);

}
