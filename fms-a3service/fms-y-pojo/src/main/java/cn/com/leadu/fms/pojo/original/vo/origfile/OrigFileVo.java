package cn.com.leadu.fms.pojo.original.vo.origfile;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: OrigFileVo
 * @Description: 资料邮寄附件载体
 * @date 2018-05-03
 */
@Data
public class OrigFileVo extends PageQuery<OrigFile> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资料ID
	 * @author ningyangyang
	 */
	private String origFileId;

	/**
	 * @Fields  : 资料邮寄业务号
	 * @author ningyangyang
	 */
	private String bizCode;

	/**
	 * @Fields  : 资料邮寄业务类型
	 * @author ningyangyang
	 */
	private String bizCodeType;

	/**
	 * @Fields  : 合同号
	 * @author ningyangyang
	 */
	private String contNo;

	/**
	 * @Fields  : 归档附件大类
	 * @author yangyiquan
	 */
	private String origFileType;

	/**
	 * @Fields  : 归档编号
	 * @author ningyangyang
	 */
	private String fileRecordNo;

	/**
	 * @Fields  : 客户姓名
	 * @author ningyangyang
	 */
	private String name;

	/**
	 * @Fields  : 申请类型
	 * @author ningyangyang
	 */
	private String applyType;

	/**
	 * @Fields  : 归档状态
	 * @author ningyangyang
	 */
	private String origFileStatus;

	/**
	 * @Fields  : 归档审核状态
	 * @author ningyangyang
	 */
	private String origFileTaskStatus;

	/**
	 * @Fields  : 归档日期
	 * @author ningyangyang
	 */
	private Date origFileDate;

	/**
	 * @Fields  : 车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 归档用户
	 * @author ningyangyang
	 */
	private String origFileUser;

	/**
	 * @Fields  : 归档用户所属机构
	 * @author ningyangyang
	 */
	private String origFileGroup;

	/**
	 * @Fields  : 资料ID
	 * @author ningyangyang
	 */
	private List<String> origFileIds;

	/**
	 * @Fields  : 资料邮寄附件
	 * @author ningyangyang
	 */
	private List<OrigFileVo> origFileVoList;

	/**
	 * @Fields  : 待邮寄资料
	 * @author ningyangyang
	 */
	private List<OrigFileDetail> BeMailOrigFileList;

	/**
	 * @Fields  : 退回资料
	 * @author ningyangyang
	 */
	private List<OrigFileDetail> sentBackOrigFileList;

	/**
	 * @Fields  : 资料邮寄附件明细
	 * @author ningyangyang
	 */
	private List<OrigFileDetail> origFileDetailList;

	/**
	 * @Fields  : 剩余归档天数
	 * @author ningyangyang
	 */
	private Integer daysRemaining;

	/**
	 * @Fields  : 实际归档时间
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date actualFilingDate;


	/**
	 * @Fields  : 归档期限
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date origDeadline;

	/**
	 * @Fields  : 快递编号
	 * @author ningyangyang
	 */
	private String postNo;

	/**
	 * @Fields  : 借阅人
	 * @author ningyangyang
	 */
	private String borrowUser;

	/**
	 * @Fields  : 押金
	 * @author ningyangyang
	 */
	private BigDecimal depositAmount;

	/**
	 * @Fields  : 借阅任务号
	 * @author ningyangyang
	 */
	private String borrowTaskNo;

	/**
	 * @Fields  : 是否交押金
	 * @author ningyangyang
	 */
	private String depositFlag;

	/**
	 * @Fields  : 归档时间(判断用)
	 * @author ningyangyang
	 */
	private String jugTime;

	/**
	 * @Fields  : 生效时间
	 * @author ningyangyang
	 */
	private Date validStartDay;

	/**
	 * @Fields  : 失效时间
	 * @author ningyangyang
	 */
	private Date validEndDay;

	/**
	 * @Fields  : 车牌照
	 * @author ningyangyang
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 快递公司
	 * @author ningyangyang
	 */
	private String postComp;

	/**
	 * @Fields  : 电话号码
	 * @author ningyangyang
	 */
	private String mobileNo;

	/**
	 * @Fields  : 客户名称
	 * @author ningyangyang
	 */
	private String cstmName;

	/**
	 * @Fields  : 类型（判断从那个画面传入）
	 * @author ningyangyang
	 */
	private String type;

	/**
	 * @Fields  : 归档状态参数
	 * @author ningyangyang
	 */
	private String origFileStatusParam;

	/**
	 * @Fields  : 明细文件状态
	 * @author ningyangyang
	 */
	private String origFileDetailStatus;

	/**
	 * @Fields  : 借阅状态
	 * @author yangyiquan
	 */
	private String borrowTaskStatus;

	/**
	 * @Fields  : 借阅时间
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date borrowDate;

	/**
	 * @Fields  : 归还状态
	 * @author yangyiquan
	 */
	private String borrowBackTaskStatus;

	/**
	 * @Fields  : 归还时间
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private String returnDate;

	/**
	 * @Fields  : 预计归还时间
	 * @author : ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date expectedReturnDate;

	/**
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

	/**
	 * @Fields  : 借阅用途
	 * @author : yangyiquan
	 */
	private String borrowPurpose;

	/**
	 * @Fields  : 当前用户
	 * @author : yanfengbo
	 */
	private String sysUser;

	/**
	 * @Fields  : 借阅资料
	 * @author : yanfengbo
	 */
	private String origFileDetailNames;

	/**
	 * @Fields  : 当前用户所属机构
	 * @author : yanfengbo
	 */
	private List<String> sysUserGroup;

	/**
	 * @Fields  : 是否超期(剩余归档天数)
	 * @author : yanfengbo
	 */
	private String daysRemainingStatus;
}