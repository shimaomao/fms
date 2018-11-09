package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: Apply
 * @Description: 申请信息实体
 * @date 2018-04-12
 */
@Data
public class Apply extends BaseEntity<Apply> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 订单ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String applyId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;
	/**
	 * @Fields  : 申请类型
	 */
	private String applyType;

	/**
	 * @Fields  : 订单状态
	 */
	private String bizStatus;

	/**
	 * @Fields  : 订单提出账号
	 */
	private String applyUser;

	/**
	 * @Fields  : 订单提出机构代码
	 */
	private String applyGroup;

	/**
	 * @Fields  : 订单创建日期
	 */
	private Date applyCreatDate;

	/**
	 * @Fields  : 订单首次提交日期
	 */
	private Date applyFirsbtDate;

	/**
	 * @Fields  : 订单提交日期
	 */
	private Date applySubmitDate;

	/**
	 * @Fields  : 审批通过日期
	 */
	private Date applyPassDate;

	/**
	 * @Fields  : 当前节点账号
	 */
	private String presentUser;

	/**
	 * @Fields  : 企业类型1
	 * @author ningyangyang
	 */
	private String companyType1;

	/**
	 * @Fields  : 企业类型2
	 * @author ningyangyang
	 */
	private String companyType2;

	/**
	 * @Fields  : 是否适合抵押
	 * @author liujinge
	 */
	private String mortgageFlag;

	/**
	 * @Fields  : 是否有条件同意
	 * @author liujinge
	 */
	private String approveFlag;

	/**
	 * @Fields  : 有条件同意人,1-主管，2-总经理
	 * @author liujinge
	 */
	private String approveFlagPerson;

	/**
	 * @Fields  : 是否家访
	 * @author ningyangyang
	 */
	private String visitFlag;

	/**
	 * @Fields  : 不家访理由
	 * @author ningyangyang
	 */
	private String novisitReason;

	/**
	 * @Fields  : 风控初审派单
	 * @author ningyangyang
	 */
	private String approveUser;

	/**
	 * @Fields  : 审批备注
	 * @author ningyangyang
	 */
	private String remark;

	/**
	 * @Fields  : 风控经理操作建议
	 * @author yanfengbo
	 */
	private String windcontrManagerProposal;

	/**
	 * @Fields  : 风控审批结果
	 * @author yanfengbo
	 */
	private String windcontrApprovalStatus;

	/**
	 * @Fields  : 终审审批结果
	 * @author yanfengbo
	 */
	private String finalApprovalStatus;
}