package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChangeTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskRepository
 * @Description: 开票变更任务Repository层
 * @date 2018-08-29
 */
public interface InvoiceChangeTaskRepository {

	/**
	 * @Title:
	 * @Description: 新增开票变更任务
	 * @param invoiceChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int insertData(InvoiceChangeTask invoiceChangeTask);

	/**
	 * @Title:
	 * @Description: 批量保存开票变更任务
	 * @param invoiceChangeTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int insertDataList(List<InvoiceChangeTask> invoiceChangeTasks);

	/**
	 * @Title:
	 * @Description: 修改开票变更任务
	 * @param invoiceChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByPrimaryKeyData(InvoiceChangeTask invoiceChangeTask);

	/**
	 * @Title:
	 * @Description: 批量修改开票变更任务
	 * @param invoiceChangeTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByPrimaryKeyDataList(List<InvoiceChangeTask> invoiceChangeTasks);

	/**
	 * @Title:
	 * @Description: 动态修改开票变更任务
	 * @param invoiceChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByPrimaryKeySelectiveData(InvoiceChangeTask invoiceChangeTask);

	/**
	 * @Title:
	 * @Description: 批量动态修改开票变更任务
	 * @param invoiceChangeTasks
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByPrimaryKeySelectiveDataList(List<InvoiceChangeTask> invoiceChangeTasks);

	/**
	 * @Title:
	 * @Description: 根据条件修改开票变更任务
	 * @param invoiceChangeTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByExampleData(InvoiceChangeTask invoiceChangeTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改开票变更任务
	 * @param invoiceChangeTask
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByExampleSelectiveData(InvoiceChangeTask invoiceChangeTask, Example example);

	/**
	 * @Title:
	 * @Description: 根据invoiceChangeTaskId删除开票变更任务
	 * @param invoiceChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int deleteData(InvoiceChangeTask invoiceChangeTask);

	/**
	 * @Title:
	 * @Description: 根据invoiceChangeTaskId集合批量删除开票变更任务
	 * @param invoiceChangeTaskIds
	 * @param invoiceChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int deleteDataList(List invoiceChangeTaskIds, InvoiceChangeTask invoiceChangeTask);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除开票变更任务
	 * @param example
	 * @param invoiceChangeTask
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int deleteExampleData(Example example, InvoiceChangeTask invoiceChangeTask);

	/**
	 * @Title:
	 * @Description: 查询全部开票变更任务
	 * @return List<InvoiceChangeTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	List<InvoiceChangeTask> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个开票变更任务
	 * @param example
	 * @return InvoiceChangeTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	InvoiceChangeTask selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询开票变更任务
	 * @param example
	 * @return List<InvoiceChangeTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	List<InvoiceChangeTask> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过invoiceChangeTaskId查询开票变更任务
	 * @param invoiceChangeTaskId
	 * @return InvoiceChangeTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	InvoiceChangeTask selectByPrimaryKey(Object invoiceChangeTaskId);

	/**
	 * @Title:
	 * @Description: 分页查询开票变更任务
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<InvoiceChangeTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	PageInfoExtend<InvoiceChangeTask> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询开票变更任务vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改开票变更任务
	 * @param invoiceChangeTask,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByPrimaryKeyData(InvoiceChangeTask invoiceChangeTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改开票变更任务,并进行排他
	 * @param invoiceChangeTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByPrimaryKeyDataList(List<InvoiceChangeTask> invoiceChangeTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改开票变更任务,并进行排他
	 * @param invoiceChangeTask
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(InvoiceChangeTask invoiceChangeTask, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改开票变更任务,并进行排他
	 * @param invoiceChangeTasks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByPrimaryKeySelectiveDataList(List<InvoiceChangeTask> invoiceChangeTasks, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改开票变更任务,并进行排他
	 * @param invoiceChangeTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByExampleData(InvoiceChangeTask invoiceChangeTask, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改开票变更任务,并进行排他
	 * @param invoiceChangeTask
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	int updateByExampleSelectiveData(InvoiceChangeTask invoiceChangeTask, Example example, boolean exclusive);

}
