package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: ContCost
 * @Description: 客户费用实体
 */
@Data
public class ContCost extends BaseEntity<ContCost> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 客户费用ID
	 * @author wangxue
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String contCostId;

	/**
	 * @Fields  : 合同编号
	 * @author wangxue
	 */
	private String contNo;

	/**
	 * @Fields  : 款项
	 * @author wangxue
	 */
	private String costItem;

	/**
	 * @Fields  : 类型
	 * @author wangxue
	 */
	private String costType;

	/**
	 * @Fields  : 金额
	 * @author wangxue
	 */
	private BigDecimal costAmount;

	/**
	 * @Fields  : 财务收款Id
	 * @author wangxue
	 */
	private String contReceiptId;

}