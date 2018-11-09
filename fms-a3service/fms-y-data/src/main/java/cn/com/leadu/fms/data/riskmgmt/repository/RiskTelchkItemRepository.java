package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchkItem;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkItemRepository
 * @Description: 风控电核项目表Repository层
 * @date 2018-06-04
 */
public interface RiskTelchkItemRepository {

	/**
	 * @Title:
	 * @Description: 新增风控电核项目表
	 * @param riskTelchkItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int insertData(RiskTelchkItem riskTelchkItem);

	/**
	 * @Title:
	 * @Description: 批量保存风控电核项目表
	 * @param riskTelchkItems
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int insertDataList(List<RiskTelchkItem> riskTelchkItems);

	/**
	 * @Title:
	 * @Description: 修改风控电核项目表
	 * @param riskTelchkItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByPrimaryKeyData(RiskTelchkItem riskTelchkItem);

	/**
	 * @Title:
	 * @Description: 批量修改风控电核项目表
	 * @param riskTelchkItems
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByPrimaryKeyDataList(List<RiskTelchkItem> riskTelchkItems);

	/**
	 * @Title:
	 * @Description: 动态修改风控电核项目表
	 * @param riskTelchkItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByPrimaryKeySelectiveData(RiskTelchkItem riskTelchkItem);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控电核项目表
	 * @param riskTelchkItems
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskTelchkItem> riskTelchkItems);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控电核项目表
	 * @param riskTelchkItem
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByExampleData(RiskTelchkItem riskTelchkItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控电核项目表
	 * @param riskTelchkItem
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByExampleSelectiveData(RiskTelchkItem riskTelchkItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据telchkItemId删除风控电核项目表
	 * @param riskTelchkItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int deleteData(RiskTelchkItem riskTelchkItem);

	/**
	 * @Title:
	 * @Description: 根据telchkItemId集合批量删除风控电核项目表
	 * @param telchkItemIds
	 * @param riskTelchkItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int deleteDataList(List telchkItemIds,RiskTelchkItem riskTelchkItem);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除风控电核项目表
	 * @param example
	 * @param riskTelchkItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int deleteExampleData(Example example,RiskTelchkItem riskTelchkItem);

	/**
	 * @Title:
	 * @Description: 查询全部风控电核项目表
	 * @return List<RiskTelchkItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	List<RiskTelchkItem> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个风控电核项目表
	 * @param example
	 * @return RiskTelchkItem
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	RiskTelchkItem selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询风控电核项目表
	 * @param example
	 * @return List<RiskTelchkItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	List<RiskTelchkItem> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过telchkItemId查询风控电核项目表
	 * @param telchkItemId
	 * @return RiskTelchkItem
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	RiskTelchkItem selectByPrimaryKey(Object telchkItemId);

	/**
	 * @Title:
	 * @Description: 分页查询风控电核项目表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RiskTelchkItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	PageInfoExtend<RiskTelchkItem> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询风控电核项目表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改风控电核项目表
	 * @param riskTelchkItem,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByPrimaryKeyData(RiskTelchkItem riskTelchkItem,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改风控电核项目表,并进行排他
	 * @param riskTelchkItems
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByPrimaryKeyDataList(List<RiskTelchkItem> riskTelchkItems,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改风控电核项目表,并进行排他
	 * @param riskTelchkItem
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(RiskTelchkItem riskTelchkItem,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控电核项目表,并进行排他
	 * @param riskTelchkItems
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskTelchkItem> riskTelchkItems,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控电核项目表,并进行排他
	 * @param riskTelchkItem
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByExampleData(RiskTelchkItem riskTelchkItem, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控电核项目表,并进行排他
	 * @param riskTelchkItem
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:07
	 */
	int updateByExampleSelectiveData(RiskTelchkItem riskTelchkItem, Example example,boolean exclusive);

}
