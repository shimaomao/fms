package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.StockAssets;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: StockAssetsRepository
 * @Description: 股份资产Repository层
 * @date 2018-05-28
 */
public interface StockAssetsRepository {

	/**
	 * @Title:
	 * @Description: 新增股份资产
	 * @param stockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int insertData(StockAssets stockAssets);

	/**
	 * @Title:
	 * @Description: 批量保存股份资产
	 * @param stockAssetss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int insertDataList(List<StockAssets> stockAssetss);

	/**
	 * @Title:
	 * @Description: 修改股份资产
	 * @param stockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int updateByPrimaryKeyData(StockAssets stockAssets);

	/**
	 * @Title:
	 * @Description: 批量修改股份资产
	 * @param stockAssetss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int updateByPrimaryKeyDataList(List<StockAssets> stockAssetss);

	/**
	 * @Title:
	 * @Description: 动态修改股份资产
	 * @param stockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int updateByPrimaryKeySelectiveData(StockAssets stockAssets);

	/**
	 * @Title:
	 * @Description: 批量动态修改股份资产
	 * @param stockAssetss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int updateByPrimaryKeySelectiveDataList(List<StockAssets> stockAssetss);

	/**
	 * @Title:
	 * @Description: 根据条件修改股份资产
	 * @param stockAssets
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int updateByExampleData(StockAssets stockAssets, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改股份资产
	 * @param stockAssets
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int updateByExampleSelectiveData(StockAssets stockAssets, Example example);

	/**
	 * @Title:
	 * @Description: 根据stockAssetsId删除股份资产
	 * @param stockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int deleteData(StockAssets stockAssets);

	/**
	 * @Title:
	 * @Description: 根据stockAssetsId集合批量删除股份资产
	 * @param stockAssetsIds
	 * @param stockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int deleteDataList(List stockAssetsIds, StockAssets stockAssets);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除股份资产
	 * @param example
	 * @param stockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	int deleteExampleData(Example example, StockAssets stockAssets);

	/**
	 * @Title:
	 * @Description: 查询全部股份资产
	 * @return List<StockAssets>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	List<StockAssets> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个股份资产
	 * @param example
	 * @return StockAssets
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	StockAssets selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询股份资产
	 * @param example
	 * @return List<StockAssets>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	List<StockAssets> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过stockAssetsId查询股份资产
	 * @param stockAssetsId
	 * @return StockAssets
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	StockAssets selectByPrimaryKey(Object stockAssetsId);

	/**
	 * @Title:
	 * @Description: 分页查询股份资产
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<StockAssets>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	PageInfoExtend<StockAssets> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询股份资产vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-28 20:57:31
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
