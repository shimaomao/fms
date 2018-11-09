package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysuserinfo.SysUserInfoVo;
import cn.com.leadu.fms.webclient.system.rpc.SysUserInfoRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoController
 * @Description: 消息用户操作管理controller
 * @date 2018-04-25
 */
@RestController
@RequestMapping("sys_user_info")
public class SysUserInfoController {

    /**
     * @Fields  : 消息用户操作管理rpc
     */
    @Autowired
    private SysUserInfoRpc sysUserInfoRpc;

    /**
     * @Title:
     * @Description: 分页查询消息用户操作管理信息
     * @param sysUserInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "findSysUserInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserInfosByPage(SysUserInfoVo sysUserInfoVo){
        Map sysUserInfoVoMap = sysUserInfoVo == null?null:(Map) JSON.toJSON(sysUserInfoVo);
        return sysUserInfoRpc.findSysUserInfosByPage(sysUserInfoVoMap);
    }

    /**
     * @Title:
     * @Description: 保存消息用户操作管理
     * @param sysUserInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "saveSysUserInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysUserInfo(@RequestBody SysUserInfoVo sysUserInfoVo){
        return sysUserInfoRpc.saveSysUserInfo(sysUserInfoVo);
    }

    /**
     * @Title:
     * @Description:  修改消息用户操作管理
     * @param sysUserInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "modifySysUserInfo",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysUserInfo(@RequestBody SysUserInfoVo sysUserInfoVo){
        return sysUserInfoRpc.modifySysUserInfo(sysUserInfoVo);
    }

    /**
     * @Title:
     * @Description:   根据userInfoId集合删除消息用户操作管理
     * @param userInfoIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "deleteSysUserInfosByUserInfoIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUserInfosByUserInfoIds(@RequestBody List<String> userInfoIds){
        SysUserInfoVo sysUserInfoVo = new SysUserInfoVo();
        sysUserInfoVo.setUserInfoIds(userInfoIds);
        return sysUserInfoRpc.deleteSysUserInfosByUserInfoIds(sysUserInfoVo);
    }

    /**
     * @Title:
     * @Description:  根据userInfoId获取消息用户操作管理
     * @param userInfoId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @RequestMapping(value = "findSysUserInfoByUserInfoId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserInfoByUserInfoId(String userInfoId){
        return sysUserInfoRpc.findSysUserInfoByUserInfoId(userInfoId);
    }


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
    @RequestMapping(value = "findSysUserInfoVosByPage", method = RequestMethod.GET)
    public  ResponseEntity<RestResponse> findSysUserInfoVosByPage(SysUserInfoVo sysUserInfoVo){
        Map sysUserInfoVoMap = sysUserInfoVo == null?null:(Map) JSON.toJSON(sysUserInfoVo);
        return sysUserInfoRpc.findSysUserInfoVosByPage(sysUserInfoVoMap);
    }

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
    @RequestMapping(value = "readSysUserInfo", method = RequestMethod.PUT)
    public  ResponseEntity<RestResponse> readSysUserInfo(@RequestBody SysUserInfoVo sysUserInfoVo){
        return sysUserInfoRpc.readSysUserInfo(sysUserInfoVo);
    }

}
