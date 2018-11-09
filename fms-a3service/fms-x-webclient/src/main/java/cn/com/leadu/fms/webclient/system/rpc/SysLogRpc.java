package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.syslog.SysLogVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: SysLogController
 * @Description: 日志管理rpc
 * @date 2018-04-10
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysLogRpc {

    /**
     * @Title:
     * @Description: 分页查询日志管理信息
     * @param sysLogVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
    @RequestMapping(value = "api/system/sys_log/findSysLogsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysLogsByPage(@RequestParam Map<String, Object> sysLogVoMap);

    /**
     * @Title:
     * @Description: 保存日志管理
     * @param sysLogVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
  /*  @RequestMapping(value = "api/system/sys_log/saveSysLog",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysLog(@RequestBody SysLogVo sysLogVo);*/

    /**
     * @Title:
     * @Description:  修改日志管理
     * @param sysLogVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
   /* @RequestMapping(value = "api/system/sys_log/modifySysLog",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysLog(@RequestBody SysLogVo sysLogVo);*/

    /**
     * @Title:
     * @Description:   根据logId集合删除日志管理
     * @param sysLogVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
  /*  @RequestMapping(value = "api/system/sys_log/deleteSysLogsByLogIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysLogsByLogIds(@RequestBody SysLogVo sysLogVo);*/

    /**
     * @Title:
     * @Description:  根据logId获取日志管理
     * @param logId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
    @RequestMapping(value = "api/system/sys_log/findSysLogByLogId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysLogByLogId(@RequestParam("logId") String logId);

}
