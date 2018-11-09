package cn.com.leadu.fms.pojo.insurance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaim
 * @Description: 保险理赔实体
 * @date 2018-05-14
 */
@Data
public class ContInsurClaim extends BaseEntity<ContInsurClaim> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 保险理赔ID
	 * @author yanfengbo
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String contInsurClaimId;

	/**
	 * @Fields  : 合同编号
	 * @author yanfengbo
	 */
	private String contNo;

	/**
	 * @Fields  : 保险信息ID
	 * @author yanfengbo
	 */
	private String contVehinsId;

	/**
	 * @Fields  : 出险日期
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date accidentTime;

	/**
	 * @Fields  : 报案号
	 * @author yanfengbo
	 */
	private String accidentRepno;

	/**
	 * @Fields  : 理赔金额
	 * @author yanfengbo
	 */
	private BigDecimal claimAmount;

	/**
	 * @Fields  : 情况说明
	 * @author yanfengbo
	 */
	private String description;

	/**
	 * @Fields  : 是否邮寄
	 * @author yanfengbo
	 */
	private String postFlag;

	/**
	 * @Fields  : 邮寄地址
	 * @author yanfengbo
	 */
	private String postAddr;

	/**
	 * @Fields  : 邮寄收货人
	 * @author yanfengbo
	 */
	private String postName;

	/**
	 * @Fields  : 快递单号
	 * @author yanfengbo
	 */
	private String postNo;

	/**
	 * @Fields  : 审批通过日期
	 * @author yanfengbo
	 */
	private Date claimPassDate;

	/**
	 * @Fields  : 财务确认日期
	 * @author yanfengbo
	 */
	private Date claimValidDate;

	/**
	 * @Fields  : 当前节点用户
	 * @author yanfengbo
	 */
	private String presentUser;

	/**
	 * @Fields  : 保险理赔状态
	 * @author yanfengbo
	 */
	private String insurClaimStatus;

	/**
	 * @Fields  : 联系电话
	 * @author yanfengbo
	 */
	private String postMobno;

	/**
	 * @Fields  : 保险理赔任务号
	 * @author yanfengbo
	 */
	private String contInsurClaimNo;

	/**
	 * @Fields  : 申请日期
	 * @author yanfengbo
	 */
	private Date insurClaimDate;

	/**
	 * @Fields  : 赔款到账日期
	 * @author yanfengbo
	 */
	private Date indemnityEnterAmountDate;

	/**
	 * @Fields  : 是否需要退还
	 * @author yanfengbo
	 */
	private String returnFlag;

	/**
	 * @Fields  : 退还方式
	 * @author yanfengbo
	 */
	private String returnMode;
}