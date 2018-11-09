package cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchk;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: RiskTelchkVo
 * @Description: 风控电核信息修改时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskTelchkModifyVo extends BaseVo<RiskTelchk> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控电核id
	 * @author liujinge
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String riskTelchkId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 核实项目
	 * @author liujinge
	 */
	private String telchkItem;

	/**
	 * @Fields  : 核实值
	 * @author liujinge
	 */
	private String telchkResult;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	private String memo;

}