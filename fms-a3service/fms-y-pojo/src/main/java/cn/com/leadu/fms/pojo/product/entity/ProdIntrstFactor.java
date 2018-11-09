package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactor
 * @Description: 产品利率实体
 * @date 2018-03-27
 */
@Data
public class ProdIntrstFactor extends BaseEntity<ProdIntrstFactor> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品利率因子ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String prodIntrstFactorId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 利率方案序号
	 */
	private String intrstNo;

	/**
	 * @Fields  : 因子代码
	 */
	private String factorCode;

	/**
	 * @Fields  : 因子值开始
	 */
	private String factorValueFrom;

	/**
	 * @Fields  : 因子值结束
	 */
	private String factorValueTo;

}