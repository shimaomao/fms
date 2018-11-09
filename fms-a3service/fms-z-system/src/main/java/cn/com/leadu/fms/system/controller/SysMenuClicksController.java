package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysmenuclicks.SysMenuClicksVo;
import cn.com.leadu.fms.system.service.SysMenuClicksService;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksDeleteListVo;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksDeleteVo;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksModifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksController
 * @Description: 利率因子相关接口
 * @date 2018-05-03
 */
@RestController
@RequestMapping("sys_menu_clicks")
public class SysMenuClicksController {

    /**
     * @Fields  : 利率因子service
     */
    @Autowired
    private SysMenuClicksService sysMenuClicksService;

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:16
     */
    @RequestMapping(value = "findSysMenuClickssByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenuClickssByPage(SysMenuClicksVo sysMenuClicksVo, @AuthUserInfo SysUser sysUser){
        sysMenuClicksVo.setUser(sysUser.getUser());
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysMenuClicksService.findSysMenuClickssByPage(sysMenuClicksVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据用户获取主页常用菜单List
     * @param sysMenuClicksVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:16
     */
    @RequestMapping(value = "findSysMenuClicksByUser" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenuClicksByUser(SysMenuClicksVo sysMenuClicksVo, @AuthUserInfo SysUser sysUser){
        sysMenuClicksVo.setUser(sysUser.getUser());
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysMenuClicksService.findSysMenuClicksByUser(sysMenuClicksVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:16
     */
    @RequestMapping(value = "saveSysMenuClicks",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysMenuClicks(@Valid @RequestBody SysMenuClicksVo sysMenuClicksVo, @AuthUserInfo SysUser sysUser){
        sysMenuClicksVo.setUser(sysUser.getUser());
        sysMenuClicksService.saveSysMenuClicks(sysMenuClicksVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param sysMenuClicksModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:16
     */
    @RequestMapping(value = "modifySysMenuClicks",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysMenuClicks(@Valid @RequestBody SysMenuClicksModifyVo sysMenuClicksModifyVo){
        sysMenuClicksService.modifySysMenuClicks(sysMenuClicksModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除利率因子
     * @param sysMenuClicksDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:16
     */
    @RequestMapping(value = "deleteSysMenuClicks",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysMenuClicks(@Valid @RequestBody SysMenuClicksDeleteVo sysMenuClicksDeleteVo){
        sysMenuClicksService.deleteSysMenuClicks(sysMenuClicksDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据menuClicksId集合删除利率因子
     * @param sysMenuClicksDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:16
     */
    @RequestMapping(value = "deleteSysMenuClickssByMenuClicksIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysMenuClickssByMenuClicksIds(@Valid @RequestBody SysMenuClicksDeleteListVo sysMenuClicksDeleteListVo){
        sysMenuClicksService.deleteSysMenuClickssByMenuClicksIds(sysMenuClicksDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据menuClicksId获取利率因子
     * @param menuClicksId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:16
     */
    @RequestMapping(value = "findSysMenuClicksByMenuClicksId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenuClicksByMenuClicksId(String menuClicksId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysMenuClicksService.findSysMenuClicksByMenuClicksId(menuClicksId)), HttpStatus.OK);
    }

}
