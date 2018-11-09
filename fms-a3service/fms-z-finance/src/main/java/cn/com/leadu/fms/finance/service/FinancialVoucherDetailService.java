package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdetail.FinancialVoucherDetailVo;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.FinancialVoucherDetailSaveVo;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.FinancialVoucherDetailModifyVo;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.FinancialVoucherDetailDeleteVo;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.FinancialVoucherDetailDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailService
 * @Description: 凭证类型明细管理业务层
 * @date 2018-06-20
 */
public interface FinancialVoucherDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询凭证类型明细管理
	 * @param financialVoucherDetailVo
	 * @return PageInfoExtend<FinancialVoucherDetail>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	PageInfoExtend<FinancialVoucherDetailVo> findFinancialVoucherDetailsByPage(FinancialVoucherDetailVo financialVoucherDetailVo);

	/**
	 * @Title:
	 * @Description: 保存凭证类型明细管理
	 * @param financialVoucherDetailSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
    void saveFinancialVoucherDetail(FinancialVoucherDetailSaveVo financialVoucherDetailSaveVo);


	/**
	 * @Title:
	 * @Description: 修改凭证类型明细管理
	 * @param financialVoucherDetailModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	void modifyFinancialVoucherDetail(FinancialVoucherDetailModifyVo financialVoucherDetailModifyVo);

	/**
	 * @Title:
	 * @Description:  通过voucherDetailId删除凭证类型明细管理
	 * @param financialVoucherDetailDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	void deleteFinancialVoucherDetail(FinancialVoucherDetailDeleteVo financialVoucherDetailDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过voucherDetailId集合删除凭证类型明细管理
	 * @param financialVoucherDetailDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	void deleteFinancialVoucherDetailsByVoucherDetailIds(FinancialVoucherDetailDeleteListVo financialVoucherDetailDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据voucherDetailId获取凭证类型明细管理
	 * @param voucherDetailId
	 * @return FinancialVoucherDetail
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	FinancialVoucherDetailVo findFinancialVoucherDetailByVoucherDetailId(String voucherDetailId);

	/**
	 * @Title:
	 * @Description:   根据凭证类型取得凭证类型明细列表
	 * @param voucherType
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/21 06:03:15
	 */
	List<FinancialVoucherDetail> findFinancialVoucherDetailsByVoucherType(String voucherType);

}
