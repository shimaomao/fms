package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysGroupLevel;
import cn.com.leadu.fms.pojo.system.vo.sysgrouplevel.SysGroupLevelVo;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelDeleteListVo;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelModifyVo;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelSaveVo;

/**
 * @author wangxue
 * @ClassName: SysGroupLevelService
 * @Description: 用户组层级业务层
 * @date 2018-03-08
 */
public interface SysGroupLevelService {

	/**
	 * @Title:
	 * @Description: 保存用户组层级
	 * @param sysGroupLevelSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:07
	 */
    void saveSysGroupLevel(SysGroupLevelSaveVo sysGroupLevelSaveVo);


	/**
	 * @Title:
	 * @Description: 修改用户组层级
	 * @param sysGroupLevelModifyVo
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:07
	 */
	void modifySysGroupLevel(SysGroupLevelModifyVo sysGroupLevelModifyVo);

	/**
	 * @Title:
	 * @Description:  通过层级id集合，删除用户组层级
	 * @param sysGroupLevelDeleteListVo
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:07
	 */
	void deleteSysGroupLevelsByIds(SysGroupLevelDeleteListVo sysGroupLevelDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据层级id，获取用户组层级
	 * @param groupLevId
	 * @return SysGroupLevel
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:07
	 */
	SysGroupLevel findSysGroupLevelById(String groupLevId);


	/**
	 * @Title:
	 * @Description: 分页查询用户组层级
	 * @param sysGroupLevelVo
	 * @return PageInfoExtend<SysGroupLevel>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:07
	 */
    PageInfoExtend<SysGroupLevel> findSysGroupLevelsByPage(SysGroupLevelVo sysGroupLevelVo);

	/**
	 * @Title:
	 * @Description:  根据层级代码，获取用户组层级
	 * @param groupLev
	 * @return SysGroupLevel
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:07
	 */
	SysGroupLevel findSysGroupLevelByGroupLev(String groupLev);

}
