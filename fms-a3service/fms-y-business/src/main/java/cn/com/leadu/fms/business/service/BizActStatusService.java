package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.BizActStatus;
import cn.com.leadu.fms.pojo.prebiz.vo.bizactstatus.BizActStatusVo;

/**
 * @author niehaibing
 * @ClassName: BizActStatusService
 * @Description: 业务状态管理业务层
 * @date 2018-03-27
 */
public interface BizActStatusService {

	/**
	 * @Title:
	 * @Description: 分页查询业务状态管理
	 * @param bizActStatusVo
	 * @return PageInfoExtend<BizActStatus>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	PageInfoExtend<BizActStatus> findBizActStatussByPage(BizActStatusVo bizActStatusVo);

	/**
	 * @Title:
	 * @Description:  根据actStsId获取业务状态管理
	 * @param actStsId
	 * @return BizActStatus
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	BizActStatus findBizActStatusByActStsId(String actStsId);

	/**
	 * @Title:
	 * @Description:  根据操作和操作前状态取得操作后状态
	 * @param actWidgetId befStatus actStsType
	 * @return String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	public String getAftStsByActIdAndBef(String actWidgetId, String actStsType);

	/**
	 * @Title:
	 * @Description:  根据操作和操作前状态取得操作后状态
	 * @param actWidgetId befStatus actStsType
	 * @return String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	public String getAftStsByActIdAndBef(String actWidgetId, String befStatus, String actStsType);
}
