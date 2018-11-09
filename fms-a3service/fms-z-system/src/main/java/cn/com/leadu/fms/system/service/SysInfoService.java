package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysInfo;
import cn.com.leadu.fms.pojo.system.vo.sysinfo.SysInfoVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoDeleteListVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoDeleteVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoModifyVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoSaveVo;

/**
 * @author qiaomengnan
 * @ClassName: SysInfoService
 * @Description: 消息管理业务层
 * @date 2018-04-25
 */
public interface SysInfoService {

	/**
	 * @Title:
	 * @Description: 分页查询消息管理
	 * @param sysInfoVo
	 * @return PageInfoExtend<SysInfo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	PageInfoExtend<SysInfo> findSysInfosByPage(SysInfoVo sysInfoVo);

	/**
	 * @Title:
	 * @Description: 保存消息管理
	 * @param sysInfoSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
    void saveSysInfo(SysInfoSaveVo sysInfoSaveVo);


	/**
	 * @Title:
	 * @Description: 修改消息管理
	 * @param sysInfoModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	void modifySysInfo(SysInfoModifyVo sysInfoModifyVo);

	/**
	 * @Title:
	 * @Description:  通过infoId删除消息管理
	 * @param sysInfoDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	void deleteSysInfo(SysInfoDeleteVo sysInfoDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过infoId集合删除消息管理
	 * @param sysInfoDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	void deleteSysInfosByInfoIds(SysInfoDeleteListVo sysInfoDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据infoId获取消息管理
	 * @param infoId
	 * @return SysInfo
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	SysInfo findSysInfoByInfoId(String infoId);

}
