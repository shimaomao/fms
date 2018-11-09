package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfo
 * @Description: 银行账号维护实体
 * @date 2018-03-26
 */
@Data
public class BasBankInfo extends BaseEntity<BasBankInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 银行ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : 电子联行号
	 */
	private String eleAccountNo;

	/**
	 * @Fields  : 开户行
	 */
	private String accBank;

	/**
	 * @Fields  : 分行名称
	 */
	private String accBranchBank;

	/**
	 * @Fields  : 开户行省份
	 */
	private String accOpBankProv;

	/**
	 * @Fields  : 开户行城市
	 */
	private String accOpBankCity;

	/**
	 * @Fields  : 开户名
	 */
	private String accountName;

	/**
	 * @Fields  : 银行账号
	 */
	private String accountNo;

	/**
	 * @Fields  : 编码
	 */
	private String accountCode;

	/**
	 * @Fields  : 是否启用
	 */
	private String enableFlag;

	/**
	 * @Fields  : 是否默认账号
	 */
	private String accDefault;

	/**
	 * @Fields  : 当前节点用户
	 */
	private String presentUser;

	/**
	 * @Fields  : 财务科目代码
	 */
	private String finassSubjectCd;

	/**
	 * @Fields  : 供应商辅助核算代码
	 */
	private String assisFinassSupplyCd;
}