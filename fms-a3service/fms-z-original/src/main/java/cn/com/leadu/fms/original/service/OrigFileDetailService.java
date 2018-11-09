package cn.com.leadu.fms.original.service;

import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowFinanceVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowPostVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailSaveVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailModifyVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailDeleteVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: OrigFileDetailService
 * @Description: 资料邮寄附件明细业务层
 * @date 2018-05-03
 */
public interface OrigFileDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件明细
	 * @param origFileDetailVo
	 * @return PageInfoExtend<OrigFileDetail>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
	List<OrigFileDetailVo> findOrigFileDetailsByPage(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件明细
	 * @param borrowTaskNo
	 * @return List<OrigFileDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	List<OrigFileDetailVo> findOrigFileBorrowMailByBorrowTaskNo(String borrowTaskNo);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件明细(借阅归还)
	 * @param origFileDetailVo
	 * @return List<OrigFileDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	List<OrigFileDetailVo> findOrigFileBorrowBackMailByBorrowTaskNo(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件明细
	 * @param borrowBackTaskNo
	 * @return List<OrigFileDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	List<OrigFileDetailVo> findOrigFileBorrowMailByBorrowBackTaskNo(String borrowBackTaskNo);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件明细（借阅归还资管复核明细）
	 * @param origFileDetailVo
	 * @return List<OrigFileDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	List<OrigFileDetailVo> findOrigFileBorrowExamineByBorrowBackTaskNo(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件明细
	 * @param origFileDetailVo
	 * @return PageInfoExtend<OrigFileDetail>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
	PageInfoExtend<OrigFileDetailVo> findOrigFileDetailByPage(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 保存资料邮寄附件明细
	 * @param origFileDetailSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
    void saveOrigFileDetail(OrigFileDetailSaveVo origFileDetailSaveVo);


	/**
	 * @Title:
	 * @Description: 修改资料邮寄附件明细
	 * @param origFileDetailModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
	void modifyOrigFileDetail(OrigFileDetailModifyVo origFileDetailModifyVo);

	/**
	 * @Title:
	 * @Description:  通过origFileDetailId删除资料邮寄附件明细
	 * @param origFileDetailDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
	void deleteOrigFileDetail(OrigFileDetailDeleteVo origFileDetailDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过origFileDetailId集合删除资料邮寄附件明细
	 * @param origFileDetailDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
	void deleteOrigFileDetailsByOrigFileDetailIds(OrigFileDetailDeleteListVo origFileDetailDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据origFileDetailId获取资料邮寄附件明细
	 * @param origFileDetailId
	 * @return OrigFileDetail
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
	OrigFileDetail findOrigFileDetailByOrigFileDetailId(String origFileDetailId);

	/**
	 * @Title:
	 * @Description:  根据借阅归还任务号获取财务制单初始化信息
	 * @param borrowBackTaskNo
	 * @return BorrowBackTaskVo
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
	BorrowBackTaskVo getBorrowTaskMakeVoucherByBorrowBackTaskNo(String borrowBackTaskNo);

	/** 
	* @Description: 根据资料邮寄业务号,资料邮寄业务类型查询所有邮寄附件明细信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/22 15:59
	*/ 
    List<OrigFileDetail> findOrigFileDetailByExample(String bizCode,String bizCodeType);

	/**
	* @Description: 获取资料回寄一览信息
	* @param: origFileVo
	* @return:
	* @Author: lijunjun
	* @Date: 2018/5/22 15:59
	*/
	PageInfoExtend<OrigFileVo> findOrigFileBorrowBackSendByPage(OrigFileVo origFileVo);

	/**
	 * @Description: 原件借阅提交
	 * @param:
	 * @return:
	 * @Author: lijunjun
	 * @Date: 2018/5/22 15:59
	 */
	void borrowTask(OrigFileBorrowTaskVo origFileBorrowTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 原件借阅取消
	 * @param: origFileBorrowTaskVo
	 * @param: sysUser
	 * @return:
	 * @Author: lijunjun
	 * @Date: 2018/5/22 15:59
	 */
	void cancelOrigFileBorrow(OrigFileBorrowTaskVo origFileBorrowTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  获取资料邮寄附件明细(原件借阅)
	 * @param origFileDetailVo
	 * @return OrigFileBorrowPostVo
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 11:26:40
	 */
	OrigFileBorrowTaskVo findOrigFileBorrowDetails(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description:  根据borrowTaskId获取借阅任务信息
	 * @param borrowTaskNo
	 * @return BorrowTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	BorrowBackTaskVo findOrigFileBorrowTaskInfo(String borrowTaskNo, String borrowBackTaskNo);

	/**
	 * @Title:
	 * @Description:  借阅审批-通过
	 * @param borrowTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowTaskExamine(BorrowTaskVo borrowTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  借阅审批-退回
	 * @param borrowTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowTaskExamineBack(BorrowTaskVo borrowTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  回寄资管复核
	 * @param borrowBackTaskVo
	 * @param sysUser
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowBackTaskExamine(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  回寄资管复核-退回
	 * @param borrowBackTaskVo
	 * @param sysUser
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowBackTaskExamineBack(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资管复核-通过
	 * @param borrowTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowTaskReExamine(BorrowTaskVo borrowTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资管复核-退回
	 * @param borrowTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowTaskReExamineBack(BorrowTaskVo borrowTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资料邮寄
	 * @param borrowTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowTaskMail(BorrowTaskVo borrowTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  邮寄确认
	 * @param origFileBorrowTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowTaskMailConfirm(OrigFileBorrowTaskVo origFileBorrowTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  财务收款确认
	 * @param origFileBorrowFinanceVo
	 * @param sysUser
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void receiptConfirm(OrigFileBorrowFinanceVo origFileBorrowFinanceVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  财务收款确认退回
	 * @param origFileBorrowFinanceVo
	 * @param sysUser
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void receiptConfirmBack(OrigFileBorrowFinanceVo origFileBorrowFinanceVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  财务制单
	 * @param borrowBackTaskVo
	 * @param sysUser
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowMakeVoucher(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  财务制单退回
	 * @param borrowBackTaskVo
	 * @param sysUser
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowMakeVoucherBack(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  财务付款
	 * @param borrowBackTaskVo
	 * @param sysUser
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowPayment(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  财务付款退回
	 * @param borrowBackTaskVo
	 * @param sysUser
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:40
	 */
	void borrowPaymentBack(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 借阅申请归还资管确认
	 * @param borrowBackTaskVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-6 11:26:39
	 */
	void borrowBackTaskConfirm(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 借阅归还付款单打印
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public String printBorrowTask(BorrowBackTaskVo borrowBackTaskVo);
}
