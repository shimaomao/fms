package cn.com.leadu.fms.system.validator.sysuser.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserVo
 * @Description: 用户管理修改时载体及验证
 * @date 2018-03-22
 */
@Data
public class SysUserModifyVo extends BaseVo<SysUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String userId;

	/**
	 * @Fields  : 用户代码
	 */
	@NotBlank(message = "用户代码不能为空")
	private String user;

	/**
	 * @Fields  : 用户名称
	 */
	@NotBlank(message = "用户名称不能为空")
	private String userName;

	/**
	 * @Fields  : 用户密码
	 */
	@NotBlank(message = "用户密码不能为空")
	private String userPassword;

	/**
	 * @Fields  : 机构(用户组)
	 */
	@NotBlank(message = "用户组不能为空")
	private String groupCode;

	/**
	 * @Fields  : 用户电话
	 */
	private String userTelNo;

	/**
	 * @Fields  : 用户手机
	 */
	@NotBlank(message = "手机号码不能为空")
	private String userMobileNo;

	/**
	 * @Fields  : 用户邮箱
	 */
	private String userMailAddress;

	/**
	 * @Fields  : 启用标志
	 */
	@NotBlank(message = "启用标识不能为空")
	private String enableFlag;

	/**
	 * @Fields  : 入职日期
	 */
	private Date employDate;

	/**
	 * @Fields  : 用户证件类型
	 */
	@NotBlank(message = "用户证件类型不能为空")
	private String certifType;

	/**
	 * @Fields  : 用户证件号码
	 */
	@NotBlank(message = "用户证件号码不能为空")
	private String certifNo;

	/**
	 * @Fields  : 用户性别
	 */
	@NotBlank(message = "用户性别不能为空")
	private String sex;

	/**
	 * @Fields  : 菜单权限类型
	 */
	@NotBlank(message = "菜单权限类型不能为空")
	private String validMenuType;

	/**
	 * @Fields  : 用户管理级别
	 */
	@NotBlank(message = "用户管理级别不能为空")
	private String userDeptLevel;

	/**
	 * 用户角色信息
	 */
	private List<SysRole> roles;
}