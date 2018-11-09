package cn.com.leadu.fms.system.validator.systpltype.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import cn.com.leadu.fms.system.validator.systpltype.validator.SysTplTypeSaveValidator;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeVo
 * @Description: 模板类型管理保存时载体及验证
 * @date 2018-03-12
 */
@Data
public class SysTplTypeSaveVo extends BaseVo<SysTplType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 类型识别
	 */
	@NotBlank(message = "模板类型识别不能为空")
	@SysTplTypeSaveValidator(message = "模板类型识别已存在")
	private String tplTypeKey;

	/**
	 * @Fields  : 类型名称
	 */
	@NotBlank(message = "模板类型名称不能为空")
	private String tplTypeName;

	/**
	 * @Fields  : 模板种类：*1-短信；2-合同
	 */
	@NotBlank(message = "模板种类不能为空")
	private String tplType;

	/**
	 * @Fields  : 默认模板内容：短信内容/合同模板文件路径
	 */
	@NotBlank(message = "默认模板内容不能为空")
	private String tplContent;

	/**
	 * @Fields  : 合同模板文件名
	 * @author qiaomengnan
	 */
	private String tplFileName;

	/**
	 * @Fields  : 合同模板页数
	 * @author qiaomengnan
	 */
	private Integer tplPage;

	/**
	 * @Fields 模板的设定的项目
	 */
	private List<SysTplItemVo> tplItemList;

}