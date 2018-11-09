package cn.com.leadu.fms.pojo.system.vo.systpl;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysTpl;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author wubaoliang
 * @ClassName: SysTplVo
 * @Description: 模板管理载体
 * @date 2018-03-12
 */
@ExcelTitle(typeValues = {"短息模板信息", "合同模板信息"},types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
@Data
public class SysTplVo extends PageQuery<SysTpl> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 模板ID
	 */
	private String tplId;

	/**
	 * @Fields  : 模板名称
	 */
	private String tplName;

	/**
	 * @Fields  : 模板类型识别ID
	 */
	private String tplTypeKey;

	/**
	 * @Fields  : 模板类型名称
	 */
	private String tplTypeName;

	/**
	 * @Fields  : 模板类型
	 */
	private String tplType;

	/**
	 * @Fields  : 启用标志
	 */
	private String enableFlag;

	/**
	 * @Fields  : 模板内容:短信内容/合同模板文件路径
	 */
	private String tplContent;

	/**
	 * @Fields 模板的设定的项目
	 */
	private List<SysTplItemVo> tplItemList;

	/**
	 * @Fields  : 模板ID
	 */
	private List<String> tplIds;

	/**
	 * @Fields  : 模板类型识别ID
	 */
	private List<String> tplTypeKeys;

	@ExcelTitle(value = "模板名称", sort = 1 )
	public String getTplName(){
		return this.tplName;
	}

	@ExcelTitle(typeValues = {"短信模板类型代码","合同模板类型代码"}, sort = 2 ,types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public String getTplTypeKey(){
		return this.tplTypeKey;
	}

	@ExcelTitle(typeValues = {"短信模板类型名称", "合同模板类型名称"}, sort = 3 ,types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public String getTplTypeName(){
		return this.tplTypeName;
	}

	@ExcelTitle(value = "启用标志", sort = 4  ,codeType = CommonCodeTypeConstants.COMMON_STATUS)
	public String getEnableFlag(){
		return enableFlag;
	}

	@ExcelTitle(value = "模板内容", sort = 5 )
	public String getTplContent(){
		return this.tplContent;
	}

}