package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.vo.sysrole.SysRoleVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleController
 * @Description: 角色相关接口
 * @date 2018/1/12
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysRoleRpc {

    /**
     * @Title:
     * @Description: 分页查询角色信息
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "api/system/sys_role/findSysRolesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysRolesByPage(@RequestParam Map<String,Object> sysRoleVo);

    /**
     * @Title:
     * @Description: 保存角色
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:42:12
     */
    @RequestMapping(value = "api/system/sys_role/saveSysRole",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysRole(@RequestBody SysRoleVo sysRoleVo);

    /**
     * @Title:
     * @Description:  修改角色
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value = "api/system/sys_role/modifySysRole",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysRole(@RequestBody SysRoleVo sysRoleVo);

    /**
     * @Title:
     * @Description:  删除角色
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "api/system/sys_role/deleteSysRole",method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysRole(@RequestParam("roleId") String id);

    /**
     * @Title:
     * @Description:  根据id获取角色
     * @param roleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "api/system/sys_role/findSysRoleById", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysRoleById(@RequestParam("roleId") String roleId);

    /**
     * @Title:
     * @Description:   根据id集合删除角色
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "api/system/sys_role/deleteSysRolesByIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysRolesByIds(@RequestBody SysRoleVo sysRoleVo);

    /**
     * 找到所有的角色
     */
    @RequestMapping(value = "api/system/sys_role/findAllRoles",method = RequestMethod.POST)
    List<SysRole> findAllRoles();

    /**
     * 找某角色对应的应该显示的审批情况集合
     */
    @RequestMapping(value = "api/system/sys_role/findApproveInfo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApproveInfo(@RequestParam(value = "searchType") String searchType);
}
