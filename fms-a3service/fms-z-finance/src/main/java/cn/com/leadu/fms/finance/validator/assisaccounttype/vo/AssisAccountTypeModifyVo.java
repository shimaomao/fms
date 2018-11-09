package cn.com.leadu.fms.finance.validator.assisaccounttype.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeVo
 * @Description: 辅助核算类型管理修改时载体及验证
 * @date 2018-06-23
 */
@Data
public class AssisAccountTypeModifyVo extends BaseVo<AssisAccountType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 辅助核算类型id
	 * @author ningyangyang
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String assisAccountTypeId;

	/**
	 * @Fields  : 辅助核算类型
	 * @author ningyangyang
	 */
	private String assisAccountType;

	/**
	 * @Fields  : 辅助核算类型名称
	 * @author ningyangyang
	 */
	private String assisAccountTypeName;

	/**
	 * @Fields  : 核算项目值设值
	 * @author ningyangyang
	 */
	private String assisAccountValue;

}