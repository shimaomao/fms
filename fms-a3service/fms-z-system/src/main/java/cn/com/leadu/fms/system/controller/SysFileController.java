package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysfile.SysFileVo;
import cn.com.leadu.fms.system.service.SysFileService;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileDeleteListVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileDeleteVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileModifyVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileSaveVo;
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
 * @ClassName: SysFileController
 * @Description: 菜单相关接口
 * @date 2018-03-01
 */
@RestController
@RequestMapping("sys_file")
public class SysFileController {

    @Autowired
    private SysFileService sysFileService;

    /**
     * @Title:
     * @Description: 分页查询菜单信息
     * @param sysFileVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-1 18:14:37
     */
    @RequestMapping(value = "findSysFileByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysFileByPage(SysFileVo sysFileVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysFileService.findSysFileByPage(sysFileVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存菜单
     * @param sysFileSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-1 18:14:37
     */
    @RequestMapping(value = "saveSysFile",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysFile(@Valid @RequestBody SysFileSaveVo sysFileSaveVo){
        sysFileService.saveSysFile(sysFileSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改菜单
     * @param sysFileModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-1 18:14:37
     */
    @RequestMapping(value = "modifySysFile",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysFile(@Valid @RequestBody SysFileModifyVo sysFileModifyVo){
        sysFileService.modifySysFile(sysFileModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除菜单
     * @param sysFileDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-1 18:14:37
     */
    @RequestMapping(value = "deleteSysFile",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysFile(@Valid @RequestBody SysFileDeleteVo sysFileDeleteVo){
        sysFileService.deleteSysFile(sysFileDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除菜单
     * @param sysFileDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-1 18:14:37
     */
    @RequestMapping(value = "deleteSysFileByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysFileByIds(@Valid @RequestBody SysFileDeleteListVo sysFileDeleteListVo){
        sysFileService.deleteSysFileByIds(sysFileDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据id获取菜单
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-1 18:14:37
     */
    @RequestMapping(value = "findSysFileById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysFileById(String id){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysFileService.findSysFileById(id)), HttpStatus.OK);
    }

}
