package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.GoldenTaxInvoiceSendVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: InvoiceRepository
 * @Description: 开票信息Repository层
 */
public interface InvoiceRepository {

	/**
	 * @Title:
	 * @Description: 新增开票信息
	 * @param invoice
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int insertData(Invoice invoice);

	/**
	 * @Title:
	 * @Description: 批量保存开票信息
	 * @param invoices
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int insertDataList(List<Invoice> invoices);

	/**
	 * @Title:
	 * @Description: 修改开票信息
	 * @param invoice
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByPrimaryKeyData(Invoice invoice);

	/**
	 * @Title:
	 * @Description: 批量修改开票信息
	 * @param invoices
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByPrimaryKeyDataList(List<Invoice> invoices);

	/**
	 * @Title:
	 * @Description: 动态修改开票信息
	 * @param invoice
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByPrimaryKeySelectiveData(Invoice invoice);

	/**
	 * @Title:
	 * @Description: 批量动态修改开票信息
	 * @param invoices
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByPrimaryKeySelectiveDataList(List<Invoice> invoices);

	/**
	 * @Title:
	 * @Description: 根据条件修改开票信息
	 * @param invoice
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByExampleData(Invoice invoice, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改开票信息
	 * @param invoice
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByExampleSelectiveData(Invoice invoice, Example example);

	/**
	 * @Title:
	 * @Description: 根据invoiceId删除开票信息
	 * @param invoice
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int deleteData(Invoice invoice);

	/**
	 * @Title:
	 * @Description: 根据invoiceId集合批量删除开票信息
	 * @param invoiceIds
	 * @param invoice
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int deleteDataList(List invoiceIds,Invoice invoice);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除开票信息
	 * @param example
	 * @param invoice
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int deleteExampleData(Example example,Invoice invoice);

	/**
	 * @Title:
	 * @Description: 查询全部开票信息
	 * @return List<Invoice>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	List<Invoice> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个开票信息
	 * @param example
	 * @return Invoice
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	Invoice selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询开票信息
	 * @param example
	 * @return List<Invoice>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	List<Invoice> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过invoiceId查询开票信息
	 * @param invoiceId
	 * @return Invoice
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	Invoice selectByPrimaryKey(Object invoiceId);

	/**
	 * @Title:
	 * @Description: 分页查询开票信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<Invoice>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	PageInfoExtend<Invoice> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询开票信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改开票信息
	 * @param invoice,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByPrimaryKeyData(Invoice invoice,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改开票信息,并进行排他
	 * @param invoices
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByPrimaryKeyDataList(List<Invoice> invoices,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改开票信息,并进行排他
	 * @param invoice
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(Invoice invoice,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改开票信息,并进行排他
	 * @param invoices
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByPrimaryKeySelectiveDataList(List<Invoice> invoices,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改开票信息,并进行排他
	 * @param invoice
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByExampleData(Invoice invoice, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改开票信息,并进行排他
	 * @param invoice
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:01:34
	 */
	int updateByExampleSelectiveData(Invoice invoice, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description:   查询开票信息vo列表
	 * @param invoiceVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/12 09:57:48
	 */
	List<InvoiceVo> selectInvoiceVos(InvoiceVo invoiceVo);

	/**
	 * @Title:
	 * @Description:   发票打印成功，带有该发票号码的开票信息更新状态为开票成功
	 * @param invoiceAutos
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/14 09:47:54
	 */
	void savePrintinvResults(List<InvoiceAuto> invoiceAutos,String user);

	/**
	 * @Title:
	 * @Description:   保存超过最大设定额度的自动开票信息
	 * @param maxInvoiceVoMaps
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/13 08:54:37
	 */
	List<InvoiceAuto> saveMaxAutoManual(Map<InvoiceVo,List<GoldenTaxInvoiceSendVo>> maxInvoiceVoMaps,String user);

	/**
	 * @Title:
	 * @Description:   保存发送成功的信息
	 * @param successSendVos
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/13 05:23:07
	 */
	List<InvoiceAuto> saveSendAutoManual(List<GoldenTaxInvoiceSendVo> successSendVos,String user);

}
