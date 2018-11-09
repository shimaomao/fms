package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoicePrintinvResultVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceResultVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceDeleteListVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceDeleteVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceModifyVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceSaveVo;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: InvoiceService
 * @Description: 开票信息业务层
 */
public interface InvoiceService {

	/**
	 * @Title:
	 * @Description: 分页查询开票信息
	 * @param invoiceVo
	 * @return PageInfoExtend<Invoice>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	PageInfoExtend<InvoiceVo> findInvoiceVosByPage(InvoiceVo invoiceVo);

	/**
	 * @Title:
	 * @Description:   手动开票
	 * @param invoiceVos
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/12 12:41:48
	 */
	void invoiceManual(List<InvoiceVo> invoiceVos);


	/**
	 * @Title:
	 * @Description:   发票作废
	 * @param invoiceIds
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/12 01:38:20
	 */
	void cancelInvoice(List<String> invoiceIds);

	/**
	 * @Title:
	 * @Description:   自动开票
	 * @param invoiceIds
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/12 02:42:21
	 */
	InvoiceResultVo autoManual(List<String> invoiceIds,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 开票完成后的打印
	 * @param invoiceAutos
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/13 09:39:40
	 */
	InvoicePrintinvResultVo printinv(List<InvoiceAuto> invoiceAutos, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 保存开票信息
	 * @param invoiceSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
    void saveInvoice(InvoiceSaveVo invoiceSaveVo);


	/**
	 * @Title:
	 * @Description: 修改开票信息
	 * @param invoiceModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	void modifyInvoice(InvoiceModifyVo invoiceModifyVo);

	/**
	 * @Title:
	 * @Description:  通过invoiceId删除开票信息
	 * @param invoiceDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	void deleteInvoice(InvoiceDeleteVo invoiceDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过invoiceId集合删除开票信息
	 * @param invoiceDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	void deleteInvoicesByInvoiceIds(InvoiceDeleteListVo invoiceDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据invoiceId获取开票信息
	 * @param invoiceId
	 * @return Invoice
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	Invoice findInvoiceByInvoiceId(String invoiceId);

	/**
	 * @Title:
	 * @Description:   手动打印
	 * @param invoiceIds
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/15 04:51:32
	 */
	InvoicePrintinvResultVo manualPrintinv(List<String> invoiceIds,SysUser sysUser);

	/**
	* @Description: 生成凭证
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/10/13 18:05
	*/
    void makeVoucher(List<String> invoiceIds, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 根据发票号查找要打印的信息
	 * @param invoiceNoList
	 * @return
	 * @throws
	 * @author nignyangyang
	 * @date 2018-10-24 16:01:33
	 */
	List<InvoiceAuto> findInvoiceAutos(List<String> invoiceNoList);
}
