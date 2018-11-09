package cn.com.leadu.fms.webclient.system.controller;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceController
 * @Description:
 * @date 2018/1/14
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysresource.SysResourceVo;
import cn.com.leadu.fms.webclient.system.rpc.SysResourceRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    private SysResourceRpc sysResourceRpc;

    /**
     * @Title:
     * @Description: 根据当前登录用户返回用户的菜单
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:48:19
     */
    @RequestMapping(value = "findSysResourceByUser",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceByUser(){
        return sysResourceRpc.findSysResourceByUser();
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
        return sysResourceRpc.findSysResourceAll();
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
        Map sysUserVoMap = sysResourceVo == null?null:(Map) JSON.toJSON(sysResourceVo);
        return sysResourceRpc.findSysResourceByPage(sysUserVoMap);
    }

    /**
     * @Title:
     * @Description: 根据角色id获取角色拥有的资源
     * @param sysRoleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "findSysResourceBySysRoleId" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceBySysRoleId(String sysRoleId){
        return sysResourceRpc.findSysResourceBySysRoleId(sysRoleId);
    }



    /**
     * @Title:
     * @Description: 保存菜单资源
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:42:12
     */
    @RequestMapping(value = "saveSysResource",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysResource(@RequestBody SysResourceVo sysResourceVo){
        return sysResourceRpc.saveSysResource(sysResourceVo);
    }


    /**
     * @Title:
     * @Description:  修改菜单资源
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value = "modifySysResource",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysResource(@RequestBody SysResourceVo sysResourceVo){
        return sysResourceRpc.modifySysResource(sysResourceVo);
    }

    /**
     * @Title:
     * @Description:  删除菜单资源
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "deleteSysResource",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysResource(String id){
        return sysResourceRpc.deleteSysResource(id);
    }


    /**
     * @Title:
     * @Description:   根据id集合删除菜单资源
     * @param ids
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "deleteSysResourceByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysResourceByIds(@RequestBody List<String> ids){
        SysResourceVo sysResourceVo = new SysResourceVo();
        sysResourceVo.setIds(ids);
        return sysResourceRpc.deleteSysResourceByIds(sysResourceVo);
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
        return sysResourceRpc.findSysResourceById(id);
    }

    /**
     * @Title:
     * @Description:  获取类型是父角色的资源菜单
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/18 10:24:47
     */
    @RequestMapping(value = "findSysResourceIsParent", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceIsParent(@RequestParam(required = false) Integer resLevel){
        return sysResourceRpc.findSysResourceIsParent(resLevel);
    }

}
