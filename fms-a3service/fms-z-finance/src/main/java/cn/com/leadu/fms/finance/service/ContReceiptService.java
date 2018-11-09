package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptPostVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.ContReceiptSaveVo;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.ContReceiptModifyVo;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.ContReceiptDeleteVo;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.ContReceiptDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lijunjun
 * @ClassName: ContReceiptService
 * @Description:  融资合同还款计划信息业务层
 * @date 2018-05-07
 */
public interface ContReceiptService {

	/**
	 * @Title:
	 * @Description: 分页查询 融资合同还款计划信息
	 * @param contReceiptVo
	 * @return PageInfoExtend<ContReceipt>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	PageInfoExtend<ContReceiptVo> findContReceiptsByPage(ContReceiptVo contReceiptVo);


	/**
	 * @Title:
	 * @Description: 分页查询 融资合同还款计划信息
	 * @param contReceiptVo
	 * @return PageInfoExtend<ContReceipt>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-7 18:04:31
	 */
	PageInfoExtend<ContReceiptVo> findContReceiptsImport(ContReceiptVo contReceiptVo);


	/**
	 * @Title:
	 * @Description: 保存 融资合同还款计划信息
	 * @param contReceiptSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
    void saveContReceipt(ContReceiptSaveVo contReceiptSaveVo);

	/**
	* @Description: 查找已开票信息,没有就新构建一个
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/10/12 16:35
	*/
    Invoice findInvoice(String invoiceDataType, String contNo, String detailNo);

    /**
	 * @Title:
	 * @Description: 修改 融资合同还款计划信息
	 * @param contReceiptModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	void modifyContReceipt(ContReceiptModifyVo contReceiptModifyVo);

	/**
	 * @Title:
	 * @Description:  通过contReceiptId删除 融资合同还款计划信息
	 * @param contReceiptDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	void deleteContReceipt(ContReceiptDeleteVo contReceiptDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contReceiptId集合删除 融资合同还款计划信息
	 * @param contReceiptDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	void deleteContReceiptsByContReceiptIds(ContReceiptDeleteListVo contReceiptDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据contReceiptId获取 融资合同还款计划信息
	 * @param contReceiptId
	 * @return ContReceipt
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	ContReceipt findContReceiptByContReceiptId(String contReceiptId);

	/**
	* @Description: 手动勾稽
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/8/6 21:37
	*/
	void manualReceipt(ContReceiptPostVo contReceiptPostVo);

	/**
	 * @Title:
	 * @Description:  勾稽
	 * @param contReceiptPostVo
	 * @return ContReceipt
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	void receipt(ContReceiptPostVo contReceiptPostVo);

	/**
	 * @Title:
	 * @Description:   导入收款明细
	 * @param filePath
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/05/11 11:51:40
	 */
	void importContReceipts(String filePath);

	/**
	 * @Title:
	 * @Description:   收款明细导入模板下载
	 * @param httpServletResponse
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/05/11 11:51:40
	 */
	void exportContReceiptModalExcel(HttpServletResponse httpServletResponse);

}
