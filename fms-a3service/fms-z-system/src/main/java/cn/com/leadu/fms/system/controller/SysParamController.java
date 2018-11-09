package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysparam.SysParamVo;
import cn.com.leadu.fms.system.service.SysParamService;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamDeleteListVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamDeleteVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamModifyVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yanfengbo
 * @ClassName: SysParamController
 * @Description: 系统常量表相关接口
 * @date 2018-03-09
 */
@RestController
@RequestMapping("sys_param")
public class SysParamController {

    @Autowired
    private SysParamService sysParamService;

    /**
     * @Title:
     * @Description: 分页查询系统常量表信息
     * @param sysParamVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "findSysParamByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamByPage(SysParamVo sysParamVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysParamService.findSysParamByPage(sysParamVo)),
                HttpStatus.OK);

    }

    /**
     * @Title:
     * @Description: 保存系统常量表
     * @param sysParamSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "saveSysParam",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysParam(@Valid @RequestBody SysParamSaveVo sysParamSaveVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                sysParamService.saveSysParam(sysParamSaveVo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改系统常量表
     * @param sysParamModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "modifySysParam",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysParam(@Valid @RequestBody SysParamModifyVo sysParamModifyVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                sysParamService.modifySysParam(sysParamModifyVo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除系统常量表
     * @param sysParamDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "deleteSysParam",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysParam(@Valid @RequestBody SysParamDeleteVo sysParamDeleteVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                sysParamService.deleteSysParam(sysParamDeleteVo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据paramKeyId集合删除系统常量表
     * @param sysParamDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "deleteSysParamByParamKeyIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysParamByParamKeyIds(@Valid @RequestBody SysParamDeleteListVo sysParamDeleteListVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                sysParamService.deleteSysParamByParamKeyIds(sysParamDeleteListVo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据paramKeyId获取系统常量表
     * @param paramKeyId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "findSysParamByParamKeyId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamByParamKeyId(String paramKeyId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysParamService.findSysParamByParamKeyId(paramKeyId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据paramKey获取系统常量值
     * @param paramKey
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "findParamValueByParamKey", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamByParamKey(String paramKey){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysParamService.findParamValueByParamKey(paramKey)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   初始化系统常量值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:19:43
     */
    @RequestMapping(value = "initSysParamsValue", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> initSysParamsValue(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                sysParamService.initSysParamsValue()
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   获取系统常量
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:31:03
     */
    @RequestMapping(value = "findSysParamsValue", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamsValue(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                sysParamService.findSysParamsValue()
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   返回常量版本值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:49:12
     */
    @RequestMapping(value = "findSysParamsValueVersion", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamsValueVersion(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                sysParamService.findSysParamsValueVersion()
        ), HttpStatus.OK);
    }

}
