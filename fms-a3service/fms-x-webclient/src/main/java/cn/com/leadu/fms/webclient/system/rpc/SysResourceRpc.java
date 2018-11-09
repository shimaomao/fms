package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysresource.SysResourceVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceRpc
 * @Description:
 * @date 2018/1/14
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysResourceRpc {

    /**
     * @Title:
     * @Description: 根据当前登录用户返回用户的菜单
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:48:19
     */
    @RequestMapping(value = "api/system/sys_resource/findSysResourceByUser",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysResourceByUser();

    /**
     * @Title:
     * @Description:  查询所有菜单列表, 根据sort资源排序
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 03:58:27
     */
    @RequestMapping(value = "api/system/sys_resource/findSysResourceAll",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysResourceAll();


    /**
     * @Title:
     * @Description: 分页查询菜单信息
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "api/system/sys_resource/findSysResourceByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysResourceByPage(@RequestParam Map<String,Object> sysResourceVo);

    /**
     * @Title:
     * @Description: 根据角色id获取角色拥有的资源
     * @param sysRoleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "api/system/sys_resource/findSysResourceBySysRoleId" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysResourceBySysRoleId(@RequestParam("sysRoleId") String sysRoleId);



    /**
     * @Title:
     * @Description: 保存菜单资源
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:42:12
     */
    @RequestMapping(value = "api/system/sys_resource/saveSysResource",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysResource(@RequestBody SysResourceVo sysResourceVo);


    /**
     * @Title:
     * @Description:  修改菜单资源
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value = "api/system/sys_resource/modifySysResource",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysResource(@RequestBody SysResourceVo sysResourceVo);

    /**
     * @Title:
     * @Description:  删除菜单资源
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "api/system/sys_resource/deleteSysResource",method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysResource(@RequestParam("id") String id);


    /**
     * @Title:
     * @Description:   根据id集合删除菜单资源
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "api/system/sys_resource/deleteSysResourceByIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysResourceByIds(@RequestBody SysResourceVo sysResourceVo);

    /**
     * @Title:
     * @Description:  根据id获取菜单资源
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "api/system/sys_resource/findSysResourceById", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysResourceById(@RequestParam("id") String id);


    /**
     * @Title:
     * @Description:  获取类型是父角色的资源菜单
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/18 10:24:47
     */
    @RequestMapping(value = "api/system/sys_resource/findSysResourceIsParent", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysResourceIsParent(@RequestParam("resLevel") Integer resLevel);

}
