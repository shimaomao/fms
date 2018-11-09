package cn.com.leadu.fms.data.cost.repository;

import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailRepository
 * @Description: 提前还款明细Repository层
 * @date 2018-05-11
 */
public interface ContPrepayDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增提前还款明细
	 * @param contPrepayDetail
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int insertData(ContPrepayDetail contPrepayDetail);

	/**
	 * @Title:
	 * @Description: 批量保存提前还款明细
	 * @param contPrepayDetails
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int insertDataList(List<ContPrepayDetail> contPrepayDetails);

	/**
	 * @Title:
	 * @Description: 修改提前还款明细
	 * @param contPrepayDetail
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int updateByPrimaryKeyData(ContPrepayDetail contPrepayDetail);

	/**
	 * @Title:
	 * @Description: 批量修改提前还款明细
	 * @param contPrepayDetails
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int updateByPrimaryKeyDataList(List<ContPrepayDetail> contPrepayDetails);

	/**
	 * @Title:
	 * @Description: 动态修改提前还款明细
	 * @param contPrepayDetail
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int updateByPrimaryKeySelectiveData(ContPrepayDetail contPrepayDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改提前还款明细
	 * @param contPrepayDetails
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContPrepayDetail> contPrepayDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改提前还款明细
	 * @param contPrepayDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int updateByExampleData(ContPrepayDetail contPrepayDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改提前还款明细
	 * @param contPrepayDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int updateByExampleSelectiveData(ContPrepayDetail contPrepayDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据contPrepayDetailId删除提前还款明细
	 * @param contPrepayDetail
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int deleteData(ContPrepayDetail contPrepayDetail);

	/**
	 * @Title:
	 * @Description: 根据contPrepayDetailId集合批量删除提前还款明细
	 * @param contPrepayDetailIds
	 * @param contPrepayDetail
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int deleteDataList(List contPrepayDetailIds,ContPrepayDetail contPrepayDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除提前还款明细
	 * @param example
	 * @param contPrepayDetail
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	int deleteExampleData(Example example,ContPrepayDetail contPrepayDetail);

	/**
	 * @Title:
	 * @Description: 查询全部提前还款明细
	 * @return List<ContPrepayDetail>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	List<ContPrepayDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个提前还款明细
	 * @param example
	 * @return ContPrepayDetail
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	ContPrepayDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询提前还款明细
	 * @param example
	 * @return List<ContPrepayDetail>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	List<ContPrepayDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contPrepayDetailId查询提前还款明细
	 * @param contPrepayDetailId
	 * @return ContPrepayDetail
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	ContPrepayDetail selectByPrimaryKey(Object contPrepayDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询提前还款明细
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContPrepayDetail>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	PageInfoExtend<ContPrepayDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询提前还款明细vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

}
