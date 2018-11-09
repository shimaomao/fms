package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CrmStockAssets;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmStockAssetsRepository
 * @Description: crm股东信息Repository层
 * @date 2018-08-27
 */
public interface CrmStockAssetsRepository {

	/**
	 * @Title:
	 * @Description: 新增crm股东信息
	 * @param crmStockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int insertData(CrmStockAssets crmStockAssets);

	/**
	 * @Title:
	 * @Description: 批量保存crm股东信息
	 * @param crmStockAssetss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int insertDataList(List<CrmStockAssets> crmStockAssetss);

	/**
	 * @Title:
	 * @Description: 修改crm股东信息
	 * @param crmStockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByPrimaryKeyData(CrmStockAssets crmStockAssets);

	/**
	 * @Title:
	 * @Description: 批量修改crm股东信息
	 * @param crmStockAssetss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByPrimaryKeyDataList(List<CrmStockAssets> crmStockAssetss);

	/**
	 * @Title:
	 * @Description: 动态修改crm股东信息
	 * @param crmStockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByPrimaryKeySelectiveData(CrmStockAssets crmStockAssets);

	/**
	 * @Title:
	 * @Description: 批量动态修改crm股东信息
	 * @param crmStockAssetss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByPrimaryKeySelectiveDataList(List<CrmStockAssets> crmStockAssetss);

	/**
	 * @Title:
	 * @Description: 根据条件修改crm股东信息
	 * @param crmStockAssets
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByExampleData(CrmStockAssets crmStockAssets, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改crm股东信息
	 * @param crmStockAssets
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByExampleSelectiveData(CrmStockAssets crmStockAssets, Example example);

	/**
	 * @Title:
	 * @Description: 根据stockAssetsId删除crm股东信息
	 * @param crmStockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int deleteData(CrmStockAssets crmStockAssets);

	/**
	 * @Title:
	 * @Description: 根据stockAssetsId集合批量删除crm股东信息
	 * @param stockAssetsIds
	 * @param crmStockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int deleteDataList(List stockAssetsIds, CrmStockAssets crmStockAssets);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除crm股东信息
	 * @param example
	 * @param crmStockAssets
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int deleteExampleData(Example example, CrmStockAssets crmStockAssets);

	/**
	 * @Title:
	 * @Description: 根據id集合物理刪除數據
	 * @param ids
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int deletePhysicsEntityList(List ids);

	/**
	 * @Title:
	 * @Description: 查询全部crm股东信息
	 * @return List<CrmStockAssets>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	List<CrmStockAssets> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个crm股东信息
	 * @param example
	 * @return CrmStockAssets
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	CrmStockAssets selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询crm股东信息
	 * @param example
	 * @return List<CrmStockAssets>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	List<CrmStockAssets> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过stockAssetsId查询crm股东信息
	 * @param stockAssetsId
	 * @return CrmStockAssets
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	CrmStockAssets selectByPrimaryKey(Object stockAssetsId);

	/**
	 * @Title:
	 * @Description: 分页查询crm股东信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CrmStockAssets>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	PageInfoExtend<CrmStockAssets> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询crm股东信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改crm股东信息
	 * @param crmStockAssets,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByPrimaryKeyData(CrmStockAssets crmStockAssets, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改crm股东信息,并进行排他
	 * @param crmStockAssetss
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByPrimaryKeyDataList(List<CrmStockAssets> crmStockAssetss, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改crm股东信息,并进行排他
	 * @param crmStockAssets
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(CrmStockAssets crmStockAssets, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改crm股东信息,并进行排他
	 * @param crmStockAssetss
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByPrimaryKeySelectiveDataList(List<CrmStockAssets> crmStockAssetss, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改crm股东信息,并进行排他
	 * @param crmStockAssets
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByExampleData(CrmStockAssets crmStockAssets, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改crm股东信息,并进行排他
	 * @param crmStockAssets
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-27 16:51:23
	 */
	int updateByExampleSelectiveData(CrmStockAssets crmStockAssets, Example example, boolean exclusive);

}
