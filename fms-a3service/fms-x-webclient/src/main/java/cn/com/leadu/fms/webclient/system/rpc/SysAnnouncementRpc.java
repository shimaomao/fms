package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysannouncement.SysAnnouncementVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementController
 * @Description: 利率因子rpc
 * @date 2018-04-27
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysAnnouncementRpc {

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param sysAnnouncementVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "api/system/sys_announcement/findSysAnnouncementsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysAnnouncementsByPage(@RequestParam Map<String, Object> sysAnnouncementVoMap);

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param sysAnnouncementVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "api/system/sys_announcement/saveSysAnnouncement",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysAnnouncement(@RequestBody SysAnnouncementVo sysAnnouncementVo);

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param sysAnnouncementVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "api/system/sys_announcement/modifySysAnnouncement",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysAnnouncement(@RequestBody SysAnnouncementVo sysAnnouncementVo);

    /**
     * @Title:
     * @Description:   根据announceId集合删除利率因子
     * @param sysAnnouncementVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "api/system/sys_announcement/deleteSysAnnouncementsByAnnounceIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysAnnouncementsByAnnounceIds(@RequestBody SysAnnouncementVo sysAnnouncementVo);

    /**
     * @Title:
     * @Description:  根据announceId获取利率因子
     * @param announceId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @RequestMapping(value = "api/system/sys_announcement/findSysAnnouncementByAnnounceId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysAnnouncementByAnnounceId(@RequestParam("announceId") String announceId);

}
