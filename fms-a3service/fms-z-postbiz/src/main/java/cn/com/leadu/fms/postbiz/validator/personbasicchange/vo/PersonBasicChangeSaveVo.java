package cn.com.leadu.fms.postbiz.validator.personbasicchange.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.PersonBasicChange;
import lombok.Data;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeVo
 * @Description: 个人基本信息变更表保存时载体及验证
 * @date 2018-08-31
 */
@Data
public class PersonBasicChangeSaveVo extends BaseVo<PersonBasicChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人基本信息变更id
	 * @author lijunjun
	 */
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