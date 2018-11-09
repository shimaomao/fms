package cn.com.leadu.fms.pojo.product.vo.prodintrst;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstVo
 * @Description: 产品利率载体
 * @date 2018-03-27
 */
@Data
public class ProdIntrstVo extends PageQuery<ProdIntrst> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品利率ID
	 */
	private String prodIntrstId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 利率方案序号
	 */
	private String intrstNo;

	/**
	 * @Fields  : 客户利率
	 */
	private BigDecimal intrstRate;

	/**
	 * @Fields  : 结算利率
	 */
	private BigDecimal settleIntrstRate;

	/**
	 * @Fields  : 手续费率
	 */
	private BigDecimal chargeRate;

	/**
	 * @Fields  : 结算手续费率
	 */
	private BigDecimal settleChargeRate;

	/**
	 * @Fields  : 一次性手续费
	 */
	private BigDecimal onetimeCharge;

	/**
	 * @Fields  : 贴息方式
	 */
	private String subsidyMode;

	/**
	 * @Fields  : 贴息利率
	 */
	private BigDecimal subsidyRate;

	/**
	 * @Fields  : 贴息年限
	 */
	private Integer subsidyYear;

	/**
	 * @Fields  : 贴息金额
	 */
	private BigDecimal subsidyAmount;

	/**
	 * @Fields  : 利率方式
	 */
	private String intrstRateMode;


	/**
	 * @Fields  : 利率方式删除区分
	 */
	private Integer intrstDelFlag;

	/**
	 * @Fields  : 利率因子条件
	 */
	private List<ProdIntrstFactorVo> prodIntrstFactorVoList;

	/**
	 * @Fields  : 产品利率ID
	 */
	private List<String> prodIntrstIds;

}