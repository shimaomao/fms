package cn.com.leadu.fms.pojo.system.vo.sysuserinfo;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoVo
 * @Description: 消息用户操作管理载体
 * @date 2018-04-25
 */
@Data
public class SysUserInfoVo extends PageQuery<SysUserInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 消息用户操作id
	 * @author qiaomengnan
	 */
	private String userInfoId;

	/**
	 * @Fields  : 消息id
	 * @author qiaomengnan
	 */
	private String infoId;

	/**
	 * @Fields  : 用户
	 * @author qiaomengnan
	 */
	private String user;

	/**
	 * @Fields  : 操作状态
	 * @author qiaomengnan
	 */
	private String readStatus;

	/**
	 * @Fields  : 已读时间
	 * @author qiaomengnan
	 */
	private Date readTime;

	/**
	 * @Fields  : 消息用户操作id
	 * @author qiaomengnan
	 */
	private List<String> userInfoIds;

	/**
	 * @Fields  : 消息内容
	 * @author qiaomengnan
	 */
	private String infoContent;

	/**
	 * @Fields  : 消息业务类型
	 * @author ningyangyang
	 */
	private String infoCodeType;

}