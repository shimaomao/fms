package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicks
 * @Description: 利率因子实体
 * @date 2018-05-03
 */
@Data
public class SysMenuClicks extends BaseEntity<SysMenuClicks> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 常用菜单id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String menuClicksId;

	/**
	 * @Fields  : 用户代码
	 * @author lijunjun
	 */
	private String user;

	/**
	 * @Fields  : 菜单链接
	 * @author lijunjun
	 */
	private String menuLink;

	/**
	 * @Fields  : 点击次数
	 * @author lijunjun
	 */
	private Integer clicksCount;

}