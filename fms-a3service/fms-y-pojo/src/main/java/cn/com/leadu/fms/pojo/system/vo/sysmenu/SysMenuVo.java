package cn.com.leadu.fms.pojo.system.vo.sysmenu;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysMenuVo
 * @Description: 系统菜单载体
 * @date 2018-03-07
 */

@ExcelTitle(value = "菜单信息")
@Data
public class SysMenuVo extends PageQuery<SysMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 菜单id
	 */
	private String menuId;

	/**
	 * @Fields  : 菜单名称
	 */
	private String menuName;

	/**
	 * @Fields  : 启用标识
	 */
	private String enableFlag;

	/**
	 * @Fields  : 上级菜单id
	 */
	private String parMenuId;

	/**
	 * @Fields  : 菜单等级
	 */
	private String menuLevel;

	/**
	 * @Fields  : 菜单链接
	 */
	private String menuLink;

	/**
	 * @Fields  : 排序
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 菜单id集合
	 */
	private List<String> menuIds;

	/**
	 * @Fields  : 上级菜单名称
	 */
	private String parMenuName;

    @ExcelTitle(value = "菜单名称",sort=1)
	public String getMenuName() {
		return menuName;
	}

	@ExcelTitle(value = "启用标识",sort=2,codeType = CommonCodeTypeConstants.COMMON_STATUS)
	public String getEnableFlag() {
		return enableFlag;
	}

	@ExcelTitle(value = "菜单等级",sort=3,codeType = CommonCodeTypeConstants.MENU_LEVEL)
	public String getMenuLevel() {
		return menuLevel;
	}
	@ExcelTitle(value = "上级菜单",sort=4)
	public String getParMenuName() {
		return parMenuName;
	}

	@ExcelTitle(value = "菜单链接",sort=5)
	public String getMenuLink() {
		return menuLink;
	}

	@ExcelTitle(value = "排序",sort=6)
	public Integer getOrderNo() {
		return orderNo;
	}

	@ExcelTitle(value = "更新时间", sort =7)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 8)
	public String getUpdater(){
		return updater;
	}

}