package cn.com.leadu.fms.pojo.system.vo.sysgroupparent;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: SysGroupParentVo
 * @Description: 用户组关系载体
 * @date 2018-03-12
 */
@Data
public class SysGroupParentVo extends PageQuery<SysGroupParent> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户组关系ID
	 */
	private String parentId;

	/**
	 * @Fields  : 用户组代码
	 */
	private String groupCode;

	/**
	 * @Fields  : 上级用户组代码
	 */
	private String parentGroup;

	/**
	 * @Fields  : 上级用户组名称
	 */
	private String parentGroupName;

	/**
	 * @Fields  : 组织类别
	 */
	private String parentType;

}