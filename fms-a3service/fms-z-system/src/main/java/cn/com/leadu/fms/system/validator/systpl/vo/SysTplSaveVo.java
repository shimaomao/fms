package cn.com.leadu.fms.system.validator.systpl.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysTpl;
import cn.com.leadu.fms.system.validator.systpl.validator.SysTplSaveValidator;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wubaoliang
 * @ClassName: SysTplVo
 * @Description: 模板管理保存时载体及验证
 * @date 2018-03-12
 */
@Data
public class SysTplSaveVo extends BaseVo<SysTpl> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 模板名称
	 */
	@NotBlank(message = "模板名称不能为空")
	@SysTplSaveValidator(message = "模板名称已经存在")
	private String tplName;

	/**
	 * @Fields  : 类型ID
	 */
	@NotBlank(message = "模板类型不能为空")
	private String tplTypeKey;

	/**
	 * @Fields  : 启用标志
	 */
	@NotBlank(message = "启用标志不能为空")
	private String enableFlag;

	/**
	 * @Fields  : 模板内容:短信内容/合同模板文件路径
	 */
	@NotBlank(message = "模板内容不能为空")
	private String tplContent;

}