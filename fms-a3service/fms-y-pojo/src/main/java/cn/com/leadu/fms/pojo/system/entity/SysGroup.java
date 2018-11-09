package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: SysGroupDao
 * @Description: 用户组管理实体
 * @date 2018-03-10
 */
@Data
public class SysGroup extends BaseEntity<SysGroup> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户组ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String groupId;

	/**
	 * @Fields  : 用户组代码
	 */
	private String groupCode;

	/**
	 * @Fields  : 用户组全称
	 */
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
	 * @Fields  : 财务辅助核算代码
	 */
	private String finassGroupCode;

}