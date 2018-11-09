package cn.com.leadu.fms.insurance.validator.continsurclaim.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimVo
 * @Description: 保险理赔保存时载体及验证
 * @date 2018-05-14
 */
@Data
public class ContInsurClaimSaveVo extends BaseVo<ContInsurClaim> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 保险理赔ID
	 * @author yanfengbo
	 */
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
	 * @Fields  : 理赔收款开户行
	 * @author yanfengbo
	 */
	private String accBank;

	/**
	 * @Fields  : 理赔收款户名
	 * @author yanfengbo
	 */
	private String accountName;

	/**
	 * @Fields  : 理赔收款账户
	 * @author yanfengbo
	 */
	private String accountNo;

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
	 * @Fields  : 联系电话
	 * @author yanfengbo
	 */
	private String postMobno;

	/**
	 * @Fields  : 保险理赔状态
	 * @author yanfengbo
	 */
	private String insurClaimStatus;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : TaskId
	 */
	private String taskId;

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

	/**
	 * @Fields  : 付款银行分行
	 * @author lijunjun
	 */
	private String payAccBranch;

	/**
	 * @Fields  : 收款银行分行
	 * @author lijunjun
	 */
	private String recAccBranch;

	/**
	 * @Fields  : 附件信息
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

}