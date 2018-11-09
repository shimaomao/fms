package cn.com.leadu.fms.pojo.system.vo.sysgroup;

import cn.com.leadu.fms.common.annotation.ChildTreeId;
import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.annotation.ParentTreeId;
import cn.com.leadu.fms.common.annotation.TreeText;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysGroup;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.vo.sysgroupparent.SysGroupParentVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupVo
 * @Description: 用户组管理载体
 * @date 2018-03-10
 */
@ExcelTitle(value = "用户组信息")
@Data
public class SysGroupVo extends PageQuery<SysGroup> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户组ID
	 */
	private String groupId;

	/**
	 * @Fields  : 用户组代码
	 */
	@ChildTreeId
	private String groupCode;

	/**
	 * @Fields  : 用户组全称
	 */
	@TreeText
	private String groupName;

	/**
	 * @Fields  : 用户组简称
	 */
	private String groupNameShort;

	/**
	 * @Fields  : 用户组英文简称
	 */
	private String groupNameEng;

	/**
	 * @Fields  : 层级代码
	 */
	private String groupLev;

	/**
	 * @Fields  : 层级名称
	 */
	private String groupLevName;

	/**
	 * @Fields  : 统一社会信用代码
	 */
	private String socialCertifNo;

	/**
	 * @Fields  : 注册地址
	 */
	private String registeredAddr;

	/**
	 * @Fields  : 负责人
	 */
	private String head;

	/**
	 * @Fields  : 区域
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 启用标志
	 */
	private String enableFlag;

	/**
	 * @Fields  : 上级用户组代码
	 */
	@ParentTreeId
	private String parentGroup;

	/**
	 * @Fields  : 组织类型
	 */
	private String parentType;


	/**
	 * @Fields  : 上级用户组信息
	 */
	private List<SysGroupParentVo> sysGroupParentVoList;

	/**
	 * @Fields  : 用户组ID
	 */
	private List<String> groupIds;

	/**
	 * @Fields  : 财务辅助核算代码
	 */
	private String finassGroupCode;

	@ExcelTitle(typeValues = {"用户组代码","机构代码"} , sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getGroupCode(){
		return this.groupCode;
	}

	@ExcelTitle(typeValues = {"用户组全称", "机构名称"}, sort = 2 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getGroupName(){
		return this.groupName;
	}

	@ExcelTitle(value = "用户组简称", sort = 3 ,types = {ExcelTypeConstants.ONE})
	public String getGroupNameShort(){
		return this.groupNameShort;
	}

	@ExcelTitle(value = "用户组英文简称", sort = 4 ,types = {ExcelTypeConstants.ONE})
	public String getGroupNameEng(){
		return groupNameEng;
	}

	@ExcelTitle(typeValues = {"层级代码", "机构层级代码"}, sort = 5 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getGroupLev(){
		return groupLev;
	}

	@ExcelTitle(typeValues = {"层级名称", "机构层级名称"}, sort = 6 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getGroupLevName(){
		return groupLevName;
	}

	@ExcelTitle(typeValues = {"统一社会信用代码"}, sort = 6 ,types = {ExcelTypeConstants.ONE})
	public String getSocialCertifNo(){
		return socialCertifNo;
	}

	@ExcelTitle(typeValues = {"负责人"}, sort = 7 ,types = {ExcelTypeConstants.ONE})
	public String getHead(){
		return head;
	}

	@ExcelTitle(typeValues = {"注册地址"}, sort = 8 ,types = {ExcelTypeConstants.ONE})
	public String getRegisteredAddr(){
		return registeredAddr;
	}

	@ExcelTitle(value = "启用标志", sort = 9 ,types = {ExcelTypeConstants.ONE} ,codeType = CommonCodeTypeConstants.COMMON_STATUS)
	public String getEnableFlag(){
		return enableFlag;
	}

	@ExcelTitle(value = "更新时间", sort = 10 ,types = {ExcelTypeConstants.ONE})
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 11 ,types = {ExcelTypeConstants.ONE})
	public String getUpdater(){
		return updater;
	}

}