package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.syslog.SysLogVo;
import cn.com.leadu.fms.webclient.system.rpc.SysLogRpc;
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
 * @author yanfengbo
 * @ClassName: SysLogController
 * @Description: 日志管理controller
 * @date 2018-04-10
 */
@RestController
@RequestMapping("sys_log")
public class SysLogController {

    /**
     * @Fields  : 日志管理rpc
     */
    @Autowired
    private SysLogRpc sysLogRpc;

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
        Map sysLogVoMap = sysLogVo == null?null:(Map) JSON.toJSON(sysLogVo);
        return sysLogRpc.findSysLogsByPage(sysLogVoMap);
    }

    /**
     * @Title:
     * @Description: 保存日志管理
     * @param sysLogVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
  /*  @RequestMapping(value = "saveSysLog",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysLog(@RequestBody SysLogVo sysLogVo){
        return sysLogRpc.saveSysLog(sysLogVo);
    }*/

    /**
     * @Title:
     * @Description:  修改日志管理
     * @param sysLogVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
  /*  @RequestMapping(value = "modifySysLog",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysLog(@RequestBody SysLogVo sysLogVo){
        return sysLogRpc.modifySysLog(sysLogVo);
    }*/

    /**
     * @Title:
     * @Description:   根据logId集合删除日志管理
     * @param logIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-4-10 10:11:17
     */
  /*  @RequestMapping(value = "deleteSysLogsByLogIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysLogsByLogIds(@RequestBody List<String> logIds){
        SysLogVo sysLogVo = new SysLogVo();
        sysLogVo.setLogIds(logIds);
        return sysLogRpc.deleteSysLogsByLogIds(sysLogVo);
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
        return sysLogRpc.findSysLogByLogId(logId);
    }

}
