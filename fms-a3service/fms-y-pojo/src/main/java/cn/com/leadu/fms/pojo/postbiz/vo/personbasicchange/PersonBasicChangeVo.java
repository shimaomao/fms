package cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.PersonBasicChange;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import lombok.Data;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeVo
 * @Description: 个人基本信息变更表载体
 * @date 2018-08-31
 */
@Data
public class PersonBasicChangeVo extends PageQuery<PersonBasicChange> {

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

	/**
	 * @Fields  : 个人基本信息变更id
	 * @author lijunjun
	 */
	private List<String> personChangeIds;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

	/**
	 * @Fields : 客户联系人信息
	 */
	private List<CstmContact> cstmContactList;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

}