package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysMenuClicks;
import cn.com.leadu.fms.pojo.system.vo.sysmenuclicks.SysMenuClicksVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksDao
 * @Description: 利率因子dao层
 * @date 2018-05-03
 */
public interface SysMenuClicksDao extends BaseDao<SysMenuClicks> {

    /**
     * @Title:
     * @Description: 分页获取公告信息
     * @param sysMenuClicksVo 查询条件
     * @return SysMenuClicksVo
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<SysMenuClicksVo> selectSysMenuClicksByPage(@Param("sysMenuClicksVo") SysMenuClicksVo sysMenuClicksVo);

    List<SysMenuClicksVo> selectSysMenuClicksByUser(@Param("sysMenuClicksVo") SysMenuClicksVo sysMenuClicksVo);
}