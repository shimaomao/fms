package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysuserinfo.SysUserInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoController
 * @Description: 消息用户操作管理rpc
 * @date 2018-04-25
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysUserInfoRpc {

    /**
     * @Title:
     * @Description: 分页查询消息用户操作管理信息
     * @param sysUserInfoVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "api/system/sys_user_info/findSysUserInfosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserInfosByPage(@RequestParam Map<String, Object> sysUserInfoVoMap);

    /**
     * @Title:
     * @Description: 保存消息用户操作管理
     * @param sysUserInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "api/system/sys_user_info/saveSysUserInfo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysUserInfo(@RequestBody SysUserInfoVo sysUserInfoVo);

    /**
     * @Title:
     * @Description:  修改消息用户操作管理
     * @param sysUserInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "api/system/sys_user_info/modifySysUserInfo",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysUserInfo(@RequestBody SysUserInfoVo sysUserInfoVo);

    /**
     * @Title:
     * @Description:   根据userInfoId集合删除消息用户操作管理
     * @param sysUserInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "api/system/sys_user_info/deleteSysUserInfosByUserInfoIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysUserInfosByUserInfoIds(@RequestBody SysUserInfoVo sysUserInfoVo);

    /**
     * @Title:
     * @Description:  根据userInfoId获取消息用户操作管理
     * @param userInfoId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "api/system/sys_user_info/findSysUserInfoByUserInfoId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserInfoByUserInfoId(@RequestParam("userInfoId") String userInfoId);

    /**
     * @Title:
     * @Description: 查询当前自己的消息
     * @param: sysUserInfoVo
     * @param: sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/25 0025 14:51
     */
    @RequestMapping(value = "api/system/sys_user_info/findSysUserInfoVosByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserInfoVosByPage(@RequestParam Map<String, Object> sysUserInfoVoMap);

    /**
     * @Title:
     * @Description: 确认读取消息
     * @param: sysUserInfoVo
     * @param: sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/25 14:51
     */
    @RequestMapping(value = "api/system/sys_user_info/readSysUserInfo", method = RequestMethod.PUT)
    ResponseEntity<RestResponse> readSysUserInfo(@RequestBody SysUserInfoVo sysUserInfoVo);

}
