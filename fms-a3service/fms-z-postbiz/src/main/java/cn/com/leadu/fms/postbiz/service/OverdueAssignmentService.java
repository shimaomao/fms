package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import cn.com.leadu.fms.pojo.postbiz.vo.overdueassignment.OverdueAssignmentVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmSaveVo;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.OverdueAssignmentSaveVo;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.OverdueAssignmentModifyVo;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.OverdueAssignmentDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.OverdueAssignmentDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: OverdueAssignmentService
 * @Description: 当日逾期任务信息业务层
 * @date 2018-05-16
 */
public interface OverdueAssignmentService {

	/**
	 * @Title:
	 * @Description: 分页查询当日逾期任务信息
	 * @param overdueAssignmentVo
	 * @return PageInfoExtend<OverdueAssignment>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	PageInfoExtend<OverdueAssignment> findOverdueAssignmentsByPage(OverdueAssignmentVo overdueAssignmentVo);

	/**
	 * @Title:
	 * @Description: 保存当日逾期任务信息
	 * @param overdueAssignmentSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
    void saveOverdueAssignment(OverdueAssignmentSaveVo overdueAssignmentSaveVo);

	/**
	 * @Title:
	 * @Description: 催收任务分配，更新当日逾期任务信息
	 * @param overdueCstmSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	void saveAssignment(OverdueCstmSaveVo overdueCstmSaveVo);


	/**
	 * @Title:
	 * @Description: 修改当日逾期任务信息
	 * @param overdueAssignmentModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	void modifyOverdueAssignment(OverdueAssignmentModifyVo overdueAssignmentModifyVo);

	/**
	 * @Title:
	 * @Description:  通过overdueAssignmentId删除当日逾期任务信息
	 * @param overdueAssignmentDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	void deleteOverdueAssignment(OverdueAssignmentDeleteVo overdueAssignmentDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过overdueAssignmentId集合删除当日逾期任务信息
	 * @param overdueAssignmentDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	void deleteOverdueAssignmentsByOverdueAssignmentIds(OverdueAssignmentDeleteListVo overdueAssignmentDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据overdueAssignmentId获取当日逾期任务信息
	 * @param overdueAssignmentId
	 * @return OverdueAssignment
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:12:03
	 */
	OverdueAssignment findOverdueAssignmentByOverdueAssignmentId(String overdueAssignmentId);

}
