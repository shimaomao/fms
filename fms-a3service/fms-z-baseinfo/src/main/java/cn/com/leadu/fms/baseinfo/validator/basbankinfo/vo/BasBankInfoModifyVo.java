package cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoVo
 * @Description: 银行账号维护修改时载体及验证
 * @date 2018-03-26
 */
@Data
public class BasBankInfoModifyVo extends BaseVo<BasBankInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 银行ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String bankId;

	/**
	 * @Fields  : 机构代码
	 */
	private String groupCode;

	/**
	 * @Fields  : 机构类型
	 */
	private String organizationType;

	/**
	 * @Fields  : 机构信息
	 */
	private String organizationId;

	/**
	 * @Fields  : 机构信息代码(辅助用)
	 */
	private String organizationIdCode;

	/**
	 * @Fields  : 银行账号维护任务号
	 */
	private String bankTaskNo;

	/**
	 * @Fields  : 银行账号状态
	 */
	private String accountNoStatus;

	/**
	 * @Fields  : 银行账号序号
	 */
	private String groupBankNo;

	/**
	 * @Fields  : 是否默认账号
	 */
	private String accDefault;

	/**
	 * @Fields  : 备注
	 */
	private String remark1;

	/**
	 * @Fields  : 当前节点用户
	 */
	private String presentUser;

	/**
	 * @Fields  : 电子联行号
	 */
	private String eleAccountNo;

	/**
	 * @Fields  : 开户行
	 */
	@NotBlank(message = "开户行不能为空")
	private String accBank;

	/**
	 * @Fields  : 分行名称
	 */
	@NotBlank(message = "分行名称不能为空")
	private String accBranchBank;

	/**
	 * @Fields  : 开户行省份
	 */
	@NotBlank(message = "开户行省份不能为空")
	private String accOpBankProv;

	/**
	 * @Fields  : 开户行城市
	 */
	@NotBlank(message = "开户行城市不能为空")
	private String accOpBankCity;

	/**
	 * @Fields  : 开户名
	 */
	@NotBlank(message = "开户名不能为空")
	private String accountName;

	/**
	 * @Fields  : 银行账号
	 */
	@NotBlank(message = "银行账号不能为空")
	private String accountNo;

	/**
	 * @Fields  : 编码
	 */
	private String accountCode;

	/**
	 * @Fields  : 是否启用
	 */
	@NotBlank(message = "是否启用不能为空")
	private String enableFlag;

	/**
	 * @Fields  : TaskId
	 */
	private String taskId;

	/**
	 * @Fields  : serviceId
	 */
	private String serviceId;

	/**
	 * @Fields  : 附件信息
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 财务科目代码
	 */
	private String finassSubjectCd;

	/**
	 * @Fields  : 供应商辅助核算代码
	 */
	private String assisFinassSupplyCd;
}