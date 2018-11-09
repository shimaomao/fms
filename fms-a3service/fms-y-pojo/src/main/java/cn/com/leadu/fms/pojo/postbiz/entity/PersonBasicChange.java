package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChange
 * @Description: 个人基本信息变更表实体
 * @date 2018-08-31
 */
@Data
public class PersonBasicChange extends BaseEntity<PersonBasicChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人基本信息变更id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String personChangeId;

	/**
	 * @Fields  : 数据类型
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
	private String personTaskNo;

	/**
	 * @Fields  : 承租人
	 * @author lijunjun
	 */
	private String name;

	/**
	 * @Fields  : 居住省份
	 * @author lijunjun
	 */
	private String resideProv;

	/**
	 * @Fields  : 居住城市
	 * @author lijunjun
	 */
	private String resideCity;

	/**
	 * @Fields  : 居住区县
	 * @author lijunjun
	 */
	private String resideCounty;

	/**
	 * @Fields  : 居住详细地址
	 * @author lijunjun
	 */
	private String resideAddr;

	/**
	 * @Fields  : 手机号码
	 * @author lijunjun
	 */
	private String mobileNo;

}