package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuserinfo.SysUserInfoVo;
import cn.com.leadu.fms.system.service.SysUserInfoService;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoDeleteListVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoDeleteVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoModifyVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoController
 * @Description: 消息用户操作管理相关接口
 * @date 2018-04-25
 */
@RestController
@RequestMapping("sys_user_info")
public class SysUserInfoController {

    /**
     * @Fields  : 消息用户操作管理service
     */
    @Autowired
    private SysUserInfoService sysUserInfoService;

    /**
     * @Title:
     * @Description: 分页查询消息用户操作管理信息
     * @param sysUserInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "findSysUserInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserInfosByPage(SysUserInfoVo sysUserInfoVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysUserInfoService.findSysUserInfosByPage(sysUserInfoVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存消息用户操作管理
     * @param sysUserInfoSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "saveSysUserInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysUserInfo(@Valid @RequestBody SysUserInfoSaveVo sysUserInfoSaveVo){
        sysUserInfoService.saveSysUserInfo(sysUserInfoSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改消息用户操作管理
     * @param sysUserInfoModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "modifySysUserInfo",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysUserInfo(@Valid @RequestBody SysUserInfoModifyVo sysUserInfoModifyVo){
        sysUserInfoService.modifySysUserInfo(sysUserInfoModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除消息用户操作管理
     * @param sysUserInfoDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "deleteSysUserInfo",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUserInfo(@Valid @RequestBody SysUserInfoDeleteVo sysUserInfoDeleteVo){
        sysUserInfoService.deleteSysUserInfo(sysUserInfoDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据userInfoId集合删除消息用户操作管理
     * @param sysUserInfoDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "deleteSysUserInfosByUserInfoIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUserInfosByUserInfoIds(@Valid @RequestBody SysUserInfoDeleteListVo sysUserInfoDeleteListVo){
        sysUserInfoService.deleteSysUserInfosByUserInfoIds(sysUserInfoDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据userInfoId获取消息用户操作管理
     * @param userInfoId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "findSysUserInfoByUserInfoId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserInfoByUserInfoId(String userInfoId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserInfoService.findSysUserInfoByUserInfoId(userInfoId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询当前自己的消息
     * @param: sysUserInfoVo
     * @param: sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/25 0025 14:51
     */
    @RequestMapping(value = "findSysUserInfoVosByPage", method = RequestMethod.GET)
    public  ResponseEntity<RestResponse> findSysUserInfoVosByPage(SysUserInfoVo sysUserInfoVo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                sysUserInfoService.findSysUserInfoVosByPage(sysUserInfoVo,sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 确认读取消息
     * @param: sysUserInfoVo
     * @param: sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/25 14:51
     */
    @RequestMapping(value = "readSysUserInfo", method = RequestMethod.PUT)
    public  ResponseEntity<RestResponse> readSysUserInfo(@RequestBody SysUserInfoVo sysUserInfoVo){
        sysUserInfoService.readSysUserInfo(sysUserInfoVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(),
                HttpStatus.OK);
    }

}
