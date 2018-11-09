package cn.com.leadu.fms.pojo.original.entity;

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
 * @author lijunjun
 * @ClassName: BorrowTask
 * @Description: 借阅任务信息实体
 * @date 2018-05-30
 */
@Data
public class BorrowTask extends BaseEntity<BorrowTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 借阅任务id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String borrowTaskId;

	/**
	 * @Fields  : 借阅任务号
	 * @author lijunjun
	 */
	private String borrowTaskNo;

	/**
	 * @Fields  : 借阅任务状态
	 * @author lijunjun
	 */
	private String borrowTaskStatus;

	/**
	 * @Fields  : 归档编号
	 * @author lijunjun
	 */
	private String fileRecordNo;

	/**
	 * @Fields  : 申请人
	 * @author lijunjun
	 */
	private String borrowUser;

	/**
	 * @Fields  : 申请人联系方式
	 * @author lijunjun
	 */
	private String borrowUserTel;

	/**
	 * @Fields  : 邮寄详细地址
	 * @author lijunjun
	 */
	private String postDetailAddress;

	/**
	 * @Fields  : 是否交押金
	 * @author lijunjun
	 */
	private String depositFlag;

	/**
	 * @Fields  : 押金金额
	 * @author lijunjun
	 */
	private BigDecimal depositAmount;

	/**
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 快递公司
	 * @author lijunjun
	 */
	private String postComp;

	/**
	 * @Fields  : 快递编号
	 * @author lijunjun
	 */
	private String postNo;

	/**
	 * @Fields  : 邮寄日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date postDate;

	/**
	 * @Fields  : 邮寄人员
	 * @author lijunjun
	 */
	private String postMember;

	/**
	 * @Fields  : 领取方式
	 * @author : yangyiquan
	 */
	private String borrowGetWay;

	/**
	 * @Fields  : 预计归还时间
	 * @author : ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date expectedReturnDate;

	/**
	 * @Fields  : 借阅用途
	 * @author : yangyiquan
	 */
	private String borrowPurpose;

}