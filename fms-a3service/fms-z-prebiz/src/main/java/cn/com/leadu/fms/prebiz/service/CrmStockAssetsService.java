package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CrmStockAssets;
import cn.com.leadu.fms.pojo.prebiz.vo.crmstockassets.CrmStockAssetsVo;
import cn.com.leadu.fms.prebiz.validator.crmstockassets.vo.CrmStockAssetsSaveVo;
import cn.com.leadu.fms.prebiz.validator.crmstockassets.vo.CrmStockAssetsModifyVo;
import cn.com.leadu.fms.prebiz.validator.crmstockassets.vo.CrmStockAssetsDeleteVo;
import cn.com.leadu.fms.prebiz.validator.crmstockassets.vo.CrmStockAssetsDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CrmStockAssetsService
 * @Description: crm股东信息业务层
 * @date 2018-08-27
 */
public interface CrmStockAssetsService {

	/**
	 * @Title:
	 * @Description: 分页查询crm股东信息
	 * @param crmStockAssetsVo
	 * @return PageInfoExtend<CrmStockAssets>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	PageInfoExtend<CrmStockAssets> findCrmStockAssetssByPage(CrmStockAssetsVo crmStockAssetsVo);

	/**
	 * @Title:
	 * @Description: 保存crm股东信息
	 * @param crmStockAssetsSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
    void saveCrmStockAssets(CrmStockAssetsSaveVo crmStockAssetsSaveVo);


	/**
	 * @Title:
	 * @Description: 修改crm股东信息
	 * @param crmStockAssetsModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	void modifyCrmStockAssets(CrmStockAssetsModifyVo crmStockAssetsModifyVo);

	/**
	 * @Title:
	 * @Description:  通过stockAssetsId删除crm股东信息
	 * @param crmStockAssetsDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	void deleteCrmStockAssets(CrmStockAssetsDeleteVo crmStockAssetsDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过stockAssetsId集合删除crm股东信息
	 * @param crmStockAssetsDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	void deleteCrmStockAssetssByStockAssetsIds(CrmStockAssetsDeleteListVo crmStockAssetsDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据stockAssetsId获取crm股东信息
	 * @param stockAssetsId
	 * @return CrmStockAssets
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	CrmStockAssets findCrmStockAssetsByStockAssetsId(String stockAssetsId);

}
