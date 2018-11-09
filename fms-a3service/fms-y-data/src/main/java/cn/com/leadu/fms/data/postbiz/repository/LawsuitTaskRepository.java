package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskSearchVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskRepository
 * @Description: 诉讼任务信息Repository层
 */
public interface LawsuitTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增诉讼任务信息
	 * @param lawsuitTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int insertData(LawsuitTask lawsuitTask);

	/**
	 * @Title:
	 * @Description: 批量保存诉讼任务信息
	 * @param lawsuitTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int insertDataList(List<LawsuitTask> lawsuitTasks);

	/**
	 * @Title:
	 * @Description: 修改诉讼任务信息
	 * @param lawsuitTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByPrimaryKeyData(LawsuitTask lawsuitTask);

	/**
	 * @Title:
	 * @Description: 批量修改诉讼任务信息
	 * @param lawsuitTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByPrimaryKeyDataList(List<LawsuitTask> lawsuitTasks);

	/**
	 * @Title:
	 * @Description: 动态修改诉讼任务信息
	 * @param lawsuitTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByPrimaryKeySelectiveData(LawsuitTask lawsuitTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改诉讼任务信息
	 * @param lawsuitTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByPrimaryKeySelectiveDataList(List<LawsuitTask> lawsuitTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改诉讼任务信息
	 * @param lawsuitTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByExampleData(LawsuitTask lawsuitTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改诉讼任务信息
	 * @param lawsuitTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByExampleSelectiveData(LawsuitTask lawsuitTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据lawsuitTaskId删除诉讼任务信息
	 * @param lawsuitTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int deleteData(LawsuitTask lawsuitTask);

	/**
	 * @Title:
	 * @Description: 根据lawsuitTaskId集合批量删除诉讼任务信息
	 * @param lawsuitTaskIds
	 * @param lawsuitTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int deleteDataList(List lawsuitTaskIds, LawsuitTask lawsuitTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除诉讼任务信息
	 * @param example
	 * @param lawsuitTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int deleteExampleData(Example example, LawsuitTask lawsuitTask);

	/**
	 * @Title:
	 * @Description: 查询全部诉讼任务信息
	 * @return List<LawsuitTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	List<LawsuitTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个诉讼任务信息
	 * @param example
	 * @return LawsuitTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	LawsuitTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询诉讼任务信息
	 * @param example
	 * @return List<LawsuitTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	List<LawsuitTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过lawsuitTaskId查询诉讼任务信息
	 * @param lawsuitTaskId
	 * @return LawsuitTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	LawsuitTask selectByPrimaryKey(Object lawsuitTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询诉讼任务信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<LawsuitTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	PageInfoExtend<LawsuitTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询诉讼任务信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改诉讼任务信息
	 * @param lawsuitTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByPrimaryKeyData(LawsuitTask lawsuitTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改诉讼任务信息,并进行排他
	 * @param lawsuitTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByPrimaryKeyDataList(List<LawsuitTask> lawsuitTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改诉讼任务信息,并进行排他
	 * @param lawsuitTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(LawsuitTask lawsuitTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改诉讼任务信息,并进行排他
	 * @param lawsuitTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByPrimaryKeySelectiveDataList(List<LawsuitTask> lawsuitTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改诉讼任务信息,并进行排他
	 * @param lawsuitTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByExampleData(LawsuitTask lawsuitTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改诉讼任务信息,并进行排他
	 * @param lawsuitTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:47
	 */
	int updateByExampleSelectiveData(LawsuitTask lawsuitTask, Example example, boolean exclusive);

	/**
	 * 根据lawsuitTaskNo获取诉讼任务信息
	 * @param lawsuitTaskNo
	 * @return
	 */
	LawsuitTaskSearchVo selectLawsuitTasksByTaskNo(String lawsuitTaskNo);

	/**
	 * 根据overdueContId获取诉讼基本信息
	 * @param overdueContId
	 * @return
	 */
	LawsuitTaskSearchVo selectLawsuitTasksByOverdueContId(String overdueContId);

	/**
	 * 根据lawsuitTaskNo获取诉讼登记信息
	 * @param lawsuitTaskNo
	 * @return
	 */
	LawsuitTaskSearchVo selectLawsuitRegistersByTaskNo(String lawsuitTaskNo);

	/**
	 * 获取诉讼任务表中所有的逾期合同ID
	 * @param
	 * @return List<String>
	 * @author wangxue
	 * @date 2018-9-19
	 */
	List<String> selectAllOverdueContIds();

	/**
	 * 根据任务号获取历史诉讼登记信息List
	 * @param lawsuitTaskNo
	 * @return
	 */
	List<LawsuitRegisterVo> selectLawsuitRegisterVosByLawsuitTaskNo(String lawsuitTaskNo);
}
