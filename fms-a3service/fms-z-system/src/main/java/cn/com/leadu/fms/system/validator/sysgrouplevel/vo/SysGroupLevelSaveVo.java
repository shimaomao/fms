package cn.com.leadu.fms.system.validator.sysgrouplevel.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysGroupLevel;
import cn.com.leadu.fms.system.validator.sysgrouplevel.validator.SysGroupLevelValidator;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wangxue
 * @ClassName: SysGroupLevelVo
 * @Description: 用户组层级保存时载体及验证
 * @date 2018-03-08
 */
@Data
public class SysGroupLevelSaveVo extends BaseVo<SysGroupLevel> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 层级代码
	 */
	@NotBlank(message = "层级代码不能为空")
	@SysGroupLevelValidator(message = "用户组层级已存在")
	private String groupLev;

	/**
	 * @Fields  : 层级名称
	 */
	@NotBlank(message = "层级名称不能为空")
	private String groupLevName;

	/**
	 * @Fields  : 启用标识
	 */
	@NotBlank(message = "启用标识不能为空")
	private String enableFlag;

}