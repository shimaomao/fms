package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeController
 * @Description: 项目权限管理rpc
 * @date 2018-03-09
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysWidgetAttributeRpc {

    /**
     * @Title:
     * @Description: 根据画面标识ID，分页查询项目权限vo
     * @param sysWidgetAttributeVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "api/system/sys_widget_attribute/findSysWidgetAttributeVoByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysWidgetAttributeVoByPage(@RequestParam Map<String, Object> sysWidgetAttributeVoMap);

    /**
     * @Title:
     * @Description: 保存项目权限管理
     * @param sysWidgetAttributeVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "api/system/sys_widget_attribute/saveSysWidgetAttribute",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysWidgetAttribute(@RequestBody SysWidgetAttributeVo sysWidgetAttributeVo);

    /**
     * @Title:
     * @Description:  修改项目权限管理
     * @param sysWidgetAttributeVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "api/system/sys_widget_attribute/modifySysWidgetAttribute",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysWidgetAttribute(@RequestBody SysWidgetAttributeVo sysWidgetAttributeVo);

    /**
     * @Title:
     * @Description:  根据widgetConId获取项目权限管理
     * @param widgetConId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "api/system/sys_widget_attribute/findSysWidgetAttributeByWidgetConId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysWidgetAttributeByWidgetConId(@RequestParam("widgetConId") String widgetConId);

    /**
     * @Title:
     * @Description:   根据widgetConId集合删除项目权限管理
     * @param sysWidgetAttributeVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "api/system/sys_widget_attribute/deleteSysWidgetAttributeByWidgetConIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysWidgetAttributeByWidgetConIds(@RequestBody SysWidgetAttributeVo sysWidgetAttributeVo);

    /**
     * @Title:
     * @Description:  查出所有项目权限数据并以树的形式返回
     * @param
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "api/system/sys_widget_attribute/findSysWidgetAttributeVoByTree" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysWidgetAttributeVoByTree();

    /**
     * @Title:
     * @Description:  重置redis中保存的画面项目权限
     * @param
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 13:37:18
     */
    @RequestMapping(value = "api/system/sys_widget_attribute/resetSysWidgetAttributeVoByTreeToRedis" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> resetSysWidgetAttributeVoByTreeToRedis();

}
