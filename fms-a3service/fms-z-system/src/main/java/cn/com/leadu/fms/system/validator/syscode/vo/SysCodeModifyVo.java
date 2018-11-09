package cn.com.leadu.fms.system.validator.syscode.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author huchenghao
 * @ClassName: SysCodeVo
 * @Description: 字典数数值修改时载体及验证
 * @date 2018-03-09
 */
@Data
public class SysCodeModifyVo extends BaseVo<SysCode> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String codeValueId;

	/**
	 * @Fields  : 
	 */
	@NotBlank(message = "数据字典类型代码不能为空")
	private String codeType;

	/**
	 * @Fields  :
	 */
	@NotBlank(message = "数据字典数值代码不能为空")
	private String codeValue;

	/**
	 * @Fields  :
	 */
	@NotBlank(message = "数据字典数值名称不能为空")
	private String codeValueName;

	/**
	 * @Fields  : 
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 
	 */
	private String appendValue;

	/**
	 * @Fields  : 
	 */
	private String memo;
	/**
	 * @Fields  :
	 */
	@NotBlank(message = "启用标志不能为空")
	private String enableFlag;
}