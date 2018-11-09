package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdFinItem;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFinItemRepository
 * @Description: 产品方案融资项目Repository层
 * @date 2018-04-06
 */
public interface ProdFinItemRepository {

	/**
	 * @Title:
	 * @Description: 新增产品方案融资项目
	 * @param prodFinItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int insertData(ProdFinItem prodFinItem);

	/**
	 * @Title:
	 * @Description: 批量保存产品方案融资项目
	 * @param prodFinItems
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int insertDataList(List<ProdFinItem> prodFinItems);

	/**
	 * @Title:
	 * @Description: 修改产品方案融资项目
	 * @param prodFinItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int updateByPrimaryKeyData(ProdFinItem prodFinItem);

	/**
	 * @Title:
	 * @Description: 批量修改产品方案融资项目
	 * @param prodFinItems
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int updateByPrimaryKeyDataList(List<ProdFinItem> prodFinItems);

	/**
	 * @Title:
	 * @Description: 动态修改产品方案融资项目
	 * @param prodFinItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int updateByPrimaryKeySelectiveData(ProdFinItem prodFinItem);

	/**
	 * @Title:
	 * @Description: 批量动态修改产品方案融资项目
	 * @param prodFinItems
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int updateByPrimaryKeySelectiveDataList(List<ProdFinItem> prodFinItems);

	/**
	 * @Title:
	 * @Description: 根据条件修改产品方案融资项目
	 * @param prodFinItem
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int updateByExampleData(ProdFinItem prodFinItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改产品方案融资项目
	 * @param prodFinItem
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int updateByExampleSelectiveData(ProdFinItem prodFinItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据prodFinItemId删除产品方案融资项目
	 * @param prodFinItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int deleteData(ProdFinItem prodFinItem);

	/**
	 * @Title:
	 * @Description: 根据prodFinItemId集合批量删除产品方案融资项目
	 * @param prodFinItemIds
	 * @param prodFinItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int deleteDataList(List prodFinItemIds, ProdFinItem prodFinItem);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除产品方案融资项目
	 * @param example
	 * @param prodFinItem
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	int deleteExampleData(Example example, ProdFinItem prodFinItem);

	/**
	 * @Title:
	 * @Description: 查询全部产品方案融资项目
	 * @return List<ProdFinItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	List<ProdFinItem> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个产品方案融资项目
	 * @param example
	 * @return ProdFinItem
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	ProdFinItem selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询产品方案融资项目
	 * @param example
	 * @return List<ProdFinItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	List<ProdFinItem> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过prodFinItemId查询产品方案融资项目
	 * @param prodFinItemId
	 * @return ProdFinItem
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	ProdFinItem selectByPrimaryKey(Object prodFinItemId);

	/**
	 * @Title:
	 * @Description: 分页查询产品方案融资项目
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ProdFinItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	PageInfoExtend<ProdFinItem> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询产品方案融资项目vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ProdFinItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	PageInfoExtend<ProdFinItem> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
