package cn.com.leadu.fms.asset.validator.equmorrepay.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: EquMorRepayVo
 * @Description: 资方抵押还款计划修改时载体及验证
 * @date 2018-05-30
 */
@Data
public class EquMorRepayModifyVo extends BaseVo<EquMorRepay> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押还款计划表id
	 * @author qiaomengnan
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String equMorRepayId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qiaomengnan
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 客户合同编号
	 * @author qiaomengnan
	 */
	private String clientContNo;

	/**
	 * @Fields  : 客户姓名
	 * @author qiaomengnan
	 */
	private String clientName;

	/**
	 * @Fields  : 融资期限
	 * @author qiaomengnan
	 */
	private String leasePeriod;

	/**
	 * @Fields  : 车架号
	 * @author qiaomengnan
	 */
	private String vinNo;

	/**
	 * @Fields  : 还款日
	 * @author qiaomengnan
	 */
	private String repayDate;

	/**
	 * @Fields  : 租金
	 * @author qiaomengnan
	 */
	private BigDecimal rent;

}