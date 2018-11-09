package cn.com.leadu.fms.system.validator.sysmenuclicks.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysMenuClicks;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksVo
 * @Description: 利率因子修改时载体及验证
 * @date 2018-05-03
 */
@Data
public class SysMenuClicksModifyVo extends BaseVo<SysMenuClicks> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 常用菜单id
	 * @author lijunjun
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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