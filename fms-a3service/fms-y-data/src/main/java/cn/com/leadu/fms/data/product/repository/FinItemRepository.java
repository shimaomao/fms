package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.pojo.product.entity.FinItem;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: FinItemRepository
 * @Description: 融资项目管理Repository层
 * @date 2018-03-19
 */
public interface FinItemRepository {

	/**
	 * @Title:
	 * @Description: 新增融资项目管理
	 * @param finItem
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int insertData(FinItem finItem);

	/**
	 * @Title:
	 * @Description: 批量保存融资项目管理
	 * @param finItems
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int insertDataList(List<FinItem> finItems);

	/**
	 * @Title:
	 * @Description: 修改融资项目管理
	 * @param finItem
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int updateByPrimaryKeyData(FinItem finItem);

	/**
	 * @Title:
	 * @Description: 批量修改融资项目管理
	 * @param finItems
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int updateByPrimaryKeyDataList(List<FinItem> finItems);

	/**
	 * @Title:
	 * @Description: 动态修改融资项目管理
	 * @param finItem
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int updateByPrimaryKeySelectiveData(FinItem finItem);

	/**
	 * @Title:
	 * @Description: 批量动态修改融资项目管理
	 * @param finItems
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinItem> finItems);

	/**
	 * @Title:
	 * @Description: 根据条件修改融资项目管理
	 * @param finItem
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int updateByExampleData(FinItem finItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改融资项目管理
	 * @param finItem
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int updateByExampleSelectiveData(FinItem finItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据finItemId删除融资项目管理
	 * @param finItem
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int deleteData(FinItem finItem);

	/**
	 * @Title:
	 * @Description: 根据finItemId集合批量删除融资项目管理
	 * @param finItemIds
	 * @param finItem
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	int deleteDataList(List finItemIds, FinItem finItem);

	/**
	 * @Title:
	 * @Description: 查询全部融资项目管理
	 * @return List<FinItem>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	List<FinItem> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个融资项目管理
	 * @param example
	 * @return FinItem
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	FinItem selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询融资项目管理
	 * @param example
	 * @return List<FinItem>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	List<FinItem> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过finItemId查询融资项目管理
	 * @param finItemId
	 * @return FinItem
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	FinItem selectByPrimaryKey(Object finItemId);

	/**
	 * @Title:
	 * @Description: 分页查询融资项目管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinItem>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	PageInfoExtend<FinItem> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资项目管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<FinItem>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	PageInfoExtend<FinItem> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据产品方案代码，获取产品方案的融资项目
	 * @param product 产品方案代码
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 22:06:58
	 */
	List<FinItemVo> selectFinItemVoListByProduct(String product);

}
