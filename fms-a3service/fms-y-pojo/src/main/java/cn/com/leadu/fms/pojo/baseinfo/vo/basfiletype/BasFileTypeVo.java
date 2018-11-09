package cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype;

import cn.com.leadu.fms.common.annotation.ChildTreeId;
import cn.com.leadu.fms.common.annotation.ParentTreeId;
import cn.com.leadu.fms.common.annotation.TreeText;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import lombok.Data;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeVo
 * @Description: 附件类型管理表载体
 * @date 2018-03-19
 */
@Data
public class BasFileTypeVo extends PageQuery<BasFileType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 附件类型ID
	 */
	private String fileTypeId;

	/**
	 * @Fields  : 附件类型代码
	 */
	@ChildTreeId
	private String fileType;

	/**
	 * @Fields  : 附件类型名称
	 */
	@TreeText
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
	@ParentTreeId
	private String parentFileType;


	/**
	 * @Fields  : 上级附件类型名称
	 */
	private String parentFileTypeName;



	/**
	 * @Fields  : 业务条件表达式
	 */
	private String fileTypeExpr;

	/**
	 * @Fields  : 是否必填
	 */
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
	 * @Fields  : 附件属性名
	 */
	private String fileAttr;

	/**
	 * @Fields  : 是否实际文件
	 */
	private String fileFlag;

	/**
	 * @Fields  : 附件显示区分
	 */
	private String subType;

	/**
	 * @Fields  : 是否可编辑
	 */
	private String fileEditFlag;

	/**
	 * @Fields  : 附件类型ID
	 */
	private List<String> fileTypeIds;

	/**
	 * @Fields  : 子类附件
	 */
	private List<BasFileTypeVo> chiBasFiles;

}