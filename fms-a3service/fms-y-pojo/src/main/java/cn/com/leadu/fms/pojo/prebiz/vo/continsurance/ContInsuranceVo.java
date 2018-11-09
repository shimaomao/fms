package cn.com.leadu.fms.pojo.prebiz.vo.continsurance;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContInsuranceVo
 * @Description: 合同车辆保险信息载体
 * @date 2018-03-23
 */
@Data
public class ContInsuranceVo extends PageQuery<ContInsurance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 保险信息ID
	 */
	private String contVehinsId;

	/**
	 * @Fields  : 合同编号
	 */
	private String contNo;

	/**
	 * @Fields  : 保险公司名称
	 */
	private String insCompName;

	/**
	 * @Fields  : 商业险保单号
	 */
	private String insPolicyNo;

	/**
	 * @Fields  : 投保生效日
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validStartDay;

	/**
	 * @Fields  : 投保失效日
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validEndDay;

	/**
	 * @Fields  : 保单实际金额
	 */
	private BigDecimal insFee;

	/**
	 * @Fields  : 保单状态
	 */
	private String insuranceStatus;

	/**
	 * @Fields  :
	 */
	private String memo;


	/**
	 * @Fields  : 保险信息ID
	 */
	private List<String> contVehinsIds;

	/**
	 * @Fields  : 险种类型
	 */
	private String insuranceType;

	/**
	 * @Fields  : 险种信息
	 */
	private String insuranceSelectInfo;

	/**
	 * @Fields  : 已购买的保险年限
	 */
	private Integer insuranceYears;

	/**
	 * @Fields  : 保险融资额
	 */
	private BigDecimal finAmount;

	/**
	 * @Fields  : 保险失效日
	 */
	private String inValidTime;

	/**
	 * @Fields  : 融资期限
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 融资类型
	 */
	private String finItem;

	/**
	 * @Fields  : 联系电话
	 */
	private String mobileNo;

	/**
	 * @Fields  : 车牌照
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 还款状态
	 */
	private String paymentSts;

	/**
	 * @Fields  : 企业类型1
	 */
	//2018.10.24  业务类型为经销商的单子，租赁期限只有1年时也要生成续保任务
	// 对应DAO文件增加关联apply表
	private String companyType1;

	/**
	 * @Fields  : 租赁期限结束日
	 */
	private Date leaseTermEndDate;

	/**
	 * @Fields  : 租赁期限结束日
	 */
	private String applyNo;


}