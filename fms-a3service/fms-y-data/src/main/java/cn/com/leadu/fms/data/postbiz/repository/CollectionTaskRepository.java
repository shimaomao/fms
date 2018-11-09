package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionTask;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CstmAddrInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.LawyerLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmPostVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskRepository
 * @Description: 催收任务Repository层
 */
public interface CollectionTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增催收任务
	 * @param collectionTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int insertData(CollectionTask collectionTask);

	/**
	 * @Title:
	 * @Description: 批量保存催收任务
	 * @param collectionTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int insertDataList(List<CollectionTask> collectionTasks);

	/**
	 * @Title:
	 * @Description: 修改催收任务
	 * @param collectionTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByPrimaryKeyData(CollectionTask collectionTask);

	/**
	 * @Title:
	 * @Description: 批量修改催收任务
	 * @param collectionTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByPrimaryKeyDataList(List<CollectionTask> collectionTasks);

	/**
	 * @Title:
	 * @Description: 动态修改催收任务
	 * @param collectionTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByPrimaryKeySelectiveData(CollectionTask collectionTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改催收任务
	 * @param collectionTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByPrimaryKeySelectiveDataList(List<CollectionTask> collectionTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改催收任务
	 * @param collectionTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByExampleData(CollectionTask collectionTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改催收任务
	 * @param collectionTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByExampleSelectiveData(CollectionTask collectionTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据collectionTaskId删除催收任务
	 * @param collectionTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int deleteData(CollectionTask collectionTask);

	/**
	 * @Title:
	 * @Description: 根据collectionTaskId集合批量删除催收任务
	 * @param collectionTaskIds
	 * @param collectionTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int deleteDataList(List collectionTaskIds, CollectionTask collectionTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除催收任务
	 * @param example
	 * @param collectionTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int deleteExampleData(Example example, CollectionTask collectionTask);

	/**
	 * @Title:
	 * @Description: 查询全部催收任务
	 * @return List<CollectionTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	List<CollectionTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个催收任务
	 * @param example
	 * @return CollectionTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	CollectionTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询催收任务
	 * @param example
	 * @return List<CollectionTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	List<CollectionTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过collectionTaskId查询催收任务
	 * @param collectionTaskId
	 * @return CollectionTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	CollectionTask selectByPrimaryKey(Object collectionTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询催收任务
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CollectionTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	PageInfoExtend<CollectionTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询催收任务vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改催收任务
	 * @param collectionTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByPrimaryKeyData(CollectionTask collectionTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改催收任务,并进行排他
	 * @param collectionTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByPrimaryKeyDataList(List<CollectionTask> collectionTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改催收任务,并进行排他
	 * @param collectionTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(CollectionTask collectionTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改催收任务,并进行排他
	 * @param collectionTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByPrimaryKeySelectiveDataList(List<CollectionTask> collectionTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改催收任务,并进行排他
	 * @param collectionTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByExampleData(CollectionTask collectionTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改催收任务,并进行排他
	 * @param collectionTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	int updateByExampleSelectiveData(CollectionTask collectionTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据overdueCstmId获取客户地址信息
	 * @param overdueCstmId
	 * @return CollectionTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	CollectionTaskVo selectCstmAddrPerInfosByOverdueCstmId(String overdueCstmId);

	/**
	 * 根据certifNo获取客户地址信息
	 * @param certifNo
	 * @return
	 */
	List<CstmAddrInfoVo> getCstmAddrInfoVoList(String certifNo);

	/**
	 * 根据collectionTaskNo获取催收任务信息
	 * @param collectionTaskNo
	 * @return
	 */
	CollectionTaskVo selectCollectionTaskByCollectionTaskNo(String collectionTaskNo);

	/**
	 * 取得上门催收任务表中全部的逾期客户ID
	 * @return List<String>
	 * @author wangxue
	 * @date 2018-9-19
	 */
	List<String> selectAllOverdueCstmIds();

	/**
	 * 根据任务号获取所有逾期合同号
	 * @param collectionTaskNo
	 * @return
	 */
	List<OverdueCstmPostVo> selectContNoListByCollectionTaskNo(String collectionTaskNo);

	/**
	 * 获取委托书需要数据
	 * @param collectionTaskNo
	 * @return
	 */
	List<CollectionLetterVo> selectProxyLetterInfo(String collectionTaskNo);

	/**
	 * 获取律师函数据
	 * @param collectionTaskNo
	 * @return
	 */
	List<LawyerLetterVo> selectLawyerLetterVoList(String collectionTaskNo);

}
