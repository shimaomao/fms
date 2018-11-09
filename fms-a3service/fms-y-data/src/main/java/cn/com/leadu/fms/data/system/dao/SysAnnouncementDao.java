package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysAnnouncement;
import cn.com.leadu.fms.pojo.system.vo.sysannouncement.SysAnnouncementVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementDao
 * @Description: 利率因子dao层
 * @date 2018-04-27
 */
public interface SysAnnouncementDao extends BaseDao<SysAnnouncement> {

    /**
     * @Title:
     * @Description: 分页获取公告信息
     * @param sysAnnouncementVo 查询条件
     * @return SysAnnouncementVo
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<SysAnnouncement> selectSysAnnouncementVosByPage(@Param("sysAnnouncementVo") SysAnnouncementVo sysAnnouncementVo);
}