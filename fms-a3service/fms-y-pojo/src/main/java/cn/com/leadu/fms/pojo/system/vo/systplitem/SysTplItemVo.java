package cn.com.leadu.fms.pojo.system.vo.systplitem;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysTplItem;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemVo
 * @Description: 模板可设项目管理载体
 * @date 2018-03-12
 */
@Data
public class SysTplItemVo extends PageQuery<SysTplItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 模板项目ID
	 */
	private String tplItemId;

	/**
	 * @Fields  : 类型识别
	 */
	private String tplTypeKey;

	/**
	 * @Fields  : 可设项目key
	 */
	private String tplItemKey;

	/**
	 * @Fields  : 可设项目名
	 */
	private String tplItemName;

	/**
	 * @Fields  : 模板项目ID
	 */
	private List<String> tplItemIds;

}