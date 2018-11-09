package cn.com.leadu.fms.data.activiti.repository;

import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeaveApproval;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleaveapproval.ActUserLeaveApprovalVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveApprovalRepository
 * @Description: 用户请假审批Repository层
 * @date 2018-03-20
 */
public interface ActUserLeaveApprovalRepository {

	/**
	 * @Title:
	 * @Description: 新增用户请假审批
	 * @param actUserLeaveApproval
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int insertData(ActUserLeaveApproval actUserLeaveApproval);

	/**
	 * @Title:
	 * @Description: 批量保存用户请假审批
	 * @param actUserLeaveApprovals
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int insertDataList(List<ActUserLeaveApproval> actUserLeaveApprovals);

	/**
	 * @Title:
	 * @Description: 修改用户请假审批
	 * @param actUserLeaveApproval
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int updateByPrimaryKeyData(ActUserLeaveApproval actUserLeaveApproval);

	/**
	 * @Title:
	 * @Description: 批量修改用户请假审批
	 * @param actUserLeaveApprovals
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int updateByPrimaryKeyDataList(List<ActUserLeaveApproval> actUserLeaveApprovals);

	/**
	 * @Title:
	 * @Description: 动态修改用户请假审批
	 * @param actUserLeaveApproval
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int updateByPrimaryKeySelectiveData(ActUserLeaveApproval actUserLeaveApproval);

	/**
	 * @Title:
	 * @Description: 批量动态修改用户请假审批
	 * @param actUserLeaveApprovals
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int updateByPrimaryKeySelectiveDataList(List<ActUserLeaveApproval> actUserLeaveApprovals);

	/**
	 * @Title:
	 * @Description: 根据条件修改用户请假审批
	 * @param actUserLeaveApproval
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int updateByExampleData(ActUserLeaveApproval actUserLeaveApproval, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改用户请假审批
	 * @param actUserLeaveApproval
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int updateByExampleSelectiveData(ActUserLeaveApproval actUserLeaveApproval, Example example);

	/**
	 * @Title:
	 * @Description: 根据approvalId删除用户请假审批
	 * @param actUserLeaveApproval
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int deleteData(ActUserLeaveApproval actUserLeaveApproval);

	/**
	 * @Title:
	 * @Description: 根据approvalId集合批量删除用户请假审批
	 * @param approvalIds
	 * @param actUserLeaveApproval
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	int deleteDataList(List approvalIds, ActUserLeaveApproval actUserLeaveApproval);

	/**
	 * @Title:
	 * @Description: 查询全部用户请假审批
	 * @return List<ActUserLeaveApproval>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	List<ActUserLeaveApproval> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个用户请假审批
	 * @param example
	 * @return ActUserLeaveApproval
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	ActUserLeaveApproval selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询用户请假审批
	 * @param example
	 * @return List<ActUserLeaveApproval>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	List<ActUserLeaveApproval> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过approvalId查询用户请假审批
	 * @param approvalId
	 * @return ActUserLeaveApproval
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	ActUserLeaveApproval selectByPrimaryKey(Object approvalId);

	/**
	 * @Title:
	 * @Description: 分页查询用户请假审批
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ActUserLeaveApproval>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	PageInfoExtend<ActUserLeaveApproval> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询用户请假审批vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ActUserLeaveApproval>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	PageInfoExtend<ActUserLeaveApproval> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
