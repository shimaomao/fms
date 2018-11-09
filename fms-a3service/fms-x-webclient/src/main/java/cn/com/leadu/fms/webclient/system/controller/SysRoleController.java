package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.vo.sysrole.SysRoleVo;
import cn.com.leadu.fms.webclient.system.rpc.SysRoleRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleController
 * @Description: 角色相关接口
 * @date 2018/1/12
 */
@RestController
@RequestMapping("sys_role")
public class SysRoleController {

    /**
     * @Fields  : 角色service
     */
    @Autowired
    private SysRoleRpc sysRoleRpc;

    /**
     * @Title:
     * @Description: 分页查询角色信息
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "findSysRolesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysRolesByPage(SysRoleVo sysRoleVo){
        Map sysRoleVoMap = sysRoleVo == null?null:(Map) JSON.toJSON(sysRoleVo);
        return sysRoleRpc.findSysRolesByPage(sysRoleVoMap);
    }

    /**
     * @Title:
     * @Description: 保存角色
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:42:12
     */
    @RequestMapping(value = "saveSysRole",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysRole(@RequestBody SysRoleVo sysRoleVo){
        return sysRoleRpc.saveSysRole(sysRoleVo);
    }

    /**
     * @Title:
     * @Description:  修改角色
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value = "modifySysRole",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysRole(@RequestBody SysRoleVo sysRoleVo){
        return sysRoleRpc.modifySysRole(sysRoleVo);
    }

    /**
     * @Title:
     * @Description:  删除角色
     * @param roleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "deleteSysRole",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysRole(String roleId){
        return sysRoleRpc.deleteSysRole(roleId);
    }

    /**
     * @Title:
     * @Description:  根据id获取角色
     * @param roleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysRoleById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysRoleById(String roleId){
        return sysRoleRpc.findSysRoleById(roleId);
    }


    /**
     * @Title:
     * @Description:   根据id集合删除角色
     * @param ids
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "deleteSysRolesByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysRolesByIds(@RequestBody List<String> ids){
        SysRoleVo sysRoleVo = new SysRoleVo();
        sysRoleVo.setIds(ids);
        return sysRoleRpc.deleteSysRolesByIds(sysRoleVo);
    }
    /**
     * 找到所有的角色
     */
    @RequestMapping(value = "findAllRoles",method = RequestMethod.POST)
    public List<SysRole> findAllRoles(){
        return sysRoleRpc.findAllRoles();
    }

    /**
     * 找某角色对应的应该显示的审批情况集合
     */
    @RequestMapping(value = "findApproveInfo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApproveInfo(String searchType){
        return sysRoleRpc.findApproveInfo(searchType);
    }
}
