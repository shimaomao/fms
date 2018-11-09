package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetailRepository
 * @Description: 融资回填明细Repository层
 * @date 2018-05-12
 */
public interface FinBackfillDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增融资回填明细
	 * @param finBackfillDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int insertData(FinBackfillDetail finBackfillDetail);

	/**
	 * @Title:
	 * @Description: 批量保存融资回填明细
	 * @param finBackfillDetails
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int insertDataList(List<FinBackfillDetail> finBackfillDetails);

	/**
	 * @Title:
	 * @Description: 修改融资回填明细
	 * @param finBackfillDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int updateByPrimaryKeyData(FinBackfillDetail finBackfillDetail);

	/**
	 * @Title:
	 * @Description: 批量修改融资回填明细
	 * @param finBackfillDetails
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int updateByPrimaryKeyDataList(List<FinBackfillDetail> finBackfillDetails);

	/**
	 * @Title:
	 * @Description: 动态修改融资回填明细
	 * @param finBackfillDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int updateByPrimaryKeySelectiveData(FinBackfillDetail finBackfillDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改融资回填明细
	 * @param finBackfillDetails
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinBackfillDetail> finBackfillDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改融资回填明细
	 * @param finBackfillDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int updateByExampleData(FinBackfillDetail finBackfillDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改融资回填明细
	 * @param finBackfillDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int updateByExampleSelectiveData(FinBackfillDetail finBackfillDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据finBackfillDetailId删除融资回填明细
	 * @param finBackfillDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int deleteData(FinBackfillDetail finBackfillDetail);

	/**
	 * @Title:
	 * @Description: 根据finBackfillDetailId集合批量删除融资回填明细
	 * @param finBackfillDetailIds
	 * @param finBackfillDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int deleteDataList(List finBackfillDetailIds, FinBackfillDetail finBackfillDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除融资回填明细
	 * @param example
	 * @param finBackfillDetail
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	int deleteExampleData(Example example, FinBackfillDetail finBackfillDetail);

	/**
	 * @Title:
	 * @Description: 查询全部融资回填明细
	 * @return List<FinBackfillDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	List<FinBackfillDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个融资回填明细
	 * @param example
	 * @return FinBackfillDetail
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	FinBackfillDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询融资回填明细
	 * @param example
	 * @return List<FinBackfillDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	List<FinBackfillDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过finBackfillDetailId查询融资回填明细
	 * @param finBackfillDetailId
	 * @return FinBackfillDetail
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	FinBackfillDetail selectByPrimaryKey(Object finBackfillDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询融资回填明细
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinBackfillDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	PageInfoExtend<FinBackfillDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资回填明细vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
