package cn.com.leadu.fms.pojo.prebiz.vo.crmstockassets;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmStockAssets;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CrmStockAssetsVo
 * @Description: crm股东信息载体
 * @date 2018-08-27
 */
@Data
public class CrmStockAssetsVo extends PageQuery<CrmStockAssets> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 股份资产ID
	 * @author ningyangyang
	 */
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

	/**
	 * @Fields  : 股份资产ID
	 * @author ningyangyang
	 */
	private List<String> stockAssetsIds;

}