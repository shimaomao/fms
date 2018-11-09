package cn.com.leadu.fms.pojo.prebiz.vo.contfindetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContFinDetailVo
 * @Description: 合同融资费用明细载体
 * @date 2018-03-23
 */
@Data
public class ContFinDetailVo extends PageQuery<ContFinDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合同融资费用明细ID
	 */
	private String contFinDetailId;

	/**
	 * @Fields  : 合同编号
	 */
	private String contNo;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 车辆序号
	 */
	private String vehicleNo;

	/**
	 * @Fields  : 融资项目代码
	 */
	private String finItem;

	/**
	 * @Fields  : 融资项目名称
	 */
	private String finItemName;

	/**
	 * @Fields  : 融资项目年限
	 */
	private Integer finItemYear;

	/**
	 * @Fields  : 融资额
	 */
	private BigDecimal finAmount;

	/**
	 * @Fields  : 合同融资费用明细ID
	 */
	private List<String> contFinDetailIds;

}