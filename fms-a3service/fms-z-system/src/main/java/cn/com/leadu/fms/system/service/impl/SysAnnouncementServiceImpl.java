package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysAnnouncementRepository;
import cn.com.leadu.fms.pojo.system.entity.SysAnnouncement;
import cn.com.leadu.fms.pojo.system.vo.sysannouncement.SysAnnouncementVo;
import cn.com.leadu.fms.system.service.SysAnnouncementService;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementDeleteListVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementDeleteVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementModifyVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementService
 * @Description: 利率因子业务实现层
 * @date 2018-04-27
 */
@Service
public class SysAnnouncementServiceImpl implements SysAnnouncementService {

    /**
     * @Fields  : 利率因子repository
     */
    @Autowired
    private SysAnnouncementRepository sysAnnouncementRepository;

    /**
     * @Title:
     * @Description: 分页查询利率因子
     * @param sysAnnouncementVo
     * @return PageInfoExtend<SysAnnouncement>
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public PageInfoExtend<SysAnnouncementVo> findSysAnnouncementsByPage(SysAnnouncementVo sysAnnouncementVo){
        // 公告标题模糊处理
        if(StringUtils.isNotTrimBlank(sysAnnouncementVo.getAnnounceTitle())){
            sysAnnouncementVo.setAnnounceTitle(SqlUtil.likePattern(sysAnnouncementVo.getAnnounceTitle()));
        } else {
            sysAnnouncementVo.setAnnounceTitle(null);
        }
        // 公告内容模糊处理
        if(StringUtils.isNotTrimBlank(sysAnnouncementVo.getAnnounceCotent())){
            sysAnnouncementVo.setAnnounceCotent(SqlUtil.likePattern(sysAnnouncementVo.getAnnounceCotent()));
        } else {
            sysAnnouncementVo.setAnnounceCotent(null);
        }
        if(StringUtils.isTrimBlank(sysAnnouncementVo.getAnnounceDateSearch())){
            sysAnnouncementVo.setAnnounceDateSearch(null);
        }
        PageInfoExtend<SysAnnouncementVo> pageInfo = sysAnnouncementRepository.selectListVoByPage("selectSysAnnouncementVosByPage",sysAnnouncementVo, sysAnnouncementVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param sysAnnouncementSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    public void saveSysAnnouncement(SysAnnouncementSaveVo sysAnnouncementSaveVo){
        sysAnnouncementRepository.insertData(sysAnnouncementSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改利率因子
     * @param sysAnnouncementModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    public void modifySysAnnouncement(SysAnnouncementModifyVo sysAnnouncementModifyVo){
        sysAnnouncementRepository.updateByPrimaryKeySelectiveData(sysAnnouncementModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过announceId删除利率因子
     * @param sysAnnouncementDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    public void deleteSysAnnouncement(SysAnnouncementDeleteVo sysAnnouncementDeleteVo){
        sysAnnouncementRepository.deleteData(sysAnnouncementDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过announceId集合删除利率因子
     * @param sysAnnouncementDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    public void deleteSysAnnouncementsByAnnounceIds(SysAnnouncementDeleteListVo sysAnnouncementDeleteListVo){
        sysAnnouncementRepository.deleteDataList(sysAnnouncementDeleteListVo.getAnnounceIds(),sysAnnouncementDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据announceId获取利率因子
     * @param announceId
     * @return SysAnnouncement
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    public SysAnnouncement findSysAnnouncementByAnnounceId(String announceId){
        return sysAnnouncementRepository.selectByPrimaryKey(announceId);
    }

}
