package cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyFinDetailVo
 * @Description: 融资费用明细信息载体
 * @date 2018-03-24
 */
@Data
public class ApplyFinDetailVo extends PageQuery<ApplyFinDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资费用明细ID
	 */
	private String applyFinDetailId;

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
	 * @Fields  : 是否可修改
	 */
	private String finMode;

	/**
	 * @Fields  : 是否可修改
	 */
	private String editMode;

	/**
	 * @Fields  : 是否和车款一起支付
	 */
	private String payMode;

	/**
	 * @Fields  : 排序
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 是否为首尾付项目  0:否，1:是
	 */
	private Integer initFinalItemFlag;

	/**
	 * @Fields  : 是否保证金融资项目 0:否，1:是
	 */
	private Integer depositItemFlag;

	/**
	 * @Fields  : 融资费用明细ID
	 */
	private List<String> applyFinDetailIds;

}