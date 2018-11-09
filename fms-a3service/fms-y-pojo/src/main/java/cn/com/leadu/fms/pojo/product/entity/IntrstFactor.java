package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author niehaibing
 * @ClassName: IntrstFactor
 * @Description: 利率因子实体
 * @date 2018-03-27
 */
@Data
public class IntrstFactor extends BaseEntity<IntrstFactor> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 利率因子ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String intrstFactorId;

	/**
	 * @Fields  : 因子代码
	 */
	private String factorCode;

	/**
	 * @Fields  : 因子名称
	 */
	private String factorName;

	/**
	 * @Fields  : 匹配类型*1-等于（checkbox）；2-区间（inputtext）
	 */
	private String factorType;

	/**
	 * @Fields  : 启用标志
	 */
	private String enableFlag;

	/**
	 * @Fields  : 排序
	 */
	private Integer orderNo;
}