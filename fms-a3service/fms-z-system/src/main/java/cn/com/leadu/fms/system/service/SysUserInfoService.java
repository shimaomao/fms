package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import cn.com.leadu.fms.pojo.system.vo.sysuserinfo.SysUserInfoVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoDeleteListVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoDeleteVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoModifyVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoSaveVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoService
 * @Description: 消息用户操作管理业务层
 * @date 2018-04-25
 */
public interface SysUserInfoService {

	/**
	 * @Title:
	 * @Description: 分页查询消息用户操作管理
	 * @param sysUserInfoVo
	 * @return PageInfoExtend<SysUserInfo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	PageInfoExtend<SysUserInfo> findSysUserInfosByPage(SysUserInfoVo sysUserInfoVo);

	/**
	 * @Title:
	 * @Description: 保存消息用户操作管理
	 * @param sysUserInfoSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
    void saveSysUserInfo(SysUserInfoSaveVo sysUserInfoSaveVo);


	/**
	 * @Title:
	 * @Description: 修改消息用户操作管理
	 * @param sysUserInfoModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	void modifySysUserInfo(SysUserInfoModifyVo sysUserInfoModifyVo);

	/**
	 * @Title:
	 * @Description:  通过userInfoId删除消息用户操作管理
	 * @param sysUserInfoDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	void deleteSysUserInfo(SysUserInfoDeleteVo sysUserInfoDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过userInfoId集合删除消息用户操作管理
	 * @param sysUserInfoDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	void deleteSysUserInfosByUserInfoIds(SysUserInfoDeleteListVo sysUserInfoDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据userInfoId获取消息用户操作管理
	 * @param userInfoId
	 * @return SysUserInfo
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	SysUserInfo findSysUserInfoByUserInfoId(String userInfoId);

	/**
	 * @Title:
	 * @Description: 查询当前自己的消息
	 * @param: sysUserInfoVo
	 * @param: sysUser
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/4/25 14:51
	 */
	PageInfoExtend<SysUserInfo> findSysUserInfoVosByPage(SysUserInfoVo sysUserInfoVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 确认读取消息
	 * @param: sysUserInfoVo
	 * @param: sysUser
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/4/25 14:51
	 */
	void readSysUserInfo(SysUserInfoVo sysUserInfoVo);

}
