package cn.com.leadu.fms.data.repository;

import cn.com.leadu.fms.pojo.system.entity.SysFile;
import cn.com.leadu.fms.pojo.system.vo.sysfile.SysFileVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileSaveVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileModifyVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileDeleteVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: SysFileService
 * @Description: 菜单业务层
 * @date 2018-03-05
 */
public interface SysFileService {

	/**
	 * @Title:
	 * @Description: 保存菜单
	 * @param sysFileSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
    void saveSysFile(SysFileSaveVo sysFileSaveVo);


	/**
	 * @Title:
	 * @Description: 修改菜单
	 * @param sysFileModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	void modifySysFile(SysFileModifyVo sysFileModifyVo);

	/**
	 * @Title:
	 * @Description:  通过id删除菜单
	 * @param sysFileDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	void deleteSysFile(SysFileDeleteVo sysFileDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过id集合删除菜单
	 * @param sysFileDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	void deleteSysFileByIds(SysFileDeleteListVo sysFileDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据id菜单
	 * @param id
	 * @return SysFile
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	SysFile findSysFileById(String id);


	/**
	 * @Title:
	 * @Description: 分页查询菜单
	 * @param sysFileVo
	 * @return PageInfoExtend<SysFile>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
    PageInfoExtend<SysFile> findSysFileByPage(SysFileVo sysFileVo);

}
