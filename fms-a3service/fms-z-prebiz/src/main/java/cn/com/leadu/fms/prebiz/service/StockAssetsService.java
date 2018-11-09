package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.StockAssets;
import cn.com.leadu.fms.pojo.prebiz.vo.stockassets.StockAssetsVo;
import cn.com.leadu.fms.prebiz.validator.stockassets.vo.StockAssetsSaveVo;
import cn.com.leadu.fms.prebiz.validator.stockassets.vo.StockAssetsModifyVo;
import cn.com.leadu.fms.prebiz.validator.stockassets.vo.StockAssetsDeleteVo;
import cn.com.leadu.fms.prebiz.validator.stockassets.vo.StockAssetsDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: StockAssetsService
 * @Description: 股份资产业务层
 * @date 2018-05-28
 */
public interface StockAssetsService {

	/**
	 * @Title:
	 * @Description: 分页查询股份资产
	 * @param stockAssetsVo
	 * @return PageInfoExtend<StockAssets>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
	PageInfoExtend<StockAssets> findStockAssetssByPage(StockAssetsVo stockAssetsVo);

	/**
	 * @Title:
	 * @Description: 保存股份资产
	 * @param stockAssetsSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
    void saveStockAssets(StockAssetsSaveVo stockAssetsSaveVo);


	/**
	 * @Title:
	 * @Description: 修改股份资产
	 * @param stockAssetsModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
	void modifyStockAssets(StockAssetsModifyVo stockAssetsModifyVo);

	/**
	 * @Title:
	 * @Description:  通过stockAssetsId删除股份资产
	 * @param stockAssetsDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
	void deleteStockAssets(StockAssetsDeleteVo stockAssetsDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过stockAssetsId集合删除股份资产
	 * @param stockAssetsDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
	void deleteStockAssetssByStockAssetsIds(StockAssetsDeleteListVo stockAssetsDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据stockAssetsId获取股份资产
	 * @param stockAssetsId
	 * @return StockAssets
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
	StockAssets findStockAssetsByStockAssetsId(String stockAssetsId);

	/**
	 * @Title:
	 * @Description: 保存股份资产
	 * @param stockAssetsList
	 * @param applyNo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
	void saveStockAssetsList(List<StockAssets> stockAssetsList, String applyNo);

	/**
	 * @Title:
	 * @Description: 根据applyNo获取股东信息
	 * @param applyNo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
    List<StockAssets> findStockAssetsListByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description: 批量更新股东信息
	 * @param applyNo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:32
	 */
	void modifyStockAssetsByApplyNo(List<StockAssets> stockAssetsList,String applyNo);

}
