package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdVehicle;
import cn.com.leadu.fms.pojo.product.vo.prodvehicle.ProdVehicleVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdVehicleService
 * @Description: 产品方案车型权限业务层
 * @date 2018-04-05
 */
public interface ProdVehicleService {

	/**
	 * @Title:
	 * @Description: 分页查询产品方案车型权限
	 * @param prodVehicleVo
	 * @return PageInfoExtend<ProdVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	PageInfoExtend<ProdVehicle> findProdVehiclesByPage(ProdVehicleVo prodVehicleVo);


	/**
	 * @Title:
	 * @Description:  根据prodVehicleId获取产品方案车型权限
	 * @param prodVehicleId
	 * @return ProdVehicle
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	ProdVehicle findProdVehicleByProdVehicleId(String prodVehicleId);
	/**
	 * @Title:
	 * @Description:  根据prodVehicleId获取产品方案车型权限
	 * @param product
	 * @return ProdVehicle
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	List<ProdVehicle> findProdVehicleByProduct(String product);

	void deleteProdVehiclesByProducts(List<String> products);
}
