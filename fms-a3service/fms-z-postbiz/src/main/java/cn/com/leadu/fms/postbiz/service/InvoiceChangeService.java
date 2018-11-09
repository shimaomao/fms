package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangePostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeService
 * @Description: 开票信息变更业务层
 * @date 2018-08-29
 */
public interface InvoiceChangeService {

	/**
	 * @Title:
	 * @Description: 保存开票信息变更
	 * @param invoiceChangePostVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:21
	 */
    void saveInvoiceChange(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 根据applyNo查询开票基本信息
	 * @param invoiceChangeVo
	 * @return InvoiceChangeVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	InvoiceChangePostVo findApplyInvoiceVosBySocialCertifNo(InvoiceChangeVo invoiceChangeVo);

	/**
	 * @Title:
	 * @Description: 根据applyNo查询开票变更前后信息
	 * @param invoiceTaskNo
	 * @return InvoiceChangeVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	InvoiceChangePostVo findInvoiceChangeVosByInvoiceTaskNo(String invoiceTaskNo);

	/**
	 * @Title:
	 * @Description: 开票信息变更审核通过
	 * @param invoiceChangePostVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:21
	 */
	void invoiceChangeApproval(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 开票信息变更审核退回
	 * @param invoiceChangePostVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:21
	 */
	void invoiceChangeBackApply(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 开票信息变更审核拒绝
	 * @param invoiceChangePostVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:21
	 */
	void invoiceChangeRefuse(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 验证当前企业是否存在变更任务
	 * @param invoiceChangeVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:21
	 */
	void checkInvoiceChange(InvoiceChangeVo invoiceChangeVo);

}
