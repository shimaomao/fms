package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.asset.validator.equmorapply.EquMorApplyFinReceiptVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyApproveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyTaskVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingDetailVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeImportVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeService
 * @Description: 资方抵押费用业务层
 * @date 2018-05-30
 */
public interface EquMorChargeService {

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押费用
	 * @param equMorChargeVo
	 * @return PageInfoExtend<EquMorCharge>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:15
	 */
	PageInfoExtend<EquMorCharge> findEquMorChargesByPage(EquMorChargeVo equMorChargeVo);




	/**
	 * @Title:
	 * @Description:  根据equMorChargeId获取资方抵押费用
	 * @param equMorChargeId
	 * @return EquMorCharge
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:15
	 */
	EquMorCharge findEquMorChargeByEquMorChargeId(String equMorChargeId);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押费用vos
	 * @param equMorApplyVo
	 * @return PageInfoExtend<EquMorChargeVos>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:15
	 */
	PageInfoExtend<EquMorApplyVo> findEquMorChargeApplyVosByPage(EquMorApplyVo equMorApplyVo);

	/**
	 * @Title:
	 * @Description:   解析excel中的数据
	 * @param filePath
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/05 02:46:55
	 */
	List<EquMorChargeVo> parseEquMorChargeVoExcel(String filePath);

	/**
	 * @Title:
	 * @Description:   导入费用
	 * @param equMorChargeImportVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/06 03:52:43
	 */
	void equMorChargeImport(EquMorChargeImportVo equMorChargeImportVo);

	/**
	 * @Title:
	 * @Description:   导入费用退回
	 * @param equMorApplyTaskVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/09 03:28:07
	 */
	void equMorChargeImportReturn(EquMorApplyTaskVo equMorApplyTaskVo);

	/**
	 * @Title:
	 * @Description: 还原导入时做的操作
	 * @param: equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/17 0017 19:34
	 */
	void restoreEquMorChargeImportInfo(String equMorTaskNo);


	/**
	 * @Title:
	 * @Description:   抵押费用导入模板下载
	 * @param httpServletResponse
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/25 11:12:06
	 */
	void downloadEquMorChargeImportTemplate(HttpServletResponse httpServletResponse);


	/**
	 * @Title:
	 * @Description:   根据抵押任务号查询费用导入详情
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/11 04:15:25
	 */
	EquMorChargeImportVo findEquMorChargeImportVo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description:   查询制单详情
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/08 03:45:53
	 */
	EquMorChargeFinTouchingDetailVo findFinanceTouchingVo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description:   财务制单
	 * @param equMorChargeFinTouchingVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/07 02:39:02
	 */
	void financeTouching(EquMorChargeFinTouchingVo equMorChargeFinTouchingVo);

	/**
	 * @Title:
	 * @Description:   财务付款
	 * @param equMorApplyTaskVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/07 02:39:41
	 */
	void financePay(EquMorApplyTaskVo equMorApplyTaskVo);

	/**
	 * @Title:
	 * @Description:   财务收款
	 * @param equMorApplyFinReceiptVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/07 02:40:01
	 */
	void financeReceipt(EquMorApplyFinReceiptVo equMorApplyFinReceiptVo);


	/**
	 * @Title:
	 * @Description:   费用导入review
	 * @param equMorApplyApproveVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/12 10:12:45
	 */
	void equMorChargeImportReview(EquMorApplyApproveVo equMorApplyApproveVo);


}
