package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferApproveVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoRetreatsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author wangxue
 * @ClassName: TransferInfoService
 * @Description: 过户流程业务层
 * @date 2018-08-29
 */
public interface TransferInfoService {

	/**
	 * @Title:
	 * @Description: 分页查询过户信息一览数据
	 * @param transferInfoVo
	 * @return PageInfoExtend<TransferInfo>
	 * @throws
	 * @author wangxue
	 * @date 2018-8-29 19:00:22
	 */
	PageInfoExtend<TransferInfo> findTransferInfosByPage(TransferInfoVo transferInfoVo);

	/**
	 * @Title:
	 * @Description: 根据合同编号 获取过户流程的页面显示的信息
	 * @param contNo 合同编号
	 * @return TransferInfoVo
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:00
	 */
	TransferInfoVo findTransferDetailByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 根据过户任务号 获取过户任务信息
	 * @param transferNo 过户任务号
	 * @return 返回结果
	 * @throws
	 * @author wangxue
	 * @date 2018-9-1 15:15:00
	 */
	TransferInfoVo findTransferDetailByTransferNo(String transferNo);

	/**
	 * @Title:
	 * @Description: 过户申请暂存处理
	 * @param transferInfoVo 需要保存的数据
	 * @return TransferInfoVo
	 * @throws
	 * @author wangxue
	 * @date 2018-8-31 17:15:00
	 */
	TransferInfoVo saveTransferApply(TransferInfoVo transferInfoVo);

	/**
	 * @Title:
	 * @Description: 过户申请提交处理
	 * @param transferInfoVo 需要保存的数据
	 * @throws
	 * @author wangxue
	 * @date 2018-8-31 17:15:00
	 */
	void submitTransferApply(TransferInfoVo transferInfoVo);

	/**
	 * @Title:
	 * @Description: 过户流程审批通过
	 * @param transferApproveVo 审批信息
	 * @return 返回结果
	 * @throws
	 * @author wangxue
	 * @date 2018-9-5 17:15:00
	 */
	void transferApproval(TransferApproveVo transferApproveVo);

	/**
	 * @Title:
	 * @Description: 过户流程审批退回
	 * @param transferApproveVo 审批信息
	 * @return 返回结果
	 * @throws
	 * @author wangxue
	 * @date 2018-9-5 17:15:00
	 */
	void transferSendBack(TransferApproveVo transferApproveVo);

	/**
	 * @Title:
	 * @Description: 过户费用结算暂存
	 * @param transferInfoVo 过户费用信息
	 * @return 返回结果
	 * @throws
	 * @author wangxue
	 * @date 2018-9-7 14:15:00
	 */
	TransferInfoVo saveTransferSettlement(TransferInfoVo transferInfoVo);

	/**
	 * @Title:
	 * @Description: 过户费用结算提交
	 * @param transferInfoVo 过户费用信息
	 * @return 返回结果
	 * @throws
	 * @author wangxue
	 * @date 2018-9-7 14:15:00
	 */
	void submitTransferSettlement(TransferInfoVo transferInfoVo);

	/**
	 * @Title:
	 * @Description: 过户财务确认收款
	 * @param transferApproveVo 确认收款信息
	 * @throws
	 * @author wangxue
	 * @date 2018-9-7 14:15:00
	 */
	void transferReceipt(TransferApproveVo transferApproveVo);

	/**
	 * @Title:
	 * @Description: 过户任务，打印付款单
	 * @param transferApproveVo 确认收款信息
	 * @return String
	 * @throws
	 * @author wangxue
	 * @date 2018-9-7 14:15:00
	 */
	String printPaymentForm(TransferApproveVo transferApproveVo);

	/**
	 * @Title:
	 * @Description: 根据过户任务号，获取过户任务信息.
	 * @param transferNo 过户任务号
	 * @return TransferInfo
	 * @throws
	 * @author wangxue
	 * @date 2018-9-6 19:00:22
	 */
	TransferInfo findTransferInfoByTransferNo(String transferNo);

	/**
	 * @Title:
	 * @Description: 根据合同编号，获取过户任务信息
	 * @param contNo 合同编号
	 * @return TransferInfo
	 * @throws
	 * @author wangxue
	 * @date 2018-9-7 14:15:00
	 */
	TransferInfo findTransferInfoByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 获取合同的车辆登记证状态
	 * @param contNo 合同编号
	 * @param bizCodeType 类型
	 * @return 返回结果
	 * @throws
	 * @author wangxue
	 * @date 2018-8-31 17:15:00
	 */
	String findOrigFileDetailStatusByContNo(String contNo, String bizCodeType);

	/**
	 * @Title:
	 * @Description: 确认书下载
	 * @param contNo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:35
	 */
	FileVo downLoadLetter(String contNo);

	/**
	 * @Title:
	 * @Description: 分页查询过户退保一览
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	PageInfoExtend<TransferInfoRetreatsVo> findTransferInfoRetreatsVosByPage(TransferInfoRetreatsVo transferInfoRetreatsVo);

	/**
	 * @Title:
	 * @Description: 根据合同号获取过户退保详情
	 * @param
	 * @return
	 * @throws
	 * @author fangshaofeng
	 * @date 2018-10-29 17:15:00
	 */
	TransferInfoRetreatsVo findTransferInfoRetreatsByVo(String contNo);

	/**
	 * @Title:
	 * @Description: 过户退保申请提交处理
	 * @param transferInfoRetreatsVo 需要保存的数据
	 * @return 返回结果
	 * @throws
	 * @author fangshaofeng
	 * @date 2018-10-30 10:15:00
	 */
	void submitTransferInfoRetreatsApply(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 根据退保任务号查询过户退保信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	TransferInfoRetreatsVo findTransferInfoRetreatVoByRetreatsNo(String retreatsNo);

	/**
	 * @Title:
	 * @Description: 过户退保申请资管复核审核通过
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	void approval(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 过户退保申请资管复核审核退回
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	void sendBack(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 过户退保流程财务确认收款同意
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	void Receivables(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 过户退保流程财务制单
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	void makeVoucher(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 过户退保流程财务付款
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	void payment(TransferInfoRetreatsVo transferInfoRetreatsVo,SysUser sysUser);
}
