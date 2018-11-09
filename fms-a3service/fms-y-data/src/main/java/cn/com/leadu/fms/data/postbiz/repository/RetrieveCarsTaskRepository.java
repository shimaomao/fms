package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskRepository
 * @Description: 收车任务Repository层
 */
public interface RetrieveCarsTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增收车任务
	 * @param retrieveCarsTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int insertData(RetrieveCarsTask retrieveCarsTask);

	/**
	 * @Title:
	 * @Description: 批量保存收车任务
	 * @param retrieveCarsTasks
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int insertDataList(List<RetrieveCarsTask> retrieveCarsTasks);

	/**
	 * @Title:
	 * @Description: 修改收车任务
	 * @param retrieveCarsTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByPrimaryKeyData(RetrieveCarsTask retrieveCarsTask);

	/**
	 * @Title:
	 * @Description: 批量修改收车任务
	 * @param retrieveCarsTasks
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByPrimaryKeyDataList(List<RetrieveCarsTask> retrieveCarsTasks);

	/**
	 * @Title:
	 * @Description: 动态修改收车任务
	 * @param retrieveCarsTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByPrimaryKeySelectiveData(RetrieveCarsTask retrieveCarsTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改收车任务
	 * @param retrieveCarsTasks
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByPrimaryKeySelectiveDataList(List<RetrieveCarsTask> retrieveCarsTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改收车任务
	 * @param retrieveCarsTask
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByExampleData(RetrieveCarsTask retrieveCarsTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改收车任务
	 * @param retrieveCarsTask
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByExampleSelectiveData(RetrieveCarsTask retrieveCarsTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据retrieveCarId删除收车任务
	 * @param retrieveCarsTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int deleteData(RetrieveCarsTask retrieveCarsTask);

	/**
	 * @Title:
	 * @Description: 根据retrieveCarId集合批量删除收车任务
	 * @param retrieveCarIds
	 * @param retrieveCarsTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int deleteDataList(List retrieveCarIds, RetrieveCarsTask retrieveCarsTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除收车任务
	 * @param example
	 * @param retrieveCarsTask
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int deleteExampleData(Example example, RetrieveCarsTask retrieveCarsTask);

	/**
	 * @Title:
	 * @Description: 查询全部收车任务
	 * @return List<RetrieveCarsTask>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	List<RetrieveCarsTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个收车任务
	 * @param example
	 * @return RetrieveCarsTask
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	RetrieveCarsTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询收车任务
	 * @param example
	 * @return List<RetrieveCarsTask>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	List<RetrieveCarsTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过retrieveCarId查询收车任务
	 * @param retrieveCarId
	 * @return RetrieveCarsTask
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	RetrieveCarsTask selectByPrimaryKey(Object retrieveCarId);

	/**
	 * @Title:
	 * @Description: 分页查询收车任务
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RetrieveCarsTask>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	PageInfoExtend<RetrieveCarsTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询收车任务vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改收车任务
	 * @param retrieveCarsTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByPrimaryKeyData(RetrieveCarsTask retrieveCarsTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改收车任务,并进行排他
	 * @param retrieveCarsTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByPrimaryKeyDataList(List<RetrieveCarsTask> retrieveCarsTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改收车任务,并进行排他
	 * @param retrieveCarsTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(RetrieveCarsTask retrieveCarsTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改收车任务,并进行排他
	 * @param retrieveCarsTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByPrimaryKeySelectiveDataList(List<RetrieveCarsTask> retrieveCarsTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改收车任务,并进行排他
	 * @param retrieveCarsTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByExampleData(RetrieveCarsTask retrieveCarsTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改收车任务,并进行排他
	 * @param retrieveCarsTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	int updateByExampleSelectiveData(RetrieveCarsTask retrieveCarsTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description:   根据收车任务Id查询收车任务vo
	 * @param retrieveCarId
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/15 02:52:48
	 */
	RetrieveCarsTaskVo selectRetrieveCarsTaskVoById(String retrieveCarId);

	/**
	 * @Title:
	 * @Description:   根据收车任务Id查询收车任务vo
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/15 02:52:48
	 */
	List<RetrieveCarsTaskVo> selectRetrieveCarsTaskVos(RetrieveCarsTaskVo retrieveCarsTaskVo);

	/**
	 * @Title:
	 * @Description:   根据收车任务号查询收车任务vo
	 * @param retrieveCarTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/18 01:47:40
	 */
	RetrieveCarsTaskVo selectRetrieveCarsTaskVoByTaskNo(String retrieveCarTaskNo);

	/**
	 * @Title:
	 * @Description:   获取收车任务表中全部的逾期合同ID
	 * @return List<String>
	 * @throws
	 * @author wangxue
	 * @date 2018/09/19
	 */
	List<String> selectAllOverdueContIds();

	/**
	 * 获取委托书下载数据List
	 * @param retrieveCarTaskNo
	 * @return
	 */
	List<CollectionLetterVo> selectproxyDownloadInfo(String retrieveCarTaskNo);

}
