package cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersJob;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CstmPersJobVo
 * @Description: 客户个人职业信息修改时载体及验证
 * @date 2018-03-26
 */
@Data
public class CstmPersJobModifyVo extends BaseVo<CstmPersJob> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人职业信息ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String persJobId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 单位名称
	 */
	private String compName;

	/**
	 * @Fields  : 单位电话
	 */
	private String compTel;

	/**
	 * @Fields  : 在职年限
	 */
	private String workYear;

	/**
	 * @Fields  : 职业
	 */
	private String profession;

	/**
	 * @Fields  : 职位
	 */
	private String position;

	/**
	 * @Fields  : 单位所属行业类别
	 */
	private String industry;

	/**
	 * @Fields  : 单位所在省份
	 */
	private String compProv;

	/**
	 * @Fields  : 单位所在城市
	 */
	private String compCity;

	/**
	 * @Fields  : 单位所在区县
	 */
	private String compCounty;

	/**
	 * @Fields  : 单位详细地址
	 */
	private String compAddr;

	/**
	 * @Fields  : 税后年薪
	 */
	private BigDecimal salary;

	/**
	 * @Fields  : 其他税后年薪
	 */
	private BigDecimal elseSalary;

	/**
	 * @Fields  : 收入来源描述
	 * @author ningyangyang
	 */
	private String sourceIncomeDes;
}