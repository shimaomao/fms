package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoiceauto.InvoiceAutoVo;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.InvoiceAutoSaveVo;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.InvoiceAutoModifyVo;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.InvoiceAutoDeleteVo;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.InvoiceAutoDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoService
 * @Description: 自动开票信息业务层
 */
public interface InvoiceAutoService {

	/**
	 * @Title:
	 * @Description: 分页查询自动开票信息
	 * @param invoiceAutoVo
	 * @return PageInfoExtend<InvoiceAuto>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:20
	 */
	PageInfoExtend<InvoiceAuto> findInvoiceAutosByPage(InvoiceAutoVo invoiceAutoVo);

	/**
	 * @Title:
	 * @Description: 保存自动开票信息
	 * @param invoiceAutoSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:20
	 */
    void saveInvoiceAuto(InvoiceAutoSaveVo invoiceAutoSaveVo);


	/**
	 * @Title:
	 * @Description: 修改自动开票信息
	 * @param invoiceAutoModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:20
	 */
	void modifyInvoiceAuto(InvoiceAutoModifyVo invoiceAutoModifyVo);

	/**
	 * @Title:
	 * @Description:  通过invoiceAutoId删除自动开票信息
	 * @param invoiceAutoDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:20
	 */
	void deleteInvoiceAuto(InvoiceAutoDeleteVo invoiceAutoDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过invoiceAutoId集合删除自动开票信息
	 * @param invoiceAutoDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:20
	 */
	void deleteInvoiceAutosByInvoiceAutoIds(InvoiceAutoDeleteListVo invoiceAutoDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据invoiceAutoId获取自动开票信息
	 * @param invoiceAutoId
	 * @return InvoiceAuto
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:20
	 */
	InvoiceAuto findInvoiceAutoByInvoiceAutoId(String invoiceAutoId);

	/**
	 * @Title:
	 * @Description:   保存自动开票集合
	 * @param invoiceAutos
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/13 08:42:08
	 */
	 void saveInvoiceAutos(List<InvoiceAuto> invoiceAutos);

	/**
	 * @Title:
	 * @Description:   根据发票号码查询自动开票信息
	 * @param infoNumbers
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/15 05:08:46
	 */
	List<InvoiceAuto> findInvoiceAutosByInfoNumbers(List<String> infoNumbers);

}
