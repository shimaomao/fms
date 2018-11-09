package cn.com.leadu.fms.original.service;

import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import cn.com.leadu.fms.pojo.original.vo.borrowtaskdetail.BorrowTaskDetailVo;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.BorrowTaskDetailSaveVo;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.BorrowTaskDetailModifyVo;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.BorrowTaskDetailDeleteVo;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.BorrowTaskDetailDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailService
 * @Description: 借阅任务明细业务层
 * @date 2018-07-16
 */
public interface BorrowTaskDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询借阅任务明细
	 * @param borrowTaskDetailVo
	 * @return PageInfoExtend<BorrowTaskDetail>
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	PageInfoExtend<BorrowTaskDetail> findBorrowTaskDetailsByPage(BorrowTaskDetailVo borrowTaskDetailVo);

	/**
	 * @Title:
	 * @Description: 保存借阅任务明细
	 * @param borrowTaskDetailSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
    void saveBorrowTaskDetail(BorrowTaskDetailSaveVo borrowTaskDetailSaveVo);


	/**
	 * @Title:
	 * @Description: 修改借阅任务明细
	 * @param borrowTaskDetailModifyVo
	 * @return
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	void modifyBorrowTaskDetail(BorrowTaskDetailModifyVo borrowTaskDetailModifyVo);

	/**
	 * @Title:
	 * @Description:  通过borrowTaskDetailId删除借阅任务明细
	 * @param borrowTaskDetailDeleteVo
	 * @return
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	void deleteBorrowTaskDetail(BorrowTaskDetailDeleteVo borrowTaskDetailDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过borrowTaskDetailId集合删除借阅任务明细
	 * @param borrowTaskDetailDeleteListVo
	 * @return
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	void deleteBorrowTaskDetailsByBorrowTaskDetailIds(BorrowTaskDetailDeleteListVo borrowTaskDetailDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据borrowTaskDetailId获取借阅任务明细
	 * @param borrowTaskDetailId
	 * @return BorrowTaskDetail
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-16 17:28:54
	 */
	BorrowTaskDetail findBorrowTaskDetailByBorrowTaskDetailId(String borrowTaskDetailId);

}
