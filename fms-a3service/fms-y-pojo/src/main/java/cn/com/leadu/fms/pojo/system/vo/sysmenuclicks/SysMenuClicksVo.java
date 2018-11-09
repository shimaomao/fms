package cn.com.leadu.fms.pojo.system.vo.sysmenuclicks;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysMenuClicks;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksVo
 * @Description: 利率因子载体
 * @date 2018-05-03
 */
@Data
public class SysMenuClicksVo extends PageQuery<SysMenuClicks> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 常用菜单id
	 * @author lijunjun
	 */
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
	 * @Fields  : 菜单名称
	 * @author lijunjun
	 */
	private String menuName;

	/**
	 * @Fields  : 点击次数
	 * @author lijunjun
	 */
	private Integer clicksCount;

	/**
	 * @Fields  : 常用菜单id
	 * @author lijunjun
	 */
	private List<String> menuClicksIds;

}