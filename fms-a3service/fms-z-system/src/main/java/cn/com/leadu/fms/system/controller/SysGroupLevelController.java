package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysgrouplevel.SysGroupLevelVo;
import cn.com.leadu.fms.system.service.SysGroupLevelService;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelDeleteListVo;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelModifyVo;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelSaveVo;
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
 * @ClassName: SysGroupLevelController
 * @Description: 用户组层级相关接口
 * @date 2018-03-08
 */
@RestController
@RequestMapping("sys_group_level")
public class SysGroupLevelController {

    @Autowired
    private SysGroupLevelService sysGroupLevelService;

    /**
     * @Title:
     * @Description: 根据层级代码、层级名称和启用标识，分页查询用户组层级信息
     * @param sysGroupLevelVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:06
     */
    @RequestMapping(value = "findSysGroupLevelsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupLevelsByPage(SysGroupLevelVo sysGroupLevelVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysGroupLevelService.findSysGroupLevelsByPage(sysGroupLevelVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存用户组层级
     * @param sysGroupLevelSaveVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:06
     */
    @RequestMapping(value = "saveSysGroupLevel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysGroupLevel(@Valid @RequestBody SysGroupLevelSaveVo sysGroupLevelSaveVo){
        sysGroupLevelService.saveSysGroupLevel(sysGroupLevelSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改用户组层级
     * @param sysGroupLevelModifyVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:06
     */
    @RequestMapping(value = "modifySysGroupLevel",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysGroupLevel(@Valid @RequestBody SysGroupLevelModifyVo sysGroupLevelModifyVo){
        sysGroupLevelService.modifySysGroupLevel(sysGroupLevelModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据层级id集合，删除用户组层级
     * @param sysGroupLevelDeleteListVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:06
     */
    @RequestMapping(value = "deleteSysGroupLevelsByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysGroupLevelsByIds(@Valid @RequestBody SysGroupLevelDeleteListVo sysGroupLevelDeleteListVo){
        sysGroupLevelService.deleteSysGroupLevelsByIds(sysGroupLevelDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据层级id，获取用户组层级
     * @param groupLevId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:06
     */
    @RequestMapping(value = "findSysGroupLevelById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupLevelById(String groupLevId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysGroupLevelService.findSysGroupLevelById(groupLevId)), HttpStatus.OK);
    }

}
