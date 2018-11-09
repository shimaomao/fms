package cn.com.leadu.fms.baseinfo.validator.basfiletype.vo;

import cn.com.leadu.fms.baseinfo.validator.basfiletype.validator.BasFileTypeValidator;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeVo
 * @Description: 附件类型管理表修改时载体及验证
 * @date 2018-03-19
 */
@Data
public class BasFileTypeModifyVo extends BaseVo<BasFileType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 附件类型ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String fileTypeId;

	/**
	 * @Fields  : 附件类型代码
	 */
	@NotBlank(message = "附件类型代码不能为空")
	private String fileType;

	/**
	 * @Fields  : 附件类型名称
	 */
	@NotBlank(message = "附件类型名称不能为空")
	private String fileTypeName;

	/**
	 * @Fields  : 附件类型描述
	 */
	private String fileTypeMemo;

	/**
	 * @Fields  : 附件类型别名
	 */
	private String fileTypeAlias;

	/**
	 * @Fields  : 上级附件类型代码
	 */
	private String parentFileType;

	/**
	 * @Fields  : 业务条件表达式
	 */
	private String fileTypeExpr;

	/**
	 * @Fields  : 附件属性名
	 */
	private String fileAttr;

	/**
	 * @Fields  : 是否必填
	 */
	@NotBlank(message = "是否必填不能为空")
	private String fileChkFlag;

	/**
	 * @Fields  : 排序
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 类型限制
	 */
	private String fileTypeSuff;

	/**
	 * @Fields  : 数量限制
	 */
	private Integer fileQtyLimit;

	/**
	 * @Fields  : 是否实际文件
	 */
	@NotBlank(message = "是否实际文件不能为空")
	private String fileFlag;

	/**
	 * @Fields  : 子类附件
	 */
	private List<BasFileTypeVo> chiBasFiles;

}