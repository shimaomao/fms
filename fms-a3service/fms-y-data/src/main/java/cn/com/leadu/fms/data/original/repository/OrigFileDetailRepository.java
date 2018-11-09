package cn.com.leadu.fms.data.original.repository;

import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowPostVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OrigFileDetailRepository
 * @Description: 原件归档明细信息Repository层
 * @date 2018-05-30
 */
public interface OrigFileDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增原件归档明细信息
	 * @param origFileDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int insertData(OrigFileDetail origFileDetail);

	/**
	 * @Title:
	 * @Description: 批量保存原件归档明细信息
	 * @param origFileDetails
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int insertDataList(List<OrigFileDetail> origFileDetails);

	/**
	 * @Title:
	 * @Description: 修改原件归档明细信息
	 * @param origFileDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByPrimaryKeyData(OrigFileDetail origFileDetail);

	/**
	 * @Title:
	 * @Description: 批量修改原件归档明细信息
	 * @param origFileDetails
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByPrimaryKeyDataList(List<OrigFileDetail> origFileDetails);

	/**
	 * @Title:
	 * @Description: 动态修改原件归档明细信息
	 * @param origFileDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByPrimaryKeySelectiveData(OrigFileDetail origFileDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改原件归档明细信息
	 * @param origFileDetails
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByPrimaryKeySelectiveDataList(List<OrigFileDetail> origFileDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改原件归档明细信息
	 * @param origFileDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByExampleData(OrigFileDetail origFileDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改原件归档明细信息
	 * @param origFileDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByExampleSelectiveData(OrigFileDetail origFileDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据origFileDetailId删除原件归档明细信息
	 * @param origFileDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int deleteData(OrigFileDetail origFileDetail);

	/**
	 * @Title:
	 * @Description: 根据origFileDetailId集合批量删除原件归档明细信息
	 * @param origFileDetailIds
	 * @param origFileDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int deleteDataList(List origFileDetailIds, OrigFileDetail origFileDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除原件归档明细信息
	 * @param example
	 * @param origFileDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int deleteExampleData(Example example, OrigFileDetail origFileDetail);

	/**
	 * @Title:
	 * @Description: 查询全部原件归档明细信息
	 * @return List<OrigFileDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	List<OrigFileDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个原件归档明细信息
	 * @param example
	 * @return OrigFileDetail
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	OrigFileDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询原件归档明细信息
	 * @param example
	 * @return List<OrigFileDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	List<OrigFileDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过origFileDetailId查询原件归档明细信息
	 * @param origFileDetailId
	 * @return OrigFileDetail
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	OrigFileDetail selectByPrimaryKey(Object origFileDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询原件归档明细信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OrigFileDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	PageInfoExtend<OrigFileDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询原件归档明细信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改原件归档明细信息
	 * @param origFileDetail,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByPrimaryKeyData(OrigFileDetail origFileDetail, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改原件归档明细信息,并进行排他
	 * @param origFileDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByPrimaryKeyDataList(List<OrigFileDetail> origFileDetails, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改原件归档明细信息,并进行排他
	 * @param origFileDetail
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(OrigFileDetail origFileDetail, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改原件归档明细信息,并进行排他
	 * @param origFileDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByPrimaryKeySelectiveDataList(List<OrigFileDetail> origFileDetails, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改原件归档明细信息,并进行排他
	 * @param origFileDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByExampleData(OrigFileDetail origFileDetail, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改原件归档明细信息,并进行排他
	 * @param origFileDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	int updateByExampleSelectiveData(OrigFileDetail origFileDetail, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件明细vo
	 * @param origFileDetailVo
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	List<OrigFileDetailVo> selectOrigFileDetails(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 查询资料邮寄附件明细vo
	 * @param origFileDetailVo
	 * @return List<OrigFileDetailVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	List<OrigFileDetailVo> selectOrigFileBorrowDetails(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 查询资料邮寄附件明细vo
	 * @param borrowTaskNo
	 * @return List<OrigFileDetailVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	List<OrigFileDetailVo> selectOrigFileBorrowMailByBorrowTaskNo(String borrowTaskNo);

	/**
	 * @Title:
	 * @Description: 查询资料邮寄附件明细vo（借阅归还）
	 * @param origFileDetailVo
	 * @return List<OrigFileDetailVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 17:21:08
	 */
	List<OrigFileDetailVo> findOrigFileBorrowBackMailByBorrowTaskNo(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 据借阅归还任务号获取财务制单初始化信息
	 * @param borrowBackTaskNo
	 * @return BorrowBackTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:39
	 */
	BorrowBackTaskVo selectBorrowTaskMakeVoucherByBorrowBackTaskNo(String borrowBackTaskNo);

	/**
	 * @Title:
	 * @Description: 据借阅归还任务号获取资管审核邮寄附件明细信息列表
	 * @param borrowBackTaskNo
	 * @return BorrowBackTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:39
	 */
	List<OrigFileDetailVo> selectOrigFileBorrowMailByBorrowBackTaskNo(String borrowBackTaskNo);

	/**
	 * @Title:
	 * @Description: 据借阅归还任务号获取资管审核邮寄附件明细信息列表
	 * @param origFileDetailVo
	 * @return BorrowBackTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:39
	 */
	List<OrigFileDetailVo> selectOrigFileBorrowExamineByBorrowBackTaskNo(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 取待打印客户信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	BorrowBackTaskVo selectCustomerInformationByBorrowBackTaskNo(String borrowBackTaskNo,String bizCodeType);

}
