package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysresource.SysResourceVo;
import cn.com.leadu.fms.system.service.SysResourceService;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceDeleteListVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceDeleteVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceModifyVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceController
 * @Description:
 * @date 2018/1/14
 */
@RestController
@RequestMapping("sys_resource")
public class SysResourceController {

    @Autowired
    private SysResourceService sysResourceService;

    /**
     * @Title:
     * @Description:  根据用户名提供用户的资源,此处提供给鉴权使用
     * @param username
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:42:08
     */
    @RequestMapping(value = "findSysResourceByUsername",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceByUsername(String username){
        List<String> res =  new ArrayList<>();
        res.add("/api/**");
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(res), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据当前登录用户返回用户的菜单
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:48:19
     */
    @RequestMapping(value = "findSysResourceByUser",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceByUser(@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysResourceService.findSysResourceByUser(sysUser.getUserId(), sysUser.getValidMenuType())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  查询所有菜单列表, 根据sort资源排序
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 03:58:27
     */
    @RequestMapping(value = "findSysResourceAll",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceAll(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysResourceService.findSysResourceAll()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询菜单信息
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "findSysResourceByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceByPage(SysResourceVo sysResourceVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysResourceService.findSysResourceByPage(sysResourceVo)),
                HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 根据菜单资源id获取角色拥有的资源
     * @param sysRoleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "findSysResourceBySysRoleId" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceBySysRoleId(String sysRoleId){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysResourceService.findSysResourceBySysRoleId(sysRoleId)),
                HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 保存菜单资源
     * @param sysResourceSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:42:12
     */
    @RequestMapping(value = "saveSysResource",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysResource(@Valid @RequestBody SysResourceSaveVo sysResourceSaveVo){
        sysResourceService.saveSysResource(sysResourceSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:  修改菜单资源
     * @param sysResourceModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value = "modifySysResource",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysResource(@Valid @RequestBody SysResourceModifyVo sysResourceModifyVo){
        sysResourceService.modifySysResource(sysResourceModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除菜单资源
     * @param sysResourceDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "deleteSysResource",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysResource(@Valid @RequestBody SysResourceDeleteVo sysResourceDeleteVo){
        sysResourceService.deleteSysResource(sysResourceDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }



    /**
     * @Title:
     * @Description:   根据id集合删除菜单资源
     * @param sysResourceDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "deleteSysResourceByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysResourceByIds(@Valid @RequestBody SysResourceDeleteListVo sysResourceDeleteListVo){
        sysResourceService.deleteSysResourceByIds(sysResourceDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据id获取菜单资源
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysResourceById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceById(String id){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysResourceService.findSysResourceById(id)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据菜单级别获取菜单集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/18 10:24:47
     */
    @RequestMapping(value = "findSysResourceIsParent", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceIsParent(@RequestParam(required = false) Integer resLevel){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysResourceService.findSysResourceIsParent(resLevel)), HttpStatus.OK);
    }

}
