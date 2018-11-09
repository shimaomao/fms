package cn.com.leadu.fms.data.original.repository;

import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailRepository
 * @Description: 借阅任务明细Repository层
 * @date 2018-07-16
 */
public interface BorrowTaskDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增借阅任务明细
	 * @param borrowTaskDetail
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int insertData(BorrowTaskDetail borrowTaskDetail);

	/**
	 * @Title:
	 * @Description: 批量保存借阅任务明细
	 * @param borrowTaskDetails
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int insertDataList(List<BorrowTaskDetail> borrowTaskDetails);

	/**
	 * @Title:
	 * @Description: 修改借阅任务明细
	 * @param borrowTaskDetail
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByPrimaryKeyData(BorrowTaskDetail borrowTaskDetail);

	/**
	 * @Title:
	 * @Description: 批量修改借阅任务明细
	 * @param borrowTaskDetails
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByPrimaryKeyDataList(List<BorrowTaskDetail> borrowTaskDetails);

	/**
	 * @Title:
	 * @Description: 动态修改借阅任务明细
	 * @param borrowTaskDetail
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByPrimaryKeySelectiveData(BorrowTaskDetail borrowTaskDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改借阅任务明细
	 * @param borrowTaskDetails
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByPrimaryKeySelectiveDataList(List<BorrowTaskDetail> borrowTaskDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改借阅任务明细
	 * @param borrowTaskDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByExampleData(BorrowTaskDetail borrowTaskDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改借阅任务明细
	 * @param borrowTaskDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByExampleSelectiveData(BorrowTaskDetail borrowTaskDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据borrowTaskDetailId删除借阅任务明细
	 * @param borrowTaskDetail
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int deleteData(BorrowTaskDetail borrowTaskDetail);

	/**
	 * @Title:
	 * @Description: 根据borrowTaskDetailId集合批量删除借阅任务明细
	 * @param borrowTaskDetailIds
	 * @param borrowTaskDetail
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int deleteDataList(List borrowTaskDetailIds, BorrowTaskDetail borrowTaskDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除借阅任务明细
	 * @param example
	 * @param borrowTaskDetail
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int deleteExampleData(Example example, BorrowTaskDetail borrowTaskDetail);

	/**
	 * @Title:
	 * @Description: 查询全部借阅任务明细
	 * @return List<BorrowTaskDetail>
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	List<BorrowTaskDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个借阅任务明细
	 * @param example
	 * @return BorrowTaskDetail
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	BorrowTaskDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询借阅任务明细
	 * @param example
	 * @return List<BorrowTaskDetail>
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	List<BorrowTaskDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过borrowTaskDetailId查询借阅任务明细
	 * @param borrowTaskDetailId
	 * @return BorrowTaskDetail
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	BorrowTaskDetail selectByPrimaryKey(Object borrowTaskDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询借阅任务明细
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BorrowTaskDetail>
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	PageInfoExtend<BorrowTaskDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询借阅任务明细vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改借阅任务明细
	 * @param borrowTaskDetail,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByPrimaryKeyData(BorrowTaskDetail borrowTaskDetail, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改借阅任务明细,并进行排他
	 * @param borrowTaskDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByPrimaryKeyDataList(List<BorrowTaskDetail> borrowTaskDetails, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改借阅任务明细,并进行排他
	 * @param borrowTaskDetail
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(BorrowTaskDetail borrowTaskDetail, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改借阅任务明细,并进行排他
	 * @param borrowTaskDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByPrimaryKeySelectiveDataList(List<BorrowTaskDetail> borrowTaskDetails, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改借阅任务明细,并进行排他
	 * @param borrowTaskDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByExampleData(BorrowTaskDetail borrowTaskDetail, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改借阅任务明细,并进行排他
	 * @param borrowTaskDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	int updateByExampleSelectiveData(BorrowTaskDetail borrowTaskDetail, Example example, boolean exclusive);

}
