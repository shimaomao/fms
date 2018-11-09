package cn.com.leadu.fms.prebiz.validator.cstmcontact.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import lombok.Data;

/**
 * @author ningyangyang
 * @ClassName: CstmContactVo
 * @Description: 客户联系人信息保存时载体及验证
 * @date 2018-03-27
 */
@Data
public class CstmContactSaveVo extends BaseVo<CstmContact> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 联系人信息ID
	 */
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
	 * @Fields  : 是否是租金联系人
	 */
	private String rentFlag;

	/**
	 * @Fields  : 联系人关系
	 */
	private String relation;

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