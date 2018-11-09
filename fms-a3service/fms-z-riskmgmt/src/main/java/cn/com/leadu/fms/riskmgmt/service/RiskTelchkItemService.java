package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchkItem;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchkitem.RiskTelchkItemVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo.RiskTelchkItemSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo.RiskTelchkItemModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo.RiskTelchkItemDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo.RiskTelchkItemDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author liujinge
 * @ClassName: RiskTelchkItemService
 * @Description: 风控电核项目表业务层
 * @date 2018-06-04
 */
public interface RiskTelchkItemService {

	/**
	 * @Title:
	 * @Description: 分页查询风控电核项目表
	 * @param riskTelchkItemVo
	 * @return PageInfoExtend<RiskTelchkItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:08
	 */
	PageInfoExtend<RiskTelchkItem> findRiskTelchkItemsByPage(RiskTelchkItemVo riskTelchkItemVo);

	/**
	 * @Title:
	 * @Description: 保存风控电核项目表
	 * @param riskTelchkItemSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:08
	 */
    void saveRiskTelchkItem(RiskTelchkItemSaveVo riskTelchkItemSaveVo);


	/**
	 * @Title:
	 * @Description: 修改风控电核项目表
	 * @param riskTelchkItemModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:08
	 */
	void modifyRiskTelchkItem(RiskTelchkItemModifyVo riskTelchkItemModifyVo);

	/**
	 * @Title:
	 * @Description:  通过telchkItemId删除风控电核项目表
	 * @param riskTelchkItemDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:08
	 */
	void deleteRiskTelchkItem(RiskTelchkItemDeleteVo riskTelchkItemDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过telchkItemId集合删除风控电核项目表
	 * @param riskTelchkItemDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:08
	 */
	void deleteRiskTelchkItemsByTelchkItemIds(RiskTelchkItemDeleteListVo riskTelchkItemDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据telchkItemId获取风控电核项目表
	 * @param telchkItemId
	 * @return RiskTelchkItem
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:08
	 */
	RiskTelchkItem findRiskTelchkItemByTelchkItemId(String telchkItemId);

}
