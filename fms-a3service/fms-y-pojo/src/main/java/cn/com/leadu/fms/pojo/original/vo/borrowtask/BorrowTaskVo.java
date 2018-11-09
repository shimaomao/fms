package cn.com.leadu.fms.pojo.original.vo.borrowtask;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskVo
 * @Description: 借阅任务信息载体
 * @date 2018-05-30
 */
@Data
public class BorrowTaskVo extends PageQuery<BorrowTask> {

	private static final long serialVersionUID = 1L;


	/**
	 * @Fields  : 借阅任务id
	 * @author lijunjun
	 */
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date postDate;

	/**
	 * @Fields  : 邮寄人员
	 * @author lijunjun
	 */
	private String postMember;

	/**
	 * @Fields  : 借阅任务id
	 * @author lijunjun
	 */
	private List<String> borrowTaskIds;

	/**
	 * @Fields  : 任务ID
	 * @author lijunjun
	 */
	private String taskId;

	/**
	 * @Fields  : 资料邮寄附件明细List
	 * @author lijunjun
	 */
	private List<OrigFileDetailVo> origFileDetailVoList;

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

	/**
	 * @Fields  : 资料归档业务类型
	 * @author yanfengbo
	 */
	private String bizCodeType;

	/**
	 * @Fields  : 借阅用途
	 * @author : yangyiquan
	 */
	private String borrowPurpose;

	/**
	 * 收款状态
	 */
	private String paymentSts;

	/**
	 * 过户状态
	 */
	private String transferSts;

	/**
	 * 借阅资料
	 */
	private String origFileDetailNames;
}