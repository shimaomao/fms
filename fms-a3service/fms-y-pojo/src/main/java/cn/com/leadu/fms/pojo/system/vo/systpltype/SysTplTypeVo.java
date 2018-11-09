package cn.com.leadu.fms.pojo.system.vo.systpltype;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeVo
 * @Description: 模板类型管理载体
 * @date 2018-03-12
 */
@Data
public class SysTplTypeVo extends PageQuery<SysTplType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 类型ID
	 */
	private String tplTypeId;

	/**
	 * @Fields  : 类型识别
	 */
	private String tplTypeKey;

	/**
	 * @Fields  : 类型识别集合
	 */
	private List<String> tplTypeKeys;

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
	 * @Fields  : 合同模板页数
	 * @author qiaomengnan
	 */
	private Integer tplPage;

	/**
	 * @Fields  : 默认模板内容：短信内容/合同模板文件路径
	 */
	private String tplFileName;


	/**
	 * @Fields 模板的设定的项目
	 */
	private List<SysTplItemVo> tplItemList;

	/**
	 * @Fields  : 类型ID
	 */
	private List<String> tplTypeIds;

}