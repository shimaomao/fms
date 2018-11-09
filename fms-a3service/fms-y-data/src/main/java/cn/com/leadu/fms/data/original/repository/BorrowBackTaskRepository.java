package cn.com.leadu.fms.data.original.repository;

import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskRepository
 * @Description: 借阅归还任务信息Repository层
 * @date 2018-06-04
 */
public interface BorrowBackTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增借阅归还任务信息
	 * @param borrowBackTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int insertData(BorrowBackTask borrowBackTask);

	/**
	 * @Title:
	 * @Description: 批量保存借阅归还任务信息
	 * @param borrowBackTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int insertDataList(List<BorrowBackTask> borrowBackTasks);

	/**
	 * @Title:
	 * @Description: 修改借阅归还任务信息
	 * @param borrowBackTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByPrimaryKeyData(BorrowBackTask borrowBackTask);

	/**
	 * @Title:
	 * @Description: 批量修改借阅归还任务信息
	 * @param borrowBackTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByPrimaryKeyDataList(List<BorrowBackTask> borrowBackTasks);

	/**
	 * @Title:
	 * @Description: 动态修改借阅归还任务信息
	 * @param borrowBackTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByPrimaryKeySelectiveData(BorrowBackTask borrowBackTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改借阅归还任务信息
	 * @param borrowBackTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByPrimaryKeySelectiveDataList(List<BorrowBackTask> borrowBackTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改借阅归还任务信息
	 * @param borrowBackTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByExampleData(BorrowBackTask borrowBackTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改借阅归还任务信息
	 * @param borrowBackTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByExampleSelectiveData(BorrowBackTask borrowBackTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据borrowBackTaskId删除借阅归还任务信息
	 * @param borrowBackTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int deleteData(BorrowBackTask borrowBackTask);

	/**
	 * @Title:
	 * @Description: 根据borrowBackTaskId集合批量删除借阅归还任务信息
	 * @param borrowBackTaskIds
	 * @param borrowBackTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int deleteDataList(List borrowBackTaskIds, BorrowBackTask borrowBackTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除借阅归还任务信息
	 * @param example
	 * @param borrowBackTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int deleteExampleData(Example example, BorrowBackTask borrowBackTask);

	/**
	 * @Title:
	 * @Description: 查询全部借阅归还任务信息
	 * @return List<BorrowBackTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	List<BorrowBackTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个借阅归还任务信息
	 * @param example
	 * @return BorrowBackTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	BorrowBackTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询借阅归还任务信息
	 * @param example
	 * @return List<BorrowBackTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	List<BorrowBackTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过borrowBackTaskId查询借阅归还任务信息
	 * @param borrowBackTaskId
	 * @return BorrowBackTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	BorrowBackTask selectByPrimaryKey(Object borrowBackTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询借阅归还任务信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BorrowBackTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	PageInfoExtend<BorrowBackTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询借阅归还任务信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改借阅归还任务信息
	 * @param borrowBackTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByPrimaryKeyData(BorrowBackTask borrowBackTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改借阅归还任务信息,并进行排他
	 * @param borrowBackTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByPrimaryKeyDataList(List<BorrowBackTask> borrowBackTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改借阅归还任务信息,并进行排他
	 * @param borrowBackTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(BorrowBackTask borrowBackTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改借阅归还任务信息,并进行排他
	 * @param borrowBackTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByPrimaryKeySelectiveDataList(List<BorrowBackTask> borrowBackTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改借阅归还任务信息,并进行排他
	 * @param borrowBackTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByExampleData(BorrowBackTask borrowBackTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改借阅归还任务信息,并进行排他
	 * @param borrowBackTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	int updateByExampleSelectiveData(BorrowBackTask borrowBackTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改借阅归还任务信息,并进行排他
	 * @param borrowBackTaskNo
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	BorrowBackTaskVo selectBorrowBackTaskByBorrowBackTaskNo(String borrowBackTaskNo);

}
