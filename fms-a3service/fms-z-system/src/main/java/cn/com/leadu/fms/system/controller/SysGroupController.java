package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.system.service.SysGroupService;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupDeleteListVo;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupModifyVo;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupSaveVo;
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
 * @ClassName: SysGroupController
 * @Description: 用户组管理相关接口
 * @date 2018-03-10
 */
@RestController
@RequestMapping("sys_group")
public class SysGroupController {

    /**
     * @Fields  : 用户组管理service
     */
    @Autowired
    private SysGroupService sysGroupService;

    /**
     * @Title:
     * @Description: 分页查询用户组管理信息Vo
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "findSysGroupVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupVosByPage(SysGroupVo sysGroupVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysGroupService.findSysGroupVosByPage(sysGroupVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询用户组管理信息Vo
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "findSysGroupVoListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupVoListByPage(SysGroupVo sysGroupVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysGroupService.findSysGroupVoListByPage(sysGroupVo)),
                HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 保存用户组管理
     * @param sysGroupSaveVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "saveSysGroup",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysGroup(@Valid @RequestBody SysGroupSaveVo sysGroupSaveVo){
        sysGroupService.saveSysGroup(sysGroupSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改用户组管理
     * @param sysGroupModifyVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "modifySysGroup",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysGroup(@Valid @RequestBody SysGroupModifyVo sysGroupModifyVo){
        sysGroupService.modifySysGroup(sysGroupModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据groupId集合删除用户组管理
     * @param sysGroupDeleteListVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "deleteSysGroupsByGroupIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysGroupsByGroupIds(@Valid @RequestBody SysGroupDeleteListVo sysGroupDeleteListVo){
        sysGroupService.deleteSysGroupsByGroupIds(sysGroupDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据groupId获取用户组信息
     * @param groupId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "findSysGroupVoByGroupId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupByGroupId(String groupId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysGroupService.findSysGroupVoByGroupId(groupId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:    查询用户组树
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/13 09:46:15
     */
    @RequestMapping(value = "findSysGroupByTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupByTree(String parentType, String groupCode) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysGroupService.findSysGroupByTree(parentType, groupCode)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:    根據經銷商代碼查詢
     * @param groupCode
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/13 09:46:15
     */
    @RequestMapping(value = "selectSysGroupVoByGroupCode", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> selectSysGroupVoByGroupCode(String groupCode) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysGroupService.selectSysGroupVoByGroupCode(groupCode)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据经销商代码，取得经销商用户组及全部子用户组代码
     * @param groupCode
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/23 17:46:15
     */
    @RequestMapping(value = "findSysGroupCodeListByGroupCode", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupCodeListByGroupCode(String groupCode) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysGroupService.findSysGroupCodeListByGroupCode(groupCode)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 得到经销商保存情况
     * @param sysGroupVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018/03/23 17:46:15
     */
    @RequestMapping(value = "getBasPartnerStatus", method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> getBasPartnerStatus(@RequestBody SysGroupVo sysGroupVo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysGroupService.getBasPartnerStatus(sysGroupVo)), HttpStatus.OK);
    }


}
