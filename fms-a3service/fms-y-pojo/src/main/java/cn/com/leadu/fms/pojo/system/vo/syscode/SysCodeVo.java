package cn.com.leadu.fms.pojo.system.vo.syscode;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeVo
 * @Description: 字典数数值载体
 * @date 2018-03-09
 */
@ExcelTitle(value = "数据字典数值")
@Data
public class SysCodeVo extends PageQuery<SysCode> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  :
	 */
	private String codeValueId;

	/**
	 * @Fields  :
	 */
	private String codeType;

	/**
	 * @Fields  :
	 */
	private  String codeTypeName;

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

	/**
	 * @Fields  :
	 */
	private List<String> codeValueIds;

	@ExcelTitle(value = "数据字典类型代码", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeType(){
		return this.codeType;
	}

	@ExcelTitle(value = "数据字典类型名称", sort =2  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeTypeName(){
		return this.codeTypeName;
	}
	@ExcelTitle(value = "数据字典代码", sort =3  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeValue(){
		return this.codeValue;
	}

	@ExcelTitle(value = "数据字典名称", sort =4  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCodeValueName(){
		return this.codeValueName;
	}

	@ExcelTitle(value = "启用标志", sort = 5 , codeType = CommonCodeTypeConstants.enableFlag)
	public String getEnableFlag(){
		return this.enableFlag;
	}

	@ExcelTitle(value = "排序", sort = 6)
	public Integer getOrderNo(){
		return orderNo;
	}

	@ExcelTitle(value = "更新时间", sort = 7)
	@JsonIgnore
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 8)
	public String getUpdater(){
		return updater;
	}

}