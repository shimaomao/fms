package cn.com.leadu.fms.data.asset.repository;

import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailRepository
 * @Description: 资方抵押还款计划Repository层
 */
public interface EquMorRepayDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增资方抵押还款计划
	 * @param equMorRepayDetail
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int insertData(EquMorRepayDetail equMorRepayDetail);

	/**
	 * @Title:
	 * @Description: 批量保存资方抵押还款计划
	 * @param equMorRepayDetails
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int insertDataList(List<EquMorRepayDetail> equMorRepayDetails);

	/**
	 * @Title:
	 * @Description: 修改资方抵押还款计划
	 * @param equMorRepayDetail
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByPrimaryKeyData(EquMorRepayDetail equMorRepayDetail);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押还款计划
	 * @param equMorRepayDetails
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByPrimaryKeyDataList(List<EquMorRepayDetail> equMorRepayDetails);

	/**
	 * @Title:
	 * @Description: 动态修改资方抵押还款计划
	 * @param equMorRepayDetail
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByPrimaryKeySelectiveData(EquMorRepayDetail equMorRepayDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押还款计划
	 * @param equMorRepayDetails
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorRepayDetail> equMorRepayDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押还款计划
	 * @param equMorRepayDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByExampleData(EquMorRepayDetail equMorRepayDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押还款计划
	 * @param equMorRepayDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByExampleSelectiveData(EquMorRepayDetail equMorRepayDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据equMorRepayDetailId删除资方抵押还款计划
	 * @param equMorRepayDetail
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int deleteData(EquMorRepayDetail equMorRepayDetail);

	/**
	 * @Title:
	 * @Description: 根据equMorRepayDetailId集合批量删除资方抵押还款计划
	 * @param equMorRepayDetailIds
	 * @param equMorRepayDetail
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int deleteDataList(List equMorRepayDetailIds,EquMorRepayDetail equMorRepayDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除资方抵押还款计划
	 * @param example
	 * @param equMorRepayDetail
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int deleteExampleData(Example example,EquMorRepayDetail equMorRepayDetail);

	/**
	 * @Title:
	 * @Description: 查询全部资方抵押还款计划
	 * @return List<EquMorRepayDetail>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	List<EquMorRepayDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个资方抵押还款计划
	 * @param example
	 * @return EquMorRepayDetail
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	EquMorRepayDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询资方抵押还款计划
	 * @param example
	 * @return List<EquMorRepayDetail>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	List<EquMorRepayDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过equMorRepayDetailId查询资方抵押还款计划
	 * @param equMorRepayDetailId
	 * @return EquMorRepayDetail
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	EquMorRepayDetail selectByPrimaryKey(Object equMorRepayDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押还款计划
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<EquMorRepayDetail>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	PageInfoExtend<EquMorRepayDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押还款计划vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改资方抵押还款计划
	 * @param equMorRepayDetail,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByPrimaryKeyData(EquMorRepayDetail equMorRepayDetail,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押还款计划,并进行排他
	 * @param equMorRepayDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByPrimaryKeyDataList(List<EquMorRepayDetail> equMorRepayDetails,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改资方抵押还款计划,并进行排他
	 * @param equMorRepayDetail
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(EquMorRepayDetail equMorRepayDetail,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押还款计划,并进行排他
	 * @param equMorRepayDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorRepayDetail> equMorRepayDetails,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押还款计划,并进行排他
	 * @param equMorRepayDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByExampleData(EquMorRepayDetail equMorRepayDetail, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押还款计划,并进行排他
	 * @param equMorRepayDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	int updateByExampleSelectiveData(EquMorRepayDetail equMorRepayDetail, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 获取需要插入抵押还款计划详细表
	 * @return List<EquMorRepayDetailVo>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	List<EquMorRepayDetailVo> selectEquMorRepayDetailVosByEquTaskNo(String equMorTaskNo);


	/**
	 * @Title:
	 * @Description: 资方抵押还款计划详情表获取一览数据
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	List<EquMorRepayDetailVo> selectEquMorRepayDetailVosByPage(EquMorRepayDetailVo equMorRepayDetailVo);
}
