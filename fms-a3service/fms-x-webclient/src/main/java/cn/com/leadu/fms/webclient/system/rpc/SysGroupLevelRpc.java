package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysgrouplevel.SysGroupLevelVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysGroupLevelController
 * @Description: 用户组层级rpc
 * @date 2018-03-08
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysGroupLevelRpc {

    /**
     * @Title:
     * @Description: 分页查询用户组层级信息
     * @param sysGroupLevelVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "api/system/sys_group_level/findSysGroupLevelsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysGroupLevelsByPage(@RequestParam Map<String, Object> sysGroupLevelVoMap);

    /**
     * @Title:
     * @Description: 保存用户组层级
     * @param sysGroupLevelVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "api/system/sys_group_level/saveSysGroupLevel",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysGroupLevel(@RequestBody SysGroupLevelVo sysGroupLevelVo);

    /**
     * @Title:
     * @Description:  修改用户组层级
     * @param sysGroupLevelVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "api/system/sys_group_level/modifySysGroupLevel",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysGroupLevel(@RequestBody SysGroupLevelVo sysGroupLevelVo);

    /**
     * @Title:
     * @Description:  根据层级id，获取用户组层级
     * @param groupLevId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "api/system/sys_group_level/findSysGroupLevelById", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysGroupLevelById(@RequestParam("groupLevId") String groupLevId);

    /**
     * @Title:
     * @Description:   根据层级id集合，删除用户组层级
     * @param sysGroupLevelVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "api/system/sys_group_level/deleteSysGroupLevelsByIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysGroupLevelsByIds(@RequestBody SysGroupLevelVo sysGroupLevelVo);

}
