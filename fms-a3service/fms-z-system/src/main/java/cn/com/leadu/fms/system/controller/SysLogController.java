package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.syslog.SysLogVo;
import cn.com.leadu.fms.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanfengbo
 * @ClassName: SysLogController
 * @Description: 日志管理相关接口
 * @date 2018-04-10
 */
@RestController
@RequestMapping("sys_log")
public class SysLogController {

    /**
     * @Fields  : 日志管理service
     */
    @Autowired
    private SysLogService sysLogService;

    /**
     * @Title:
     * @Description: 分页查询日志管理信息
     * @param sysLogVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
    @RequestMapping(value = "findSysLogsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysLogsByPage(SysLogVo sysLogVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysLogService.findSysLogsByPage(sysLogVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存日志管理
     * @param sysLogSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
   /* @RequestMapping(value = "saveSysLog",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysLog(@Valid @RequestBody SysLogSaveVo sysLogSaveVo){
        sysLogService.saveSysLog(sysLogSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }*/

    /**
     * @Title:
     * @Description:  修改日志管理
     * @param sysLogModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
  /*  @RequestMapping(value = "modifySysLog",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysLog(@Valid @RequestBody SysLogModifyVo sysLogModifyVo){
        sysLogService.modifySysLog(sysLogModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }*/

    /**
     * @Title:
     * @Description:  删除日志管理
     * @param sysLogDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
   /* @RequestMapping(value = "deleteSysLog",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysLog(@Valid @RequestBody SysLogDeleteVo sysLogDeleteVo){
        sysLogService.deleteSysLog(sysLogDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }*/

    /**
     * @Title:
     * @Description:   根据logId集合删除日志管理
     * @param sysLogDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
   /* @RequestMapping(value = "deleteSysLogsByLogIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysLogsByLogIds(@Valid @RequestBody SysLogDeleteListVo sysLogDeleteListVo){
        sysLogService.deleteSysLogsByLogIds(sysLogDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }*/

    /**
     * @Title:
     * @Description:  根据logId获取日志管理
     * @param logId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
    @RequestMapping(value = "findSysLogByLogId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysLogByLogId(String logId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysLogService.findSysLogByLogId(logId)), HttpStatus.OK);
    }

}
