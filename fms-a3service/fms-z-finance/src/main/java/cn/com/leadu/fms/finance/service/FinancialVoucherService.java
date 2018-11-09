package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucher;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucher.FinancialVoucherVo;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.FinancialVoucherSaveVo;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.FinancialVoucherModifyVo;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.FinancialVoucherDeleteVo;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.FinancialVoucherDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherService
 * @Description: 凭证类型管理业务层
 * @date 2018-06-20
 */
public interface FinancialVoucherService {

	/**
	 * @Title:
	 * @Description: 分页查询凭证类型管理
	 * @param financialVoucherVo
	 * @return PageInfoExtend<FinancialVoucher>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	PageInfoExtend<FinancialVoucher> findFinancialVouchersByPage(FinancialVoucherVo financialVoucherVo);

	/**
	 * @Title:
	 * @Description: 保存凭证类型管理
	 * @param financialVoucherSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
    void saveFinancialVoucher(FinancialVoucherSaveVo financialVoucherSaveVo);


	/**
	 * @Title:
	 * @Description: 修改凭证类型管理
	 * @param financialVoucherModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	void modifyFinancialVoucher(FinancialVoucherModifyVo financialVoucherModifyVo);

	/**
	 * @Title:
	 * @Description:  通过voucherId删除凭证类型管理
	 * @param financialVoucherDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	void deleteFinancialVoucher(FinancialVoucherDeleteVo financialVoucherDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过voucherId集合删除凭证类型管理
	 * @param financialVoucherVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	void deleteFinancialVouchersByVoucherIds(FinancialVoucherVo financialVoucherVo);



	/**
	 * @Title:
	 * @Description:  根据voucherId获取凭证类型管理
	 * @param voucherId
	 * @return FinancialVoucher
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	FinancialVoucher findFinancialVoucherByVoucherId(String voucherId);

	/**
	 * @Title:
	 * @Description: 查询凭证信息树形结构
	 * @param
	 * @return PageInfoExtend<FinancialVoucher>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	List<BootstrapTreeViewNodeVo> findFinancialVouchersByTree();

}
