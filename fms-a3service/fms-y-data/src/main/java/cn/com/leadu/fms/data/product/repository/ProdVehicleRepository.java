package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdVehicle;
import cn.com.leadu.fms.pojo.product.vo.prodvehicle.ProdVehicleVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdVehicleRepository
 * @Description: 产品方案车型权限Repository层
 * @date 2018-04-05
 */
public interface ProdVehicleRepository {

	/**
	 * @Title:
	 * @Description: 新增产品方案车型权限
	 * @param prodVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int insertData(ProdVehicle prodVehicle);

	/**
	 * @Title:
	 * @Description: 批量保存产品方案车型权限
	 * @param prodVehicles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int insertDataList(List<ProdVehicle> prodVehicles);

	/**
	 * @Title:
	 * @Description: 修改产品方案车型权限
	 * @param prodVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int updateByPrimaryKeyData(ProdVehicle prodVehicle);

	/**
	 * @Title:
	 * @Description: 批量修改产品方案车型权限
	 * @param prodVehicles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int updateByPrimaryKeyDataList(List<ProdVehicle> prodVehicles);

	/**
	 * @Title:
	 * @Description: 动态修改产品方案车型权限
	 * @param prodVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int updateByPrimaryKeySelectiveData(ProdVehicle prodVehicle);

	/**
	 * @Title:
	 * @Description: 批量动态修改产品方案车型权限
	 * @param prodVehicles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int updateByPrimaryKeySelectiveDataList(List<ProdVehicle> prodVehicles);

	/**
	 * @Title:
	 * @Description: 根据条件修改产品方案车型权限
	 * @param prodVehicle
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int updateByExampleData(ProdVehicle prodVehicle, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改产品方案车型权限
	 * @param prodVehicle
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int updateByExampleSelectiveData(ProdVehicle prodVehicle, Example example);

	/**
	 * @Title:
	 * @Description: 根据prodVehicleId删除产品方案车型权限
	 * @param prodVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int deleteData(ProdVehicle prodVehicle);

	/**
	 * @Title:
	 * @Description: 根据prodVehicleId集合批量删除产品方案车型权限
	 * @param prodVehicleIds
	 * @param prodVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int deleteDataList(List prodVehicleIds,ProdVehicle prodVehicle);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除产品方案车型权限
	 * @param example
	 * @param prodVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	int deleteExampleData(Example example,ProdVehicle prodVehicle);

	/**
	 * @Title:
	 * @Description: 查询全部产品方案车型权限
	 * @return List<ProdVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	List<ProdVehicle> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个产品方案车型权限
	 * @param example
	 * @return ProdVehicle
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	ProdVehicle selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询产品方案车型权限
	 * @param example
	 * @return List<ProdVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	List<ProdVehicle> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过prodVehicleId查询产品方案车型权限
	 * @param prodVehicleId
	 * @return ProdVehicle
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	ProdVehicle selectByPrimaryKey(Object prodVehicleId);

	/**
	 * @Title:
	 * @Description: 分页查询产品方案车型权限
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ProdVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	PageInfoExtend<ProdVehicle> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询产品方案车型权限vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ProdVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	PageInfoExtend<ProdVehicle> selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 通过产品方案查询
	 * @param product
	 * @return List<ProdVehicleVo>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	List<ProdVehicleVo> selectProdVehicleVosByProduct(String product);

}
