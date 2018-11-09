package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVisit;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvisit.ApplyVisitVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author liujinge
 * @ClassName: ApplyVisitService
 * @Description: 贷前家访业务层
 * @date 2018-06-04
 */
public interface ApplyVisitService {

	/**
	 * @Title:
	 * @Description: 分页查询贷前家访
	 * @param applyVisitVo
	 * @return PageInfoExtend<ApplyVisit>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	PageInfoExtend<ApplyVisit> findApplyVisitsByPage(ApplyVisitVo applyVisitVo);


	/**
	 * @Title:
	 * @Description:  根据applyVisitId获取贷前家访
	 * @param applyVisitId
	 * @return ApplyVisit
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:00:52
	 */
	ApplyVisit findApplyVisitByApplyVisitId(String applyVisitId);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取贷前家访
	 * @param applyNo
	 * @return ApplyVisit
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-4 15:00:52
	 */
	ApplyVisitVo findApplyVisitByApplyNo(String applyNo);

}
