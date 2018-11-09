package cn.com.leadu.fms.original.service;

import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.original.validator.borrowtask.vo.BorrowTaskSaveVo;
import cn.com.leadu.fms.original.validator.borrowtask.vo.BorrowTaskModifyVo;
import cn.com.leadu.fms.original.validator.borrowtask.vo.BorrowTaskDeleteVo;
import cn.com.leadu.fms.original.validator.borrowtask.vo.BorrowTaskDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskService
 * @Description: 借阅任务信息业务层
 * @date 2018-05-30
 */
public interface BorrowTaskService {

	/**
	 * @Title:
	 * @Description: 分页查询借阅任务信息
	 * @param borrowTaskVo
	 * @return PageInfoExtend<BorrowTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 16:21:19
	 */
	PageInfoExtend<BorrowTaskVo> findBorrowTasksByPage(BorrowTaskVo borrowTaskVo);

	/**
	 * @Title:
	 * @Description: 保存借阅任务信息
	 * @param borrowTaskSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 16:21:19
	 */
    void saveBorrowTask(BorrowTaskSaveVo borrowTaskSaveVo);


	/**
	 * @Title:
	 * @Description: 修改借阅任务信息
	 * @param borrowTaskModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 16:21:19
	 */
	void modifyBorrowTask(BorrowTaskModifyVo borrowTaskModifyVo);

	/**
	 * @Title:
	 * @Description:  通过borrowTaskId删除借阅任务信息
	 * @param borrowTaskDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 16:21:19
	 */
	void deleteBorrowTask(BorrowTaskDeleteVo borrowTaskDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过borrowTaskId集合删除借阅任务信息
	 * @param borrowTaskDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 16:21:19
	 */
	void deleteBorrowTasksByBorrowTaskIds(BorrowTaskDeleteListVo borrowTaskDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据borrowTaskId获取借阅任务信息
	 * @param borrowTaskId
	 * @return BorrowTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 16:21:19
	 */
	BorrowTask findBorrowTaskByBorrowTaskId(String borrowTaskId);

	/**
	 * @Title:
	 * @Description:  根据borrowTaskNo获取借阅任务信息
	 * @param borrowTaskNo
	 * @return BorrowTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-30 16:21:19
	 */
	BorrowTaskVo findBorrowTaskByBorrowTaskNo(String borrowTaskNo);

}
