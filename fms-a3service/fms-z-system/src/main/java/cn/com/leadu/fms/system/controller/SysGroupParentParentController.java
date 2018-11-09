package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.system.service.SysGroupParentService;
import cn.com.leadu.fms.system.validator.sysgroupparent.vo.SysGroupParentSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author huchenghao
 * @ClassName: SysGroupParentController
 * @Description: 用户组管理相关接口
 * @date 2018-03-29
 */
@RestController
@RequestMapping("sys_group_parent")
public class SysGroupParentParentController {

    /**
     * @Fields  : 用户关系service
     */
    @Autowired
    private SysGroupParentService SysGroupParentService;

    /**
     * @Title:
     * @Description: 保存用户组管理
     * @param SysGroupParentSaveVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "saveSysGroupParent",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysGroupParent(@Valid @RequestBody SysGroupParentSaveVo SysGroupParentSaveVo){
        SysGroupParentService.saveSysGroupParent(SysGroupParentSaveVo.getEntity());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 通过code删除
     * @param groupCode
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "deleteSysGroupParentByGroupCode",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> deleteSysGroupParentByGroupCode(String groupCode){
        SysGroupParentService.deleteSysGroupParentByGroupCode(groupCode);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
