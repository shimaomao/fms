package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdGroup;
import cn.com.leadu.fms.pojo.product.vo.prodgroup.ProdGroupVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdGroupRepository
 * @Description: 产品方案机构权限Repository层
 * @date 2018-04-05
 */
public interface ProdGroupRepository {

	/**
	 * @Title:
	 * @Description: 新增产品方案机构权限
	 * @param prodGroup
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int insertData(ProdGroup prodGroup);

	/**
	 * @Title:
	 * @Description: 批量保存产品方案机构权限
	 * @param prodGroups
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int insertDataList(List<ProdGroup> prodGroups);

	/**
	 * @Title:
	 * @Description: 修改产品方案机构权限
	 * @param prodGroup
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int updateByPrimaryKeyData(ProdGroup prodGroup);

	/**
	 * @Title:
	 * @Description: 批量修改产品方案机构权限
	 * @param prodGroups
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int updateByPrimaryKeyDataList(List<ProdGroup> prodGroups);

	/**
	 * @Title:
	 * @Description: 动态修改产品方案机构权限
	 * @param prodGroup
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int updateByPrimaryKeySelectiveData(ProdGroup prodGroup);

	/**
	 * @Title:
	 * @Description: 批量动态修改产品方案机构权限
	 * @param prodGroups
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int updateByPrimaryKeySelectiveDataList(List<ProdGroup> prodGroups);

	/**
	 * @Title:
	 * @Description: 根据条件修改产品方案机构权限
	 * @param prodGroup
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int updateByExampleData(ProdGroup prodGroup, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改产品方案机构权限
	 * @param prodGroup
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int updateByExampleSelectiveData(ProdGroup prodGroup, Example example);

	/**
	 * @Title:
	 * @Description: 根据prodGroupId删除产品方案机构权限
	 * @param prodGroup
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int deleteData(ProdGroup prodGroup);

	/**
	 * @Title:
	 * @Description: 根据prodGroupId集合批量删除产品方案机构权限
	 * @param prodGroupIds
	 * @param prodGroup
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int deleteDataList(List prodGroupIds,ProdGroup prodGroup);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除产品方案机构权限
	 * @param example
	 * @param prodGroup
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	int deleteExampleData(Example example,ProdGroup prodGroup);

	/**
	 * @Title:
	 * @Description: 查询全部产品方案机构权限
	 * @return List<ProdGroup>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	List<ProdGroup> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个产品方案机构权限
	 * @param example
	 * @return ProdGroup
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	ProdGroup selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询产品方案机构权限
	 * @param example
	 * @return List<ProdGroup>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	List<ProdGroup> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过prodGroupId查询产品方案机构权限
	 * @param prodGroupId
	 * @return ProdGroup
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	ProdGroup selectByPrimaryKey(Object prodGroupId);

	/**
	 * @Title:
	 * @Description: 分页查询产品方案机构权限
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ProdGroup>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	PageInfoExtend<ProdGroup> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询产品方案机构权限vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ProdGroup>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	PageInfoExtend<ProdGroup> selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 通过产品方案查询
	 * @param product
	 * @return List<ProdGroupVo>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	List<ProdGroupVo> selectProdGroupVosByProduct(String product);

}
