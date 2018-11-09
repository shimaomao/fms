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
import java.util.Date;

/**
 * @author huchenghao
 * @ClassName: SysCodeDao
 * @Description: 字典数数值实体
 * @date 2018-03-09
 */
@ExcelTitle(value = "数据字典数值")
@Data
public class SysCode extends BaseEntity<SysCode> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String codeValueId;

	/**
	 * @Fields  : 
	 */
	private String codeType;

	/**
	 * @Fields  : 
	 */
	private String codeValue;

	/**
	 * @Fields  : 
	 */
	private String codeValueName;

	/**
	 * @Fields  : 
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 
	 */
	private String appendValue;

	/**
	 * @Fields  : 
	 */
	private String memo;

	/**
	 * @Fields  :
	 */
	private String enableFlag;
	@ExcelTitle(value = "数据字典数值代码", sort = 3 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeType(){
		return this.codeType;
	}

	@ExcelTitle(value = "数据字典数值名称", sort =2  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeValueName(){
		return this.codeValueName;
	}
	@ExcelTitle(value = "数据字典类型代码", sort =1  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeValue(){
		return this.codeValue;
	}

	@ExcelTitle(value = "启用状态", sort = 5 , codeType = CommonCodeTypeConstants.enableFlag)
	public String getEnableFlag(){
		return this.enableFlag;
	}

	@ExcelTitle(value = "使用说明", sort =4  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getMemo(){
		return this.memo;
	}
}