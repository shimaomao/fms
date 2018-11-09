package cn.com.leadu.fms.data.activiti.repository;

import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeave;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleave.ActUserLeaveVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveRepository
 * @Description: 用户请假Repository层
 * @date 2018-03-14
 */
public interface ActUserLeaveRepository {

	/**
	 * @Title:
	 * @Description: 新增用户请假
	 * @param actUserLeave
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int insertData(ActUserLeave actUserLeave);

	/**
	 * @Title:
	 * @Description: 批量保存用户请假
	 * @param actUserLeaves
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int insertDataList(List<ActUserLeave> actUserLeaves);

	/**
	 * @Title:
	 * @Description: 修改用户请假
	 * @param actUserLeave
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int updateByPrimaryKeyData(ActUserLeave actUserLeave);

	/**
	 * @Title:
	 * @Description: 批量修改用户请假
	 * @param actUserLeaves
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int updateByPrimaryKeyDataList(List<ActUserLeave> actUserLeaves);

	/**
	 * @Title:
	 * @Description: 动态修改用户请假
	 * @param actUserLeave
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int updateByPrimaryKeySelectiveData(ActUserLeave actUserLeave);

	/**
	 * @Title:
	 * @Description: 批量动态修改用户请假
	 * @param actUserLeaves
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int updateByPrimaryKeySelectiveDataList(List<ActUserLeave> actUserLeaves);

	/**
	 * @Title:
	 * @Description: 根据条件修改用户请假
	 * @param actUserLeave
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int updateByExampleData(ActUserLeave actUserLeave, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改用户请假
	 * @param actUserLeave
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int updateByExampleSelectiveData(ActUserLeave actUserLeave, Example example);

	/**
	 * @Title:
	 * @Description: 根据leaveId删除用户请假
	 * @param actUserLeave
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int deleteData(ActUserLeave actUserLeave);

	/**
	 * @Title:
	 * @Description: 根据leaveId集合批量删除用户请假
	 * @param leaveIds
	 * @param actUserLeave
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	int deleteDataList(List leaveIds, ActUserLeave actUserLeave);

	/**
	 * @Title:
	 * @Description: 查询全部用户请假
	 * @return List<ActUserLeave>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	List<ActUserLeave> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个用户请假
	 * @param example
	 * @return ActUserLeave
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	ActUserLeave selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询用户请假
	 * @param example
	 * @return List<ActUserLeave>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	List<ActUserLeave> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过leaveId查询用户请假
	 * @param leaveId
	 * @return ActUserLeave
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	ActUserLeave selectByPrimaryKey(Object leaveId);

	/**
	 * @Title:
	 * @Description: 分页查询用户请假
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ActUserLeave>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	PageInfoExtend<ActUserLeave> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询用户请假vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ActUserLeave>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:51
	 */
	PageInfoExtend<ActUserLeave> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
