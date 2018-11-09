package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lijunjun
 * @ClassName: ContactsChange
 * @Description: 联系人信息变更实体
 * @date 2018-09-01
 */
@Data
public class ContactsChange extends BaseEntity<ContactsChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 联系人信息变更id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String contactsChangeId;

	/**
	 * @Fields  : 操作类型
	 * @author lijunjun
	 */
	private String solveType;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 变更任务号
	 * @author lijunjun
	 */
	private String contactsTaskNo;

	/**
	 * @Fields  : 序号
	 * @author lijunjun
	 */
	private String contactNo;

	/**
	 * @Fields  : 联系人姓名
	 * @author lijunjun
	 */
	private String name;

	/**
	 * @Fields  : 是否租金联系人
	 * @author lijunjun
	 */
	private String rentFlag;

	/**
	 * @Fields  : 联系人关系
	 * @author lijunjun
	 */
	private String relation;

	/**
	 * @Fields  : 联系人手机号码
	 * @author lijunjun
	 */
	private String mobileNo;

	/**
	 * @Fields  : 联系人所在省份
	 */
	private String resideProv;

	/**
	 * @Fields  : 联系人所在城市
	 */
	private String resideCity;

	/**
	 * @Fields  : 联系人所在区县
	 */
	private String resideCounty;

	/**
	 * @Fields  : 联系人所在详细地址
	 */
	private String resideAddr;

}