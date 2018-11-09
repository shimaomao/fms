package cn.com.leadu.fms.pojo.system.vo.sysuser;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserVo
 * @Description: 用户组设置载体
 * @date 2018-03-20
 */
@ExcelTitle(value = "用户信息")
@Data
public class SysUserVo extends PageQuery<SysUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户ID
	 */
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
	 * @Fields  : 机构代码(用户组)
	 */
	private String groupCode;

	/**
	 * @Fields  : 机构代码(用户组)集合
	 */
	private List<String> groupCodes;
	/**
	 * @Fields  : 机构名称(用户组)
	 */
	private String groupName;

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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
     @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
	private Date lastLoginTime;

	/**
	 * @Fields  : 用户ID
	 */
	private List<String> userIds;

	/** 
	 * @Fields  : 用户角色信息
	 */ 
	private List<SysRole> roles;  

	/** 
	 * @Fields  : 用户菜单信息，即将弃用
	 */
	@Deprecated
	private List<SysResource> resources;

	/**
	 * @Fields  : 用户菜单信息
	 */
	private List<SysMenu> sysMenus;

	/**
	 *@Fields  : 角色code入力
	 */
	private String role;

	/**
	 *@Fields  : 角色名称入力
	 */
	private String roleName;

	@ExcelTitle(value = "用户代码", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getUser(){
		return this.user;
	}

	@ExcelTitle(value = "用户姓名", sort = 2)
	public String getUserName(){
		return this.userName;
	}

	@ExcelTitle(value = "机构(用户组)", sort = 3)
	public String getGroupName(){
		return this.groupName;
	}

	@ExcelTitle(value = "角色信息", sort = 4)
	public String getRoleNames(){
		StringBuffer roleNames = new StringBuffer();
		if(ArrayUtils.isNotNullAndLengthNotZero(roles)){
			for(SysRole sysRole : roles){
				roleNames.append(sysRole.getRoleName());
				roleNames.append(",");
			}
			roleNames = roleNames.deleteCharAt(roleNames.length() - 1);
		}
		return roleNames.toString();
	}

	@ExcelTitle(value = "用户电话", sort = 5)
	public String getUserTelNo(){
		return userTelNo;
	}

	@ExcelTitle(value = "用户手机", sort = 6)
	public String getUserMobileNo(){
		return userMobileNo;
	}

	@ExcelTitle(value = "用户邮箱", sort = 7)
	public String getUserMailAddress(){
		return userMailAddress;
	}

	@ExcelTitle(value = "启用标志", sort = 8 ,codeType = CommonCodeTypeConstants.COMMON_STATUS)
	public String getEnableFlag(){
		return enableFlag;
	}

	@ExcelTitle(value = "入职日期", sort = 9)
	public String getEmployDateStr(){
		return DateUtils.dateToStr(employDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "用户性别", sort = 10 , codeType = CommonCodeTypeConstants.GENDER)
	public String getSex(){
		return sex;
	}

	@ExcelTitle(value = "菜单权限类型", sort = 11 , codeType = CommonCodeTypeConstants.SYS_VALIDMENUTYPE)
	public String getValidMenuType(){
		return validMenuType;
	}

	@ExcelTitle(value = "最后登录时间", sort = 12)
	public String getLastLoginTimeStr(){
		return DateUtils.dateToStr(lastLoginTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新时间", sort = 13)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 14)
	public String getUpdater(){
		return updater;
	}

}