package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.annotation.ChildTreeId;
import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.annotation.ParentTreeId;
import cn.com.leadu.fms.common.annotation.TreeText;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeDao
 * @Description: 附件类型管理表实体
 * @date 2018-03-19
 */
@ExcelTitle(typeValues = { "附件类型信息" ,"上级附件类型代码信息" } ,types = { ExcelTypeConstants.ONE , ExcelTypeConstants.TWO })
@Data
public class BasFileType extends BaseEntity<BasFileType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 附件类型ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : '是否可编辑'
	 */
	private String fileEditFlag;

	@ExcelTitle(value = "附件类型代码", sort = 1 ,types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public String getFileType(){
		return this.fileType;
	}

	@ExcelTitle(value = "附件类型名称", sort = 2,types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public String getFileTypeName(){
		return this.fileTypeName;
	}

	@ExcelTitle(value = "上级附件类型代码", sort = 3,types = {ExcelTypeConstants.ONE})
	public String getParentFileType(){
		return this.parentFileType;
	}

	@ExcelTitle(value = "是否必填", sort = 4,codeType = CommonCodeTypeConstants.REQUIRED_STATE,types = {ExcelTypeConstants.ONE})
	public String getFileChkFlagStr() {return fileChkFlag;}

	@ExcelTitle(value = "排序", sort = 5,types = {ExcelTypeConstants.ONE})
	public Integer getOrderNo(){
		return this.orderNo;
	}

	@ExcelTitle(value = "类型限制", sort = 6,types = {ExcelTypeConstants.ONE})
	public String getFileTypeSuff(){
		return this.fileTypeSuff;
	}

	@ExcelTitle(value = "数量限制", sort = 7,types = {ExcelTypeConstants.ONE})
	public Integer getFileQtyLimit(){
		return fileQtyLimit;
	}

	@ExcelTitle(value = "是否实际文件", sort = 8,codeType = CommonCodeTypeConstants.ACTUAL_FILE,types = {ExcelTypeConstants.ONE})
	public String getFileFlag(){
		return this.fileFlag;
	}

	@ExcelTitle(value = "更新时间", sort = 9,types = {ExcelTypeConstants.ONE})
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime, DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 10,types = {ExcelTypeConstants.ONE})
	public String getUpdater(){
		return updater;
	}

}