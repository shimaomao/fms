package cn.com.leadu.fms.system.validator.sysparam.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysParam;
import cn.com.leadu.fms.system.validator.sysparam.validator.SysParamValidator;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: SysParamVo
 * @Description: 系统常量表保存时载体及验证
 * @date 2018-03-09
 */
@Data
public class SysParamSaveVo extends BaseVo<SysParam> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 参数主键id
	 */
	private String paramKeyId;

	/**
	 * @Fields  : 参数主键
	 */
	@SysParamValidator(message = "已经存在，不能重复添加")
	@NotBlank(message = "参数主键不能为空")
	private String paramKey;

	/**
	 * @Fields  : 参数名称
	 */
	@NotBlank(message = "参数名称不能为空")
	private String paramName;

	/**
	 * @Fields  : 参数描述
	 */
	private String paramDesc;

	/**
	 * @Fields  : 参数值
	 */
	@NotBlank(message = "参数值不能为空")
	private String paramValue;

	/**
	 * @Fields  : 开始日期
	 */
	private Date validStartDate;

	/**
	 * @Fields  : 结束日期
	 */
	private Date validEndDate;

}