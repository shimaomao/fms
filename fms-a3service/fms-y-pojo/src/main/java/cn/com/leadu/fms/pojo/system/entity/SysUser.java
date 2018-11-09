package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.entity.BaseUser;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: SysUserDao
 * @Description: 系统用户管理实体
 * @date 2018-03-17
 */
@Data
public class SysUser extends BaseEntity<SysUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String userId;

	/**
	 * @Fields  : 用户代码
	 */
	private String user;

	/**
	 * @Fields  : 用户名称
	 */
	private String userName;

	/**
	 * @Fields  : 用户密码
	 */
	private String userPassword;

	/**
	 * @Fields  : 机构(用户组)
	 */
	private String groupCode;

	/**
	 * @Fields  : 用户电话
	 */
	private String userTelNo;

	/**
	 * @Fields  : 用户手机
	 */
	private String userMobileNo;

	/**
	 * @Fields  : 用户邮箱
	 */
	private String userMailAddress;

	/**
	 * @Fields  : 启用标志
	 */
	private String enableFlag;

	/**
	 * @Fields  : 入职日期
	 */
	private Date employDate;

	/**
	 * @Fields  : 用户证件类型
	 */
	private String certifType;

	/**
	 * @Fields  : 用户证件号码
	 */
	private String certifNo;

	/**
	 * @Fields  : 用户性别
	 */
	private String sex;

	/**
	 * @Fields  : 菜单权限类型
	 */
	private String validMenuType;

	/**
	 * @Fields  : 用户管理级别
	 */
	private String userDeptLevel;

	/**
	 * @Fields  : 最后登录时间
	 */
	private Date lastLoginTime;

}