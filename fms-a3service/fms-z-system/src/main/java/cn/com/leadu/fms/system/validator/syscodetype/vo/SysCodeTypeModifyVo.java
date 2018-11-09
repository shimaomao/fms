package cn.com.leadu.fms.system.validator.syscodetype.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeVo
 * @Description: 字典数据类型修改时载体及验证
 * @date 2018-03-08
 */
@Data
public class SysCodeTypeModifyVo extends BaseVo<SysCodeType> {

	private static final long serialVersionUID = 1L;
	/**
	 * @Fields  :
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String codeTypeId;
	/**
	 * @Fields  : 
	 */

	@NotBlank(message = "数据字典类型代码不能为空")
	private String codeType;

	/**
	 * @Fields  :
	 */
	@NotBlank(message = "数据字典类型名称不能为空")
	private String codeTypeName;

	/**
	 * @Fields  :
	 */
	@NotBlank(message = "启用标识不能为空")
	private String enableFlag;

	/**
	 * @Fields  : 
	 */
	private String memo;

}