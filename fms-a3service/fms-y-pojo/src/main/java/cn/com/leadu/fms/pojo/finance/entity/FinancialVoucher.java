package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.annotation.ChildTreeId;
import cn.com.leadu.fms.common.annotation.ParentTreeId;
import cn.com.leadu.fms.common.annotation.TreeText;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucher
 * @Description: 凭证类型管理实体
 * @date 2018-06-20
 */
@Data
public class FinancialVoucher extends BaseEntity<FinancialVoucher> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 凭证类型id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String voucherId;

	/**
	 * @Fields  : 凭证类型
	 * @author ningyangyang
	 */
	@ChildTreeId
	private String voucherType;

	/**
	 * @Fields  : 凭证类型名称
	 * @author ningyangyang
	 */
	@TreeText
	private String voucherName;

	/**
	 * @Fields  : 凭证类型备注
	 * @author ningyangyang
	 */
	@ParentTreeId
	private String voucherMemo;

}