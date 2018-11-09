package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: StockAssets
 * @Description: 股份资产实体
 * @date 2018-05-28
 */
@Data
public class StockAssets extends BaseEntity<StockAssets> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 股份资产ID
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String stockAssetsId;

	/**
	 * @Fields  : 申请编号
	 * @author ningyangyang
	 */
	private String applyNo;

	/**
	 * @Fields  : 股东名称
	 * @author ningyangyang
	 */
	private String shareholderName;

	/**
	 * @Fields  : 股份比例
	 * @author ningyangyang
	 */
	private BigDecimal shareRatio;

	/**
	 * @Fields  : 出资额
	 * @author ningyangyang
	 */
	private BigDecimal contribution;

}