package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: ProdVehicle
 * @Description: 产品方案车型权限实体
 * @date 2018-04-05
 */
@Data
public class ProdVehicle extends BaseEntity<ProdVehicle> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品车型权限ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String prodVehicleId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 车型代码
	 */
	private String vehicleCode;

}