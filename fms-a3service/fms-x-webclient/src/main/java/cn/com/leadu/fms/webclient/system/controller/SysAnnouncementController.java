package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysannouncement.SysAnnouncementVo;
import cn.com.leadu.fms.webclient.system.rpc.SysAnnouncementRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementController
 * @Description: 利率因子controller
 * @date 2018-04-27
 */
@RestController
@RequestMapping("sys_announcement")
public class SysAnnouncementController {

    /**
     * @Fields  : 利率因子rpc
     */
    @Autowired
    private SysAnnouncementRpc sysAnnouncementRpc;

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param sysAnnouncementVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "findSysAnnouncementsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysAnnouncementsByPage(SysAnnouncementVo sysAnnouncementVo){
        Map sysAnnouncementVoMap = sysAnnouncementVo == null?null:(Map) JSON.toJSON(sysAnnouncementVo);
        return sysAnnouncementRpc.findSysAnnouncementsByPage(sysAnnouncementVoMap);
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param sysAnnouncementVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "saveSysAnnouncement",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysAnnouncement(@RequestBody SysAnnouncementVo sysAnnouncementVo){
        return sysAnnouncementRpc.saveSysAnnouncement(sysAnnouncementVo);
    }

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param sysAnnouncementVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "modifySysAnnouncement",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysAnnouncement(@RequestBody SysAnnouncementVo sysAnnouncementVo){
        return sysAnnouncementRpc.modifySysAnnouncement(sysAnnouncementVo);
    }

    /**
     * @Title:
     * @Description:   根据announceId集合删除利率因子
     * @param announceIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "deleteSysAnnouncementsByAnnounceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysAnnouncementsByAnnounceIds(@RequestBody List<String> announceIds){
        SysAnnouncementVo sysAnnouncementVo = new SysAnnouncementVo();
        sysAnnouncementVo.setAnnounceIds(announceIds);
        return sysAnnouncementRpc.deleteSysAnnouncementsByAnnounceIds(sysAnnouncementVo);
    }

    /**
     * @Title:
     * @Description:  根据announceId获取利率因子
     * @param announceId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "findSysAnnouncementByAnnounceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysAnnouncementByAnnounceId(String announceId){
        return sysAnnouncementRpc.findSysAnnouncementByAnnounceId(announceId);
    }

}
