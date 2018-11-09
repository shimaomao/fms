package cn.com.leadu.fms.system.validator.sysgroup.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysGroup;
import cn.com.leadu.fms.pojo.system.vo.sysgroupparent.SysGroupParentVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupVo
 * @Description: 用户组管理修改时载体及验证
 * @date 2018-03-10
 */
@Data
public class SysGroupModifyVo extends BaseVo<SysGroup> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户组ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String groupId;

	/**
	 * @Fields  : 用户组代码
	 */
	@NotBlank(message = "用户组代码不能为空")
	private String groupCode;

	/**
	 * @Fields  : 用户组全称
	 */
	@NotBlank(message = "用户组全称不能为空")
	private String groupName;

	/**
	 * @Fields  : 用户组简称
	 */
	@NotBlank(message = "用户组简称不能为空")
	private String groupNameShort;

	/**
	 * @Fields  : 用户组英文简称
	 */
	@NotBlank(message = "用户组英文简称不能为空")
	private String groupNameEng;

	/**
	 * @Fields  : 层级代码
	 */
	@NotBlank(message = "层级代码不能为空")
	private String groupLev;

	/**
	 * @Fields  : 启用标志
	 */
	@NotBlank(message = "启用标志不能为空")
	private String enableFlag;

	/**
	 * @Fields  : 上级用户组信息
	 */
	private List<SysGroupParentVo> sysGroupParentVoList;

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
	 * @Fields  : 财务辅助核算代码
	 */
	private String finassGroupCode;

}