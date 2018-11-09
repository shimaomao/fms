package cn.com.leadu.fms.original.validator.borrowtask.vo;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskVo
 * @Description: 借阅任务信息修改时载体及验证
 * @date 2018-05-30
 */
@Data
public class BorrowTaskModifyVo extends BaseVo<BorrowTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 借阅任务id
	 * @author lijunjun
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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
	 * @Fields  : 领取方式
	 * @author : yangyiquan
	 */
	private String borrowGetWay;

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
	private Date postDate;

	/**
	 * @Fields  : 邮寄人员
	 * @author lijunjun
	 */
	private String postMember;

	/**
	 * @Fields  : 车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 承租人
	 * @author ningyangyang
	 */
	private String cstmName;

	/**
	 * @Fields  : 预计归还时间
	 * @author : ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date expectedReturnDate;

}