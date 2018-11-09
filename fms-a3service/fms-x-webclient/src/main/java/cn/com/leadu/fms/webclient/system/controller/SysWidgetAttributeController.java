package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeVo;
import cn.com.leadu.fms.webclient.system.rpc.SysWidgetAttributeRpc;
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
 * @author wangxue
 * @ClassName: SysWidgetAttributeController
 * @Description: 项目权限管理controller
 * @date 2018-03-09
 */
@RestController
@RequestMapping("sys_widget_attribute")
public class SysWidgetAttributeController {

    @Autowired
    private SysWidgetAttributeRpc sysWidgetAttributeRpc;

    /**
     * @Title:
     * @Description: 根据画面标识ID，分页查询项目权限vo
     * @param sysWidgetAttributeVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "findSysWidgetAttributeVoByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysWidgetAttributeVoByPage(SysWidgetAttributeVo sysWidgetAttributeVo){
        Map sysWidgetAttributeVoMap = sysWidgetAttributeVo == null?null:(Map) JSON.toJSON(sysWidgetAttributeVo);
        return sysWidgetAttributeRpc.findSysWidgetAttributeVoByPage(sysWidgetAttributeVoMap);
    }

    /**
     * @Title:
     * @Description: 保存项目权限管理
     * @param sysWidgetAttributeVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "saveSysWidgetAttribute",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysWidgetAttribute(@RequestBody SysWidgetAttributeVo sysWidgetAttributeVo){
        return sysWidgetAttributeRpc.saveSysWidgetAttribute(sysWidgetAttributeVo);
    }

    /**
     * @Title:
     * @Description:  修改项目权限管理
     * @param sysWidgetAttributeVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "modifySysWidgetAttribute",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysWidgetAttribute(@RequestBody SysWidgetAttributeVo sysWidgetAttributeVo){
        return sysWidgetAttributeRpc.modifySysWidgetAttribute(sysWidgetAttributeVo);
    }

    /**
     * @Title:
     * @Description:  根据widgetConId获取项目权限管理
     * @param widgetConId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "findSysWidgetAttributeByWidgetConId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysWidgetAttributeByWidgetConId(String widgetConId){
        return sysWidgetAttributeRpc.findSysWidgetAttributeByWidgetConId(widgetConId);
    }

    /**
     * @Title:
     * @Description:   根据widgetConId集合删除项目权限管理
     * @param widgetConIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "deleteSysWidgetAttributeByWidgetConIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysWidgetAttributeByWidgetConIds(@RequestBody List<String> widgetConIds){
        SysWidgetAttributeVo sysWidgetAttributeVo = new SysWidgetAttributeVo();
        sysWidgetAttributeVo.setWidgetConIds(widgetConIds);
        return sysWidgetAttributeRpc.deleteSysWidgetAttributeByWidgetConIds(sysWidgetAttributeVo);
    }

    /**
     * @Title:
     * @Description:   查出所有项目权限数据并以树的形式返回
     * @param
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "findSysWidgetAttributeVoByTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysWidgetAttributeVoByTree(){
        return sysWidgetAttributeRpc.findSysWidgetAttributeVoByTree();
    }

    /**
     * @Title:
     * @Description:  重置redis中保存的画面项目权限
     * @param
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 13:37:18
     */
    @RequestMapping(value = "resetSysWidgetAttributeVoByTreeToRedis", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> resetSysWidgetAttributeVoByTreeToRedis(){
        return sysWidgetAttributeRpc.resetSysWidgetAttributeVoByTreeToRedis();
    }

}
