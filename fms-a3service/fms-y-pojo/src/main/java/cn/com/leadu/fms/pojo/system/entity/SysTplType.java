package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeDao
 * @Description: 模板类型管理实体
 * @date 2018-03-12
 */
@ExcelTitle(types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO,ExcelTypeConstants.THREE}, typeValues ={"短息模板类型信息", "合同模板类型信息", "模板类型信息"} )
@Data
public class SysTplType extends BaseEntity<SysTplType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 类型ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String tplTypeId;

	/**
	 * @Fields  : 类型识别
	 */
	private String tplTypeKey;

	/**
	 * @Fields  : 类型名称
	 */
	private String tplTypeName;

	/**
	 * @Fields  : 模板种类：*1-短信；2-合同
	 */
	private String tplType;

	/**
	 * @Fields  : 默认模板内容：短信内容/合同模板文件路径
	 */
	private String tplContent;

	/**
	 * @Fields  : 默认模板内容：短信内容/合同模板文件路径
	 */
	private String tplFileName;

	/**
	 * @Fields  : 合同模板页数
	 * @author qiaomengnan
	 */
	private Integer tplPage;

	@ExcelTitle(typeValues = {"短信模板类型代码","合同模板类型代码","模板类型代码"}, sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO,ExcelTypeConstants.THREE})
	public String getTplTypeKey(){
		return this.tplTypeKey;
	}

	@ExcelTitle(typeValues = {"短信模板类型名称","合同模板类型名称","模板类型名称"}, sort = 2 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO,ExcelTypeConstants.THREE})
	public String getTplTypeName(){
		return this.tplTypeName;
	}

	@ExcelTitle(value = "模板种类", sort = 3 ,types = {ExcelTypeConstants.THREE} ,codeType = CommonCodeTypeConstants.TPL_TYPE)
	public String getTplType(){
		return tplType;
	}

	@ExcelTitle(value = "默认模板内容", sort = 4 )
	public String getTplContent(){
		return tplContent;
	}

}