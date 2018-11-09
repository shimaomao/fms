package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfo
 * @Description: 消息用户操作管理实体
 * @date 2018-04-25
 */
@Data
public class SysUserInfo extends BaseEntity<SysUserInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 消息用户操作id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : 消息业务类型
	 * @author ningyangyang
	 */
	private String infoCodeType;

}