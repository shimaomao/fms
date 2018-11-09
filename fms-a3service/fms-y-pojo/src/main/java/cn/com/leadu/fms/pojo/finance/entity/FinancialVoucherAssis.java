package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherAssis
 * @Description: 财务凭证核算数据实体
 * @date 2018-06-26
 */
@Data
public class FinancialVoucherAssis extends BaseEntity<FinancialVoucherAssis> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务凭证核算id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String voucherAssisId;

	/**
	 * @Fields  : 财务凭证id
	 * @author qiaomengnan
	 */
	private String voucherDataId;

	/**
	 * @Fields  : 辅助核算类型
	 * @author qiaomengnan
	 */
	private String assisAccountType;

	/**
	 * @Fields  : 辅助核算序号
	 * @author qiaomengnan
	 */
	private Integer assisAccountOrder;

	/**
	 * @Fields  : 核算项目值
	 * @author qiaomengnan
	 */
	private String assisAccountValue;

}