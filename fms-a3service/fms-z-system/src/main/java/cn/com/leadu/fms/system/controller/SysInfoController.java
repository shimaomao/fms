package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysinfo.SysInfoVo;
import cn.com.leadu.fms.system.service.SysInfoService;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoDeleteListVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoDeleteVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoModifyVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoSaveVo;
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
 * @ClassName: SysInfoController
 * @Description: 消息管理相关接口
 * @date 2018-04-25
 */
@RestController
@RequestMapping("sys_info")
public class SysInfoController {

    /**
     * @Fields  : 消息管理service
     */
    @Autowired
    private SysInfoService sysInfoService;

    /**
     * @Title:
     * @Description: 分页查询消息管理信息
     * @param sysInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "findSysInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysInfosByPage(SysInfoVo sysInfoVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysInfoService.findSysInfosByPage(sysInfoVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存消息管理
     * @param sysInfoSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "saveSysInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysInfo(@Valid @RequestBody SysInfoSaveVo sysInfoSaveVo){
        sysInfoService.saveSysInfo(sysInfoSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改消息管理
     * @param sysInfoModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "modifySysInfo",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysInfo(@Valid @RequestBody SysInfoModifyVo sysInfoModifyVo){
        sysInfoService.modifySysInfo(sysInfoModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除消息管理
     * @param sysInfoDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "deleteSysInfo",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysInfo(@Valid @RequestBody SysInfoDeleteVo sysInfoDeleteVo){
        sysInfoService.deleteSysInfo(sysInfoDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据infoId集合删除消息管理
     * @param sysInfoDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "deleteSysInfosByInfoIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysInfosByInfoIds(@Valid @RequestBody SysInfoDeleteListVo sysInfoDeleteListVo){
        sysInfoService.deleteSysInfosByInfoIds(sysInfoDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据infoId获取消息管理
     * @param infoId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "findSysInfoByInfoId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysInfoByInfoId(String infoId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysInfoService.findSysInfoByInfoId(infoId)), HttpStatus.OK);
    }

}
