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
 * @author huchenghao
 * @ClassName: SysCodeTypeDao
 * @Description: 字典数据类型实体
 * @date 2018-03-08
 */
@ExcelTitle(value = "数据字典类型")
@Data
public class SysCodeType extends BaseEntity<SysCodeType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String codeTypeId;

	private String codeType;
	/**
	 * @Fields  : 
	 */
	private String codeTypeName;

	/**
	 * @Fields  : 
	 */
	private String enableFlag;

	/**
	 * @Fields  : 
	 */
	private String memo;
	@ExcelTitle(value = "数据字典类型代码", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeType(){
		return this.codeType;
	}

	@ExcelTitle(value = "数据字典类型名称", sort =2  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeTypeName(){
		return this.codeTypeName;
	}

	@ExcelTitle(value = "启用状态", sort = 4 , codeType = CommonCodeTypeConstants.enableFlag)
	public String getEnableFlag(){
		return this.enableFlag;
	}

	@ExcelTitle(value = "使用说明", sort =3  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getMemo(){
		return this.memo;
	}
}