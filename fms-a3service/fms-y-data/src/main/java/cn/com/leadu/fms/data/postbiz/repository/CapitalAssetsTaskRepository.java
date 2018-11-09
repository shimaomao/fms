package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.CapitalAssetsTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: CapitalAssetsTaskRepository
 * @Description: 转固定资产Repository层
 */
public interface CapitalAssetsTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增转固定资产
	 * @param capitalAssetsTask
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int insertData(CapitalAssetsTask capitalAssetsTask);

	/**
	 * @Title:
	 * @Description: 批量保存转固定资产
	 * @param capitalAssetsTasks
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int insertDataList(List<CapitalAssetsTask> capitalAssetsTasks);

	/**
	 * @Title:
	 * @Description: 修改转固定资产
	 * @param capitalAssetsTask
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByPrimaryKeyData(CapitalAssetsTask capitalAssetsTask);

	/**
	 * @Title:
	 * @Description: 批量修改转固定资产
	 * @param capitalAssetsTasks
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByPrimaryKeyDataList(List<CapitalAssetsTask> capitalAssetsTasks);

	/**
	 * @Title:
	 * @Description: 动态修改转固定资产
	 * @param capitalAssetsTask
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByPrimaryKeySelectiveData(CapitalAssetsTask capitalAssetsTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改转固定资产
	 * @param capitalAssetsTasks
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByPrimaryKeySelectiveDataList(List<CapitalAssetsTask> capitalAssetsTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改转固定资产
	 * @param capitalAssetsTask
	 * @param example
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByExampleData(CapitalAssetsTask capitalAssetsTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改转固定资产
	 * @param capitalAssetsTask
	 * @param example
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByExampleSelectiveData(CapitalAssetsTask capitalAssetsTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据capitalAssetsTaskId删除转固定资产
	 * @param capitalAssetsTask
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int deleteData(CapitalAssetsTask capitalAssetsTask);

	/**
	 * @Title:
	 * @Description: 根据capitalAssetsTaskId集合批量删除转固定资产
	 * @param capitalAssetsTaskIds
	 * @param capitalAssetsTask
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int deleteDataList(List capitalAssetsTaskIds, CapitalAssetsTask capitalAssetsTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除转固定资产
	 * @param example
	 * @param capitalAssetsTask
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int deleteExampleData(Example example, CapitalAssetsTask capitalAssetsTask);

	/**
	 * @Title:
	 * @Description: 查询全部转固定资产
	 * @return List<CapitalAssetsTask>
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	List<CapitalAssetsTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个转固定资产
	 * @param example
	 * @return CapitalAssetsTask
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	CapitalAssetsTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询转固定资产
	 * @param example
	 * @return List<CapitalAssetsTask>
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	List<CapitalAssetsTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过capitalAssetsTaskId查询转固定资产
	 * @param capitalAssetsTaskId
	 * @return CapitalAssetsTask
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	CapitalAssetsTask selectByPrimaryKey(Object capitalAssetsTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询转固定资产
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CapitalAssetsTask>
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	PageInfoExtend<CapitalAssetsTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询转固定资产vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改转固定资产
	 * @param capitalAssetsTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByPrimaryKeyData(CapitalAssetsTask capitalAssetsTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改转固定资产,并进行排他
	 * @param capitalAssetsTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByPrimaryKeyDataList(List<CapitalAssetsTask> capitalAssetsTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改转固定资产,并进行排他
	 * @param capitalAssetsTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(CapitalAssetsTask capitalAssetsTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改转固定资产,并进行排他
	 * @param capitalAssetsTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByPrimaryKeySelectiveDataList(List<CapitalAssetsTask> capitalAssetsTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改转固定资产,并进行排他
	 * @param capitalAssetsTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByExampleData(CapitalAssetsTask capitalAssetsTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改转固定资产,并进行排他
	 * @param capitalAssetsTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:00:43
	 */
	int updateByExampleSelectiveData(CapitalAssetsTask capitalAssetsTask, Example example, boolean exclusive);

}
