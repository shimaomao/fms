package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author ningyangyang
 * @ClassName: CstmContact
 * @Description: 客户联系人信息实体
 * @date 2018-03-27
 */
@Data
public class CstmContact extends BaseEntity<CstmContact> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 联系人信息ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String contactId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 序号
	 */
	private String contactNo;

	/**
	 * @Fields  : 联系人姓名
	 */
	private String name;

	/**
	 * @Fields  : 联系人关系
	 */
	private String relation;

	/**
	 * @Fields  : 是否是租金联系人
	 */
	private String rentFlag;

	/**
	 * @Fields  : 联系人手机号码
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