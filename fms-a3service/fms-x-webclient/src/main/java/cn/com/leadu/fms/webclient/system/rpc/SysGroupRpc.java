package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysGroupController
 * @Description: 用户组管理rpc
 * @date 2018-03-10
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysGroupRpc {

    /**
     * @Title:
     * @Description: 分页查询用户组管理信息
     * @param sysGroupVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "api/system/sys_group/findSysGroupVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysGroupVosByPage(@RequestParam Map<String, Object> sysGroupVoMap);

    /**
     * @Title:
     * @Description: 分页查询用户组管理信息
     * @param sysGroupVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "api/system/sys_group/findSysGroupVoListByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysGroupVoListByPage(@RequestParam Map<String, Object> sysGroupVoMap);

    /**
     * @Title:
     * @Description: 保存用户组管理
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "api/system/sys_group/saveSysGroup",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysGroup(@RequestBody SysGroupVo sysGroupVo);

    /**
     * @Title:
     * @Description:  修改用户组管理
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "api/system/sys_group/modifySysGroup",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysGroup(@RequestBody SysGroupVo sysGroupVo);

    /**
     * @Title:
     * @Description:   根据groupId集合删除用户组管理
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "api/system/sys_group/deleteSysGroupsByGroupIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysGroupsByGroupIds(@RequestBody SysGroupVo sysGroupVo);

    /**
     * @Title:
     * @Description:  根据groupId获取用户组管理
     * @param groupId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "api/system/sys_group/findSysGroupVoByGroupId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysGroupVoByGroupId(@RequestParam("groupId") String groupId);

    /**
     * @Title:
     * @Description:  查询用户组信息树
     * @param parentType
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "api/system/sys_group/findSysGroupByTree", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysGroupByTree(@RequestParam("parentType")String parentType, @RequestParam("groupCode")String groupCode);

    /**
     * @Title:
     * @Description:  根据groupCode查询
     * @param groupCode
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "api/system/sys_group/selectSysGroupVoByGroupCode", method = RequestMethod.GET)
    ResponseEntity<RestResponse> selectSysGroupVoByGroupCode(@RequestParam("groupCode") String groupCode);

}
