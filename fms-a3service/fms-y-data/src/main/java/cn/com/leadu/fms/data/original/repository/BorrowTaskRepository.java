package cn.com.leadu.fms.data.original.repository;

import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskRepository
 * @Description: 借阅任务信息Repository层
 * @date 2018-05-30
 */
public interface BorrowTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增借阅任务信息
	 * @param borrowTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int insertData(BorrowTask borrowTask);

	/**
	 * @Title:
	 * @Description: 批量保存借阅任务信息
	 * @param borrowTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int insertDataList(List<BorrowTask> borrowTasks);

	/**
	 * @Title:
	 * @Description: 修改借阅任务信息
	 * @param borrowTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByPrimaryKeyData(BorrowTask borrowTask);

	/**
	 * @Title:
	 * @Description: 批量修改借阅任务信息
	 * @param borrowTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByPrimaryKeyDataList(List<BorrowTask> borrowTasks);

	/**
	 * @Title:
	 * @Description: 动态修改借阅任务信息
	 * @param borrowTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByPrimaryKeySelectiveData(BorrowTask borrowTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改借阅任务信息
	 * @param borrowTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByPrimaryKeySelectiveDataList(List<BorrowTask> borrowTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改借阅任务信息
	 * @param borrowTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByExampleData(BorrowTask borrowTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改借阅任务信息
	 * @param borrowTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByExampleSelectiveData(BorrowTask borrowTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据borrowTaskId删除借阅任务信息
	 * @param borrowTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int deleteData(BorrowTask borrowTask);

	/**
	 * @Title:
	 * @Description: 根据borrowTaskId集合批量删除借阅任务信息
	 * @param borrowTaskIds
	 * @param borrowTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int deleteDataList(List borrowTaskIds, BorrowTask borrowTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除借阅任务信息
	 * @param example
	 * @param borrowTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int deleteExampleData(Example example, BorrowTask borrowTask);

	/**
	 * @Title:
	 * @Description: 查询全部借阅任务信息
	 * @return List<BorrowTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	List<BorrowTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个借阅任务信息
	 * @param example
	 * @return BorrowTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	BorrowTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询借阅任务信息
	 * @param example
	 * @return List<BorrowTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	List<BorrowTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过borrowTaskId查询借阅任务信息
	 * @param borrowTaskId
	 * @return BorrowTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	BorrowTask selectByPrimaryKey(Object borrowTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询借阅任务信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BorrowTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	PageInfoExtend<BorrowTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询借阅任务信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改借阅任务信息
	 * @param borrowTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByPrimaryKeyData(BorrowTask borrowTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改借阅任务信息,并进行排他
	 * @param borrowTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByPrimaryKeyDataList(List<BorrowTask> borrowTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改借阅任务信息,并进行排他
	 * @param borrowTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(BorrowTask borrowTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改借阅任务信息,并进行排他
	 * @param borrowTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByPrimaryKeySelectiveDataList(List<BorrowTask> borrowTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改借阅任务信息,并进行排他
	 * @param borrowTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByExampleData(BorrowTask borrowTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改借阅任务信息,并进行排他
	 * @param borrowTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:18:56
	 */
	int updateByExampleSelectiveData(BorrowTask borrowTask, Example example, boolean exclusive);

	/**
	 * 根据借阅任务号获取合同号
	 * @param borrowTaskNo
	 * @return
	 */
	String selectBizCodeByBorrowTaskNo(String borrowTaskNo);

}
