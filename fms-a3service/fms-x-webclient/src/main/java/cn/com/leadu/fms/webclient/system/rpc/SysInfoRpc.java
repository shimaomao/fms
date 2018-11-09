package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysinfo.SysInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysInfoController
 * @Description: 消息管理rpc
 * @date 2018-04-25
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysInfoRpc {

    /**
     * @Title:
     * @Description: 分页查询消息管理信息
     * @param sysInfoVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "api/system/sys_info/findSysInfosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysInfosByPage(@RequestParam Map<String, Object> sysInfoVoMap);

    /**
     * @Title:
     * @Description: 保存消息管理
     * @param sysInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "api/system/sys_info/saveSysInfo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysInfo(@RequestBody SysInfoVo sysInfoVo);

    /**
     * @Title:
     * @Description:  修改消息管理
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "api/system/sys_info/modifySysInfo",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysInfo(@RequestBody SysInfoVo sysInfoVo);

    /**
     * @Title:
     * @Description:   根据infoId集合删除消息管理
     * @param infoIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "api/system/sys_info/deleteSysInfosByInfoIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysInfosByInfoIds(@RequestBody SysInfoVo sysInfoVo);

    /**
     * @Title:
     * @Description:  根据infoId获取消息管理
     * @param infoId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "api/system/sys_info/findSysInfoByInfoId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysInfoByInfoId(@RequestParam("infoId") String infoId);

}
