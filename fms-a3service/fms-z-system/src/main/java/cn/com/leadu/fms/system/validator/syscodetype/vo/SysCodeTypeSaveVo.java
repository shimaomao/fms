package cn.com.leadu.fms.system.validator.syscodetype.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import cn.com.leadu.fms.system.validator.syscodetype.validator.SysCodeTypeValidator;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeVo
 * @Description: 字典数据类型保存时载体及验证
 * @date 2018-03-08
 */
@Data
public class SysCodeTypeSaveVo extends BaseVo<SysCodeType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  :
	 */
	private String codeTypeId;
    @SysCodeTypeValidator(message = "已存在的数据字典类型，请勿重复添加！")
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