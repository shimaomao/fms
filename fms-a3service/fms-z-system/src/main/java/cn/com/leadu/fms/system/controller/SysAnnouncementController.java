package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysannouncement.SysAnnouncementVo;
import cn.com.leadu.fms.system.service.SysAnnouncementService;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementDeleteListVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementDeleteVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementModifyVo;
import cn.com.leadu.fms.system.validator.sysannouncement.vo.SysAnnouncementSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementController
 * @Description: 利率因子相关接口
 * @date 2018-04-27
 */
@RestController
@RequestMapping("sys_announcement")
public class SysAnnouncementController {

    /**
     * @Fields  : 利率因子service
     */
    @Autowired
    private SysAnnouncementService sysAnnouncementService;

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param sysAnnouncementVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:36
     */
    @RequestMapping(value = "findSysAnnouncementsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysAnnouncementsByPage(SysAnnouncementVo sysAnnouncementVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysAnnouncementService.findSysAnnouncementsByPage(sysAnnouncementVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param sysAnnouncementSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:36
     */
    @RequestMapping(value = "saveSysAnnouncement",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysAnnouncement(@Valid @RequestBody SysAnnouncementSaveVo sysAnnouncementSaveVo){
        sysAnnouncementService.saveSysAnnouncement(sysAnnouncementSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param sysAnnouncementModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:36
     */
    @RequestMapping(value = "modifySysAnnouncement",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysAnnouncement(@Valid @RequestBody SysAnnouncementModifyVo sysAnnouncementModifyVo){
        sysAnnouncementService.modifySysAnnouncement(sysAnnouncementModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除利率因子
     * @param sysAnnouncementDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:36
     */
    @RequestMapping(value = "deleteSysAnnouncement",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysAnnouncement(@Valid @RequestBody SysAnnouncementDeleteVo sysAnnouncementDeleteVo){
        sysAnnouncementService.deleteSysAnnouncement(sysAnnouncementDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据announceId集合删除利率因子
     * @param sysAnnouncementDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:36
     */
    @RequestMapping(value = "deleteSysAnnouncementsByAnnounceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysAnnouncementsByAnnounceIds(@Valid @RequestBody SysAnnouncementDeleteListVo sysAnnouncementDeleteListVo){
        sysAnnouncementService.deleteSysAnnouncementsByAnnounceIds(sysAnnouncementDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据announceId获取利率因子
     * @param announceId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:36
     */
    @RequestMapping(value = "findSysAnnouncementByAnnounceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysAnnouncementByAnnounceId(String announceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysAnnouncementService.findSysAnnouncementByAnnounceId(announceId)), HttpStatus.OK);
    }

}
