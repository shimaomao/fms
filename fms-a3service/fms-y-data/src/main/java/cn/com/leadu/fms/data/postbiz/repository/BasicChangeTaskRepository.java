package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.BasicChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeTaskCancelVo;
import java.util.List;
import tk.mybatis.mapper.entity.Example;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskRepository
 * @Description: 基本信息变更任务Repository层
 * @date 2018-08-31
 */
public interface BasicChangeTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增基本信息变更任务
	 * @param basicChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int insertData(BasicChangeTask basicChangeTask);

	/**
	 * @Title:
	 * @Description: 批量保存基本信息变更任务
	 * @param basicChangeTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int insertDataList(List<BasicChangeTask> basicChangeTasks);

	/**
	 * @Title:
	 * @Description: 修改基本信息变更任务
	 * @param basicChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByPrimaryKeyData(BasicChangeTask basicChangeTask);

	/**
	 * @Title:
	 * @Description: 批量修改基本信息变更任务
	 * @param basicChangeTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByPrimaryKeyDataList(List<BasicChangeTask> basicChangeTasks);

	/**
	 * @Title:
	 * @Description: 动态修改基本信息变更任务
	 * @param basicChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByPrimaryKeySelectiveData(BasicChangeTask basicChangeTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改基本信息变更任务
	 * @param basicChangeTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasicChangeTask> basicChangeTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改基本信息变更任务
	 * @param basicChangeTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByExampleData(BasicChangeTask basicChangeTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改基本信息变更任务
	 * @param basicChangeTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByExampleSelectiveData(BasicChangeTask basicChangeTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据personChangeTaskId删除基本信息变更任务
	 * @param basicChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int deleteData(BasicChangeTask basicChangeTask);

	/**
	 * @Title:
	 * @Description: 根据personChangeTaskId集合批量删除基本信息变更任务
	 * @param personChangeTaskIds
	 * @param basicChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int deleteDataList(List personChangeTaskIds, BasicChangeTask basicChangeTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除基本信息变更任务
	 * @param example
	 * @param basicChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int deleteExampleData(Example example, BasicChangeTask basicChangeTask);

	/**
	 * @Title:
	 * @Description: 查询全部基本信息变更任务
	 * @return List<BasicChangeTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	List<BasicChangeTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个基本信息变更任务
	 * @param example
	 * @return BasicChangeTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	BasicChangeTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询基本信息变更任务
	 * @param example
	 * @return List<BasicChangeTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	List<BasicChangeTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过personChangeTaskId查询基本信息变更任务
	 * @param personChangeTaskId
	 * @return BasicChangeTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	BasicChangeTask selectByPrimaryKey(Object personChangeTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询基本信息变更任务
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasicChangeTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	PageInfoExtend<BasicChangeTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询基本信息变更任务vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改基本信息变更任务
	 * @param basicChangeTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByPrimaryKeyData(BasicChangeTask basicChangeTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改基本信息变更任务,并进行排他
	 * @param basicChangeTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByPrimaryKeyDataList(List<BasicChangeTask> basicChangeTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改基本信息变更任务,并进行排他
	 * @param basicChangeTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(BasicChangeTask basicChangeTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改基本信息变更任务,并进行排他
	 * @param basicChangeTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasicChangeTask> basicChangeTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改基本信息变更任务,并进行排他
	 * @param basicChangeTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByExampleData(BasicChangeTask basicChangeTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改基本信息变更任务,并进行排他
	 * @param basicChangeTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:11:00
	 */
	int updateByExampleSelectiveData(BasicChangeTask basicChangeTask, Example example, boolean exclusive);

	/**
	 * 获取基本信息变更取消内容
	 * @param basicChangeTaskCancelVo
	 * @return
	 */
	BasicChangeTaskCancelVo selectBasicChangeCancelVo(BasicChangeTaskCancelVo basicChangeTaskCancelVo);
}
