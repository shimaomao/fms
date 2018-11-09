package cn.com.leadu.fms.pojo.system.vo.sysuserrole;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysUserRole;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: SysUserRoleVo
 * @Description: 用户角色管理载体
 * @date 2018-03-22
 */
@Data
public class SysUserRoleVo extends PageQuery<SysUserRole> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户角色id
	 */
	private String userRoleId;
	/**
	 * @Fields  :用户id
	 */
	private String userId;

	/**
	 * @Fields  : 角色id
	 */
	private String roleId;

	/**
	 * @Fields  : 删除标记
	 */
	private Integer delFlag;

	/**
	 * @Fields  : 用户id集合
	 */
	private List<String> userIds;

	/**
	 * @Fields  : 角色id集合
	 */
	private List<String> roleIds;

	/**
	 * @Fields  : 删除标记集合
	 */
	private List<Integer> delFlags;

}