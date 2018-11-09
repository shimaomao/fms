package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail.FinBackfillDetailVo;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.FinBackfillDetailSaveVo;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.FinBackfillDetailModifyVo;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.FinBackfillDetailDeleteVo;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.FinBackfillDetailDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetailService
 * @Description: 融资回填明细业务层
 * @date 2018-05-12
 */
public interface FinBackfillDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询融资回填明细
	 * @param finBackfillDetailVo
	 * @return PageInfoExtend<FinBackfillDetail>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	PageInfoExtend<FinBackfillDetail> findFinBackfillDetailsByPage(FinBackfillDetailVo finBackfillDetailVo);

	/**
	 * @Title:
	 * @Description: 保存融资回填明细
	 * @param finBackfillDetailSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
    void saveFinBackfillDetail(FinBackfillDetailSaveVo finBackfillDetailSaveVo);


	/**
	 * @Title:
	 * @Description: 修改融资回填明细
	 * @param finBackfillDetailModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	void modifyFinBackfillDetail(FinBackfillDetailModifyVo finBackfillDetailModifyVo);

	/**
	 * @Title:
	 * @Description:  通过finBackfillDetailId删除融资回填明细
	 * @param finBackfillDetailDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	void deleteFinBackfillDetail(FinBackfillDetailDeleteVo finBackfillDetailDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过finBackfillDetailId集合删除融资回填明细
	 * @param finBackfillDetailDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	void deleteFinBackfillDetailsByFinBackfillDetailIds(FinBackfillDetailDeleteListVo finBackfillDetailDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据finBackfillDetailId获取融资回填明细
	 * @param finBackfillDetailId
	 * @return FinBackfillDetail
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 13:44:42
	 */
	FinBackfillDetail findFinBackfillDetailByFinBackfillDetailId(String finBackfillDetailId);

}
