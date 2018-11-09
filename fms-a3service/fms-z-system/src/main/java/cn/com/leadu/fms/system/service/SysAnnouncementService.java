package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysAnnouncement;
import cn.com.leadu.fms.pojo.system.vo.sysannouncement.SysAnnouncementVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementDeleteListVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementDeleteVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementModifyVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementSaveVo;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementService
 * @Description: 利率因子业务层
 * @date 2018-04-27
 */
public interface SysAnnouncementService {

	/**
	 * @Title:
	 * @Description: 分页查询利率因子
	 * @param sysAnnouncementVo
	 * @return PageInfoExtend<SysAnnouncement>
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
//	PageInfoExtend<SysAnnouncement> findSysAnnouncementsByPage(SysAnnouncementVo sysAnnouncementVo);

	/**
	 * @Title:
	 * @Description: 分页查询公告信息
	 * @param sysAnnouncementVo
	 * @return PageInfoExtend<SysAnnouncement>
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	PageInfoExtend<SysAnnouncementVo> findSysAnnouncementsByPage(SysAnnouncementVo sysAnnouncementVo);

	/**
	 * @Title:
	 * @Description: 保存利率因子
	 * @param sysAnnouncementSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
    void saveSysAnnouncement(SysAnnouncementSaveVo sysAnnouncementSaveVo);


	/**
	 * @Title:
	 * @Description: 修改利率因子
	 * @param sysAnnouncementModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	void modifySysAnnouncement(SysAnnouncementModifyVo sysAnnouncementModifyVo);

	/**
	 * @Title:
	 * @Description:  通过announceId删除利率因子
	 * @param sysAnnouncementDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	void deleteSysAnnouncement(SysAnnouncementDeleteVo sysAnnouncementDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过announceId集合删除利率因子
	 * @param sysAnnouncementDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	void deleteSysAnnouncementsByAnnounceIds(SysAnnouncementDeleteListVo sysAnnouncementDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据announceId获取利率因子
	 * @param announceId
	 * @return SysAnnouncement
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	SysAnnouncement findSysAnnouncementByAnnounceId(String announceId);

}
