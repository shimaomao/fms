package cn.com.leadu.fms.baseinfo.validator.basblacklist.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBlacklist;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistVo
 * @Description: 黑名单修改时载体及验证
 * @date 2018-05-04
 */
@Data
public class BasBlacklistModifyVo extends BaseVo<BasBlacklist> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 黑名单id
	 * @author yangyiquan
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String blacklistId;

	/**
	 * @Fields  : 客户名称
	 * @author yangyiquan
	 */
	@NotBlank(message = "客户名称不能为空")
	private String name;

	/**
	 * @Fields  : 证件号码
	 * @author yangyiquan
	 */
	@NotBlank(message = "证件号码不能为空")
	private String certifNo;

	/**
	 * @Fields  : 手机号码
	 * @author wangxue
	 */
	private String mobileNo;

	/**
	 * @Fields  : 黑名单级别
	 * @author yangyiquan
	 */
	@NotBlank(message = "黑名单级别不能为空")
	private String blackLevel;

	/**
	 * @Fields  : 来源
	 * @author yangyiquan
	 */
	@NotBlank(message = "来源不能为空")
	private String source;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

}