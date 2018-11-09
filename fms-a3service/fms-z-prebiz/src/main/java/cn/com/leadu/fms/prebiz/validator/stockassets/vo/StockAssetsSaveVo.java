package cn.com.leadu.fms.prebiz.validator.stockassets.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.StockAssets;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: StockAssetsVo
 * @Description: 股份资产保存时载体及验证
 * @date 2018-05-28
 */
@Data
public class StockAssetsSaveVo extends BaseVo<StockAssets> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 股份资产ID
	 * @author ningyangyang
	 */
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