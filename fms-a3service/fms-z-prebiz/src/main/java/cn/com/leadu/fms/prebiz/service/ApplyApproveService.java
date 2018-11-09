package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.vo.applyapprove.ApplyApproveVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;

/**
 * @author liujinge
 * @ClassName: ApplyApproveService
 * @Description: 区域经理审核
 * @date 2018-03-23
 */
public interface ApplyApproveService {

	/**
	 * @Title:
	 * @Description: 区域经理审批通过
	 * @param applyApproveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-3-23 18:48:00
	 */
    void approval(ApplyApproveVo applyApproveVo);
	/**
	 * @Title:
	 * @Description: 风控审批拒绝
	 * @param applyApproveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	void refuse(ApplyApproveVo applyApproveVo);

	/**
	 * @Title:
	 * @Description: 区域经理审批退回
	 * @param applyApproveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-3-23 18:48:00
	 */
	void sendBack(ApplyApproveVo applyApproveVo);

	/**
	 * @Title:
	 * @Description: 风控审批同意
	 * @param applyApproveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	void sendBackTop(ApplyApproveVo applyApproveVo);

	/**
	 * @Title:
	 * @Description: 获取审批附件
	 * @param:
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/5/7  14:40
	 */
	CommonBizFilesVo findBizFileByApplyNo(String applyNo);

}
