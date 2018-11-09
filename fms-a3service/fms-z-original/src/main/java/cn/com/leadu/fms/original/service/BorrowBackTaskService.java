package cn.com.leadu.fms.original.service;

import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.BorrowBackTaskSaveVo;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.BorrowBackTaskModifyVo;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.BorrowBackTaskDeleteVo;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.BorrowBackTaskDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskService
 * @Description: 借阅归还任务信息业务层
 * @date 2018-06-04
 */
public interface BorrowBackTaskService {

	/**
	 * @Title:
	 * @Description: 分页查询借阅归还任务信息
	 * @param borrowBackTaskVo
	 * @return PageInfoExtend<BorrowBackTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	PageInfoExtend<BorrowBackTask> findBorrowBackTasksByPage(BorrowBackTaskVo borrowBackTaskVo);

	/**
	 * @Title:
	 * @Description: 保存借阅归还任务信息
	 * @param borrowBackTaskSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
    void saveBorrowBackTask(BorrowBackTaskSaveVo borrowBackTaskSaveVo);


	/**
	 * @Title:
	 * @Description: 修改借阅归还任务信息
	 * @param borrowBackTaskModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	void modifyBorrowBackTask(BorrowBackTaskModifyVo borrowBackTaskModifyVo);

	/**
	 * @Title:
	 * @Description:  通过borrowBackTaskId删除借阅归还任务信息
	 * @param borrowBackTaskDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	void deleteBorrowBackTask(BorrowBackTaskDeleteVo borrowBackTaskDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过borrowBackTaskId集合删除借阅归还任务信息
	 * @param borrowBackTaskDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	void deleteBorrowBackTasksByBorrowBackTaskIds(BorrowBackTaskDeleteListVo borrowBackTaskDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据borrowBackTaskId获取借阅归还任务信息
	 * @param borrowBackTaskId
	 * @return BorrowBackTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	BorrowBackTask findBorrowBackTaskByBorrowBackTaskId(String borrowBackTaskId);

	/**
	 * @Title:
	 * @Description:  根据borrowBackTaskNo获取借阅归还任务信息
	 * @param borrowBackTaskNo
	 * @return BorrowBackTask
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-4 10:42:26
	 */
	BorrowBackTaskVo findBorrowBackTaskByBorrowBackTaskNo(String borrowBackTaskNo);

	/** 
	* @Description: 根据borrowBackTaskNo获取借阅归还任务实体
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/17 17:04
	*/ 
	BorrowBackTask findBorrowBackEntityByBorrowBackTaskNo(String borrowBackTaskNo);

}
