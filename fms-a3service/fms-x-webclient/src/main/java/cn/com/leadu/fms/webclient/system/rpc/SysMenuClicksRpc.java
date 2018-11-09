package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysmenuclicks.SysMenuClicksVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksController
 * @Description: 利率因子rpc
 * @date 2018-05-03
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysMenuClicksRpc {

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param sysMenuClicksVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "api/system/sys_menu_clicks/findSysMenuClickssByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysMenuClickssByPage(@RequestParam Map<String, Object> sysMenuClicksVoMap);

    /**
     * @Title:
     * @Description: 根据用户获取常用菜单List
     * @param sysMenuClicksVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "api/system/sys_menu_clicks/findSysMenuClicksByUser" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysMenuClicksByUser(@RequestParam Map<String, Object> sysMenuClicksVoMap);

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "api/system/sys_menu_clicks/saveSysMenuClicks",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysMenuClicks(@RequestBody SysMenuClicksVo sysMenuClicksVo);

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "api/system/sys_menu_clicks/modifySysMenuClicks",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysMenuClicks(@RequestBody SysMenuClicksVo sysMenuClicksVo);

    /**
     * @Title:
     * @Description:   根据menuClicksId集合删除利率因子
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "api/system/sys_menu_clicks/deleteSysMenuClickssByMenuClicksIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysMenuClickssByMenuClicksIds(@RequestBody SysMenuClicksVo sysMenuClicksVo);

    /**
     * @Title:
     * @Description:  根据menuClicksId获取利率因子
     * @param menuClicksId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "api/system/sys_menu_clicks/findSysMenuClicksByMenuClicksId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysMenuClicksByMenuClicksId(@RequestParam("menuClicksId") String menuClicksId);

}
