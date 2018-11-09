package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmSaveVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueAssignmentRepository
 * @Description: 当日逾期任务信息Repository层
 * @date 2018-05-16
 */
public interface OverdueAssignmentRepository {

	/**
	 * @Title:
	 * @Description: 新增当日逾期任务信息
	 * @param overdueAssignment
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int insertData(OverdueAssignment overdueAssignment);

	/**
	 * @Title:
	 * @Description: 批量保存当日逾期任务信息
	 * @param overdueAssignments
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int insertDataList(List<OverdueAssignment> overdueAssignments);

	/**
	 * @Title:
	 * @Description: 修改当日逾期任务信息
	 * @param overdueAssignment
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int updateByPrimaryKeyData(OverdueAssignment overdueAssignment);

	/**
	 * @Title:
	 * @Description: 批量修改当日逾期任务信息
	 * @param overdueAssignments
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int updateByPrimaryKeyDataList(List<OverdueAssignment> overdueAssignments);

	/**
	 * @Title:
	 * @Description: 动态修改当日逾期任务信息
	 * @param overdueAssignment
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int updateByPrimaryKeySelectiveData(OverdueAssignment overdueAssignment);

	/**
	 * @Title:
	 * @Description: 批量动态修改当日逾期任务信息
	 * @param overdueAssignments
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueAssignment> overdueAssignments);

	/**
	 * @Title:
	 * @Description: 根据条件修改当日逾期任务信息
	 * @param overdueAssignment
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int updateByExampleData(OverdueAssignment overdueAssignment, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改当日逾期任务信息
	 * @param overdueAssignment
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int updateByExampleSelectiveData(OverdueAssignment overdueAssignment, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueAssignmentId删除当日逾期任务信息
	 * @param overdueAssignment
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int deleteData(OverdueAssignment overdueAssignment);

	/**
	 * @Title:
	 * @Description: 根据overdueAssignmentId集合批量删除当日逾期任务信息
	 * @param overdueAssignmentIds
	 * @param overdueAssignment
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int deleteDataList(List overdueAssignmentIds, OverdueAssignment overdueAssignment);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除当日逾期任务信息
	 * @param example
	 * @param overdueAssignment
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	int deleteExampleData(Example example, OverdueAssignment overdueAssignment);

	/**
	 * @Title:
	 * @Description: 查询全部当日逾期任务信息
	 * @return List<OverdueAssignment>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	List<OverdueAssignment> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个当日逾期任务信息
	 * @param example
	 * @return OverdueAssignment
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	OverdueAssignment selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询当日逾期任务信息
	 * @param example
	 * @return List<OverdueAssignment>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	List<OverdueAssignment> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueAssignmentId查询当日逾期任务信息
	 * @param overdueAssignmentId
	 * @return OverdueAssignment
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	OverdueAssignment selectByPrimaryKey(Object overdueAssignmentId);

	/**
	 * @Title:
	 * @Description: 分页查询当日逾期任务信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueAssignment>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	PageInfoExtend<OverdueAssignment> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询当日逾期任务信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
