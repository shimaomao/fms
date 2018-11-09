package cn.com.leadu.fms.pojo.product.vo.prodgroup;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.entity.ProdGroup;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdGroupVo
 * @Description: 产品方案机构权限载体
 * @date 2018-04-05
 */
@Data
public class ProdGroupVo extends PageQuery<ProdGroup> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品机构权限ID
	 */
	private String prodGroupId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;
	/**
	 * @Fields  : 用户组(机构)Id
	 */
	private String groupId;
	/**
	 * @Fields  : 用户组(机构)代码 
	 */
	private String groupCode;


	/**
	 * @Fields  : 用户组(机构)名称
	 */
	private String groupName;

	/**
	 * @Fields  : 用户组(机构)层级
	 */
	private String groupLev;

	/**
	 * @Fields  : 用户组(机构)层级名称
	 */
	private String groupLevName;

	/**
	 * @Fields  : 产品机构权限ID
	 */
	private List<String> prodGroupIds;

}