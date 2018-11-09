package cn.com.leadu.fms.pojo.baseinfo.vo.basblacklist;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBlacklist;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistVo
 * @Description: 黑名单载体
 * @date 2018-05-04
 */
@Data
public class BasBlacklistVo extends PageQuery<BasBlacklist> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 黑名单id
	 * @author yangyiquan
	 */
	private String blacklistId;

	/**
	 * @Fields  : 客户名称
	 * @author yangyiquan
	 */
	private String name;

	/**
	 * @Fields  : 证件号码
	 * @author yangyiquan
	 */
	private String certifNo;

	/**
	 * @Fields  : 手机号码
	 * @author wangxue
	 */
	private String mobileNo;

	/**
	 * @Fields  : 黑名单级别
	 * @author yangyiquan
	 */
	private String blackLevel;

	/**
	 * @Fields  : 来源
	 * @author yangyiquan
	 */
	private String source;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

	/**
	 * @Fields  : 黑名单id
	 * @author yangyiquan
	 */
	private List<String> blacklistIds;

	/**
	 * @Fields  : 申请编号
	 * @author wangxue
	 */
	private String applyNo;

	/**
	 * @Fields  : 加入黑名单类型
	 * @author wangxue
	 */
	private String registerType;

	/**
	 * @Fields  : 关系类型
	 * @author wangxue
	 */
	private String relationType;

	/**
	 * @Fields  : 关系类型名称
	 * @author wangxue
	 */
	private String relationTypeName;

	/**
	 * @Fields  : 申请编号集合
	 * @author wangxue
	 */
	private List<String> applyNoList;

}