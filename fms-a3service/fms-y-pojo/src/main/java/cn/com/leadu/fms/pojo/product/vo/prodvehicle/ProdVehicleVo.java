package cn.com.leadu.fms.pojo.product.vo.prodvehicle;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.entity.ProdVehicle;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdVehicleVo
 * @Description: 产品方案车型权限载体
 * @date 2018-04-05
 */
@Data
public class ProdVehicleVo extends PageQuery<ProdVehicle> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品车型权限ID
	 */
	private String prodVehicleId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 车型代码
	 */
	private String vehicleId;
	/**
	 * @Fields  : 车型代码
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 车型名称
	 */
	private String vehicleName;


	/**
	 * @Fields  : 车型级别
	 */
	private String vehicleLevel;

	/**
	 * @Fields  : 产品车型权限ID
	 */
	private List<String> prodVehicleIds;

}