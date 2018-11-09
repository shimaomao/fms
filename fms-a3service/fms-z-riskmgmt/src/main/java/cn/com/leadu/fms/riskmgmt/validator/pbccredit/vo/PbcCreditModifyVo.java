package cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PbcCredit;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: PbcCreditVo
 * @Description: 个人人行征信信息修改时载体及验证
 * @date 2018-06-04
 */
@Data
public class PbcCreditModifyVo extends BaseVo<PbcCredit> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人人行征信信息id
	 * @author liujinge
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String pbcCreditId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 关系类型
	 * @author liujinge
	 */
	private String relation;

	/**
	 * @Fields  : 姓名
	 * @author liujinge
	 */
	private String name;

	/**
	 * @Fields  : 是否白户
	 * @author liujinge
	 */
	private String whiteCard;

	/**
	 * @Fields  : 信用卡或贷款状态
	 * @author liujinge
	 */
	private String creditStatus;

	/**
	 * @Fields  : 首笔贷款或贷记卡发放月份
	 * @author liujinge
	 */
	private String firstCreditYm;

	/**
	 * @Fields  : 贷款法人机构数
	 * @author liujinge
	 */
	private String creditCount;

	/**
	 * @Fields  : 贷款合同总额
	 * @author liujinge
	 */
	private BigDecimal creditAmount;

	/**
	 * @Fields  : 贷款余额
	 * @author liujinge
	 */
	private BigDecimal creditRest;

	/**
	 * @Fields  : 最近6个月平均还款
	 * @author liujinge
	 */
	private BigDecimal repayHalfYear;

	/**
	 * @Fields  : 房产抵押或者房产贷款余额
	 * @author liujinge
	 */
	private BigDecimal propertyCreditRest;

	/**
	 * @Fields  : 车辆按揭贷款余额
	 * @author liujinge
	 */
	private BigDecimal carCreditRest;

	/**
	 * @Fields  : 其他贷款余额
	 * @author liujinge
	 */
	private BigDecimal elseCreditRest;

	/**
	 * @Fields  : 贷记卡发卡机构数
	 * @author liujinge
	 */
	private String debitCardCount;

	/**
	 * @Fields  : 贷记卡授信总额
	 * @author liujinge
	 */
	private BigDecimal debitCardAmount;

	/**
	 * @Fields  : 贷记卡最高授信额度
	 * @author liujinge
	 */
	private BigDecimal debitCardMax;

	/**
	 * @Fields  : 已贷记卡使用额度
	 * @author liujinge
	 */
	private BigDecimal debitCardUsed;

	/**
	 * @Fields  : 最近6个月平均使用额度
	 * @author liujinge
	 */
	private BigDecimal usedHalfYear;

	/**
	 * @Fields  : 贷款余额占授信额度比例
	 * @author liujinge
	 */
	private String debitRestRatio;

	/**
	 * @Fields  : 贷记卡已使用信用额度占授信额度比例
	 * @author liujinge
	 */
	private String debitUsedRatio;

	/**
	 * @Fields  : 最早卡户记录距今月数
	 * @author liujinge
	 */
	private String monthMax;

	/**
	 * @Fields  : 最近3个月贷款和信用审批查询次数
	 * @author liujinge
	 */
	private String creditQueryCount;

	/**
	 * @Fields  : 最近2个月新开户数
	 * @author liujinge
	 */
	private String newAccounts;

	/**
	 * @Fields  : 贷款最近3个月所有贷款还款记录最差状态
	 * @author liujinge
	 */
	private String creditStatusThrm;

	/**
	 * @Fields  : 贷款最近24个月所有贷款还款记录最差状态
	 * @author liujinge
	 */
	private String creditStatusTwoy;

	/**
	 * @Fields  : 贷记卡最近6个月所有信用卡还款记录最差状态
	 * @author liujinge
	 */
	private String debitStatusSixm;

	/**
	 * @Fields  : 最近12个月内累计逾期次数
	 * @author liujinge
	 */
	private String overdueCount;

	/**
	 * @Fields  : 逾期记录确认
	 * @author liujinge
	 */
	private String overdueConfirm;

	/**
	 * @Fields  : 其他提示信息
	 * @author liujinge
	 */
	private String elseMemo;

}