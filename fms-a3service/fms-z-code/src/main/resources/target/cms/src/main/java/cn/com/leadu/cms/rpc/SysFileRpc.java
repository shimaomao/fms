package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysfile.SysFileVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysFileController
 * @Description: 菜单rpc
 * @date 2018-03-05
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysFileRpc {

    /**
     * @Title:
     * @Description: 分页查询菜单信息
     * @param sysFileVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "api/system/sys_file/findSysFileByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysFileByPage(@RequestParam Map<String,Object> sysFileVoMap);

    /**
     * @Title:
     * @Description: 保存菜单
     * @param sysFileVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "api/system/sys_file/saveSysFile",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysFile(@RequestBody SysFileVo sysFileVo);

    /**
     * @Title:
     * @Description:  修改菜单
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "api/system/sys_file/modifySysFile",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysFile(@RequestBody SysFileVo sysFileVo);

    /**
     * @Title:
     * @Description:  根据id获取菜单
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "api/system/sys_file/findSysFileById", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysFileById(@RequestParam("id") String id);

    /**
     * @Title:
     * @Description:   根据id集合删除菜单
     * @param ids
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "api/system/sys_organization_property/deleteSysFileByIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysFileByIds(@RequestBody SysFileVo sysFileVo);

}
