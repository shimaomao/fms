package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.webclient.system.rpc.SysUserRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysUserController
 * @Description: 系统用户相关接口
 * @date 2018/1/9
 */
@RestController
@RequestMapping("sys_user")
public class SysUserController {

    @Autowired
    private SysUserRpc sysUserRpc;
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * @Title:
     * @Description: 保存用户
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 02:21:22
     */
    @RequestMapping(value="saveSysUser",method = RequestMethod.POST)
    public ResponseEntity<RestResponse<String>> saveSysUser(@RequestBody SysUserVo sysUserVo){
        return sysUserRpc.saveSysUser(sysUserVo);
    }

    /**
     * @Title:
     * @Description: 分页查询用户信息
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value="findSysUserByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserByPage(SysUserVo sysUserVo) throws FmsRpcException {
        Map sysUserVoMap = sysUserVo == null?null:(Map)JSON.toJSON(sysUserVo);
        return sysUserRpc.findSysUserByPage(sysUserVoMap);
    }

    /**
     * @Title:
     * @Description:  修改用户
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value="modifySysUser",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysUser(@RequestBody SysUserVo sysUserVo){
        return sysUserRpc.modifySysUser(sysUserVo);
    }

    /**
     * @Title:
     * @Description:  获取加密后的密码
     * @param password
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value="getPasswordEncoder",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getPasswordEncoder(String password,String passwordold){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(passwordEncoder.matches(password,passwordold)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除用户
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value="deleteSysUser",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUser(String id){
        return sysUserRpc.deleteSysUser(id);
    }


    /**
     * @Title:
     * @Description:  根据id获取用户
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysUserById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserById(String id){
        return sysUserRpc.findSysUserById(id);
    }

    /**
     * @Title:
     * @Description:  获取当前登录用户的详细信息
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 02:26:33
     */
    @RequestMapping(value = "findSysUserDetail", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserDetail(){
        return sysUserRpc.findSysUserDetail();
    }

    /**
     * @Title:
     * @Description:   根据id集合删除用户
     * @param ids
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "deleteSysUserByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUserByIds(@RequestBody List<String> ids){
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setUserIds(ids);
        return sysUserRpc.deleteSysUserByIds(sysUserVo);
    }

    /**
     * @Title:
     * @Description:   修改用户密码
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/19 06:00:46
     */
    @RequestMapping(value = "modifySysUserPwd" , method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysUserPwd(@RequestBody SysUserVo sysUserVo){
        return sysUserRpc.modifySysUserPwd(sysUserVo);
    }

    /**
     * @Title:
     * @Description:  根据id获取用户vo
     * @param userId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysUserVoById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserVoById(String userId){
        return sysUserRpc.findSysUserVoById(userId);
    }

    /**
     * @Title:
     * @Description: 分页查询用户vo信息
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "findSysUserVoByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserVoByPage(SysUserVo sysUserVo){
        Map sysUserVoMap = sysUserVo == null?null:(Map)JSON.toJSON(sysUserVo);
        return sysUserRpc.findSysUserVoByPage(sysUserVoMap);
    }
    /**
     * 找到所有菜单权限类型为用户的用户
     * @return
     */
    @RequestMapping(value = "findAllUsers",method = RequestMethod.POST)
    public List<SysUser> findAllUsers(){
        return sysUserRpc.findAllUsers();
    }

    /**
     * 找到所有菜单权限类型为用户的用户
     * @return
     */
    @RequestMapping(value = "findUserDetailByUser",method = RequestMethod.GET)
    public ResponseEntity<RestResponse>  findUserDetailByUser(){
        return sysUserRpc.findUserDetailByUser();
    }
}
