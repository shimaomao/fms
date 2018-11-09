package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysMenuClicks;
import cn.com.leadu.fms.pojo.system.vo.sysmenuclicks.SysMenuClicksVo;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksDeleteListVo;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksDeleteVo;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksModifyVo;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksService
 * @Description: 利率因子业务层
 * @date 2018-05-03
 */
public interface SysMenuClicksService {

	/**
	 * @Title:
	 * @Description: 分页查询利率因子
	 * @param sysMenuClicksVo
	 * @return PageInfoExtend<SysMenuClicks>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	PageInfoExtend<SysMenuClicksVo> findSysMenuClickssByPage(SysMenuClicksVo sysMenuClicksVo);

	List<SysMenuClicksVo> findSysMenuClicksByUser(SysMenuClicksVo sysMenuClicksVo);

	/**
	 * @Title:
	 * @Description: 保存利率因子
	 * @param sysMenuClicksVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
    void saveSysMenuClicks(SysMenuClicksVo sysMenuClicksVo);


	/**
	 * @Title:
	 * @Description: 修改利率因子
	 * @param sysMenuClicksModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	void modifySysMenuClicks(SysMenuClicksModifyVo sysMenuClicksModifyVo);

	/**
	 * @Title:
	 * @Description:  通过menuClicksId删除利率因子
	 * @param sysMenuClicksDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	void deleteSysMenuClicks(SysMenuClicksDeleteVo sysMenuClicksDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过menuClicksId集合删除利率因子
	 * @param sysMenuClicksDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	void deleteSysMenuClickssByMenuClicksIds(SysMenuClicksDeleteListVo sysMenuClicksDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据menuClicksId获取利率因子
	 * @param menuClicksId
	 * @return SysMenuClicks
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 18:09:17
	 */
	SysMenuClicks findSysMenuClicksByMenuClicksId(String menuClicksId);
}
