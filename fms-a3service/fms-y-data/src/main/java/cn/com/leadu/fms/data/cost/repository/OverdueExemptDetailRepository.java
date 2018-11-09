package cn.com.leadu.fms.data.cost.repository;

import cn.com.leadu.fms.pojo.cost.entity.OverdueExemptDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptDetailRepository
 * @Description: 罚息免除任务明细表Repository层
 * @date 2018-05-30
 */
public interface OverdueExemptDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增罚息免除任务明细表
	 * @param overdueExemptDetail
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int insertData(OverdueExemptDetail overdueExemptDetail);

	/**
	 * @Title:
	 * @Description: 批量保存罚息免除任务明细表
	 * @param overdueExemptDetails
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int insertDataList(List<OverdueExemptDetail> overdueExemptDetails);

	/**
	 * @Title:
	 * @Description: 修改罚息免除任务明细表
	 * @param overdueExemptDetail
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int updateByPrimaryKeyData(OverdueExemptDetail overdueExemptDetail);

	/**
	 * @Title:
	 * @Description: 批量修改罚息免除任务明细表
	 * @param overdueExemptDetails
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int updateByPrimaryKeyDataList(List<OverdueExemptDetail> overdueExemptDetails);

	/**
	 * @Title:
	 * @Description: 动态修改罚息免除任务明细表
	 * @param overdueExemptDetail
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int updateByPrimaryKeySelectiveData(OverdueExemptDetail overdueExemptDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改罚息免除任务明细表
	 * @param overdueExemptDetails
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueExemptDetail> overdueExemptDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改罚息免除任务明细表
	 * @param overdueExemptDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int updateByExampleData(OverdueExemptDetail overdueExemptDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改罚息免除任务明细表
	 * @param overdueExemptDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int updateByExampleSelectiveData(OverdueExemptDetail overdueExemptDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueExemptDetailId删除罚息免除任务明细表
	 * @param overdueExemptDetail
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int deleteData(OverdueExemptDetail overdueExemptDetail);

	/**
	 * @Title:
	 * @Description: 根据overdueExemptDetailId集合批量删除罚息免除任务明细表
	 * @param overdueExemptDetailIds
	 * @param overdueExemptDetail
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int deleteDataList(List overdueExemptDetailIds,OverdueExemptDetail overdueExemptDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除罚息免除任务明细表
	 * @param example
	 * @param overdueExemptDetail
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	int deleteExampleData(Example example,OverdueExemptDetail overdueExemptDetail);

	/**
	 * @Title:
	 * @Description: 查询全部罚息免除任务明细表
	 * @return List<OverdueExemptDetail>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	List<OverdueExemptDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个罚息免除任务明细表
	 * @param example
	 * @return OverdueExemptDetail
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	OverdueExemptDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询罚息免除任务明细表
	 * @param example
	 * @return List<OverdueExemptDetail>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	List<OverdueExemptDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueExemptDetailId查询罚息免除任务明细表
	 * @param overdueExemptDetailId
	 * @return OverdueExemptDetail
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	OverdueExemptDetail selectByPrimaryKey(Object overdueExemptDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询罚息免除任务明细表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueExemptDetail>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	PageInfoExtend<OverdueExemptDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询罚息免除任务明细表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:43:43
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

}
