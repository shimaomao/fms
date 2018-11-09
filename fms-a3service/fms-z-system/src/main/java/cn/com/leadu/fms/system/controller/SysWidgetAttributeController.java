package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeVo;
import cn.com.leadu.fms.system.service.SysWidgetAttributeService;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeDeleteListVo;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeModifyVo;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeController
 * @Description: 项目权限管理相关接口
 * @date 2018-03-09
 */
@RestController
@RequestMapping("sys_widget_attribute")
public class SysWidgetAttributeController {

    @Autowired
    private SysWidgetAttributeService sysWidgetAttributeService;

    /**
     * @Title:
     * @Description: 根据画面标识ID，分页查询项目权限vo
     * @param sysWidgetAttributeVo
     * @return PageInfoExtend<SysWidgetAttribute>
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @RequestMapping(value = "findSysWidgetAttributeVoByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysWidgetAttributeVoByPage(SysWidgetAttributeVo sysWidgetAttributeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysWidgetAttributeService.findSysWidgetAttributeVoByPage(sysWidgetAttributeVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存项目权限管理
     * @param sysWidgetAttributeSaveVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    @RequestMapping(value = "saveSysWidgetAttribute",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysWidgetAttribute(@Valid @RequestBody SysWidgetAttributeSaveVo sysWidgetAttributeSaveVo){
        return sysWidgetAttributeService.saveSysWidgetAttribute(sysWidgetAttributeSaveVo);
    }

    /**
     * @Title:
     * @Description:  修改项目权限管理
     * @param sysWidgetAttributeModifyVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    @RequestMapping(value = "modifySysWidgetAttribute",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysWidgetAttribute(@Valid @RequestBody SysWidgetAttributeModifyVo sysWidgetAttributeModifyVo){
        sysWidgetAttributeService.modifySysWidgetAttribute(sysWidgetAttributeModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据widgetConId集合删除项目权限管理
     * @param sysWidgetAttributeDeleteListVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    @RequestMapping(value = "deleteSysWidgetAttributeByWidgetConIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysWidgetAttributeByWidgetConIds(@Valid @RequestBody SysWidgetAttributeDeleteListVo sysWidgetAttributeDeleteListVo){
        sysWidgetAttributeService.deleteSysWidgetAttributeByWidgetConIds(sysWidgetAttributeDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据widgetConId获取项目权限管理
     * @param widgetConId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    @RequestMapping(value = "findSysWidgetAttributeByWidgetConId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysWidgetAttributeByWidgetConId(String widgetConId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysWidgetAttributeService.findSysWidgetAttributeByWidgetConId(widgetConId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   查出所有项目权限数据并以树的形式返回
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    @RequestMapping(value = "findSysWidgetAttributeVoByTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysWidgetAttributeVoByTree(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysWidgetAttributeService.findSysWidgetAttributeVoByTree()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysWidgetAttributeService.resetSysWidgetAttributeVoByTreeToRedis()), HttpStatus.OK);
    }

}
