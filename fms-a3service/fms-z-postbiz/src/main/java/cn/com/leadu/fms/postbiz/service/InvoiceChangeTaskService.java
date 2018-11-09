package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.HistoryChangeVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskService
 * @Description: 开票变更任务业务层
 * @date 2018-08-29
 */
public interface InvoiceChangeTaskService {

	/**
	 * @Title:
	 * @Description: 分页查询开票变更任务
	 * @param invoiceChangeVo
	 * @return PageInfoExtend<InvoiceChangeVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	PageInfoExtend<InvoiceChangeVo> findCompanyInvoiceListByPage(InvoiceChangeVo invoiceChangeVo);

	/**
	 * @Title:
	 * @Description: 分页查询开票变更任务
	 * @param invoiceChangeVo
	 * @return PageInfoExtend<InvoiceChangeVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:36:36
	 */
	PageInfoExtend<InvoiceChangeVo> findInvoiceChangeVosByPage(InvoiceChangeVo invoiceChangeVo);

	/**
	 * @Title:
	 * @Description: 分页查询制定社会统一信用号的开票变更历史任务
	 * @param vo 参数
	 * @return PageInfoExtend<HistoryChangeVo>
	 * @throws
	 * @author huzongcheng
	 */
	PageInfoExtend<HistoryChangeVo> findInvoiceChangeHistory(HistoryChangeVo vo);

}
