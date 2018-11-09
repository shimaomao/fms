package cn.com.leadu.fms.prebiz.validator.crmstockassets.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmStockAssets;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CrmStockAssetsVo
 * @Description: crm股东信息修改时载体及验证
 * @date 2018-08-27
 */
@Data
public class CrmStockAssetsModifyVo extends BaseVo<CrmStockAssets> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 股份资产ID
	 * @author ningyangyang
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String stockAssetsId;

	/**
	 * @Fields  : 统一社会信用代码
	 * @author ningyangyang
	 */
	private String socialCertifNo;

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